package org.tukaani.xz.simple;

import org.tukaani.xz.common.ByteArrayView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class ARM64 implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public ARM64(boolean z, int i8) {
        this.isEncoder = z;
        this.pos = i8;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] bArr, int i8, int i9) {
        int i10 = (i9 + i8) - 4;
        int i11 = i8;
        while (i11 <= i10) {
            byte b9 = bArr[i11 + 3];
            if ((b9 & 252) == 148) {
                int intLE = ByteArrayView.getIntLE(bArr, i11);
                int i12 = ((this.pos + i11) - i8) >>> 2;
                if (!this.isEncoder) {
                    i12 = -i12;
                }
                ByteArrayView.setIntLE(bArr, i11, ((intLE + i12) & 67108863) | (-1811939328));
            } else if ((b9 & 159) == 144) {
                int intLE2 = ByteArrayView.getIntLE(bArr, i11);
                int i13 = ((intLE2 >>> 29) & 3) | ((intLE2 >>> 3) & 2097148);
                if (((i13 + 131072) & 1835008) == 0) {
                    int i14 = ((this.pos + i11) - i8) >>> 12;
                    if (!this.isEncoder) {
                        i14 = -i14;
                    }
                    int i15 = i13 + i14;
                    ByteArrayView.setIntLE(bArr, i11, (intLE2 & (-1879048161)) | ((i15 & 3) << 29) | ((262140 & i15) << 3) | ((-(i15 & 131072)) & 14680064));
                }
            }
            i11 += 4;
        }
        int i16 = i11 - i8;
        this.pos += i16;
        return i16;
    }
}
