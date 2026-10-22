package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.gcm.GCMMultiplier;
import org.bouncycastle.crypto.modes.gcm.Tables4kGCMMultiplier;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class GCMSIVBlockCipher implements AEADBlockCipher {
    private static final byte ADD = -31;
    private static final int AEAD_COMPLETE = 2;
    private static final int BUFLEN = 16;
    private static final int HALFBUFLEN = 8;
    private static final int INIT = 1;
    private static final byte MASK = -128;
    private static final int MAX_DATALEN = 2147483623;
    private static final int NONCELEN = 12;
    private boolean forEncryption;
    private byte[] macBlock;
    private final GCMSIVHasher theAEADHasher;
    private final BlockCipher theCipher;
    private final GCMSIVHasher theDataHasher;
    private GCMSIVCache theEncData;
    private int theFlags;
    private final byte[] theGHash;
    private byte[] theInitialAEAD;
    private final GCMMultiplier theMultiplier;
    private byte[] theNonce;
    private GCMSIVCache thePlain;
    private final byte[] theReverse;

    public static class GCMSIVCache extends ByteArrayOutputStream {
        public void clearBuffer() {
            Arrays.fill(getBuffer(), (byte) 0);
        }

        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public class GCMSIVHasher {
        private int numActive;
        private long numHashed;
        private final byte[] theBuffer;
        private final byte[] theByte;

        private GCMSIVHasher() {
            this.theBuffer = new byte[16];
            this.theByte = new byte[1];
        }

        public void completeHash() {
            if (this.numActive > 0) {
                Arrays.fill(GCMSIVBlockCipher.this.theReverse, (byte) 0);
                GCMSIVBlockCipher.fillReverse(this.theBuffer, 0, this.numActive, GCMSIVBlockCipher.this.theReverse);
                GCMSIVBlockCipher gCMSIVBlockCipher = GCMSIVBlockCipher.this;
                gCMSIVBlockCipher.gHASH(gCMSIVBlockCipher.theReverse);
            }
        }

        public long getBytesProcessed() {
            return this.numHashed;
        }

        public void reset() {
            this.numActive = 0;
            this.numHashed = 0L;
        }

        public void updateHash(byte b9) {
            byte[] bArr = this.theByte;
            bArr[0] = b9;
            updateHash(bArr, 0, 1);
        }

        public void updateHash(byte[] bArr, int i8, int i9) {
            int i10;
            int i11 = this.numActive;
            int i12 = 16 - i11;
            if (i11 <= 0 || i9 < i12) {
                i10 = i9;
                i12 = 0;
            } else {
                System.arraycopy(bArr, i8, this.theBuffer, i11, i12);
                GCMSIVBlockCipher.fillReverse(this.theBuffer, 0, 16, GCMSIVBlockCipher.this.theReverse);
                GCMSIVBlockCipher gCMSIVBlockCipher = GCMSIVBlockCipher.this;
                gCMSIVBlockCipher.gHASH(gCMSIVBlockCipher.theReverse);
                i10 = i9 - i12;
                this.numActive = 0;
            }
            while (i10 >= 16) {
                GCMSIVBlockCipher.fillReverse(bArr, i8 + i12, 16, GCMSIVBlockCipher.this.theReverse);
                GCMSIVBlockCipher gCMSIVBlockCipher2 = GCMSIVBlockCipher.this;
                gCMSIVBlockCipher2.gHASH(gCMSIVBlockCipher2.theReverse);
                i12 += 16;
                i10 -= 16;
            }
            if (i10 > 0) {
                System.arraycopy(bArr, i8 + i12, this.theBuffer, this.numActive, i10);
                this.numActive += i10;
            }
            this.numHashed += i9;
        }
    }

    public GCMSIVBlockCipher() {
        this(AESEngine.newInstance());
    }

    private static int bufLength(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    private byte[] calculateTag() {
        this.theDataHasher.completeHash();
        byte[] bArrCompletePolyVal = completePolyVal();
        byte[] bArr = new byte[16];
        for (int i8 = 0; i8 < 12; i8++) {
            bArrCompletePolyVal[i8] = (byte) (bArrCompletePolyVal[i8] ^ this.theNonce[i8]);
        }
        bArrCompletePolyVal[15] = (byte) (bArrCompletePolyVal[15] & AbstractJsonLexerKt.TC_INVALID);
        this.theCipher.processBlock(bArrCompletePolyVal, 0, bArr, 0);
        return bArr;
    }

    private void checkAEADStatus(int i8) {
        int i9 = this.theFlags;
        if ((i9 & 1) == 0) {
            throw new IllegalStateException("Cipher is not initialised");
        }
        if ((i9 & 2) != 0) {
            throw new IllegalStateException("AEAD data cannot be processed after ordinary data");
        }
        if (this.theAEADHasher.getBytesProcessed() - Long.MIN_VALUE > (MAX_DATALEN - i8) - Long.MIN_VALUE) {
            throw new IllegalStateException("AEAD byte count exceeded");
        }
    }

    private static void checkBuffer(byte[] bArr, int i8, int i9, boolean z) {
        int iBufLength = bufLength(bArr);
        int i10 = i8 + i9;
        if (i9 < 0 || i8 < 0 || i10 < 0 || i10 > iBufLength) {
            if (!z) {
                throw new DataLengthException("Input buffer too short.");
            }
        }
    }

    private void checkStatus(int i8) {
        long j4;
        int i9 = this.theFlags;
        if ((i9 & 1) == 0) {
            throw new IllegalStateException("Cipher is not initialised");
        }
        if ((i9 & 2) == 0) {
            this.theAEADHasher.completeHash();
            this.theFlags |= 2;
        }
        long size = this.thePlain.size();
        if (this.forEncryption) {
            j4 = 2147483623;
        } else {
            size = this.theEncData.size();
            j4 = 2147483639;
        }
        if (size - Long.MIN_VALUE > (j4 - i8) - Long.MIN_VALUE) {
            throw new IllegalStateException("byte count exceeded");
        }
    }

    private byte[] completePolyVal() {
        byte[] bArr = new byte[16];
        gHashLengths();
        fillReverse(this.theGHash, 0, 16, bArr);
        return bArr;
    }

    private void decryptPlain() throws InvalidCipherTextException, IOException {
        byte[] buffer = this.theEncData.getBuffer();
        int size = this.theEncData.size();
        int i8 = size - 16;
        if (i8 < 0) {
            throw new InvalidCipherTextException("Data too short");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(buffer, i8, size);
        byte[] bArrClone = Arrays.clone(bArrCopyOfRange);
        bArrClone[15] = (byte) (bArrClone[15] | MASK);
        byte[] bArr = new byte[16];
        int i9 = 0;
        while (i8 > 0) {
            this.theCipher.processBlock(bArrClone, 0, bArr, 0);
            int iMin = Math.min(16, i8);
            xorBlock(bArr, buffer, i9, iMin);
            this.thePlain.write(bArr, 0, iMin);
            this.theDataHasher.updateHash(bArr, 0, iMin);
            i8 -= iMin;
            i9 += iMin;
            incrementCounter(bArrClone);
        }
        byte[] bArrCalculateTag = calculateTag();
        if (!Arrays.constantTimeAreEqual(bArrCalculateTag, bArrCopyOfRange)) {
            reset();
            throw new InvalidCipherTextException("mac check failed");
        }
        byte[] bArr2 = this.macBlock;
        System.arraycopy(bArrCalculateTag, 0, bArr2, 0, bArr2.length);
    }

    private void deriveKeys(KeyParameter keyParameter) {
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[16];
        int keyLength = keyParameter.getKeyLength();
        byte[] bArr4 = new byte[keyLength];
        System.arraycopy(this.theNonce, 0, bArr, 4, 12);
        this.theCipher.init(true, keyParameter);
        this.theCipher.processBlock(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr3, 0, 8);
        bArr[0] = (byte) (bArr[0] + 1);
        this.theCipher.processBlock(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr3, 8, 8);
        bArr[0] = (byte) (bArr[0] + 1);
        this.theCipher.processBlock(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr4, 0, 8);
        bArr[0] = (byte) (bArr[0] + 1);
        this.theCipher.processBlock(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr4, 8, 8);
        if (keyLength == 32) {
            bArr[0] = (byte) (bArr[0] + 1);
            this.theCipher.processBlock(bArr, 0, bArr2, 0);
            System.arraycopy(bArr2, 0, bArr4, 16, 8);
            bArr[0] = (byte) (bArr[0] + 1);
            this.theCipher.processBlock(bArr, 0, bArr2, 0);
            System.arraycopy(bArr2, 0, bArr4, 24, 8);
        }
        this.theCipher.init(true, new KeyParameter(bArr4));
        fillReverse(bArr3, 0, 16, bArr2);
        mulX(bArr2);
        this.theMultiplier.init(bArr2);
        this.theFlags |= 1;
    }

    private int encryptPlain(byte[] bArr, byte[] bArr2, int i8) {
        byte[] buffer = this.thePlain.getBuffer();
        byte[] bArrClone = Arrays.clone(bArr);
        bArrClone[15] = (byte) (bArrClone[15] | MASK);
        byte[] bArr3 = new byte[16];
        int size = this.thePlain.size();
        int i9 = 0;
        while (size > 0) {
            this.theCipher.processBlock(bArrClone, 0, bArr3, 0);
            int iMin = Math.min(16, size);
            xorBlock(bArr3, buffer, i9, iMin);
            System.arraycopy(bArr3, 0, bArr2, i8 + i9, iMin);
            size -= iMin;
            i9 += iMin;
            incrementCounter(bArrClone);
        }
        return this.thePlain.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fillReverse(byte[] bArr, int i8, int i9, byte[] bArr2) {
        int i10 = 0;
        int i11 = 15;
        while (i10 < i9) {
            bArr2[i11] = bArr[i8 + i10];
            i10++;
            i11--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gHASH(byte[] bArr) {
        xorBlock(this.theGHash, bArr);
        this.theMultiplier.multiplyH(this.theGHash);
    }

    private void gHashLengths() {
        byte[] bArr = new byte[16];
        Pack.longToBigEndian(this.theDataHasher.getBytesProcessed() * 8, bArr, 0);
        Pack.longToBigEndian(this.theAEADHasher.getBytesProcessed() * 8, bArr, 8);
        gHASH(bArr);
    }

    private static void incrementCounter(byte[] bArr) {
        for (int i8 = 0; i8 < 4; i8++) {
            byte b9 = (byte) (bArr[i8] + 1);
            bArr[i8] = b9;
            if (b9 != 0) {
                return;
            }
        }
    }

    private static void mulX(byte[] bArr) {
        int i8 = 0;
        for (int i9 = 0; i9 < 16; i9++) {
            byte b9 = bArr[i9];
            bArr[i9] = (byte) (i8 | ((b9 >> 1) & 127));
            i8 = (b9 & 1) == 0 ? 0 : -128;
        }
        if (i8 != 0) {
            bArr[0] = (byte) (bArr[0] ^ ADD);
        }
    }

    private void resetStreams() {
        GCMSIVCache gCMSIVCache = this.thePlain;
        if (gCMSIVCache != null) {
            gCMSIVCache.clearBuffer();
        }
        this.theAEADHasher.reset();
        this.theDataHasher.reset();
        this.thePlain = new GCMSIVCache();
        this.theEncData = this.forEncryption ? null : new GCMSIVCache();
        this.theFlags &= -3;
        Arrays.fill(this.theGHash, (byte) 0);
        byte[] bArr = this.theInitialAEAD;
        if (bArr != null) {
            this.theAEADHasher.updateHash(bArr, 0, bArr.length);
        }
    }

    private static void xorBlock(byte[] bArr, byte[] bArr2) {
        for (int i8 = 0; i8 < 16; i8++) {
            bArr[i8] = (byte) (bArr[i8] ^ bArr2[i8]);
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] bArr, int i8) throws InvalidCipherTextException, IOException {
        checkStatus(0);
        checkBuffer(bArr, i8, getOutputSize(0), true);
        if (!this.forEncryption) {
            decryptPlain();
            int size = this.thePlain.size();
            System.arraycopy(this.thePlain.getBuffer(), 0, bArr, i8, size);
            resetStreams();
            return size;
        }
        byte[] bArrCalculateTag = calculateTag();
        int iEncryptPlain = encryptPlain(bArrCalculateTag, bArr, i8) + 16;
        System.arraycopy(bArrCalculateTag, 0, bArr, this.thePlain.size() + i8, 16);
        byte[] bArr2 = this.macBlock;
        System.arraycopy(bArrCalculateTag, 0, bArr2, 0, bArr2.length);
        resetStreams();
        return iEncryptPlain;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.theCipher.getAlgorithmName() + "-GCM-SIV";
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public byte[] getMac() {
        return Arrays.clone(this.macBlock);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getOutputSize(int i8) {
        if (this.forEncryption) {
            return this.thePlain.size() + i8 + 16;
        }
        int size = this.theEncData.size() + i8;
        if (size > 16) {
            return size - 16;
        }
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.theCipher;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int i8) {
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        byte[] iv;
        KeyParameter key;
        byte[] associatedText;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            associatedText = aEADParameters.getAssociatedText();
            iv = aEADParameters.getNonce();
            key = aEADParameters.getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to GCM-SIV");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            iv = parametersWithIV.getIV();
            key = (KeyParameter) parametersWithIV.getParameters();
            associatedText = null;
        }
        if (iv == null || iv.length != 12) {
            throw new IllegalArgumentException("Invalid nonce");
        }
        if (key == null || !(key.getKeyLength() == 16 || key.getKeyLength() == 32)) {
            throw new IllegalArgumentException("Invalid key");
        }
        this.forEncryption = z;
        this.theInitialAEAD = associatedText;
        this.theNonce = iv;
        deriveKeys(key);
        resetStreams();
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte b9) {
        checkAEADStatus(1);
        this.theAEADHasher.updateHash(b9);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i8, int i9) {
        checkAEADStatus(i9);
        checkBuffer(bArr, i8, i9, false);
        this.theAEADHasher.updateHash(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte b9, byte[] bArr, int i8) throws IOException {
        checkStatus(1);
        if (!this.forEncryption) {
            this.theEncData.write(b9);
            return 0;
        }
        this.thePlain.write(b9);
        this.theDataHasher.updateHash(b9);
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) throws IOException {
        checkStatus(i9);
        checkBuffer(bArr, i8, i9, false);
        if (this.forEncryption) {
            this.thePlain.write(bArr, i8, i9);
            this.theDataHasher.updateHash(bArr, i8, i9);
        } else {
            this.theEncData.write(bArr, i8, i9);
        }
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        resetStreams();
    }

    public GCMSIVBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, new Tables4kGCMMultiplier());
    }

    private static void xorBlock(byte[] bArr, byte[] bArr2, int i8, int i9) {
        for (int i10 = 0; i10 < i9; i10++) {
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i10 + i8]);
        }
    }

    public GCMSIVBlockCipher(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        this.theGHash = new byte[16];
        this.theReverse = new byte[16];
        this.macBlock = new byte[16];
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("Cipher required with a block size of 16.");
        }
        this.theCipher = blockCipher;
        this.theMultiplier = gCMMultiplier;
        this.theAEADHasher = new GCMSIVHasher();
        this.theDataHasher = new GCMSIVHasher();
    }
}
