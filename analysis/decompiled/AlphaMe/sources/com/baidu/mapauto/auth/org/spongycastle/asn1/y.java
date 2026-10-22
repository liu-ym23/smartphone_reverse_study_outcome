package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public final class y extends a {
    public y(int i4, e eVar) {
        super(true, i4, a(eVar));
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.a, com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f7689a ? 96 : 64, this.f7690b);
        pVar.a(128);
        pVar.f7749a.write(this.f7691c);
        pVar.a(0);
        pVar.a(0);
    }

    public static byte[] a(e eVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i4 = 0; i4 != eVar.f7709a.size(); i4++) {
            try {
                byteArrayOutputStream.write(((l) eVar.a(i4)).a("BER"));
            } catch (IOException e4) {
                throw new q("malformed object: " + e4, e4);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
