package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.engines.AsconPermutationFriend;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class AsconCXof128 extends AsconXofBase {

    /* renamed from: z0, reason: collision with root package name */
    private final long f4406z0;

    /* renamed from: z1, reason: collision with root package name */
    private final long f4407z1;
    private final long z2;

    /* renamed from: z3, reason: collision with root package name */
    private final long f4408z3;

    /* renamed from: z4, reason: collision with root package name */
    private final long f4409z4;

    public AsconCXof128() {
        this(new byte[0], 0, 0);
    }

    private void initState(byte[] bArr, int i8, int i9) {
        if (i9 == 0) {
            this.f4405p.set(5768210384618244584L, 6623958265790276749L, 4252419465292010770L, 1238191464582506891L, 56353695744608240L);
        } else {
            this.f4405p.set(7445901275803737603L, 4886737088792722364L, -1616759365661982283L, 3076320316797452470L, -8124743304765850554L);
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f4405p;
            asconPermutation.f4448x0 ^= i9 << 3;
            asconPermutation.p(12);
            update(bArr, i8, i9);
            padAndAbsorb();
        }
        super.reset();
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
        return super.doFinal(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.digests.AsconXofBase, org.bouncycastle.crypto.Xof
    public /* bridge */ /* synthetic */ int doOutput(byte[] bArr, int i8, int i9) {
        return super.doOutput(bArr, i8, i9);
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

    @Override // org.bouncycastle.crypto.digests.AsconXofBase, org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.f4405p.set(this.f4406z0, this.f4407z1, this.z2, this.f4408z3, this.f4409z4);
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public void setBytes(long j4, byte[] bArr, int i8) {
        Pack.longToLittleEndian(j4, bArr, i8);
    }

    @Override // org.bouncycastle.crypto.digests.AsconXofBase, org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ void update(byte b9) {
        super.update(b9);
    }

    public AsconCXof128(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.crypto.digests.AsconXofBase, org.bouncycastle.crypto.Xof
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8, int i9) {
        return super.doFinal(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public long loadBytes(byte[] bArr, int i8, int i9) {
        return Pack.littleEndianToLong(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public void setBytes(long j4, byte[] bArr, int i8, int i9) {
        Pack.longToLittleEndian(j4, bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.digests.AsconXofBase, org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ void update(byte[] bArr, int i8, int i9) {
        super.update(bArr, i8, i9);
    }

    public AsconCXof128(byte[] bArr, int i8, int i9) {
        this.algorithmName = "Ascon-CXOF128";
        ensureSufficientInputBuffer(bArr, i8, i9);
        if (i9 > 256) {
            throw new DataLengthException("customized string is too long");
        }
        initState(bArr, i8, i9);
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f4405p;
        this.f4406z0 = asconPermutation.f4448x0;
        this.f4407z1 = asconPermutation.f4449x1;
        this.z2 = asconPermutation.f4450x2;
        this.f4408z3 = asconPermutation.f4451x3;
        this.f4409z4 = asconPermutation.f4452x4;
    }
}
