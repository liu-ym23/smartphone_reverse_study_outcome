package com.obric.memorydata.sdk.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ComponentEnabledChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33795a = null;

    static {
        f33795a = new a();
    }

    private a() {
    }

    public final boolean a(Context r4, ComponentName r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r5, "componentName");
        PackageManager r7 = r6.getPackageManager();
        o.a(r7);
        String r0 = r5.getPackageName();
        o.c(r0, "getPackageName(...)");
        if (a(r7, r0) == false) goto L5;
        return false;
    L5:
        int r1 = r7.getComponentEnabledSetting(r5);
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 != 2) goto L11;
        return false;
    L11:
        if (r1 != 3) goto L18;
        return false;
    L18:
        return false;
    L19:
        return true;
    L15:
        return a(r7, r5);
    }

    public final boolean a(PackageManager r2, String r3) {
        o.e(r2, "pm");
        o.e(r3, "packageName");
        ApplicationInfo r1 = r2.getApplicationInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        o.c(r1, "getApplicationInfo(...)");     // Catch: PackageManager.NameNotFoundException -> L6
        return true ^ r1.enabled;
    L9:
        return true;
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
}
