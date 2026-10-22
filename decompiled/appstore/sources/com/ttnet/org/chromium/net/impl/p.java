package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements TTCronetNetExpRequest.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TTCronetNetExpRequest.Natives f18884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18885b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(TTCronetNetExpRequest.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            p.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((TTCronetNetExpRequest.Natives) r10);
        }
    }

    static {
        f18885b = new a();
    }

    public p() {
    }

    public static /* synthetic */ TTCronetNetExpRequest.Natives a(TTCronetNetExpRequest.Natives r10) {
        f18884a = r10;
        return r10;
    }

    public static TTCronetNetExpRequest.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        TTCronetNetExpRequest.Natives r10 = f18884a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new p();
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public long createRequestAdapter(TTCronetNetExpRequest r10, long r11, int r12, String[] r13, int r14, int r15) {
        return kf.a.t1(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public void destroy(long r10, TTCronetNetExpRequest r11) {
        kf.a.u1(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public void doExtraCommand(long r10, TTCronetNetExpRequest r11, String r12, String r13) {
        kf.a.v1(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public void start(long r10, TTCronetNetExpRequest r11) {
        kf.a.w1(r10, r11);
    }
}
