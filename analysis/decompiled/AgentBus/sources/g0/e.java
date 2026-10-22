package g0;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import q7.z;

/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: i, reason: collision with root package name */
    public final j0.g f3678i;

    /* renamed from: j, reason: collision with root package name */
    public Object f3679j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3680k;

    /* renamed from: l, reason: collision with root package name */
    public int f3681l;

    public e(j0.g gVar, l[] lVarArr) {
        super(gVar.f5078g, lVarArr);
        this.f3678i = gVar;
        this.f3681l = gVar.f5080i;
    }

    public final void d(int i2, k kVar, Object obj, int i10) {
        int i11 = i10 * 5;
        l[] lVarArr = this.f3675f;
        if (i11 <= 30) {
            int iC = 1 << ib.c.C(i2, i11);
            if (kVar.h(iC)) {
                lVarArr[i10].a(kVar.f3691d, Integer.bitCount(kVar.f3688a) * 2, kVar.f(iC));
                this.f3676g = i10;
                return;
            } else {
                int iT = kVar.t(iC);
                k kVarS = kVar.s(iT);
                lVarArr[i10].a(kVar.f3691d, Integer.bitCount(kVar.f3688a) * 2, iT);
                d(i2, kVarS, obj, i10 + 1);
                return;
            }
        }
        l lVar = lVarArr[i10];
        Object[] objArr = kVar.f3691d;
        lVar.a(objArr, objArr.length, 0);
        while (true) {
            l lVar2 = lVarArr[i10];
            if (q7.k.a(lVar2.f3692f[lVar2.f3694h], obj)) {
                this.f3676g = i10;
                return;
            } else {
                lVarArr[i10].f3694h += 2;
            }
        }
    }

    @Override // g0.d, java.util.Iterator
    public final Object next() {
        if (this.f3678i.f5080i != this.f3681l) {
            throw new ConcurrentModificationException();
        }
        if (!this.f3677h) {
            throw new NoSuchElementException();
        }
        l lVar = this.f3675f[this.f3676g];
        this.f3679j = lVar.f3692f[lVar.f3694h];
        this.f3680k = true;
        return super.next();
    }

    @Override // g0.d, java.util.Iterator
    public final void remove() {
        if (!this.f3680k) {
            throw new IllegalStateException();
        }
        boolean z4 = this.f3677h;
        j0.g gVar = this.f3678i;
        if (!z4) {
            z.a(gVar).remove(this.f3679j);
        } else {
            if (!z4) {
                throw new NoSuchElementException();
            }
            l lVar = this.f3675f[this.f3676g];
            Object obj = lVar.f3692f[lVar.f3694h];
            z.a(gVar).remove(this.f3679j);
            d(obj != null ? obj.hashCode() : 0, gVar.f5078g, obj, 0);
        }
        this.f3679j = null;
        this.f3680k = false;
        this.f3681l = gVar.f5080i;
    }
}
