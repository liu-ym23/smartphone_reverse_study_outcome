package com.android.contacts.common.compat;

import android.net.Uri;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;
import obric.util.Utils;

/* JADX INFO: loaded from: classes.dex */
public class TelephonyManagerCompat {
    public static final String TELEPHONY_MANAGER_CLASS = "android.telephony.TelephonyManager";

    public TelephonyManagerCompat() {
    }

    public static boolean isVoiceCapable(TelephonyManager r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (CompatUtils.isLollipopMr1Compatible() == true) goto L16;
        if (CompatUtils.isMethodAvailable(TELEPHONY_MANAGER_CLASS, "isVoiceCapable", new Class[0]) == true) goto L16;
        int r5 = r4.getPhoneType();
        if (r5 == 2) goto L14;
        if (r5 == 1) goto L14;
        return false;
    L14:
        return true;
    L16:
        return r4.isVoiceCapable();
    }

    public static int getPhoneCount(TelephonyManager r4) {
        if (r4 != null) goto L6;
        return 1;
    L6:
        if (CompatUtils.isMarshmallowCompatible() == true) goto L12;
        if (CompatUtils.isMethodAvailable(TELEPHONY_MANAGER_CLASS, "getPhoneCount", new Class[0]) == true) goto L12;
        return 1;
    L12:
        return r4.getPhoneCount();
    }

    public static String getDeviceId(TelephonyManager r4, int r5) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (CompatUtils.isMarshmallowCompatible() == true) goto L12;
        if (CompatUtils.isMethodAvailable(TELEPHONY_MANAGER_CLASS, Utils.METHOD_GET_DEVICE_ID, new Class[]{Integer.class}) == true) goto L12;
        return null;
    L12:
        return r4.getDeviceId(r5);
    }

    public static boolean isTtyModeSupported(TelephonyManager r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (CompatUtils.isMarshmallowCompatible() == true) goto L12;
        if (CompatUtils.isMethodAvailable(TELEPHONY_MANAGER_CLASS, "isTtyModeSupported", new Class[0]) == true) goto L12;
        return false;
    L12:
        return r4.isTtyModeSupported();
    }

    public static boolean isHearingAidCompatibilitySupported(TelephonyManager r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (CompatUtils.isMarshmallowCompatible() == true) goto L12;
        if (CompatUtils.isMethodAvailable(TELEPHONY_MANAGER_CLASS, "isHearingAidCompatibilitySupported", new Class[0]) == true) goto L12;
        return false;
    L12:
        return r4.isHearingAidCompatibilitySupported();
    }

    public static Uri getVoicemailRingtoneUri(TelephonyManager r1, PhoneAccountHandle r2) {
        if (CompatUtils.isNCompatible() == true) goto L7;
        return null;
    L7:
        return TelephonyManagerSdkCompat.getVoicemailRingtoneUri(r1, r2);
    }

    public static boolean isVoicemailVibrationEnabled(TelephonyManager r1, PhoneAccountHandle r2) {
        if (CompatUtils.isNCompatible() == true) goto L7;
        return true;
    L7:
        return TelephonyManagerSdkCompat.isVoicemailVibrationEnabled(r1, r2);
    }
}
