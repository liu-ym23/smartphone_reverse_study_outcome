package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.engines.AEADBaseEngine;
import org.bouncycastle.crypto.engines.AsconPermutationFriend;

/* loaded from: classes.dex */
abstract class AsconBaseEngine extends AEADBaseEngine {
    protected long ASCON_IV;
    protected long K0;
    protected long K1;
    protected long N0;
    protected long N1;
    protected long dsep;
    protected int nr;

    /* renamed from: p, reason: collision with root package name */
    AsconPermutationFriend.AsconPermutation f4447p = new AsconPermutationFriend.AsconPermutation();

    public abstract void ascon_aeadinit();

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.State state, boolean z) {
        int i8 = this.m_state.ord;
        if (i8 == 2 || i8 == 6) {
            processFinalAAD();
            this.f4447p.p(this.nr);
        }
        this.f4447p.f4452x4 ^= this.dsep;
        this.m_aadPos = 0;
        this.m_state = state;
    }

    public abstract String getAlgorithmVersion();

    public abstract long loadBytes(byte[] bArr, int i8);

    public abstract long pad(int i8);

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferAAD(byte[] bArr, int i8) {
        this.f4447p.f4448x0 ^= loadBytes(bArr, i8);
        if (this.BlockSize == 16) {
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f4447p;
            asconPermutation.f4449x1 = loadBytes(bArr, i8 + 8) ^ asconPermutation.f4449x1;
        }
        this.f4447p.p(this.nr);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        long jLoadBytes = loadBytes(bArr, i8);
        setBytes(this.f4447p.f4448x0 ^ jLoadBytes, bArr2, i9);
        this.f4447p.f4448x0 = jLoadBytes;
        if (this.BlockSize == 16) {
            long jLoadBytes2 = loadBytes(bArr, i8 + 8);
            setBytes(this.f4447p.f4449x1 ^ jLoadBytes2, bArr2, i9 + 8);
            this.f4447p.f4449x1 = jLoadBytes2;
        }
        this.f4447p.p(this.nr);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        this.f4447p.f4448x0 ^= loadBytes(bArr, i8);
        setBytes(this.f4447p.f4448x0, bArr2, i9);
        if (this.BlockSize == 16) {
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f4447p;
            asconPermutation.f4449x1 = loadBytes(bArr, i8 + 8) ^ asconPermutation.f4449x1;
            setBytes(this.f4447p.f4449x1, bArr2, i9 + 8);
        }
        this.f4447p.p(this.nr);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i8) {
        if (this.forEncryption) {
            processFinalEncrypt(this.m_buf, this.m_bufPos, bArr, i8);
        } else {
            processFinalDecrypt(this.m_buf, this.m_bufPos, bArr, i8);
        }
        setBytes(this.f4447p.f4451x3, this.mac, 0);
        setBytes(this.f4447p.f4452x4, this.mac, 8);
    }

    public abstract void processFinalDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9);

    public abstract void processFinalEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9);

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void reset(boolean z) {
        super.reset(z);
        ascon_aeadinit();
    }

    public abstract void setBytes(long j4, byte[] bArr, int i8);
}
