package com.android.server.display.color;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.ColorDisplayManager;
import android.opengl.Matrix;
import android.util.Slog;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ReduceBrightColorsTintController extends TintController {
    private final float[] mCoefficients;
    private final float[] mMatrix;
    private int mStrength;

    public ReduceBrightColorsTintController() {
        this.mMatrix = new float[16];
        this.mCoefficients = new float[3];
    }

    @Override // com.android.server.display.color.TintController
    public /* bridge */ /* synthetic */ void cancelAnimator() {
        super.cancelAnimator();
    }

    @Override // com.android.server.display.color.TintController
    public /* bridge */ /* synthetic */ void endAnimator() {
        super.endAnimator();
    }

    @Override // com.android.server.display.color.TintController
    public /* bridge */ /* synthetic */ ValueAnimator getAnimator() {
        return super.getAnimator();
    }

    @Override // com.android.server.display.color.TintController
    public /* bridge */ /* synthetic */ long getTransitionDurationMilliseconds() {
        return super.getTransitionDurationMilliseconds();
    }

    @Override // com.android.server.display.color.TintController
    public /* bridge */ /* synthetic */ long getTransitionDurationMilliseconds(boolean r3) {
        return super.getTransitionDurationMilliseconds(r3);
    }

    @Override // com.android.server.display.color.TintController
    public /* bridge */ /* synthetic */ boolean isActivated() {
        return super.isActivated();
    }

    @Override // com.android.server.display.color.TintController
    public /* bridge */ /* synthetic */ boolean isActivatedStateNotSet() {
        return super.isActivatedStateNotSet();
    }

    @Override // com.android.server.display.color.TintController
    public /* bridge */ /* synthetic */ void setAnimator(ValueAnimator r1) {
        super.setAnimator(r1);
    }

    @Override // com.android.server.display.color.TintController
    public void setUp(Context context, boolean needsLinear) {
        Resources r0 = context.getResources();
        if (needsLinear == false) goto L5;
        int r1 = R.array.config_serialPorts;
    L6:
        String[] coefficients = r0.getStringArray(r1);
        int i = 0;
    L8:
        if (i >= 3) goto L12;
        if (i >= coefficients.length) goto L15;
        this.mCoefficients[i] = Float.parseFloat(coefficients[i]);
        i = i + 1;
        goto L8
    L15:
        return;
    L12:
        return;
    L5:
        r1 = R.array.config_serviceStateLocationAllowedPackages;
        goto L6
    }

    @Override // com.android.server.display.color.TintController
    public float[] getMatrix() {
        if (isActivated() == false) goto L6;
        return Arrays.copyOf(this.mMatrix, this.mMatrix.length);
    L6:
        return ColorDisplayService.MATRIX_IDENTITY;
    }

    @Override // com.android.server.display.color.TintController
    public void setMatrix(int strengthLevel) {
        if (strengthLevel >= 0) goto L5;
        strengthLevel = 0;
    L7:
        Slog.d("ColorDisplayService", "Setting bright color reduction level: " + strengthLevel);
        this.mStrength = strengthLevel;
        Matrix.setIdentityM(this.mMatrix, 0);
        float componentValue = computeComponentValue(strengthLevel);
        this.mMatrix[0] = componentValue;
        this.mMatrix[5] = componentValue;
        this.mMatrix[10] = componentValue;
        return;
    L5:
        if (strengthLevel <= 100) goto L7;
        strengthLevel = 100;
        goto L7
    }

    private float clamp(float value) {
        if (value <= 1.0f) goto L6;
        return 1.0f;
    L6:
        if (value >= 0.0f) goto L8;
        return 0.0f;
    L8:
        return value;
    }

    @Override // com.android.server.display.color.TintController
    public void dump(PrintWriter pw) {
        pw.println("    mStrength = " + this.mStrength);
    }

    @Override // com.android.server.display.color.TintController
    public int getLevel() {
        return 250;
    }

    @Override // com.android.server.display.color.TintController
    public boolean isAvailable(Context context) {
        return ColorDisplayManager.isColorTransformAccelerated(context);
    }

    @Override // com.android.server.display.color.TintController
    public void setActivated(Boolean isActivated) {
        super.setActivated(isActivated);
        if (isActivated != null) goto L5;
    L7:
        String r0 = "Turning off reduce bright colors";
    L8:
        Slog.i("ColorDisplayService", r0);
        return;
    L5:
        if (isActivated.booleanValue() == false) goto L7;
        r0 = "Turning on reduce bright colors";
        goto L8
    }

    public int getStrength() {
        return this.mStrength;
    }

    public float getOffsetFactor() {
        return (this.mCoefficients[0] + this.mCoefficients[1]) + this.mCoefficients[2];
    }

    public float getAdjustedBrightness(float nits) {
        return computeComponentValue(this.mStrength) * nits;
    }

    public float getAdjustedNitsForStrength(float nits, int strength) {
        return computeComponentValue(strength) * nits;
    }

    private float computeComponentValue(int strengthLevel) {
        float percentageStrength = strengthLevel / 100.0f;
        float squaredPercentageStrength = percentageStrength * percentageStrength;
        return clamp(((this.mCoefficients[0] * squaredPercentageStrength) + (this.mCoefficients[1] * percentageStrength)) + this.mCoefficients[2]);
    }
}
