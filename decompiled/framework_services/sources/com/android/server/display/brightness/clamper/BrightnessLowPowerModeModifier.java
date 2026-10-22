package com.android.server.display.brightness.clamper;

import android.hardware.display.DisplayManagerInternal;
import android.pico.utils.ExtImplFactory;
import android.util.IndentingPrintWriter;
import com.android.server.display.DisplayBrightnessState;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
class BrightnessLowPowerModeModifier extends BrightnessModifier {
    private IExtBrightnessLowPowerModeModifier mExt;

    BrightnessLowPowerModeModifier() {
        this.mExt = (IExtBrightnessLowPowerModeModifier) ExtImplFactory.getImpl(IExtBrightnessLowPowerModeModifier.class, new Object[]{this});
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier
    boolean shouldApply(DisplayManagerInternal.DisplayPowerRequest request) {
        return request.lowPowerMode;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier
    float getBrightnessAdjusted(float currentBrightness, DisplayManagerInternal.DisplayPowerRequest request) {
        float brightnessFactor = Math.min(request.screenLowPowerBrightnessFactor, 1.0f);
        return Math.max(currentBrightness * brightnessFactor, 0.0f);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier
    int getModifier() {
        return 2;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier, com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void apply(DisplayManagerInternal.DisplayPowerRequest request, DisplayBrightnessState.Builder stateBuilder) {
        if (this.mExt == null) goto L6;
        this.mExt.apply(request, stateBuilder);
        return;
    L6:
        super.apply(request, stateBuilder);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessModifier, com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void dump(PrintWriter pw) {
        pw.println("BrightnessLowPowerModeModifier:");
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "    ");
        super.dump(ipw);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public boolean shouldListenToLightSensor() {
        return false;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void setAmbientLux(float lux) {
    }

    public IExtBrightnessLowPowerModeModifier getExt() {
        return this.mExt;
    }
}
