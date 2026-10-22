package com.android.server.display.brightness.strategy;

import android.pico.utils.ExtImplFactory;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.brightness.StrategyExecutionRequest;
import com.android.server.display.brightness.StrategySelectionNotifyRequest;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class TemporaryBrightnessStrategy implements DisplayBrightnessStrategy {
    private IExtTemporaryBrightnessStrategy mExt;
    protected float mTemporaryScreenBrightness;

    public TemporaryBrightnessStrategy() {
        this.mExt = (IExtTemporaryBrightnessStrategy) ExtImplFactory.getImpl(IExtTemporaryBrightnessStrategy.class, new Object[]{this});
        this.mTemporaryScreenBrightness = Float.NaN;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public DisplayBrightnessState updateBrightness(StrategyExecutionRequest strategyExecutionRequest) {
        DisplayBrightnessState displayBrightnessState = this.mExt.updateBrightness(strategyExecutionRequest);
        return displayBrightnessState;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public String getName() {
        return "TemporaryBrightnessStrategy";
    }

    public float getTemporaryScreenBrightness() {
        return this.mTemporaryScreenBrightness;
    }

    public void setTemporaryScreenBrightness(float temporaryScreenBrightness) {
        this.mTemporaryScreenBrightness = temporaryScreenBrightness;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void dump(PrintWriter writer) {
        writer.println("TemporaryBrightnessStrategy:");
        writer.println("  mTemporaryScreenBrightness:" + this.mTemporaryScreenBrightness);
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void strategySelectionPostProcessor(StrategySelectionNotifyRequest strategySelectionNotifyRequest) {
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public int getReason() {
        return 7;
    }

    public String toString() {
        return "TemporaryBrightnessStrategy:" + this.mTemporaryScreenBrightness;
    }
}
