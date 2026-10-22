package com.bytedance.bdinstall;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BaseWorker.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f6357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final an f6358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f6359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected l f6360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f6361e;
    private boolean f;
    private InstallDispatcher.a.InterfaceC0143a g;

    /* JADX INFO: compiled from: BaseWorker.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f6362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f6364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6365d;

        a() {
            this.f6362a = false;
            this.f6363b = 0;
            this.f6364c = 0;
            this.f6365d = 0;
        }
    }

    public abstract void a(int r1);

    public abstract void a(boolean r1);

    public abstract boolean a();

    public abstract long b();

    public abstract long[] c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract String f();

    public abstract void g();

    long j() {
        return 60000;
    }

    public k(Context r3, an r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f6359c = 0;
        this.f6357a = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f6358b = r4;
        this.f6360d = l.a(String.valueOf(r4.a()));
    }

    public k(Context r3, an r4, long r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f6359c = 0;
        this.f6357a = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.f6358b = r4;
        this.f6361e = r5;
        this.f6360d = l.a(String.valueOf(r4.a()));
    }

    public void h() {
        this.f = true;
    }

    boolean i() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final a k() {
        boolean r1 = true;
        int r2 = 1;
        int r3 = 0;
        boolean r4 = false;
        r4 = false;
        if (a() == true) goto L5;
    L8:
        Object[] r0 = true;
    L9:
        a r5 = new a();
        if (r0 == true) goto L12;
        long r6 = 60000;
        t.c("network not ready. delay 60000 ms do " + f());
    L26:
        r5.f6363b = r2;
        r5.f6362a = r4;
        r5.f6364c = r6;
        return r5;
    L12:
        long r7 = this.f6361e + b();
        long r8 = System.currentTimeMillis();
        if (r7 <= (1000 + r8)) goto L28;
        r6 = r7 - r8;
        r2 = 2;
        t.a(f() + "time not ready. need " + r6);
        goto L26
    L28:
        boolean r9 = d();     // Catch: Exception -> L16
    L18:
        if (r9 == false) goto L20;
        r5.f6365d = this.f6359c;
        this.f6359c = 0;
        this.f6361e = System.currentTimeMillis();
        r6 = b();
    L24:
        t.c(f() + " worked:" + r9 + " " + r6, null);
        int r10 = r3;
        r4 = r1;
        r2 = r10;
        goto L26
    L20:
        long[] r11 = c();
        int r12 = this.f6359c;
        int r13 = r12 + 1;
        this.f6359c = r13;
        int r14 = r12 % r11.length;
        long r15 = r11[r14];
        if (r14 != (r11.length - 1)) goto L23;
        r5.f6365d = r13;
        r6 = r15;
        r3 = 4;
        r1 = false;
        goto L24
    L23:
        r1 = false;
        r6 = r15;
        r3 = 3;
    L16:
        e = move-exception;
        e.printStackTrace();
        t.a(e);
        r9 = false;
        goto L18
    L5:
        if (com.bytedance.bdinstall.j.l.a(this.f6357a) == true) goto L8;
        r0 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends k> T l() {
        this.f6361e = 0;
        return this;
    }

    public void a(InstallDispatcher.a.InterfaceC0143a r3) {
        this.g = (InstallDispatcher.a.InterfaceC0143a) ZeusTransformUtils.wrapperContextForParams(r3, InstallDispatcher.a.InterfaceC0143a.class, "com.obric.aiagent.plugin");
    }

    public InstallDispatcher.a.InterfaceC0143a m() {
        return this.g;
    }
}
