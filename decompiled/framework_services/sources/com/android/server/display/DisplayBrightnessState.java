package com.android.server.display;

import android.hardware.display.BrightnessInfo;
import android.text.TextUtils;
import com.android.server.display.brightness.BrightnessEvent;
import com.android.server.display.brightness.BrightnessReason;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class DisplayBrightnessState {
    public static final float BRIGHTNESS_NOT_SET = -1.0f;
    public static final float CUSTOM_ANIMATION_RATE_NOT_SET = -1.0f;
    private final float mBrightness;
    private final int mBrightnessAdjustmentFlag;
    private final BrightnessEvent mBrightnessEvent;
    private int mBrightnessMaxReason;
    private final BrightnessReason mBrightnessReason;
    private final float mCustomAnimationRate;
    private final String mDisplayBrightnessStrategyName;
    private final float mHdrBrightness;
    private final boolean mIsSlowChange;
    private final boolean mIsUserInitiatedChange;
    private final float mMaxBrightness;
    private final float mMinBrightness;
    private final boolean mShouldUpdateScreenBrightnessSetting;
    private final boolean mShouldUseAutoBrightness;

    public static class Builder {
        private float mBrightness;
        private int mBrightnessAdjustmentFlag;
        private BrightnessEvent mBrightnessEvent;
        private int mBrightnessMaxReason;
        private BrightnessReason mBrightnessReason;
        private float mCustomAnimationRate;
        private String mDisplayBrightnessStrategyName;
        private float mHdrBrightness;
        private boolean mIsSlowChange;
        private boolean mIsUserInitiatedChange;
        private float mMaxBrightness;
        private float mMinBrightness;
        private boolean mShouldUpdateScreenBrightnessSetting;
        private boolean mShouldUseAutoBrightness;

        public Builder() {
            this.mHdrBrightness = -1.0f;
            this.mBrightnessReason = new BrightnessReason();
            this.mMaxBrightness = 1.0f;
            this.mCustomAnimationRate = -1.0f;
            this.mBrightnessAdjustmentFlag = 0;
            this.mBrightnessMaxReason = 0;
        }

        public static Builder from(DisplayBrightnessState state) {
            Builder builder = new Builder();
            builder.setBrightness(state.getBrightness());
            builder.setHdrBrightness(state.getHdrBrightness());
            builder.setBrightnessReason(state.getBrightnessReason());
            builder.setDisplayBrightnessStrategyName(state.getDisplayBrightnessStrategyName());
            builder.setShouldUseAutoBrightness(state.getShouldUseAutoBrightness());
            builder.setIsSlowChange(state.isSlowChange());
            builder.setMaxBrightness(state.getMaxBrightness());
            builder.setMinBrightness(state.getMinBrightness());
            builder.setCustomAnimationRate(state.getCustomAnimationRate());
            builder.setShouldUpdateScreenBrightnessSetting(state.shouldUpdateScreenBrightnessSetting());
            builder.setBrightnessEvent(state.getBrightnessEvent());
            builder.setBrightnessAdjustmentFlag(state.getBrightnessAdjustmentFlag());
            builder.setIsUserInitiatedChange(state.isUserInitiatedChange());
            builder.setBrightnessMaxReason(state.getBrightnessMaxReason());
            return builder;
        }

        public float getBrightness() {
            return this.mBrightness;
        }

        public Builder setBrightness(float brightness) {
            this.mBrightness = brightness;
            return this;
        }

        public float getHdrBrightness() {
            return this.mHdrBrightness;
        }

        public Builder setHdrBrightness(float hdrBrightness) {
            this.mHdrBrightness = hdrBrightness;
            return this;
        }

        public BrightnessReason getBrightnessReason() {
            return this.mBrightnessReason;
        }

        public Builder setBrightnessReason(BrightnessReason brightnessReason) {
            this.mBrightnessReason = brightnessReason;
            return this;
        }

        public Builder setBrightnessReason(int brightnessReason) {
            return setBrightnessReason(new BrightnessReason(brightnessReason));
        }

        public String getDisplayBrightnessStrategyName() {
            return this.mDisplayBrightnessStrategyName;
        }

        public Builder setDisplayBrightnessStrategyName(String displayBrightnessStrategyName) {
            this.mDisplayBrightnessStrategyName = displayBrightnessStrategyName;
            return this;
        }

        public Builder setShouldUseAutoBrightness(boolean shouldUseAutoBrightness) {
            this.mShouldUseAutoBrightness = shouldUseAutoBrightness;
            return this;
        }

        public boolean getShouldUseAutoBrightness() {
            return this.mShouldUseAutoBrightness;
        }

        public Builder setIsSlowChange(boolean isSlowChange) {
            this.mIsSlowChange = isSlowChange;
            return this;
        }

        public boolean isSlowChange() {
            return this.mIsSlowChange;
        }

        public Builder setMaxBrightness(float maxBrightness) {
            this.mMaxBrightness = maxBrightness;
            return this;
        }

        public float getMaxBrightness() {
            return this.mMaxBrightness;
        }

        public Builder setMinBrightness(float minBrightness) {
            this.mMinBrightness = minBrightness;
            return this;
        }

        public float getMinBrightness() {
            return this.mMinBrightness;
        }

        public Builder setCustomAnimationRate(float animationRate) {
            this.mCustomAnimationRate = animationRate;
            return this;
        }

        public float getCustomAnimationRate() {
            return this.mCustomAnimationRate;
        }

        public boolean shouldUpdateScreenBrightnessSetting() {
            return this.mShouldUpdateScreenBrightnessSetting;
        }

        public Builder setShouldUpdateScreenBrightnessSetting(boolean shouldUpdateScreenBrightnessSetting) {
            this.mShouldUpdateScreenBrightnessSetting = shouldUpdateScreenBrightnessSetting;
            return this;
        }

        public DisplayBrightnessState build() {
            return new DisplayBrightnessState(this, null);
        }

        public BrightnessEvent getBrightnessEvent() {
            return this.mBrightnessEvent;
        }

        public Builder setBrightnessEvent(BrightnessEvent brightnessEvent) {
            this.mBrightnessEvent = brightnessEvent;
            return this;
        }

        public int getBrightnessAdjustmentFlag() {
            return this.mBrightnessAdjustmentFlag;
        }

        public Builder setBrightnessAdjustmentFlag(int brightnessAdjustmentFlag) {
            this.mBrightnessAdjustmentFlag = brightnessAdjustmentFlag;
            return this;
        }

        public boolean isUserInitiatedChange() {
            return this.mIsUserInitiatedChange;
        }

        public Builder setIsUserInitiatedChange(boolean isUserInitiatedChange) {
            this.mIsUserInitiatedChange = isUserInitiatedChange;
            return this;
        }

        public int getBrightnessMaxReason() {
            return this.mBrightnessMaxReason;
        }

        public Builder setBrightnessMaxReason(int brightnessMaxReason) {
            this.mBrightnessMaxReason = brightnessMaxReason;
            return this;
        }
    }

    /* synthetic */ DisplayBrightnessState(Builder r1, DisplayBrightnessStateIA r2) {
        this(r1);
    }

    private DisplayBrightnessState(Builder builder) {
        this.mBrightness = builder.getBrightness();
        this.mHdrBrightness = builder.getHdrBrightness();
        this.mBrightnessReason = builder.getBrightnessReason();
        this.mDisplayBrightnessStrategyName = builder.getDisplayBrightnessStrategyName();
        this.mShouldUseAutoBrightness = builder.getShouldUseAutoBrightness();
        this.mIsSlowChange = builder.isSlowChange();
        this.mMaxBrightness = builder.getMaxBrightness();
        this.mMinBrightness = builder.getMinBrightness();
        this.mCustomAnimationRate = builder.getCustomAnimationRate();
        this.mShouldUpdateScreenBrightnessSetting = builder.shouldUpdateScreenBrightnessSetting();
        this.mBrightnessEvent = builder.getBrightnessEvent();
        this.mBrightnessAdjustmentFlag = builder.getBrightnessAdjustmentFlag();
        this.mIsUserInitiatedChange = builder.isUserInitiatedChange();
        this.mBrightnessMaxReason = builder.getBrightnessMaxReason();
    }

    public float getBrightness() {
        return this.mBrightness;
    }

    public float getHdrBrightness() {
        return this.mHdrBrightness;
    }

    public BrightnessReason getBrightnessReason() {
        return this.mBrightnessReason;
    }

    public String getDisplayBrightnessStrategyName() {
        return this.mDisplayBrightnessStrategyName;
    }

    public boolean getShouldUseAutoBrightness() {
        return this.mShouldUseAutoBrightness;
    }

    public boolean isSlowChange() {
        return this.mIsSlowChange;
    }

    public float getMaxBrightness() {
        return this.mMaxBrightness;
    }

    public float getMinBrightness() {
        return this.mMinBrightness;
    }

    public float getCustomAnimationRate() {
        return this.mCustomAnimationRate;
    }

    public boolean shouldUpdateScreenBrightnessSetting() {
        return this.mShouldUpdateScreenBrightnessSetting;
    }

    public BrightnessEvent getBrightnessEvent() {
        return this.mBrightnessEvent;
    }

    public int getBrightnessAdjustmentFlag() {
        return this.mBrightnessAdjustmentFlag;
    }

    public boolean isUserInitiatedChange() {
        return this.mIsUserInitiatedChange;
    }

    public int getBrightnessMaxReason() {
        return this.mBrightnessMaxReason;
    }

    public String toString() {
        return "DisplayBrightnessState:\n    brightness:" + getBrightness() + "\n    hdrBrightness:" + getHdrBrightness() + "\n    brightnessReason:" + getBrightnessReason() + "\n    shouldUseAutoBrightness:" + getShouldUseAutoBrightness() + "\n    isSlowChange:" + this.mIsSlowChange + "\n    maxBrightness:" + this.mMaxBrightness + "\n    minBrightness:" + this.mMinBrightness + "\n    customAnimationRate:" + this.mCustomAnimationRate + "\n    shouldUpdateScreenBrightnessSetting:" + this.mShouldUpdateScreenBrightnessSetting + "\n    mBrightnessEvent:" + Objects.toString(this.mBrightnessEvent, "null") + "\n    mBrightnessAdjustmentFlag:" + this.mBrightnessAdjustmentFlag + "\n    mIsUserInitiatedChange:" + this.mIsUserInitiatedChange + "\n    mBrightnessMaxReason:" + BrightnessInfo.briMaxReasonToString(this.mBrightnessMaxReason);
    }

    public boolean equals(Object other) {
        if (other != this) goto L6;
        return true;
    L6:
        if ((other instanceof DisplayBrightnessState) == true) goto L8;
        return false;
    L8:
        DisplayBrightnessState otherState = (DisplayBrightnessState) other;
        if (this.mBrightness != otherState.getBrightness()) goto L38;
        if (this.mHdrBrightness != otherState.getHdrBrightness()) goto L38;
        if (this.mBrightnessReason.equals(otherState.getBrightnessReason()) == false) goto L38;
        if (TextUtils.equals(this.mDisplayBrightnessStrategyName, otherState.getDisplayBrightnessStrategyName()) == false) goto L38;
        if (this.mShouldUseAutoBrightness != otherState.getShouldUseAutoBrightness()) goto L38;
        if (this.mIsSlowChange != otherState.isSlowChange()) goto L38;
        if (this.mMaxBrightness != otherState.getMaxBrightness()) goto L38;
        if (this.mMinBrightness != otherState.getMinBrightness()) goto L38;
        if (this.mCustomAnimationRate != otherState.getCustomAnimationRate()) goto L38;
        if (this.mShouldUpdateScreenBrightnessSetting != otherState.shouldUpdateScreenBrightnessSetting()) goto L38;
        if (Objects.equals(this.mBrightnessEvent, otherState.getBrightnessEvent()) == false) goto L38;
        if (this.mBrightnessAdjustmentFlag != otherState.getBrightnessAdjustmentFlag()) goto L38;
        if (this.mIsUserInitiatedChange != otherState.isUserInitiatedChange()) goto L38;
        if (this.mBrightnessMaxReason != otherState.getBrightnessMaxReason()) goto L38;
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Float.valueOf(this.mBrightness), Float.valueOf(this.mHdrBrightness), this.mBrightnessReason, Boolean.valueOf(this.mShouldUseAutoBrightness), Boolean.valueOf(this.mIsSlowChange), Float.valueOf(this.mMaxBrightness), Float.valueOf(this.mMinBrightness), Float.valueOf(this.mCustomAnimationRate), Boolean.valueOf(this.mShouldUpdateScreenBrightnessSetting), this.mBrightnessEvent, Integer.valueOf(this.mBrightnessAdjustmentFlag), Boolean.valueOf(this.mIsUserInitiatedChange), Integer.valueOf(this.mBrightnessMaxReason)});
    }

    public static Builder builder() {
        return new Builder();
    }
}
