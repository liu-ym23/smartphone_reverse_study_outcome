package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KDFParameters;

/* loaded from: classes.dex */
public class ConcatenationKDFGenerator implements DerivationFunction {
    private Digest digest;
    private int hLen;
    private byte[] otherInfo;
    private byte[] shared;

    public ConcatenationKDFGenerator(Digest digest) {
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
        int i11;
        if (i9 <= 0) {
            throw new IllegalArgumentException("len must be > 0");
        }
        if (bArr.length - i9 < i8) {
            throw new OutputLengthException("output buffer too small");
        }
        byte[] bArr2 = new byte[this.hLen];
        byte[] bArr3 = new byte[4];
        this.digest.reset();
        int i12 = 1;
        if (i9 > this.hLen) {
            i10 = 0;
            while (true) {
                ItoOSP(i12, bArr3);
                this.digest.update(bArr3, 0, 4);
                Digest digest = this.digest;
                byte[] bArr4 = this.shared;
                digest.update(bArr4, 0, bArr4.length);
                Digest digest2 = this.digest;
                byte[] bArr5 = this.otherInfo;
                digest2.update(bArr5, 0, bArr5.length);
                this.digest.doFinal(bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i8 + i10, this.hLen);
                int i13 = this.hLen;
                i10 += i13;
                i11 = i12 + 1;
                if (i12 >= i9 / i13) {
                    break;
                }
                i12 = i11;
            }
            i12 = i11;
        } else {
            i10 = 0;
        }
        if (i10 < i9) {
            ItoOSP(i12, bArr3);
            this.digest.update(bArr3, 0, 4);
            Digest digest3 = this.digest;
            byte[] bArr6 = this.shared;
            digest3.update(bArr6, 0, bArr6.length);
            Digest digest4 = this.digest;
            byte[] bArr7 = this.otherInfo;
            digest4.update(bArr7, 0, bArr7.length);
            this.digest.doFinal(bArr2, 0);
            System.arraycopy(bArr2, 0, bArr, i8 + i10, i9 - i10);
        }
        return i9;
    }

    public Digest getDigest() {
        return this.digest;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        if (!(derivationParameters instanceof KDFParameters)) {
            throw new IllegalArgumentException("KDF parameters required for generator");
        }
        KDFParameters kDFParameters = (KDFParameters) derivationParameters;
        this.shared = kDFParameters.getSharedSecret();
        this.otherInfo = kDFParameters.getIV();
    }
}
