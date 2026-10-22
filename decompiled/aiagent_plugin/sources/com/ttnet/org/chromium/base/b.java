package com.ttnet.org.chromium.base;

/* JADX INFO: compiled from: ApplicationStatusJni.java */
/* JADX INFO: loaded from: classes4.dex */
class b implements ApplicationStatus.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<ApplicationStatus.d> f37692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ApplicationStatus.d f37693b;

    b() {
    }

    static {
        f37692a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.d
    public void a(int r1) {
        com.ttnet.org.chromium.base.b.a.a(r1);
    }

    public static ApplicationStatus.d a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        ApplicationStatus.d r0 = f37693b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.ApplicationStatus.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        l.a(false);
        return new b();
    }
}
