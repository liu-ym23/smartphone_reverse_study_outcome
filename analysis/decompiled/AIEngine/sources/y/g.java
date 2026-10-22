package y;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g<T> implements ListIterator<T>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final SnapshotStateList<T> f13941a;

    /* renamed from: b, reason: collision with root package name */
    public int f13942b;

    /* renamed from: c, reason: collision with root package name */
    public int f13943c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f13944d;

    public g(SnapshotStateList<T> snapshotStateList, int i10) {
        this.f13941a = snapshotStateList;
        this.f13942b = i10 - 1;
        this.f13944d = e.e(snapshotStateList);
    }

    public final void a() {
        if (e.e(this.f13941a) != this.f13944d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(T t8) {
        a();
        int i10 = this.f13942b + 1;
        SnapshotStateList<T> snapshotStateList = this.f13941a;
        snapshotStateList.add(i10, t8);
        this.f13943c = -1;
        this.f13942b++;
        this.f13944d = e.e(snapshotStateList);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f13942b < this.f13941a.size() - 1;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f13942b >= 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final T next() {
        a();
        int i10 = this.f13942b + 1;
        this.f13943c = i10;
        SnapshotStateList<T> snapshotStateList = this.f13941a;
        e.a(i10, snapshotStateList.size());
        T t8 = snapshotStateList.get(i10);
        this.f13942b = i10;
        return t8;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f13942b + 1;
    }

    @Override // java.util.ListIterator
    public final T previous() {
        a();
        int i10 = this.f13942b;
        SnapshotStateList<T> snapshotStateList = this.f13941a;
        e.a(i10, snapshotStateList.size());
        int i11 = this.f13942b;
        this.f13943c = i11;
        this.f13942b--;
        return snapshotStateList.get(i11);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f13942b;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        a();
        int i10 = this.f13943c;
        SnapshotStateList<T> snapshotStateList = this.f13941a;
        snapshotStateList.remove(i10);
        this.f13942b--;
        this.f13943c = -1;
        this.f13944d = e.e(snapshotStateList);
    }

    @Override // java.util.ListIterator
    public final void set(T t8) {
        a();
        int i10 = this.f13943c;
        if (i10 < 0) {
            throw new IllegalStateException("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()");
        }
        SnapshotStateList<T> snapshotStateList = this.f13941a;
        snapshotStateList.set(i10, t8);
        this.f13944d = e.e(snapshotStateList);
    }
}
