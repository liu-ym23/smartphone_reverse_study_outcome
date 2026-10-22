package com.stepos.pps.data.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.zip.Checksum;
import kotlin.UByte;

/* loaded from: classes.dex */
public class CRC64 implements Checksum {
    private static final int GF2_DIM = 64;
    private static final long POLY = -3932672073523589310L;
    private static final long[][] table = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 8, 256);
    private long value;

    static {
        for (int i = 0; i < 256; i++) {
            long j = i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j & 1) == 1 ? (j >>> 1) ^ POLY : j >>> 1;
            }
            table[0][i] = j;
        }
        for (int i3 = 0; i3 < 256; i3++) {
            long j2 = table[0][i3];
            for (int i4 = 1; i4 < 8; i4++) {
                long[][] jArr = table;
                j2 = (j2 >>> 8) ^ jArr[0][(int) (255 & j2)];
                jArr[i4][i3] = j2;
            }
        }
    }

    public CRC64() {
        this.value = 0L;
    }

    public CRC64(long j) {
        this.value = j;
    }

    public CRC64(byte[] bArr, int i) {
        this.value = 0L;
        update(bArr, i);
    }

    public CRC64(byte[] bArr, int i, int i2) {
        this.value = 0L;
        update(bArr, i, i2);
    }

    public CRC64(byte[] bArr) {
        long j = 0;
        for (int i = 0; i < 4; i++) {
            j = (j << 8) ^ (bArr[i] & 255);
        }
        this.value = j;
    }

    public static CRC64 fromBytes(byte[] bArr) {
        CRC64 crc64 = new CRC64();
        crc64.update(bArr, bArr.length);
        return crc64;
    }

    public static CRC64 fromFile(File file) throws IOException {
        return fromInputStream(new FileInputStream(file));
    }

    public static CRC64 fromInputStream(InputStream inputStream) throws IOException {
        try {
            CRC64 crc64 = new CRC64();
            byte[] bArr = new byte[65536];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return crc64;
                }
                crc64.update(bArr, i);
            }
        } finally {
            inputStream.close();
        }
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[7 - i] = (byte) (this.value >>> (i * 8));
        }
        return bArr;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        return this.value;
    }

    public void update(byte[] bArr, int i) {
        update(bArr, 0, i);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i, int i2) {
        this.value = ~this.value;
        int i3 = i;
        int i4 = i2;
        while (i4 >= 8) {
            long[][] jArr = table;
            long[] jArr2 = jArr[7];
            long j = this.value;
            this.value = ((((((jArr[6][(int) ((bArr[i3 + 1] & UByte.MAX_VALUE) ^ ((j >>> 8) & 255))] ^ jArr2[(int) ((j & 255) ^ (bArr[i3] & UByte.MAX_VALUE))]) ^ jArr[5][(int) (((j >>> 16) & 255) ^ (bArr[i3 + 2] & UByte.MAX_VALUE))]) ^ jArr[4][(int) (((j >>> 24) & 255) ^ (bArr[i3 + 3] & UByte.MAX_VALUE))]) ^ jArr[3][(int) (((j >>> 32) & 255) ^ (bArr[i3 + 4] & UByte.MAX_VALUE))]) ^ jArr[2][(int) (((j >>> 40) & 255) ^ (bArr[i3 + 5] & UByte.MAX_VALUE))]) ^ jArr[1][(int) ((255 & (j >>> 48)) ^ (bArr[i3 + 6] & UByte.MAX_VALUE))]) ^ jArr[0][(int) ((j >>> 56) ^ (bArr[i3 + 7] & UByte.MAX_VALUE))];
            i3 += 8;
            i4 -= 8;
        }
        while (i4 > 0) {
            long[] jArr3 = table[0];
            long j2 = this.value;
            this.value = jArr3[(int) ((bArr[i3] ^ j2) & 255)] ^ (j2 >>> 8);
            i3++;
            i4--;
        }
        this.value = ~this.value;
    }

    @Override // java.util.zip.Checksum
    public void update(int i) {
        update(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.value = 0L;
    }

    private static long gf2MatrixTimes(long[] jArr, long j) {
        int i = 0;
        long j2 = 0;
        while (j != 0) {
            if ((j & 1) == 1) {
                j2 ^= jArr[i];
            }
            j >>>= 1;
            i++;
        }
        return j2;
    }

    private static void gf2MatrixSquare(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 64; i++) {
            jArr[i] = gf2MatrixTimes(jArr2, jArr2[i]);
        }
    }

    public static CRC64 combine(CRC64 crc64, CRC64 crc642, long j) {
        if (j == 0) {
            return new CRC64(crc64.getValue());
        }
        long[] jArr = new long[64];
        long[] jArr2 = new long[64];
        jArr2[0] = -3932672073523589310L;
        long j2 = 1;
        for (int i = 1; i < 64; i++) {
            jArr2[i] = j2;
            j2 <<= 1;
        }
        gf2MatrixSquare(jArr, jArr2);
        gf2MatrixSquare(jArr2, jArr);
        long value = crc64.getValue();
        long value2 = crc642.getValue();
        do {
            gf2MatrixSquare(jArr, jArr2);
            if ((j & 1) == 1) {
                value = gf2MatrixTimes(jArr, value);
            }
            long j3 = j >>> 1;
            if (j3 == 0) {
                break;
            }
            gf2MatrixSquare(jArr2, jArr);
            if ((j3 & 1) == 1) {
                value = gf2MatrixTimes(jArr2, value);
            }
            j >>>= 2;
        } while (j != 0);
        return new CRC64(value2 ^ value);
    }
}
