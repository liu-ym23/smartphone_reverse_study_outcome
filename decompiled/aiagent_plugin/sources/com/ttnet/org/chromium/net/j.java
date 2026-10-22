package com.ttnet.org.chromium.net;

/* JADX INFO: compiled from: HttpNegotiateAuthenticatorJni.java */
/* JADX INFO: loaded from: classes4.dex */
class j implements HttpNegotiateAuthenticator.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<HttpNegotiateAuthenticator.a> f38248a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HttpNegotiateAuthenticator.a f38249b;

    j() {
    }

    static {
        f38248a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.HttpNegotiateAuthenticator.a
    public void setResult(long r1, HttpNegotiateAuthenticator r3, int r4, String r5) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5);
    }

    public static HttpNegotiateAuthenticator.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        HttpNegotiateAuthenticator.a r0 = f38249b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.HttpNegotiateAuthenticator.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new j();
    }
}
