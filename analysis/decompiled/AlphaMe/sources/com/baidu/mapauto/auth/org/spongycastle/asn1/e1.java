package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class e1 extends w {
    public e1(boolean z4, int i4, d dVar) {
        super(z4, i4, dVar);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        r rVarG = this.f7780c.c().g();
        if (!this.f7779b) {
            pVar.a(rVarG.f() ? 160 : 128, this.f7778a);
            pVar.a(rVarG);
        } else {
            pVar.a(160, this.f7778a);
            pVar.b(rVarG.e());
            pVar.a((d) rVarG);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int iE = this.f7780c.c().g().e();
        if (this.f7779b) {
            return u1.a(iE) + u1.b(this.f7778a) + iE;
        }
        return u1.b(this.f7778a) + (iE - 1);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        if (this.f7779b) {
            return true;
        }
        return this.f7780c.c().g().f();
    }
}
