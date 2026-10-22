package f9;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class y implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public final x f3604f;

    /* renamed from: g, reason: collision with root package name */
    public androidx.datastore.preferences.protobuf.d f3605g;

    /* renamed from: h, reason: collision with root package name */
    public int f3606h;

    public y(z zVar) {
        x xVar = new x(zVar);
        this.f3604f = xVar;
        this.f3605g = new androidx.datastore.preferences.protobuf.d(xVar.next());
        this.f3606h = zVar.f3608g;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3606h > 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f3605g.hasNext()) {
            this.f3605g = new androidx.datastore.preferences.protobuf.d(this.f3604f.next());
        }
        this.f3606h--;
        return Byte.valueOf(this.f3605g.a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
