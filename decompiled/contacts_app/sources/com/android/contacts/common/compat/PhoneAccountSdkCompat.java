package com.android.contacts.common.compat;

import android.os.Bundle;
import android.telecom.PhoneAccount;

/* JADX INFO: loaded from: classes.dex */
public class PhoneAccountSdkCompat {
    public static final int CAPABILITY_VIDEO_CALLING_RELIES_ON_PRESENCE = 256;
    public static final String EXTRA_CALL_SUBJECT_CHARACTER_ENCODING = "android.telecom.extra.CALL_SUBJECT_CHARACTER_ENCODING";
    public static final String EXTRA_CALL_SUBJECT_MAX_LENGTH = "android.telecom.extra.CALL_SUBJECT_MAX_LENGTH";
    private static final String TAG = "PhoneAccountSdkCompat";

    public PhoneAccountSdkCompat() {
    }

    public static Bundle getExtras(PhoneAccount r1) {
        if (CompatUtils.isNCompatible() == true) goto L7;
        return null;
    L7:
        return r1.getExtras();
    }
}
