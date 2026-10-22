package com.bytedance.crash.npth_repair.a;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: RepairLog.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "NpthRepair";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7641a = false;

    static {
    }

    public static void a(String r1, Object r2) {
        if (f7641a == false) goto L6;
        a(TAG, r1 + " " + r2);
        return;
    }

    public static void a(boolean r0) {
        f7641a = r0;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
