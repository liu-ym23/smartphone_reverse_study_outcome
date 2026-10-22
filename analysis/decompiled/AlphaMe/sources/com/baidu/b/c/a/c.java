package com.baidu.b.c.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final SecureRandom f4817a = new SecureRandom();

    /* renamed from: b, reason: collision with root package name */
    private e f4818b;

    public c() {
        this.f4818b = null;
        this.f4818b = new e(new b(), 16);
    }

    public void a(int i4, byte[] bArr, byte[] bArr2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.f4818b.a(i4, bArr, bArr2, f4817a);
    }

    public final byte[] a(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException {
        if (bArr != null) {
            return this.f4818b.a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        c cVar = new c();
        cVar.a(2, bArr, bArr2);
        return cVar.a(bArr3);
    }
}
