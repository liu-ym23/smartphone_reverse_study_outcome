package com.android.server.display.brightness.strategy;

import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.brightness.BrightnessReason;
import com.android.server.display.brightness.StrategyExecutionRequest;
import com.android.server.display.brightness.StrategySelectionNotifyRequest;
import com.android.server.display.feature.DisplayManagerFlags;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class OffloadBrightnessStrategy implements DisplayBrightnessStrategy {
    private final DisplayManagerFlags mDisplayManagerFlags;
    private float mOffloadScreenBrightness;

    public OffloadBrightnessStrategy(DisplayManagerFlags displayManagerFlags) {
        this.mDisplayManagerFlags = displayManagerFlags;
        this.mOffloadScreenBrightness = Float.NaN;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public DisplayBrightnessState updateBrightness(StrategyExecutionRequest strategyExecutionRequest) {
        float offloadBrightness = this.mOffloadScreenBrightness;
        if (this.mDisplayManagerFlags.isRefactorDisplayPowerControllerEnabled() == false) goto L5;
        this.mOffloadScreenBrightness = Float.NaN;
    L5:
        BrightnessReason brightnessReason = new BrightnessReason();
        brightnessReason.setReason(11);
        return new DisplayBrightnessState.Builder().setBrightness(offloadBrightness).setBrightnessReason(brightnessReason).setDisplayBrightnessStrategyName(getName()).setIsSlowChange(false).setShouldUpdateScreenBrightnessSetting(true).build();
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public String getName() {
        return "OffloadBrightnessStrategy";
    }

    public float getOffloadScreenBrightness() {
        return this.mOffloadScreenBrightness;
    }

    public void setOffloadScreenBrightness(float offloadScreenBrightness) {
        this.mOffloadScreenBrightness = offloadScreenBrightness;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void dump(PrintWriter writer) {
        writer.println("OffloadBrightnessStrategy:");
        writer.println("  mOffloadScreenBrightness:" + this.mOffloadScreenBrightness);
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void strategySelectionPostProcessor(StrategySelectionNotifyRequest strategySelectionNotifyRequest) {
        if (strategySelectionNotifyRequest.getSelectedDisplayBrightnessStrategy().getName().equals(getName()) == false) goto L5;
        return;
    L5:
        if (strategySelectionNotifyRequest.getSelectedDisplayBrightnessStrategy().getName().equals("InvalidBrightnessStrategy") == true) goto L9;
        this.mOffloadScreenBrightness = Float.NaN;
        return;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public int getReason() {
        return 11;
    }
}
