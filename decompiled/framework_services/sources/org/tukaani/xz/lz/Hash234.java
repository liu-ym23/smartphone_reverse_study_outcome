package org.tukaani.xz.lz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import org.tukaani.xz.ArrayCache;

/* JADX INFO: loaded from: classes3.dex */
final class Hash234 extends CRC32Hash {
    private static final int HASH_2_MASK = 1023;
    private static final int HASH_2_SIZE = 1024;
    private static final int HASH_3_MASK = 65535;
    private static final int HASH_3_SIZE = 65536;
    private final int[] hash2Table;
    private int hash2Value;
    private final int[] hash3Table;
    private int hash3Value;
    private final int hash4Mask;
    private final int hash4Size;
    private final int[] hash4Table;
    private int hash4Value;

    static int getHash4Size(int dictSize) {
        int h = dictSize - 1;
        int h2 = h | (h >>> 1);
        int h3 = h2 | (h2 >>> 2);
        int h4 = h3 | (h3 >>> 4);
        int h5 = ((h4 | (h4 >>> 8)) >>> 1) | 65535;
        if (h5 <= 16777216) goto L6;
        h5 = h5 >>> 1;
    L6:
        return h5 + 1;
    }

    static int getMemoryUsage(int dictSize) {
        return ((getHash4Size(dictSize) + 66560) / 256) + 4;
    }

    Hash234(int dictSize, ArrayCache arrayCache) {
        this.hash2Value = 0;
        this.hash3Value = 0;
        this.hash4Value = 0;
        this.hash2Table = arrayCache.getIntArray(1024, true);
        this.hash3Table = arrayCache.getIntArray(65536, true);
        this.hash4Size = getHash4Size(dictSize);
        this.hash4Table = arrayCache.getIntArray(this.hash4Size, true);
        this.hash4Mask = this.hash4Size - 1;
    }

    void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.hash4Table);
        arrayCache.putArray(this.hash3Table);
        arrayCache.putArray(this.hash2Table);
    }

    void calcHashes(byte[] buf, int off) {
        int temp = CRC32Hash.crcTable[buf[off] & CecDeviceType.INACTIVE] ^ (buf[off + 1] & CecDeviceType.INACTIVE);
        this.hash2Value = temp & HASH_2_MASK;
        int temp2 = temp ^ ((buf[off + 2] & CecDeviceType.INACTIVE) << 8);
        this.hash3Value = 65535 & temp2;
        int temp3 = temp2 ^ (CRC32Hash.crcTable[buf[off + 3] & CecDeviceType.INACTIVE] << 5);
        this.hash4Value = this.hash4Mask & temp3;
    }

    int getHash2Pos() {
        return this.hash2Table[this.hash2Value];
    }

    int getHash3Pos() {
        return this.hash3Table[this.hash3Value];
    }

    int getHash4Pos() {
        return this.hash4Table[this.hash4Value];
    }

    void updateTables(int pos) {
        this.hash2Table[this.hash2Value] = pos;
        this.hash3Table[this.hash3Value] = pos;
        this.hash4Table[this.hash4Value] = pos;
    }

    void normalize(int normalizationOffset) {
        LZEncoder.normalize(this.hash2Table, 1024, normalizationOffset);
        LZEncoder.normalize(this.hash3Table, 65536, normalizationOffset);
        LZEncoder.normalize(this.hash4Table, this.hash4Size, normalizationOffset);
    }
}
