package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class CharEscaperBuilder {
    private final Map<Character, String> map;
    private int max;

    private static class CharArrayDecorator extends CharEscaper {
        private final int replaceLength;
        private final char[][] replacements;

        CharArrayDecorator(char[][] r1) {
            this.replacements = r1;
            this.replaceLength = r1.length;
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String r6) {
            int r0 = r6.length();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L11;
            char r2 = r6.charAt(r1);
            char[][] r3 = this.replacements;
            if (r2 >= r3.length) goto L10;
            if (r3[r2] == null) goto L10;
            return escapeSlow(r6, r1);
        L10:
            r1 = r1 + 1;
            goto L3
        L11:
            return r6;
        }

        @Override // com.google.common.escape.CharEscaper
        protected char[] escape(char r2) {
            if (r2 < this.replaceLength) goto L7;
            return null;
        L7:
            return this.replacements[r2];
        }
    }

    public CharEscaperBuilder() {
        this.max = -1;
        this.map = new HashMap();
    }

    public CharEscaperBuilder addEscape(char r3, String r4) {
        this.map.put(Character.valueOf(r3), (String) Preconditions.checkNotNull(r4));
        if (r3 <= this.max) goto L5;
        this.max = r3;
    L5:
        return this;
    }

    public CharEscaperBuilder addEscapes(char[] r4, String r5) {
        Preconditions.checkNotNull(r5);
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        addEscape(r4[r1], r5);
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }

    public char[][] toArray() {
        char[][] r0 = new char[this.max + 1][];
        Iterator<Map.Entry<Character, String>> r3 = this.map.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry<Character, String> r1 = r3.next();
        r0[r1.getKey().charValue()] = r1.getValue().toCharArray();
        goto L4
    L6:
        return r0;
    }

    public Escaper toEscaper() {
        return new CharArrayDecorator(toArray());
    }
}
