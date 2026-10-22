package W3;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import k4.InterfaceC0814a;

/* renamed from: W3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0392c<E> extends AbstractC0391b<E> implements List<E>, InterfaceC0814a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5747a = new a(null);

    /* renamed from: W3.c$a */
    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        public final void a(int i5, int i6) {
            if (i5 < 0 || i5 >= i6) {
                throw new IndexOutOfBoundsException("index: " + i5 + ", size: " + i6);
            }
        }

        public final void b(int i5, int i6) {
            if (i5 < 0 || i5 > i6) {
                throw new IndexOutOfBoundsException("index: " + i5 + ", size: " + i6);
            }
        }

        public final void c(int i5, int i6, int i7) {
            if (i5 < 0 || i6 > i7) {
                throw new IndexOutOfBoundsException("fromIndex: " + i5 + ", toIndex: " + i6 + ", size: " + i7);
            }
            if (i5 <= i6) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i5 + " > toIndex: " + i6);
        }

        public final int d(int i5, int i6) {
            int i7 = i5 + (i5 >> 1);
            if (i7 - i6 < 0) {
                i7 = i6;
            }
            return i7 - 2147483639 > 0 ? i6 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i7;
        }

        public final boolean e(Collection<?> collection, Collection<?> collection2) {
            j4.k.g(collection, "c");
            j4.k.g(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!j4.k.b(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(Collection<?> collection) {
            j4.k.g(collection, "c");
            Iterator<?> it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        private a() {
        }
    }

    /* renamed from: W3.c$b */
    private class b implements Iterator<E>, InterfaceC0814a {

        /* renamed from: a, reason: collision with root package name */
        private int f5748a;

        public b() {
        }

        protected final int b() {
            return this.f5748a;
        }

        protected final void c(int i5) {
            this.f5748a = i5;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5748a < AbstractC0392c.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC0392c<E> abstractC0392c = AbstractC0392c.this;
            int i5 = this.f5748a;
            this.f5748a = i5 + 1;
            return abstractC0392c.get(i5);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: W3.c$c, reason: collision with other inner class name */
    private class C0086c extends AbstractC0392c<E>.b implements ListIterator<E>, InterfaceC0814a {
        public C0086c(int i5) {
            super();
            AbstractC0392c.f5747a.b(i5, AbstractC0392c.this.size());
            c(i5);
        }

        @Override // java.util.ListIterator
        public void add(E e6) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return b() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return b();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractC0392c<E> abstractC0392c = AbstractC0392c.this;
            c(b() - 1);
            return abstractC0392c.get(b());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return b() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e6) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: W3.c$d */
    private static final class d<E> extends AbstractC0392c<E> implements RandomAccess {

        /* renamed from: b, reason: collision with root package name */
        private final AbstractC0392c<E> f5751b;

        /* renamed from: c, reason: collision with root package name */
        private final int f5752c;

        /* renamed from: d, reason: collision with root package name */
        private int f5753d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(AbstractC0392c<? extends E> abstractC0392c, int i5, int i6) {
            j4.k.g(abstractC0392c, "list");
            this.f5751b = abstractC0392c;
            this.f5752c = i5;
            AbstractC0392c.f5747a.c(i5, i6, abstractC0392c.size());
            this.f5753d = i6 - i5;
        }

        @Override // W3.AbstractC0391b
        public int c() {
            return this.f5753d;
        }

        @Override // W3.AbstractC0392c, java.util.List
        public E get(int i5) {
            AbstractC0392c.f5747a.a(i5, this.f5753d);
            return this.f5751b.get(this.f5752c + i5);
        }

        @Override // W3.AbstractC0392c, java.util.List
        public List<E> subList(int i5, int i6) {
            AbstractC0392c.f5747a.c(i5, i6, this.f5753d);
            AbstractC0392c<E> abstractC0392c = this.f5751b;
            int i7 = this.f5752c;
            return new d(abstractC0392c, i5 + i7, i7 + i6);
        }
    }

    protected AbstractC0392c() {
    }

    @Override // java.util.List
    public void add(int i5, E e6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i5, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f5747a.e(this, (Collection) obj);
        }
        return false;
    }

    @Override // java.util.List
    public abstract E get(int i5);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f5747a.f(this);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (j4.k.b(it.next(), obj)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new b();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (j4.k.b(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new C0086c(0);
    }

    @Override // java.util.List
    public E remove(int i5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i5, E e6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i5, int i6) {
        return new d(this, i5, i6);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i5) {
        return new C0086c(i5);
    }
}
