package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* loaded from: classes.dex */
public class PKCS7Padding implements BlockCipherPadding {
    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i8) {
        byte length = (byte) (bArr.length - i8);
        while (i8 < bArr.length) {
            bArr[i8] = length;
            i8++;
        }
        return length;
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "PKCS7";
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        byte b9 = bArr[bArr.length - 1];
        int i8 = b9 & 255;
        int length = bArr.length - i8;
        int i9 = ((i8 - 1) | length) >> 31;
        for (int i10 = 0; i10 < bArr.length; i10++) {
            i9 |= (bArr[i10] ^ b9) & (~((i10 - length) >> 31));
        }
        if (i9 == 0) {
            return i8;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom secureRandom) {
    }
}
