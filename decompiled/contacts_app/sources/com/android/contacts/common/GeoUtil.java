package com.android.contacts.common;

import android.content.Context;
import com.android.contacts.common.location.CountryDetector;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

/* JADX INFO: loaded from: classes.dex */
public class GeoUtil {
    public GeoUtil() {
    }

    public static String getCurrentCountryIso(Context r0) {
        return CountryDetector.getInstance(r0).getCurrentCountryIso();
    }

    public static String getGeocodedLocationFor(Context r3, String r4) {
        PhoneNumberOfflineGeocoder r0 = PhoneNumberOfflineGeocoder.getInstance();
        PhoneNumberUtil r1 = PhoneNumberUtil.getInstance();
        return r0.getDescriptionForNumber(r1.parse(r4, getCurrentCountryIso(r3)), r3.getResources().getConfiguration().locale);
    L5:
        return null;
    }
}
