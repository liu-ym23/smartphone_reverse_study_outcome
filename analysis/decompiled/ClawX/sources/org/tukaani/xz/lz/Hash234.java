package org.tukaani.xz.lz;

import org.tukaani.xz.ArrayCache;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
final class Hash234 extends CRC32Hash {
    private static final int HASH_2_MASK = 1023;
    private static final int HASH_2_SIZE = 1024;
    private static final int HASH_3_MASK = 65535;
    private static final int HASH_3_SIZE = 65536;
    private final int[] hash2Table;
    private final int[] hash3Table;
    private final int hash4Mask;
    private final int hash4Size;
    private final int[] hash4Table;
    private int hash2Value = 0;
    private int hash3Value = 0;
    private int hash4Value = 0;

    public Hash234(int i8, ArrayCache arrayCache) {
        this.hash2Table = arrayCache.getIntArray(1024, true);
        this.hash3Table = arrayCache.getIntArray(HASH_3_SIZE, true);
        int hash4Size = getHash4Size(i8);
        this.hash4Size = hash4Size;
        this.hash4Table = arrayCache.getIntArray(hash4Size, true);
        this.hash4Mask = hash4Size - 1;
    }

    public static int getHash4Size(int i8) {
        int i9 = i8 - 1;
        int i10 = i9 | (i9 >>> 1);
        int i11 = i10 | (i10 >>> 2);
        int i12 = i11 | (i11 >>> 4);
        int i13 = ((i12 | (i12 >>> 8)) >>> 1) | 65535;
        if (i13 > 16777216) {
            i13 >>>= 1;
        }
        return i13 + 1;
    }

    public static int getMemoryUsage(int i8) {
        return ((getHash4Size(i8) + 66560) / 256) + 4;
    }

    public void calcHashes(byte[] bArr, int i8) {
        int[] iArr = CRC32Hash.crcTable;
        int i9 = iArr[bArr[i8] & 255] ^ (bArr[i8 + 1] & 255);
        this.hash2Value = i9 & HASH_2_MASK;
        int i10 = i9 ^ ((bArr[i8 + 2] & 255) << 8);
        this.hash3Value = 65535 & i10;
        this.hash4Value = ((iArr[bArr[i8 + 3] & 255] << 5) ^ i10) & this.hash4Mask;
    }

    public int getHash2Pos() {
        return this.hash2Table[this.hash2Value];
    }

    public int getHash3Pos() {
        return this.hash3Table[this.hash3Value];
    }

    public int getHash4Pos() {
        return this.hash4Table[this.hash4Value];
    }

    public void normalize(int i8) {
        LZEncoder.normalize(this.hash2Table, 1024, i8);
        LZEncoder.normalize(this.hash3Table, HASH_3_SIZE, i8);
        LZEncoder.normalize(this.hash4Table, this.hash4Size, i8);
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.hash4Table);
        arrayCache.putArray(this.hash3Table);
        arrayCache.putArray(this.hash2Table);
    }

    public void updateTables(int i8) {
        this.hash2Table[this.hash2Value] = i8;
        this.hash3Table[this.hash3Value] = i8;
        this.hash4Table[this.hash4Value] = i8;
    }
}
