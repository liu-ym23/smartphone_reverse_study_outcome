package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AEADBaseEngine;
import org.bouncycastle.crypto.hpke.HPKE;
import org.bouncycastle.util.Bytes;

/* loaded from: classes.dex */
public class GiftCofbEngine extends AEADBaseEngine {
    private static final byte[] GIFT_RC = {1, 3, 7, 15, 31, 62, 61, 59, 55, 47, 30, 60, 57, 51, 39, 14, 29, 58, 53, 43, 22, 44, 24, 48, 33, 2, 5, 11, 23, 46, 28, 56, 49, 35, 6, 13, 27, 54, 45, 26};
    private byte[] Y;
    private byte[] input;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f4457k;
    private byte[] npub;
    private byte[] offset;

    public GiftCofbEngine() {
        this.KEY_SIZE = 16;
        this.IV_SIZE = 16;
        this.MAC_SIZE = 16;
        this.BlockSize = 16;
        this.AADBufferSize = 16;
        this.algorithmName = "GIFT-COFB AEAD";
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Buffered, AEADBaseEngine.AADOperatorType.Default, AEADBaseEngine.DataOperatorType.Counter);
    }

    private void double_half_block(byte[] bArr) {
        int i8 = 0;
        int i9 = ((bArr[0] & 255) >>> 7) * 27;
        while (i8 < 7) {
            int i10 = i8 + 1;
            bArr[i8] = (byte) (((bArr[i8] & 255) << 1) | ((bArr[i10] & 255) >>> 7));
            i8 = i10;
        }
        bArr[7] = (byte) (((bArr[7] & 255) << 1) ^ i9);
    }

    private void giftb128(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        char c3 = 0;
        int[] iArr = {((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255), ((bArr[4] & 255) << 24) | ((bArr[5] & 255) << 16) | ((bArr[6] & 255) << 8) | (bArr[7] & 255), ((bArr[8] & 255) << 24) | ((bArr[9] & 255) << 16) | ((bArr[10] & 255) << 8) | (bArr[11] & 255), ((bArr[13] & 255) << 16) | ((bArr[12] & 255) << 24) | ((bArr[14] & 255) << 8) | (bArr[15] & 255)};
        short[] sArr = {(short) (((bArr2[0] & 255) << 8) | (bArr2[1] & 255)), (short) (((bArr2[2] & 255) << 8) | (bArr2[3] & 255)), (short) (((bArr2[4] & 255) << 8) | (bArr2[5] & 255)), (short) (((bArr2[6] & 255) << 8) | (bArr2[7] & 255)), (short) (((bArr2[8] & 255) << 8) | (bArr2[9] & 255)), (short) (((bArr2[10] & 255) << 8) | (bArr2[11] & 255)), (short) (((bArr2[12] & 255) << 8) | (bArr2[13] & 255)), (short) (((bArr2[14] & 255) << 8) | (bArr2[15] & 255))};
        int i8 = 0;
        while (i8 < 40) {
            int i9 = iArr[1];
            int i10 = iArr[c3];
            int i11 = iArr[2];
            int i12 = i9 ^ (i10 & i11);
            iArr[1] = i12;
            int i13 = iArr[3];
            int i14 = i10 ^ (i12 & i13);
            iArr[c3] = i14;
            int i15 = i11 ^ (i14 | i12);
            iArr[2] = i15;
            char c8 = c3;
            int i16 = i13 ^ i15;
            iArr[3] = i16;
            int i17 = i12 ^ i16;
            iArr[1] = i17;
            int i18 = ~i16;
            iArr[3] = i18;
            iArr[2] = i15 ^ (i14 & i17);
            iArr[c8] = i18;
            iArr[3] = i14;
            iArr[c8] = rowperm(i18, 0, 3, 2, 1);
            iArr[1] = rowperm(iArr[1], 1, 0, 3, 2);
            iArr[2] = rowperm(iArr[2], 2, 1, 0, 3);
            int iRowperm = rowperm(iArr[3], 3, 2, 1, 0);
            iArr[3] = iRowperm;
            int i19 = iArr[2];
            short s8 = sArr[2];
            int i20 = (s8 & HPKE.aead_EXPORT_ONLY) << 16;
            short s9 = sArr[3];
            iArr[2] = i19 ^ (i20 | (s9 & HPKE.aead_EXPORT_ONLY));
            int i21 = iArr[1];
            short s10 = sArr[6];
            int i22 = (s10 & HPKE.aead_EXPORT_ONLY) << 16;
            short s11 = sArr[7];
            iArr[1] = i21 ^ (i22 | (s11 & HPKE.aead_EXPORT_ONLY));
            iArr[3] = iRowperm ^ ((GIFT_RC[i8] & 255) ^ Integer.MIN_VALUE);
            short s12 = (short) (((s10 & HPKE.aead_EXPORT_ONLY) >>> 2) | ((s10 & HPKE.aead_EXPORT_ONLY) << 14));
            short s13 = (short) (((s11 & HPKE.aead_EXPORT_ONLY) >>> 12) | ((s11 & HPKE.aead_EXPORT_ONLY) << 4));
            sArr[7] = sArr[5];
            sArr[6] = sArr[4];
            sArr[5] = s9;
            sArr[4] = s8;
            sArr[3] = sArr[1];
            sArr[2] = sArr[c8];
            sArr[1] = s13;
            sArr[c8] = s12;
            i8++;
            c3 = c8;
        }
        char c9 = c3;
        int i23 = iArr[c9];
        bArr3[c9] = (byte) (i23 >>> 24);
        bArr3[1] = (byte) (i23 >>> 16);
        bArr3[2] = (byte) (i23 >>> 8);
        bArr3[3] = (byte) i23;
        int i24 = iArr[1];
        bArr3[4] = (byte) (i24 >>> 24);
        bArr3[5] = (byte) (i24 >>> 16);
        bArr3[6] = (byte) (i24 >>> 8);
        bArr3[7] = (byte) i24;
        int i25 = iArr[2];
        bArr3[8] = (byte) (i25 >>> 24);
        bArr3[9] = (byte) (i25 >>> 16);
        bArr3[10] = (byte) (i25 >>> 8);
        bArr3[11] = (byte) i25;
        int i26 = iArr[3];
        bArr3[12] = (byte) (i26 >>> 24);
        bArr3[13] = (byte) (i26 >>> 16);
        bArr3[14] = (byte) (i26 >>> 8);
        bArr3[15] = (byte) i26;
    }

    private void pho1(byte[] bArr, byte[] bArr2, byte[] bArr3, int i8, int i9) {
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[16];
        if (i9 == 0) {
            bArr4[0] = -128;
        } else {
            System.arraycopy(bArr3, i8, bArr4, 0, i9);
            if (i9 < 16) {
                bArr4[i9] = -128;
            }
        }
        System.arraycopy(bArr2, 8, bArr5, 0, 8);
        int i10 = 0;
        while (i10 < 7) {
            int i11 = i10 + 8;
            int i12 = (bArr2[i10] & 255) << 1;
            i10++;
            bArr5[i11] = (byte) (((bArr2[i10] & 255) >>> 7) | i12);
        }
        bArr5[15] = (byte) (((bArr2[7] & 255) << 1) | ((bArr2[0] & 255) >>> 7));
        System.arraycopy(bArr5, 0, bArr2, 0, 16);
        Bytes.xor(16, bArr2, bArr4, bArr);
    }

    private int rowperm(int i8, int i9, int i10, int i11, int i12) {
        int i13 = 0;
        for (int i14 = 0; i14 < 8; i14++) {
            int i15 = i14 * 4;
            i13 = i13 | (((i8 >>> i15) & 1) << ((i9 * 8) + i14)) | (((i8 >>> (i15 + 1)) & 1) << ((i10 * 8) + i14)) | (((i8 >>> (i15 + 2)) & 1) << ((i11 * 8) + i14)) | (((i8 >>> (i15 + 3)) & 1) << ((8 * i12) + i14));
        }
        return i13;
    }

    private void triple_half_block(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        int i8 = 0;
        while (i8 < 7) {
            int i9 = i8 + 1;
            bArr2[i8] = (byte) (((bArr[i9] & 255) >>> 7) | ((bArr[i8] & 255) << 1));
            i8 = i9;
        }
        bArr2[7] = (byte) ((((bArr[0] & 255) >>> 7) * 27) ^ ((bArr[7] & 255) << 1));
        Bytes.xorTo(8, bArr2, bArr);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
        return super.doFinal(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.State state, boolean z) {
        finishAAD3(state, z);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getIVBytesSize() {
        return super.getIVBytesSize();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getKeyBytesSize() {
        return super.getKeyBytesSize();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ byte[] getMac() {
        return super.getMac();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int getOutputSize(int i8) {
        return super.getOutputSize(i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int getUpdateOutputSize(int i8) {
        return super.getUpdateOutputSize(i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void init(boolean z, CipherParameters cipherParameters) {
        super.init(z, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADByte(byte b9) {
        super.processAADByte(b9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADBytes(byte[] bArr, int i8, int i9) {
        super.processAADBytes(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferAAD(byte[] bArr, int i8) {
        pho1(this.input, this.Y, bArr, i8, 16);
        double_half_block(this.offset);
        Bytes.xorTo(8, this.offset, this.input);
        giftb128(this.input, this.f4457k, this.Y);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        double_half_block(this.offset);
        Bytes.xor(this.BlockSize, this.Y, bArr, i8, bArr2, i9);
        pho1(this.input, this.Y, bArr2, i9, this.BlockSize);
        Bytes.xorTo(8, this.offset, this.input);
        giftb128(this.input, this.f4457k, this.Y);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        double_half_block(this.offset);
        Bytes.xor(this.BlockSize, this.Y, bArr, i8, bArr2, i9);
        pho1(this.input, this.Y, bArr, i8, this.BlockSize);
        Bytes.xorTo(8, this.offset, this.input);
        giftb128(this.input, this.f4457k, this.Y);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int processByte(byte b9, byte[] bArr, int i8) {
        return super.processByte(b9, bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        return super.processBytes(bArr, i8, i9, bArr2, i10);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalAAD() {
        AEADBaseEngine.State state;
        int len = this.dataOperator.getLen() - (this.forEncryption ? 0 : this.MAC_SIZE);
        triple_half_block(this.offset);
        if ((this.m_aadPos & 15) != 0 || (state = this.m_state) == AEADBaseEngine.State.DecInit || state == AEADBaseEngine.State.EncInit) {
            triple_half_block(this.offset);
        }
        if (len == 0) {
            triple_half_block(this.offset);
            triple_half_block(this.offset);
        }
        pho1(this.input, this.Y, this.m_aad, 0, this.m_aadPos);
        Bytes.xorTo(8, this.offset, this.input);
        giftb128(this.input, this.f4457k, this.Y);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i8) {
        GiftCofbEngine giftCofbEngine;
        int len = this.dataOperator.getLen() - (this.forEncryption ? 0 : this.MAC_SIZE);
        if (len != 0) {
            triple_half_block(this.offset);
            if ((len & 15) != 0) {
                triple_half_block(this.offset);
            }
            Bytes.xor(this.m_bufPos, this.Y, this.m_buf, 0, bArr, i8);
            if (this.forEncryption) {
                giftCofbEngine = this;
                giftCofbEngine.pho1(this.input, this.Y, this.m_buf, 0, this.m_bufPos);
            } else {
                giftCofbEngine = this;
                giftCofbEngine.pho1(giftCofbEngine.input, giftCofbEngine.Y, bArr, i8, giftCofbEngine.m_bufPos);
            }
            Bytes.xorTo(8, giftCofbEngine.offset, giftCofbEngine.input);
            giftCofbEngine.giftb128(giftCofbEngine.input, giftCofbEngine.f4457k, giftCofbEngine.Y);
        } else {
            giftCofbEngine = this;
        }
        System.arraycopy(giftCofbEngine.Y, 0, giftCofbEngine.mac, 0, giftCofbEngine.BlockSize);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void init(byte[] bArr, byte[] bArr2) {
        this.npub = bArr2;
        this.f4457k = bArr;
        this.Y = new byte[this.BlockSize];
        this.input = new byte[16];
        this.offset = new byte[8];
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void reset(boolean z) {
        super.reset(z);
        System.arraycopy(this.npub, 0, this.input, 0, this.IV_SIZE);
        giftb128(this.input, this.f4457k, this.Y);
        System.arraycopy(this.Y, 0, this.offset, 0, 8);
    }
}
