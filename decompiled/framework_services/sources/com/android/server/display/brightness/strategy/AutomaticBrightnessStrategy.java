package com.android.server.display.brightness.strategy;

import android.content.Context;
import android.hardware.display.BrightnessConfiguration;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.view.Display;
import com.android.server.display.AutomaticBrightnessController;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.brightness.BrightnessEvent;
import com.android.server.display.brightness.BrightnessReason;
import com.android.server.display.brightness.BrightnessUtils;
import com.android.server.display.brightness.StrategyExecutionRequest;
import com.android.server.display.brightness.StrategySelectionNotifyRequest;
import com.android.server.display.feature.DisplayManagerFlags;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class AutomaticBrightnessStrategy extends AutomaticBrightnessStrategy2 implements DisplayBrightnessStrategy {
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
    private DisplayManagerFlags mDisplayManagerFlags;
    private IExtAutomaticBrightnessStrategy mExt;
    private Injector mInjector;
    private boolean mIsAutoBrightnessEnabled;
    private boolean mIsConfigured;
    private boolean mIsShortTermModelActive;
    private boolean mIsSlowChange;
    private float mPendingAutoBrightnessAdjustment;
    private boolean mShouldResetShortTermModel;
    private float mTemporaryAutoBrightnessAdjustment;
    private boolean mUseAutoBrightness;

    interface Injector {
        BrightnessEvent getBrightnessEvent(int r1);
    }

    static class RealInjector implements Injector {
        RealInjector() {
        }

        @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy.Injector
        public BrightnessEvent getBrightnessEvent(int displayId) {
            return new BrightnessEvent(displayId);
        }
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public /* bridge */ /* synthetic */ IExtAutomaticBrightnessStrategy2 getExt() {
        return getExt();
    }

    AutomaticBrightnessStrategy(Context context, int displayId, Injector injector, DisplayManagerFlags displayManagerFlags) {
        super(context, displayId);
        this.mAutoBrightnessAdjustmentReasonsFlags = 0;
        this.mShouldResetShortTermModel = false;
        this.mAppliedAutoBrightness = false;
        this.mUseAutoBrightness = false;
        this.mIsAutoBrightnessEnabled = false;
        this.mIsShortTermModelActive = false;
        this.mExt = (IExtAutomaticBrightnessStrategy) ExtImplFactory.getImpl(IExtAutomaticBrightnessStrategy.class, new Object[]{this});
        this.mContext = context;
        this.mDisplayId = displayId;
        this.mAutoBrightnessAdjustment = getAutoBrightnessAdjustmentSetting();
        this.mPendingAutoBrightnessAdjustment = Float.NaN;
        this.mTemporaryAutoBrightnessAdjustment = Float.NaN;
        this.mDisplayManagerFlags = displayManagerFlags;
        if (injector != null) goto L5;
        Injector r0 = new RealInjector();
    L6:
        this.mInjector = r0;
        return;
    L5:
        r0 = injector;
        goto L6
    }

    public AutomaticBrightnessStrategy(Context context, int displayId, DisplayManagerFlags displayManagerFlags) {
        this(context, displayId, null, displayManagerFlags);
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public void setAutoBrightnessState(int targetDisplayState, boolean allowAutoBrightnessWhileDozingConfig, int brightnessReason, int policy, boolean useNormalBrightnessForDoze, float lastUserSetScreenBrightness, boolean userSetBrightnessChanged, boolean isBedtimeModeWearEnabled) {
        boolean r1 = false;
        if (allowAutoBrightnessWhileDozingConfig == false) goto L7;
        if (policy != 1) goto L7;
        if (targetDisplayState == 1) goto L7;
        boolean r2 = true;
    L8:
        boolean autoBrightnessEnabledInDoze = r2;
        if (shouldUseAutoBrightness() == true) goto L13;
        if (this.mExt.manuAutoBrightnessEnabled() == true) goto L13;
    L17:
        boolean r3 = false;
    L18:
        this.mIsAutoBrightnessEnabled = r3;
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
        this.mIsConfigured = true;
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
        r3 = true;
    L7:
        r2 = false;
        goto L8
    }

    public void setIsConfigured(boolean configure) {
        this.mIsConfigured = configure;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public boolean isAutoBrightnessEnabled() {
        return this.mIsAutoBrightnessEnabled;
    }

    public boolean isAutoBrightnessValid() {
        boolean isValid = false;
        boolean r2 = false;
        if (isAutoBrightnessEnabled() == false) goto L10;
        float brightness = getAutomaticScreenBrightness(null, false);
        if (BrightnessUtils.isValidBrightnessValue(brightness) == false) goto L7;
    L8:
        isValid = true;
        goto L10
    L7:
        if (brightness == (-1.0f)) goto L8;
    L10:
        if (hasAppliedAutoBrightness() == true) goto L12;
    L14:
        this.mIsSlowChange = r2;
        setAutoBrightnessApplied(isValid);
        return isValid;
    L12:
        if (getAutoBrightnessAdjustmentChanged() == true) goto L14;
        r2 = true;
        goto L14
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public boolean isAutoBrightnessDisabledDueToDisplayOff() {
        return this.mAutoBrightnessDisabledDueToDisplayOff;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public void setBrightnessConfiguration(BrightnessConfiguration brightnessConfiguration, boolean shouldResetShortTermModel) {
        this.mBrightnessConfiguration = brightnessConfiguration;
        setShouldResetShortTermModel(shouldResetShortTermModel);
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
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

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public void setAutomaticBrightnessController(AutomaticBrightnessController automaticBrightnessController) {
        if (automaticBrightnessController != this.mAutomaticBrightnessController) goto L6;
        return;
    L6:
        if (this.mAutomaticBrightnessController == null) goto L8;
        this.mAutomaticBrightnessController.stop();
    L8:
        this.mAutomaticBrightnessController = automaticBrightnessController;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public boolean shouldUseAutoBrightness() {
        return this.mUseAutoBrightness;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public void setUseAutoBrightness(boolean useAutoBrightness) {
        this.mUseAutoBrightness = useAutoBrightness;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public boolean isShortTermModelActive() {
        return this.mIsShortTermModelActive;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
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

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public void setTemporaryAutoBrightnessAdjustment(float temporaryAutoBrightnessAdjustment) {
        this.mTemporaryAutoBrightnessAdjustment = temporaryAutoBrightnessAdjustment;
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public DisplayBrightnessState updateBrightness(StrategyExecutionRequest strategyExecutionRequest) {
        BrightnessReason brightnessReason = new BrightnessReason();
        brightnessReason.setReason(4);
        BrightnessEvent brightnessEvent = this.mInjector.getBrightnessEvent(this.mDisplayId);
        boolean r2 = true;
        float brightness = this.mExt.overrideManuAutoBrightness(getAutomaticScreenBrightness(brightnessEvent, true));
        DisplayBrightnessState.Builder r4 = new DisplayBrightnessState.Builder().setBrightness(brightness).setBrightnessReason(brightnessReason).setDisplayBrightnessStrategyName(getName()).setIsSlowChange(this.mIsSlowChange).setBrightnessEvent(brightnessEvent).setBrightnessAdjustmentFlag(this.mAutoBrightnessAdjustmentReasonsFlags);
        if (brightness == strategyExecutionRequest.getCurrentScreenBrightness()) goto L5;
        boolean r5 = true;
    L6:
        DisplayBrightnessState.Builder r6 = r4.setShouldUpdateScreenBrightnessSetting(r5);
        if (getAutoBrightnessAdjustmentChanged() == true) goto L14;
        if (strategyExecutionRequest.isUserSetBrightnessChanged() == true) goto L14;
        r2 = false;
    L14:
        return r6.setIsUserInitiatedChange(r2).build();
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public String getName() {
        return "AutomaticBrightnessStrategy";
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2, com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
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

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public void strategySelectionPostProcessor(StrategySelectionNotifyRequest strategySelectionNotifyRequest) {
        if (this.mIsConfigured == true) goto L5;
        AutomaticBrightnessStrategy r1 = this;
        r1.setAutoBrightnessState(strategySelectionNotifyRequest.getTargetDisplayState(), strategySelectionNotifyRequest.isAllowAutoBrightnessWhileDozingConfig(), strategySelectionNotifyRequest.getSelectedDisplayBrightnessStrategy().getReason(), strategySelectionNotifyRequest.getDisplayPowerRequest().policy, strategySelectionNotifyRequest.getDisplayPowerRequest().useNormalBrightnessForDoze, strategySelectionNotifyRequest.getLastUserSetScreenBrightness(), strategySelectionNotifyRequest.isUserSetBrightnessChanged(), strategySelectionNotifyRequest.isBedtimeModeWearEnabled());
    L6:
        r1.mIsConfigured = false;
        return;
    L5:
        r1 = this;
        goto L6
    }

    @Override // com.android.server.display.brightness.strategy.DisplayBrightnessStrategy
    public int getReason() {
        return 4;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public boolean getAutoBrightnessAdjustmentChanged() {
        return this.mAutoBrightnessAdjustmentChanged;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public boolean isTemporaryAutoBrightnessAdjustmentApplied() {
        return this.mAppliedTemporaryAutoBrightnessAdjustment;
    }

    public float getAutomaticScreenBrightness(BrightnessEvent brightnessEvent, boolean isAutomaticBrightnessAdjusted) {
        if (this.mAutomaticBrightnessController == null) goto L5;
        float brightness = this.mAutomaticBrightnessController.getAutomaticScreenBrightness(brightnessEvent);
    L7:
        if (isAutomaticBrightnessAdjusted == true) goto L9;
        adjustAutomaticBrightnessStateIfValid(brightness);
    L9:
        return brightness;
    L5:
        brightness = Float.NaN;
        goto L7
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public boolean hasAppliedAutoBrightness() {
        return this.mAppliedAutoBrightness;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
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

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    void setShouldResetShortTermModel(boolean shouldResetShortTermModel) {
        this.mShouldResetShortTermModel = shouldResetShortTermModel;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    boolean shouldResetShortTermModel() {
        return this.mShouldResetShortTermModel;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    float getAutoBrightnessAdjustment() {
        return this.mAutoBrightnessAdjustment;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    float getPendingAutoBrightnessAdjustment() {
        return this.mPendingAutoBrightnessAdjustment;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    float getTemporaryAutoBrightnessAdjustment() {
        return this.mTemporaryAutoBrightnessAdjustment;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    void putAutoBrightnessAdjustmentSetting(float adjustment) {
        if (this.mDisplayId != 0) goto L6;
        this.mAutoBrightnessAdjustment = adjustment;
        Settings.System.putFloatForUser(this.mContext.getContentResolver(), "screen_auto_brightness_adj", adjustment, -2);
        return;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public void setAutoBrightnessApplied(boolean autoBrightnessApplied) {
        this.mAppliedAutoBrightness = autoBrightnessApplied;
    }

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
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

    private void switchMode(int state, boolean useNormalBrightnessForDoze, int policy, boolean isWearBedtimeModeEnabled, boolean sendUpdate) {
        if (this.mDisplayManagerFlags.areAutoBrightnessModesEnabled() == true) goto L5;
        return;
    L5:
        if (this.mAutomaticBrightnessController != null) goto L7;
        return;
    L7:
        if (this.mAutomaticBrightnessController.isInIdleMode() == true) goto L34;
        boolean shouldUseDozeMode = true;
        if (this.mDisplayManagerFlags.isAutoBrightnessModeBedtimeWearEnabled() == false) goto L13;
        if (isWearBedtimeModeEnabled == false) goto L13;
        boolean shouldUseBedtimeMode = true;
    L14:
        if (shouldUseBedtimeMode == false) goto L18;
        this.mAutomaticBrightnessController.switchMode(3, sendUpdate);
        return;
    L18:
        if (this.mDisplayManagerFlags.isNormalBrightnessForDozeParameterEnabled(this.mContext) == false) goto L25;
        if (useNormalBrightnessForDoze == true) goto L22;
        if (policy != 1) goto L22;
    L27:
        if (shouldUseDozeMode == false) goto L30;
        this.mAutomaticBrightnessController.switchMode(2, sendUpdate);
        return;
    L30:
        this.mAutomaticBrightnessController.switchMode(0, sendUpdate);
        return;
    L22:
        if (Display.isDozeState(state) == true) goto L27;
        shouldUseDozeMode = false;
        goto L27
    L25:
        shouldUseDozeMode = Display.isDozeState(state);
    L13:
        shouldUseBedtimeMode = false;
        goto L14
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

    @Override // com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2
    public IExtAutomaticBrightnessStrategy getExt() {
        return this.mExt;
    }
}
