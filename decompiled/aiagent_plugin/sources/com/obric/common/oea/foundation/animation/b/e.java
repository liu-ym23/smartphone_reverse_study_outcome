package com.obric.common.oea.foundation.animation.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SpringSimulation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f32324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f32325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f32326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f32327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f32328e;
    private float f;
    private float g;

    public e(float r3) {
        this.g = r3;
        this.f32324a = Math.sqrt(50.0f);
        this.f = 1.0f;
    }

    public final void c(float r1) {
        this.g = r1;
    }

    public final void a(float r5) {
        if (a() <= 0) goto L7;
        this.f32324a = Math.sqrt(r5);
        this.f32325b = false;
        return;
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Spring stiffness constant must be positive."), Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final float a() {
        double r0 = this.f32324a;
        return (float) (r0 * r0);
    }

    public final float b() {
        return this.f;
    }

    public final void b(float r3) {
        if (r3 < 0) goto L7;
        this.f = r3;
        this.f32325b = false;
        return;
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Damping ratio must be non-negative"), Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final void c() {
        if (this.f32325b == false) goto L6;
        return;
    L6:
        if (this.g == f.a()) goto L18;
        float r0 = this.f;
        double r1 = ((double) r0) * ((double) r0);
        float r4 = 1;
        if (r0 <= r4) goto L11;
        double r6 = this.f32324a;
        double r2 = r1 - ((double) 1);
        this.f32326c = (((double) (-r0)) * r6) + (r6 * Math.sqrt(r2));
        double r5 = -this.f;
        double r7 = this.f32324a;
        this.f32327d = (r5 * r7) - (r7 * Math.sqrt(r2));
    L15:
        this.f32325b = true;
        return;
    L11:
        if (r0 < 0) goto L15;
        if (r0 >= r4) goto L15;
        this.f32328e = this.f32324a * Math.sqrt(((double) 1) - r1);
        goto L15
    L18:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Error: Final position of the spring must be set before the animation starts"), Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final d a(float r17, float r18, long r19) {
        c();
        double r2 = r19 / 1000.0d;
        float r4 = r17 - this.g;
        float r5 = this.f;
        if (r5 <= 1) goto L6;
        double r6 = r4;
        double r7 = this.f32327d;
        double r10 = r18;
        double r12 = this.f32326c;
        double r8 = r6 - (((r7 * r6) - r10) / (r7 - r12));
        double r9 = ((r6 * r7) - r10) / (r7 - r12);
        double r11 = (Math.exp(r7 * r2) * r8) + (Math.exp(this.f32326c * r2) * r9);
        double r13 = this.f32327d;
        double r14 = (r8 * r13) * Math.exp(r13 * r2);
        double r15 = this.f32326c;
        double r16 = r14 + ((r9 * r15) * Math.exp(r15 * r2));
    L10:
        return f.a((float) (r11 + ((double) this.g)), (float) r16);
    L6:
        if (r5 != 1.0f) goto L8;
        double r20 = this.f32324a;
        double r21 = r4;
        double r22 = ((double) r18) + (r20 * r21);
        double r23 = r21 + (r22 * r2);
        double r24 = Math.exp((-r20) * r2) * r23;
        double r25 = r23 * Math.exp((-this.f32324a) * r2);
        double r110 = this.f32324a;
        r11 = r24;
        r16 = (r25 * (-r110)) + (r22 * Math.exp((-r110) * r2));
        goto L10
    L8:
        double r26 = ((double) 1) / this.f32328e;
        double r111 = this.f32324a;
        double r112 = r4;
        double r27 = r26 * (((((double) r5) * r111) * r112) + ((double) r18));
        double r28 = Math.exp((((double) (-r5)) * r111) * r2) * ((Math.cos(this.f32328e * r2) * r112) + (Math.sin(this.f32328e * r2) * r27));
        double r29 = this.f32324a;
        float r1 = this.f;
        double r113 = ((-r29) * r28) * ((double) r1);
        double r30 = Math.exp((((double) (-r1)) * r29) * r2);
        double r114 = this.f32328e;
        double r31 = ((-r114) * r112) * Math.sin(r114 * r2);
        double r115 = this.f32328e;
        r16 = (r30 * (r31 + ((r27 * r115) * Math.cos(r115 * r2)))) + r113;
        r11 = r28;
        goto L10
    }
}
