package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encoding;

/* JADX INFO: loaded from: classes39.dex */
public abstract class l implements d {
    public l() {
    }

    public final byte[] a(String r100) throws IOException {
        if (r100.equals(ASN1Encoding.DER) == false) goto L8;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        new x0(r101).a(this);
    L6:
        return r101.toByteArray();
    L8:
        if (r100.equals(ASN1Encoding.DL) == false) goto L11;
        r101 = new ByteArrayOutputStream();
        new k1(r101).a(this);
        goto L6
    L11:
        return d();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public abstract r c();

    public final byte[] d() throws IOException {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        new p(r100).a(this);
        return r100.toByteArray();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L10;
        return false;
    L10:
        return c().equals(((d) r100).c());
    }

    public int hashCode() {
        return c().hashCode();
    }
}
