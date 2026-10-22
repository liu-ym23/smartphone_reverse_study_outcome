package org.bouncycastle.crypto.macs;

import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class SipHash128 extends SipHash {
    public SipHash128() {
    }

    @Override // org.bouncycastle.crypto.macs.SipHash, org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i8) {
        this.f4512m = ((this.f4512m >>> ((7 - this.wordPos) << 3)) >>> 8) | ((((this.wordCount << 3) + r2) & 255) << 56);
        processMessageWord();
        this.f4515v2 ^= 238;
        applySipRounds(this.d);
        long j4 = this.f4513v0;
        long j8 = this.f4514v1;
        long j9 = ((j4 ^ j8) ^ this.f4515v2) ^ this.f4516v3;
        this.f4514v1 = j8 ^ 221;
        applySipRounds(this.d);
        long j10 = ((this.f4513v0 ^ this.f4514v1) ^ this.f4515v2) ^ this.f4516v3;
        reset();
        Pack.longToLittleEndian(j9, bArr, i8);
        Pack.longToLittleEndian(j10, bArr, i8 + 8);
        return 16;
    }

    @Override // org.bouncycastle.crypto.macs.SipHash, org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "SipHash128-" + this.f4510c + "-" + this.d;
    }

    @Override // org.bouncycastle.crypto.macs.SipHash, org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.macs.SipHash, org.bouncycastle.crypto.Mac
    public void reset() {
        super.reset();
        this.f4514v1 ^= 238;
    }

    public SipHash128(int i8, int i9) {
        super(i8, i9);
    }

    @Override // org.bouncycastle.crypto.macs.SipHash
    public long doFinal() {
        throw new UnsupportedOperationException("doFinal() is not supported");
    }
}
