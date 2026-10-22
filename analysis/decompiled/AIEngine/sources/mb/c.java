package mb;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class c<E> extends mb.a<E> implements List<E> {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static void a(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                StringBuilder sbD = h0.e.d(i10, "startIndex: ", i11, ", endIndex: ", ", size: ");
                sbD.append(i12);
                throw new IndexOutOfBoundsException(sbD.toString());
            }
            if (i10 > i11) {
                throw new IllegalArgumentException(a0.a.f("startIndex: ", i10, i11, " > endIndex: "));
            }
        }

        public static void b(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                StringBuilder sbD = h0.e.d(i10, "fromIndex: ", i11, ", toIndex: ", ", size: ");
                sbD.append(i12);
                throw new IndexOutOfBoundsException(sbD.toString());
            }
            if (i10 > i11) {
                throw new IllegalArgumentException(a0.a.f("fromIndex: ", i10, i11, " > toIndex: "));
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Iterator<E>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public int f10547a;

        public b() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f10547a < c.this.a();
        }

        @Override // java.util.Iterator
        public final E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.f10547a;
            this.f10547a = i10 + 1;
            return c.this.get(i10);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: mb.c$c, reason: collision with other inner class name */
    public class C0110c extends c<E>.b implements ListIterator<E> {
        public C0110c(int i10) {
            super();
            int iA = c.this.a();
            if (i10 < 0 || i10 > iA) {
                throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, iA, ", size: "));
            }
            this.f10547a = i10;
        }

        @Override // java.util.ListIterator
        public final void add(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f10547a > 0;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f10547a;
        }

        @Override // java.util.ListIterator
        public final E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            int i10 = this.f10547a - 1;
            this.f10547a = i10;
            return c.this.get(i10);
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f10547a - 1;
        }

        @Override // java.util.ListIterator
        public final void set(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d<E> extends c<E> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        public final c<E> f10550a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10551b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10552c;

        /* JADX WARN: Multi-variable type inference failed */
        public d(c<? extends E> cVar, int i10, int i11) {
            this.f10550a = cVar;
            this.f10551b = i10;
            a.b(i10, i11, cVar.a());
            this.f10552c = i11 - i10;
        }

        @Override // mb.a
        public final int a() {
            return this.f10552c;
        }

        @Override // java.util.List
        public final E get(int i10) {
            int i11 = this.f10552c;
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
            }
            return this.f10550a.get(this.f10551b + i10);
        }
    }

    @Override // java.util.List
    public final void add(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        if (size() == collection.size()) {
            Iterator<E> it = collection.iterator();
            Iterator<E> it2 = iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.g.b(it2.next(), it.next())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        Iterator<E> it = iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            E next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }

    public int indexOf(E e10) {
        Iterator<E> it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.g.b(it.next(), e10)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(E e10) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.g.b(listIterator.previous(), e10)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new C0110c(0);
    }

    @Override // java.util.List
    public final E remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final E set(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return new C0110c(i10);
    }
}
