package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes4.dex */
public final class r implements TraceEvent.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TraceEvent.Natives f18339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18340b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            setInstanceForTesting((TraceEvent.Natives) r10);
        }

        public void setInstanceForTesting(TraceEvent.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            r.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    }

    static {
        f18340b = new a();
    }

    public r() {
    }

    public static /* synthetic */ TraceEvent.Natives a(TraceEvent.Natives r10) {
        f18339a = r10;
        return r10;
    }

    public static TraceEvent.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        TraceEvent.Natives r10 = f18339a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.TraceEvent.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(true);
        return new r();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void begin(String r10, String r11) {
        kf.a.r(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void beginToplevel(String r10) {
        kf.a.s(r10);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void end(String r10, String r11) {
        kf.a.t(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void endToplevel(String r10) {
        kf.a.u(r10);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void finishAsync(String r10, long r11) {
        kf.a.v(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void instant(String r10, String r11) {
        kf.a.w(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void registerEnabledObserver() {
        kf.a.x();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void setupATraceStartupTrace(String r10) {
        kf.a.y(r10);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void startATrace(String r10) {
        kf.a.z(r10);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void startAsync(String r10, long r11) {
        kf.a.A(r10, r11);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void stopATrace() {
        kf.a.B();
    }
}
