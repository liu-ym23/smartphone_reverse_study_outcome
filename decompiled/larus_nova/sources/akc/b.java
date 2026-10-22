package akc;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes40.dex */
public final class b<E> implements Iterator<E>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterator<E> f4109b;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Object r100 = this.f4108a;
        monitor-enter(r100);
        boolean r101 = this.f4109b.hasNext();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Iterator
    public final E next() {
        Object r100 = this.f4108a;
        monitor-enter(r100);
        E r101 = this.f4109b.next();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Iterator
    public final void remove() {
        Object r100 = this.f4108a;
        monitor-enter(r100);
        this.f4109b.remove();     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Object r100, Iterator<? extends E> r101) {
        Intrinsics.checkNotNullParameter(r100, "lock");
        Intrinsics.checkNotNullParameter(r101, "del");
        this.f4108a = r100;
        this.f4109b = r101;
    }
}
