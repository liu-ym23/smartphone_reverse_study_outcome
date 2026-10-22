package com.google.common.collect;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class Hashing {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static int MAX_TABLE_SIZE = 1073741824;

    static {
    }

    private Hashing() {
    }

    static int smear(int r1) {
        return Integer.rotateLeft(r1 * C1, 15) * C2;
    }

    static int smearedHash(@Nullable Object r0) {
        if (r0 != null) goto L4;
        int r1 = 0;
    L6:
        return smear(r1);
    L4:
        r1 = r0.hashCode();
        goto L6
    }

    static int closedTableSize(int r3, double r4) {
        int r5 = Math.max(r3, 2);
        int r0 = Integer.highestOneBit(r5);
        if (r5 <= ((int) (r4 * ((double) r0)))) goto L9;
        int r6 = r0 << 1;
        if (r6 <= 0) goto L8;
        return r6;
    L8:
        return MAX_TABLE_SIZE;
    L9:
        return r0;
    }

    static boolean needsResizing(int r4, int r5, double r6) {
        if (r4 > (r6 * ((double) r5))) goto L5;
    L7:
        return false;
    L5:
        if (r5 >= MAX_TABLE_SIZE) goto L7;
        return true;
    }
}
