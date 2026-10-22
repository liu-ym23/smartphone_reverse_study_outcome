package com.google.zxing.oned.rss;

/* JADX INFO: loaded from: classes3.dex */
public final class RSSUtils {
    private RSSUtils() {
    }

    public static int getRSSvalue(int[] r17, int r18, boolean r19) {
        int[] r0 = r17;
        int r2 = r0.length;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r5 = r5 + r0[r4];
        r4 = r4 + 1;
        goto L3
    L5:
        int r3 = r0.length;
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L6:
        int r9 = r3 - 1;
        if (r6 >= r9) goto L27;
        int r10 = 1 << r6;
        r8 = r8 | r10;
        int r11 = 1;
    L10:
        if (r11 >= r0[r6]) goto L26;
        int r12 = r5 - r11;
        int r14 = r3 - r6;
        int r15 = r14 - 2;
        int r13 = combins(r12 - 1, r15);
        if (r19 == false) goto L18;
        if (r8 != 0) goto L18;
        int r16 = r14 - 1;
        if ((r12 - r16) < r16) goto L18;
        r13 = r13 - combins(r12 - r14, r15);
    L18:
        if ((r14 - 1) <= 1) goto L23;
        int r20 = r12 - r15;
        int r110 = 0;
    L20:
        if (r20 <= r18) goto L22;
        r110 = r110 + combins((r12 - r20) - 1, r14 - 3);
        r20 = r20 - 1;
        goto L20
    L22:
        r13 = r13 - (r110 * (r9 - r6));
    L25:
        r7 = r7 + r13;
        r11 = r11 + 1;
        r8 = r8 & (~r10);
        r0 = r17;
        goto L10
    L23:
        if (r12 <= r18) goto L25;
        r13 = r13 - 1;
        goto L25
    L26:
        r5 = r5 - r11;
        r6 = r6 + 1;
        r0 = r17;
        goto L6
    L27:
        return r7;
    }

    private static int combins(int r4, int r5) {
        int r0 = r4 - r5;
        if (r0 <= r5) goto L5;
        r0 = r5;
        r5 = r0;
    L5:
        int r1 = 1;
        int r2 = 1;
    L6:
        if (r4 <= r5) goto L11;
        r1 = r1 * r4;
        if (r2 > r0) goto L10;
        r1 = r1 / r2;
        r2 = r2 + 1;
    L10:
        r4 = r4 - 1;
    L11:
        if (r2 > r0) goto L13;
        r1 = r1 / r2;
        r2 = r2 + 1;
        goto L11
    L13:
        return r1;
    }
}
