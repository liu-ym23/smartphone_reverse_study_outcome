package com.baidu.mshield.b.c;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f32365a = -1;

    public static void a(int r100, String r101) {
    }

    public static void a(Throwable r100) {
    }

    static {
        new ThreadLocal();
    }

    public static void a(String r100) {
        b(r100);
    }

    public static void b(String r100) {
        int r101 = f32365a;
        if (r101 == (-1)) goto L7;
        if (r101 == 0) goto L7;
        if (r101 == 1) goto L7;
        return;
    L7:
        a(1, r100);
    }

    public static void c(String r100) {
        int r101 = f32365a;
        if (r101 == (-1)) goto L9;
        if (r101 == 0) goto L9;
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L9;
        return;
    L9:
        a(2, r100);
    }
}
