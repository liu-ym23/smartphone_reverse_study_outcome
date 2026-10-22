package ea;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class e implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public boolean f3230f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3231g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f f3232h;

    public e(f fVar) {
        this.f3232h = fVar;
        this.f3231g = ((AbstractList) fVar).modCount;
    }

    public final void a() {
        f fVar = this.f3232h;
        int i2 = ((AbstractList) fVar).modCount;
        int i10 = this.f3231g;
        if (i2 == i10) {
            return;
        }
        throw new ConcurrentModificationException("ModCount: " + ((AbstractList) fVar).modCount + "; expected: " + i10);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f3230f;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f3230f) {
            throw new NoSuchElementException();
        }
        this.f3230f = true;
        a();
        return this.f3232h.f3234g;
    }

    @Override // java.util.Iterator
    public final void remove() {
        a();
        this.f3232h.clear();
    }
}
