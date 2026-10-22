package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.HKDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;

/* loaded from: classes.dex */
public class HKDFBytesGenerator implements DerivationFunction {
    private byte[] currentT;
    private int generatedBytes;
    private HMac hMacHash;
    private int hashLen;
    private byte[] info;

    public HKDFBytesGenerator(Digest digest) {
        this.hMacHash = new HMac(digest);
        this.hashLen = digest.getDigestSize();
    }

    private void expandNext() {
        int i8 = this.generatedBytes;
        int i9 = this.hashLen;
        int i10 = (i8 / i9) + 1;
        if (i10 >= 256) {
            throw new DataLengthException("HKDF cannot generate more than 255 blocks of HashLen size");
        }
        if (i8 != 0) {
            this.hMacHash.update(this.currentT, 0, i9);
        }
        HMac hMac = this.hMacHash;
        byte[] bArr = this.info;
        hMac.update(bArr, 0, bArr.length);
        this.hMacHash.update((byte) i10);
        this.hMacHash.doFinal(this.currentT, 0);
    }

    public byte[] extractPRK(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            this.hMacHash.init(new KeyParameter(new byte[this.hashLen]));
        } else {
            this.hMacHash.init(new KeyParameter(bArr));
        }
        this.hMacHash.update(bArr2, 0, bArr2.length);
        byte[] bArr3 = new byte[this.hashLen];
        this.hMacHash.doFinal(bArr3, 0);
        return bArr3;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i8, int i9) {
        int i10 = this.generatedBytes;
        int i11 = i10 + i9;
        int i12 = this.hashLen;
        if (i11 > i12 * 255) {
            throw new DataLengthException("HKDF may only be used for 255 * HashLen bytes of output");
        }
        if (i10 % i12 == 0) {
            expandNext();
        }
        int i13 = this.generatedBytes;
        int i14 = this.hashLen;
        int i15 = i13 % i14;
        int iMin = Math.min(i14 - (i13 % i14), i9);
        System.arraycopy(this.currentT, i15, bArr, i8, iMin);
        this.generatedBytes += iMin;
        int i16 = i9 - iMin;
        while (true) {
            i8 += iMin;
            if (i16 <= 0) {
                return i9;
            }
            expandNext();
            iMin = Math.min(this.hashLen, i16);
            System.arraycopy(this.currentT, 0, bArr, i8, iMin);
            this.generatedBytes += iMin;
            i16 -= iMin;
        }
    }

    public Digest getDigest() {
        return this.hMacHash.getUnderlyingDigest();
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        HMac hMac;
        KeyParameter keyParameter;
        if (!(derivationParameters instanceof HKDFParameters)) {
            throw new IllegalArgumentException("HKDF parameters required for HKDFBytesGenerator");
        }
        HKDFParameters hKDFParameters = (HKDFParameters) derivationParameters;
        if (hKDFParameters.skipExtract()) {
            hMac = this.hMacHash;
            keyParameter = new KeyParameter(hKDFParameters.getIKM());
        } else {
            hMac = this.hMacHash;
            keyParameter = new KeyParameter(extractPRK(hKDFParameters.getSalt(), hKDFParameters.getIKM()));
        }
        hMac.init(keyParameter);
        this.info = hKDFParameters.getInfo();
        this.generatedBytes = 0;
        this.currentT = new byte[this.hashLen];
    }
}
