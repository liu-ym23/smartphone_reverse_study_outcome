package com.bytedance.bdturing;

import android.util.Log;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: LogUtil.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f6553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f6554b;

    static {
        f6553a = new g();
        f6554b = 1;
    }

    private g() {
    }

    public static final boolean a() {
        if (f6554b <= 6) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void a(String r2, String r3) {
        if (f6554b >= 4) goto L5;
        return;
    L5:
        b(r2, String.valueOf(r3));
    }

    public static final void c(String r2, String r3) {
        if (f6554b >= 5) goto L5;
        return;
    L5:
        d(r2, String.valueOf(r3));
    }

    public static final void e(String r2, String r3) {
        if (f6554b >= 6) goto L5;
        return;
    L5:
        f(r2, String.valueOf(r3));
    }

    public static final void g(String r2, String r3) {
        if (f6554b >= 3) goto L5;
        return;
    L5:
        h(r2, String.valueOf(r3));
    }

    public static final void a(Exception r2) {
        o.d(r2, "e");
        if (f6554b >= 3) goto L6;
        r2.printStackTrace();
        return;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int h(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int f(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
