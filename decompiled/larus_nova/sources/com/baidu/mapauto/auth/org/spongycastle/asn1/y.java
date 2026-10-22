package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encoding;

/* JADX INFO: loaded from: classes39.dex */
public final class y extends a {
    public y(int r100, e r101) {
        super(true, r100, a(r101));
    }

    public static byte[] a(e r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        int r102 = 0;
    L4:
        if (r102 == r100.f31829a.size()) goto L11;
        r101.write(((l) r100.a(r102)).a(ASN1Encoding.BER));     // Catch: IOException -> L7
        r102 = r102 + 1;
    L7:
        e = move-exception;
        throw new q("malformed object: " + e, e);
    L11:
        return r101.toByteArray();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.a, com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        if (this.f31809a == false) goto L5;
        int r101 = 96;
    L6:
        r100.a(r101, this.f31810b);
        r100.a(128);
        byte[] r102 = this.f31811c;
        r100.f31869a.write(r102);
        r100.a(0);
        r100.a(0);
        return;
    L5:
        r101 = 64;
        goto L6
    }
}
