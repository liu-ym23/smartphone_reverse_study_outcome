package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f1 extends AbstractList<String> implements y, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final x f1809a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ListIterator<String> {

        /* renamed from: a, reason: collision with root package name */
        public ListIterator<String> f1810a;

        @Override // java.util.ListIterator
        public final void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f1810a.hasNext();
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f1810a.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            return this.f1810a.next();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f1810a.nextIndex();
        }

        @Override // java.util.ListIterator
        public final String previous() {
            return this.f1810a.previous();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f1810a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public final void set(String str) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Iterator<String> {

        /* renamed from: a, reason: collision with root package name */
        public Iterator<String> f1811a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f1811a.hasNext();
        }

        @Override // java.util.Iterator
        public final String next() {
            return this.f1811a.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public f1(x xVar) {
        this.f1809a = xVar;
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final List<?> C() {
        return Collections.unmodifiableList(this.f1809a.f1898b);
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final Object C0(int i10) {
        return this.f1809a.f1898b.get(i10);
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final void g0(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        return (String) this.f1809a.get(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        b bVar = new b();
        bVar.f1811a = this.f1809a.iterator();
        return bVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i10) {
        a aVar = new a();
        aVar.f1810a = this.f1809a.listIterator(i10);
        return aVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1809a.size();
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final y x0() {
        return this;
    }
}
