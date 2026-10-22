package com.google.i18n.phonenumbers;

/* JADX INFO: loaded from: classes2.dex */
interface MetadataSource {
    Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int r1);

    Phonemetadata.PhoneMetadata getMetadataForRegion(String r1);
}
