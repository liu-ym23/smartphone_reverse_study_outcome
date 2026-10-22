package org.tukaani.xz.delta;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class DeltaDecoder extends DeltaCoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public DeltaDecoder(int i8) {
        super(i8);
    }

    public void decode(byte[] bArr, int i8, int i9) {
        int iMin = Math.min(i9, this.distance);
        int i10 = 0;
        while (i10 < iMin) {
            int i11 = i8 + i10;
            bArr[i11] = (byte) (bArr[i11] + this.history[i10]);
            i10++;
        }
        while (i10 < i9) {
            int i12 = i8 + i10;
            bArr[i12] = (byte) (bArr[i12] + bArr[i12 - this.distance]);
            i10++;
        }
        int i13 = this.distance;
        if (i9 >= i13) {
            System.arraycopy(bArr, (i8 + i9) - i13, this.history, 0, i13);
            return;
        }
        byte[] bArr2 = this.history;
        System.arraycopy(bArr2, i10, bArr2, 0, i13 - i10);
        System.arraycopy(bArr, i8, this.history, this.distance - i10, i9);
    }
}
