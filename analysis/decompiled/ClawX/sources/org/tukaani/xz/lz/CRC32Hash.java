package org.tukaani.xz.lz;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class CRC32Hash {
    private static final int CRC32_POLY = -306674912;
    static final int[] crcTable = new int[256];

    static {
        for (int i8 = 0; i8 < 256; i8++) {
            int i9 = i8;
            for (int i10 = 0; i10 < 8; i10++) {
                i9 = (i9 & 1) != 0 ? (i9 >>> 1) ^ CRC32_POLY : i9 >>> 1;
            }
            crcTable[i8] = i9;
        }
    }
}
