package com.google.i18n.phonenumbers.prefixmapper;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
class DefaultMapStorage extends PhonePrefixMapStorageStrategy {
    private String[] descriptions;
    private int[] phoneNumberPrefixes;

    public DefaultMapStorage() {
    }

    @Override // com.google.i18n.phonenumbers.prefixmapper.PhonePrefixMapStorageStrategy
    public int getPrefix(int r1) {
        return this.phoneNumberPrefixes[r1];
    }

    @Override // com.google.i18n.phonenumbers.prefixmapper.PhonePrefixMapStorageStrategy
    public String getDescription(int r1) {
        return this.descriptions[r1];
    }

    @Override // com.google.i18n.phonenumbers.prefixmapper.PhonePrefixMapStorageStrategy
    public void readFromSortedMap(SortedMap<Integer, String> r6) {
        this.numOfEntries = r6.size();
        this.phoneNumberPrefixes = new int[this.numOfEntries];
        this.descriptions = new String[this.numOfEntries];
        Iterator<Integer> r0 = r6.keySet().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        int r2 = r0.next().intValue();
        this.phoneNumberPrefixes[r1] = r2;
        this.possibleLengths.add(Integer.valueOf(((int) Math.log10(r2)) + 1));
        r1 = r1 + 1;
        goto L4
    L6:
        r6.values().toArray(this.descriptions);
    }

    @Override // com.google.i18n.phonenumbers.prefixmapper.PhonePrefixMapStorageStrategy
    public void readExternal(ObjectInput r5) throws IOException {
        this.numOfEntries = r5.readInt();
        int[] r0 = this.phoneNumberPrefixes;
        if (r0 != null) goto L5;
    L6:
        this.phoneNumberPrefixes = new int[this.numOfEntries];
    L7:
        String[] r1 = this.descriptions;
        if (r1 != null) goto L10;
    L11:
        this.descriptions = new String[this.numOfEntries];
    L12:
        int r2 = 0;
        int r3 = 0;
    L14:
        if (r3 >= this.numOfEntries) goto L16;
        this.phoneNumberPrefixes[r3] = r5.readInt();
        this.descriptions[r3] = r5.readUTF();
        r3 = r3 + 1;
        goto L14
    L16:
        int r4 = r5.readInt();
        this.possibleLengths.clear();
    L17:
        if (r2 >= r4) goto L19;
        this.possibleLengths.add(Integer.valueOf(r5.readInt()));
        r2 = r2 + 1;
        goto L17
    L19:
        return;
    L10:
        if (r1.length >= this.numOfEntries) goto L12;
    L5:
        if (r0.length >= this.numOfEntries) goto L7;
        goto L6
    }

    @Override // com.google.i18n.phonenumbers.prefixmapper.PhonePrefixMapStorageStrategy
    public void writeExternal(ObjectOutput r3) throws IOException {
        r3.writeInt(this.numOfEntries);
        int r0 = 0;
    L4:
        if (r0 >= this.numOfEntries) goto L6;
        r3.writeInt(this.phoneNumberPrefixes[r0]);
        r3.writeUTF(this.descriptions[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        r3.writeInt(this.possibleLengths.size());
        Iterator<Integer> r2 = this.possibleLengths.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r3.writeInt(r2.next().intValue());
        goto L8
    }
}
