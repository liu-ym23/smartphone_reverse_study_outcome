package com.ttnet.org.chromium.net;

/* JADX INFO: compiled from: X509UtilJni.java */
/* JADX INFO: loaded from: classes4.dex */
class al implements ak.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<ak.a> f37895a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ak.a f37896b;

    al() {
    }

    static {
        f37895a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.ak.a
    public void a() {
        com.ttnet.org.chromium.base.b.a.k();
    }

    public static ak.a b() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        ak.a r0 = f37896b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.X509Util.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(true);
        return new al();
    }
}
