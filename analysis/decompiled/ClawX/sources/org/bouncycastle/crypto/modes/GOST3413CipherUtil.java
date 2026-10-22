package org.bouncycastle.crypto.modes;

import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
class GOST3413CipherUtil {
    public static byte[] LSB(byte[] bArr, int i8) {
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, bArr.length - i8, bArr2, 0, i8);
        return bArr2;
    }

    public static byte[] MSB(byte[] bArr, int i8) {
        return Arrays.copyOf(bArr, i8);
    }

    public static byte[] copyFromInput(byte[] bArr, int i8, int i9) {
        if (bArr.length < i8 + i9) {
            i8 = bArr.length - i9;
        }
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, i9, bArr2, 0, i8);
        return bArr2;
    }

    public static byte[] sum(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i8 = 0; i8 < bArr.length; i8++) {
            bArr3[i8] = (byte) (bArr[i8] ^ bArr2[i8]);
        }
        return bArr3;
    }
}
