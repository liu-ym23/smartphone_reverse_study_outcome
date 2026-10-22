package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class w0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o1 f31901a;

    public w0(o1 r100) {
        this.f31901a = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new v0(this.f31901a.c());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.o
    public final InputStream b() {
        return this.f31901a;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        return a();
    L4:
        e = move-exception;
        StringBuilder r100 = com.baidu.mapauto.auth.b.a("IOException converting stream to byte array: ");
        r100.append(e.getMessage());
        throw new q(r100.toString(), e);
    }
}
