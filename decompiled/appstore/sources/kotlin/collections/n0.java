package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: loaded from: classes4.dex */
public final class n0 extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f21101a;

    public static final class a implements ListIterator, KMutableListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListIterator f21102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n0 f21103b;

        public a(n0 r10, int r11) {
            this.f21103b = r10;
            this.f21102a = n0.a(r10).listIterator(z.I(r10, r11));
        }

        @Override // java.util.ListIterator
        public void add(Object r10) {
            this.f21102a.add(r10);
            this.f21102a.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f21102a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f21102a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            return this.f21102a.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return z.H(this.f21103b, this.f21102a.previousIndex());
        }

        @Override // java.util.ListIterator
        public Object previous() {
            return this.f21102a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return z.H(this.f21103b, this.f21102a.nextIndex());
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.f21102a.remove();
        }

        @Override // java.util.ListIterator
        public void set(Object r10) {
            this.f21102a.set(r10);
        }
    }

    public n0(List r10) {
        kotlin.jvm.internal.q.g(r10, "delegate");
        this.f21101a = r10;
    }

    public static final /* synthetic */ List a(n0 r10) {
        return r10.f21101a;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r10, Object r11) {
        this.f21101a.add(z.I(this, r10), r11);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f21101a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int r10) {
        return this.f21101a.get(z.G(this, r10));
    }

    @Override // kotlin.collections.e
    public int getSize() {
        return this.f21101a.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.e
    public Object removeAt(int r10) {
        return this.f21101a.remove(z.G(this, r10));
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int r10, Object r11) {
        return this.f21101a.set(z.G(this, r10), r11);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int r10) {
        return new a(this, r10);
    }
}
