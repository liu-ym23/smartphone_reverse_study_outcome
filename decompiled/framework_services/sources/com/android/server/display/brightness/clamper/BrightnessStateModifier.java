package com.android.server.display.brightness.clamper;

import android.hardware.display.DisplayManagerInternal;
import com.android.server.display.DisplayBrightnessState;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface BrightnessStateModifier {
    void apply(DisplayManagerInternal.DisplayPowerRequest r1, DisplayBrightnessState.Builder r2);

    void dump(PrintWriter r1);

    void setAmbientLux(float r1);

    boolean shouldListenToLightSensor();

    void stop();
}
