package org.tukaani.xz.check;

import java.lang.reflect.Array;
import org.tukaani.xz.common.ByteArrayView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class CRC64 extends Check {
    private static final long[][] TABLE = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 4, 256);
    private long crc = -1;

    static {
        int i8 = 0;
        while (i8 < 4) {
            for (int i9 = 0; i9 < 256; i9++) {
                long j4 = i8 == 0 ? i9 : TABLE[i8 - 1][i9];
                for (int i10 = 0; i10 < 8; i10++) {
                    j4 = (j4 & 1) == 1 ? (j4 >>> 1) ^ (-3932672073523589310L) : j4 >>> 1;
                }
                TABLE[i8][i9] = j4;
            }
            i8++;
        }
    }

    public CRC64() {
        this.size = 8;
        this.name = "CRC64";
    }

    @Override // org.tukaani.xz.check.Check
    public byte[] finish() {
        byte[] bArr = new byte[8];
        ByteArrayView.setLongLE(bArr, 0, ~this.crc);
        this.crc = -1L;
        return bArr;
    }

    @Override // org.tukaani.xz.check.Check
    public void update(byte[] bArr, int i8, int i9) {
        int i10 = i9 + i8;
        int i11 = i10 - 3;
        while (i8 < i11) {
            long j4 = this.crc;
            int i12 = (int) j4;
            long[][] jArr = TABLE;
            this.crc = (((j4 >>> 32) ^ (jArr[3][(i12 & 255) ^ (bArr[i8] & 255)] ^ jArr[2][((i12 >>> 8) & 255) ^ (bArr[i8 + 1] & 255)])) ^ jArr[1][((i12 >>> 16) & 255) ^ (bArr[i8 + 2] & 255)]) ^ jArr[0][((i12 >>> 24) & 255) ^ (bArr[i8 + 3] & 255)];
            i8 += 4;
        }
        while (i8 < i10) {
            long[] jArr2 = TABLE[0];
            int i13 = i8 + 1;
            int i14 = bArr[i8] & 255;
            long j8 = this.crc;
            this.crc = (j8 >>> 8) ^ jArr2[i14 ^ (((int) j8) & 255)];
            i8 = i13;
        }
    }
}
