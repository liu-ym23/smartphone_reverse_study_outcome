package org.bouncycastle.util.encoders;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes.dex */
public class UTF8 {
    private static final byte C_CR1 = 1;
    private static final byte C_CR2 = 2;
    private static final byte C_CR3 = 3;
    private static final byte C_ILL = 0;
    private static final byte C_L2A = 4;
    private static final byte C_L3A = 5;
    private static final byte C_L3B = 6;
    private static final byte C_L3C = 7;
    private static final byte C_L4A = 8;
    private static final byte C_L4B = 9;
    private static final byte C_L4C = 10;
    private static final byte S_CS1 = 0;
    private static final byte S_CS2 = 16;
    private static final byte S_CS3 = 32;
    private static final byte S_END = -1;
    private static final byte S_ERR = -2;
    private static final byte S_P3A = 48;
    private static final byte S_P3B = 64;
    private static final byte S_P4A = 80;
    private static final byte S_P4B = 96;
    private static final short[] firstUnitTable = new short[128];
    private static final byte[] transitionTable;

    static {
        byte[] bArr = new byte[112];
        transitionTable = bArr;
        byte[] bArr2 = new byte[128];
        fill(bArr2, 0, 15, (byte) 1);
        fill(bArr2, 16, 31, (byte) 2);
        fill(bArr2, 32, 63, (byte) 3);
        fill(bArr2, 64, 65, (byte) 0);
        fill(bArr2, 66, 95, (byte) 4);
        fill(bArr2, 96, 96, (byte) 5);
        fill(bArr2, 97, 108, (byte) 6);
        fill(bArr2, 109, 109, (byte) 7);
        fill(bArr2, 110, 111, (byte) 6);
        fill(bArr2, 112, 112, (byte) 8);
        fill(bArr2, 113, 115, (byte) 9);
        fill(bArr2, 116, 116, (byte) 10);
        fill(bArr2, 117, 127, (byte) 0);
        fill(bArr, 0, bArr.length - 1, S_ERR);
        fill(bArr, 8, 11, S_END);
        fill(bArr, 24, 27, (byte) 0);
        fill(bArr, 40, 43, S_CS2);
        fill(bArr, 58, 59, (byte) 0);
        fill(bArr, 72, 73, (byte) 0);
        fill(bArr, 89, 91, S_CS2);
        fill(bArr, 104, 104, S_CS2);
        byte[] bArr3 = {0, 0, 0, 0, 31, 15, 15, 15, 7, 7, 7};
        byte[] bArr4 = {S_ERR, S_ERR, S_ERR, S_ERR, 0, S_P3A, S_CS2, S_P3B, S_P4A, S_CS3, S_P4B};
        for (int i8 = 0; i8 < 128; i8++) {
            byte b9 = bArr2[i8];
            firstUnitTable[i8] = (short) (bArr4[b9] | ((bArr3[b9] & i8) << 8));
        }
    }

    private static void fill(byte[] bArr, int i8, int i9, byte b9) {
        while (i8 <= i9) {
            bArr[i8] = b9;
            i8++;
        }
    }

    public static int transcodeToUTF16(byte[] bArr, int i8, int i9, char[] cArr) {
        int i10 = i9 + i8;
        int i11 = 0;
        while (i8 < i10) {
            int i12 = i8 + 1;
            byte b9 = bArr[i8];
            if (b9 < 0) {
                short s8 = firstUnitTable[b9 & AbstractJsonLexerKt.TC_INVALID];
                int i13 = s8 >>> 8;
                byte b10 = (byte) s8;
                while (b10 >= 0) {
                    if (i12 >= i10) {
                        return -1;
                    }
                    int i14 = i12 + 1;
                    byte b11 = bArr[i12];
                    i13 = (i13 << 6) | (b11 & 63);
                    b10 = transitionTable[b10 + ((b11 & S_END) >>> 4)];
                    i12 = i14;
                }
                if (b10 == -2) {
                    return -1;
                }
                if (i13 <= 65535) {
                    if (i11 >= cArr.length) {
                        return -1;
                    }
                    cArr[i11] = (char) i13;
                    i11++;
                } else {
                    if (i11 >= cArr.length - 1) {
                        return -1;
                    }
                    int i15 = i11 + 1;
                    cArr[i11] = (char) ((i13 >>> 10) + 55232);
                    i11 += 2;
                    cArr[i15] = (char) ((i13 & 1023) | 56320);
                }
                i8 = i12;
            } else {
                if (i11 >= cArr.length) {
                    return -1;
                }
                cArr[i11] = (char) b9;
                i8 = i12;
                i11++;
            }
        }
        return i11;
    }

    public static int transcodeToUTF16(byte[] bArr, char[] cArr) {
        return transcodeToUTF16(bArr, 0, bArr.length, cArr);
    }
}
