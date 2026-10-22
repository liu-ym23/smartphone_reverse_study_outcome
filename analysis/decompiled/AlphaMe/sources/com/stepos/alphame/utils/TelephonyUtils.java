package com.stepos.alphame.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/* loaded from: classes.dex */
public class TelephonyUtils {
    public static String getNetworkCountryIso(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkCountryIso();
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }
}
