package ia;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: ia.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4191k extends AbstractList<String> implements RandomAccess, InterfaceC4185e {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC4185e f33125a;

    /* renamed from: ia.k$a */
    public class a implements ListIterator<String> {

        /* renamed from: a, reason: collision with root package name */
        public ListIterator<String> f33126a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f33127b;

        public a(int i10) {
            this.f33127b = i10;
            this.f33126a = C4191k.this.f33125a.listIterator(i10);
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f33126a.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return this.f33126a.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f33126a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f33126a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f33126a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f33126a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: ia.k$b */
    public class b implements Iterator<String> {

        /* renamed from: a, reason: collision with root package name */
        public Iterator<String> f33129a;

        public b() {
            this.f33129a = C4191k.this.f33125a.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f33129a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f33129a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public C4191k(InterfaceC4185e interfaceC4185e) {
        this.f33125a = interfaceC4185e;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        return this.f33125a.get(i10);
    }

    @Override // ia.InterfaceC4185e
    public AbstractC4182b getByteString(int i10) {
        return this.f33125a.getByteString(i10);
    }

    @Override // ia.InterfaceC4185e
    public List<?> getUnderlyingElements() {
        return this.f33125a.getUnderlyingElements();
    }

    @Override // ia.InterfaceC4185e
    public InterfaceC4185e getUnmodifiableView() {
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

    @Override // ia.InterfaceC4185e
    public void q(AbstractC4182b abstractC4182b) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f33125a.size();
    }
}
