package com.bytedance.apm6.cpu.c.a;

/* JADX INFO: compiled from: NormalIdleState.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends com.bytedance.apm6.cpu.c.a {
    public e(com.bytedance.apm6.cpu.c.d r1) {
        super(r1);
    }

    @Override // com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a(com.bytedance.apm6.cpu.b.c r1, boolean r2) {
        super.a(r1, r2);
        this.f5233a.c();
    }

    @Override // com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a() {
        super.a();
    }

    @Override // com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a(boolean r3) {
        super.a(r3);
        a("life cycle change when state is idle, lifecycle change to back?: " + r3);
        this.f5233a.c();
    }

    @Override // com.bytedance.apm6.cpu.c.g
    public com.bytedance.apm6.cpu.c.h b() {
        return com.bytedance.apm6.cpu.c.h.f5275e;
    }
}
