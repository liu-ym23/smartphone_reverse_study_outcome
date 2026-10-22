package com.ttnet.org.chromium.net;

/* JADX INFO: compiled from: AndroidNetworkLibraryJni.java */
/* JADX INFO: loaded from: classes4.dex */
class a implements AndroidNetworkLibrary.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<AndroidNetworkLibrary.a> f37884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AndroidNetworkLibrary.a f37885b;

    a() {
    }

    static {
        f37884a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.AndroidNetworkLibrary.a
    public void a(boolean r1, int r2) {
        com.ttnet.org.chromium.base.b.a.a(r1, r2);
    }

    public static AndroidNetworkLibrary.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        AndroidNetworkLibrary.a r0 = f37885b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.AndroidNetworkLibrary.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(true);
        return new a();
    }
}
