package org.bouncycastle.crypto.generators;

import m0.f;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.MacDerivationFunction;
import org.bouncycastle.crypto.params.KDFCounterParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Integers;

/* loaded from: classes.dex */
public class KDFCounterBytesGenerator implements MacDerivationFunction {
    private byte[] fixedInputDataCtrPrefix;
    private byte[] fixedInputData_afterCtr;
    private int generatedBytes;

    /* renamed from: h, reason: collision with root package name */
    private final int f4482h;
    private byte[] ios;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f4483k;
    private int maxSizeExcl;
    private final Mac prf;

    public KDFCounterBytesGenerator(Mac mac) {
        this.prf = mac;
        int macSize = mac.getMacSize();
        this.f4482h = macSize;
        this.f4483k = new byte[macSize];
    }

    private void generateNext() {
        int i8 = (this.generatedBytes / this.f4482h) + 1;
        byte[] bArr = this.ios;
        int length = bArr.length;
        if (length != 1) {
            if (length != 2) {
                if (length != 3) {
                    if (length != 4) {
                        throw new IllegalStateException("Unsupported size of counter i");
                    }
                    bArr[0] = (byte) (i8 >>> 24);
                }
                bArr[bArr.length - 3] = (byte) (i8 >>> 16);
            }
            bArr[bArr.length - 2] = (byte) (i8 >>> 8);
        }
        bArr[bArr.length - 1] = (byte) i8;
        Mac mac = this.prf;
        byte[] bArr2 = this.fixedInputDataCtrPrefix;
        mac.update(bArr2, 0, bArr2.length);
        Mac mac2 = this.prf;
        byte[] bArr3 = this.ios;
        mac2.update(bArr3, 0, bArr3.length);
        Mac mac3 = this.prf;
        byte[] bArr4 = this.fixedInputData_afterCtr;
        mac3.update(bArr4, 0, bArr4.length);
        this.prf.doFinal(this.f4483k, 0);
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i8, int i9) {
        int i10 = this.generatedBytes;
        int i11 = i10 + i9;
        if (i11 < 0 || i11 >= this.maxSizeExcl) {
            throw new DataLengthException(f.e(new StringBuilder("Current KDFCTR may only be used for "), this.maxSizeExcl, " bytes"));
        }
        if (i10 % this.f4482h == 0) {
            generateNext();
        }
        int i12 = this.generatedBytes;
        int i13 = this.f4482h;
        int i14 = i12 % i13;
        int iMin = Math.min(i13 - (i12 % i13), i9);
        System.arraycopy(this.f4483k, i14, bArr, i8, iMin);
        this.generatedBytes += iMin;
        int i15 = i9 - iMin;
        while (true) {
            i8 += iMin;
            if (i15 <= 0) {
                return i9;
            }
            generateNext();
            iMin = Math.min(this.f4482h, i15);
            System.arraycopy(this.f4483k, 0, bArr, i8, iMin);
            this.generatedBytes += iMin;
            i15 -= iMin;
        }
    }

    @Override // org.bouncycastle.crypto.MacDerivationFunction
    public Mac getMac() {
        return this.prf;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        if (!(derivationParameters instanceof KDFCounterParameters)) {
            throw new IllegalArgumentException("Wrong type of arguments given");
        }
        KDFCounterParameters kDFCounterParameters = (KDFCounterParameters) derivationParameters;
        this.prf.init(new KeyParameter(kDFCounterParameters.getKI()));
        this.fixedInputDataCtrPrefix = kDFCounterParameters.getFixedInputDataCounterPrefix();
        this.fixedInputData_afterCtr = kDFCounterParameters.getFixedInputDataCounterSuffix();
        int r3 = kDFCounterParameters.getR();
        this.ios = new byte[r3 / 8];
        this.maxSizeExcl = r3 >= Integers.numberOfLeadingZeros(this.f4482h) ? Integer.MAX_VALUE : this.f4482h << r3;
        this.generatedBytes = 0;
    }
}
