package com.google.i18n.phonenumbers;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class MetadataManager {
    private static final String ALTERNATE_FORMATS_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/PhoneNumberAlternateFormatsProto";
    static final MetadataLoader DEFAULT_METADATA_LOADER = null;
    static final String MULTI_FILE_PHONE_NUMBER_METADATA_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto";
    private static final String SHORT_NUMBER_METADATA_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/ShortNumberMetadataProto";
    static final String SINGLE_FILE_PHONE_NUMBER_METADATA_FILE_NAME = "/com/google/i18n/phonenumbers/data/SingleFilePhoneNumberMetadataProto";
    private static final Set<Integer> alternateFormatsCountryCodes = null;
    private static final ConcurrentHashMap<Integer, Phonemetadata.PhoneMetadata> alternateFormatsMap = null;
    private static final Logger logger = null;
    private static final ConcurrentHashMap<String, Phonemetadata.PhoneMetadata> shortNumberMetadataMap = null;
    private static final Set<String> shortNumberMetadataRegionCodes = null;

    static class SingleFileMetadataMaps {
        private final Map<Integer, Phonemetadata.PhoneMetadata> countryCallingCodeToMetadata;
        private final Map<String, Phonemetadata.PhoneMetadata> regionCodeToMetadata;

        static SingleFileMetadataMaps load(String r4, MetadataLoader r5) {
            List r6 = MetadataManager.access$000(r4, r5);
            HashMap r7 = new HashMap();
            HashMap r0 = new HashMap();
            Iterator r8 = r6.iterator();
        L4:
            if (r8.hasNext() == false) goto L10;
            Phonemetadata.PhoneMetadata r1 = (Phonemetadata.PhoneMetadata) r8.next();
            String r2 = r1.getId();
            if (PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY.equals(r2) == true) goto L7;
            r7.put(r2, r1);
            goto L4
        L7:
            r0.put(Integer.valueOf(r1.getCountryCode()), r1);
            goto L4
        L10:
            return new SingleFileMetadataMaps(r7, r0);
        }

        private SingleFileMetadataMaps(Map<String, Phonemetadata.PhoneMetadata> r1, Map<Integer, Phonemetadata.PhoneMetadata> r2) {
            this.regionCodeToMetadata = Collections.unmodifiableMap(r1);
            this.countryCallingCodeToMetadata = Collections.unmodifiableMap(r2);
        }

        Phonemetadata.PhoneMetadata get(String r1) {
            return this.regionCodeToMetadata.get(r1);
        }

        Phonemetadata.PhoneMetadata get(int r1) {
            return this.countryCallingCodeToMetadata.get(Integer.valueOf(r1));
        }
    }

    static /* synthetic */ List access$000(String r0, MetadataLoader r1) {
        return getMetadataFromSingleFileName(r0, r1);
    }

    static {
        DEFAULT_METADATA_LOADER = new AnonymousClass1();
        logger = Logger.getLogger(MetadataManager.class.getName());
        alternateFormatsMap = new ConcurrentHashMap();
        shortNumberMetadataMap = new ConcurrentHashMap();
        alternateFormatsCountryCodes = AlternateFormatsCountryCodeSet.getCountryCodeSet();
        shortNumberMetadataRegionCodes = ShortNumbersRegionCodeSet.getRegionCodeSet();
    }

    private MetadataManager() {
    }

    static Phonemetadata.PhoneMetadata getAlternateFormatsForCountry(int r3) {
        if (alternateFormatsCountryCodes.contains(Integer.valueOf(r3)) == true) goto L7;
        return null;
    L7:
        return getMetadataFromMultiFilePrefix(Integer.valueOf(r3), alternateFormatsMap, ALTERNATE_FORMATS_FILE_PREFIX, DEFAULT_METADATA_LOADER);
    }

    static Phonemetadata.PhoneMetadata getShortNumberMetadataForRegion(String r3) {
        if (shortNumberMetadataRegionCodes.contains(r3) == true) goto L7;
        return null;
    L7:
        return getMetadataFromMultiFilePrefix(r3, shortNumberMetadataMap, SHORT_NUMBER_METADATA_FILE_PREFIX, DEFAULT_METADATA_LOADER);
    }

    static Set<String> getSupportedShortNumberRegions() {
        return Collections.unmodifiableSet(shortNumberMetadataRegionCodes);
    }

    static <T> Phonemetadata.PhoneMetadata getMetadataFromMultiFilePrefix(T r4, ConcurrentHashMap<T, Phonemetadata.PhoneMetadata> r5, String r6, MetadataLoader r7) {
        Phonemetadata.PhoneMetadata r0 = r5.get(r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r8 = r6 + "_" + r4;
        List<Phonemetadata.PhoneMetadata> r9 = getMetadataFromSingleFileName(r8, r7);
        if (r9.size() <= 1) goto L8;
        logger.log(Level.WARNING, "more than one metadata in file " + r8);
    L8:
        Phonemetadata.PhoneMetadata r10 = r9.get(0);
        Phonemetadata.PhoneMetadata r11 = r5.putIfAbsent(r4, r10);
        if (r11 != null) goto L11;
        return r10;
    L11:
        return r11;
    }

    static SingleFileMetadataMaps getSingleFileMetadataMaps(AtomicReference<SingleFileMetadataMaps> r1, String r2, MetadataLoader r3) {
        SingleFileMetadataMaps r0 = r1.get();
        if (r0 == null) goto L5;
        return r0;
    L5:
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r1, null, SingleFileMetadataMaps.load(r2, r3));
        return r1.get();
    }

    private static List<Phonemetadata.PhoneMetadata> getMetadataFromSingleFileName(String r2, MetadataLoader r3) {
        InputStream r4 = r3.loadMetadata(r2);
        if (r4 == null) goto L10;
        List<Phonemetadata.PhoneMetadata> r5 = loadMetadataAndCloseInput(r4).getMetadataList();
        if (r5.size() == 0) goto L8;
        return r5;
    L8:
        throw new IllegalStateException("empty metadata: " + r2);
    L10:
        throw new IllegalStateException("missing metadata: " + r2);
    }

    private static Phonemetadata.PhoneMetadataCollection loadMetadataAndCloseInput(InputStream r5) {
        ObjectInputStream r2 = null;
        ObjectInputStream r3 = new ObjectInputStream(r5);     // Catch: Throwable -> L16 IOException -> L18
        Phonemetadata.PhoneMetadataCollection r4 = new Phonemetadata.PhoneMetadataCollection();     // Catch: Throwable -> L14
        r4.readExternal(r3);     // Catch: IOException -> L11 Throwable -> L14
        r3.close();     // Catch: IOException -> L8
    L10:
        return r4;
    L8:
        e = move-exception;
        logger.log(Level.WARNING, "error closing input stream (ignored)", e);
        goto L10
    L11:
        e = move-exception;
        throw new RuntimeException("cannot load/parse metadata", e);     // Catch: Throwable -> L14
    L14:
        th = th;
        r2 = r3;
    L36:
        if (r2 == null) goto L23;
        r2.close();     // Catch: IOException -> L25
    L35:
    L27:
        throw th;
    L23:
        r5.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        logger.log(Level.WARNING, "error closing input stream (ignored)", e);
        goto L27
    L16:
        th = th;
    L18:
        e = move-exception;
        throw new RuntimeException("cannot load/parse metadata", e);     // Catch: Throwable -> L16
    }
}
