package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class o0 implements d, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f31865a;

    public o0(v r100) {
        this.f31865a = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new n0(this.f31865a.b());
    L4:
        e = move-exception;
        throw new g(e.getMessage(), e);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        return a();
    L8:
        e = move-exception;
        throw new q("unable to get DER object", e);
    L5:
        e = move-exception;
        throw new q("unable to get DER object", e);
    }
}
