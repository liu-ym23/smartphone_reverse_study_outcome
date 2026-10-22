package d.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g<V> extends d.a.d<V> implements d.h.b.a.b, Collection<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d<?, V> f38340a;

    public g(d<?, V> r2) {
        o.e(r2, "backing");
        this.f38340a = r2;
    }

    @Override // d.a.d
    public int a() {
        return this.f38340a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f38340a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object r1) {
        return this.f38340a.containsValue(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(V r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends V> r2) {
        o.e((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin"), "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f38340a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(this.f38340a.i(), Iterator.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object r1) {
        return this.f38340a.c(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r4, "elements");
        this.f38340a.g();
        return super.removeAll(r4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r4, "elements");
        this.f38340a.g();
        return super.retainAll(r4);
    }
}
