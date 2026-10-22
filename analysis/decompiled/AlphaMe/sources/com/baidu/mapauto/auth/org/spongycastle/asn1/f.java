package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class f extends r {

    /* renamed from: b, reason: collision with root package name */
    public static f[] f7711b = new f[12];

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7712a;

    public f(byte[] bArr) {
        if (!com.baidu.mapauto.auth.org.spongycastle.util.c.a() && j.b(bArr)) {
            throw new IllegalArgumentException("malformed enumerated");
        }
        this.f7712a = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f7712a, 10);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return u1.a(this.f7712a.length) + 1 + this.f7712a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f7712a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof f) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f7712a, ((f) rVar).f7712a);
        }
        return false;
    }
}
