package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    private final float[] tempEndValues;
    private final Matrix tempMatrix;
    private final float[] tempStartValues;

    public MatrixEvaluator() {
        this.tempStartValues = new float[9];
        this.tempEndValues = new float[9];
        this.tempMatrix = new Matrix();
    }

    @Override // android.animation.TypeEvaluator
    public /* synthetic */ Matrix evaluate(float r3, Matrix r4, Matrix r5) {
        return evaluate2(r3, (Matrix) ZeusTransformUtils.preCheckCast(r4, Matrix.class, "com.obric.aiagent.plugin"), (Matrix) ZeusTransformUtils.preCheckCast(r5, Matrix.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Matrix evaluate2(float r4, Matrix r5, Matrix r6) {
        r5.getValues(this.tempStartValues);
        r6.getValues(this.tempEndValues);
        int r7 = 0;
    L4:
        if (r7 >= 9) goto L6;
        float[] r8 = this.tempEndValues;
        float r0 = r8[r7];
        float[] r1 = this.tempStartValues;
        float r2 = r0 - r1[r7];
        r8[r7] = r1[r7] + (r2 * r4);
        r7 = r7 + 1;
        goto L4
    L6:
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }
}
