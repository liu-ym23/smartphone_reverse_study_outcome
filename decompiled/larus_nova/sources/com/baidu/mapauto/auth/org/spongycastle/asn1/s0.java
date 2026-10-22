package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class s0 extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f31885a;

    public s0(byte[] r100) {
        this.f31885a = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r100.a(this.f31885a, 22);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof s0) == true) goto L7;
        return false;
    L7:
        return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f31885a, ((s0) r100).f31885a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return (u1.a(this.f31885a.length) + 1) + this.f31885a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f31885a);
    }

    public final String toString() {
        return com.baidu.mapauto.auth.org.spongycastle.util.d.a(this.f31885a);
    }
}
