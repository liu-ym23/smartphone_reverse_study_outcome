package com.android.server.display.brightness.clamper;

import android.hardware.display.DisplayManagerInternal;
import android.pico.utils.IExtBase;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.IExtDisplayPowerController;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtBrightnessLowPowerModeModifier extends IExtBase {
    void apply(DisplayManagerInternal.DisplayPowerRequest r1, DisplayBrightnessState.Builder r2);

    void setDisplayPowerController(IExtDisplayPowerController r1);
}
