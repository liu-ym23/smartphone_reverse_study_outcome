package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: AbstractList.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c<E> extends d.a.a<E> implements d.h.b.a.a, List<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38373a = null;

    /* JADX INFO: compiled from: AbstractList.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public final int c(int r2, int r3) {
            int r4 = r2 + (r2 >> 1);
            if ((r4 - r3) >= 0) goto L5;
            r4 = r3;
        L5:
            int r1 = 2147483639;
            if ((r4 - 2147483639) <= 0) goto L11;
            if (r3 <= 2147483639) goto L10;
            r1 = Integer.MAX_VALUE;
        L10:
            return r1;
        L11:
            return r4;
        }

        private a() {
        }

        public final void a(int r3, int r4) {
            if (r3 < 0) goto L6;
            if (r3 >= r4) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r3 + ", size: " + r4);
        }

        public final void b(int r3, int r4) {
            if (r3 < 0) goto L6;
            if (r3 > r4) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r3 + ", size: " + r4);
        }

        public final void a(int r3, int r4, int r5) {
            if (r3 < 0) goto L10;
            if (r4 > r5) goto L10;
            if (r3 > r4) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("fromIndex: " + r3 + " > toIndex: " + r4);
        L10:
            throw new IndexOutOfBoundsException("fromIndex: " + r3 + ", toIndex: " + r4 + ", size: " + r5);
        }

        public final void b(int r3, int r4, int r5) {
            if (r3 < 0) goto L10;
            if (r4 > r5) goto L10;
            if (r3 > r4) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("startIndex: " + r3 + " > endIndex: " + r4);
        L10:
            throw new IndexOutOfBoundsException("startIndex: " + r3 + ", endIndex: " + r4 + ", size: " + r5);
        }

        public final int a(Collection<?> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "c");
            Iterator<E> r3 = r1.iterator();
            int r4 = 1;
        L4:
            if (r3.hasNext() == false) goto L10;
            E r0 = r3.next();
            int r5 = r4 * 31;
            if (r0 == null) goto L8;
            int r6 = r0.hashCode();
        L9:
            r4 = r5 + r6;
            goto L4
        L8:
            r6 = 0;
            goto L9
        L10:
            return r4;
        }

        public final boolean a(Collection<?> r3, Collection<?> r4) {
            Collection r2 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
            Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r2, "c");
            d.h.b.o.e(r5, "other");
            if (r2.size() == r5.size()) goto L5;
            return false;
        L5:
            Iterator<E> r6 = r5.iterator();
            Iterator<E> r7 = r2.iterator();
        L7:
            if (r7.hasNext() == false) goto L11;
            if (d.h.b.o.a(r7.next(), r6.next()) == true) goto L7;
            return false;
        L11:
            return true;
        }
    }

    /* JADX INFO: compiled from: AbstractList.kt */
    private class b implements d.h.b.a.a, Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c<E> f38374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f38375b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public b(c r1) {
            this.f38374a = r1;
        }

        public final int a() {
            return this.f38375b;
        }

        public final void a(int r1) {
            this.f38375b = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38375b >= this.f38374a.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext() == false) goto L7;
            c<E> r0 = this.f38374a;
            int r1 = this.f38375b;
            this.f38375b = r1 + 1;
            return r0.get(r1);
        L7:
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: renamed from: d.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractList.kt */
    private class C1034c extends c<E>.b implements d.h.b.a.a, ListIterator<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c<E> f38376b;

        @Override // java.util.ListIterator
        public void add(E r1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(E r1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public C1034c(c r2, int r3) {
            this.f38376b = r2;
            super(r2);
            c.f38373a.b(r3, r2.size());
            a(r3);
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (a() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious() == false) goto L7;
            c<E> r0 = this.f38376b;
            a(a() - 1);
            return r0.get(a());
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }
    }

    /* JADX INFO: compiled from: AbstractList.kt */
    private static final class d<E> extends c<E> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c<E> f38377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f38378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f38379d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(c<? extends E> r2, int r3, int r4) {
            d.h.b.o.e(r2, "list");
            this.f38377b = r2;
            this.f38378c = r3;
            c.f38373a.a(r3, r4, r2.size());
            this.f38379d = r4 - r3;
        }

        @Override // d.a.c, java.util.List
        public E get(int r3) {
            c.f38373a.a(r3, this.f38379d);
            return this.f38377b.get(this.f38378c + r3);
        }

        @Override // d.a.a
        public int a() {
            return this.f38379d;
        }
    }

    static {
        f38373a = new a(null);
    }

    @Override // java.util.List
    public void add(int r1, E r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r1, Collection<? extends E> r2) {
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract E get(int r1);

    @Override // java.util.List
    public E remove(int r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int r1, E r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public c() {
    }

    public Iterator<E> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new b(this), Iterator.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.List
    public int indexOf(E r3) {
        Iterator<E> r2 = ((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.aiagent.plugin")).iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L9;
        if (d.h.b.o.a(r2.next(), r3) == true) goto L13;
        r0 = r0 + 1;
        goto L4
    L13:
        return r0;
    L9:
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(E r3) {
        List r2 = (List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.aiagent.plugin");
        ListIterator<E> r4 = r2.listIterator(r2.size());
    L4:
        if (r4.hasPrevious() == false) goto L8;
        if (d.h.b.o.a(r4.previous(), r3) == false) goto L4;
        return r4.nextIndex();
    L8:
        return -1;
    }

    public ListIterator<E> listIterator() {
        return (ListIterator) ZeusTransformUtils.preCheckCast(new C1034c(this, 0), ListIterator.class, "com.obric.aiagent.plugin");
    }

    public ListIterator<E> listIterator(int r2) {
        return (ListIterator) ZeusTransformUtils.preCheckCast(new C1034c(this, r2), ListIterator.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.List
    public List<E> subList(int r2, int r3) {
        return (List) ZeusTransformUtils.preCheckCast(new d(this, r2, r3), List.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, List.class) == true) goto L10;
        return false;
    L10:
        return f38373a.a((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f38373a.a((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin"));
    }
}
