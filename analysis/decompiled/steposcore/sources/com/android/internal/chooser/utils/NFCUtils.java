package com.android.internal.chooser.utils;

import android.content.Intent;

/* loaded from: classes.dex */
public class NFCUtils {
    public static boolean isNfcIntent(Intent intent) {
        return intent != null && "android.nfc.action.TECH_DISCOVERED".equals(intent.getAction());
    }
}
