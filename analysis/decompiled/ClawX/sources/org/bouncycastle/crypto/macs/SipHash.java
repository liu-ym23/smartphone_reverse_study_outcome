package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class SipHash implements Mac {

    /* renamed from: c, reason: collision with root package name */
    protected final int f4510c;
    protected final int d;
    protected long k0;

    /* renamed from: k1, reason: collision with root package name */
    protected long f4511k1;

    /* renamed from: m, reason: collision with root package name */
    protected long f4512m;

    /* renamed from: v0, reason: collision with root package name */
    protected long f4513v0;

    /* renamed from: v1, reason: collision with root package name */
    protected long f4514v1;

    /* renamed from: v2, reason: collision with root package name */
    protected long f4515v2;

    /* renamed from: v3, reason: collision with root package name */
    protected long f4516v3;
    protected int wordCount;
    protected int wordPos;

    public SipHash() {
        this.f4512m = 0L;
        this.wordPos = 0;
        this.wordCount = 0;
        this.f4510c = 2;
        this.d = 4;
    }

    public static long rotateLeft(long j4, int i8) {
        return (j4 >>> (-i8)) | (j4 << i8);
    }

    public void applySipRounds(int i8) {
        long jRotateLeft = this.f4513v0;
        long jRotateLeft2 = this.f4514v1;
        long jRotateLeft3 = this.f4515v2;
        long jRotateLeft4 = this.f4516v3;
        for (int i9 = 0; i9 < i8; i9++) {
            long j4 = jRotateLeft + jRotateLeft2;
            long j8 = jRotateLeft3 + jRotateLeft4;
            long jRotateLeft5 = rotateLeft(jRotateLeft2, 13) ^ j4;
            long jRotateLeft6 = rotateLeft(jRotateLeft4, 16) ^ j8;
            long j9 = j8 + jRotateLeft5;
            jRotateLeft = rotateLeft(j4, 32) + jRotateLeft6;
            jRotateLeft2 = rotateLeft(jRotateLeft5, 17) ^ j9;
            jRotateLeft4 = rotateLeft(jRotateLeft6, 21) ^ jRotateLeft;
            jRotateLeft3 = rotateLeft(j9, 32);
        }
        this.f4513v0 = jRotateLeft;
        this.f4514v1 = jRotateLeft2;
        this.f4515v2 = jRotateLeft3;
        this.f4516v3 = jRotateLeft4;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i8) {
        Pack.longToLittleEndian(doFinal(), bArr, i8);
        return 8;
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "SipHash-" + this.f4510c + "-" + this.d;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
        }
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        if (key.length != 16) {
            throw new IllegalArgumentException("'params' must be a 128-bit key");
        }
        this.k0 = Pack.littleEndianToLong(key, 0);
        this.f4511k1 = Pack.littleEndianToLong(key, 8);
        reset();
    }

    public void processMessageWord() {
        this.wordCount++;
        this.f4516v3 ^= this.f4512m;
        applySipRounds(this.f4510c);
        this.f4513v0 ^= this.f4512m;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        long j4 = this.k0;
        this.f4513v0 = 8317987319222330741L ^ j4;
        long j8 = this.f4511k1;
        this.f4514v1 = 7237128888997146477L ^ j8;
        this.f4515v2 = j4 ^ 7816392313619706465L;
        this.f4516v3 = 8387220255154660723L ^ j8;
        this.f4512m = 0L;
        this.wordPos = 0;
        this.wordCount = 0;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte b9) {
        this.f4512m = (this.f4512m >>> 8) | ((b9 & 255) << 56);
        int i8 = this.wordPos + 1;
        this.wordPos = i8;
        if (i8 == 8) {
            processMessageWord();
            this.wordPos = 0;
        }
    }

    public SipHash(int i8, int i9) {
        this.f4512m = 0L;
        this.wordPos = 0;
        this.wordCount = 0;
        this.f4510c = i8;
        this.d = i9;
    }

    public long doFinal() {
        this.f4512m = ((this.f4512m >>> ((7 - this.wordPos) << 3)) >>> 8) | ((((this.wordCount << 3) + r2) & 255) << 56);
        processMessageWord();
        this.f4515v2 ^= 255;
        applySipRounds(this.d);
        long j4 = ((this.f4513v0 ^ this.f4514v1) ^ this.f4515v2) ^ this.f4516v3;
        reset();
        return j4;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] bArr, int i8, int i9) {
        int i10 = i9 & (-8);
        int i11 = this.wordPos;
        char c3 = '8';
        long j4 = 255;
        int i12 = 0;
        if (i11 == 0) {
            while (i12 < i10) {
                this.f4512m = Pack.littleEndianToLong(bArr, i8 + i12);
                processMessageWord();
                i12 += 8;
            }
            while (i12 < i9) {
                long j8 = this.f4512m >>> 8;
                this.f4512m = j8;
                this.f4512m = j8 | ((bArr[i8 + i12] & 255) << 56);
                i12++;
            }
            this.wordPos = i9 - i10;
            return;
        }
        int i13 = i11 << 3;
        int i14 = 0;
        while (i14 < i10) {
            long jLittleEndianToLong = Pack.littleEndianToLong(bArr, i8 + i14);
            this.f4512m = (this.f4512m >>> (-i13)) | (jLittleEndianToLong << i13);
            processMessageWord();
            this.f4512m = jLittleEndianToLong;
            i14 += 8;
            c3 = c3;
            j4 = j4;
        }
        char c8 = c3;
        long j9 = j4;
        while (i14 < i9) {
            long j10 = this.f4512m >>> 8;
            this.f4512m = j10;
            this.f4512m = j10 | ((bArr[i8 + i14] & j9) << c8);
            int i15 = this.wordPos + 1;
            this.wordPos = i15;
            if (i15 == 8) {
                processMessageWord();
                this.wordPos = 0;
            }
            i14++;
        }
    }
}
