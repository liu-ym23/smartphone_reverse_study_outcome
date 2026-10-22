package com.obric.common.oea.foundation.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ISmoothCornerImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f32273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f32274b;

    public final float c() {
        return this.f32273a;
    }

    public final float d() {
        return this.f32274b;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L11;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        if (Float.compare(this.f32273a, r4.f32273a) == 0) goto L9;
        return false;
    L9:
        if (Float.compare(this.f32274b, r4.f32274b) == 0) goto L17;
        return false;
    L17:
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        return (Float.hashCode(this.f32273a) * 31) + Float.hashCode(this.f32274b);
    }

    public String toString() {
        return "Point(x=" + this.f32273a + ", y=" + this.f32274b + ")";
    }

    public e(float r1, float r2) {
        this.f32273a = r1;
        this.f32274b = r2;
    }

    public final float a() {
        return this.f32273a;
    }

    public final float b() {
        return this.f32274b;
    }
}
