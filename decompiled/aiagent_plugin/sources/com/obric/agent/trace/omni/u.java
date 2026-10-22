package com.obric.agent.trace.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ReportBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f15711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f15712b;

    public static /* synthetic */ u a(u r0, long r1, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.f15711a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.f15712b;
    L9:
        return r0.a(r1, r3);
    }

    public final u a(long r1, long r3) {
        return new u(r1, r3);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, u.class) == true) goto L8;
        return false;
    L8:
        u r10 = (u) ZeusTransformUtils.preCheckCast(r9, u.class, "com.obric.aiagent.plugin");
        if (this.f15711a == r10.f15711a) goto L12;
        return false;
    L12:
        if (this.f15712b == r10.f15712b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f15711a) * 31) + Long.hashCode(this.f15712b);
    }

    public String toString() {
        return "ReportTakingOverBean(takingOverStart=" + this.f15711a + ", takingOverEnd=" + this.f15712b + ')';
    }

    public u(long r1, long r3) {
        this.f15711a = r1;
        this.f15712b = r3;
    }

    public /* synthetic */ u(long r1, long r3, int r5, d.h.b.h r6) {
        if ((r5 & 2) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r3);
    }

    public final long a() {
        return this.f15711a;
    }

    public final long b() {
        return this.f15712b;
    }
}
