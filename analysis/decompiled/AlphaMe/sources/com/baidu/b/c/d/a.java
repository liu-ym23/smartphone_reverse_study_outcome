package com.baidu.b.c.d;

import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private c f4847a;

    private a() {
    }

    public static a a() throws NoSuchPaddingException {
        a aVar = new a();
        c cVar = new c();
        aVar.f4847a = cVar;
        cVar.a("PKCS1Padding");
        return aVar;
    }

    public void a(int i4, d dVar) throws InvalidKeyException {
        this.f4847a.a(i4, dVar, b.f4848a);
    }

    public final byte[] a(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException {
        if (bArr != null) {
            return this.f4847a.a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
