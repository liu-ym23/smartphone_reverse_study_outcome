package com.android.server.display.brightness;

import android.hardware.display.BrightnessInfo;
import android.hardware.display.DisplayManagerInternal;
import android.os.SystemClock;
import android.view.Display;
import com.android.server.display.config.DisplayBrightnessMappingConfig;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public final class BrightnessEvent {
    public static final int FLAG_DOZE_SCALE = 4;
    public static final int FLAG_EVEN_DIMMER = 64;
    public static final int FLAG_INVALID_LUX = 2;
    public static final int FLAG_LOW_POWER_MODE = 32;
    public static final int FLAG_RBC = 1;
    public static final int FLAG_USER_SET = 8;
    private static final SimpleDateFormat FORMAT = null;
    private int mAdjustmentFlags;
    private int mAutoBrightnessMode;
    private boolean mAutomaticBrightnessEnabled;
    private float mBrightness;
    private String mDisplayBrightnessStrategyName;
    private int mDisplayId;
    private int mDisplayPolicy;
    private int mDisplayState;
    private int mDisplayStateReason;
    private int mFlags;
    private float mHbmMax;
    private int mHbmMode;
    private float mInitialBrightness;
    private float mLux;
    private float mNits;
    private float mPercent;
    private String mPhysicalDisplayId;
    private String mPhysicalDisplayName;
    private float mPowerFactor;
    private float mPreThresholdBrightness;
    private float mPreThresholdLux;
    private float mRampSpeed;
    private int mRbcStrength;
    private BrightnessReason mReason;
    private float mRecommendedBrightness;
    private boolean mSlowChange;
    private float mThermalMax;
    private long mTime;
    private float mUnclampedBrightness;
    private boolean mWasShortTermModelActive;

    static {
        FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
    }

    public BrightnessEvent(BrightnessEvent that) {
        this.mReason = new BrightnessReason();
        copyFrom(that);
    }

    public BrightnessEvent(int displayId) {
        this.mReason = new BrightnessReason();
        this.mDisplayId = displayId;
        reset();
    }

    public void copyFrom(BrightnessEvent that) {
        this.mReason.set(that.getReason());
        this.mDisplayId = that.getDisplayId();
        this.mPhysicalDisplayId = that.getPhysicalDisplayId();
        this.mPhysicalDisplayName = that.getPhysicalDisplayName();
        this.mDisplayState = that.mDisplayState;
        this.mDisplayStateReason = that.mDisplayStateReason;
        this.mDisplayPolicy = that.mDisplayPolicy;
        this.mTime = that.getTime();
        this.mLux = that.getLux();
        this.mPreThresholdLux = that.getPreThresholdLux();
        this.mNits = that.getNits();
        this.mPercent = that.getPercent();
        this.mInitialBrightness = that.getInitialBrightness();
        this.mBrightness = that.getBrightness();
        this.mUnclampedBrightness = that.getUnclampedBrightness();
        this.mRecommendedBrightness = that.getRecommendedBrightness();
        this.mPreThresholdBrightness = that.getPreThresholdBrightness();
        this.mHbmMode = that.getHbmMode();
        this.mHbmMax = that.getHbmMax();
        this.mRbcStrength = that.getRbcStrength();
        this.mThermalMax = that.getThermalMax();
        this.mPowerFactor = that.getPowerFactor();
        this.mWasShortTermModelActive = that.wasShortTermModelActive();
        this.mFlags = that.getFlags();
        this.mAdjustmentFlags = that.getAdjustmentFlags();
        this.mAutomaticBrightnessEnabled = that.isAutomaticBrightnessEnabled();
        this.mDisplayBrightnessStrategyName = that.getDisplayBrightnessStrategyName();
        this.mAutoBrightnessMode = that.mAutoBrightnessMode;
        this.mSlowChange = that.mSlowChange;
        this.mRampSpeed = that.mRampSpeed;
    }

    public void reset() {
        this.mReason = new BrightnessReason();
        this.mTime = SystemClock.uptimeMillis();
        this.mPhysicalDisplayId = "";
        this.mPhysicalDisplayName = "";
        this.mDisplayState = 0;
        this.mDisplayStateReason = 0;
        this.mDisplayPolicy = 0;
        this.mLux = -1.0f;
        this.mPreThresholdLux = 0.0f;
        this.mNits = -1.0f;
        this.mPercent = -1.0f;
        this.mInitialBrightness = Float.NaN;
        this.mBrightness = Float.NaN;
        this.mUnclampedBrightness = Float.NaN;
        this.mRecommendedBrightness = Float.NaN;
        this.mPreThresholdBrightness = Float.NaN;
        this.mHbmMode = 0;
        this.mHbmMax = 1.0f;
        this.mRbcStrength = 0;
        this.mThermalMax = 1.0f;
        this.mPowerFactor = 1.0f;
        this.mWasShortTermModelActive = false;
        this.mFlags = 0;
        this.mAdjustmentFlags = 0;
        this.mAutomaticBrightnessEnabled = true;
        this.mDisplayBrightnessStrategyName = "";
        this.mAutoBrightnessMode = 0;
        this.mSlowChange = false;
        this.mRampSpeed = 0.0f;
    }

    public boolean equalsMainData(BrightnessEvent that) {
        if (this.mReason.equals(that.mReason) == true) goto L5;
    L55:
        return false;
    L5:
        if (this.mDisplayId != that.mDisplayId) goto L55;
        if (this.mPhysicalDisplayId.equals(that.mPhysicalDisplayId) == false) goto L55;
        if (this.mPhysicalDisplayName.equals(that.mPhysicalDisplayName) == false) goto L55;
        if (this.mDisplayState != that.mDisplayState) goto L55;
        if (this.mDisplayStateReason != that.mDisplayStateReason) goto L55;
        if (this.mDisplayPolicy != that.mDisplayPolicy) goto L55;
        if (Float.floatToRawIntBits(this.mLux) != Float.floatToRawIntBits(that.mLux)) goto L55;
        if (Float.floatToRawIntBits(this.mPreThresholdLux) != Float.floatToRawIntBits(that.mPreThresholdLux)) goto L55;
        if (Float.floatToRawIntBits(this.mNits) != Float.floatToRawIntBits(that.mNits)) goto L55;
        if (Float.floatToRawIntBits(this.mPercent) != Float.floatToRawIntBits(that.mPercent)) goto L55;
        if (Float.floatToRawIntBits(this.mBrightness) != Float.floatToRawIntBits(that.mBrightness)) goto L55;
        if (Float.floatToRawIntBits(this.mUnclampedBrightness) != Float.floatToRawIntBits(that.mUnclampedBrightness)) goto L55;
        if (Float.floatToRawIntBits(this.mRecommendedBrightness) != Float.floatToRawIntBits(that.mRecommendedBrightness)) goto L55;
        if (Float.floatToRawIntBits(this.mPreThresholdBrightness) != Float.floatToRawIntBits(that.mPreThresholdBrightness)) goto L55;
        if (this.mHbmMode != that.mHbmMode) goto L55;
        if (Float.floatToRawIntBits(this.mHbmMax) != Float.floatToRawIntBits(that.mHbmMax)) goto L55;
        if (this.mRbcStrength != that.mRbcStrength) goto L55;
        if (Float.floatToRawIntBits(this.mThermalMax) != Float.floatToRawIntBits(that.mThermalMax)) goto L55;
        if (Float.floatToRawIntBits(this.mPowerFactor) != Float.floatToRawIntBits(that.mPowerFactor)) goto L55;
        if (this.mWasShortTermModelActive != that.mWasShortTermModelActive) goto L55;
        if (this.mFlags != that.mFlags) goto L55;
        if (this.mAdjustmentFlags != that.mAdjustmentFlags) goto L55;
        if (this.mAutomaticBrightnessEnabled != that.mAutomaticBrightnessEnabled) goto L55;
        if (this.mDisplayBrightnessStrategyName.equals(that.mDisplayBrightnessStrategyName) == false) goto L55;
        if (this.mAutoBrightnessMode != that.mAutoBrightnessMode) goto L55;
        return true;
    }

    public String toString(boolean includeTime) {
        StringBuilder r0 = new StringBuilder();
        String r1 = "";
        if (includeTime == false) goto L5;
        String r2 = FORMAT.format(new Date(this.mTime)) + " - ";
    L6:
        r0.append(r2);
        r0.append("BrightnessEvent: brt=");
        r0.append(this.mBrightness);
        if ((this.mFlags & 8) == 0) goto L9;
        r1 = "(user_set)";
    L9:
        r0.append(r1);
        r0.append(" (");
        r0.append(this.mPercent);
        r0.append("%), nits= ");
        r0.append(this.mNits);
        r0.append(", lux=");
        r0.append(this.mLux);
        r0.append(", reason=");
        r0.append(this.mReason.toString(this.mAdjustmentFlags));
        r0.append(", strat=");
        r0.append(this.mDisplayBrightnessStrategyName);
        r0.append(", state=");
        r0.append(Display.stateToString(this.mDisplayState));
        r0.append(", stateReason=");
        r0.append(Display.stateReasonToString(this.mDisplayStateReason));
        r0.append(", policy=");
        r0.append(DisplayManagerInternal.DisplayPowerRequest.policyToString(this.mDisplayPolicy));
        r0.append(", flags=");
        r0.append(flagsToString());
        r0.append(", initBrt=");
        r0.append(this.mInitialBrightness);
        r0.append(", rcmdBrt=");
        r0.append(this.mRecommendedBrightness);
        r0.append(", preBrt=");
        r0.append(this.mPreThresholdBrightness);
        r0.append(", preLux=");
        r0.append(this.mPreThresholdLux);
        r0.append(", wasShortTermModelActive=");
        r0.append(this.mWasShortTermModelActive);
        r0.append(", autoBrightness=");
        r0.append(this.mAutomaticBrightnessEnabled);
        r0.append(" (");
        r0.append(DisplayBrightnessMappingConfig.autoBrightnessModeToString(this.mAutoBrightnessMode));
        r0.append("), unclampedBrt=");
        r0.append(this.mUnclampedBrightness);
        r0.append(", hbmMax=");
        r0.append(this.mHbmMax);
        r0.append(", hbmMode=");
        r0.append(BrightnessInfo.hbmToString(this.mHbmMode));
        r0.append(", thrmMax=");
        r0.append(this.mThermalMax);
        r0.append(", rbcStrength=");
        r0.append(this.mRbcStrength);
        r0.append(", powerFactor=");
        r0.append(this.mPowerFactor);
        r0.append(", physDisp=");
        r0.append(this.mPhysicalDisplayName);
        r0.append("(");
        r0.append(this.mPhysicalDisplayId);
        r0.append("), logicalId=");
        r0.append(this.mDisplayId);
        r0.append(", slowChange=");
        r0.append(this.mSlowChange);
        r0.append(", rampSpeed=");
        r0.append(this.mRampSpeed);
        return r0.toString();
    L5:
        r2 = "";
        goto L6
    }

    public String toString() {
        return toString(true);
    }

    public BrightnessReason getReason() {
        return this.mReason;
    }

    public void setReason(BrightnessReason reason) {
        this.mReason = reason;
    }

    public long getTime() {
        return this.mTime;
    }

    public void setTime(long time) {
        this.mTime = time;
    }

    public int getDisplayId() {
        return this.mDisplayId;
    }

    public void setDisplayId(int displayId) {
        this.mDisplayId = displayId;
    }

    public String getPhysicalDisplayId() {
        return this.mPhysicalDisplayId;
    }

    public void setPhysicalDisplayId(String mPhysicalDisplayId) {
        this.mPhysicalDisplayId = mPhysicalDisplayId;
    }

    public String getPhysicalDisplayName() {
        return this.mPhysicalDisplayName;
    }

    public void setPhysicalDisplayName(String mPhysicalDisplayName) {
        this.mPhysicalDisplayName = mPhysicalDisplayName;
    }

    public void setDisplayState(int state) {
        this.mDisplayState = state;
    }

    public void setDisplayStateReason(int reason) {
        this.mDisplayStateReason = reason;
    }

    public void setDisplayPolicy(int policy) {
        this.mDisplayPolicy = policy;
    }

    public float getLux() {
        return this.mLux;
    }

    public void setLux(float lux) {
        this.mLux = lux;
    }

    public float getPreThresholdLux() {
        return this.mPreThresholdLux;
    }

    public void setPreThresholdLux(float preThresholdLux) {
        this.mPreThresholdLux = preThresholdLux;
    }

    public float getInitialBrightness() {
        return this.mInitialBrightness;
    }

    public void setInitialBrightness(float mInitialBrightness) {
        this.mInitialBrightness = mInitialBrightness;
    }

    public float getBrightness() {
        return this.mBrightness;
    }

    public void setBrightness(float brightness) {
        this.mBrightness = brightness;
    }

    public float getUnclampedBrightness() {
        return this.mUnclampedBrightness;
    }

    public void setUnclampedBrightness(float unclampedBrightness) {
        this.mUnclampedBrightness = unclampedBrightness;
    }

    public void setPercent(float percent) {
        this.mPercent = percent;
    }

    public float getPercent() {
        return this.mPercent;
    }

    public void setNits(float nits) {
        this.mNits = nits;
    }

    public float getNits() {
        return this.mNits;
    }

    public float getRecommendedBrightness() {
        return this.mRecommendedBrightness;
    }

    public void setRecommendedBrightness(float recommendedBrightness) {
        this.mRecommendedBrightness = recommendedBrightness;
    }

    public float getPreThresholdBrightness() {
        return this.mPreThresholdBrightness;
    }

    public void setPreThresholdBrightness(float preThresholdBrightness) {
        this.mPreThresholdBrightness = preThresholdBrightness;
    }

    public int getHbmMode() {
        return this.mHbmMode;
    }

    public void setHbmMode(int hbmMode) {
        this.mHbmMode = hbmMode;
    }

    public float getHbmMax() {
        return this.mHbmMax;
    }

    public void setHbmMax(float hbmMax) {
        this.mHbmMax = hbmMax;
    }

    public int getRbcStrength() {
        return this.mRbcStrength;
    }

    public void setRbcStrength(int mRbcStrength) {
        this.mRbcStrength = mRbcStrength;
    }

    public boolean isRbcEnabled() {
        if ((this.mFlags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public float getThermalMax() {
        return this.mThermalMax;
    }

    public void setThermalMax(float thermalMax) {
        this.mThermalMax = thermalMax;
    }

    public float getPowerFactor() {
        return this.mPowerFactor;
    }

    public void setPowerFactor(float mPowerFactor) {
        this.mPowerFactor = mPowerFactor;
    }

    public boolean isLowPowerModeSet() {
        if ((this.mFlags & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean setWasShortTermModelActive(boolean wasShortTermModelActive) {
        this.mWasShortTermModelActive = wasShortTermModelActive;
        return wasShortTermModelActive;
    }

    public boolean wasShortTermModelActive() {
        return this.mWasShortTermModelActive;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public void setFlags(int flags) {
        this.mFlags = flags;
    }

    public int getAdjustmentFlags() {
        return this.mAdjustmentFlags;
    }

    public void setAdjustmentFlags(int adjustmentFlags) {
        this.mAdjustmentFlags = adjustmentFlags;
    }

    public boolean isAutomaticBrightnessEnabled() {
        return this.mAutomaticBrightnessEnabled;
    }

    public void setDisplayBrightnessStrategyName(String displayBrightnessStrategyName) {
        this.mDisplayBrightnessStrategyName = displayBrightnessStrategyName;
    }

    public String getDisplayBrightnessStrategyName() {
        return this.mDisplayBrightnessStrategyName;
    }

    public void setAutomaticBrightnessEnabled(boolean automaticBrightnessEnabled) {
        this.mAutomaticBrightnessEnabled = automaticBrightnessEnabled;
    }

    public int getAutoBrightnessMode() {
        return this.mAutoBrightnessMode;
    }

    public void setAutoBrightnessMode(int mode) {
        this.mAutoBrightnessMode = mode;
    }

    public void setSlowChange(boolean slowChange) {
        this.mSlowChange = slowChange;
    }

    public void setRampSpeed(float rampSpeed) {
        this.mRampSpeed = rampSpeed;
    }

    public String flagsToString() {
        StringBuilder r0 = new StringBuilder();
        String r2 = "";
        if ((this.mFlags & 8) == 0) goto L5;
        String r1 = "user_set ";
    L6:
        r0.append(r1);
        if ((this.mFlags & 1) == 0) goto L9;
        String r3 = "rbc ";
    L10:
        r0.append(r3);
        if ((this.mFlags & 2) == 0) goto L13;
        String r4 = "invalid_lux ";
    L14:
        r0.append(r4);
        if ((this.mFlags & 4) == 0) goto L17;
        String r5 = "doze_scale ";
    L18:
        r0.append(r5);
        if ((this.mFlags & 32) == 0) goto L21;
        String r6 = "low_power_mode ";
    L22:
        r0.append(r6);
        if ((this.mFlags & 64) == 0) goto L25;
        r2 = "even_dimmer ";
    L25:
        r0.append(r2);
        return r0.toString();
    L21:
        r6 = "";
        goto L22
    L17:
        r5 = "";
        goto L18
    L13:
        r4 = "";
        goto L14
    L9:
        r3 = "";
        goto L10
    L5:
        r1 = "";
        goto L6
    }
}
