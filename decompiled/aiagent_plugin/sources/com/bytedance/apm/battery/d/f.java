package com.bytedance.apm.battery.d;

/* JADX INFO: compiled from: BatteryCpuStatsImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4313c;

    public f() {
        super("cpu_active_time");
        this.f4313c = 0;
    }

    @Override // com.bytedance.apm.battery.d.b
    public void b(boolean r8, boolean r9) {
        long r0 = com.bytedance.apm.util.b.c();
        long r2 = this.f4313c;
        if (r2 <= 0) goto L9;
        if (r9 == false) goto L9;
        long r3 = r0 - r2;
        if (r3 <= 0) goto L8;
        a(r8, r3, com.bytedance.apm.battery.a.a().h());
        goto L9
    L8:
        com.bytedance.apm.h.a.b("APM-Battery", "CPU Value:" + r3);
    L9:
        this.f4313c = r0;
    }

    private long b() {
        return com.bytedance.apm.util.b.a(100);
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(com.bytedance.apm.battery.c.b r8, com.bytedance.apm.e.a r9) {
        if (r9.a() == false) goto L5;
        r8.k((long) ((r9.d() / b()) * 1000.0d));
        return;
    L5:
        r8.b((long) ((r9.d() / b()) * 1000.0d));
    }
}
