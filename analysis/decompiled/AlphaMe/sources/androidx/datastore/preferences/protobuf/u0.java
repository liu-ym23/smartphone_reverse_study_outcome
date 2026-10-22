package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class u0 extends AbstractList implements I, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final I f3542a;

    public u0(I i4) {
        this.f3542a = i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i4) {
        return (String) this.f3542a.get(i4);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new t0(this);
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public final I k() {
        return this;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public final void l(AbstractC0259h abstractC0259h) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i4) {
        return new s0(this, i4);
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public final Object m(int i4) {
        return this.f3542a.m(i4);
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public final List n() {
        return this.f3542a.n();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3542a.size();
    }
}
