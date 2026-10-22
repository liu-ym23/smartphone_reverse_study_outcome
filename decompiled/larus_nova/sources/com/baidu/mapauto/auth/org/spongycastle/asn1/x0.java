package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class x0 extends p {
    public x0(OutputStream r100) {
        super(r100);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p
    public final x0 a() {
        return this;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p
    public final void a(d r100) throws IOException {
        if (r100 == null) goto L6;
        r100.c().g().a(this);
        return;
    L6:
        throw new IOException("null object detected");
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p
    public final p b() {
        return this;
    }
}
