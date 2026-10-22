package com.bytedance.bdinstall;

/* JADX INFO: compiled from: DrLog.java */
/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6443a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6444b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ah f6445c;

    static {
        f6444b = com.bytedance.bdinstall.j.j.b();
    }

    public static void a(String r3) {
        ah r0 = f6445c;
        if (r0 == null) goto L6;
        r0.b("bdinstall# " + r3, null);
        return;
    }

    public static void a(String r3, Throwable r4) {
        ah r0 = f6445c;
        if (r0 == null) goto L6;
        r0.c("bdinstall# " + r3, r4);
        return;
    }

    public static void b(String r3, Throwable r4) {
        ah r0 = f6445c;
        if (r0 == null) goto L6;
        r0.e("bdinstall# " + r3, r4);
        return;
    }

    public static void c(String r3, Throwable r4) {
        ah r0 = f6445c;
        if (r0 == null) goto L6;
        r0.d("bdinstall# " + r3, r4);
        return;
    }

    public static void a(Throwable r2) {
        ah r0 = f6445c;
        if (r0 == null) goto L6;
        r0.e("U SHALL NOT PASS!", r2);
        return;
    }

    public static boolean a() {
        return f6443a;
    }

    public static void b(String r3) {
        ah r0 = f6445c;
        if (r0 == null) goto L6;
        r0.a("bdinstall# " + r3, null);
        return;
    }

    public static void c(String r3) {
        ah r0 = f6445c;
        if (r0 == null) goto L6;
        r0.e("bdinstall# " + r3, null);
        return;
    }
}
