package com.android.server.display.brightness;

import android.hardware.display.DisplayManagerInternal;
import com.android.server.display.brightness.strategy.DisplayBrightnessStrategy;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class StrategySelectionNotifyRequest {
    private final boolean mAllowAutoBrightnessWhileDozingConfig;
    private DisplayManagerInternal.DisplayPowerRequest mDisplayPowerRequest;
    private final boolean mIsAutoBrightnessEnabled;
    private final boolean mIsBedtimeModeWearEnabled;
    private float mLastUserSetScreenBrightness;
    private final DisplayBrightnessStrategy mSelectedDisplayBrightnessStrategy;
    private int mTargetDisplayState;
    private boolean mUserSetBrightnessChanged;

    public StrategySelectionNotifyRequest(DisplayManagerInternal.DisplayPowerRequest displayPowerRequest, int targetDisplayState, DisplayBrightnessStrategy displayBrightnessStrategy, float lastUserSetScreenBrightness, boolean userSetBrightnessChanged, boolean allowAutoBrightnessWhileDozingConfig, boolean isAutoBrightnessEnabled, boolean isBedtimeModeWearEnabled) {
        this.mDisplayPowerRequest = displayPowerRequest;
        this.mTargetDisplayState = targetDisplayState;
        this.mSelectedDisplayBrightnessStrategy = displayBrightnessStrategy;
        this.mLastUserSetScreenBrightness = lastUserSetScreenBrightness;
        this.mUserSetBrightnessChanged = userSetBrightnessChanged;
        this.mAllowAutoBrightnessWhileDozingConfig = allowAutoBrightnessWhileDozingConfig;
        this.mIsAutoBrightnessEnabled = isAutoBrightnessEnabled;
        this.mIsBedtimeModeWearEnabled = isBedtimeModeWearEnabled;
    }

    public DisplayBrightnessStrategy getSelectedDisplayBrightnessStrategy() {
        return this.mSelectedDisplayBrightnessStrategy;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof StrategySelectionNotifyRequest) == true) goto L5;
        return false;
    L5:
        StrategySelectionNotifyRequest other = (StrategySelectionNotifyRequest) obj;
        if (other.getSelectedDisplayBrightnessStrategy() == getSelectedDisplayBrightnessStrategy()) goto L8;
        return false;
    L8:
        if (Objects.equals(this.mDisplayPowerRequest, other.getDisplayPowerRequest()) == true) goto L10;
        return false;
    L10:
        if (this.mTargetDisplayState == other.getTargetDisplayState()) goto L12;
        return false;
    L12:
        if (this.mUserSetBrightnessChanged == other.isUserSetBrightnessChanged()) goto L14;
        return false;
    L14:
        if (this.mLastUserSetScreenBrightness == other.getLastUserSetScreenBrightness()) goto L16;
        return false;
    L16:
        if (this.mAllowAutoBrightnessWhileDozingConfig == other.isAllowAutoBrightnessWhileDozingConfig()) goto L18;
        return false;
    L18:
        if (this.mIsAutoBrightnessEnabled == other.isAutoBrightnessEnabled()) goto L20;
        return false;
    L20:
        if (this.mIsBedtimeModeWearEnabled != other.isBedtimeModeWearEnabled()) goto L31;
        return true;
    L31:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mSelectedDisplayBrightnessStrategy, this.mDisplayPowerRequest, Integer.valueOf(this.mTargetDisplayState), Boolean.valueOf(this.mUserSetBrightnessChanged), Float.valueOf(this.mLastUserSetScreenBrightness), Boolean.valueOf(this.mAllowAutoBrightnessWhileDozingConfig), Boolean.valueOf(this.mIsAutoBrightnessEnabled)});
    }

    public float getLastUserSetScreenBrightness() {
        return this.mLastUserSetScreenBrightness;
    }

    public boolean isUserSetBrightnessChanged() {
        return this.mUserSetBrightnessChanged;
    }

    public boolean isBedtimeModeWearEnabled() {
        return this.mIsBedtimeModeWearEnabled;
    }

    public DisplayManagerInternal.DisplayPowerRequest getDisplayPowerRequest() {
        return this.mDisplayPowerRequest;
    }

    public int getTargetDisplayState() {
        return this.mTargetDisplayState;
    }

    public boolean isAllowAutoBrightnessWhileDozingConfig() {
        return this.mAllowAutoBrightnessWhileDozingConfig;
    }

    public boolean isAutoBrightnessEnabled() {
        return this.mIsAutoBrightnessEnabled;
    }

    public String toString() {
        return "StrategySelectionNotifyRequest: mDisplayPowerRequest=" + this.mDisplayPowerRequest + " mTargetDisplayState=" + this.mTargetDisplayState + " mSelectedDisplayBrightnessStrategy=" + this.mSelectedDisplayBrightnessStrategy + " mLastUserSetScreenBrightness=" + this.mLastUserSetScreenBrightness + " mUserSetBrightnessChanged=" + this.mUserSetBrightnessChanged + " mAllowAutoBrightnessWhileDozingConfig=" + this.mAllowAutoBrightnessWhileDozingConfig + " mIsAutoBrightnessEnabled=" + this.mIsAutoBrightnessEnabled + " mIsBedtimeModeWearEnabled" + this.mIsBedtimeModeWearEnabled;
    }
}
