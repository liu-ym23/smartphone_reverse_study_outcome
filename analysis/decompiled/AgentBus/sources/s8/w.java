package s8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class w extends e0 {

    /* renamed from: n, reason: collision with root package name */
    public final l8.y f9610n;

    /* renamed from: o, reason: collision with root package name */
    public final r f9611o;

    /* renamed from: p, reason: collision with root package name */
    public final u9.h f9612p;

    /* renamed from: q, reason: collision with root package name */
    public final b0.e f9613q;

    public w(a3.b bVar, l8.y yVar, r rVar) {
        super(bVar, null);
        this.f9610n = yVar;
        this.f9611o = rVar;
        u9.n nVar = ((r8.a) bVar.f162f).f9002a;
        a8.e eVar = new a8.e(19, bVar, this);
        u9.k kVar = (u9.k) nVar;
        kVar.getClass();
        this.f9612p = new u9.h(kVar, eVar);
        this.f9613q = ((u9.k) nVar).c(new g1.y(23, this, bVar));
    }

    @Override // s8.a0, o9.o, o9.n
    public final Collection a(e9.f fVar, n8.c cVar) {
        q7.k.e(fVar, "name");
        return d7.z.f2978f;
    }

    @Override // o9.o, o9.q
    public final f8.g b(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        return v(fVar, null);
    }

    @Override // s8.a0, o9.o, o9.q
    public final Collection e(o9.f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        if (!fVar.a(o9.f.f7909l | o9.f.f7902e)) {
            return d7.z.f2978f;
        }
        Iterable iterable = (Iterable) this.f9520d.c();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            f8.j jVar = (f8.j) obj;
            if (jVar instanceof f8.e) {
                e9.f name = ((f8.e) jVar).getName();
                q7.k.d(name, "it.name");
                if (((Boolean) kVar.invoke(name)).booleanValue()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    @Override // s8.a0
    public final Set h(o9.f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        if (!fVar.a(o9.f.f7902e)) {
            return d7.b0.f2947f;
        }
        Set set = (Set) this.f9612p.c();
        if (set == null) {
            this.f9610n.getClass();
            return new LinkedHashSet();
        }
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(e9.f.e((String) it.next()));
        }
        return hashSet;
    }

    @Override // s8.a0
    public final Set i(o9.f fVar, o9.k kVar) {
        q7.k.e(fVar, "kindFilter");
        return d7.b0.f2947f;
    }

    @Override // s8.a0
    public final c k() {
        return b.f9529a;
    }

    @Override // s8.a0
    public final void m(LinkedHashSet linkedHashSet, e9.f fVar) {
        q7.k.e(fVar, "name");
    }

    @Override // s8.a0
    public final Set o(o9.f fVar) {
        q7.k.e(fVar, "kindFilter");
        return d7.b0.f2947f;
    }

    @Override // s8.a0
    public final f8.j q() {
        return this.f9611o;
    }

    public final f8.e v(e9.f fVar, l8.o oVar) {
        e9.f fVar2 = e9.h.f3200a;
        q7.k.e(fVar, "name");
        String strB = fVar.b();
        q7.k.d(strB, "name.asString()");
        if (strB.length() <= 0 || fVar.f3198g) {
            return null;
        }
        Set set = (Set) this.f9612p.c();
        if (oVar == null && set != null && !set.contains(fVar.b())) {
            return null;
        }
        return (f8.e) this.f9613q.invoke(new s(fVar, oVar));
    }
}
