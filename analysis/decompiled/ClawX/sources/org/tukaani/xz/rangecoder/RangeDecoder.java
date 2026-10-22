package org.tukaani.xz.rangecoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class RangeDecoder extends RangeCoder {
    int range = 0;
    int code = 0;

    public int decodeBit(short[] sArr, int i8) {
        normalize();
        short s8 = sArr[i8];
        int i9 = (this.range >>> 11) * s8;
        if (Integer.compareUnsigned(this.code, i9) < 0) {
            this.range = i9;
            sArr[i8] = (short) (s8 + ((2048 - s8) >>> 5));
            return 0;
        }
        this.range -= i9;
        this.code -= i9;
        sArr[i8] = (short) (s8 - (s8 >>> 5));
        return 1;
    }

    public int decodeBitTree(short[] sArr) {
        int iDecodeBit = 1;
        do {
            iDecodeBit = decodeBit(sArr, iDecodeBit) | (iDecodeBit << 1);
        } while (iDecodeBit < sArr.length);
        return iDecodeBit - sArr.length;
    }

    public int decodeDirectBits(int i8) {
        int i9 = 0;
        do {
            normalize();
            int i10 = this.range >>> 1;
            this.range = i10;
            int i11 = this.code;
            int i12 = (i11 - i10) >>> 31;
            this.code = i11 - (i10 & (i12 - 1));
            i9 = (i9 << 1) | (1 - i12);
            i8--;
        } while (i8 != 0);
        return i9;
    }

    public int decodeReverseBitTree(short[] sArr) {
        int i8 = 0;
        int i9 = 1;
        int i10 = 0;
        while (true) {
            int iDecodeBit = decodeBit(sArr, i9);
            i9 = (i9 << 1) | iDecodeBit;
            int i11 = i10 + 1;
            i8 |= iDecodeBit << i10;
            if (i9 >= sArr.length) {
                return i8;
            }
            i10 = i11;
        }
    }

    public abstract void normalize();
}
