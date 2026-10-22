package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: Sets.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ad implements d.h.b.a.a, Serializable, Set {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ad f38347a = null;

    static {
        f38347a = new ad();
    }

    public int a() {
        return 0;
    }

    public boolean a(Void r1) {
        d.h.b.o.e(r1, "element");
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public /* synthetic */ boolean add(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return d.h.b.g.a((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] r3) {
        d.h.b.o.e(r3, "array");
        return (T[]) d.h.b.g.a((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin"), r3);
    }

    public String toString() {
        return "[]";
    }

    private ad() {
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Void.class) == true) goto L7;
        return false;
    L7:
        return a((Void) ZeusTransformUtils.preCheckCast(r3, Void.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return a();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Set.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "elements");
        return r1.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(aa.f38344a, Iterator.class, "com.obric.aiagent.plugin");
    }
}
