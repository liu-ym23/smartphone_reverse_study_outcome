package r4;

import c5.m;
import c5.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g implements Set, q5.b {

    /* renamed from: a, reason: collision with root package name */
    public final Set f5098a;

    /* renamed from: b, reason: collision with root package name */
    public final p5.l f5099b;

    /* renamed from: c, reason: collision with root package name */
    public final p5.l f5100c;
    public final int d;

    public g(Set delegate, p5.l lVar, p5.l lVar2) {
        p.e(delegate, "delegate");
        this.f5098a = delegate;
        this.f5099b = lVar;
        this.f5100c = lVar2;
        this.d = delegate.size();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        return this.f5098a.add(this.f5100c.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection elements) {
        p.e(elements, "elements");
        return this.f5098a.addAll(f(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f5098a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5098a.contains(this.f5100c.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection elements) {
        p.e(elements, "elements");
        return this.f5098a.containsAll(f(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Set)) {
            return false;
        }
        ArrayList arrayListG = g(this.f5098a);
        return ((Set) obj).containsAll(arrayListG) && arrayListG.containsAll((Collection) obj);
    }

    public final ArrayList f(Collection collection) {
        ArrayList arrayList = new ArrayList(o.n0(collection, 10));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f5100c.invoke(it.next()));
        }
        return arrayList;
    }

    public final ArrayList g(Collection collection) {
        p.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(o.n0(collection, 10));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f5099b.invoke(it.next()));
        }
        return arrayList;
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        return this.f5098a.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f5098a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new f(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f5098a.remove(this.f5100c.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection elements) {
        p.e(elements, "elements");
        return this.f5098a.removeAll(m.R0(f(elements)));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection elements) {
        p.e(elements, "elements");
        return this.f5098a.retainAll(m.R0(f(elements)));
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.d;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return p.m(this);
    }

    public final String toString() {
        return g(this.f5098a).toString();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] array) {
        p.e(array, "array");
        return p.n(this, array);
    }
}
