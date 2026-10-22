package com.android.server.vibrator;

import android.R;
import android.content.res.Resources;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.VibratorInfo;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class HapticFeedbackVibrationProvider {
    private static final VibrationAttributes COMMUNICATION_REQUEST_VIBRATION_ATTRIBUTES = null;
    private static final VibrationAttributes HARDWARE_FEEDBACK_VIBRATION_ATTRIBUTES = null;
    private static final VibrationAttributes IME_FEEDBACK_VIBRATION_ATTRIBUTES = null;
    private static final VibrationAttributes PHYSICAL_EMULATION_VIBRATION_ATTRIBUTES = null;
    private static final String TAG = "HapticFeedbackVibrationProvider";
    private static final VibrationAttributes TOUCH_VIBRATION_ATTRIBUTES = null;
    private final HapticFeedbackCustomization mHapticFeedbackCustomization;
    private final boolean mHapticTextHandleEnabled;
    private float mKeyboardVibrationFixedAmplitude;
    private final VibrationEffect mSafeModeEnabledVibrationEffect;
    private final VibratorInfo mVibratorInfo;

    static {
        TOUCH_VIBRATION_ATTRIBUTES = VibrationAttributes.createForUsage(18);
        PHYSICAL_EMULATION_VIBRATION_ATTRIBUTES = VibrationAttributes.createForUsage(34);
        HARDWARE_FEEDBACK_VIBRATION_ATTRIBUTES = VibrationAttributes.createForUsage(50);
        COMMUNICATION_REQUEST_VIBRATION_ATTRIBUTES = VibrationAttributes.createForUsage(65);
        IME_FEEDBACK_VIBRATION_ATTRIBUTES = VibrationAttributes.createForUsage(82);
    }

    public HapticFeedbackVibrationProvider(Resources res, VibratorInfo vibratorInfo) {
        this(res, vibratorInfo, new HapticFeedbackCustomization(res, vibratorInfo));
    }

    HapticFeedbackVibrationProvider(Resources res, VibratorInfo vibratorInfo, HapticFeedbackCustomization hapticFeedbackCustomization) {
        this.mVibratorInfo = vibratorInfo;
        this.mHapticTextHandleEnabled = res.getBoolean(R.bool.config_enableMultiUserUI);
        this.mHapticFeedbackCustomization = hapticFeedbackCustomization;
        VibrationEffect safeModeVibration = this.mHapticFeedbackCustomization.getEffect(10001);
        if (safeModeVibration == null) goto L5;
        VibrationEffect r1 = safeModeVibration;
    L6:
        this.mSafeModeEnabledVibrationEffect = r1;
        this.mKeyboardVibrationFixedAmplitude = res.getFloat(R.dimen.default_minimal_size_resizable_task);
        if (this.mKeyboardVibrationFixedAmplitude >= 0.0f) goto L9;
    L10:
        this.mKeyboardVibrationFixedAmplitude = -1.0f;
        return;
    L9:
        if (this.mKeyboardVibrationFixedAmplitude > 1.0f) goto L10;
        return;
    L5:
        r1 = VibrationSettings.createEffectFromResource(res, R.array.config_system_condition_providers);
        goto L6
    }

    public VibrationEffect getVibration(int effectId) {
        if (isFeedbackConstantEnabled(effectId) == true) goto L6;
        return null;
    L6:
        VibrationEffect customizedVibration = this.mHapticFeedbackCustomization.getEffect(effectId);
        if (customizedVibration == null) goto L10;
        return customizedVibration;
    L10:
        return getVibrationForHapticFeedback(effectId);
    }

    public VibrationEffect getVibration(int effectId, int inputSource) {
        if (isFeedbackConstantEnabled(effectId) == true) goto L6;
        return null;
    L6:
        VibrationEffect customizedVibration = this.mHapticFeedbackCustomization.getEffect(effectId, inputSource);
        if (customizedVibration == null) goto L10;
        return customizedVibration;
    L10:
        return getVibrationForHapticFeedback(effectId);
    }

    public VibrationAttributes getVibrationAttributes(int effectId, int flags, int privFlags) {
        switch(effectId) {
            case 3: goto L8;
            case 7: goto L8;
            case 14: goto L7;
            case 15: goto L7;
            case 18: goto L6;
            case 19: goto L6;
            case 20: goto L6;
            case 10002: goto L5;
            case 10003: goto L5;
            case 10004: goto L4;
            case 10005: goto L4;
            default: goto L3;
        };
    L3:
        VibrationAttributes attrs = TOUCH_VIBRATION_ATTRIBUTES;
    L10:
        return getVibrationAttributesWithFlags(attrs, effectId, flags);
    L4:
        attrs = COMMUNICATION_REQUEST_VIBRATION_ATTRIBUTES;
        goto L10
    L5:
        attrs = HARDWARE_FEEDBACK_VIBRATION_ATTRIBUTES;
        goto L10
    L6:
        attrs = HARDWARE_FEEDBACK_VIBRATION_ATTRIBUTES;
        goto L10
    L7:
        attrs = PHYSICAL_EMULATION_VIBRATION_ATTRIBUTES;
        goto L10
    L8:
        attrs = createKeyboardVibrationAttributes(privFlags);
        goto L10
    }

    public VibrationAttributes getVibrationAttributes(int effectId, int inputSource, int flags, int privFlags) {
        switch(effectId) {
            case 18: goto L6;
            case 19: goto L6;
            case 20: goto L6;
            default: goto L4;
        };
    L4:
        return getVibrationAttributes(effectId, flags, privFlags);
    L6:
        if (inputSource != 4194304) goto L8;
        VibrationAttributes attrs = HARDWARE_FEEDBACK_VIBRATION_ATTRIBUTES;
    L10:
        return getVibrationAttributesWithFlags(attrs, effectId, flags);
    L8:
        attrs = TOUCH_VIBRATION_ATTRIBUTES;
        goto L10
    }

    public boolean isRestrictedHapticFeedback(int effectId) {
        switch(effectId) {
            case 10004: goto L5;
            case 10005: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    public void dump(String prefix, PrintWriter pw) {
        pw.print("mHapticTextHandleEnabled=");
        pw.println(this.mHapticTextHandleEnabled);
    }

    private boolean isFeedbackConstantEnabled(int effectId) {
        switch(effectId) {
            case -1: goto L5;
            case 9: goto L8;
            default: goto L3;
        };
    L3:
        return true;
    L5:
        return false;
    L8:
        return this.mHapticTextHandleEnabled;
    }

    private VibrationEffect getVibrationForHapticFeedback(int effectId) {
        switch(effectId) {
            case 0: goto L31;
            case 1: goto L29;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L29;
            case 6: goto L23;
            case 7: goto L27;
            case 8: goto L21;
            case 9: goto L25;
            case 11: goto L21;
            case 12: goto L29;
            case 13: goto L23;
            case 14: goto L31;
            case 15: goto L29;
            case 16: goto L29;
            case 17: goto L19;
            case 18: goto L23;
            case 19: goto L29;
            case 20: goto L29;
            case 21: goto L17;
            case 22: goto L15;
            case 23: goto L23;
            case 24: goto L13;
            case 25: goto L31;
            case 26: goto L23;
            case 27: goto L25;
            case 4096: goto L11;
            case 10001: goto L9;
            case 10002: goto L7;
            case 10003: goto L31;
            case 10004: goto L29;
            case 10005: goto L19;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return getAssistantButtonVibration();
    L9:
        return this.mSafeModeEnabledVibrationEffect;
    L11:
        return VibrationEffect.createWaveform(new long[]{60, 20, 20}, new int[]{32, 0, 32}, -1);
    L13:
        return getVibration(7, 0.4f, 21);
    L15:
        return getVibration(8, 0.2f, 21);
    L17:
        return getVibration(7, 0.5f, 2);
    L19:
        return VibrationEffect.get(1);
    L21:
        return VibrationEffect.get(2, false);
    L23:
        return VibrationEffect.get(2);
    L25:
        return VibrationEffect.get(21);
    L27:
        return getKeyboardVibration(effectId);
    L29:
        return VibrationEffect.get(0);
    L31:
        return VibrationEffect.get(5);
    }

    private VibrationEffect getVibration(int primitiveId, float primitiveScale, int predefinedVibrationEffectId) {
        if (this.mVibratorInfo.isPrimitiveSupported(primitiveId) == false) goto L7;
        return VibrationEffect.startComposition().addPrimitive(primitiveId, primitiveScale).compose();
    L7:
        return VibrationEffect.get(predefinedVibrationEffectId);
    }

    private VibrationEffect getAssistantButtonVibration() {
        if (this.mVibratorInfo.isPrimitiveSupported(4) == false) goto L9;
        if (this.mVibratorInfo.isPrimitiveSupported(7) == false) goto L9;
        return VibrationEffect.startComposition().addPrimitive(4, 0.25f).addPrimitive(7, 1.0f, 50).compose();
    L9:
        return VibrationEffect.get(5);
    }

    private VibrationEffect getKeyboardVibration(int effectId) {
        switch(effectId) {
            case 7: goto L4;
            default: goto L3;
        };
    L3:
        int primitiveId = 1;
        int predefinedEffectId = 0;
        boolean predefinedEffectFallback = true;
    L6:
        if (this.mKeyboardVibrationFixedAmplitude <= 0.0f) goto L12;
        if (this.mVibratorInfo.isPrimitiveSupported(primitiveId) == false) goto L12;
        return VibrationEffect.startComposition().addPrimitive(primitiveId, this.mKeyboardVibrationFixedAmplitude).compose();
    L12:
        return VibrationEffect.get(predefinedEffectId, predefinedEffectFallback);
    L4:
        primitiveId = 7;
        predefinedEffectId = 2;
        predefinedEffectFallback = false;
        goto L6
    }

    private VibrationAttributes createKeyboardVibrationAttributes(int privFlags) {
        if ((privFlags & 1) != 0) goto L7;
        return TOUCH_VIBRATION_ATTRIBUTES;
    L7:
        return IME_FEEDBACK_VIBRATION_ATTRIBUTES;
    }

    private VibrationAttributes getVibrationAttributesWithFlags(VibrationAttributes attrs, int effectId, int flags) {
        int vibFlags = 0;
        if ((flags & 2) == 0) goto L6;
        vibFlags = 0 | 2;
    L6:
        if (shouldBypassInterruptionPolicy(effectId) == false) goto L8;
        vibFlags = vibFlags | 1;
    L8:
        if (vibFlags != 0) goto L11;
        return attrs;
    L11:
        return new VibrationAttributes.Builder(attrs).setFlags(vibFlags).build();
    }

    private static boolean shouldBypassInterruptionPolicy(int effectId) {
        switch(effectId) {
            case 18: goto L5;
            case 19: goto L5;
            case 20: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }
}
