package com.google.common.base;

import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
final class SmallCharMatcher extends CharMatcher.FastMatcher {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] r1, long r2, boolean r4, String r5) {
        super(r5);
        this.table = r1;
        this.filter = r2;
        this.containsZero = r4;
    }

    static int smear(int r1) {
        return Integer.rotateLeft(r1 * C1, 15) * C2;
    }

    private boolean checkFilter(int r3) {
        if (1 != ((this.filter >> r3) & 1)) goto L5;
        return true;
    L5:
        return false;
    }

    static int chooseTableSize(int r5) {
        if (r5 != 1) goto L6;
        return 2;
    L6:
        int r0 = Integer.highestOneBit(r5 - 1) << 1;
    L8:
        if ((((double) r0) * 0.5d) >= r5) goto L10;
        r0 = r0 << 1;
        goto L8
    L10:
        return r0;
    }

    static CharMatcher from(BitSet r9, String r10) {
        int r0 = r9.cardinality();
        boolean r6 = r9.get(0);
        int r1 = chooseTableSize(r0);
        char[] r3 = new char[r1];
        int r2 = r1 - 1;
        int r4 = r9.nextSetBit(0);
        long r5 = 0;
    L4:
        if (r4 == (-1)) goto L11;
        long r7 = (1 << r4) | r5;
        int r8 = smear(r4);
    L6:
        int r11 = r8 & r2;
        if (r3[r11] == 0) goto L8;
        r8 = r11 + 1;
        goto L6
    L8:
        r3[r11] = (char) r4;
        r4 = r9.nextSetBit(r4 + 1);
        r5 = r7;
        goto L4
    L11:
        return new SmallCharMatcher(r3, r5, r6, r10);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char r7) {
        if (r7 != 0) goto L6;
        return this.containsZero;
    L6:
        if (checkFilter(r7) == true) goto L8;
        return false;
    L8:
        int r0 = this.table.length - 1;
        int r3 = smear(r7) & r0;
        int r4 = r3;
    L9:
        char r5 = this.table[r4];
        if (r5 == 0) goto L11;
        if (r5 == r7) goto L13;
        r4 = (r4 + 1) & r0;
        if (r4 != r3) goto L9;
        return false;
    L13:
        return true;
    L11:
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    void setBits(BitSet r4) {
        int r1 = 0;
        if (this.containsZero == false) goto L5;
        r4.set(0);
    L5:
        char[] r3 = this.table;
        int r0 = r3.length;
    L6:
        if (r1 >= r0) goto L11;
        char r2 = r3[r1];
        if (r2 == 0) goto L10;
        r4.set(r2);
    L10:
        r1 = r1 + 1;
        goto L6
    }
}
