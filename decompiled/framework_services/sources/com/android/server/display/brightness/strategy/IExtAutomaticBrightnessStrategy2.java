package com.android.server.display.brightness.strategy;

import android.pico.utils.IExtBase;
import com.android.server.display.IExtDisplayPowerController;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtAutomaticBrightnessStrategy2 extends IExtBase {
    boolean manuAutoBrightnessEnabled();

    void setDisplayPowerController(IExtDisplayPowerController r1);
}
