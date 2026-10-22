package com.android.server.display.brightness;

import android.util.Slog;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class BrightnessReason {
    public static final int ADJUSTMENT_AUTO = 2;
    public static final int ADJUSTMENT_AUTO_TEMP = 1;
    public static final int MODIFIER_DIMMED = 1;
    public static final int MODIFIER_DIMMED_EXIT = 8192;
    public static final int MODIFIER_HDR = 4;
    public static final int MODIFIER_HDR_EXIT = 4096;
    public static final int MODIFIER_LOW_POWER = 2;
    public static final int MODIFIER_MASK = 12351;
    public static final int MODIFIER_MIN_LUX = 16;
    public static final int MODIFIER_STYLUS_UNDER_USE = 32;
    public static final int MODIFIER_THROTTLED = 8;
    public static final int REASON_AUTOMATIC = 4;
    public static final int REASON_BOOST = 8;
    public static final int REASON_DOZE = 2;
    public static final int REASON_DOZE_DEFAULT = 3;
    public static final int REASON_DOZE_ENTER_FULL_SCREEN_AOD = 14;
    public static final int REASON_DOZE_MANUAL = 12;
    public static final int REASON_FAKE_SLEEP = 13;
    public static final int REASON_FOLLOWER = 10;
    public static final int REASON_MANUAL = 1;
    public static final int REASON_MANUAL_RANGE_TRANSITION = 15;
    public static final int REASON_MAX = 15;
    public static final int REASON_OFFLOAD = 11;
    public static final int REASON_OVERRIDE = 6;
    public static final int REASON_SCREEN_OFF = 5;
    public static final int REASON_SCREEN_OFF_BRIGHTNESS_SENSOR = 9;
    public static final int REASON_TEMPORARY = 7;
    public static final int REASON_UNKNOWN = 0;
    private static final String TAG = "BrightnessReason";
    private int mModifier;
    private int mReason;
    private CharSequence mTag;

    public BrightnessReason() {
    }

    public BrightnessReason(int reason) {
        setReason(reason);
    }

    public void set(BrightnessReason other) {
        int r0 = 0;
        if (other != null) goto L5;
        int r1 = 0;
    L6:
        setReason(r1);
        if (other == null) goto L10;
        r0 = other.mModifier;
    L10:
        setModifier(r0);
        if (other != null) goto L13;
        CharSequence r2 = null;
    L14:
        setTag(r2);
        return;
    L13:
        r2 = other.mTag;
        goto L14
    L5:
        r1 = other.mReason;
        goto L6
    }

    public void addModifier(int modifier) {
        setModifier(this.mModifier | modifier);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof BrightnessReason) == true) goto L5;
        return false;
    L5:
        BrightnessReason other = (BrightnessReason) obj;
        if (other.mReason == this.mReason) goto L8;
        return false;
    L8:
        if (other.mModifier == this.mModifier) goto L10;
        return false;
    L10:
        if (other.mTag == null) goto L12;
        String r2 = other.mTag.toString();
    L14:
        if (Objects.equals(r2, this.mTag) == false) goto L20;
        return true;
    L20:
        return false;
    L12:
        r2 = null;
        goto L14
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mReason), Integer.valueOf(this.mModifier), this.mTag});
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int adjustments) {
        StringBuilder sb = new StringBuilder();
        sb.append(reasonToString(this.mReason));
        if (this.mTag == null) goto L5;
        sb.append("(");
        sb.append(this.mTag);
        sb.append(")");
    L5:
        sb.append(" [");
        if ((adjustments & 1) == 0) goto L9;
        sb.append(" temp_adj");
    L9:
        if ((adjustments & 2) == 0) goto L12;
        sb.append(" auto_adj");
    L12:
        if ((this.mModifier & 2) == 0) goto L15;
        sb.append(" low_pwr");
    L15:
        if ((this.mModifier & 1) == 0) goto L18;
        sb.append(" dim");
    L18:
        if ((this.mModifier & 4) == 0) goto L21;
        sb.append(" hdr");
    L21:
        if ((this.mModifier & 8) == 0) goto L24;
        sb.append(" throttled");
    L24:
        if ((this.mModifier & 16) == 0) goto L27;
        sb.append(" lux_lower_bound");
    L27:
        if ((this.mModifier & 32) == 0) goto L30;
        sb.append(" stylus_under_use");
    L30:
        if ((this.mModifier & 4096) == 0) goto L33;
        sb.append(" hdr_exit");
    L33:
        if ((this.mModifier & 8192) == 0) goto L35;
        sb.append(" dim_exit");
    L35:
        int strlen = sb.length();
        if (sb.charAt(strlen - 1) != '[') goto L38;
        sb.setLength(strlen - 2);
    L40:
        return sb.toString();
    L38:
        sb.append(" ]");
        goto L40
    }

    public void setTag(CharSequence tag) {
        this.mTag = tag;
    }

    public CharSequence getTag() {
        return this.mTag;
    }

    public int getReason() {
        return this.mReason;
    }

    public void setReason(int reason) {
        if (reason >= 0) goto L4;
    L7:
        Slog.w(TAG, "brightness reason out of bounds: " + reason);
        return;
    L4:
        if (reason > 15) goto L7;
        this.mReason = reason;
    }

    public int getModifier() {
        return this.mModifier;
    }

    public void setModifier(int modifier) {
        if ((modifier & (-12352)) == 0) goto L5;
        Slog.w(TAG, "brightness modifier out of bounds: 0x" + Integer.toHexString(modifier));
        return;
    L5:
        this.mModifier = modifier;
    }

    private String reasonToString(int reason) {
        switch(reason) {
            case 1: goto L33;
            case 2: goto L31;
            case 3: goto L29;
            case 4: goto L27;
            case 5: goto L25;
            case 6: goto L23;
            case 7: goto L21;
            case 8: goto L19;
            case 9: goto L17;
            case 10: goto L15;
            case 11: goto L13;
            case 12: goto L11;
            case 13: goto L9;
            case 14: goto L7;
            case 15: goto L5;
            default: goto L4;
        };
    L5:
        return "manual_range_transition";
    L7:
        return "doze_enter_full_screen_aod";
    L9:
        return "fake_sleep";
    L11:
        return "doze_manual";
    L13:
        return "offload";
    L15:
        return "follower";
    L17:
        return "screen_off_brightness_sensor";
    L19:
        return "boost";
    L21:
        return "temporary";
    L23:
        return "override";
    L25:
        return "screen_off";
    L27:
        return "automatic";
    L29:
        return "doze_default";
    L31:
        return "doze";
    L33:
        return "manual";
    L4:
        return Integer.toString(reason);
    }
}
