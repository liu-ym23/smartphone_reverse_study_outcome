package com.android.server.accessibility.magnification;

import android.content.ContentResolver;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;

/* JADX INFO: loaded from: classes.dex */
public class FullScreenMagnificationVibrationHelper {
    private static final int VIBRATION_AMPLITUDE = 127;
    private static final long VIBRATION_DURATION_MS = 10;
    private final ContentResolver mContentResolver;
    VibrationEffectSupportedProvider mIsVibrationEffectSupportedProvider;
    private final VibrationEffect mVibrationEffect;
    private final Vibrator mVibrator;

    interface VibrationEffectSupportedProvider {
        boolean isVibrationEffectSupported();
    }

    public static /* synthetic */ boolean $r8$lambda$IilLQVdJVIsd1508DxmBYUCCvrw(FullScreenMagnificationVibrationHelper r0) {
        return r0.lambda$new$0();
    }

    public FullScreenMagnificationVibrationHelper(Context context) {
        this.mVibrationEffect = VibrationEffect.get(0);
        this.mContentResolver = context.getContentResolver();
        this.mVibrator = (Vibrator) context.getSystemService(Vibrator.class);
        this.mIsVibrationEffectSupportedProvider = new FullScreenMagnificationVibrationHelper$$ExternalSyntheticLambda0(this);
    }

    private /* synthetic */ boolean lambda$new$0() {
        if (this.mVibrator != null) goto L5;
        return false;
    L5:
        if (this.mVibrator.areAllEffectsSupported(new int[]{0}) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    void vibrateIfSettingEnabled() {
        if (this.mVibrator != null) goto L5;
        return;
    L5:
        if (this.mVibrator.hasVibrator() == true) goto L7;
        return;
    L7:
        if (isEdgeHapticSettingEnabled() == true) goto L9;
        return;
    L9:
        if (this.mIsVibrationEffectSupportedProvider.isVibrationEffectSupported() == false) goto L11;
        this.mVibrator.vibrate(this.mVibrationEffect);
        return;
    L11:
        this.mVibrator.vibrate(VibrationEffect.createOneShot(VIBRATION_DURATION_MS, 127));
    }

    private boolean isEdgeHapticSettingEnabled() {
        if (Settings.Secure.getIntForUser(this.mContentResolver, "accessibility_display_magnification_edge_haptic_enabled", 0, -2) == 1) goto L5;
        return false;
    L5:
        return true;
    }
}
