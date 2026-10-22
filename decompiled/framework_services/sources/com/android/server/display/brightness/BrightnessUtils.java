package com.android.server.display.brightness;

import android.util.MathUtils;
import com.android.server.display.DisplayBrightnessState;

/* JADX INFO: loaded from: classes2.dex */
public final class BrightnessUtils {
    public BrightnessUtils() {
    }

    public static boolean isValidBrightnessValue(float brightness) {
        if (Float.isNaN(brightness) == false) goto L5;
    L9:
        return false;
    L5:
        if (brightness < 0.0f) goto L9;
        if (brightness > 1.0f) goto L9;
        return true;
    }

    public static float clampAbsoluteBrightness(float value) {
        return MathUtils.constrain(value, 0.0f, 1.0f);
    }

    public static float clampBrightnessAdjustment(float value) {
        return MathUtils.constrain(value, -1.0f, 1.0f);
    }

    public static DisplayBrightnessState constructDisplayBrightnessState(int brightnessChangeReason, float brightness, String displayBrightnessStrategyName) {
        return constructDisplayBrightnessState(brightnessChangeReason, brightness, displayBrightnessStrategyName, false);
    }

    public static DisplayBrightnessState constructDisplayBrightnessState(int brightnessChangeReason, float brightness, String displayBrightnessStrategyName, boolean slowChange) {
        BrightnessReason brightnessReason = new BrightnessReason();
        brightnessReason.setReason(brightnessChangeReason);
        return new DisplayBrightnessState.Builder().setBrightness(brightness).setBrightnessReason(brightnessReason).setDisplayBrightnessStrategyName(displayBrightnessStrategyName).setIsSlowChange(slowChange).build();
    }
}
