package com.google.i18n.phonenumbers.prefixmapper;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class PrefixTimeZonesMap implements Externalizable {
    private static final String RAW_STRING_TIMEZONES_SEPARATOR = "&";
    private final PhonePrefixMap phonePrefixMap;

    public PrefixTimeZonesMap() {
        this.phonePrefixMap = new PhonePrefixMap();
    }

    public void readPrefixTimeZonesMap(SortedMap<Integer, String> r1) {
        this.phonePrefixMap.readPhonePrefixMap(r1);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r1) throws IOException {
        this.phonePrefixMap.writeExternal(r1);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r1) throws IOException {
        this.phonePrefixMap.readExternal(r1);
    }

    private List<String> lookupTimeZonesForNumber(long r2) {
        String r3 = this.phonePrefixMap.lookup(r2);
        if (r3 != null) goto L7;
        return new LinkedList();
    L7:
        return tokenizeRawOutputString(r3);
    }

    public List<String> lookupTimeZonesForNumber(Phonenumber.PhoneNumber r3) {
        return lookupTimeZonesForNumber(Long.parseLong(r3.getCountryCode() + PhoneNumberUtil.getInstance().getNationalSignificantNumber(r3)));
    }

    public List<String> lookupCountryLevelTimeZonesForNumber(Phonenumber.PhoneNumber r3) {
        return lookupTimeZonesForNumber(r3.getCountryCode());
    }

    private List<String> tokenizeRawOutputString(String r2) {
        StringTokenizer r1 = new StringTokenizer(r2, RAW_STRING_TIMEZONES_SEPARATOR);
        LinkedList r3 = new LinkedList();
    L4:
        if (r1.hasMoreTokens() == false) goto L6;
        r3.add(r1.nextToken());
        goto L4
    L6:
        return r3;
    }

    public String toString() {
        return this.phonePrefixMap.toString();
    }
}
