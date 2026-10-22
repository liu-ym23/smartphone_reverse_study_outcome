package d0;

import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class d implements ListIterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final Object f2747f;

    /* renamed from: g, reason: collision with root package name */
    public int f2748g;

    public d(int i2, List list) {
        this.f2747f = list;
        this.f2748g = i2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.ListIterator
    public final void add(Object obj) {
        this.f2747f.add(this.f2748g, obj);
        this.f2748g++;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f2748g < this.f2747f.size();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f2748g > 0;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        int i2 = this.f2748g;
        this.f2748g = i2 + 1;
        return this.f2747f.get(i2);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f2748g;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.ListIterator
    public final Object previous() {
        int i2 = this.f2748g - 1;
        this.f2748g = i2;
        return this.f2747f.get(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f2748g - 1;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i2 = this.f2748g - 1;
        this.f2748g = i2;
        this.f2747f.remove(i2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    @Override // java.util.ListIterator
    public final void set(Object obj) {
        this.f2747f.set(this.f2748g, obj);
    }
}
