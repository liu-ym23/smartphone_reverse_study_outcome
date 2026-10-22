package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;

/* loaded from: classes.dex */
public class PKCS5S2ParametersGenerator extends PBEParametersGenerator {
    private Mac hMac;
    private byte[] state;

    public PKCS5S2ParametersGenerator() {
        this(DigestFactory.createSHA1());
    }

    private void F(byte[] bArr, int i8, byte[] bArr2, byte[] bArr3, int i9) {
        if (i8 == 0) {
            throw new IllegalArgumentException("iteration count must be at least 1.");
        }
        if (bArr != null) {
            this.hMac.update(bArr, 0, bArr.length);
        }
        this.hMac.update(bArr2, 0, bArr2.length);
        this.hMac.doFinal(this.state, 0);
        byte[] bArr4 = this.state;
        System.arraycopy(bArr4, 0, bArr3, i9, bArr4.length);
        for (int i10 = 1; i10 < i8; i10++) {
            Mac mac = this.hMac;
            byte[] bArr5 = this.state;
            mac.update(bArr5, 0, bArr5.length);
            this.hMac.doFinal(this.state, 0);
            int i11 = 0;
            while (true) {
                byte[] bArr6 = this.state;
                if (i11 != bArr6.length) {
                    int i12 = i9 + i11;
                    bArr3[i12] = (byte) (bArr6[i11] ^ bArr3[i12]);
                    i11++;
                }
            }
        }
    }

    private byte[] generateDerivedKey(int i8) {
        int i9;
        int macSize = this.hMac.getMacSize();
        int i10 = ((i8 + macSize) - 1) / macSize;
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[i10 * macSize];
        this.hMac.init(new KeyParameter(this.password));
        int i11 = 0;
        for (int i12 = 1; i12 <= i10; i12++) {
            while (true) {
                byte b9 = (byte) (bArr[i9] + 1);
                bArr[i9] = b9;
                i9 = b9 == 0 ? i9 - 1 : 3;
            }
            F(this.salt, this.iterationCount, bArr, bArr2, i11);
            i11 += macSize;
        }
        return bArr2;
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int i8) {
        return generateDerivedParameters(i8);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i8) {
        int i9 = i8 / 8;
        return new KeyParameter(generateDerivedKey(i9), 0, i9);
    }

    public PKCS5S2ParametersGenerator(Digest digest) {
        HMac hMac = new HMac(digest);
        this.hMac = hMac;
        this.state = new byte[hMac.getMacSize()];
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i8, int i9) {
        int i10 = i8 / 8;
        int i11 = i9 / 8;
        byte[] bArrGenerateDerivedKey = generateDerivedKey(i10 + i11);
        return new ParametersWithIV(new KeyParameter(bArrGenerateDerivedKey, 0, i10), bArrGenerateDerivedKey, i10, i11);
    }
}
