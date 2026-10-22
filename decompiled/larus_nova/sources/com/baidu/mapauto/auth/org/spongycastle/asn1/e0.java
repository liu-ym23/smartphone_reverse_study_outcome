package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class e0 implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f31830a;

    public e0(v r100) {
        this.f31830a = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new d0(this.f31830a.b());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        return a();
    L4:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());
    }
}
