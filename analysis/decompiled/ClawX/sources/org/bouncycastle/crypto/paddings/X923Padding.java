package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* loaded from: classes.dex */
public class X923Padding implements BlockCipherPadding {
    SecureRandom random = null;

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i8) {
        byte length = (byte) (bArr.length - i8);
        while (i8 < bArr.length - 1) {
            SecureRandom secureRandom = this.random;
            if (secureRandom == null) {
                bArr[i8] = 0;
            } else {
                bArr[i8] = (byte) secureRandom.nextInt();
            }
            i8++;
        }
        bArr[i8] = length;
        return length;
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "X9.23";
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom secureRandom) {
        this.random = secureRandom;
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
