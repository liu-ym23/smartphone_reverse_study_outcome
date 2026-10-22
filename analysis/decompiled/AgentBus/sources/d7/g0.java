package d7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class g0 extends h {

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f2963f;

    public g0(ArrayList arrayList) {
        this.f2963f = arrayList;
    }

    @Override // d7.h
    public final int a() {
        return this.f2963f.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        this.f2963f.add(r.G0(i2, this), obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f2963f.clear();
    }

    @Override // d7.h
    public final Object f(int i2) {
        return this.f2963f.remove(r.F0(i2, this));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return this.f2963f.get(r.F0(i2, this));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new f0(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new f0(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        return this.f2963f.set(r.F0(i2, this), obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        return new f0(this, i2);
    }
}
