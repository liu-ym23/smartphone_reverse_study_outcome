package com.google.i18n.phonenumbers.geocoding;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.prefixmapper.PrefixFileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneNumberOfflineGeocoder {
    private static final String MAPPING_DATA_DIRECTORY = "/com/google/i18n/phonenumbers/geocoding/data/";
    private static PhoneNumberOfflineGeocoder instance;
    private final PhoneNumberUtil phoneUtil;
    private PrefixFileReader prefixFileReader;

    static {
    }

    PhoneNumberOfflineGeocoder(String r2) {
        this.prefixFileReader = null;
        this.phoneUtil = PhoneNumberUtil.getInstance();
        this.prefixFileReader = new PrefixFileReader(r2);
    }

    public static synchronized PhoneNumberOfflineGeocoder getInstance() {
        monitor-enter(PhoneNumberOfflineGeocoder.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L7;
        instance = new PhoneNumberOfflineGeocoder(MAPPING_DATA_DIRECTORY);     // Catch: Throwable -> L10
    L7:
        PhoneNumberOfflineGeocoder r1 = instance;     // Catch: Throwable -> L10
        monitor-exit(PhoneNumberOfflineGeocoder.class);
        return r1;
    }

    private String getCountryNameForNumber(Phonenumber.PhoneNumber r6, Locale r7) {
        List<String> r0 = this.phoneUtil.getRegionCodesForCountryCode(r6.getCountryCode());
        if (r0.size() == 1) goto L5;
        Iterator<String> r1 = r0.iterator();
        String r2 = "ZZ";
    L8:
        if (r1.hasNext() == false) goto L17;
        String r3 = r1.next();
        if (this.phoneUtil.isValidNumberForRegion(r6, r3) == false) goto L8;
        if (r2.equals("ZZ") == false) goto L13;
        r2 = r3;
        goto L8
    L13:
        return "";
    L17:
        return getRegionDisplayName(r2, r7);
    L5:
        return getRegionDisplayName(r0.get(0), r7);
    }

    private String getRegionDisplayName(String r2, Locale r3) {
        if (r2 != null) goto L5;
        return "";
    L5:
        if (r2.equals("ZZ") == false) goto L7;
        return "";
    L7:
        if (r2.equals(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY) == false) goto L10;
        return "";
    L10:
        return new Locale("", r2).getDisplayCountry(r3);
    }

    public String getDescriptionForValidNumber(Phonenumber.PhoneNumber r7, Locale r8) {
        String r0 = r8.getLanguage();
        String r1 = r8.getCountry();
        String r2 = PhoneNumberUtil.getCountryMobileToken(r7.getCountryCode());
        String r3 = this.phoneUtil.getNationalSignificantNumber(r7);
        if (r2.equals("") == false) goto L5;
    L11:
        String r4 = this.prefixFileReader.getDescriptionForNumber(r7, r0, "", r1);
    L13:
        if (r4.length() <= 0) goto L16;
        return r4;
    L16:
        return getCountryNameForNumber(r7, r8);
    L5:
        if (r3.startsWith(r2) == false) goto L11;
        String r5 = r3.substring(r2.length());
        String r6 = this.phoneUtil.getRegionCodeForCountryCode(r7.getCountryCode());
        Phonenumber.PhoneNumber r9 = this.phoneUtil.parse(r5, r6);     // Catch: NumberParseException -> L9
    L10:
        r4 = this.prefixFileReader.getDescriptionForNumber(r9, r0, "", r1);
    L9:
        r9 = r7;
        goto L10
    }

    public String getDescriptionForValidNumber(Phonenumber.PhoneNumber r2, Locale r3, String r4) {
        String r0 = this.phoneUtil.getRegionCodeForNumber(r2);
        if (r4.equals(r0) == false) goto L7;
        return getDescriptionForValidNumber(r2, r3);
    L7:
        return getRegionDisplayName(r0, r3);
    }

    public String getDescriptionForNumber(Phonenumber.PhoneNumber r4, Locale r5) {
        PhoneNumberUtil.PhoneNumberType r0 = this.phoneUtil.getNumberType(r4);
        if (r0 != PhoneNumberUtil.PhoneNumberType.UNKNOWN) goto L7;
        return "";
    L7:
        if (this.phoneUtil.isNumberGeographical(r0, r4.getCountryCode()) == true) goto L11;
        return getCountryNameForNumber(r4, r5);
    L11:
        return getDescriptionForValidNumber(r4, r5);
    }

    public String getDescriptionForNumber(Phonenumber.PhoneNumber r4, Locale r5, String r6) {
        PhoneNumberUtil.PhoneNumberType r0 = this.phoneUtil.getNumberType(r4);
        if (r0 != PhoneNumberUtil.PhoneNumberType.UNKNOWN) goto L7;
        return "";
    L7:
        if (this.phoneUtil.isNumberGeographical(r0, r4.getCountryCode()) == true) goto L11;
        return getCountryNameForNumber(r4, r5);
    L11:
        return getDescriptionForValidNumber(r4, r5, r6);
    }
}
