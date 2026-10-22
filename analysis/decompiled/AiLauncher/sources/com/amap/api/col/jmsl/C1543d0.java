package com.amap.api.col.jmsl;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.amap.api.col.jmsl.d0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1543d0 extends N {
    public C1543d0() {
    }

    @Override // com.amap.api.col.jmsl.N
    public final byte[] a(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException {
        return C1568j1.i(bArr);
    }

    public C1543d0(N n10) {
        super(n10);
    }
}
