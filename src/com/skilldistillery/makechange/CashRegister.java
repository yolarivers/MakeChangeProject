package com.skilldistillery.makechange;

import java.util.Scanner;
import java.text.DecimalFormat;

public class CashRegister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the price of the item: ");
        double price = scanner.nextDouble();

      
        System.out.print("Enter the amount tendered by the customer: ");
        double tendered = scanner.nextDouble();

     
        if (tendered < price) {
            System.out.println("Error: Not enough money provided.");
        } else if (tendered == price) {
            System.out.println("Exact amount provided. No change needed.");
        } else {
         
            double change = tendered - price;

           
            DecimalFormat df = new DecimalFormat("#.00");
            String formattedChange = df.format(change);

           
            int cents = (int) Math.round(change * 100);

          
            int[] denominations = {1000, 500, 100, 25, 10, 5, 1};
            String[] names = {"$10", "$5", "$1", "quarter", "dime", "nickel", "penny"};

            System.out.println("Change needed: $" + formattedChange);
            for (int i = 0; i < denominations.length; i++) {
                int count = cents / denominations[i];
                if (count > 0) {
                    if (names[i].equals("penny") && count > 1) {
                        System.out.println(count + " pennies");
                    } else {
                        System.out.println(count + " " + names[i] + (count > 1 && !names[i].equals("penny") ? "s" : ""));
                    }
                    cents %= denominations[i];
                }
            }
        }

        scanner.close();
    }
}