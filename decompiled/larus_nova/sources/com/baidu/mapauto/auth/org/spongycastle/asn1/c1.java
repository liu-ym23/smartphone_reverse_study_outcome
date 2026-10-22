package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class c1 implements d, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f31827a;

    public c1(v r100) {
        this.f31827a = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new b1(this.f31827a.b());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        return a();
    L4:
        e = move-exception;
        throw new q(e.getMessage(), e);
    }
}
