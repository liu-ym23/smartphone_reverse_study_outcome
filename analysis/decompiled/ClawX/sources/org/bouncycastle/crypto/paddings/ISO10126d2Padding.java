package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* loaded from: classes.dex */
public class ISO10126d2Padding implements BlockCipherPadding {
    SecureRandom random;

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i8) {
        byte length = (byte) (bArr.length - i8);
        while (i8 < bArr.length - 1) {
            bArr[i8] = (byte) this.random.nextInt();
            i8++;
        }
        bArr[i8] = length;
        return length;
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "ISO10126-2";
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom secureRandom) {
        this.random = CryptoServicesRegistrar.getSecureRandom(secureRandom);
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        int i8 = bArr[bArr.length - 1] & 255;
        if ((((bArr.length - i8) | (i8 - 1)) >> 31) == 0) {
            return i8;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
