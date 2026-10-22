package com.volcengine.tos;

import F9.C0234l;
import M0.k;
import R6.b;
import R6.c;
import S6.a;
import X6.i;
import X6.j;
import X6.o;
import a.AbstractC0291a;
import a7.AbstractC0307c;
import e7.C1424a;
import java.net.UnknownHostException;
import k2.C1621a;

/* loaded from: classes3.dex */
public class TOSV2ClientBuilder {
    public TOSV2 build(String str, String str2, String str3, String str4) {
        a aVar = (AbstractC0291a.y(str3) && AbstractC0291a.y(str4)) ? new a(str3, str4) : null;
        R6.a aVarA = b.a();
        aVarA.c = str;
        aVarA.b = str2;
        aVarA.f1156a = aVar;
        return build(aVarA.a());
    }

    public TOSV2 build(String str, String str2, String str3, String str4, String str5) {
        a aVar;
        if (AbstractC0291a.y(str3) && AbstractC0291a.y(str4) && AbstractC0291a.y(str5)) {
            aVar = new a(str3, str4);
            aVar.d = str5;
        } else {
            aVar = null;
        }
        R6.a aVarA = b.a();
        aVarA.c = str;
        aVarA.b = str2;
        aVarA.f1156a = aVar;
        return build(aVarA.a());
    }

    public TOSV2 build(String str, String str2, S6.b bVar) {
        R6.a aVarA = b.a();
        aVarA.c = str;
        aVarA.b = str2;
        aVarA.f1156a = bVar;
        return build(aVarA.a());
    }

    public TOSV2 build(String str, String str2, String str3, String str4, C1424a c1424a) {
        a aVar = (AbstractC0291a.y(str3) && AbstractC0291a.y(str4)) ? new a(str3, str4) : null;
        R6.a aVarA = b.a();
        aVarA.c = str;
        aVarA.b = str2;
        aVarA.f1156a = aVar;
        aVarA.d = c1424a;
        return build(aVarA.a());
    }

    public TOSV2 build(String str, String str2, S6.b bVar, C1424a c1424a) {
        R6.a aVarA = b.a();
        aVarA.c = str;
        aVarA.b = str2;
        aVarA.f1156a = bVar;
        aVarA.d = c1424a;
        return build(aVarA.a());
    }

    public TOSV2 build(String str, String str2, String str3, String str4, String str5, C1424a c1424a) {
        a aVar;
        if (AbstractC0291a.y(str3) && AbstractC0291a.y(str4) && AbstractC0291a.y(str5)) {
            aVar = new a(str3, str4);
            aVar.d = str5;
        } else {
            aVar = null;
        }
        R6.a aVarA = b.a();
        aVarA.c = str;
        aVarA.b = str2;
        aVarA.f1156a = aVar;
        aVarA.d = c1424a;
        return build(aVarA.a());
    }

    public TOSV2 build(b bVar) throws NumberFormatException, UnknownHostException {
        b bVar2;
        S6.b bVar3;
        c cVar = new c();
        AbstractC0307c.a(bVar, "TOSClientConfiguration");
        AbstractC0307c.a(bVar.c, "region");
        cVar.f1158a = bVar;
        cVar.a();
        if (cVar.i == null) {
            if (cVar.g == null) {
                b bVar4 = cVar.f1158a;
                String str = bVar4.b;
                if (bVar4.d != null && !AbstractC0291a.x(str)) {
                    str.startsWith("http");
                    cVar.f1158a.d.getClass();
                }
                cVar.g = new B1.b(cVar.f1158a.d);
            }
            if (cVar.h == null && (bVar3 = (bVar2 = cVar.f1158a).f1157a) != null) {
                cVar.h = new K1.a(bVar3, bVar2.c);
            }
            K1.a aVar = cVar.h;
            String str2 = cVar.f1158a.b;
            o oVar = new o();
            oVar.e = 0;
            oVar.f1519a = aVar;
            oVar.d(str2);
            cVar.f1158a.getClass();
            cVar.i = oVar;
        }
        B1.b bVar5 = cVar.g;
        o oVar2 = cVar.i;
        C1621a c1621a = new C1621a();
        c1621a.f4793a = new A0.b(bVar5, 3);
        c1621a.b = oVar2;
        cVar.b = c1621a;
        C0234l c0234l = new C0234l();
        c0234l.c = new A0.b(bVar5, 3);
        c0234l.d = oVar2;
        b bVar6 = cVar.f1158a;
        c0234l.f649a = bVar6.e;
        boolean z10 = bVar6.f;
        c0234l.b = z10;
        cVar.c = c0234l;
        j jVar = new j();
        jVar.f1514a = new A0.b(bVar5, 3);
        jVar.b = c0234l;
        jVar.c = z10;
        cVar.d = jVar;
        K1.a aVar2 = cVar.h;
        k kVar = new k(4);
        AbstractC0307c.a(oVar2, "TosRequestFactory");
        AbstractC0307c.a(aVar2, "Signer");
        kVar.b = oVar2;
        kVar.c = aVar2;
        cVar.e = kVar;
        cVar.f = new i(cVar.b, cVar.c, cVar.d, kVar);
        return cVar;
    }
}
