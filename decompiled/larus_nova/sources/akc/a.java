package akc;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;

/* JADX INFO: loaded from: classes40.dex */
public class a<E> implements Collection<E>, KMutableCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Collection<E> f4106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4107b;

    @Override // java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    @Override // java.util.Collection
    public final void clear() {
        Object r100 = this.f4107b;
        monitor-enter(r100);
        this.f4106a.clear();     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        Object r100 = this.f4107b;
        monitor-enter(r100);
        boolean r101 = this.f4106a.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        Object r100 = this.f4107b;
        monitor-enter(r100);
        b r101 = new b(this.f4107b, this.f4106a.iterator());     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public final int size() {
        Object r100 = this.f4107b;
        monitor-enter(r100);
        int r101 = this.f4106a.size();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public final boolean add(E r100) {
        Object r101 = this.f4107b;
        monitor-enter(r101);
        boolean r102 = this.f4106a.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Object r101 = this.f4107b;
        monitor-enter(r101);
        boolean r102 = this.f4106a.addAll(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public final boolean contains(Object r100) {
        Object r101 = this.f4107b;
        monitor-enter(r101);
        boolean r102 = this.f4106a.contains(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Object r101 = this.f4107b;
        monitor-enter(r101);
        boolean r102 = this.f4106a.containsAll(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public final boolean remove(Object r100) {
        Object r101 = this.f4107b;
        monitor-enter(r101);
        boolean r102 = this.f4106a.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Object r101 = this.f4107b;
        monitor-enter(r101);
        boolean r102 = this.f4106a.removeAll(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Object r101 = this.f4107b;
        monitor-enter(r101);
        boolean r102 = this.f4106a.retainAll(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public a(Collection<E> r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f4106a = r100;
        if (r101 != null) goto L5;
        r101 = new Object();
    L5:
        this.f4107b = r101;
    }
}
