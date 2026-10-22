package com.android.server.display.brightness;

import android.content.Context;
import android.pico.utils.IExtBase;
import com.android.server.display.brightness.strategy.DisplayBrightnessStrategy;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtDisplayBrightnessStrategySelector extends IExtBase {
    void setBrightness(float r1, float r2);

    boolean skipOverrideBrightness2Auto();

    default DisplayBrightnessStrategy selectStrategy(StrategySelectionRequest strategySelectionRequest) {
        return null;
    }

    default DisplayBrightnessStrategy selectPostTemporaryStrategy(StrategySelectionRequest strategySelectionRequest) {
        return null;
    }

    default void onBaseReady(Context context, int displayId) {
    }

    default void onBrightnessClampedForManualRange(float effectiveSdrBrightness) {
    }

    default void onDisplayBrightnessStrategySelected(DisplayBrightnessStrategy strategy) {
    }

    default void strategySelectionPostProcessor(StrategySelectionNotifyRequest strategySelectionNotifyRequest) {
    }

    default void dump(PrintWriter writer) {
    }
}
