package com.android.contacts.common.compat;

import android.net.Uri;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public class TelephonyManagerSdkCompat {
    public TelephonyManagerSdkCompat() {
    }

    public static Uri getVoicemailRingtoneUri(TelephonyManager r1, PhoneAccountHandle r2) {
        if (CompatUtils.isNCompatible() == true) goto L7;
        return null;
    L7:
        return r1.getVoicemailRingtoneUri(r2);
    }

    public static boolean isVoicemailVibrationEnabled(TelephonyManager r1, PhoneAccountHandle r2) {
        if (CompatUtils.isNCompatible() == true) goto L7;
        return false;
    L7:
        return r1.isVoicemailVibrationEnabled(r2);
    }
}
