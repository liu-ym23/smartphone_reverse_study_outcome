package D7;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public final class J extends AbstractC0218j {

    /* renamed from: a, reason: collision with root package name */
    public final List f396a;

    public J(List delegate) {
        kotlin.jvm.internal.k.f(delegate, "delegate");
        this.f396a = delegate;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        this.f396a.add(v.q0(i, this), obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f396a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f396a.get(v.p0(i, this));
    }

    @Override // D7.AbstractC0218j
    /* renamed from: getSize */
    public final int getB() {
        return this.f396a.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new I(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new I(this, 0);
    }

    @Override // D7.AbstractC0218j
    public final Object removeAt(int i) {
        return this.f396a.remove(v.p0(i, this));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        return this.f396a.set(v.p0(i, this), obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new I(this, i);
    }
}
