package com.amap.api.mapcore.util;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes28.dex */
public class r3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f27925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f27926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f27927e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f27929b;

    public boolean e() {
        if (this.f27929b < 20) goto L5;
        return true;
    L5:
        return false;
    }

    public void f() {
        this.f27929b++;
    }

    public r3() {
        this.f27928a = false;
        this.f27929b = 0;
    }

    public static boolean b() {
        return f27925c;
    }

    public static boolean c() {
        return f27926d;
    }

    public static boolean d() {
        return f27927e;
    }

    public boolean a() {
        return this.f27928a;
    }

    public static void b(boolean r100) {
        f27926d = r100;
    }

    public static void c(boolean r100) {
        f27927e = r100;
    }

    public boolean a(Bitmap r110) {
        if (r110 != null) goto L31;
    L29:
        this.f27928a = true;
        return true;
    L31:
        int r100 = r110.getWidth();     // Catch: Throwable -> L23
        int r101 = r110.getHeight();     // Catch: Throwable -> L23
        int r102 = (int) (r100 / 4.0f);     // Catch: Throwable -> L23
        int r103 = -1;
    L6:
        if (r102 >= ((r100 * 3) / 4.0f)) goto L29;
        int r104 = (int) (r101 / 4.0f);     // Catch: Throwable -> L23
    L9:
        if (r104 >= ((r101 * 3) / 4.0f)) goto L22;
        int r105 = r110.getPixel(r102, r104);     // Catch: Throwable -> L23
        if (r103 != (-1)) goto L14;
        r103 = r105;
    L14:
        if (r105 != r103) goto L15;
        if (r105 != (-16777216)) goto L19;
        r104 = r104 + 1;
        goto L9
    L19:
        this.f27928a = true;
        return false;
    L15:
        this.f27928a = true;
        return false;
    L22:
        r102 = r102 + 1;
    L23:
        th = move-exception;
        t6.a(th, "AMapdelegate", "checkBlackScreen");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        this.f27928a = true;
        throw th;
    }

    public static void a(boolean r100) {
        f27925c = r100;
    }
}
