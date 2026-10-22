package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.digests.BufferBaseDigest;
import org.bouncycastle.crypto.engines.PhotonBeetleEngine;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Bytes;

/* loaded from: classes.dex */
public class PhotonBeetleDigest extends BufferBaseDigest {
    private static final int D = 8;
    private static final int SQUEEZE_RATE_INBYTES = 16;
    private int blockCount;
    private final byte[] state;

    public static class Friend {
        private static final Friend INSTANCE = new Friend();

        private Friend() {
        }
    }

    public PhotonBeetleDigest() {
        super(BufferBaseDigest.ProcessingBufferType.Buffered, 4);
        this.DigestSize = 32;
        this.state = new byte[32];
        this.algorithmName = "Photon-Beetle Hash";
        this.blockCount = 0;
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
        return super.doFinal(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest
    public void finish(byte[] bArr, int i8) {
        int i9 = this.m_bufPos;
        if (i9 == 0 && this.blockCount == 0) {
            byte[] bArr2 = this.state;
            int i10 = this.DigestSize - 1;
            bArr2[i10] = (byte) (bArr2[i10] ^ 32);
        } else {
            int i11 = this.blockCount;
            if (i11 < 4) {
                System.arraycopy(this.m_buf, 0, this.state, i11 << 2, i9);
                byte[] bArr3 = this.state;
                int i12 = (this.blockCount << 2) + this.m_bufPos;
                bArr3[i12] = (byte) (bArr3[i12] ^ 1);
                int i13 = this.DigestSize - 1;
                bArr3[i13] = (byte) (bArr3[i13] ^ 32);
            } else if (i11 == 4 && i9 == 0) {
                byte[] bArr4 = this.state;
                int i14 = this.DigestSize - 1;
                bArr4[i14] = (byte) (bArr4[i14] ^ 64);
            } else {
                PhotonBeetleEngine.photonPermutation(Friend.INSTANCE, this.state);
                Bytes.xorTo(this.m_bufPos, this.m_buf, this.state);
                int i15 = this.m_bufPos;
                int i16 = this.BlockSize;
                if (i15 < i16) {
                    byte[] bArr5 = this.state;
                    bArr5[i15] = (byte) (bArr5[i15] ^ 1);
                }
                byte[] bArr6 = this.state;
                int i17 = this.DigestSize - 1;
                bArr6[i17] = (byte) (((i15 % i16 != 0 ? 2 : 1) << 5) ^ bArr6[i17]);
            }
        }
        PhotonBeetleEngine.photonPermutation(Friend.INSTANCE, this.state);
        System.arraycopy(this.state, 0, bArr, i8, 16);
        PhotonBeetleEngine.photonPermutation(Friend.INSTANCE, this.state);
        System.arraycopy(this.state, 0, bArr, i8 + 16, 16);
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
        int i9 = this.blockCount;
        if (i9 < 4) {
            System.arraycopy(bArr, i8, this.state, i9 << 2, this.BlockSize);
        } else {
            PhotonBeetleEngine.photonPermutation(Friend.INSTANCE, this.state);
            Bytes.xorTo(this.BlockSize, bArr, i8, this.state);
        }
        this.blockCount++;
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        Arrays.fill(this.state, (byte) 0);
        this.blockCount = 0;
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
