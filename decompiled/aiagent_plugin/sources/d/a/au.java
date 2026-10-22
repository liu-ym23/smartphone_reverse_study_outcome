package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes4.dex */
final class au<T> extends e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<T> f38353a;

    /* JADX INFO: compiled from: ReversedViews.kt */
    public static final class a implements d.h.b.a.f, ListIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ au<T> f38354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ListIterator<T> f38355b;

        a(au<T> r4, int r5) {
            this.f38354a = r4;
            this.f38355b = au.a(r4).listIterator(x.b((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), r5));
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f38355b.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f38355b.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.f38355b.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return x.c((List) ZeusTransformUtils.preCheckCast(this.f38354a, List.class, "com.obric.aiagent.plugin"), this.f38355b.previousIndex());
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.f38355b.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return x.c((List) ZeusTransformUtils.preCheckCast(this.f38354a, List.class, "com.obric.aiagent.plugin"), this.f38355b.nextIndex());
        }

        @Override // java.util.ListIterator
        public void add(T r2) {
            this.f38355b.add(r2);
            this.f38355b.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.f38355b.remove();
        }

        @Override // java.util.ListIterator
        public void set(T r1) {
            this.f38355b.set(r1);
        }
    }

    public au(List<T> r3) {
        List<T> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "delegate");
        this.f38353a = r4;
    }

    public static final /* synthetic */ List a(au r0) {
        return r0.f38353a;
    }

    @Override // d.a.e
    public int a() {
        return this.f38353a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r4) {
        return this.f38353a.get(x.a((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.aiagent.plugin"), r4));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f38353a.clear();
    }

    @Override // d.a.e
    public T a(int r4) {
        return this.f38353a.remove(x.a((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.aiagent.plugin"), r4));
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int r4, T r5) {
        return this.f38353a.set(x.a((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.aiagent.plugin"), r4), r5);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r4, T r5) {
        this.f38353a.add(x.b((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.aiagent.plugin"), r4), r5);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(listIterator(0), Iterator.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<T> listIterator(int r2) {
        return (ListIterator) ZeusTransformUtils.preCheckCast(new a(this, r2), ListIterator.class, "com.obric.aiagent.plugin");
    }
}
