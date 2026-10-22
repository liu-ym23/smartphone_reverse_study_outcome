package com.ttnet.org.chromium.net;

/* JADX INFO: compiled from: ProxyChangeListenerJni.java */
/* JADX INFO: loaded from: classes4.dex */
class s implements ProxyChangeListener.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<ProxyChangeListener.b> f38257a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ProxyChangeListener.b f38258b;

    s() {
    }

    static {
        f38257a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.b
    public void a(long r1, ProxyChangeListener r3, String r4, int r5, String r6, String[] r7) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5, r6, r7);
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.b
    public void a(long r1, ProxyChangeListener r3) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3);
    }

    public static ProxyChangeListener.b a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        ProxyChangeListener.b r0 = f38258b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.ProxyChangeListener.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new s();
    }
}
