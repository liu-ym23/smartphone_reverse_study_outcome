package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class e1 extends w {
    public e1(boolean r100, int r101, d r102) {
        super(r100, r101, r102);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r r101 = this.f31900c.c().g();
        int r102 = 160;
        if (this.f31899b == false) goto L6;
        r100.a(160, this.f31898a);
        r100.b(r101.e());
        r100.a(r101);
        return;
    L6:
        if (r101.f() == true) goto L9;
        r102 = 128;
    L9:
        r100.a(r102, this.f31898a);
        r100.a(r101);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int r100 = this.f31900c.c().g().e();
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
}
