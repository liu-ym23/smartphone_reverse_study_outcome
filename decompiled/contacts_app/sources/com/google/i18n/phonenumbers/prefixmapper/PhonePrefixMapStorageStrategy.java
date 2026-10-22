package com.google.i18n.phonenumbers.prefixmapper;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.SortedMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
abstract class PhonePrefixMapStorageStrategy {
    protected int numOfEntries;
    protected final TreeSet<Integer> possibleLengths;

    public abstract String getDescription(int r1);

    public abstract int getPrefix(int r1);

    public abstract void readExternal(ObjectInput r1) throws IOException;

    public abstract void readFromSortedMap(SortedMap<Integer, String> r1);

    public abstract void writeExternal(ObjectOutput r1) throws IOException;

    PhonePrefixMapStorageStrategy() {
        this.numOfEntries = 0;
        this.possibleLengths = new TreeSet();
    }

    public int getNumOfEntries() {
        return this.numOfEntries;
    }

    public TreeSet<Integer> getPossibleLengths() {
        return this.possibleLengths;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = getNumOfEntries();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.append(getPrefix(r2)).append("|").append(getDescription(r2)).append("\n");
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }
}
