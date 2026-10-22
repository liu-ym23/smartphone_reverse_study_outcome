package kotlin.collections.builders;

import androidx.datastore.preferences.protobuf.b1;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.g;
import mb.c;
import mb.f;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ListBuilder<E> extends f<E> implements List<E>, RandomAccess, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final ListBuilder f10009d;

    /* renamed from: a, reason: collision with root package name */
    public E[] f10010a;

    /* renamed from: b, reason: collision with root package name */
    public int f10011b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10012c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class BuilderSubList<E> extends f<E> implements List<E>, RandomAccess, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public E[] f10013a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10014b;

        /* renamed from: c, reason: collision with root package name */
        public int f10015c;

        /* renamed from: d, reason: collision with root package name */
        public final BuilderSubList<E> f10016d;

        /* renamed from: e, reason: collision with root package name */
        public final ListBuilder<E> f10017e;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class a<E> implements ListIterator<E>, ac.a {

            /* renamed from: a, reason: collision with root package name */
            public final BuilderSubList<E> f10018a;

            /* renamed from: b, reason: collision with root package name */
            public int f10019b;

            /* renamed from: c, reason: collision with root package name */
            public int f10020c = -1;

            /* renamed from: d, reason: collision with root package name */
            public int f10021d;

            public a(BuilderSubList<E> builderSubList, int i10) {
                this.f10018a = builderSubList;
                this.f10019b = i10;
                this.f10021d = ((AbstractList) builderSubList).modCount;
            }

            public final void a() {
                if (((AbstractList) this.f10018a.f10017e).modCount != this.f10021d) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator
            public final void add(E e10) {
                a();
                int i10 = this.f10019b;
                this.f10019b = i10 + 1;
                BuilderSubList<E> builderSubList = this.f10018a;
                builderSubList.add(i10, e10);
                this.f10020c = -1;
                this.f10021d = ((AbstractList) builderSubList).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public final boolean hasNext() {
                return this.f10019b < this.f10018a.f10015c;
            }

            @Override // java.util.ListIterator
            public final boolean hasPrevious() {
                return this.f10019b > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public final E next() {
                a();
                int i10 = this.f10019b;
                BuilderSubList<E> builderSubList = this.f10018a;
                if (i10 >= builderSubList.f10015c) {
                    throw new NoSuchElementException();
                }
                this.f10019b = i10 + 1;
                this.f10020c = i10;
                return builderSubList.f10013a[builderSubList.f10014b + i10];
            }

            @Override // java.util.ListIterator
            public final int nextIndex() {
                return this.f10019b;
            }

            @Override // java.util.ListIterator
            public final E previous() {
                a();
                int i10 = this.f10019b;
                if (i10 <= 0) {
                    throw new NoSuchElementException();
                }
                int i11 = i10 - 1;
                this.f10019b = i11;
                this.f10020c = i11;
                BuilderSubList<E> builderSubList = this.f10018a;
                return builderSubList.f10013a[builderSubList.f10014b + i11];
            }

            @Override // java.util.ListIterator
            public final int previousIndex() {
                return this.f10019b - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public final void remove() {
                a();
                int i10 = this.f10020c;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                BuilderSubList<E> builderSubList = this.f10018a;
                builderSubList.b(i10);
                this.f10019b = this.f10020c;
                this.f10020c = -1;
                this.f10021d = ((AbstractList) builderSubList).modCount;
            }

            @Override // java.util.ListIterator
            public final void set(E e10) {
                a();
                int i10 = this.f10020c;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                this.f10018a.set(i10, e10);
            }
        }

        public BuilderSubList(E[] backing, int i10, int i11, BuilderSubList<E> builderSubList, ListBuilder<E> root) {
            g.f(backing, "backing");
            g.f(root, "root");
            this.f10013a = backing;
            this.f10014b = i10;
            this.f10015c = i11;
            this.f10016d = builderSubList;
            this.f10017e = root;
            ((AbstractList) this).modCount = ((AbstractList) root).modCount;
        }

        private final Object writeReplace() throws NotSerializableException {
            if (this.f10017e.f10012c) {
                return new SerializedCollection(0, this);
            }
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        @Override // mb.f
        public final int a() {
            g();
            return this.f10015c;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean add(E e10) {
            h();
            g();
            f(this.f10014b + this.f10015c, e10);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean addAll(Collection<? extends E> elements) {
            g.f(elements, "elements");
            h();
            g();
            int size = elements.size();
            e(elements, this.f10014b + this.f10015c, size);
            return size > 0;
        }

        @Override // mb.f
        public final E b(int i10) {
            h();
            g();
            int i11 = this.f10015c;
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
            }
            return i(this.f10014b + i10);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final void clear() {
            h();
            g();
            j(this.f10014b, this.f10015c);
        }

        public final void e(Collection collection, int i10, int i11) {
            ((AbstractList) this).modCount++;
            ListBuilder<E> listBuilder = this.f10017e;
            BuilderSubList<E> builderSubList = this.f10016d;
            if (builderSubList != null) {
                builderSubList.e(collection, i10, i11);
            } else {
                ListBuilder listBuilder2 = ListBuilder.f10009d;
                listBuilder.e(collection, i10, i11);
            }
            this.f10013a = listBuilder.f10010a;
            this.f10015c += i11;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final boolean equals(Object obj) {
            g();
            if (obj == this) {
                return true;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                E[] eArr = this.f10013a;
                int i10 = this.f10015c;
                if (i10 == list.size()) {
                    for (int i11 = 0; i11 < i10; i11++) {
                        if (g.b(eArr[this.f10014b + i11], list.get(i11))) {
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public final void f(int i10, E e10) {
            ((AbstractList) this).modCount++;
            ListBuilder<E> listBuilder = this.f10017e;
            BuilderSubList<E> builderSubList = this.f10016d;
            if (builderSubList != null) {
                builderSubList.f(i10, e10);
            } else {
                ListBuilder listBuilder2 = ListBuilder.f10009d;
                listBuilder.f(i10, e10);
            }
            this.f10013a = listBuilder.f10010a;
            this.f10015c++;
        }

        public final void g() {
            if (((AbstractList) this.f10017e).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public final E get(int i10) {
            g();
            int i11 = this.f10015c;
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
            }
            return this.f10013a[this.f10014b + i10];
        }

        public final void h() {
            if (this.f10017e.f10012c) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final int hashCode() {
            g();
            E[] eArr = this.f10013a;
            int i10 = this.f10015c;
            int iHashCode = 1;
            for (int i11 = 0; i11 < i10; i11++) {
                E e10 = eArr[this.f10014b + i11];
                iHashCode = (iHashCode * 31) + (e10 != null ? e10.hashCode() : 0);
            }
            return iHashCode;
        }

        public final E i(int i10) {
            E eI;
            ((AbstractList) this).modCount++;
            BuilderSubList<E> builderSubList = this.f10016d;
            if (builderSubList != null) {
                eI = builderSubList.i(i10);
            } else {
                ListBuilder listBuilder = ListBuilder.f10009d;
                eI = this.f10017e.i(i10);
            }
            this.f10015c--;
            return eI;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int indexOf(Object obj) {
            g();
            for (int i10 = 0; i10 < this.f10015c; i10++) {
                if (g.b(this.f10013a[this.f10014b + i10], obj)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean isEmpty() {
            g();
            return this.f10015c == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public final Iterator<E> iterator() {
            return listIterator(0);
        }

        public final void j(int i10, int i11) {
            if (i11 > 0) {
                ((AbstractList) this).modCount++;
            }
            BuilderSubList<E> builderSubList = this.f10016d;
            if (builderSubList != null) {
                builderSubList.j(i10, i11);
            } else {
                ListBuilder listBuilder = ListBuilder.f10009d;
                this.f10017e.j(i10, i11);
            }
            this.f10015c -= i11;
        }

        public final int k(int i10, int i11, Collection<? extends E> collection, boolean z) {
            int iK;
            BuilderSubList<E> builderSubList = this.f10016d;
            if (builderSubList != null) {
                iK = builderSubList.k(i10, i11, collection, z);
            } else {
                ListBuilder listBuilder = ListBuilder.f10009d;
                iK = this.f10017e.k(i10, i11, collection, z);
            }
            if (iK > 0) {
                ((AbstractList) this).modCount++;
            }
            this.f10015c -= iK;
            return iK;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int lastIndexOf(Object obj) {
            g();
            for (int i10 = this.f10015c - 1; i10 >= 0; i10--) {
                if (g.b(this.f10013a[this.f10014b + i10], obj)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public final ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean remove(Object obj) {
            h();
            g();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                b(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean removeAll(Collection<? extends Object> elements) {
            g.f(elements, "elements");
            h();
            g();
            return k(this.f10014b, this.f10015c, elements, false) > 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean retainAll(Collection<? extends Object> elements) {
            g.f(elements, "elements");
            h();
            g();
            return k(this.f10014b, this.f10015c, elements, true) > 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public final E set(int i10, E e10) {
            h();
            g();
            int i11 = this.f10015c;
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
            }
            E[] eArr = this.f10013a;
            int i12 = this.f10014b;
            E e11 = eArr[i12 + i10];
            eArr[i12 + i10] = e10;
            return e11;
        }

        @Override // java.util.AbstractList, java.util.List
        public final List<E> subList(int i10, int i11) {
            c.a.b(i10, i11, this.f10015c);
            return new BuilderSubList(this.f10013a, this.f10014b + i10, i11 - i10, this, this.f10017e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final <T> T[] toArray(T[] array) {
            g.f(array, "array");
            g();
            int length = array.length;
            int i10 = this.f10015c;
            int i11 = this.f10014b;
            if (length < i10) {
                T[] tArr = (T[]) Arrays.copyOfRange(this.f10013a, i11, i10 + i11, array.getClass());
                g.e(tArr, "copyOfRange(...)");
                return tArr;
            }
            b1.q(this.f10013a, array, 0, i11, i10 + i11);
            int i12 = this.f10015c;
            if (i12 < array.length) {
                array[i12] = null;
            }
            return array;
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            g();
            return y.i(this.f10013a, this.f10014b, this.f10015c, this);
        }

        @Override // java.util.AbstractList, java.util.List
        public final ListIterator<E> listIterator(int i10) {
            g();
            int i11 = this.f10015c;
            if (i10 < 0 || i10 > i11) {
                throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
            }
            return new a(this, i10);
        }

        @Override // java.util.AbstractList, java.util.List
        public final void add(int i10, E e10) {
            h();
            g();
            int i11 = this.f10015c;
            if (i10 >= 0 && i10 <= i11) {
                f(this.f10014b + i10, e10);
                return;
            }
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
        }

        @Override // java.util.AbstractList, java.util.List
        public final boolean addAll(int i10, Collection<? extends E> elements) {
            g.f(elements, "elements");
            h();
            g();
            int i11 = this.f10015c;
            if (i10 >= 0 && i10 <= i11) {
                int size = elements.size();
                e(elements, this.f10014b + i10, size);
                return size > 0;
            }
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final Object[] toArray() {
            g();
            E[] eArr = this.f10013a;
            int i10 = this.f10015c;
            int i11 = this.f10014b;
            return b1.v(eArr, i11, i10 + i11);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<E> implements ListIterator<E>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public final ListBuilder<E> f10022a;

        /* renamed from: b, reason: collision with root package name */
        public int f10023b;

        /* renamed from: c, reason: collision with root package name */
        public int f10024c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f10025d;

        public a(ListBuilder<E> listBuilder, int i10) {
            this.f10022a = listBuilder;
            this.f10023b = i10;
            this.f10025d = ((AbstractList) listBuilder).modCount;
        }

        public final void a() {
            if (((AbstractList) this.f10022a).modCount != this.f10025d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public final void add(E e10) {
            a();
            int i10 = this.f10023b;
            this.f10023b = i10 + 1;
            ListBuilder<E> listBuilder = this.f10022a;
            listBuilder.add(i10, e10);
            this.f10024c = -1;
            this.f10025d = ((AbstractList) listBuilder).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f10023b < this.f10022a.f10011b;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f10023b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final E next() {
            a();
            int i10 = this.f10023b;
            ListBuilder<E> listBuilder = this.f10022a;
            if (i10 >= listBuilder.f10011b) {
                throw new NoSuchElementException();
            }
            this.f10023b = i10 + 1;
            this.f10024c = i10;
            return listBuilder.f10010a[i10];
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f10023b;
        }

        @Override // java.util.ListIterator
        public final E previous() {
            a();
            int i10 = this.f10023b;
            if (i10 <= 0) {
                throw new NoSuchElementException();
            }
            int i11 = i10 - 1;
            this.f10023b = i11;
            this.f10024c = i11;
            return this.f10022a.f10010a[i11];
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f10023b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            a();
            int i10 = this.f10024c;
            if (i10 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            ListBuilder<E> listBuilder = this.f10022a;
            listBuilder.b(i10);
            this.f10023b = this.f10024c;
            this.f10024c = -1;
            this.f10025d = ((AbstractList) listBuilder).modCount;
        }

        @Override // java.util.ListIterator
        public final void set(E e10) {
            a();
            int i10 = this.f10024c;
            if (i10 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.f10022a.set(i10, e10);
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.f10012c = true;
        f10009d = listBuilder;
    }

    public ListBuilder(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.f10010a = (E[]) new Object[i10];
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.f10012c) {
            return new SerializedCollection(0, this);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // mb.f
    public final int a() {
        return this.f10011b;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e10) {
        g();
        int i10 = this.f10011b;
        ((AbstractList) this).modCount++;
        h(i10, 1);
        this.f10010a[i10] = e10;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> elements) {
        g.f(elements, "elements");
        g();
        int size = elements.size();
        e(elements, this.f10011b, size);
        return size > 0;
    }

    @Override // mb.f
    public final E b(int i10) {
        g();
        int i11 = this.f10011b;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
        }
        return i(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        g();
        j(0, this.f10011b);
    }

    public final void e(Collection collection, int i10, int i11) {
        ((AbstractList) this).modCount++;
        h(i10, i11);
        Iterator<E> it = collection.iterator();
        for (int i12 = 0; i12 < i11; i12++) {
            this.f10010a[i10 + i12] = it.next();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            E[] eArr = this.f10010a;
            int i10 = this.f10011b;
            if (i10 == list.size()) {
                for (int i11 = 0; i11 < i10; i11++) {
                    if (g.b(eArr[i11], list.get(i11))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f(int i10, E e10) {
        ((AbstractList) this).modCount++;
        h(i10, 1);
        this.f10010a[i10] = e10;
    }

    public final void g() {
        if (this.f10012c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i10) {
        int i11 = this.f10011b;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
        }
        return this.f10010a[i10];
    }

    public final void h(int i10, int i11) {
        int i12 = this.f10011b + i11;
        if (i12 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.f10010a;
        if (i12 > eArr.length) {
            int length = eArr.length;
            int i13 = length + (length >> 1);
            if (i13 - i12 < 0) {
                i13 = i12;
            }
            if (i13 - 2147483639 > 0) {
                i13 = i12 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            E[] eArr2 = (E[]) Arrays.copyOf(eArr, i13);
            g.e(eArr2, "copyOf(...)");
            this.f10010a = eArr2;
        }
        E[] eArr3 = this.f10010a;
        b1.q(eArr3, eArr3, i10 + i11, i10, this.f10011b);
        this.f10011b += i11;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        E[] eArr = this.f10010a;
        int i10 = this.f10011b;
        int iHashCode = 1;
        for (int i11 = 0; i11 < i10; i11++) {
            E e10 = eArr[i11];
            iHashCode = (iHashCode * 31) + (e10 != null ? e10.hashCode() : 0);
        }
        return iHashCode;
    }

    public final E i(int i10) {
        ((AbstractList) this).modCount++;
        E[] eArr = this.f10010a;
        E e10 = eArr[i10];
        b1.q(eArr, eArr, i10, i10 + 1, this.f10011b);
        E[] eArr2 = this.f10010a;
        int i11 = this.f10011b - 1;
        g.f(eArr2, "<this>");
        eArr2[i11] = null;
        this.f10011b--;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i10 = 0; i10 < this.f10011b; i10++) {
            if (g.b(this.f10010a[i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f10011b == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<E> iterator() {
        return listIterator(0);
    }

    public final void j(int i10, int i11) {
        if (i11 > 0) {
            ((AbstractList) this).modCount++;
        }
        E[] eArr = this.f10010a;
        b1.q(eArr, eArr, i10, i10 + i11, this.f10011b);
        E[] eArr2 = this.f10010a;
        int i12 = this.f10011b;
        y.J(eArr2, i12 - i11, i12);
        this.f10011b -= i11;
    }

    public final int k(int i10, int i11, Collection<? extends E> collection, boolean z) {
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = i10 + i12;
            if (collection.contains(this.f10010a[i14]) == z) {
                E[] eArr = this.f10010a;
                i12++;
                eArr[i13 + i10] = eArr[i14];
                i13++;
            } else {
                i12++;
            }
        }
        int i15 = i11 - i13;
        E[] eArr2 = this.f10010a;
        b1.q(eArr2, eArr2, i10 + i13, i11 + i10, this.f10011b);
        E[] eArr3 = this.f10010a;
        int i16 = this.f10011b;
        y.J(eArr3, i16 - i15, i16);
        if (i15 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f10011b -= i15;
        return i15;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i10 = this.f10011b - 1; i10 >= 0; i10--) {
            if (g.b(this.f10010a[i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<? extends Object> elements) {
        g.f(elements, "elements");
        g();
        return k(0, this.f10011b, elements, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection<? extends Object> elements) {
        g.f(elements, "elements");
        g();
        return k(0, this.f10011b, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i10, E e10) {
        g();
        int i11 = this.f10011b;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
        }
        E[] eArr = this.f10010a;
        E e11 = eArr[i10];
        eArr[i10] = e10;
        return e11;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List<E> subList(int i10, int i11) {
        c.a.b(i10, i11, this.f10011b);
        return new BuilderSubList(this.f10010a, i10, i11 - i10, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final <T> T[] toArray(T[] array) {
        g.f(array, "array");
        int length = array.length;
        int i10 = this.f10011b;
        if (length < i10) {
            T[] tArr = (T[]) Arrays.copyOfRange(this.f10010a, 0, i10, array.getClass());
            g.e(tArr, "copyOfRange(...)");
            return tArr;
        }
        b1.q(this.f10010a, array, 0, 0, i10);
        int i11 = this.f10011b;
        if (i11 < array.length) {
            array[i11] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return y.i(this.f10010a, 0, this.f10011b, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator(int i10) {
        int i11 = this.f10011b;
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
        }
        return new a(this, i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection<? extends E> elements) {
        g.f(elements, "elements");
        g();
        int i11 = this.f10011b;
        if (i10 >= 0 && i10 <= i11) {
            int size = elements.size();
            e(elements, i10, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, E e10) {
        g();
        int i11 = this.f10011b;
        if (i10 >= 0 && i10 <= i11) {
            ((AbstractList) this).modCount++;
            h(i10, 1);
            this.f10010a[i10] = e10;
            return;
        }
        throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return b1.v(this.f10010a, 0, this.f10011b);
    }
}
