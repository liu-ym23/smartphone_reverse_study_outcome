package org.tukaani.xz.simple;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class ARMThumb implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public ARMThumb(boolean z, int i8) {
        this.isEncoder = z;
        this.pos = i8 + 4;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] bArr, int i8, int i9) {
        int i10 = (i9 + i8) - 4;
        int i11 = i8;
        while (i11 <= i10) {
            int i12 = i11 + 1;
            int i13 = bArr[i12];
            if ((i13 & 248) == 240) {
                int i14 = i11 + 3;
                int i15 = bArr[i14];
                if ((i15 & 248) == 248) {
                    int i16 = ((i13 & 7) << 19) | ((bArr[i11] & 255) << 11) | ((i15 & 7) << 8);
                    int i17 = i11 + 2;
                    int i18 = (i16 | (bArr[i17] & 255)) << 1;
                    int i19 = this.isEncoder ? ((this.pos + i11) - i8) + i18 : i18 - ((this.pos + i11) - i8);
                    bArr[i12] = (byte) (240 | ((i19 >>> 20) & 7));
                    bArr[i11] = (byte) (i19 >>> 12);
                    bArr[i14] = (byte) (((i19 >>> 9) & 7) | 248);
                    bArr[i17] = (byte) (i19 >>> 1);
                    i11 = i17;
                }
            }
            i11 += 2;
        }
        int i20 = i11 - i8;
        this.pos += i20;
        return i20;
    }
}
