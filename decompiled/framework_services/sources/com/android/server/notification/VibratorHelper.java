package com.android.server.notification;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.AudioAttributes;
import android.media.Utils;
import android.net.Uri;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Slog;
import com.android.server.pm.PackageManagerService;
import java.time.Duration;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class VibratorHelper {
    private static final long[] DEFAULT_VIBRATE_PATTERN = null;
    private static final String TAG = "NotificationVibratorHelper";
    private static final int VIBRATE_PATTERN_MAXLEN = 17;
    private final Context mContext;
    private final long[] mDefaultPattern;
    private final float[] mDefaultPwlePattern;
    private final int mDefaultVibrationAmplitude;
    private final long[] mFallbackPattern;
    private final float[] mFallbackPwlePattern;
    private final Vibrator mVibrator;

    static {
        DEFAULT_VIBRATE_PATTERN = new long[]{0, 250, 250, 250};
    }

    public VibratorHelper(Context context) {
        this.mVibrator = (Vibrator) context.getSystemService(Vibrator.class);
        this.mDefaultPattern = getLongArray(context.getResources(), R.array.config_displayShapeArray, 17, DEFAULT_VIBRATE_PATTERN);
        this.mFallbackPattern = getLongArray(context.getResources(), R.array.config_roundedCornerBottomRadiusAdjustmentArray, 17, DEFAULT_VIBRATE_PATTERN);
        this.mDefaultPwlePattern = getFloatArray(context.getResources(), R.array.config_displayUniqueIdArray);
        this.mFallbackPwlePattern = getFloatArray(context.getResources(), R.array.config_roundedCornerBottomRadiusArray);
        this.mDefaultVibrationAmplitude = context.getResources().getInteger(R.integer.config_displayWhiteBalanceColorTemperatureDefault);
        this.mContext = context;
    }

    public static VibrationEffect createWaveformVibration(long[] pattern, boolean insistent) {
        if (pattern == null) goto L15;
        if (insistent == false) goto L5;
        int r0 = 0;
    L13:
        return VibrationEffect.createWaveform(pattern, r0);
    L9:
        Slog.e(TAG, "Error creating vibration waveform with pattern: " + Arrays.toString(pattern));
        return null;
    L5:
        r0 = -1;
        goto L13
    L15:
        return null;
    }

    public static VibrationEffect createPwleWaveformVibration(float[] values, boolean insistent) {
        if (values != null) goto L23;
        return null;
    L23:
        int length = values.length;     // Catch: IllegalArgumentException -> L13
        if (length == 0) goto L20;
        if ((length % 3) != 0) goto L20;
        VibrationEffect.WaveformBuilder waveformBuilder = VibrationEffect.startWaveform();     // Catch: IllegalArgumentException -> L13
        int i = 0;
    L11:
        if (i >= length) goto L15;
        waveformBuilder.addTransition(Duration.ofMillis((int) values[i + 2]), VibrationEffect.VibrationParameter.targetAmplitude(values[i]), VibrationEffect.VibrationParameter.targetFrequency(values[i + 1]));     // Catch: IllegalArgumentException -> L13
        i = i + 3;     // Catch: IllegalArgumentException -> L13
        goto L11
    L15:
        VibrationEffect effect = waveformBuilder.build();     // Catch: IllegalArgumentException -> L13
        if (insistent == false) goto L19;
        return VibrationEffect.startComposition().repeatEffectIndefinitely(effect).compose();
    L19:
        return effect;
    L20:
        return null;
    L21:
        Slog.e(TAG, "Error creating vibration PWLE waveform with pattern: " + Arrays.toString(values));
        return null;
    }

    public VibrationEffect scale(VibrationEffect effect, float scale) {
        return effect.resolve(this.mDefaultVibrationAmplitude).scale(scale);
    }

    public void vibrate(VibrationEffect effect, AudioAttributes attrs, String reason) {
        this.mVibrator.vibrate(1000, PackageManagerService.PLATFORM_PACKAGE_NAME, effect, reason, new VibrationAttributes.Builder(attrs).build());
    }

    public void vibrate(VibrationEffect effect, AudioAttributes attrs, String reason, int slotId) {
        Vibrator r0 = this.mVibrator;
        VibrationAttributes.Builder r1 = new VibrationAttributes.Builder(attrs);
        if (slotId != 0) goto L5;
        int r2 = 1024;
    L6:
        r0.vibrate(1000, PackageManagerService.PLATFORM_PACKAGE_NAME, effect, reason, r1.setPrivateFlags(r2).build());
        return;
    L5:
        r2 = 2048;
        goto L6
    }

    public void cancelVibration() {
        this.mVibrator.cancel(-15);
    }

    public VibrationEffect createFallbackVibration(boolean insistent) {
        if (this.mVibrator.hasFrequencyControl() == false) goto L8;
        VibrationEffect effect = createPwleWaveformVibration(this.mFallbackPwlePattern, insistent);
        if (effect == null) goto L8;
        return effect;
    L8:
        return createWaveformVibration(this.mFallbackPattern, insistent);
    }

    public VibrationEffect createDefaultVibration(boolean insistent) {
        if (this.mVibrator.hasFrequencyControl() == false) goto L8;
        VibrationEffect effect = createPwleWaveformVibration(this.mDefaultPwlePattern, insistent);
        if (effect == null) goto L8;
        return effect;
    L8:
        return createWaveformVibration(this.mDefaultPattern, insistent);
    }

    public VibrationEffect createVibrationEffectFromSoundUri(Uri uri) {
        if (uri != null) goto L5;
    L12:
        return null;
    L5:
        if (uri.isOpaque() == true) goto L12;
        return Utils.parseVibrationEffect(this.mVibrator, Utils.getVibrationUri(uri));
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to get vibration effect: ", e);
        return null;
    }

    public boolean areEffectComponentsSupported(VibrationEffect effect) {
        return this.mVibrator.areVibrationFeaturesSupported(effect);
    }

    private static float[] getFloatArray(Resources resources, int resId) {
        TypedArray array = resources.obtainTypedArray(resId);
        float[] values = new float[array.length()];     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= values.length) goto L13;
        values[i] = array.getFloat(i, Float.NaN);     // Catch: Throwable -> L11
        if (Float.isNaN(values[i]) == true) goto L8;
        i = i + 1;
        goto L5
    L8:
        array.recycle();
        return null;
    L13:
        array.recycle();
        return values;
    L11:
        th = move-exception;
        array.recycle();
        throw th;
    }

    private static long[] getLongArray(Resources resources, int resId, int maxLength, long[] def) {
        int[] ar = resources.getIntArray(resId);
        if (ar != null) goto L6;
        return def;
    L6:
        if (ar.length <= maxLength) goto L8;
        int len = maxLength;
    L9:
        long[] out = new long[len];
        int i = 0;
    L10:
        if (i >= len) goto L13;
        out[i] = ar[i];
        i = i + 1;
        goto L10
    L13:
        return out;
    L8:
        len = ar.length;
        goto L9
    }
}
