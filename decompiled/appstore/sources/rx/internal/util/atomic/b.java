package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends AbstractQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f24389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f24390b;

    public b() {
        this.f24389a = new AtomicReference();
        this.f24390b = new AtomicReference();
    }

    public final LinkedQueueNode a() {
        return (LinkedQueueNode) this.f24390b.get();
    }

    public final LinkedQueueNode b() {
        return (LinkedQueueNode) this.f24389a.get();
    }

    public final LinkedQueueNode c() {
        return (LinkedQueueNode) this.f24390b.get();
    }

    public final LinkedQueueNode d() {
        return (LinkedQueueNode) this.f24389a.get();
    }

    public final void e(LinkedQueueNode r10) {
        this.f24390b.lazySet(r10);
    }

    public final void f(LinkedQueueNode r10) {
        this.f24389a.lazySet(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        if (c() != d()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode r10 = c();
        LinkedQueueNode r11 = d();
        int r12 = 0;
    L3:
        if (r10 == r11) goto L10;
        if (r12 >= Integer.MAX_VALUE) goto L10;
    L6:
        LinkedQueueNode r13 = r10.lvNext();
        if (r13 == null) goto L6;
        r12 = r12 + 1;
        r10 = r13;
    L10:
        return r12;
    }
}
