package t;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g<T> extends a<T> {

    /* renamed from: c, reason: collision with root package name */
    public final T[] f12887c;

    /* renamed from: d, reason: collision with root package name */
    public final k<T> f12888d;

    public g(Object[] objArr, T[] tArr, int i10, int i11, int i12) {
        super(i10, i11);
        this.f12887c = tArr;
        int i13 = (i11 - 1) & (-32);
        this.f12888d = new k<>(objArr, i10 > i13 ? i13 : i10, i13, i12);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        k<T> kVar = this.f12888d;
        if (kVar.hasNext()) {
            this.f12871a++;
            return kVar.next();
        }
        int i10 = this.f12871a;
        this.f12871a = i10 + 1;
        return this.f12887c[i10 - kVar.f12872b];
    }

    @Override // java.util.ListIterator
    public final T previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f12871a;
        k<T> kVar = this.f12888d;
        int i11 = kVar.f12872b;
        if (i10 <= i11) {
            this.f12871a = i10 - 1;
            return kVar.previous();
        }
        int i12 = i10 - 1;
        this.f12871a = i12;
        return this.f12887c[i12 - i11];
    }
}
