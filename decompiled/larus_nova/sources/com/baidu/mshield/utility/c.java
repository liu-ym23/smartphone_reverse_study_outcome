package com.baidu.mshield.utility;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f32453a;

    public static String e(Context r100) {
        return "";
    }

    public static String f(Context r100) {
        return "";
    }

    public c() {
    }

    public static String a() {
        return Build.DISPLAY;
    }

    public static String a(String r100) {
        String r101 = new String(com.baidu.mshield.b.f.a.a(Base64.decode(r100, 10), com.baidu.mshield.b.f.a.a(16)), "UTF-8");     // Catch: Throwable -> L5
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return r101;
    L11:
        return "";
    L5:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return "";
    }

    public static synchronized String b(Context r100) {
        monitor-enter(c.class);
    L40:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L44
        return "";
    L44:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(f32453a) == true) goto L10;
        String r101 = f32453a;     // Catch: Throwable -> L40
        monitor-exit(c.class);
        return r101;
    L10:
        String r102 = a(r100, false);     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r102) == true) goto L15;
        f32453a = r102;     // Catch: Throwable -> L40
        monitor-exit(c.class);
        return r102;
    L15:
        com.baidu.mshield.sharedpreferences.a r103 = com.baidu.mshield.sharedpreferences.a.a(r100);     // Catch: Throwable -> L40
        String r104 = r103.q();     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r104) == false) goto L49;
    L24:
        String r105 = r103.n();     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r105) == true) goto L29;
        r103.i(new String(Base64.encode(com.baidu.mshield.b.f.a.b(r105.getBytes("UTF-8"), com.baidu.mshield.b.f.a.a(16)), 10), "UTF-8"));     // Catch: Throwable -> L40
        f32453a = r105;     // Catch: Throwable -> L40
        monitor-exit(c.class);
        return r105;
    L29:
        String r106 = c(r100);     // Catch: Throwable -> L40
        String r107 = e(r100);     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r107) == false) goto L32;
        r107 = "0";
    L32:
        String r108 = r106 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + new StringBuffer(r107).reverse().toString();     // Catch: Throwable -> L40
        String r109 = new String(Base64.encode(com.baidu.mshield.b.f.a.b(r108.getBytes("UTF-8"), com.baidu.mshield.b.f.a.a(16)), 10), "UTF-8");     // Catch: Throwable -> L40
        String r110 = r103.n();     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r110) == false) goto L37;
        r103.h(r108);     // Catch: Throwable -> L40
        r103.i(r109);     // Catch: Throwable -> L40
        f32453a = r108;     // Catch: Throwable -> L40
        monitor-exit(c.class);
        return r108;
    L37:
        f32453a = r110;     // Catch: Throwable -> L40
        monitor-exit(c.class);
        return r110;
    L49:
        String r111 = a(r104);     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r111) == true) goto L24;
        f32453a = r111;     // Catch: Throwable -> L22
        monitor-exit(c.class);
        return r111;
    L22:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L40
        goto L24
    }

    public static String c(Context r100) {
        String r101 = "";
        String r102 = e(r100);     // Catch: Throwable -> L8
        r101 = a(r100);     // Catch: Throwable -> L6
    L12:
        return a((r102 + r101 + UUID.randomUUID().toString()).getBytes(), true);
    L6:
        th = th;
    L10:
        com.baidu.mshield.b.c.a.a(th);
    L8:
        th = th;
        r102 = "";
        goto L10
    }

    public static String d(Context r100) {
    L8:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        goto L10
    L4:
        if (TextUtils.isEmpty(com.baidu.sec.privacy.e.a.a(r100).c("bd_setting_i", true)) == false) goto L6;
        e(r100);     // Catch: Throwable -> L8 Exception -> L11
    L6:
        TextUtils.isEmpty(e(r100));     // Catch: Throwable -> L8
        return "";
    L10:
        return "";
    }

    public static String g(Context r100) {
        Display r101 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();     // Catch: Throwable -> L8
        DisplayMetrics r102 = new DisplayMetrics();     // Catch: Throwable -> L8
        r101.getMetrics(r102);     // Catch: Throwable -> L8
        if (r102.widthPixels >= r102.heightPixels) goto L7;
        return r102.widthPixels + "*" + r102.heightPixels;
    L7:
        return r102.heightPixels + "*" + r102.widthPixels;
    L8:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return "";
    }

    public static String h(Context r100) {
        com.baidu.mshield.sharedpreferences.a r101 = com.baidu.mshield.sharedpreferences.a.a(r100);     // Catch: Throwable -> L23
        String r102 = r101.f();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r102) == true) goto L7;
        return r102;
    L7:
        if (Build.VERSION.SDK_INT <= 25) goto L9;
        return "";
    L9:
        String r103 = e(r100);     // Catch: Throwable -> L23
        String r104 = a(r100);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r103) == true) goto L12;
    L14:
        byte[] r105 = (r103 + ":" + r104).getBytes();     // Catch: Throwable -> L23
        int r106 = 0;
    L16:
        if (r106 >= r105.length) goto L18;
        r105[r106] = (byte) (r105[r106] ^ 246);     // Catch: Throwable -> L23
        r106 = r106 + 1;     // Catch: Throwable -> L23
        goto L16
    L18:
        String r107 = com.baidu.mshield.b.f.e.c(r105);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r107) == false) goto L21;
        return "";
    L21:
        r101.o(r107);     // Catch: Throwable -> L23
        return r107;
    L12:
        if (TextUtils.isEmpty(r104) == false) goto L14;
        return "";
    L23:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return "";
    }

    public static String i(Context r100) {
        if (TextUtils.isEmpty(com.baidu.mshield.b.e.a.d(r100, "bd_setting_i")) == false) goto L6;
        e(r100);     // Catch: Throwable -> L8
    L6:
        TextUtils.isEmpty(e(r100));
    L7:
        return "";
    }

    public static String j(Context r100) {
        String r101 = a(r100);     // Catch: Throwable -> L25
        String r102 = com.baidu.sec.privacy.e.a.a(r100).c("bd_setting_i", true);     // Catch: Throwable -> L12
    L10:
        th = th;
    L14:
        com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L25
    L15:
        String r103 = com.baidu.sec.privacy.e.a.a(r100).c("com.baidu.deviceid", true);     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r103) == false) goto L18;
        r103 = com.baidu.sec.privacy.e.a.a(r100).c(a(("com.baidu" + r102 + r101).getBytes(), true), true);     // Catch: Throwable -> L25
    L18:
        if (r103 != null) goto L20;
        return "";
    L20:
        String r104 = e(r100);     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r104) == false) goto L23;
        r104 = "0";
    L23:
        return r103 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + new StringBuffer(r104).reverse().toString();
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L15;
        r102 = e(r100);     // Catch: Throwable -> L10
    L12:
        th = th;
        r102 = "";
    L25:
        return "";
    }

    public static String a(Context r100) {
        return com.baidu.mshield.core.a.a("arid");
    }

    public static String a(Context r100, boolean r101) {
        Bundle r102 = g.a(r100, "getRemoteZid", null, r101, null, false);     // Catch: Throwable -> L7
        if (r102 == null) goto L13;
        String r103 = r102.getString("_zid");     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r103) == true) goto L14;
        return r103;
    L14:
        return "";
    L13:
        return "";
    L7:
        th = move-exception;
        a.a(th);
        return "";
    }

    public static String a(byte[] r100, boolean r101) {
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L4
        r102.reset();     // Catch: NoSuchAlgorithmException -> L4
        r102.update(r100);     // Catch: NoSuchAlgorithmException -> L4
        return a(r102.digest(), "", r101);
    L4:
        e = move-exception;
        com.baidu.mshield.b.c.a.a(e);
        return null;
    }

    public static String a(byte[] r100, String r101, boolean r102) {
        StringBuilder r103 = new StringBuilder();
        int r104 = r100.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L12;
        String r106 = Integer.toHexString(r100[r105] & UByte.MAX_VALUE);
        if (r102 == false) goto L8;
        r106 = r106.toUpperCase();
    L8:
        if (r106.length() != 1) goto L10;
        r103.append("0");
    L10:
        r103.append(r106);
        r103.append(r101);
        r105 = r105 + 1;
        goto L3
    L12:
        return r103.toString();
    }
}
