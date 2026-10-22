package f0;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class h extends a {

    /* renamed from: h, reason: collision with root package name */
    public final Object[] f3345h;

    /* renamed from: i, reason: collision with root package name */
    public final k f3346i;

    public h(Object[] objArr, Object[] objArr2, int i2, int i10, int i11) {
        super(i2, i10);
        this.f3345h = objArr2;
        int i12 = (i10 - 1) & (-32);
        this.f3346i = new k(objArr, i2 > i12 ? i12 : i2, i12, i11);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        k kVar = this.f3346i;
        if (kVar.hasNext()) {
            this.f3326f++;
            return kVar.next();
        }
        int i2 = this.f3326f;
        this.f3326f = i2 + 1;
        return this.f3345h[i2 - kVar.f3327g];
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f3326f;
        k kVar = this.f3346i;
        int i10 = kVar.f3327g;
        if (i2 <= i10) {
            this.f3326f = i2 - 1;
            return kVar.previous();
        }
        int i11 = i2 - 1;
        this.f3326f = i11;
        return this.f3345h[i11 - i10];
    }
}
