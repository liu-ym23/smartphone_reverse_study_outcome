package com.ttnet.org.chromium.net.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: CronetWebsocketConnectionJni.java */
/* JADX INFO: loaded from: classes4.dex */
class p implements CronetWebsocketConnection.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<CronetWebsocketConnection.a> f38159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CronetWebsocketConnection.a f38160b;

    p() {
    }

    static {
        f38159a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.a
    public long a(CronetWebsocketConnection r1, long r2) {
        return com.ttnet.org.chromium.base.b.a.a(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.a
    public void a(long r1, CronetWebsocketConnection r3, int r4, String r5, long r6, int r8, long r9, String r11, int r12, String r13, boolean r14) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5, r6, r8, r9, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.a
    public void a(long r1, CronetWebsocketConnection r3, boolean r4) {
        com.ttnet.org.chromium.base.b.a.f(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.a
    public void a(long r1, CronetWebsocketConnection r3) {
        com.ttnet.org.chromium.base.b.a.m(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.a
    public void a(long r1, CronetWebsocketConnection r3, String r4) {
        com.ttnet.org.chromium.base.b.a.f(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.a
    public void a(long r1, CronetWebsocketConnection r3, ByteBuffer r4) {
        com.ttnet.org.chromium.base.b.a.c(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.a
    public void b(long r1, CronetWebsocketConnection r3) {
        com.ttnet.org.chromium.base.b.a.n(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.a
    public void b(long r1, CronetWebsocketConnection r3, String r4) {
        com.ttnet.org.chromium.base.b.a.g(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.a
    public void a(long r1, CronetWebsocketConnection r3, String r4, String r5) {
        com.ttnet.org.chromium.base.b.a.f(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.a
    public void b(long r1, CronetWebsocketConnection r3, String r4, String r5) {
        com.ttnet.org.chromium.base.b.a.g(r1, r3, r4, r5);
    }

    public static CronetWebsocketConnection.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        CronetWebsocketConnection.a r0 = f38160b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new p();
    }
}
