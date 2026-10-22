package com.bytedance.securityguardkit.a;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: PlatformKeyManagerFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "PlatformKeyManagerFactory";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.bytedance.securityguardkit.a.a.a f11123a;

    public static synchronized com.bytedance.securityguardkit.a.a.a a() {
        monitor-enter(a.class);
        com.bytedance.securityguardkit.a.a.a r1 = f11123a;     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        int r2 = b.a();     // Catch: Throwable -> L18
        if (r2 != 1) goto L12;
        a(TAG, "get ObricPlatformKeyManagerAdapter.");     // Catch: Throwable -> L18
        f11123a = new com.bytedance.securityguardkit.a.c.a();     // Catch: Throwable -> L18
    L15:
        com.bytedance.securityguardkit.a.a.a r3 = f11123a;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return r3;
    L12:
        if (r2 != 2) goto L14;
        a(TAG, "get AssistantPlatformKeyManagerAdapter.");     // Catch: Throwable -> L18
        f11123a = new com.bytedance.securityguardkit.a.b.a();     // Catch: Throwable -> L18
        goto L15
    L14:
        b(TAG, "unknown platform type: " + r2);     // Catch: Throwable -> L18
        f11123a = null;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
