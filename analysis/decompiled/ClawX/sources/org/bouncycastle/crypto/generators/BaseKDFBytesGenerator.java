package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.DigestDerivationFunction;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ISO18033KDFParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class BaseKDFBytesGenerator implements DigestDerivationFunction {
    private int counterStart;
    private Digest digest;
    private byte[] iv;
    private byte[] shared;

    public BaseKDFBytesGenerator(int i8, Digest digest) {
        this.counterStart = i8;
        this.digest = digest;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i8, int i9) {
        int i10 = i9;
        int i11 = i8;
        if (bArr.length - i10 < i11) {
            throw new OutputLengthException("output buffer too small");
        }
        long j4 = i10;
        int digestSize = this.digest.getDigestSize();
        if (j4 > 8589934591L) {
            throw new IllegalArgumentException("Output length too large");
        }
        long j8 = digestSize;
        int i12 = (int) (((j4 + j8) - 1) / j8);
        byte[] bArr2 = new byte[this.digest.getDigestSize()];
        byte[] bArr3 = new byte[4];
        Pack.intToBigEndian(this.counterStart, bArr3, 0);
        int i13 = this.counterStart & (-256);
        for (int i14 = 0; i14 < i12; i14++) {
            Digest digest = this.digest;
            byte[] bArr4 = this.shared;
            digest.update(bArr4, 0, bArr4.length);
            this.digest.update(bArr3, 0, 4);
            byte[] bArr5 = this.iv;
            if (bArr5 != null) {
                this.digest.update(bArr5, 0, bArr5.length);
            }
            this.digest.doFinal(bArr2, 0);
            if (i10 > digestSize) {
                System.arraycopy(bArr2, 0, bArr, i11, digestSize);
                i11 += digestSize;
                i10 -= digestSize;
            } else {
                System.arraycopy(bArr2, 0, bArr, i11, i10);
            }
            byte b9 = (byte) (bArr3[3] + 1);
            bArr3[3] = b9;
            if (b9 == 0) {
                i13 += 256;
                Pack.intToBigEndian(i13, bArr3, 0);
            }
        }
        this.digest.reset();
        return (int) j4;
    }

    @Override // org.bouncycastle.crypto.DigestDerivationFunction
    public Digest getDigest() {
        return this.digest;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.shared = kDFParameters.getSharedSecret();
            this.iv = kDFParameters.getIV();
        } else {
            if (!(derivationParameters instanceof ISO18033KDFParameters)) {
                throw new IllegalArgumentException("KDF parameters required for generator");
            }
            this.shared = ((ISO18033KDFParameters) derivationParameters).getSeed();
            this.iv = null;
        }
    }
}
