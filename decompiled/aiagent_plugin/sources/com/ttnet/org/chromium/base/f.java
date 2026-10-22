package com.ttnet.org.chromium.base;

/* JADX INFO: compiled from: JavaExceptionReporterJni.java */
/* JADX INFO: loaded from: classes4.dex */
class f implements JavaExceptionReporter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<JavaExceptionReporter.a> f37703a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static JavaExceptionReporter.a f37704b;

    f() {
    }

    static {
        f37703a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.JavaExceptionReporter.a
    public void a(boolean r1, Throwable r2) {
        com.ttnet.org.chromium.base.b.a.a(r1, r2);
    }

    public static JavaExceptionReporter.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        JavaExceptionReporter.a r0 = f37704b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.JavaExceptionReporter.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        l.a(true);
        return new f();
    }
}
