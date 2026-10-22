package com.android.server.people.data;

import android.content.Context;
import android.location.Country;
import android.location.CountryDetector;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class Utils {
    static String getCurrentCountryIso(Context context) {
        String countryIso = null;
        CountryDetector detector = (CountryDetector) context.getSystemService("country_detector");
        if (detector == null) goto L7;
        Country country = detector.detectCountry();
        if (country == null) goto L7;
        countryIso = country.getCountryIso();
    L7:
        if (countryIso == null) goto L9;
        return countryIso;
    L9:
        return Locale.getDefault().getCountry();
    }

    private Utils() {
    }
}
