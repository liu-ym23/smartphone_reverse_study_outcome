package com.baidu.b.f;

import java.io.ByteArrayOutputStream;
import kotlin.UByte;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f4882a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4883b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4884c;

    public a(String str, boolean z4, boolean z5) {
        this.f4882a = str;
        this.f4883b = z4;
        this.f4884c = z5;
    }

    private static int a(int i4) {
        if (i4 == 1) {
            return 6;
        }
        if (i4 == 2) {
            return 4;
        }
        if (i4 == 3) {
            return 3;
        }
        if (i4 != 4) {
            return i4 != 5 ? -1 : 0;
        }
        return 1;
    }

    public String a(byte[] bArr) {
        int i4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i5 = 0; i5 < (bArr.length + 4) / 5; i5++) {
            short[] sArr = new short[5];
            int[] iArr = new int[8];
            int i6 = 5;
            for (int i7 = 0; i7 < 5; i7++) {
                int i8 = (i5 * 5) + i7;
                if (i8 < bArr.length) {
                    sArr[i7] = (short) (bArr[i8] & UByte.MAX_VALUE);
                } else {
                    sArr[i7] = 0;
                    i6--;
                }
            }
            int iA = a(i6);
            short s4 = sArr[0];
            iArr[0] = (byte) ((s4 >> 3) & 31);
            short s5 = sArr[1];
            iArr[1] = (byte) (((s4 & 7) << 2) | ((s5 >> 6) & 3));
            iArr[2] = (byte) ((s5 >> 1) & 31);
            short s6 = sArr[2];
            iArr[3] = (byte) (((s5 & 1) << 4) | ((s6 >> 4) & 15));
            int i9 = (s6 & 15) << 1;
            short s7 = sArr[3];
            iArr[4] = (byte) (i9 | (1 & (s7 >> 7)));
            iArr[5] = (byte) ((s7 >> 2) & 31);
            short s8 = sArr[4];
            iArr[6] = (byte) (((s8 >> 5) & 7) | ((s7 & 3) << 3));
            iArr[7] = (byte) (s8 & 31);
            int i10 = 0;
            while (true) {
                i4 = 8 - iA;
                if (i10 >= i4) {
                    break;
                }
                char cCharAt = this.f4882a.charAt(iArr[i10]);
                if (this.f4884c) {
                    cCharAt = Character.toLowerCase(cCharAt);
                }
                byteArrayOutputStream.write(cCharAt);
                i10++;
            }
            if (this.f4883b) {
                while (i4 < 8) {
                    byteArrayOutputStream.write(61);
                    i4++;
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }
}
