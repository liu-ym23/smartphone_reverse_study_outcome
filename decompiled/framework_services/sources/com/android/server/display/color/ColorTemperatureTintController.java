package com.android.server.display.color;

/* JADX INFO: loaded from: classes2.dex */
abstract class ColorTemperatureTintController extends TintController {
    abstract float[] computeMatrixForCct(int r1);

    abstract int getAppliedCct();

    abstract int getDisabledCct();

    abstract CctEvaluator getEvaluator();

    abstract int getTargetCct();

    abstract void setAppliedCct(int r1);

    abstract void setTargetCct(int r1);

    ColorTemperatureTintController() {
    }
}
