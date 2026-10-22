package com.obric.oui.common.util;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import d.h.b.o;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OUILogger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f34568a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f34569b;

    static {
        f34568a = new e();
    }

    private e() {
    }

    public final void a(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        d r0 = f34569b;
        if (r0 != null) goto L5;
        x r3 = null;
    L6:
        if (r3 != null) goto L9;
        Integer.valueOf(b(r1, r2));
        return;
    L9:
        return;
    L5:
        r0.a(r1, r2);
        r3 = x.f38692a;
        goto L6
    }

    public final void c(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        d r0 = f34569b;
        if (r0 != null) goto L5;
        x r3 = null;
    L6:
        if (r3 != null) goto L9;
        Integer.valueOf(d(r1, r2));
        return;
    L9:
        return;
    L5:
        r0.b(r1, r2);
        r3 = x.f38692a;
        goto L6
    }

    public static /* synthetic */ void a(e r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        d r0 = f34569b;
        if (r0 != null) goto L5;
        x r4 = null;
    L6:
        if (r4 != null) goto L9;
        Integer.valueOf(b(r1, r2, r3));
        return;
    L9:
        return;
    L5:
        r0.a(r1, r2, r3);
        r4 = x.f38692a;
        goto L6
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
