package com.android.server.display.feature;

import android.provider.DeviceConfig;
import android.provider.DeviceConfigInterface;
import android.util.Slog;
import com.android.server.display.utils.DeviceConfigParsingUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceConfigParameterProvider {
    private static final String TAG = "DisplayFeatureProvider";
    private final DeviceConfigInterface mDeviceConfig;

    public DeviceConfigParameterProvider(DeviceConfigInterface deviceConfig) {
        this.mDeviceConfig = deviceConfig;
    }

    public boolean isHdrOutputControlFeatureEnabled() {
        return DeviceConfig.getBoolean("display_manager", "enable_hdr_output_control", true);
    }

    public boolean isNormalBrightnessControllerFeatureEnabled() {
        return DeviceConfig.getBoolean("display_manager", "use_normal_brightness_mode_controller", false);
    }

    public boolean isDisableScreenWakeLocksWhileCachedFeatureEnabled() {
        return this.mDeviceConfig.getBoolean("display_manager", "disable_screen_wake_locks_while_cached", true);
    }

    public float getPeakRefreshRateDefault() {
        return this.mDeviceConfig.getFloat("display_manager", "peak_refresh_rate_default", -1.0f);
    }

    public String getPowerThrottlingData() {
        return this.mDeviceConfig.getString("display_manager", "power_throttling_data", null);
    }

    public String getBrightnessThrottlingData() {
        return this.mDeviceConfig.getString("display_manager", "brightness_throttling_data", null);
    }

    public int getRefreshRateInHbmSunlight() {
        return this.mDeviceConfig.getInt("display_manager", "refresh_rate_in_hbm_sunlight", -1);
    }

    public int getRefreshRateInHbmHdr() {
        return this.mDeviceConfig.getInt("display_manager", "refresh_rate_in_hbm_hdr", -1);
    }

    public int getRefreshRateInHighZone() {
        return this.mDeviceConfig.getInt("display_manager", "refresh_rate_in_high_zone", -1);
    }

    public int getRefreshRateInLowZone() {
        return this.mDeviceConfig.getInt("display_manager", "refresh_rate_in_zone", -1);
    }

    public float[] getHighAmbientBrightnessThresholds() {
        return DeviceConfigParsingUtils.ambientBrightnessThresholdsIntToFloat(getIntArrayProperty("fixed_refresh_rate_high_ambient_brightness_thresholds"));
    }

    public float[] getHighDisplayBrightnessThresholds() {
        return DeviceConfigParsingUtils.displayBrightnessThresholdsIntToFloat(getIntArrayProperty("fixed_refresh_rate_high_display_brightness_thresholds"));
    }

    public float[] getLowDisplayBrightnessThresholds() {
        return DeviceConfigParsingUtils.displayBrightnessThresholdsIntToFloat(getIntArrayProperty("peak_refresh_rate_brightness_thresholds"));
    }

    public float[] getLowAmbientBrightnessThresholds() {
        return DeviceConfigParsingUtils.ambientBrightnessThresholdsIntToFloat(getIntArrayProperty("peak_refresh_rate_ambient_thresholds"));
    }

    public void addOnPropertiesChangedListener(Executor executor, DeviceConfig.OnPropertiesChangedListener listener) {
        this.mDeviceConfig.addOnPropertiesChangedListener("display_manager", executor, listener);
    }

    public void removeOnPropertiesChangedListener(DeviceConfig.OnPropertiesChangedListener listener) {
        this.mDeviceConfig.removeOnPropertiesChangedListener(listener);
    }

    private int[] getIntArrayProperty(String prop) {
        String strArray = this.mDeviceConfig.getString("display_manager", prop, null);
        if (strArray != null) goto L5;
        return null;
    L5:
        return parseIntArray(strArray);
    }

    private int[] parseIntArray(String strArray) {
        String[] items = strArray.split(",");
        int[] array = new int[items.length];
        int i = 0;
    L12:
    L7:
        e = move-exception;
        Slog.e(TAG, "Incorrect format for array: '" + strArray + "'", e);
        return null;
    L4:
        if (i >= array.length) goto L15;
        array[i] = Integer.parseInt(items[i]);     // Catch: NumberFormatException -> L7
        i = i + 1;
        goto L12
    L15:
        return array;
    }
}
