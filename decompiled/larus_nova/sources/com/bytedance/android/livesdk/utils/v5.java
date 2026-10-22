package com.bytedance.android.livesdk.utils;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes11.dex */
public final class v5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f159193a;

    public static SharedPreferences b() {
        if (f159193a != null) goto L6;
        f159193a = jc1.a.b().getSharedPreferences("xi_gua_live_sp", 0);
    L6:
        return f159193a;
    }

    public static SharedPreferences.Editor a() {
        return b().edit();
    }
}
