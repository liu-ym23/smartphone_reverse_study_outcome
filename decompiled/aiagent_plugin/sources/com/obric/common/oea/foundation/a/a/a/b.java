package com.obric.common.oea.foundation.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ISmoothCornerImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f32263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f32264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f32265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f32266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f32267e;
    private final float f;

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L19;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
        if (Float.compare(this.f32263a, r4.f32263a) == 0) goto L9;
        return false;
    L9:
        if (Float.compare(this.f32264b, r4.f32264b) == 0) goto L11;
        return false;
    L11:
        if (Float.compare(this.f32265c, r4.f32265c) == 0) goto L13;
        return false;
    L13:
        if (Float.compare(this.f32266d, r4.f32266d) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f32267e, r4.f32267e) == 0) goto L17;
        return false;
    L17:
        if (Float.compare(this.f, r4.f) == 0) goto L29;
        return false;
    L29:
        return true;
    L19:
        return false;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.f32263a) * 31) + Float.hashCode(this.f32264b)) * 31) + Float.hashCode(this.f32265c)) * 31) + Float.hashCode(this.f32266d)) * 31) + Float.hashCode(this.f32267e)) * 31) + Float.hashCode(this.f);
    }

    public String toString() {
        return "ControlPoint(handleLarge=" + this.f32263a + ", distanceOuter=" + this.f32264b + ", distanceInner=" + this.f32265c + ", handleMedium=" + this.f32266d + ", curveInner=" + this.f32267e + ", curveOuter=" + this.f + ")";
    }

    public b(float r1, float r2, float r3, float r4, float r5, float r6) {
        this.f32263a = r1;
        this.f32264b = r2;
        this.f32265c = r3;
        this.f32266d = r4;
        this.f32267e = r5;
        this.f = r6;
    }

    public final float a() {
        return this.f32263a;
    }

    public final float b() {
        return this.f32264b;
    }

    public final float c() {
        return this.f32265c;
    }

    public final float d() {
        return this.f32266d;
    }

    public final float e() {
        return this.f32267e;
    }

    public final float f() {
        return this.f;
    }
}
