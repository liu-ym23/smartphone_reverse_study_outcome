package com.ttnet.org.chromium.net;

/* JADX INFO: compiled from: NetworkActiveNotifierJni.java */
/* JADX INFO: loaded from: classes4.dex */
class m implements NetworkActiveNotifier.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<NetworkActiveNotifier.a> f38250a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static NetworkActiveNotifier.a f38251b;

    m() {
    }

    static {
        f38250a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.NetworkActiveNotifier.a
    public void a(long r1) {
        com.ttnet.org.chromium.base.b.a.c(r1);
    }

    public static NetworkActiveNotifier.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        NetworkActiveNotifier.a r0 = f38251b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.NetworkActiveNotifier.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new m();
    }
}
