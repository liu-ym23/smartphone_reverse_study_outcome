package com.bytedance.apm;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class PerfConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f4110a = false;

    static {
    }

    public PerfConfig() {
    }

    public static void setReportMessage() {
        a("PerfConfig", "setReportMessage set true");
        f4110a = true;
    }

    public static boolean a() {
        return f4110a;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
