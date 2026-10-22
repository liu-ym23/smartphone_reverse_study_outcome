package f0;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class i extends a {

    /* renamed from: h, reason: collision with root package name */
    public final g f3347h;

    /* renamed from: i, reason: collision with root package name */
    public int f3348i;

    /* renamed from: j, reason: collision with root package name */
    public k f3349j;

    /* renamed from: k, reason: collision with root package name */
    public int f3350k;

    public i(g gVar, int i2) {
        super(i2, gVar.f3344m);
        this.f3347h = gVar;
        this.f3348i = gVar.j();
        this.f3350k = -1;
        c();
    }

    public final void a() {
        if (this.f3348i != this.f3347h.j()) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // f0.a, java.util.ListIterator
    public final void add(Object obj) {
        a();
        int i2 = this.f3326f;
        g gVar = this.f3347h;
        gVar.add(i2, obj);
        this.f3326f++;
        this.f3327g = gVar.a();
        this.f3348i = gVar.j();
        this.f3350k = -1;
        c();
    }

    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public final void c() {
        g gVar = this.f3347h;
        Object[] objArr = gVar.f3342k;
        if (objArr == null) {
            this.f3349j = null;
            return;
        }
        int i2 = (gVar.f3344m - 1) & (-32);
        int i10 = this.f3326f;
        if (i10 > i2) {
            i10 = i2;
        }
        int i11 = (gVar.f3340i / 5) + 1;
        k kVar = this.f3349j;
        if (kVar == null) {
            this.f3349j = new k(objArr, i10, i2, i11);
            return;
        }
        kVar.f3326f = i10;
        kVar.f3327g = i2;
        kVar.f3353h = i11;
        if (kVar.f3354i.length < i11) {
            kVar.f3354i = new Object[i11];
        }
        kVar.f3354i[0] = objArr;
        ?? r02 = i10 == i2 ? 1 : 0;
        kVar.f3355j = r02;
        kVar.c(i10 - r02, 1);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        a();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f3326f;
        this.f3350k = i2;
        k kVar = this.f3349j;
        g gVar = this.f3347h;
        if (kVar == null) {
            Object[] objArr = gVar.f3343l;
            this.f3326f = i2 + 1;
            return objArr[i2];
        }
        if (kVar.hasNext()) {
            this.f3326f++;
            return kVar.next();
        }
        Object[] objArr2 = gVar.f3343l;
        int i10 = this.f3326f;
        this.f3326f = i10 + 1;
        return objArr2[i10 - kVar.f3327g];
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        a();
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f3326f;
        this.f3350k = i2 - 1;
        k kVar = this.f3349j;
        g gVar = this.f3347h;
        if (kVar == null) {
            Object[] objArr = gVar.f3343l;
            int i10 = i2 - 1;
            this.f3326f = i10;
            return objArr[i10];
        }
        int i11 = kVar.f3327g;
        if (i2 <= i11) {
            this.f3326f = i2 - 1;
            return kVar.previous();
        }
        Object[] objArr2 = gVar.f3343l;
        int i12 = i2 - 1;
        this.f3326f = i12;
        return objArr2[i12 - i11];
    }

    @Override // f0.a, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        a();
        int i2 = this.f3350k;
        if (i2 == -1) {
            throw new IllegalStateException();
        }
        g gVar = this.f3347h;
        gVar.f(i2);
        int i10 = this.f3350k;
        if (i10 < this.f3326f) {
            this.f3326f = i10;
        }
        this.f3327g = gVar.a();
        this.f3348i = gVar.j();
        this.f3350k = -1;
        c();
    }

    @Override // f0.a, java.util.ListIterator
    public final void set(Object obj) {
        a();
        int i2 = this.f3350k;
        if (i2 == -1) {
            throw new IllegalStateException();
        }
        g gVar = this.f3347h;
        gVar.set(i2, obj);
        this.f3348i = gVar.j();
        c();
    }
}
