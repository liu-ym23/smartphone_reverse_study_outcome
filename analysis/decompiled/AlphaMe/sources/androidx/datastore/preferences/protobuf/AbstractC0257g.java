package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: androidx.datastore.preferences.protobuf.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0257g implements Iterator {
    @Override // java.util.Iterator
    public final Object next() {
        C0255f c0255f = (C0255f) this;
        int i4 = c0255f.f3470a;
        if (i4 >= c0255f.f3471b) {
            throw new NoSuchElementException();
        }
        c0255f.f3470a = i4 + 1;
        return Byte.valueOf(c0255f.f3472c.f(i4));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
