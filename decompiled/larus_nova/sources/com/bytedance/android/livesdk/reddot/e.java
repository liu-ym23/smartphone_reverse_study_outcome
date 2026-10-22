package com.bytedance.android.livesdk.reddot;

import android.content.Context;
import com.bytedance.android.livesdk.config.v61;
import com.bytedance.android.livesdk.utils.LivePanelsOptUtil;
import j40.b1;
import j40.p3;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f157090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f157091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f157092c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f157093d;

    static {
        f157092c = p3.f497282a.getValue().booleanValue() | ((v61) LivePanelsOptUtil.f158761c.getValue()).b();
    }

    public static long a(Context r100) {
        String r101 = r100.getPackageName();
        long r102 = 0;
    L10:
        e = move-exception;
        e.printStackTrace();
        return r102;
    L4:
        if (b1.f497171a.getValue().g() != true) goto L8;
        long r103 = f157093d;     // Catch: Exception -> L10
        if (r103 == 0) goto L8;
        return r103;
    L8:
        r102 = r100.getPackageManager().getPackageInfo(r101, 0).firstInstallTime;     // Catch: Exception -> L10
        f157093d = r102;     // Catch: Exception -> L10
        return r102;
    }

    public static long b(Context r100) {
        String r101 = r100.getPackageName();
        b1.f497171a.getValue().getClass();     // Catch: Exception -> L5
        return r100.getPackageManager().getPackageInfo(r101, 0).lastUpdateTime;
    L5:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }
}
