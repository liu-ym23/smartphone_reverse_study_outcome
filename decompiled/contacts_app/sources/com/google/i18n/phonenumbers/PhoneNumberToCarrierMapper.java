package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.prefixmapper.PrefixFileReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneNumberToCarrierMapper {
    private static final String MAPPING_DATA_DIRECTORY = "/com/google/i18n/phonenumbers/carrier/data/";
    private static PhoneNumberToCarrierMapper instance;
    private final PhoneNumberUtil phoneUtil;
    private PrefixFileReader prefixFileReader;

    static {
    }

    PhoneNumberToCarrierMapper(String r2) {
        this.prefixFileReader = null;
        this.phoneUtil = PhoneNumberUtil.getInstance();
        this.prefixFileReader = new PrefixFileReader(r2);
    }

    public static synchronized PhoneNumberToCarrierMapper getInstance() {
        monitor-enter(PhoneNumberToCarrierMapper.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L7;
        instance = new PhoneNumberToCarrierMapper(MAPPING_DATA_DIRECTORY);     // Catch: Throwable -> L10
    L7:
        PhoneNumberToCarrierMapper r1 = instance;     // Catch: Throwable -> L10
        monitor-exit(PhoneNumberToCarrierMapper.class);
        return r1;
    }

    public String getNameForValidNumber(Phonenumber.PhoneNumber r3, Locale r4) {
        String r0 = r4.getLanguage();
        String r5 = r4.getCountry();
        return this.prefixFileReader.getDescriptionForNumber(r3, r0, "", r5);
    }

    public String getNameForNumber(Phonenumber.PhoneNumber r2, Locale r3) {
        if (isMobile(this.phoneUtil.getNumberType(r2)) == true) goto L5;
        return "";
    L5:
        return getNameForValidNumber(r2, r3);
    }

    public String getSafeDisplayName(Phonenumber.PhoneNumber r3, Locale r4) {
        PhoneNumberUtil r0 = this.phoneUtil;
        if (r0.isMobileNumberPortableRegion(r0.getRegionCodeForNumber(r3)) == false) goto L7;
        return "";
    L7:
        return getNameForNumber(r3, r4);
    }

    private boolean isMobile(PhoneNumberUtil.PhoneNumberType r1) {
        if (r1 != PhoneNumberUtil.PhoneNumberType.MOBILE) goto L5;
    L10:
        return true;
    L5:
        if (r1 == PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE) goto L10;
        if (r1 == PhoneNumberUtil.PhoneNumberType.PAGER) goto L10;
        return false;
    }
}
