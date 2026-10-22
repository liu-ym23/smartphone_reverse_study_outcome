package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class KCCMBlockCipher implements AEADBlockCipher {
    private static final int BITS_IN_BYTE = 8;
    private static final int BYTES_IN_INT = 4;
    private static final int MAX_MAC_BIT_LENGTH = 512;
    private static final int MIN_MAC_BIT_LENGTH = 64;
    private byte[] G1;
    private int Nb_;
    private ExposedByteArrayOutputStream associatedText;
    private byte[] buffer;
    private byte[] counter;
    private ExposedByteArrayOutputStream data;
    private BlockCipher engine;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private byte[] mac;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonce;

    /* renamed from: s, reason: collision with root package name */
    private byte[] f4529s;

    public static class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public KCCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, 4);
    }

    private void CalculateMac(byte[] bArr, int i8, int i9) {
        while (i9 > 0) {
            for (int i10 = 0; i10 < this.engine.getBlockSize(); i10++) {
                byte[] bArr2 = this.macBlock;
                bArr2[i10] = (byte) (bArr2[i10] ^ bArr[i8 + i10]);
            }
            BlockCipher blockCipher = this.engine;
            byte[] bArr3 = this.macBlock;
            blockCipher.processBlock(bArr3, 0, bArr3, 0);
            i9 -= this.engine.getBlockSize();
            i8 += this.engine.getBlockSize();
        }
    }

    private void ProcessBlock(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        int i11 = 0;
        while (true) {
            byte[] bArr3 = this.counter;
            if (i11 >= bArr3.length) {
                break;
            }
            byte[] bArr4 = this.f4529s;
            bArr4[i11] = (byte) (bArr4[i11] + bArr3[i11]);
            i11++;
        }
        this.engine.processBlock(this.f4529s, 0, this.buffer, 0);
        for (int i12 = 0; i12 < this.engine.getBlockSize(); i12++) {
            bArr2[i10 + i12] = (byte) (this.buffer[i12] ^ bArr[i8 + i12]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048 A[LOOP:0: B:24:0x0041->B:26:0x0048, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte getFlag(boolean r3, int r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "0"
            if (r3 == 0) goto Lf
            java.lang.String r3 = "1"
            r0.append(r3)
            goto L12
        Lf:
            r0.append(r1)
        L12:
            r3 = 8
            if (r4 == r3) goto L36
            r3 = 16
            if (r4 == r3) goto L33
            r3 = 32
            if (r4 == r3) goto L30
            r3 = 48
            if (r4 == r3) goto L2d
            r3 = 64
            if (r4 == r3) goto L27
            goto L39
        L27:
            java.lang.String r3 = "110"
        L29:
            r0.append(r3)
            goto L39
        L2d:
            java.lang.String r3 = "101"
            goto L29
        L30:
            java.lang.String r3 = "100"
            goto L29
        L33:
            java.lang.String r3 = "011"
            goto L29
        L36:
            java.lang.String r3 = "010"
            goto L29
        L39:
            int r2 = r2.Nb_
            int r2 = r2 + (-1)
            java.lang.String r2 = java.lang.Integer.toBinaryString(r2)
        L41:
            int r3 = r2.length()
            r4 = 4
            if (r3 >= r4) goto L57
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r2 = 0
            java.lang.StringBuilder r2 = r3.insert(r2, r1)
            java.lang.String r2 = r2.toString()
            goto L41
        L57:
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            r3 = 2
            int r2 = java.lang.Integer.parseInt(r2, r3)
            byte r2 = (byte) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.modes.KCCMBlockCipher.getFlag(boolean, int):byte");
    }

    private void intToBytes(int i8, byte[] bArr, int i9) {
        bArr[i9 + 3] = (byte) (i8 >> 24);
        bArr[i9 + 2] = (byte) (i8 >> 16);
        bArr[i9 + 1] = (byte) (i8 >> 8);
        bArr[i9] = (byte) i8;
    }

    private void processAAD(byte[] bArr, int i8, int i9, int i10) {
        if (i9 - i8 < this.engine.getBlockSize()) {
            throw new IllegalArgumentException("authText buffer too short");
        }
        if (i9 % this.engine.getBlockSize() != 0) {
            throw new IllegalArgumentException("padding not supported");
        }
        byte[] bArr2 = this.nonce;
        System.arraycopy(bArr2, 0, this.G1, 0, (bArr2.length - this.Nb_) - 1);
        intToBytes(i10, this.buffer, 0);
        System.arraycopy(this.buffer, 0, this.G1, (this.nonce.length - this.Nb_) - 1, 4);
        byte[] bArr3 = this.G1;
        bArr3[bArr3.length - 1] = getFlag(true, this.macSize);
        this.engine.processBlock(this.G1, 0, this.macBlock, 0);
        intToBytes(i9, this.buffer, 0);
        if (i9 <= this.engine.getBlockSize() - this.Nb_) {
            for (int i11 = 0; i11 < i9; i11++) {
                byte[] bArr4 = this.buffer;
                int i12 = this.Nb_ + i11;
                bArr4[i12] = (byte) (bArr4[i12] ^ bArr[i8 + i11]);
            }
            for (int i13 = 0; i13 < this.engine.getBlockSize(); i13++) {
                byte[] bArr5 = this.macBlock;
                bArr5[i13] = (byte) (bArr5[i13] ^ this.buffer[i13]);
            }
            BlockCipher blockCipher = this.engine;
            byte[] bArr6 = this.macBlock;
            blockCipher.processBlock(bArr6, 0, bArr6, 0);
            return;
        }
        for (int i14 = 0; i14 < this.engine.getBlockSize(); i14++) {
            byte[] bArr7 = this.macBlock;
            bArr7[i14] = (byte) (bArr7[i14] ^ this.buffer[i14]);
        }
        BlockCipher blockCipher2 = this.engine;
        byte[] bArr8 = this.macBlock;
        blockCipher2.processBlock(bArr8, 0, bArr8, 0);
        while (i9 != 0) {
            for (int i15 = 0; i15 < this.engine.getBlockSize(); i15++) {
                byte[] bArr9 = this.macBlock;
                bArr9[i15] = (byte) (bArr9[i15] ^ bArr[i15 + i8]);
            }
            BlockCipher blockCipher3 = this.engine;
            byte[] bArr10 = this.macBlock;
            blockCipher3.processBlock(bArr10, 0, bArr10, 0);
            i8 += this.engine.getBlockSize();
            i9 -= this.engine.getBlockSize();
        }
    }

    private void setNb(int i8) {
        if (i8 != 4 && i8 != 6 && i8 != 8) {
            throw new IllegalArgumentException("Nb = 4 is recommended by DSTU7624 but can be changed to only 6 or 8 in this implementation");
        }
        this.Nb_ = i8;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] bArr, int i8) throws InvalidCipherTextException, IOException {
        int iProcessPacket = processPacket(this.data.getBuffer(), 0, this.data.size(), bArr, i8);
        reset();
        return iProcessPacket;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.engine.getAlgorithmName() + "/KCCM";
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public byte[] getMac() {
        return Arrays.clone(this.mac);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getOutputSize(int i8) {
        return i8 + this.macSize;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IOException {
        CipherParameters parameters;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            if (aEADParameters.getMacSize() > 512 || aEADParameters.getMacSize() < 64 || aEADParameters.getMacSize() % 8 != 0) {
                throw new IllegalArgumentException("Invalid mac size specified");
            }
            this.nonce = aEADParameters.getNonce();
            this.macSize = aEADParameters.getMacSize() / 8;
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            parameters = aEADParameters.getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("Invalid parameters specified");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.nonce = parametersWithIV.getIV();
            this.macSize = this.engine.getBlockSize();
            this.initialAssociatedText = null;
            parameters = parametersWithIV.getParameters();
        }
        this.mac = new byte[this.macSize];
        this.forEncryption = z;
        this.engine.init(true, parameters);
        this.counter[0] = 1;
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
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
            throw new DataLengthException("input buffer too short");
        }
        this.data.write(bArr, i8, i9);
        return 0;
    }

    public int processPacket(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) throws InvalidCipherTextException, IOException {
        int i11;
        if (bArr.length - i8 < i9) {
            throw new DataLengthException("input buffer too short");
        }
        if (bArr2.length - i10 < i9) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.associatedText.size() > 0) {
            if (this.forEncryption) {
                processAAD(this.associatedText.getBuffer(), 0, this.associatedText.size(), this.data.size());
            } else {
                processAAD(this.associatedText.getBuffer(), 0, this.associatedText.size(), this.data.size() - this.macSize);
            }
        }
        if (!this.forEncryption) {
            if ((i9 - this.macSize) % this.engine.getBlockSize() != 0) {
                throw new DataLengthException("partial blocks not supported");
            }
            this.engine.processBlock(this.nonce, 0, this.f4529s, 0);
            int blockSize = i9 / this.engine.getBlockSize();
            int blockSize2 = i8;
            int blockSize3 = i10;
            for (int i12 = 0; i12 < blockSize; i12++) {
                ProcessBlock(bArr, blockSize2, i9, bArr2, blockSize3);
                blockSize2 += this.engine.getBlockSize();
                blockSize3 += this.engine.getBlockSize();
            }
            if (i9 > blockSize2) {
                int i13 = 0;
                while (true) {
                    byte[] bArr3 = this.counter;
                    if (i13 >= bArr3.length) {
                        break;
                    }
                    byte[] bArr4 = this.f4529s;
                    bArr4[i13] = (byte) (bArr4[i13] + bArr3[i13]);
                    i13++;
                }
                this.engine.processBlock(this.f4529s, 0, this.buffer, 0);
                int i14 = 0;
                while (true) {
                    i11 = this.macSize;
                    if (i14 >= i11) {
                        break;
                    }
                    bArr2[blockSize3 + i14] = (byte) (this.buffer[i14] ^ bArr[blockSize2 + i14]);
                    i14++;
                }
                blockSize3 += i11;
            }
            int i15 = 0;
            while (true) {
                byte[] bArr5 = this.counter;
                if (i15 >= bArr5.length) {
                    break;
                }
                byte[] bArr6 = this.f4529s;
                bArr6[i15] = (byte) (bArr6[i15] + bArr5[i15]);
                i15++;
            }
            this.engine.processBlock(this.f4529s, 0, this.buffer, 0);
            int i16 = this.macSize;
            System.arraycopy(bArr2, blockSize3 - i16, this.buffer, 0, i16);
            CalculateMac(bArr2, 0, blockSize3 - this.macSize);
            System.arraycopy(this.macBlock, 0, this.mac, 0, this.macSize);
            int i17 = this.macSize;
            byte[] bArr7 = new byte[i17];
            System.arraycopy(this.buffer, 0, bArr7, 0, i17);
            if (!Arrays.constantTimeAreEqual(this.mac, bArr7)) {
                throw new InvalidCipherTextException("mac check failed");
            }
            reset();
            return i9 - this.macSize;
        }
        if (i9 % this.engine.getBlockSize() != 0) {
            throw new DataLengthException("partial blocks not supported");
        }
        CalculateMac(bArr, i8, i9);
        this.engine.processBlock(this.nonce, 0, this.f4529s, 0);
        int blockSize4 = i9;
        while (blockSize4 > 0) {
            ProcessBlock(bArr, i8, i9, bArr2, i10);
            blockSize4 -= this.engine.getBlockSize();
            i8 += this.engine.getBlockSize();
            i10 += this.engine.getBlockSize();
        }
        int i18 = 0;
        while (true) {
            byte[] bArr8 = this.counter;
            if (i18 >= bArr8.length) {
                break;
            }
            byte[] bArr9 = this.f4529s;
            bArr9[i18] = (byte) (bArr9[i18] + bArr8[i18]);
            i18++;
        }
        this.engine.processBlock(this.f4529s, 0, this.buffer, 0);
        int i19 = 0;
        while (true) {
            int i20 = this.macSize;
            if (i19 >= i20) {
                System.arraycopy(this.macBlock, 0, this.mac, 0, i20);
                reset();
                return i9 + this.macSize;
            }
            bArr2[i10 + i19] = (byte) (this.buffer[i19] ^ this.macBlock[i19]);
            i19++;
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() throws IOException {
        Arrays.fill(this.G1, (byte) 0);
        Arrays.fill(this.buffer, (byte) 0);
        Arrays.fill(this.counter, (byte) 0);
        Arrays.fill(this.macBlock, (byte) 0);
        this.counter[0] = 1;
        this.data.reset();
        this.associatedText.reset();
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }

    public KCCMBlockCipher(BlockCipher blockCipher, int i8) {
        this.associatedText = new ExposedByteArrayOutputStream();
        this.data = new ExposedByteArrayOutputStream();
        this.Nb_ = 4;
        this.engine = blockCipher;
        this.macSize = blockCipher.getBlockSize();
        this.nonce = new byte[blockCipher.getBlockSize()];
        this.initialAssociatedText = new byte[blockCipher.getBlockSize()];
        this.mac = new byte[blockCipher.getBlockSize()];
        this.macBlock = new byte[blockCipher.getBlockSize()];
        this.G1 = new byte[blockCipher.getBlockSize()];
        this.buffer = new byte[blockCipher.getBlockSize()];
        this.f4529s = new byte[blockCipher.getBlockSize()];
        this.counter = new byte[blockCipher.getBlockSize()];
        setNb(i8);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int i8) {
        return i8;
    }
}
