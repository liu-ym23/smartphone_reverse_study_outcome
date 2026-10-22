package org.bouncycastle.crypto.generators;

import m0.f;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.MacDerivationFunction;
import org.bouncycastle.crypto.params.KDFFeedbackParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Integers;

/* loaded from: classes.dex */
public class KDFFeedbackBytesGenerator implements MacDerivationFunction {
    private byte[] fixedInputData;
    private int generatedBytes;

    /* renamed from: h, reason: collision with root package name */
    private final int f4487h;
    private byte[] ios;
    private byte[] iv;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f4488k;
    private int maxSizeExcl;
    private final Mac prf;
    private boolean useCounter;

    public KDFFeedbackBytesGenerator(Mac mac) {
        this.prf = mac;
        int macSize = mac.getMacSize();
        this.f4487h = macSize;
        this.f4488k = new byte[macSize];
    }

    private void generateNext() {
        if (this.generatedBytes == 0) {
            Mac mac = this.prf;
            byte[] bArr = this.iv;
            mac.update(bArr, 0, bArr.length);
        } else {
            Mac mac2 = this.prf;
            byte[] bArr2 = this.f4488k;
            mac2.update(bArr2, 0, bArr2.length);
        }
        if (this.useCounter) {
            int i8 = (this.generatedBytes / this.f4487h) + 1;
            byte[] bArr3 = this.ios;
            int length = bArr3.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length != 4) {
                            throw new IllegalStateException("Unsupported size of counter i");
                        }
                        bArr3[0] = (byte) (i8 >>> 24);
                    }
                    bArr3[bArr3.length - 3] = (byte) (i8 >>> 16);
                }
                bArr3[bArr3.length - 2] = (byte) (i8 >>> 8);
            }
            bArr3[bArr3.length - 1] = (byte) i8;
            this.prf.update(bArr3, 0, bArr3.length);
        }
        Mac mac3 = this.prf;
        byte[] bArr4 = this.fixedInputData;
        mac3.update(bArr4, 0, bArr4.length);
        this.prf.doFinal(this.f4488k, 0);
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i8, int i9) {
        int i10 = this.generatedBytes;
        int i11 = i10 + i9;
        if (i11 < 0 || i11 >= this.maxSizeExcl) {
            throw new DataLengthException(f.e(new StringBuilder("Current KDFCTR may only be used for "), this.maxSizeExcl, " bytes"));
        }
        if (i10 % this.f4487h == 0) {
            generateNext();
        }
        int i12 = this.generatedBytes;
        int i13 = this.f4487h;
        int i14 = i12 % i13;
        int iMin = Math.min(i13 - (i12 % i13), i9);
        System.arraycopy(this.f4488k, i14, bArr, i8, iMin);
        this.generatedBytes += iMin;
        int i15 = i9 - iMin;
        while (true) {
            i8 += iMin;
            if (i15 <= 0) {
                return i9;
            }
            generateNext();
            iMin = Math.min(this.f4487h, i15);
            System.arraycopy(this.f4488k, 0, bArr, i8, iMin);
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
        if (!(derivationParameters instanceof KDFFeedbackParameters)) {
            throw new IllegalArgumentException("Wrong type of arguments given");
        }
        KDFFeedbackParameters kDFFeedbackParameters = (KDFFeedbackParameters) derivationParameters;
        this.prf.init(new KeyParameter(kDFFeedbackParameters.getKI()));
        this.fixedInputData = kDFFeedbackParameters.getFixedInputData();
        int r3 = kDFFeedbackParameters.getR();
        this.ios = new byte[r3 / 8];
        int i8 = Integer.MAX_VALUE;
        if (kDFFeedbackParameters.useCounter() && r3 < Integers.numberOfLeadingZeros(this.f4487h)) {
            i8 = this.f4487h << r3;
        }
        this.maxSizeExcl = i8;
        this.iv = kDFFeedbackParameters.getIV();
        this.useCounter = kDFFeedbackParameters.useCounter();
        this.generatedBytes = 0;
    }
}
