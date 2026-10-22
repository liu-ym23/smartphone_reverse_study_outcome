package com.android.server.display.config;

import android.util.Slog;
import android.util.Spline;
import android.view.SurfaceControl;
import java.math.BigDecimal;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class HighBrightnessModeData {
    static final float HDR_PERCENT_OF_SCREEN_REQUIRED_DEFAULT = 0.5f;
    private static final String TAG = "HighBrightnessModeData";
    public final boolean allowInLowPowerMode;
    public final boolean isHighBrightnessModeEnabled;
    public final float minimumHdrPercentOfScreen;
    public final float minimumLux;
    public final SurfaceControl.RefreshRateRange refreshRateLimit;
    public final Spline sdrToHdrRatioSpline;
    public final long timeMaxMillis;
    public final long timeMinMillis;
    public final long timeWindowMillis;
    public final float transitionPoint;

    public HighBrightnessModeData(float minimumLux, float transitionPoint, long timeWindowMillis, long timeMaxMillis, long timeMinMillis, boolean allowInLowPowerMode, float minimumHdrPercentOfScreen, Spline sdrToHdrRatioSpline, SurfaceControl.RefreshRateRange refreshRateLimit, boolean isHighBrightnessModeEnabled) {
        this.minimumLux = minimumLux;
        this.transitionPoint = transitionPoint;
        this.timeWindowMillis = timeWindowMillis;
        this.timeMaxMillis = timeMaxMillis;
        this.timeMinMillis = timeMinMillis;
        this.allowInLowPowerMode = allowInLowPowerMode;
        this.minimumHdrPercentOfScreen = minimumHdrPercentOfScreen;
        this.sdrToHdrRatioSpline = sdrToHdrRatioSpline;
        this.refreshRateLimit = refreshRateLimit;
        this.isHighBrightnessModeEnabled = isHighBrightnessModeEnabled;
    }

    public String toString() {
        return "HBM{minLux: " + this.minimumLux + ", transition: " + this.transitionPoint + ", timeWindow: " + this.timeWindowMillis + "ms, timeMax: " + this.timeMaxMillis + "ms, timeMin: " + this.timeMinMillis + "ms, allowInLowPowerMode: " + this.allowInLowPowerMode + ", minimumHdrPercentOfScreen: " + this.minimumHdrPercentOfScreen + ", mSdrToHdrRatioSpline=" + this.sdrToHdrRatioSpline + ", refreshRateLimit=" + this.refreshRateLimit + ", isHighBrightnessModeEnabled=" + this.isHighBrightnessModeEnabled + "} ";
    }

    public static HighBrightnessModeData loadHighBrightnessModeData(DisplayConfiguration config, Function<HighBrightnessMode, Float> transitionPointProvider) {
        HighBrightnessMode hbm = config.getHighBrightnessMode();
        float minimumHdrPercentOfScreen = HDR_PERCENT_OF_SCREEN_REQUIRED_DEFAULT;
        SurfaceControl.RefreshRateRange refreshRateLimit = null;
        if (hbm == null) goto L19;
        float minimumLux = hbm.getMinimumLux_all().floatValue();
        float transitionPoint = transitionPointProvider.apply(hbm).floatValue();
        HbmTiming hbmTiming = hbm.getTiming_all();
        long timeWindowMillis = hbmTiming.getTimeWindowSecs_all().longValue() * 1000;
        long timeMaxMillis = hbmTiming.getTimeMaxSecs_all().longValue() * 1000;
        long timeMinMillis = hbmTiming.getTimeMinSecs_all().longValue() * 1000;
        boolean allowInLowPowerMode = hbm.getAllowInLowPowerMode_all();
        BigDecimal minHdrPctOfScreen = hbm.getMinimumHdrPercentOfScreen_all();
        if (minHdrPctOfScreen == null) goto L14;
        minimumHdrPercentOfScreen = minHdrPctOfScreen.floatValue();
        if (minimumHdrPercentOfScreen <= 1.0f) goto L9;
    L12:
        Slog.w(TAG, "Invalid minimum HDR percent of screen: " + minimumHdrPercentOfScreen);
        minimumHdrPercentOfScreen = HDR_PERCENT_OF_SCREEN_REQUIRED_DEFAULT;
        goto L14
    L9:
        if (minimumHdrPercentOfScreen < 0.0f) goto L12;
    L14:
        Spline sdrToHdrRatioSpline = loadSdrHdrRatioMap(hbm);
        RefreshRateRange rr = hbm.getRefreshRate_all();
        if (rr == null) goto L18;
        float r0 = rr.getMinimum().floatValue();
        float transitionPoint2 = rr.getMaximum().floatValue();
        refreshRateLimit = new SurfaceControl.RefreshRateRange(r0, transitionPoint2);
    L18:
        boolean isEnabled = hbm.getEnabled();
        float minimumLux2 = minimumLux;
        float transitionPoint3 = transitionPoint;
        long timeWindowMillis2 = timeWindowMillis;
        long timeMaxMillis2 = timeMaxMillis;
        long timeMinMillis2 = timeMinMillis;
        boolean allowInLowPowerMode2 = allowInLowPowerMode;
        float minimumHdrPercentOfScreen2 = minimumHdrPercentOfScreen;
        Spline sdrToHdrRatioSpline2 = sdrToHdrRatioSpline;
        SurfaceControl.RefreshRateRange refreshRateLimit2 = refreshRateLimit;
        boolean isEnabled2 = isEnabled;
    L21:
        return new HighBrightnessModeData(minimumLux2, transitionPoint3, timeWindowMillis2, timeMaxMillis2, timeMinMillis2, allowInLowPowerMode2, minimumHdrPercentOfScreen2, sdrToHdrRatioSpline2, refreshRateLimit2, isEnabled2);
    L19:
        minimumLux2 = 0.0f;
        transitionPoint3 = 0.0f;
        timeWindowMillis2 = 0;
        timeMaxMillis2 = 0;
        timeMinMillis2 = 0;
        allowInLowPowerMode2 = false;
        minimumHdrPercentOfScreen2 = 0.5f;
        sdrToHdrRatioSpline2 = null;
        refreshRateLimit2 = null;
        isEnabled2 = false;
        goto L21
    }

    private static Spline loadSdrHdrRatioMap(HighBrightnessMode hbmConfig) {
        SdrHdrRatioMap sdrHdrRatioMap = hbmConfig.getSdrHdrRatioMap_all();
        if (sdrHdrRatioMap != null) goto L7;
        return null;
    L7:
        return DisplayDeviceConfigUtils.createSpline(sdrHdrRatioMap.getPoint(), new HdrBrightnessData$$ExternalSyntheticLambda3(), new HdrBrightnessData$$ExternalSyntheticLambda2());
    }
}
