package com.obric.aiagent.skill.ovirt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IOVirtService.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f20998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f20999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f21000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f21001d;

    public g() {
        this(0, 0, 0, 0, 15, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
        return false;
    L8:
        g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
        if (this.f20998a == r10.f20998a) goto L12;
        return false;
    L12:
        if (this.f20999b == r10.f20999b) goto L15;
        return false;
    L15:
        if (this.f21000c == r10.f21000c) goto L18;
        return false;
    L18:
        if (this.f21001d == r10.f21001d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f20998a) * 31) + Long.hashCode(this.f20999b)) * 31) + Long.hashCode(this.f21000c)) * 31) + Long.hashCode(this.f21001d);
    }

    public String toString() {
        return "TaskActivationMetrics(totalDurationMs=" + this.f20998a + ", cleanupDurationMs=" + this.f20999b + ", openingDurationMs=" + this.f21000c + ", projectionDurationMs=" + this.f21001d + ')';
    }

    public g(long r1, long r3, long r5, long r7) {
        this.f20998a = r1;
        this.f20999b = r3;
        this.f21000c = r5;
        this.f21001d = r7;
    }

    public /* synthetic */ g(long r3, long r5, long r7, long r9, int r11, d.h.b.h r12) {
        if ((r11 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r7 = 0;
    L12:
        if ((r11 & 8) == 0) goto L14;
        r9 = 0;
    L14:
        this(r3, r5, r7, r9);
    }

    public final long a() {
        return this.f20998a;
    }

    public final long b() {
        return this.f20999b;
    }

    public final long c() {
        return this.f21000c;
    }

    public final long d() {
        return this.f21001d;
    }
}
