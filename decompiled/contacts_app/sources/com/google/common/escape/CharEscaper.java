package com.google.common.escape;

import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CharEscaper extends Escaper {
    private static final int DEST_PAD_MULTIPLIER = 2;

    protected abstract char[] escape(char r1);

    protected CharEscaper() {
    }

    @Override // com.google.common.escape.Escaper
    public String escape(String r4) {
        Preconditions.checkNotNull(r4);
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (escape(r4.charAt(r1)) != null) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return escapeSlow(r4, r1);
    L9:
        return r4;
    }

    protected final String escapeSlow(String r12, int r13) {
        int r0 = r12.length();
        char[] r1 = Platform.charBufferFromThreadLocal();
        int r2 = r1.length;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r13 >= r0) goto L16;
        char[] r6 = escape(r12.charAt(r13));
        if (r6 == null) goto L15;
        int r7 = r6.length;
        int r8 = r13 - r4;
        int r9 = r5 + r8;
        int r10 = r9 + r7;
        if (r2 >= r10) goto L10;
        r2 = ((r0 - r13) * 2) + r10;
        r1 = growBuffer(r1, r5, r2);
    L10:
        if (r8 <= 0) goto L12;
        r12.getChars(r4, r13, r1, r5);
        r5 = r9;
    L12:
        if (r7 <= 0) goto L14;
        System.arraycopy(r6, 0, r1, r5, r7);
        r5 = r5 + r7;
    L14:
        r4 = r13 + 1;
    L15:
        r13 = r13 + 1;
        goto L3
    L16:
        int r11 = r0 - r4;
        if (r11 <= 0) goto L23;
        int r14 = r11 + r5;
        if (r2 >= r14) goto L21;
        r1 = growBuffer(r1, r5, r14);
    L21:
        r12.getChars(r4, r0, r1, r5);
        r5 = r14;
    L23:
        return new String(r1, 0, r5);
    }

    private static char[] growBuffer(char[] r1, int r2, int r3) {
        char[] r4 = new char[r3];
        if (r2 <= 0) goto L5;
        System.arraycopy(r1, 0, r4, 0, r2);
    L5:
        return r4;
    }
}
