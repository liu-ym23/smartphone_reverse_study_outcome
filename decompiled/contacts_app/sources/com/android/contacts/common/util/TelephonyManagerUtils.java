package com.android.contacts.common.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.GlobalProxyLancet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class TelephonyManagerUtils {
    private static final String LOG_TAG = "TelephonyManagerUtils";

    static {
    }

    public static boolean hasVideoCallSubscription(Context r0) {
        return true;
    }

    public TelephonyManagerUtils() {
    }

    public static String getVoiceMailAlphaTag(Context r1) {
        return ((TelephonyManager) r1.getSystemService("phone")).getVoiceMailAlphaTag();
    }

    public static String getCurrentCountryIso(Context r2, Locale r3) {
        String r4 = ((TelephonyManager) r2.getSystemService("phone")).getNetworkCountryIso().toUpperCase();
        if (r4 != null) goto L6;
        String r5 = r3.getCountry();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "No CountryDetector; falling back to countryIso based on locale: " + r5);
        return r5;
    L6:
        return r4;
    }
}
