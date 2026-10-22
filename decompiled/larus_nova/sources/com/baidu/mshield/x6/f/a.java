package com.baidu.mshield.x6.f;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.autonavi.amap.mapcore.AMapEngineUtils;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static void a(Context r100) {
        AlarmManager r101 = (AlarmManager) r100.getSystemService("alarm");     // Catch: Throwable -> L8
        Intent r102 = new Intent("com.baidu.mshield.x6.alarm.work.finger");     // Catch: Throwable -> L8
        r102.setPackage(r100.getPackageName());     // Catch: Throwable -> L8
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r103 = 201326592;
    L6:
        r101.cancel(PendingIntent.getBroadcast(r100, 100, r102, r103));     // Catch: Throwable -> L8
        Intent r104 = new Intent("com.baidu.mshield.x6.alarm.work.zid");     // Catch: Throwable -> L8
        r104.setPackage(r100.getPackageName());     // Catch: Throwable -> L8
        r101.cancel(PendingIntent.getBroadcast(r100, 101, r104, r103));     // Catch: Throwable -> L8
        return;
    L5:
        r103 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L8:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
    }

    public static void b(Context r100) {
        AlarmManager r101 = (AlarmManager) r100.getSystemService("alarm");     // Catch: Throwable -> L14
        Intent r102 = new Intent("com.baidu.mshield.x6.alarm.work.finger");     // Catch: Throwable -> L14
        r102.setPackage(r100.getPackageName());     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 23) goto L6;
        int r103 = 201326592;
    L7:
        PendingIntent r104 = PendingIntent.getBroadcast(r100, 100, r102, r103);     // Catch: Throwable -> L14
        r101.cancel(r104);     // Catch: Throwable -> L10
    L12:
        int r105 = new com.baidu.mshield.x6.b.b(r100).b();     // Catch: Throwable -> L14
        com.baidu.mshield.b.c.a.b("finger alarm interval=" + r105 + " Min");     // Catch: Throwable -> L14
        r101.set(1, System.currentTimeMillis() + (((long) r105) * 60000), r104);     // Catch: Throwable -> L14
        return;
    L10:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L14
        goto L12
    L6:
        r103 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L14:
        th = move-exception;
        f.b(th);
    }

    public static void c(Context r100) {
        AlarmManager r101 = (AlarmManager) r100.getSystemService("alarm");     // Catch: Throwable -> L14
        Intent r102 = new Intent("com.baidu.mshield.x6.alarm.work.zid");     // Catch: Throwable -> L14
        r102.setPackage(r100.getPackageName());     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 23) goto L6;
        int r103 = 201326592;
    L7:
        PendingIntent r104 = PendingIntent.getBroadcast(r100, 101, r102, r103);     // Catch: Throwable -> L14
        r101.cancel(r104);     // Catch: Throwable -> L10
    L12:
        com.baidu.mshield.b.c.a.b("zid alarm interval=" + com.baidu.mshield.x6.e.a.a(r100) + " HOUR");     // Catch: Throwable -> L14
        r101.set(1, System.currentTimeMillis() + (((long) com.baidu.mshield.x6.e.a.a(r100)) * 3600000), r104);     // Catch: Throwable -> L14
        return;
    L10:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L14
        goto L12
    L6:
        r103 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L14:
        th = move-exception;
        f.b(th);
    }
}
