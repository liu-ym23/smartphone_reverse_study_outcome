package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.e0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: loaded from: classes43.dex */
public final class t<T extends MVIState<?>> implements e0<T>, List<T>, KMutableList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f41712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<T> f41713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f41714c;

    public class a<T extends MVIState<?>, ITR extends Iterator<? extends T>> implements Iterator<T>, KMutableIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ITR f41716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f41717c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ t f41718d;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f41716b.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            int r100 = this.f41717c;
            this.f41715a = r100;
            this.f41717c = r100 + 1;
            return (MVIState) this.f41716b.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.f41718d.e(new b.d(this.f41715a));
            this.f41717c = this.f41715a;
            this.f41715a = -1;
            this.f41716b.remove();
        }

        public a(t r100, ITR r101, int r102) {
            this.f41718d = r100;
            this.f41716b = r101;
            this.f41717c = r102;
            this.f41715a = -1;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41720b;

        public static final class a extends b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final a f41721c = null;

            public a() {
                super(-1, -1);
            }

            static {
                f41721c = new a();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.anya.internal.t$b$b, reason: collision with other inner class name */
        public static final class C0767b extends b {
            public C0767b(int r100) {
                super(r100, 1);
            }
        }

        public static final class c extends b {
            public c(int r100) {
                super(r100, 1);
            }

            public c(int r100, int r101) {
                super(r100, r101);
            }
        }

        public static final class d extends b {
            public d(int r100) {
                super(r100, 1);
            }

            public d(int r100, int r101) {
                super(r100, r101);
            }
        }

        public static final class e extends b {
            public e(int r100) {
                super(r100, 1);
            }
        }

        public final String toString() {
            return "{ type: " + getClass() + ", index: " + this.f41719a + ", count: " + this.f41720b + " }";
        }

        public b(int r100, int r101) {
            this.f41719a = r100;
            this.f41720b = r101;
        }
    }

    public final class c<T extends MVIState<?>> extends t<T>.a<T, ListIterator<T>> implements ListIterator<T>, KMutableListIterator {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ t f41722e;

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return ((ListIterator) this.f41716b).hasPrevious();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return ((ListIterator) this.f41716b).nextIndex();
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            int r100 = this.f41717c - 1;
            this.f41717c = r100;
            this.f41715a = r100;
            return (MVIState) ((ListIterator) this.f41716b).previous();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return ((ListIterator) this.f41716b).previousIndex();
        }

        @Override // java.util.ListIterator
        public final void add(Object r100) {
            MVIState r101 = (MVIState) r100;
            r101.notifyParentNodeChange = this.f41722e.c();
            this.f41722e.e(new b.c(this.f41717c));
            this.f41717c++;
            this.f41715a = -1;
            ((ListIterator) this.f41716b).add(r101);
        }

        @Override // java.util.ListIterator
        public final void set(Object r100) {
            MVIState r101 = (MVIState) r100;
            r101.notifyParentNodeChange = this.f41722e.c();
            this.f41722e.e(new b.e(this.f41715a));
            ((ListIterator) this.f41716b).set(r101);
        }

        public c(t r100, ListIterator<T> r101, int r102) {
            this.f41722e = r100;
            super(r100, r101, r102);
        }
    }

    public final class d<T extends MVIState<?>> implements List<T>, KMutableList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f41723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t f41725c;

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection<? extends Object> r100) {
            return this.f41723a.containsAll(r100);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            return this.f41723a.isEmpty();
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection<? extends Object> r100) {
            return this.f41723a.retainAll(r100);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public final <T> T[] toArray(T[] r100) {
            return (T[]) CollectionToArray.toArray(this, r100);
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            this.f41725c.e(new b.d(this.f41724b, this.f41723a.size()));
            this.f41723a.clear();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator<T> iterator() {
            return new a(this.f41725c, this.f41723a.iterator(), this.f41724b);
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.f41723a.size();
        }

        @Override // java.util.List, java.util.Collection
        public final boolean add(Object r100) {
            MVIState r101 = (MVIState) r100;
            r101.notifyParentNodeChange = this.f41725c.c();
            this.f41725c.e(new b.c(this.f41723a.size() + this.f41724b));
            return this.f41723a.add((T) r101);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection<? extends T> r100) {
            Iterator<T> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            MVIState r102 = (MVIState) r101.next();
            r102.notifyParentNodeChange = this.f41725c.c();
            goto L4
        L6:
            this.f41725c.e(new b.c(this.f41723a.size() + this.f41724b, r100.size()));
            return this.f41723a.addAll(r100);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object r100) {
            if ((r100 instanceof MVIState) == false) goto L6;
            List<T> r101 = this.f41723a;
            return r101.contains((MVIState) r100);
        L6:
            return false;
        }

        @Override // java.util.List
        public final Object get(int r100) {
            return (MVIState) ListProtector.get(this.f41723a, r100);
        }

        @Override // java.util.List
        public final int indexOf(Object r100) {
            if ((r100 instanceof MVIState) == false) goto L6;
            List<T> r101 = this.f41723a;
            return r101.indexOf((MVIState) r100);
        L6:
            return -1;
        }

        @Override // java.util.List
        public final int lastIndexOf(Object r100) {
            if ((r100 instanceof MVIState) == false) goto L6;
            List<T> r101 = this.f41723a;
            return r101.lastIndexOf((MVIState) r100);
        L6:
            return -1;
        }

        @Override // java.util.List
        public final ListIterator<T> listIterator(int r100) {
            return new c(this.f41725c, this.f41723a.listIterator(r100), this.f41724b);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object r100) {
            if ((r100 instanceof MVIState) == false) goto L8;
            int r101 = indexOf((MVIState) r100);
            if (r101 < 0) goto L8;
            this.f41725c.e(new b.d(this.f41724b + r101));
            ListProtector.remove(this.f41723a, r101);
            return true;
        L8:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection<? extends Object> r100) {
            Iterator r101 = CollectionsKt.toSet(r100).iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            MVIState r102 = (MVIState) r101.next();
            int r103 = this.f41723a.indexOf(r102);
            if (r103 < 0) goto L4;
            this.f41725c.e(new b.d(r103 + this.f41724b));
            goto L4
        L9:
            return this.f41723a.removeAll(r100);
        }

        @Override // java.util.List
        public final Object remove(int r100) {
            this.f41725c.e(new b.d(this.f41724b + r100));
            return (MVIState) ListProtector.remove(this.f41723a, r100);
        }

        @Override // java.util.List
        public final void add(int r100, Object r101) {
            MVIState r102 = (MVIState) r101;
            r102.notifyParentNodeChange = this.f41725c.c();
            this.f41725c.e(new b.c(this.f41724b + r100));
            ListProtector.add(this.f41723a, r100, r102);
        }

        @Override // java.util.List
        public final boolean addAll(int r100, Collection<? extends T> r101) {
            Iterator<T> r102 = r101.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            MVIState r103 = (MVIState) r102.next();
            r103.notifyParentNodeChange = this.f41725c.c();
            goto L4
        L6:
            this.f41725c.e(new b.c(this.f41724b + r100, r101.size()));
            return this.f41723a.addAll(r100, r101);
        }

        @Override // java.util.List
        public final Object set(int r100, Object r101) {
            MVIState r102 = (MVIState) r101;
            r102.notifyParentNodeChange = this.f41725c.c();
            this.f41725c.e(new b.e(this.f41724b + r100));
            return (MVIState) ListProtector.set(this.f41723a, r100, r102);
        }

        @Override // java.util.List
        public final List<T> subList(int r100, int r101) {
            return new d(this.f41725c, this.f41723a.subList(r100, r101), this.f41724b + r100);
        }

        public d(t r100, List<T> r101, int r102) {
            this.f41725c = r100;
            this.f41723a = r101;
            this.f41724b = r102;
        }
    }

    public t() {
        this(null);
    }

    public final T a(int r100) {
        return (T) ListProtector.get(this.f41713b, r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r100) {
        return this.f41713b.containsAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f41713b.isEmpty();
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r100) {
        return this.f41713b.retainAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    public final Function0<Unit> c() {
        Function0<Unit> r100 = this.f41712a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L5:
        return r100;
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        e(b.a.f41721c);
        this.f41713b.clear();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return new a(this, this.f41713b.iterator(), 0);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f41713b.size();
    }

    public t(Object r100) {
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        this.f41713b = r101;
        this.f41714c = r102;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object r100) {
        MVIState r101 = (MVIState) r100;
        Function0<Unit> r102 = this.f41712a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L5:
        r101.notifyParentNodeChange = r102;
        e(new b.c(this.f41713b.size()));
        return this.f41713b.add((T) r101);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends T> r100) {
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        MVIState r102 = (MVIState) r101.next();
        Function0<Unit> r103 = this.f41712a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L8:
        r102.notifyParentNodeChange = r103;
        goto L4
    L9:
        e(new b.c(this.f41713b.size(), r100.size()));
        return this.f41713b.addAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r100) {
        if ((r100 instanceof MVIState) == false) goto L6;
        List<T> r101 = this.f41713b;
        return r101.contains((MVIState) r100);
    L6:
        return false;
    }

    public final void d(int r100) {
        e(new b.C0767b(r100));
    }

    public final void e(b r100) {
        Function0<Unit> r101 = this.f41712a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L5:
        r101.invoke();
        b r102 = (b) CollectionsKt.firstOrNull(this.f41714c);
        b.a r103 = b.a.f41721c;
        if (Intrinsics.areEqual(r102, r103) == false) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r100, r103) == false) goto L12;
        this.f41714c.clear();
        this.f41714c.add(r103);
        return;
    L12:
        this.f41714c.add(r100);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int r100) {
        return a(r100);
    }

    @Override // java.util.List
    public final int indexOf(Object r100) {
        if ((r100 instanceof MVIState) == false) goto L6;
        List<T> r101 = this.f41713b;
        return r101.indexOf((MVIState) r100);
    L6:
        return -1;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r100) {
        if ((r100 instanceof MVIState) == false) goto L6;
        List<T> r101 = this.f41713b;
        return r101.lastIndexOf((MVIState) r100);
    L6:
        return -1;
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator(int r100) {
        return new c(this, this.f41713b.listIterator(r100), r100);
    }

    @Override // com.bytedance.android.anya.e0
    public final boolean q(List<? extends T> r100) {
        if (this.f41713b.size() == r100.size()) goto L5;
        boolean r101 = true;
    L6:
        int r102 = Math.min(this.f41713b.size(), r100.size());
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L17;
        i.a((MVIState) ListProtector.get(this.f41713b, r103), (MVIState) ListProtector.get(r100, r103));
        e(new b.C0767b(r103));
        if (r101 == false) goto L11;
    L14:
        r101 = true;
    L15:
        r103 = r103 + 1;
        goto L7
    L11:
        if ((!((MVIState) ListProtector.get(this.f41713b, r103)).modifiedProperties.isEmpty()) == true) goto L14;
        r101 = false;
        goto L15
    L17:
        if (r100.size() <= this.f41713b.size()) goto L20;
        addAll(r100.subList(this.f41713b.size(), r100.size()));
    L22:
        return r101;
    L20:
        if (r100.size() >= this.f41713b.size()) goto L22;
        ((d) subList(r100.size(), this.f41713b.size())).clear();
        goto L22
    L5:
        r101 = false;
        goto L6
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r100) {
        if ((r100 instanceof MVIState) == false) goto L8;
        int r101 = indexOf((MVIState) r100);
        if (r101 < 0) goto L8;
        e(new b.d(r101));
        ListProtector.remove(this.f41713b, r101);
        return true;
    L8:
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r100) {
        Iterator r101 = CollectionsKt.toSet(r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        MVIState r102 = (MVIState) r101.next();
        int r103 = this.f41713b.indexOf(r102);
        if (r103 < 0) goto L4;
        e(new b.d(r103));
        goto L4
    L9:
        return this.f41713b.removeAll(r100);
    }

    @Override // java.util.List
    public final Object remove(int r100) {
        e(new b.d(r100));
        return (MVIState) ListProtector.remove(this.f41713b, r100);
    }

    @Override // java.util.List
    public final void add(int r100, Object r101) {
        MVIState r102 = (MVIState) r101;
        Function0<Unit> r103 = this.f41712a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L5:
        r102.notifyParentNodeChange = r103;
        e(new b.c(r100));
        ListProtector.add(this.f41713b, r100, r102);
    }

    @Override // java.util.List
    public final boolean addAll(int r100, Collection<? extends T> r101) {
        Iterator<T> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        MVIState r103 = (MVIState) r102.next();
        Function0<Unit> r104 = this.f41712a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L8:
        r103.notifyParentNodeChange = r104;
        goto L4
    L9:
        e(new b.c(r100, r101.size()));
        return this.f41713b.addAll(r100, r101);
    }

    @Override // java.util.List
    public final Object set(int r100, Object r101) {
        MVIState r102 = (MVIState) r101;
        Function0<Unit> r103 = this.f41712a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("onChange");
    L5:
        r102.notifyParentNodeChange = r103;
        e(new b.e(r100));
        return (MVIState) ListProtector.set(this.f41713b, r100, r102);
    }

    @Override // java.util.List
    public final List<T> subList(int r100, int r101) {
        return new d(this, this.f41713b.subList(r100, r101), r100);
    }
}
