package com.baidu.bbalbscesium.k.d;

import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f30362a;

    private a() {
    }

    public static a a() throws NoSuchPaddingException {
        a r100 = new a();
        c r101 = new c();
        r100.f30362a = r101;
        r101.b(c.f30370p);
        return r100;
    }

    public void a(int r100, d r101) throws InvalidKeyException {
        this.f30362a.a(r100, r101, b.f30363a);
    }

    public final byte[] a(byte[] r100) throws IllegalBlockSizeException, BadPaddingException {
        if (r100 == null) goto L6;
        return this.f30362a.a(r100, 0, r100.length);
    L6:
        throw new IllegalArgumentException("Null input buffer");
    }
}
