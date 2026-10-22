package E9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final class I implements K {

    /* renamed from: a, reason: collision with root package name */
    public final Collection<E> f2431a;

    /* JADX WARN: Multi-variable type inference failed */
    public I(Collection<? extends E> packageFragments) {
        kotlin.jvm.internal.p.i(packageFragments, "packageFragments");
        this.f2431a = packageFragments;
    }

    public static final ga.c f(E it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.f();
    }

    public static final boolean g(ga.c cVar, ga.c it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !it.c() && kotlin.jvm.internal.p.d(it.d(), cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // E9.K
    public void a(ga.c fqName, Collection<E> packageFragments) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(packageFragments, "packageFragments");
        for (Object obj : this.f2431a) {
            if (kotlin.jvm.internal.p.d(((E) obj).f(), fqName)) {
                packageFragments.add(obj);
            }
        }
    }

    @Override // E9.F
    public List<E> b(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        Collection<E> collection = this.f2431a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (kotlin.jvm.internal.p.d(((E) obj).f(), fqName)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // E9.K
    public boolean c(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        Collection<E> collection = this.f2431a;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.p.d(((E) it.next()).f(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // E9.F
    public Collection<ga.c> k(ga.c fqName, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        return SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(Z8.F.d0(this.f2431a), G.f2429a), new H(fqName)));
    }
}
