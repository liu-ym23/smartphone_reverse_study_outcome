package com.alibaba.android.vlayout;

/* JADX INFO: loaded from: classes.dex */
public class Cantor {
    public Cantor() {
    }

    public static long getCantor(long r10, long r11) {
        long r12 = r10 + r11;
        return ((r12 * (1 + r12)) / 2) + r11;
    }

    public static void reverseCantor(long r10, long[] r11) {
        if (r11 != null) goto L5;
    L6:
        r11 = new long[2];
    L7:
        int r12 = (int) (Math.floor(Math.sqrt((8 * r10) + 1) - 1.0d) / 2.0d);
        int r13 = (int) (r10 - ((long) (((r12 * r12) + r12) / 2)));
        r11[0] = r12 - r13;
        r11[1] = r13;
        return;
    L5:
        if (r11.length >= 2) goto L7;
        goto L6
    }
}
