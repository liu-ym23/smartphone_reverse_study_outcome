package com.android.server.display.brightness.strategy;

import android.util.Slog;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.brightness.BrightnessUtils;
import com.android.server.display.brightness.StrategyExecutionRequest;
import com.android.server.display.brightness.StrategySelectionNotifyRequest;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class DozeBrightnessStrategy implements DisplayBrightnessStrategy {
    public DozeBrightnessStrategy() {
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public DisplayBrightnessState updateBrightness(StrategyExecutionRequest strategyExecutionRequest) {
        if (strategyExecutionRequest.getDisplayPowerRequest().dozeScreenState != 1) goto L7;
        Slog.d(getName(), "DozeBrightnessStrategy updateBrightness");
        return BrightnessUtils.constructDisplayBrightnessState(2, -1.0f, getName());
    L7:
        return BrightnessUtils.constructDisplayBrightnessState(2, strategyExecutionRequest.getDisplayPowerRequest().dozeScreenBrightness, getName());
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public String getName() {
        return "DozeBrightnessStrategy";
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void dump(PrintWriter writer) {
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void strategySelectionPostProcessor(StrategySelectionNotifyRequest strategySelectionNotifyRequest) {
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public int getReason() {
        return 2;
    }
}
