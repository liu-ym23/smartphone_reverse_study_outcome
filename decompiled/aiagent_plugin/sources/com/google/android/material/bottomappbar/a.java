package com.google.android.material.bottomappbar;

import com.google.android.material.shape.f;
import com.google.android.material.shape.o;

/* JADX INFO: compiled from: BottomAppBarTopEdgeTreatment.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends f implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f13234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f13235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f13236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f13237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f13238e;
    private float f;

    public a(float r2, float r3, float r4) {
        this.f = -1.0f;
        this.f13235b = r2;
        this.f13234a = r3;
        c(r4);
        this.f13238e = 0.0f;
    }

    @Override // com.google.android.material.shape.f
    public void a(float r24, float r25, float r26, o r27) {
        float r2 = this.f13236c;
        if (r2 != 0.0f) goto L6;
        r27.b(r24, 0.0f);
        return;
    L6:
        float r12 = ((this.f13235b * 2.0f) + r2) / 2.0f;
        float r13 = r26 * this.f13234a;
        float r14 = r25 + this.f13238e;
        float r3 = (this.f13237d * r26) + ((1.0f - r26) * r12);
        if ((r3 / r12) < 1.0f) goto L10;
        r27.b(r24, 0.0f);
        return;
    L10:
        float r4 = this.f;
        float r15 = r4 * r26;
        if (r4 != (-1.0f)) goto L13;
    L16:
        boolean r5 = true;
    L17:
        boolean r16 = r5;
        if (r16 == true) goto L20;
        float r6 = 1.75f;
        float r17 = 0.0f;
    L21:
        float r7 = r12 + r13;
        float r8 = r17 + r13;
        float r9 = (float) Math.sqrt((r7 * r7) - (r8 * r8));
        float r10 = r14 - r9;
        float r18 = r14 + r9;
        float r11 = (float) Math.toDegrees(Math.atan(r9 / r8));
        float r19 = (90.0f - r11) + r6;
        r27.b(r10, 0.0f);
        float r20 = r13 * 2.0f;
        r27.a(r10 - r13, 0.0f, r10 + r13, r20, 270.0f, r11);
        if (r16 == false) goto L24;
        r27.a(r14 - r12, (-r12) - r17, r14 + r12, r12 - r17, 180.0f - r19, (r19 * 2.0f) - 180.0f);
    L25:
        r27.a(r18 - r13, 0.0f, r18 + r13, r20, 270.0f - r11, r11);
        r27.b(r24, 0.0f);
        return;
    L24:
        float r21 = this.f13235b;
        float r110 = r15 * 2.0f;
        float r22 = r14 - r12;
        r27.a(r22, -(r15 + r21), r22 + (r21 + r110), r21 + r15, 180.0f - r19, ((r19 * 2.0f) - 180.0f) / 2.0f);
        float r23 = r14 + r12;
        float r28 = this.f13235b;
        r27.b(r23 - ((r28 / 2.0f) + r15), r28 + r15);
        float r0 = this.f13235b;
        r27.a(r23 - (r110 + r0), -(r15 + r0), r23, r0 + r15, 90.0f, r19 - 90.0f);
        goto L25
    L20:
        r17 = r3;
        r6 = 0.0f;
        goto L21
    L13:
        if (Math.abs((r4 * 2.0f) - r2) < 0.1f) goto L16;
        r5 = false;
        goto L17
    }

    public float a() {
        return this.f13236c;
    }

    public void a(float r1) {
        this.f13236c = r1;
    }

    void b(float r1) {
        this.f13238e = r1;
    }

    public float b() {
        return this.f13238e;
    }

    float c() {
        return this.f13237d;
    }

    void c(float r2) {
        if (r2 < 0.0f) goto L7;
        this.f13237d = r2;
        return;
    L7:
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    float d() {
        return this.f13235b;
    }

    void d(float r1) {
        this.f13235b = r1;
    }

    float e() {
        return this.f13234a;
    }

    void e(float r1) {
        this.f13234a = r1;
    }

    public float f() {
        return this.f;
    }

    public void f(float r1) {
        this.f = r1;
    }
}
