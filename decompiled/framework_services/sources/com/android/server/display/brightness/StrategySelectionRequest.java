package com.android.server.display.brightness;

import android.hardware.display.DisplayManagerInternal;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class StrategySelectionRequest {
    private DisplayManagerInternal.DisplayOffloadSession mDisplayOffloadSession;
    private DisplayManagerInternal.DisplayPowerRequest mDisplayPowerRequest;
    private boolean mIsStylusBeingUsed;
    private boolean mIsWearBedtimeModeEnabled;
    private float mLastUserSetScreenBrightness;
    private int mTargetDisplayState;
    private boolean mUserSetBrightnessChanged;

    public StrategySelectionRequest(DisplayManagerInternal.DisplayPowerRequest displayPowerRequest, int targetDisplayState, float lastUserSetScreenBrightness, boolean userSetBrightnessChanged, DisplayManagerInternal.DisplayOffloadSession displayOffloadSession, boolean isStylusBeingUsed, boolean isWearBedtimeModeEnabled) {
        this.mDisplayPowerRequest = displayPowerRequest;
        this.mTargetDisplayState = targetDisplayState;
        this.mLastUserSetScreenBrightness = lastUserSetScreenBrightness;
        this.mUserSetBrightnessChanged = userSetBrightnessChanged;
        this.mDisplayOffloadSession = displayOffloadSession;
        this.mIsStylusBeingUsed = isStylusBeingUsed;
        this.mIsWearBedtimeModeEnabled = isWearBedtimeModeEnabled;
    }

    public DisplayManagerInternal.DisplayPowerRequest getDisplayPowerRequest() {
        return this.mDisplayPowerRequest;
    }

    public int getTargetDisplayState() {
        return this.mTargetDisplayState;
    }

    public float getLastUserSetScreenBrightness() {
        return this.mLastUserSetScreenBrightness;
    }

    public boolean isUserSetBrightnessChanged() {
        return this.mUserSetBrightnessChanged;
    }

    public boolean isWearBedtimeModeEnabled() {
        return this.mIsWearBedtimeModeEnabled;
    }

    public DisplayManagerInternal.DisplayOffloadSession getDisplayOffloadSession() {
        return this.mDisplayOffloadSession;
    }

    public boolean isStylusBeingUsed() {
        return this.mIsStylusBeingUsed;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof StrategySelectionRequest) == true) goto L5;
        return false;
    L5:
        StrategySelectionRequest other = (StrategySelectionRequest) obj;
        if (Objects.equals(this.mDisplayPowerRequest, other.getDisplayPowerRequest()) == true) goto L8;
        return false;
    L8:
        if (this.mTargetDisplayState == other.getTargetDisplayState()) goto L10;
        return false;
    L10:
        if (this.mLastUserSetScreenBrightness == other.getLastUserSetScreenBrightness()) goto L12;
        return false;
    L12:
        if (this.mUserSetBrightnessChanged == other.isUserSetBrightnessChanged()) goto L14;
        return false;
    L14:
        if (this.mDisplayOffloadSession.equals(other.getDisplayOffloadSession()) == true) goto L16;
        return false;
    L16:
        if (this.mIsStylusBeingUsed == other.isStylusBeingUsed()) goto L18;
        return false;
    L18:
        if (this.mIsWearBedtimeModeEnabled != other.isWearBedtimeModeEnabled()) goto L28;
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mDisplayPowerRequest, Integer.valueOf(this.mTargetDisplayState), Float.valueOf(this.mLastUserSetScreenBrightness), Boolean.valueOf(this.mUserSetBrightnessChanged), this.mDisplayOffloadSession, Boolean.valueOf(this.mIsStylusBeingUsed)});
    }
}
