package com.bytedance.watson.assist.d;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: DebugLog.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "watson_assist";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11871a;

    static {
        f11871a = a(TAG, 3);
    }

    public static void a(String r1) {
        a(TAG, r1);
    }

    public static void b(String r1) {
        c(TAG, r1);
    }

    public static void c(String r1) {
        e(TAG, r1);
    }

    public static void d(String r1) {
        g(TAG, r1);
    }

    public static void a(String r1, String r2) {
        if (f11871a == false) goto L6;
        b(r1, r2);
        return;
    }

    public static void c(String r0, String r1) {
        d(r0, r1);
    }

    public static void e(String r0, String r1) {
        f(r0, r1);
    }

    public static void g(String r0, String r1) {
        h(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int f(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int h(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
