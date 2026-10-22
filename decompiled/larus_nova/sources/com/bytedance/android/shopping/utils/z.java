package com.bytedance.android.shopping.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187162a = 0;

    public z() {
    }

    static {
    }

    public static void a(String r100, Throwable r101, String r102) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L10;
        dm.a.b r103 = dm.a.f469202a;
        if (r102 != null) goto L7;
        r102 = "EcomPdp";
    L7:
        dm.a.a(r102).b(r100, r101);
        return;
    L10:
        return;
    }

    public static void b(Object r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        xh.a r103 = xh.c.a("EcomPdp");
        xh.b r104 = new xh.b();
        r104.c(r101);
        r104.b(r102);
        r104.a(r100);
        r103.f(4, r104);
    }

    public static /* synthetic */ void c(Object r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        b(r100, r101, null);
    }
}
