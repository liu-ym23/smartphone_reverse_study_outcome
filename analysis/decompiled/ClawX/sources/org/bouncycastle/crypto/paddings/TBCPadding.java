package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;

/* loaded from: classes.dex */
public class TBCPadding implements BlockCipherPadding {
    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i8) {
        int length = bArr.length - i8;
        int i9 = 0;
        if (i8 <= 0 ? (bArr[bArr.length - 1] & 1) == 0 : (bArr[i8 - 1] & 1) == 0) {
            i9 = 255;
        }
        byte b9 = (byte) i9;
        while (i8 < bArr.length) {
            bArr[i8] = b9;
            i8++;
        }
        return length;
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "TBC";
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int padCount(byte[] bArr) {
        int length = bArr.length - 1;
        int i8 = bArr[length] & 255;
        int i9 = -1;
        int i10 = 1;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            i9 &= (((bArr[length] & 255) ^ i8) - 1) >> 31;
            i10 -= i9;
        }
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom secureRandom) {
    }
}
