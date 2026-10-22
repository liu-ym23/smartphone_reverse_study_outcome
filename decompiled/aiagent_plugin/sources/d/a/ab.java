package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ab implements d.h.b.a.a, Serializable, List, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ab f38345a = null;

    static {
        f38345a = new ab();
    }

    public int a() {
        return 0;
    }

    public boolean a(Void r1) {
        d.h.b.o.e(r1, "element");
        return false;
    }

    @Override // java.util.List
    public /* synthetic */ void add(int r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* synthetic */ boolean add(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r1, Collection r2) {
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int b(Void r1) {
        d.h.b.o.e(r1, "element");
        return -1;
    }

    public int c(Void r1) {
        d.h.b.o.e(r1, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.List
    public /* synthetic */ Object remove(int r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* synthetic */ Object set(int r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return d.h.b.g.a((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r3) {
        d.h.b.o.e(r3, "array");
        return (T[]) d.h.b.g.a((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin"), r3);
    }

    public String toString() {
        return "[]";
    }

    private ab() {
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Void.class) == true) goto L7;
        return false;
    L7:
        return a((Void) ZeusTransformUtils.preCheckCast(r3, Void.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.List
    public /* synthetic */ Object get(int r1) {
        return a(r1);
    }

    @Override // java.util.List
    public final int indexOf(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Void.class) == true) goto L7;
        return -1;
    L7:
        return b((Void) ZeusTransformUtils.preCheckCast(r3, Void.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Void.class) == true) goto L7;
        return -1;
    L7:
        return c((Void) ZeusTransformUtils.preCheckCast(r3, Void.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return a();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, List.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "elements");
        return r1.isEmpty();
    }

    public Void a(int r3) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + r3 + '.');
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(aa.f38344a, Iterator.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return (ListIterator) ZeusTransformUtils.preCheckCast(aa.f38344a, ListIterator.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.List
    public ListIterator listIterator(int r3) {
        if (r3 != 0) goto L6;
        return (ListIterator) ZeusTransformUtils.preCheckCast(aa.f38344a, ListIterator.class, "com.obric.aiagent.plugin");
    L6:
        throw new IndexOutOfBoundsException("Index: " + r3);
    }

    @Override // java.util.List
    public List subList(int r3, int r4) {
        if (r3 != 0) goto L7;
        if (r4 != 0) goto L7;
        return (List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.aiagent.plugin");
    L7:
        throw new IndexOutOfBoundsException("fromIndex: " + r3 + ", toIndex: " + r4);
    }
}
