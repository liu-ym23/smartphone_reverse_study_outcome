package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements ApplicationStatus.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ApplicationStatus.Natives f18313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18314b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(ApplicationStatus.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            b.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((ApplicationStatus.Natives) r10);
        }
    }

    static {
        f18314b = new a();
    }

    public b() {
    }

    public static /* synthetic */ ApplicationStatus.Natives a(ApplicationStatus.Natives r10) {
        f18313a = r10;
        return r10;
    }

    public static ApplicationStatus.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        ApplicationStatus.Natives r10 = f18313a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.ApplicationStatus.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new b();
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.Natives
    public void onApplicationStateChange(int r10) {
        kf.a.a(r10);
    }
}
