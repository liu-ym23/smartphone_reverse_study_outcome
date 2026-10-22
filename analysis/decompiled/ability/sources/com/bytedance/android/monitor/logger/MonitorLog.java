package com.bytedance.android.monitor.logger;

import D.a;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class MonitorLog {

    /* renamed from: a, reason: collision with root package name */
    public static a f2210a = null;
    public static boolean b = false;

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "hybrid_monitor" : !str.startsWith("hybrid_monitor_") ? "hybrid_monitor_".concat(str) : str;
    }

    public static void d(@NonNull String str, @NonNull String str2) {
        if (isLogEnable()) {
            Log.d(a(str), str2);
        }
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        Log.e(a(str), str2);
    }

    public static void i(@NonNull String str, @NonNull String str2) {
        if (isLogEnable()) {
            Log.i(a(str), str2);
        }
    }

    public static boolean isLogEnable() {
        return b;
    }

    public static void setLogEnable(boolean z10) {
        b = z10;
    }

    public static void setLogger(@Nullable a aVar) {
    }

    public static void v(@NonNull String str, @NonNull String str2) {
        if (isLogEnable()) {
            Log.v(a(str), str2);
        }
    }

    public static void w(@NonNull String str, @NonNull String str2) {
        if (isLogEnable()) {
            Log.w(a(str), str2);
        }
    }

    public static void e(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        if (isLogEnable()) {
            Log.e(a(str), str2, th);
        }
    }
}
