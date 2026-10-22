package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.h;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends AbstractQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f24387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24388b;

    public a(int r10) {
        int r11 = h.a(r10);
        this.f24388b = r11 - 1;
        this.f24387a = new AtomicReferenceArray(r11);
    }

    public final int a(long r10) {
        int r11 = this.f24388b;
        return r11 & ((int) r10);
    }

    public final int b(long r10, int r11) {
        return ((int) r10) & r11;
    }

    public final Object c(int r10) {
        return d(this.f24387a, r10);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
    L3:
        if (poll() != 0) goto L3;
        if (isEmpty() == false) goto L3;
    }

    public final Object d(AtomicReferenceArray r10, int r11) {
        return r10.get(r11);
    }

    public final void e(AtomicReferenceArray r10, int r11, Object r12) {
        r10.lazySet(r11, r12);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }
}
