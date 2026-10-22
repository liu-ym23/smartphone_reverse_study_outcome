package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements CronetUrlRequest.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CronetUrlRequest.Natives f18800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18801b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(CronetUrlRequest.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            f.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((CronetUrlRequest.Natives) r10);
        }
    }

    static {
        f18801b = new a();
    }

    public f() {
    }

    public static /* synthetic */ CronetUrlRequest.Natives a(CronetUrlRequest.Natives r10) {
        f18800a = r10;
        return r10;
    }

    public static CronetUrlRequest.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        CronetUrlRequest.Natives r10 = f18800a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new f();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void abortWhenUploadException(long r10, CronetUrlRequest r11) {
        kf.a.T0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void addRequestCookieHeader(long r10, CronetUrlRequest r11, String r12, String r13) {
        kf.a.U0(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean addRequestHeader(long r10, CronetUrlRequest r11, String r12, String r13) {
        return kf.a.V0(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void appTimeout(long r10, CronetUrlRequest r11) {
        kf.a.W0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public long createRequestAdapter(CronetUrlRequest r10, long r11, String r12, int r13, int r14, boolean r15, boolean r16, boolean r17, boolean r18, int r19, boolean r110, int r111) {
        return kf.a.X0(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void destroy(long r10, CronetUrlRequest r11, boolean r12) {
        kf.a.Y0(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void followDeferredRedirect(long r10, CronetUrlRequest r11) {
        kf.a.Z0(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void getStatus(long r10, CronetUrlRequest r11, VersionSafeCallbacks.UrlRequestStatusListener r12) {
        kf.a.a1(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean readData(long r10, CronetUrlRequest r11, ByteBuffer r12, int r13, int r14) {
        return kf.a.b1(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void removeRequestCookieHeader(long r10, CronetUrlRequest r11) {
        kf.a.c1(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean setHttpMethod(long r10, CronetUrlRequest r11, String r12) {
        return kf.a.d1(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setRequestTimeout(long r10, CronetUrlRequest r11, int r12) {
        kf.a.e1(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setSocketTimeout(long r10, CronetUrlRequest r11, int r12, int r13, int r14) {
        kf.a.f1(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setThrottleNetSpeed(long r10, CronetUrlRequest r11, long r12) {
        kf.a.g1(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void start(long r10, CronetUrlRequest r11) {
        kf.a.h1(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void stopRedirect(long r10, CronetUrlRequest r11) {
        kf.a.i1(r10, r11);
    }
}
