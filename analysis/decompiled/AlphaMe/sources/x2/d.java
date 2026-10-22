package x2;

import androidx.fragment.app.A;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class d implements Iterator, Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f15927a;

    /* renamed from: b, reason: collision with root package name */
    public int f15928b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15929c = true;

    public d(Object[] objArr) {
        this.f15927a = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f15929c) {
            return this.f15928b < this.f15927a.length;
        }
        throw new A("#iterator() cannot be used nested.", 7);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i4 = this.f15928b;
        Object[] objArr = this.f15927a;
        if (i4 >= objArr.length) {
            throw new NoSuchElementException(String.valueOf(this.f15928b));
        }
        if (!this.f15929c) {
            throw new A("#iterator() cannot be used nested.", 7);
        }
        this.f15928b = i4 + 1;
        return objArr[i4];
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new A("Remove not allowed.", 7);
    }
}
