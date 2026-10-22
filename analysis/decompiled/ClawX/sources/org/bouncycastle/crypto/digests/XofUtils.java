package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class XofUtils {
    public static byte[] encode(byte b9) {
        return Arrays.concatenate(leftEncode(8L), new byte[]{b9});
    }

    public static byte[] leftEncode(long j4) {
        long j8 = j4;
        byte b9 = 1;
        while (true) {
            j8 >>= 8;
            if (j8 == 0) {
                break;
            }
            b9 = (byte) (b9 + 1);
        }
        byte[] bArr = new byte[b9 + 1];
        bArr[0] = b9;
        for (int i8 = 1; i8 <= b9; i8++) {
            bArr[i8] = (byte) (j4 >> ((b9 - i8) * 8));
        }
        return bArr;
    }

    public static byte[] rightEncode(long j4) {
        long j8 = j4;
        byte b9 = 1;
        while (true) {
            j8 >>= 8;
            if (j8 == 0) {
                break;
            }
            b9 = (byte) (b9 + 1);
        }
        byte[] bArr = new byte[b9 + 1];
        bArr[b9] = b9;
        for (int i8 = 0; i8 < b9; i8++) {
            bArr[i8] = (byte) (j4 >> (((b9 - i8) - 1) * 8));
        }
        return bArr;
    }

    public static byte[] encode(byte[] bArr, int i8, int i9) {
        return bArr.length == i9 ? Arrays.concatenate(leftEncode(i9 * 8), bArr) : Arrays.concatenate(leftEncode(i9 * 8), Arrays.copyOfRange(bArr, i8, i9 + i8));
    }
}
