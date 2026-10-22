package com.ttnet.org.chromium.net.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: CronetBidirectionalStreamJni.java */
/* JADX INFO: loaded from: classes4.dex */
class c implements CronetBidirectionalStream.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<CronetBidirectionalStream.a> f38119a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CronetBidirectionalStream.a f38120b;

    c() {
    }

    static {
        f38119a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.a
    public boolean a(long r1, CronetBidirectionalStream r3, ByteBuffer[] r4, int[] r5, int[] r6, boolean r7) {
        return com.ttnet.org.chromium.base.b.a.a(r1, r3, r4, r5, r6, r7);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.a
    public void a(long r1, CronetBidirectionalStream r3, boolean r4) {
        com.ttnet.org.chromium.base.b.a.a(r1, r3, r4);
    }

    public static CronetBidirectionalStream.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        CronetBidirectionalStream.a r0 = f38120b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new c();
    }
}
