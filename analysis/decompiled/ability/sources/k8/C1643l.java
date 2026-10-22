package k8;

import h8.AbstractC1538u;
import h8.InterfaceC1497E;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: k8.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1643l implements InterfaceC1497E {

    /* renamed from: a, reason: collision with root package name */
    public final List f4849a;
    public final String b;

    public C1643l(List providers, String debugName) {
        kotlin.jvm.internal.k.f(providers, "providers");
        kotlin.jvm.internal.k.f(debugName, "debugName");
        this.f4849a = providers;
        this.b = debugName;
        providers.size();
        D7.v.j1(providers).size();
    }

    @Override // h8.InterfaceC1497E
    public final void a(G8.c fqName, ArrayList arrayList) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        Iterator it = this.f4849a.iterator();
        while (it.hasNext()) {
            AbstractC1538u.b((InterfaceC1497E) it.next(), fqName, arrayList);
        }
    }

    @Override // h8.InterfaceC1497E
    public final boolean b(G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        List list = this.f4849a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!AbstractC1538u.e((InterfaceC1497E) it.next(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // h8.InterfaceC1497E
    public final Collection f(G8.c fqName, S7.k kVar) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        HashSet hashSet = new HashSet();
        Iterator it = this.f4849a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(((InterfaceC1497E) it.next()).f(fqName, kVar));
        }
        return hashSet;
    }

    public final String toString() {
        return this.b;
    }
}
