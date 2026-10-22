package com.android.server.display;

import android.os.Handler;
import android.os.IBinder;
import android.pico.utils.ExtImplFactory;
import com.android.server.display.brightness.clamper.HdrClamper;
import com.android.server.display.config.HighBrightnessModeData;
import com.android.server.display.feature.DisplayManagerFlags;
import java.io.PrintWriter;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes2.dex */
class BrightnessRangeController {
    private IExtBrightnessRangeController mExt;
    protected final HighBrightnessModeController mHbmController;
    private final HdrClamper mHdrClamper;
    private final Runnable mModeChangeCallback;
    private final NormalBrightnessModeController mNormalBrightnessModeController;
    private final boolean mUseHdrClamper;

    public static /* synthetic */ boolean $r8$lambda$GUV7m5sl0wmyNlkXREpePSULFgA(BrightnessRangeController r0, DisplayDeviceConfig r1) {
        return r0.lambda$loadFromConfig$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$U0nZjfPV0TdCJdzfZtXNehso7Pg(BrightnessRangeController r0, float r1) {
        r0.lambda$onAmbientLuxChange$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$dKtp9_j8KRcoYxWMg8d00hzlVN0(BrightnessRangeController r0, int r1) {
        r0.lambda$setAutoBrightnessEnabled$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$dbB59hbTRiQQALN7imDybrZ2ZcM(BrightnessRangeController r0, HighBrightnessModeMetadata r1, DisplayDeviceInfo r2, IBinder r3, DisplayDeviceConfig r4) {
        r0.lambda$loadFromConfig$3(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$p1Nigl72IgjP0-A2CBQzXT9CNbM, reason: not valid java name */
    public static /* synthetic */ boolean m3583$r8$lambda$p1Nigl72IgjP0A2CBQzXT9CNbM(BrightnessRangeController r0, float r1) {
        return r0.lambda$onAmbientLuxChange$0(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$zpmKQQW2rDvBS46nbBqX3mXvWvI(BrightnessRangeController r0, int r1) {
        return r0.lambda$setAutoBrightnessEnabled$4(r1);
    }

    BrightnessRangeController(HighBrightnessModeController hbmController, Runnable modeChangeCallback, DisplayDeviceConfig displayDeviceConfig, Handler handler, DisplayManagerFlags flags, IBinder displayToken, DisplayDeviceInfo info) {
        NormalBrightnessModeController r4 = new NormalBrightnessModeController();
        modeChangeCallback.getClass();
        this(hbmController, modeChangeCallback, displayDeviceConfig, r4, new HdrClamper(new BrightnessRangeController$$ExternalSyntheticLambda5(modeChangeCallback), new Handler(handler.getLooper())), flags, displayToken, info);
    }

    BrightnessRangeController(HighBrightnessModeController hbmController, Runnable modeChangeCallback, DisplayDeviceConfig displayDeviceConfig, NormalBrightnessModeController normalBrightnessModeController, HdrClamper hdrClamper, DisplayManagerFlags flags, IBinder displayToken, DisplayDeviceInfo info) {
        this.mExt = (IExtBrightnessRangeController) ExtImplFactory.getImpl(IExtBrightnessRangeController.class, new Object[]{this});
        this.mHbmController = hbmController;
        this.mModeChangeCallback = modeChangeCallback;
        this.mHdrClamper = hdrClamper;
        this.mNormalBrightnessModeController = normalBrightnessModeController;
        this.mUseHdrClamper = !flags.useNewHdrBrightnessModifier();
        this.mNormalBrightnessModeController.resetNbmData(displayDeviceConfig.getLuxThrottlingData());
        if (flags.useNewHdrBrightnessModifier() == false) goto L5;
        this.mHbmController.disableHdrBoost();
    L5:
        updateHdrClamper(info, displayToken, displayDeviceConfig);
    }

    void dump(PrintWriter pw) {
        pw.println("BrightnessRangeController:");
        pw.println("  mUseHdrClamper=" + this.mUseHdrClamper);
        this.mHbmController.dump(pw);
        this.mNormalBrightnessModeController.dump(pw);
        this.mHdrClamper.dump(pw);
    }

    void onAmbientLuxChange(final float ambientLux) {
        applyChanges(new BrightnessRangeController$$ExternalSyntheticLambda2(this, ambientLux), new BrightnessRangeController$$ExternalSyntheticLambda3(this, ambientLux));
        if (this.mUseHdrClamper == false) goto L6;
        this.mHdrClamper.onAmbientLuxChange(ambientLux);
        return;
    }

    private /* synthetic */ boolean lambda$onAmbientLuxChange$0(float ambientLux) {
        return this.mNormalBrightnessModeController.onAmbientLuxChange(ambientLux);
    }

    private /* synthetic */ void lambda$onAmbientLuxChange$1(float ambientLux) {
        this.mHbmController.onAmbientLuxChange(ambientLux);
    }

    float getNormalBrightnessMax() {
        return this.mHbmController.getNormalBrightnessMax();
    }

    void loadFromConfig(final HighBrightnessModeMetadata hbmMetadata, final IBinder token, final DisplayDeviceInfo info, final DisplayDeviceConfig displayDeviceConfig) {
        applyChanges(new BrightnessRangeController$$ExternalSyntheticLambda0(this, displayDeviceConfig), new BrightnessRangeController$$ExternalSyntheticLambda1(this, hbmMetadata, info, token, displayDeviceConfig));
        updateHdrClamper(info, token, displayDeviceConfig);
    }

    private /* synthetic */ boolean lambda$loadFromConfig$2(DisplayDeviceConfig displayDeviceConfig) {
        return this.mNormalBrightnessModeController.resetNbmData(displayDeviceConfig.getLuxThrottlingData());
    }

    private /* synthetic */ void lambda$loadFromConfig$3(HighBrightnessModeMetadata hbmMetadata, DisplayDeviceInfo info, IBinder token, final DisplayDeviceConfig displayDeviceConfig) {
        this.mHbmController.setHighBrightnessModeMetadata(hbmMetadata);
        HighBrightnessModeController r1 = this.mHbmController;
        int r2 = info.width;
        int r3 = info.height;
        String r5 = info.uniqueId;
        HighBrightnessModeData r6 = displayDeviceConfig.getHighBrightnessModeData();
        displayDeviceConfig.getClass();
        r1.resetHbmData(r2, r3, token, r5, r6, new BrightnessRangeController$$ExternalSyntheticLambda4(displayDeviceConfig));
    }

    void stop() {
        this.mHbmController.stop();
        this.mHdrClamper.stop();
    }

    void setAutoBrightnessEnabled(final int state) {
        applyChanges(new BrightnessRangeController$$ExternalSyntheticLambda6(this, state), new BrightnessRangeController$$ExternalSyntheticLambda7(this, state));
        this.mHdrClamper.setAutoBrightnessState(state);
    }

    private /* synthetic */ boolean lambda$setAutoBrightnessEnabled$4(int state) {
        return this.mNormalBrightnessModeController.setAutoBrightnessState(state);
    }

    private /* synthetic */ void lambda$setAutoBrightnessEnabled$5(int state) {
        this.mHbmController.setAutoBrightnessEnabled(state);
    }

    void onBrightnessChanged(float brightness, float unthrottledBrightness, DisplayBrightnessState state) {
        HighBrightnessModeController r0 = this.mHbmController;
        if (state.getHdrBrightness() == (-1.0f)) goto L5;
        boolean r1 = true;
    L6:
        r0.onHdrBoostApplied(r1);
        this.mHbmController.onBrightnessChanged(brightness, unthrottledBrightness, state.getBrightnessMaxReason());
        return;
    L5:
        r1 = false;
        goto L6
    }

    float getCurrentBrightnessMin() {
        return this.mHbmController.getCurrentBrightnessMin();
    }

    float getCurrentBrightnessMax() {
        if (this.mHbmController.deviceSupportsHbm() == false) goto L10;
        if (this.mHbmController.isHbmCurrentlyAllowed() == false) goto L10;
        return this.mHbmController.getCurrentBrightnessMax();
    L10:
        return Math.min(this.mHbmController.getCurrentBrightnessMax(), this.mNormalBrightnessModeController.getCurrentBrightnessMax());
    }

    int getHighBrightnessMode() {
        return this.mHbmController.getHighBrightnessMode();
    }

    float getHdrBrightnessValue() {
        float hdrBrightness = this.mHbmController.getHdrBrightnessValue();
        if (this.mUseHdrClamper == false) goto L6;
        return this.mHdrClamper.clamp(hdrBrightness);
    L6:
        return hdrBrightness;
    }

    float getTransitionPoint() {
        return this.mHbmController.getTransitionPoint();
    }

    private void updateHdrClamper(DisplayDeviceInfo info, IBinder token, DisplayDeviceConfig displayDeviceConfig) {
        if (this.mUseHdrClamper == false) goto L10;
        HighBrightnessModeData hbmData = displayDeviceConfig.getHighBrightnessModeData();
        if (hbmData != null) goto L7;
        float r1 = -1.0f;
    L8:
        float minimumHdrPercentOfScreen = r1;
        this.mHdrClamper.resetHdrConfig(displayDeviceConfig.getHdrBrightnessData(), info.width, info.height, minimumHdrPercentOfScreen, token);
        return;
    L7:
        r1 = hbmData.minimumHdrPercentOfScreen;
        goto L8
    }

    private void applyChanges(BooleanSupplier nbmChangesFunc, Runnable hbmChangesFunc) {
        boolean nbmTransitionChanged = nbmChangesFunc.getAsBoolean();
        hbmChangesFunc.run();
        if (nbmTransitionChanged == false) goto L6;
        this.mModeChangeCallback.run();
        return;
    }

    public float getHdrTransitionRate() {
        if (this.mUseHdrClamper == true) goto L7;
        return -1.0f;
    L7:
        return this.mHdrClamper.getTransitionRate();
    }

    public IExtBrightnessRangeController getExt() {
        return this.mExt;
    }

    public float getHdrExitTransitionRate() {
        if (this.mUseHdrClamper == true) goto L7;
        return -1.0f;
    L7:
        return this.mHdrClamper.getHdrExitTransitionRate();
    }

    public void setHdrLayerPresentExit(boolean isHdrLayerPresentExit) {
        this.mHbmController.setHdrLayerPresentExit(isHdrLayerPresentExit);
    }
}
