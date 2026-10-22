package com.android.server.display.config;

import android.R;
import android.content.Context;
import android.util.Spline;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.server.display.DisplayDeviceConfig;
import com.android.server.display.feature.DisplayManagerFlags;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayBrightnessMappingConfig {
    private static final String DEFAULT_BRIGHTNESS_MAPPING_KEY = null;
    private final Map<String, float[]> mBrightnessLevelsLuxMap;
    private final Map<String, float[]> mBrightnessLevelsMap;
    private float[] mBrightnessLevelsNits;

    static {
        DEFAULT_BRIGHTNESS_MAPPING_KEY = AutoBrightnessModeName._default.getRawName() + "_" + AutoBrightnessSettingName.normal.getRawName();
    }

    public DisplayBrightnessMappingConfig(Context context, DisplayManagerFlags flags, AutoBrightness autoBrightnessConfig, Spline backlightToBrightnessSpline) {
        this.mBrightnessLevelsMap = new HashMap();
        this.mBrightnessLevelsLuxMap = new HashMap();
        if (flags.areAutoBrightnessModesEnabled() == false) goto L39;
        if (autoBrightnessConfig == null) goto L39;
        if (autoBrightnessConfig.getLuxToBrightnessMapping() == null) goto L39;
        if (autoBrightnessConfig.getLuxToBrightnessMapping().size() <= 0) goto L39;
        Iterator<LuxToBrightnessMapping> r0 = autoBrightnessConfig.getLuxToBrightnessMapping().iterator();
    L11:
        if (r0.hasNext() == false) goto L39;
        LuxToBrightnessMapping mapping = r0.next();
        int size = mapping.getMap().getPoint().size();
        float[] brightnessLevels = new float[size];
        float[] brightnessLevelsLux = new float[size];
        int i = 0;
    L13:
        if (i >= size) goto L16;
        float backlight = mapping.getMap().getPoint().get(i).getSecond().floatValue();
        brightnessLevels[i] = backlightToBrightnessSpline.interpolate(backlight);
        brightnessLevelsLux[i] = mapping.getMap().getPoint().get(i).getFirst().floatValue();
        i = i + 1;
        goto L13
    L16:
        if (size == 0) goto L37;
        if (brightnessLevelsLux[0] != 0.0f) goto L35;
        StringBuilder r5 = new StringBuilder();
        if (mapping.getMode() != null) goto L22;
        String r6 = AutoBrightnessModeName._default.getRawName();
    L23:
        r5.append(r6);
        r5.append("_");
        if (mapping.getSetting() != null) goto L26;
        String r7 = AutoBrightnessSettingName.normal.getRawName();
    L27:
        r5.append(r7);
        String key = r5.toString();
        if (this.mBrightnessLevelsMap.containsKey(key) == true) goto L33;
        if (this.mBrightnessLevelsLuxMap.containsKey(key) == true) goto L33;
        this.mBrightnessLevelsMap.put(key, brightnessLevels);
        this.mBrightnessLevelsLuxMap.put(key, brightnessLevelsLux);
    L33:
        throw new IllegalArgumentException("A display brightness mapping with key " + key + " already exists");
    L26:
        r7 = mapping.getSetting().getRawName();
        goto L27
    L22:
        r6 = mapping.getMode().getRawName();
        goto L23
    L35:
        throw new IllegalArgumentException("The first lux value in the display brightness mapping must be 0");
    L37:
        throw new IllegalArgumentException("A display brightness mapping should not be empty");
    L39:
        if (this.mBrightnessLevelsMap.containsKey(DEFAULT_BRIGHTNESS_MAPPING_KEY) == true) goto L41;
    L42:
        this.mBrightnessLevelsNits = DisplayDeviceConfig.getFloatArray(context.getResources().obtainTypedArray(R.array.config_bg_current_drain_high_threshold_to_bg_restricted), -1.0f);
        this.mBrightnessLevelsLuxMap.put(DEFAULT_BRIGHTNESS_MAPPING_KEY, DisplayDeviceConfig.getLuxLevels(context.getResources().getIntArray(R.array.config_biometric_protected_package_names)));
        this.mBrightnessLevelsMap.put(DEFAULT_BRIGHTNESS_MAPPING_KEY, brightnessArrayIntToFloat(context.getResources().getIntArray(R.array.config_bg_current_drain_threshold_to_bg_restricted), backlightToBrightnessSpline));
        return;
    L41:
        if (this.mBrightnessLevelsLuxMap.containsKey(DEFAULT_BRIGHTNESS_MAPPING_KEY) == false) goto L42;
    }

    public float[] getLuxArray(int mode, int preset) {
        float[] luxArray = this.mBrightnessLevelsLuxMap.get(autoBrightnessModeToString(mode) + "_" + autoBrightnessPresetToString(preset));
        if (luxArray == null) goto L6;
        return luxArray;
    L6:
        return this.mBrightnessLevelsLuxMap.get(autoBrightnessModeToString(mode) + "_" + AutoBrightnessSettingName.normal.getRawName());
    }

    public float[] getNitsArray() {
        return this.mBrightnessLevelsNits;
    }

    public float[] getBrightnessArray(int mode, int preset) {
        float[] brightnessArray = this.mBrightnessLevelsMap.get(autoBrightnessModeToString(mode) + "_" + autoBrightnessPresetToString(preset));
        if (brightnessArray == null) goto L6;
        return brightnessArray;
    L6:
        return this.mBrightnessLevelsMap.get(autoBrightnessModeToString(mode) + "_" + AutoBrightnessSettingName.normal.getRawName());
    }

    public String toString() {
        StringBuilder brightnessLevelsLuxMapString = new StringBuilder("{");
        Iterator<Map.Entry<String, float[]>> r2 = this.mBrightnessLevelsLuxMap.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        Map.Entry<String, float[]> entry = r2.next();
        brightnessLevelsLuxMapString.append(entry.getKey());
        brightnessLevelsLuxMapString.append("=");
        brightnessLevelsLuxMapString.append(Arrays.toString(entry.getValue()));
        brightnessLevelsLuxMapString.append(", ");
        goto L4
    L7:
        if (brightnessLevelsLuxMapString.length() <= 2) goto L9;
        brightnessLevelsLuxMapString.delete(brightnessLevelsLuxMapString.length() - 2, brightnessLevelsLuxMapString.length());
    L9:
        brightnessLevelsLuxMapString.append("}");
        StringBuilder brightnessLevelsMapString = new StringBuilder("{");
        Iterator<Map.Entry<String, float[]>> r1 = this.mBrightnessLevelsMap.entrySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, float[]> entry2 = r1.next();
        brightnessLevelsMapString.append(entry2.getKey());
        brightnessLevelsMapString.append("=");
        brightnessLevelsMapString.append(Arrays.toString(entry2.getValue()));
        brightnessLevelsMapString.append(", ");
        goto L11
    L14:
        if (brightnessLevelsMapString.length() <= 2) goto L16;
        brightnessLevelsMapString.delete(brightnessLevelsMapString.length() - 2, brightnessLevelsMapString.length());
    L16:
        brightnessLevelsMapString.append("}");
        return "mBrightnessLevelsNits= " + Arrays.toString(this.mBrightnessLevelsNits) + ", mBrightnessLevelsLuxMap= " + brightnessLevelsLuxMapString + ", mBrightnessLevelsMap= " + brightnessLevelsMapString;
    }

    public static String autoBrightnessModeToString(int mode) {
        switch(mode) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException("Unknown auto-brightness mode: " + mode);
    L6:
        return AutoBrightnessModeName.bedtime_wear.getRawName();
    L8:
        return AutoBrightnessModeName.doze.getRawName();
    L10:
        return AutoBrightnessModeName.idle.getRawName();
    L12:
        return AutoBrightnessModeName._default.getRawName();
    }

    public static String autoBrightnessPresetToString(int preset) {
        switch(preset) {
            case 1: goto L8;
            case 2: goto L10;
            case 3: goto L9;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException("Unknown auto-brightness preset value: " + preset);
    L9:
        return AutoBrightnessSettingName.dim.getRawName();
    L10:
        return AutoBrightnessSettingName.normal.getRawName();
    L8:
        return AutoBrightnessSettingName.bright.getRawName();
    }

    private float[] brightnessArrayIntToFloat(int[] brightnessInt, Spline backlightToBrightnessSpline) {
        float[] brightnessFloat = new float[brightnessInt.length];
        int i = 0;
    L4:
        if (i >= brightnessInt.length) goto L7;
        brightnessFloat[i] = backlightToBrightnessSpline.interpolate(BrightnessSynchronizer.brightnessIntToFloat(brightnessInt[i]));
        i = i + 1;
        goto L4
    L7:
        return brightnessFloat;
    }
}
