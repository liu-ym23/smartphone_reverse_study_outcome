package org.tukaani.xz.simple;

import org.bouncycastle.asn1.BERTags;
import org.tukaani.xz.common.ByteArrayView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class RISCVEncoder implements SimpleFilter {
    private int pos;

    public RISCVEncoder(int i8) {
        this.pos = i8;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] bArr, int i8, int i9) {
        int i10 = (i9 + i8) - 8;
        int i11 = i8;
        while (i11 <= i10) {
            int i12 = bArr[i11];
            int i13 = i12 & 255;
            if (i13 == 239) {
                int i14 = i11 + 1;
                int i15 = bArr[i14];
                if ((i15 & 13) == 0) {
                    int i16 = i11 + 2;
                    int i17 = bArr[i16];
                    int i18 = i11 + 3;
                    int i19 = bArr[i18];
                    int i20 = (((i15 & 240) << 8) | ((i17 & 15) << 16) | ((i17 & 16) << 7) | ((i17 & BERTags.FLAGS) >>> 4) | ((i19 & 127) << 4) | ((i19 & 128) << 13)) + ((this.pos + i11) - i8);
                    bArr[i14] = (byte) ((i15 & 15) | ((i20 >>> 13) & 240));
                    bArr[i16] = (byte) (i20 >>> 9);
                    bArr[i18] = (byte) (i20 >>> 1);
                    i11 = i16;
                }
            } else if ((i12 & 127) == 23) {
                int i21 = ((bArr[i11 + 1] & 255) << 8) | i13;
                int i22 = i11 + 2;
                int i23 = i21 | ((bArr[i22] & 255) << 16) | ((bArr[i11 + 3] & 255) << 24);
                if ((i23 & 3712) != 0) {
                    i22 = i11 + 4;
                    int intLE = ByteArrayView.getIntLE(bArr, i22);
                    if ((((i23 << 8) ^ intLE) & 1015811) == 3) {
                        int i24 = ((this.pos + i11) - i8) + (i23 & (-4096)) + (intLE >> 20);
                        ByteArrayView.setIntLE(bArr, i11, (intLE << 12) | 279);
                        ByteArrayView.setIntBE(bArr, i22, i24);
                        i11 += 6;
                    }
                    i11 = i22;
                } else {
                    int i25 = i23 >>> 27;
                    if (((i23 - 12544) & 16256) < (i25 & 29)) {
                        int i26 = i11 + 4;
                        int intLE2 = ByteArrayView.getIntLE(bArr, i26);
                        ByteArrayView.setIntLE(bArr, i11, 23 | (i25 << 7) | (intLE2 & (-4096)));
                        ByteArrayView.setIntLE(bArr, i26, (i23 >>> 12) | (intLE2 << 20));
                        i11 += 6;
                    }
                    i11 = i22;
                }
            }
            i11 += 2;
        }
        int i27 = i11 - i8;
        this.pos += i27;
        return i27;
    }
}
