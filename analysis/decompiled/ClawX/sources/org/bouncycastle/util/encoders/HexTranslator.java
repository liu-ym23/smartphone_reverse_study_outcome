package org.bouncycastle.util.encoders;

/* loaded from: classes.dex */
public class HexTranslator implements Translator {
    private static final byte[] hexTable = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    @Override // org.bouncycastle.util.encoders.Translator
    public int decode(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        int i11 = i9 / 2;
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = (i12 * 2) + i8;
            byte b9 = bArr[i13];
            byte b10 = bArr[i13 + 1];
            if (b9 < 97) {
                bArr2[i10] = (byte) ((b9 - 48) << 4);
            } else {
                bArr2[i10] = (byte) ((b9 - 87) << 4);
            }
            if (b10 < 97) {
                bArr2[i10] = (byte) (bArr2[i10] + ((byte) (b10 - 48)));
            } else {
                bArr2[i10] = (byte) (bArr2[i10] + ((byte) (b10 - 87)));
            }
            i10++;
        }
        return i11;
    }

    @Override // org.bouncycastle.util.encoders.Translator
    public int encode(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        int i11 = 0;
        int i12 = i8;
        int i13 = 0;
        while (i11 < i9) {
            int i14 = i10 + i13;
            byte[] bArr3 = hexTable;
            bArr2[i14] = bArr3[(bArr[i12] >> 4) & 15];
            bArr2[i14 + 1] = bArr3[bArr[i12] & 15];
            i12++;
            i11++;
            i13 += 2;
        }
        return i9 * 2;
    }

    @Override // org.bouncycastle.util.encoders.Translator
    public int getDecodedBlockSize() {
        return 1;
    }

    @Override // org.bouncycastle.util.encoders.Translator
    public int getEncodedBlockSize() {
        return 2;
    }
}
