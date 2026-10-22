package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;

/* JADX INFO: loaded from: classes28.dex */
public class SymbolTable {
    private final int indexMask;
    private final String[] symbols;

    public SymbolTable(int r100) {
        this.indexMask = r100 - 1;
        this.symbols = new String[r100];
        addSymbol("$ref", 0, 4, 1185263);
        String r101 = JSON.DEFAULT_TYPE_KEY;
        addSymbol(r101, 0, r101.length(), JSON.DEFAULT_TYPE_KEY.hashCode());
    }

    public static int hash(char[] r100, int r101, int r102) {
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L5;
        int r105 = r101 + 1;
        r104 = (r104 * 31) + r100[r101];
        r103 = r103 + 1;
        r101 = r105;
        goto L3
    L5:
        return r104;
    }

    private static String subString(String r100, int r101, int r102) {
        char[] r103 = new char[r102];
        r100.getChars(r101, r102 + r101, r103, 0);
        return new String(r103);
    }

    public String addSymbol(char[] r100, int r101, int r102) {
        return addSymbol(r100, r101, r102, hash(r100, r101, r102));
    }

    public String addSymbol(char[] r100, int r101, int r102, int r103) {
        int r104 = this.indexMask & r103;
        String r105 = this.symbols[r104];
        if (r105 == null) goto L19;
        boolean r106 = false;
        if (r103 == r105.hashCode()) goto L7;
    L15:
        if (r106 == false) goto L18;
        return r105;
    L18:
        return new String(r100, r101, r102);
    L7:
        if (r102 != r105.length()) goto L15;
        int r107 = 0;
    L9:
        if (r107 >= r102) goto L14;
        if (r100[r101 + r107] != r105.charAt(r107)) goto L15;
        r107 = r107 + 1;
        goto L9
    L14:
        r106 = true;
        goto L15
    L19:
        String r108 = new String(r100, r101, r102).intern();
        this.symbols[r104] = r108;
        return r108;
    }

    public String addSymbol(String r100, int r101, int r102, int r110) {
        return addSymbol(r100, r101, r102, r110, false);
    }

    public String addSymbol(String r100, int r101, int r102, int r103, boolean r104) {
        int r105 = this.indexMask & r103;
        String r106 = this.symbols[r105];
        if (r106 == null) goto L16;
        if (r103 == r106.hashCode()) goto L7;
    L11:
        String r107 = subString(r100, r101, r102);
        if (r104 == false) goto L14;
        this.symbols[r105] = r107;
    L14:
        return r107;
    L7:
        if (r102 != r106.length()) goto L11;
        if (r100.startsWith(r106, r101) == false) goto L11;
        return r106;
    L16:
        if (r102 == r100.length()) goto L19;
        r100 = subString(r100, r101, r102);
    L19:
        String r108 = r100.intern();
        this.symbols[r105] = r108;
        return r108;
    }
}
