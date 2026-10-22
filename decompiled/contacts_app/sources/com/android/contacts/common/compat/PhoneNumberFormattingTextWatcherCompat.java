package com.android.contacts.common.compat;

import android.telephony.PhoneNumberFormattingTextWatcher;

/* JADX INFO: loaded from: classes.dex */
public class PhoneNumberFormattingTextWatcherCompat {
    public PhoneNumberFormattingTextWatcherCompat() {
    }

    public static PhoneNumberFormattingTextWatcher newInstance(String r1) {
        if (CompatUtils.isLollipopCompatible() == false) goto L7;
        return new PhoneNumberFormattingTextWatcher(r1);
    L7:
        return new PhoneNumberFormattingTextWatcher();
    }
}
