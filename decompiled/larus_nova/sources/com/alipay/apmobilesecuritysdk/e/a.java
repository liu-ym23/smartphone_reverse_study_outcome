package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class a {
    public static b a(String r100) {
    L6:
        e = move-exception;
        com.alipay.apmobilesecuritysdk.c.a.a(e);
    L8:
        return null;
    L3:
        if (com.alipay.sdk.m.z.a.a(r100) == true) goto L8;
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L6
        return new b(r101.optString("apdid"), r101.optString("deviceInfoHash"), r101.optString("timestamp"));
    }

    public static synchronized void a() {
        monitor-enter(a.class);
        monitor-exit(a.class);
    }

    public static synchronized void a(Context r100) {
        monitor-enter(a.class);
        com.alipay.apmobilesecuritysdk.f.a.a(r100, "vkeyid_profiles_v3", "deviceid", "");     // Catch: Throwable -> L7
        com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", "");     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(Context r100, b r101) {
        monitor-enter(a.class);
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L13 Exception -> L15
        r102.put("apdid", r101.f25090a);     // Catch: Throwable -> L13 Exception -> L15
        r102.put("deviceInfoHash", r101.f25091b);     // Catch: Throwable -> L13 Exception -> L15
        r102.put("timestamp", r101.f25092c);     // Catch: Throwable -> L13 Exception -> L15
        String r103 = r102.toString();     // Catch: Throwable -> L13 Exception -> L15
        com.alipay.apmobilesecuritysdk.f.a.a(r100, "vkeyid_profiles_v3", "deviceid", r103);     // Catch: Throwable -> L13 Exception -> L15
        com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", r103);     // Catch: Throwable -> L13 Exception -> L15
        monitor-exit(a.class);
        return;
    L13:
        th = move-exception;
        throw th;
    L15:
        e = move-exception;
        com.alipay.apmobilesecuritysdk.c.a.a(e);     // Catch: Throwable -> L13
    }

    public static synchronized b b() {
        monitor-enter(a.class);
        String r100 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");     // Catch: Throwable -> L12
        if (com.alipay.sdk.m.z.a.a(r100) == false) goto L9;
        monitor-exit(a.class);
        return null;
    L9:
        b r101 = a(r100);     // Catch: Throwable -> L12
        monitor-exit(a.class);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized b b(Context r100) {
        monitor-enter(a.class);
        String r101 = com.alipay.apmobilesecuritysdk.f.a.a(r100, "vkeyid_profiles_v3", "deviceid");     // Catch: Throwable -> L10
        if (com.alipay.sdk.m.z.a.a(r101) == false) goto L7;
        r101 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");     // Catch: Throwable -> L10
    L7:
        b r102 = a(r101);     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized b c(Context r100) {
        monitor-enter(a.class);
        String r101 = com.alipay.apmobilesecuritysdk.f.a.a(r100, "vkeyid_profiles_v3", "deviceid");     // Catch: Throwable -> L12
        if (com.alipay.sdk.m.z.a.a(r101) == false) goto L9;
        monitor-exit(a.class);
        return null;
    L9:
        b r102 = a(r101);     // Catch: Throwable -> L12
        monitor-exit(a.class);
        return r102;
    L12:
        th = move-exception;
        throw th;
    }
}
