package d.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e<K, V> extends a<Map.Entry<K, V>, K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d<K, V> f38338a;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* synthetic */ boolean add(Object r3) {
        return d((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"));
    }

    public e(d<K, V> r2) {
        o.e(r2, "backing");
        this.f38338a = r2;
    }

    @Override // d.a.f
    public int a() {
        return this.f38338a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f38338a.isEmpty();
    }

    @Override // d.a.a.a
    public boolean b(Map.Entry<? extends K, ? extends V> r3) {
        Map.Entry<? extends K, ? extends V> r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        o.e(r4, "element");
        return this.f38338a.a(r4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f38338a.clear();
    }

    public boolean d(Map.Entry<K, V> r2) {
        o.e((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin"), "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map.Entry<K, V>> r2) {
        o.e((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin"), "elements");
        throw new UnsupportedOperationException();
    }

    @Override // d.a.a.a
    public boolean c(Map.Entry r3) {
        Map.Entry<? extends K, ? extends V> r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        o.e(r4, "element");
        return this.f38338a.b(r4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(this.f38338a.j(), Iterator.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r4, "elements");
        return this.f38338a.a(r4);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r4, "elements");
        this.f38338a.g();
        return super.removeAll(r4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r4, "elements");
        this.f38338a.g();
        return super.retainAll(r4);
    }
}
