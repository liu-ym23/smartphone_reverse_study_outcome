package com.android.server.display.brightness.strategy;

import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.brightness.BrightnessUtils;
import com.android.server.display.brightness.StrategyExecutionRequest;
import com.android.server.display.brightness.StrategySelectionNotifyRequest;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class FollowerBrightnessStrategy implements DisplayBrightnessStrategy {
    private float mBrightnessToFollow;
    private boolean mBrightnessToFollowSlowChange;
    private final int mDisplayId;

    public FollowerBrightnessStrategy(int displayId) {
        this.mDisplayId = displayId;
        this.mBrightnessToFollow = Float.NaN;
        this.mBrightnessToFollowSlowChange = false;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public DisplayBrightnessState updateBrightness(StrategyExecutionRequest strategyExecutionRequest) {
        return BrightnessUtils.constructDisplayBrightnessState(10, this.mBrightnessToFollow, getName(), this.mBrightnessToFollowSlowChange);
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public String getName() {
        return "FollowerBrightnessStrategy";
    }

    public float getBrightnessToFollow() {
        return this.mBrightnessToFollow;
    }

    public void setBrightnessToFollow(float brightnessToFollow, boolean slowChange) {
        this.mBrightnessToFollow = brightnessToFollow;
        this.mBrightnessToFollowSlowChange = slowChange;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void dump(PrintWriter writer) {
        writer.println("FollowerBrightnessStrategy:");
        writer.println("  mDisplayId=" + this.mDisplayId);
        writer.println("  mBrightnessToFollow:" + this.mBrightnessToFollow);
        writer.println("  mBrightnessToFollowSlowChange:" + this.mBrightnessToFollowSlowChange);
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void strategySelectionPostProcessor(StrategySelectionNotifyRequest strategySelectionNotifyRequest) {
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public int getReason() {
        return 10;
    }
}
