package com.android.server.display.utils;

import android.util.Slog;
import com.android.internal.display.BrightnessSynchronizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceConfigParsingUtils {
    private static final String TAG = "DeviceConfigParsingUtils";

    public static /* synthetic */ Map $r8$lambda$b2Y8K0BYdwDnMSlNtt3pQmkwaec(String r0) {
        return lambda$parseDeviceConfigMap$0(r0);
    }

    public DeviceConfigParsingUtils() {
    }

    public static <T, V> Map<String, Map<String, V>> parseDeviceConfigMap(String data, BiFunction<String, String, T> dataPointMapper, Function<List<T>, V> dataSetMapper) {
        if (data == null) goto L5;
        Map<String, Map<String, V>> result = new HashMap();
        String[] dataSets = data.split(";");
        int r0 = dataSets.length;
        int r4 = 0;
    L7:
        if (r4 >= r0) goto L46;
        String dataSet = dataSets[r4];
        String[] items = dataSet.split(",");
        int noOfItems = items.length;
        if (noOfItems < 4) goto L10;
        int i = 0 + 1;
        String uniqueDisplayId = items[0];
        int i2 = i + 1;
        String numberOfPointsString = items[i];
        int numberOfPoints = Integer.parseInt(numberOfPointsString);     // Catch: NumberFormatException -> L43
        int expectedMinItems = (numberOfPoints * 2) + 2;
        if (noOfItems < expectedMinItems) goto L41;
        if (noOfItems > (expectedMinItems + 1)) goto L41;
        List<T> dataPoints = new ArrayList();
        int j = 0;
    L20:
        int r16 = r0;
        if (j >= numberOfPoints) goto L27;
        int i3 = i2 + 1;
        String key = items[i2];
        int i4 = i3 + 1;
        String[] dataSets2 = dataSets;
        String value = items[i3];
        int r17 = r4;
        int noOfItems2 = noOfItems;
        T dataPoint = dataPointMapper.apply(key, value);
        if (dataPoint == null) goto L24;
        dataPoints.add(dataPoint);
        j = j + 1;
        r0 = r16;
        r4 = r17;
        i2 = i4;
        dataSets = dataSets2;
        noOfItems = noOfItems2;
        goto L20
    L24:
        Slog.e(TAG, "Invalid dataPoint ,key=" + key + ",value=" + value + ",dataSet=" + dataSet, new Throwable());
        return Map.of();
    L27:
        String[] dataSets3 = dataSets;
        int r18 = r4;
        V dataSetMapped = dataSetMapper.apply(dataPoints);
        if (dataSetMapped == null) goto L29;
        if (i2 >= items.length) goto L34;
        String dataSetId = items[i2];
    L35:
        Map<String, V> byDisplayId = result.computeIfAbsent(uniqueDisplayId, new DeviceConfigParsingUtils$$ExternalSyntheticLambda0());
        if (byDisplayId.put(dataSetId, dataSetMapped) != null) goto L37;
        r4 = r18 + 1;
        r0 = r16;
        dataSets = dataSets3;
        goto L7
    L37:
        Slog.e(TAG, "Duplicate dataSetId=" + dataSetId + ",data=" + data, new Throwable());
        return Map.of();
    L34:
        dataSetId = "default";
        goto L35
    L29:
        Slog.e(TAG, "Invalid dataSetMapped dataPoints=" + dataPoints + ",dataSet=" + dataSet, new Throwable());
        return Map.of();
    L41:
        Slog.e(TAG, "Invalid dataSet(wrong number of points):" + dataSet, new Throwable());
        return Map.of();
    L43:
        nfe = move-exception;
        Slog.e(TAG, "Invalid dataSet(invalid number of points):" + dataSet, nfe);
        return Map.of();
    L10:
        Slog.e(TAG, "Invalid dataSet(not enough items):" + dataSet, new Throwable());
        return Map.of();
    L46:
        return result;
    L5:
        return Map.of();
    }

    private static /* synthetic */ Map lambda$parseDeviceConfigMap$0(String k) {
        return new HashMap();
    }

    public static int parseThermalStatus(String value) throws IllegalArgumentException {
        switch(value.hashCode()) {
            case -905723276: goto L24;
            case -618857213: goto L21;
            case -169343402: goto L18;
            case 3387192: goto L15;
            case 102970646: goto L12;
            case 1629013393: goto L9;
            case 1952151455: goto L6;
            default: goto L26;
        };
    L26:
        byte r0 = -1;
    L27:
        switch(r0) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L30;
            default: goto L29;
        };
    L30:
        return 6;
    L31:
        return 5;
    L32:
        return 4;
    L33:
        return 3;
    L34:
        return 2;
    L35:
        return 1;
    L36:
        return 0;
    L29:
        throw new IllegalArgumentException("Invalid Thermal Status: " + value);
    L6:
        if (value.equals("critical") == false) goto L26;
        r0 = 4;
        goto L27
    L9:
        if (value.equals("emergency") == false) goto L26;
        r0 = 5;
        goto L27
    L12:
        if (value.equals("light") == false) goto L26;
        r0 = 1;
        goto L27
    L15:
        if (value.equals("none") == false) goto L26;
        r0 = 0;
        goto L27
    L18:
        if (value.equals("shutdown") == false) goto L26;
        r0 = 6;
        goto L27
    L21:
        if (value.equals("moderate") == false) goto L26;
        r0 = 2;
        goto L27
    L24:
        if (value.equals("severe") == false) goto L26;
        r0 = 3;
        goto L27
    }

    public static float parseBrightness(String stringVal) throws IllegalArgumentException {
        float value = Float.parseFloat(stringVal);
        if (value < 0.0f) goto L8;
        if (value > 1.0f) goto L8;
        return value;
    L8:
        throw new IllegalArgumentException("Brightness value out of bounds: " + stringVal);
    }

    public static float[] displayBrightnessThresholdsIntToFloat(int[] thresholdsInt) {
        if (thresholdsInt != null) goto L5;
        return null;
    L5:
        float[] thresholds = new float[thresholdsInt.length];
        int i = 0;
    L7:
        if (i >= thresholds.length) goto L14;
        if (thresholdsInt[i] >= 0) goto L11;
        thresholds[i] = thresholdsInt[i];
    L12:
        i = i + 1;
        goto L7
    L11:
        thresholds[i] = BrightnessSynchronizer.brightnessIntToFloat(thresholdsInt[i]);
        goto L12
    L14:
        return thresholds;
    }

    public static float[] ambientBrightnessThresholdsIntToFloat(int[] thresholdsInt) {
        if (thresholdsInt != null) goto L5;
        return null;
    L5:
        float[] thresholds = new float[thresholdsInt.length];
        int i = 0;
    L7:
        if (i >= thresholds.length) goto L10;
        thresholds[i] = thresholdsInt[i];
        i = i + 1;
        goto L7
    L10:
        return thresholds;
    }
}
