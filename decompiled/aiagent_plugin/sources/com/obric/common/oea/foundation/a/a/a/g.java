package com.obric.common.oea.foundation.a.a.a;

import android.graphics.Path;

/* JADX INFO: compiled from: QuadraticSmoothCornerImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f32279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f32280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f32281d;

    public g() {
        this(0.0f, 1, null);
    }

    public g(float r1) {
        this.f32281d = r1;
        this.f32279b = 1.175f;
        this.f32280c = "QuadraticSmoothCornerImpl";
    }

    public /* synthetic */ g(float r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0.375f;
    L5:
        this(r1);
    }

    @Override // com.obric.common.oea.foundation.a.a.a.d
    public String getType() {
        return this.f32280c;
    }

    @Override // com.obric.common.oea.foundation.a.a.a.d
    public boolean a(float r1, float r2) {
        if (r1 >= (this.f32281d * r2)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.common.oea.foundation.a.a.a.d
    public Path a(float r10, float r11, float r12, float r13, float r14) {
        float r0 = Math.min(r12 - r10, r13 - r11);
        if (r14 == 0.0f) goto L10;
        if (r14 >= (this.f32281d * r0)) goto L10;
        float r9 = Math.min(r0 / 2.0f, r14 * this.f32279b);
        float r1 = r11 + r9;
        e r15 = new e(r12, r1);
        float r2 = r13 - r9;
        e r3 = new e(r12, r2);
        e r4 = new e(r12, r13);
        float r5 = r12 - r9;
        e r6 = new e(r5, r13);
        float r16 = r9 + r10;
        e r7 = new e(r16, r13);
        e r8 = new e(r10, r13);
        e r17 = new e(r10, r2);
        e r18 = new e(r10, r1);
        e r19 = new e(r10, r11);
        e r110 = new e(r16, r11);
        e r20 = new e(r5, r11);
        e r21 = new e(r12, r11);
        e r111 = new e(r12, r1);
        Path r112 = new Path();
        r112.moveTo(r15.a(), r15.b());
        r112.lineTo(r3.a(), r3.b());
        r112.quadTo(r4.a(), r4.b(), r6.a(), r6.b());
        r112.lineTo(r7.a(), r7.b());
        r112.quadTo(r8.a(), r8.b(), r17.a(), r17.b());
        r112.lineTo(r18.a(), r18.b());
        r112.quadTo(r19.a(), r19.b(), r110.a(), r110.b());
        r112.lineTo(r20.a(), r20.b());
        r112.quadTo(r21.a(), r21.b(), r111.a(), r111.b());
        r112.close();
        return r112;
    L10:
        return b(r10, r11, r12, r13, r14);
    }
}
