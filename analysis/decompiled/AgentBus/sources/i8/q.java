package i8;

import b0.r1;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class q extends o9.o {

    /* renamed from: b, reason: collision with root package name */
    public final u9.e f4836b;

    /* renamed from: c, reason: collision with root package name */
    public final u9.e f4837c;

    /* renamed from: d, reason: collision with root package name */
    public final u9.i f4838d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ r f4839e;

    public q(r rVar, u9.n nVar) {
        if (nVar == null) {
            h(0);
            throw null;
        }
        this.f4839e = rVar;
        u9.k kVar = (u9.k) nVar;
        this.f4836b = kVar.b(new o(this, 0));
        this.f4837c = kVar.b(new o(this, 1));
        this.f4838d = new u9.i(kVar, new r1(2, this));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void h(int r13) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.q.h(int):void");
    }

    @Override // o9.o, o9.n
    public final Collection a(e9.f fVar, n8.c cVar) {
        if (fVar != null) {
            return (Collection) this.f4837c.invoke(fVar);
        }
        h(1);
        throw null;
    }

    @Override // o9.o, o9.n
    public final Set c() {
        Set set = (Set) this.f4839e.f4843n.c();
        if (set != null) {
            return set;
        }
        h(17);
        throw null;
    }

    @Override // o9.o, o9.n
    public final Set d() {
        Set set = (Set) this.f4839e.f4843n.c();
        if (set != null) {
            return set;
        }
        h(19);
        throw null;
    }

    @Override // o9.o, o9.q
    public final Collection e(o9.f fVar, p7.k kVar) {
        if (fVar == null) {
            h(13);
            throw null;
        }
        if (kVar == null) {
            h(14);
            throw null;
        }
        Collection collection = (Collection) this.f4838d.c();
        if (collection != null) {
            return collection;
        }
        h(15);
        throw null;
    }

    @Override // o9.o, o9.q
    public final Collection f(e9.f fVar, n8.a aVar) {
        if (fVar != null) {
            return (Collection) this.f4836b.invoke(fVar);
        }
        h(5);
        throw null;
    }

    @Override // o9.o, o9.n
    public final Set g() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        h(18);
        throw null;
    }

    public final o9.n i() {
        o9.n nVarV0 = ((v9.v) ((v9.f) this.f4839e.h()).d().iterator().next()).v0();
        if (nVarV0 != null) {
            return nVarV0;
        }
        h(9);
        throw null;
    }

    public final LinkedHashSet j(e9.f fVar, Collection collection) {
        if (fVar == null) {
            h(10);
            throw null;
        }
        if (collection == null) {
            h(11);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        h9.l.f4243c.h(fVar, collection, Collections.EMPTY_SET, this.f4839e, new p(linkedHashSet, 0));
        return linkedHashSet;
    }
}
