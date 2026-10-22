package com.ttnet.org.chromium.base;

/* JADX INFO: compiled from: PowerMonitorJni.java */
/* JADX INFO: loaded from: classes4.dex */
class p implements PowerMonitor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<PowerMonitor.b> f37730a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static PowerMonitor.b f37731b;

    p() {
    }

    static {
        f37730a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.b
    public void a() {
        com.ttnet.org.chromium.base.b.a.a();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.b
    public void b() {
        com.ttnet.org.chromium.base.b.a.b();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.b
    public void c() {
        com.ttnet.org.chromium.base.b.a.c();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.b
    public void d() {
        com.ttnet.org.chromium.base.b.a.d();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.b
    public void e() {
        com.ttnet.org.chromium.base.b.a.e();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.b
    public void a(int r1) {
        com.ttnet.org.chromium.base.b.a.b(r1);
    }

    public static PowerMonitor.b f() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        PowerMonitor.b r0 = f37731b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.PowerMonitor.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        l.a(false);
        return new p();
    }
}
