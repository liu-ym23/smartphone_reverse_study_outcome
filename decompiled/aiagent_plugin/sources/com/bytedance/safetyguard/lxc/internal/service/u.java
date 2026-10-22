package com.bytedance.safetyguard.lxc.internal.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyFdKey.kt */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f11057c;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, u.class) == true) goto L8;
        return false;
    L8:
        u r10 = (u) ZeusTransformUtils.preCheckCast(r9, u.class, "com.obric.aiagent.plugin");
        if (this.f11055a == r10.f11055a) goto L12;
        return false;
    L12:
        if (this.f11056b == r10.f11056b) goto L15;
        return false;
    L15:
        if (this.f11057c == r10.f11057c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f11055a) * 31) + Long.hashCode(this.f11056b)) * 31) + Integer.hashCode(this.f11057c);
    }

    public String toString() {
        return "ProxyFdStat(device=" + this.f11055a + ", inode=" + this.f11056b + ", mode=" + this.f11057c + ')';
    }

    public u(long r1, long r3, int r5) {
        this.f11055a = r1;
        this.f11056b = r3;
        this.f11057c = r5;
    }

    public final long a() {
        return this.f11055a;
    }

    public final long b() {
        return this.f11056b;
    }

    public final int c() {
        return this.f11057c;
    }
}
