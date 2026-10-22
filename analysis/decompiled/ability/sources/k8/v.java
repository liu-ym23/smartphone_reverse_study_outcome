package k8;

import h8.AbstractC1538u;
import h8.InterfaceC1494B;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class v implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4873a;
    public final w b;

    public /* synthetic */ v(w wVar, int i) {
        this.f4873a = i;
        this.b = wVar;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f4873a) {
            case 0:
                w wVar = this.b;
                z zVar = wVar.c;
                zVar.Q0();
                return AbstractC1538u.f((C1643l) zVar.k.getF4884a(), wVar.d);
            case 1:
                w wVar2 = this.b;
                z zVar2 = wVar2.c;
                zVar2.Q0();
                return Boolean.valueOf(AbstractC1538u.e((C1643l) zVar2.k.getF4884a(), wVar2.d));
            default:
                w wVar3 = this.b;
                W8.h hVar = wVar3.f;
                Z7.t[] tVarArr = w.h;
                boolean zBooleanValue = ((Boolean) S0.b.g1(hVar, tVarArr[1])).booleanValue();
                G8.c cVar = wVar3.d;
                z zVar3 = wVar3.c;
                if (zBooleanValue) {
                    return Q8.n.b;
                }
                List list = (List) S0.b.g1(wVar3.e, tVarArr[0]);
                ArrayList arrayList = new ArrayList(D7.w.c0(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((InterfaceC1494B) it.next()).w());
                }
                return com.stepos.statsrpk.d.p(D7.v.R0(arrayList, new L(zVar3, cVar)), "package view scope for " + cVar + " in " + zVar3.getName());
        }
    }
}
