package com.android.server.display.brightness.clamper;

import android.os.IBinder;
import android.pico.utils.IExtBase;
import com.android.server.display.config.HdrBrightnessData;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtHdrBrightnessModifier extends IExtBase {
    HdrBrightnessModifier.Mode getHdrMode();

    boolean isHdrExit(float r1, float r2, HdrBrightnessData r3);

    boolean isHdrExitMode();

    boolean isHdrMode();

    void onDisplayChanged(BrightnessClamperController.DisplayDeviceData r1, HdrBrightnessModifier.Mode r2);

    void onHdrInfoChanged(float r1, float r2, HdrBrightnessModifier.Mode r3);

    void onHdrInfoChanged(IBinder r1, int r2, int r3, int r4, int r5, float r6);

    void onLowPowerModeChange(boolean r1, HdrBrightnessModifier.Mode r2);

    void setHdrMode(HdrBrightnessModifier.Mode r1);
}
