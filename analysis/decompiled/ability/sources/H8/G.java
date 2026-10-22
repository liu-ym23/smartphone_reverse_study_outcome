package H8;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class G extends AbstractList implements RandomAccess, p {

    /* renamed from: a, reason: collision with root package name */
    public final o f766a;

    public G(o oVar) {
        this.f766a = oVar;
    }

    @Override // H8.p
    public final void d(r rVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return (String) this.f766a.get(i);
    }

    @Override // H8.p
    public final AbstractC0244e getByteString(int i) {
        return this.f766a.getByteString(i);
    }

    @Override // H8.p
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f766a.f778a);
    }

    @Override // H8.p
    public final G getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        F f = new F();
        f.f765a = this.f766a.iterator();
        return f;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        E e = new E();
        e.f764a = this.f766a.listIterator(i);
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f766a.size();
    }
}
