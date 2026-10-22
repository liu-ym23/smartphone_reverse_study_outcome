package o0;

import h5.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends a {

    /* renamed from: g, reason: collision with root package name */
    public int f8997g;

    /* renamed from: h, reason: collision with root package name */
    public Object[] f8998h;
    public boolean i;

    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public j(Object[] objArr, int i, int i3, int i10) {
        super(i, i3);
        this.f8997g = i10;
        Object[] objArr2 = new Object[i10];
        this.f8998h = objArr2;
        ?? r52 = i == i3 ? 1 : 0;
        this.i = r52;
        objArr2[0] = objArr;
        b(i - r52, 1);
    }

    public final Object a() {
        int i = this.f8974c & 31;
        Object obj = this.f8998h[this.f8997g - 1];
        obj.getClass();
        return ((Object[]) obj)[i];
    }

    public final void b(int i, int i3) {
        int i10 = (this.f8997g - i3) * 5;
        while (i3 < this.f8997g) {
            Object[] objArr = this.f8998h;
            Object obj = objArr[i3 - 1];
            obj.getClass();
            objArr[i3] = ((Object[]) obj)[t.D(i, i10)];
            i10 -= 5;
            i3++;
        }
    }

    public final void c(int i) {
        int i3 = 0;
        while (t.D(this.f8974c, i3) == i) {
            i3 += 5;
        }
        if (i3 > 0) {
            b(this.f8974c, ((this.f8997g - 1) - (i3 / 5)) + 1);
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            g5.f.k();
            return null;
        }
        Object objA = a();
        int i = this.f8974c + 1;
        this.f8974c = i;
        if (i == this.f8975f) {
            this.i = true;
            return objA;
        }
        c(0);
        return objA;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            g5.f.k();
            return null;
        }
        this.f8974c--;
        if (this.i) {
            this.i = false;
            return a();
        }
        c(31);
        return a();
    }
}
