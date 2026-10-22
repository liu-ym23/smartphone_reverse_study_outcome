package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public final class CharEscaperBuilder {
    private final Map<Character, String> map;
    private int max;

    public static class CharArrayDecorator extends CharEscaper {
        private final int replaceLength;
        private final char[][] replacements;

        public CharArrayDecorator(char[][] r10) {
            this.replacements = r10;
            this.replaceLength = r10.length;
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String r10) {
            int r11 = r10.length();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L11;
            char r13 = r10.charAt(r12);
            char[][] r14 = this.replacements;
            if (r13 >= r14.length) goto L10;
            if (r14[r13] == null) goto L10;
            return escapeSlow(r10, r12);
        L10:
            r12 = r12 + 1;
            goto L3
        L11:
            return r10;
        }

        @Override // com.google.common.escape.CharEscaper
        public char[] escape(char r10) {
            if (r10 < this.replaceLength) goto L7;
            return null;
        L7:
            return this.replacements[r10];
        }
    }

    public CharEscaperBuilder() {
        this.max = -1;
        this.map = new HashMap();
    }

    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscape(char r10, String r11) {
        this.map.put(Character.valueOf(r10), (String) Preconditions.checkNotNull(r11));
        if (r10 <= this.max) goto L5;
        this.max = r10;
    L5:
        return this;
    }

    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscapes(char[] r10, String r11) {
        Preconditions.checkNotNull(r11);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        addEscape(r10[r13], r11);
        r13 = r13 + 1;
        goto L3
    L5:
        return this;
    }

    public char[][] toArray() {
        char[][] r10 = new char[this.max + 1][];
        Iterator<Map.Entry<Character, String>> r11 = this.map.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<Character, String> r12 = r11.next();
        r10[r12.getKey().charValue()] = r12.getValue().toCharArray();
        goto L4
    L6:
        return r10;
    }

    public Escaper toEscaper() {
        return new CharArrayDecorator(toArray());
    }
}
