package com.google.common.net;

import com.android.contacts.util.HanziToPinyin;
import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;

/* JADX INFO: loaded from: classes2.dex */
public final class PercentEscaper extends UnicodeEscaper {
    private static final char[] PLUS_SIGN = null;
    private static final char[] UPPER_HEX_DIGITS = null;
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    static {
        PLUS_SIGN = new char[]{'+'};
        UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    }

    public PercentEscaper(String r2, boolean r3) {
        Preconditions.checkNotNull(r2);
        if (r2.matches(".*[0-9A-Za-z].*") == true) goto L14;
        String r4 = r2 + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        if (r3 == true) goto L7;
    L11:
        this.plusForSpace = r3;
        this.safeOctets = createSafeOctets(r4);
        return;
    L7:
        if (r4.contains(HanziToPinyin.Token.SEPARATOR) == false) goto L11;
        throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
    L14:
        throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }

    private static boolean[] createSafeOctets(String r5) {
        char[] r6 = r5.toCharArray();
        int r0 = r6.length;
        int r1 = -1;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = Math.max(r6[r3], r1);
        r3 = r3 + 1;
        goto L3
    L5:
        boolean[] r4 = new boolean[r1 + 1];
        int r7 = r6.length;
    L6:
        if (r2 >= r7) goto L8;
        r4[r6[r2]] = true;
        r2 = r2 + 1;
        goto L6
    L8:
        return r4;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected int nextEscapeIndex(CharSequence r4, int r5, int r6) {
        Preconditions.checkNotNull(r4);
    L3:
        if (r5 >= r6) goto L10;
        char r0 = r4.charAt(r5);
        boolean[] r1 = this.safeOctets;
        if (r0 >= r1.length) goto L10;
        if (r1[r0] == false) goto L10;
        r5 = r5 + 1;
    L10:
        return r5;
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public String escape(String r6) {
        Preconditions.checkNotNull(r6);
        int r0 = r6.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        char r2 = r6.charAt(r1);
        boolean[] r3 = this.safeOctets;
        if (r2 >= r3.length) goto L11;
        if (r3[r2] == false) goto L11;
        r1 = r1 + 1;
    L11:
        return escapeSlow(r6, r1);
    L12:
        return r6;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected char[] escape(int r13) {
        boolean[] r0 = this.safeOctets;
        if (r13 >= r0.length) goto L9;
        if (r0[r13] == false) goto L9;
        return null;
    L9:
        if (r13 != 32) goto L15;
        if (this.plusForSpace == false) goto L15;
        return PLUS_SIGN;
    L15:
        if (r13 > 127) goto L19;
        char[] r1 = UPPER_HEX_DIGITS;
        return new char[]{'%', r1[r13 >>> 4], r1[r13 & 15]};
    L19:
        if (r13 > 2047) goto L23;
        char[] r2 = UPPER_HEX_DIGITS;
        char[] r12 = {'%', r2[(r13 >>> 4) | 12], r2[r13 & 15], '%', r2[(r13 & 3) | 8], r2[r13 & 15]};
        int r14 = r13 >>> 4;
        int r15 = r14 >>> 2;
        return r12;
    L23:
        if (r13 > 65535) goto L27;
        char[] r3 = UPPER_HEX_DIGITS;
        char[] r16 = {'%', 'E', r3[r13 >>> 2], '%', r3[(r13 & 3) | 8], r3[r13 & 15], '%', r3[(r13 & 3) | 8], r3[r13 & 15]};
        int r17 = r13 >>> 4;
        int r18 = r17 >>> 2;
        int r19 = r18 >>> 4;
        return r16;
    L27:
        if (r13 > 1114111) goto L31;
        char[] r4 = UPPER_HEX_DIGITS;
        char[] r110 = {'%', 'F', r4[(r13 >>> 2) & 7], '%', r4[(r13 & 3) | 8], r4[r13 & 15], '%', r4[(r13 & 3) | 8], r4[r13 & 15], '%', r4[(r13 & 3) | 8], r4[r13 & 15]};
        int r111 = r13 >>> 4;
        int r112 = r111 >>> 2;
        int r113 = r112 >>> 4;
        int r114 = r113 >>> 2;
        int r115 = r114 >>> 4;
        return r110;
    L31:
        throw new IllegalArgumentException("Invalid unicode character value " + r13);
    }
}
