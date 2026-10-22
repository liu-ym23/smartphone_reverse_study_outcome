package com.bytedance.apm6.cpu.c.a;

/* JADX INFO: compiled from: BaseProcessDetectState.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends com.bytedance.apm6.cpu.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.apm6.cpu.b.c f5234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f5235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.apm6.util.e.a f5236d;

    public abstract boolean b(boolean r1);

    public abstract long c();

    public abstract boolean d();

    static /* synthetic */ void a(a r0) {
        r0.e();
    }

    public a(com.bytedance.apm6.cpu.c.d r1) {
        super(r1);
    }

    @Override // com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a(com.bytedance.apm6.cpu.b.c r7, boolean r8) {
        super.a(r7, r8);
        this.f5234b = r7;
        this.f5235c = r8;
        com.bytedance.apm6.util.c.b.b("APM-CPU", "enter : " + b() + " provideDetectInterval : " + c() + " isBack : " + r8);
        com.bytedance.apm6.util.e.a r9 = this.f5236d;
        if (r9 != null) goto L5;
        final long r2 = c();
        final long r4 = c();
        this.f5236d = new AnonymousClass1(this, r2, r4);
    L6:
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5476d).a(this.f5236d);
        return;
    L5:
        r9.a(c(), c());
        goto L6
    }

    @Override // com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a() {
        super.a();
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5476d).b(this.f5236d);
    }

    @Override // com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a(boolean r2) {
        super.a(r2);
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5476d).b(this.f5236d);
        this.f5233a.b();
    }

    private void e() {
        if (com.bytedance.apm6.cpu.c.b.a() == true) goto L5;
        double r0 = com.bytedance.apm6.cpu.c.e.a();
        com.bytedance.watson.assist.a.c r2 = this.f5233a.g();
        if (r2 == null) goto L13;
        boolean r3 = r2.a((float) r0);
        if (r3 == false) goto L14;
        r3 = com.bytedance.apm6.cpu.c.b.a(this.f5234b, r0, this.f5235c);
    L14:
        a("run judge process cpu usage task, is over max threshold?: " + r3 + " speed: " + r0 + ", back max speed: " + this.f5234b.e() + ", fore max speed: " + this.f5234b.i());
        if (b(r3) == false) goto L19;
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5476d).b(this.f5236d);
        return;
    L19:
        return;
    L13:
        r3 = com.bytedance.apm6.cpu.c.b.a(this.f5234b, r0, this.f5235c);
        goto L14
    L5:
        if (d() == false) goto L18;
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5476d).b(this.f5236d);
        return;
    }
}
