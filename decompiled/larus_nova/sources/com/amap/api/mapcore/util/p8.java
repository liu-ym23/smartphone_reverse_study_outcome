package com.amap.api.mapcore.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes28.dex */
public abstract class p8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    p8 f27850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    byte[] f27851b;

    public void a(byte[] r100) {
    }

    public abstract byte[] b(byte[] r100) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] r100 = b(this.f27851b);
        p8 r101 = this.f27850a;
        if (r101 == null) goto L6;
        r101.f27851b = r100;
        return r101.a();
    L6:
        return r100;
    }

    public p8() {
        this.f27851b = null;
    }

    public p8(p8 r100) {
        this.f27851b = null;
        this.f27850a = r100;
    }
}
