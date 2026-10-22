package com.android.server.display.config;

import android.R;
import android.content.res.Resources;
import android.text.TextUtils;
import com.android.server.display.feature.DisplayManagerFlags;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SensorData {
    public static final String TEMPERATURE_TYPE_DISPLAY = "DISPLAY";
    public static final String TEMPERATURE_TYPE_SKIN = "SKIN";
    private static final SensorData UNSPECIFIED_SENSOR_DATA = null;
    public final float maxRefreshRate;
    public final float minRefreshRate;
    public final String name;
    public final List<SupportedModeData> supportedModes;
    public final String type;

    static {
        UNSPECIFIED_SENSOR_DATA = new SensorData(null, null);
    }

    private SensorData(String type, String name) {
        this(type, name, 0.0f, Float.POSITIVE_INFINITY, List.of());
    }

    SensorData(String type, String name, float minRefreshRate, float maxRefreshRate, List<SupportedModeData> supportedModes) {
        this.type = type;
        this.name = name;
        this.minRefreshRate = minRefreshRate;
        this.maxRefreshRate = maxRefreshRate;
        this.supportedModes = Collections.unmodifiableList(supportedModes);
    }

    public boolean matches(String sensorName, String sensorType) {
        boolean isNameSpecified = !TextUtils.isEmpty(sensorName);
        boolean isTypeSpecified = !TextUtils.isEmpty(sensorType);
        if (isNameSpecified == true) goto L6;
        if (isTypeSpecified == true) goto L6;
    L14:
        return false;
    L6:
        if (isNameSpecified == true) goto L8;
    L10:
        if (isTypeSpecified == true) goto L12;
        return true;
    L12:
        if (sensorType.equals(this.type) == false) goto L14;
        return true;
    L8:
        if (sensorName.equals(this.name) == false) goto L14;
        goto L10
    }

    public String toString() {
        return "SensorData{type= " + this.type + ", name= " + this.name + ", refreshRateRange: [" + this.minRefreshRate + ", " + this.maxRefreshRate + "], supportedModes=" + this.supportedModes + '}';
    }

    public static SensorData loadAmbientLightSensorConfig(DisplayConfiguration config, Resources resources) {
        SensorDetails sensorDetails = config.getLightSensor();
        if (sensorDetails == null) goto L7;
        return loadSensorData(sensorDetails);
    L7:
        return loadAmbientLightSensorConfig(resources);
    }

    public static SensorData loadAmbientLightSensorConfig(Resources resources) {
        return new SensorData(resources.getString(R.string.config_mms_user_agent_profile_url), "");
    }

    public static SensorData loadScreenOffBrightnessSensorConfig(DisplayConfiguration config) {
        SensorDetails sensorDetails = config.getScreenOffBrightnessSensor();
        if (sensorDetails == null) goto L7;
        return loadSensorData(sensorDetails);
    L7:
        return UNSPECIFIED_SENSOR_DATA;
    }

    public static SensorData loadProxSensorConfig(DisplayManagerFlags flags, DisplayConfiguration config) {
        List<SensorDetails> sensorDetailsList = config.getProxSensor();
        if (sensorDetailsList.isEmpty() == true) goto L5;
        SensorData selectedSensor = UNSPECIFIED_SENSOR_DATA;
        Iterator<SensorDetails> r2 = sensorDetailsList.iterator();
    L8:
        if (r2.hasNext() == false) goto L16;
        SensorDetails sensorDetails = r2.next();
        String flagStr = sensorDetails.getFeatureFlag();
        if (flags.isUseFusionProxSensorEnabled() == false) goto L8;
        if (flags.getUseFusionProxSensorFlagName().equals(flagStr) == false) goto L8;
        selectedSensor = loadSensorData(sensorDetails);
    L16:
        if (UNSPECIFIED_SENSOR_DATA != selectedSensor) goto L25;
        Iterator<SensorDetails> r3 = sensorDetailsList.iterator();
    L19:
        if (r3.hasNext() == false) goto L25;
        SensorDetails sensorDetails2 = r3.next();
        if (sensorDetails2.getFeatureFlag() != null) goto L19;
        selectedSensor = loadSensorData(sensorDetails2);
    L25:
        if (UNSPECIFIED_SENSOR_DATA != selectedSensor) goto L27;
        return selectedSensor;
    L27:
        if ("".equals(selectedSensor.name) == true) goto L29;
        return selectedSensor;
    L29:
        if ("".equals(selectedSensor.type) == false) goto L43;
        return null;
    L43:
        return selectedSensor;
    L5:
        return UNSPECIFIED_SENSOR_DATA;
    }

    public static SensorData loadTempSensorUnspecifiedConfig() {
        return new SensorData(TEMPERATURE_TYPE_SKIN, null);
    }

    public static SensorData loadTempSensorConfig(DisplayManagerFlags flags, DisplayConfiguration config) {
        SensorDetails sensorDetails = config.getTempSensor();
        if (flags.isSensorBasedBrightnessThrottlingEnabled() == false) goto L14;
        if (sensorDetails == null) goto L14;
        String name = sensorDetails.getName();
        String type = sensorDetails.getType();
        if (TextUtils.isEmpty(type) == false) goto L9;
    L10:
        type = TEMPERATURE_TYPE_SKIN;
        name = null;
    L12:
        return new SensorData(type, name);
    L9:
        if (TextUtils.isEmpty(name) == false) goto L12;
    L14:
        return loadTempSensorUnspecifiedConfig();
    }

    public static SensorData loadSensorUnspecifiedConfig() {
        return UNSPECIFIED_SENSOR_DATA;
    }

    private static SensorData loadSensorData(SensorDetails sensorDetails) {
        RefreshRateRange rr = sensorDetails.getRefreshRate();
        if (rr == null) goto L5;
        float minRefreshRate = rr.getMinimum().floatValue();
        float maxRefreshRate = rr.getMaximum().floatValue();
        float minRefreshRate2 = minRefreshRate;
        float maxRefreshRate2 = maxRefreshRate;
    L6:
        List<SupportedModeData> supportedModes = SupportedModeData.load(sensorDetails.getSupportedModes());
        return new SensorData(sensorDetails.getType(), sensorDetails.getName(), minRefreshRate2, maxRefreshRate2, supportedModes);
    L5:
        minRefreshRate2 = 0.0f;
        maxRefreshRate2 = Float.POSITIVE_INFINITY;
        goto L6
    }
}
