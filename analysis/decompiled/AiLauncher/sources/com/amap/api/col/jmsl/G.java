package com.amap.api.col.jmsl;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
public class G extends AbstractC1614v0 {

    /* renamed from: c, reason: collision with root package name */
    public N f16087c;

    public G(AbstractC1614v0 abstractC1614v0) {
        super(abstractC1614v0);
        this.f16087c = new C1543d0();
    }

    @Override // com.amap.api.col.jmsl.AbstractC1614v0
    public byte[] c(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException {
        return this.f16087c.b(bArr);
    }
}
