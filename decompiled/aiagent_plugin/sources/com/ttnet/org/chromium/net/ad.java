package com.ttnet.org.chromium.net;

/* JADX INFO: compiled from: TTSocketAccelerateJni.java */
/* JADX INFO: loaded from: classes4.dex */
class ad implements TTSocketAccelerate.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<TTSocketAccelerate.a> f37886a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static TTSocketAccelerate.a f37887b;

    ad() {
    }

    static {
        f37886a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.TTSocketAccelerate.a
    public void a(long r1, TTSocketAccelerate r3, int r4) {
        com.ttnet.org.chromium.base.b.a.c(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.TTSocketAccelerate.a
    public void a(long r1, TTSocketAccelerate r3, int r4, int r5) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5);
    }

    public static TTSocketAccelerate.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        TTSocketAccelerate.a r0 = f37887b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.TTSocketAccelerate.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new ad();
    }
}
