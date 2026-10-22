package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public class i0 extends AbstractList<String> implements A, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final A f13582a;

    public class a implements ListIterator<String> {

        /* renamed from: a, reason: collision with root package name */
        public ListIterator<String> f13583a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13584b;

        public a(int i10) {
            this.f13584b = i10;
            this.f13583a = i0.this.f13582a.listIterator(i10);
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f13583a.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return this.f13583a.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f13583a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f13583a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f13583a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f13583a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class b implements Iterator<String> {

        /* renamed from: a, reason: collision with root package name */
        public Iterator<String> f13586a;

        public b() {
            this.f13586a = i0.this.f13582a.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f13586a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13586a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public i0(A a10) {
        this.f13582a = a10;
    }

    @Override // androidx.datastore.preferences.protobuf.A
    public void F(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        return (String) this.f13582a.get(i10);
    }

    @Override // androidx.datastore.preferences.protobuf.A
    public Object getRaw(int i10) {
        return this.f13582a.getRaw(i10);
    }

    @Override // androidx.datastore.preferences.protobuf.A
    public List<?> getUnderlyingElements() {
        return this.f13582a.getUnderlyingElements();
    }

    @Override // androidx.datastore.preferences.protobuf.A
    public A getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i10) {
        return new a(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f13582a.size();
    }
}
