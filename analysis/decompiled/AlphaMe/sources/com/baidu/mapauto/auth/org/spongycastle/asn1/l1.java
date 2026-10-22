package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes.dex */
public final class l1 extends s {

    /* renamed from: b, reason: collision with root package name */
    public int f7732b;

    public l1() {
        this.f7732b = -1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        p pVarB = pVar.b();
        if (this.f7732b < 0) {
            Enumeration enumerationElements = this.f7764a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().h().e();
            }
            this.f7732b = iE;
        }
        int i4 = this.f7732b;
        pVar.a(48);
        pVar.b(i4);
        Enumeration enumerationElements2 = this.f7764a.elements();
        while (enumerationElements2.hasMoreElements()) {
            pVarB.a((d) enumerationElements2.nextElement());
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        if (this.f7732b < 0) {
            Enumeration enumerationElements = this.f7764a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().h().e();
            }
            this.f7732b = iE;
        }
        int i4 = this.f7732b;
        return u1.a(i4) + 1 + i4;
    }

    public l1(e eVar) {
        super(eVar);
        this.f7732b = -1;
    }
}
