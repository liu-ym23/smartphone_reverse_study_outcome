package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes.dex */
public final class h0 extends w {
    public h0(boolean z4, int i4, d dVar) {
        super(z4, i4, dVar);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        Enumeration enumerationElements;
        pVar.a(160, this.f7778a);
        pVar.a(128);
        if (this.f7779b) {
            pVar.a(this.f7780c);
        } else {
            d dVar = this.f7780c;
            if (dVar instanceof n) {
                enumerationElements = dVar instanceof b0 ? ((b0) dVar).j() : new b0(((n) dVar).i()).j();
            } else if (dVar instanceof s) {
                enumerationElements = ((s) dVar).i();
            } else {
                if (!(dVar instanceof u)) {
                    StringBuilder sbA = com.baidu.mapauto.auth.a.a("not implemented: ");
                    sbA.append(this.f7780c.getClass().getName());
                    throw new g(sbA.toString());
                }
                enumerationElements = ((u) dVar).f7771a.elements();
            }
            while (enumerationElements.hasMoreElements()) {
                pVar.a((d) enumerationElements.nextElement());
            }
        }
        pVar.a(0);
        pVar.a(0);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int iE = this.f7780c.c().e();
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
