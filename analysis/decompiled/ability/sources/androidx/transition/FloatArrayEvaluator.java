package androidx.transition;

import android.animation.TypeEvaluator;

/* loaded from: classes2.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    public FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f7 = fArr[i];
            fArr3[i] = B7.a.b(fArr2[i], f7, f, f7);
        }
        return fArr3;
    }
}
