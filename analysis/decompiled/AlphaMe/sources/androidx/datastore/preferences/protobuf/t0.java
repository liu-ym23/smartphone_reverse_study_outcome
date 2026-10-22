package androidx.datastore.preferences.protobuf;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class t0 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f3538a;

    public t0(u0 u0Var) {
        this.f3538a = u0Var.f3542a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3538a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f3538a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
