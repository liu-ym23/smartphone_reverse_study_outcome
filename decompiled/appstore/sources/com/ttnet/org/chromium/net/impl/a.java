package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements CronetBidirectionalStream.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CronetBidirectionalStream.Natives f18768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18769b = null;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.a$a, reason: collision with other inner class name */
    public class C0225a implements JniStaticTestMocker {
        public C0225a() {
        }

        public void a(CronetBidirectionalStream.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            a.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((CronetBidirectionalStream.Natives) r10);
        }
    }

    static {
        f18769b = new C0225a();
    }

    public a() {
    }

    public static /* synthetic */ CronetBidirectionalStream.Natives a(CronetBidirectionalStream.Natives r10) {
        f18768a = r10;
        return r10;
    }

    public static CronetBidirectionalStream.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        CronetBidirectionalStream.Natives r10 = f18768a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new a();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public long createBidirectionalStream(CronetBidirectionalStream r10, long r11, boolean r12, boolean r13, boolean r14, int r15, boolean r16, int r17) {
        return kf.a.O(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public void destroy(long r10, CronetBidirectionalStream r11, boolean r12) {
        kf.a.P(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public boolean readData(long r10, CronetBidirectionalStream r11, ByteBuffer r12, int r13, int r14) {
        return kf.a.Q(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public void sendRequestHeaders(long r10, CronetBidirectionalStream r11) {
        kf.a.R(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public int start(long r10, CronetBidirectionalStream r11, String r12, int r13, String r14, String[] r15, boolean r16) {
        return kf.a.S(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public boolean writevData(long r10, CronetBidirectionalStream r11, ByteBuffer[] r12, int[] r13, int[] r14, boolean r15) {
        return kf.a.T(r10, r11, r12, r13, r14, r15);
    }
}
