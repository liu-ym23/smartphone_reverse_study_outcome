package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.BitSet;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] r10, long r11, boolean r12, String r13) {
        super(r13);
        this.table = r10;
        this.filter = r11;
        this.containsZero = r12;
    }

    private boolean checkFilter(int r10) {
        if (1 != ((this.filter >> r10) & 1)) goto L5;
        return true;
    L5:
        return false;
    }

    @VisibleForTesting
    public static int chooseTableSize(int r10) {
        if (r10 != 1) goto L6;
        return 2;
    L6:
        int r11 = Integer.highestOneBit(r10 - 1) << 1;
    L8:
        if ((((double) r11) * DESIRED_LOAD_FACTOR) >= r10) goto L10;
        r11 = r11 << 1;
        goto L8
    L10:
        return r11;
    }

    public static CharMatcher from(BitSet r10, String r11) {
        int r12 = r10.cardinality();
        boolean r13 = r10.get(0);
        int r14 = chooseTableSize(r12);
        char[] r15 = new char[r14];
        int r16 = r14 - 1;
        int r17 = r10.nextSetBit(0);
        long r18 = 0;
    L4:
        if (r17 == (-1)) goto L11;
        long r19 = (1 << r17) | r18;
        int r20 = smear(r17);
    L6:
        int r21 = r20 & r16;
        if (r15[r21] == 0) goto L8;
        r20 = r21 + 1;
        goto L6
    L8:
        r15[r21] = (char) r17;
        r17 = r10.nextSetBit(r17 + 1);
        r18 = r19;
        goto L4
    L11:
        return new SmallCharMatcher(r15, r18, r13, r11);
    }

    public static int smear(int r10) {
        return Integer.rotateLeft(r10 * C1, 15) * C2;
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char r10) {
        if (r10 != 0) goto L6;
        return this.containsZero;
    L6:
        if (checkFilter(r10) == true) goto L8;
        return false;
    L8:
        int r11 = this.table.length - 1;
        int r12 = smear(r10) & r11;
        int r13 = r12;
    L9:
        char r14 = this.table[r13];
        if (r14 == 0) goto L11;
        if (r14 == r10) goto L13;
        r13 = (r13 + 1) & r11;
        if (r13 != r12) goto L9;
        return false;
    L13:
        return true;
    L11:
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    public void setBits(BitSet r10) {
        int r11 = 0;
        if (this.containsZero == false) goto L5;
        r10.set(0);
    L5:
        char[] r12 = this.table;
        int r13 = r12.length;
    L6:
        if (r11 >= r13) goto L11;
        char r14 = r12[r11];
        if (r14 == 0) goto L10;
        r10.set(r14);
    L10:
        r11 = r11 + 1;
        goto L6
    }
}
