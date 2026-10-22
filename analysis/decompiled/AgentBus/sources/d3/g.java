package d3;

import d7.x;
import d7.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import la.f0;
import la.k0;
import la.u0;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final u0 f2814a = k0.c(h.f2828a);

    /* renamed from: b, reason: collision with root package name */
    public final u0 f2815b;

    /* renamed from: c, reason: collision with root package name */
    public final f0 f2816c;

    /* renamed from: d, reason: collision with root package name */
    public final d7.m f2817d;

    /* renamed from: e, reason: collision with root package name */
    public final d7.m f2818e;

    /* renamed from: f, reason: collision with root package name */
    public d f2819f;

    /* renamed from: g, reason: collision with root package name */
    public int f2820g;

    /* renamed from: h, reason: collision with root package name */
    public f f2821h;

    /* renamed from: i, reason: collision with root package name */
    public final LinkedHashSet f2822i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f2823j;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f2824k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2825l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2826m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2827n;

    public g() {
        u0 u0VarC = k0.c(new e());
        this.f2815b = u0VarC;
        this.f2816c = new f0(u0VarC);
        this.f2817d = new d7.m();
        this.f2818e = new d7.m();
        this.f2822i = new LinkedHashSet();
        this.f2823j = new LinkedHashSet();
        this.f2824k = new LinkedHashSet();
    }

    public final void a(i5.f fVar, f fVar2, int i2) {
        q7.k.e(fVar, "dispatcher");
        if (fVar2.f2812a == null) {
            (i2 != 0 ? i2 != 1 ? this.f2822i : this.f2823j : this.f2824k).add(fVar2);
            fVar2.f2812a = fVar;
            q7.k.e((e) this.f2816c.f5918f.getValue(), "history");
            fVar2.b(i2 != 0 ? i2 != 1 ? this.f2827n : this.f2825l : this.f2826m);
            return;
        }
        throw new IllegalArgumentException(("Input '" + fVar2 + "' is already added to dispatcher " + fVar2.f2812a + '.').toString());
    }

    public final void b() {
        boolean z4;
        boolean z10;
        e eVar;
        d7.m mVar = this.f2817d;
        if (mVar == null || !mVar.isEmpty()) {
            Iterator it = mVar.iterator();
            while (it.hasNext()) {
                if (((d) it.next()).f2808b) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
        } else {
            z4 = false;
        }
        d7.m mVar2 = this.f2818e;
        if (mVar2 == null || !mVar2.isEmpty()) {
            Iterator it2 = mVar2.iterator();
            while (it2.hasNext()) {
                if (((d) it2.next()).f2808b) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        } else {
            z10 = false;
        }
        boolean z11 = z4 || z10;
        boolean z12 = this.f2826m != z4;
        boolean z13 = this.f2825l != z10;
        boolean z14 = this.f2827n != z11;
        LinkedHashSet linkedHashSet = this.f2824k;
        if (z12) {
            Iterator it3 = linkedHashSet.iterator();
            while (it3.hasNext()) {
                ((f) it3.next()).b(z4);
            }
        }
        LinkedHashSet linkedHashSet2 = this.f2823j;
        if (z13) {
            Iterator it4 = linkedHashSet2.iterator();
            while (it4.hasNext()) {
                ((f) it4.next()).b(z10);
            }
        }
        LinkedHashSet linkedHashSet3 = this.f2822i;
        if (z14) {
            Iterator it5 = linkedHashSet3.iterator();
            while (it5.hasNext()) {
                ((f) it5.next()).b(z11);
            }
        }
        this.f2826m = z4;
        this.f2825l = z10;
        this.f2827n = z11;
        d dVarC = this.f2819f;
        if (dVarC == null) {
            dVarC = c(0);
        }
        d dVarC2 = this.f2819f;
        if (dVarC2 == null) {
            dVarC2 = c(0);
        }
        if (q7.k.a(dVarC2, dVarC)) {
            if (dVarC2 == null) {
                eVar = new e();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<E> it6 = mVar.iterator();
                while (it6.hasNext()) {
                    boolean z15 = ((d) it6.next()).f2808b;
                }
                Iterator<E> it7 = mVar2.iterator();
                while (it7.hasNext()) {
                    boolean z16 = ((d) it7.next()).f2808b;
                }
                a.a aVar = dVarC2.f2807a;
                e7.c cVarM = a.a.m();
                x.D0(cVarM, arrayList);
                cVarM.add(aVar);
                x.D0(cVarM, z.f2978f);
                eVar = new e(arrayList.size(), a.a.e(cVarM));
            }
            u0 u0Var = this.f2815b;
            if (q7.k.a((e) u0Var.getValue(), eVar)) {
                return;
            }
            u0Var.g(null, eVar);
            Iterator it8 = linkedHashSet.iterator();
            while (it8.hasNext()) {
                ((f) it8.next()).getClass();
            }
            Iterator it9 = linkedHashSet2.iterator();
            while (it9.hasNext()) {
                ((f) it9.next()).getClass();
            }
            Iterator it10 = linkedHashSet3.iterator();
            while (it10.hasNext()) {
                ((f) it10.next()).getClass();
            }
        }
    }

    public final d c(int i2) {
        Object next;
        Object next2;
        d7.m mVar = this.f2818e;
        d7.m mVar2 = this.f2817d;
        Object obj = null;
        if (i2 == -1) {
            Iterator it = mVar2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((d) next).f2808b) {
                    break;
                }
            }
            d dVar = (d) next;
            if (dVar != null) {
                return dVar;
            }
            Iterator it2 = mVar.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next3 = it2.next();
                if (((d) next3).f2808b) {
                    obj = next3;
                    break;
                }
            }
            return (d) obj;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException(("Unsupported direction: '" + i2 + "'.").toString());
            }
            Iterator it3 = mVar2.iterator();
            while (it3.hasNext()) {
                ((d) it3.next()).getClass();
            }
            Iterator it4 = mVar.iterator();
            while (it4.hasNext()) {
                ((d) it4.next()).getClass();
            }
            return null;
        }
        Iterator it5 = mVar2.iterator();
        while (true) {
            if (!it5.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it5.next();
            if (((d) next2).f2808b) {
                break;
            }
        }
        d dVar2 = (d) next2;
        if (dVar2 != null) {
            return dVar2;
        }
        Iterator it6 = mVar.iterator();
        while (true) {
            if (!it6.hasNext()) {
                break;
            }
            Object next4 = it6.next();
            if (((d) next4).f2808b) {
                obj = next4;
                break;
            }
        }
        return (d) obj;
    }
}
