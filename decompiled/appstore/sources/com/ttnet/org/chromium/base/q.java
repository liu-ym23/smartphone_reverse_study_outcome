package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements TimeUtils$Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TimeUtils$Natives f18337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18338b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(TimeUtils$Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            q.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((TimeUtils$Natives) r10);
        }
    }

    static {
        f18338b = new a();
    }

    public q() {
    }

    public static /* synthetic */ TimeUtils$Natives a(TimeUtils$Natives r10) {
        f18337a = r10;
        return r10;
    }

    public static TimeUtils$Natives b() {
        if (kf.a.f21061a == false) goto L12;
        TimeUtils$Natives r10 = f18337a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.TimeUtils.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(true);
        return new q();
    }

    @Override // com.ttnet.org.chromium.base.TimeUtils$Natives
    public long getTimeTicksNowUs() {
        return kf.a.q();
    }
}
