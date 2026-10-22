package com.bytedance.apm.util;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes14.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f190693a = -1;

    public static long a(Context r110, long r111, long r112, int r113) {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 > 22) goto L5;
    L9:
        boolean r101 = false;
    L10:
        long r102 = 0;
        if (r101 == true) goto L13;
        return 0;
    L13:
        NetworkStatsManager r103 = (NetworkStatsManager) r110.getApplicationContext().getSystemService("netstats");
        if (r103 != null) goto L16;
        return 0;
    L16:
        NetworkStats.Bucket r104 = new NetworkStats.Bucket();
        NetworkStats r114 = r103.querySummary(r113, null, r111, r112);     // Catch: Exception -> L19
    L18:
        long r115 = 0;
    L21:
        if (r114 == null) goto L36;
        if (r114.hasNextBucket() == false) goto L36;
        r114.getNextBucket(r104);
        int r116 = r104.getUid();
        if (f190693a != (-1)) goto L34;
        PackageInfo r117 = r110.getApplicationContext().getPackageManager().getPackageInfo(r110.getApplicationContext().getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L31
        if (r117 == null) goto L34;
        f190693a = r117.applicationInfo.uid;     // Catch: PackageManager.NameNotFoundException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L34:
        if (f190693a != r116) goto L21;
        r102 = r102 + r104.getRxBytes();
        r115 = r115 + r104.getTxBytes();
    L36:
        if (r114 == null) goto L39;
        r114.close();
    L39:
        return r102 + r115;
    L19:
        e = move-exception;
        e.printStackTrace();
        r114 = null;
        goto L18
    L5:
        if (r100 >= 28) goto L9;
        if (ContextCompat.checkSelfPermission(com.bytedance.apm.d.getContext(), "android.permission.READ_PHONE_STATE") != 0) goto L9;
        r101 = true;
        goto L10
    }
}
