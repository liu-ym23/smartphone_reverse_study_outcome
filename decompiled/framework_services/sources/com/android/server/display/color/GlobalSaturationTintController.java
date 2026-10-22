package com.android.server.display.color;

import android.content.Context;
import android.hardware.display.ColorDisplayManager;
import android.opengl.Matrix;
import android.util.Slog;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class GlobalSaturationTintController extends TintController {
    private final float[] mMatrixGlobalSaturation;

    GlobalSaturationTintController() {
        this.mMatrixGlobalSaturation = new float[16];
    }

    @Override // com.android.server.display.color.TintController
    public void setUp(Context context, boolean needsLinear) {
    }

    @Override // com.android.server.display.color.TintController
    public float[] getMatrix() {
        return Arrays.copyOf(this.mMatrixGlobalSaturation, this.mMatrixGlobalSaturation.length);
    }

    @Override // com.android.server.display.color.TintController
    public void setMatrix(int saturationLevel) {
        if (saturationLevel >= 0) goto L5;
        saturationLevel = 0;
    L7:
        Slog.d("ColorDisplayService", "Setting saturation level: " + saturationLevel);
        if (saturationLevel != 100) goto L10;
        setActivated(false);
        Matrix.setIdentityM(this.mMatrixGlobalSaturation, 0);
        return;
    L10:
        setActivated(true);
        float saturation = saturationLevel * 0.01f;
        float desaturation = 1.0f - saturation;
        float[] luminance = {0.231f * desaturation, 0.715f * desaturation, 0.072f * desaturation};
        this.mMatrixGlobalSaturation[0] = luminance[0] + saturation;
        this.mMatrixGlobalSaturation[1] = luminance[0];
        this.mMatrixGlobalSaturation[2] = luminance[0];
        this.mMatrixGlobalSaturation[4] = luminance[1];
        this.mMatrixGlobalSaturation[5] = luminance[1] + saturation;
        this.mMatrixGlobalSaturation[6] = luminance[1];
        this.mMatrixGlobalSaturation[8] = luminance[2];
        this.mMatrixGlobalSaturation[9] = luminance[2];
        this.mMatrixGlobalSaturation[10] = luminance[2] + saturation;
        return;
    L5:
        if (saturationLevel <= 100) goto L7;
        saturationLevel = 100;
        goto L7
    }

    @Override // com.android.server.display.color.TintController
    public int getLevel() {
        return 150;
    }

    @Override // com.android.server.display.color.TintController
    public boolean isAvailable(Context context) {
        return ColorDisplayManager.isColorTransformAccelerated(context);
    }
}
