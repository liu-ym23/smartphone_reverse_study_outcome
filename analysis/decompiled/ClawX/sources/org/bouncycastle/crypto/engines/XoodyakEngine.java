package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.digests.XoodyakDigest;
import org.bouncycastle.crypto.engines.AEADBaseEngine;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Bytes;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class XoodyakEngine extends AEADBaseEngine {
    private static final int ModeHash = 1;
    private static final int ModeKeyed = 0;
    private static final int PhaseDown = 1;
    private static final int PhaseUp = 2;
    private static final int[] RC = {88, 56, 960, 208, 288, 20, 96, 44, 896, 240, 416, 18};
    private static final int f_bPrime_1 = 47;
    private byte[] K;
    private byte aadcd;
    private boolean encrypted;
    private byte[] iv;
    private int mode;
    private int phase;
    private final byte[] state;

    public XoodyakEngine() {
        this.algorithmName = "Xoodyak AEAD";
        this.MAC_SIZE = 16;
        this.IV_SIZE = 16;
        this.KEY_SIZE = 16;
        this.BlockSize = 24;
        this.AADBufferSize = 44;
        this.state = new byte[48];
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.Default, AEADBaseEngine.DataOperatorType.Counter);
    }

    private void AbsorbAny(byte[] bArr, int i8, int i9, int i10) {
        if (this.phase != 2) {
            up(this.mode, this.state, 0);
        }
        int i11 = i8;
        int i12 = i10;
        while (true) {
            int iMin = Math.min(i9, this.AADBufferSize);
            byte[] bArr2 = bArr;
            down(this.mode, this.state, bArr2, i11, iMin, i12);
            this.phase = 1;
            i11 += iMin;
            i9 -= iMin;
            if (i9 == 0) {
                return;
            }
            i12 = 0;
            bArr = bArr2;
        }
    }

    private static void down(int i8, byte[] bArr, byte[] bArr2, int i9, int i10, int i11) {
        Bytes.xorTo(i10, bArr2, i9, bArr);
        bArr[i10] = (byte) (bArr[i10] ^ 1);
        int i12 = bArr[f_bPrime_1];
        if (i8 == 1) {
            i11 &= 1;
        }
        bArr[f_bPrime_1] = (byte) (i12 ^ i11);
    }

    private static void up(int i8, byte[] bArr, int i9) {
        if (i8 != 1) {
            bArr[f_bPrime_1] = (byte) (bArr[f_bPrime_1] ^ i9);
        }
        int iLittleEndianToInt = Pack.littleEndianToInt(bArr, 0);
        int iLittleEndianToInt2 = Pack.littleEndianToInt(bArr, 4);
        int iLittleEndianToInt3 = Pack.littleEndianToInt(bArr, 8);
        int i10 = 12;
        int iLittleEndianToInt4 = Pack.littleEndianToInt(bArr, 12);
        int iLittleEndianToInt5 = Pack.littleEndianToInt(bArr, 16);
        int iLittleEndianToInt6 = Pack.littleEndianToInt(bArr, 20);
        int iLittleEndianToInt7 = Pack.littleEndianToInt(bArr, 24);
        int iLittleEndianToInt8 = Pack.littleEndianToInt(bArr, 28);
        int iLittleEndianToInt9 = Pack.littleEndianToInt(bArr, 32);
        int i11 = 0;
        int i12 = iLittleEndianToInt8;
        int iRotateLeft = iLittleEndianToInt9;
        int iLittleEndianToInt10 = Pack.littleEndianToInt(bArr, 36);
        int iLittleEndianToInt11 = Pack.littleEndianToInt(bArr, 40);
        int iLittleEndianToInt12 = Pack.littleEndianToInt(bArr, 44);
        while (i11 < i10) {
            int i13 = (iLittleEndianToInt ^ iLittleEndianToInt5) ^ iRotateLeft;
            int i14 = (iLittleEndianToInt2 ^ iLittleEndianToInt6) ^ iLittleEndianToInt10;
            int i15 = i11;
            int i16 = (iLittleEndianToInt3 ^ iLittleEndianToInt7) ^ iLittleEndianToInt11;
            int i17 = iLittleEndianToInt12;
            int i18 = (iLittleEndianToInt4 ^ i12) ^ i17;
            int i19 = iLittleEndianToInt11;
            int iRotateLeft2 = Integers.rotateLeft(i18, 5) ^ Integers.rotateLeft(i18, 14);
            int iRotateLeft3 = Integers.rotateLeft(i13, 5) ^ Integers.rotateLeft(i13, 14);
            int iRotateLeft4 = Integers.rotateLeft(i14, 5) ^ Integers.rotateLeft(i14, 14);
            int iRotateLeft5 = Integers.rotateLeft(i16, 5) ^ Integers.rotateLeft(i16, 14);
            int i20 = iLittleEndianToInt ^ iRotateLeft2;
            int i21 = iLittleEndianToInt5 ^ iRotateLeft2;
            int i22 = iRotateLeft ^ iRotateLeft2;
            int i23 = iLittleEndianToInt2 ^ iRotateLeft3;
            int i24 = iLittleEndianToInt6 ^ iRotateLeft3;
            int i25 = iRotateLeft3 ^ iLittleEndianToInt10;
            int i26 = iLittleEndianToInt3 ^ iRotateLeft4;
            int i27 = iLittleEndianToInt7 ^ iRotateLeft4;
            int i28 = iLittleEndianToInt4 ^ iRotateLeft5;
            int i29 = i12 ^ iRotateLeft5;
            int iRotateLeft6 = Integers.rotateLeft(i22, 11);
            int iRotateLeft7 = Integers.rotateLeft(i25, 11);
            int iRotateLeft8 = Integers.rotateLeft(i19 ^ iRotateLeft4, 11);
            int iRotateLeft9 = Integers.rotateLeft(i17 ^ iRotateLeft5, 11);
            int i30 = i20 ^ RC[i15];
            int i31 = ((~i29) & iRotateLeft6) ^ i30;
            int i32 = ((~i21) & iRotateLeft7) ^ i23;
            int i33 = ((~i24) & iRotateLeft8) ^ i26;
            int i34 = ((~i27) & iRotateLeft9) ^ i28;
            int i35 = ((~iRotateLeft6) & i30) ^ i29;
            int i36 = i21 ^ ((~iRotateLeft7) & i23);
            int i37 = ((~iRotateLeft8) & i26) ^ i24;
            int i38 = ((~iRotateLeft9) & i28) ^ i27;
            int i39 = iRotateLeft6 ^ ((~i30) & i29);
            int i40 = iRotateLeft7 ^ ((~i23) & i21);
            int i41 = iRotateLeft8 ^ ((~i26) & i24);
            int i42 = iRotateLeft9 ^ ((~i28) & i27);
            iLittleEndianToInt5 = Integers.rotateLeft(i35, 1);
            int iRotateLeft10 = Integers.rotateLeft(i36, 1);
            int iRotateLeft11 = Integers.rotateLeft(i37, 1);
            int iRotateLeft12 = Integers.rotateLeft(i38, 1);
            iRotateLeft = Integers.rotateLeft(i41, 8);
            iLittleEndianToInt10 = Integers.rotateLeft(i42, 8);
            iLittleEndianToInt11 = Integers.rotateLeft(i39, 8);
            iLittleEndianToInt12 = Integers.rotateLeft(i40, 8);
            iLittleEndianToInt = i31;
            iLittleEndianToInt6 = iRotateLeft10;
            iLittleEndianToInt3 = i33;
            i10 = 12;
            iLittleEndianToInt7 = iRotateLeft11;
            i11 = i15 + 1;
            iLittleEndianToInt2 = i32;
            i12 = iRotateLeft12;
            iLittleEndianToInt4 = i34;
        }
        Pack.intToLittleEndian(iLittleEndianToInt, bArr, 0);
        Pack.intToLittleEndian(iLittleEndianToInt2, bArr, 4);
        Pack.intToLittleEndian(iLittleEndianToInt3, bArr, 8);
        Pack.intToLittleEndian(iLittleEndianToInt4, bArr, 12);
        Pack.intToLittleEndian(iLittleEndianToInt5, bArr, 16);
        Pack.intToLittleEndian(iLittleEndianToInt6, bArr, 20);
        Pack.intToLittleEndian(iLittleEndianToInt7, bArr, 24);
        Pack.intToLittleEndian(i12, bArr, 28);
        Pack.intToLittleEndian(iRotateLeft, bArr, 32);
        Pack.intToLittleEndian(iLittleEndianToInt10, bArr, 36);
        Pack.intToLittleEndian(iLittleEndianToInt11, bArr, 40);
        Pack.intToLittleEndian(iLittleEndianToInt12, bArr, 44);
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
        AbsorbAny(bArr, i8, this.AADBufferSize, this.aadcd);
        this.aadcd = (byte) 0;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        up(this.mode, this.state, this.encrypted ? 0 : 128);
        Bytes.xor(this.BlockSize, this.state, bArr, i8, bArr2, i9);
        down(this.mode, this.state, bArr2, i9, this.BlockSize, 0);
        this.phase = 1;
        this.encrypted = true;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        up(this.mode, this.state, this.encrypted ? 0 : 128);
        Bytes.xor(this.BlockSize, this.state, bArr, i8, bArr2, i9);
        down(this.mode, this.state, bArr, i8, this.BlockSize, 0);
        this.phase = 1;
        this.encrypted = true;
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
        AbsorbAny(this.m_aad, 0, this.m_aadPos, this.aadcd);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i8) {
        if (this.m_bufPos != 0 || !this.encrypted) {
            up(this.mode, this.state, this.encrypted ? 0 : 128);
            Bytes.xor(this.m_bufPos, this.state, this.m_buf, 0, bArr, i8);
            if (this.forEncryption) {
                down(this.mode, this.state, this.m_buf, 0, this.m_bufPos, 0);
            } else {
                down(this.mode, this.state, bArr, i8, this.m_bufPos, 0);
            }
            this.phase = 1;
        }
        up(this.mode, this.state, 64);
        System.arraycopy(this.state, 0, this.mac, 0, this.MAC_SIZE);
        this.phase = 2;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    public static void down(XoodyakDigest.Friend friend, int i8, byte[] bArr, byte[] bArr2, int i9, int i10, int i11) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by XoodyakDigest");
        }
        down(i8, bArr, bArr2, i9, i10, i11);
    }

    public static void up(XoodyakDigest.Friend friend, int i8, byte[] bArr, int i9) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by XoodyakDigest");
        }
        up(i8, bArr, i9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void init(byte[] bArr, byte[] bArr2) {
        this.K = bArr;
        this.iv = bArr2;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void reset(boolean z) {
        super.reset(z);
        Arrays.fill(this.state, (byte) 0);
        this.encrypted = false;
        this.phase = 2;
        this.aadcd = (byte) 3;
        byte[] bArr = this.K;
        int length = bArr.length;
        int length2 = this.iv.length;
        byte[] bArr2 = new byte[this.AADBufferSize];
        this.mode = 0;
        System.arraycopy(bArr, 0, bArr2, 0, length);
        System.arraycopy(this.iv, 0, bArr2, length, length2);
        int i8 = length + length2;
        bArr2[i8] = (byte) length2;
        AbsorbAny(bArr2, 0, i8 + 1, 2);
    }
}
