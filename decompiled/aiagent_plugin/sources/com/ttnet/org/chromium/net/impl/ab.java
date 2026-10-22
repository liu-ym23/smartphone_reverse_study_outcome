package com.ttnet.org.chromium.net.impl;

/* JADX INFO: compiled from: TTCronetNetExpRequestJni.java */
/* JADX INFO: loaded from: classes4.dex */
class ab implements TTCronetNetExpRequest.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ttnet.org.chromium.base.i<TTCronetNetExpRequest.a> f38082a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static TTCronetNetExpRequest.a f38083b;

    ab() {
    }

    static {
        f38082a = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.a
    public long a(TTCronetNetExpRequest r1, long r2, int r4, String[] r5, int r6, int r7, int r8) {
        return com.ttnet.org.chromium.base.b.a.a(r1, r2, r4, r5, r6, r7, r8);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.a
    public void a(long r1, TTCronetNetExpRequest r3) {
        com.ttnet.org.chromium.base.b.a.o(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.a
    public void b(long r1, TTCronetNetExpRequest r3) {
        com.ttnet.org.chromium.base.b.a.p(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.a
    public void a(long r1, TTCronetNetExpRequest r3, String r4, String r5) {
        com.ttnet.org.chromium.base.b.a.h(r1, r3, r4, r5);
    }

    public static TTCronetNetExpRequest.a a() {
        if (com.ttnet.org.chromium.base.b.a.f37694a == false) goto L12;
        TTCronetNetExpRequest.a r0 = f38083b;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (com.ttnet.org.chromium.base.b.a.f37695b == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        com.ttnet.org.chromium.base.l.a(false);
        return new ab();
    }
}
