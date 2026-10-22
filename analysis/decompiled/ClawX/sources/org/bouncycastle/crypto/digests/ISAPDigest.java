package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.digests.AsconBaseDigest;
import org.bouncycastle.crypto.digests.BufferBaseDigest;
import org.bouncycastle.crypto.engines.AsconPermutationFriend;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class ISAPDigest extends BufferBaseDigest {

    /* renamed from: p, reason: collision with root package name */
    private final AsconPermutationFriend.AsconPermutation f4422p;

    public static class Friend {
        private static final Friend INSTANCE = new Friend();

        private Friend() {
        }

        public static Friend getFriend(AsconBaseDigest.Friend friend) {
            if (friend != null) {
                return INSTANCE;
            }
            throw new NullPointerException("This method is only for use by AsconBaseDigest");
        }
    }

    public ISAPDigest() {
        super(BufferBaseDigest.ProcessingBufferType.Immediate, 8);
        this.f4422p = AsconPermutationFriend.getAsconPermutation(Friend.INSTANCE);
        this.DigestSize = 32;
        this.algorithmName = "ISAP Hash";
        reset();
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
        return super.doFinal(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest
    public void finish(byte[] bArr, int i8) {
        this.f4422p.f4448x0 ^= 128 << ((7 - this.m_bufPos) << 3);
        while (true) {
            int i9 = this.m_bufPos;
            if (i9 <= 0) {
                break;
            }
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f4422p;
            long j4 = asconPermutation.f4448x0;
            byte[] bArr2 = this.m_buf;
            int i10 = i9 - 1;
            this.m_bufPos = i10;
            asconPermutation.f4448x0 = j4 ^ ((bArr2[i10] & 255) << ((7 - i10) << 3));
        }
        for (int i11 = 0; i11 < 4; i11++) {
            this.f4422p.p(12);
            Pack.longToBigEndian(this.f4422p.f4448x0, bArr, i8);
            i8 += 8;
        }
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

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest
    public void processBytes(byte[] bArr, int i8) {
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f4422p;
        asconPermutation.f4448x0 = Pack.bigEndianToLong(bArr, i8) ^ asconPermutation.f4448x0;
        this.f4422p.p(12);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.f4422p.set(-1255492011513352131L, -8380609354527731710L, -5437372128236807582L, 4834782570098516968L, 3787428097924915520L);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ void update(byte b9) {
        super.update(b9);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ void update(byte[] bArr, int i8, int i9) {
        super.update(bArr, i8, i9);
    }
}
