package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.digests.Blake2xsDigest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* loaded from: classes.dex */
public class Grainv1Engine implements StreamCipher {
    private static final int STATE_SIZE = 5;
    private int index = 2;
    private boolean initialised = false;
    private int[] lfsr;
    private int[] nfsr;
    private byte[] out;
    private int output;
    private byte[] workingIV;
    private byte[] workingKey;

    private byte getKeyStream() {
        if (this.index > 1) {
            oneRound();
            this.index = 0;
        }
        byte[] bArr = this.out;
        int i8 = this.index;
        this.index = i8 + 1;
        return bArr[i8];
    }

    private int getOutput() {
        int[] iArr = this.nfsr;
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = (i8 >>> 1) | (i9 << 15);
        int i11 = (i8 >>> 2) | (i9 << 14);
        int i12 = (i8 >>> 4) | (i9 << 12);
        int i13 = (i8 >>> 10) | (i9 << 6);
        int i14 = iArr[2];
        int i15 = (i9 >>> 15) | (i14 << 1);
        int i16 = iArr[3];
        int i17 = (i14 >>> 11) | (i16 << 5);
        int i18 = iArr[4];
        int i19 = (i16 >>> 8) | (i18 << 8);
        int i20 = (i18 << 1) | (i16 >>> 15);
        int[] iArr2 = this.lfsr;
        int i21 = iArr2[0] >>> 3;
        int i22 = iArr2[1];
        int i23 = i21 | (i22 << 13);
        int i24 = iArr2[2];
        int i25 = (i22 >>> 9) | (i24 << 7);
        int i26 = (iArr2[3] << 2) | (i24 >>> 14);
        int i27 = iArr2[4];
        int i28 = i26 & i27;
        int i29 = ((((i25 ^ i20) ^ (i23 & i27)) ^ i28) ^ (i27 & i20)) ^ ((i23 & i25) & i26);
        int i30 = i23 & i26;
        return ((((((((((((i27 & i30) ^ i29) ^ (i30 & i20)) ^ ((i25 & i26) & i20)) ^ (i20 & i28)) ^ i10) ^ i11) ^ i12) ^ i13) ^ i15) ^ i17) ^ i19) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
    }

    private int getOutputLFSR() {
        int[] iArr = this.lfsr;
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = (i8 >>> 13) | (i9 << 3);
        int i11 = iArr[2];
        int i12 = (i9 >>> 7) | (i11 << 9);
        int i13 = iArr[3];
        int i14 = (i11 >>> 6) | (i13 << 10);
        int i15 = iArr[4];
        int i16 = (i13 >>> 3) | (i15 << 13);
        return (((i15 << 2) | (i13 >>> 14)) ^ ((((i8 ^ i10) ^ i12) ^ i14) ^ i16)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
    }

    private int getOutputNFSR() {
        int[] iArr = this.nfsr;
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = (i8 >>> 9) | (i9 << 7);
        int i11 = (i8 >>> 14) | (i9 << 2);
        int i12 = (i8 >>> 15) | (i9 << 1);
        int i13 = iArr[2];
        int i14 = (i9 >>> 5) | (i13 << 11);
        int i15 = (i9 >>> 12) | (i13 << 4);
        int i16 = iArr[3];
        int i17 = (i13 >>> 1) | (i16 << 15);
        int i18 = (i13 >>> 5) | (i16 << 11);
        int i19 = (i13 >>> 13) | (i16 << 3);
        int i20 = iArr[4];
        int i21 = (i16 >>> 4) | (i20 << 12);
        int i22 = (i16 >>> 12) | (i20 << 4);
        int i23 = (i16 >>> 14) | (i20 << 2);
        int i24 = (i20 << 1) | (i16 >>> 15);
        int i25 = i24 & i22;
        int i26 = (((i8 ^ (((((((((i23 ^ i22) ^ i21) ^ i19) ^ i18) ^ i17) ^ i15) ^ i14) ^ i11) ^ i10)) ^ i25) ^ (i18 & i17)) ^ (i12 & i10);
        int i27 = i22 & i21;
        int i28 = i17 & i15 & i14;
        return (((((((((i24 & i19) & i15) & i10) ^ ((i26 ^ (i27 & i19)) ^ i28)) ^ ((i27 & i18) & i17)) ^ ((i25 & i14) & i12)) ^ (((i25 & i21) & i19) & i18)) ^ ((i28 & i12) & i10)) ^ (((((i21 & i19) & i18) & i17) & i15) & i14)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
    }

    private void initGrain() {
        for (int i8 = 0; i8 < 10; i8++) {
            this.output = getOutput();
            this.nfsr = shift(this.nfsr, (getOutputNFSR() ^ this.lfsr[0]) ^ this.output);
            this.lfsr = shift(this.lfsr, getOutputLFSR() ^ this.output);
        }
        this.initialised = true;
    }

    private void oneRound() {
        int output = getOutput();
        this.output = output;
        byte[] bArr = this.out;
        bArr[0] = (byte) output;
        bArr[1] = (byte) (output >> 8);
        this.nfsr = shift(this.nfsr, getOutputNFSR() ^ this.lfsr[0]);
        this.lfsr = shift(this.lfsr, getOutputLFSR());
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        bArr2[8] = -1;
        bArr2[9] = -1;
        this.workingKey = bArr;
        this.workingIV = bArr2;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int[] iArr = this.nfsr;
            if (i8 >= iArr.length) {
                return;
            }
            byte[] bArr3 = this.workingKey;
            int i10 = i9 + 1;
            iArr[i8] = ((bArr3[i9] & 255) | (bArr3[i10] << 8)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
            int[] iArr2 = this.lfsr;
            byte[] bArr4 = this.workingIV;
            iArr2[i8] = ((bArr4[i9] & 255) | (bArr4[i10] << 8)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
            i9 += 2;
            i8++;
        }
    }

    private int[] shift(int[] iArr, int i8) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = iArr[4];
        iArr[4] = i8;
        return iArr;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "Grain v1";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("Grain v1 init parameters must include an IV");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] iv = parametersWithIV.getIV();
        if (iv == null || iv.length != 8) {
            throw new IllegalArgumentException("Grain v1 requires exactly 8 bytes of IV");
        }
        if (!(parametersWithIV.getParameters() instanceof KeyParameter)) {
            throw new IllegalArgumentException("Grain v1 init parameters must include a key");
        }
        byte[] key = ((KeyParameter) parametersWithIV.getParameters()).getKey();
        if (key.length != 10) {
            throw new IllegalArgumentException("Grain v1 key must be 80 bits long");
        }
        byte[] bArr = new byte[key.length];
        this.workingIV = bArr;
        this.workingKey = new byte[key.length];
        this.lfsr = new int[5];
        this.nfsr = new int[5];
        this.out = new byte[2];
        System.arraycopy(iv, 0, bArr, 0, iv.length);
        System.arraycopy(key, 0, this.workingKey, 0, key.length);
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 80, cipherParameters, Utils.getPurpose(z)));
        reset();
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i8 + i9 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i10 + i9 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i11 = 0; i11 < i9; i11++) {
            bArr2[i10 + i11] = (byte) (bArr[i8 + i11] ^ getKeyStream());
        }
        return i9;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        this.index = 2;
        setKey(this.workingKey, this.workingIV);
        initGrain();
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte b9) {
        if (this.initialised) {
            return (byte) (getKeyStream() ^ b9);
        }
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }
}
