package I2;

import w0.C5715a;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f3347a;

    /* renamed from: b, reason: collision with root package name */
    public float f3348b;

    /* renamed from: c, reason: collision with root package name */
    public int f3349c;

    /* renamed from: d, reason: collision with root package name */
    public int f3350d;

    /* renamed from: e, reason: collision with root package name */
    public float f3351e;

    /* renamed from: f, reason: collision with root package name */
    public float f3352f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3353g;

    /* renamed from: h, reason: collision with root package name */
    public final float f3354h;

    public a(int i10, float f10, float f11, float f12, int i11, float f13, int i12, float f14, int i13, float f15) {
        this.f3347a = i10;
        this.f3348b = C5715a.a(f10, f11, f12);
        this.f3349c = i11;
        this.f3351e = f13;
        this.f3350d = i12;
        this.f3352f = f14;
        this.f3353g = i13;
        d(f15, f11, f12, f14);
        this.f3354h = b(f14);
    }

    public static a c(float f10, float f11, float f12, float f13, int[] iArr, float f14, int[] iArr2, float f15, int[] iArr3) {
        a aVar = null;
        int i10 = 1;
        for (int i11 : iArr3) {
            int length = iArr2.length;
            int i12 = 0;
            while (i12 < length) {
                int i13 = iArr2[i12];
                int length2 = iArr.length;
                int i14 = 0;
                while (i14 < length2) {
                    int i15 = length;
                    int i16 = i12;
                    int i17 = i10;
                    int i18 = length2;
                    int i19 = i14;
                    a aVar2 = new a(i17, f11, f12, f13, iArr[i14], f14, i13, f15, i11, f10);
                    if (aVar == null || aVar2.f3354h < aVar.f3354h) {
                        if (aVar2.f3354h == 0.0f) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    int i20 = i17 + 1;
                    i14 = i19 + 1;
                    i12 = i16;
                    i10 = i20;
                    length = i15;
                    length2 = i18;
                }
                i12++;
                i10 = i10;
                length = length;
            }
        }
        return aVar;
    }

    public final float a(float f10, int i10, float f11, int i11, int i12) {
        if (i10 <= 0) {
            f11 = 0.0f;
        }
        float f12 = i10;
        float f13 = i11 / 2.0f;
        return (f10 - ((f12 + f13) * f11)) / (i12 + f13);
    }

    public final float b(float f10) {
        if (g()) {
            return Math.abs(f10 - this.f3352f) * this.f3347a;
        }
        return Float.MAX_VALUE;
    }

    public final void d(float f10, float f11, float f12, float f13) {
        float f14 = f10 - f();
        int i10 = this.f3349c;
        if (i10 > 0 && f14 > 0.0f) {
            float f15 = this.f3348b;
            this.f3348b = f15 + Math.min(f14 / i10, f12 - f15);
        } else if (i10 > 0 && f14 < 0.0f) {
            float f16 = this.f3348b;
            this.f3348b = f16 + Math.max(f14 / i10, f11 - f16);
        }
        int i11 = this.f3349c;
        float f17 = i11 > 0 ? this.f3348b : 0.0f;
        this.f3348b = f17;
        float fA = a(f10, i11, f17, this.f3350d, this.f3353g);
        this.f3352f = fA;
        float f18 = (this.f3348b + fA) / 2.0f;
        this.f3351e = f18;
        int i12 = this.f3350d;
        if (i12 <= 0 || fA == f13) {
            return;
        }
        float f19 = (f13 - fA) * this.f3353g;
        float fMin = Math.min(Math.abs(f19), f18 * 0.1f * i12);
        if (f19 > 0.0f) {
            this.f3351e -= fMin / this.f3350d;
            this.f3352f += fMin / this.f3353g;
        } else {
            this.f3351e += fMin / this.f3350d;
            this.f3352f -= fMin / this.f3353g;
        }
    }

    public int e() {
        return this.f3349c + this.f3350d + this.f3353g;
    }

    public final float f() {
        return (this.f3352f * this.f3353g) + (this.f3351e * this.f3350d) + (this.f3348b * this.f3349c);
    }

    public final boolean g() {
        int i10 = this.f3353g;
        if (i10 <= 0 || this.f3349c <= 0 || this.f3350d <= 0) {
            return i10 <= 0 || this.f3349c <= 0 || this.f3352f > this.f3348b;
        }
        float f10 = this.f3352f;
        float f11 = this.f3351e;
        return f10 > f11 && f11 > this.f3348b;
    }

    public String toString() {
        return "Arrangement [priority=" + this.f3347a + ", smallCount=" + this.f3349c + ", smallSize=" + this.f3348b + ", mediumCount=" + this.f3350d + ", mediumSize=" + this.f3351e + ", largeCount=" + this.f3353g + ", largeSize=" + this.f3352f + ", cost=" + this.f3354h + "]";
    }
}
