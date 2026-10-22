package com.android.server.display.brightness.clamper;

import android.hardware.display.DisplayManagerInternal;
import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtDisplayDimModifier extends IExtBase {
    float getBrightnessAdjusted(float r1, DisplayManagerInternal.DisplayPowerRequest r2, float r3, float r4);

    int getModifier();

    boolean shouldApply(DisplayManagerInternal.DisplayPowerRequest r1);
}
