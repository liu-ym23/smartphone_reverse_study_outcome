package com.android.server.power;

import android.hardware.display.DisplayManagerInternal;
import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtPowerGroup extends IExtBase {
    default void setXtPolicy(boolean isXt, int xtPolicy) {
    }

    default void updateScreenPolicyLocked() {
    }

    default void updateDozeScreenBrightness(DisplayManagerInternal.DisplayPowerRequest displayPowerRequest) {
    }

    default void boostPower() {
    }
}
