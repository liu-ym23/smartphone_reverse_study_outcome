package com.bytedance.safetyguard.lxc.internal.client;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f10008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f10012e;
    private final int f;
    private final int g;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, o.class) == true) goto L8;
        return false;
    L8:
        o r10 = (o) ZeusTransformUtils.preCheckCast(r9, o.class, "com.obric.aiagent.plugin");
        if (this.f10008a == r10.f10008a) goto L12;
        return false;
    L12:
        if (this.f10009b == r10.f10009b) goto L15;
        return false;
    L15:
        if (this.f10010c == r10.f10010c) goto L18;
        return false;
    L18:
        if (this.f10011d == r10.f10011d) goto L21;
        return false;
    L21:
        if (this.f10012e == r10.f10012e) goto L24;
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
        return (((((((((((this.f10008a.hashCode() * 31) + Long.hashCode(this.f10009b)) * 31) + Integer.hashCode(this.f10010c)) * 31) + Integer.hashCode(this.f10011d)) * 31) + Integer.hashCode(this.f10012e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g);
    }

    public String toString() {
        return "ProxyServiceConnectorSnapshot(state=" + this.f10008a + ", bindingGeneration=" + this.f10009b + ", pendingRequestCount=" + this.f10010c + ", proxyAttachmentLeases=" + this.f10011d + ", sidecarOperationLeases=" + this.f10012e + ", sidecarSessionLeases=" + this.f + ", retainedBackupFdCount=" + this.g + ')';
    }

    public o(g r2, long r3, int r5, int r6, int r7, int r8, int r9) {
        d.h.b.o.e(r2, "state");
        this.f10008a = r2;
        this.f10009b = r3;
        this.f10010c = r5;
        this.f10011d = r6;
        this.f10012e = r7;
        this.f = r8;
        this.g = r9;
    }

    public final g a() {
        return this.f10008a;
    }

    public final int b() {
        return (this.f10011d + this.f10012e) + this.f;
    }
}
