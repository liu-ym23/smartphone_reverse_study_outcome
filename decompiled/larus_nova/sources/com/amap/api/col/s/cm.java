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
public abstract class cm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    cm f26427a;

    public abstract byte[] a(byte[] r100) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public cm() {
    }

    public cm(cm r100) {
        this.f26427a = r100;
    }

    public final byte[] b(byte[] r100) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        cm r101 = this.f26427a;
        if (r101 == null) goto L6;
        r100 = r101.b(r100);
    L6:
        return a(r100);
    }
}
