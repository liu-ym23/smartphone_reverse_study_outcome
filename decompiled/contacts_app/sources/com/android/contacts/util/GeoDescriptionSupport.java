package com.android.contacts.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber;
import com.android.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class GeoDescriptionSupport {
    private static final String TAG = "GeoDescriptionSupport";
    private static volatile GeoDescriptionSupport sGeoDescriptionSupport;
    private Context mContext;
    private PhoneNumberOfflineGeocoder mGeocoder;
    private Locale mLocale;
    private PhoneNumberUtil mPhoneNumberUtil;

    public static GeoDescriptionSupport getInstance(Context r2) {
        if (sGeoDescriptionSupport != null) goto L18;
        monitor-enter(GeoDescriptionSupport.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (sGeoDescriptionSupport != null) goto L12;
        if (r2 != null) goto L10;
        Context r3 = ContactsApplication.getInstance();     // Catch: Throwable -> L14
    L11:
        sGeoDescriptionSupport = new GeoDescriptionSupport(r3);     // Catch: Throwable -> L14
        goto L12
    L10:
        r3 = r2.getApplicationContext();     // Catch: Throwable -> L14
    L12:
        monitor-exit(GeoDescriptionSupport.class);     // Catch: Throwable -> L14
    L18:
        return sGeoDescriptionSupport;
    }

    private GeoDescriptionSupport(Context r2) {
        this.mContext = r2;
        this.mPhoneNumberUtil = PhoneNumberUtil.getInstance();
        this.mGeocoder = PhoneNumberOfflineGeocoder.getInstance();
        this.mLocale = r2.getResources().getConfiguration().locale;
    }

    public String getGeoDescription(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return "";
    L5:
        String r4 = getCurrentCountryIso(this.mContext, this.mLocale);
        Phonenumber.PhoneNumber r6 = null;
    L13:
        e = move-exception;
        e.printStackTrace();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getGeoDescription: NumberParseException for incoming number '" + r9 + "'");
    L15:
        if (r6 == null) goto L20;
        String r8 = this.mGeocoder.getDescriptionForNumber(r6, this.mLocale);
        if (ContactsUtils.DEBUG == false) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "- got description: '" + r8 + "'");
    L19:
        return r8;
    L20:
        return "";
    L7:
        if (ContactsUtils.DEBUG == false) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "parsing '" + r9 + "' for countryIso '" + r4 + "'...");     // Catch: NumberParseException -> L13
    L9:
        r6 = this.mPhoneNumberUtil.parse(r9, r4);     // Catch: NumberParseException -> L13
        if (ContactsUtils.DEBUG == false) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "- parsed number: " + r6);     // Catch: NumberParseException -> L13
        goto L15
    }

    private static String getCurrentCountryIso(Context r1, Locale r2) {
        String r3 = ((TelephonyManager) r1.getSystemService("phone")).getNetworkCountryIso().toUpperCase();
        if (TextUtils.isEmpty(r3) == false) goto L6;
        String r4 = r2.getCountry();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "No CountryDetector; falling back to countryIso based on locale: " + r4);
        return r4;
    L6:
        return r3;
    }
}
