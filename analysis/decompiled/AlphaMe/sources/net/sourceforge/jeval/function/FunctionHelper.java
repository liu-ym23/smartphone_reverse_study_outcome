package net.sourceforge.jeval.function;

import java.util.ArrayList;
import net.sourceforge.jeval.ArgumentTokenizer;

/* loaded from: classes2.dex */
public class FunctionHelper {
    public static ArrayList getDoubles(String str, char c4) throws FunctionException {
        ArrayList arrayList = new ArrayList();
        try {
            ArgumentTokenizer argumentTokenizer = new ArgumentTokenizer(str, c4);
            while (argumentTokenizer.hasMoreTokens()) {
                arrayList.add(new Double(argumentTokenizer.nextToken().trim()));
            }
            return arrayList;
        } catch (Exception e4) {
            throw new FunctionException("Invalid values in string.", e4);
        }
    }

    public static ArrayList getOneStringAndOneInteger(String str, char c4) throws FunctionException {
        ArrayList arrayList = new ArrayList();
        try {
            ArgumentTokenizer argumentTokenizer = new ArgumentTokenizer(str, c4);
            int i4 = 0;
            while (argumentTokenizer.hasMoreTokens()) {
                if (i4 == 0) {
                    arrayList.add(argumentTokenizer.nextToken());
                } else {
                    if (i4 != 1) {
                        throw new FunctionException("Invalid values in string.");
                    }
                    arrayList.add(new Integer(new Double(argumentTokenizer.nextToken().trim()).intValue()));
                }
                i4++;
            }
            return arrayList;
        } catch (Exception e4) {
            throw new FunctionException("Invalid values in string.", e4);
        }
    }

    public static ArrayList getOneStringAndTwoIntegers(String str, char c4) throws FunctionException {
        ArrayList arrayList = new ArrayList();
        try {
            ArgumentTokenizer argumentTokenizer = new ArgumentTokenizer(str, c4);
            int i4 = 0;
            while (argumentTokenizer.hasMoreTokens()) {
                if (i4 == 0) {
                    arrayList.add(argumentTokenizer.nextToken().trim());
                } else {
                    if (i4 != 1 && i4 != 2) {
                        throw new FunctionException("Invalid values in string.");
                    }
                    arrayList.add(new Integer(new Double(argumentTokenizer.nextToken().trim()).intValue()));
                }
                i4++;
            }
            return arrayList;
        } catch (Exception e4) {
            throw new FunctionException("Invalid values in string.", e4);
        }
    }

    public static ArrayList getStrings(String str, char c4) throws FunctionException {
        ArrayList arrayList = new ArrayList();
        try {
            ArgumentTokenizer argumentTokenizer = new ArgumentTokenizer(str, c4);
            while (argumentTokenizer.hasMoreTokens()) {
                arrayList.add(argumentTokenizer.nextToken());
            }
            return arrayList;
        } catch (Exception e4) {
            throw new FunctionException("Invalid values in string.", e4);
        }
    }

    public static ArrayList getTwoStringsAndOneInteger(String str, char c4) throws FunctionException {
        ArrayList arrayList = new ArrayList();
        try {
            ArgumentTokenizer argumentTokenizer = new ArgumentTokenizer(str, c4);
            int i4 = 0;
            while (argumentTokenizer.hasMoreTokens()) {
                if (i4 == 0 || i4 == 1) {
                    arrayList.add(argumentTokenizer.nextToken());
                } else {
                    if (i4 != 2) {
                        throw new FunctionException("Invalid values in string.");
                    }
                    arrayList.add(new Integer(new Double(argumentTokenizer.nextToken().trim()).intValue()));
                }
                i4++;
            }
            return arrayList;
        } catch (Exception e4) {
            throw new FunctionException("Invalid values in string.", e4);
        }
    }

    public static String trimAndRemoveQuoteChars(String str, char c4) throws FunctionException {
        String strTrim = str.trim();
        if (strTrim.charAt(0) != c4) {
            throw new FunctionException("Value does not start with a quote.");
        }
        String strSubstring = strTrim.substring(1, strTrim.length());
        if (strSubstring.charAt(strSubstring.length() - 1) == c4) {
            return strSubstring.substring(0, strSubstring.length() - 1);
        }
        throw new FunctionException("Value does not end with a quote.");
    }
}
