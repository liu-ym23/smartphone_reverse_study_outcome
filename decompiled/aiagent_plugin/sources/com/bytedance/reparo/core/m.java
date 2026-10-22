package com.bytedance.reparo.core;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: ReparoPatch.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile m f9321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Application f9322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.reparo.core.g.a f9323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private k f9325e;
    private g f;

    private m() {
    }

    public static m a() {
        if (f9321a != null) goto L13;
        monitor-enter(m.class);
        f9321a = new m();     // Catch: Throwable -> L9
        monitor-exit(m.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f9321a;
    }

    public int a(Application r13, e r14, String r15, com.bytedance.reparo.core.g.a r16, boolean r17, boolean r18, boolean r19) {
        Application r1 = (Application) ZeusTransformUtils.wrapperContextForParams(r13, Application.class, "com.obric.aiagent.plugin");
        com.bytedance.reparo.core.g.a r2 = (com.bytedance.reparo.core.g.a) ZeusTransformUtils.wrapperContextForParams(r16, com.bytedance.reparo.core.g.a.class, "com.obric.aiagent.plugin");
        if (this.f9324d == false) goto L5;
        return 0;
    L5:
        this.f9322b = r1;
        this.f9323c = r2;
        g r7 = new g(this.f9322b);
        r7.a(r18);
        r7.b(r19);
        this.f = r7;
        k r3 = new k(this.f9322b, r7, r14, this.f9323c, r15, r17);
        this.f9325e = r3;
        r3.a();
        this.f9324d = true;
        return 0;
    }

    private void j() {
        if (this.f9324d == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("has not initialized.");
    }

    public int b() {
        j();
        return this.f9323c.b();
    }

    public String c() {
        j();
        return this.f9323c.a();
    }

    public Map<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d> d() {
        j();
        return this.f9325e.c();
    }

    public void e() {
        j();
        this.f9325e.b();
    }

    public void a(k.a r3) {
        k.a r4 = (k.a) ZeusTransformUtils.wrapperContextForParams(r3, k.a.class, "com.obric.aiagent.plugin");
        j();
        this.f9325e.a(r4);
    }

    public void b(k.a r3) {
        k.a r4 = (k.a) ZeusTransformUtils.wrapperContextForParams(r3, k.a.class, "com.obric.aiagent.plugin");
        j();
        this.f9325e.b(r4);
    }

    public void update(n r1) {
        j();
        this.f9325e.update(r1);
    }

    public void f() {
        j();
        this.f9325e.b(true);
    }

    public void g() {
        if (this.f9324d == false) goto L6;
        this.f9325e.a(true);
        return;
    }

    public boolean h() {
        return this.f9324d;
    }

    public g i() {
        return this.f;
    }
}
