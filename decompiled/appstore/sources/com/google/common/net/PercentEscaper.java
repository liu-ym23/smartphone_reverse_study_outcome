package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public final class PercentEscaper extends UnicodeEscaper {
    private static final char[] PLUS_SIGN = null;
    private static final char[] UPPER_HEX_DIGITS = null;
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    static {
        PLUS_SIGN = new char[]{'+'};
        UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    }

    public PercentEscaper(String r10, boolean r11) {
        Preconditions.checkNotNull(r10);
        if (r10.matches(".*[0-9A-Za-z].*") == true) goto L14;
        String r12 = r10 + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        if (r11 == true) goto L7;
    L11:
        this.plusForSpace = r11;
        this.safeOctets = createSafeOctets(r12);
        return;
    L7:
        if (r12.contains(" ") == false) goto L11;
        throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
    L14:
        throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }

    private static boolean[] createSafeOctets(String r10) {
        char[] r11 = r10.toCharArray();
        int r12 = r11.length;
        int r13 = -1;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L5;
        r13 = Math.max(r11[r15], r13);
        r15 = r15 + 1;
        goto L3
    L5:
        boolean[] r16 = new boolean[r13 + 1];
        int r17 = r11.length;
    L6:
        if (r14 >= r17) goto L8;
        r16[r11[r14]] = true;
        r14 = r14 + 1;
        goto L6
    L8:
        return r16;
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public String escape(String r10) {
        Preconditions.checkNotNull(r10);
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L12;
        char r13 = r10.charAt(r12);
        boolean[] r14 = this.safeOctets;
        if (r13 >= r14.length) goto L11;
        if (r14[r13] == false) goto L11;
        r12 = r12 + 1;
    L11:
        return escapeSlow(r10, r12);
    L12:
        return r10;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    public int nextEscapeIndex(CharSequence r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
    L3:
        if (r11 >= r12) goto L10;
        char r13 = r10.charAt(r11);
        boolean[] r14 = this.safeOctets;
        if (r13 >= r14.length) goto L10;
        if (r14[r13] == false) goto L10;
        r11 = r11 + 1;
    L10:
        return r11;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    public char[] escape(int r14) {
        boolean[] r10 = this.safeOctets;
        if (r14 >= r10.length) goto L9;
        if (r10[r14] == false) goto L9;
        return null;
    L9:
        if (r14 != 32) goto L15;
        if (this.plusForSpace == false) goto L15;
        return PLUS_SIGN;
    L15:
        if (r14 > 127) goto L19;
        char[] r11 = UPPER_HEX_DIGITS;
        return new char[]{'%', r11[r14 >>> 4], r11[r14 & 15]};
    L19:
        if (r14 > 2047) goto L23;
        char[] r12 = UPPER_HEX_DIGITS;
        return new char[]{'%', r12[(r14 >>> 10) | 12], r12[(r14 >>> 6) & 15], '%', r12[((r14 >>> 4) & 3) | 8], r12[r14 & 15]};
    L23:
        if (r14 > 65535) goto L27;
        char[] r13 = UPPER_HEX_DIGITS;
        return new char[]{'%', 'E', r13[r14 >>> 12], '%', r13[((r14 >>> 10) & 3) | 8], r13[(r14 >>> 6) & 15], '%', r13[((r14 >>> 4) & 3) | 8], r13[r14 & 15]};
    L27:
        if (r14 > 1114111) goto L31;
        char[] r15 = UPPER_HEX_DIGITS;
        return new char[]{'%', 'F', r15[(r14 >>> 18) & 7], '%', r15[((r14 >>> 16) & 3) | 8], r15[(r14 >>> 12) & 15], '%', r15[((r14 >>> 10) & 3) | 8], r15[(r14 >>> 6) & 15], '%', r15[((r14 >>> 4) & 3) | 8], r15[r14 & 15]};
    L31:
        throw new IllegalArgumentException("Invalid unicode character value " + r14);
    }
}
