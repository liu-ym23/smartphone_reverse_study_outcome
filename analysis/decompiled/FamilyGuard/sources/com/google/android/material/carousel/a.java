package com.google.android.material.carousel;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    final int f12499a;

    /* renamed from: b, reason: collision with root package name */
    float f12500b;

    /* renamed from: c, reason: collision with root package name */
    int f12501c;

    /* renamed from: d, reason: collision with root package name */
    int f12502d;

    /* renamed from: e, reason: collision with root package name */
    float f12503e;

    /* renamed from: f, reason: collision with root package name */
    float f12504f;

    /* renamed from: g, reason: collision with root package name */
    final int f12505g;

    /* renamed from: h, reason: collision with root package name */
    final float f12506h;

    public a(int i5, float f5, float f6, float f7, int i6, float f8, int i7, float f9, int i8, float f10) {
        this.f12499a = i5;
        this.f12500b = B.a.a(f5, f6, f7);
        this.f12501c = i6;
        this.f12503e = f8;
        this.f12502d = i7;
        this.f12504f = f9;
        this.f12505g = i8;
        d(f10, f6, f7, f9);
        this.f12506h = b(f9);
    }

    private float a(float f5, int i5, float f6, int i6, int i7) {
        if (i5 <= 0) {
            f6 = 0.0f;
        }
        float f7 = i5;
        float f8 = i6 / 2.0f;
        return (f5 - ((f7 + f8) * f6)) / (i7 + f8);
    }

    private float b(float f5) {
        if (g()) {
            return Math.abs(f5 - this.f12504f) * this.f12499a;
        }
        return Float.MAX_VALUE;
    }

    public static a c(float f5, float f6, float f7, float f8, int[] iArr, float f9, int[] iArr2, float f10, int[] iArr3) {
        a aVar = null;
        int i5 = 1;
        for (int i6 : iArr3) {
            int length = iArr2.length;
            int i7 = 0;
            while (i7 < length) {
                int i8 = iArr2[i7];
                int length2 = iArr.length;
                int i9 = 0;
                while (i9 < length2) {
                    int i10 = length;
                    int i11 = i7;
                    int i12 = i5;
                    int i13 = length2;
                    int i14 = i9;
                    a aVar2 = new a(i12, f6, f7, f8, iArr[i9], f9, i8, f10, i6, f5);
                    if (aVar == null || aVar2.f12506h < aVar.f12506h) {
                        if (aVar2.f12506h == 0.0f) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    int i15 = i12 + 1;
                    i9 = i14 + 1;
                    i7 = i11;
                    i5 = i15;
                    length = i10;
                    length2 = i13;
                }
                i7++;
                i5 = i5;
                length = length;
            }
        }
        return aVar;
    }

    private void d(float f5, float f6, float f7, float f8) {
        float f9 = f5 - f();
        int i5 = this.f12501c;
        if (i5 > 0 && f9 > 0.0f) {
            float f10 = this.f12500b;
            this.f12500b = f10 + Math.min(f9 / i5, f7 - f10);
        } else if (i5 > 0 && f9 < 0.0f) {
            float f11 = this.f12500b;
            this.f12500b = f11 + Math.max(f9 / i5, f6 - f11);
        }
        int i6 = this.f12501c;
        float f12 = i6 > 0 ? this.f12500b : 0.0f;
        this.f12500b = f12;
        float fA = a(f5, i6, f12, this.f12502d, this.f12505g);
        this.f12504f = fA;
        float f13 = (this.f12500b + fA) / 2.0f;
        this.f12503e = f13;
        int i7 = this.f12502d;
        if (i7 <= 0 || fA == f8) {
            return;
        }
        float f14 = (f8 - fA) * this.f12505g;
        float fMin = Math.min(Math.abs(f14), f13 * 0.1f * i7);
        if (f14 > 0.0f) {
            this.f12503e -= fMin / this.f12502d;
            this.f12504f += fMin / this.f12505g;
        } else {
            this.f12503e += fMin / this.f12502d;
            this.f12504f -= fMin / this.f12505g;
        }
    }

    private float f() {
        return (this.f12504f * this.f12505g) + (this.f12503e * this.f12502d) + (this.f12500b * this.f12501c);
    }

    private boolean g() {
        int i5 = this.f12505g;
        if (i5 <= 0 || this.f12501c <= 0 || this.f12502d <= 0) {
            return i5 <= 0 || this.f12501c <= 0 || this.f12504f > this.f12500b;
        }
        float f5 = this.f12504f;
        float f6 = this.f12503e;
        return f5 > f6 && f6 > this.f12500b;
    }

    int e() {
        return this.f12501c + this.f12502d + this.f12505g;
    }

    public String toString() {
        return "Arrangement [priority=" + this.f12499a + ", smallCount=" + this.f12501c + ", smallSize=" + this.f12500b + ", mediumCount=" + this.f12502d + ", mediumSize=" + this.f12503e + ", largeCount=" + this.f12505g + ", largeSize=" + this.f12504f + ", cost=" + this.f12506h + "]";
    }
}
