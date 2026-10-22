package com.amap.api.col.jmsl;

import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class U {
    public static byte[] a(String str) {
        try {
            String[] strArrSplit = new StringBuffer(str).reverse().toString().split(Const.STR_MART_COMMA);
            int length = strArrSplit.length;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                bArr[i10] = Byte.parseByte(strArrSplit[i10]);
            }
            String[] strArrSplit2 = new StringBuffer(new String(V.c(new String(bArr)), "UTF-8")).reverse().toString().split(Const.STR_MART_COMMA);
            byte[] bArr2 = new byte[strArrSplit2.length];
            for (int i11 = 0; i11 < strArrSplit2.length; i11++) {
                bArr2[i11] = Byte.parseByte(strArrSplit2[i11]);
            }
            return bArr2;
        } catch (Throwable th) {
            C1541c2.b(th, "AMU", "rcs");
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArrA;
        byte[] bArrA2 = null;
        try {
            try {
                bArrA = a("16,99,86,77,511,98,86,97,511,99,86,77,511,18,48,97,511,99,86,77,511,58,601,77,511,58,48,77,511,58,86,87,511,18,48,97,511,58,86,87,511,18,48,97,511,98,48,87,511,98,48,97,511,99,86,77,511,58,221,77,511,98,601,87");
            } catch (Throwable th) {
                C1541c2.b(th, "AMU", "grk");
                bArrA = null;
            }
            try {
                bArrA2 = a("16,18,86,97,511,18,48,97,511,18,86,97,511,58,86,77,511,18,86,97,511,58,48,77,511,18,86,97,511,58,601,77,511,18,86,97,511,58,221,77,511,18,86,97,511,58,86,87,511,18,86,97,511,58,48,87,511,18,86,97,511,58,601,87");
            } catch (Throwable th2) {
                C1541c2.b(th2, "AMU", "giv");
            }
            return C1568j1.f(bArrA, bArr, bArrA2);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArrA;
        byte[] bArrA2 = null;
        try {
            try {
                bArrA = a("16,99,86,77,511,98,86,97,511,99,86,77,511,18,48,97,511,99,86,77,511,58,601,77,511,58,48,77,511,58,86,87,511,18,48,97,511,58,86,87,511,18,48,97,511,98,48,87,511,98,48,97,511,99,86,77,511,58,221,77,511,98,601,87");
            } catch (Throwable th) {
                C1541c2.b(th, "AMU", "grk");
                bArrA = null;
            }
            try {
                bArrA2 = a("16,18,86,97,511,18,48,97,511,18,86,97,511,58,86,77,511,18,86,97,511,58,48,77,511,18,86,97,511,58,601,77,511,18,86,97,511,58,221,77,511,18,86,97,511,58,86,87,511,18,86,97,511,58,48,87,511,18,86,97,511,58,601,87");
            } catch (Throwable th2) {
                C1541c2.b(th2, "AMU", "giv");
            }
            return C1568j1.h(bArrA, bArr, bArrA2);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }
}
