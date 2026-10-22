package androidx.datastore.preferences.protobuf;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class m1 implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public Iterator f908f;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f908f.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f908f.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
