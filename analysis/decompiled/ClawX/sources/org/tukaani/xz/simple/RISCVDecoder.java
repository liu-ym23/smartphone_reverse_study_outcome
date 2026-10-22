package org.tukaani.xz.simple;

import org.bouncycastle.asn1.BERTags;
import org.tukaani.xz.common.ByteArrayView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class RISCVDecoder implements SimpleFilter {
    private int pos;

    public RISCVDecoder(int i8) {
        this.pos = i8;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] bArr, int i8, int i9) {
        int i10;
        int i11;
        int i12 = (i9 + i8) - 8;
        int i13 = i8;
        while (i13 <= i12) {
            int i14 = bArr[i13];
            int i15 = i14 & 255;
            if (i15 == 239) {
                int i16 = i13 + 1;
                int i17 = bArr[i16];
                if ((i17 & 13) == 0) {
                    int i18 = i13 + 2;
                    int i19 = i13 + 3;
                    int i20 = ((((i17 & 240) << 13) | ((bArr[i18] & 255) << 9)) | ((bArr[i19] & 255) << 1)) - ((this.pos + i13) - i8);
                    bArr[i16] = (byte) ((i17 & 15) | ((i20 >>> 8) & 240));
                    bArr[i18] = (byte) (((i20 >>> 16) & 15) | ((i20 >>> 7) & 16) | ((i20 << 4) & BERTags.FLAGS));
                    bArr[i19] = (byte) (((i20 >>> 13) & 128) | ((i20 >>> 4) & 127));
                    i13 = i18;
                }
            } else if ((i14 & 127) == 23) {
                int i21 = ((bArr[i13 + 1] & 255) << 8) | i15;
                int i22 = i13 + 2;
                int i23 = i21 | ((bArr[i22] & 255) << 16) | ((bArr[i13 + 3] & 255) << 24);
                if ((i23 & 3712) != 0) {
                    i22 = i13 + 4;
                    int intLE = ByteArrayView.getIntLE(bArr, i22);
                    if ((((i23 << 8) ^ intLE) & 1015811) == 3) {
                        i10 = (i23 & (-4096)) + (intLE >>> 20);
                        i11 = (intLE << 12) | 279;
                        ByteArrayView.setIntLE(bArr, i13, i11);
                        ByteArrayView.setIntLE(bArr, i13 + 4, i10);
                        i13 += 6;
                    }
                    i13 = i22;
                } else {
                    int i24 = i23 >>> 27;
                    if (((i23 - 12544) & 16256) < (i24 & 29)) {
                        int intBE = ByteArrayView.getIntBE(bArr, i13 + 4) - ((this.pos + i13) - i8);
                        i10 = (i23 >>> 12) | (intBE << 20);
                        i11 = ((intBE + 2048) & (-4096)) | 23 | (i24 << 7);
                        ByteArrayView.setIntLE(bArr, i13, i11);
                        ByteArrayView.setIntLE(bArr, i13 + 4, i10);
                        i13 += 6;
                    }
                    i13 = i22;
                }
            }
            i13 += 2;
        }
        int i25 = i13 - i8;
        this.pos += i25;
        return i25;
    }
}
