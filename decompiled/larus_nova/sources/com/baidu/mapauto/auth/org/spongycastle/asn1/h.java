package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class h extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f31838a;

    public h(byte[] r100) {
        this.f31838a = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r100.a(this.f31838a, 24);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof h) == true) goto L7;
        return false;
    L7:
        return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f31838a, ((h) r100).f31838a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        int r100 = this.f31838a.length;
        return (u1.a(r100) + 1) + r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f31838a);
    }
}
