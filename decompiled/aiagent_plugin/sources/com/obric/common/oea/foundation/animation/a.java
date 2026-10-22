package com.obric.common.oea.foundation.animation;

import com.obric.common.oea.foundation.animation.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.m.c;
import java.util.Objects;

/* JADX INFO: compiled from: AnimationInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f32291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f32292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f32293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f32295e;
    private T f;
    private T g;
    private final com.obric.common.oea.foundation.animation.g.a<T> h;
    private Float i;
    private final c<T> j;
    private float k;

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L21;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f32295e, r4.f32295e) == true) goto L9;
        return false;
    L9:
        if (o.a(this.f, r4.f) == true) goto L11;
        return false;
    L11:
        if (o.a(this.g, r4.g) == true) goto L13;
        return false;
    L13:
        if (o.a(this.h, r4.h) == true) goto L15;
        return false;
    L15:
        if (o.a(this.i, r4.i) == true) goto L17;
        return false;
    L17:
        if (o.a(this.j, r4.j) == true) goto L19;
        return false;
    L19:
        if (Float.compare(this.k, r4.k) == 0) goto L32;
        return false;
    L32:
        return true;
    L21:
        return false;
    }

    public int hashCode() {
        String r0 = this.f32295e;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        T r4 = this.f;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        T r7 = this.g;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        com.obric.common.oea.foundation.animation.g.a<T> r10 = this.h;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Float r13 = this.i;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        c<T> r16 = this.j;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return ((r15 + r1) * 31) + Float.hashCode(this.k);
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AnimationInfo(property=" + this.f32295e + ", initialValue=" + this.f + ", targetValue=" + this.g + ", spec=" + this.h + ", initialVelocity=" + this.i + ", valueClass=" + this.j + ", currentVelocity=" + this.k + ")";
    }

    public a(String r3, T r4, T r5, com.obric.common.oea.foundation.animation.g.a<T> r6, Float r7, c<T> r8, float r9) {
        com.obric.common.oea.foundation.animation.g.a<T> r10 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        c<T> r11 = (c) ZeusTransformUtils.wrapperContextForParams(r8, c.class, "com.obric.aiagent.plugin");
        o.e(r3, "property");
        o.e(r4, "initialValue");
        o.e(r5, "targetValue");
        o.e(r10, "spec");
        o.e(r11, "valueClass");
        this.f32295e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r10;
        this.i = r7;
        this.j = r11;
        this.k = r9;
        this.f32291a = -1;
        this.f32292b = -1;
        this.f32293c = -1;
        this.f32294d = true;
    }

    public final String e() {
        return this.f32295e;
    }

    public final T f() {
        return this.f;
    }

    public final T g() {
        return this.g;
    }

    public final void a(Float r1) {
        this.i = r1;
    }

    public final Float h() {
        return this.i;
    }

    public /* synthetic */ a(String r11, Object r12, Object r13, com.obric.common.oea.foundation.animation.g.a r14, Float r15, c r16, float r17, int r18, h r19) {
        com.obric.common.oea.foundation.animation.g.a r6 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r14, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r16, c.class, "com.obric.aiagent.plugin");
        if ((r18 & 64) == 0) goto L5;
        float r9 = 0.0f;
    L6:
        this(r11, r12, r13, r6, r15, r8, r9);
        return;
    L5:
        r9 = r17;
        goto L6
    }

    public final float i() {
        return this.k;
    }

    public final long a() {
        if (this.f32291a >= 0) goto L10;
        com.obric.common.oea.foundation.animation.g.a<T> r0 = this.h;
        T r1 = this.f;
        T r2 = this.g;
        Float r3 = this.i;
        if (r3 == null) goto L7;
        float r4 = r3.floatValue();
    L8:
        this.f32291a = r0.a(r1, r2, r4);
        goto L10
    L7:
        r4 = 0.0f;
    L10:
        return this.f32291a;
    }

    public final void a(long r1) {
        this.f32292b = r1;
    }

    public final long b() {
        return this.f32292b;
    }

    public final void b(long r1) {
        this.f32293c = r1;
    }

    public final void a(boolean r1) {
        this.f32294d = r1;
    }

    public final boolean c() {
        return this.f32294d;
    }

    public final T c(long r9) {
        c<T> r0 = this.j;
        if (o.a(r0, aa.b(Float.TYPE)) == false) goto L7;
        b r1 = b.f32321a;
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
        com.obric.common.oea.foundation.animation.b.a r2 = (com.obric.common.oea.foundation.animation.b.a) ZeusTransformUtils.preCheckCast(r1, com.obric.common.oea.foundation.animation.b.a.class, "com.obric.aiagent.plugin");
    L5:
        com.obric.common.oea.foundation.animation.b.a r3 = r2;
        T r4 = this.f;
        T r5 = this.g;
        Float r6 = this.i;
        if (r6 == null) goto L12;
        float r7 = r6.floatValue();
    L14:
        return (T) r3.a(r9, r4, r5, r7, this.h);
    L12:
        r7 = 0.0f;
        goto L14
    L7:
        if (o.a(r0, aa.b(Integer.TYPE)) == false) goto L16;
        com.obric.common.oea.foundation.animation.b.c r8 = com.obric.common.oea.foundation.animation.b.c.f32322a;
        Objects.requireNonNull(r8, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
        r2 = (com.obric.common.oea.foundation.animation.b.a) ZeusTransformUtils.preCheckCast(r8, com.obric.common.oea.foundation.animation.b.a.class, "com.obric.aiagent.plugin");
        goto L5
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Unsupported type " + this.j), Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final float d(long r9) {
        c<T> r0 = this.j;
        if (o.a(r0, aa.b(Float.TYPE)) == false) goto L7;
        b r1 = b.f32321a;
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
        com.obric.common.oea.foundation.animation.b.a r2 = (com.obric.common.oea.foundation.animation.b.a) ZeusTransformUtils.preCheckCast(r1, com.obric.common.oea.foundation.animation.b.a.class, "com.obric.aiagent.plugin");
    L5:
        com.obric.common.oea.foundation.animation.b.a r3 = r2;
        T r4 = this.f;
        T r5 = this.g;
        Float r6 = this.i;
        if (r6 == null) goto L12;
        float r7 = r6.floatValue();
    L13:
        float r10 = r3.b(r9, r4, r5, r7, this.h);
        this.k = r10;
        return r10;
    L12:
        r7 = 0.0f;
        goto L13
    L7:
        if (o.a(r0, aa.b(Integer.TYPE)) == false) goto L16;
        com.obric.common.oea.foundation.animation.b.c r8 = com.obric.common.oea.foundation.animation.b.c.f32322a;
        Objects.requireNonNull(r8, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
        r2 = (com.obric.common.oea.foundation.animation.b.a) ZeusTransformUtils.preCheckCast(r8, com.obric.common.oea.foundation.animation.b.a.class, "com.obric.aiagent.plugin");
        goto L5
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Unsupported type " + this.j), Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final boolean e(long r8) {
        c<T> r0 = this.j;
        if (o.a(r0, aa.b(Float.TYPE)) == false) goto L7;
        b r1 = b.f32321a;
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
        com.obric.common.oea.foundation.animation.b.a r2 = (com.obric.common.oea.foundation.animation.b.a) ZeusTransformUtils.preCheckCast(r1, com.obric.common.oea.foundation.animation.b.a.class, "com.obric.aiagent.plugin");
    L10:
        return r2.a(r8, a(), this.h);
    L7:
        if (o.a(r0, aa.b(Integer.TYPE)) == false) goto L12;
        com.obric.common.oea.foundation.animation.b.c r3 = com.obric.common.oea.foundation.animation.b.c.f32322a;
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
        r2 = (com.obric.common.oea.foundation.animation.b.a) ZeusTransformUtils.preCheckCast(r3, com.obric.common.oea.foundation.animation.b.a.class, "com.obric.aiagent.plugin");
        goto L10
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Unsupported type " + this.j), Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final void a(boolean r3, boolean r4, boolean r5) {
        this.f32294d = r3;
        if (r5 == false) goto L5;
        float r6 = 0.0f;
    L6:
        this.k = r6;
        this.f32292b = -1;
        this.f32293c = -1;
        if (r4 == false) goto L10;
        T r7 = this.f;
        this.f = this.g;
        this.g = r7;
        return;
    L10:
        return;
    L5:
        r6 = this.k;
        goto L6
    }

    public final String d() {
        return "AnimationInfo(property: " + this.f32295e + ", initialValue: " + this.f + ", targetValue: " + this.g + ", spec: " + this.h.a() + ", initialVelocity: " + this.i + ", valueClass: " + this.j + ", currentVelocity: " + this.k + ", durationNanos: " + this.f32291a + ", firstFrameTimeNanos: " + this.f32292b + ", lastFrameTimeNanos: " + this.f32293c + ", isRunning: " + this.f32294d + ')';
    }
}
