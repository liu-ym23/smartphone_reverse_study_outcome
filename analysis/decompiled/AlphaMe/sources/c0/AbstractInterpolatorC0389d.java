package c0;

import android.view.animation.Interpolator;
import com.stepos.alphame.utils.Property;
import s.AbstractC0831a;

/* renamed from: c0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractInterpolatorC0389d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f4464a;

    /* renamed from: b, reason: collision with root package name */
    public final float f4465b;

    public AbstractInterpolatorC0389d(float[] fArr) {
        this.f4464a = fArr;
        this.f4465b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f4) {
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        if (f4 <= Property.DEFAULT_FLOAT_VALUE) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        float[] fArr = this.f4464a;
        int iMin = Math.min((int) ((fArr.length - 1) * f4), fArr.length - 2);
        float f5 = this.f4465b;
        float f6 = (f4 - (iMin * f5)) / f5;
        float f7 = fArr[iMin];
        return AbstractC0831a.c(fArr[iMin + 1], f7, f6, f7);
    }
}
