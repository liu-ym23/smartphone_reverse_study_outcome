package com.bytedance.safetyguard.lxc.internal.c;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HelloHandshake.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9846e;
    private final int f;
    private final a g;
    private final String h;
    private final boolean i;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, j.class) == true) goto L8;
        return false;
    L8:
        j r10 = (j) ZeusTransformUtils.preCheckCast(r9, j.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f9842a, r10.f9842a) == true) goto L12;
        return false;
    L12:
        if (this.f9843b == r10.f9843b) goto L15;
        return false;
    L15:
        if (this.f9844c == r10.f9844c) goto L18;
        return false;
    L18:
        if (this.f9845d == r10.f9845d) goto L21;
        return false;
    L21:
        if (this.f9846e == r10.f9846e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r10.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((this.f9842a.hashCode() * 31) + Long.hashCode(this.f9843b)) * 31) + Integer.hashCode(this.f9844c)) * 31) + Integer.hashCode(this.f9845d)) * 31) + Integer.hashCode(this.f9846e)) * 31) + Integer.hashCode(this.f)) * 31) + this.g.hashCode()) * 31;
        String r3 = this.h;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "ProxyHelloAck(sessionId=" + this.f9842a + ", acceptedFeatureBitmap=" + this.f9843b + ", maxFramePayload=" + this.f9844c + ", dataChunkSize=" + this.f9845d + ", streamWindow=" + this.f9846e + ", openResultTimeoutMs=" + this.f + ", resultCode=" + this.g + ", errorMessage=" + this.h + ')';
    }

    public j(String r2, long r3, int r5, int r6, int r7, int r8, a r9, String r10) {
        d.h.b.o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r9, "resultCode");
        this.f9842a = r2;
        this.f9843b = r3;
        this.f9844c = r5;
        this.f9845d = r6;
        this.f9846e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        if (r9 != a.f9808b) goto L5;
        boolean r4 = true;
    L6:
        this.i = r4;
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final String a() {
        return this.f9842a;
    }

    public final long b() {
        return this.f9843b;
    }

    public final int c() {
        return this.f9844c;
    }

    public final int d() {
        return this.f9845d;
    }

    public final int e() {
        return this.f9846e;
    }

    public final int f() {
        return this.f;
    }

    public /* synthetic */ j(String r13, long r14, int r16, int r17, int r18, int r19, a r20, String r21, int r22, d.h.b.h r23) {
        if ((r22 & 32) == 0) goto L5;
        int r9 = 300000;
    L7:
        if ((r22 & 64) == 0) goto L9;
        a r10 = a.f9808b;
    L11:
        if ((r22 & 128) == 0) goto L13;
        String r11 = null;
    L14:
        this(r13, r14, r16, r17, r18, r9, r10, r11);
        return;
    L13:
        r11 = r21;
        goto L14
    L9:
        r10 = r20;
        goto L11
    L5:
        r9 = r19;
        goto L7
    }

    public final a g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final boolean i() {
        return this.i;
    }
}
