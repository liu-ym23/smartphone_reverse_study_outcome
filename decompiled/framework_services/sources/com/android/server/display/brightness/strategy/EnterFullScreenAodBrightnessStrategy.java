package com.android.server.display.brightness.strategy;

import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.brightness.BrightnessUtils;
import com.android.server.display.brightness.StrategyExecutionRequest;
import com.android.server.display.brightness.StrategySelectionNotifyRequest;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class EnterFullScreenAodBrightnessStrategy implements DisplayBrightnessStrategy {
    private static final String TAG = "EnterFullScreenAodBrightnessStrategy";
    private float mAodTargetBrightness;

    public EnterFullScreenAodBrightnessStrategy() {
        this.mAodTargetBrightness = Float.NaN;
    }

    public void setAodTargetBrightness(float aodTargetBrightness) {
        this.mAodTargetBrightness = aodTargetBrightness;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public DisplayBrightnessState updateBrightness(StrategyExecutionRequest strategyExecutionRequest) {
        float targetBrightness = strategyExecutionRequest.getCurrentScreenBrightness();
        if (BrightnessUtils.isValidBrightnessValue(this.mAodTargetBrightness) == false) goto L10;
        if (BrightnessUtils.isValidBrightnessValue(targetBrightness) == false) goto L10;
        if (targetBrightness <= this.mAodTargetBrightness) goto L10;
        targetBrightness = this.mAodTargetBrightness;
    L10:
        return BrightnessUtils.constructDisplayBrightnessState(getReason(), targetBrightness, getName());
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public String getName() {
        return TAG;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public int getReason() {
        return 14;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void dump(PrintWriter writer) {
        writer.println("EnterFullScreenAodBrightnessStrategy:");
        writer.println("  mAodTargetBrightness=" + this.mAodTargetBrightness);
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void strategySelectionPostProcessor(StrategySelectionNotifyRequest strategySelectionNotifyRequest) {
    }
}
