package com.android.server.display;

import android.hardware.SensorManager;
import android.os.Handler;
import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtDisplayPowerProximityStateController extends IExtBase {
    void init(SensorManager r1, Handler r2);

    void updatePickUpState(boolean r1, boolean r2);

    default boolean processProximityEventWithPickup(boolean positive) {
        return positive;
    }
}
