package oa;

import com.obric.android.alog.Alog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Alog f22543a;

    static {
    }

    public static void a() {
        Alog r10 = f22543a;
        if (r10 == null) goto L6;
        r10.h();
        return;
    }

    public static long b() {
        Alog r10 = f22543a;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.l();
    }

    public static void c(String r10, String r11) {
        k(1, r10, r11);
    }

    public static void d(String r10, String r11) {
        k(4, r10, r11);
    }

    public static void e(String r10, String r11) {
        k(2, r10, r11);
    }

    public static void f(String r10, String r11) {
        k(0, r10, r11);
    }

    public static void g(String r10, String r11) {
        k(3, r10, r11);
    }

    public static void h(int r10, String r11, String r12, long r13, long r14) {
        Alog r15 = f22543a;
        if (r15 == null) goto L6;
        r15.t(r10, r11, r12, r13, r14);
        return;
    }

    public static void i(Alog r10) {
        f22543a = r10;
        if (r10 != null) goto L5;
        long r11 = 0;
    L6:
        Alog.nativeSetDefaultInstance(r11);
        return;
    L5:
        r11 = r10.m();
        goto L6
    }

    public static void j(int r10) {
        Alog r11 = f22543a;
        if (r11 == null) goto L6;
        r11.p(r10);
        return;
    }

    public static void k(int r10, String r11, String r12) {
        Alog r13 = f22543a;
        if (r13 == null) goto L6;
        r13.s(r10, r11, r12);
        return;
    }
}
