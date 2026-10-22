package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* loaded from: classes.dex */
public class ISO7816d4Padding implements BlockCipherPadding {
    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i8) {
        int length = bArr.length - i8;
        bArr[i8] = -128;
        while (true) {
            i8++;
            if (i8 >= bArr.length) {
                return length;
            }
            bArr[i8] = 0;
        }
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "ISO7816-4";
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        int length = bArr.length;
        int i8 = -1;
        int i9 = -1;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            i8 ^= ((((r3 ^ 128) - 1) >> 31) & i9) & (length ^ i8);
            i9 &= ((bArr[length] & 255) - 1) >> 31;
        }
        if (i8 >= 0) {
            return bArr.length - i8;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom secureRandom) {
    }
}
