package G6;

import g1.AbstractC1451a;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final float f680a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public d(float f, float f7, float f9, float f10, float f11, float f12) {
        float fT = AbstractC1451a.t(f - f9, 0.0f, f < 0.0f ? 0.0f : f);
        float f13 = f12 * f;
        f7 = f13 >= f7 ? f13 : f7;
        f7 = f7 > fT ? fT : f7;
        this.f680a = f7;
        float f14 = fT - f7;
        f14 = f14 < 0.0f ? 0.0f : f14;
        this.b = f14;
        float fMin = Math.min(f10, 0.1f * f14);
        this.c = fMin;
        float f15 = f14 - fMin;
        float fMin2 = Math.min(f11 * f, (f15 >= 0.0f ? f15 : 0.0f) * 0.8f);
        this.d = fMin2;
        this.e = (fT - fMin) - fMin2;
        this.f = f;
    }

    public final float a(float f) {
        float f7 = this.e;
        if (f > 1.0f) {
            return B7.a.b(f, 1.0f, this.f - f7, f7);
        }
        float f9 = this.f680a;
        return B7.a.b(f7, f9, f, f9);
    }
}
