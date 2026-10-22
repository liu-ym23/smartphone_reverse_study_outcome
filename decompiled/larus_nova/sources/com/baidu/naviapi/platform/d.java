package com.baidu.naviapi.platform;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes39.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f32668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SharedPreferences.Editor f32669b;

    public static void a(Context r100) {
        SharedPreferences r101 = r100.getSharedPreferences("bd_navi_api", 0);
        f32668a = r101;
        f32669b = r101.edit();
    }

    public static String a(String r100) {
        return f32668a.getString(r100, "");
    }

    public static void a(String r100, String r101) {
        f32669b.putString(r100, r101);
        f32669b.commit();
    }
}
