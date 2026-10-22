package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class z implements d, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f31909b;

    public z(int r100, v r101) {
        this.f31908a = r100;
        this.f31909b = r101;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new y(this.f31908a, this.f31909b.b());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        return a();
    L4:
        e = move-exception;
        throw new q(e.getMessage(), e);
    }
}
