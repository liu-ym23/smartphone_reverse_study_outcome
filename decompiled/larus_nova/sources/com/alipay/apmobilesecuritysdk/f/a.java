package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.os.Environment;
import com.alipay.sdk.m.b0.e;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class a {
    public a() {
    }

    public static String a(Context r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (com.alipay.sdk.m.z.a.a(r101) == false) goto L7;
        return null;
    L7:
        if (com.alipay.sdk.m.z.a.a(r102) == true) goto L19;
        String r103 = e.a(r100, r101, r102, "");     // Catch: Throwable -> L14
        if (com.alipay.sdk.m.z.a.a(r103) == false) goto L12;
        return null;
    L12:
        return com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), r103);
    L20:
        return null;
    L19:
        return null;
    }

    public static String a(String r100, String r101) {
        monitor-enter(a.class);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (com.alipay.sdk.m.z.a.a(r100) == false) goto L7;
    L22:
        monitor-exit(a.class);     // Catch: Throwable -> L24
        return null;
    L7:
        if (com.alipay.sdk.m.z.a.a(r101) == true) goto L22;
        String r102 = com.alipay.sdk.m.b0.b.a(r100);     // Catch: Throwable -> L20
        if (com.alipay.sdk.m.z.a.a(r102) == false) goto L13;
        monitor-exit(a.class);     // Catch: Throwable -> L24
        return null;
    L13:
        String r103 = new JSONObject(r102).getString(r101);     // Catch: Throwable -> L20
        if (com.alipay.sdk.m.z.a.a(r103) == false) goto L17;
        monitor-exit(a.class);     // Catch: Throwable -> L24
        return null;
    L17:
        String r104 = com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), r103);     // Catch: Throwable -> L20
        monitor-exit(a.class);     // Catch: Throwable -> L24
        return r104;
    L21:
        return null;
    }

    public static void a(Context r100, String r101, String r102, String r103) {
        if (com.alipay.sdk.m.z.a.a(r101) == false) goto L5;
        return;
    L5:
        if (com.alipay.sdk.m.z.a.a(r102) == true) goto L14;
        if (r100 == null) goto L15;
        String r104 = com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), r103);     // Catch: Throwable -> L10
        HashMap r105 = new HashMap();     // Catch: Throwable -> L10
        r105.put(r102, r104);     // Catch: Throwable -> L10
        e.a(r100, r101, r105);     // Catch: Throwable -> L10
        return;
    L16:
        return;
    L15:
        return;
    }

    public static void a(String r100, String r101, String r102) {
        monitor-enter(a.class);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (com.alipay.sdk.m.z.a.a(r100) == false) goto L7;
    L28:
        monitor-exit(a.class);     // Catch: Throwable -> L30
        return;
    L7:
        if (com.alipay.sdk.m.z.a.a(r101) == true) goto L28;
        String r103 = com.alipay.sdk.m.b0.b.a(r100);     // Catch: Throwable -> L34
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L34
        if (com.alipay.sdk.m.z.a.b(r103) == true) goto L40;
    L14:
        r104.put(r101, com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), r102));     // Catch: Throwable -> L34
        r104.toString();     // Catch: Throwable -> L34
        System.clearProperty(r100);     // Catch: Throwable -> L33
    L17:
        if (com.alipay.sdk.m.b0.c.a() == false) goto L26;
        String r105 = ".SystemConfig" + File.separator + r100;     // Catch: Throwable -> L34
        if (com.alipay.sdk.m.b0.c.a() == false) goto L26;
        PolarisFileWrapper r106 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), r105);
        if (r106.exists() == false) goto L26;
        if (r106.isFile() == false) goto L26;
        r106.delete();
        goto L26
    L40:
        r104 = new JSONObject(r103);     // Catch: Exception -> L13 Throwable -> L34
    L13:
        r104 = new JSONObject();     // Catch: Throwable -> L34
    L26:
        monitor-exit(a.class);     // Catch: Throwable -> L30
    }
}
