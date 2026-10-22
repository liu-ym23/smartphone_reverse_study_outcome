package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;

/* loaded from: classes.dex */
public class SymbolTable {
    private final int indexMask;
    private final String[] symbols;

    public SymbolTable(int i4) {
        this.indexMask = i4 - 1;
        this.symbols = new String[i4];
        addSymbol("$ref", 0, 4, 1185263);
        String str = JSON.DEFAULT_TYPE_KEY;
        addSymbol(str, 0, str.length(), JSON.DEFAULT_TYPE_KEY.hashCode());
    }

    public static int hash(char[] cArr, int i4, int i5) {
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            i7 = (i7 * 31) + cArr[i4];
            i6++;
            i4++;
        }
        return i7;
    }

    private static String subString(String str, int i4, int i5) {
        char[] cArr = new char[i5];
        str.getChars(i4, i5 + i4, cArr, 0);
        return new String(cArr);
    }

    public String addSymbol(char[] cArr, int i4, int i5) {
        return addSymbol(cArr, i4, i5, hash(cArr, i4, i5));
    }

    public String addSymbol(char[] cArr, int i4, int i5, int i6) {
        int i7 = this.indexMask & i6;
        String str = this.symbols[i7];
        if (str != null) {
            if (i6 == str.hashCode() && i5 == str.length()) {
                for (int i8 = 0; i8 < i5; i8++) {
                    if (cArr[i4 + i8] == str.charAt(i8)) {
                    }
                }
                return str;
            }
            return new String(cArr, i4, i5);
        }
        String strIntern = new String(cArr, i4, i5).intern();
        this.symbols[i7] = strIntern;
        return strIntern;
    }

    public String addSymbol(String str, int i4, int i5, int i6) {
        return addSymbol(str, i4, i5, i6, false);
    }

    public String addSymbol(String str, int i4, int i5, int i6, boolean z4) {
        int i7 = this.indexMask & i6;
        String str2 = this.symbols[i7];
        if (str2 != null) {
            if (i6 == str2.hashCode() && i5 == str2.length() && str.startsWith(str2, i4)) {
                return str2;
            }
            String strSubString = subString(str, i4, i5);
            if (z4) {
                this.symbols[i7] = strSubString;
            }
            return strSubString;
        }
        if (i5 != str.length()) {
            str = subString(str, i4, i5);
        }
        String strIntern = str.intern();
        this.symbols[i7] = strIntern;
        return strIntern;
    }
}
