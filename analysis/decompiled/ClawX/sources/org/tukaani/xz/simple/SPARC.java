package org.tukaani.xz.simple;

import org.tukaani.xz.common.ByteArrayView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class SPARC implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public SPARC(boolean z, int i8) {
        this.isEncoder = z;
        this.pos = i8;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] bArr, int i8, int i9) {
        int i10 = (i9 + i8) - 4;
        int i11 = i8;
        while (i11 <= i10) {
            byte b9 = bArr[i11];
            if ((b9 == 64 && (bArr[i11 + 1] & 192) == 0) || (b9 == 127 && (bArr[i11 + 1] & 192) == 192)) {
                int intBE = ByteArrayView.getIntBE(bArr, i11);
                int i12 = ((this.pos + i11) - i8) >>> 2;
                if (!this.isEncoder) {
                    i12 = -i12;
                }
                ByteArrayView.setIntBE(bArr, i11, ((((intBE + i12) << 9) >> 9) & 1073741823) | 1073741824);
            }
            i11 += 4;
        }
        int i13 = i11 - i8;
        this.pos += i13;
        return i13;
    }
}
