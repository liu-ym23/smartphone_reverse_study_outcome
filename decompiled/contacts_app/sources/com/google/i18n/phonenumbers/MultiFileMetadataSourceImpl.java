package com.google.i18n.phonenumbers;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
final class MultiFileMetadataSourceImpl implements MetadataSource {
    private final ConcurrentHashMap<String, Phonemetadata.PhoneMetadata> geographicalRegions;
    private final MetadataLoader metadataLoader;
    private final ConcurrentHashMap<Integer, Phonemetadata.PhoneMetadata> nonGeographicalRegions;
    private final String phoneNumberMetadataFilePrefix;

    MultiFileMetadataSourceImpl(String r2, MetadataLoader r3) {
        this.geographicalRegions = new ConcurrentHashMap();
        this.nonGeographicalRegions = new ConcurrentHashMap();
        this.phoneNumberMetadataFilePrefix = r2;
        this.metadataLoader = r3;
    }

    MultiFileMetadataSourceImpl(MetadataLoader r2) {
        this("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", r2);
    }

    @Override // com.google.i18n.phonenumbers.MetadataSource
    public Phonemetadata.PhoneMetadata getMetadataForRegion(String r3) {
        return MetadataManager.getMetadataFromMultiFilePrefix(r3, this.geographicalRegions, this.phoneNumberMetadataFilePrefix, this.metadataLoader);
    }

    @Override // com.google.i18n.phonenumbers.MetadataSource
    public Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int r3) {
        if (isNonGeographical(r3) == true) goto L7;
        return null;
    L7:
        return MetadataManager.getMetadataFromMultiFilePrefix(Integer.valueOf(r3), this.nonGeographicalRegions, this.phoneNumberMetadataFilePrefix, this.metadataLoader);
    }

    private boolean isNonGeographical(int r3) {
        List<String> r2 = CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap().get(Integer.valueOf(r3));
        if (r2.size() == 1) goto L5;
        return false;
    L5:
        if (PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY.equals(r2.get(0)) == true) goto L7;
        return false;
    L7:
        return true;
    }
}
