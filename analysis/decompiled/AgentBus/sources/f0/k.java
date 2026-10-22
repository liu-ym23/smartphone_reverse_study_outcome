package f0;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class k extends a {

    /* renamed from: h, reason: collision with root package name */
    public int f3353h;

    /* renamed from: i, reason: collision with root package name */
    public Object[] f3354i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3355j;

    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public k(Object[] objArr, int i2, int i10, int i11) {
        super(i2, i10);
        this.f3353h = i11;
        Object[] objArr2 = new Object[i11];
        this.f3354i = objArr2;
        ?? r52 = i2 == i10 ? 1 : 0;
        this.f3355j = r52;
        objArr2[0] = objArr;
        c(i2 - r52, 1);
    }

    public final Object a() {
        int i2 = this.f3326f & 31;
        Object obj = this.f3354i[this.f3353h - 1];
        q7.k.c(obj, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
        return ((Object[]) obj)[i2];
    }

    public final void c(int i2, int i10) {
        int i11 = (this.f3353h - i10) * 5;
        while (i10 < this.f3353h) {
            Object[] objArr = this.f3354i;
            Object obj = objArr[i10 - 1];
            q7.k.c(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr[i10] = ((Object[]) obj)[a.a.R(i2, i11)];
            i11 -= 5;
            i10++;
        }
    }

    public final void d(int i2) {
        int i10 = 0;
        while (a.a.R(this.f3326f, i10) == i2) {
            i10 += 5;
        }
        if (i10 > 0) {
            c(this.f3326f, ((this.f3353h - 1) - (i10 / 5)) + 1);
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objA = a();
        int i2 = this.f3326f + 1;
        this.f3326f = i2;
        if (i2 == this.f3327g) {
            this.f3355j = true;
            return objA;
        }
        d(0);
        return objA;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        this.f3326f--;
        if (this.f3355j) {
            this.f3355j = false;
            return a();
        }
        d(31);
        return a();
    }
}
