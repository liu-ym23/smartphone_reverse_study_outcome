package org.tukaani.xz.delta;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class DeltaEncoder extends DeltaCoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public DeltaEncoder(int i8) {
        super(i8);
    }

    public void encode(byte[] bArr, int i8, int i9, byte[] bArr2) {
        int iMin = Math.min(i9, this.distance);
        int i10 = 0;
        while (i10 < iMin) {
            bArr2[i10] = (byte) (bArr[i8 + i10] - this.history[i10]);
            i10++;
        }
        int i11 = this.distance;
        if (i9 >= i11) {
            System.arraycopy(bArr, (i8 + i9) - i11, this.history, 0, i11);
        } else {
            byte[] bArr3 = this.history;
            System.arraycopy(bArr3, i10, bArr3, 0, i11 - i10);
            System.arraycopy(bArr, i8, this.history, this.distance - i10, i9);
        }
        while (i10 < i9) {
            int i12 = i8 + i10;
            bArr2[i10] = (byte) (bArr[i12] - bArr[i12 - this.distance]);
            i10++;
        }
    }
}
