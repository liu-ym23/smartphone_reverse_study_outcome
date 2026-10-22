package com.android.server.display;

import android.hardware.display.BrightnessConfiguration;
import android.hardware.display.DisplayManagerInternal;
import android.os.Bundle;
import android.pico.utils.IExtBase;
import android.resourcemanager.AppRecordData;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtAutomaticBrightnessController extends IExtBase {

    public interface AmbientLuxListener {
        default void onAmbientLuxChange(float ambientLux) {
        }
    }

    public interface AutoBrightnessListener {
        void onAutoBrightnessChanged(float r1, float r2, float r3, Object r4);
    }

    void clearUserDataPoints();

    boolean configure(int r1, BrightnessConfiguration r2, float r3, boolean r4, float r5, boolean r6, int r7, int r8, boolean r9);

    void dump(PrintWriter r1);

    float getBrightnessFromNits(float r1);

    int getRateType();

    void handleBrightnessModeChange(int r1);

    void init();

    void onBootPhase(int r1);

    void resetRateType();

    void setListener(AutoBrightnessListener r1);

    boolean setScreenBrightnessByUser(float r1, float r2);

    void setScreenState(int r1, int r2, DisplayManagerInternal.DisplayPowerRequest r3);

    void stop();

    void updateAutoBrightness(boolean r1, float r2, float r3, float r4, boolean r5);

    void updateFocusAppEvent(AppRecordData r1);

    default void setAmbientLuxListener(AmbientLuxListener listener) {
    }

    default void updateDisplaySceneSource(Bundle data) {
    }

    default void setDisplayId(int displayId) {
    }

    default void clearUserDataPointsForScene(int scene) {
    }

    default boolean restoreShortTermModel(float recoveryRatio) {
        return false;
    }
}
