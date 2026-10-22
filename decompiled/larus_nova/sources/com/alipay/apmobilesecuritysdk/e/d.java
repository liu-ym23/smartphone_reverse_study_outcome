package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class d {
    public static c a(String r100) {
    L6:
        e = move-exception;
        com.alipay.apmobilesecuritysdk.c.a.a(e);
    L8:
        return null;
    L3:
        if (com.alipay.sdk.m.z.a.a(r100) == true) goto L8;
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L6
        return new c(r101.optString("apdid"), r101.optString("deviceInfoHash"), r101.optString("timestamp"), r101.optString("tid"), r101.optString(com.alipay.sdk.m.l.b.f25485g));
    }

    public static synchronized void a() {
        monitor-enter(d.class);
        monitor-exit(d.class);
    }

    public static synchronized void a(Context r100) {
        monitor-enter(d.class);
        com.alipay.apmobilesecuritysdk.f.a.a(r100, "vkeyid_profiles_v4", "key_deviceid_v4", "");     // Catch: Throwable -> L7
        com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", "");     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(Context r100, c r101) {
        monitor-enter(d.class);
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L17 Exception -> L19
        r102.put("apdid", r101.f25093a);     // Catch: Throwable -> L17 Exception -> L19
        r102.put("deviceInfoHash", r101.f25094b);     // Catch: Throwable -> L17 Exception -> L19
        r102.put("timestamp", r101.f25095c);     // Catch: Throwable -> L17 Exception -> L19
        r102.put("tid", r101.f25096d);     // Catch: Throwable -> L17 Exception -> L19
        r102.put(com.alipay.sdk.m.l.b.f25485g, r101.f25097e);     // Catch: Throwable -> L17 Exception -> L19
        String r103 = r102.toString();     // Catch: Throwable -> L17 Exception -> L19
        com.alipay.apmobilesecuritysdk.f.a.a(r100, "vkeyid_profiles_v4", "key_deviceid_v4", r103);     // Catch: Throwable -> L17 Exception -> L19
        com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", r103);     // Catch: Throwable -> L17 Exception -> L19
        monitor-exit(d.class);
        return;
    L17:
        th = move-exception;
        throw th;
    L19:
        e = move-exception;
        com.alipay.apmobilesecuritysdk.c.a.a(e);     // Catch: Throwable -> L17
    }

    public static synchronized c b() {
        monitor-enter(d.class);
        String r100 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");     // Catch: Throwable -> L12
        if (com.alipay.sdk.m.z.a.a(r100) == false) goto L9;
        monitor-exit(d.class);
        return null;
    L9:
        c r101 = a(r100);     // Catch: Throwable -> L12
        monitor-exit(d.class);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized c b(Context r100) {
        monitor-enter(d.class);
        String r101 = com.alipay.apmobilesecuritysdk.f.a.a(r100, "vkeyid_profiles_v4", "key_deviceid_v4");     // Catch: Throwable -> L10
        if (com.alipay.sdk.m.z.a.a(r101) == false) goto L7;
        r101 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");     // Catch: Throwable -> L10
    L7:
        c r102 = a(r101);     // Catch: Throwable -> L10
        monitor-exit(d.class);
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized c c(Context r100) {
        monitor-enter(d.class);
        String r101 = com.alipay.apmobilesecuritysdk.f.a.a(r100, "vkeyid_profiles_v4", "key_deviceid_v4");     // Catch: Throwable -> L12
        if (com.alipay.sdk.m.z.a.a(r101) == false) goto L9;
        monitor-exit(d.class);
        return null;
    L9:
        c r102 = a(r101);     // Catch: Throwable -> L12
        monitor-exit(d.class);
        return r102;
    L12:
        th = move-exception;
        throw th;
    }
}
