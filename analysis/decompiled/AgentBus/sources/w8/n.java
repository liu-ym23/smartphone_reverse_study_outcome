package w8;

import b0.a2;
import d7.c0;
import d7.d0;
import d7.e0;
import d7.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10918a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public c7.j f10919b = new c7.j("V", null);

    public n(nb.f fVar, String str) {
    }

    public final void a(String str, e... eVarArr) {
        p pVar;
        q7.k.e(str, "type");
        if (eVarArr.length == 0) {
            pVar = null;
        } else {
            d7.p pVar2 = new d7.p(1, new a2(3, eVarArr));
            int iS = e0.S(t.A0(pVar2, 10));
            if (iS < 16) {
                iS = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iS);
            Iterator it = pVar2.iterator();
            while (true) {
                d0 d0Var = (d0) it;
                if (!d0Var.f2955g.hasNext()) {
                    break;
                }
                c0 c0Var = (c0) d0Var.next();
                linkedHashMap.put(Integer.valueOf(c0Var.f2951a), (e) c0Var.f2952b);
            }
            pVar = new p(linkedHashMap);
        }
        this.f10918a.add(new c7.j(str, pVar));
    }

    public final void b(String str, e... eVarArr) {
        q7.k.e(str, "type");
        d7.p pVar = new d7.p(1, new a2(3, eVarArr));
        int iS = e0.S(t.A0(pVar, 10));
        if (iS < 16) {
            iS = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iS);
        Iterator it = pVar.iterator();
        while (true) {
            d0 d0Var = (d0) it;
            if (!d0Var.f2955g.hasNext()) {
                this.f10919b = new c7.j(str, new p(linkedHashMap));
                return;
            } else {
                c0 c0Var = (c0) d0Var.next();
                linkedHashMap.put(Integer.valueOf(c0Var.f2951a), (e) c0Var.f2952b);
            }
        }
    }

    public final void c(m9.c cVar) {
        q7.k.e(cVar, "type");
        String strC = cVar.c();
        q7.k.d(strC, "type.desc");
        this.f10919b = new c7.j(strC, null);
    }
}
