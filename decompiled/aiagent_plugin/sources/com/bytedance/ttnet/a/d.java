package com.bytedance.ttnet.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: ImageStrategyController.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f11267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f11268b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile SharedPreferences f11269d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Context f11270c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f11271e;
    private volatile long f;
    private volatile int g;
    private volatile int h;

    static {
        f11268b = new Object();
    }

    public static d a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f11267a != null) goto L15;
        Object r0 = f11268b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11267a != null) goto L9;
        f11267a = new d(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return f11267a;
    }

    private d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        this.f11270c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    L5:
        b();
    }

    public static d a() {
        return f11267a;
    }

    private void b() {
        SharedPreferences r0 = c();     // Catch: Throwable -> L4
        this.f11271e = r0.getInt("image_opt_switch", 0);     // Catch: Throwable -> L4
        this.f = r0.getLong("image_opt_black_interval", 0);     // Catch: Throwable -> L4
        this.g = r0.getInt("image_opt_failed_times", 0);     // Catch: Throwable -> L4
        this.h = r0.getInt("image_opt_limit_count", 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void a(JSONObject r12) {
        if (r12 == null) goto L26;
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r12.length() <= 0) goto L27;
        int r5 = r12.optInt("image_opt_switch", 0);     // Catch: Throwable -> L21
        long r6 = r12.optLong("image_opt_black_interval", 0);     // Catch: Throwable -> L21
        int r8 = r12.optInt("image_opt_failed_times", 0);     // Catch: Throwable -> L21
        int r13 = r12.optInt("image_opt_limit_count", 0);     // Catch: Throwable -> L21
        SharedPreferences.Editor r4 = c().edit();     // Catch: Throwable -> L21
        if (r5 == this.f11271e) goto L11;
        r4.putInt("image_opt_switch", r5);     // Catch: Throwable -> L21
    L11:
        if (r6 == this.f) goto L14;
        r4.putLong("image_opt_black_interval", r6);     // Catch: Throwable -> L21
    L14:
        if (r8 == this.g) goto L17;
        r4.putInt("image_opt_failed_times", r8);     // Catch: Throwable -> L21
    L17:
        if (r13 == this.h) goto L19;
        r4.putInt("image_opt_limit_count", r13);     // Catch: Throwable -> L21
    L19:
        r4.apply();     // Catch: Throwable -> L21
        this.f11271e = r5;     // Catch: Throwable -> L21
        this.f = r6;     // Catch: Throwable -> L21
        this.g = r8;     // Catch: Throwable -> L21
        this.h = r13;     // Catch: Throwable -> L21
        return;
    L27:
        return;
    }

    private SharedPreferences c() {
        if (f11269d != null) goto L6;
        f11269d = this.f11270c.getSharedPreferences("image_opt_table", 0);
    L6:
        return f11269d;
    }
}
