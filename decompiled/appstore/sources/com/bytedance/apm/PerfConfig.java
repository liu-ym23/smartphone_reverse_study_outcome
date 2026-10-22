package com.bytedance.apm;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class PerfConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6350a = false;

    static {
    }

    public static boolean a() {
        return f6350a;
    }

    public static void setReportMessage() {
        Log.e("PerfConfig", "setReportMessage set true");
        f6350a = true;
    }
}
