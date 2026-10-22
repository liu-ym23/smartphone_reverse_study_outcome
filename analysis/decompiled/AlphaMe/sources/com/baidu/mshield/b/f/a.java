package com.baidu.mshield.b.f;

import android.util.Base64;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f8284a;

    /* renamed from: b, reason: collision with root package name */
    public static byte[] f8285b;

    /* renamed from: c, reason: collision with root package name */
    public static byte[] f8286c;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return c(bArr2, bArr);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return d(bArr2, bArr);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        try {
            return com.baidu.xclient.gdid.a.b(bArr2, bArr);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return null;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            return com.baidu.xclient.gdid.a.a(bArr2, bArr);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return null;
        }
    }

    public static synchronized byte[] a(int i4) {
        byte[] bArr;
        try {
            if (i4 == 16) {
                byte[] bArr2 = f8284a;
                if (bArr2 == null || bArr2.length != 16) {
                    f8284a = Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 74, 107, 97, 87, 78, 49, 90, 71, 108, 104, 89, 103, kotlin.io.encoding.Base64.padSymbol, kotlin.io.encoding.Base64.padSymbol}, 0);
                }
                bArr = f8284a;
            } else if (i4 != 24) {
                bArr = new byte[0];
            } else {
                byte[] bArr3 = f8285b;
                if (bArr3 == null || bArr3.length != 24) {
                    f8285b = Base64.decode(new byte[]{84, 88, 112, 66, 101, 85, 49, 85, 83, 88, 104, 78, 82, 69, 112, 114, 89, 86, 100, 79, 77, 86, 112, 72, 98, 71, 104, 90, 90, 122, 48, 57, 10}, 0);
                }
                bArr = f8285b;
            }
        } catch (Throwable th) {
            byte[] bArr4 = new byte[0];
            com.baidu.sec.privacy.f.c.a(th);
            bArr = bArr4;
        }
        return bArr;
    }

    public static synchronized byte[] a() {
        byte[] bArr;
        try {
            byte[] bArr2 = f8286c;
            if (bArr2 == null || bArr2.length != 16) {
                f8286c = Base64.decode(new byte[]{78, 68, 65, 121, 77, 122, 85, 120, 78, 122, 74, 108, 97, 71, 78, 110, 90, 109, 108, 106, 89, 81, kotlin.io.encoding.Base64.padSymbol, kotlin.io.encoding.Base64.padSymbol, 10}, 0);
            }
            bArr = f8286c;
        } finally {
            return bArr;
        }
        return bArr;
    }
}
