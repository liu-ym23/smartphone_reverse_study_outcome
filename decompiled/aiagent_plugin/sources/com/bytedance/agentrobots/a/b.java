package com.bytedance.agentrobots.a;

import aiassistant.version.AssistantVersion;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;
import obric.version.ObricVersion;

/* JADX INFO: compiled from: TypeDetector.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "TypeDetector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3986a = -1;

    static {
    }

    public static synchronized int a() {
        monitor-enter(b.class);
        int r1 = f3986a;     // Catch: Throwable -> L12
        if (r1 == (-1)) goto L9;
        monitor-exit(b.class);
        return r1;
    L9:
        int r2 = b();     // Catch: Throwable -> L12
        f3986a = r2;     // Catch: Throwable -> L12
        monitor-exit(b.class);
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    private static int b() {
        int r0 = c();
        if (r0 < 10) goto L6;
        a(TAG, "robots framework detected: assistant, version=" + r0);
        return 2;
    L6:
        if (r0 < 0) goto L9;
        a(TAG, "robots framework detected: obric, version=" + r0);
        return 1;
    L9:
        b(TAG, "robots framework version unresolved");
        return 0;
    }

    private static int c() {
        return AssistantVersion.getVersion();
    L4:
        th = move-exception;
        b(TAG, "AssistantVersion.getVersion() failed: " + th.getClass().getSimpleName());
        return ObricVersion.getVersion();
    L8:
        th = move-exception;
        b(TAG, "ObricVersion.getVersion() failed: " + th.getClass().getSimpleName());
        return -1;
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
