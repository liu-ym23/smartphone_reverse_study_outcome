package r0;

import android.view.animation.Interpolator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f5063a;

    /* renamed from: b, reason: collision with root package name */
    public final float f5064b;

    public b(float[] fArr) {
        this.f5063a = fArr;
        this.f5064b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f3) {
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f5063a;
        int iMin = Math.min((int) ((fArr.length - 1) * f3), fArr.length - 2);
        float f7 = this.f5064b;
        float f9 = (f3 - (iMin * f7)) / f7;
        float f10 = fArr[iMin];
        return ((fArr[iMin + 1] - f10) * f9) + f10;
    }
}
