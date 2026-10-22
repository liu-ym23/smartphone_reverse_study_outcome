package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class Poly1305 implements Mac {
    private static final int BLOCK_SIZE = 16;
    private final BlockCipher cipher;
    private final byte[] currentBlock;
    private int currentBlockOffset;

    /* renamed from: h0, reason: collision with root package name */
    private int f4495h0;

    /* renamed from: h1, reason: collision with root package name */
    private int f4496h1;

    /* renamed from: h2, reason: collision with root package name */
    private int f4497h2;
    private int h3;

    /* renamed from: h4, reason: collision with root package name */
    private int f4498h4;
    private int k0;

    /* renamed from: k1, reason: collision with root package name */
    private int f4499k1;

    /* renamed from: k2, reason: collision with root package name */
    private int f4500k2;

    /* renamed from: k3, reason: collision with root package name */
    private int f4501k3;

    /* renamed from: r0, reason: collision with root package name */
    private int f4502r0;

    /* renamed from: r1, reason: collision with root package name */
    private int f4503r1;

    /* renamed from: r2, reason: collision with root package name */
    private int f4504r2;
    private int r3;

    /* renamed from: r4, reason: collision with root package name */
    private int f4505r4;

    /* renamed from: s1, reason: collision with root package name */
    private int f4506s1;

    /* renamed from: s2, reason: collision with root package name */
    private int f4507s2;

    /* renamed from: s3, reason: collision with root package name */
    private int f4508s3;

    /* renamed from: s4, reason: collision with root package name */
    private int f4509s4;
    private final byte[] singleByte;

    public Poly1305() {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        this.cipher = null;
    }

    private static final long mul32x32_64(int i8, int i9) {
        return (i8 & 4294967295L) * i9;
    }

    private void processBlock() {
        int i8 = this.currentBlockOffset;
        if (i8 < 16) {
            this.currentBlock[i8] = 1;
            for (int i9 = i8 + 1; i9 < 16; i9++) {
                this.currentBlock[i9] = 0;
            }
        }
        long jLittleEndianToInt = Pack.littleEndianToInt(this.currentBlock, 0);
        long j4 = jLittleEndianToInt & 4294967295L;
        long jLittleEndianToInt2 = Pack.littleEndianToInt(this.currentBlock, 4) & 4294967295L;
        long jLittleEndianToInt3 = Pack.littleEndianToInt(this.currentBlock, 8) & 4294967295L;
        long jLittleEndianToInt4 = 4294967295L & Pack.littleEndianToInt(this.currentBlock, 12);
        int i10 = (int) (this.f4495h0 + (jLittleEndianToInt & 67108863));
        this.f4495h0 = i10;
        this.f4496h1 = (int) (this.f4496h1 + ((((jLittleEndianToInt2 << 32) | j4) >>> 26) & 67108863));
        this.f4497h2 = (int) (this.f4497h2 + (((jLittleEndianToInt2 | (jLittleEndianToInt3 << 32)) >>> 20) & 67108863));
        this.h3 = (int) (this.h3 + ((((jLittleEndianToInt4 << 32) | jLittleEndianToInt3) >>> 14) & 67108863));
        int i11 = (int) (this.f4498h4 + (jLittleEndianToInt4 >>> 8));
        this.f4498h4 = i11;
        if (this.currentBlockOffset == 16) {
            this.f4498h4 = i11 + 16777216;
        }
        long jMul32x32_64 = mul32x32_64(i10, this.f4502r0) + mul32x32_64(this.f4496h1, this.f4509s4) + mul32x32_64(this.f4497h2, this.f4508s3) + mul32x32_64(this.h3, this.f4507s2) + mul32x32_64(this.f4498h4, this.f4506s1);
        long jMul32x32_642 = mul32x32_64(this.f4495h0, this.f4503r1) + mul32x32_64(this.f4496h1, this.f4502r0) + mul32x32_64(this.f4497h2, this.f4509s4) + mul32x32_64(this.h3, this.f4508s3) + mul32x32_64(this.f4498h4, this.f4507s2);
        long jMul32x32_643 = mul32x32_64(this.f4495h0, this.f4504r2) + mul32x32_64(this.f4496h1, this.f4503r1) + mul32x32_64(this.f4497h2, this.f4502r0) + mul32x32_64(this.h3, this.f4509s4) + mul32x32_64(this.f4498h4, this.f4508s3);
        long jMul32x32_644 = mul32x32_64(this.f4495h0, this.r3) + mul32x32_64(this.f4496h1, this.f4504r2) + mul32x32_64(this.f4497h2, this.f4503r1) + mul32x32_64(this.h3, this.f4502r0) + mul32x32_64(this.f4498h4, this.f4509s4);
        long jMul32x32_645 = mul32x32_64(this.f4495h0, this.f4505r4) + mul32x32_64(this.f4496h1, this.r3) + mul32x32_64(this.f4497h2, this.f4504r2) + mul32x32_64(this.h3, this.f4503r1) + mul32x32_64(this.f4498h4, this.f4502r0);
        long j8 = jMul32x32_642 + (jMul32x32_64 >>> 26);
        long j9 = jMul32x32_643 + (j8 >>> 26);
        this.f4497h2 = ((int) j9) & 67108863;
        long j10 = jMul32x32_644 + (j9 >>> 26);
        this.h3 = ((int) j10) & 67108863;
        long j11 = jMul32x32_645 + (j10 >>> 26);
        this.f4498h4 = ((int) j11) & 67108863;
        int i12 = (((int) (j11 >>> 26)) * 5) + (((int) jMul32x32_64) & 67108863);
        this.f4496h1 = (((int) j8) & 67108863) + (i12 >>> 26);
        this.f4495h0 = i12 & 67108863;
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        int i8 = 16;
        if (this.cipher != null && (bArr2 == null || bArr2.length != 16)) {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
        int iLittleEndianToInt = Pack.littleEndianToInt(bArr, 0);
        int iLittleEndianToInt2 = Pack.littleEndianToInt(bArr, 4);
        int iLittleEndianToInt3 = Pack.littleEndianToInt(bArr, 8);
        int iLittleEndianToInt4 = Pack.littleEndianToInt(bArr, 12);
        this.f4502r0 = 67108863 & iLittleEndianToInt;
        int i9 = ((iLittleEndianToInt >>> 26) | (iLittleEndianToInt2 << 6)) & 67108611;
        this.f4503r1 = i9;
        int i10 = ((iLittleEndianToInt2 >>> 20) | (iLittleEndianToInt3 << 12)) & 67092735;
        this.f4504r2 = i10;
        int i11 = ((iLittleEndianToInt3 >>> 14) | (iLittleEndianToInt4 << 18)) & 66076671;
        this.r3 = i11;
        int i12 = (iLittleEndianToInt4 >>> 8) & 1048575;
        this.f4505r4 = i12;
        this.f4506s1 = i9 * 5;
        this.f4507s2 = i10 * 5;
        this.f4508s3 = i11 * 5;
        this.f4509s4 = i12 * 5;
        BlockCipher blockCipher = this.cipher;
        if (blockCipher != null) {
            byte[] bArr3 = new byte[16];
            blockCipher.init(true, new KeyParameter(bArr, 16, 16));
            this.cipher.processBlock(bArr2, 0, bArr3, 0);
            i8 = 0;
            bArr = bArr3;
        }
        this.k0 = Pack.littleEndianToInt(bArr, i8);
        this.f4499k1 = Pack.littleEndianToInt(bArr, i8 + 4);
        this.f4500k2 = Pack.littleEndianToInt(bArr, i8 + 8);
        this.f4501k3 = Pack.littleEndianToInt(bArr, i8 + 12);
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i8) {
        if (i8 + 16 > bArr.length) {
            throw new OutputLengthException("Output buffer is too short.");
        }
        if (this.currentBlockOffset > 0) {
            processBlock();
        }
        int i9 = this.f4496h1;
        int i10 = this.f4495h0;
        int i11 = i9 + (i10 >>> 26);
        int i12 = this.f4497h2 + (i11 >>> 26);
        int i13 = this.h3 + (i12 >>> 26);
        int i14 = i12 & 67108863;
        int i15 = this.f4498h4 + (i13 >>> 26);
        int i16 = i13 & 67108863;
        int i17 = ((i15 >>> 26) * 5) + (i10 & 67108863);
        int i18 = i15 & 67108863;
        int i19 = (i11 & 67108863) + (i17 >>> 26);
        int i20 = i17 & 67108863;
        int i21 = i20 + 5;
        int i22 = (i21 >>> 26) + i19;
        int i23 = (i22 >>> 26) + i14;
        int i24 = (i23 >>> 26) + i16;
        int i25 = 67108863 & i24;
        int i26 = ((i24 >>> 26) + i18) - 67108864;
        int i27 = (i26 >>> 31) - 1;
        int i28 = ~i27;
        this.f4495h0 = (i20 & i28) | (i21 & 67108863 & i27);
        this.f4496h1 = (i19 & i28) | (i22 & 67108863 & i27);
        this.f4497h2 = (i14 & i28) | (i23 & 67108863 & i27);
        this.h3 = (i25 & i27) | (i16 & i28);
        this.f4498h4 = (i18 & i28) | (i26 & i27);
        long j4 = (((r3 << 26) | r8) & 4294967295L) + (this.k0 & 4294967295L);
        long j8 = (((r3 >>> 6) | (r6 << 20)) & 4294967295L) + (this.f4499k1 & 4294967295L);
        Pack.intToLittleEndian((int) j4, bArr, i8);
        long j9 = j8 + (j4 >>> 32);
        Pack.intToLittleEndian((int) j9, bArr, i8 + 4);
        long j10 = (((r6 >>> 12) | (r5 << 14)) & 4294967295L) + (this.f4500k2 & 4294967295L) + (j9 >>> 32);
        Pack.intToLittleEndian((int) j10, bArr, i8 + 8);
        Pack.intToLittleEndian((int) ((((r5 >>> 18) | (r4 << 8)) & 4294967295L) + (this.f4501k3 & 4294967295L) + (j10 >>> 32)), bArr, i8 + 12);
        reset();
        return 16;
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        if (this.cipher == null) {
            return "Poly1305";
        }
        return "Poly1305-" + this.cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        byte[] iv;
        if (this.cipher == null) {
            iv = null;
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            iv = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        }
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("Poly1305 requires a key.");
        }
        setKey(((KeyParameter) cipherParameters).getKey(), iv);
        reset();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        this.currentBlockOffset = 0;
        this.f4498h4 = 0;
        this.h3 = 0;
        this.f4497h2 = 0;
        this.f4496h1 = 0;
        this.f4495h0 = 0;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte b9) {
        byte[] bArr = this.singleByte;
        bArr[0] = b9;
        update(bArr, 0, 1);
    }

    public Poly1305(BlockCipher blockCipher) {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
        }
        this.cipher = blockCipher;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] bArr, int i8, int i9) {
        int i10 = 0;
        while (i9 > i10) {
            if (this.currentBlockOffset == 16) {
                processBlock();
                this.currentBlockOffset = 0;
            }
            int iMin = Math.min(i9 - i10, 16 - this.currentBlockOffset);
            System.arraycopy(bArr, i10 + i8, this.currentBlock, this.currentBlockOffset, iMin);
            i10 += iMin;
            this.currentBlockOffset += iMin;
        }
    }
}
