package com.ttnet.org.chromium.net.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: CronetFrontierClientJni.java */
/* JADX INFO: loaded from: classes4.dex */
class f implements CronetFrontierClient.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<CronetFrontierClient.d> f38121a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CronetFrontierClient.d f38122b;

    f() {
    }

    static {
        f38121a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.d
    public long a(CronetFrontierClient r1) {
        return com.ttnet.org.chromium.base.b.a.a(r1);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.d
    public void a(long r1, CronetFrontierClient r3, String r4, String r5) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.d
    public void a(long r1, CronetFrontierClient r3, int r4) {
        com.ttnet.org.chromium.base.b.a.d(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.d
    public void a(long r1, CronetFrontierClient r3, int r4, int r5, String r6, int r7, String r8, String r9, String r10, String r11, int r12, int r13, int r14, boolean r15, String r16, String r17) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.d
    public void a(long r1, CronetFrontierClient r3, String[] r4, ByteBuffer r5, int r6, int r7, boolean r8) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5, r6, r7, r8);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.d
    public void a(long r1, CronetFrontierClient r3, int r4, String[] r5, ByteBuffer r6) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.d
    public void a(long r1, CronetFrontierClient r3, boolean r4) {
        com.ttnet.org.chromium.base.b.a.b(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.d
    public void a(long r1, CronetFrontierClient r3) {
        com.ttnet.org.chromium.base.b.a.b(r1, r3);
    }

    public static CronetFrontierClient.d a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        CronetFrontierClient.d r0 = f38122b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new f();
    }
}
