package com.obric.matrix.platform.sdk.ones.internal.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MLog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final String TAG = "matrix_ones";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f33684a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f33685b;

    static {
        f33684a = new b();
    }

    private b() {
    }

    public static /* synthetic */ void a(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        a(r0, r1, r2);
    }

    public static final void a(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        if (f33685b == false) goto L5;
        b(r1, r2, r3);
    L5:
        f33684a.k(r1, r2, r3);
    }

    public static /* synthetic */ void b(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        c(r0, r1, r2);
    }

    public static final void c(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        if (f33685b == false) goto L5;
        d(r1, r2, r3);
    L5:
        f33684a.k(r1, r2, r3);
    }

    public static final void a(String r3) {
        o.e(r3, "msg");
        c(TAG, r3, null, 4, null);
    }

    public static /* synthetic */ void c(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        e(r0, r1, r2);
    }

    public static final void e(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        if (f33685b == false) goto L5;
        f(r1, r2, r3);
    L5:
        f33684a.l(r1, r2, r3);
    }

    public static /* synthetic */ void d(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        g(r0, r1, r2);
    }

    public static final void g(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        if (f33685b == false) goto L5;
        h(r1, r2, r3);
    L5:
        f33684a.l(r1, r2, r3);
    }

    public static /* synthetic */ void e(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        i(r0, r1, r2);
    }

    public static final void i(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        if (f33685b == false) goto L5;
        j(r1, r2, r3);
    L5:
        f33684a.l(r1, r2, r3);
    }

    private final void k(String r3, String r4, Throwable r5) {
        com.obric.matrix.platform.sdk.ones.a r2 = com.obric.matrix.platform.sdk.ones.b.f33630a.b();
        if (r2 == null) goto L6;
        r2.a(r3, "MatrixOnesSdk: " + r4, r5);
        return;
    }

    private final void l(String r3, String r4, Throwable r5) {
        com.obric.matrix.platform.sdk.ones.a r2 = com.obric.matrix.platform.sdk.ones.b.f33630a.b();
        if (r2 == null) goto L6;
        r2.b(r3, "MatrixOnesSdk: " + r4, r5);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int f(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int h(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int j(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
