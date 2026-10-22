package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.Xof;

/* loaded from: classes.dex */
abstract class AsconXofBase extends AsconBaseDigest implements Xof {
    private final byte[] buffer = new byte[this.BlockSize];
    private int bytesInBuffer;
    private boolean m_squeezing;

    private void ensureNoAbsorbWhileSqueezing(boolean z) {
        if (z) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public int doFinal(byte[] bArr, int i8, int i9) {
        int iDoOutput = doOutput(bArr, i8, i9);
        reset();
        return iDoOutput;
    }

    public int doOutput(byte[] bArr, int i8, int i9) {
        int iHash;
        ensureSufficientOutputBuffer(bArr, i8, i9);
        int i10 = this.bytesInBuffer;
        if (i10 != 0) {
            int i11 = this.BlockSize - i10;
            iHash = Math.min(i9, i10);
            System.arraycopy(this.buffer, i11, bArr, i8, iHash);
            this.bytesInBuffer -= iHash;
        } else {
            iHash = 0;
        }
        int i12 = i9 - iHash;
        int i13 = this.BlockSize;
        if (i12 >= i13) {
            iHash += hash(bArr, i8 + iHash, i12 - (i12 % i13));
        }
        if (iHash >= i9) {
            return iHash;
        }
        hash(this.buffer, 0, this.BlockSize);
        int i14 = i9 - iHash;
        System.arraycopy(this.buffer, 0, bArr, i8 + iHash, i14);
        this.bytesInBuffer = this.buffer.length - i14;
        return iHash + i14;
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    public void padAndAbsorb() {
        if (this.m_squeezing) {
            this.f4405p.p(this.ASCON_PB_ROUNDS);
        } else {
            this.m_squeezing = true;
            super.padAndAbsorb();
        }
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        this.m_squeezing = false;
        this.bytesInBuffer = 0;
        super.reset();
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public void update(byte b9) {
        ensureNoAbsorbWhileSqueezing(this.m_squeezing);
        super.update(b9);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i8, int i9) {
        ensureNoAbsorbWhileSqueezing(this.m_squeezing);
        super.update(bArr, i8, i9);
    }
}
