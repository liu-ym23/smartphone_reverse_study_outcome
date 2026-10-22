package com.android.server.display.whitebalance;

import android.R;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.hardware.SensorManager;
import android.os.Handler;
import android.util.TypedValue;
import com.android.server.display.utils.AmbientFilter;
import com.android.server.display.utils.AmbientFilterFactory;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayWhiteBalanceFactory {
    private static final String BRIGHTNESS_FILTER_TAG = "AmbientBrightnessFilter";
    private static final String COLOR_TEMPERATURE_FILTER_TAG = "AmbientColorTemperatureFilter";

    public static DisplayWhiteBalanceController create(Handler handler, SensorManager sensorManager, Resources resources) {
        AmbientSensor.AmbientBrightnessSensor brightnessSensor = createBrightnessSensor(handler, sensorManager, resources);
        AmbientFilter brightnessFilter = AmbientFilterFactory.createBrightnessFilter(BRIGHTNESS_FILTER_TAG, resources);
        AmbientSensor.AmbientColorTemperatureSensor colorTemperatureSensor = createColorTemperatureSensor(handler, sensorManager, resources);
        AmbientFilter colorTemperatureFilter = AmbientFilterFactory.createColorTemperatureFilter(COLOR_TEMPERATURE_FILTER_TAG, resources);
        DisplayWhiteBalanceThrottler throttler = createThrottler(resources);
        float[] displayWhiteBalanceLowLightAmbientBrightnesses = getFloatArray(resources, R.array.config_face_acquire_vendor_keyguard_ignorelist);
        float[] displayWhiteBalanceLowLightAmbientBrightnessesStrong = getFloatArray(resources, R.array.config_fillBuiltInDisplayCutoutArray);
        float[] displayWhiteBalanceLowLightAmbientBiases = getFloatArray(resources, R.array.config_face_acquire_vendor_biometricprompt_ignorelist);
        float[] displayWhiteBalanceLowLightAmbientBiasesStrong = getFloatArray(resources, R.array.config_face_acquire_vendor_enroll_ignorelist);
        float lowLightAmbientColorTemperature = getFloat(resources, R.dimen.default_background_blur_radius);
        float lowLightAmbientColorTemperatureStrong = getFloat(resources, R.dimen.default_gap);
        float[] displayWhiteBalanceHighLightAmbientBrightnesses = getFloatArray(resources, R.array.config_face_acquire_biometricprompt_ignorelist);
        float[] displayWhiteBalanceHighLightAmbientBrightnessesStrong = getFloatArray(resources, R.array.config_face_acquire_enroll_ignorelist);
        float[] displayWhiteBalanceHighLightAmbientBiases = getFloatArray(resources, R.array.config_ephemeralResolverPackage);
        float[] displayWhiteBalanceHighLightAmbientBiasesStrong = getFloatArray(resources, R.array.config_ethernet_interfaces);
        float highLightAmbientColorTemperature = getFloat(resources, R.dimen.default_app_widget_padding_right);
        float highLightAmbientColorTemperatureStrong = getFloat(resources, R.dimen.default_app_widget_padding_top);
        float[] ambientColorTemperatures = getFloatArray(resources, R.array.config_displayWhiteBalanceStrongDisplayColorTemperatures);
        float[] displayColorTemperatures = getFloatArray(resources, R.array.config_doubleClickVibePattern);
        float[] strongAmbientColorTemperatures = getFloatArray(resources, R.array.config_foldedDeviceStates);
        float[] strongDisplayColorTemperatures = getFloatArray(resources, R.array.config_fontManagerServiceCerts);
        boolean lightModeAllowed = resources.getBoolean(R.bool.config_dontPreferApn);
        DisplayWhiteBalanceController controller = new DisplayWhiteBalanceController(brightnessSensor, brightnessFilter, colorTemperatureSensor, colorTemperatureFilter, throttler, displayWhiteBalanceLowLightAmbientBrightnesses, displayWhiteBalanceLowLightAmbientBrightnessesStrong, displayWhiteBalanceLowLightAmbientBiases, displayWhiteBalanceLowLightAmbientBiasesStrong, lowLightAmbientColorTemperature, lowLightAmbientColorTemperatureStrong, displayWhiteBalanceHighLightAmbientBrightnesses, displayWhiteBalanceHighLightAmbientBrightnessesStrong, displayWhiteBalanceHighLightAmbientBiases, displayWhiteBalanceHighLightAmbientBiasesStrong, highLightAmbientColorTemperature, highLightAmbientColorTemperatureStrong, ambientColorTemperatures, displayColorTemperatures, strongAmbientColorTemperatures, strongDisplayColorTemperatures, lightModeAllowed);
        brightnessSensor.setCallbacks(controller);
        colorTemperatureSensor.setCallbacks(controller);
        return controller;
    }

    private DisplayWhiteBalanceFactory() {
    }

    public static AmbientSensor.AmbientBrightnessSensor createBrightnessSensor(Handler handler, SensorManager sensorManager, Resources resources) {
        int rate = resources.getInteger(R.integer.config_displayWhiteBalanceTransitionTimeIncrease);
        return new AmbientSensor.AmbientBrightnessSensor(handler, sensorManager, rate);
    }

    public static AmbientSensor.AmbientColorTemperatureSensor createColorTemperatureSensor(Handler handler, SensorManager sensorManager, Resources resources) {
        String name = resources.getString(R.string.config_mobile_hotspot_provision_app_no_ui);
        int rate = resources.getInteger(R.integer.config_doubleTapOnHomeBehavior);
        return new AmbientSensor.AmbientColorTemperatureSensor(handler, sensorManager, name, rate);
    }

    private static DisplayWhiteBalanceThrottler createThrottler(Resources resources) {
        int increaseDebounce = resources.getInteger(R.integer.config_doubleTapPowerGestureMode);
        int decreaseDebounce = resources.getInteger(R.integer.config_doubleTapTimeoutMillis);
        float[] baseThresholds = getFloatArray(resources, R.array.config_display_no_service_when_sim_unready);
        float[] increaseThresholds = getFloatArray(resources, R.array.config_face_acquire_keyguard_ignorelist);
        float[] decreaseThresholds = getFloatArray(resources, R.array.config_dockExtconStateMapping);
        return new DisplayWhiteBalanceThrottler(increaseDebounce, decreaseDebounce, baseThresholds, increaseThresholds, decreaseThresholds);
    }

    private static float getFloat(Resources resources, int id) {
        TypedValue value = new TypedValue();
        resources.getValue(id, value, true);
        if (value.type == 4) goto L7;
        return Float.NaN;
    L7:
        return value.getFloat();
    }

    private static float[] getFloatArray(Resources resources, int id) {
        TypedArray array = resources.obtainTypedArray(id);
    L16:
        th = move-exception;
        array.recycle();
        throw th;
    L5:
        if (array.length() != 0) goto L8;
        array.recycle();
        return null;
    L8:
        float[] values = new float[array.length()];     // Catch: Throwable -> L16
        int i = 0;
    L10:
        if (i >= values.length) goto L18;
        values[i] = array.getFloat(i, Float.NaN);     // Catch: Throwable -> L16
        if (Float.isNaN(values[i]) == true) goto L13;
        i = i + 1;
        goto L10
    L13:
        array.recycle();
        return null;
    L18:
        array.recycle();
        return values;
    }
}
