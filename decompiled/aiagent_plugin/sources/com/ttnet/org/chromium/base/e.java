package com.ttnet.org.chromium.base;

/* JADX INFO: compiled from: EarlyTraceEventJni.java */
/* JADX INFO: loaded from: classes4.dex */
class e implements EarlyTraceEvent.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<EarlyTraceEvent.c> f37701a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static EarlyTraceEvent.c f37702b;

    e() {
    }

    static {
        f37701a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.c
    public void a(String r1, long r2, int r4, long r5) {
        com.ttnet.org.chromium.base.b.a.a(r1, r2, r4, r5);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.c
    public void b(String r1, long r2, int r4, long r5) {
        com.ttnet.org.chromium.base.b.a.b(r1, r2, r4, r5);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.c
    public void c(String r1, long r2, int r4, long r5) {
        com.ttnet.org.chromium.base.b.a.c(r1, r2, r4, r5);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.c
    public void d(String r1, long r2, int r4, long r5) {
        com.ttnet.org.chromium.base.b.a.d(r1, r2, r4, r5);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.c
    public void a(String r1, long r2, long r4) {
        com.ttnet.org.chromium.base.b.a.a(r1, r2, r4);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.c
    public void b(String r1, long r2, long r4) {
        com.ttnet.org.chromium.base.b.a.b(r1, r2, r4);
    }

    public static EarlyTraceEvent.c a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        EarlyTraceEvent.c r0 = f37702b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.EarlyTraceEvent.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        l.a(true);
        return new e();
    }
}
