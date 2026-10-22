package com.android.server.display.brightness;

import android.hardware.display.DisplayManagerInternal;
import android.pico.utils.IExtBase;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.brightness.strategy.DisplayBrightnessStrategy;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtDisplayBrightnessController extends IExtBase {
    void setStylusBeingUsed(boolean r1);

    DisplayBrightnessState updateBrightness(DisplayBrightnessState r1, DisplayBrightnessStrategy r2, DisplayManagerInternal.DisplayPowerRequest r3);
}
