package com.ttnet.org.chromium.net;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class TTSocketAccelerate {
    private static final String TAG = "TTSocketAccelerate";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f37870a;

    interface a {
        void a(long r1, TTSocketAccelerate r3, int r4);

        void a(long r1, TTSocketAccelerate r3, int r4, int r5);
    }

    public TTSocketAccelerate() {
        this.f37870a = 0;
    }

    public static TTSocketAccelerate init() {
        return new TTSocketAccelerate();
    }

    public void setNativeDelegate(long r1) {
        this.f37870a = r1;
    }

    public void checkSystemAvailable() {
        if (this.f37870a != 0) goto L6;
        return;
    L6:
        if (Build.MANUFACTURER.toLowerCase().contains("honor") == true) goto L12;
        if (Build.BRAND.toLowerCase().contains("honor") == true) goto L12;
        ad.a().a(this.f37870a, this, -1002);
        return;
    L12:
        if (Build.VERSION.SDK_INT >= 29) goto L15;
        ad.a().a(this.f37870a, this, -1003);
        return;
    L15:
        ad.a().a(this.f37870a, this, 0);
    }

    public void notifyAccelerate(int r13, int r14, int r15) {
        Method r0 = ZeusTransformUtils.forName("com.hihonor.android.emcom.EmcomManagerEx", "com.obric.aiagent.plugin").getMethod("notifyAppInfo", new Class[]{Bundle.class});     // Catch: Throwable -> L4
        a("SA", "notify scene:" + r13 + " value: " + r14 + " fd:" + r15);     // Catch: Throwable -> L4
        Bundle r1 = new Bundle();     // Catch: Throwable -> L4
        r1.putInt("msgType", 49);     // Catch: Throwable -> L4
        r1.putInt(DBHelper.BATTERY_COL_SCENE, 16);     // Catch: Throwable -> L4
        r1.putInt("subscene", r14);     // Catch: Throwable -> L4
        r1.putInt("status", 1);     // Catch: Throwable -> L4
        r1.putInt("accStatus", 3);     // Catch: Throwable -> L4
        r1.putString("KFD", "" + r15);     // Catch: Throwable -> L4
        r0.invoke(null, new Object[]{r1});     // Catch: Throwable -> L4
        ad.a().a(this.f37870a, this, r13, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        ad.a().a(this.f37870a, this, r13, -1000);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
