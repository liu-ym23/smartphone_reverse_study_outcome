package com.bytedance.crash;

import android.os.Build;

/* JADX INFO: compiled from: GlobalSwitch.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7515a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f7516b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7517c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f7518d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f7519e;

    static {
    }

    public static void a(boolean r0) {
        f7515a = r0;
    }

    public static boolean a() {
        return f7515a;
    }

    public static void b(boolean r0) {
        f7516b = r0;
    }

    public static boolean b() {
        return f7516b;
    }

    public static boolean c() {
        return f7517c;
    }

    public static boolean d() {
        return f7518d;
    }

    public static void c(boolean r0) {
        f7519e = r0;
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
    L7:
        return false;
    L5:
        if (f7519e == false) goto L7;
        return true;
    }
}
