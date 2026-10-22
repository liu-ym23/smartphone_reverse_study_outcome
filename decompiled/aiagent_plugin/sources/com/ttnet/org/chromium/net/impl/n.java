package com.ttnet.org.chromium.net.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: CronetUrlRequestJni.java */
/* JADX INFO: loaded from: classes4.dex */
class n implements CronetUrlRequest.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<CronetUrlRequest.a> f38156a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CronetUrlRequest.a f38157b;

    n() {
    }

    static {
        f38156a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public long a(CronetUrlRequest r1, long r2, String r4, int r5, int r6, boolean r7, boolean r8, boolean r9, int r10, boolean r11, int r12, int r13, long r14) {
        return com.ttnet.org.chromium.base.b.a.a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public boolean a(long r1, CronetUrlRequest r3, String r4) {
        return com.ttnet.org.chromium.base.b.a.a(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public boolean a(long r1, CronetUrlRequest r3, String r4, String r5) {
        return com.ttnet.org.chromium.base.b.a.b(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void a(long r1, CronetUrlRequest r3) {
        com.ttnet.org.chromium.base.b.a.d(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void b(long r1, CronetUrlRequest r3) {
        com.ttnet.org.chromium.base.b.a.e(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public boolean a(long r1, CronetUrlRequest r3, ByteBuffer r4, int r5, int r6) {
        return com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void a(long r1, CronetUrlRequest r3, boolean r4) {
        com.ttnet.org.chromium.base.b.a.c(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void c(long r1, CronetUrlRequest r3) {
        com.ttnet.org.chromium.base.b.a.f(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void d(long r1, CronetUrlRequest r3) {
        com.ttnet.org.chromium.base.b.a.g(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void b(long r1, CronetUrlRequest r3, String r4, String r5) {
        com.ttnet.org.chromium.base.b.a.c(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void e(long r1, CronetUrlRequest r3) {
        com.ttnet.org.chromium.base.b.a.h(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void a(long r1, CronetUrlRequest r3, int r4, int r5, int r6) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void a(long r1, CronetUrlRequest r3, int r4) {
        com.ttnet.org.chromium.base.b.a.e(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void a(long r1, CronetUrlRequest r3, long r4) {
        com.ttnet.org.chromium.base.b.a.b(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void b(long r1, CronetUrlRequest r3, int r4) {
        com.ttnet.org.chromium.base.b.a.f(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void c(long r1, CronetUrlRequest r3, String r4, String r5) {
        com.ttnet.org.chromium.base.b.a.d(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.a
    public void a(long r1, CronetUrlRequest r3, VersionSafeCallbacks.UrlRequestStatusListener r4) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4);
    }

    public static CronetUrlRequest.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        CronetUrlRequest.a r0 = f38157b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new n();
    }
}
