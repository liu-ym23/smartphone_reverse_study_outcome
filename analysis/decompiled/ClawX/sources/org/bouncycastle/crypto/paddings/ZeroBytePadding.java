package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;

/* loaded from: classes.dex */
public class ZeroBytePadding implements BlockCipherPadding {
    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i8) {
        int length = bArr.length - i8;
        while (i8 < bArr.length) {
            bArr[i8] = 0;
            i8++;
        }
        return length;
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "ZeroByte";
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int padCount(byte[] bArr) {
        int length = bArr.length;
        int i8 = 0;
        int i9 = -1;
        while (true) {
            length--;
            if (length < 0) {
                return i8;
            }
            i9 &= ((bArr[length] & 255) - 1) >> 31;
            i8 -= i9;
        }
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom secureRandom) {
    }
}
