package com.ttnet.org.chromium.base;

/* JADX INFO: compiled from: JavaHandlerThreadJni.java */
/* JADX INFO: loaded from: classes4.dex */
class g implements JavaHandlerThread.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<JavaHandlerThread.a> f37705a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static JavaHandlerThread.a f37706b;

    g() {
    }

    static {
        f37705a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.JavaHandlerThread.a
    public void a(long r1, long r3) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3);
    }

    @Override // com.ttnet.org.chromium.base.JavaHandlerThread.a
    public void a(long r1) {
        com.ttnet.org.chromium.base.b.a.a(r1);
    }

    public static JavaHandlerThread.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        JavaHandlerThread.a r0 = f37706b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.JavaHandlerThread.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        l.a(true);
        return new g();
    }
}
