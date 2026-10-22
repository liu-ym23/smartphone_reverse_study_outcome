package com.bytedance.apm.util;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f6679a = -1;

    static {
    }

    public static boolean a() {
        return false;
    }

    public static int b(Context r10) {
        if (f6679a != (-1)) goto L12;
        PackageManager r11 = r10.getApplicationContext().getPackageManager();
        PackageInfo r12 = r11.getPackageInfo(r10.getApplicationContext().getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r12 == null) goto L12;
        f6679a = r12.applicationInfo.uid;     // Catch: PackageManager.NameNotFoundException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return f6679a;
    }

    public static long c(Context r10, long r11, long r13, int r15) {
        long r12 = 0;
        if (a() == true) goto L5;
        return 0;
    L5:
        NetworkStatsManager r14 = (NetworkStatsManager) r10.getApplicationContext().getSystemService("netstats");
        if (r14 != null) goto L8;
        return 0;
    L8:
        NetworkStats.Bucket r16 = new NetworkStats.Bucket();
        NetworkStats r17 = r14.querySummary(r15, null, r11, r13);     // Catch: Exception -> L11
    L10:
        long r18 = 0;
    L13:
        if (r17 == null) goto L19;
        if (r17.hasNextBucket() == false) goto L19;
        r17.getNextBucket(r16);
        if (b(r10) != r16.getUid()) goto L13;
        r12 = r12 + r16.getRxBytes();
        r18 = r18 + r16.getTxBytes();
    L19:
        if (r17 == null) goto L22;
        r17.close();
    L22:
        return r12 + r18;
    L11:
        e = move-exception;
        e.printStackTrace();
        r17 = null;
        goto L10
    }
}
