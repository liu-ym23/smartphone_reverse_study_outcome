package com.obric.memorydata.sdk.a;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: DebugLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f33796a;

    public b(boolean r1) {
        this.f33796a = r1;
    }

    @Override // com.obric.memorydata.sdk.a.c
    public void a(String r2, String r3) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        if (this.f33796a == false) goto L6;
        d(r2, r3);
        return;
    }

    @Override // com.obric.memorydata.sdk.a.c
    public void b(String r2, String r3) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        if (this.f33796a == false) goto L6;
        e(r2, r3);
        return;
    }

    @Override // com.obric.memorydata.sdk.a.c
    public void c(String r2, String r3) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        if (this.f33796a == false) goto L6;
        f(r2, r3);
        return;
    }

    @Override // com.obric.memorydata.sdk.a.c
    public void a(String r2, String r3, Throwable r4) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        if (this.f33796a == false) goto L8;
        if (r4 == null) goto L6;
        b(r2, r3, r4);
        return;
    L6:
        g(r2, r3);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int e(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int f(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int g(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
