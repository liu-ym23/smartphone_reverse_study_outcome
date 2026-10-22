package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f19165e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ae.class) == true) goto L8;
        return false;
    L8:
        ae r10 = (ae) ZeusTransformUtils.preCheckCast(r9, ae.class, "com.obric.aiagent.plugin");
        if (this.f19161a == r10.f19161a) goto L12;
        return false;
    L12:
        if (this.f19162b == r10.f19162b) goto L15;
        return false;
    L15:
        if (this.f19163c == r10.f19163c) goto L18;
        return false;
    L18:
        if (this.f19164d == r10.f19164d) goto L21;
        return false;
    L21:
        if (this.f19165e == r10.f19165e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((Long.hashCode(this.f19161a) * 31) + Long.hashCode(this.f19162b)) * 31) + Long.hashCode(this.f19163c)) * 31) + Integer.hashCode(this.f19164d)) * 31) + Integer.hashCode(this.f19165e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i);
    }

    public String toString() {
        return "SkillProjectionPreparationMetrics(managerInitializeDurationMs=" + this.f19161a + ", admissionDurationMs=" + this.f19162b + ", hostPrepareDurationMs=" + this.f19163c + ", installedCount=" + this.f19164d + ", admittedCount=" + this.f19165e + ", rejectedCount=" + this.f + ", preparationAttemptedCount=" + this.g + ", preparationFailedCount=" + this.h + ", cliToolCount=" + this.i + ')';
    }

    public ae(long r1, long r3, long r5, int r7, int r8, int r9, int r10, int r11, int r12) {
        this.f19161a = r1;
        this.f19162b = r3;
        this.f19163c = r5;
        this.f19164d = r7;
        this.f19165e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
    }

    public final long a() {
        return this.f19161a;
    }

    public final long b() {
        return this.f19162b;
    }

    public final long c() {
        return this.f19163c;
    }

    public final int d() {
        return this.f19164d;
    }

    public final int e() {
        return this.f19165e;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public final int i() {
        return this.i;
    }
}
