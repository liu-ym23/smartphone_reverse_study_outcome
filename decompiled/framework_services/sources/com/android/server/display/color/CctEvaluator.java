package com.android.server.display.color;

import android.animation.TypeEvaluator;
import android.util.Slog;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class CctEvaluator implements TypeEvaluator<Integer> {
    private static final String TAG = "CctEvaluator";
    private final int mIndexOffset;
    final int[] mSteppedCctsAtOffsetCcts;
    final int[] mStepsAtOffsetCcts;

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Integer evaluate(float r1, Integer r2, Integer r3) {
        return evaluate2(r1, r2, r3);
    }

    CctEvaluator(int min, int max, int[] cctRangeMinimums, int[] steps) {
        int delta = (max - min) + 1;
        this.mStepsAtOffsetCcts = new int[delta];
        this.mSteppedCctsAtOffsetCcts = new int[delta];
        this.mIndexOffset = min;
        int parallelArraysLength = cctRangeMinimums.length;
        if (cctRangeMinimums.length == steps.length) goto L5;
        Slog.e(TAG, "Parallel arrays cctRangeMinimums and steps are different lengths; setting step of 1");
        setStepOfOne();
        return;
    L5:
        if (parallelArraysLength != 0) goto L7;
        Slog.e(TAG, "No cctRangeMinimums or steps are set; setting step of 1");
        setStepOfOne();
        return;
    L7:
        int parallelArraysIndex = 0;
        int index = 0;
        int lastSteppedCct = Integer.MIN_VALUE;
    L8:
        if (index >= delta) goto L27;
        int cct = this.mIndexOffset + index;
        int nextParallelArraysIndex = parallelArraysIndex + 1;
    L10:
        if (nextParallelArraysIndex >= parallelArraysLength) goto L14;
        if (cct < cctRangeMinimums[nextParallelArraysIndex]) goto L14;
        parallelArraysIndex = nextParallelArraysIndex;
        nextParallelArraysIndex = nextParallelArraysIndex + 1;
    L14:
        this.mStepsAtOffsetCcts[index] = steps[parallelArraysIndex];
        if (lastSteppedCct != Integer.MIN_VALUE) goto L17;
    L18:
        lastSteppedCct = cct;
    L19:
        this.mSteppedCctsAtOffsetCcts[index] = lastSteppedCct;
        index = index + 1;
        goto L8
    L17:
        if (Math.abs(lastSteppedCct - cct) < steps[parallelArraysIndex]) goto L19;
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Integer evaluate2(float fraction, Integer startValue, Integer endValue) {
        int cct = (int) (startValue.intValue() + ((endValue.intValue() - startValue.intValue()) * fraction));
        int index = cct - this.mIndexOffset;
        if (index >= 0) goto L5;
    L9:
        Slog.e(TAG, "steppedCctValueAt: returning same since invalid requested index=" + index);
        return Integer.valueOf(cct);
    L5:
        if (index >= this.mSteppedCctsAtOffsetCcts.length) goto L9;
        return Integer.valueOf(this.mSteppedCctsAtOffsetCcts[index]);
    }

    private void setStepOfOne() {
        Arrays.fill(this.mStepsAtOffsetCcts, 1);
        int i = 0;
    L4:
        if (i >= this.mSteppedCctsAtOffsetCcts.length) goto L7;
        this.mSteppedCctsAtOffsetCcts[i] = this.mIndexOffset + i;
        i = i + 1;
        goto L4
    }
}
