package k8;

import X8.AbstractC0275f;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* renamed from: k8.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1647p extends Q8.p {
    public final W8.e b;
    public final W8.e c;
    public final W8.h d;
    public final /* synthetic */ C1648q e;

    public C1647p(C1648q c1648q, W8.l lVar) {
        if (lVar == null) {
            g(0);
            throw null;
        }
        this.e = c1648q;
        W8.i iVar = (W8.i) lVar;
        this.b = iVar.c(new C1646o(this, 0));
        this.c = iVar.c(new C1646o(this, 1));
        this.d = new W8.h(iVar, new I8.e(this, 24));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void g(int r13) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.C1647p.g(int):void");
    }

    @Override // Q8.p, Q8.o
    public final Set a() {
        Set set = (Set) this.e.i.invoke();
        if (set != null) {
            return set;
        }
        g(17);
        throw null;
    }

    @Override // Q8.p, Q8.q
    public final Collection c(Q8.f fVar, S7.k kVar) {
        if (fVar == null) {
            g(13);
            throw null;
        }
        Collection collection = (Collection) this.d.invoke();
        if (collection != null) {
            return collection;
        }
        g(15);
        throw null;
    }

    @Override // Q8.p, Q8.o
    public final Collection d(G8.f fVar, NoLookupLocation noLookupLocation) {
        if (fVar != null) {
            return (Collection) this.c.invoke(fVar);
        }
        g(1);
        throw null;
    }

    @Override // Q8.p, Q8.o
    public final Set e() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        g(18);
        throw null;
    }

    @Override // Q8.p, Q8.o
    public final Collection f(G8.f fVar, p8.a aVar) {
        if (fVar != null) {
            return (Collection) this.b.invoke(fVar);
        }
        g(5);
        throw null;
    }

    @Override // Q8.p, Q8.o
    public final Set getVariableNames() {
        Set set = (Set) this.e.i.invoke();
        if (set != null) {
            return set;
        }
        g(19);
        throw null;
    }

    public final Q8.o h() {
        Q8.o oVarW = ((X8.w) ((AbstractC0275f) this.e.m()).e().iterator().next()).w();
        if (oVarW != null) {
            return oVarW;
        }
        g(9);
        throw null;
    }

    public final LinkedHashSet i(G8.f fVar, Collection collection) {
        if (fVar == null) {
            g(10);
            throw null;
        }
        if (collection == null) {
            g(11);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        J8.k.c.h(fVar, collection, Collections.EMPTY_SET, this.e, new V8.g(linkedHashSet, 1));
        return linkedHashSet;
    }
}
