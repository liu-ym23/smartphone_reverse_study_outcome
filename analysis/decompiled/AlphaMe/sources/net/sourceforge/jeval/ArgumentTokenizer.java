package net.sourceforge.jeval;

import java.util.Enumeration;

/* loaded from: classes2.dex */
public class ArgumentTokenizer implements Enumeration {
    private String arguments;
    public final char defaultDelimiter = ',';
    private char delimiter;

    public ArgumentTokenizer(String str, char c4) {
        this.arguments = str;
        this.delimiter = c4;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return hasMoreTokens();
    }

    public boolean hasMoreTokens() {
        return this.arguments.length() > 0;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        return nextToken();
    }

    public String nextToken() {
        String strSubstring;
        int length = this.arguments.length();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= length) {
                strSubstring = null;
                break;
            }
            if (this.arguments.charAt(i4) != '(') {
                if (this.arguments.charAt(i4) != ')') {
                    if (this.arguments.charAt(i4) == this.delimiter && i5 == 0) {
                        strSubstring = this.arguments.substring(0, i4);
                        this.arguments = this.arguments.substring(i4 + 1);
                        break;
                    }
                } else {
                    i5--;
                }
            } else {
                i5++;
            }
            i4++;
        }
        if (strSubstring != null) {
            return strSubstring;
        }
        String str = this.arguments;
        this.arguments = "";
        return str;
    }
}
