package com.bytedance.retrofit2;

/* JADX INFO: compiled from: TTMetricsUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class am {
    public static long a(long r3) {
        if (r3 != (-1)) goto L6;
        return -1;
    L6:
        return r3 / 1000000;
    }

    public static long b(long r3) {
        if (r3 != (-1)) goto L6;
        return -1;
    L6:
        return r3 / 1000;
    }

    public static long a(long r5, long r7, long r9) {
        if (r5 >= 0) goto L5;
    L14:
        return -1;
    L5:
        if (r7 < 0) goto L14;
        if (r9 < 0) goto L14;
        if (r7 <= r9) goto L13;
        return -1;
    L13:
        return a(r9 - r7) + r5;
    }

    public static long a(long r3, long r5) {
        if (r3 != (-1)) goto L5;
    L11:
        return -1;
    L5:
        if (r5 == (-1)) goto L11;
        if (r3 > r5) goto L11;
        return b(r5 - r3);
    }
}
