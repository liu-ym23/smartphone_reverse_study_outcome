package o0;

import java.util.ListIterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a implements ListIterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public int f8974c;

    /* renamed from: f, reason: collision with root package name */
    public int f8975f;

    public a(int i, int i3) {
        this.f8974c = i;
        this.f8975f = i3;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f8974c < this.f8975f;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f8974c > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f8974c;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f8974c - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
