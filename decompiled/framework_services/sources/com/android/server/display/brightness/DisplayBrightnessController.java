package com.android.server.display.brightness;

import android.R;
import android.content.Context;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManagerInternal;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.pico.utils.ExtImplFactory;
import android.util.IndentingPrintWriter;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.server.display.AutomaticBrightnessController;
import com.android.server.display.BrightnessMappingStrategy;
import com.android.server.display.BrightnessSetting;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.DisplayDeviceConfig;
import com.android.server.display.brightness.strategy.AutoBrightnessFallbackStrategy;
import com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2;
import com.android.server.display.brightness.strategy.DisplayBrightnessStrategy;
import com.android.server.display.feature.DisplayManagerFlags;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class DisplayBrightnessController {
    private static final float FULL_SCREEN_AOD_TARGET_BRIGHTNESS_NITS = 30.0f;
    AutomaticBrightnessController mAutomaticBrightnessController;
    private final HandlerExecutor mBrightnessChangeExecutor;
    private final BrightnessSetting mBrightnessSetting;
    private BrightnessSetting.BrightnessSettingListener mBrightnessSettingListener;
    private final Context mContext;
    private float mCurrentScreenBrightness;
    private DisplayBrightnessStrategy mDisplayBrightnessStrategy;
    private DisplayBrightnessStrategySelector mDisplayBrightnessStrategySelector;
    private final int mDisplayId;
    private IExtDisplayBrightnessController mExt;
    private boolean mIsStylusBeingUsed;
    private float mLastUserSetScreenBrightness;
    private final Object mLock;
    private Runnable mOnBrightnessChangeRunnable;
    private float mPendingScreenBrightness;
    private final boolean mPersistBrightnessNitsForDefaultDisplay;
    private final float mScreenBrightnessDefault;
    private boolean mUserSetScreenBrightnessUpdated;

    static class Injector {
        Injector() {
        }

        DisplayBrightnessStrategySelector getDisplayBrightnessStrategySelector(Context context, int displayId, DisplayManagerFlags flags) {
            return new DisplayBrightnessStrategySelector(context, null, displayId, flags);
        }
    }

    public DisplayBrightnessController(Context context, Injector injector, int displayId, float defaultScreenBrightness, BrightnessSetting brightnessSetting, Runnable onBrightnessChangeRunnable, HandlerExecutor brightnessChangeExecutor, DisplayManagerFlags flags) {
        this.mLock = new Object();
        this.mLastUserSetScreenBrightness = Float.NaN;
        this.mExt = (IExtDisplayBrightnessController) ExtImplFactory.getImpl(IExtDisplayBrightnessController.class, new Object[]{this});
        if (injector != null) goto L5;
        injector = new Injector();
    L5:
        this.mDisplayId = displayId;
        this.mBrightnessSetting = brightnessSetting;
        this.mPendingScreenBrightness = Float.NaN;
        this.mScreenBrightnessDefault = BrightnessUtils.clampAbsoluteBrightness(defaultScreenBrightness);
        this.mCurrentScreenBrightness = getScreenBrightnessSetting();
        this.mOnBrightnessChangeRunnable = onBrightnessChangeRunnable;
        this.mDisplayBrightnessStrategySelector = injector.getDisplayBrightnessStrategySelector(context, displayId, flags);
        this.mBrightnessChangeExecutor = brightnessChangeExecutor;
        this.mPersistBrightnessNitsForDefaultDisplay = context.getResources().getBoolean(R.bool.config_pulseOnNotificationsAvailable);
        this.mContext = context;
    }

    public DisplayBrightnessState updateBrightness(DisplayManagerInternal.DisplayPowerRequest displayPowerRequest, int targetDisplayState, DisplayManagerInternal.DisplayOffloadSession displayOffloadSession, boolean isBedtimeModeWearEnabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IExtDisplayBrightnessStrategySelector selectorExt = this.mDisplayBrightnessStrategySelector.getExt();     // Catch: Throwable -> L7
        if (selectorExt == null) goto L9;
        selectorExt.setBrightness(getCurrentBrightness(), getBrightnessFromNits(FULL_SCREEN_AOD_TARGET_BRIGHTNESS_NITS));     // Catch: Throwable -> L7
    L9:
        this.mDisplayBrightnessStrategy = this.mDisplayBrightnessStrategySelector.selectStrategy(constructStrategySelectionRequest(displayPowerRequest, targetDisplayState, displayOffloadSession, isBedtimeModeWearEnabled));     // Catch: Throwable -> L7
        DisplayBrightnessState state = this.mDisplayBrightnessStrategy.updateBrightness(constructStrategyExecutionRequest(displayPowerRequest));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        if (state == null) goto L14;
        state = addAutomaticBrightnessState(state);
    L14:
        return this.mExt.updateBrightness(state, this.mDisplayBrightnessStrategy, displayPowerRequest);
    L7:
        th = move-exception;
        throw th;
    }

    public void setTemporaryBrightness(Float temporaryBrightness) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        setTemporaryBrightnessLocked(temporaryBrightness.floatValue());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean updateWindowManagerBrightnessOverride(DisplayManagerInternal.DisplayBrightnessOverrideRequest request) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mDisplayBrightnessStrategySelector.getOverrideBrightnessStrategy().updateWindowManagerBrightnessOverride(request);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setBrightnessToFollow(float brightnessToFollow, boolean slowChange) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDisplayBrightnessStrategySelector.getFollowerDisplayBrightnessStrategy().setBrightnessToFollow(brightnessToFollow, slowChange);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean setBrightnessFromOffload(float brightness) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mDisplayBrightnessStrategySelector.getOffloadBrightnessStrategy() != null) goto L7;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L7:
        if (BrightnessSynchronizer.floatEquals(this.mDisplayBrightnessStrategySelector.getOffloadBrightnessStrategy().getOffloadScreenBrightness(), brightness) == true) goto L14;
        this.mDisplayBrightnessStrategySelector.getOffloadBrightnessStrategy().setOffloadScreenBrightness(brightness);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    }

    public void onBrightnessClampedForManualRange(float effectiveSdrBrightness) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDisplayBrightnessStrategySelector.onBrightnessClampedForManualRange(effectiveSdrBrightness);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isAllowAutoBrightnessWhileDozing() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mDisplayBrightnessStrategySelector.isAllowAutoBrightnessWhileDozing();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isAllowAutoBrightnessWhileDozingConfig() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mDisplayBrightnessStrategySelector.isAllowAutoBrightnessWhileDozingConfig();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAndNotifyCurrentScreenBrightness(float brightnessValue) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (brightnessValue == this.mCurrentScreenBrightness) goto L7;
        boolean hasBrightnessChanged = true;
    L8:
        setCurrentScreenBrightnessLocked(brightnessValue);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (hasBrightnessChanged == false) goto L18;
        notifyCurrentScreenBrightness();
        return;
    L18:
        return;
    L7:
        hasBrightnessChanged = false;
        goto L8
    }

    public float getCurrentBrightness() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        float r1 = this.mCurrentScreenBrightness;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public float getPendingScreenBrightness() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        float r1 = this.mPendingScreenBrightness;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setPendingScreenBrightness(float brightnessValue) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPendingScreenBrightness = brightnessValue;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean getIsUserSetScreenBrightnessUpdated() {
        return this.mUserSetScreenBrightnessUpdated;
    }

    public void registerBrightnessSettingChangeListener(BrightnessSetting.BrightnessSettingListener brightnessSettingListener) {
        this.mBrightnessSettingListener = brightnessSettingListener;
        this.mBrightnessSetting.registerListener(this.mBrightnessSettingListener);
    }

    public float getLastUserSetScreenBrightness() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        float r1 = this.mLastUserSetScreenBrightness;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public float getScreenBrightnessSetting() {
        float brightness = this.mBrightnessSetting.getBrightness();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (Float.isNaN(brightness) == false) goto L9;
        brightness = this.mScreenBrightnessDefault;     // Catch: Throwable -> L7
    L9:
        float r2 = BrightnessUtils.clampAbsoluteBrightness(brightness);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r2;
    }

    public void setBrightness(float brightnessValue, float maxBrightness) {
        this.mBrightnessSetting.setBrightness(brightnessValue);
        if (this.mDisplayId == 0) goto L5;
        return;
    L5:
        if (this.mPersistBrightnessNitsForDefaultDisplay == false) goto L15;
        float nits = convertToNits(brightnessValue);
        float currentlyStoredNits = this.mBrightnessSetting.getBrightnessNitsForDefaultDisplay();
        if (nits >= 0.0f) goto L9;
        return;
    L9:
        if (brightnessValue == maxBrightness) goto L11;
    L12:
        this.mBrightnessSetting.setBrightnessNitsForDefaultDisplay(nits);
        return;
    L11:
        if (currentlyStoredNits <= nits) goto L12;
        return;
    }

    public void setBrightness(float brightnessValue, int userSerial, float maxBrightness) {
        this.mBrightnessSetting.setUserSerial(userSerial);
        setBrightness(brightnessValue, maxBrightness);
    }

    public void saveBrightnessIfNeeded() {
        this.mBrightnessSetting.saveIfNeeded();
    }

    public void updateScreenBrightnessSetting(float brightnessValue, float maxBrightness) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (BrightnessUtils.isValidBrightnessValue(brightnessValue) == false) goto L15;
        if (brightnessValue == this.mCurrentScreenBrightness) goto L15;
        setCurrentScreenBrightnessLocked(brightnessValue);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        notifyCurrentScreenBrightness();
        setBrightness(brightnessValue, maxBrightness);
        return;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public void setUpAutoBrightness(AutomaticBrightnessController automaticBrightnessController, SensorManager sensorManager, DisplayDeviceConfig displayDeviceConfig, Handler handler, BrightnessMappingStrategy brightnessMappingStrategy, boolean isDisplayEnabled, int leadDisplayId) {
        setAutomaticBrightnessController(automaticBrightnessController);
        setUpAutoBrightnessFallbackStrategy(sensorManager, displayDeviceConfig, handler, brightnessMappingStrategy, isDisplayEnabled, leadDisplayId);
    }

    public AutomaticBrightnessStrategy2 getAutomaticBrightnessStrategy() {
        return this.mDisplayBrightnessStrategySelector.getAutomaticBrightnessStrategy();
    }

    public float convertToNits(float brightness) {
        if (this.mAutomaticBrightnessController != null) goto L7;
        return -1.0f;
    L7:
        return this.mAutomaticBrightnessController.convertToNits(brightness);
    }

    public float convertToAdjustedNits(float brightness) {
        if (this.mAutomaticBrightnessController != null) goto L7;
        return -1.0f;
    L7:
        return this.mAutomaticBrightnessController.convertToAdjustedNits(brightness);
    }

    public float getBrightnessFromNits(float nits) {
        if (this.mAutomaticBrightnessController != null) goto L7;
        return Float.NaN;
    L7:
        return this.mAutomaticBrightnessController.getBrightnessFromNits(nits);
    }

    public void stop() {
        if (this.mBrightnessSetting == null) goto L5;
        this.mBrightnessSetting.unregisterListener(this.mBrightnessSettingListener);
    L5:
        AutoBrightnessFallbackStrategy autoBrightnessFallbackStrategy = getAutoBrightnessFallbackStrategy();
        if (autoBrightnessFallbackStrategy == null) goto L9;
        autoBrightnessFallbackStrategy.stop();
        return;
    }

    private AutoBrightnessFallbackStrategy getAutoBrightnessFallbackStrategy() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AutoBrightnessFallbackStrategy r1 = this.mDisplayBrightnessStrategySelector.getAutoBrightnessFallbackStrategy();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter writer) {
        writer.println();
        writer.println("DisplayBrightnessController:");
        writer.println("  mDisplayId=: " + this.mDisplayId);
        writer.println("  mScreenBrightnessDefault=" + this.mScreenBrightnessDefault);
        writer.println("  mPersistBrightnessNitsForDefaultDisplay=" + this.mPersistBrightnessNitsForDefaultDisplay);
        writer.println("  mIsStylusBeingUsed=" + this.mIsStylusBeingUsed);
        Object r0 = this.mLock;
        monitor-enter(r0);
        writer.println("  mPendingScreenBrightness=" + this.mPendingScreenBrightness);     // Catch: Throwable -> L7
        writer.println("  mCurrentScreenBrightness=" + this.mCurrentScreenBrightness);     // Catch: Throwable -> L7
        writer.println("  mLastUserSetScreenBrightness=" + this.mLastUserSetScreenBrightness);     // Catch: Throwable -> L7
        if (this.mDisplayBrightnessStrategy == null) goto L9;
        writer.println("  Last selected DisplayBrightnessStrategy= " + this.mDisplayBrightnessStrategy.getName());     // Catch: Throwable -> L7
    L9:
        this.mDisplayBrightnessStrategySelector.dump(new IndentingPrintWriter(writer, " "));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean updateUserSetScreenBrightness() {
        this.mUserSetScreenBrightnessUpdated = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (BrightnessUtils.isValidBrightnessValue(this.mPendingScreenBrightness) == true) goto L14;
        if (this.mCurrentScreenBrightness != getTemporaryBrightness()) goto L11;
        setTemporaryBrightnessLocked(Float.NaN);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L14:
        if (this.mCurrentScreenBrightness != this.mPendingScreenBrightness) goto L18;
        this.mPendingScreenBrightness = Float.NaN;     // Catch: Throwable -> L9
        setTemporaryBrightnessLocked(Float.NaN);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L18:
        setCurrentScreenBrightnessLocked(this.mPendingScreenBrightness);     // Catch: Throwable -> L9
        this.mLastUserSetScreenBrightness = this.mPendingScreenBrightness;     // Catch: Throwable -> L9
        this.mPendingScreenBrightness = Float.NaN;     // Catch: Throwable -> L9
        setTemporaryBrightnessLocked(Float.NaN);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        notifyCurrentScreenBrightness();
        this.mUserSetScreenBrightnessUpdated = true;
        return true;
    }

    public void setStylusBeingUsed(boolean isEnabled) {
        this.mExt.setStylusBeingUsed(isEnabled);
        this.mIsStylusBeingUsed = isEnabled;
    }

    boolean isStylusBeingUsed() {
        return this.mIsStylusBeingUsed;
    }

    BrightnessSetting.BrightnessSettingListener getBrightnessSettingListener() {
        return this.mBrightnessSettingListener;
    }

    public DisplayBrightnessStrategy getCurrentDisplayBrightnessStrategy() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayBrightnessStrategy r1 = this.mDisplayBrightnessStrategy;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setAutomaticBrightnessController(AutomaticBrightnessController automaticBrightnessController) {
        this.mAutomaticBrightnessController = automaticBrightnessController;
        getAutomaticBrightnessStrategy().setAutomaticBrightnessController(automaticBrightnessController);
        loadNitBasedBrightnessSetting();
    }

    private void setUpAutoBrightnessFallbackStrategy(SensorManager sensorManager, DisplayDeviceConfig displayDeviceConfig, Handler handler, BrightnessMappingStrategy brightnessMappingStrategy, boolean isDisplayEnabled, int leadDisplayId) {
        AutoBrightnessFallbackStrategy autoBrightnessFallbackStrategy = getAutoBrightnessFallbackStrategy();
        if (autoBrightnessFallbackStrategy == null) goto L6;
        autoBrightnessFallbackStrategy.setupAutoBrightnessFallbackSensor(sensorManager, displayDeviceConfig, handler, brightnessMappingStrategy, isDisplayEnabled, leadDisplayId);
        return;
    }

    private DisplayBrightnessState addAutomaticBrightnessState(DisplayBrightnessState state) {
        AutomaticBrightnessStrategy2 autoStrat = getAutomaticBrightnessStrategy();
        DisplayBrightnessState.Builder builder = DisplayBrightnessState.Builder.from(state);
        if (autoStrat != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        builder.setShouldUseAutoBrightness(r2);
        return builder.build();
    L5:
        if (autoStrat.shouldUseAutoBrightness() == false) goto L7;
        r2 = true;
        goto L8
    }

    private void setTemporaryBrightnessLocked(float temporaryBrightness) {
        this.mDisplayBrightnessStrategySelector.getTemporaryDisplayBrightnessStrategy().setTemporaryScreenBrightness(temporaryBrightness);
    }

    private void setCurrentScreenBrightnessLocked(float brightnessValue) {
        if (brightnessValue == this.mCurrentScreenBrightness) goto L6;
        this.mCurrentScreenBrightness = brightnessValue;
        return;
    }

    private void notifyCurrentScreenBrightness() {
        this.mBrightnessChangeExecutor.execute(this.mOnBrightnessChangeRunnable);
    }

    private void loadNitBasedBrightnessSetting() {
        float currentBrightnessSetting = Float.NaN;
        if (this.mDisplayId != 0) goto L12;
        if (this.mPersistBrightnessNitsForDefaultDisplay == false) goto L12;
        float brightnessNitsForDefaultDisplay = this.mBrightnessSetting.getBrightnessNitsForDefaultDisplay();
        if (brightnessNitsForDefaultDisplay < 0.0f) goto L12;
        float brightnessForDefaultDisplay = getBrightnessFromNits(brightnessNitsForDefaultDisplay);
        if (BrightnessUtils.isValidBrightnessValue(brightnessForDefaultDisplay) == false) goto L12;
        this.mBrightnessSetting.setBrightnessNoNotify(brightnessForDefaultDisplay);
        currentBrightnessSetting = brightnessForDefaultDisplay;
    L12:
        if (Float.isNaN(currentBrightnessSetting) == false) goto L14;
        currentBrightnessSetting = getScreenBrightnessSetting();
    L14:
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mCurrentScreenBrightness = currentBrightnessSetting;     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private StrategySelectionRequest constructStrategySelectionRequest(DisplayManagerInternal.DisplayPowerRequest displayPowerRequest, int targetDisplayState, DisplayManagerInternal.DisplayOffloadSession displayOffloadSession, boolean isBedtimeModeEnabled) {
        boolean userSetBrightnessChanged = updateUserSetScreenBrightness();
        Object r1 = this.mLock;
        monitor-enter(r1);
        float lastUserSetScreenBrightness = this.mLastUserSetScreenBrightness;     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return new StrategySelectionRequest(displayPowerRequest, targetDisplayState, lastUserSetScreenBrightness, userSetBrightnessChanged, displayOffloadSession, this.mIsStylusBeingUsed, isBedtimeModeEnabled);
    L8:
        th = th;
    L16:
        throw th;
    L12:
        th = th;
        goto L16
    }

    private StrategyExecutionRequest constructStrategyExecutionRequest(DisplayManagerInternal.DisplayPowerRequest displayPowerRequest) {
        float currentScreenBrightness = getCurrentBrightness();
        return new StrategyExecutionRequest(displayPowerRequest, currentScreenBrightness, this.mUserSetScreenBrightnessUpdated, this.mIsStylusBeingUsed);
    }

    public float getTemporaryBrightness() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        float r1 = this.mDisplayBrightnessStrategySelector.getTemporaryDisplayBrightnessStrategy().getTemporaryScreenBrightness();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public IExtDisplayBrightnessStrategySelector getDisplayBrightnessStrategySelectorExt() {
        return this.mDisplayBrightnessStrategySelector.getExt();
    }
}
