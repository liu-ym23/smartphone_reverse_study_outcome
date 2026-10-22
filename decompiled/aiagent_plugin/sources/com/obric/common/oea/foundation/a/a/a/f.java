package com.obric.common.oea.foundation.a.a.a;

import android.graphics.Path;
import android.graphics.RectF;
import d.l.n;

/* JADX INFO: compiled from: QuadraticSmoothCornerExImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f32276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f32277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f32278e;

    @Override // com.obric.common.oea.foundation.a.a.a.d
    public boolean a(float r1, float r2) {
        if (r1 != (r2 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    public f() {
        this.f32275b = "QuadraticSmoothCornerExImpl";
        this.f32276c = 0.585786f;
        this.f32277d = 0.292893f;
        this.f32278e = 1.175f;
    }

    @Override // com.obric.common.oea.foundation.a.a.a.d
    public String getType() {
        return this.f32275b;
    }

    @Override // com.obric.common.oea.foundation.a.a.a.d
    public Path a(float r9, float r10, float r11, float r12, float r13) {
        float r1 = r11 - r9;
        float r2 = r12 - r10;
        float r3 = Math.min(r1, r2);
        float r4 = Math.max(r1, r2);
        if (r13 == 0.0f) goto L22;
        float r5 = r3 * 0.5f;
        if (r13 != r5) goto L22;
        if (r13 != r5) goto L13;
        if (r1 != r2) goto L13;
        return b(r9, r10, r11, r12, r13);
    L13:
        if (r1 <= r2) goto L15;
        boolean r6 = true;
    L16:
        float r7 = n.b(r13, r5);
        float r8 = Math.min(this.f32278e * r7, r4 * 0.5f);
        if (r6 == false) goto L20;
        return a(r9, r10, r11, r12, r7, r8);
    L20:
        return b(r9, r10, r11, r12, r7, r8);
    L15:
        r6 = false;
    L22:
        return b(r9, r10, r11, r12, r13);
    }

    private final Path a(float r17, float r18, float r19, float r20, float r21, float r22) {
        float r5 = this.f32276c * r21;
        float r0 = this.f32277d * r21;
        float r7 = r17 + r22;
        e r6 = new e(r7, r18);
        float r9 = 2.0f * r21;
        RectF r8 = new RectF(r17, r18, r17 + r9, r20);
        RectF r10 = new RectF(r19 - r9, r18, r19, r20);
        float r11 = r19 - r22;
        e r12 = new e(r11, r18);
        float r13 = r19 - r5;
        e r14 = new e(r13, r18);
        float r3 = r19 - r0;
        float r15 = r18 + r0;
        e r16 = new e(r3, r15);
        float r110 = r20 - r0;
        new e(r3, r110);
        e r4 = new e(r13, r20);
        e r23 = new e(r11, r20);
        e r111 = new e(r7, r20);
        float r24 = r5 + r17;
        e r112 = new e(r24, r20);
        float r1 = r0 + r17;
        e r25 = new e(r1, r110);
        new e(r1, r15);
        e r2 = new e(r24, r18);
        e r26 = new e(r7, r18);
        Path r27 = new Path();
        r27.moveTo(r6.a(), r6.b());
        r27.lineTo(r12.a(), r12.b());
        r27.quadTo(r14.a(), r14.b(), r16.a(), r16.b());
        r27.arcTo(r10, -45.0f, 90.0f);
        r27.quadTo(r4.a(), r4.b(), r23.a(), r23.b());
        r27.lineTo(r111.a(), r111.b());
        r27.quadTo(r112.a(), r112.b(), r25.a(), r25.b());
        r27.arcTo(r8, 135.0f, 90.0f);
        r27.quadTo(r2.a(), r2.b(), r26.a(), r26.b());
        r27.close();
        return r27;
    }

    private final Path b(float r17, float r18, float r19, float r20, float r21, float r22) {
        float r5 = this.f32276c * r21;
        float r0 = this.f32277d * r21;
        float r7 = r18 + r22;
        e r6 = new e(r19, r7);
        float r9 = 2.0f * r21;
        RectF r8 = new RectF(r17, r18, r19, r18 + r9);
        RectF r10 = new RectF(r17, r20 - r9, r19, r20);
        float r11 = r20 - r22;
        e r12 = new e(r19, r11);
        float r13 = r20 - r5;
        e r14 = new e(r19, r13);
        float r15 = r19 - r0;
        float r4 = r20 - r0;
        e r16 = new e(r15, r4);
        float r110 = r17 + r0;
        new e(r110, r4);
        e r23 = new e(r17, r13);
        e r24 = new e(r17, r11);
        e r111 = new e(r17, r7);
        float r25 = r5 + r18;
        e r112 = new e(r17, r25);
        float r1 = r0 + r18;
        e r2 = new e(r110, r1);
        new e(r15, r1);
        e r3 = new e(r19, r25);
        e r26 = new e(r19, r7);
        Path r27 = new Path();
        r27.moveTo(r6.a(), r6.b());
        r27.lineTo(r12.a(), r12.b());
        r27.quadTo(r14.a(), r14.b(), r16.a(), r16.b());
        r27.arcTo(r10, 45.0f, 90.0f);
        r27.quadTo(r23.a(), r23.b(), r24.a(), r24.b());
        r27.lineTo(r111.a(), r111.b());
        r27.quadTo(r112.a(), r112.b(), r2.a(), r2.b());
        r27.arcTo(r8, 225.0f, 90.0f);
        r27.quadTo(r3.a(), r3.b(), r26.a(), r26.b());
        r27.close();
        return r27;
    }
}
