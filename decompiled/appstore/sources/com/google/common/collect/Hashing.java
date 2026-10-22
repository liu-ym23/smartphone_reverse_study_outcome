package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
final class Hashing {
    private static final long C1 = -862048943;
    private static final long C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    private Hashing() {
    }

    public static int closedTableSize(int r10, double r11) {
        int r12 = Math.max(r10, 2);
        int r13 = Integer.highestOneBit(r12);
        if (r12 <= ((int) (r11 * ((double) r13)))) goto L9;
        int r14 = r13 << 1;
        if (r14 > 0) goto L10;
        return 1073741824;
    L10:
        return r14;
    L9:
        return r13;
    }

    public static boolean needsResizing(int r10, int r11, double r12) {
        if (r10 > (r12 * ((double) r11))) goto L5;
    L7:
        return false;
    L5:
        if (r11 >= 1073741824) goto L7;
        return true;
    }

    public static int smear(int r10) {
        return (int) (((long) Integer.rotateLeft((int) (((long) r10) * C1), 15)) * C2);
    }

    public static int smearedHash(@NullableDecl Object r10) {
        if (r10 != null) goto L4;
        int r11 = 0;
    L6:
        return smear(r11);
    L4:
        r11 = r10.hashCode();
        goto L6
    }
}
