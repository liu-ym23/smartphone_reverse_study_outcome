package com.google.android.gms.internal.location;

import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: classes.dex */
public abstract class l implements ListIterator, Iterator {
    public final void a() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ void remove() {
        a();
        throw null;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
