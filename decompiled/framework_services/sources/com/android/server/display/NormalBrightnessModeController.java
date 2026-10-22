package com.android.server.display;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class NormalBrightnessModeController {
    private float mAmbientLux;
    private boolean mAutoBrightnessEnabled;
    private float mMaxBrightness;
    private Map<DisplayDeviceConfig.BrightnessLimitMapType, Map<Float, Float>> mMaxBrightnessLimits;

    NormalBrightnessModeController() {
        this.mMaxBrightnessLimits = new HashMap();
        this.mAmbientLux = Float.MAX_VALUE;
        this.mAutoBrightnessEnabled = false;
        this.mMaxBrightness = 1.0f;
    }

    boolean onAmbientLuxChange(float ambientLux) {
        this.mAmbientLux = ambientLux;
        return recalculateMaxBrightness();
    }

    boolean setAutoBrightnessState(int state) {
        boolean isEnabled = true;
        if (state == 1) goto L7;
        isEnabled = false;
    L7:
        if (isEnabled == this.mAutoBrightnessEnabled) goto L10;
        this.mAutoBrightnessEnabled = isEnabled;
        return recalculateMaxBrightness();
    L10:
        return false;
    }

    float getCurrentBrightnessMax() {
        return this.mMaxBrightness;
    }

    boolean resetNbmData(Map<DisplayDeviceConfig.BrightnessLimitMapType, Map<Float, Float>> maxBrightnessLimits) {
        this.mMaxBrightnessLimits = maxBrightnessLimits;
        return recalculateMaxBrightness();
    }

    void dump(PrintWriter pw) {
        pw.println("NormalBrightnessModeController:");
        pw.println("  mAutoBrightnessEnabled=" + this.mAutoBrightnessEnabled);
        pw.println("  mAmbientLux=" + this.mAmbientLux);
        pw.println("  mMaxBrightness=" + this.mMaxBrightness);
        pw.println("  mMaxBrightnessLimits=" + this.mMaxBrightnessLimits);
    }

    private boolean recalculateMaxBrightness() {
        float foundAmbientBoundary = Float.MAX_VALUE;
        float foundMaxBrightness = 1.0f;
        Map<Float, Float> maxBrightnessPoints = null;
        if (this.mAutoBrightnessEnabled == false) goto L6;
        Map<Float, Float> maxBrightnessPoints2 = this.mMaxBrightnessLimits.get(DisplayDeviceConfig.BrightnessLimitMapType.ADAPTIVE);
        maxBrightnessPoints = maxBrightnessPoints2;
    L6:
        if (this.mAutoBrightnessEnabled == false) goto L9;
        if (maxBrightnessPoints != null) goto L9;
        Map<Float, Float> maxBrightnessPoints3 = this.mMaxBrightnessLimits.get(DisplayDeviceConfig.BrightnessLimitMapType.DEFAULT);
        maxBrightnessPoints = maxBrightnessPoints3;
    L9:
        if (maxBrightnessPoints == null) goto L20;
        Iterator<Map.Entry<Float, Float>> r3 = maxBrightnessPoints.entrySet().iterator();
    L12:
        if (r3.hasNext() == false) goto L20;
        Map.Entry<Float, Float> brightnessPoint = r3.next();
        float ambientBoundary = brightnessPoint.getKey().floatValue();
        if (ambientBoundary <= this.mAmbientLux) goto L12;
        if (ambientBoundary >= foundAmbientBoundary) goto L12;
        foundMaxBrightness = brightnessPoint.getValue().floatValue();
        foundAmbientBoundary = ambientBoundary;
    L20:
        if (this.mMaxBrightness == foundMaxBrightness) goto L23;
        this.mMaxBrightness = foundMaxBrightness;
        return true;
    L23:
        return false;
    }
}
