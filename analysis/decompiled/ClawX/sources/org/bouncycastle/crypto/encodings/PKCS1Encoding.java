package org.bouncycastle.crypto.encodings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

/* loaded from: classes.dex */
public class PKCS1Encoding implements AsymmetricBlockCipher {
    private static final int HEADER_LENGTH = 10;
    public static final String NOT_STRICT_LENGTH_ENABLED_PROPERTY = "org.bouncycastle.pkcs1.not_strict";
    public static final String STRICT_LENGTH_ENABLED_PROPERTY = "org.bouncycastle.pkcs1.strict";
    private byte[] blockBuffer;
    private AsymmetricBlockCipher engine;
    private byte[] fallback;
    private boolean forEncryption;
    private boolean forPrivateKey;
    private int pLen;
    private SecureRandom random;
    private boolean useStrictLength;

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.pLen = -1;
        this.fallback = null;
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
    }

    private static int checkPkcs1Encoding1(byte[] bArr) {
        int i8 = 0;
        int i9 = -((bArr[0] & 255) ^ 1);
        int i10 = 0;
        for (int i11 = 1; i11 < bArr.length; i11++) {
            int i12 = bArr[i11] & 255;
            int i13 = (i12 - 1) >> 31;
            i8 ^= ((~i10) & i11) & i13;
            i10 |= i13;
            i9 |= ~((((i12 ^ 255) - 1) >> 31) | i10);
        }
        return ((bArr.length - 1) - i8) | (((i8 - 9) | i9) >> 31);
    }

    private static int checkPkcs1Encoding2(byte[] bArr) {
        int i8 = 0;
        int i9 = -((bArr[0] & 255) ^ 2);
        int i10 = 0;
        for (int i11 = 1; i11 < bArr.length; i11++) {
            int i12 = ((bArr[i11] & 255) - 1) >> 31;
            i8 ^= ((~i10) & i11) & i12;
            i10 |= i12;
        }
        return ((bArr.length - 1) - i8) | ((i9 | (i8 - 9)) >> 31);
    }

    private byte[] decodeBlock(byte[] bArr, int i8, int i9) {
        if (this.forPrivateKey && this.pLen != -1) {
            return decodeBlockOrRandom(bArr, i8, i9);
        }
        int outputBlockSize = this.engine.getOutputBlockSize();
        byte[] bArrProcessBlock = this.engine.processBlock(bArr, i8, i9);
        boolean z = this.useStrictLength & (bArrProcessBlock.length != outputBlockSize);
        byte[] bArr2 = bArrProcessBlock.length < outputBlockSize ? this.blockBuffer : bArrProcessBlock;
        int iCheckPkcs1Encoding2 = this.forPrivateKey ? checkPkcs1Encoding2(bArr2) : checkPkcs1Encoding1(bArr2);
        try {
            if (iCheckPkcs1Encoding2 < 0) {
                throw new InvalidCipherTextException("block incorrect");
            }
            if (z) {
                throw new InvalidCipherTextException("block incorrect size");
            }
            byte[] bArr3 = new byte[iCheckPkcs1Encoding2];
            System.arraycopy(bArr2, bArr2.length - iCheckPkcs1Encoding2, bArr3, 0, iCheckPkcs1Encoding2);
            return bArr3;
        } finally {
            Arrays.fill(bArrProcessBlock, (byte) 0);
            byte[] bArr4 = this.blockBuffer;
            Arrays.fill(bArr4, 0, Math.max(0, bArr4.length - bArrProcessBlock.length), (byte) 0);
        }
    }

    private byte[] decodeBlockOrRandom(byte[] bArr, int i8, int i9) throws InvalidCipherTextException {
        if (!this.forPrivateKey) {
            throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
        }
        int i10 = this.pLen;
        byte[] bArr2 = this.fallback;
        if (bArr2 == null) {
            bArr2 = new byte[i10];
            this.random.nextBytes(bArr2);
        }
        int outputBlockSize = this.engine.getOutputBlockSize();
        byte[] bArrProcessBlock = this.engine.processBlock(bArr, i8, i9);
        byte[] bArr3 = (bArrProcessBlock.length == outputBlockSize || (!this.useStrictLength && bArrProcessBlock.length >= outputBlockSize)) ? bArrProcessBlock : this.blockBuffer;
        int iCheckPkcs1Encoding2 = checkPkcs1Encoding2(bArr3, i10);
        int length = bArr3.length - i10;
        byte[] bArr4 = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr4[i11] = (byte) ((bArr3[length + i11] & (~iCheckPkcs1Encoding2)) | (bArr2[i11] & iCheckPkcs1Encoding2));
        }
        Arrays.fill(bArrProcessBlock, (byte) 0);
        byte[] bArr5 = this.blockBuffer;
        Arrays.fill(bArr5, 0, Math.max(0, bArr5.length - bArrProcessBlock.length), (byte) 0);
        return bArr4;
    }

    private byte[] encodeBlock(byte[] bArr, int i8, int i9) {
        if (i9 > getInputBlockSize()) {
            throw new IllegalArgumentException("input data too large");
        }
        int inputBlockSize = this.engine.getInputBlockSize();
        byte[] bArr2 = new byte[inputBlockSize];
        if (this.forPrivateKey) {
            bArr2[0] = 1;
            for (int i10 = 1; i10 != (inputBlockSize - i9) - 1; i10++) {
                bArr2[i10] = -1;
            }
        } else {
            this.random.nextBytes(bArr2);
            bArr2[0] = 2;
            for (int i11 = 1; i11 != (inputBlockSize - i9) - 1; i11++) {
                while (bArr2[i11] == 0) {
                    bArr2[i11] = (byte) this.random.nextInt();
                }
            }
        }
        int i12 = inputBlockSize - i9;
        bArr2[i12 - 1] = 0;
        System.arraycopy(bArr, i8, bArr2, i12, i9);
        return this.engine.processBlock(bArr2, 0, inputBlockSize);
    }

    private boolean useStrict() {
        if (Properties.isOverrideSetTo(NOT_STRICT_LENGTH_ENABLED_PROPERTY, true)) {
            return false;
        }
        return !Properties.isOverrideSetTo(STRICT_LENGTH_ENABLED_PROPERTY, false);
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        return this.forEncryption ? inputBlockSize - 10 : inputBlockSize;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : outputBlockSize - 10;
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            asymmetricKeyParameter = (AsymmetricKeyParameter) parametersWithRandom.getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
            if (!asymmetricKeyParameter.isPrivate() && z) {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            }
        }
        this.engine.init(z, cipherParameters);
        this.forPrivateKey = asymmetricKeyParameter.isPrivate();
        this.forEncryption = z;
        this.blockBuffer = new byte[this.engine.getOutputBlockSize()];
        if (this.pLen > 0 && this.fallback == null && this.random == null) {
            throw new IllegalArgumentException("encoder requires random");
        }
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i8, int i9) {
        return this.forEncryption ? encodeBlock(bArr, i8, i9) : decodeBlock(bArr, i8, i9);
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, int i8) {
        this.pLen = -1;
        this.fallback = null;
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
        this.pLen = i8;
    }

    private static int checkPkcs1Encoding2(byte[] bArr, int i8) {
        int i9 = -((bArr[0] & 255) ^ 2);
        int length = (bArr.length - 1) - i8;
        int i10 = (length - 9) | i9;
        for (int i11 = 1; i11 < length; i11++) {
            i10 |= (bArr[i11] & 255) - 1;
        }
        return ((-(bArr[length] & 255)) | i10) >> 31;
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, byte[] bArr) {
        this.pLen = -1;
        this.fallback = null;
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
        this.fallback = bArr;
        this.pLen = bArr.length;
    }
}
