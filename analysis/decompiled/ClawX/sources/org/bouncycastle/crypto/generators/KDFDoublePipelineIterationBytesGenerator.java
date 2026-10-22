package org.bouncycastle.crypto.generators;

import m0.f;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.MacDerivationFunction;
import org.bouncycastle.crypto.params.KDFDoublePipelineIterationParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Integers;

/* loaded from: classes.dex */
public class KDFDoublePipelineIterationBytesGenerator implements MacDerivationFunction {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f4484a;
    private byte[] fixedInputData;
    private int generatedBytes;

    /* renamed from: h, reason: collision with root package name */
    private final int f4485h;
    private byte[] ios;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f4486k;
    private int maxSizeExcl;
    private final Mac prf;
    private boolean useCounter;

    public KDFDoublePipelineIterationBytesGenerator(Mac mac) {
        this.prf = mac;
        int macSize = mac.getMacSize();
        this.f4485h = macSize;
        this.f4484a = new byte[macSize];
        this.f4486k = new byte[macSize];
    }

    private void generateNext() {
        if (this.generatedBytes == 0) {
            Mac mac = this.prf;
            byte[] bArr = this.fixedInputData;
            mac.update(bArr, 0, bArr.length);
            this.prf.doFinal(this.f4484a, 0);
        } else {
            Mac mac2 = this.prf;
            byte[] bArr2 = this.f4484a;
            mac2.update(bArr2, 0, bArr2.length);
            this.prf.doFinal(this.f4484a, 0);
        }
        Mac mac3 = this.prf;
        byte[] bArr3 = this.f4484a;
        mac3.update(bArr3, 0, bArr3.length);
        if (this.useCounter) {
            int i8 = (this.generatedBytes / this.f4485h) + 1;
            byte[] bArr4 = this.ios;
            int length = bArr4.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length != 4) {
                            throw new IllegalStateException("Unsupported size of counter i");
                        }
                        bArr4[0] = (byte) (i8 >>> 24);
                    }
                    bArr4[bArr4.length - 3] = (byte) (i8 >>> 16);
                }
                bArr4[bArr4.length - 2] = (byte) (i8 >>> 8);
            }
            bArr4[bArr4.length - 1] = (byte) i8;
            this.prf.update(bArr4, 0, bArr4.length);
        }
        Mac mac4 = this.prf;
        byte[] bArr5 = this.fixedInputData;
        mac4.update(bArr5, 0, bArr5.length);
        this.prf.doFinal(this.f4486k, 0);
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i8, int i9) {
        int i10 = this.generatedBytes;
        int i11 = i10 + i9;
        if (i11 < 0 || i11 >= this.maxSizeExcl) {
            throw new DataLengthException(f.e(new StringBuilder("Current KDFCTR may only be used for "), this.maxSizeExcl, " bytes"));
        }
        if (i10 % this.f4485h == 0) {
            generateNext();
        }
        int i12 = this.generatedBytes;
        int i13 = this.f4485h;
        int i14 = i12 % i13;
        int iMin = Math.min(i13 - (i12 % i13), i9);
        System.arraycopy(this.f4486k, i14, bArr, i8, iMin);
        this.generatedBytes += iMin;
        int i15 = i9 - iMin;
        while (true) {
            i8 += iMin;
            if (i15 <= 0) {
                return i9;
            }
            generateNext();
            iMin = Math.min(this.f4485h, i15);
            System.arraycopy(this.f4486k, 0, bArr, i8, iMin);
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
        if (!(derivationParameters instanceof KDFDoublePipelineIterationParameters)) {
            throw new IllegalArgumentException("Wrong type of arguments given");
        }
        KDFDoublePipelineIterationParameters kDFDoublePipelineIterationParameters = (KDFDoublePipelineIterationParameters) derivationParameters;
        this.prf.init(new KeyParameter(kDFDoublePipelineIterationParameters.getKI()));
        this.fixedInputData = kDFDoublePipelineIterationParameters.getFixedInputData();
        int r3 = kDFDoublePipelineIterationParameters.getR();
        this.ios = new byte[r3 / 8];
        int i8 = Integer.MAX_VALUE;
        if (kDFDoublePipelineIterationParameters.useCounter() && r3 < Integers.numberOfLeadingZeros(this.f4485h)) {
            i8 = this.f4485h << r3;
        }
        this.maxSizeExcl = i8;
        this.useCounter = kDFDoublePipelineIterationParameters.useCounter();
        this.generatedBytes = 0;
    }
}
