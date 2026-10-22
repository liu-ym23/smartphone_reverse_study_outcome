package E2;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes2.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f2348a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f2349b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f2350c = new Matrix();

    public Matrix a(float f10, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f2348a);
        matrix2.getValues(this.f2349b);
        for (int i10 = 0; i10 < 9; i10++) {
            float[] fArr = this.f2349b;
            float f11 = fArr[i10];
            float f12 = this.f2348a[i10];
            fArr[i10] = f12 + ((f11 - f12) * f10);
        }
        this.f2350c.setValues(this.f2349b);
        return this.f2350c;
    }
}
