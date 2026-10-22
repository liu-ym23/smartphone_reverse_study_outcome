package j2;

import android.view.animation.Interpolator;
import com.stepos.alphame.utils.Property;
import s.AbstractC0831a;

/* renamed from: j2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class InterpolatorC0636a implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f13131a = new float[100];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f13132b = new float[100];

    public InterpolatorC0636a(float f4, float f5, float f6) {
        float f7 = f4 * 3.0f;
        float f8 = f6 * 3.0f;
        float f9 = (f7 + 1.0f) - f8;
        float f10 = f8 - (f4 * 6.0f);
        float f11 = f5 * 3.0f;
        float f12 = (1.0f + f11) - 3.0f;
        float f13 = 3.0f - (f5 * 6.0f);
        float f14 = Property.DEFAULT_FLOAT_VALUE;
        for (int i4 = 0; i4 < 100; i4++) {
            float f15 = f14 * f14;
            float f16 = f15 * f14;
            this.f13131a[i4] = (f7 * f14) + (f10 * f15) + (f9 * f16);
            this.f13132b[i4] = (f11 * f14) + (f15 * f13) + (f16 * f12);
            f14 += 0.01f;
        }
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f4) {
        if (f4 <= Property.DEFAULT_FLOAT_VALUE) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f13131a.length - 1;
        int i4 = 0;
        while (length - i4 > 1) {
            int i5 = (i4 + length) / 2;
            if (f4 < this.f13131a[i5]) {
                length = i5;
            } else {
                i4 = i5;
            }
        }
        float[] fArr = this.f13131a;
        float f5 = fArr[length];
        float f6 = fArr[i4];
        float f7 = f5 - f6;
        if (f7 == Property.DEFAULT_FLOAT_VALUE) {
            return this.f13132b[i4];
        }
        float[] fArr2 = this.f13132b;
        float f8 = fArr2[i4];
        return AbstractC0831a.c(fArr2[length], f8, (f4 - f6) / f7, f8);
    }
}
