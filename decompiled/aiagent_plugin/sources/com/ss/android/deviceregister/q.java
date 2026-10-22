package com.ss.android.deviceregister;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MigrateDetector.java */
/* JADX INFO: loaded from: classes4.dex */
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f37444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackageManager f37445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComponentName f37446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f37447d;

    private static String a(int r1) {
        if (r1 != 0) goto L4;
        return "STATE_DEFAULT";
    L4:
        if (r1 != 1) goto L6;
        return "STATE_ENABLED";
    L6:
        if (r1 == 2) goto L9;
        return "UNKNOWN";
    L9:
        return "STATE_DISABLED";
    }

    q(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        this.f37444a = r0.getSharedPreferences("device_register_migrate_detector", 0);
        this.f37445b = r0.getPackageManager();
        this.f37446c = new ComponentName(r5, AActivity.class);
        boolean r6 = d();
        this.f37447d = r6;
        o.b(o.f37441a, "MigrateDetector#constructor migrate=" + r6);
    }

    void a() {
        o.b(o.f37441a, "MigrateDetector#disableComponent");
        ZeusTransformUtils.setComponentEnabledSetting(this.f37445b, this.f37446c, 2, 1);
        this.f37444a.edit().putInt("component_state", 2).apply();
    }

    boolean b() {
        return this.f37447d;
    }

    private int c() {
        return this.f37445b.getComponentEnabledSetting(this.f37446c);
    }

    private boolean d() {
        int r0 = c();
        int r5 = this.f37444a.getInt("component_state", 0);
        o.b(o.f37441a, "MigrateDetector#isMigrateInternal cs=" + a(r0) + " ss=" + a(r5));
        if (r0 == 0) goto L5;
    L8:
        return false;
    L5:
        if (r5 != 2) goto L8;
        return true;
    }
}
