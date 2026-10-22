package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public abstract class UnicodeEscaper extends Escaper {
    private static final int DEST_PAD = 32;

    public UnicodeEscaper() {
    }

    public static int codePointAt(CharSequence r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        if (r11 >= r12) goto L24;
        int r13 = r11 + 1;
        char r14 = r10.charAt(r11);
        if (r14 >= 55296) goto L7;
    L22:
        return r14;
    L7:
        if (r14 > 57343) goto L22;
        if (r14 > 56319) goto L21;
        if (r13 == r12) goto L13;
        char r15 = r10.charAt(r13);
        if (Character.isLowSurrogate(r15) == false) goto L19;
        return Character.toCodePoint(r14, r15);
    L19:
        throw new IllegalArgumentException("Expected low surrogate but got char '" + r15 + "' with value " + r15 + " at index " + r13 + " in '" + r10 + "'");
    L13:
        return -r14;
    L21:
        throw new IllegalArgumentException("Unexpected low surrogate character '" + r14 + "' with value " + r14 + " at index " + r11 + " in '" + r10 + "'");
    L24:
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static char[] growBuffer(char[] r10, int r11, int r12) {
        if (r12 < 0) goto L8;
        char[] r13 = new char[r12];
        if (r11 <= 0) goto L6;
        System.arraycopy(r10, 0, r13, 0, r11);
    L6:
        return r13;
    L8:
        throw new AssertionError("Cannot increase internal buffer any further");
    }

    @Override // com.google.common.escape.Escaper
    public String escape(String r10) {
        Preconditions.checkNotNull(r10);
        int r11 = r10.length();
        int r12 = nextEscapeIndex(r10, 0, r11);
        if (r12 != r11) goto L6;
        return r10;
    L6:
        return escapeSlow(r10, r12);
    }

    public abstract char[] escape(int r10);

    public final String escapeSlow(String r12, int r13) {
        int r10 = r12.length();
        char[] r11 = Platform.charBufferFromThreadLocal();
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r13 >= r10) goto L24;
        int r16 = codePointAt(r12, r13, r10);
        if (r16 < 0) goto L23;
        char[] r17 = escape(r16);
        if (Character.isSupplementaryCodePoint(r16) == false) goto L9;
        int r18 = 2;
    L10:
        int r19 = r18 + r13;
        if (r17 == null) goto L21;
        int r20 = r13 - r14;
        int r21 = r15 + r20;
        int r22 = r17.length + r21;
        if (r11.length >= r22) goto L15;
        r11 = growBuffer(r11, r15, (r22 + (r10 - r13)) + 32);
    L15:
        if (r20 <= 0) goto L18;
        r12.getChars(r14, r13, r11, r15);
        r15 = r21;
    L18:
        if (r17.length <= 0) goto L20;
        System.arraycopy(r17, 0, r11, r15, r17.length);
        r15 = r15 + r17.length;
    L20:
        r14 = r19;
    L21:
        r13 = nextEscapeIndex(r12, r19, r10);
        goto L3
    L9:
        r18 = 1;
        goto L10
    L23:
        throw new IllegalArgumentException("Trailing high surrogate at end of input");
    L24:
        int r110 = r10 - r14;
        if (r110 <= 0) goto L31;
        int r111 = r110 + r15;
        if (r11.length >= r111) goto L29;
        r11 = growBuffer(r11, r15, r111);
    L29:
        r12.getChars(r14, r10, r11, r15);
        r15 = r111;
    L31:
        return new String(r11, 0, r15);
    }

    public int nextEscapeIndex(CharSequence r10, int r11, int r12) {
    L2:
        if (r11 >= r12) goto L13;
        int r13 = codePointAt(r10, r11, r12);
        if (r13 < 0) goto L13;
        if (escape(r13) != null) goto L13;
        if (Character.isSupplementaryCodePoint(r13) == false) goto L11;
        int r14 = 2;
    L12:
        r11 = r11 + r14;
        goto L2
    L11:
        r14 = 1;
    L13:
        return r11;
    }
}
