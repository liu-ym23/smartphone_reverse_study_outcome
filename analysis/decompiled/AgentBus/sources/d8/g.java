package d8;

import ba.u;
import d7.r;
import f8.j;
import f8.n0;
import f8.t;
import g8.h;
import i8.l0;
import i8.r0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m.x;
import q7.k;
import v9.v;
import v9.v0;

/* loaded from: classes.dex */
public final class g extends l0 {
    public g(j jVar, g gVar, int i2, boolean z4) {
        super(jVar, gVar, h.f3888a, u.f1636g, i2, n0.f3487b);
        this.f4881r = true;
        this.f4889z = z4;
        this.A = false;
    }

    @Override // i8.l0, i8.u
    public final i8.u I0(int i2, e9.f fVar, j jVar, t tVar, n0 n0Var, g8.j jVar2) {
        k.e(jVar, "newOwner");
        x.t(i2, "kind");
        k.e(jVar2, "annotations");
        return new g(jVar, (g) tVar, i2, this.f4889z);
    }

    @Override // i8.u
    public final i8.u J0(i8.t tVar) {
        e9.f fVar;
        g gVar = (g) super.J0(tVar);
        if (gVar == null) {
            return null;
        }
        List listX0 = gVar.x0();
        k.d(listX0, "substituted.valueParameters");
        if (listX0.isEmpty()) {
            return gVar;
        }
        Iterator it = listX0.iterator();
        while (it.hasNext()) {
            v type = ((r0) it.next()).getType();
            k.d(type, "it.type");
            if (s7.a.q(type) != null) {
                List listX02 = gVar.x0();
                k.d(listX02, "substituted.valueParameters");
                ArrayList arrayList = new ArrayList(d7.t.A0(listX02, 10));
                Iterator it2 = listX02.iterator();
                while (it2.hasNext()) {
                    v type2 = ((r0) it2.next()).getType();
                    k.d(type2, "it.type");
                    arrayList.add(s7.a.q(type2));
                }
                int size = gVar.x0().size() - arrayList.size();
                boolean z4 = true;
                if (size == 0) {
                    List listX03 = gVar.x0();
                    k.d(listX03, "valueParameters");
                    ArrayList arrayListS1 = r.s1(arrayList, listX03);
                    if (arrayListS1.isEmpty()) {
                        return gVar;
                    }
                    Iterator it3 = arrayListS1.iterator();
                    while (it3.hasNext()) {
                        c7.j jVar = (c7.j) it3.next();
                        if (!k.a((e9.f) jVar.f1973f, ((r0) jVar.f1974g).getName())) {
                        }
                    }
                    return gVar;
                }
                List<r0> listX04 = gVar.x0();
                k.d(listX04, "valueParameters");
                ArrayList arrayList2 = new ArrayList(d7.t.A0(listX04, 10));
                for (r0 r0Var : listX04) {
                    e9.f name = r0Var.getName();
                    k.d(name, "it.name");
                    int i2 = r0Var.f4845k;
                    int i10 = i2 - size;
                    if (i10 >= 0 && (fVar = (e9.f) arrayList.get(i10)) != null) {
                        name = fVar;
                    }
                    arrayList2.add(r0Var.G0(gVar, name, i2));
                }
                i8.t tVarM0 = gVar.M0(v0.f10595b);
                if (arrayList.isEmpty()) {
                    z4 = false;
                } else {
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        if (((e9.f) it4.next()) == null) {
                            break;
                        }
                    }
                    z4 = false;
                }
                tVarM0.A = Boolean.valueOf(z4);
                tVarM0.f4858l = arrayList2;
                tVarM0.f4856j = gVar.a();
                i8.u uVarJ0 = super.J0(tVarM0);
                k.b(uVarJ0);
                return uVarJ0;
            }
        }
        return gVar;
    }

    @Override // i8.u, f8.t
    public final boolean e() {
        return false;
    }

    @Override // i8.u, f8.t
    public final boolean e0() {
        return false;
    }

    @Override // i8.u, f8.w
    public final boolean w() {
        return false;
    }
}
