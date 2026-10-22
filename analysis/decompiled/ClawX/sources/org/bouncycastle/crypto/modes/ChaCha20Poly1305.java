package org.bouncycastle.crypto.modes;

import a8.b;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.engines.ChaCha7539Engine;
import org.bouncycastle.crypto.macs.Poly1305;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class ChaCha20Poly1305 implements AEADCipher {
    private static final long AAD_LIMIT = -1;
    private static final int BUF_SIZE = 64;
    private static final long DATA_LIMIT = 274877906880L;
    private static final int KEY_SIZE = 32;
    private static final int MAC_SIZE = 16;
    private static final int NONCE_SIZE = 12;
    private static final byte[] ZEROES = new byte[15];
    private long aadCount;
    private final byte[] buf;
    private int bufPos;
    private final ChaCha7539Engine chacha20;
    private long dataCount;
    private byte[] initialAAD;
    private final byte[] key;
    private final byte[] mac;
    private final byte[] nonce;
    private final Mac poly1305;
    private int state;

    public static final class State {
        static final int DEC_AAD = 6;
        static final int DEC_DATA = 7;
        static final int DEC_FINAL = 8;
        static final int DEC_INIT = 5;
        static final int ENC_AAD = 2;
        static final int ENC_DATA = 3;
        static final int ENC_FINAL = 4;
        static final int ENC_INIT = 1;
        static final int UNINITIALIZED = 0;

        private State() {
        }
    }

    public ChaCha20Poly1305() {
        this(new Poly1305());
    }

    private void checkAAD() {
        int i8 = this.state;
        if (i8 == 1) {
            this.state = 2;
            return;
        }
        if (i8 != 2) {
            if (i8 == 4) {
                throw new IllegalStateException("ChaCha20Poly1305 cannot be reused for encryption");
            }
            if (i8 == 5) {
                this.state = 6;
            } else if (i8 != 6) {
                throw new IllegalStateException();
            }
        }
    }

    private void checkData() {
        int i8;
        switch (this.state) {
            case 1:
            case 2:
                i8 = 3;
                break;
            case 3:
            case 7:
                return;
            case 4:
                throw new IllegalStateException("ChaCha20Poly1305 cannot be reused for encryption");
            case 5:
            case 6:
                i8 = 7;
                break;
            default:
                throw new IllegalStateException();
        }
        finishAAD(i8);
    }

    private void finishAAD(int i8) {
        padMAC(this.aadCount);
        this.state = i8;
    }

    private void finishData(int i8) {
        padMAC(this.dataCount);
        byte[] bArr = new byte[16];
        Pack.longToLittleEndian(this.aadCount, bArr, 0);
        Pack.longToLittleEndian(this.dataCount, bArr, 8);
        this.poly1305.update(bArr, 0, 16);
        this.poly1305.doFinal(this.mac, 0);
        this.state = i8;
    }

    private long incrementCount(long j4, int i8, long j8) {
        long j9 = i8;
        if (j4 - Long.MIN_VALUE <= (j8 - j9) - Long.MIN_VALUE) {
            return j4 + j9;
        }
        throw new IllegalStateException("Limit exceeded");
    }

    private void initMAC() {
        byte[] bArr = new byte[64];
        try {
            this.chacha20.processBytes(bArr, 0, 64, bArr, 0);
            this.poly1305.init(new KeyParameter(bArr, 0, 32));
        } finally {
            Arrays.clear(bArr);
        }
    }

    private void padMAC(long j4) {
        int i8 = ((int) j4) & 15;
        if (i8 != 0) {
            this.poly1305.update(ZEROES, 0, 16 - i8);
        }
    }

    private void processData(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        if (i10 > bArr2.length - i9) {
            throw new OutputLengthException("Output buffer too short");
        }
        this.chacha20.processBytes(bArr, i8, i9, bArr2, i10);
        this.dataCount = incrementCount(this.dataCount, i9, DATA_LIMIT);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] bArr, int i8) throws InvalidCipherTextException {
        int i9;
        int i10;
        if (bArr == null) {
            throw new NullPointerException("'out' cannot be null");
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("'outOff' cannot be negative");
        }
        checkData();
        Arrays.clear(this.mac);
        int i11 = this.state;
        if (i11 == 3) {
            int i12 = this.bufPos;
            int i13 = i12 + 16;
            if (i8 > bArr.length - i13) {
                throw new OutputLengthException("Output buffer too short");
            }
            if (i12 > 0) {
                processData(this.buf, 0, i12, bArr, i8);
                this.poly1305.update(bArr, i8, this.bufPos);
            }
            finishData(4);
            System.arraycopy(this.mac, 0, bArr, this.bufPos + i8, 16);
            i9 = i13;
        } else {
            if (i11 != 7) {
                throw new IllegalStateException();
            }
            int i14 = this.bufPos;
            if (i14 < 16) {
                throw new InvalidCipherTextException("data too short");
            }
            int i15 = i14 - 16;
            if (i8 > bArr.length - i15) {
                throw new OutputLengthException("Output buffer too short");
            }
            if (i15 > 0) {
                this.poly1305.update(this.buf, 0, i15);
                i10 = i15;
                processData(this.buf, 0, i10, bArr, i8);
            } else {
                i10 = i15;
            }
            finishData(8);
            if (!Arrays.constantTimeAreEqual(16, this.mac, 0, this.buf, i10)) {
                throw new InvalidCipherTextException("mac check in ChaCha20Poly1305 failed");
            }
            i9 = i10;
        }
        reset(false, true);
        return i9;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return "ChaCha20Poly1305";
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public byte[] getMac() {
        return Arrays.clone(this.mac);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getOutputSize(int i8) {
        int iMax = Math.max(0, i8) + this.bufPos;
        int i9 = this.state;
        if (i9 == 1 || i9 == 2 || i9 == 3) {
            return iMax + 16;
        }
        if (i9 == 5 || i9 == 6 || i9 == 7) {
            return Math.max(0, iMax - 16);
        }
        throw new IllegalStateException();
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int i8) {
        int iMax = Math.max(0, i8) + this.bufPos;
        int i9 = this.state;
        if (i9 != 1 && i9 != 2 && i9 != 3) {
            if (i9 != 5 && i9 != 6 && i9 != 7) {
                throw new IllegalStateException();
            }
            iMax = Math.max(0, iMax - 16);
        }
        return iMax - (iMax % 64);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        ParametersWithIV parametersWithIV;
        KeyParameter key;
        byte[] iv;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            int macSize = aEADParameters.getMacSize();
            if (128 != macSize) {
                throw new IllegalArgumentException(b.j(macSize, "Invalid value for MAC size: "));
            }
            key = aEADParameters.getKey();
            iv = aEADParameters.getNonce();
            parametersWithIV = new ParametersWithIV(key, iv);
            this.initialAAD = aEADParameters.getAssociatedText();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to ChaCha20Poly1305");
            }
            parametersWithIV = (ParametersWithIV) cipherParameters;
            key = (KeyParameter) parametersWithIV.getParameters();
            iv = parametersWithIV.getIV();
            this.initialAAD = null;
        }
        if (key == null) {
            if (this.state == 0) {
                throw new IllegalArgumentException("Key must be specified in initial init");
            }
        } else if (32 != key.getKeyLength()) {
            throw new IllegalArgumentException("Key must be 256 bits");
        }
        if (iv == null || 12 != iv.length) {
            throw new IllegalArgumentException("Nonce must be 96 bits");
        }
        if (this.state != 0 && z && Arrays.areEqual(this.nonce, iv) && (key == null || Arrays.areEqual(this.key, key.getKey()))) {
            throw new IllegalArgumentException("cannot reuse nonce for ChaCha20Poly1305 encryption");
        }
        if (key != null) {
            key.copyTo(this.key, 0, 32);
        }
        System.arraycopy(iv, 0, this.nonce, 0, 12);
        this.chacha20.init(true, parametersWithIV);
        this.state = z ? 1 : 5;
        reset(true, false);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte b9) {
        checkAAD();
        this.aadCount = incrementCount(this.aadCount, 1, AAD_LIMIT);
        this.poly1305.update(b9);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i8, int i9) {
        if (bArr == null) {
            throw new NullPointerException("'in' cannot be null");
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("'inOff' cannot be negative");
        }
        if (i9 < 0) {
            throw new IllegalArgumentException("'len' cannot be negative");
        }
        if (i8 > bArr.length - i9) {
            throw new DataLengthException("Input buffer too short");
        }
        checkAAD();
        if (i9 > 0) {
            this.aadCount = incrementCount(this.aadCount, i9, AAD_LIMIT);
            this.poly1305.update(bArr, i8, i9);
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte b9, byte[] bArr, int i8) {
        checkData();
        int i9 = this.state;
        if (i9 == 3) {
            byte[] bArr2 = this.buf;
            int i10 = this.bufPos;
            bArr2[i10] = b9;
            int i11 = i10 + 1;
            this.bufPos = i11;
            if (i11 != 64) {
                return 0;
            }
            processData(bArr2, 0, 64, bArr, i8);
            this.poly1305.update(bArr, i8, 64);
            this.bufPos = 0;
            return 64;
        }
        if (i9 != 7) {
            throw new IllegalStateException();
        }
        byte[] bArr3 = this.buf;
        int i12 = this.bufPos;
        bArr3[i12] = b9;
        int i13 = i12 + 1;
        this.bufPos = i13;
        if (i13 != bArr3.length) {
            return 0;
        }
        this.poly1305.update(bArr3, 0, 64);
        processData(this.buf, 0, 64, bArr, i8);
        byte[] bArr4 = this.buf;
        System.arraycopy(bArr4, 64, bArr4, 0, 16);
        this.bufPos = 16;
        return 64;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        byte[] bArr3;
        int i11;
        int i12;
        int i13 = i8;
        int i14 = i9;
        if (bArr == null) {
            throw new NullPointerException("'in' cannot be null");
        }
        if (i13 < 0) {
            throw new IllegalArgumentException("'inOff' cannot be negative");
        }
        if (i14 < 0) {
            throw new IllegalArgumentException("'len' cannot be negative");
        }
        if (i13 > bArr.length - i14) {
            throw new DataLengthException("Input buffer too short");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("'outOff' cannot be negative");
        }
        if (bArr == bArr2 && Arrays.segmentsOverlap(i8, i14, i10, getUpdateOutputSize(i14))) {
            bArr = new byte[i14];
            System.arraycopy(bArr2, i8, bArr, 0, i14);
            i13 = 0;
        }
        checkData();
        int i15 = this.state;
        if (i15 != 3) {
            if (i15 != 7) {
                throw new IllegalStateException();
            }
            int i16 = 0;
            for (int i17 = 0; i17 < i14; i17++) {
                byte[] bArr4 = this.buf;
                int i18 = this.bufPos;
                bArr4[i18] = bArr[i13 + i17];
                int i19 = i18 + 1;
                this.bufPos = i19;
                if (i19 == bArr4.length) {
                    this.poly1305.update(bArr4, 0, 64);
                    processData(this.buf, 0, 64, bArr2, i10 + i16);
                    byte[] bArr5 = this.buf;
                    System.arraycopy(bArr5, 64, bArr5, 0, 16);
                    this.bufPos = 16;
                    i16 += 64;
                }
            }
            return i16;
        }
        if (this.bufPos != 0) {
            while (i14 > 0) {
                i11 = i14 - 1;
                byte[] bArr6 = this.buf;
                int i20 = this.bufPos;
                int i21 = i13 + 1;
                bArr6[i20] = bArr[i13];
                int i22 = i20 + 1;
                this.bufPos = i22;
                if (i22 == 64) {
                    bArr3 = bArr2;
                    processData(bArr6, 0, 64, bArr3, i10);
                    this.poly1305.update(bArr3, i10, 64);
                    this.bufPos = 0;
                    i13 = i21;
                    i12 = 64;
                    break;
                }
                i14 = i11;
                i13 = i21;
            }
            bArr3 = bArr2;
            i11 = i14;
            i12 = 0;
        } else {
            bArr3 = bArr2;
            i11 = i14;
            i12 = 0;
        }
        while (i11 >= 64) {
            int i23 = i10 + i12;
            byte[] bArr7 = bArr;
            int i24 = i13;
            processData(bArr7, i24, 64, bArr3, i23);
            this.poly1305.update(bArr3, i23, 64);
            i13 = i24 + 64;
            i11 -= 64;
            i12 += 64;
            bArr = bArr7;
        }
        byte[] bArr8 = bArr;
        if (i11 > 0) {
            System.arraycopy(bArr8, i13, this.buf, 0, i11);
            this.bufPos = i11;
        }
        return i12;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        reset(true, true);
    }

    public ChaCha20Poly1305(Mac mac) {
        this.key = new byte[32];
        this.nonce = new byte[12];
        this.buf = new byte[80];
        this.mac = new byte[16];
        this.state = 0;
        if (mac == null) {
            throw new NullPointerException("'poly1305' cannot be null");
        }
        if (16 != mac.getMacSize()) {
            throw new IllegalArgumentException("'poly1305' must be a 128-bit MAC");
        }
        this.chacha20 = new ChaCha7539Engine();
        this.poly1305 = mac;
    }

    private void reset(boolean z, boolean z2) {
        Arrays.clear(this.buf);
        if (z) {
            Arrays.clear(this.mac);
        }
        this.aadCount = 0L;
        this.dataCount = 0L;
        this.bufPos = 0;
        switch (this.state) {
            case 1:
            case 5:
                break;
            case 2:
            case 3:
            case 4:
                this.state = 4;
                return;
            case 6:
            case 7:
            case 8:
                this.state = 5;
                break;
            default:
                throw new IllegalStateException();
        }
        if (z2) {
            this.chacha20.reset();
        }
        initMAC();
        byte[] bArr = this.initialAAD;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}
