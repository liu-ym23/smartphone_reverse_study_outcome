package f9;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class h0 extends AbstractList implements RandomAccess, t {

    /* renamed from: f, reason: collision with root package name */
    public final s f3561f;

    public h0(s sVar) {
        this.f3561f = sVar;
    }

    @Override // f9.t
    public final void c(u uVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return (String) this.f3561f.get(i2);
    }

    @Override // f9.t
    public final d getByteString(int i2) {
        return this.f3561f.getByteString(i2);
    }

    @Override // f9.t
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f3561f.f3599f);
    }

    @Override // f9.t
    public final h0 getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        g0 g0Var = new g0();
        g0Var.f3558f = this.f3561f.iterator();
        return g0Var;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        f0 f0Var = new f0();
        f0Var.f3555f = this.f3561f.listIterator(i2);
        return f0Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3561f.size();
    }
}
