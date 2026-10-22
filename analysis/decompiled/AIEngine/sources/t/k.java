package t;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k<E> extends a<E> {

    /* renamed from: c, reason: collision with root package name */
    public int f12895c;

    /* renamed from: d, reason: collision with root package name */
    public Object[] f12896d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12897e;

    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public k(Object[] objArr, int i10, int i11, int i12) {
        super(i10, i11);
        this.f12895c = i12;
        Object[] objArr2 = new Object[i12];
        this.f12896d = objArr2;
        ?? r52 = i10 == i11 ? 1 : 0;
        this.f12897e = r52;
        objArr2[0] = objArr;
        b(i10 - r52, 1);
    }

    public final E a() {
        int i10 = this.f12871a & 31;
        Object obj = this.f12896d[this.f12895c - 1];
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
        return (E) ((Object[]) obj)[i10];
    }

    public final void b(int i10, int i11) {
        int i12 = (this.f12895c - i11) * 5;
        while (i11 < this.f12895c) {
            Object[] objArr = this.f12896d;
            Object obj = objArr[i11 - 1];
            kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr[i11] = ((Object[]) obj)[jd.b.v(i10, i12)];
            i12 -= 5;
            i11++;
        }
    }

    public final void c(int i10) {
        int i11 = 0;
        while (jd.b.v(this.f12871a, i11) == i10) {
            i11 += 5;
        }
        if (i11 > 0) {
            b(this.f12871a, ((this.f12895c - 1) - (i11 / 5)) + 1);
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E eA = a();
        int i10 = this.f12871a + 1;
        this.f12871a = i10;
        if (i10 == this.f12872b) {
            this.f12897e = true;
            return eA;
        }
        c(0);
        return eA;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        this.f12871a--;
        if (this.f12897e) {
            this.f12897e = false;
            return a();
        }
        c(31);
        return a();
    }
}
