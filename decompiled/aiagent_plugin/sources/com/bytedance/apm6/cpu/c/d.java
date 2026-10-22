package com.bytedance.apm6.cpu.c;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CpuExceptionStateMachine.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.apm6.service.d.a f5269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.watson.assist.a.c f5270e;
    private g f;
    private com.bytedance.apm6.cpu.b.c g;
    private g h;
    private g i;
    private g j;
    private g k;
    private g l;

    public d(com.bytedance.apm6.service.d.a r3) {
        com.bytedance.apm6.service.d.a r4 = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");
        this.f5266a = false;
        this.f5267b = false;
        this.f5269d = r4;
    }

    public void a(g r3, g r4, g r5, g r6, g r7) {
        g r8 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        g r9 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
        g r10 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.aiagent.plugin");
        g r11 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.aiagent.plugin");
        g r12 = (g) ZeusTransformUtils.wrapperContextForParams(r7, g.class, "com.obric.aiagent.plugin");
        if (this.f5267b == false) goto L5;
        return;
    L5:
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.f5270e = com.bytedance.watson.assist.a.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
    L7:
        this.f5267b = true;
    }

    public synchronized void a(com.bytedance.apm6.cpu.b.c r2) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f5266a == false) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.f5267b == false) goto L15;
        this.g = r2;     // Catch: Throwable -> L17
        boolean r3 = true;
        this.f5266a = true;     // Catch: Throwable -> L17
        b.a(com.bytedance.apm6.cpu.a.a().b());     // Catch: Throwable -> L17
        if (this.f5269d.isForeground() == false) goto L12;
        r3 = false;
    L12:
        this.f5268c = r3;     // Catch: Throwable -> L17
        c();     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public synchronized void a() {
        monitor-enter(this);
        g r0 = this.f;     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.f5266a == false) goto L11;
        r0.a();     // Catch: Throwable -> L13
        this.f5266a = false;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void b() {
        monitor-enter(this);
        a(this.l);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void c() {
        monitor-enter(this);
        a(this.h);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void d() {
        monitor-enter(this);
        a(this.i);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void e() {
        monitor-enter(this);
        a(this.j);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void f() {
        monitor-enter(this);
        a(this.k);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void a(boolean r3) {
        monitor-enter(this);
        g r0 = this.f;     // Catch: Throwable -> L17
        if (r0 != null) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.f5266a == false) goto L15;
        if (this.f5268c != r3) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.f5268c = r3;     // Catch: Throwable -> L17
        r0.a(r3);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public com.bytedance.watson.assist.a.c g() {
        return this.f5270e;
    }

    private void a(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        if (this.f5266a == true) goto L5;
        return;
    L5:
        if (this.f5267b == false) goto L17;
        this.f = r4;
        com.bytedance.apm6.cpu.b.c r0 = this.g;
        com.bytedance.apm6.service.d.a r1 = this.f5269d;
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        r4.a(r0, r2);
        h();
        return;
    L10:
        if (r1.isForeground() == false) goto L13;
        r2 = false;
        goto L14
    }

    private void h() {
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L6;
        com.bytedance.apm6.util.c.b.b("APM-CPU", "change cpu exception detect state: " + this.f);
        return;
    }
}
