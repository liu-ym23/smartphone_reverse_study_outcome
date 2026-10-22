package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniClientIntentPendingTrace.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f15873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f15874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Boolean f15876d;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
        if (this.f15873a == r10.f15873a) goto L12;
        return false;
    L12:
        if (this.f15874b == r10.f15874b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15875c, r10.f15875c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f15876d, r10.f15876d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((Long.hashCode(this.f15873a) * 31) + Long.hashCode(this.f15874b)) * 31;
        String r1 = this.f15875c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Boolean r5 = this.f15876d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniClientIntentPendingStart(t00ElapsedMs=" + this.f15873a + ", clientReceivePushTimestampMs=" + this.f15874b + ", omniTaskStateAtPush=" + this.f15875c + ", isOmniTaskActiveAtPush=" + this.f15876d + ')';
    }

    public d(long r1, long r3, String r5, Boolean r6) {
        this.f15873a = r1;
        this.f15874b = r3;
        this.f15875c = r5;
        this.f15876d = r6;
    }

    public final long a() {
        return this.f15873a;
    }

    public final long b() {
        return this.f15874b;
    }

    public final String c() {
        return this.f15875c;
    }

    public final Boolean d() {
        return this.f15876d;
    }
}
