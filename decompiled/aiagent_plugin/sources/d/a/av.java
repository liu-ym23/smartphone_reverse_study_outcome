package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes4.dex */
class av<T> extends c<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<T> f38356b;

    /* JADX INFO: compiled from: ReversedViews.kt */
    public static final class a implements d.h.b.a.a, ListIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ av<T> f38357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ListIterator<T> f38358b;

        @Override // java.util.ListIterator
        public void add(T r1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(T r1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(av<? extends T> r4, int r5) {
            this.f38357a = r4;
            this.f38358b = av.a(r4).listIterator(x.b((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), r5));
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f38358b.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f38358b.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.f38358b.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return x.c((List) ZeusTransformUtils.preCheckCast(this.f38357a, List.class, "com.obric.aiagent.plugin"), this.f38358b.previousIndex());
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.f38358b.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return x.c((List) ZeusTransformUtils.preCheckCast(this.f38357a, List.class, "com.obric.aiagent.plugin"), this.f38358b.nextIndex());
        }
    }

    public av(List<? extends T> r3) {
        List<T> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "delegate");
        this.f38356b = r4;
    }

    public static final /* synthetic */ List a(av r0) {
        return r0.f38356b;
    }

    @Override // d.a.a
    public int a() {
        return this.f38356b.size();
    }

    @Override // d.a.c, java.util.List
    public T get(int r4) {
        return this.f38356b.get(x.a((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.aiagent.plugin"), r4));
    }

    @Override // d.a.c, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(listIterator(0), Iterator.class, "com.obric.aiagent.plugin");
    }

    @Override // d.a.c, java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // d.a.c, java.util.List
    public ListIterator<T> listIterator(int r2) {
        return (ListIterator) ZeusTransformUtils.preCheckCast(new a(this, r2), ListIterator.class, "com.obric.aiagent.plugin");
    }
}
