package o9;

import f8.p0;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import v9.s0;
import v9.v0;

/* loaded from: classes.dex */
public final class t implements n {

    /* renamed from: b, reason: collision with root package name */
    public final n f7941b;

    /* renamed from: c, reason: collision with root package name */
    public final v0 f7942c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap f7943d;

    /* renamed from: e, reason: collision with root package name */
    public final c7.o f7944e;

    public t(n nVar, v0 v0Var) {
        q7.k.e(nVar, "workerScope");
        q7.k.e(v0Var, "givenSubstitutor");
        this.f7941b = nVar;
        s7.a.H(new a8.c(22, v0Var));
        s0 s0VarF = v0Var.f();
        q7.k.d(s0VarF, "givenSubstitutor.substitution");
        this.f7942c = new v0(a.a.p0(s0VarF));
        this.f7944e = s7.a.H(new a8.c(21, this));
    }

    @Override // o9.n
    public final Collection a(e9.f fVar, n8.c cVar) {
        q7.k.e(fVar, "name");
        return i(this.f7941b.a(fVar, cVar));
    }

    @Override // o9.q
    public final f8.g b(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        f8.g gVarB = this.f7941b.b(fVar, aVar);
        if (gVarB != null) {
            return (f8.g) h(gVarB);
        }
        return null;
    }

    @Override // o9.n
    public final Set c() {
        return this.f7941b.c();
    }

    @Override // o9.n
    public final Set d() {
        return this.f7941b.d();
    }

    @Override // o9.q
    public final Collection e(f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        return (Collection) this.f7944e.getValue();
    }

    @Override // o9.q
    public final Collection f(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        return i(this.f7941b.f(fVar, aVar));
    }

    @Override // o9.n
    public final Set g() {
        return this.f7941b.g();
    }

    public final f8.j h(f8.j jVar) {
        v0 v0Var = this.f7942c;
        if (v0Var.f10596a.e()) {
            return jVar;
        }
        if (this.f7943d == null) {
            this.f7943d = new HashMap();
        }
        HashMap map = this.f7943d;
        q7.k.b(map);
        Object objD = map.get(jVar);
        if (objD == null) {
            if (!(jVar instanceof p0)) {
                throw new IllegalStateException(("Unknown descriptor in scope: " + jVar).toString());
            }
            objD = ((p0) jVar).d(v0Var);
            if (objD == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + jVar + " substitution fails");
            }
            map.put(jVar, objD);
        }
        return (f8.j) objD;
    }

    public final Collection i(Collection collection) {
        if (this.f7942c.f10596a.e() || collection.isEmpty()) {
            return collection;
        }
        int size = collection.size();
        LinkedHashSet linkedHashSet = new LinkedHashSet(size >= 3 ? (size / 3) + size + 1 : 3);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(h((f8.j) it.next()));
        }
        return linkedHashSet;
    }
}
