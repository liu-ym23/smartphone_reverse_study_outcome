package f8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class c0 extends i8.j {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f3465l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f3466m;

    /* renamed from: n, reason: collision with root package name */
    public final v9.i f3467n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(u9.k kVar, f fVar, e9.f fVar2, boolean z4, int i2) {
        super(kVar, fVar, fVar2, n0.f3487b);
        q7.k.e(fVar, "container");
        this.f3465l = z4;
        v7.d dVarN = nb.i.N(0, i2);
        ArrayList arrayList = new ArrayList(d7.t.A0(dVarN, 10));
        Iterator it = dVarN.iterator();
        while (true) {
            v7.c cVar = (v7.c) it;
            if (!cVar.f10528h) {
                this.f3466m = arrayList;
                this.f3467n = new v9.i(this, v.c(this), ib.k.S(l9.d.j(this).n().e()), kVar);
                return;
            } else {
                int iNextInt = cVar.nextInt();
                arrayList.add(i8.p0.J0(this, 1, e9.f.e("T" + iNextInt), iNextInt, kVar));
            }
        }
    }

    @Override // f8.e
    public final boolean A0() {
        return false;
    }

    @Override // f8.e
    public final int B() {
        return 1;
    }

    @Override // f8.e
    public final boolean C() {
        return false;
    }

    @Override // f8.e
    public final Collection E() {
        return d7.b0.f2947f;
    }

    @Override // f8.e
    public final boolean J() {
        return false;
    }

    @Override // i8.z
    public final o9.n T(w9.g gVar) {
        return o9.m.f7933b;
    }

    @Override // f8.e
    public final Collection U() {
        return d7.z.f2978f;
    }

    @Override // f8.w
    public final boolean Z() {
        return false;
    }

    @Override // f8.e, f8.m, f8.w
    public final n c() {
        n nVar = o.f3492e;
        q7.k.d(nVar, "PUBLIC");
        return nVar;
    }

    @Override // f8.e
    public final boolean e() {
        return false;
    }

    @Override // g8.a
    public final g8.j getAnnotations() {
        return g8.h.f3888a;
    }

    @Override // f8.g
    public final v9.m0 h() {
        return this.f3467n;
    }

    @Override // f8.e, f8.w
    public final int i() {
        return 1;
    }

    @Override // f8.e
    public final r0 i0() {
        return null;
    }

    @Override // f8.e
    public final i8.i k0() {
        return null;
    }

    @Override // f8.e
    public final boolean l() {
        return false;
    }

    @Override // f8.e
    public final /* bridge */ /* synthetic */ o9.n l0() {
        return o9.m.f7933b;
    }

    @Override // f8.h
    public final boolean m() {
        return this.f3465l;
    }

    @Override // f8.w
    public final boolean r0() {
        return false;
    }

    @Override // f8.e, f8.h
    public final List s() {
        return this.f3466m;
    }

    public final String toString() {
        return "class " + getName() + " (not found)";
    }

    @Override // i8.j, f8.w
    public final boolean w() {
        return false;
    }
}
