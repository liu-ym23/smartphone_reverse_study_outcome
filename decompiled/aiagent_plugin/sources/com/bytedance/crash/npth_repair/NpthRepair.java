package com.bytedance.crash.npth_repair;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.crash.npth_repair.a.a;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class NpthRepair {
    private static final String TAG = "NpthRepair";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f7637a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f7638b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7639c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f7640d = -1;

    static {
    }

    private static native boolean nGetDebuggable();

    private static native int nInit(int r0, boolean r1);

    private static native void nSetDebuggable(boolean r0);

    public NpthRepair() {
    }

    public static synchronized int a(Context r3, boolean r4) {
        monitor-enter(NpthRepair.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (f7639c == false) goto L11;
        if (r4 == false) goto L8;
        a(TAG, "already do init");     // Catch: Throwable -> L21
    L8:
        int r6 = f7640d;     // Catch: Throwable -> L21
        monitor-exit(NpthRepair.class);
        return r6;
    L11:
        a.a(r4);     // Catch: Throwable -> L21
        f7639c = true;     // Catch: Throwable -> L21
        f7637a = r5;     // Catch: Throwable -> L21
        if (b() == true) goto L25;
        f7640d = -5;     // Catch: Throwable -> L21
    L18:
        int r7 = f7640d;     // Catch: Throwable -> L21
        monitor-exit(NpthRepair.class);
        return r7;
    L25:
        a(r4);     // Catch: Throwable -> L15
        f7640d = nInit(Build.VERSION.SDK_INT, r4);     // Catch: Throwable -> L15
    L16:
        f7640d = -3;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public static boolean a() {
        if (f7640d != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void a(boolean r1) {
        a.a(r1);
        if (f7638b == false) goto L6;
        nSetDebuggable(r1);
        return;
    }

    public static boolean b() {
        if (f7638b == true) goto L8;
        com.bytedance.librarian.a.a("npth_repair", f7637a);     // Catch: Throwable -> L6
        f7638b = true;     // Catch: Throwable -> L6
    L6:
        a(TAG, "load so fail");
    L8:
        return f7638b;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
