package com.google.android.material.bottomappbar;

import t1.C1114g;
import t1.n;

/* loaded from: classes.dex */
public class b extends C1114g implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private float f12294a;

    /* renamed from: b, reason: collision with root package name */
    private float f12295b;

    /* renamed from: c, reason: collision with root package name */
    private float f12296c;

    /* renamed from: d, reason: collision with root package name */
    private float f12297d;

    /* renamed from: e, reason: collision with root package name */
    private float f12298e;

    /* renamed from: f, reason: collision with root package name */
    private float f12299f;

    @Override // t1.C1114g
    public void d(float f5, float f6, float f7, n nVar) {
        float f8;
        float f9;
        float f10 = this.f12296c;
        if (f10 == 0.0f) {
            nVar.m(f5, 0.0f);
            return;
        }
        float f11 = ((this.f12295b * 2.0f) + f10) / 2.0f;
        float f12 = f7 * this.f12294a;
        float f13 = f6 + this.f12298e;
        float f14 = (this.f12297d * f7) + ((1.0f - f7) * f11);
        if (f14 / f11 >= 1.0f) {
            nVar.m(f5, 0.0f);
            return;
        }
        float f15 = this.f12299f;
        float f16 = f15 * f7;
        boolean z5 = f15 == -1.0f || Math.abs((f15 * 2.0f) - f10) < 0.1f;
        if (z5) {
            f8 = f14;
            f9 = 0.0f;
        } else {
            f9 = 1.75f;
            f8 = 0.0f;
        }
        float f17 = f11 + f12;
        float f18 = f8 + f12;
        float fSqrt = (float) Math.sqrt((f17 * f17) - (f18 * f18));
        float f19 = f13 - fSqrt;
        float f20 = f13 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f18));
        float f21 = (90.0f - degrees) + f9;
        nVar.m(f19, 0.0f);
        float f22 = f19 - f12;
        float f23 = f19 + f12;
        float f24 = f12 * 2.0f;
        nVar.a(f22, 0.0f, f23, f24, 270.0f, degrees);
        if (z5) {
            nVar.a(f13 - f11, (-f11) - f8, f13 + f11, f11 - f8, 180.0f - f21, (f21 * 2.0f) - 180.0f);
        } else {
            float f25 = this.f12295b;
            float f26 = f16 * 2.0f;
            float f27 = f25 + f26;
            float f28 = f13 - f11;
            nVar.a(f28, -(f16 + f25), f27 + f28, f25 + f16, 180.0f - f21, ((f21 * 2.0f) - 180.0f) / 2.0f);
            float f29 = f13 + f11;
            float f30 = this.f12295b;
            nVar.m(f29 - ((f30 / 2.0f) + f16), f30 + f16);
            float f31 = this.f12295b;
            nVar.a(f29 - (f26 + f31), -(f16 + f31), f29, f31 + f16, 90.0f, f21 - 90.0f);
        }
        nVar.a(f20 - f12, 0.0f, f20 + f12, f24, 270.0f - degrees, degrees);
        nVar.m(f5, 0.0f);
    }

    float e() {
        return this.f12297d;
    }

    public float g() {
        return this.f12299f;
    }

    float h() {
        return this.f12295b;
    }

    float i() {
        return this.f12294a;
    }

    public float j() {
        return this.f12296c;
    }

    void k(float f5) {
        if (f5 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f12297d = f5;
    }

    public void l(float f5) {
        this.f12299f = f5;
    }

    void n(float f5) {
        this.f12295b = f5;
    }

    void p(float f5) {
        this.f12294a = f5;
    }

    public void q(float f5) {
        this.f12296c = f5;
    }

    void s(float f5) {
        this.f12298e = f5;
    }
}
