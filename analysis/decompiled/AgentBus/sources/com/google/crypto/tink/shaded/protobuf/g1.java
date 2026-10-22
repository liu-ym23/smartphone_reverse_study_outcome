package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class g1 implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public Iterator f2208f;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2208f.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f2208f.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
