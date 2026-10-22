package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class a extends r {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7689a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7690b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f7691c;

    public a(boolean z4, int i4, byte[] bArr) {
        this.f7689a = z4;
        this.f7690b = i4;
        this.f7691c = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof a)) {
            return false;
        }
        a aVar = (a) rVar;
        return this.f7689a == aVar.f7689a && this.f7690b == aVar.f7690b && com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f7691c, aVar.f7691c);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        return u1.a(this.f7691c.length) + u1.b(this.f7690b) + this.f7691c.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return this.f7689a;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        boolean z4 = this.f7689a;
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f7691c) ^ ((z4 ? 1 : 0) ^ this.f7690b);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public void a(p pVar) throws IOException {
        int i4 = this.f7689a ? 96 : 64;
        int i5 = this.f7690b;
        byte[] bArr = this.f7691c;
        pVar.a(i4, i5);
        pVar.b(bArr.length);
        pVar.f7749a.write(bArr);
    }
}
