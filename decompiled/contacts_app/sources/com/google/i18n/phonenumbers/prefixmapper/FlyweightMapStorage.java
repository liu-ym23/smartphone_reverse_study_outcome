package com.google.i18n.phonenumbers.prefixmapper;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
final class FlyweightMapStorage extends PhonePrefixMapStorageStrategy {
    private static final int INT_NUM_BYTES = 4;
    private static final int SHORT_NUM_BYTES = 2;
    private int descIndexSizeInBytes;
    private ByteBuffer descriptionIndexes;
    private String[] descriptionPool;
    private ByteBuffer phoneNumberPrefixes;
    private int prefixSizeInBytes;

    private static int getOptimalNumberOfBytesForValue(int r1) {
        if (r1 > 32767) goto L5;
        return 2;
    L5:
        return 4;
    }

    FlyweightMapStorage() {
    }

    @Override // com.google.i18n.phonenumbers.prefixmapper.PhonePrefixMapStorageStrategy
    public int getPrefix(int r2) {
        return readWordFromBuffer(this.phoneNumberPrefixes, this.prefixSizeInBytes, r2);
    }

    @Override // com.google.i18n.phonenumbers.prefixmapper.PhonePrefixMapStorageStrategy
    public String getDescription(int r3) {
        int r4 = readWordFromBuffer(this.descriptionIndexes, this.descIndexSizeInBytes, r3);
        return this.descriptionPool[r4];
    }

    @Override // com.google.i18n.phonenumbers.prefixmapper.PhonePrefixMapStorageStrategy
    public void readFromSortedMap(SortedMap<Integer, String> r9) {
        TreeSet r0 = new TreeSet();
        this.numOfEntries = r9.size();
        this.prefixSizeInBytes = getOptimalNumberOfBytesForValue(r9.lastKey().intValue());
        this.phoneNumberPrefixes = ByteBuffer.allocate(this.numOfEntries * this.prefixSizeInBytes);
        Iterator<Map.Entry<Integer, String>> r1 = r9.entrySet().iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<Integer, String> r3 = r1.next();
        int r4 = r3.getKey().intValue();
        storeWordInBuffer(this.phoneNumberPrefixes, this.prefixSizeInBytes, r2, r4);
        this.possibleLengths.add(Integer.valueOf(((int) Math.log10(r4)) + 1));
        r0.add(r3.getValue());
        r2 = r2 + 1;
        goto L4
    L6:
        createDescriptionPool(r0, r9);
    }

    private void createDescriptionPool(SortedSet<String> r5, SortedMap<Integer, String> r6) {
        this.descIndexSizeInBytes = getOptimalNumberOfBytesForValue(r5.size() - 1);
        this.descriptionIndexes = ByteBuffer.allocate(this.numOfEntries * this.descIndexSizeInBytes);
        String[] r0 = new String[r5.size()];
        this.descriptionPool = r0;
        r5.toArray(r0);
        int r7 = 0;
        int r1 = 0;
    L4:
        if (r7 >= this.numOfEntries) goto L6;
        storeWordInBuffer(this.descriptionIndexes, this.descIndexSizeInBytes, r1, Arrays.binarySearch(this.descriptionPool, r6.get(Integer.valueOf(readWordFromBuffer(this.phoneNumberPrefixes, this.prefixSizeInBytes, r7)))));
        r1 = r1 + 1;
        r7 = r7 + 1;
        goto L4
    }

    @Override // com.google.i18n.phonenumbers.prefixmapper.PhonePrefixMapStorageStrategy
    public void readExternal(ObjectInput r6) throws IOException {
        this.prefixSizeInBytes = r6.readInt();
        this.descIndexSizeInBytes = r6.readInt();
        int r0 = r6.readInt();
        this.possibleLengths.clear();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.possibleLengths.add(Integer.valueOf(r6.readInt()));
        r2 = r2 + 1;
        goto L3
    L5:
        int r3 = r6.readInt();
        String[] r4 = this.descriptionPool;
        if (r4 != null) goto L8;
    L9:
        this.descriptionPool = new String[r3];
    L10:
        if (r1 >= r3) goto L12;
        this.descriptionPool[r1] = r6.readUTF();
        r1 = r1 + 1;
        goto L10
    L12:
        readEntries(r6);
        return;
    L8:
        if (r4.length >= r3) goto L10;
        goto L9
    }

    private void readEntries(ObjectInput r4) throws IOException {
        this.numOfEntries = r4.readInt();
        ByteBuffer r0 = this.phoneNumberPrefixes;
        if (r0 != null) goto L5;
    L6:
        this.phoneNumberPrefixes = ByteBuffer.allocate(this.numOfEntries * this.prefixSizeInBytes);
    L7:
        ByteBuffer r1 = this.descriptionIndexes;
        if (r1 != null) goto L10;
    L11:
        this.descriptionIndexes = ByteBuffer.allocate(this.numOfEntries * this.descIndexSizeInBytes);
    L12:
        int r2 = 0;
    L14:
        if (r2 >= this.numOfEntries) goto L16;
        readExternalWord(r4, this.prefixSizeInBytes, this.phoneNumberPrefixes, r2);
        readExternalWord(r4, this.descIndexSizeInBytes, this.descriptionIndexes, r2);
        r2 = r2 + 1;
        goto L14
    L16:
        return;
    L10:
        if (r1.capacity() >= this.numOfEntries) goto L12;
    L5:
        if (r0.capacity() >= this.numOfEntries) goto L7;
        goto L6
    }

    @Override // com.google.i18n.phonenumbers.prefixmapper.PhonePrefixMapStorageStrategy
    public void writeExternal(ObjectOutput r6) throws IOException {
        r6.writeInt(this.prefixSizeInBytes);
        r6.writeInt(this.descIndexSizeInBytes);
        r6.writeInt(this.possibleLengths.size());
        Iterator<Integer> r0 = this.possibleLengths.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r6.writeInt(r0.next().intValue());
        goto L4
    L6:
        r6.writeInt(this.descriptionPool.length);
        String[] r1 = this.descriptionPool;
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        r6.writeUTF(r1[r4]);
        r4 = r4 + 1;
        goto L7
    L9:
        r6.writeInt(this.numOfEntries);
    L11:
        if (r3 >= this.numOfEntries) goto L13;
        writeExternalWord(r6, this.prefixSizeInBytes, this.phoneNumberPrefixes, r3);
        writeExternalWord(r6, this.descIndexSizeInBytes, this.descriptionIndexes, r3);
        r3 = r3 + 1;
        goto L11
    }

    private static void readExternalWord(ObjectInput r1, int r2, ByteBuffer r3, int r4) throws IOException {
        int r5 = r4 * r2;
        if (r2 != 2) goto L5;
        r3.putShort(r5, r1.readShort());
        return;
    L5:
        r3.putInt(r5, r1.readInt());
    }

    private static void writeExternalWord(ObjectOutput r1, int r2, ByteBuffer r3, int r4) throws IOException {
        int r5 = r4 * r2;
        if (r2 != 2) goto L5;
        r1.writeShort(r3.getShort(r5));
        return;
    L5:
        r1.writeInt(r3.getInt(r5));
    }

    private static int readWordFromBuffer(ByteBuffer r1, int r2, int r3) {
        int r4 = r3 * r2;
        if (r2 != 2) goto L6;
        return r1.getShort(r4);
    L6:
        return r1.getInt(r4);
    }

    private static void storeWordInBuffer(ByteBuffer r1, int r2, int r3, int r4) {
        int r5 = r3 * r2;
        if (r2 != 2) goto L5;
        r1.putShort(r5, (short) r4);
        return;
    L5:
        r1.putInt(r5, r4);
    }
}
