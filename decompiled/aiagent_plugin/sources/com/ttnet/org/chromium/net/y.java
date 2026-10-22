package com.ttnet.org.chromium.net;

/* JADX INFO: compiled from: TTAppSecurityManagerJni.java */
/* JADX INFO: loaded from: classes4.dex */
class y implements x.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<x.b> f38303a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static x.b f38304b;

    y() {
    }

    static {
        f38303a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.x.b
    public boolean a() {
        return com.ttnet.org.chromium.base.b.a.i();
    }

    @Override // com.ttnet.org.chromium.net.x.b
    public boolean b() {
        return com.ttnet.org.chromium.base.b.a.j();
    }

    public static x.b c() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        x.b r0 = f38304b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.TTAppSecurityManager.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new y();
    }
}
