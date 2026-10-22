package com.android.server.display.brightness.clamper;

import android.hardware.display.DisplayManagerInternal;
import com.android.server.display.DisplayBrightnessState;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
abstract class BrightnessModifier implements BrightnessStateModifier {
    private boolean mApplied;

    abstract float getBrightnessAdjusted(float r1, DisplayManagerInternal.DisplayPowerRequest r2);

    abstract int getModifier();

    abstract boolean shouldApply(DisplayManagerInternal.DisplayPowerRequest r1);

    BrightnessModifier() {
        this.mApplied = false;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void apply(DisplayManagerInternal.DisplayPowerRequest request, DisplayBrightnessState.Builder stateBuilder) {
        if (shouldApply(request) == false) goto L13;
        float value = stateBuilder.getBrightness();
        if (value <= 0.0f) goto L8;
        stateBuilder.setBrightness(getBrightnessAdjusted(value, request));
        stateBuilder.getBrightnessReason().addModifier(getModifier());
    L8:
        if (this.mApplied == true) goto L10;
        stateBuilder.setIsSlowChange(false);
        stateBuilder.setCustomAnimationRate(-1.0f);
    L10:
        this.mApplied = true;
        return;
    L13:
        if (this.mApplied == false) goto L17;
        stateBuilder.setIsSlowChange(false);
        stateBuilder.setCustomAnimationRate(-1.0f);
        this.mApplied = false;
        return;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void dump(PrintWriter pw) {
        pw.println("BrightnessModifier:");
        pw.println("  mApplied=" + this.mApplied);
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessStateModifier
    public void stop() {
    }
}
