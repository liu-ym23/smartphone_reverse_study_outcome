package t;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h<T> extends a<T> {

    /* renamed from: c, reason: collision with root package name */
    public final f<T> f12889c;

    /* renamed from: d, reason: collision with root package name */
    public int f12890d;

    /* renamed from: e, reason: collision with root package name */
    public k<? extends T> f12891e;
    public int h;

    public h(f<T> fVar, int i10) {
        super(i10, fVar.f12886k);
        this.f12889c = fVar;
        this.f12890d = fVar.f();
        this.h = -1;
        b();
    }

    public final void a() {
        if (this.f12890d != this.f12889c.f()) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // t.a, java.util.ListIterator
    public final void add(T t8) {
        a();
        int i10 = this.f12871a;
        f<T> fVar = this.f12889c;
        fVar.add(i10, t8);
        this.f12871a++;
        this.f12872b = fVar.a();
        this.f12890d = fVar.f();
        this.h = -1;
        b();
    }

    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public final void b() {
        f<T> fVar = this.f12889c;
        Object[] objArr = fVar.h;
        if (objArr == null) {
            this.f12891e = null;
            return;
        }
        int i10 = (fVar.f12886k - 1) & (-32);
        int i11 = this.f12871a;
        if (i11 > i10) {
            i11 = i10;
        }
        int i12 = (fVar.f12883d / 5) + 1;
        k<? extends T> kVar = this.f12891e;
        if (kVar == null) {
            this.f12891e = new k<>(objArr, i11, i10, i12);
            return;
        }
        kVar.f12871a = i11;
        kVar.f12872b = i10;
        kVar.f12895c = i12;
        if (kVar.f12896d.length < i12) {
            kVar.f12896d = new Object[i12];
        }
        kVar.f12896d[0] = objArr;
        ?? r02 = i11 == i10 ? 1 : 0;
        kVar.f12897e = r02;
        kVar.b(i11 - r02, 1);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final T next() {
        a();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f12871a;
        this.h = i10;
        k<? extends T> kVar = this.f12891e;
        f<T> fVar = this.f12889c;
        if (kVar == null) {
            Object[] objArr = fVar.f12885j;
            this.f12871a = i10 + 1;
            return (T) objArr[i10];
        }
        if (kVar.hasNext()) {
            this.f12871a++;
            return kVar.next();
        }
        Object[] objArr2 = fVar.f12885j;
        int i11 = this.f12871a;
        this.f12871a = i11 + 1;
        return (T) objArr2[i11 - kVar.f12872b];
    }

    @Override // java.util.ListIterator
    public final T previous() {
        a();
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f12871a;
        this.h = i10 - 1;
        k<? extends T> kVar = this.f12891e;
        f<T> fVar = this.f12889c;
        if (kVar == null) {
            Object[] objArr = fVar.f12885j;
            int i11 = i10 - 1;
            this.f12871a = i11;
            return (T) objArr[i11];
        }
        int i12 = kVar.f12872b;
        if (i10 <= i12) {
            this.f12871a = i10 - 1;
            return kVar.previous();
        }
        Object[] objArr2 = fVar.f12885j;
        int i13 = i10 - 1;
        this.f12871a = i13;
        return (T) objArr2[i13 - i12];
    }

    @Override // t.a, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        a();
        int i10 = this.h;
        if (i10 == -1) {
            throw new IllegalStateException();
        }
        f<T> fVar = this.f12889c;
        fVar.b(i10);
        int i11 = this.h;
        if (i11 < this.f12871a) {
            this.f12871a = i11;
        }
        this.f12872b = fVar.a();
        this.f12890d = fVar.f();
        this.h = -1;
        b();
    }

    @Override // t.a, java.util.ListIterator
    public final void set(T t8) {
        a();
        int i10 = this.h;
        if (i10 == -1) {
            throw new IllegalStateException();
        }
        f<T> fVar = this.f12889c;
        fVar.set(i10, t8);
        this.f12890d = fVar.f();
        b();
    }
}
