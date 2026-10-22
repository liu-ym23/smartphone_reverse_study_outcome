package m0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import yb.j;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements List, zb.b {

    /* renamed from: c, reason: collision with root package name */
    public final Object f8153c;

    /* renamed from: f, reason: collision with root package name */
    public final int f8154f;

    /* renamed from: g, reason: collision with root package name */
    public int f8155g;

    public c(List list, int i, int i3) {
        this.f8153c = list;
        this.f8154f = i;
        this.f8155g = i3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final void add(int i, Object obj) {
        this.f8153c.add(i + this.f8154f, obj);
        this.f8155g++;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        this.f8153c.addAll(i + this.f8154f, collection);
        int size = collection.size();
        this.f8155g += size;
        return size > 0;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List, java.util.Collection
    public final void clear() {
        int i = this.f8155g - 1;
        int i3 = this.f8154f;
        if (i3 <= i) {
            while (true) {
                this.f8153c.remove(i);
                if (i == i3) {
                    break;
                } else {
                    i--;
                }
            }
        }
        this.f8155g = i3;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        int i = this.f8155g;
        for (int i3 = this.f8154f; i3 < i; i3++) {
            if (k.a(this.f8153c.get(i3), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final Object get(int i) {
        f.a(i, this);
        return this.f8153c.get(i + this.f8154f);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final int indexOf(Object obj) {
        int i = this.f8155g;
        int i3 = this.f8154f;
        for (int i10 = i3; i10 < i; i10++) {
            if (k.a(this.f8153c.get(i10), obj)) {
                return i10 - i3;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f8155g == this.f8154f;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new d(0, this);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        int i = this.f8155g - 1;
        int i3 = this.f8154f;
        if (i3 > i) {
            return -1;
        }
        while (!k.a(this.f8153c.get(i), obj)) {
            if (i == i3) {
                return -1;
            }
            i--;
        }
        return i - i3;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new d(0, this);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int i = this.f8155g;
        for (int i3 = this.f8154f; i3 < i; i3++) {
            ?? r22 = this.f8153c;
            if (k.a(r22.get(i3), obj)) {
                r22.remove(i3);
                this.f8155g--;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i = this.f8155g;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return i != this.f8155g;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i = this.f8155g;
        int i3 = i - 1;
        int i10 = this.f8154f;
        if (i10 <= i3) {
            while (true) {
                ?? r32 = this.f8153c;
                if (!collection.contains(r32.get(i3))) {
                    r32.remove(i3);
                    this.f8155g--;
                }
                if (i3 == i10) {
                    break;
                }
                i3--;
            }
        }
        return i != this.f8155g;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final Object set(int i, Object obj) {
        f.a(i, this);
        return this.f8153c.set(i + this.f8154f, obj);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f8155g - this.f8154f;
    }

    @Override // java.util.List
    public final List subList(int i, int i3) {
        f.b(this, i, i3);
        return new c(this, i, i3);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return j.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return j.b(this, objArr);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new d(i, this);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        int i = this.f8155g;
        this.f8155g = i + 1;
        this.f8153c.add(i, obj);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        this.f8153c.addAll(this.f8155g, collection);
        int size = collection.size();
        this.f8155g += size;
        return size > 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final Object remove(int i) {
        f.a(i, this);
        this.f8155g--;
        return this.f8153c.remove(i + this.f8154f);
    }
}
