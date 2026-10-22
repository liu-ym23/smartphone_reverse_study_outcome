package com.android.contacts.common.compat;

import android.content.Intent;
import android.telecom.TelecomManager;

/* JADX INFO: loaded from: classes.dex */
public class TelecomManagerUtil {
    public TelecomManagerUtil() {
    }

    public static Intent createManageBlockedNumbersIntent(TelecomManager r1) {
        if (CompatUtils.isNCompatible() == true) goto L7;
        return null;
    L7:
        return r1.createManageBlockedNumbersIntent();
    }
}
