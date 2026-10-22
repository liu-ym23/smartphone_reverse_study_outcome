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
public class k8 extends p8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j7 f27508c;

    public k8(p8 r100) {
        super(r100);
        this.f27508c = new l7();
    }

    @Override // com.amap.api.mapcore.util.p8
    public byte[] b(byte[] r100) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f27508c.b(r100);
    }
}
