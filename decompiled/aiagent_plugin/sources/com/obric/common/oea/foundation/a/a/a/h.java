package com.obric.common.oea.foundation.a.a.a;

import android.graphics.Path;

/* JADX INFO: compiled from: SketchSmoothCornerImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f32282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f32283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f32284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f32285e;

    @Override // com.obric.common.oea.foundation.a.a.a.d
    public boolean a(float r1, float r2) {
        if (r1 >= (r2 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    public h() {
        this.f32282b = 128.19f;
        this.f32283c = 83.62f;
        this.f32284d = new b(67.45f, 51.16f, 34.86f, 22.07f, 13.36f, 4.64f);
        this.f32285e = "SketchSmoothCornerImpl";
    }

    @Override // com.obric.common.oea.foundation.a.a.a.d
    public String getType() {
        return this.f32285e;
    }

    @Override // com.obric.common.oea.foundation.a.a.a.d
    public Path a(float r46, float r47, float r48, float r49, float r50) {
        Path r7 = new Path();
        float r5 = r48 - r46;
        float r6 = r49 - r47;
        float r8 = Math.min(r5, r6);
        if (r50 == 0.0f) goto L17;
        if (r50 >= (r8 * 0.5f)) goto L17;
        float r9 = r50 / (r8 / 2.0f);
        float r12 = 1.0f;
        if (r9 <= 0.5f) goto L10;
        float r10 = 1.0f - (Math.min(1.0f, (r9 - 0.5f) / 0.4f) * 0.13877845f);
    L12:
        if (r9 <= 0.6f) goto L14;
        r12 = 1.0f + (Math.min(1.0f, (r9 - 0.6f) / 0.3f) * 0.042454004f);
    L14:
        float r11 = r50 / 100.0f;
        float r13 = (this.f32282b * r11) * r10;
        float r14 = (this.f32283c * r11) * r12;
        b r19 = new b(r11 * this.f32284d.a(), r11 * this.f32284d.b(), r11 * this.f32284d.c(), r11 * this.f32284d.d(), r11 * this.f32284d.e(), r11 * this.f32284d.f());
        float r15 = (r5 / 2.0f) + r46;
        e r0 = new e(r15, r47);
        float r16 = r48 - r13;
        e r17 = new e(Math.max(r15, r16), r47);
        float r18 = r48 - r14;
        e r110 = new e(r18, r47);
        e r111 = new e(r48 - r19.a(), r47 + r19.f());
        e r112 = new e(r48 - r19.b(), r47 + r19.e());
        e r113 = new e(r48 - r19.c(), r47 + r19.d());
        e r114 = new e(r48 - r19.d(), r47 + r19.c());
        e r115 = new e(r48 - r19.e(), r47 + r19.b());
        e r116 = new e(r48 - r19.f(), r47 + r19.a());
        float r117 = r47 + r14;
        e r118 = new e(r48, r117);
        float r20 = r6 / 2.0f;
        e r119 = new e(r48, r47 + Math.min(r20, r13));
        float r21 = r20 + r47;
        float r120 = r49 - r13;
        e r121 = new e(r48, Math.max(r21, r120));
        float r122 = r49 - r14;
        e r22 = new e(r48, r122);
        e r23 = new e(r48 - r19.f(), r49 - r19.a());
        e r24 = new e(r48 - r19.e(), r49 - r19.b());
        e r25 = new e(r48 - r19.d(), r49 - r19.c());
        e r26 = new e(r48 - r19.c(), r49 - r19.d());
        e r27 = new e(r48 - r19.b(), r49 - r19.e());
        e r28 = new e(r48 - r19.a(), r49 - r19.f());
        e r3 = new e(r18, r49);
        e r123 = new e(Math.max(r15, r16), r49);
        float r1 = r46 + r13;
        e r124 = new e(Math.min(r15, r1), r49);
        float r29 = r14 + r46;
        e r4 = new e(r29, r49);
        e r125 = new e(r46 + r19.a(), r49 - r19.f());
        e r126 = new e(r19.b() + r46, r49 - r19.e());
        e r127 = new e(r19.c() + r46, r49 - r19.d());
        e r128 = new e(r19.d() + r46, r49 - r19.c());
        e r129 = new e(r19.e() + r46, r49 - r19.b());
        e r130 = new e(r19.f() + r46, r49 - r19.a());
        e r30 = new e(r46, r122);
        e r131 = new e(r46, Math.max(r21, r120));
        e r132 = new e(r46, Math.min(r21, r47 + r13));
        e r133 = new e(r46, r117);
        e r134 = new e(r19.f() + r46, r19.a() + r47);
        e r31 = new e(r19.e() + r46, r47 + r19.b());
        e r32 = new e(r19.d() + r46, r47 + r19.c());
        e r33 = new e(r19.c() + r46, r47 + r19.d());
        e r34 = new e(r19.b() + r46, r47 + r19.e());
        e r35 = new e(r46 + r19.a(), r19.f() + r47);
        e r36 = new e(r29, r47);
        e r37 = new e(Math.min(r15, r1), r47);
        r7.moveTo(r0.a(), r0.b());
        r7.lineTo(r17.a(), r17.b());
        r7.cubicTo(r110.a(), r110.b(), r111.a(), r111.b(), r112.a(), r112.b());
        r7.cubicTo(r113.a(), r113.b(), r114.a(), r114.b(), r115.a(), r115.b());
        r7.cubicTo(r116.a(), r116.b(), r118.a(), r118.b(), r119.a(), r119.b());
        r7.lineTo(r121.a(), r121.b());
        r7.cubicTo(r22.a(), r22.b(), r23.a(), r23.b(), r24.a(), r24.b());
        r7.cubicTo(r25.a(), r25.b(), r26.a(), r26.b(), r27.a(), r27.b());
        r7.cubicTo(r28.a(), r28.b(), r3.a(), r3.b(), r123.a(), r123.b());
        r7.lineTo(r124.a(), r124.b());
        r7.cubicTo(r4.a(), r4.b(), r125.a(), r125.b(), r126.a(), r126.b());
        r7.cubicTo(r127.a(), r127.b(), r128.a(), r128.b(), r129.a(), r129.b());
        r7.cubicTo(r130.a(), r130.b(), r30.a(), r30.b(), r131.a(), r131.b());
        r7.lineTo(r132.a(), r132.b());
        r7.cubicTo(r133.a(), r133.b(), r134.a(), r134.b(), r31.a(), r31.b());
        r7.cubicTo(r32.a(), r32.b(), r33.a(), r33.b(), r34.a(), r34.b());
        r7.cubicTo(r35.a(), r35.b(), r36.a(), r36.b(), r37.a(), r37.b());
        r7.close();
        return r7;
    L10:
        r10 = 1.0f;
    L17:
        return b(r46, r47, r48, r49, r50);
    }
}
