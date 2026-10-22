package com.android.server.textservices;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
final class LocaleUtils {
    LocaleUtils() {
    }

    public static ArrayList<Locale> getSuitableLocalesForSpellChecker(Locale systemLocale) {
        if (systemLocale == null) goto L17;
        String language = systemLocale.getLanguage();
        boolean hasLanguage = !TextUtils.isEmpty(language);
        String country = systemLocale.getCountry();
        boolean hasCountry = !TextUtils.isEmpty(country);
        String variant = systemLocale.getVariant();
        boolean hasVariant = !TextUtils.isEmpty(variant);
        if (hasLanguage == false) goto L8;
        if (hasCountry == false) goto L8;
        if (hasVariant == false) goto L8;
        Locale systemLocaleLanguageCountryVariant = new Locale(language, country, variant);
    L9:
        if (hasLanguage == false) goto L12;
        if (hasCountry == false) goto L12;
        Locale systemLocaleLanguageCountry = new Locale(language, country);
    L13:
        if (hasLanguage == false) goto L15;
        Locale systemLocaleLanguage = new Locale(language);
    L18:
        ArrayList<Locale> locales = new ArrayList();
        if (systemLocaleLanguageCountryVariant == null) goto L22;
        locales.add(systemLocaleLanguageCountryVariant);
    L22:
        if (Locale.ENGLISH.equals(systemLocaleLanguage) == false) goto L32;
        if (systemLocaleLanguageCountry == null) goto L31;
        locales.add(systemLocaleLanguageCountry);
        if (Locale.US.equals(systemLocaleLanguageCountry) == true) goto L28;
        locales.add(Locale.US);
    L28:
        if (Locale.UK.equals(systemLocaleLanguageCountry) == true) goto L30;
        locales.add(Locale.UK);
    L30:
        locales.add(Locale.ENGLISH);
    L37:
        return locales;
    L31:
        locales.add(Locale.ENGLISH);
        locales.add(Locale.US);
        locales.add(Locale.UK);
        goto L37
    L32:
        if (systemLocaleLanguageCountry == null) goto L34;
        locales.add(systemLocaleLanguageCountry);
    L34:
        if (systemLocaleLanguage == null) goto L36;
        locales.add(systemLocaleLanguage);
    L36:
        locales.add(Locale.US);
        locales.add(Locale.UK);
        locales.add(Locale.ENGLISH);
        goto L37
    L15:
        systemLocaleLanguage = null;
    L12:
        systemLocaleLanguageCountry = null;
    L8:
        systemLocaleLanguageCountryVariant = null;
        goto L9
    L17:
        systemLocaleLanguageCountryVariant = null;
        systemLocaleLanguageCountry = null;
        systemLocaleLanguage = null;
        goto L18
    }
}
