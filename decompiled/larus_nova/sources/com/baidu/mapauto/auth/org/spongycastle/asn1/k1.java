package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class k1 extends p {
    public k1(OutputStream r100) {
        super(r100);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p
    public final void a(d r100) throws IOException {
        if (r100 == null) goto L6;
        r100.c().h().a(this);
        return;
    L6:
        throw new IOException("null object detected");
    }
}
