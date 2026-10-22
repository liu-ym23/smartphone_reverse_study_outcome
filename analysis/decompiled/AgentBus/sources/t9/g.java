package t9;

import f8.a0;
import f8.e0;
import f8.n0;
import f8.v;
import i8.r0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import v9.z;
import z8.p0;

/* loaded from: classes.dex */
public final class g extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9798g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i f9799h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(i iVar, int i2) {
        super(0);
        this.f9798g = i2;
        this.f9799h = iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v30, types: [java.util.ArrayList] */
    @Override // p7.a
    public final Object c() {
        Object next;
        f8.n nVar;
        Object uVar;
        z zVarD0;
        ?? arrayList;
        int i2 = this.f9798g;
        int i10 = 1;
        i iVar = this.f9799h;
        switch (i2) {
            case 0:
                return v.c(iVar);
            case 1:
                return d7.r.m1(((r9.i) iVar.f9809q.f9070f).f9051e.h(iVar.A));
            case 2:
                z8.i iVar2 = iVar.f9802j;
                if ((iVar2.f12187h & 4) != 4) {
                    return null;
                }
                f8.g gVarB = iVar.C0().b(nb.i.y((b9.f) iVar.f9809q.f9071g, iVar2.f12190k), n8.c.f6883l);
                if (gVarB instanceof f8.e) {
                    return (f8.e) gVarB;
                }
                return null;
            case 3:
                r9.k kVar = iVar.f9809q;
                List list = iVar.f9802j.f12200u;
                q7.k.d(list, "classProto.constructorList");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (b9.e.f1570m.e(((z8.k) obj).f12229i).booleanValue()) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(d7.t.A0(arrayList2, 10));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    z8.k kVar2 = (z8.k) it.next();
                    r9.r rVar = (r9.r) kVar.f9078n;
                    q7.k.d(kVar2, "it");
                    arrayList3.add(rVar.d(kVar2, false));
                }
                return d7.r.c1(d7.r.c1(arrayList3, d7.s.w0(iVar.k0())), ((r9.i) kVar.f9070f).f9060n.c(iVar));
            case 4:
                i iVar3 = this.f9799h;
                int i11 = iVar3.f9808p;
                if (!a1.a.a(i11)) {
                    List list2 = iVar3.f9802j.f12200u;
                    q7.k.d(list2, "classProto.constructorList");
                    Iterator it2 = list2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            next = it2.next();
                            if (!b9.e.f1570m.e(((z8.k) next).f12229i).booleanValue()) {
                            }
                        } else {
                            next = null;
                        }
                    }
                    z8.k kVar3 = (z8.k) next;
                    if (kVar3 != null) {
                        return ((r9.r) iVar3.f9809q.f9078n).d(kVar3, true);
                    }
                    return null;
                }
                h9.e eVar = new h9.e(iVar3, null, g8.h.f3888a, true, 1, n0.f3487b);
                List list3 = Collections.EMPTY_LIST;
                int i12 = h9.f.f4236a;
                if (i11 == 3 || a1.a.a(i11)) {
                    nVar = f8.o.f3488a;
                    if (nVar == null) {
                        h9.f.a(49);
                        throw null;
                    }
                } else if (h9.f.q(iVar3)) {
                    nVar = f8.o.f3488a;
                    if (nVar == null) {
                        h9.f.a(51);
                        throw null;
                    }
                } else if (h9.f.k(iVar3)) {
                    nVar = f8.o.f3497j;
                    if (nVar == null) {
                        h9.f.a(52);
                        throw null;
                    }
                } else {
                    nVar = f8.o.f3492e;
                    if (nVar == null) {
                        h9.f.a(53);
                        throw null;
                    }
                }
                eVar.U0(list3, nVar);
                eVar.f4875l = iVar3.k();
                return eVar;
            case 5:
                int i13 = iVar.f9806n;
                if (i13 == 2) {
                    List<Integer> list4 = iVar.f9802j.f12205z;
                    q7.k.d(list4, "fqNames");
                    if (!list4.isEmpty()) {
                        ArrayList arrayList4 = new ArrayList();
                        for (Integer num : list4) {
                            r9.k kVar4 = iVar.f9809q;
                            r9.i iVar4 = (r9.i) kVar4.f9070f;
                            b9.f fVar = (b9.f) kVar4.f9071g;
                            q7.k.d(num, "index");
                            f8.e eVarB = iVar4.b(nb.i.s(fVar, num.intValue()));
                            if (eVarB != null) {
                                arrayList4.add(eVarB);
                            }
                        }
                        return arrayList4;
                    }
                    if (i13 == 2) {
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        f8.j jVar = iVar.f9814v;
                        if (jVar instanceof e0) {
                            h9.m.c(iVar, linkedHashSet, ((e0) jVar).v0(), false);
                        }
                        h9.m.c(iVar, linkedHashSet, iVar.h0(), true);
                        return d7.r.j1(linkedHashSet, new h9.i(i10));
                    }
                }
                return d7.z.f2978f;
            default:
                r9.k kVar5 = iVar.f9809q;
                if (!iVar.e() && !iVar.l()) {
                    return null;
                }
                z8.i iVar5 = iVar.f9802j;
                b9.f fVar2 = (b9.f) kVar5.f9071g;
                b9.g gVar = (b9.g) kVar5.f9073i;
                a7.g gVar2 = (a7.g) kVar5.f9077m;
                q7.k.e(iVar5, "<this>");
                q7.k.e(fVar2, "nameResolver");
                if (iVar5.E.size() > 0) {
                    List<Integer> list5 = iVar5.E;
                    q7.k.d(list5, "multiFieldValueClassUnderlyingNameList");
                    ArrayList arrayList5 = new ArrayList(d7.t.A0(list5, 10));
                    for (Integer num2 : list5) {
                        q7.k.d(num2, "it");
                        arrayList5.add(nb.i.y(fVar2, num2.intValue()));
                    }
                    c7.j jVar2 = new c7.j(Integer.valueOf(iVar5.H.size()), Integer.valueOf(iVar5.G.size()));
                    if (jVar2.equals(new c7.j(Integer.valueOf(arrayList5.size()), 0))) {
                        List<Integer> list6 = iVar5.H;
                        q7.k.d(list6, "multiFieldValueClassUnderlyingTypeIdList");
                        arrayList = new ArrayList(d7.t.A0(list6, 10));
                        for (Integer num3 : list6) {
                            q7.k.d(num3, "it");
                            arrayList.add(gVar.a(num3.intValue()));
                        }
                    } else {
                        if (!jVar2.equals(new c7.j(0, Integer.valueOf(arrayList5.size())))) {
                            throw new IllegalStateException(("class " + nb.i.y(fVar2, iVar5.f12189j) + " has illegal multi-field value class representation").toString());
                        }
                        arrayList = iVar5.G;
                    }
                    q7.k.d(arrayList, "when (typeIdCount to typ…epresentation\")\n        }");
                    ArrayList arrayList6 = new ArrayList(d7.t.A0(arrayList, 10));
                    for (p0 p0Var : arrayList) {
                        q7.k.e(p0Var, "p0");
                        arrayList6.add(gVar2.u(p0Var, true));
                    }
                    uVar = new a0(d7.r.s1(arrayList5, arrayList6));
                } else if ((iVar5.f12187h & 8) == 8) {
                    e9.f fVarY = nb.i.y(fVar2, iVar5.B);
                    int i14 = iVar5.f12187h;
                    p0 p0VarA = (i14 & 16) == 16 ? iVar5.C : (i14 & 32) == 32 ? gVar.a(iVar5.D) : null;
                    if ((p0VarA == null || (zVarD0 = gVar2.u(p0VarA, true)) == null) && (zVarD0 = iVar.D0(fVarY)) == null) {
                        throw new IllegalStateException(("cannot determine underlying type for value class " + nb.i.y(fVar2, iVar5.f12189j) + " with property " + fVarY).toString());
                    }
                    uVar = new f8.u(fVarY, zVarD0);
                } else {
                    uVar = null;
                }
                if (uVar != null) {
                    return uVar;
                }
                if (iVar.f9803k.a(1, 5, 1)) {
                    return null;
                }
                i8.i iVarK0 = iVar.k0();
                if (iVarK0 == null) {
                    throw new IllegalStateException(("Inline class has no primary constructor: " + iVar).toString());
                }
                List listX0 = iVarK0.x0();
                q7.k.d(listX0, "constructor.valueParameters");
                e9.f name = ((r0) d7.r.N0(listX0)).getName();
                q7.k.d(name, "constructor.valueParameters.first().name");
                z zVarD02 = iVar.D0(name);
                if (zVarD02 != null) {
                    return new f8.u(name, zVarD02);
                }
                throw new IllegalStateException(("Value class has no underlying property: " + iVar).toString());
        }
    }
}
