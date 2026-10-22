package y;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Ref$IntRef;
import mb.t;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n<T> implements List<T>, ac.c {

    /* renamed from: a, reason: collision with root package name */
    public final SnapshotStateList<T> f13957a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13958b;

    /* renamed from: c, reason: collision with root package name */
    public int f13959c;

    /* renamed from: d, reason: collision with root package name */
    public int f13960d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements ListIterator<T>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f13961a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n<T> f13962b;

        public a(Ref$IntRef ref$IntRef, n<T> nVar) {
            this.f13961a = ref$IntRef;
            this.f13962b = nVar;
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            throw new IllegalStateException("Cannot modify a state list through an iterator");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f13961a.f10074a < this.f13962b.f13960d - 1;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f13961a.f10074a >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final T next() {
            Ref$IntRef ref$IntRef = this.f13961a;
            int i10 = ref$IntRef.f10074a + 1;
            n<T> nVar = this.f13962b;
            e.a(i10, nVar.f13960d);
            ref$IntRef.f10074a = i10;
            return nVar.get(i10);
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f13961a.f10074a + 1;
        }

        @Override // java.util.ListIterator
        public final T previous() {
            Ref$IntRef ref$IntRef = this.f13961a;
            int i10 = ref$IntRef.f10074a;
            n<T> nVar = this.f13962b;
            e.a(i10, nVar.f13960d);
            ref$IntRef.f10074a = i10 - 1;
            return nVar.get(i10);
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f13961a.f10074a;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            throw new IllegalStateException("Cannot modify a state list through an iterator");
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            throw new IllegalStateException("Cannot modify a state list through an iterator");
        }
    }

    public n(SnapshotStateList<T> snapshotStateList, int i10, int i11) {
        this.f13957a = snapshotStateList;
        this.f13958b = i10;
        this.f13959c = e.e(snapshotStateList);
        this.f13960d = i11 - i10;
    }

    public final void a() {
        if (e.e(this.f13957a) != this.f13959c) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(T t8) {
        a();
        int i10 = this.f13958b + this.f13960d;
        SnapshotStateList<T> snapshotStateList = this.f13957a;
        snapshotStateList.add(i10, t8);
        this.f13960d++;
        this.f13959c = e.e(snapshotStateList);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        return addAll(this.f13960d, collection);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        if (this.f13960d > 0) {
            a();
            int i10 = this.f13960d;
            int i11 = this.f13958b;
            SnapshotStateList<T> snapshotStateList = this.f13957a;
            snapshotStateList.removeRange(i11, i10 + i11);
            this.f13960d = 0;
            this.f13959c = e.e(snapshotStateList);
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        Collection<?> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public final T get(int i10) {
        a();
        e.a(i10, this.f13960d);
        return this.f13957a.get(this.f13958b + i10);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        a();
        int i10 = this.f13960d;
        int i11 = this.f13958b;
        Iterator<Integer> it = dc.h.e0(i11, i10 + i11).iterator();
        while (it.hasNext()) {
            int iNextInt = ((t) it).nextInt();
            if (kotlin.jvm.internal.g.b(obj, this.f13957a.get(iNextInt))) {
                return iNextInt - i11;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f13960d == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        a();
        int i10 = this.f13960d;
        int i11 = this.f13958b;
        for (int i12 = (i10 + i11) - 1; i12 >= i11; i12--) {
            if (kotlin.jvm.internal.g.b(obj, this.f13957a.get(i12))) {
                return i12 - i11;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        a();
        int i10 = this.f13960d;
        int i11 = this.f13958b;
        SnapshotStateList<T> snapshotStateList = this.f13957a;
        int iRetainAllInRange$runtime = snapshotStateList.retainAllInRange$runtime(collection, i11, i10 + i11);
        if (iRetainAllInRange$runtime > 0) {
            this.f13959c = e.e(snapshotStateList);
            this.f13960d -= iRetainAllInRange$runtime;
        }
        return iRetainAllInRange$runtime > 0;
    }

    @Override // java.util.List
    public final T set(int i10, T t8) {
        e.a(i10, this.f13960d);
        a();
        int i11 = i10 + this.f13958b;
        SnapshotStateList<T> snapshotStateList = this.f13957a;
        T t10 = snapshotStateList.set(i11, t8);
        this.f13959c = e.e(snapshotStateList);
        return t10;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f13960d;
    }

    @Override // java.util.List
    public final List<T> subList(int i10, int i11) {
        if (!(i10 >= 0 && i10 <= i11 && i11 <= this.f13960d)) {
            androidx.compose.runtime.f.a("fromIndex or toIndex are out of bounds");
        }
        a();
        int i12 = this.f13958b;
        return new n(this.f13957a, i10 + i12, i11 + i12);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return kotlin.jvm.internal.d.a(this);
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator(int i10) {
        a();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f10074a = i10 - 1;
        return new a(ref$IntRef, this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        return (T[]) kotlin.jvm.internal.d.b(this, tArr);
    }

    @Override // java.util.List
    public final boolean addAll(int i10, Collection<? extends T> collection) {
        a();
        int i11 = i10 + this.f13958b;
        SnapshotStateList<T> snapshotStateList = this.f13957a;
        boolean zAddAll = snapshotStateList.addAll(i11, collection);
        if (zAddAll) {
            this.f13960d = collection.size() + this.f13960d;
            this.f13959c = e.e(snapshotStateList);
        }
        return zAddAll;
    }

    @Override // java.util.List
    public final T remove(int i10) {
        a();
        int i11 = this.f13958b + i10;
        SnapshotStateList<T> snapshotStateList = this.f13957a;
        T tRemove = snapshotStateList.remove(i11);
        this.f13960d--;
        this.f13959c = e.e(snapshotStateList);
        return tRemove;
    }

    @Override // java.util.List
    public final void add(int i10, T t8) {
        a();
        int i11 = this.f13958b + i10;
        SnapshotStateList<T> snapshotStateList = this.f13957a;
        snapshotStateList.add(i11, t8);
        this.f13960d++;
        this.f13959c = e.e(snapshotStateList);
    }
}
