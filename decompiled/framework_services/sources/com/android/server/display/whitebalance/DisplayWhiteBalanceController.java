package com.android.server.display.whitebalance;

import android.util.Slog;
import android.util.Spline;
import com.android.server.LocalServices;
import com.android.server.display.color.ColorDisplayService;
import com.android.server.display.utils.AmbientFilter;
import com.android.server.display.utils.History;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayWhiteBalanceController implements AmbientSensor.AmbientBrightnessSensor.Callbacks, AmbientSensor.AmbientColorTemperatureSensor.Callbacks {
    private static final String TAG = "DisplayWhiteBalanceController";
    private float mAmbientColorTemperature;
    private final History mAmbientColorTemperatureHistory;
    private float mAmbientColorTemperatureOverride;
    private Spline.LinearSpline mAmbientToDisplayColorTemperatureSpline;
    AmbientFilter mBrightnessFilter;
    private final AmbientSensor.AmbientBrightnessSensor mBrightnessSensor;
    private final ColorDisplayService.ColorDisplayServiceInternal mColorDisplayServiceInternal;
    AmbientFilter mColorTemperatureFilter;
    private final AmbientSensor.AmbientColorTemperatureSensor mColorTemperatureSensor;
    private Callbacks mDisplayPowerControllerCallbacks;
    private boolean mEnabled;
    private Spline.LinearSpline mHighLightAmbientBrightnessToBiasSpline;
    private Spline.LinearSpline mHighLightAmbientBrightnessToBiasSplineStrong;
    private final float mHighLightAmbientColorTemperature;
    private final float mHighLightAmbientColorTemperatureStrong;
    private float mLastAmbientColorTemperature;
    private float mLatestAmbientBrightness;
    private float mLatestAmbientColorTemperature;
    private float mLatestHighLightBias;
    private float mLatestLowLightBias;
    private final boolean mLightModeAllowed;
    private boolean mLoggingEnabled;
    private Spline.LinearSpline mLowLightAmbientBrightnessToBiasSpline;
    private Spline.LinearSpline mLowLightAmbientBrightnessToBiasSplineStrong;
    private final float mLowLightAmbientColorTemperature;
    private final float mLowLightAmbientColorTemperatureStrong;
    float mPendingAmbientColorTemperature;
    private Spline.LinearSpline mStrongAmbientToDisplayColorTemperatureSpline;
    private boolean mStrongModeEnabled;
    private final DisplayWhiteBalanceThrottler mThrottler;

    public interface Callbacks {
        void updateWhiteBalance();
    }

    public DisplayWhiteBalanceController(AmbientSensor.AmbientBrightnessSensor brightnessSensor, AmbientFilter brightnessFilter, AmbientSensor.AmbientColorTemperatureSensor colorTemperatureSensor, AmbientFilter colorTemperatureFilter, DisplayWhiteBalanceThrottler throttler, float[] lowLightAmbientBrightnesses, float[] lowLightAmbientBrightnessesStrong, float[] lowLightAmbientBiases, float[] lowLightAmbientBiasesStrong, float lowLightAmbientColorTemperature, float lowLightAmbientColorTemperatureStrong, float[] highLightAmbientBrightnesses, float[] highLightAmbientBrightnessesStrong, float[] highLightAmbientBiases, float[] highLightAmbientBiasesStrong, float highLightAmbientColorTemperature, float highLightAmbientColorTemperatureStrong, float[] ambientColorTemperatures, float[] displayColorTemperatures, float[] strongAmbientColorTemperatures, float[] strongDisplayColorTemperatures, boolean lightModeAllowed) {
        validateArguments(brightnessSensor, brightnessFilter, colorTemperatureSensor, colorTemperatureFilter, throttler);
        this.mBrightnessSensor = brightnessSensor;
        this.mBrightnessFilter = brightnessFilter;
        this.mColorTemperatureSensor = colorTemperatureSensor;
        this.mColorTemperatureFilter = colorTemperatureFilter;
        this.mThrottler = throttler;
        this.mLowLightAmbientColorTemperature = lowLightAmbientColorTemperature;
        this.mLowLightAmbientColorTemperatureStrong = lowLightAmbientColorTemperatureStrong;
        this.mHighLightAmbientColorTemperature = highLightAmbientColorTemperature;
        this.mHighLightAmbientColorTemperatureStrong = highLightAmbientColorTemperatureStrong;
        this.mAmbientColorTemperature = -1.0f;
        this.mPendingAmbientColorTemperature = -1.0f;
        this.mLastAmbientColorTemperature = -1.0f;
        this.mAmbientColorTemperatureHistory = new History(50);
        this.mAmbientColorTemperatureOverride = -1.0f;
        this.mLightModeAllowed = lightModeAllowed;
        this.mLowLightAmbientBrightnessToBiasSpline = new Spline.LinearSpline(lowLightAmbientBrightnesses, lowLightAmbientBiases);     // Catch: Exception -> L7
    L13:
        if (this.mLowLightAmbientBrightnessToBiasSpline != null) goto L15;
    L115:
        this.mLowLightAmbientBrightnessToBiasSplineStrong = new Spline.LinearSpline(lowLightAmbientBrightnessesStrong, lowLightAmbientBiasesStrong);     // Catch: Exception -> L23
    L29:
        if (this.mLowLightAmbientBrightnessToBiasSplineStrong != null) goto L31;
    L123:
        this.mHighLightAmbientBrightnessToBiasSpline = new Spline.LinearSpline(highLightAmbientBrightnesses, highLightAmbientBiases);     // Catch: Exception -> L39
    L45:
        if (this.mHighLightAmbientBrightnessToBiasSpline != null) goto L47;
    L103:
        this.mHighLightAmbientBrightnessToBiasSplineStrong = new Spline.LinearSpline(highLightAmbientBrightnessesStrong, highLightAmbientBiasesStrong);     // Catch: Exception -> L55
    L61:
        if (this.mHighLightAmbientBrightnessToBiasSplineStrong == null) goto L68;
        if (this.mHighLightAmbientBrightnessToBiasSplineStrong.interpolate(0.0f) == 0.0f) goto L65;
    L66:
        Slog.d(TAG, "invalid strong high light ambient brightness to bias spline, bias must begin at 0.0 and end at 1.0.");
        this.mHighLightAmbientBrightnessToBiasSplineStrong = null;
        goto L68
    L65:
        if (this.mHighLightAmbientBrightnessToBiasSplineStrong.interpolate(Float.POSITIVE_INFINITY) != 1.0f) goto L66;
    L68:
        if (this.mLowLightAmbientBrightnessToBiasSpline == null) goto L77;
        if (this.mHighLightAmbientBrightnessToBiasSpline == null) goto L77;
        if (lowLightAmbientBrightnesses[lowLightAmbientBrightnesses.length - 1] <= highLightAmbientBrightnesses[0]) goto L77;
        Slog.d(TAG, "invalid low light and high light ambient brightness to bias spline combination, defined domains must not intersect.");
        this.mLowLightAmbientBrightnessToBiasSpline = null;
        this.mHighLightAmbientBrightnessToBiasSpline = null;
    L77:
        if (this.mLowLightAmbientBrightnessToBiasSplineStrong != null) goto L79;
    L107:
        this.mAmbientToDisplayColorTemperatureSpline = new Spline.LinearSpline(ambientColorTemperatures, displayColorTemperatures);     // Catch: Exception -> L87
    L117:
        this.mStrongAmbientToDisplayColorTemperatureSpline = new Spline.LinearSpline(strongAmbientColorTemperatures, strongDisplayColorTemperatures);     // Catch: Exception -> L96
    L101:
        this.mColorDisplayServiceInternal = (ColorDisplayService.ColorDisplayServiceInternal) LocalServices.getService(ColorDisplayService.ColorDisplayServiceInternal.class);
        return;
    L96:
        e = e;
    L100:
        Slog.e(TAG, "Failed to create strong ambient to display color temperature spline", e);
    L98:
        e = e;
    L87:
        e = e;
    L91:
        Slog.e(TAG, "failed to create ambient to display color temperature spline.", e);
        this.mAmbientToDisplayColorTemperatureSpline = null;
    L89:
        e = e;
        goto L91
    L79:
        if (this.mHighLightAmbientBrightnessToBiasSplineStrong == null) goto L107;
        if (lowLightAmbientBrightnessesStrong[lowLightAmbientBrightnessesStrong.length - 1] <= highLightAmbientBrightnessesStrong[0]) goto L107;
        Slog.d(TAG, "invalid strong low light and high light ambient brightness to bias spline combination, defined domains must not intersect.");
        this.mLowLightAmbientBrightnessToBiasSplineStrong = null;
        this.mHighLightAmbientBrightnessToBiasSplineStrong = null;
    L55:
        e = e;
    L59:
        Slog.e(TAG, "failed to create strong high light ambient brightness to bias spline.", e);
        this.mHighLightAmbientBrightnessToBiasSplineStrong = null;
    L57:
        e = e;
        goto L59
    L47:
        if (this.mHighLightAmbientBrightnessToBiasSpline.interpolate(0.0f) == 0.0f) goto L49;
    L50:
        Slog.d(TAG, "invalid high light ambient brightness to bias spline, bias must begin at 0.0 and end at 1.0.");
        this.mHighLightAmbientBrightnessToBiasSpline = null;
        goto L103
    L49:
        if (this.mHighLightAmbientBrightnessToBiasSpline.interpolate(Float.POSITIVE_INFINITY) == 1.0f) goto L103;
    L39:
        e = e;
    L43:
        Slog.e(TAG, "failed to create high light ambient brightness to bias spline.", e);
        this.mHighLightAmbientBrightnessToBiasSpline = null;
    L41:
        e = e;
        goto L43
    L31:
        if (this.mLowLightAmbientBrightnessToBiasSplineStrong.interpolate(0.0f) == 0.0f) goto L33;
    L34:
        Slog.d(TAG, "invalid strong low light ambient brightness to bias spline, bias must begin at 0.0 and end at 1.0.");
        this.mLowLightAmbientBrightnessToBiasSplineStrong = null;
        goto L123
    L33:
        if (this.mLowLightAmbientBrightnessToBiasSplineStrong.interpolate(Float.POSITIVE_INFINITY) == 1.0f) goto L123;
    L23:
        e = e;
    L27:
        Slog.e(TAG, "failed to create strong low light ambient brightness to bias spline.", e);
        this.mLowLightAmbientBrightnessToBiasSplineStrong = null;
    L25:
        e = e;
        goto L27
    L15:
        if (this.mLowLightAmbientBrightnessToBiasSpline.interpolate(0.0f) == 0.0f) goto L17;
    L18:
        Slog.d(TAG, "invalid low light ambient brightness to bias spline, bias must begin at 0.0 and end at 1.0.");
        this.mLowLightAmbientBrightnessToBiasSpline = null;
        goto L115
    L17:
        if (this.mLowLightAmbientBrightnessToBiasSpline.interpolate(Float.POSITIVE_INFINITY) == 1.0f) goto L115;
    L7:
        e = e;
    L11:
        Slog.e(TAG, "failed to create low light ambient brightness to bias spline.", e);
        this.mLowLightAmbientBrightnessToBiasSpline = null;
    L9:
        e = e;
        goto L11
    }

    public boolean setEnabled(boolean enabled) {
        if (enabled == false) goto L6;
        return enable();
    L6:
        return disable();
    }

    public void setStrongModeEnabled(boolean enabled) {
        this.mStrongModeEnabled = enabled;
        ColorDisplayService.ColorDisplayServiceInternal r0 = this.mColorDisplayServiceInternal;
        if (this.mLightModeAllowed == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        r0.setDisplayWhiteBalanceAllowed(r1);
        if (this.mEnabled == false) goto L13;
        updateAmbientColorTemperature();
        updateDisplayColorTemperature();
        return;
    L13:
        return;
    L5:
        if (this.mStrongModeEnabled == true) goto L8;
        r1 = false;
        goto L9
    }

    public boolean setCallbacks(Callbacks callbacks) {
        if (this.mDisplayPowerControllerCallbacks != callbacks) goto L6;
        return false;
    L6:
        this.mDisplayPowerControllerCallbacks = callbacks;
        return true;
    }

    public boolean setLoggingEnabled(boolean loggingEnabled) {
        if (this.mLoggingEnabled != loggingEnabled) goto L6;
        return false;
    L6:
        this.mLoggingEnabled = loggingEnabled;
        this.mBrightnessSensor.setLoggingEnabled(loggingEnabled);
        this.mBrightnessFilter.setLoggingEnabled(loggingEnabled);
        this.mColorTemperatureSensor.setLoggingEnabled(loggingEnabled);
        this.mColorTemperatureFilter.setLoggingEnabled(loggingEnabled);
        this.mThrottler.setLoggingEnabled(loggingEnabled);
        return true;
    }

    public boolean setAmbientColorTemperatureOverride(float ambientColorTemperatureOverride) {
        if (this.mAmbientColorTemperatureOverride != ambientColorTemperatureOverride) goto L6;
        return false;
    L6:
        this.mAmbientColorTemperatureOverride = ambientColorTemperatureOverride;
        return true;
    }

    public void dump(PrintWriter writer) {
        writer.println("DisplayWhiteBalanceController:");
        writer.println("------------------------------");
        writer.println("  mLoggingEnabled=" + this.mLoggingEnabled);
        writer.println("  mEnabled=" + this.mEnabled);
        writer.println("  mStrongModeEnabled=" + this.mStrongModeEnabled);
        writer.println("  mDisplayPowerControllerCallbacks=" + this.mDisplayPowerControllerCallbacks);
        this.mBrightnessSensor.dump(writer);
        this.mBrightnessFilter.dump(writer);
        this.mColorTemperatureSensor.dump(writer);
        this.mColorTemperatureFilter.dump(writer);
        this.mThrottler.dump(writer);
        writer.println("  mLowLightAmbientColorTemperature=" + this.mLowLightAmbientColorTemperature);
        writer.println("  mLowLightAmbientColorTemperatureStrong=" + this.mLowLightAmbientColorTemperatureStrong);
        writer.println("  mHighLightAmbientColorTemperature=" + this.mHighLightAmbientColorTemperature);
        writer.println("  mHighLightAmbientColorTemperatureStrong=" + this.mHighLightAmbientColorTemperatureStrong);
        writer.println("  mAmbientColorTemperature=" + this.mAmbientColorTemperature);
        writer.println("  mPendingAmbientColorTemperature=" + this.mPendingAmbientColorTemperature);
        writer.println("  mLastAmbientColorTemperature=" + this.mLastAmbientColorTemperature);
        writer.println("  mAmbientColorTemperatureHistory=" + this.mAmbientColorTemperatureHistory);
        writer.println("  mAmbientColorTemperatureOverride=" + this.mAmbientColorTemperatureOverride);
        writer.println("  mAmbientToDisplayColorTemperatureSpline=" + this.mAmbientToDisplayColorTemperatureSpline);
        writer.println("  mStrongAmbientToDisplayColorTemperatureSpline=" + this.mStrongAmbientToDisplayColorTemperatureSpline);
        writer.println("  mLowLightAmbientBrightnessToBiasSpline=" + this.mLowLightAmbientBrightnessToBiasSpline);
        writer.println("  mLowLightAmbientBrightnessToBiasSplineStrong=" + this.mLowLightAmbientBrightnessToBiasSplineStrong);
        writer.println("  mHighLightAmbientBrightnessToBiasSpline=" + this.mHighLightAmbientBrightnessToBiasSpline);
        writer.println("  mHighLightAmbientBrightnessToBiasSplineStrong=" + this.mHighLightAmbientBrightnessToBiasSplineStrong);
    }

    @Override // com.android.server.display.whitebalance.AmbientSensor.AmbientBrightnessSensor.Callbacks
    public void onAmbientBrightnessChanged(float value) {
        long time = System.currentTimeMillis();
        this.mBrightnessFilter.addValue(time, value);
        updateAmbientColorTemperature();
    }

    @Override // com.android.server.display.whitebalance.AmbientSensor.AmbientColorTemperatureSensor.Callbacks
    public void onAmbientColorTemperatureChanged(float value) {
        long time = System.currentTimeMillis();
        this.mColorTemperatureFilter.addValue(time, value);
        updateAmbientColorTemperature();
    }

    public void updateAmbientColorTemperature() {
        long time = System.currentTimeMillis();
        if (this.mStrongModeEnabled == false) goto L5;
        float lowLightAmbientColorTemperature = this.mLowLightAmbientColorTemperatureStrong;
    L7:
        if (this.mStrongModeEnabled == false) goto L9;
        float highLightAmbientColorTemperature = this.mHighLightAmbientColorTemperatureStrong;
    L11:
        if (this.mStrongModeEnabled == false) goto L13;
        Spline.LinearSpline lowLightAmbientBrightnessToBiasSpline = this.mLowLightAmbientBrightnessToBiasSplineStrong;
    L15:
        if (this.mStrongModeEnabled == false) goto L17;
        Spline.LinearSpline highLightAmbientBrightnessToBiasSpline = this.mHighLightAmbientBrightnessToBiasSplineStrong;
    L18:
        float ambientColorTemperature = this.mColorTemperatureFilter.getEstimate(time);
        this.mLatestAmbientColorTemperature = ambientColorTemperature;
        if (this.mStrongModeEnabled == false) goto L26;
        if (this.mStrongAmbientToDisplayColorTemperatureSpline != null) goto L23;
    L30:
        float ambientBrightness = this.mBrightnessFilter.getEstimate(time);
        this.mLatestAmbientBrightness = ambientBrightness;
        if (ambientColorTemperature == (-1.0f)) goto L37;
        if (ambientBrightness == (-1.0f)) goto L37;
        if (lowLightAmbientBrightnessToBiasSpline == null) goto L37;
        float bias = lowLightAmbientBrightnessToBiasSpline.interpolate(ambientBrightness);
        ambientColorTemperature = (bias * ambientColorTemperature) + ((1.0f - bias) * lowLightAmbientColorTemperature);
        this.mLatestLowLightBias = bias;
    L37:
        if (ambientColorTemperature == (-1.0f)) goto L43;
        if (ambientBrightness == (-1.0f)) goto L43;
        if (highLightAmbientBrightnessToBiasSpline == null) goto L43;
        float bias2 = highLightAmbientBrightnessToBiasSpline.interpolate(ambientBrightness);
        ambientColorTemperature = ((1.0f - bias2) * ambientColorTemperature) + (bias2 * highLightAmbientColorTemperature);
        this.mLatestHighLightBias = bias2;
    L43:
        if (this.mAmbientColorTemperatureOverride == (-1.0f)) goto L49;
        if (this.mLoggingEnabled == false) goto L47;
        Slog.d(TAG, "override ambient color temperature: " + ambientColorTemperature + " => " + this.mAmbientColorTemperatureOverride);
    L47:
        ambientColorTemperature = this.mAmbientColorTemperatureOverride;
    L49:
        if (ambientColorTemperature != (-1.0f)) goto L51;
        return;
    L51:
        if (this.mThrottler.throttle(ambientColorTemperature) == false) goto L54;
        return;
    L54:
        if (this.mLoggingEnabled == false) goto L56;
        Slog.d(TAG, "pending ambient color temperature: " + ambientColorTemperature);
    L56:
        this.mPendingAmbientColorTemperature = ambientColorTemperature;
        if (this.mDisplayPowerControllerCallbacks == null) goto L61;
        this.mDisplayPowerControllerCallbacks.updateWhiteBalance();
        return;
    L61:
        return;
    L23:
        if (ambientColorTemperature == (-1.0f)) goto L30;
        ambientColorTemperature = this.mStrongAmbientToDisplayColorTemperatureSpline.interpolate(ambientColorTemperature);
        goto L30
    L26:
        if (this.mAmbientToDisplayColorTemperatureSpline == null) goto L30;
        if (ambientColorTemperature == (-1.0f)) goto L30;
        ambientColorTemperature = this.mAmbientToDisplayColorTemperatureSpline.interpolate(ambientColorTemperature);
        goto L30
    L17:
        highLightAmbientBrightnessToBiasSpline = this.mHighLightAmbientBrightnessToBiasSpline;
        goto L18
    L13:
        lowLightAmbientBrightnessToBiasSpline = this.mLowLightAmbientBrightnessToBiasSpline;
        goto L15
    L9:
        highLightAmbientColorTemperature = this.mHighLightAmbientColorTemperature;
        goto L11
    L5:
        lowLightAmbientColorTemperature = this.mLowLightAmbientColorTemperature;
        goto L7
    }

    public void updateDisplayColorTemperature() {
        float ambientColorTemperature = -1.0f;
        if (this.mAmbientColorTemperature != (-1.0f)) goto L8;
        if (this.mPendingAmbientColorTemperature != (-1.0f)) goto L8;
        ambientColorTemperature = this.mLastAmbientColorTemperature;
    L8:
        if (this.mPendingAmbientColorTemperature == (-1.0f)) goto L13;
        if (this.mPendingAmbientColorTemperature == this.mAmbientColorTemperature) goto L13;
        ambientColorTemperature = this.mPendingAmbientColorTemperature;
    L13:
        if (ambientColorTemperature != (-1.0f)) goto L15;
        return;
    L15:
        this.mAmbientColorTemperature = ambientColorTemperature;
        if (this.mLoggingEnabled == false) goto L18;
        Slog.d(TAG, "ambient color temperature: " + this.mAmbientColorTemperature);
    L18:
        this.mPendingAmbientColorTemperature = -1.0f;
        this.mAmbientColorTemperatureHistory.add(this.mAmbientColorTemperature);
        Slog.d(TAG, "Display cct: " + this.mAmbientColorTemperature + " Latest ambient cct: " + this.mLatestAmbientColorTemperature + " Latest ambient lux: " + this.mLatestAmbientBrightness + " Latest low light bias: " + this.mLatestLowLightBias + " Latest high light bias: " + this.mLatestHighLightBias);
        this.mColorDisplayServiceInternal.setDisplayWhiteBalanceColorTemperature((int) this.mAmbientColorTemperature);
        this.mLastAmbientColorTemperature = this.mAmbientColorTemperature;
    }

    public float calculateAdjustedBrightnessNits(float requestedBrightnessNits) {
        float luminance = this.mColorDisplayServiceInternal.getDisplayWhiteBalanceLuminance();
        if (luminance != (-1.0f)) goto L5;
        return requestedBrightnessNits;
    L5:
        float effectiveBrightness = requestedBrightnessNits * luminance;
        return (requestedBrightnessNits - effectiveBrightness) + requestedBrightnessNits;
    }

    private void validateArguments(AmbientSensor.AmbientBrightnessSensor brightnessSensor, AmbientFilter brightnessFilter, AmbientSensor.AmbientColorTemperatureSensor colorTemperatureSensor, AmbientFilter colorTemperatureFilter, DisplayWhiteBalanceThrottler throttler) {
        brightnessSensor.getClass();
        brightnessFilter.getClass();
        colorTemperatureSensor.getClass();
        colorTemperatureFilter.getClass();
        throttler.getClass();
    }

    private boolean enable() {
        if (this.mEnabled == false) goto L7;
        return false;
    L7:
        if (this.mLoggingEnabled == false) goto L9;
        Slog.d(TAG, "enabling");
    L9:
        this.mEnabled = true;
        this.mBrightnessSensor.setEnabled(true);
        this.mColorTemperatureSensor.setEnabled(true);
        return true;
    }

    private boolean disable() {
        if (this.mEnabled == true) goto L6;
        return false;
    L6:
        if (this.mLoggingEnabled == false) goto L8;
        Slog.d(TAG, "disabling");
    L8:
        this.mEnabled = false;
        this.mBrightnessSensor.setEnabled(false);
        this.mBrightnessFilter.clear();
        this.mColorTemperatureSensor.setEnabled(false);
        this.mColorTemperatureFilter.clear();
        this.mThrottler.clear();
        this.mAmbientColorTemperature = -1.0f;
        this.mPendingAmbientColorTemperature = -1.0f;
        this.mColorDisplayServiceInternal.resetDisplayWhiteBalanceColorTemperature();
        return true;
    }
}
