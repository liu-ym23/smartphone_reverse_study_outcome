package com.bytedance.safetyguard.lxc.internal.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ClientRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f11031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f11032d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (this.f11029a == r6.f11029a) goto L12;
        return false;
    L12:
        if (this.f11030b == r6.f11030b) goto L15;
        return false;
    L15:
        if (this.f11031c == r6.f11031c) goto L18;
        return false;
    L18:
        if (this.f11032d == r6.f11032d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f11029a) * 31) + Integer.hashCode(this.f11030b)) * 31) + Integer.hashCode(this.f11031c)) * 31) + Integer.hashCode(this.f11032d);
    }

    public String toString() {
        return "ClientRegistrySnapshot(clientCount=" + this.f11029a + ", attachmentCount=" + this.f11030b + ", sidecarOperationCount=" + this.f11031c + ", sidecarSessionCount=" + this.f11032d + ')';
    }

    public i(int r1, int r2, int r3, int r4) {
        this.f11029a = r1;
        this.f11030b = r2;
        this.f11031c = r3;
        this.f11032d = r4;
    }

    public final int a() {
        return this.f11029a;
    }

    public final int b() {
        return this.f11030b;
    }
}
