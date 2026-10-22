package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements JavaExceptionReporter.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JavaExceptionReporter.Natives f18324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18325b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(JavaExceptionReporter.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            g.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((JavaExceptionReporter.Natives) r10);
        }
    }

    static {
        f18325b = new a();
    }

    public g() {
    }

    public static /* synthetic */ JavaExceptionReporter.Natives a(JavaExceptionReporter.Natives r10) {
        f18324a = r10;
        return r10;
    }

    public static JavaExceptionReporter.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        JavaExceptionReporter.Natives r10 = f18324a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.JavaExceptionReporter.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(true);
        return new g();
    }

    @Override // com.ttnet.org.chromium.base.JavaExceptionReporter.Natives
    public void reportJavaException(boolean r10, Throwable r11) {
        kf.a.h(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.JavaExceptionReporter.Natives
    public void reportJavaStackTrace(String r10) {
        kf.a.i(r10);
    }
}
