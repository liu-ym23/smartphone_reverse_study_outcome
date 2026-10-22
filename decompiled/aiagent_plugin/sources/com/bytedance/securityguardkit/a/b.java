package com.bytedance.securityguardkit.a;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: PlatformTypeDetector.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "PlatformTypeDetector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11124a = -1;

    static {
    }

    public static synchronized int a() {
        monitor-enter(b.class);
        int r1 = f11124a;     // Catch: Throwable -> L12
        if (r1 == (-1)) goto L9;
        monitor-exit(b.class);
        return r1;
    L9:
        int r2 = b();     // Catch: Throwable -> L12
        f11124a = r2;     // Catch: Throwable -> L12
        monitor-exit(b.class);
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    private static int b() {
        if (a("com.obric.security.platformkey.PlatformKeyManager", null) == false) goto L7;
        a(TAG, "Platform detected: obric");
        return 1;
    L7:
        if (a("com.aiassistant.security.platformkey.PlatformKeyManager", null) == false) goto L10;
        a(TAG, "Platform detected: assistant");
        return 2;
    L10:
        b(TAG, "PlatformKeyManager not found in either package");
        return 0;
    }

    private static boolean a(String r1, ClassLoader r2) {
        Class.forName(r1, false, r2);     // Catch: Throwable -> L6
        return true;
    L6:
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
