package com.bytedance.crash.npth_repair.nativeCrash;

import android.util.Log;
import com.bytedance.crash.npth_repair.NpthRepair;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.a;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class DvmSuspendTimeOpt {
    private static final String TAG = "DvmSuspendTimeOpt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static boolean f7650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static int f7651b;

    private static native int nSuspendTimeOpt();

    public DvmSuspendTimeOpt() {
    }

    public static synchronized int a() {
        monitor-enter(DvmSuspendTimeOpt.class);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (NpthRepair.a() == true) goto L11;
        a(TAG, "not init yet, please make sure invoke NpthRepair.init first");     // Catch: Throwable -> L25
        monitor-exit(DvmSuspendTimeOpt.class);
        return -1;
    L11:
        if (f7650a == false) goto L17;
        a(TAG, "has fixed");     // Catch: Throwable -> L25
        monitor-exit(DvmSuspendTimeOpt.class);
        return -2;
    L17:
        f7650a = true;     // Catch: Throwable -> L25
        f7651b = nSuspendTimeOpt();     // Catch: Throwable -> L20
    L22:
        int r1 = f7651b;     // Catch: Throwable -> L25
        monitor-exit(DvmSuspendTimeOpt.class);
        return r1;
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        f7651b = -4;     // Catch: Throwable -> L25
        goto L22
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
