package com.bytedance.safetyguard.lxc.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StreamContext.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.c.c f10152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10155e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private final Object j;
    private final Object k;
    private final int l;
    private final int m;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ag.class) == true) goto L8;
        return false;
    L8:
        ag r6 = (ag) ZeusTransformUtils.preCheckCast(r5, ag.class, "com.obric.aiagent.plugin");
        if (this.f10151a == r6.f10151a) goto L12;
        return false;
    L12:
        if (this.f10152b == r6.f10152b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f10153c, r6.f10153c) == true) goto L18;
        return false;
    L18:
        if (this.f10154d == r6.f10154d) goto L21;
        return false;
    L21:
        if (this.f10155e == r6.f10155e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.f10151a) * 31) + this.f10152b.hashCode()) * 31) + this.f10153c.hashCode()) * 31) + Integer.hashCode(this.f10154d)) * 31) + Integer.hashCode(this.f10155e)) * 31) + Integer.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i);
    }

    public String toString() {
        return "StreamContext(streamId=" + this.f10151a + ", ingress=" + this.f10152b + ", targetHost=" + this.f10153c + ", targetPort=" + this.f10154d + ", sendWindow=" + this.f10155e + ", recvWindow=" + this.f + ", localSendClosed=" + this.g + ", peerSendClosed=" + this.h + ", closed=" + this.i + ')';
    }

    public ag(int r2, com.bytedance.safetyguard.lxc.internal.c.c r3, String r4, int r5, int r6, int r7, boolean r8, boolean r9, boolean r10) {
        d.h.b.o.e(r3, "ingress");
        d.h.b.o.e(r4, "targetHost");
        this.f10151a = r2;
        this.f10152b = r3;
        this.f10153c = r4;
        this.f10154d = r5;
        this.f10155e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = new Object();
        this.k = new Object();
        this.l = this.f10155e;
        this.m = this.f;
    }

    public /* synthetic */ ag(int r14, com.bytedance.safetyguard.lxc.internal.c.c r15, String r16, int r17, int r18, int r19, boolean r20, boolean r21, boolean r22, int r23, d.h.b.h r24) {
        if ((r23 & 64) == 0) goto L5;
        boolean r10 = false;
    L7:
        if ((r23 & 128) == 0) goto L9;
        boolean r11 = false;
    L11:
        if ((r23 & 256) == 0) goto L13;
        boolean r12 = false;
    L14:
        this(r14, r15, r16, r17, r18, r19, r10, r11, r12);
        return;
    L13:
        r12 = r22;
        goto L14
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }

    public final int a() {
        return this.f10151a;
    }

    public final com.bytedance.safetyguard.lxc.internal.c.c b() {
        return this.f10152b;
    }

    public final int c() {
        return this.f;
    }

    public final void a(boolean r1) {
        this.g = r1;
    }

    public final void b(boolean r1) {
        this.h = r1;
    }

    public final boolean d() {
        return this.h;
    }

    public final boolean e() {
        return this.i;
    }

    public final void a(int r5) {
        if (r5 < 0) goto L17;
        Object r2 = this.k;
        monitor-enter(r2);
        int r3 = this.f;     // Catch: Throwable -> L13
        if (r5 > r3) goto L12;
        this.f = r3 - r5;     // Catch: Throwable -> L13
        d.x r4 = d.x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(r2);
        return;
    L12:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("DATA exceeds receive window", null, 2, null);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("bytes must not be negative", null, 2, null);
    }

    public final void b(int r8) {
        if (r8 <= 0) goto L17;
        Object r2 = this.k;
        monitor-enter(r2);
        long r3 = ((long) this.f) + ((long) r8);     // Catch: Throwable -> L13
        if (r3 > this.m) goto L12;
        this.f = (int) r3;     // Catch: Throwable -> L13
        d.x r7 = d.x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(r2);
        return;
    L12:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Receive window exceeds negotiated limit", null, 2, null);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("bytes must be positive", null, 2, null);
    }

    public final void c(int r7) {
        if (r7 <= 0) goto L21;
        Object r2 = this.j;
        monitor-enter(r2);
    L22:
        boolean r3 = this.i;     // Catch: Throwable -> L17
        if (r3 == true) goto L11;
        if (r7 <= this.f10155e) goto L11;
        this.j.wait(1000);     // Catch: Throwable -> L17
    L11:
        if (r3 == true) goto L16;
        this.f10155e -= r7;     // Catch: Throwable -> L17
        d.x r6 = d.x.f38692a;     // Catch: Throwable -> L17
        monitor-exit(r2);
        return;
    L16:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Stream is closed: " + this.f10151a, null, 2, null);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L21:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("bytes must be positive", null, 2, null);
    }

    public final void d(int r8) {
        if (r8 <= 0) goto L17;
        Object r2 = this.j;
        monitor-enter(r2);
        long r3 = ((long) this.f10155e) + ((long) r8);     // Catch: Throwable -> L13
        if (r3 > this.l) goto L12;
        this.f10155e = (int) r3;     // Catch: Throwable -> L13
        this.j.notifyAll();     // Catch: Throwable -> L13
        d.x r7 = d.x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(r2);
        return;
    L12:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Send window exceeds negotiated limit", null, 2, null);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("bytes must be positive", null, 2, null);
    }

    public final void f() {
        Object r0 = this.j;
        monitor-enter(r0);
        this.i = true;     // Catch: Throwable -> L8
        this.j.notifyAll();     // Catch: Throwable -> L8
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final boolean g() {
        if (this.g == true) goto L5;
    L7:
        return false;
    L5:
        if (this.h == false) goto L7;
        return true;
    }
}
