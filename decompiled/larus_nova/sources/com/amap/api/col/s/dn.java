package com.amap.api.col.s;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes28.dex */
public abstract class dn {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    dn f26581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    byte[] f26582d;

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        dn r100 = this;
    L3:
        byte[] r101 = r100.a(r100.f26582d);
        r100 = r100.f26581c;
        if (r100 == null) goto L6;
        r100.f26582d = r101;
        goto L3
    L6:
        return r101;
    }

    public abstract byte[] a(byte[] r100) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void b(byte[] r100) {
    }

    public dn() {
        this.f26582d = null;
    }

    public dn(dn r100) {
        this.f26582d = null;
        this.f26581c = r100;
    }
}
