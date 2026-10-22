package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes.dex */
public final class b1 extends u {

    /* renamed from: c, reason: collision with root package name */
    public int f7700c;

    public b1() {
        this.f7700c = -1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        x0 x0VarA = pVar.a();
        if (this.f7700c < 0) {
            Enumeration enumerationElements = this.f7771a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().g().e();
            }
            this.f7700c = iE;
        }
        int i4 = this.f7700c;
        pVar.a(49);
        pVar.b(i4);
        Enumeration enumerationElements2 = this.f7771a.elements();
        while (enumerationElements2.hasMoreElements()) {
            x0VarA.a((d) enumerationElements2.nextElement());
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        if (this.f7700c < 0) {
            Enumeration enumerationElements = this.f7771a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().g().e();
            }
            this.f7700c = iE;
        }
        int i4 = this.f7700c;
        return u1.a(i4) + 1 + i4;
    }

    public b1(e eVar) {
        super(eVar);
        this.f7700c = -1;
    }
}
