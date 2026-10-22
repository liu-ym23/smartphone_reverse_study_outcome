package com.bytedance.apm.battery.d;

/* JADX INFO: compiled from: BatteryPacketsStatsImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f4315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f4316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.apm.perf.a.g f4317e;

    public h() {
        super("traffic_packets");
        this.f4315c = -1;
        this.f4316d = -1;
        this.f4317e = com.bytedance.apm.perf.a.g.a();
    }

    @Override // com.bytedance.apm.battery.d.b
    public void b(boolean r4, boolean r5) {
        if (a() == false) goto L14;
        d(r5);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (com.bytedance.apm.c.i() == false) goto L10;
        com.bytedance.apm.h.e.c(com.bytedance.apm.h.b.f4646b, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L10:
        com.bytedance.services.apm.api.a.a(th, "BatteryPacketsStatsImpl");
        return;
    }

    private void d(boolean r9) {
        long r0 = this.f4317e.g();
        long r2 = this.f4317e.e();
        if (this.f4316d > (-1)) goto L5;
    L8:
        this.f4315c = r0;
        this.f4316d = r2;
        return;
    L5:
        if (this.f4315c <= (-1)) goto L8;
        if (r9 == false) goto L8;
        String r10 = com.bytedance.apm.battery.a.a().h();
        a(true, r0 - this.f4315c, r10);
        a(false, r2 - this.f4316d, r10);
        goto L8
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(com.bytedance.apm.battery.c.b r3, com.bytedance.apm.e.a r4) {
        if (r4.a() == false) goto L5;
        r3.n(r4.d());
        return;
    L5:
        r3.e(r4.d());
    }
}
