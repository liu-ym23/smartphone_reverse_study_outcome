package com.ttnet.org.chromium.base.a;

/* JADX INFO: compiled from: RecordHistogram.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static int a(long r2) {
        if (r2 <= 2147483647L) goto L7;
        return Integer.MAX_VALUE;
    L7:
        if (r2 >= (-2147483648L)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) r2;
    }

    public static void a(String r1, boolean r2) {
        d.a().a(r1, r2);
    }

    public static void a(String r8, long r9) {
        a(r8, r9, 1, 10000, 50);
    }

    private static void a(String r2, long r3, long r5, long r7, int r9) {
        d.a().a(r2, a(r3), a(r5), a(r7), r9);
    }
}
