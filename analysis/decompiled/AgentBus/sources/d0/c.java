package d0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import q7.j;
import q7.k;

/* loaded from: classes.dex */
public final class c implements List, r7.c {

    /* renamed from: f, reason: collision with root package name */
    public final Object f2744f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2745g;

    /* renamed from: h, reason: collision with root package name */
    public int f2746h;

    public c(List list, int i2, int i10) {
        this.f2744f = list;
        this.f2745g = i2;
        this.f2746h = i10;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        int i2 = this.f2746h;
        this.f2746h = i2 + 1;
        this.f2744f.add(i2, obj);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        this.f2744f.addAll(i2 + this.f2745g, collection);
        int size = collection.size();
        this.f2746h += size;
        return size > 0;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List, java.util.Collection
    public final void clear() {
        int i2 = this.f2746h - 1;
        int i10 = this.f2745g;
        if (i10 <= i2) {
            while (true) {
                this.f2744f.remove(i2);
                if (i2 == i10) {
                    break;
                } else {
                    i2--;
                }
            }
        }
        this.f2746h = i10;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        int i2 = this.f2746h;
        for (int i10 = this.f2745g; i10 < i2; i10++) {
            if (k.a(this.f2744f.get(i10), obj)) {
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
    public final Object get(int i2) {
        f.a(i2, this);
        return this.f2744f.get(i2 + this.f2745g);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final int indexOf(Object obj) {
        int i2 = this.f2746h;
        int i10 = this.f2745g;
        for (int i11 = i10; i11 < i2; i11++) {
            if (k.a(this.f2744f.get(i11), obj)) {
                return i11 - i10;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f2746h == this.f2745g;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new d(0, this);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        int i2 = this.f2746h - 1;
        int i10 = this.f2745g;
        if (i10 > i2) {
            return -1;
        }
        while (!k.a(this.f2744f.get(i2), obj)) {
            if (i2 == i10) {
                return -1;
            }
            i2--;
        }
        return i2 - i10;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new d(0, this);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int i2 = this.f2746h;
        for (int i10 = this.f2745g; i10 < i2; i10++) {
            ?? r22 = this.f2744f;
            if (k.a(r22.get(i10), obj)) {
                r22.remove(i10);
                this.f2746h--;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i2 = this.f2746h;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return i2 != this.f2746h;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i2 = this.f2746h;
        int i10 = i2 - 1;
        int i11 = this.f2745g;
        if (i11 <= i10) {
            while (true) {
                ?? r32 = this.f2744f;
                if (!collection.contains(r32.get(i10))) {
                    r32.remove(i10);
                    this.f2746h--;
                }
                if (i10 == i11) {
                    break;
                }
                i10--;
            }
        }
        return i2 != this.f2746h;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final Object set(int i2, Object obj) {
        f.a(i2, this);
        return this.f2744f.set(i2 + this.f2745g, obj);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f2746h - this.f2745g;
    }

    @Override // java.util.List
    public final List subList(int i2, int i10) {
        f.b(this, i2, i10);
        return new c(this, i2, i10);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return j.a(this);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final void add(int i2, Object obj) {
        this.f2744f.add(i2 + this.f2745g, obj);
        this.f2746h++;
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i2) {
        return new d(i2, this);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return j.b(this, objArr);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        this.f2744f.addAll(this.f2746h, collection);
        int size = collection.size();
        this.f2746h += size;
        return size > 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.List
    public final Object remove(int i2) {
        f.a(i2, this);
        this.f2746h--;
        return this.f2744f.remove(i2 + this.f2745g);
    }
}
