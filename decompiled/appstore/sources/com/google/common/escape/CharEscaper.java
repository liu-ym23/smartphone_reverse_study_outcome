package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public abstract class CharEscaper extends Escaper {
    private static final int DEST_PAD_MULTIPLIER = 2;

    public CharEscaper() {
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
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (escape(r10.charAt(r12)) != null) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        return escapeSlow(r10, r12);
    L9:
        return r10;
    }

    public abstract char[] escape(char r10);

    public final String escapeSlow(String r12, int r13) {
        int r10 = r12.length();
        char[] r11 = Platform.charBufferFromThreadLocal();
        int r14 = r11.length;
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r13 >= r10) goto L16;
        char[] r17 = escape(r12.charAt(r13));
        if (r17 == null) goto L15;
        int r18 = r17.length;
        int r19 = r13 - r15;
        int r20 = r16 + r19;
        int r110 = r20 + r18;
        if (r14 >= r110) goto L10;
        r14 = ((r10 - r13) * 2) + r110;
        r11 = growBuffer(r11, r16, r14);
    L10:
        if (r19 <= 0) goto L12;
        r12.getChars(r15, r13, r11, r16);
        r16 = r20;
    L12:
        if (r18 <= 0) goto L14;
        System.arraycopy(r17, 0, r11, r16, r18);
        r16 = r16 + r18;
    L14:
        r15 = r13 + 1;
    L15:
        r13 = r13 + 1;
        goto L3
    L16:
        int r111 = r10 - r15;
        if (r111 <= 0) goto L23;
        int r112 = r111 + r16;
        if (r14 >= r112) goto L21;
        r11 = growBuffer(r11, r16, r112);
    L21:
        r12.getChars(r15, r10, r11, r16);
        r16 = r112;
    L23:
        return new String(r11, 0, r16);
    }
}
