package com.bytedance.safetyguard.lxc.internal.c;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HelloHandshake.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f9839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9841e;
    private final int f;
    private final int g;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, i.class) == true) goto L8;
        return false;
    L8:
        i r10 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f9837a, r10.f9837a) == true) goto L12;
        return false;
    L12:
        if (this.f9838b == r10.f9838b) goto L15;
        return false;
    L15:
        if (this.f9839c == r10.f9839c) goto L18;
        return false;
    L18:
        if (this.f9840d == r10.f9840d) goto L21;
        return false;
    L21:
        if (this.f9841e == r10.f9841e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.f9837a.hashCode() * 31) + Long.hashCode(this.f9838b)) * 31) + Long.hashCode(this.f9839c)) * 31) + Integer.hashCode(this.f9840d)) * 31) + Integer.hashCode(this.f9841e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g);
    }

    public String toString() {
        return "ProxyHello(sessionId=" + this.f9837a + ", featureBitmap=" + this.f9838b + ", requiredFeatureBitmap=" + this.f9839c + ", maxFramePayload=" + this.f9840d + ", dataChunkSize=" + this.f9841e + ", streamWindow=" + this.f + ", openResultTimeoutMs=" + this.g + ')';
    }

    public i(String r2, long r3, long r5, int r7, int r8, int r9, int r10) {
        d.h.b.o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        this.f9837a = r2;
        this.f9838b = r3;
        this.f9839c = r5;
        this.f9840d = r7;
        this.f9841e = r8;
        this.f = r9;
        this.g = r10;
    }

    public final String a() {
        return this.f9837a;
    }

    public final long b() {
        return this.f9838b;
    }

    public final long c() {
        return this.f9839c;
    }

    public final int d() {
        return this.f9840d;
    }

    public final int e() {
        return this.f9841e;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }
}
