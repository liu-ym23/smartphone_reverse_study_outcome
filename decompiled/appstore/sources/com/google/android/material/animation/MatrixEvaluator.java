package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
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
    @NonNull
    public /* bridge */ /* synthetic */ Matrix evaluate(float r10, @NonNull Matrix r11, @NonNull Matrix r12) {
        return evaluate2(r10, r11, r12);
    }

    @NonNull
    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Matrix evaluate2(float r10, @NonNull Matrix r11, @NonNull Matrix r12) {
        r11.getValues(this.tempStartValues);
        r12.getValues(this.tempEndValues);
        int r13 = 0;
    L4:
        if (r13 >= 9) goto L6;
        float[] r14 = this.tempEndValues;
        float r15 = r14[r13];
        float r16 = this.tempStartValues[r13];
        r14[r13] = r16 + ((r15 - r16) * r10);
        r13 = r13 + 1;
        goto L4
    L6:
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }
}
