package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes39.dex */
public final class h0 extends w {
    public h0(boolean r100, int r101, d r102) {
        super(r100, r101, r102);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int r100 = this.f31900c.c().e();
        if (this.f31899b == false) goto L7;
        return (u1.a(r100) + u1.b(this.f31898a)) + r100;
    L7:
        return u1.b(this.f31898a) + (r100 - 1);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        if (this.f31899b == false) goto L7;
        return true;
    L7:
        return this.f31900c.c().g().f();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r100.a(160, this.f31898a);
        r100.a(128);
        if (this.f31899b == true) goto L21;
        d r101 = this.f31900c;
        if ((r101 instanceof n) == false) goto L11;
        if ((r101 instanceof b0) == false) goto L9;
        Enumeration r102 = ((b0) r101).j();
    L17:
        if (r102.hasMoreElements() == false) goto L22;
        r100.a((d) r102.nextElement());
    L22:
        r100.a(0);
        r100.a(0);
        return;
    L9:
        r102 = new b0(((n) r101).i()).j();
        goto L17
    L11:
        if ((r101 instanceof s) == false) goto L14;
        r102 = ((s) r101).i();
        goto L17
    L14:
        if ((r101 instanceof u) == false) goto L19;
        r102 = ((u) r101).f31891a.elements();
        goto L17
    L19:
        StringBuilder r103 = com.baidu.mapauto.auth.b.a("not implemented: ");
        r103.append(this.f31900c.getClass().getName());
        throw new g(r103.toString());
    L21:
        r100.a(this.f31900c);
        goto L22
    }
}
