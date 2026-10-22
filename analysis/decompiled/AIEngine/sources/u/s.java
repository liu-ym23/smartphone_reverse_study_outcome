package u;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class s<K, V, T> implements Iterator<T>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f13133a = r.f13126e.f13130d;

    /* renamed from: b, reason: collision with root package name */
    public int f13134b;

    /* renamed from: c, reason: collision with root package name */
    public int f13135c;

    public final void a(Object[] objArr, int i10, int i11) {
        this.f13133a = objArr;
        this.f13134b = i10;
        this.f13135c = i11;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13135c < this.f13134b;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
