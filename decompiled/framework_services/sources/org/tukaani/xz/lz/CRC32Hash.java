package org.tukaani.xz.lz;

/* JADX INFO: loaded from: classes3.dex */
class CRC32Hash {
    private static final int CRC32_POLY = -306674912;
    static final int[] crcTable = null;

    CRC32Hash() {
    }

    static {
        crcTable = new int[256];
        int i = 0;
    L3:
        if (i >= 256) goto L14;
        int r = i;
        int j = 0;
    L6:
        if (j >= 8) goto L12;
        if ((r & 1) == 0) goto L10;
        r = (r >>> 1) ^ CRC32_POLY;
    L11:
        j = j + 1;
        goto L6
    L10:
        r = r >>> 1;
        goto L11
    L12:
        crcTable[i] = r;
        i = i + 1;
        goto L3
    }
}
