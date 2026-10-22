package com.amap.api.col.jmsl;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.amap.api.col.jmsl.v0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1614v0 {

    /* renamed from: a, reason: collision with root package name */
    public AbstractC1614v0 f16979a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f16980b = null;

    public AbstractC1614v0() {
    }

    public void a(byte[] bArr) {
    }

    public byte[] b() throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException {
        byte[] bArrC = c(this.f16980b);
        AbstractC1614v0 abstractC1614v0 = this.f16979a;
        if (abstractC1614v0 == null) {
            return bArrC;
        }
        abstractC1614v0.f16980b = bArrC;
        return abstractC1614v0.b();
    }

    public abstract byte[] c(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException;

    public AbstractC1614v0(AbstractC1614v0 abstractC1614v0) {
        this.f16979a = abstractC1614v0;
    }
}
