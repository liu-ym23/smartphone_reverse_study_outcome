package com.bytedance.android.gamecp.common.utils;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes44.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f57198a;

    public static SharedPreferences b() {
        if (f57198a != null) goto L6;
        f57198a = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext().getSharedPreferences("xi_gua_live_sp", 0);
    L6:
        return f57198a;
    }

    public static SharedPreferences.Editor a() {
        return b().edit();
    }
}
