package com.obric.common.oea.foundation.animation.g.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FloatSpringSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f32387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f32388b;

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == false) goto L11;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (Double.compare(this.f32387a, r6.f32387a) == 0) goto L9;
        return false;
    L9:
        if (Double.compare(this.f32388b, r6.f32388b) == 0) goto L17;
        return false;
    L17:
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        return (Double.hashCode(this.f32387a) * 31) + Double.hashCode(this.f32388b);
    }

    public String toString() {
        return "ComplexDouble(_real=" + this.f32387a + ", _imaginary=" + this.f32388b + ")";
    }

    public a(double r1, double r3) {
        this.f32387a = r1;
        this.f32388b = r3;
    }

    public static final /* synthetic */ double a(a r2) {
        return r2.f32387a;
    }

    public static final /* synthetic */ void a(a r0, double r1) {
        r0.f32387a = r1;
    }

    public static final /* synthetic */ double b(a r2) {
        return r2.f32388b;
    }

    public static final /* synthetic */ void b(a r0, double r1) {
        r0.f32388b = r1;
    }

    public final double a() {
        return this.f32387a;
    }

    public final double b() {
        return this.f32388b;
    }
}
