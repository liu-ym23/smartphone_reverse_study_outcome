package com.obric.agent.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ClientToolReportHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f16040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f16041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f16042c;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, k.class) == true) goto L8;
        return false;
    L8:
        k r10 = (k) ZeusTransformUtils.preCheckCast(r9, k.class, "com.obric.aiagent.plugin");
        if (this.f16040a == r10.f16040a) goto L12;
        return false;
    L12:
        if (this.f16041b == r10.f16041b) goto L15;
        return false;
    L15:
        if (this.f16042c == r10.f16042c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f16040a) * 31) + Long.hashCode(this.f16041b)) * 31) + Long.hashCode(this.f16042c);
    }

    public String toString() {
        return "ClientToolTiming(duration=" + this.f16040a + ", startTime=" + this.f16041b + ", endTime=" + this.f16042c + ')';
    }

    public k(long r1, long r3, long r5) {
        this.f16040a = r1;
        this.f16041b = r3;
        this.f16042c = r5;
    }

    public final long a() {
        return this.f16040a;
    }

    public final long b() {
        return this.f16041b;
    }

    public final long c() {
        return this.f16042c;
    }
}
