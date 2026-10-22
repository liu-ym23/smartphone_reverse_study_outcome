package com.android.server.display.brightness.strategy;

import com.android.server.display.IExtDisplayPowerController;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtAutomaticBrightnessStrategy extends IExtAutomaticBrightnessStrategy2 {
    @Override // com.android.server.display.brightness.strategy.IExtAutomaticBrightnessStrategy2
    boolean manuAutoBrightnessEnabled();

    float overrideManuAutoBrightness(float r1);

    @Override // com.android.server.display.brightness.strategy.IExtAutomaticBrightnessStrategy2
    void setDisplayPowerController(IExtDisplayPowerController r1);

    boolean skipOverrideBrightness2Auto();
}
