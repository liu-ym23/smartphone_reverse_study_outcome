package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class x {
    public static SharedPreferences b(Context r100) {
        String r101 = null;
        if (r100 != null) goto L5;
    L15:
        return null;
    L5:
        if (r100.getApplicationContext() == null) goto L15;
        hh2.f.a r102 = hh2.f.f485165a;
        hh2.g r103 = hh2.f.f485165a.f485167a;
        if (r103 == null) goto L11;
        r101 = r103.i();
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L14;
        r101 = "ec_local_cache_sp";
    L14:
        return r100.getApplicationContext().getSharedPreferences(r101, 0);
    }

    public static long a(Context r100, String r101) {
        SharedPreferences r102 = b(r100);
        if (r102 != null) goto L5;
    L8:
        return 0;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L8;
        return r102.getLong(r101, 0);
    }

    public static void c(Context r100, String r101, long r102) {
        SharedPreferences r103 = b(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        SharedPreferences.Editor r104 = r103.edit();
        if (r104 == null) goto L12;
        r104.putLong(r101, r102);
        r104.apply();
        return;
    L12:
        return;
    }
}
