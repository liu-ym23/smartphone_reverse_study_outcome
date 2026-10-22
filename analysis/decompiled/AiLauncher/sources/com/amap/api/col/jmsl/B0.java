package com.amap.api.col.jmsl;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class B0 {

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f15930a;

    /* renamed from: b, reason: collision with root package name */
    public static String[] f15931b = {"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};

    public static String a(String str) {
        return L1.c(str);
    }

    public static String b(int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < iArr.length; i10++) {
            int i11 = iArr[i10];
            int i12 = 1;
            for (int i13 = 0; i13 < 15; i13++) {
                i12 = (i12 << 2) | 1;
            }
            int i14 = ((i11 & i12) << 1) | (((i12 << 1) & i11) >>> 1);
            int i15 = 0;
            for (int i16 = 0; i16 < i10; i16++) {
                i15 = (i15 >> 1) | Integer.MIN_VALUE;
            }
            int i17 = (i14 << i10) | ((i14 & i15) >>> (32 - i10));
            char[] cArr = new char[4];
            for (int i18 = 0; i18 < 4; i18++) {
                char c10 = (char) ((i17 >>> (i18 * 8)) & 255);
                cArr[3 - i18] = c10;
                String str = " ";
                for (int i19 = 0; i19 < 32; i19++) {
                    str = str + (((Integer.MIN_VALUE >>> i19) & c10) >>> (31 - i19));
                }
            }
            sb2.append(new String(cArr));
        }
        return sb2.toString();
    }

    public static byte[] c(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            if (f15930a == null) {
                f15930a = C1604s2.m("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f15930a);
            int[] iArr = new int[8];
            int i10 = 0;
            while (true) {
                String[] strArr = f15931b;
                if (i10 >= strArr.length) {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(b(iArr).getBytes("UTF-8"), C1604s2.m("EQUVT"));
                    Cipher cipher = Cipher.getInstance(C1604s2.m("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
                    cipher.init(1, secretKeySpec, ivParameterSpec);
                    return cipher.doFinal(bArr);
                }
                byte[] bArrB = C1568j1.b(strArr[i10]);
                iArr[i10] = ((bArrB[0] & 255) << 24) | (bArrB[3] & 255) | ((bArrB[2] & 255) << 8) | ((bArrB[1] & 255) << 16);
                i10++;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String d(String str) {
        try {
            return V.a(c(str.getBytes("UTF-8")));
        } catch (Throwable unused) {
            return null;
        }
    }
}
