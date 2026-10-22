package com.baidu.b.c.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static volatile byte[] f4835a;

    public static byte[] a() throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (f4835a == null) {
            synchronized (g.class) {
                try {
                    if (f4835a == null) {
                        byte[] bArr = new byte[16];
                        System.arraycopy(com.baidu.b.c.c.b.b(), 0, bArr, 0, 16);
                        c cVar = new c();
                        cVar.a(2, bArr, bArr);
                        f4835a = cVar.a(new byte[]{-71, -100, -115, 26, 39, -124, 14, 14, -31, -46, -56, 1, 25, -127, -99, -107, -54, 51, 46, 14, 68, -68, -19, 28, 66, 19, -113, 5, 25, -11, -123, 50});
                    }
                } finally {
                }
            }
        }
        return f4835a;
    }
}
