package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h1 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f1464a;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1464a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f1464a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
