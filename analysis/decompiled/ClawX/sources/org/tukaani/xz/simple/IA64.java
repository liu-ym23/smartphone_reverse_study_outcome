package org.tukaani.xz.simple;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class IA64 implements SimpleFilter {
    private static final int[] BRANCH_TABLE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 6, 6, 0, 0, 7, 7, 4, 4, 0, 0, 4, 4, 0, 0};
    private final boolean isEncoder;
    private int pos;

    public IA64(boolean z, int i8) {
        this.isEncoder = z;
        this.pos = i8;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] bArr, int i8, int i9) {
        char c3;
        int i10;
        char c8 = 16;
        int i11 = (i8 + i9) - 16;
        int i12 = i8;
        while (i12 <= i11) {
            int i13 = BRANCH_TABLE[bArr[i12] & 31];
            int i14 = 5;
            int i15 = 0;
            while (i15 < 3) {
                if (((i13 >>> i15) & 1) == 0) {
                    c3 = c8;
                    i10 = i14;
                } else {
                    int i16 = i14 >>> 3;
                    int i17 = i14 & 7;
                    c3 = c8;
                    long j4 = 0;
                    int i18 = 0;
                    while (i18 < 6) {
                        j4 |= (bArr[(i12 + i16) + i18] & 255) << (i18 * 8);
                        i18++;
                        i14 = i14;
                    }
                    i10 = i14;
                    long j8 = j4 >>> i17;
                    if (((j8 >>> 37) & 15) == 5 && ((j8 >>> 9) & 7) == 0) {
                        int i19 = (((((int) (j8 >>> 36)) & 1) << 20) | ((int) ((j8 >>> 13) & 1048575))) << 4;
                        long j9 = (this.isEncoder ? ((this.pos + i12) - i8) + i19 : i19 - ((this.pos + i12) - i8)) >>> 4;
                        long j10 = ((((j8 & (-77309403137L)) | ((j9 & 1048575) << 13)) | ((j9 & 1048576) << c3)) << i17) | (((1 << i17) - 1) & j4);
                        for (int i20 = 0; i20 < 6; i20++) {
                            bArr[i12 + i16 + i20] = (byte) (j10 >>> (i20 * 8));
                        }
                    }
                }
                i15++;
                i14 = i10 + 41;
                c8 = c3;
            }
            i12 += 16;
        }
        int i21 = i12 - i8;
        this.pos += i21;
        return i21;
    }
}
