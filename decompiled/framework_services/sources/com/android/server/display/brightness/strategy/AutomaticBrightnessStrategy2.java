package com.android.server.display.brightness.strategy;

import android.content.Context;
import android.hardware.display.BrightnessConfiguration;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import com.android.server.display.AutomaticBrightnessController;
import com.android.server.display.brightness.BrightnessEvent;
import com.android.server.display.brightness.BrightnessUtils;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class AutomaticBrightnessStrategy2 {
    private boolean mAppliedAutoBrightness;
    private boolean mAppliedTemporaryAutoBrightnessAdjustment;
    private float mAutoBrightnessAdjustment;
    private boolean mAutoBrightnessAdjustmentChanged;
    private int mAutoBrightnessAdjustmentReasonsFlags;
    private boolean mAutoBrightnessDisabledDueToDisplayOff;
    private AutomaticBrightnessController mAutomaticBrightnessController;
    private BrightnessConfiguration mBrightnessConfiguration;
    private final Context mContext;
    private final int mDisplayId;
    private IExtAutomaticBrightnessStrategy2 mExt;
    private boolean mIsAutoBrightnessEnabled;
    private boolean mIsShortTermModelActive;
    private float mPendingAutoBrightnessAdjustment;
    private boolean mShouldResetShortTermModel;
    private float mTemporaryAutoBrightnessAdjustment;
    private boolean mUseAutoBrightness;

    public AutomaticBrightnessStrategy2(Context context, int displayId) {
        this.mAutoBrightnessAdjustmentReasonsFlags = 0;
        this.mShouldResetShortTermModel = false;
        this.mAppliedAutoBrightness = false;
        this.mUseAutoBrightness = false;
        this.mIsAutoBrightnessEnabled = false;
        this.mIsShortTermModelActive = false;
        this.mExt = (IExtAutomaticBrightnessStrategy2) ExtImplFactory.getImpl(IExtAutomaticBrightnessStrategy2.class, new Object[]{this});
        this.mContext = context;
        this.mDisplayId = displayId;
        this.mAutoBrightnessAdjustment = getAutoBrightnessAdjustmentSetting();
        this.mPendingAutoBrightnessAdjustment = Float.NaN;
        this.mTemporaryAutoBrightnessAdjustment = Float.NaN;
    }

    public void setAutoBrightnessState(int targetDisplayState, boolean allowAutoBrightnessWhileDozingConfig, int brightnessReason, int policy, boolean useNormalBrightnessForDoze, float lastUserSetScreenBrightness, boolean userSetBrightnessChanged, boolean isBedtimeModeEnabled) {
        boolean r1 = false;
        if (allowAutoBrightnessWhileDozingConfig == false) goto L7;
        if (policy != 1) goto L7;
        if (targetDisplayState == 1) goto L7;
        boolean r5 = true;
    L8:
        boolean autoBrightnessEnabledInDoze = r5;
        if (shouldUseAutoBrightness() == true) goto L13;
        if (this.mExt.manuAutoBrightnessEnabled() == true) goto L13;
    L17:
        boolean r6 = false;
    L18:
        this.mIsAutoBrightnessEnabled = r6;
        if (shouldUseAutoBrightness() == false) goto L24;
        if (targetDisplayState != 2) goto L22;
        if (policy != 1) goto L24;
    L22:
        if (autoBrightnessEnabledInDoze == true) goto L24;
        r1 = true;
    L24:
        this.mAutoBrightnessDisabledDueToDisplayOff = r1;
        if (this.mIsAutoBrightnessEnabled == false) goto L30;
        if (brightnessReason == 10) goto L30;
        int autoBrightnessState = 1;
    L33:
        accommodateUserBrightnessChanges(userSetBrightnessChanged, lastUserSetScreenBrightness, policy, targetDisplayState, useNormalBrightnessForDoze, this.mBrightnessConfiguration, autoBrightnessState);
        return;
    L30:
        if (this.mAutoBrightnessDisabledDueToDisplayOff == false) goto L32;
        autoBrightnessState = 3;
        goto L33
    L32:
        autoBrightnessState = 2;
    L13:
        if (brightnessReason == 6) goto L17;
        if (this.mAutomaticBrightnessController == null) goto L17;
        r6 = true;
    L7:
        r5 = false;
        goto L8
    }

    public boolean isAutoBrightnessEnabled() {
        return this.mIsAutoBrightnessEnabled;
    }

    public boolean isAutoBrightnessDisabledDueToDisplayOff() {
        return this.mAutoBrightnessDisabledDueToDisplayOff;
    }

    public void setBrightnessConfiguration(BrightnessConfiguration brightnessConfiguration, boolean shouldResetShortTermModel) {
        this.mBrightnessConfiguration = brightnessConfiguration;
        setShouldResetShortTermModel(shouldResetShortTermModel);
    }

    public boolean processPendingAutoBrightnessAdjustments() {
        this.mAutoBrightnessAdjustmentChanged = false;
        if (Float.isNaN(this.mPendingAutoBrightnessAdjustment) == false) goto L6;
        return false;
    L6:
        if (this.mAutoBrightnessAdjustment != this.mPendingAutoBrightnessAdjustment) goto L9;
        this.mPendingAutoBrightnessAdjustment = Float.NaN;
        return false;
    L9:
        this.mAutoBrightnessAdjustment = this.mPendingAutoBrightnessAdjustment;
        this.mPendingAutoBrightnessAdjustment = Float.NaN;
        this.mTemporaryAutoBrightnessAdjustment = Float.NaN;
        this.mAutoBrightnessAdjustmentChanged = true;
        return true;
    }

    public void setAutomaticBrightnessController(AutomaticBrightnessController automaticBrightnessController) {
        if (automaticBrightnessController != this.mAutomaticBrightnessController) goto L6;
        return;
    L6:
        if (this.mAutomaticBrightnessController == null) goto L8;
        this.mAutomaticBrightnessController.stop();
    L8:
        this.mAutomaticBrightnessController = automaticBrightnessController;
    }

    public boolean shouldUseAutoBrightness() {
        return this.mUseAutoBrightness;
    }

    public void setUseAutoBrightness(boolean useAutoBrightness) {
        this.mUseAutoBrightness = useAutoBrightness;
    }

    public boolean isShortTermModelActive() {
        return this.mIsShortTermModelActive;
    }

    public void updatePendingAutoBrightnessAdjustments() {
        float adj = Settings.System.getFloatForUser(this.mContext.getContentResolver(), "screen_auto_brightness_adj", 0.0f, -2);
        if (Float.isNaN(adj) == false) goto L5;
        float r1 = Float.NaN;
    L6:
        this.mPendingAutoBrightnessAdjustment = r1;
        return;
    L5:
        r1 = BrightnessUtils.clampBrightnessAdjustment(adj);
        goto L6
    }

    public void setTemporaryAutoBrightnessAdjustment(float temporaryAutoBrightnessAdjustment) {
        this.mTemporaryAutoBrightnessAdjustment = temporaryAutoBrightnessAdjustment;
    }

    public void dump(PrintWriter writer) {
        writer.println("AutomaticBrightnessStrategy:");
        writer.println("  mDisplayId=" + this.mDisplayId);
        writer.println("  mAutoBrightnessAdjustment=" + this.mAutoBrightnessAdjustment);
        writer.println("  mPendingAutoBrightnessAdjustment=" + this.mPendingAutoBrightnessAdjustment);
        writer.println("  mTemporaryAutoBrightnessAdjustment=" + this.mTemporaryAutoBrightnessAdjustment);
        writer.println("  mShouldResetShortTermModel=" + this.mShouldResetShortTermModel);
        writer.println("  mAppliedAutoBrightness=" + this.mAppliedAutoBrightness);
        writer.println("  mAutoBrightnessAdjustmentChanged=" + this.mAutoBrightnessAdjustmentChanged);
        writer.println("  mAppliedTemporaryAutoBrightnessAdjustment=" + this.mAppliedTemporaryAutoBrightnessAdjustment);
        writer.println("  mUseAutoBrightness=" + this.mUseAutoBrightness);
        writer.println("  mWasShortTermModelActive=" + this.mIsShortTermModelActive);
        writer.println("  mAutoBrightnessAdjustmentReasonsFlags=" + this.mAutoBrightnessAdjustmentReasonsFlags);
    }

    public boolean getAutoBrightnessAdjustmentChanged() {
        return this.mAutoBrightnessAdjustmentChanged;
    }

    public boolean isTemporaryAutoBrightnessAdjustmentApplied() {
        return this.mAppliedTemporaryAutoBrightnessAdjustment;
    }

    public float getAutomaticScreenBrightness(BrightnessEvent brightnessEvent) {
        if (this.mAutomaticBrightnessController == null) goto L5;
        float brightness = this.mAutomaticBrightnessController.getAutomaticScreenBrightness(brightnessEvent);
    L6:
        adjustAutomaticBrightnessStateIfValid(brightness);
        return brightness;
    L5:
        brightness = Float.NaN;
        goto L6
    }

    public int getAutoBrightnessAdjustmentReasonsFlags() {
        return this.mAutoBrightnessAdjustmentReasonsFlags;
    }

    public boolean hasAppliedAutoBrightness() {
        return this.mAppliedAutoBrightness;
    }

    void adjustAutomaticBrightnessStateIfValid(float brightnessState) {
        if (isTemporaryAutoBrightnessAdjustmentApplied() == false) goto L5;
        int r0 = 1;
    L6:
        this.mAutoBrightnessAdjustmentReasonsFlags = r0;
        if (this.mAutomaticBrightnessController == null) goto L9;
        float newAutoBrightnessAdjustment = this.mAutomaticBrightnessController.getAutomaticScreenBrightnessAdjustment();
    L11:
        if (Float.isNaN(newAutoBrightnessAdjustment) == false) goto L13;
    L15:
        this.mAutoBrightnessAdjustmentReasonsFlags = 0;
        return;
    L13:
        if (this.mAutoBrightnessAdjustment == newAutoBrightnessAdjustment) goto L15;
        putAutoBrightnessAdjustmentSetting(newAutoBrightnessAdjustment);
        return;
    L9:
        newAutoBrightnessAdjustment = 0.0f;
        goto L11
    L5:
        r0 = 2;
        goto L6
    }

    void setShouldResetShortTermModel(boolean shouldResetShortTermModel) {
        this.mShouldResetShortTermModel = shouldResetShortTermModel;
    }

    boolean shouldResetShortTermModel() {
        return this.mShouldResetShortTermModel;
    }

    float getAutoBrightnessAdjustment() {
        return this.mAutoBrightnessAdjustment;
    }

    float getPendingAutoBrightnessAdjustment() {
        return this.mPendingAutoBrightnessAdjustment;
    }

    float getTemporaryAutoBrightnessAdjustment() {
        return this.mTemporaryAutoBrightnessAdjustment;
    }

    void putAutoBrightnessAdjustmentSetting(float adjustment) {
        if (this.mDisplayId != 0) goto L6;
        this.mAutoBrightnessAdjustment = adjustment;
        Settings.System.putFloatForUser(this.mContext.getContentResolver(), "screen_auto_brightness_adj", adjustment, -2);
        return;
    }

    public void setAutoBrightnessApplied(boolean autoBrightnessApplied) {
        this.mAppliedAutoBrightness = autoBrightnessApplied;
    }

    void accommodateUserBrightnessChanges(boolean userSetBrightnessChanged, float lastUserSetScreenBrightness, int policy, int displayState, boolean useNormalBrightnessForDoze, BrightnessConfiguration brightnessConfiguration, int autoBrightnessState) {
        processPendingAutoBrightnessAdjustments();
        float autoBrightnessAdjustment = updateTemporaryAutoBrightnessAdjustments();
        this.mIsShortTermModelActive = false;
        if (this.mAutomaticBrightnessController == null) goto L6;
        this.mAutomaticBrightnessController.configure(autoBrightnessState, brightnessConfiguration, lastUserSetScreenBrightness, userSetBrightnessChanged, autoBrightnessAdjustment, this.mAutoBrightnessAdjustmentChanged, policy, displayState, useNormalBrightnessForDoze, this.mShouldResetShortTermModel);
        this.mShouldResetShortTermModel = false;
        this.mIsShortTermModelActive = this.mAutomaticBrightnessController.hasUserDataPoints();
        return;
    }

    private float updateTemporaryAutoBrightnessAdjustments() {
        this.mAppliedTemporaryAutoBrightnessAdjustment = !Float.isNaN(this.mTemporaryAutoBrightnessAdjustment);
        if (this.mAppliedTemporaryAutoBrightnessAdjustment == false) goto L6;
        return this.mTemporaryAutoBrightnessAdjustment;
    L6:
        return this.mAutoBrightnessAdjustment;
    }

    private float getAutoBrightnessAdjustmentSetting() {
        float adj = Settings.System.getFloatForUser(this.mContext.getContentResolver(), "screen_auto_brightness_adj", 0.0f, -2);
        if (Float.isNaN(adj) == false) goto L6;
        return 0.0f;
    L6:
        return BrightnessUtils.clampBrightnessAdjustment(adj);
    }

    public IExtAutomaticBrightnessStrategy2 getExt() {
        return this.mExt;
    }
}
