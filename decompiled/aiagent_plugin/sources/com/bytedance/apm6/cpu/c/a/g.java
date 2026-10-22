package com.bytedance.apm6.cpu.c.a;

/* JADX INFO: compiled from: NormalProcessDoubleDetectState.java */
/* JADX INFO: loaded from: classes.dex */
class g extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5252d;

    public g(com.bytedance.apm6.cpu.c.d r1) {
        super(r1);
        this.f5252d = 0;
    }

    @Override // com.bytedance.apm6.cpu.c.g
    public com.bytedance.apm6.cpu.c.h b() {
        return com.bytedance.apm6.cpu.c.h.f5272b;
    }

    @Override // com.bytedance.apm6.cpu.c.a.a
    public long c() {
        if (this.f5235c == false) goto L5;
        return 300000;
    L5:
        return 5000;
    }

    @Override // com.bytedance.apm6.cpu.c.a.a, com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a(boolean r2) {
        if (r2 == false) goto L4;
        this.f5252d = 0;
    L4:
        super.a(r2);
    }

    @Override // com.bytedance.apm6.cpu.c.a.a
    public boolean b(boolean r4) {
        if (r4 == false) goto L9;
        this.f5252d++;
        a("over time: " + this.f5252d + " max over time: 2");
        if (this.f5252d < 2) goto L8;
        this.f5252d = 0;
        this.f5233a.e();
        return true;
    L8:
        return false;
    L9:
        this.f5252d = 0;
        this.f5233a.c();
        return true;
    }

    @Override // com.bytedance.apm6.cpu.c.a.a
    public boolean d() {
        this.f5252d = 0;
        this.f5233a.c();
        return true;
    }
}
