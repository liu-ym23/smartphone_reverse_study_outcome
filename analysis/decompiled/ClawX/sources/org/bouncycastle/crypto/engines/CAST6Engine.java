package org.bouncycastle.crypto.engines;

import org.bouncycastle.asn1.BERTags;

/* loaded from: classes.dex */
public final class CAST6Engine extends CAST5Engine {
    protected static final int BLOCK_SIZE = 16;
    protected static final int ROUNDS = 12;
    protected int[] _Kr = new int[48];
    protected int[] _Km = new int[48];
    protected int[] _Tr = new int[BERTags.PRIVATE];
    protected int[] _Tm = new int[BERTags.PRIVATE];
    private int[] _workingKey = new int[8];

    public final void CAST_Decipher(int i8, int i9, int i10, int i11, int[] iArr) {
        int i12;
        int i13 = 0;
        while (true) {
            if (i13 >= 6) {
                break;
            }
            int i14 = (11 - i13) * 4;
            i10 ^= F1(i11, this._Km[i14], this._Kr[i14]);
            int i15 = i14 + 1;
            i9 ^= F2(i10, this._Km[i15], this._Kr[i15]);
            int i16 = i14 + 2;
            i8 ^= F3(i9, this._Km[i16], this._Kr[i16]);
            int i17 = i14 + 3;
            i11 ^= F1(i8, this._Km[i17], this._Kr[i17]);
            i13++;
        }
        for (i12 = 6; i12 < 12; i12++) {
            int i18 = (11 - i12) * 4;
            int i19 = i18 + 3;
            i11 ^= F1(i8, this._Km[i19], this._Kr[i19]);
            int i20 = i18 + 2;
            i8 ^= F3(i9, this._Km[i20], this._Kr[i20]);
            int i21 = i18 + 1;
            i9 ^= F2(i10, this._Km[i21], this._Kr[i21]);
            i10 ^= F1(i11, this._Km[i18], this._Kr[i18]);
        }
        iArr[0] = i8;
        iArr[1] = i9;
        iArr[2] = i10;
        iArr[3] = i11;
    }

    public final void CAST_Encipher(int i8, int i9, int i10, int i11, int[] iArr) {
        int i12;
        int i13 = 0;
        while (true) {
            if (i13 >= 6) {
                break;
            }
            int i14 = i13 * 4;
            i10 ^= F1(i11, this._Km[i14], this._Kr[i14]);
            int i15 = i14 + 1;
            i9 ^= F2(i10, this._Km[i15], this._Kr[i15]);
            int i16 = i14 + 2;
            i8 ^= F3(i9, this._Km[i16], this._Kr[i16]);
            int i17 = i14 + 3;
            i11 ^= F1(i8, this._Km[i17], this._Kr[i17]);
            i13++;
        }
        for (i12 = 6; i12 < 12; i12++) {
            int i18 = i12 * 4;
            int i19 = i18 + 3;
            i11 ^= F1(i8, this._Km[i19], this._Kr[i19]);
            int i20 = i18 + 2;
            i8 ^= F3(i9, this._Km[i20], this._Kr[i20]);
            int i21 = i18 + 1;
            i9 ^= F2(i10, this._Km[i21], this._Kr[i21]);
            i10 ^= F1(i11, this._Km[i18], this._Kr[i18]);
        }
        iArr[0] = i8;
        iArr[1] = i9;
        iArr[2] = i10;
        iArr[3] = i11;
    }

    @Override // org.bouncycastle.crypto.engines.CAST5Engine
    public int decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int[] iArr = new int[4];
        CAST_Decipher(BytesTo32bits(bArr, i8), BytesTo32bits(bArr, i8 + 4), BytesTo32bits(bArr, i8 + 8), BytesTo32bits(bArr, i8 + 12), iArr);
        Bits32ToBytes(iArr[0], bArr2, i9);
        Bits32ToBytes(iArr[1], bArr2, i9 + 4);
        Bits32ToBytes(iArr[2], bArr2, i9 + 8);
        Bits32ToBytes(iArr[3], bArr2, i9 + 12);
        return 16;
    }

    @Override // org.bouncycastle.crypto.engines.CAST5Engine
    public int encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int[] iArr = new int[4];
        CAST_Encipher(BytesTo32bits(bArr, i8), BytesTo32bits(bArr, i8 + 4), BytesTo32bits(bArr, i8 + 8), BytesTo32bits(bArr, i8 + 12), iArr);
        Bits32ToBytes(iArr[0], bArr2, i9);
        Bits32ToBytes(iArr[1], bArr2, i9 + 4);
        Bits32ToBytes(iArr[2], bArr2, i9 + 8);
        Bits32ToBytes(iArr[3], bArr2, i9 + 12);
        return 16;
    }

    @Override // org.bouncycastle.crypto.engines.CAST5Engine, org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "CAST6";
    }

    @Override // org.bouncycastle.crypto.engines.CAST5Engine, org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.engines.CAST5Engine
    public void setKey(byte[] bArr) {
        int i8 = 1518500249;
        int i9 = 19;
        boolean z = false;
        for (int i10 = 0; i10 < 24; i10++) {
            for (int i11 = 0; i11 < 8; i11++) {
                int i12 = (i10 * 8) + i11;
                this._Tm[i12] = i8;
                i8 += 1859775393;
                this._Tr[i12] = i9;
                i9 = (i9 + 17) & 31;
            }
        }
        byte[] bArr2 = new byte[64];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i13 = 0; i13 < 8; i13++) {
            this._workingKey[i13] = BytesTo32bits(bArr2, i13 * 4);
        }
        int i14 = 0;
        while (i14 < 12) {
            int i15 = i14 * 16;
            int[] iArr = this._workingKey;
            iArr[6] = iArr[6] ^ F1(iArr[7], this._Tm[i15], this._Tr[i15]);
            int[] iArr2 = this._workingKey;
            int i16 = i15 + 1;
            iArr2[5] = iArr2[5] ^ F2(iArr2[6], this._Tm[i16], this._Tr[i16]);
            int[] iArr3 = this._workingKey;
            int i17 = i15 + 2;
            iArr3[4] = iArr3[4] ^ F3(iArr3[5], this._Tm[i17], this._Tr[i17]);
            int[] iArr4 = this._workingKey;
            int i18 = i15 + 3;
            boolean z2 = z;
            iArr4[3] = F1(iArr4[4], this._Tm[i18], this._Tr[i18]) ^ iArr4[3];
            int[] iArr5 = this._workingKey;
            int i19 = i15 + 4;
            iArr5[2] = F2(iArr5[3], this._Tm[i19], this._Tr[i19]) ^ iArr5[2];
            int[] iArr6 = this._workingKey;
            int i20 = i15 + 5;
            iArr6[1] = F3(iArr6[2], this._Tm[i20], this._Tr[i20]) ^ iArr6[1];
            int[] iArr7 = this._workingKey;
            int i21 = i15 + 6;
            iArr7[z2 ? 1 : 0] = iArr7[z2 ? 1 : 0] ^ F1(iArr7[1], this._Tm[i21], this._Tr[i21]);
            int[] iArr8 = this._workingKey;
            int i22 = i15 + 7;
            iArr8[7] = F2(iArr8[z2 ? 1 : 0], this._Tm[i22], this._Tr[i22]) ^ iArr8[7];
            int i23 = ((i14 * 2) + 1) * 8;
            int[] iArr9 = this._workingKey;
            iArr9[6] = iArr9[6] ^ F1(iArr9[7], this._Tm[i23], this._Tr[i23]);
            int[] iArr10 = this._workingKey;
            int i24 = i23 + 1;
            iArr10[5] = iArr10[5] ^ F2(iArr10[6], this._Tm[i24], this._Tr[i24]);
            int[] iArr11 = this._workingKey;
            int i25 = i23 + 2;
            iArr11[4] = iArr11[4] ^ F3(iArr11[5], this._Tm[i25], this._Tr[i25]);
            int[] iArr12 = this._workingKey;
            int i26 = i23 + 3;
            iArr12[3] = iArr12[3] ^ F1(iArr12[4], this._Tm[i26], this._Tr[i26]);
            int[] iArr13 = this._workingKey;
            int i27 = i23 + 4;
            iArr13[2] = iArr13[2] ^ F2(iArr13[3], this._Tm[i27], this._Tr[i27]);
            int[] iArr14 = this._workingKey;
            int i28 = i23 + 5;
            iArr14[1] = iArr14[1] ^ F3(iArr14[2], this._Tm[i28], this._Tr[i28]);
            int[] iArr15 = this._workingKey;
            int i29 = i23 + 6;
            iArr15[z2 ? 1 : 0] = iArr15[z2 ? 1 : 0] ^ F1(iArr15[1], this._Tm[i29], this._Tr[i29]);
            int[] iArr16 = this._workingKey;
            int i30 = i23 + 7;
            iArr16[7] = F2(iArr16[z2 ? 1 : 0], this._Tm[i30], this._Tr[i30]) ^ iArr16[7];
            int[] iArr17 = this._Kr;
            int i31 = i14 * 4;
            int[] iArr18 = this._workingKey;
            iArr17[i31] = iArr18[z2 ? 1 : 0] & 31;
            int i32 = i31 + 1;
            iArr17[i32] = iArr18[2] & 31;
            int i33 = i31 + 2;
            iArr17[i33] = iArr18[4] & 31;
            int i34 = i31 + 3;
            iArr17[i34] = iArr18[6] & 31;
            int[] iArr19 = this._Km;
            iArr19[i31] = iArr18[7];
            iArr19[i32] = iArr18[5];
            iArr19[i33] = iArr18[3];
            iArr19[i34] = iArr18[1];
            i14++;
            z = z2 ? 1 : 0;
        }
    }

    @Override // org.bouncycastle.crypto.engines.CAST5Engine, org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
