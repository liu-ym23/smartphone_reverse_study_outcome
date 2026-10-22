package p0;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public Object[] f9676c = j.f9671e.f9675d;

    /* renamed from: f, reason: collision with root package name */
    public int f9677f;

    /* renamed from: g, reason: collision with root package name */
    public int f9678g;

    public final void a(Object[] objArr, int i, int i3) {
        this.f9676c = objArr;
        this.f9677f = i;
        this.f9678g = i3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9678g < this.f9677f;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
