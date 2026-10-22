package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements CronetWebsocketConnection.Natives {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CronetWebsocketConnection.Natives f18803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JniStaticTestMocker f18804b = null;

    public class a implements JniStaticTestMocker {
        public a() {
        }

        public void a(CronetWebsocketConnection.Natives r10) {
            if (kf.a.f21061a == false) goto L7;
            h.a(r10);
            return;
        L7:
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }

        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public /* bridge */ /* synthetic */ void setInstanceForTesting(Object r10) {
            a((CronetWebsocketConnection.Natives) r10);
        }
    }

    static {
        f18804b = new a();
    }

    public h() {
    }

    public static /* synthetic */ CronetWebsocketConnection.Natives a(CronetWebsocketConnection.Natives r10) {
        f18803a = r10;
        return r10;
    }

    public static CronetWebsocketConnection.Natives b() {
        if (kf.a.f21061a == false) goto L12;
        CronetWebsocketConnection.Natives r10 = f18803a;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (kf.a.f21062b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.a(false);
        return new h();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addGetParam(long r10, CronetWebsocketConnection r11, String r12, String r13) {
        kf.a.j1(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addHeader(long r10, CronetWebsocketConnection r11, String r12, String r13) {
        kf.a.k1(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addUrl(long r10, CronetWebsocketConnection r11, String r12) {
        kf.a.l1(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public long createWebsocketConnectionAdapter(CronetWebsocketConnection r10, long r11) {
        return kf.a.m1(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void destroy(long r10, CronetWebsocketConnection r11) {
        kf.a.n1(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void sendBinary(long r10, CronetWebsocketConnection r11, ByteBuffer r12) {
        kf.a.o1(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void sendText(long r10, CronetWebsocketConnection r11, String r12) {
        kf.a.p1(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void startWithFrontier(long r10, CronetWebsocketConnection r11, int r12, String r13, long r14, int r15, long r16, String r17, int r18, String r19, boolean r110) {
        kf.a.q1(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void startWithWSChannel(long r10, CronetWebsocketConnection r11, boolean r12) {
        kf.a.r1(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void stop(long r10, CronetWebsocketConnection r11) {
        kf.a.s1(r10, r11);
    }
}
