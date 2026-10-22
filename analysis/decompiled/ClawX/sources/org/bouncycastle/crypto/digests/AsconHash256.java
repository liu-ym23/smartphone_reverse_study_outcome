package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class AsconHash256 extends AsconBaseDigest {
    public AsconHash256() {
        this.algorithmName = "Ascon-Hash256";
        reset();
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
        return super.doFinal(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.ExtendedDigest
    public /* bridge */ /* synthetic */ int getByteLength() {
        return super.getByteLength();
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ int getDigestSize() {
        return super.getDigestSize();
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public long loadBytes(byte[] bArr, int i8) {
        return Pack.littleEndianToLong(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public long pad(int i8) {
        return 1 << (i8 << 3);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.f4405p.set(-7269279749984954751L, 5459383224871899602L, -5880230600644446182L, 4359436768738168243L, 1899470422303676269L);
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public void setBytes(long j4, byte[] bArr, int i8) {
        Pack.longToLittleEndian(j4, bArr, i8);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ void update(byte b9) {
        super.update(b9);
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public long loadBytes(byte[] bArr, int i8, int i9) {
        return Pack.littleEndianToLong(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public void setBytes(long j4, byte[] bArr, int i8, int i9) {
        Pack.longToLittleEndian(j4, bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ void update(byte[] bArr, int i8, int i9) {
        super.update(bArr, i8, i9);
    }
}
