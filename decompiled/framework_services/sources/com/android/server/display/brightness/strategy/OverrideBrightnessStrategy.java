package com.android.server.display.brightness.strategy;

import android.hardware.display.DisplayManagerInternal;
import android.pico.utils.ExtImplFactory;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.brightness.StrategyExecutionRequest;
import com.android.server.display.brightness.StrategySelectionNotifyRequest;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class OverrideBrightnessStrategy implements DisplayBrightnessStrategy {
    private IExtOverrideBrightnessStrategy mExt;
    protected float mWindowManagerBrightnessOverride;
    protected CharSequence mWindowManagerBrightnessOverrideTag;

    public OverrideBrightnessStrategy() {
        this.mWindowManagerBrightnessOverride = Float.NaN;
        this.mWindowManagerBrightnessOverrideTag = null;
        this.mExt = (IExtOverrideBrightnessStrategy) ExtImplFactory.getImpl(IExtOverrideBrightnessStrategy.class, new Object[]{this});
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public DisplayBrightnessState updateBrightness(StrategyExecutionRequest strategyExecutionRequest) {
        return this.mExt.updateBrightness(strategyExecutionRequest);
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public String getName() {
        return "OverrideBrightnessStrategy";
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void dump(PrintWriter writer) {
        writer.println("OverrideBrightnessStrategy:");
        writer.println("  mWindowManagerBrightnessOverride=" + this.mWindowManagerBrightnessOverride);
        writer.println("  mWindowManagerBrightnessOverrideTag=" + this.mWindowManagerBrightnessOverrideTag);
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void strategySelectionPostProcessor(StrategySelectionNotifyRequest strategySelectionNotifyRequest) {
    }

    public boolean updateWindowManagerBrightnessOverride(DisplayManagerInternal.DisplayBrightnessOverrideRequest request) {
        return this.mExt.updateWindowManagerBrightnessOverride(request);
    }

    public float getWindowManagerBrightnessOverride() {
        return this.mWindowManagerBrightnessOverride;
    }

    private boolean floatEquals(float f1, float f2) {
        if (f1 != f2) goto L5;
    L10:
        return true;
    L5:
        if (Float.isNaN(f1) == true) goto L7;
    L9:
        return false;
    L7:
        if (Float.isNaN(f2) == false) goto L9;
        goto L9
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public int getReason() {
        return 6;
    }
}
