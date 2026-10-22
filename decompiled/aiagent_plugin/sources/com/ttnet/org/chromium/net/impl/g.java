package com.ttnet.org.chromium.net.impl;

/* JADX INFO: compiled from: CronetLibraryLoaderJni.java */
/* JADX INFO: loaded from: classes4.dex */
class g implements CronetLibraryLoader.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<CronetLibraryLoader.a> f38123a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CronetLibraryLoader.a f38124b;

    g() {
    }

    static {
        f38123a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.a
    public void a() {
        com.ttnet.org.chromium.base.b.a.l();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.a
    public String b() {
        return com.ttnet.org.chromium.base.b.a.m();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.a
    public void c() {
        com.ttnet.org.chromium.base.b.a.n();
    }

    public static CronetLibraryLoader.a d() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        CronetLibraryLoader.a r0 = f38124b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetLibraryLoader.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new g();
    }
}
