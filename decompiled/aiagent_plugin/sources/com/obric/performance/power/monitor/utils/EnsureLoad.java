package com.obric.performance.power.monitor.utils;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: EnsureLoad.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EnsureLoad {
    private static final String TAG = "EnsureLoad";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnsureLoad f37016a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f37017b;

    public final void init() {
    }

    private EnsureLoad() {
    }

    public final boolean a() {
        return f37017b;
    }

    static {
        f37016a = new EnsureLoad();
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L5
        System.loadLibrary("performance_power");     // Catch: Throwable -> L5
        f37017b = true;     // Catch: Throwable -> L5
        a(TAG, "cost:" + (System.currentTimeMillis() - r1));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        a(TAG, "init performance_power.so", th);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
