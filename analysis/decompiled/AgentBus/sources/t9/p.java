package t9;

import d7.x;
import f8.e0;
import i8.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import z8.b0;
import z8.c1;
import z8.v0;

/* loaded from: classes.dex */
public final class p extends o {

    /* renamed from: g, reason: collision with root package name */
    public final e0 f9839g;

    /* renamed from: h, reason: collision with root package name */
    public final String f9840h;

    /* renamed from: i, reason: collision with root package name */
    public final e9.c f9841i;

    public p(e0 e0Var, b0 b0Var, b9.f fVar, b9.a aVar, x8.f fVar2, r9.i iVar, String str, p7.a aVar2) {
        q7.k.e(b0Var, "proto");
        q7.k.e(fVar, "nameResolver");
        q7.k.e(aVar, "metadataVersion");
        q7.k.e(iVar, "components");
        q7.k.e(str, "debugName");
        v0 v0Var = b0Var.f12041l;
        q7.k.d(v0Var, "proto.typeTable");
        b9.g gVar = new b9.g(v0Var);
        b9.h hVar = b9.h.f1585b;
        c1 c1Var = b0Var.f12042m;
        q7.k.d(c1Var, "proto.versionRequirementTable");
        r9.k kVarA = iVar.a(e0Var, fVar, gVar, ib.c.t(c1Var), aVar, fVar2);
        List list = b0Var.f12038i;
        q7.k.d(list, "proto.functionList");
        List list2 = b0Var.f12039j;
        q7.k.d(list2, "proto.propertyList");
        List list3 = b0Var.f12040k;
        q7.k.d(list3, "proto.typeAliasList");
        super(kVarA, list, list2, list3, aVar2);
        this.f9839g = e0Var;
        this.f9840h = str;
        this.f9841i = ((c0) e0Var).f4758j;
    }

    @Override // t9.o, o9.o, o9.q
    public final f8.g b(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        ib.k.M(((r9.i) this.f9835b.f9070f).f9055i, aVar, this.f9839g, fVar);
        return super.b(fVar, aVar);
    }

    @Override // o9.o, o9.q
    public final Collection e(o9.f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        List listI = i(fVar, kVar);
        Iterable iterable = ((r9.i) this.f9835b.f9070f).f9057k;
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            x.D0(arrayList, ((h8.c) it.next()).b(this.f9841i));
        }
        return d7.r.c1(listI, arrayList);
    }

    @Override // t9.o
    public final void h(ArrayList arrayList, p7.k kVar) {
        q7.k.e(kVar, "nameFilter");
    }

    @Override // t9.o
    public final e9.b l(e9.f fVar) {
        q7.k.e(fVar, "name");
        return new e9.b(this.f9841i, fVar);
    }

    @Override // t9.o
    public final Set n() {
        return d7.b0.f2947f;
    }

    @Override // t9.o
    public final Set o() {
        return d7.b0.f2947f;
    }

    @Override // t9.o
    public final Set p() {
        return d7.b0.f2947f;
    }

    @Override // t9.o
    public final boolean q(e9.f fVar) {
        q7.k.e(fVar, "name");
        if (super.q(fVar)) {
            return true;
        }
        Iterable iterable = ((r9.i) this.f9835b.f9070f).f9057k;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (((h8.c) it.next()).a(this.f9841i, fVar)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return this.f9840h;
    }
}
