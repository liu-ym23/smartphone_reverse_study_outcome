package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public class r0 extends AbstractList<String> implements G, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final G f10113a;

    class a implements ListIterator<String> {

        /* renamed from: a, reason: collision with root package name */
        ListIterator<String> f10114a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f10115b;

        a(int i5) {
            this.f10115b = i5;
            this.f10114a = r0.this.f10113a.listIterator(i5);
        }

        @Override // java.util.ListIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f10114a.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return this.f10114a.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f10114a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f10114a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f10114a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f10114a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    class b implements Iterator<String> {

        /* renamed from: a, reason: collision with root package name */
        Iterator<String> f10117a;

        b() {
            this.f10117a = r0.this.f10113a.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f10117a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10117a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public r0(G g5) {
        this.f10113a = g5;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get(int i5) {
        return (String) this.f10113a.get(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.G
    public void e(AbstractC0488h abstractC0488h) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.datastore.preferences.protobuf.G
    public List<?> g() {
        return this.f10113a.g();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // androidx.datastore.preferences.protobuf.G
    public G j() {
        return this;
    }

    @Override // androidx.datastore.preferences.protobuf.G
    public Object k(int i5) {
        return this.f10113a.k(i5);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i5) {
        return new a(i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10113a.size();
    }
}
