package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.digests.BufferBaseDigest;
import org.bouncycastle.crypto.digests.ISAPDigest;
import org.bouncycastle.crypto.engines.AsconPermutationFriend;

/* loaded from: classes.dex */
abstract class AsconBaseDigest extends BufferBaseDigest {
    protected int ASCON_PB_ROUNDS;

    /* renamed from: p, reason: collision with root package name */
    AsconPermutationFriend.AsconPermutation f4405p;

    public static class Friend {
        private static final Friend INSTANCE = new Friend();

        private Friend() {
        }
    }

    public AsconBaseDigest() {
        super(BufferBaseDigest.ProcessingBufferType.Immediate, 8);
        this.ASCON_PB_ROUNDS = 12;
        this.f4405p = AsconPermutationFriend.getAsconPermutation(ISAPDigest.Friend.getFriend(Friend.INSTANCE));
        this.DigestSize = 32;
    }

    public void ensureSufficientOutputBuffer(byte[] bArr, int i8, int i9) {
        if (i8 + i9 > bArr.length) {
            throw new OutputLengthException("output buffer is too short");
        }
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest
    public void finish(byte[] bArr, int i8) {
        padAndAbsorb();
        squeeze(bArr, i8, this.DigestSize);
    }

    public int hash(byte[] bArr, int i8, int i9) {
        ensureSufficientOutputBuffer(bArr, i8, i9);
        padAndAbsorb();
        squeeze(bArr, i8, i9);
        return i9;
    }

    public abstract long loadBytes(byte[] bArr, int i8);

    public abstract long loadBytes(byte[] bArr, int i8, int i9);

    public abstract long pad(int i8);

    public void padAndAbsorb() {
        this.f4405p.f4448x0 ^= loadBytes(this.m_buf, 0, this.m_bufPos) ^ pad(this.m_bufPos);
        this.f4405p.p(12);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest
    public void processBytes(byte[] bArr, int i8) {
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f4405p;
        asconPermutation.f4448x0 = loadBytes(bArr, i8) ^ asconPermutation.f4448x0;
        this.f4405p.p(this.ASCON_PB_ROUNDS);
    }

    public abstract void setBytes(long j4, byte[] bArr, int i8);

    public abstract void setBytes(long j4, byte[] bArr, int i8, int i9);

    public void squeeze(byte[] bArr, int i8, int i9) {
        int i10 = i8;
        int i11 = i9;
        while (i11 > this.BlockSize) {
            setBytes(this.f4405p.f4448x0, bArr, i10);
            this.f4405p.p(this.ASCON_PB_ROUNDS);
            int i12 = this.BlockSize;
            i10 += i12;
            i11 -= i12;
        }
        setBytes(this.f4405p.f4448x0, bArr, i10, i11);
    }
}
