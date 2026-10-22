package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.prefixmapper.PrefixTimeZonesMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneNumberToTimeZonesMapper {
    private static final String MAPPING_DATA_DIRECTORY = "/com/google/i18n/phonenumbers/timezones/data/";
    private static final String MAPPING_DATA_FILE_NAME = "map_data";
    private static final String UNKNOWN_TIMEZONE = "Etc/Unknown";
    static final List<String> UNKNOWN_TIME_ZONE_LIST = null;
    private static final Logger logger = null;
    private PrefixTimeZonesMap prefixTimeZonesMap;

    /* JADX INFO: renamed from: com.google.i18n.phonenumbers.PhoneNumberToTimeZonesMapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final PhoneNumberToTimeZonesMapper INSTANCE = null;

        private LazyHolder() {
        }

        static /* synthetic */ PhoneNumberToTimeZonesMapper access$200() {
            return INSTANCE;
        }

        static {
            INSTANCE = new PhoneNumberToTimeZonesMapper(PhoneNumberToTimeZonesMapper.access$000("/com/google/i18n/phonenumbers/timezones/data/map_data"), null);
        }
    }

    public static String getUnknownTimeZone() {
        return UNKNOWN_TIMEZONE;
    }

    /* synthetic */ PhoneNumberToTimeZonesMapper(PrefixTimeZonesMap r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ PrefixTimeZonesMap access$000(String r0) {
        return loadPrefixTimeZonesMapFromFile(r0);
    }

    static {
        ArrayList r0 = new ArrayList(1);
        UNKNOWN_TIME_ZONE_LIST = r0;
        r0.add(UNKNOWN_TIMEZONE);
        logger = Logger.getLogger(PhoneNumberToTimeZonesMapper.class.getName());
    }

    PhoneNumberToTimeZonesMapper(String r2) {
        this.prefixTimeZonesMap = null;
        this.prefixTimeZonesMap = loadPrefixTimeZonesMapFromFile(r2 + MAPPING_DATA_FILE_NAME);
    }

    private PhoneNumberToTimeZonesMapper(PrefixTimeZonesMap r1) {
        this.prefixTimeZonesMap = r1;
    }

    private static PrefixTimeZonesMap loadPrefixTimeZonesMapFromFile(String r4) {
        InputStream r5 = PhoneNumberToTimeZonesMapper.class.getResourceAsStream(r4);
        PrefixTimeZonesMap r0 = new PrefixTimeZonesMap();
        ObjectInputStream r1 = null;
        ObjectInputStream r2 = new ObjectInputStream(r5);     // Catch: Throwable -> L10 IOException -> L12
        r0.readExternal(r2);     // Catch: Throwable -> L6 IOException -> L8
        close(r2);
    L15:
        return r0;
    L8:
        e = e;
        r1 = r2;
    L13:
        logger.log(Level.WARNING, e.toString());     // Catch: Throwable -> L10
        close(r1);
    L6:
        th = th;
        r1 = r2;
    L16:
        close(r1);
        throw th;
    L12:
        e = e;
    L10:
        th = th;
        goto L16
    }

    private static void close(InputStream r2) {
        if (r2 == null) goto L10;
        r2.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        logger.log(Level.WARNING, e.toString());
        return;
    }

    public static synchronized PhoneNumberToTimeZonesMapper getInstance() {
        monitor-enter(PhoneNumberToTimeZonesMapper.class);
        PhoneNumberToTimeZonesMapper r1 = LazyHolder.access$200();     // Catch: Throwable -> L7
        monitor-exit(PhoneNumberToTimeZonesMapper.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<String> getTimeZonesForGeographicalNumber(Phonenumber.PhoneNumber r1) {
        return getTimeZonesForGeocodableNumber(r1);
    }

    public List<String> getTimeZonesForNumber(Phonenumber.PhoneNumber r4) {
        PhoneNumberUtil.PhoneNumberType r0 = PhoneNumberUtil.getInstance().getNumberType(r4);
        if (r0 != PhoneNumberUtil.PhoneNumberType.UNKNOWN) goto L7;
        return UNKNOWN_TIME_ZONE_LIST;
    L7:
        if (PhoneNumberUtil.getInstance().isNumberGeographical(r0, r4.getCountryCode()) == true) goto L11;
        return getCountryLevelTimeZonesforNumber(r4);
    L11:
        return getTimeZonesForGeographicalNumber(r4);
    }

    private List<String> getTimeZonesForGeocodableNumber(Phonenumber.PhoneNumber r1) {
        List<String> r0 = this.prefixTimeZonesMap.lookupTimeZonesForNumber(r1);
        if (r0.isEmpty() == false) goto L6;
        r0 = UNKNOWN_TIME_ZONE_LIST;
    L6:
        return Collections.unmodifiableList(r0);
    }

    private List<String> getCountryLevelTimeZonesforNumber(Phonenumber.PhoneNumber r1) {
        List<String> r0 = this.prefixTimeZonesMap.lookupCountryLevelTimeZonesForNumber(r1);
        if (r0.isEmpty() == false) goto L6;
        r0 = UNKNOWN_TIME_ZONE_LIST;
    L6:
        return Collections.unmodifiableList(r0);
    }
}
