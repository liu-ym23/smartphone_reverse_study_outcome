package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes.dex */
public final class m1 extends u {

    /* renamed from: c, reason: collision with root package name */
    public int f7738c;

    public m1() {
        this.f7738c = -1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        p pVarB = pVar.b();
        if (this.f7738c < 0) {
            Enumeration enumerationElements = this.f7771a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().h().e();
            }
            this.f7738c = iE;
        }
        int i4 = this.f7738c;
        pVar.a(49);
        pVar.b(i4);
        Enumeration enumerationElements2 = this.f7771a.elements();
        while (enumerationElements2.hasMoreElements()) {
            pVarB.a((d) enumerationElements2.nextElement());
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        if (this.f7738c < 0) {
            Enumeration enumerationElements = this.f7771a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().h().e();
            }
            this.f7738c = iE;
        }
        int i4 = this.f7738c;
        return u1.a(i4) + 1 + i4;
    }

    public m1(e eVar) {
        super(eVar);
        this.f7738c = -1;
    }
}
