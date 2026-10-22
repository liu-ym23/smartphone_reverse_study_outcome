package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: AbstractCollection.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<E> implements d.h.b.a.a, Collection<E> {

    /* JADX INFO: renamed from: d.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractCollection.kt */
    static final class C1030a extends d.h.b.p implements d.h.a.b<E, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<E> f38308a;

        /* JADX WARN: Multi-variable type inference failed */
        C1030a(a<? extends E> r1) {
            this.f38308a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ CharSequence invoke(Object r1) {
            return a(r1);
        }

        public final CharSequence a(E r2) {
            if (r2 != this.f38308a) goto L5;
            Object r1 = ZeusTransformUtils.preCheckCast("(this Collection)", CharSequence.class, "com.obric.aiagent.plugin");
        L7:
            return (CharSequence) r1;
        L5:
            r1 = ZeusTransformUtils.preCheckCast(String.valueOf(r2), CharSequence.class, "com.obric.aiagent.plugin");
            goto L7
        }
    }

    public abstract int a();

    @Override // java.util.Collection
    public boolean add(E r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> r2) {
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

    public a() {
    }

    @Override // java.util.Collection
    public final int size() {
        return a();
    }

    @Override // java.util.Collection
    public boolean contains(E r4) {
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(this, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L5;
    L7:
        Iterator r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if (d.h.b.o.a(r5.next(), r4) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "elements");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L15;
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L16;
        if (contains(r6.next()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(this, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.aiagent.plugin"), 0, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C1030a(this), d.h.a.b.class, "com.obric.aiagent.plugin"), 24, null);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return d.h.b.g.a((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r3) {
        d.h.b.o.e(r3, "array");
        return (T[]) d.h.b.g.a((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin"), r3);
    }
}
