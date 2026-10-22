package com.ttnet.org.chromium.net;

/* JADX INFO: compiled from: NetworkChangeNotifierJni.java */
/* JADX INFO: loaded from: classes4.dex */
class n implements NetworkChangeNotifier.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<NetworkChangeNotifier.b> f38252a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static NetworkChangeNotifier.b f38253b;

    n() {
    }

    static {
        f38252a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.b
    public void a(long r1, NetworkChangeNotifier r3, int r4, long r5) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.b
    public void a(long r1, NetworkChangeNotifier r3, int r4) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.b
    public void b(long r1, NetworkChangeNotifier r3, int r4) {
        com.ttnet.org.chromium.base.b.a.b(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.b
    public void a(long r1, NetworkChangeNotifier r3, long r4, boolean r6, int r7) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r6, r7);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.b
    public void a(long r1, NetworkChangeNotifier r3, long r4) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.b
    public void a(long r1, NetworkChangeNotifier r3, boolean r4, long r5) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.b
    public void a(long r1, NetworkChangeNotifier r3, long[] r4) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4);
    }

    public static NetworkChangeNotifier.b a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        NetworkChangeNotifier.b r0 = f38253b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new n();
    }
}
