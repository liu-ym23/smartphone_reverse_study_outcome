package w5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kb.j;
import kb.p;
import od.g0;
import od.i0;
import od.n;
import od.o;
import od.u;
import od.z;
import yb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends o {

    /* renamed from: b, reason: collision with root package name */
    public o f15245b;

    @Override // od.o
    public final g0 a(z zVar) {
        zVar.getClass();
        return this.f15245b.a(zVar);
    }

    @Override // od.o
    public final void b(z zVar, z zVar2) {
        zVar.getClass();
        zVar2.getClass();
        this.f15245b.b(zVar, zVar2);
    }

    @Override // od.o
    public final void c(z zVar) {
        this.f15245b.c(zVar);
    }

    @Override // od.o
    public final void d(z zVar) {
        zVar.getClass();
        this.f15245b.d(zVar);
    }

    @Override // od.o
    public final List g(z zVar) {
        zVar.getClass();
        List<z> listG = this.f15245b.g(zVar);
        ArrayList arrayList = new ArrayList();
        for (z zVar2 : listG) {
            zVar2.getClass();
            arrayList.add(zVar2);
        }
        p.n0(arrayList);
        return arrayList;
    }

    @Override // od.o
    public final n i(z zVar) {
        zVar.getClass();
        n nVarI = this.f15245b.i(zVar);
        if (nVarI == null) {
            return null;
        }
        z zVar2 = (z) nVarI.f9473d;
        if (zVar2 == null) {
            return nVarI;
        }
        boolean z10 = nVarI.f9471b;
        boolean z11 = nVarI.f9472c;
        Long l2 = (Long) nVarI.f9474e;
        Long l10 = (Long) nVarI.f9475f;
        Long l11 = (Long) nVarI.f9476g;
        Long l12 = (Long) nVarI.f9477h;
        Map map = (Map) nVarI.i;
        map.getClass();
        return new n(z10, z11, zVar2, l2, l10, l11, l12, map);
    }

    @Override // od.o
    public final u j(z zVar) {
        zVar.getClass();
        return this.f15245b.j(zVar);
    }

    @Override // od.o
    public final g0 k(z zVar) {
        o oVar = this.f15245b;
        z zVarB = zVar.b();
        if (zVarB != null) {
            j jVar = new j();
            while (zVarB != null && !f(zVarB)) {
                jVar.addFirst(zVarB);
                zVarB = zVarB.b();
            }
            Iterator<E> it = jVar.iterator();
            while (it.hasNext()) {
                z zVar2 = (z) it.next();
                zVar2.getClass();
                oVar.c(zVar2);
            }
        }
        return oVar.k(zVar);
    }

    @Override // od.o
    public final i0 l(z zVar) {
        zVar.getClass();
        return this.f15245b.l(zVar);
    }

    public final String toString() {
        return v.a(d.class).c() + '(' + this.f15245b + ')';
    }
}
