package com.bytedance.bdinstall.migrate;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.j.j;
import com.bytedance.bdinstall.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MigrateDetector.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f6379e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PackageManager f6380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentName f6381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f6382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedPreferences f6383d;

    static {
    }

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

    public a(Context r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        this.f6383d = j.a(r6, r5);
        this.f6380a = r0.getPackageManager();
        this.f6381b = new ComponentName(r6, MigrateDetectorActivity.class);
        boolean r7 = d();
        this.f6382c = r7;
        t.a("MigrateDetector#constructor migrate=" + r7);
    }

    public void a() {
        t.a("MigrateDetector#disableComponent");
        ZeusTransformUtils.setComponentEnabledSetting(this.f6380a, this.f6381b, 2, 1);     // Catch: Exception -> L5
        this.f6383d.edit().putInt("component_state", 2).apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        t.b("MigrateDetector#disableComponent error", e);
    }

    public boolean b() {
        return this.f6382c;
    }

    private int c() {
        return this.f6380a.getComponentEnabledSetting(this.f6381b);
    }

    private boolean d() {
        int r0 = f6379e;
        if (r0 == (-1)) goto L14;
    L7:
        int r4 = this.f6383d.getInt("component_state", 0);
        t.a("MigrateDetector#isMigrateInternal cs=" + a(r0) + " ss=" + a(r4));
        if (r0 == 0) goto L10;
    L13:
        return false;
    L10:
        if (r4 != 2) goto L13;
        return true;
    L14:
        r0 = c();     // Catch: Exception -> L6
        f6379e = r0;     // Catch: Exception -> L6
    L6:
        return false;
    }

    public static void a(Context r2, an r3, String r4, boolean r5) {
        SharedPreferences.Editor r6 = j.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3).edit();
        r6.putString("old_did", r4);
        if (r5 == false) goto L5;
        r6.putBoolean("is_migrate", true);
    L6:
        r6.apply();
        return;
    L5:
        r6.remove("is_migrate");
        goto L6
    }

    public static String a(Context r2, an r3) {
        return j.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3).getString("old_did", null);
    }

    public static boolean b(Context r2, an r3) {
        return j.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3).getBoolean("is_migrate", false);
    }
}
