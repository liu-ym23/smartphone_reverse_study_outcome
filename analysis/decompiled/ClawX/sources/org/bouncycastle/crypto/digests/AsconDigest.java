package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class AsconDigest extends AsconBaseDigest {
    AsconParameters asconParameters;

    public enum AsconParameters {
        AsconHash,
        AsconHashA
    }

    public AsconDigest(AsconParameters asconParameters) {
        String str;
        this.asconParameters = asconParameters;
        int iOrdinal = asconParameters.ordinal();
        if (iOrdinal == 0) {
            this.ASCON_PB_ROUNDS = 12;
            str = "Ascon-Hash";
        } else {
            if (iOrdinal != 1) {
                throw new IllegalArgumentException("Invalid parameter settings for Ascon Hash");
            }
            this.ASCON_PB_ROUNDS = 8;
            str = "Ascon-HashA";
        }
        this.algorithmName = str;
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
        return Pack.bigEndianToLong(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public long pad(int i8) {
        return 128 << (56 - (i8 << 3));
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        int iOrdinal = this.asconParameters.ordinal();
        if (iOrdinal == 0) {
            this.f4405p.set(-1255492011513352131L, -8380609354527731710L, -5437372128236807582L, 4834782570098516968L, 3787428097924915520L);
        } else {
            if (iOrdinal != 1) {
                return;
            }
            this.f4405p.set(92044056785660070L, 8326807761760157607L, 3371194088139667532L, -2956994353054992515L, -6828509670848688761L);
        }
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public void setBytes(long j4, byte[] bArr, int i8) {
        Pack.longToBigEndian(j4, bArr, i8);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ void update(byte b9) {
        super.update(b9);
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public long loadBytes(byte[] bArr, int i8, int i9) {
        return Pack.bigEndianToLong(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public void setBytes(long j4, byte[] bArr, int i8, int i9) {
        Pack.longToBigEndian(j4, bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ void update(byte[] bArr, int i8, int i9) {
        super.update(bArr, i8, i9);
    }
}
