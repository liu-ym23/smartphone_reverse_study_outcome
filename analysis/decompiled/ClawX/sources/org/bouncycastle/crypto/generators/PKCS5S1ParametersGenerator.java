package org.bouncycastle.crypto.generators;

import a8.b;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* loaded from: classes.dex */
public class PKCS5S1ParametersGenerator extends PBEParametersGenerator {
    private Digest digest;

    public PKCS5S1ParametersGenerator(Digest digest) {
        this.digest = digest;
    }

    private byte[] generateDerivedKey() {
        int digestSize = this.digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        Digest digest = this.digest;
        byte[] bArr2 = this.password;
        digest.update(bArr2, 0, bArr2.length);
        Digest digest2 = this.digest;
        byte[] bArr3 = this.salt;
        digest2.update(bArr3, 0, bArr3.length);
        this.digest.doFinal(bArr, 0);
        for (int i8 = 1; i8 < this.iterationCount; i8++) {
            this.digest.update(bArr, 0, digestSize);
            this.digest.doFinal(bArr, 0);
        }
        return bArr;
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int i8) {
        return generateDerivedParameters(i8);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i8) {
        int i9 = i8 / 8;
        if (i9 <= this.digest.getDigestSize()) {
            return new KeyParameter(generateDerivedKey(), 0, i9);
        }
        throw new IllegalArgumentException(b.k(i9, "Can't generate a derived key ", " bytes long."));
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i8, int i9) {
        int i10 = i8 / 8;
        int i11 = i9 / 8;
        int i12 = i10 + i11;
        if (i12 > this.digest.getDigestSize()) {
            throw new IllegalArgumentException(b.k(i12, "Can't generate a derived key ", " bytes long."));
        }
        byte[] bArrGenerateDerivedKey = generateDerivedKey();
        return new ParametersWithIV(new KeyParameter(bArrGenerateDerivedKey, 0, i10), bArrGenerateDerivedKey, i10, i11);
    }
}
