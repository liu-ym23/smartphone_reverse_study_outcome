package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class n1 extends AbstractList implements d0, RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    public final c0 f912f;

    public n1(c0 c0Var) {
        this.f912f = c0Var;
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final void d(g gVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return (String) this.f912f.get(i2);
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final Object getRaw(int i2) {
        return this.f912f.f836g.get(i2);
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f912f.f836g);
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final d0 getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        m1 m1Var = new m1();
        m1Var.f908f = this.f912f.iterator();
        return m1Var;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        l1 l1Var = new l1();
        l1Var.f900f = this.f912f.listIterator(i2);
        return l1Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f912f.size();
    }
}
