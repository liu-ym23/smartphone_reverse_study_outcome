package com.google.i18n.phonenumbers.prefixmapper;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class PhonePrefixMap implements Externalizable {
    private static final Logger logger = null;
    private PhonePrefixMapStorageStrategy phonePrefixMapStorage;
    private final PhoneNumberUtil phoneUtil;

    static {
        logger = Logger.getLogger(PhonePrefixMap.class.getName());
    }

    PhonePrefixMapStorageStrategy getPhonePrefixMapStorage() {
        return this.phonePrefixMapStorage;
    }

    public PhonePrefixMap() {
        this.phoneUtil = PhoneNumberUtil.getInstance();
    }

    private static int getSizeOfPhonePrefixMapStorage(PhonePrefixMapStorageStrategy r1, SortedMap<Integer, String> r2) throws IOException {
        r1.readFromSortedMap(r2);
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();
        ObjectOutputStream r0 = new ObjectOutputStream(r3);
        r1.writeExternal(r0);
        r0.flush();
        int r4 = r3.size();
        r0.close();
        return r4;
    }

    private PhonePrefixMapStorageStrategy createDefaultMapStorage() {
        return new DefaultMapStorage();
    }

    private PhonePrefixMapStorageStrategy createFlyweightMapStorage() {
        return new FlyweightMapStorage();
    }

    PhonePrefixMapStorageStrategy getSmallerMapStorage(SortedMap<Integer, String> r4) {
        PhonePrefixMapStorageStrategy r0 = createFlyweightMapStorage();     // Catch: IOException -> L7
        int r1 = getSizeOfPhonePrefixMapStorage(r0, r4);     // Catch: IOException -> L7
        PhonePrefixMapStorageStrategy r2 = createDefaultMapStorage();     // Catch: IOException -> L7
        if (r1 >= getSizeOfPhonePrefixMapStorage(r2, r4)) goto L6;
        return r0;
    L6:
        return r2;
    L7:
        e = move-exception;
        logger.severe(e.getMessage());
        return createFlyweightMapStorage();
    }

    public void readPhonePrefixMap(SortedMap<Integer, String> r1) {
        this.phonePrefixMapStorage = getSmallerMapStorage(r1);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r2) throws IOException {
        if (r2.readBoolean() == false) goto L5;
        this.phonePrefixMapStorage = new FlyweightMapStorage();
    L6:
        this.phonePrefixMapStorage.readExternal(r2);
        return;
    L5:
        this.phonePrefixMapStorage = new DefaultMapStorage();
        goto L6
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r2) throws IOException {
        r2.writeBoolean(this.phonePrefixMapStorage instanceof FlyweightMapStorage);
        this.phonePrefixMapStorage.writeExternal(r2);
    }

    String lookup(long r9) {
        int r0 = this.phonePrefixMapStorage.getNumOfEntries();
        if (r0 != 0) goto L5;
        return null;
    L5:
        int r1 = r0 - 1;
        SortedSet r2 = this.phonePrefixMapStorage.getPossibleLengths();
    L7:
        if (r2.size() <= 0) goto L19;
        Integer r3 = (Integer) r2.last();
        String r4 = String.valueOf(r9);
        if (r4.length() <= r3.intValue()) goto L11;
        r9 = Long.parseLong(r4.substring(0, r3.intValue()));
    L11:
        r1 = binarySearch(0, r1, r9);
        if (r1 < 0) goto L13;
        if (r9 == this.phonePrefixMapStorage.getPrefix(r1)) goto L17;
        r2 = r2.headSet(r3);
        goto L7
    L17:
        return this.phonePrefixMapStorage.getDescription(r1);
    L13:
        return null;
    L19:
        return null;
    }

    public String lookup(Phonenumber.PhoneNumber r3) {
        return lookup(Long.parseLong(r3.getCountryCode() + this.phoneUtil.getNationalSignificantNumber(r3)));
    }

    private int binarySearch(int r4, int r5, long r6) {
        int r0 = 0;
    L3:
        if (r4 > r5) goto L10;
        r0 = (r4 + r5) >>> 1;
        long r1 = this.phonePrefixMapStorage.getPrefix(r0);
        if (r1 == r6) goto L6;
        if (r1 > r6) goto L8;
        r4 = r0 + 1;
        goto L3
    L8:
        r0 = r0 - 1;
        r5 = r0;
        goto L3
    L6:
        return r0;
    L10:
        return r0;
    }

    public String toString() {
        return this.phonePrefixMapStorage.toString();
    }
}
