package p0;

import h5.t;
import java.util.ConcurrentModificationException;
import yb.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class d extends c {

    /* renamed from: h, reason: collision with root package name */
    public final s0.f f9663h;
    public Object i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9664j;

    /* renamed from: k, reason: collision with root package name */
    public int f9665k;

    public d(s0.f fVar, k[] kVarArr) {
        super(fVar.f11177f, kVarArr);
        this.f9663h = fVar;
        this.f9665k = fVar.f11179h;
    }

    public final void c(int i, j jVar, Object obj, int i3) {
        int i10 = i3 * 5;
        k[] kVarArr = this.f9660c;
        if (i10 <= 30) {
            int iE = 1 << t.E(i, i10);
            if (jVar.h(iE)) {
                kVarArr[i3].a(jVar.f9675d, Integer.bitCount(jVar.f9672a) * 2, jVar.f(iE));
                this.f9661f = i3;
                return;
            } else {
                int iT = jVar.t(iE);
                j jVarS = jVar.s(iT);
                kVarArr[i3].a(jVar.f9675d, Integer.bitCount(jVar.f9672a) * 2, iT);
                c(i, jVarS, obj, i3 + 1);
                return;
            }
        }
        k kVar = kVarArr[i3];
        Object[] objArr = jVar.f9675d;
        kVar.a(objArr, objArr.length, 0);
        while (true) {
            k kVar2 = kVarArr[i3];
            if (yb.k.a(kVar2.f9676c[kVar2.f9678g], obj)) {
                this.f9661f = i3;
                return;
            } else {
                kVarArr[i3].f9678g += 2;
            }
        }
    }

    @Override // p0.c, java.util.Iterator
    public final Object next() {
        if (this.f9663h.f11179h != this.f9665k) {
            throw new ConcurrentModificationException();
        }
        if (!this.f9662g) {
            g5.f.k();
            return null;
        }
        k kVar = this.f9660c[this.f9661f];
        this.i = kVar.f9676c[kVar.f9678g];
        this.f9664j = true;
        return super.next();
    }

    @Override // p0.c, java.util.Iterator
    public final void remove() {
        if (!this.f9664j) {
            throw new IllegalStateException();
        }
        boolean z10 = this.f9662g;
        s0.f fVar = this.f9663h;
        if (!z10) {
            x.b(fVar).remove(this.i);
        } else {
            if (!z10) {
                g5.f.k();
                return;
            }
            k kVar = this.f9660c[this.f9661f];
            Object obj = kVar.f9676c[kVar.f9678g];
            x.b(fVar).remove(this.i);
            c(obj != null ? obj.hashCode() : 0, fVar.f11177f, obj, 0);
        }
        this.i = null;
        this.f9664j = false;
        this.f9665k = fVar.f11179h;
    }
}
