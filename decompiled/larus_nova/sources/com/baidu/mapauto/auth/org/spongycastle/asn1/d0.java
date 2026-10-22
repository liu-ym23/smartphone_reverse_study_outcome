package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes39.dex */
public final class d0 extends s {
    public d0() {
    }

    public d0(e r100) {
        super(r100);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        Enumeration r100 = this.f31884a.elements();
        int r101 = 0;
    L4:
        if (r100.hasMoreElements() == false) goto L7;
        r101 = r101 + ((d) r100.nextElement()).c().e();
        goto L4
    L7:
        return (r101 + 2) + 2;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r100.a(48);
        r100.a(128);
        Enumeration r101 = this.f31884a.elements();
    L4:
        if (r101.hasMoreElements() == false) goto L6;
        r100.a((d) r101.nextElement());
        goto L4
    L6:
        r100.a(0);
        r100.a(0);
    }
}
