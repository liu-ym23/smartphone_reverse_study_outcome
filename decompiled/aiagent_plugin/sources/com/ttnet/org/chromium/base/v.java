package com.ttnet.org.chromium.base;

/* JADX INFO: compiled from: TraceEventJni.java */
/* JADX INFO: loaded from: classes4.dex */
class v implements TraceEvent.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<TraceEvent.b> f37776a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static TraceEvent.b f37777b;

    v() {
    }

    static {
        f37776a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.b
    public void a(String r1) {
        com.ttnet.org.chromium.base.b.a.a(r1);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.b
    public void a() {
        com.ttnet.org.chromium.base.b.a.f();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.b
    public void b(String r1) {
        com.ttnet.org.chromium.base.b.a.b(r1);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.b
    public void a(String r1, String r2) {
        com.ttnet.org.chromium.base.b.a.a(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.b
    public void b(String r1, String r2) {
        com.ttnet.org.chromium.base.b.a.b(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.b
    public void c(String r1, String r2) {
        com.ttnet.org.chromium.base.b.a.c(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.b
    public void c(String r1) {
        com.ttnet.org.chromium.base.b.a.c(r1);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.b
    public void d(String r1) {
        com.ttnet.org.chromium.base.b.a.d(r1);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.b
    public boolean b() {
        return com.ttnet.org.chromium.base.b.a.g();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.b
    public void c() {
        com.ttnet.org.chromium.base.b.a.h();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.b
    public long a(String r1, long r2) {
        return com.ttnet.org.chromium.base.b.a.a(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.b
    public void a(int r1, int r2, boolean r3, boolean r4, String r5, String r6, long r7) {
        com.ttnet.org.chromium.base.b.a.a(r1, r2, r3, r4, r5, r6, r7);
    }

    public static TraceEvent.b d() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        TraceEvent.b r0 = f37777b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.TraceEvent.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        l.a(true);
        return new v();
    }
}
