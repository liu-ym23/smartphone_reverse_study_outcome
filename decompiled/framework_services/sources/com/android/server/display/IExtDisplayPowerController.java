package com.android.server.display;

import android.hardware.display.DisplayManagerInternal;
import android.net.Uri;
import android.os.Bundle;
import android.pico.utils.IExtBase;
import android.resourcemanager.AppRecordData;
import android.util.Pair;
import com.android.server.display.brightness.BrightnessReason;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtDisplayPowerController extends IExtBase {
    float animateBrightnessRateSelect(float r1, float r2, boolean r3, float r4);

    void animateScreenBrightness(float r1, float r2, float r3, boolean r4, BrightnessReason r5, int r6);

    void clamp(DisplayManagerInternal.DisplayPowerRequest r1, DisplayBrightnessState.Builder r2);

    float getAodAnimationRate(float r1, float r2);

    Pair<Float, Float> getAodTarget(float r1, float r2, float r3);

    float getBrightnessFromNits(float r1);

    float getDimRate(float r1, float r2, float r3);

    float getHdrRate(float r1, float r2, float r3);

    float getModeChangeRate(float r1, float r2, float r3);

    float getOverrideRate(float r1, float r2, float r3);

    float getPowerDiscountRate(float r1, float r2, float r3);

    float getTransitionPoint();

    void handleAodBrightness(float r1, float r2);

    void handleBrightnessModeChange(int r1);

    void init();

    void initialize();

    boolean isAodInProgress();

    void logDisplayPolicyChanged(int r1, int r2);

    void onAnimationEnd();

    void onBootPhase(int r1);

    boolean onChange(boolean r1, Uri r2);

    void onScreenOn();

    float overrideManuAutoBrightness(float r1);

    float overrideManuBrightness(float r1);

    void requestDisplayStateInternal(int r1, int r2, float r3, float r4, int r5);

    boolean requestPowerState(DisplayManagerInternal.DisplayPowerRequest r1, DisplayManagerInternal.DisplayPowerRequest r2, boolean r3);

    void screenOnBlocked(int r1, int r2, int r3, boolean r4);

    void setAutoBrightness(float r1);

    void setBrightnessExt(int r1, String r2);

    void setReportedScreenState(int r1);

    void setScreenState(int r1, int r2);

    boolean skipOverrideBrightness2Auto();

    void startSetTemporaryBrightness(int r1, boolean r2, float r3);

    void updateAnimateValue(float r1, float r2);

    void updateAutoBrightnessRateType();

    void updateBrightnessForFeature(String r1, Bundle r2);

    void updateFocusAppEvent(AppRecordData r1);

    void updatePowerRequst(int r1, DisplayManagerInternal.DisplayPowerRequest r2);

    void updatePowerStateInternalReset();

    default boolean isContentInvisibleSkipAnimation(int oldState, int state) {
        return true;
    }

    default boolean isSkipAnimation(boolean skipAnimation, boolean initialRampSkip, boolean hasBrightnessBuckets, boolean isDisplayContentVisible, boolean brightnessIsTemporary, boolean slowChange) {
        return skipAnimation;
    }

    default float getLuxFromNits(int displayId, float nits) {
        return Float.NaN;
    }

    default float getNitsFromLux(int displayId, float lux) {
        return Float.NaN;
    }

    default void setFullScreenAodAlphaState(boolean enabled, float gray) {
    }

    default void dump(PrintWriter pw) {
    }

    default float calcTemporaryBrightness(float brightness) {
        return brightness;
    }

    default float getManualRangeTransitionRate(float customAnimationRate, float sdrAnimateValue, float animateValue) {
        return customAnimationRate;
    }

    default void onBrightnessClampedForManualRange(float effectiveSdrBrightness) {
    }

    default void updateDisplaySceneSource(Bundle data) {
    }
}
