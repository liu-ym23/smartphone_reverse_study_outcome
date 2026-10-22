package com.obric.common.oea.foundation.animation.g.a;

import com.obric.common.oea.foundation.animation.b.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: FloatSpringSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.obric.common.oea.foundation.animation.g.a<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f32390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f32391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f32392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f32393e;
    private final int f;
    private final float g;

    public b() {
        this(0.0f, 0.0f, 0, 0.0f, 15, null);
    }

    public b(float r1, float r2, int r3, float r4) {
        this.f32392d = r1;
        this.f32393e = r2;
        this.f = r3;
        this.g = r4;
        this.f32389a = "FloatSpringSpec";
        e r5 = new e(1.0f);
        r5.b(r1);
        r5.a(r2);
        x r6 = x.f38692a;
        this.f32390b = r5;
        this.f32391c = 1.0f;
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public /* synthetic */ long a(Float r3, Float r4, float r5) {
        return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).floatValue(), r5);
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public /* synthetic */ Float a(long r9, Float r11, Float r12, float r13) {
        return a(r9, ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).floatValue(), r13);
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public /* synthetic */ float b(long r9, Float r11, Float r12, float r13) {
        return b(r9, ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).floatValue(), r13);
    }

    public /* synthetic */ b(float r2, float r3, int r4, float r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 1.0f;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 1.0f;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0.01f;
    L14:
        this(r2, r3, r4, r5);
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public String a() {
        return "FloatSpringSpec(dampingRatio: " + this.f32392d + ", stiffness: " + this.f32393e + ", delay: " + this.f + ", visibilityThreshold: " + this.g + ", delta: " + this.f32391c + ')';
    }

    public final void a(float r1) {
        this.f32391c = r1;
    }

    public Float a(long r3, float r5, float r6, float r7) {
        long r4 = c(r3, r5, r6, r7) / 1000000;
        this.f32390b.c(r6);
        return Float.valueOf(this.f32390b.a(r5, r7, r4).a());
    }

    public float b(long r3, float r5, float r6, float r7) {
        long r4 = c(r3, r5, r6, r7) / 1000000;
        this.f32390b.c(r6);
        return this.f32390b.a(r5, r7, r4).b();
    }

    public long a(float r3, float r4, float r5) {
        float r0 = this.f32390b.a();
        float r1 = this.f32390b.b();
        float r6 = r3 - r4;
        float r7 = this.g;
        float r8 = r5 / r7;
        return c.a(r0, r1, r8, r6 / r7, this.f32391c) * 1000000;
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public boolean a(long r5, long r7) {
        if (r5 < (r7 + (((long) this.f) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }

    private final long c(long r9, float r11, float r12, float r13) {
        long r14 = a(r11, r12, r13);
        long r2 = r9 - (((long) this.f) * 1000000);
        if (r14 < 0) goto L5;
        long r6 = r14;
    L7:
        return n.a(r2, 0, r6);
    L5:
        r6 = 0;
        goto L7
    }
}
