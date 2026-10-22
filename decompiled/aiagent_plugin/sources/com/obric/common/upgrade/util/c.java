package com.obric.common.upgrade.util;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: LogUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final String TAG = "OAppUpgrade";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f32650a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f32651b;

    static {
        f32650a = new c();
    }

    private c() {
    }

    public final void a(boolean r1) {
        f32651b = r1;
    }

    public final void a(String r1) {
        o.e(r1, "msg");
        if (f32651b == false) goto L6;
        a(TAG, r1);
        return;
    }

    public final void b(String r1) {
        o.e(r1, "msg");
        if (f32651b == false) goto L6;
        b(TAG, r1);
        return;
    }

    public final void c(String r1) {
        o.e(r1, "msg");
        if (f32651b == false) goto L6;
        c(TAG, r1);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
