package com.baidu.sec.privacy.f;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f33534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f33535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f33536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f33537d;

    public static void a(Throwable r100) {
    }

    public static boolean a(Context r100) {
    L22:
        th = move-exception;
        a(th);
        return false;
    L3:
        if (f33534a == true) goto L5;
        if (r100 == null) goto L39;
        Iterator<ActivityManager.RunningAppProcessInfo> r101 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Throwable -> L22
    L9:
        if (r101.hasNext() == false) goto L40;
        ActivityManager.RunningAppProcessInfo r102 = r101.next();     // Catch: Throwable -> L22
        if (r102.importance != 100) goto L9;
        if (r102.importanceReasonCode != 0) goto L9;
        String[] r103 = r102.pkgList;     // Catch: Throwable -> L22
        if (r103 == null) goto L9;
        if (r103.length == 0) goto L9;
        if (Arrays.asList(r103).contains(r100.getPackageName()) == false) goto L9;
        return true;
    L40:
        return false;
    L39:
        return false;
    L5:
        return f33535b;
    }

    public static boolean b(Context r100) {
    L14:
        th = move-exception;
        a(th);
        return false;
    L4:
        if (e.a(r100, new String[]{"android.permission.GET_TASKS"}) == true) goto L6;
        return true;
    L6:
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L14
        if (r101.getRunningTasks(1) != null) goto L9;
        return false;
    L9:
        ActivityManager.RunningTaskInfo r102 = r101.getRunningTasks(1).get(0);     // Catch: Throwable -> L14
        if (r102 != null) goto L12;
        return false;
    L12:
        String r103 = r102.topActivity.getPackageName();     // Catch: Throwable -> L14
        return r100.getPackageName().equals(r103);
    }

    public static boolean c(Context r100) {
        return ((PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).isScreenOn();
    L4:
        th = move-exception;
        a(th);
        return false;
    }

    public static boolean d(Context r100) {
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L14
        if ((r101 - f33536c) >= 1000) goto L7;
        return f33537d;
    L7:
        if (c(r100) == true) goto L9;
    L11:
        boolean r102 = false;
    L12:
        f33537d = r102;     // Catch: Throwable -> L14
        f33536c = r101;     // Catch: Throwable -> L14
    L17:
        return f33537d;
    L9:
        if (a(r100) == false) goto L11;
        r102 = true;
    L14:
        th = move-exception;
        a(th);
        goto L17
    }

    public static void a(boolean r100) {
        f33534a = true;
        f33535b = r100;
    }
}
