package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes.dex */
public final class z0 extends s {

    /* renamed from: b, reason: collision with root package name */
    public int f7790b;

    public z0() {
        this.f7790b = -1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        x0 x0VarA = pVar.a();
        int iJ = j();
        pVar.a(48);
        pVar.b(iJ);
        Enumeration enumerationElements = this.f7764a.elements();
        while (enumerationElements.hasMoreElements()) {
            x0VarA.a((d) enumerationElements.nextElement());
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int iJ = j();
        return u1.a(iJ) + 1 + iJ;
    }

    public final int j() throws IOException {
        if (this.f7790b < 0) {
            Enumeration enumerationElements = this.f7764a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().g().e();
            }
            this.f7790b = iE;
        }
        return this.f7790b;
    }

    public z0(e eVar) {
        super(eVar);
        this.f7790b = -1;
    }
}
