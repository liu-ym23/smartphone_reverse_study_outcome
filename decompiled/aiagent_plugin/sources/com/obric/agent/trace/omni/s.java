package com.obric.agent.trace.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ReportBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f15704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f15705b;

    public static /* synthetic */ s a(s r0, long r1, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.f15704a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.f15705b;
    L9:
        return r0.a(r1, r3);
    }

    public final s a(long r1, long r3) {
        return new s(r1, r3);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, s.class) == true) goto L8;
        return false;
    L8:
        s r10 = (s) ZeusTransformUtils.preCheckCast(r9, s.class, "com.obric.aiagent.plugin");
        if (this.f15704a == r10.f15704a) goto L12;
        return false;
    L12:
        if (this.f15705b == r10.f15705b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f15704a) * 31) + Long.hashCode(this.f15705b);
    }

    public String toString() {
        return "ReportClarifyBean(clarifyStart=" + this.f15704a + ", clarifyEnd=" + this.f15705b + ')';
    }

    public s(long r1, long r3) {
        this.f15704a = r1;
        this.f15705b = r3;
    }

    public /* synthetic */ s(long r1, long r3, int r5, d.h.b.h r6) {
        if ((r5 & 2) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r3);
    }

    public final long a() {
        return this.f15704a;
    }

    public final long b() {
        return this.f15705b;
    }
}
