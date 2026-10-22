package com.android.server.display.config;

import android.R;
import android.content.res.Resources;
import android.util.Pair;
import android.util.Slog;
import com.android.server.display.utils.DebugUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HysteresisLevels {
    private static final boolean DEBUG = false;
    private static final float[] DEFAULT_AMBIENT_BRIGHTENING_THRESHOLDS = null;
    private static final float[] DEFAULT_AMBIENT_DARKENING_THRESHOLDS = null;
    private static final float[] DEFAULT_AMBIENT_THRESHOLD_LEVELS = null;
    private static final float[] DEFAULT_SCREEN_BRIGHTENING_THRESHOLDS = null;
    private static final float[] DEFAULT_SCREEN_DARKENING_THRESHOLDS = null;
    private static final float[] DEFAULT_SCREEN_THRESHOLD_LEVELS = null;
    private static final String TAG = "HysteresisLevels";
    private final float[] mBrighteningThresholdLevels;
    private final float[] mBrighteningThresholdsPercentages;
    private final float[] mDarkeningThresholdLevels;
    private final float[] mDarkeningThresholdsPercentages;
    private final float mMinBrightening;
    private final float mMinDarkening;

    static {
        DEFAULT_AMBIENT_BRIGHTENING_THRESHOLDS = new float[]{100.0f};
        DEFAULT_AMBIENT_DARKENING_THRESHOLDS = new float[]{200.0f};
        DEFAULT_AMBIENT_THRESHOLD_LEVELS = new float[]{0.0f};
        DEFAULT_SCREEN_THRESHOLD_LEVELS = new float[]{0.0f};
        DEFAULT_SCREEN_BRIGHTENING_THRESHOLDS = new float[]{100.0f};
        DEFAULT_SCREEN_DARKENING_THRESHOLDS = new float[]{200.0f};
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    public HysteresisLevels(float[] brighteningThresholdsPercentages, float[] darkeningThresholdsPercentages, float[] brighteningThresholdLevels, float[] darkeningThresholdLevels, float minDarkeningThreshold, float minBrighteningThreshold) {
        if (brighteningThresholdsPercentages.length != brighteningThresholdLevels.length) goto L9;
        if (darkeningThresholdsPercentages.length != darkeningThresholdLevels.length) goto L9;
        this.mBrighteningThresholdsPercentages = setArrayFormat(brighteningThresholdsPercentages, 100.0f);
        this.mDarkeningThresholdsPercentages = setArrayFormat(darkeningThresholdsPercentages, 100.0f);
        this.mBrighteningThresholdLevels = setArrayFormat(brighteningThresholdLevels, 1.0f);
        this.mDarkeningThresholdLevels = setArrayFormat(darkeningThresholdLevels, 1.0f);
        this.mMinDarkening = minDarkeningThreshold;
        this.mMinBrightening = minBrighteningThreshold;
        return;
    L9:
        throw new IllegalArgumentException("Mismatch between hysteresis array lengths.");
    }

    public float getBrighteningThreshold(float value) {
        float brightConstant = getReferenceLevel(value, this.mBrighteningThresholdLevels, this.mBrighteningThresholdsPercentages);
        float brightThreshold = (1.0f + brightConstant) * value;
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "bright hysteresis constant=" + brightConstant + ", threshold=" + brightThreshold + ", value=" + value);
    L6:
        return Math.max(brightThreshold, this.mMinBrightening + value);
    }

    public float getDarkeningThreshold(float value) {
        float darkConstant = getReferenceLevel(value, this.mDarkeningThresholdLevels, this.mDarkeningThresholdsPercentages);
        float darkThreshold = (1.0f - darkConstant) * value;
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "dark hysteresis constant=: " + darkConstant + ", threshold=" + darkThreshold + ", value=" + value);
    L6:
        return Math.max(Math.min(darkThreshold, value - this.mMinDarkening), 0.0f);
    }

    public float[] getBrighteningThresholdsPercentages() {
        return this.mBrighteningThresholdsPercentages;
    }

    public float[] getDarkeningThresholdsPercentages() {
        return this.mDarkeningThresholdsPercentages;
    }

    public float[] getBrighteningThresholdLevels() {
        return this.mBrighteningThresholdLevels;
    }

    public float[] getDarkeningThresholdLevels() {
        return this.mDarkeningThresholdLevels;
    }

    public float getMinDarkening() {
        return this.mMinDarkening;
    }

    public float getMinBrightening() {
        return this.mMinBrightening;
    }

    private float getReferenceLevel(float value, float[] thresholdLevels, float[] thresholdPercentages) {
        if (thresholdLevels != null) goto L4;
        return 0.0f;
    L4:
        if (thresholdLevels.length != 0) goto L6;
        return 0.0f;
    L6:
        if (value < thresholdLevels[0]) goto L21;
        int index = 0;
    L10:
        if (index >= (thresholdLevels.length - 1)) goto L15;
        if (value < thresholdLevels[index + 1]) goto L15;
        index = index + 1;
    L15:
        return thresholdPercentages[index];
    L21:
        return 0.0f;
    }

    private float[] setArrayFormat(float[] configArray, float divideFactor) {
        float[] levelArray = new float[configArray.length];
        int index = 0;
    L4:
        if (levelArray.length <= index) goto L7;
        levelArray[index] = configArray[index] / divideFactor;
        index = index + 1;
        goto L4
    L7:
        return levelArray;
    }

    public String toString() {
        return "HysteresisLevels {\n    mBrighteningThresholdLevels=" + Arrays.toString(this.mBrighteningThresholdLevels) + ",\n    mBrighteningThresholdsPercentages=" + Arrays.toString(this.mBrighteningThresholdsPercentages) + ",\n    mMinBrightening=" + this.mMinBrightening + ",\n    mDarkeningThresholdLevels=" + Arrays.toString(this.mDarkeningThresholdLevels) + ",\n    mDarkeningThresholdsPercentages=" + Arrays.toString(this.mDarkeningThresholdsPercentages) + ",\n    mMinDarkening=" + this.mMinDarkening + "\n}";
    }

    public static HysteresisLevels loadAmbientBrightnessConfig(DisplayConfiguration config, Resources resources) {
        if (config != null) goto L5;
        Thresholds r0 = null;
    L4:
        Thresholds r1 = r0;
        return createHysteresisLevels(r1, R.array.config_backGestureInsetScales, R.array.config_availableColorModes, R.array.config_availableEMValueOptions, DEFAULT_AMBIENT_THRESHOLD_LEVELS, DEFAULT_AMBIENT_BRIGHTENING_THRESHOLDS, DEFAULT_AMBIENT_DARKENING_THRESHOLDS, resources, false);
    L5:
        r0 = config.getAmbientBrightnessChangeThresholds();
        goto L4
    }

    public static HysteresisLevels loadDisplayBrightnessConfig(DisplayConfiguration config, Resources resources) {
        if (config != null) goto L5;
        Thresholds r0 = null;
    L4:
        Thresholds r1 = r0;
        return createHysteresisLevels(r1, R.array.config_tether_upstream_types, R.array.config_telephonyHardware, R.array.config_tether_dhcp_range, DEFAULT_SCREEN_THRESHOLD_LEVELS, DEFAULT_SCREEN_BRIGHTENING_THRESHOLDS, DEFAULT_SCREEN_DARKENING_THRESHOLDS, resources, true);
    L5:
        r0 = config.getDisplayBrightnessChangeThresholds();
        goto L4
    }

    public static HysteresisLevels loadAmbientBrightnessIdleConfig(DisplayConfiguration config, Resources resources) {
        if (config != null) goto L5;
        Thresholds r0 = null;
    L4:
        Thresholds r1 = r0;
        return createHysteresisLevels(r1, R.array.config_backGestureInsetScales, R.array.config_availableColorModes, R.array.config_availableEMValueOptions, DEFAULT_AMBIENT_THRESHOLD_LEVELS, DEFAULT_AMBIENT_BRIGHTENING_THRESHOLDS, DEFAULT_AMBIENT_DARKENING_THRESHOLDS, resources, false);
    L5:
        r0 = config.getAmbientBrightnessChangeThresholdsIdle();
        goto L4
    }

    public static HysteresisLevels loadDisplayBrightnessIdleConfig(DisplayConfiguration config, Resources resources) {
        if (config != null) goto L5;
        Thresholds r0 = null;
    L4:
        Thresholds r1 = r0;
        return createHysteresisLevels(r1, R.array.config_tether_upstream_types, R.array.config_telephonyHardware, R.array.config_tether_dhcp_range, DEFAULT_SCREEN_THRESHOLD_LEVELS, DEFAULT_SCREEN_BRIGHTENING_THRESHOLDS, DEFAULT_SCREEN_DARKENING_THRESHOLDS, resources, true);
    L5:
        r0 = config.getDisplayBrightnessChangeThresholdsIdle();
        goto L4
    }

    private static HysteresisLevels createHysteresisLevels(Thresholds thresholds, int configLevels, int configBrighteningThresholds, int configDarkeningThresholds, float[] defaultLevels, float[] defaultBrighteningThresholds, float[] defaultDarkeningThresholds, Resources resources, boolean potentialOldBrightnessScale) {
        BrightnessThresholds darkeningThresholds = null;
        if (thresholds != null) goto L5;
        BrightnessThresholds r1 = null;
    L6:
        BrightnessThresholds brighteningThresholds = r1;
        if (thresholds == null) goto L10;
        darkeningThresholds = thresholds.getDarkeningThresholds();
    L10:
        Pair<float[], float[]> brighteningPair = getBrightnessLevelAndPercentage(brighteningThresholds, configLevels, configBrighteningThresholds, defaultLevels, defaultBrighteningThresholds, potentialOldBrightnessScale, resources);
        BrightnessThresholds darkeningThresholds2 = darkeningThresholds;
        Pair<float[], float[]> darkeningPair = getBrightnessLevelAndPercentage(darkeningThresholds2, configLevels, configDarkeningThresholds, defaultLevels, defaultDarkeningThresholds, potentialOldBrightnessScale, resources);
        float r4 = 0.0f;
        if (brighteningThresholds != null) goto L13;
    L15:
        float r5 = 0.0f;
    L16:
        float brighteningMinThreshold = r5;
        if (darkeningThresholds2 != null) goto L19;
    L21:
        float darkeningMinThreshold = r4;
        return new HysteresisLevels((float[]) brighteningPair.second, (float[]) darkeningPair.second, (float[]) brighteningPair.first, (float[]) darkeningPair.first, darkeningMinThreshold, brighteningMinThreshold);
    L19:
        if (darkeningThresholds2.getMinimum() == null) goto L21;
        r4 = darkeningThresholds2.getMinimum().floatValue();
        goto L21
    L13:
        if (brighteningThresholds.getMinimum() == null) goto L15;
        r5 = brighteningThresholds.getMinimum().floatValue();
        goto L16
    L5:
        r1 = thresholds.getBrighteningThresholds();
        goto L6
    }

    private static Pair<float[], float[]> getBrightnessLevelAndPercentage(BrightnessThresholds thresholds, int configFallbackThreshold, int configFallbackPermille, float[] defaultLevels, float[] defaultPercentage, boolean potentialOldBrightnessScale, Resources resources) {
        if (thresholds != null) goto L4;
    L13:
        if (resources == null) goto L50;
        int[] configThresholdArray = resources.getIntArray(configFallbackThreshold);
        if (configThresholdArray != null) goto L17;
    L20:
        int configThresholdsSize = 1;
    L21:
        int[] configPermille = resources.getIntArray(configFallbackPermille);
        if (configPermille != null) goto L24;
    L27:
        boolean emptyArray = true;
    L28:
        if (emptyArray == false) goto L32;
        if (configThresholdsSize != 1) goto L32;
        return new Pair(defaultLevels, defaultPercentage);
    L32:
        if (emptyArray == true) goto L48;
        if (configPermille.length != configThresholdsSize) goto L48;
        float[] configThresholdWithZeroPrefixed = new float[configThresholdsSize];
        int i = 1;
    L36:
        if (i >= configThresholdsSize) goto L39;
        configThresholdWithZeroPrefixed[i] = configThresholdArray[i - 1];
        i = i + 1;
        goto L36
    L39:
        if (potentialOldBrightnessScale == false) goto L41;
        configThresholdWithZeroPrefixed = constraintInRangeIfNeeded(configThresholdWithZeroPrefixed);
    L41:
        float[] configPercentage = new float[configThresholdsSize];
        int i2 = 0;
    L43:
        if (i2 >= configPermille.length) goto L46;
        configPercentage[i2] = configPermille[i2] / 10.0f;
        i2 = i2 + 1;
        goto L43
    L46:
        return new Pair(configThresholdWithZeroPrefixed, configPercentage);
    L48:
        throw new IllegalArgumentException("Brightness threshold arrays do not align in length");
    L24:
        if (configPermille.length == 0) goto L27;
        emptyArray = false;
        goto L28
    L17:
        if (configThresholdArray.length == 0) goto L20;
        configThresholdsSize = configThresholdArray.length + 1;
        goto L21
    L50:
        return new Pair(defaultLevels, defaultPercentage);
    L4:
        if (thresholds.getBrightnessThresholdPoints() == null) goto L13;
        if (thresholds.getBrightnessThresholdPoints().getBrightnessThresholdPoint().isEmpty() == true) goto L13;
        List<ThresholdPoint> points = thresholds.getBrightnessThresholdPoints().getBrightnessThresholdPoint();
        int size = points.size();
        float[] thresholdLevels = new float[size];
        float[] thresholdPercentages = new float[size];
        int i3 = 0;
        Iterator<ThresholdPoint> r5 = points.iterator();
    L9:
        if (r5.hasNext() == false) goto L12;
        ThresholdPoint point = r5.next();
        thresholdLevels[i3] = point.getThreshold().floatValue();
        thresholdPercentages[i3] = point.getPercentage().floatValue();
        i3 = i3 + 1;
        goto L9
    L12:
        return new Pair(thresholdLevels, thresholdPercentages);
    }

    private static float[] constraintInRangeIfNeeded(float[] thresholdLevels) {
        if (isAllInRange(thresholdLevels, 0.0f, 1.0f) == false) goto L5;
        return thresholdLevels;
    L5:
        Slog.w(TAG, "Detected screen thresholdLevels on a deprecated brightness scale");
        float[] thresholdLevelsScaled = new float[thresholdLevels.length];
        int index = 0;
    L7:
        if (thresholdLevels.length <= index) goto L10;
        thresholdLevelsScaled[index] = thresholdLevels[index] / 255.0f;
        index = index + 1;
        goto L7
    L10:
        return thresholdLevelsScaled;
    }

    private static boolean isAllInRange(float[] configArray, float minValueInclusive, float maxValueInclusive) {
        int r0 = configArray.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        float v = configArray[r2];
        if (v < minValueInclusive) goto L10;
        if (v > maxValueInclusive) goto L10;
        r2 = r2 + 1;
    L10:
        return false;
    L11:
        return true;
    }
}
