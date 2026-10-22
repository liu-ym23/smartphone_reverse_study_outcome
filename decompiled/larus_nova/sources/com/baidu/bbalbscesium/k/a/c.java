package com.baidu.bbalbscesium.k.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/* JADX INFO: loaded from: classes39.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SecureRandom f30320b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f30321a;

    static {
        f30320b = new SecureRandom();
    }

    public c() {
        this.f30321a = null;
        this.f30321a = new e(new b(), 16);
    }

    public static byte[] a(byte[] r100, byte[] r101, byte[] r102) throws Exception {
        c r103 = new c();
        r103.a(2, r100, r101);
        return r103.a(r102);
    }

    public static byte[] b(byte[] r100, byte[] r101, byte[] r102) throws Exception {
        c r103 = new c();
        r103.a(1, r100, r101);
        return r103.a(r102);
    }

    public void a(int r100, byte[] r101, byte[] r102) throws InvalidAlgorithmParameterException, InvalidKeyException {
        this.f30321a.a(r100, r101, r102, f30320b);
    }

    public final byte[] a(byte[] r100) throws IllegalBlockSizeException, BadPaddingException {
        if (r100 == null) goto L6;
        return this.f30321a.a(r100, 0, r100.length);
    L6:
        throw new IllegalArgumentException("Null input buffer");
    }
}
