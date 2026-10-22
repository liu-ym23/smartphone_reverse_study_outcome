package H9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p9.InterfaceC5074l;

/* renamed from: H9.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0833l implements E9.K {

    /* renamed from: a, reason: collision with root package name */
    public final List<E9.F> f3139a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3140b;

    /* JADX WARN: Multi-variable type inference failed */
    public C0833l(List<? extends E9.F> providers, String debugName) {
        kotlin.jvm.internal.p.i(providers, "providers");
        kotlin.jvm.internal.p.i(debugName, "debugName");
        this.f3139a = providers;
        this.f3140b = debugName;
        providers.size();
        Z8.F.r1(providers).size();
    }

    @Override // E9.K
    public void a(ga.c fqName, Collection<E9.E> packageFragments) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(packageFragments, "packageFragments");
        Iterator<E9.F> it = this.f3139a.iterator();
        while (it.hasNext()) {
            E9.J.a(it.next(), fqName, packageFragments);
        }
    }

    @Override // E9.F
    public List<E9.E> b(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator<E9.F> it = this.f3139a.iterator();
        while (it.hasNext()) {
            E9.J.a(it.next(), fqName, arrayList);
        }
        return Z8.F.m1(arrayList);
    }

    @Override // E9.K
    public boolean c(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        List<E9.F> list = this.f3139a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!E9.J.b((E9.F) it.next(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // E9.F
    public Collection<ga.c> k(ga.c fqName, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator<E9.F> it = this.f3139a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().k(fqName, nameFilter));
        }
        return hashSet;
    }

    public String toString() {
        return this.f3140b;
    }
}
