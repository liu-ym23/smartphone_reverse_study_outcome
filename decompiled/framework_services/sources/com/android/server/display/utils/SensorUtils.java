package com.android.server.display.utils;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.android.server.display.config.SensorData;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SensorUtils {
    public static final int NO_FALLBACK = 0;

    public SensorUtils() {
    }

    public static Sensor findSensor(SensorManager sensorManager, SensorData sensorData, int fallbackType) {
        if (sensorData != null) goto L6;
        return null;
    L6:
        return findSensor(sensorManager, sensorData.type, sensorData.name, fallbackType);
    }

    public static Sensor findSensor(SensorManager sensorManager, String sensorType, String sensorName, int fallbackType) {
        if (sensorManager != null) goto L5;
        return null;
    L5:
        boolean isNameSpecified = !TextUtils.isEmpty(sensorName);
        boolean isTypeSpecified = !TextUtils.isEmpty(sensorType);
        if (isNameSpecified == true) goto L8;
        if (isTypeSpecified == true) goto L8;
    L21:
        if (fallbackType != 0) goto L23;
        return null;
    L23:
        return sensorManager.getDefaultSensor(fallbackType);
    L8:
        List<Sensor> sensors = sensorManager.getSensorList(-1);
        Iterator<Sensor> r4 = sensors.iterator();
    L10:
        if (r4.hasNext() == false) goto L21;
        Sensor sensor = r4.next();
        if (isNameSpecified == false) goto L15;
        if (sensorName.equals(sensor.getName()) == false) goto L10;
    L15:
        if (isTypeSpecified == false) goto L20;
        if (sensorType.equals(sensor.getStringType()) == false) goto L10;
    L20:
        return sensor;
    }

    public static int getSensorTemperatureType(SensorData tempSensor) {
        if (tempSensor.type.equalsIgnoreCase(SensorData.TEMPERATURE_TYPE_DISPLAY) == false) goto L7;
        return 11;
    L7:
        if (tempSensor.type.equalsIgnoreCase(SensorData.TEMPERATURE_TYPE_SKIN) == false) goto L11;
        return 3;
    L11:
        throw new IllegalArgumentException("tempSensor doesn't support type: " + tempSensor.type);
    }
}
