package com.google.android.material.bottomappbar;

import Z2.g;
import Z2.n;

/* loaded from: classes2.dex */
public class b extends g implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public float f20416a;

    /* renamed from: b, reason: collision with root package name */
    public float f20417b;

    /* renamed from: c, reason: collision with root package name */
    public float f20418c;

    /* renamed from: d, reason: collision with root package name */
    public float f20419d;

    /* renamed from: e, reason: collision with root package name */
    public float f20420e;

    /* renamed from: f, reason: collision with root package name */
    public float f20421f;

    @Override // Z2.g
    public void d(float f10, float f11, float f12, n nVar) {
        float f13;
        float f14;
        float f15 = this.f20418c;
        if (f15 == 0.0f) {
            nVar.m(f10, 0.0f);
            return;
        }
        float f16 = ((this.f20417b * 2.0f) + f15) / 2.0f;
        float f17 = f12 * this.f20416a;
        float f18 = f11 + this.f20420e;
        float f19 = (this.f20419d * f12) + ((1.0f - f12) * f16);
        if (f19 / f16 >= 1.0f) {
            nVar.m(f10, 0.0f);
            return;
        }
        float f20 = this.f20421f;
        float f21 = f20 * f12;
        boolean z10 = f20 == -1.0f || Math.abs((f20 * 2.0f) - f15) < 0.1f;
        if (z10) {
            f13 = f19;
            f14 = 0.0f;
        } else {
            f14 = 1.75f;
            f13 = 0.0f;
        }
        float f22 = f16 + f17;
        float f23 = f13 + f17;
        float fSqrt = (float) Math.sqrt((f22 * f22) - (f23 * f23));
        float f24 = f18 - fSqrt;
        float f25 = f18 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f23));
        float f26 = (90.0f - degrees) + f14;
        nVar.m(f24, 0.0f);
        float f27 = f24 - f17;
        float f28 = f24 + f17;
        float f29 = f17 * 2.0f;
        nVar.a(f27, 0.0f, f28, f29, 270.0f, degrees);
        if (z10) {
            nVar.a(f18 - f16, (-f16) - f13, f18 + f16, f16 - f13, 180.0f - f26, (f26 * 2.0f) - 180.0f);
        } else {
            float f30 = this.f20417b;
            float f31 = f21 * 2.0f;
            float f32 = f30 + f31;
            float f33 = f18 - f16;
            nVar.a(f33, -(f21 + f30), f32 + f33, f30 + f21, 180.0f - f26, ((f26 * 2.0f) - 180.0f) / 2.0f);
            float f34 = f18 + f16;
            float f35 = this.f20417b;
            nVar.m(f34 - ((f35 / 2.0f) + f21), f35 + f21);
            float f36 = this.f20417b;
            nVar.a(f34 - (f31 + f36), -(f21 + f36), f34, f36 + f21, 90.0f, f26 - 90.0f);
        }
        nVar.a(f25 - f17, 0.0f, f25 + f17, f29, 270.0f - degrees, degrees);
        nVar.m(f10, 0.0f);
    }

    public float f() {
        return this.f20419d;
    }

    public float g() {
        return this.f20421f;
    }

    public float h() {
        return this.f20417b;
    }

    public float i() {
        return this.f20416a;
    }

    public float j() {
        return this.f20418c;
    }

    public void k(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f20419d = f10;
    }

    public void n(float f10) {
        this.f20421f = f10;
    }

    public void o(float f10) {
        this.f20417b = f10;
    }

    public void p(float f10) {
        this.f20416a = f10;
    }

    public void q(float f10) {
        this.f20418c = f10;
    }

    public void r(float f10) {
        this.f20420e = f10;
    }
}
