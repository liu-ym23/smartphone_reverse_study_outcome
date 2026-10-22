package com.baidu.mshield.b.f;

import kotlin.UByte;

/* loaded from: classes.dex */
public class f {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArrA = a(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < bArr.length; i6++) {
            i4 = (i4 + 1) & 255;
            byte b4 = bArrA[i4];
            i5 = ((b4 & UByte.MAX_VALUE) + i5) & 255;
            bArrA[i4] = bArrA[i5];
            bArrA[i5] = b4;
            byte b5 = (byte) (bArrA[((bArrA[i4] & UByte.MAX_VALUE) + (b4 & UByte.MAX_VALUE)) & 255] ^ bArr[i6]);
            bArr3[i6] = b5;
            bArr3[i6] = (byte) (b5 ^ 42);
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i4 = 0; i4 < 256; i4++) {
            bArr2[i4] = (byte) i4;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int length = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            int i7 = bArr[length] & UByte.MAX_VALUE;
            byte b4 = bArr2[i6];
            i5 = (i7 + (b4 & UByte.MAX_VALUE) + i5) & 255;
            bArr2[i6] = bArr2[i5];
            bArr2[i5] = b4;
            length = (length + 1) % bArr.length;
        }
        return bArr2;
    }
}
