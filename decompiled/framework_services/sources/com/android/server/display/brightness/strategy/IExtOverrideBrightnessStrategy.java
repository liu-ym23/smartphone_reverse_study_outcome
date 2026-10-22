package com.android.server.display.brightness.strategy;

import android.hardware.display.DisplayManagerInternal;
import android.pico.utils.IExtBase;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.brightness.StrategyExecutionRequest;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtOverrideBrightnessStrategy extends IExtBase {
    DisplayBrightnessState updateBrightness(StrategyExecutionRequest r1);

    boolean updateWindowManagerBrightnessOverride(DisplayManagerInternal.DisplayBrightnessOverrideRequest r1);
}
