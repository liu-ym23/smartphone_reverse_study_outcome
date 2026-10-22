package com.ttnet.org.chromium.net.impl;

/* JADX INFO: compiled from: CronetUploadDataStreamJni.java */
/* JADX INFO: loaded from: classes4.dex */
class l implements CronetUploadDataStream.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<CronetUploadDataStream.a> f38152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CronetUploadDataStream.a f38153b;

    l() {
    }

    static {
        f38152a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.a
    public long a(CronetUploadDataStream r1, long r2, long r4) {
        return com.ttnet.org.chromium.base.b.a.a(r1, r2, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.a
    public void a(long r1, CronetUploadDataStream r3, int r4, boolean r5) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.a
    public void a(long r1, CronetUploadDataStream r3) {
        com.ttnet.org.chromium.base.b.a.c(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.a
    public void a(long r1) {
        com.ttnet.org.chromium.base.b.a.d(r1);
    }

    public static CronetUploadDataStream.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        CronetUploadDataStream.a r0 = f38153b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new l();
    }
}
