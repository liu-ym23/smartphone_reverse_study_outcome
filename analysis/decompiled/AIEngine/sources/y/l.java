package y;

import androidx.compose.runtime.snapshots.SnapshotStateSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l<T> implements Iterator<T>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final SnapshotStateSet<T> f13950a;

    /* renamed from: b, reason: collision with root package name */
    public final Iterator<T> f13951b;

    /* renamed from: c, reason: collision with root package name */
    public T f13952c;

    /* renamed from: d, reason: collision with root package name */
    public T f13953d;

    /* renamed from: e, reason: collision with root package name */
    public int f13954e;

    /* JADX WARN: Multi-variable type inference failed */
    public l(SnapshotStateSet<T> snapshotStateSet, Iterator<? extends T> it) {
        this.f13950a = snapshotStateSet;
        this.f13951b = it;
        this.f13954e = f.b(snapshotStateSet);
        this.f13952c = this.f13953d;
        this.f13953d = it.hasNext() ? (T) it.next() : null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13953d != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (f.b(this.f13950a) != this.f13954e) {
            throw new ConcurrentModificationException();
        }
        this.f13952c = this.f13953d;
        Iterator<T> it = this.f13951b;
        this.f13953d = it.hasNext() ? it.next() : null;
        T t8 = this.f13952c;
        if (t8 != null) {
            return t8;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        SnapshotStateSet<T> snapshotStateSet = this.f13950a;
        if (f.b(snapshotStateSet) != this.f13954e) {
            throw new ConcurrentModificationException();
        }
        T t8 = this.f13952c;
        if (t8 == null) {
            throw new IllegalStateException();
        }
        snapshotStateSet.remove(t8);
        this.f13952c = null;
        lb.n nVar = lb.n.f10413a;
        this.f13954e = f.b(snapshotStateSet);
    }
}
