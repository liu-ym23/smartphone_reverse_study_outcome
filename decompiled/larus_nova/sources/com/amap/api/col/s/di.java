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
public final class di extends dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private cm f26571a;

    public di() {
        this.f26571a = new co();
    }

    public di(dn r100) {
        super(r100);
        this.f26571a = new co();
    }

    @Override // com.amap.api.col.s.dn
    public final byte[] a(byte[] r100) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f26571a.b(r100);
    }
}
