package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import m0.f;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class CCMBlockCipher implements CCMModeCipher {
    private int blockSize;
    private BlockCipher cipher;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private CipherParameters keyParam;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonce;
    private ExposedByteArrayOutputStream associatedText = new ExposedByteArrayOutputStream();
    private ExposedByteArrayOutputStream data = new ExposedByteArrayOutputStream();

    public static class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public CCMBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.macBlock = new byte[blockSize];
        if (blockSize != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    private int calculateMac(byte[] bArr, int i8, int i9, byte[] bArr2) {
        CBCBlockCipherMac cBCBlockCipherMac = new CBCBlockCipherMac(this.cipher, this.macSize * 8);
        cBCBlockCipherMac.init(this.keyParam);
        byte[] bArr3 = new byte[16];
        if (hasAssociatedText()) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        int i10 = 2;
        byte macSize = (byte) (bArr3[0] | ((((cBCBlockCipherMac.getMacSize() - 2) / 2) & 7) << 3));
        bArr3[0] = macSize;
        byte[] bArr4 = this.nonce;
        bArr3[0] = (byte) (macSize | ((14 - bArr4.length) & 7));
        System.arraycopy(bArr4, 0, bArr3, 1, bArr4.length);
        int i11 = i9;
        int i12 = 1;
        while (i11 > 0) {
            bArr3[16 - i12] = (byte) (i11 & 255);
            i11 >>>= 8;
            i12++;
        }
        cBCBlockCipherMac.update(bArr3, 0, 16);
        if (hasAssociatedText()) {
            int associatedTextLength = getAssociatedTextLength();
            if (associatedTextLength < 65280) {
                cBCBlockCipherMac.update((byte) (associatedTextLength >> 8));
                cBCBlockCipherMac.update((byte) associatedTextLength);
            } else {
                cBCBlockCipherMac.update((byte) -1);
                cBCBlockCipherMac.update((byte) -2);
                cBCBlockCipherMac.update((byte) (associatedTextLength >> 24));
                cBCBlockCipherMac.update((byte) (associatedTextLength >> 16));
                cBCBlockCipherMac.update((byte) (associatedTextLength >> 8));
                cBCBlockCipherMac.update((byte) associatedTextLength);
                i10 = 6;
            }
            byte[] bArr5 = this.initialAssociatedText;
            if (bArr5 != null) {
                cBCBlockCipherMac.update(bArr5, 0, bArr5.length);
            }
            if (this.associatedText.size() > 0) {
                cBCBlockCipherMac.update(this.associatedText.getBuffer(), 0, this.associatedText.size());
            }
            int i13 = (i10 + associatedTextLength) % 16;
            if (i13 != 0) {
                while (i13 != 16) {
                    cBCBlockCipherMac.update((byte) 0);
                    i13++;
                }
            }
        }
        cBCBlockCipherMac.update(bArr, i8, i9);
        return cBCBlockCipherMac.doFinal(bArr2, 0);
    }

    private int getAssociatedTextLength() {
        int size = this.associatedText.size();
        byte[] bArr = this.initialAssociatedText;
        return size + (bArr == null ? 0 : bArr.length);
    }

    private int getMacSize(boolean z, int i8) {
        if (!z || (i8 >= 32 && i8 <= 128 && (i8 & 15) == 0)) {
            return i8 >>> 3;
        }
        throw new IllegalArgumentException("tag length in octets must be one of {4,6,8,10,12,14,16}");
    }

    private boolean hasAssociatedText() {
        return getAssociatedTextLength() > 0;
    }

    public static CCMModeCipher newInstance(BlockCipher blockCipher) {
        return new CCMBlockCipher(blockCipher);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] bArr, int i8) throws InvalidCipherTextException {
        int iProcessPacket = processPacket(this.data.getBuffer(), 0, this.data.size(), bArr, i8);
        reset();
        return iProcessPacket;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CCM";
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public byte[] getMac() {
        int i8 = this.macSize;
        byte[] bArr = new byte[i8];
        System.arraycopy(this.macBlock, 0, bArr, 0, i8);
        return bArr;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getOutputSize(int i8) {
        int size = this.data.size() + i8;
        boolean z = this.forEncryption;
        int i9 = this.macSize;
        if (z) {
            return size + i9;
        }
        if (size < i9) {
            return 0;
        }
        return size - i9;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int i8) {
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        CipherParameters parameters;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            this.nonce = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            this.macSize = getMacSize(z, aEADParameters.getMacSize());
            parameters = aEADParameters.getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameters passed to CCM: "));
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.nonce = parametersWithIV.getIV();
            this.initialAssociatedText = null;
            this.macSize = getMacSize(z, 64);
            parameters = parametersWithIV.getParameters();
        }
        if (parameters != null) {
            this.keyParam = parameters;
        }
        byte[] bArr = this.nonce;
        if (bArr == null || bArr.length < 7 || bArr.length > 13) {
            throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
        }
        reset();
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte b9) throws IOException {
        this.associatedText.write(b9);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i8, int i9) throws IOException {
        this.associatedText.write(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte b9, byte[] bArr, int i8) throws IOException {
        this.data.write(b9);
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) throws IOException {
        if (bArr.length < i8 + i9) {
            throw new DataLengthException("Input buffer too short");
        }
        this.data.write(bArr, i8, i9);
        return 0;
    }

    public int processPacket(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) throws InvalidCipherTextException {
        int i11;
        if (this.keyParam == null) {
            throw new IllegalStateException("CCM cipher unitialized.");
        }
        byte[] bArr3 = this.nonce;
        int length = bArr3.length;
        int i12 = 15 - length;
        if (i12 < 4) {
            if (i9 - (!this.forEncryption ? 16 : 0) >= (1 << (i12 * 8))) {
                throw new IllegalStateException("CCM packet too large for choice of q");
            }
        }
        byte[] bArr4 = new byte[this.blockSize];
        bArr4[0] = (byte) ((14 - length) & 7);
        System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
        CTRModeCipher cTRModeCipherNewInstance = SICBlockCipher.newInstance(this.cipher);
        cTRModeCipherNewInstance.init(this.forEncryption, new ParametersWithIV(this.keyParam, bArr4));
        if (!this.forEncryption) {
            int i13 = this.macSize;
            if (i9 < i13) {
                throw new InvalidCipherTextException("data too short");
            }
            int i14 = i9 - i13;
            if (bArr2.length < i14 + i10) {
                throw new OutputLengthException("Output buffer too short.");
            }
            int i15 = i8 + i14;
            System.arraycopy(bArr, i15, this.macBlock, 0, i13);
            byte[] bArr5 = this.macBlock;
            cTRModeCipherNewInstance.processBlock(bArr5, 0, bArr5, 0);
            int i16 = this.macSize;
            while (true) {
                byte[] bArr6 = this.macBlock;
                if (i16 == bArr6.length) {
                    break;
                }
                bArr6[i16] = 0;
                i16++;
            }
            int i17 = i8;
            int i18 = i10;
            while (true) {
                i11 = this.blockSize;
                if (i17 >= i15 - i11) {
                    break;
                }
                cTRModeCipherNewInstance.processBlock(bArr, i17, bArr2, i18);
                int i19 = this.blockSize;
                i18 += i19;
                i17 += i19;
            }
            byte[] bArr7 = new byte[i11];
            int i20 = i14 - (i17 - i8);
            System.arraycopy(bArr, i17, bArr7, 0, i20);
            cTRModeCipherNewInstance.processBlock(bArr7, 0, bArr7, 0);
            System.arraycopy(bArr7, 0, bArr2, i18, i20);
            byte[] bArr8 = new byte[this.blockSize];
            calculateMac(bArr2, i10, i14, bArr8);
            if (Arrays.constantTimeAreEqual(this.macBlock, bArr8)) {
                return i14;
            }
            throw new InvalidCipherTextException("mac check in CCM failed");
        }
        int i21 = this.macSize + i9;
        if (bArr2.length < i21 + i10) {
            throw new OutputLengthException("Output buffer too short.");
        }
        calculateMac(bArr, i8, i9, this.macBlock);
        byte[] bArr9 = new byte[this.blockSize];
        cTRModeCipherNewInstance.processBlock(this.macBlock, 0, bArr9, 0);
        int i22 = i8;
        int i23 = i10;
        while (true) {
            int i24 = i8 + i9;
            int i25 = this.blockSize;
            if (i22 >= i24 - i25) {
                byte[] bArr10 = new byte[i25];
                int i26 = i24 - i22;
                System.arraycopy(bArr, i22, bArr10, 0, i26);
                cTRModeCipherNewInstance.processBlock(bArr10, 0, bArr10, 0);
                System.arraycopy(bArr10, 0, bArr2, i23, i26);
                System.arraycopy(bArr9, 0, bArr2, i10 + i9, this.macSize);
                return i21;
            }
            cTRModeCipherNewInstance.processBlock(bArr, i22, bArr2, i23);
            int i27 = this.blockSize;
            i23 += i27;
            i22 += i27;
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        this.cipher.reset();
        this.associatedText.reset();
        this.data.reset();
    }

    public byte[] processPacket(byte[] bArr, int i8, int i9) throws InvalidCipherTextException {
        int i10;
        if (this.forEncryption) {
            i10 = this.macSize + i9;
        } else {
            int i11 = this.macSize;
            if (i9 < i11) {
                throw new InvalidCipherTextException("data too short");
            }
            i10 = i9 - i11;
        }
        byte[] bArr2 = new byte[i10];
        processPacket(bArr, i8, i9, bArr2, 0);
        return bArr2;
    }
}
