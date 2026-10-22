package com.baidu.xclient.gdid.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.xclient.gdid.d;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f33600a = 60000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f33601b = 3600000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f33602c = 86400000;

    public static void a(Context r100, long r101) {
        if (r101 > 0) goto L14;
        return;
    L14:
        AlarmManager r102 = (AlarmManager) r100.getSystemService("alarm");     // Catch: Throwable -> L11
        Intent r103 = new Intent(b.f33603a);     // Catch: Throwable -> L11
        r103.setPackage(d.a().a(r100));     // Catch: Throwable -> L11
        if (Build.VERSION.SDK_INT < 23) goto L8;
        int r104 = 201326592;
    L9:
        PendingIntent r105 = PendingIntent.getBroadcast(r100, 100, r103, r104);     // Catch: Throwable -> L11
        r102.cancel(r105);     // Catch: Throwable -> L11
        r102.set(1, System.currentTimeMillis() + r101, r105);     // Catch: Throwable -> L11
        return;
    L8:
        r104 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L11:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
    }
}
