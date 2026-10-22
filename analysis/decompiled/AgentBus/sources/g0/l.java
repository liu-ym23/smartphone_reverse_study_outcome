package g0;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class l implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public Object[] f3692f = k.f3687e.f3691d;

    /* renamed from: g, reason: collision with root package name */
    public int f3693g;

    /* renamed from: h, reason: collision with root package name */
    public int f3694h;

    public final void a(Object[] objArr, int i2, int i10) {
        this.f3692f = objArr;
        this.f3693g = i2;
        this.f3694h = i10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3694h < this.f3693g;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
