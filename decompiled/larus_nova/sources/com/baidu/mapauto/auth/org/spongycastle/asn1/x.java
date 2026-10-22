package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class x extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f31902a;

    public x(byte[] r100) {
        this.f31902a = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r100.a(23);
        int r101 = this.f31902a.length;
        r100.b(r101);
        int r102 = 0;
    L3:
        if (r102 == r101) goto L5;
        r100.a(this.f31902a[r102]);
        r102 = r102 + 1;
        goto L3
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof x) == true) goto L7;
        return false;
    L7:
        return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f31902a, ((x) r100).f31902a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        int r100 = this.f31902a.length;
        return (u1.a(r100) + 1) + r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f31902a);
    }

    public final String toString() {
        return com.baidu.mapauto.auth.org.spongycastle.util.d.a(this.f31902a);
    }
}
