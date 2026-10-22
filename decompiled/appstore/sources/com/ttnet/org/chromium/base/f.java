package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements EarlyTraceEvent.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static EarlyTraceEvent.Natives f18322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18323b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            setInstanceForTesting((EarlyTraceEvent.Natives) r10);
        }

        public void setInstanceForTesting(EarlyTraceEvent.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            f.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    }

    static {
        f18323b = new a();
    }

    public f() {
    }

    public static /* synthetic */ EarlyTraceEvent.Natives a(EarlyTraceEvent.Natives r10) {
        f18322a = r10;
        return r10;
    }

    public static EarlyTraceEvent.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        EarlyTraceEvent.Natives r10 = f18322a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.EarlyTraceEvent.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(true);
        return new f();
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyAsyncBeginEvent(String r10, long r11, long r12) {
        kf.a.b(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyAsyncEndEvent(String r10, long r11, long r12) {
        kf.a.c(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyBeginEvent(String r10, long r11, int r12, long r13) {
        kf.a.d(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyEndEvent(String r10, long r11, int r12, long r13) {
        kf.a.e(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyToplevelBeginEvent(String r10, long r11, int r12, long r13) {
        kf.a.f(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.Natives
    public void recordEarlyToplevelEndEvent(String r10, long r11, int r12, long r13) {
        kf.a.g(r10, r11, r12, r13);
    }
}
