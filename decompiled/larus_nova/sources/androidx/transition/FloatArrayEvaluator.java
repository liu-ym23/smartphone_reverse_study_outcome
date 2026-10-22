package androidx.transition;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes17.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    public FloatArrayEvaluator(float[] r100) {
        this.mArray = r100;
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public float[] evaluate2(float r100, float[] r101, float[] r102) {
        float[] r103 = this.mArray;
        if (r103 != null) goto L5;
        r103 = new float[r101.length];
    L5:
        int r104 = 0;
    L7:
        if (r104 >= r103.length) goto L9;
        float r105 = r101[r104];
        r103[r104] = r105 + ((r102[r104] - r105) * r100);
        r104 = r104 + 1;
        goto L7
    L9:
        return r103;
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ float[] evaluate(float r100, float[] r101, float[] r102) {
        return evaluate2(r100, r101, r102);
    }
}
