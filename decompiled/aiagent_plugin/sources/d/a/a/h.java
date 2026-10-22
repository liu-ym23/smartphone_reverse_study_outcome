package d.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SetBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h<E> extends d.a.f<E> implements d.h.b.a.h, Serializable, Set<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f38341a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final h f38342c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d<E, ?> f38343b;

    /* JADX INFO: compiled from: SetBuilder.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public h(d<E, ?> r2) {
        o.e(r2, "backing");
        this.f38343b = r2;
    }

    static {
        f38341a = new a(null);
        f38342c = new h(d.f38327a.a());
    }

    public h() {
        this(new d());
    }

    public final Set<E> b() {
        this.f38343b.b();
        if (size() > 0) goto L7;
        h<E> this = f38342c;
    L7:
        return (Set) ZeusTransformUtils.preCheckCast(this, Set.class, "com.obric.aiagent.plugin");
    }

    @Override // d.a.f
    public int a() {
        return this.f38343b.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f38343b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        return this.f38343b.containsKey(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f38343b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E r1) {
        if (this.f38343b.a(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r1) {
        return this.f38343b.b(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(this.f38343b.h(), Iterator.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r4, "elements");
        this.f38343b.g();
        return super.addAll(r4);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r4, "elements");
        this.f38343b.g();
        return super.removeAll(r4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r4, "elements");
        this.f38343b.g();
        return super.retainAll(r4);
    }
}
