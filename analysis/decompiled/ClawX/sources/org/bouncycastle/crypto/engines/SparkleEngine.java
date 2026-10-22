package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.digests.Blake2xsDigest;
import org.bouncycastle.crypto.digests.SparkleDigest;
import org.bouncycastle.crypto.engines.AEADBaseEngine;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class SparkleEngine extends AEADBaseEngine {
    private static final int[] RCON = {-1209970334, -1083090816, 951376470, 844003128, -1156479509, 1333558103, -809524792, -1028445891};
    private final int CAP_MASK;
    private final int KEY_WORDS;
    private final int RATE_WORDS;
    private final int SPARKLE_STEPS_BIG;
    private final int SPARKLE_STEPS_SLIM;
    private final int STATE_WORDS;
    private final int TAG_WORDS;
    private final int _A0;
    private final int _A1;
    private final int _M2;
    private final int _M3;
    private boolean encrypted;

    /* renamed from: k, reason: collision with root package name */
    private final int[] f4475k;
    private final int[] npub;
    private final int[] state;

    public enum SparkleParameters {
        SCHWAEMM128_128,
        SCHWAEMM256_128,
        SCHWAEMM192_192,
        SCHWAEMM256_256
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SparkleEngine(org.bouncycastle.crypto.engines.SparkleEngine.SparkleParameters r8) {
        /*
            r7 = this;
            r7.<init>()
            int r8 = r8.ordinal()
            r0 = 7
            r1 = 1
            r2 = 3
            r3 = 256(0x100, float:3.59E-43)
            r4 = 128(0x80, float:1.8E-43)
            if (r8 == 0) goto L4d
            r5 = 11
            r6 = 384(0x180, float:5.38E-43)
            if (r8 == r1) goto L41
            r4 = 2
            if (r8 == r4) goto L36
            if (r8 != r2) goto L2e
            r8 = 8
            r7.SPARKLE_STEPS_SLIM = r8
            r8 = 12
            r7.SPARKLE_STEPS_BIG = r8
            java.lang.String r8 = "SCHWAEMM256-256"
            r7.algorithmName = r8
            r8 = 512(0x200, float:7.17E-43)
            r6 = r8
        L2a:
            r8 = r3
            r0 = r8
            r4 = r0
            goto L5b
        L2e:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Invalid definition of SCHWAEMM instance"
            r7.<init>(r8)
            throw r7
        L36:
            r7.SPARKLE_STEPS_SLIM = r0
            r7.SPARKLE_STEPS_BIG = r5
            java.lang.String r8 = "SCHWAEMM192-192"
            r7.algorithmName = r8
            r3 = 192(0xc0, float:2.69E-43)
            goto L2a
        L41:
            r7.SPARKLE_STEPS_SLIM = r0
            r7.SPARKLE_STEPS_BIG = r5
            java.lang.String r8 = "SCHWAEMM256-128"
            r7.algorithmName = r8
            r8 = r3
            r0 = r4
        L4b:
            r3 = r0
            goto L5b
        L4d:
            r7.SPARKLE_STEPS_SLIM = r0
            r8 = 10
            r7.SPARKLE_STEPS_BIG = r8
            java.lang.String r8 = "SCHWAEMM128-128"
            r7.algorithmName = r8
            r6 = r3
            r8 = r4
            r0 = r8
            goto L4b
        L5b:
            int r5 = r3 >>> 5
            r7.KEY_WORDS = r5
            int r3 = r3 >>> r2
            r7.KEY_SIZE = r3
            int r3 = r4 >>> 5
            r7.TAG_WORDS = r3
            int r3 = r4 >>> 3
            r7.MAC_SIZE = r3
            int r3 = r6 >>> 5
            r7.STATE_WORDS = r3
            int r4 = r8 >>> 5
            r7.RATE_WORDS = r4
            int r8 = r8 >>> r2
            r7.IV_SIZE = r8
            int r6 = r0 >>> 6
            int r0 = r0 >>> 5
            if (r4 <= r0) goto L7d
            int r0 = r0 - r1
            goto L7e
        L7d:
            r0 = -1
        L7e:
            r7.CAP_MASK = r0
            int r0 = r1 << r6
            int r1 = r0 << 24
            r7._A0 = r1
            r1 = r0 ^ 1
            int r1 = r1 << 24
            r7._A1 = r1
            r1 = r0 ^ 2
            int r1 = r1 << 24
            r7._M2 = r1
            r0 = r0 ^ r2
            int r0 = r0 << 24
            r7._M3 = r0
            int[] r0 = new int[r3]
            r7.state = r0
            int[] r0 = new int[r5]
            r7.f4475k = r0
            int[] r0 = new int[r4]
            r7.npub = r0
            r7.BlockSize = r8
            r7.AADBufferSize = r8
            org.bouncycastle.crypto.engines.AEADBaseEngine$ProcessingBufferType r8 = org.bouncycastle.crypto.engines.AEADBaseEngine.ProcessingBufferType.Buffered
            org.bouncycastle.crypto.engines.AEADBaseEngine$AADOperatorType r0 = org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperatorType.Default
            org.bouncycastle.crypto.engines.AEADBaseEngine$DataOperatorType r1 = org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperatorType.Default
            r7.setInnerMembers(r8, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.engines.SparkleEngine.<init>(org.bouncycastle.crypto.engines.SparkleEngine$SparkleParameters):void");
    }

    private static int ELL(int i8) {
        return (i8 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) ^ Integers.rotateRight(i8, 16);
    }

    private static void sparkle_opt(int[] iArr, int i8) {
        int length = iArr.length;
        if (length == 8) {
            sparkle_opt8(iArr, i8);
        } else if (length == 12) {
            sparkle_opt12(iArr, i8);
        } else {
            if (length != 16) {
                throw new IllegalStateException();
            }
            sparkle_opt16(iArr, i8);
        }
    }

    public static void sparkle_opt12(SparkleDigest.Friend friend, int[] iArr, int i8) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by SparkleDigest");
        }
        sparkle_opt12(iArr, i8);
    }

    public static void sparkle_opt16(SparkleDigest.Friend friend, int[] iArr, int i8) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by SparkleDigest");
        }
        sparkle_opt16(iArr, i8);
    }

    public static void sparkle_opt8(int[] iArr, int i8) {
        int i9 = iArr[0];
        int i10 = iArr[1];
        char c3 = 2;
        int i11 = iArr[2];
        char c8 = 3;
        int i12 = iArr[3];
        char c9 = 4;
        int i13 = iArr[4];
        char c10 = 5;
        int i14 = iArr[5];
        int i15 = iArr[6];
        int i16 = iArr[7];
        int i17 = 0;
        while (i17 < i8) {
            int[] iArr2 = RCON;
            int i18 = i10 ^ iArr2[i17 & 7];
            int i19 = i12 ^ i17;
            int i20 = iArr2[0];
            char c11 = c3;
            int iRotateRight = Integers.rotateRight(i18, 31) + i9;
            char c12 = c8;
            int iRotateRight2 = i18 ^ Integers.rotateRight(iRotateRight, 24);
            char c13 = c9;
            int iRotateRight3 = Integers.rotateRight(iRotateRight2, 17) + (iRotateRight ^ i20);
            int iRotateRight4 = iRotateRight2 ^ Integers.rotateRight(iRotateRight3, 17);
            int i21 = (iRotateRight3 ^ i20) + iRotateRight4;
            int iRotateRight5 = iRotateRight4 ^ Integers.rotateRight(i21, 31);
            int iRotateRight6 = Integers.rotateRight(iRotateRight5, 24) + (i21 ^ i20);
            char c14 = c10;
            int iRotateRight7 = iRotateRight5 ^ Integers.rotateRight(iRotateRight6, 16);
            int i22 = iRotateRight6 ^ i20;
            int i23 = iArr2[1];
            int iRotateRight8 = Integers.rotateRight(i19, 31) + i11;
            int iRotateRight9 = i19 ^ Integers.rotateRight(iRotateRight8, 24);
            int iRotateRight10 = Integers.rotateRight(iRotateRight9, 17) + (iRotateRight8 ^ i23);
            int iRotateRight11 = iRotateRight9 ^ Integers.rotateRight(iRotateRight10, 17);
            int i24 = (iRotateRight10 ^ i23) + iRotateRight11;
            int iRotateRight12 = iRotateRight11 ^ Integers.rotateRight(i24, 31);
            int iRotateRight13 = Integers.rotateRight(iRotateRight12, 24) + (i24 ^ i23);
            int iRotateRight14 = iRotateRight12 ^ Integers.rotateRight(iRotateRight13, 16);
            int i25 = iRotateRight13 ^ i23;
            int i26 = iArr2[c11];
            int iRotateRight15 = Integers.rotateRight(i14, 31) + i13;
            int iRotateRight16 = i14 ^ Integers.rotateRight(iRotateRight15, 24);
            int iRotateRight17 = Integers.rotateRight(iRotateRight16, 17) + (iRotateRight15 ^ i26);
            int iRotateRight18 = iRotateRight16 ^ Integers.rotateRight(iRotateRight17, 17);
            int i27 = (iRotateRight17 ^ i26) + iRotateRight18;
            int iRotateRight19 = iRotateRight18 ^ Integers.rotateRight(i27, 31);
            int iRotateRight20 = Integers.rotateRight(iRotateRight19, 24) + (i27 ^ i26);
            int iRotateRight21 = iRotateRight19 ^ Integers.rotateRight(iRotateRight20, 16);
            int i28 = iArr2[c12];
            int iRotateRight22 = Integers.rotateRight(i16, 31) + i15;
            int iRotateRight23 = i16 ^ Integers.rotateRight(iRotateRight22, 24);
            int iRotateRight24 = Integers.rotateRight(iRotateRight23, 17) + (iRotateRight22 ^ i28);
            int iRotateRight25 = Integers.rotateRight(iRotateRight24, 17) ^ iRotateRight23;
            int i29 = (iRotateRight24 ^ i28) + iRotateRight25;
            int iRotateRight26 = Integers.rotateRight(i29, 31) ^ iRotateRight25;
            int iRotateRight27 = Integers.rotateRight(iRotateRight26, 24) + (i29 ^ i28);
            int iRotateRight28 = iRotateRight26 ^ Integers.rotateRight(iRotateRight27, 16);
            int iELL = ELL(i22 ^ i25);
            int iELL2 = ELL(iRotateRight7 ^ iRotateRight14);
            int i30 = ((iRotateRight27 ^ i28) ^ i25) ^ iELL2;
            int i31 = (iRotateRight28 ^ iRotateRight14) ^ iELL;
            int i32 = iELL ^ (iRotateRight21 ^ iRotateRight7);
            i17++;
            i14 = iRotateRight7;
            i10 = i31;
            i15 = i25;
            i16 = iRotateRight14;
            i12 = i32;
            i11 = ((iRotateRight20 ^ i26) ^ i22) ^ iELL2;
            c3 = c11;
            c9 = c13;
            c10 = c14;
            i13 = i22;
            i9 = i30;
            c8 = c12;
        }
        iArr[0] = i9;
        iArr[1] = i10;
        iArr[c3] = i11;
        iArr[c8] = i12;
        iArr[c9] = i13;
        iArr[c10] = i14;
        iArr[6] = i15;
        iArr[7] = i16;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
        return super.doFinal(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.State state, boolean z) {
        finishAAD2(state);
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
        int i9 = 0;
        while (true) {
            int i10 = this.RATE_WORDS;
            if (i9 >= i10 / 2) {
                sparkle_opt(this.state, this.SPARKLE_STEPS_SLIM);
                return;
            }
            int i11 = (i10 / 2) + i9;
            int[] iArr = this.state;
            int i12 = iArr[i9];
            int i13 = iArr[i11];
            int iLittleEndianToInt = Pack.littleEndianToInt(bArr, (i9 * 4) + i8);
            int iLittleEndianToInt2 = Pack.littleEndianToInt(bArr, (i11 * 4) + i8);
            int[] iArr2 = this.state;
            int i14 = this.RATE_WORDS;
            iArr2[i9] = (iLittleEndianToInt ^ i13) ^ iArr2[i14 + i9];
            iArr2[i11] = ((i13 ^ i12) ^ iLittleEndianToInt2) ^ iArr2[i14 + (this.CAP_MASK & i11)];
            i9++;
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10 = 0;
        while (true) {
            int i11 = this.RATE_WORDS;
            if (i10 >= i11 / 2) {
                sparkle_opt(this.state, this.SPARKLE_STEPS_SLIM);
                this.encrypted = true;
                return;
            }
            int i12 = (i11 / 2) + i10;
            int[] iArr = this.state;
            int i13 = iArr[i10];
            int i14 = iArr[i12];
            int i15 = i10 * 4;
            int iLittleEndianToInt = Pack.littleEndianToInt(bArr, i8 + i15);
            int i16 = i12 * 4;
            int iLittleEndianToInt2 = Pack.littleEndianToInt(bArr, i8 + i16);
            int[] iArr2 = this.state;
            int i17 = this.RATE_WORDS;
            iArr2[i10] = ((i13 ^ i14) ^ iLittleEndianToInt) ^ iArr2[i17 + i10];
            iArr2[i12] = (i13 ^ iLittleEndianToInt2) ^ iArr2[i17 + (this.CAP_MASK & i12)];
            Pack.intToLittleEndian(iLittleEndianToInt ^ i13, bArr2, i9 + i15);
            Pack.intToLittleEndian(iLittleEndianToInt2 ^ i14, bArr2, i9 + i16);
            i10++;
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10 = 0;
        while (true) {
            int i11 = this.RATE_WORDS;
            if (i10 >= i11 / 2) {
                sparkle_opt(this.state, this.SPARKLE_STEPS_SLIM);
                this.encrypted = true;
                return;
            }
            int i12 = (i11 / 2) + i10;
            int[] iArr = this.state;
            int i13 = iArr[i10];
            int i14 = iArr[i12];
            int i15 = i10 * 4;
            int iLittleEndianToInt = Pack.littleEndianToInt(bArr, i8 + i15);
            int i16 = i12 * 4;
            int iLittleEndianToInt2 = Pack.littleEndianToInt(bArr, i8 + i16);
            int[] iArr2 = this.state;
            int i17 = this.RATE_WORDS;
            iArr2[i10] = (i14 ^ iLittleEndianToInt) ^ iArr2[i17 + i10];
            iArr2[i12] = ((i13 ^ i14) ^ iLittleEndianToInt2) ^ iArr2[i17 + (this.CAP_MASK & i12)];
            Pack.intToLittleEndian(iLittleEndianToInt ^ i13, bArr2, i9 + i15);
            Pack.intToLittleEndian(iLittleEndianToInt2 ^ i14, bArr2, i9 + i16);
            i10++;
        }
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
        int i8 = this.m_aadPos;
        int i9 = this.BlockSize;
        int i10 = 0;
        if (i8 < i9) {
            int[] iArr = this.state;
            int i11 = this.STATE_WORDS - 1;
            iArr[i11] = iArr[i11] ^ this._A0;
            byte[] bArr = this.m_aad;
            int i12 = i8 + 1;
            this.m_aadPos = i12;
            bArr[i8] = -128;
            Arrays.fill(bArr, i12, i9, (byte) 0);
        } else {
            int[] iArr2 = this.state;
            int i13 = this.STATE_WORDS - 1;
            iArr2[i13] = iArr2[i13] ^ this._A1;
        }
        while (true) {
            int i14 = this.RATE_WORDS;
            if (i10 >= i14 / 2) {
                sparkle_opt(this.state, this.SPARKLE_STEPS_BIG);
                return;
            }
            int i15 = (i14 / 2) + i10;
            int[] iArr3 = this.state;
            int i16 = iArr3[i10];
            int i17 = iArr3[i15];
            int iLittleEndianToInt = Pack.littleEndianToInt(this.m_aad, i10 * 4);
            int iLittleEndianToInt2 = Pack.littleEndianToInt(this.m_aad, i15 * 4);
            int[] iArr4 = this.state;
            int i18 = this.RATE_WORDS;
            iArr4[i10] = (iLittleEndianToInt ^ i17) ^ iArr4[i18 + i10];
            iArr4[i15] = ((i17 ^ i16) ^ iLittleEndianToInt2) ^ iArr4[i18 + (this.CAP_MASK & i15)];
            i10++;
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i8) {
        int i9;
        if (this.encrypted || this.m_bufPos > 0) {
            int[] iArr = this.state;
            int i10 = this.STATE_WORDS - 1;
            iArr[i10] = iArr[i10] ^ (this.m_bufPos < this.IV_SIZE ? this._M2 : this._M3);
            int[] iArr2 = new int[this.RATE_WORDS];
            int i11 = 0;
            while (true) {
                i9 = this.m_bufPos;
                if (i11 >= i9) {
                    break;
                }
                int i12 = i11 >>> 2;
                iArr2[i12] = iArr2[i12] | ((this.m_buf[i11] & 255) << ((i11 & 3) << 3));
                i11++;
            }
            if (i9 < this.IV_SIZE) {
                if (!this.forEncryption) {
                    int i13 = (i9 & 3) << 3;
                    int i14 = i9 >>> 2;
                    int i15 = iArr2[i14];
                    int[] iArr3 = this.state;
                    iArr2[i14] = ((iArr3[i9 >>> 2] >>> i13) << i13) | i15;
                    int i16 = (i9 >>> 2) + 1;
                    System.arraycopy(iArr3, i16, iArr2, i16, this.RATE_WORDS - i16);
                }
                int i17 = this.m_bufPos;
                int i18 = i17 >>> 2;
                iArr2[i18] = (128 << ((i17 & 3) << 3)) ^ iArr2[i18];
            }
            int i19 = 0;
            while (true) {
                int i20 = this.RATE_WORDS;
                if (i19 >= i20 / 2) {
                    break;
                }
                int i21 = (i20 / 2) + i19;
                int[] iArr4 = this.state;
                int i22 = iArr4[i19];
                int i23 = iArr4[i21];
                if (this.forEncryption) {
                    iArr4[i19] = (iArr2[i19] ^ i23) ^ iArr4[i20 + i19];
                    iArr4[i21] = iArr4[i20 + (this.CAP_MASK & i21)] ^ ((i22 ^ i23) ^ iArr2[i21]);
                } else {
                    iArr4[i19] = ((i22 ^ i23) ^ iArr2[i19]) ^ iArr4[i20 + i19];
                    iArr4[i21] = iArr4[i20 + (this.CAP_MASK & i21)] ^ (iArr2[i21] ^ i22);
                }
                iArr2[i19] = iArr2[i19] ^ i22;
                iArr2[i21] = iArr2[i21] ^ i23;
                i19++;
            }
            int i24 = 0;
            while (i24 < this.m_bufPos) {
                bArr[i8] = (byte) (iArr2[i24 >>> 2] >>> ((i24 & 3) << 3));
                i24++;
                i8++;
            }
            sparkle_opt(this.state, this.SPARKLE_STEPS_BIG);
        }
        for (int i25 = 0; i25 < this.KEY_WORDS; i25++) {
            int[] iArr5 = this.state;
            int i26 = this.RATE_WORDS + i25;
            iArr5[i26] = iArr5[i26] ^ this.f4475k[i25];
        }
        Pack.intToLittleEndian(this.state, this.RATE_WORDS, this.TAG_WORDS, this.mac, 0);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    public static void sparkle_opt12(int[] iArr, int i8) {
        int i9 = iArr[0];
        int i10 = iArr[1];
        int i11 = iArr[2];
        int i12 = iArr[3];
        char c3 = 4;
        int i13 = iArr[4];
        char c8 = 5;
        int i14 = iArr[5];
        char c9 = 6;
        int i15 = iArr[6];
        char c10 = 7;
        int i16 = iArr[7];
        int i17 = iArr[8];
        int i18 = iArr[9];
        int i19 = iArr[10];
        int i20 = iArr[11];
        int i21 = 0;
        int i22 = i18;
        while (i21 < i8) {
            int[] iArr2 = RCON;
            int i23 = i10 ^ iArr2[i21 & 7];
            int i24 = i12 ^ i21;
            int i25 = iArr2[0];
            char c11 = c3;
            int iRotateRight = Integers.rotateRight(i23, 31) + i9;
            char c12 = c8;
            int iRotateRight2 = i23 ^ Integers.rotateRight(iRotateRight, 24);
            char c13 = c9;
            int iRotateRight3 = Integers.rotateRight(iRotateRight2, 17) + (iRotateRight ^ i25);
            int iRotateRight4 = iRotateRight2 ^ Integers.rotateRight(iRotateRight3, 17);
            int i26 = (iRotateRight3 ^ i25) + iRotateRight4;
            int iRotateRight5 = iRotateRight4 ^ Integers.rotateRight(i26, 31);
            int iRotateRight6 = Integers.rotateRight(iRotateRight5, 24) + (i26 ^ i25);
            char c14 = c10;
            int iRotateRight7 = iRotateRight5 ^ Integers.rotateRight(iRotateRight6, 16);
            int i27 = iRotateRight6 ^ i25;
            int i28 = iArr2[1];
            int iRotateRight8 = Integers.rotateRight(i24, 31) + i11;
            int iRotateRight9 = i24 ^ Integers.rotateRight(iRotateRight8, 24);
            int iRotateRight10 = Integers.rotateRight(iRotateRight9, 17) + (iRotateRight8 ^ i28);
            int iRotateRight11 = iRotateRight9 ^ Integers.rotateRight(iRotateRight10, 17);
            int i29 = (iRotateRight10 ^ i28) + iRotateRight11;
            int iRotateRight12 = iRotateRight11 ^ Integers.rotateRight(i29, 31);
            int iRotateRight13 = Integers.rotateRight(iRotateRight12, 24) + (i29 ^ i28);
            int iRotateRight14 = iRotateRight12 ^ Integers.rotateRight(iRotateRight13, 16);
            int i30 = iRotateRight13 ^ i28;
            int i31 = iArr2[2];
            int iRotateRight15 = Integers.rotateRight(i14, 31) + i13;
            int iRotateRight16 = i14 ^ Integers.rotateRight(iRotateRight15, 24);
            int iRotateRight17 = Integers.rotateRight(iRotateRight16, 17) + (iRotateRight15 ^ i31);
            int iRotateRight18 = iRotateRight16 ^ Integers.rotateRight(iRotateRight17, 17);
            int i32 = (iRotateRight17 ^ i31) + iRotateRight18;
            int iRotateRight19 = iRotateRight18 ^ Integers.rotateRight(i32, 31);
            int iRotateRight20 = Integers.rotateRight(iRotateRight19, 24) + (i32 ^ i31);
            int iRotateRight21 = iRotateRight19 ^ Integers.rotateRight(iRotateRight20, 16);
            int i33 = iRotateRight20 ^ i31;
            int i34 = iArr2[3];
            int iRotateRight22 = Integers.rotateRight(i16, 31) + i15;
            int iRotateRight23 = i16 ^ Integers.rotateRight(iRotateRight22, 24);
            int iRotateRight24 = Integers.rotateRight(iRotateRight23, 17) + (iRotateRight22 ^ i34);
            int iRotateRight25 = iRotateRight23 ^ Integers.rotateRight(iRotateRight24, 17);
            int i35 = (iRotateRight24 ^ i34) + iRotateRight25;
            int iRotateRight26 = iRotateRight25 ^ Integers.rotateRight(i35, 31);
            int iRotateRight27 = Integers.rotateRight(iRotateRight26, 24) + (i35 ^ i34);
            int iRotateRight28 = iRotateRight26 ^ Integers.rotateRight(iRotateRight27, 16);
            int i36 = iRotateRight27 ^ i34;
            int i37 = iArr2[c11];
            int iRotateRight29 = Integers.rotateRight(i22, 31) + i17;
            int iRotateRight30 = i22 ^ Integers.rotateRight(iRotateRight29, 24);
            int iRotateRight31 = Integers.rotateRight(iRotateRight30, 17) + (iRotateRight29 ^ i37);
            int iRotateRight32 = iRotateRight30 ^ Integers.rotateRight(iRotateRight31, 17);
            int i38 = (iRotateRight31 ^ i37) + iRotateRight32;
            int iRotateRight33 = iRotateRight32 ^ Integers.rotateRight(i38, 31);
            int iRotateRight34 = Integers.rotateRight(iRotateRight33, 24) + (i38 ^ i37);
            int iRotateRight35 = iRotateRight33 ^ Integers.rotateRight(iRotateRight34, 16);
            int i39 = iRotateRight34 ^ i37;
            int i40 = iArr2[c12];
            int iRotateRight36 = Integers.rotateRight(i20, 31) + i19;
            int iRotateRight37 = i20 ^ Integers.rotateRight(iRotateRight36, 24);
            int iRotateRight38 = Integers.rotateRight(iRotateRight37, 17) + (iRotateRight36 ^ i40);
            int iRotateRight39 = iRotateRight37 ^ Integers.rotateRight(iRotateRight38, 17);
            int i41 = (iRotateRight38 ^ i40) + iRotateRight39;
            int iRotateRight40 = iRotateRight39 ^ Integers.rotateRight(i41, 31);
            int iRotateRight41 = Integers.rotateRight(iRotateRight40, 24) + (i41 ^ i40);
            int iRotateRight42 = iRotateRight40 ^ Integers.rotateRight(iRotateRight41, 16);
            int i42 = iRotateRight41 ^ i40;
            int iELL = ELL((i27 ^ i30) ^ i33);
            int iELL2 = ELL((iRotateRight7 ^ iRotateRight14) ^ iRotateRight21);
            int i43 = (i39 ^ i30) ^ iELL2;
            int i44 = (iRotateRight35 ^ iRotateRight14) ^ iELL;
            int i45 = (iRotateRight42 ^ iRotateRight21) ^ iELL;
            int i46 = iELL ^ (iRotateRight28 ^ iRotateRight7);
            i21++;
            i16 = iRotateRight7;
            i17 = i30;
            i11 = (i42 ^ i33) ^ iELL2;
            i19 = i33;
            i13 = (i36 ^ i27) ^ iELL2;
            c3 = c11;
            c10 = c14;
            i10 = i44;
            i15 = i27;
            i22 = iRotateRight14;
            i9 = i43;
            c9 = c13;
            i12 = i45;
            i20 = iRotateRight21;
            i14 = i46;
            c8 = c12;
        }
        iArr[0] = i9;
        iArr[1] = i10;
        iArr[2] = i11;
        iArr[3] = i12;
        iArr[c3] = i13;
        iArr[c8] = i14;
        iArr[c9] = i15;
        iArr[c10] = i16;
        iArr[8] = i17;
        iArr[9] = i22;
        iArr[10] = i19;
        iArr[11] = i20;
    }

    public static void sparkle_opt16(int[] iArr, int i8) {
        int i9 = iArr[0];
        int i10 = iArr[1];
        int i11 = iArr[2];
        int i12 = iArr[3];
        int i13 = iArr[4];
        int i14 = iArr[5];
        char c3 = 6;
        int i15 = iArr[6];
        char c8 = 7;
        int i16 = iArr[7];
        int i17 = iArr[8];
        int i18 = iArr[9];
        int i19 = iArr[10];
        int i20 = iArr[11];
        int i21 = iArr[12];
        int i22 = iArr[13];
        int i23 = iArr[14];
        int i24 = i20;
        int i25 = i22;
        int i26 = iArr[15];
        int i27 = 0;
        int i28 = i18;
        while (i27 < i8) {
            int[] iArr2 = RCON;
            int i29 = i10 ^ iArr2[i27 & 7];
            int i30 = i12 ^ i27;
            int i31 = iArr2[0];
            char c9 = c3;
            int iRotateRight = Integers.rotateRight(i29, 31) + i9;
            char c10 = c8;
            int iRotateRight2 = i29 ^ Integers.rotateRight(iRotateRight, 24);
            int iRotateRight3 = Integers.rotateRight(iRotateRight2, 17) + (iRotateRight ^ i31);
            int iRotateRight4 = iRotateRight2 ^ Integers.rotateRight(iRotateRight3, 17);
            int i32 = (iRotateRight3 ^ i31) + iRotateRight4;
            int iRotateRight5 = iRotateRight4 ^ Integers.rotateRight(i32, 31);
            int iRotateRight6 = Integers.rotateRight(iRotateRight5, 24) + (i32 ^ i31);
            int iRotateRight7 = iRotateRight5 ^ Integers.rotateRight(iRotateRight6, 16);
            int i33 = iRotateRight6 ^ i31;
            int i34 = iArr2[1];
            int iRotateRight8 = Integers.rotateRight(i30, 31) + i11;
            int iRotateRight9 = i30 ^ Integers.rotateRight(iRotateRight8, 24);
            int iRotateRight10 = Integers.rotateRight(iRotateRight9, 17) + (iRotateRight8 ^ i34);
            int iRotateRight11 = iRotateRight9 ^ Integers.rotateRight(iRotateRight10, 17);
            int i35 = (iRotateRight10 ^ i34) + iRotateRight11;
            int iRotateRight12 = iRotateRight11 ^ Integers.rotateRight(i35, 31);
            int iRotateRight13 = Integers.rotateRight(iRotateRight12, 24) + (i35 ^ i34);
            int iRotateRight14 = iRotateRight12 ^ Integers.rotateRight(iRotateRight13, 16);
            int i36 = iRotateRight13 ^ i34;
            int i37 = iArr2[2];
            int iRotateRight15 = Integers.rotateRight(i14, 31) + i13;
            int iRotateRight16 = i14 ^ Integers.rotateRight(iRotateRight15, 24);
            int iRotateRight17 = Integers.rotateRight(iRotateRight16, 17) + (iRotateRight15 ^ i37);
            int iRotateRight18 = iRotateRight16 ^ Integers.rotateRight(iRotateRight17, 17);
            int i38 = (iRotateRight17 ^ i37) + iRotateRight18;
            int iRotateRight19 = iRotateRight18 ^ Integers.rotateRight(i38, 31);
            int iRotateRight20 = Integers.rotateRight(iRotateRight19, 24) + (i38 ^ i37);
            int iRotateRight21 = iRotateRight19 ^ Integers.rotateRight(iRotateRight20, 16);
            int i39 = iRotateRight20 ^ i37;
            int i40 = iArr2[3];
            int iRotateRight22 = Integers.rotateRight(i16, 31) + i15;
            int iRotateRight23 = i16 ^ Integers.rotateRight(iRotateRight22, 24);
            int iRotateRight24 = Integers.rotateRight(iRotateRight23, 17) + (iRotateRight22 ^ i40);
            int iRotateRight25 = iRotateRight23 ^ Integers.rotateRight(iRotateRight24, 17);
            int i41 = (iRotateRight24 ^ i40) + iRotateRight25;
            int iRotateRight26 = iRotateRight25 ^ Integers.rotateRight(i41, 31);
            int iRotateRight27 = Integers.rotateRight(iRotateRight26, 24) + (i41 ^ i40);
            int iRotateRight28 = iRotateRight26 ^ Integers.rotateRight(iRotateRight27, 16);
            int i42 = i40 ^ iRotateRight27;
            int i43 = iArr2[4];
            int iRotateRight29 = Integers.rotateRight(i28, 31) + i17;
            int iRotateRight30 = i28 ^ Integers.rotateRight(iRotateRight29, 24);
            int iRotateRight31 = Integers.rotateRight(iRotateRight30, 17) + (iRotateRight29 ^ i43);
            int iRotateRight32 = iRotateRight30 ^ Integers.rotateRight(iRotateRight31, 17);
            int i44 = (iRotateRight31 ^ i43) + iRotateRight32;
            int iRotateRight33 = iRotateRight32 ^ Integers.rotateRight(i44, 31);
            int iRotateRight34 = Integers.rotateRight(iRotateRight33, 24) + (i44 ^ i43);
            int iRotateRight35 = iRotateRight33 ^ Integers.rotateRight(iRotateRight34, 16);
            int i45 = iRotateRight34 ^ i43;
            int i46 = iArr2[5];
            int iRotateRight36 = Integers.rotateRight(i24, 31) + i19;
            int iRotateRight37 = i24 ^ Integers.rotateRight(iRotateRight36, 24);
            int iRotateRight38 = Integers.rotateRight(iRotateRight37, 17) + (iRotateRight36 ^ i46);
            int iRotateRight39 = iRotateRight37 ^ Integers.rotateRight(iRotateRight38, 17);
            int i47 = (iRotateRight38 ^ i46) + iRotateRight39;
            int iRotateRight40 = iRotateRight39 ^ Integers.rotateRight(i47, 31);
            int iRotateRight41 = Integers.rotateRight(iRotateRight40, 24) + (i47 ^ i46);
            int iRotateRight42 = iRotateRight40 ^ Integers.rotateRight(iRotateRight41, 16);
            int i48 = iRotateRight41 ^ i46;
            int i49 = iArr2[c9];
            int iRotateRight43 = Integers.rotateRight(i25, 31) + i21;
            int iRotateRight44 = i25 ^ Integers.rotateRight(iRotateRight43, 24);
            int iRotateRight45 = Integers.rotateRight(iRotateRight44, 17) + (iRotateRight43 ^ i49);
            int iRotateRight46 = iRotateRight44 ^ Integers.rotateRight(iRotateRight45, 17);
            int i50 = (iRotateRight45 ^ i49) + iRotateRight46;
            int iRotateRight47 = iRotateRight46 ^ Integers.rotateRight(i50, 31);
            int iRotateRight48 = Integers.rotateRight(iRotateRight47, 24) + (i50 ^ i49);
            int iRotateRight49 = iRotateRight47 ^ Integers.rotateRight(iRotateRight48, 16);
            int i51 = iRotateRight48 ^ i49;
            int i52 = iArr2[c10];
            int iRotateRight50 = Integers.rotateRight(i26, 31) + i23;
            int iRotateRight51 = i26 ^ Integers.rotateRight(iRotateRight50, 24);
            int iRotateRight52 = Integers.rotateRight(iRotateRight51, 17) + (iRotateRight50 ^ i52);
            int iRotateRight53 = iRotateRight51 ^ Integers.rotateRight(iRotateRight52, 17);
            int i53 = (iRotateRight52 ^ i52) + iRotateRight53;
            int iRotateRight54 = iRotateRight53 ^ Integers.rotateRight(i53, 31);
            int iRotateRight55 = Integers.rotateRight(iRotateRight54, 24) + (i53 ^ i52);
            int iRotateRight56 = iRotateRight54 ^ Integers.rotateRight(iRotateRight55, 16);
            int i54 = iRotateRight55 ^ i52;
            int iELL = ELL(((i33 ^ i36) ^ i39) ^ i42);
            int iELL2 = ELL(((iRotateRight7 ^ iRotateRight14) ^ iRotateRight21) ^ iRotateRight28);
            int i55 = iRotateRight14 ^ iRotateRight42;
            int i56 = (i48 ^ i36) ^ iELL2;
            int i57 = (i51 ^ i39) ^ iELL2;
            int i58 = (iRotateRight21 ^ iRotateRight49) ^ iELL;
            int i59 = (i54 ^ i42) ^ iELL2;
            int i60 = (i33 ^ i45) ^ iELL2;
            i16 = (iRotateRight7 ^ iRotateRight35) ^ iELL;
            i27++;
            i14 = (iRotateRight56 ^ iRotateRight28) ^ iELL;
            i28 = iRotateRight7;
            i10 = i55 ^ iELL;
            i19 = i36;
            i11 = i57;
            i25 = iRotateRight21;
            i15 = i60;
            i9 = i56;
            i24 = iRotateRight14;
            i23 = i42;
            i12 = i58;
            c3 = c9;
            i17 = i33;
            i21 = i39;
            i13 = i59;
            i26 = iRotateRight28;
            c8 = c10;
        }
        iArr[0] = i9;
        iArr[1] = i10;
        iArr[2] = i11;
        iArr[3] = i12;
        iArr[4] = i13;
        iArr[5] = i14;
        iArr[c3] = i15;
        iArr[c8] = i16;
        iArr[8] = i17;
        iArr[9] = i28;
        iArr[10] = i19;
        iArr[11] = i24;
        iArr[12] = i21;
        iArr[13] = i25;
        iArr[14] = i23;
        iArr[15] = i26;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void init(byte[] bArr, byte[] bArr2) {
        Pack.littleEndianToInt(bArr, 0, this.f4475k);
        Pack.littleEndianToInt(bArr2, 0, this.npub);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void reset(boolean z) {
        this.encrypted = false;
        System.arraycopy(this.npub, 0, this.state, 0, this.RATE_WORDS);
        System.arraycopy(this.f4475k, 0, this.state, this.RATE_WORDS, this.KEY_WORDS);
        sparkle_opt(this.state, this.SPARKLE_STEPS_BIG);
        super.reset(z);
    }
}
