package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements PowerMonitor.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PowerMonitor.Natives f18329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18330b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(PowerMonitor.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            l.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((PowerMonitor.Natives) r10);
        }
    }

    static {
        f18330b = new a();
    }

    public l() {
    }

    public static /* synthetic */ PowerMonitor.Natives a(PowerMonitor.Natives r10) {
        f18329a = r10;
        return r10;
    }

    public static PowerMonitor.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        PowerMonitor.Natives r10 = f18329a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.PowerMonitor.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new l();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.Natives
    public void onBatteryChargingChanged() {
        kf.a.l();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.Natives
    public void onInstantResume() {
        kf.a.m();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.Natives
    public void onInstantSuspend() {
        kf.a.n();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.Natives
    public void onResume() {
        kf.a.o();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.Natives
    public void onSuspend() {
        kf.a.p();
    }
}
