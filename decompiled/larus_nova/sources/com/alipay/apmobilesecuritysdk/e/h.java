package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.UUID;

/* JADX INFO: loaded from: classes28.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f25103a = "";

    public h() {
    }

    public static long a(Context r100) {
        String r101 = com.alipay.sdk.m.b0.a.a(r100, "vkeyid_settings", "update_time_interval");
        if (com.alipay.sdk.m.z.a.b(r101) == false) goto L9;
        return CastLongProtector.parseLong(r101);
    L10:
        return 86400000;
    L9:
        return 86400000;
    }

    public static void a(Context r100, String r101) {
        a(r100, "update_time_interval", r101);
    }

    public static void a(Context r100, String r101, long r102) {
        com.alipay.sdk.m.b0.a.a(r100, "vkeyid_settings", "vkey_valid" + r101, String.valueOf(r102));
    }

    public static void a(Context r100, String r101, String r102) {
        com.alipay.sdk.m.b0.a.a(r100, "vkeyid_settings", r101, r102);
    }

    public static void a(Context r100, boolean r101) {
        if (r101 == false) goto L4;
        String r102 = "1";
    L5:
        a(r100, "log_switch", r102);
        return;
    L4:
        r102 = "0";
        goto L5
    }

    public static String b(Context r100) {
        return com.alipay.sdk.m.b0.a.a(r100, "vkeyid_settings", "last_apdid_env");
    }

    public static void b(Context r100, String r101) {
        a(r100, "last_machine_boot_time", r101);
    }

    public static void c(Context r100, String r101) {
        a(r100, "last_apdid_env", r101);
    }

    public static boolean c(Context r100) {
        String r101 = com.alipay.sdk.m.b0.a.a(r100, "vkeyid_settings", "log_switch");
        if (r101 != null) goto L5;
        return false;
    L5:
        if ("1".equals(r101) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static String d(Context r100) {
        return com.alipay.sdk.m.b0.a.a(r100, "vkeyid_settings", "dynamic_key");
    }

    public static void d(Context r100, String r101) {
        a(r100, "agent_switch", r101);
    }

    public static String e(Context r100) {
        return com.alipay.sdk.m.b0.a.a(r100, "vkeyid_settings", "apse_degrade");
    }

    public static void e(Context r100, String r101) {
        a(r100, "dynamic_key", r101);
    }

    public static String f(Context r100) {
        monitor-enter(h.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (com.alipay.sdk.m.z.a.a(f25103a) == false) goto L15;
        String r101 = com.alipay.sdk.m.b0.e.a(r100, "alipay_vkey_random", "random", "");     // Catch: Throwable -> L18
        f25103a = r101;     // Catch: Throwable -> L18
        if (com.alipay.sdk.m.z.a.a(r101) == false) goto L15;
        String r102 = com.alipay.sdk.m.y.b.a(UUID.randomUUID().toString());     // Catch: Throwable -> L18
        f25103a = r102;     // Catch: Throwable -> L18
        if (r102 == null) goto L15;
        SharedPreferences.Editor r103 = r100.getSharedPreferences("alipay_vkey_random", 0).edit();     // Catch: Throwable -> L18
        if (r103 == null) goto L15;
        r103.putString("random", r102);     // Catch: Throwable -> L18
        r103.commit();     // Catch: Throwable -> L18
    L15:
        String r104 = f25103a;     // Catch: Throwable -> L18
        monitor-exit(h.class);     // Catch: Throwable -> L18
        return r104;
    }

    public static void f(Context r100, String r101) {
        a(r100, "webrtc_url", r101);
    }

    public static void g(Context r100, String r101) {
        a(r100, "apse_degrade", r101);
    }

    public static long h(Context r100, String r101) {
        String r102 = com.alipay.sdk.m.b0.a.a(r100, "vkeyid_settings", "vkey_valid" + r101);     // Catch: Throwable -> L8
        if (com.alipay.sdk.m.z.a.a(r102) == false) goto L6;
        return 0;
    L6:
        return Long.parseLong(r102);
    L8:
        return 0;
    }
}
