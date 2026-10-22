package com.bytedance.ttnet.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: MultiProcStackOptConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.frameworks.baselib.network.http.cronet.b.i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f11277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f11278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f11281e;
    private long f;
    private long g;
    private Keva h;
    private String i;
    private boolean j;
    private boolean k;
    private Context l;
    private com.bytedance.frameworks.baselib.network.http.cronet.d.b m;

    public static f a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f11277a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11277a != null) goto L9;
        f11277a = new f(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f11277a;
    }

    private f(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        this.f11279c = false;
        this.f11280d = true;
        this.f11281e = -1;
        this.f = 0;
        this.g = 10800;
        this.j = false;
        this.k = false;
        this.m = com.bytedance.frameworks.baselib.network.http.cronet.d.b.f8260c;
        KevaBuilder.getInstance().setContext(r7);
        this.f11278b = com.bytedance.frameworks.baselib.network.http.i.h.b(r7);
        this.h = Keva.getRepo("tt_stack_config", 1);
        this.l = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
    }

    private String a(String r2) {
        return this.i + "_" + r2;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.b.i.c
    public String b() {
        return this.m.toString();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.b.i.c
    public boolean a() {
    L31:
        e = move-exception;
        e.printStackTrace();
        this.m = com.bytedance.frameworks.baselib.network.http.cronet.d.b.g;
        return false;
    L4:
        if (this.j == false) goto L7;
        this.m = com.bytedance.frameworks.baselib.network.http.cronet.d.b.f8258a;     // Catch: Exception -> L31
        return false;
    L7:
        String r3 = com.bytedance.frameworks.baselib.network.http.i.h.d(this.l);     // Catch: Exception -> L31
        this.i = r3;     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r3) == false) goto L11;
        this.m = com.bytedance.frameworks.baselib.network.http.cronet.d.b.f8259b;     // Catch: Exception -> L31
        return false;
    L11:
        this.j = true;     // Catch: Exception -> L31
        this.f11279c = this.h.getBoolean("enable_stack_opt", false);     // Catch: Exception -> L31
        this.f11280d = this.h.getBoolean("enable_stack_opt_fallback_fix", true);     // Catch: Exception -> L31
        this.g = this.h.getLong("stack_opt_fallback_fix_interval_s", 10800);     // Catch: Exception -> L31
        this.f11281e = this.h.getInt(a("stack_opt_failures"), 0);     // Catch: Exception -> L31
        this.f = this.h.getLong(a("stack_opt_failure_timestamp"), 0);     // Catch: Exception -> L31
        if (this.f11280d == false) goto L19;
        if (this.f11281e <= 0) goto L19;
        if ((System.currentTimeMillis() - this.f) <= TimeUnit.SECONDS.toMillis(this.g)) goto L19;
        this.m = com.bytedance.frameworks.baselib.network.http.cronet.d.b.f;     // Catch: Exception -> L31
        this.f11281e = 0;     // Catch: Exception -> L31
    L19:
        if (this.f11279c == false) goto L27;
        if (this.f11281e != 0) goto L27;
        this.h.storeInt(a("stack_opt_failures"), this.f11281e + 1);     // Catch: Exception -> L31
        this.h.storeLong(a("stack_opt_failure_timestamp"), System.currentTimeMillis());     // Catch: Exception -> L31
        this.k = true;     // Catch: Exception -> L31
        if (this.m == com.bytedance.frameworks.baselib.network.http.cronet.d.b.f) goto L25;
        this.m = com.bytedance.frameworks.baselib.network.http.cronet.d.b.f8262e;     // Catch: Exception -> L31
    L25:
        return true;
    L27:
        if (this.f11279c == true) goto L29;
        this.m = com.bytedance.frameworks.baselib.network.http.cronet.d.b.f8260c;     // Catch: Exception -> L31
    L30:
        return false;
    L29:
        this.m = com.bytedance.frameworks.baselib.network.http.cronet.d.b.f8261d;     // Catch: Exception -> L31
        goto L30
    }

    public void a(boolean r3, boolean r4, int r5) {
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.f11278b == false) goto L6;
        this.h.storeBoolean("enable_stack_opt", r3);     // Catch: Exception -> L11
        this.h.storeBoolean("enable_stack_opt_fallback_fix", r4);     // Catch: Exception -> L11
        this.h.storeLong("stack_opt_fallback_fix_interval_s", Long.valueOf(r5).longValue());     // Catch: Exception -> L11
    L6:
        if (this.j == true) goto L8;
        return;
    L8:
        if (this.k == false) goto L17;
        this.h.storeInt(a("stack_opt_failures"), 0);     // Catch: Exception -> L11
        this.h.storeLong(a("stack_opt_failure_timestamp"), 0);     // Catch: Exception -> L11
        return;
    }
}
