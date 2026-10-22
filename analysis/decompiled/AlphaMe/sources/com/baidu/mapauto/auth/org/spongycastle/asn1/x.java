package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class x extends r {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f7782a;

    public x(byte[] bArr) {
        this.f7782a = bArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(23);
        int length = this.f7782a.length;
        pVar.b(length);
        for (int i4 = 0; i4 != length; i4++) {
            pVar.a(this.f7782a[i4]);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        int length = this.f7782a.length;
        return u1.a(length) + 1 + length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f7782a);
    }

    public final String toString() {
        return com.baidu.mapauto.auth.org.spongycastle.util.d.a(this.f7782a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof x) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f7782a, ((x) rVar).f7782a);
        }
        return false;
    }
}
