package com.bytedance.apm6.cpu.c.a;

/* JADX INFO: compiled from: NormalCoolDownState.java */
/* JADX INFO: loaded from: classes.dex */
class c extends com.bytedance.apm6.cpu.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm6.util.e.a f5243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f5244c;

    static /* synthetic */ void a(c r0, String r1) {
        r0.a(r1);
    }

    static /* synthetic */ boolean a(c r0) {
        return r0.f5244c;
    }

    public c(final com.bytedance.apm6.cpu.c.d r9) {
        super(r9);
        this.f5244c = false;
        final long r3 = c();
        final long r5 = 0;
        this.f5243b = new AnonymousClass1(this, r3, r5, r9);
    }

    private long c() {
        if (this.f5244c == false) goto L5;
        return 1200000;
    L5:
        return 120000;
    }

    @Override // com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a(com.bytedance.apm6.cpu.b.c r5, boolean r6) {
        super.a(r5, r6);
        com.bytedance.apm6.util.e.a r7 = this.f5243b;
        if (r7 == null) goto L5;
        r7.a(c(), 0);
    L5:
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b).a(this.f5243b);
    }

    @Override // com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a() {
        super.a();
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b).b(this.f5243b);
    }

    @Override // com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a(boolean r1) {
        super.a(r1);
        this.f5244c = r1;
    }

    @Override // com.bytedance.apm6.cpu.c.g
    public com.bytedance.apm6.cpu.c.h b() {
        return com.bytedance.apm6.cpu.c.h.f5274d;
    }
}
