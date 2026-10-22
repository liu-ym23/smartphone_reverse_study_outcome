package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class g0 implements d, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f31835a;

    public g0(v r100) {
        this.f31835a = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new f0(this.f31835a.b());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        return a();
    L4:
        e = move-exception;
        throw new q(e.getMessage(), e);
    }
}
