package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes4.dex */
final class g<T> implements d.h.b.a.a, Collection<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T[] f38380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f38381b;

    @Override // java.util.Collection
    public boolean add(T r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean remove(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r3) {
        d.h.b.o.e(r3, "array");
        return (T[]) d.h.b.g.a((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin"), r3);
    }

    public g(T[] r2, boolean r3) {
        d.h.b.o.e(r2, "values");
        this.f38380a = r2;
        this.f38381b = r3;
    }

    @Override // java.util.Collection
    public final int size() {
        return a();
    }

    public int a() {
        return this.f38380a.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        if (this.f38380a.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection
    public boolean contains(Object r1) {
        return i.b(this.f38380a, r1);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "elements");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L15;
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L16;
        if (contains(r6.next()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return d.h.b.c.a(this.f38380a);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return p.a(this.f38380a, this.f38381b);
    }
}
