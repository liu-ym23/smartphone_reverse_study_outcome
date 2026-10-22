package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements JavaHandlerThread.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JavaHandlerThread.Natives f18326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18327b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(JavaHandlerThread.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            h.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((JavaHandlerThread.Natives) r10);
        }
    }

    static {
        f18327b = new a();
    }

    public h() {
    }

    public static /* synthetic */ JavaHandlerThread.Natives a(JavaHandlerThread.Natives r10) {
        f18326a = r10;
        return r10;
    }

    public static JavaHandlerThread.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        JavaHandlerThread.Natives r10 = f18326a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.JavaHandlerThread.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(true);
        return new h();
    }

    @Override // com.ttnet.org.chromium.base.JavaHandlerThread.Natives
    public void initializeThread(long r10, long r11) {
        kf.a.j(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.JavaHandlerThread.Natives
    public void onLooperStopped(long r10) {
        kf.a.k(r10);
    }
}
