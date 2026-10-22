package com.obric.agent.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PackageParseHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class t {
    private static final String TAG = "[PackageParseHelper]";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f16075a = null;

    static {
        f16075a = new t();
    }

    private t() {
    }

    public final boolean a(Context r2, String r3, String r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        d.h.b.o.e(r3, "packageName");
        d.h.b.o.e(r4, "serviceName");
        PackageManager r5 = r1.getPackageManager();
        ServiceInfo r6 = r5.getServiceInfo(new ComponentName(r3, r4), 0);     // Catch: Throwable -> L5
        d.h.b.o.c(r6, "getServiceInfo(...)");     // Catch: Throwable -> L5
        return r6.enabled;
    L8:
        return false;
    }

    public final boolean b(Context r6, String r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "context");
        d.h.b.o.e(r7, "packageName");
        d.h.b.o.e(r8, "activityName");
        PackageManager r10 = r9.getPackageManager();
        ComponentName r2 = new ComponentName(r7, r8);     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L10
        ActivityInfo r11 = r10.getActivityInfo(r2, 0);     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L10
        d.h.b.o.c(r11, "getActivityInfo(...)");     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L10
        int r12 = r10.getComponentEnabledSetting(r2);     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L10
        ISecureLogDepend.Companion.i(TAG, "isActivityEnabled, componentName: " + r2 + ", enabled: " + r11.enabled + ", isEnable: " + r11.isEnabled() + ", componentEnabledSetting: " + r12 + ", activityInfo: " + r11);     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L10
    L5:
        if (r12 == 0) goto L16;
        if (r12 == 1) goto L16;
        return false;
    L16:
        return true;
    L10:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "isActivityEnabled, e: " + e);
        return false;
    L8:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "isActivityEnabled, e: " + e);
        return false;
    }
}
