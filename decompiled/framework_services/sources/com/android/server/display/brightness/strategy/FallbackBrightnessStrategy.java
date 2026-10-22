package com.android.server.display.brightness.strategy;

import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.brightness.BrightnessReason;
import com.android.server.display.brightness.StrategyExecutionRequest;
import com.android.server.display.brightness.StrategySelectionNotifyRequest;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class FallbackBrightnessStrategy implements DisplayBrightnessStrategy {
    public FallbackBrightnessStrategy() {
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public DisplayBrightnessState updateBrightness(StrategyExecutionRequest strategyExecutionRequest) {
        BrightnessReason brightnessReason = new BrightnessReason();
        brightnessReason.setReason(1);
        if (strategyExecutionRequest.isStylusBeingUsed() == false) goto L6;
        brightnessReason.setModifier(32);
    L6:
        return new DisplayBrightnessState.Builder().setBrightness(strategyExecutionRequest.getCurrentScreenBrightness()).setBrightnessReason(brightnessReason).setDisplayBrightnessStrategyName(getName()).setShouldUpdateScreenBrightnessSetting(true).setIsUserInitiatedChange(strategyExecutionRequest.isUserSetBrightnessChanged()).build();
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public String getName() {
        return DisplayBrightnessStrategyConstants.FALLBACK_BRIGHTNESS_STRATEGY_NAME;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public int getReason() {
        return 1;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void dump(PrintWriter writer) {
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void strategySelectionPostProcessor(StrategySelectionNotifyRequest strategySelectionNotifyRequest) {
    }
}
