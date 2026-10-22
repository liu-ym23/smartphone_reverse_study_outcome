package d.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.b.o;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: ListBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b<E> extends d.a.e<E> implements d.h.b.a.e, Serializable, List<E>, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C1032b f38309a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final b f38310e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private E[] f38311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f38312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f38313d;

    /* JADX INFO: compiled from: ListBuilder.kt */
    public static final class a<E> extends d.a.e<E> implements d.h.b.a.e, Serializable, List<E>, RandomAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private E[] f38314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f38315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f38316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final a<E> f38317d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final b<E> f38318e;

        /* JADX INFO: renamed from: d.a.a.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ListBuilder.kt */
        private static final class C1031a<E> implements d.h.b.a.f, ListIterator<E> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final a<E> f38319a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f38320b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f38321c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f38322d;

            public C1031a(a<E> r2, int r3) {
                o.e(r2, "list");
                this.f38319a = r2;
                this.f38320b = r3;
                this.f38321c = -1;
                this.f38322d = a.a(r2);
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                if (this.f38320b <= 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                if (this.f38320b >= a.b(this.f38319a)) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f38320b - 1;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f38320b;
            }

            @Override // java.util.ListIterator
            public E previous() {
                a();
                int r0 = this.f38320b;
                if (r0 <= 0) goto L7;
                int r1 = r0 - 1;
                this.f38320b = r1;
                this.f38321c = r1;
                return (E) a.c(this.f38319a)[a.d(this.f38319a) + this.f38321c];
            L7:
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public E next() {
                a();
                if (this.f38320b >= a.b(this.f38319a)) goto L7;
                int r0 = this.f38320b;
                this.f38320b = r0 + 1;
                this.f38321c = r0;
                return (E) a.c(this.f38319a)[a.d(this.f38319a) + this.f38321c];
            L7:
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public void set(E r3) {
                a();
                int r0 = this.f38321c;
                if (r0 == (-1)) goto L5;
                boolean r1 = true;
            L6:
                if (r1 == false) goto L10;
                this.f38319a.set(r0, r3);
                return;
            L10:
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            L5:
                r1 = false;
                goto L6
            }

            @Override // java.util.ListIterator
            public void add(E r4) {
                a();
                a<E> r0 = this.f38319a;
                int r1 = this.f38320b;
                this.f38320b = r1 + 1;
                r0.add(r1, r4);
                this.f38321c = -1;
                this.f38322d = a.a(this.f38319a);
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                a();
                int r0 = this.f38321c;
                if (r0 == (-1)) goto L5;
                boolean r2 = true;
            L6:
                if (r2 == false) goto L10;
                this.f38319a.remove(r0);
                this.f38320b = this.f38321c;
                this.f38321c = -1;
                this.f38322d = a.a(this.f38319a);
                return;
            L10:
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            L5:
                r2 = false;
                goto L6
            }

            private final void a() {
                if (b.a(a.e(this.f38319a)) != this.f38322d) goto L6;
                return;
            L6:
                throw new ConcurrentModificationException();
            }
        }

        public static final /* synthetic */ int a(a r0) {
            return r0.modCount;
        }

        public static final /* synthetic */ int b(a r0) {
            return r0.f38316c;
        }

        public static final /* synthetic */ Object[] c(a r0) {
            return r0.f38314a;
        }

        public static final /* synthetic */ int d(a r0) {
            return r0.f38315b;
        }

        public static final /* synthetic */ b e(a r0) {
            return r0.f38318e;
        }

        public a(E[] r2, int r3, int r4, a<E> r5, b<E> r6) {
            o.e(r2, "backing");
            o.e(r6, "root");
            this.f38314a = r2;
            this.f38315b = r3;
            this.f38316c = r4;
            this.f38317d = r5;
            this.f38318e = r6;
            this.modCount = b.a(r6);
        }

        @Override // d.a.e
        public int a() {
            c();
            return this.f38316c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            c();
            if (this.f38316c != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r3) {
            c();
            d.a.c.f38373a.a(r3, this.f38316c);
            return this.f38314a[this.f38315b + r3];
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int r3, E r4) {
            d();
            c();
            d.a.c.f38373a.a(r3, this.f38316c);
            E[] r0 = this.f38314a;
            int r2 = this.f38315b;
            E r1 = r0[r2 + r3];
            r0[r2 + r3] = r4;
            return r1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r4) {
            c();
            int r0 = 0;
        L4:
            if (r0 >= this.f38316c) goto L9;
            if (o.a(this.f38314a[this.f38315b + r0], r4) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r4) {
            c();
            int r0 = this.f38316c - 1;
        L3:
            if (r0 < 0) goto L8;
            if (o.a(this.f38314a[this.f38315b + r0], r4) == true) goto L6;
            r0 = r0 - 1;
            goto L3
        L6:
            return r0;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            return (Iterator) ZeusTransformUtils.preCheckCast(listIterator(0), Iterator.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int r3) {
            c();
            d.a.c.f38373a.b(r3, this.f38316c);
            return (ListIterator) ZeusTransformUtils.preCheckCast(new C1031a(this, r3), ListIterator.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E r3) {
            d();
            c();
            a(this.f38315b + this.f38316c, r3);
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int r3, E r4) {
            d();
            c();
            d.a.c.f38373a.b(r3, this.f38316c);
            a(this.f38315b + r3, r4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> r4) {
            Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
            o.e(r5, "elements");
            d();
            c();
            int r0 = r5.size();
            a(this.f38315b + this.f38316c, r5, r0);
            if (r0 <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int r3, Collection<? extends E> r4) {
            Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
            o.e(r5, "elements");
            d();
            c();
            d.a.c.f38373a.b(r3, this.f38316c);
            int r0 = r5.size();
            a(this.f38315b + r3, r5, r0);
            if (r0 <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            d();
            c();
            a(this.f38315b, this.f38316c);
        }

        @Override // d.a.e
        public E a(int r3) {
            d();
            c();
            d.a.c.f38373a.a(r3, this.f38316c);
            return b(this.f38315b + r3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object r1) {
            d();
            c();
            int r2 = indexOf(r1);
            if (r2 < 0) goto L5;
            remove(r2);
        L5:
            if (r2 < 0) goto L7;
            return true;
        L7:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<? extends Object> r4) {
            Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
            o.e(r5, "elements");
            d();
            c();
            if (a(this.f38315b, this.f38316c, r5, false) <= 0) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<? extends Object> r4) {
            Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
            o.e(r5, "elements");
            d();
            c();
            if (a(this.f38315b, this.f38316c, r5, true) > 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int r9, int r10) {
            d.a.c.f38373a.a(r9, r10, this.f38316c);
            return (List) ZeusTransformUtils.preCheckCast(new a(this.f38314a, this.f38315b + r9, r10 - r9, this, this.f38318e), List.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] r5) {
            o.e(r5, "array");
            c();
            int r0 = r5.length;
            int r1 = this.f38316c;
            if (r0 >= r1) goto L6;
            E[] r2 = this.f38314a;
            int r4 = this.f38315b;
            T[] r6 = (T[]) Arrays.copyOfRange(r2, r4, r1 + r4, r5.getClass());
            o.c(r6, "copyOfRange(...)");
            return r6;
        L6:
            E[] r3 = this.f38314a;
            int r7 = this.f38315b;
            i.a(r3, r5, 0, r7, r1 + r7);
            return (T[]) p.a(this.f38316c, r5);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            c();
            E[] r0 = this.f38314a;
            int r1 = this.f38315b;
            return i.a(r0, r1, this.f38316c + r1);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r3) {
            c();
            if (r3 != this) goto L5;
        L10:
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, List.class) == true) goto L7;
        L9:
            return false;
        L7:
            if (a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin")) == false) goto L9;
            goto L9
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            c();
            return d.a.a.c.b(this.f38314a, this.f38315b, this.f38316c);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            c();
            return d.a.a.c.a(this.f38314a, this.f38315b, this.f38316c, (Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin"));
        }

        private final void b() {
            this.modCount++;
        }

        private final void c() {
            if (b.a(this.f38318e) != this.modCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        private final void d() {
            if (e() == true) goto L6;
            return;
        L6:
            throw new UnsupportedOperationException();
        }

        private final boolean e() {
            return b.d(this.f38318e);
        }

        private final boolean a(List<?> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            return d.a.a.c.a(this.f38314a, this.f38315b, this.f38316c, r4);
        }

        private final void a(int r2, E r3) {
            b();
            a<E> r0 = this.f38317d;
            if (r0 == null) goto L5;
            r0.a(r2, r3);
        L6:
            this.f38314a = (E[]) b.c(this.f38318e);
            this.f38316c++;
            return;
        L5:
            b.a(this.f38318e, r2, r3);
            goto L6
        }

        private final void a(int r3, Collection<? extends E> r4, int r5) {
            Collection<? extends E> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
            b();
            a<E> r0 = this.f38317d;
            if (r0 == null) goto L5;
            r0.a(r3, r6, r5);
        L6:
            this.f38314a = (E[]) b.c(this.f38318e);
            this.f38316c += r5;
            return;
        L5:
            b.a(this.f38318e, r3, r6, r5);
            goto L6
        }

        private final E b(int r2) {
            b();
            a<E> r0 = this.f38317d;
            if (r0 == null) goto L5;
            E r3 = r0.b(r2);
        L6:
            this.f38316c--;
            return r3;
        L5:
            r3 = (E) b.a(this.f38318e, r2);
            goto L6
        }

        private final void a(int r2, int r3) {
            if (r3 <= 0) goto L4;
            b();
        L4:
            a<E> r0 = this.f38317d;
            if (r0 == null) goto L7;
            r0.a(r2, r3);
        L8:
            this.f38316c -= r3;
            return;
        L7:
            b.a(this.f38318e, r2, r3);
            goto L8
        }

        private final int a(int r3, int r4, Collection<? extends E> r5, boolean r6) {
            Collection<? extends E> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
            a<E> r0 = this.f38317d;
            if (r0 == null) goto L5;
            int r8 = r0.a(r3, r4, r7, r6);
        L6:
            if (r8 <= 0) goto L8;
            b();
        L8:
            this.f38316c -= r8;
            return r8;
        L5:
            r8 = b.a(this.f38318e, r3, r4, r7, r6);
            goto L6
        }
    }

    /* JADX INFO: renamed from: d.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ListBuilder.kt */
    private static final class C1032b {
        public /* synthetic */ C1032b(d.h.b.h r1) {
            this();
        }

        private C1032b() {
        }
    }

    /* JADX INFO: compiled from: ListBuilder.kt */
    private static final class c<E> implements d.h.b.a.f, ListIterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b<E> f38323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f38324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f38325c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f38326d;

        public c(b<E> r2, int r3) {
            o.e(r2, "list");
            this.f38323a = r2;
            this.f38324b = r3;
            this.f38325c = -1;
            this.f38326d = b.a(r2);
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.f38324b <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.f38324b >= b.b(this.f38323a)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f38324b - 1;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f38324b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            a();
            int r0 = this.f38324b;
            if (r0 <= 0) goto L7;
            int r1 = r0 - 1;
            this.f38324b = r1;
            this.f38325c = r1;
            return (E) b.c(this.f38323a)[this.f38325c];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            a();
            if (this.f38324b >= b.b(this.f38323a)) goto L7;
            int r0 = this.f38324b;
            this.f38324b = r0 + 1;
            this.f38325c = r0;
            return (E) b.c(this.f38323a)[this.f38325c];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public void set(E r3) {
            a();
            int r0 = this.f38325c;
            if (r0 == (-1)) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L10;
            this.f38323a.set(r0, r3);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        L5:
            r1 = false;
            goto L6
        }

        @Override // java.util.ListIterator
        public void add(E r4) {
            a();
            b<E> r0 = this.f38323a;
            int r1 = this.f38324b;
            this.f38324b = r1 + 1;
            r0.add(r1, r4);
            this.f38325c = -1;
            this.f38326d = b.a(this.f38323a);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            int r0 = this.f38325c;
            if (r0 == (-1)) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L10;
            this.f38323a.remove(r0);
            this.f38324b = this.f38325c;
            this.f38325c = -1;
            this.f38326d = b.a(this.f38323a);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        L5:
            r2 = false;
            goto L6
        }

        private final void a() {
            if (b.a(this.f38323a) != this.f38326d) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }
    }

    public b() {
        this(0, 1, null);
    }

    public b(int r1) {
        this.f38311b = (E[]) d.a.a.c.a(r1);
    }

    public /* synthetic */ b(int r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 10;
    L5:
        this(r1);
    }

    public static final /* synthetic */ int a(b r0) {
        return r0.modCount;
    }

    public static final /* synthetic */ int a(b r2, int r3, int r4, Collection r5, boolean r6) {
        return r2.a(r3, r4, (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin"), r6);
    }

    public static final /* synthetic */ Object a(b r0, int r1) {
        return r0.d(r1);
    }

    public static final /* synthetic */ void a(b r0, int r1, int r2) {
        r0.b(r1, r2);
    }

    public static final /* synthetic */ void a(b r0, int r1, Object r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(b r2, int r3, Collection r4, int r5) {
        r2.a(r3, (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin"), r5);
    }

    public static final /* synthetic */ int b(b r0) {
        return r0.f38312c;
    }

    public static final /* synthetic */ Object[] c(b r0) {
        return r0.f38311b;
    }

    public static final /* synthetic */ boolean d(b r0) {
        return r0.f38313d;
    }

    static {
        f38309a = new C1032b(null);
        b r0 = new b(0);
        r0.f38313d = true;
        f38310e = r0;
    }

    public final List<E> b() {
        d();
        this.f38313d = true;
        if (this.f38312c > 0) goto L7;
        b<E> this = f38310e;
    L7:
        return (List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.aiagent.plugin");
    }

    @Override // d.a.e
    public int a() {
        return this.f38312c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (this.f38312c != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r3) {
        d.a.c.f38373a.a(r3, this.f38312c);
        return this.f38311b[r3];
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r3, E r4) {
        d();
        d.a.c.f38373a.a(r3, this.f38312c);
        E[] r2 = this.f38311b;
        E r0 = r2[r3];
        r2[r3] = r4;
        return r0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.f38312c) goto L9;
        if (o.a(this.f38311b[r0], r3) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r3) {
        int r0 = this.f38312c - 1;
    L3:
        if (r0 < 0) goto L8;
        if (o.a(this.f38311b[r0], r3) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(listIterator(0), Iterator.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int r3) {
        d.a.c.f38373a.b(r3, this.f38312c);
        return (ListIterator) ZeusTransformUtils.preCheckCast(new c(this, r3), ListIterator.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r2) {
        d();
        a(this.f38312c, r2);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r3, E r4) {
        d();
        d.a.c.f38373a.b(r3, this.f38312c);
        a(r3, r4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r4, "elements");
        d();
        int r0 = r4.size();
        a(this.f38312c, r4, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r3, Collection<? extends E> r4) {
        Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        o.e(r5, "elements");
        d();
        d.a.c.f38373a.b(r3, this.f38312c);
        int r0 = r5.size();
        a(r3, r5, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        d();
        b(0, this.f38312c);
    }

    @Override // d.a.e
    public E a(int r3) {
        d();
        d.a.c.f38373a.a(r3, this.f38312c);
        return d(r3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r1) {
        d();
        int r2 = indexOf(r1);
        if (r2 < 0) goto L5;
        remove(r2);
    L5:
        if (r2 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r4, "elements");
        d();
        if (a(0, this.f38312c, r4, false) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r4) {
        Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        o.e(r5, "elements");
        d();
        if (a(0, this.f38312c, r5, true) > 0) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int r9, int r10) {
        d.a.c.f38373a.a(r9, r10, this.f38312c);
        return (List) ZeusTransformUtils.preCheckCast(new a(this.f38311b, r9, r10 - r9, null, this), List.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r4) {
        o.e(r4, "array");
        int r0 = r4.length;
        int r1 = this.f38312c;
        if (r0 >= r1) goto L6;
        T[] r3 = (T[]) Arrays.copyOfRange(this.f38311b, 0, r1, r4.getClass());
        o.c(r3, "copyOfRange(...)");
        return r3;
    L6:
        i.a(this.f38311b, r4, 0, 0, r1);
        return (T[]) p.a(this.f38312c, r4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return i.a(this.f38311b, 0, this.f38312c);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r3) {
        if (r3 != this) goto L4;
    L9:
        return true;
    L4:
        if (ZeusTransformUtils.instanceOf(r3, List.class) == true) goto L6;
    L8:
        return false;
    L6:
        if (a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin")) == false) goto L8;
        goto L8
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return d.a.a.c.b(this.f38311b, 0, this.f38312c);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return d.a.a.c.a(this.f38311b, 0, this.f38312c, (Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin"));
    }

    private final void c() {
        this.modCount++;
    }

    private final void d() {
        if (this.f38313d == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private final void b(int r2) {
        c(this.f38312c + r2);
    }

    private final void c(int r3) {
        if (r3 < 0) goto L8;
        if (r3 <= this.f38311b.length) goto L9;
        int r4 = d.a.c.f38373a.c(this.f38311b.length, r3);
        this.f38311b = (E[]) d.a.a.c.a(this.f38311b, r4);
        return;
    L9:
        return;
    L8:
        throw new OutOfMemoryError();
    }

    private final boolean a(List<?> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        return d.a.a.c.a(this.f38311b, 0, this.f38312c, r4);
    }

    private final void a(int r4, int r5) {
        b(r5);
        E[] r0 = this.f38311b;
        i.a(r0, r0, r4 + r5, r4, this.f38312c);
        this.f38312c += r5;
    }

    private final void a(int r2, E r3) {
        c();
        a(r2, 1);
        this.f38311b[r2] = r3;
    }

    private final void a(int r5, Collection<? extends E> r6, int r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        c();
        a(r5, r7);
        Iterator<E> r9 = r8.iterator();
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        this.f38311b[r5 + r0] = r9.next();
        r0 = r0 + 1;
        goto L3
    }

    private final E d(int r5) {
        c();
        E[] r0 = this.f38311b;
        E r1 = r0[r5];
        i.a(r0, r0, r5, r5 + 1, this.f38312c);
        d.a.a.c.b(this.f38311b, this.f38312c - 1);
        this.f38312c--;
        return r1;
    }

    private final void b(int r4, int r5) {
        if (r5 <= 0) goto L4;
        c();
    L4:
        E[] r0 = this.f38311b;
        i.a(r0, r0, r4, r4 + r5, this.f38312c);
        E[] r6 = this.f38311b;
        int r1 = this.f38312c;
        d.a.a.c.a(r6, r1 - r5, r1);
        this.f38312c -= r5;
    }

    private final int a(int r6, int r7, Collection<? extends E> r8, boolean r9) {
        Collection r10 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r7) goto L8;
        int r3 = r6 + r0;
        if (r10.contains(this.f38311b[r3]) == r9) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        E[] r2 = this.f38311b;
        r0 = r0 + 1;
        r2[r1 + r6] = r2[r3];
        r1 = r1 + 1;
        goto L3
    L8:
        int r11 = r7 - r1;
        E[] r12 = this.f38311b;
        i.a(r12, r12, r6 + r1, r7 + r6, this.f38312c);
        E[] r13 = this.f38311b;
        int r14 = this.f38312c;
        d.a.a.c.a(r13, r14 - r11, r14);
        if (r11 <= 0) goto L11;
        c();
    L11:
        this.f38312c -= r11;
        return r11;
    }
}
