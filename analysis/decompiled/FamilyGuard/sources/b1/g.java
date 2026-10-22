package b1;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f11792a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f11793b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f11794c = new Matrix();

    public Matrix a(float f5, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f11792a);
        matrix2.getValues(this.f11793b);
        for (int i5 = 0; i5 < 9; i5++) {
            float[] fArr = this.f11793b;
            float f6 = fArr[i5];
            float f7 = this.f11792a[i5];
            fArr[i5] = f7 + ((f6 - f7) * f5);
        }
        this.f11794c.setValues(this.f11793b);
        return this.f11794c;
    }
}
