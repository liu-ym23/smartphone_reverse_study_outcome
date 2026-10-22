package com.baidu.mshield.x0.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f32478a;

    public static void a(Context r100) {
        AlarmManager r101 = (AlarmManager) r100.getSystemService("alarm");     // Catch: Throwable -> L8
        Intent r102 = new Intent("com.baidu.mshield.x0.alarm.action");     // Catch: Throwable -> L8
        r102.setPackage(r100.getPackageName());     // Catch: Throwable -> L8
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r103 = 201326592;
    L6:
        r101.cancel(PendingIntent.getBroadcast(r100, 100, r102, r103));     // Catch: Throwable -> L8
        return;
    L5:
        r103 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L8:
        th = move-exception;
        d.a(th);
    }

    public static int b(Context r100) {
        String r101 = new com.baidu.mshield.x0.l.a(r100).c("plc33");     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r101) == true) goto L9;
        return new JSONObject(r101).optJSONObject("5").optInt("t", 60);
    L9:
        return 60;
    L7:
        th = move-exception;
        d.a(th);
        goto L9
    }

    public static void c(Context r100) {
        int r101 = new com.baidu.mshield.x0.l.a(r100).b();
        if (r101 != 0) goto L5;
        r101 = 24;
    L5:
        a(r100, "com.baidu.mshield.x0.detect.app.fr", ((long) r101) * 3600000, 1);
    }

    public static void a(Context r100, long r101) {
        AlarmManager r102 = (AlarmManager) r100.getSystemService("alarm");     // Catch: Throwable -> L13
        Intent r103 = new Intent("com.baidu.mshield.x0.alarm.action");     // Catch: Throwable -> L13
        r103.setPackage(r100.getPackageName());     // Catch: Throwable -> L13
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r104 = 201326592;
    L6:
        PendingIntent r105 = PendingIntent.getBroadcast(r100, 100, r103, r104);     // Catch: Throwable -> L13
        r102.cancel(r105);     // Catch: Throwable -> L9
    L11:
        r102.set(1, System.currentTimeMillis() + r101, r105);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L13
        goto L11
    L5:
        r104 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L13:
        th = move-exception;
        d.a(th);
    }

    public static void a(Context r100, com.baidu.mshield.x0.l.a r101) {
        if (r101 != null) goto L4;
        r101 = new com.baidu.mshield.x0.l.a(r100);
    L4:
        a(r100, "com.baidu.mshield.x0.timer.pp.action", ((long) r101.m()) * 60000, 0);
    }

    public static void a(Context r100, boolean r101) {
        f32478a = r101;
        a(r100, new com.baidu.mshield.x0.l.a(r100));
        c(r100);
        f32478a = false;
    }

    public static void a(Context r100, String r101, long r102, int r103) {
        long r104 = System.currentTimeMillis() + r102;     // Catch: Throwable -> L11
        a r105 = new a();     // Catch: Throwable -> L11
        r105.f32475a = r101;     // Catch: Throwable -> L11
        r105.f32477c = r104;     // Catch: Throwable -> L11
        r105.f32476b = r103;     // Catch: Throwable -> L11
        a r106 = com.baidu.mshield.x0.f.a.a(r100).a(r101);     // Catch: Throwable -> L11
        if (r106 == null) goto L9;
        long r107 = r106.f32477c;     // Catch: Throwable -> L11
        long r108 = new com.baidu.mshield.x0.l.a(r100).n();     // Catch: Throwable -> L11
        if (f32478a == true) goto L9;
        if (r107 < r108) goto L9;
        r105.f32477c = r107;     // Catch: Throwable -> L11
    L9:
        com.baidu.mshield.x0.f.a.a(r100).a(r105);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        d.a(th);
    }
}
