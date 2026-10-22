package com.obric.common.oea.foundation.animation.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OEasing.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f32422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f32423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f32424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f32425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f32426e;
    private final float f;

    public b(float r7, float r8, float r9, float r10) {
        this.f32424c = r7;
        this.f32425d = r8;
        this.f32426e = r9;
        this.f = r10;
        com.obric.common.oea.foundation.animation.i.a r11 = d.a(0.0f, r8, r10, 1.0f, new float[5], 0);
        this.f32422a = Float.intBitsToFloat((int) (r11.f32449a >> 32));
        this.f32423b = Float.intBitsToFloat((int) (r11.f32449a & 4294967295L));
    }

    @Override // com.obric.common.oea.foundation.animation.h.c
    public float a(float r5) {
        if (r5 > 0.0f) goto L5;
        return r5;
    L5:
        if (r5 >= 1.0f) goto L17;
        float r0 = d.a(0.0f - r5, this.f32424c - r5, this.f32426e - r5, 1.0f - r5);
        if (Float.isNaN(r0) == false) goto L9;
        b(r5);
    L9:
        float r6 = d.a(this.f32425d, this.f, r0);
        float r1 = this.f32422a;
        float r4 = this.f32423b;
        if (r6 >= r1) goto L13;
        r6 = r1;
    L13:
        if (r6 > r4) goto L15;
        return r6;
    L15:
        return r4;
    L17:
        return r5;
    }

    private final void b(float r5) {
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("The cubic curve with parameters (" + this.f32424c + ", " + this.f32425d + ", " + this.f32426e + ", " + this.f + ") has no solution at " + r5), Throwable.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (this.f32424c != ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin")).f32424c) goto L13;
        if (this.f32425d != ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin")).f32425d) goto L13;
        if (this.f32426e != ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin")).f32426e) goto L13;
        if (this.f != ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin")).f) goto L13;
        return true;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f32424c) * 31) + Float.hashCode(this.f32425d)) * 31) + Float.hashCode(this.f32426e)) * 31) + Float.hashCode(this.f);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.f32424c + ", b=" + this.f32425d + ", c=" + this.f32426e + ", d=" + this.f + ')';
    }
}
