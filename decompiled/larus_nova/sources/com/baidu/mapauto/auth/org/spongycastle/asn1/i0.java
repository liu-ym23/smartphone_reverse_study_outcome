package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class i0 implements d, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f31843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f31844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f31845c;

    public i0(boolean r100, int r101, v r102) {
        this.f31843a = r100;
        this.f31844b = r101;
        this.f31845c = r102;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return this.f31845c.a(this.f31843a, this.f31844b);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        return a();
    L4:
        e = move-exception;
        throw new q(e.getMessage());
    }
}
