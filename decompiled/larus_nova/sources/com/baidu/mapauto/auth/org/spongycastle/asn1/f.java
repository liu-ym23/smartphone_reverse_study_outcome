package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class f extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f[] f31831b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f31832a;

    static {
        f31831b = new f[12];
    }

    public f(byte[] r100) {
        if (com.baidu.mapauto.auth.org.spongycastle.util.c.a() == false) goto L5;
    L9:
        this.f31832a = com.baidu.mapauto.auth.org.spongycastle.util.a.a(r100);
        return;
    L5:
        if (j.b(r100) == false) goto L9;
        throw new IllegalArgumentException("malformed enumerated");
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r100.a(this.f31832a, 10);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof f) == true) goto L7;
        return false;
    L7:
        return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f31832a, ((f) r100).f31832a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return (u1.a(this.f31832a.length) + 1) + this.f31832a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f31832a);
    }
}
