package org.tukaani.xz.simple;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class ARM implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public ARM(boolean z, int i8) {
        this.isEncoder = z;
        this.pos = i8 + 8;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] bArr, int i8, int i9) {
        int i10 = (i9 + i8) - 4;
        int i11 = i8;
        while (i11 <= i10) {
            if ((bArr[i11 + 3] & 255) == 235) {
                int i12 = i11 + 2;
                int i13 = i11 + 1;
                int i14 = ((((bArr[i12] & 255) << 16) | ((bArr[i13] & 255) << 8)) | (bArr[i11] & 255)) << 2;
                int i15 = this.isEncoder ? ((this.pos + i11) - i8) + i14 : i14 - ((this.pos + i11) - i8);
                bArr[i12] = (byte) (i15 >>> 18);
                bArr[i13] = (byte) (i15 >>> 10);
                bArr[i11] = (byte) (i15 >>> 2);
            }
            i11 += 4;
        }
        int i16 = i11 - i8;
        this.pos += i16;
        return i16;
    }
}
