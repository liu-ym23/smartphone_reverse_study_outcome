package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxySessionStats.kt */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f10270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f10271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ProxySessionErrorCode f10272e;
    private final String f;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, u.class) == true) goto L8;
        return false;
    L8:
        u r10 = (u) ZeusTransformUtils.preCheckCast(r9, u.class, "com.obric.aiagent.plugin");
        if (this.f10268a == r10.f10268a) goto L12;
        return false;
    L12:
        if (this.f10269b == r10.f10269b) goto L15;
        return false;
    L15:
        if (this.f10270c == r10.f10270c) goto L18;
        return false;
    L18:
        if (this.f10271d == r10.f10271d) goto L21;
        return false;
    L21:
        if (this.f10272e == r10.f10272e) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((Integer.hashCode(this.f10268a) * 31) + Integer.hashCode(this.f10269b)) * 31) + Long.hashCode(this.f10270c)) * 31) + Long.hashCode(this.f10271d)) * 31;
        ProxySessionErrorCode r1 = this.f10272e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ProxySessionStatsSnapshot(openedStreamCount=" + this.f10268a + ", rejectedStreamCount=" + this.f10269b + ", bytesFromGateway=" + this.f10270c + ", bytesToGateway=" + this.f10271d + ", lastErrorCode=" + this.f10272e + ", lastErrorMessage=" + this.f + ')';
    }

    public u(int r1, int r2, long r3, long r5, ProxySessionErrorCode r7, String r8) {
        this.f10268a = r1;
        this.f10269b = r2;
        this.f10270c = r3;
        this.f10271d = r5;
        this.f10272e = r7;
        this.f = r8;
    }

    public final int a() {
        return this.f10268a;
    }

    public final int b() {
        return this.f10269b;
    }

    public final long c() {
        return this.f10270c;
    }

    public final long d() {
        return this.f10271d;
    }

    public final ProxySessionErrorCode e() {
        return this.f10272e;
    }
}
