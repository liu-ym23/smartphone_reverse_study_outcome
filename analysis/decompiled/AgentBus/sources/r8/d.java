package r8;

import c8.m;
import d7.n;
import d7.r;
import fa.l;
import fa.p;
import g8.i;
import g8.j;
import java.util.Iterator;
import q7.k;

/* loaded from: classes.dex */
public final class d implements j {

    /* renamed from: f, reason: collision with root package name */
    public final a3.b f9030f;

    /* renamed from: g, reason: collision with root package name */
    public final v8.b f9031g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f9032h;

    /* renamed from: i, reason: collision with root package name */
    public final b0.e f9033i;

    public d(a3.b bVar, v8.b bVar2, boolean z4) {
        k.e(bVar, "c");
        k.e(bVar2, "annotationOwner");
        this.f9030f = bVar;
        this.f9031g = bVar2;
        this.f9032h = z4;
        this.f9033i = ((u9.k) ((a) bVar.f162f).f9002a).c(new c(0, this));
    }

    @Override // g8.j
    public final g8.c b(e9.c cVar) {
        g8.c cVar2;
        k.e(cVar, "fqName");
        v8.b bVar = this.f9031g;
        l8.e eVarA = bVar.a(cVar);
        if (eVarA != null && (cVar2 = (g8.c) this.f9033i.invoke(eVarA)) != null) {
            return cVar2;
        }
        e9.f fVar = p8.c.f8508a;
        return p8.c.a(cVar, bVar, this.f9030f);
    }

    @Override // g8.j
    public final boolean g(e9.c cVar) {
        return i.hasAnnotation(this, cVar);
    }

    @Override // g8.j
    public final boolean isEmpty() {
        return this.f9031g.getAnnotations().isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        v8.b bVar = this.f9031g;
        p pVarT0 = l.t0(r.H0(bVar.getAnnotations()), this.f9033i);
        e9.f fVar = p8.c.f8508a;
        return new fa.e(new fa.f(l.r0(n.T(new fa.j[]{pVarT0, n.T(new Object[]{p8.c.a(m.f2042m, bVar, this.f9030f)})})), false, new c6.d(15)));
    }
}
