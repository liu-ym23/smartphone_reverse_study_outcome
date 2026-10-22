package com.obric.performance.power.monitor.i;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import java.io.File;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ThreadMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f37011a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final File f37012b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final File f37013c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f37014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f37015e;

    private a() {
    }

    static {
        f37011a = new a();
        File r0 = new File("/proc/self/task");
        f37012b = r0;
        f37013c = new File("/proc/self/limits");
        f37015e = -1;
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == true) goto L7;
        return;
    L7:
        if (r0.canRead() == false) goto L12;
        f37014d = true;
        return;
    }

    public final int a() {
        if (f37014d == true) goto L15;
        ILogDepend.Companion.d("PowerMonitor", "ThreadMonitor getCount: canRead=false, return 0");
        return 0;
    L15:
        File[] r5 = f37012b.listFiles();     // Catch: Throwable -> L12
        if (r5 == null) goto L9;
        int r6 = r5.length;     // Catch: Throwable -> L12
    L10:
        ILogDepend.Companion.d("PowerMonitor", "ThreadMonitor getCount: " + r6);     // Catch: Throwable -> L12
        return r6;
    L9:
        r6 = 0;
    L12:
        th = move-exception;
        a("PowerMonitor", "ThreadMonitor getCount", th);
        return 0;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
