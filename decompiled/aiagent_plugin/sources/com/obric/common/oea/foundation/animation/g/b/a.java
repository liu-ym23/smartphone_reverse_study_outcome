package com.obric.common.oea.foundation.animation.g.b;

import com.obric.common.oea.foundation.animation.h.d;
import com.obric.common.oea.foundation.animation.h.e;
import com.obric.common.oea.foundation.animation.h.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: FloatTweenSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.obric.common.oea.foundation.animation.g.a<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f32406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e.d f32407d;

    public a() {
        this(0, 0, null, 7, null);
    }

    public a(int r2, int r3, e.d r4) {
        o.e(r4, "easing");
        this.f32405b = r2;
        this.f32406c = r3;
        this.f32407d = r4;
        this.f32404a = "FloatTweenSpec";
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

    public /* synthetic */ a(int r1, int r2, e.d r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 300;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = e.d.f32444b;
    L11:
        this(r1, r2, r3);
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public String a() {
        return "FloatTweenSpec(durationMillis: " + this.f32405b + ", delay: " + this.f32406c + ", easing: " + this.f32407d + ')';
    }

    public Float a(long r6, float r8, float r9, float r10) {
        long r7 = a(r6);
        int r11 = this.f32405b;
        float r0 = 1.0f;
        if (r11 != 0) goto L5;
        float r12 = 1.0f;
    L6:
        e.d r13 = this.f32407d;
        e.d r14 = e.d.f32443a;
        e.d r5 = this.f32407d;
        if (r13 != r14) goto L9;
        float r15 = f.b(r5).a(r12);
    L18:
        return Float.valueOf(d.b(r8, r9, r15));
    L9:
        com.obric.common.oea.foundation.animation.h.b r16 = f.a(r5);
        if (r12 >= 0.0f) goto L13;
        r12 = 0.0f;
    L13:
        if (r12 > 1.0f) goto L16;
        r0 = r12;
    L16:
        r15 = r16.a(r0);
        goto L18
    L5:
        r12 = r7 / (((long) r11) * 1000000);
        goto L6
    }

    public long a(float r1, float r2, float r3) {
        return ((long) this.f32405b) * 1000000;
    }

    private final long a(long r11) {
        return n.a(r11 - (((long) this.f32406c) * 1000000), 0, ((long) this.f32405b) * 1000000);
    }

    public float b(long r10, float r12, float r13, float r14) {
        long r1 = a(r10);
        if (r1 >= 0) goto L6;
        return 0.0f;
    L6:
        if (r1 != 0) goto L8;
        return r14;
    L8:
        float r11 = a(r1 - 1000000, r12, r13, r14).floatValue();
        return (a(r1, r12, r13, r14).floatValue() - r11) * 1000.0f;
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public boolean a(long r5, long r7) {
        if (r5 < (r7 + (((long) this.f32406c) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, a.class) == true) goto L5;
        return false;
    L5:
        if (((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.aiagent.plugin")).f32405b == this.f32405b) goto L7;
        return false;
    L7:
        if (((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.aiagent.plugin")).f32406c == this.f32406c) goto L9;
        return false;
    L9:
        if (((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.aiagent.plugin")).f32407d != this.f32407d) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        return (((this.f32405b * 31) + this.f32407d.hashCode()) * 31) + this.f32406c;
    }
}
