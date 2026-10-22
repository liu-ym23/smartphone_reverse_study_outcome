package com.bytedance.apm.internal;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f190599a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SharedPreferences f190600b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f190601c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f190602d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f190603e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f190604f = 100;

    public static void a(int r100, boolean r101) {
        if (r101 == false) goto L4;
        f190602d = r100 | f190602d;
        return;
    L4:
        int r102 = f190602d;
        f190602d = (~r100) & r102;
    }
}
