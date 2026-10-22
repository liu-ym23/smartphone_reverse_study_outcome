package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class EAXBlockCipher implements AEADBlockCipher {
    private static final byte cTAG = 2;
    private static final byte hTAG = 1;
    private static final byte nTAG = 0;
    private byte[] associatedTextMac;
    private int blockSize;
    private byte[] bufBlock;
    private int bufOff;
    private CTRModeCipher cipher;
    private boolean cipherInitialized;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private Mac mac;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonceMac;

    public EAXBlockCipher(BlockCipher blockCipher) {
        this.blockSize = blockCipher.getBlockSize();
        CMac cMac = new CMac(blockCipher);
        this.mac = cMac;
        this.macBlock = new byte[this.blockSize];
        this.associatedTextMac = new byte[cMac.getMacSize()];
        this.nonceMac = new byte[this.mac.getMacSize()];
        this.cipher = SICBlockCipher.newInstance(blockCipher);
    }

    private void calculateMac() {
        byte[] bArr = new byte[this.blockSize];
        int i8 = 0;
        this.mac.doFinal(bArr, 0);
        while (true) {
            byte[] bArr2 = this.macBlock;
            if (i8 >= bArr2.length) {
                return;
            }
            bArr2[i8] = (byte) ((this.nonceMac[i8] ^ this.associatedTextMac[i8]) ^ bArr[i8]);
            i8++;
        }
    }

    private void initCipher() {
        if (this.cipherInitialized) {
            return;
        }
        this.cipherInitialized = true;
        this.mac.doFinal(this.associatedTextMac, 0);
        int i8 = this.blockSize;
        byte[] bArr = new byte[i8];
        bArr[i8 - 1] = 2;
        this.mac.update(bArr, 0, i8);
    }

    private int process(byte b9, byte[] bArr, int i8) {
        int iProcessBlock;
        byte[] bArr2 = this.bufBlock;
        int i9 = this.bufOff;
        int i10 = i9 + 1;
        this.bufOff = i10;
        bArr2[i9] = b9;
        if (i10 != bArr2.length) {
            return 0;
        }
        int length = bArr.length;
        int i11 = this.blockSize;
        if (length < i8 + i11) {
            throw new OutputLengthException("Output buffer is too short");
        }
        if (this.forEncryption) {
            iProcessBlock = this.cipher.processBlock(bArr2, 0, bArr, i8);
            this.mac.update(bArr, i8, this.blockSize);
        } else {
            this.mac.update(bArr2, 0, i11);
            iProcessBlock = this.cipher.processBlock(this.bufBlock, 0, bArr, i8);
        }
        this.bufOff = 0;
        if (!this.forEncryption) {
            byte[] bArr3 = this.bufBlock;
            System.arraycopy(bArr3, this.blockSize, bArr3, 0, this.macSize);
            this.bufOff = this.macSize;
        }
        return iProcessBlock;
    }

    private boolean verifyMac(byte[] bArr, int i8) {
        int i9 = 0;
        for (int i10 = 0; i10 < this.macSize; i10++) {
            i9 |= this.macBlock[i10] ^ bArr[i8 + i10];
        }
        return i9 == 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] bArr, int i8) throws InvalidCipherTextException {
        initCipher();
        int i9 = this.bufOff;
        byte[] bArr2 = this.bufBlock;
        byte[] bArr3 = new byte[bArr2.length];
        this.bufOff = 0;
        if (this.forEncryption) {
            int i10 = i8 + i9;
            if (bArr.length < this.macSize + i10) {
                throw new OutputLengthException("Output buffer too short");
            }
            this.cipher.processBlock(bArr2, 0, bArr3, 0);
            System.arraycopy(bArr3, 0, bArr, i8, i9);
            this.mac.update(bArr3, 0, i9);
            calculateMac();
            System.arraycopy(this.macBlock, 0, bArr, i10, this.macSize);
            reset(false);
            return i9 + this.macSize;
        }
        int i11 = this.macSize;
        if (i9 < i11) {
            throw new InvalidCipherTextException("data too short");
        }
        if (bArr.length < (i8 + i9) - i11) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (i9 > i11) {
            this.mac.update(bArr2, 0, i9 - i11);
            this.cipher.processBlock(this.bufBlock, 0, bArr3, 0);
            System.arraycopy(bArr3, 0, bArr, i8, i9 - this.macSize);
        }
        calculateMac();
        if (!verifyMac(this.bufBlock, i9 - this.macSize)) {
            throw new InvalidCipherTextException("mac check in EAX failed");
        }
        reset(false);
        return i9 - this.macSize;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.cipher.getUnderlyingCipher().getAlgorithmName() + "/EAX";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
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
        int i9 = i8 + this.bufOff;
        boolean z = this.forEncryption;
        int i10 = this.macSize;
        if (z) {
            return i9 + i10;
        }
        if (i9 < i10) {
            return 0;
        }
        return i9 - i10;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.cipher.getUnderlyingCipher();
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int i8) {
        int i9 = i8 + this.bufOff;
        if (!this.forEncryption) {
            int i10 = this.macSize;
            if (i9 < i10) {
                return 0;
            }
            i9 -= i10;
        }
        return i9 - (i9 % this.blockSize);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        byte[] iv;
        CipherParameters parameters;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            iv = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            this.macSize = aEADParameters.getMacSize() / 8;
            parameters = aEADParameters.getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to EAX");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            iv = parametersWithIV.getIV();
            this.initialAssociatedText = null;
            this.macSize = this.mac.getMacSize() / 2;
            parameters = parametersWithIV.getParameters();
        }
        this.bufBlock = new byte[z ? this.blockSize : this.blockSize + this.macSize];
        byte[] bArr = new byte[this.blockSize];
        this.mac.init(parameters);
        int i8 = this.blockSize;
        bArr[i8 - 1] = 0;
        this.mac.update(bArr, 0, i8);
        this.mac.update(iv, 0, iv.length);
        this.mac.doFinal(this.nonceMac, 0);
        this.cipher.init(true, new ParametersWithIV(parameters, this.nonceMac));
        reset();
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte b9) {
        if (this.cipherInitialized) {
            throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
        }
        this.mac.update(b9);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i8, int i9) {
        if (this.cipherInitialized) {
            throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
        }
        this.mac.update(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte b9, byte[] bArr, int i8) {
        initCipher();
        return process(b9, bArr, i8);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        initCipher();
        if (bArr.length < i8 + i9) {
            throw new DataLengthException("Input buffer too short");
        }
        if (bArr == bArr2 && Arrays.segmentsOverlap(i8, i9, i10, getUpdateOutputSize(i9))) {
            bArr = new byte[i9];
            System.arraycopy(bArr2, i8, bArr, 0, i9);
            i8 = 0;
        }
        int iProcess = 0;
        for (int i11 = 0; i11 != i9; i11++) {
            iProcess += process(bArr[i8 + i11], bArr2, i10 + iProcess);
        }
        return iProcess;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        reset(true);
    }

    private void reset(boolean z) {
        this.cipher.reset();
        this.mac.reset();
        this.bufOff = 0;
        Arrays.fill(this.bufBlock, (byte) 0);
        if (z) {
            Arrays.fill(this.macBlock, (byte) 0);
        }
        int i8 = this.blockSize;
        byte[] bArr = new byte[i8];
        bArr[i8 - 1] = 1;
        this.mac.update(bArr, 0, i8);
        this.cipherInitialized = false;
        byte[] bArr2 = this.initialAssociatedText;
        if (bArr2 != null) {
            processAADBytes(bArr2, 0, bArr2.length);
        }
    }
}
