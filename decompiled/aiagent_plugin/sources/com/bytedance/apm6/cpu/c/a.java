package com.bytedance.apm6.cpu.c;

/* JADX INFO: compiled from: BaseCpuExceptionState.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected d f5233a;

    public a(d r1) {
        this.f5233a = r1;
    }

    @Override // com.bytedance.apm6.cpu.c.g
    public void a(com.bytedance.apm6.cpu.b.c r1, boolean r2) {
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L6;
        com.bytedance.apm6.util.c.b.b("APM-CPU", "enter : " + b());
        return;
    }

    @Override // com.bytedance.apm6.cpu.c.g
    public void a() {
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L6;
        com.bytedance.apm6.util.c.b.b("APM-CPU", "stop detect when state is : " + b());
        return;
    }

    @Override // com.bytedance.apm6.cpu.c.g
    public void a(boolean r2) {
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L6;
        com.bytedance.apm6.util.c.b.b("APM-CPU", "onLifeCycleChange when state is : " + b());
        return;
    }

    public void a(String r3) {
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L6;
        com.bytedance.apm6.util.c.b.b("APM-CPU", "[" + b() + "]: " + r3);
        return;
    }
}
