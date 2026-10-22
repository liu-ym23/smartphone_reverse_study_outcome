package com.android.server.display.brightness;

import android.hardware.display.DisplayManagerInternal;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class StrategyExecutionRequest {
    private final float mCurrentScreenBrightness;
    private final DisplayManagerInternal.DisplayPowerRequest mDisplayPowerRequest;
    private boolean mIsStylusBeingUsed;
    private boolean mUserSetBrightnessChanged;

    public StrategyExecutionRequest(DisplayManagerInternal.DisplayPowerRequest displayPowerRequest, float currentScreenBrightness, boolean userSetBrightnessChanged, boolean isStylusBeingUsed) {
        this.mDisplayPowerRequest = displayPowerRequest;
        this.mCurrentScreenBrightness = currentScreenBrightness;
        this.mUserSetBrightnessChanged = userSetBrightnessChanged;
        this.mIsStylusBeingUsed = isStylusBeingUsed;
    }

    public DisplayManagerInternal.DisplayPowerRequest getDisplayPowerRequest() {
        return this.mDisplayPowerRequest;
    }

    public float getCurrentScreenBrightness() {
        return this.mCurrentScreenBrightness;
    }

    public boolean isUserSetBrightnessChanged() {
        return this.mUserSetBrightnessChanged;
    }

    public boolean isStylusBeingUsed() {
        return this.mIsStylusBeingUsed;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof StrategyExecutionRequest) == true) goto L5;
        return false;
    L5:
        StrategyExecutionRequest other = (StrategyExecutionRequest) obj;
        if (Objects.equals(this.mDisplayPowerRequest, other.getDisplayPowerRequest()) == true) goto L8;
        return false;
    L8:
        if (this.mCurrentScreenBrightness == other.getCurrentScreenBrightness()) goto L10;
        return false;
    L10:
        if (this.mUserSetBrightnessChanged == other.isUserSetBrightnessChanged()) goto L12;
        return false;
    L12:
        if (this.mIsStylusBeingUsed != other.isStylusBeingUsed()) goto L19;
        return true;
    L19:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mDisplayPowerRequest, Float.valueOf(this.mCurrentScreenBrightness), Boolean.valueOf(this.mUserSetBrightnessChanged), Boolean.valueOf(this.mIsStylusBeingUsed)});
    }
}
