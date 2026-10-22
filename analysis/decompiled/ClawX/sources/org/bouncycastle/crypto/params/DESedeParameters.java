package org.bouncycastle.crypto.params;

/* loaded from: classes.dex */
public class DESedeParameters extends DESParameters {
    public static final int DES_EDE_KEY_LENGTH = 24;

    public DESedeParameters(byte[] bArr) {
        super(bArr);
        if (isWeakKey(bArr, 0, bArr.length)) {
            throw new IllegalArgumentException("attempt to create weak DESede key");
        }
    }

    public static boolean isReal2Key(byte[] bArr, int i8) {
        boolean z = false;
        for (int i9 = i8; i9 != i8 + 8; i9++) {
            if (bArr[i9] != bArr[i9 + 8]) {
                z = true;
            }
        }
        return z;
    }

    public static boolean isReal3Key(byte[] bArr, int i8) {
        int i9 = i8;
        boolean z = false;
        boolean z2 = false;
        boolean z8 = false;
        while (true) {
            boolean z9 = true;
            if (i9 == i8 + 8) {
                break;
            }
            byte b9 = bArr[i9];
            byte b10 = bArr[i9 + 8];
            z |= b9 != b10;
            byte b11 = bArr[i9 + 16];
            z2 |= b9 != b11;
            if (b10 == b11) {
                z9 = false;
            }
            z8 |= z9;
            i9++;
        }
        return z && z2 && z8;
    }

    public static boolean isRealEDEKey(byte[] bArr, int i8) {
        return bArr.length == 16 ? isReal2Key(bArr, i8) : isReal3Key(bArr, i8);
    }

    public static boolean isWeakKey(byte[] bArr, int i8) {
        return isWeakKey(bArr, i8, bArr.length - i8);
    }

    public static boolean isWeakKey(byte[] bArr, int i8, int i9) {
        while (i8 < i9) {
            if (DESParameters.isWeakKey(bArr, i8)) {
                return true;
            }
            i8 += 8;
        }
        return false;
    }
}
