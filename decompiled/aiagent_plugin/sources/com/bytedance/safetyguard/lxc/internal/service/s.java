package com.bytedance.safetyguard.lxc.internal.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyFdKey.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11054b;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, s.class) == true) goto L8;
        return false;
    L8:
        s r10 = (s) ZeusTransformUtils.preCheckCast(r9, s.class, "com.obric.aiagent.plugin");
        if (this.f11053a == r10.f11053a) goto L12;
        return false;
    L12:
        if (this.f11054b == r10.f11054b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f11053a) * 31) + Long.hashCode(this.f11054b);
    }

    public String toString() {
        return "ProxyFdKey(device=" + this.f11053a + ", inode=" + this.f11054b + ')';
    }

    public s(long r1, long r3) {
        this.f11053a = r1;
        this.f11054b = r3;
    }

    public final long a() {
        return this.f11053a;
    }

    public final long b() {
        return this.f11054b;
    }
}
