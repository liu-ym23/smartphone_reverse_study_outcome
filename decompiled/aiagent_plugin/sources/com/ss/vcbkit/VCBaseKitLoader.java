package com.ss.vcbkit;

import android.util.Log;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class VCBaseKitLoader {
    private static final String TAG = "vcbasekit";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f37589a = false;

    static {
    }

    private VCBaseKitLoader() {
    }

    public static synchronized boolean loadLibrary() {
        monitor-enter(VCBaseKitLoader.class);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (f37589a == false) goto L9;
        monitor-exit(VCBaseKitLoader.class);
        return true;
    L9:
        UnExpected.a();     // Catch: Throwable -> L19
        System.loadLibrary(TAG);     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
        f37589a = true;     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
    L16:
        boolean r1 = f37589a;     // Catch: Throwable -> L19
        monitor-exit(VCBaseKitLoader.class);
        return r1;
    L12:
        th = move-exception;
        a(TAG, "Can't load vcbasekit:" + th.getMessage());     // Catch: Throwable -> L19
    L14:
        e = move-exception;
        a(TAG, "Can't link vcbasekit:" + e.getMessage());     // Catch: Throwable -> L19
        goto L16
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
