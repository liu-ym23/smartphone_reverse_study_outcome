package com.obric.agent.trace.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ReportBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f15701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f15702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f15703c;

    public static /* synthetic */ r a(r r7, long r8, long r10, long r12, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.f15701a;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = r7.f15702b;
    L8:
        long r3 = r10;
        if ((r14 & 4) == 0) goto L12;
        r12 = r7.f15703c;
    L12:
        return r7.a(r1, r3, r12);
    }

    public final r a(long r8, long r10, long r12) {
        return new r(r8, r10, r12);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, r.class) == true) goto L8;
        return false;
    L8:
        r r10 = (r) ZeusTransformUtils.preCheckCast(r9, r.class, "com.obric.aiagent.plugin");
        if (this.f15701a == r10.f15701a) goto L12;
        return false;
    L12:
        if (this.f15702b == r10.f15702b) goto L15;
        return false;
    L15:
        if (this.f15703c == r10.f15703c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f15701a) * 31) + Long.hashCode(this.f15702b)) * 31) + Long.hashCode(this.f15703c);
    }

    public String toString() {
        return "ReportCallUserBean(callUserStart=" + this.f15701a + ", takingOverStart=" + this.f15702b + ", callUserEnd=" + this.f15703c + ')';
    }

    public r(long r1, long r3, long r5) {
        this.f15701a = r1;
        this.f15702b = r3;
        this.f15703c = r5;
    }

    public /* synthetic */ r(long r11, long r13, long r15, int r17, d.h.b.h r18) {
        if ((r17 & 2) == 0) goto L5;
        long r6 = 0;
    L7:
        if ((r17 & 4) == 0) goto L9;
        long r8 = 0;
    L10:
        this(r11, r6, r8);
        return;
    L9:
        r8 = r15;
        goto L10
    L5:
        r6 = r13;
        goto L7
    }

    public final long a() {
        return this.f15701a;
    }

    public final long b() {
        return this.f15702b;
    }

    public final long c() {
        return this.f15703c;
    }
}
