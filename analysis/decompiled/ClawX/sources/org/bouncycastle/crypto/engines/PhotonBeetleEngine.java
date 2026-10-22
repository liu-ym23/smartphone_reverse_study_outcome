package org.bouncycastle.crypto.engines;

import java.lang.reflect.Array;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.digests.PhotonBeetleDigest;
import org.bouncycastle.crypto.engines.AEADBaseEngine;
import org.bouncycastle.util.Bytes;

/* loaded from: classes.dex */
public class PhotonBeetleEngine extends AEADBaseEngine {
    private static final int D = 8;
    private byte[] K;
    private final int LAST_THREE_BITS_OFFSET;
    private byte[] N;
    private final int RATE_INBYTES_HALF;
    private final int STATE_INBYTES;
    private boolean input_empty;
    private byte[] state;
    private static final byte[][] RC = {new byte[]{1, 3, 7, 14, 13, 11, 6, 12, 9, 2, 5, 10}, new byte[]{0, 2, 6, 15, 12, 10, 7, 13, 8, 3, 4, 11}, new byte[]{2, 0, 4, 13, 14, 8, 5, 15, 10, 1, 6, 9}, new byte[]{6, 4, 0, 9, 10, 12, 1, 11, 14, 5, 2, 13}, new byte[]{14, 12, 8, 1, 2, 4, 9, 3, 6, 13, 10, 5}, new byte[]{15, 13, 9, 0, 3, 5, 8, 2, 7, 12, 11, 4}, new byte[]{13, 15, 11, 2, 1, 7, 10, 0, 5, 14, 9, 6}, new byte[]{9, 11, 15, 6, 5, 3, 14, 4, 1, 10, 13, 2}};
    private static final byte[][] MixColMatrix = {new byte[]{2, 4, 2, 11, 2, 8, 5, 6}, new byte[]{12, 9, 8, 13, 7, 7, 5, 2}, new byte[]{4, 4, 13, 13, 9, 4, 13, 9}, new byte[]{1, 6, 5, 1, 12, 13, 15, 14}, new byte[]{15, 12, 9, 13, 14, 5, 14, 13}, new byte[]{9, 14, 5, 15, 4, 12, 9, 6}, new byte[]{12, 2, 2, 10, 3, 1, 1, 14}, new byte[]{15, 1, 13, 10, 5, 10, 2, 3}};
    private static final byte[] sbox = {12, 5, 6, 11, 9, 0, 10, 13, 3, 14, 15, 8, 4, 7, 1, 2};

    public enum PhotonBeetleParameters {
        pb32,
        pb128
    }

    public PhotonBeetleEngine(PhotonBeetleParameters photonBeetleParameters) {
        int i8;
        int i9;
        this.MAC_SIZE = 16;
        this.IV_SIZE = 16;
        this.KEY_SIZE = 16;
        int iOrdinal = photonBeetleParameters.ordinal();
        if (iOrdinal != 0) {
            i8 = iOrdinal != 1 ? 0 : 128;
            i9 = i8;
        } else {
            i8 = 32;
            i9 = BERTags.FLAGS;
        }
        int i10 = i8 + 7;
        int i11 = i10 >>> 3;
        this.BlockSize = i11;
        this.AADBufferSize = i11;
        this.RATE_INBYTES_HALF = i10 >>> 4;
        int i12 = ((i8 + i9) + 7) >>> 3;
        this.STATE_INBYTES = i12;
        this.LAST_THREE_BITS_OFFSET = (r4 - ((i12 - 1) << 3)) - 3;
        this.algorithmName = "Photon-Beetle AEAD";
        this.state = new byte[i12];
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Buffered, AEADBaseEngine.AADOperatorType.Counter, AEADBaseEngine.DataOperatorType.Counter);
    }

    public static void photonPermutation(PhotonBeetleDigest.Friend friend, byte[] bArr) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by PhotonBeetleDigest");
        }
        photonPermutation(bArr);
    }

    private void rhoohr(byte[] bArr, int i8, byte[] bArr2, int i9, int i10) {
        photonPermutation(this.state);
        byte[] bArr3 = new byte[8];
        int iMin = Math.min(i10, this.RATE_INBYTES_HALF);
        int i11 = 0;
        while (true) {
            int i12 = this.RATE_INBYTES_HALF;
            if (i11 >= i12 - 1) {
                byte[] bArr4 = this.state;
                bArr3[i12 - 1] = (byte) (((bArr4[0] & 1) << 7) | ((bArr4[i11] & 255) >>> 1));
                Bytes.xor(iMin, bArr4, i12, bArr2, i9, bArr, i8);
                Bytes.xor(i10 - iMin, bArr3, iMin - this.RATE_INBYTES_HALF, bArr2, i9 + iMin, bArr, i8 + iMin);
                return;
            }
            byte[] bArr5 = this.state;
            int i13 = i11 + 1;
            bArr3[i11] = (byte) (((bArr5[i13] & 1) << 7) | ((bArr5[i11] & 255) >>> 1));
            i11 = i13;
        }
    }

    private byte select(boolean z, boolean z2, byte b9, byte b10) {
        if (z && z2) {
            return (byte) 1;
        }
        if (z) {
            return (byte) 2;
        }
        return z2 ? b9 : b10;
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
        photonPermutation(this.state);
        Bytes.xorTo(this.BlockSize, bArr, i8, this.state);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        rhoohr(bArr2, i9, bArr, i8, this.BlockSize);
        Bytes.xorTo(this.BlockSize, bArr2, i9, this.state);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        rhoohr(bArr2, i9, bArr, i8, this.BlockSize);
        Bytes.xorTo(this.BlockSize, bArr, i8, this.state);
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
        int len = this.aadOperator.getLen();
        if (len != 0) {
            if (this.m_aadPos != 0) {
                photonPermutation(this.state);
                Bytes.xorTo(this.m_aadPos, this.m_aad, this.state);
                int i8 = this.m_aadPos;
                if (i8 < this.BlockSize) {
                    byte[] bArr = this.state;
                    bArr[i8] = (byte) (bArr[i8] ^ 1);
                }
            }
            byte[] bArr2 = this.state;
            int i9 = this.STATE_INBYTES - 1;
            bArr2[i9] = (byte) ((select(this.dataOperator.getLen() - (this.forEncryption ? 0 : this.MAC_SIZE) > 0, len % this.BlockSize == 0, (byte) 3, (byte) 4) << this.LAST_THREE_BITS_OFFSET) ^ bArr2[i9]);
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i8) {
        PhotonBeetleEngine photonBeetleEngine;
        int len = this.dataOperator.getLen() - (this.forEncryption ? 0 : this.MAC_SIZE);
        int i9 = this.m_bufPos;
        int len2 = this.aadOperator.getLen();
        if (len2 != 0 || len != 0) {
            this.input_empty = false;
        }
        byte bSelect = select(len2 != 0, len % this.BlockSize == 0, (byte) 5, (byte) 6);
        if (len != 0) {
            if (i9 != 0) {
                photonBeetleEngine = this;
                photonBeetleEngine.rhoohr(bArr, i8, this.m_buf, 0, i9);
                if (photonBeetleEngine.forEncryption) {
                    Bytes.xorTo(i9, photonBeetleEngine.m_buf, photonBeetleEngine.state);
                } else {
                    Bytes.xorTo(i9, bArr, i8, photonBeetleEngine.state);
                }
                if (i9 < photonBeetleEngine.BlockSize) {
                    byte[] bArr2 = photonBeetleEngine.state;
                    bArr2[i9] = (byte) (bArr2[i9] ^ 1);
                }
            } else {
                photonBeetleEngine = this;
            }
            byte[] bArr3 = photonBeetleEngine.state;
            int i10 = photonBeetleEngine.STATE_INBYTES - 1;
            bArr3[i10] = (byte) (bArr3[i10] ^ (bSelect << photonBeetleEngine.LAST_THREE_BITS_OFFSET));
        } else {
            photonBeetleEngine = this;
            if (photonBeetleEngine.input_empty) {
                byte[] bArr4 = photonBeetleEngine.state;
                int i11 = photonBeetleEngine.STATE_INBYTES - 1;
                bArr4[i11] = (byte) (bArr4[i11] ^ (1 << photonBeetleEngine.LAST_THREE_BITS_OFFSET));
            }
        }
        photonPermutation(photonBeetleEngine.state);
        System.arraycopy(photonBeetleEngine.state, 0, photonBeetleEngine.mac, 0, photonBeetleEngine.MAC_SIZE);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    private static void photonPermutation(byte[] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 8, 8);
        for (int i8 = 0; i8 < 64; i8++) {
            bArr2[i8 >>> 3][i8 & 7] = (byte) (((bArr[i8 >> 1] & 255) >>> ((i8 & 1) * 4)) & 15);
        }
        for (int i9 = 0; i9 < 12; i9++) {
            for (int i10 = 0; i10 < 8; i10++) {
                byte[] bArr3 = bArr2[i10];
                bArr3[0] = (byte) (bArr3[0] ^ RC[i10][i9]);
            }
            for (int i11 = 0; i11 < 8; i11++) {
                for (int i12 = 0; i12 < 8; i12++) {
                    byte[] bArr4 = bArr2[i11];
                    bArr4[i12] = sbox[bArr4[i12]];
                }
            }
            for (int i13 = 1; i13 < 8; i13++) {
                System.arraycopy(bArr2[i13], 0, bArr, 0, 8);
                int i14 = 8 - i13;
                System.arraycopy(bArr, i13, bArr2[i13], 0, i14);
                System.arraycopy(bArr, 0, bArr2[i13], i14, i13);
            }
            for (int i15 = 0; i15 < 8; i15++) {
                for (int i16 = 0; i16 < 8; i16++) {
                    int i17 = 0;
                    for (int i18 = 0; i18 < 8; i18++) {
                        byte b9 = MixColMatrix[i16][i18];
                        byte b10 = bArr2[i18][i15];
                        i17 = (((i17 ^ ((b10 & 1) * b9)) ^ ((b10 & 2) * b9)) ^ ((b10 & 4) * b9)) ^ (b9 * (b10 & 8));
                    }
                    int i19 = i17 >>> 4;
                    int i20 = (i19 << 1) ^ ((i17 & 15) ^ i19);
                    int i21 = i20 >>> 4;
                    bArr[i16] = (byte) (((i20 & 15) ^ i21) ^ (i21 << 1));
                }
                for (int i22 = 0; i22 < 8; i22++) {
                    bArr2[i22][i15] = bArr[i22];
                }
            }
        }
        for (int i23 = 0; i23 < 64; i23 += 2) {
            byte[] bArr5 = bArr2[i23 >>> 3];
            bArr[i23 >>> 1] = (byte) (((bArr5[(i23 + 1) & 7] & 15) << 4) | (bArr5[i23 & 7] & 15));
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void init(byte[] bArr, byte[] bArr2) {
        this.K = bArr;
        this.N = bArr2;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void reset(boolean z) {
        super.reset(z);
        this.input_empty = true;
        byte[] bArr = this.K;
        System.arraycopy(bArr, 0, this.state, 0, bArr.length);
        byte[] bArr2 = this.N;
        System.arraycopy(bArr2, 0, this.state, this.K.length, bArr2.length);
    }
}
