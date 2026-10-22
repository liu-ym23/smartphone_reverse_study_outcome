package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.MGFParameters;

/* loaded from: classes.dex */
public class MGF1BytesGenerator implements DerivationFunction {
    private Digest digest;
    private int hLen;
    private byte[] seed;

    public MGF1BytesGenerator(Digest digest) {
        this.digest = digest;
        this.hLen = digest.getDigestSize();
    }

    private void ItoOSP(int i8, byte[] bArr) {
        bArr[0] = (byte) (i8 >>> 24);
        bArr[1] = (byte) (i8 >>> 16);
        bArr[2] = (byte) (i8 >>> 8);
        bArr[3] = (byte) i8;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i8, int i9) {
        int i10;
        if (bArr.length - i9 < i8) {
            throw new OutputLengthException("output buffer too small");
        }
        byte[] bArr2 = new byte[this.hLen];
        byte[] bArr3 = new byte[4];
        this.digest.reset();
        if (i9 > this.hLen) {
            i10 = 0;
            do {
                ItoOSP(i10, bArr3);
                Digest digest = this.digest;
                byte[] bArr4 = this.seed;
                digest.update(bArr4, 0, bArr4.length);
                this.digest.update(bArr3, 0, 4);
                this.digest.doFinal(bArr2, 0);
                int i11 = this.hLen;
                System.arraycopy(bArr2, 0, bArr, (i10 * i11) + i8, i11);
                i10++;
            } while (i10 < i9 / this.hLen);
        } else {
            i10 = 0;
        }
        if (this.hLen * i10 < i9) {
            ItoOSP(i10, bArr3);
            Digest digest2 = this.digest;
            byte[] bArr5 = this.seed;
            digest2.update(bArr5, 0, bArr5.length);
            this.digest.update(bArr3, 0, 4);
            this.digest.doFinal(bArr2, 0);
            int i12 = i10 * this.hLen;
            System.arraycopy(bArr2, 0, bArr, i8 + i12, i9 - i12);
        }
        return i9;
    }

    public Digest getDigest() {
        return this.digest;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        if (!(derivationParameters instanceof MGFParameters)) {
            throw new IllegalArgumentException("MGF parameters required for MGF1Generator");
        }
        this.seed = ((MGFParameters) derivationParameters).getSeed();
    }
}
