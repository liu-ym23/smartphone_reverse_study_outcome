package com.obric.capabilitykit.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32043a = null;

    static {
        f32043a = new b();
    }

    private b() {
    }

    private final boolean a(PackageManager r2, ComponentName r3) {
        boolean r1 = false;
        r1 = r2.getActivityInfo(r3, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L5 Exception -> L11
    L14:
    L5:
        r1 = r2.getServiceInfo(r3, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L7 Exception -> L11
    L7:
        r1 = r2.getReceiverInfo(r3, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L9 Exception -> L11
    L9:
        r1 = r2.getProviderInfo(r3, 0).enabled;     // Catch: Exception -> L11
    L10:
        return r1;
    }

    private final boolean a(PackageManager r2, String r3) {
        ApplicationInfo r1 = r2.getApplicationInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        d.h.b.o.c(r1, "pm.getApplicationInfo(packageName, 0)");     // Catch: PackageManager.NameNotFoundException -> L6
        return true ^ r1.enabled;
    L9:
        return true;
    }

    public final boolean a(Context r4, ComponentName r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        d.h.b.o.e(r5, "componentName");
        PackageManager r7 = r6.getPackageManager();
        d.h.b.o.c(r7, "pm");
        String r0 = r5.getPackageName();
        d.h.b.o.c(r0, "componentName.packageName");
        if (a(r7, r0) == false) goto L5;
        return false;
    L5:
        int r1 = r7.getComponentEnabledSetting(r5);
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L12;
        return false;
    L12:
        return true;
    L11:
        return a(r7, r5);
    }
}
