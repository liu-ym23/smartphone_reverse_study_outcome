package com.android.server.display;

import android.content.Context;
import android.hardware.display.BrightnessConfiguration;
import android.pico.utils.IExtBase;
import android.util.Spline;
import com.android.server.display.auto.ISceneSwitchEvent;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtBrightnessMappingStrategy extends IExtBase {

    public interface IExtPhysicalMappingStrategy extends IExtBrightnessMappingStrategy {
        default float getBrightness(float lux) {
            return Float.NaN;
        }
    }

    public interface IExtSimpleMappingStrategy extends IExtBrightnessMappingStrategy {
        float convertToNits(float r1);

        void createSplines(float[] r1, float[] r2, float[] r3, float[] r4);

        void dump(PrintWriter r1, float r2);

        float getBrightness(float r1, String r2, int r3);

        float getBrightnessFromNits(float r1);

        float getUnadjustedBrightness(float r1);
    }

    public static final class SplineComputationResult {
        public final float[] configBrightness;
        public final float[] configLux;
        public final float[] finalBrightness;
        public final float[] finalLux;
        public final float[] finalNits;
        public final float[] userBrightness;
        public final float[] userLux;

        public SplineComputationResult(float[] configLux, float[] configBrightness, float[] userLux, float[] userBrightness, float[] finalLux, float[] finalBrightness) {
            this(configLux, configBrightness, userLux, userBrightness, finalLux, finalBrightness, null);
        }

        public SplineComputationResult(float[] configLux, float[] configBrightness, float[] userLux, float[] userBrightness, float[] finalLux, float[] finalBrightness, float[] finalNits) {
            this.configLux = configLux;
            this.configBrightness = configBrightness;
            this.userLux = userLux;
            this.userBrightness = userBrightness;
            this.finalLux = finalLux;
            this.finalBrightness = finalBrightness;
            this.finalNits = finalNits;
        }
    }

    default void init(Context context) {
    }

    default void setUserDataPoint(float lux, float brightness) {
    }

    default void clearUserDataPoints() {
    }

    default void clearUserDataPointsForScene(int scene) {
    }

    default int getUserDataPointCount() {
        return 0;
    }

    default float getUserDataPointLux(int index) {
        return Float.NaN;
    }

    default float getUserDataPointBrightness(int index) {
        return Float.NaN;
    }

    default SplineComputationResult computeSimpleSpline(float[] lux, float[] brightness, float maxGamma, float autoBrightnessAdjustment) {
        return null;
    }

    default SplineComputationResult computePhysicalSpline(BrightnessConfiguration config, Spline adjustedNitsToBrightnessSpline, Spline brightnessToAdjustedNitsSpline, float maxGamma, float autoBrightnessAdjustment) {
        return null;
    }

    default void onSplineRecomputed(String kind, int mode, int preset, float lastUserLux, float lastUserBrightness, float[] configLux, float[] configBrightness, float[] userLux, float[] userBrightness, float[] finalLux, float[] finalBrightness) {
    }

    default boolean clearUserDataPointForLux(float lux) {
        return false;
    }

    default void setDisplayId(int displayId) {
    }

    default boolean switchAutoBrightnessScene(ISceneSwitchEvent event, float ambientLux, boolean ambientLuxValid) {
        return false;
    }

    default int getAutoBrightnessScene() {
        return 0;
    }

    default void dumpSceneState(PrintWriter pw) {
    }
}
