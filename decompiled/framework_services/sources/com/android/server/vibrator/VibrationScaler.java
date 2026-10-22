package com.android.server.vibrator;

import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.vibrator.PrebakedSegment;
import android.os.vibrator.VibrationConfig;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import com.android.server.utils.PriorityDump;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
final class VibrationScaler {
    static final float ADAPTIVE_SCALE_NONE = 1.0f;
    private static final float SCALE_FACTOR_HIGH = 1.2f;
    private static final float SCALE_FACTOR_LOW = 0.8f;
    private static final float SCALE_FACTOR_NONE = 1.0f;
    private static final float SCALE_FACTOR_VERY_HIGH = 1.4f;
    private static final float SCALE_FACTOR_VERY_LOW = 0.6f;
    static final int SCALE_HIGH = 1;
    static final int SCALE_LOW = -1;
    static final int SCALE_NONE = 0;
    static final int SCALE_VERY_HIGH = 2;
    static final int SCALE_VERY_LOW = -2;
    private static final String TAG = "VibrationScaler";
    private final SparseArray<Float> mAdaptiveHapticsScales;
    private final int mDefaultVibrationAmplitude;
    private final float mDefaultVibrationScaleLevelGain;
    private final VibrationSettings mSettingsController;

    VibrationScaler(VibrationConfig config, VibrationSettings settingsController) {
        this.mAdaptiveHapticsScales = new SparseArray();
        this.mSettingsController = settingsController;
        this.mDefaultVibrationAmplitude = config.getDefaultVibrationAmplitude();
        this.mDefaultVibrationScaleLevelGain = config.getDefaultVibrationScaleLevelGain();
    }

    public int getScaleLevel(int usageHint) {
        int defaultIntensity = this.mSettingsController.getDefaultIntensity(usageHint);
        int currentIntensity = this.mSettingsController.getCurrentIntensity(usageHint);
        if (currentIntensity != 0) goto L5;
        return 0;
    L5:
        int scaleLevel = currentIntensity - defaultIntensity;
        if (scaleLevel >= (-2)) goto L8;
    L10:
        Slog.wtf(TAG, "Error in scaling calculations, ended up with invalid scale level " + scaleLevel + " for vibration with usage " + usageHint);
        return 0;
    L8:
        if (scaleLevel > 2) goto L10;
        return scaleLevel;
    }

    public float getScaleFactor(int usageHint) {
        return scaleLevelToScaleFactor(getScaleLevel(usageHint));
    }

    public float getAdaptiveHapticsScale(int usageHint) {
        return this.mAdaptiveHapticsScales.get(usageHint, Float.valueOf(1.0f)).floatValue();
    }

    public VibrationEffect scale(VibrationEffect effect, int usageHint) {
        int newEffectStrength = getEffectStrength(usageHint);
        float scaleFactor = getScaleFactor(usageHint);
        float adaptiveScale = getAdaptiveHapticsScale(usageHint);
        if (usageHint == 33) goto L10;
        if (usageHint == 49) goto L10;
        return effect.resolve(this.mDefaultVibrationAmplitude).applyEffectStrength(newEffectStrength).scale(scaleFactor).applyAdaptiveScale(adaptiveScale);
    L10:
        return effect.resolve(this.mDefaultVibrationAmplitude).applyEffectStrength(newEffectStrength).scaleCustom(scaleFactor).applyAdaptiveScale(adaptiveScale);
    }

    public PrebakedSegment scale(PrebakedSegment prebaked, int usageHint) {
        return prebaked.applyEffectStrength(getEffectStrength(usageHint));
    }

    public void updateAdaptiveHapticsScale(int usageHint, float scale) {
        this.mAdaptiveHapticsScales.put(usageHint, Float.valueOf(scale));
    }

    public void removeAdaptiveHapticsScale(int usageHint) {
        this.mAdaptiveHapticsScales.remove(usageHint);
    }

    public void clearAdaptiveHapticsScales() {
        this.mAdaptiveHapticsScales.clear();
    }

    void dump(IndentingPrintWriter pw) {
        pw.println("VibrationScaler:");
        pw.increaseIndent();
        pw.println("ScaleLevels:");
        pw.increaseIndent();
        int level = -2;
    L4:
        if (level > 2) goto L6;
        pw.println(scaleLevelToString(level) + " = " + scaleLevelToScaleFactor(level));
        level = level + 1;
        goto L4
    L6:
        pw.decreaseIndent();
        pw.println("AdaptiveHapticsScales:");
        pw.increaseIndent();
        int i = 0;
    L8:
        if (i >= this.mAdaptiveHapticsScales.size()) goto L10;
        int usage = this.mAdaptiveHapticsScales.keyAt(i);
        float scale = this.mAdaptiveHapticsScales.valueAt(i).floatValue();
        pw.println(VibrationAttributes.usageToString(usage) + " = " + String.format(Locale.ROOT, "%.2f", new Object[]{Float.valueOf(scale)}));
        i = i + 1;
        goto L8
    L10:
        pw.decreaseIndent();
        pw.decreaseIndent();
    }

    void dump(ProtoOutputStream proto) {
        proto.write(1120986464282L, this.mDefaultVibrationAmplitude);
    }

    public String toString() {
        StringBuilder scaleLevelsStr = new StringBuilder("{");
        int level = -2;
    L4:
        if (level > 2) goto L9;
        scaleLevelsStr.append(scaleLevelToString(level));
        scaleLevelsStr.append("=");
        scaleLevelsStr.append(scaleLevelToScaleFactor(level));
        if (level >= SCALE_FACTOR_VERY_HIGH) goto L8;
        scaleLevelsStr.append(", ");
    L8:
        level = level + 1;
        goto L4
    L9:
        scaleLevelsStr.append("}");
        return "VibrationScaler{mScaleLevels=" + scaleLevelsStr + ", mAdaptiveHapticsScales=" + this.mAdaptiveHapticsScales + '}';
    }

    private int getEffectStrength(int usageHint) {
        int currentIntensity = this.mSettingsController.getCurrentIntensity(usageHint);
        if (currentIntensity != 0) goto L6;
        currentIntensity = this.mSettingsController.getDefaultIntensity(usageHint);
    L6:
        return intensityToEffectStrength(currentIntensity);
    }

    private static int intensityToEffectStrength(int intensity) {
        switch(intensity) {
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L11;
            default: goto L4;
        };
    L4:
        Slog.w(TAG, "Got unexpected vibration intensity: " + intensity);
        return 2;
    L6:
        return 1;
    L7:
        return 0;
    L11:
        return 2;
    }

    private float scaleLevelToScaleFactor(int level) {
        switch(level) {
            case -2: goto L7;
            case -1: goto L6;
            case 0: goto L3;
            case 1: goto L5;
            case 2: goto L4;
            default: goto L3;
        };
    L3:
        return 1.0f;
    L4:
        return SCALE_FACTOR_VERY_HIGH;
    L5:
        return SCALE_FACTOR_HIGH;
    L6:
        return SCALE_FACTOR_LOW;
    L7:
        return SCALE_FACTOR_VERY_LOW;
    }

    static String scaleLevelToString(int scaleLevel) {
        switch(scaleLevel) {
            case -2: goto L8;
            case -1: goto L7;
            case 0: goto L6;
            case 1: goto L5;
            case 2: goto L4;
            default: goto L10;
        };
    L4:
        return "VERY_HIGH";
    L5:
        return PriorityDump.PRIORITY_ARG_HIGH;
    L6:
        return "NONE";
    L7:
        return "LOW";
    L8:
        return "VERY_LOW";
    L10:
        return String.valueOf(scaleLevel);
    }
}
