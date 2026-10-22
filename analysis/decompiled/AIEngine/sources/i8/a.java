package i8;

import android.view.animation.Interpolator;
import h0.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f9576a = new float[100];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f9577b = new float[100];

    public a(float f8, float f9, float f10) {
        float f11 = f8 * 3.0f;
        float f12 = f10 * 3.0f;
        float f13 = (f11 + 1.0f) - f12;
        float f14 = f12 - (f8 * 6.0f);
        float f15 = f9 * 3.0f;
        float f16 = (1.0f + f15) - 3.0f;
        float f17 = 3.0f - (f9 * 6.0f);
        float f18 = 0.0f;
        for (int i10 = 0; i10 < 100; i10++) {
            float f19 = f18 * f18;
            float f20 = f19 * f18;
            this.f9576a[i10] = (f11 * f18) + (f14 * f19) + (f13 * f20);
            this.f9577b[i10] = (f15 * f18) + (f19 * f17) + (f20 * f16);
            f18 += 0.01f;
        }
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f8) {
        if (f8 <= 0.0f) {
            return 0.0f;
        }
        if (f8 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f9576a.length - 1;
        int i10 = 0;
        while (length - i10 > 1) {
            int i11 = (i10 + length) / 2;
            if (f8 < this.f9576a[i11]) {
                length = i11;
            } else {
                i10 = i11;
            }
        }
        float[] fArr = this.f9576a;
        float f9 = fArr[length];
        float f10 = fArr[i10];
        float f11 = f9 - f10;
        if (f11 == 0.0f) {
            return this.f9577b[i10];
        }
        float[] fArr2 = this.f9577b;
        float f12 = fArr2[i10];
        return e.a(fArr2[length], f12, (f8 - f10) / f11, f12);
    }
}
