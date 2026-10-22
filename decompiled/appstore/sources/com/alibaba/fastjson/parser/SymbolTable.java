package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;

/* JADX INFO: loaded from: classes.dex */
public class SymbolTable {
    private final int indexMask;
    private final Entry[] symbols;

    public static class Entry {
        final char[] chars;
        final int hashCode;
        final String value;

        public Entry(String r10, int r11) {
            this.value = r10;
            this.chars = r10.toCharArray();
            this.hashCode = r11;
        }
    }

    public SymbolTable(int r10) {
        this.indexMask = r10 - 1;
        this.symbols = new Entry[r10];
        addSymbol("$ref", 0, 4, 1185263);
        addSymbol(JSON.DEFAULT_TYPE_KEY, 0, 5, 62680954);
    }

    private static String subString(String r10, int r11, int r12) {
        char[] r13 = new char[r12];
        r10.getChars(r11, r12 + r11, r13, 0);
        return new String(r13);
    }

    public String addSymbol(char[] r10, int r11, int r12, int r13) {
        int r14 = this.indexMask & r13;
        Entry r15 = this.symbols[r14];
        if (r15 != null) goto L5;
        String r16 = new String(r10, r11, r12).intern();
        Entry r17 = new Entry(r16, r13);
        this.symbols[r14] = r17;
        return r16;
    L5:
        if (r13 != r15.hashCode) goto L17;
        if (r12 != r15.chars.length) goto L17;
        int r18 = 0;
    L9:
        if (r18 >= r12) goto L15;
        if (r10[r11 + r18] != r15.chars[r18]) goto L17;
        r18 = r18 + 1;
        goto L9
    L15:
        return r15.value;
    L17:
        return new String(r10, r11, r12);
    }

    public String addSymbol(String r10, int r11, int r12, int r13) {
        int r14 = this.indexMask & r13;
        Entry r15 = this.symbols[r14];
        if (r15 == null) goto L15;
        if (r13 != r15.hashCode) goto L13;
        if (r12 != r15.chars.length) goto L13;
        if (r10.regionMatches(r11, r15.value, 0, r12) == false) goto L13;
        return r15.value;
    L13:
        return subString(r10, r11, r12);
    L15:
        if (r12 == r10.length()) goto L18;
        r10 = subString(r10, r11, r12);
    L18:
        String r16 = r10.intern();
        this.symbols[r14] = new Entry(r16, r13);
        return r16;
    }
}
