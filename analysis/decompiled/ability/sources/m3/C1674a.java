package m3;

import com.google.common.collect.ImmutableList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import k3.AbstractC1622a;

/* renamed from: m3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1674a extends AbstractC1677d implements ListIterator {

    /* renamed from: a, reason: collision with root package name */
    public final int f5298a;
    public int b;
    public final ImmutableList c;

    public C1674a(ImmutableList immutableList, int i) {
        int size = immutableList.size();
        AbstractC1622a.c(i, size);
        this.f5298a = size;
        this.b = i;
        this.c = immutableList;
    }

    public final Object a(int i) {
        return this.c.get(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.b < this.f5298a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.b = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
