package com.android.server.display.config;

import android.util.Slog;
import android.util.Spline;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EvenDimmerBrightnessData {
    private static final String TAG = "EvenDimmerBrightnessData";
    public final float[] backlight;
    public final Spline backlightToBrightness;
    public final Spline backlightToNits;
    public final float[] brightness;
    public final Spline brightnessToBacklight;
    public final Spline minLuxToNits;
    public final float[] nits;
    public final Spline nitsToBacklight;
    public final float transitionPoint;

    public EvenDimmerBrightnessData(float transitionPoint, float[] nits, float[] backlight, float[] brightness, Spline backlightToNits, Spline nitsToBacklight, Spline brightnessToBacklight, Spline backlightToBrightness, Spline minLuxToNits) {
        this.transitionPoint = transitionPoint;
        this.nits = nits;
        this.backlight = backlight;
        this.brightness = brightness;
        this.backlightToNits = backlightToNits;
        this.nitsToBacklight = nitsToBacklight;
        this.brightnessToBacklight = brightnessToBacklight;
        this.backlightToBrightness = backlightToBrightness;
        this.minLuxToNits = minLuxToNits;
    }

    public String toString() {
        return "EvenDimmerBrightnessData {transitionPoint: " + this.transitionPoint + ", nits: " + Arrays.toString(this.nits) + ", backlight: " + Arrays.toString(this.backlight) + ", brightness: " + Arrays.toString(this.brightness) + ", backlightToNits: " + this.backlightToNits + ", nitsToBacklight: " + this.nitsToBacklight + ", brightnessToBacklight: " + this.brightnessToBacklight + ", backlightToBrightness: " + this.backlightToBrightness + ", minLuxToNits: " + this.minLuxToNits + "} ";
    }

    public static EvenDimmerBrightnessData loadConfig(DisplayConfiguration config) {
        EvenDimmerMode lbm = config.getEvenDimmer();
        if (lbm != null) goto L5;
        return null;
    L5:
        boolean lbmIsEnabled = lbm.getEnabled();
        if (lbmIsEnabled == true) goto L8;
        return null;
    L8:
        ComprehensiveBrightnessMap map = lbm.getBrightnessMapping();
        if (map != null) goto L11;
        return null;
    L11:
        List<BrightnessPoint> brightnessPoints = map.getBrightnessPoint();
        if (brightnessPoints.isEmpty() == false) goto L14;
        return null;
    L14:
        float[] nits = new float[brightnessPoints.size()];
        float[] backlight = new float[brightnessPoints.size()];
        float[] brightness = new float[brightnessPoints.size()];
        int i = 0;
    L16:
        if (i >= brightnessPoints.size()) goto L18;
        BrightnessPoint val = brightnessPoints.get(i);
        nits[i] = val.getNits().floatValue();
        backlight[i] = val.getBacklight().floatValue();
        brightness[i] = val.getBrightness().floatValue();
        i = i + 1;
        goto L16
    L18:
        float transitionPoint = lbm.getTransitionPoint().floatValue();
        NitsMap minimumNitsMap = lbm.getLuxToMinimumNitsMap();
        if (minimumNitsMap != null) goto L22;
        Slog.e(TAG, "Invalid min lux to nits mapping");
        return null;
    L22:
        List<Point> points = minimumNitsMap.getPoint();
        int size = points.size();
        float[] minLux = new float[size];
        float[] minNits = new float[size];
        Iterator<Point> r15 = points.iterator();
        int i2 = 0;
    L24:
        if (r15.hasNext() == false) goto L37;
        Point point = r15.next();
        minLux[i2] = point.getValue().floatValue();
        minNits[i2] = point.getNits().floatValue();
        if (i2 <= 0) goto L34;
        EvenDimmerMode lbm2 = lbm;
        if (minLux[i2] >= minLux[i2 - 1]) goto L32;
        Slog.e(TAG, "minLuxToNitsSpline must be non-decreasing, ignoring rest  of configuration. Value: " + minLux[i2] + " < " + minLux[i2 - 1]);
    L32:
        if (minNits[i2] >= minNits[i2 - 1]) goto L35;
        Slog.e(TAG, "minLuxToNitsSpline must be non-decreasing, ignoring rest  of configuration. Nits: " + minNits[i2] + " < " + minNits[i2 - 1]);
    L35:
        i2 = i2 + 1;
        points = points;
        lbm = lbm2;
        lbmIsEnabled = lbmIsEnabled;
        goto L24
    L34:
        lbm2 = lbm;
        points = points;
        lbmIsEnabled = lbmIsEnabled;
        goto L35
    L37:
        return new EvenDimmerBrightnessData(transitionPoint, nits, backlight, brightness, new Spline.LinearSpline(backlight, nits), new Spline.LinearSpline(nits, backlight), new Spline.LinearSpline(brightness, backlight), new Spline.LinearSpline(backlight, brightness), Spline.createSpline(minLux, minNits));
    }
}
