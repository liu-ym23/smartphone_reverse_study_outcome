package com.android.server.display.config;

import android.util.Spline;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class HdrBrightnessData {
    private static final String TAG = "HdrBrightnessData";
    public final boolean allowInLowPowerMode;
    public final long brightnessDecreaseDebounceMillis;
    public final long brightnessIncreaseDebounceMillis;
    public final float hbmTransitionPoint;
    public final float highestHdrSdrRatio;
    public final Map<Float, Float> maxBrightnessLimits;
    public final float minimumHdrPercentOfScreenForHbm;
    public final float minimumHdrPercentOfScreenForNbm;
    public final float screenBrightnessRampDecrease;
    public final float screenBrightnessRampIncrease;
    public final Spline sdrToHdrRatioSpline;

    public HdrBrightnessData(Map<Float, Float> maxBrightnessLimits, long brightnessIncreaseDebounceMillis, float screenBrightnessRampIncrease, long brightnessDecreaseDebounceMillis, float screenBrightnessRampDecrease, float hbmTransitionPoint, float minimumHdrPercentOfScreenForNbm, float minimumHdrPercentOfScreenForHbm, boolean allowInLowPowerMode, Spline sdrToHdrRatioSpline, float highestHdrSdrRatio) {
        this.maxBrightnessLimits = maxBrightnessLimits;
        this.brightnessIncreaseDebounceMillis = brightnessIncreaseDebounceMillis;
        this.screenBrightnessRampIncrease = screenBrightnessRampIncrease;
        this.brightnessDecreaseDebounceMillis = brightnessDecreaseDebounceMillis;
        this.screenBrightnessRampDecrease = screenBrightnessRampDecrease;
        this.hbmTransitionPoint = hbmTransitionPoint;
        this.minimumHdrPercentOfScreenForNbm = minimumHdrPercentOfScreenForNbm;
        this.minimumHdrPercentOfScreenForHbm = minimumHdrPercentOfScreenForHbm;
        this.allowInLowPowerMode = allowInLowPowerMode;
        this.sdrToHdrRatioSpline = sdrToHdrRatioSpline;
        this.highestHdrSdrRatio = highestHdrSdrRatio;
    }

    public String toString() {
        return "HdrBrightnessData {mMaxBrightnessLimits: " + this.maxBrightnessLimits + ", mBrightnessIncreaseDebounceMillis: " + this.brightnessIncreaseDebounceMillis + ", mScreenBrightnessRampIncrease: " + this.screenBrightnessRampIncrease + ", mBrightnessDecreaseDebounceMillis: " + this.brightnessDecreaseDebounceMillis + ", mScreenBrightnessRampDecrease: " + this.screenBrightnessRampDecrease + ", transitionPoint: " + this.hbmTransitionPoint + ", minimumHdrPercentOfScreenForNbm: " + this.minimumHdrPercentOfScreenForNbm + ", minimumHdrPercentOfScreenForHbm: " + this.minimumHdrPercentOfScreenForHbm + ", allowInLowPowerMode: " + this.allowInLowPowerMode + ", sdrToHdrRatioSpline: " + this.sdrToHdrRatioSpline + ", highestHdrSdrRatio: " + this.highestHdrSdrRatio + "} ";
    }

    public static HdrBrightnessData loadConfig(DisplayConfiguration config, Function<HighBrightnessMode, Float> transitionPointProvider) {
        HighBrightnessMode hbmConfig = config.getHighBrightnessMode();
        HdrBrightnessConfig hdrConfig = config.getHdrBrightnessConfig();
        if (hdrConfig == null) goto L5;
        List<NonNegativeFloatToFloatPoint> points = hdrConfig.getBrightnessMap().getPoint();
        Map<Float, Float> brightnessLimits = new HashMap();
        Iterator<NonNegativeFloatToFloatPoint> r4 = points.iterator();
    L8:
        if (r4.hasNext() == false) goto L11;
        NonNegativeFloatToFloatPoint point = r4.next();
        brightnessLimits.put(Float.valueOf(point.getFirst().floatValue()), Float.valueOf(point.getSecond().floatValue()));
        goto L8
    L11:
        if (hdrConfig.getMinimumHdrPercentOfScreenForHbm() == null) goto L13;
        float minHdrPercentForHbm = hdrConfig.getMinimumHdrPercentOfScreenForHbm().floatValue();
    L15:
        if (hdrConfig.getMinimumHdrPercentOfScreenForNbm() == null) goto L17;
        float minHdrPercentForNbm = hdrConfig.getMinimumHdrPercentOfScreenForNbm().floatValue();
    L19:
        if (minHdrPercentForNbm > minHdrPercentForHbm) goto L23;
        return new HdrBrightnessData(brightnessLimits, hdrConfig.getBrightnessIncreaseDebounceMillis().longValue(), hdrConfig.getScreenBrightnessRampIncrease().floatValue(), hdrConfig.getBrightnessDecreaseDebounceMillis().longValue(), hdrConfig.getScreenBrightnessRampDecrease().floatValue(), getTransitionPoint(hbmConfig, transitionPointProvider), minHdrPercentForNbm, minHdrPercentForHbm, hdrConfig.getAllowInLowPowerMode(), getSdrHdrRatioSpline(hdrConfig, config.getHighBrightnessMode()), getHighestSdrHdrRatio(hdrConfig, config.getHighBrightnessMode()));
    L23:
        throw new IllegalArgumentException("minHdrPercentForHbm should be >= minHdrPercentForNbm");
    L17:
        minHdrPercentForNbm = minHdrPercentForHbm;
        goto L19
    L13:
        minHdrPercentForHbm = getFallbackHdrPercent(hbmConfig);
        goto L15
    L5:
        return getFallbackData(hbmConfig, transitionPointProvider);
    }

    private static float getTransitionPoint(HighBrightnessMode hbm, Function<HighBrightnessMode, Float> transitionPointProvider) {
        if (hbm != null) goto L6;
        return 1.0f;
    L6:
        return transitionPointProvider.apply(hbm).floatValue();
    }

    private static HdrBrightnessData getFallbackData(HighBrightnessMode hbm, Function<HighBrightnessMode, Float> transitionPointProvider) {
        if (hbm != null) goto L5;
        return null;
    L5:
        float fallbackPercent = getFallbackHdrPercent(hbm);
        Spline fallbackSpline = getFallbackSdrHdrRatioSpline(hbm);
        return new HdrBrightnessData(Collections.emptyMap(), 0, -1.0f, 0, -1.0f, getTransitionPoint(hbm, transitionPointProvider), fallbackPercent, fallbackPercent, false, fallbackSpline, getFallbackHighestSdrHdrRatio(hbm));
    }

    private static float getFallbackHdrPercent(HighBrightnessMode hbm) {
        if (hbm == null) goto L4;
        BigDecimal minHdrPctOfScreen = hbm.getMinimumHdrPercentOfScreen_all();
    L5:
        if (minHdrPctOfScreen != null) goto L9;
        return 0.5f;
    L9:
        return minHdrPctOfScreen.floatValue();
    L4:
        minHdrPctOfScreen = null;
        goto L5
    }

    private static Spline getSdrHdrRatioSpline(HdrBrightnessConfig hdrConfig, HighBrightnessMode hbm) {
        NonNegativeFloatToFloatMap sdrHdrRatioMap = hdrConfig.getSdrHdrRatioMap();
        if (sdrHdrRatioMap != null) goto L7;
        return getFallbackSdrHdrRatioSpline(hbm);
    L7:
        return DisplayDeviceConfigUtils.createSpline(sdrHdrRatioMap.getPoint(), new HdrBrightnessData$$ExternalSyntheticLambda0(), new HdrBrightnessData$$ExternalSyntheticLambda1());
    }

    private static Spline getFallbackSdrHdrRatioSpline(HighBrightnessMode hbm) {
        if (hbm == null) goto L5;
        SdrHdrRatioMap fallbackMap = hbm.getSdrHdrRatioMap_all();
    L6:
        if (fallbackMap != null) goto L9;
        return null;
    L9:
        return DisplayDeviceConfigUtils.createSpline(fallbackMap.getPoint(), new HdrBrightnessData$$ExternalSyntheticLambda3(), new HdrBrightnessData$$ExternalSyntheticLambda2());
    L5:
        fallbackMap = null;
        goto L6
    }

    private static float getHighestSdrHdrRatio(HdrBrightnessConfig hdrConfig, HighBrightnessMode hbm) {
        NonNegativeFloatToFloatMap sdrHdrRatioMap = hdrConfig.getSdrHdrRatioMap();
        if (sdrHdrRatioMap != null) goto L7;
        return getFallbackHighestSdrHdrRatio(hbm);
    L7:
        return DisplayDeviceConfigUtils.getHighestHdrSdrRatio(sdrHdrRatioMap.getPoint(), new HdrBrightnessData$$ExternalSyntheticLambda1());
    }

    private static float getFallbackHighestSdrHdrRatio(HighBrightnessMode hbm) {
        if (hbm == null) goto L4;
        SdrHdrRatioMap fallbackMap = hbm.getSdrHdrRatioMap_all();
    L5:
        if (fallbackMap != null) goto L9;
        return 1.0f;
    L9:
        return DisplayDeviceConfigUtils.getHighestHdrSdrRatio(fallbackMap.getPoint(), new HdrBrightnessData$$ExternalSyntheticLambda2());
    L4:
        fallbackMap = null;
        goto L5
    }
}
