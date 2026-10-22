package o1;

import android.view.animation.Interpolator;
import h0.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class c implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f10715a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10716b;

    public c(float[] fArr) {
        this.f10715a = fArr;
        this.f10716b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f8) {
        if (f8 >= 1.0f) {
            return 1.0f;
        }
        if (f8 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f10715a;
        int iMin = Math.min((int) ((fArr.length - 1) * f8), fArr.length - 2);
        float f9 = this.f10716b;
        float f10 = (f8 - (iMin * f9)) / f9;
        float f11 = fArr[iMin];
        return e.a(fArr[iMin + 1], f11, f10, f11);
    }
}
