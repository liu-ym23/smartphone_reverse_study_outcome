package d8;

import c8.n;
import d7.r;
import d7.t;
import d7.z;
import f8.e0;
import f8.n0;
import f8.o;
import f8.r0;
import g8.h;
import g8.j;
import i8.i;
import i8.p0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import o9.m;
import u9.k;
import v9.m0;

/* loaded from: classes.dex */
public final class c extends i8.b {

    /* renamed from: q, reason: collision with root package name */
    public static final e9.b f2982q = new e9.b(n.f2066k, e9.f.e("Function"));

    /* renamed from: r, reason: collision with root package name */
    public static final e9.b f2983r = new e9.b(n.f2063h, e9.f.e("KFunction"));

    /* renamed from: j, reason: collision with root package name */
    public final k f2984j;

    /* renamed from: k, reason: collision with root package name */
    public final e0 f2985k;

    /* renamed from: l, reason: collision with root package name */
    public final e f2986l;

    /* renamed from: m, reason: collision with root package name */
    public final int f2987m;

    /* renamed from: n, reason: collision with root package name */
    public final b f2988n;

    /* renamed from: o, reason: collision with root package name */
    public final f f2989o;

    /* renamed from: p, reason: collision with root package name */
    public final List f2990p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(k kVar, s9.c cVar, e eVar, int i2) {
        super(kVar, eVar.a(i2));
        q7.k.e(cVar, "containingDeclaration");
        this.f2984j = kVar;
        this.f2985k = cVar;
        this.f2986l = eVar;
        this.f2987m = i2;
        this.f2988n = new b(this);
        this.f2989o = new f(kVar, this);
        ArrayList arrayList = new ArrayList();
        v7.d dVar = new v7.d(1, i2, 1);
        ArrayList arrayList2 = new ArrayList(t.A0(dVar, 10));
        Iterator it = dVar.iterator();
        while (true) {
            v7.c cVar2 = (v7.c) it;
            if (!cVar2.f10528h) {
                arrayList.add(p0.J0(this, 3, e9.f.e("R"), arrayList.size(), this.f2984j));
                this.f2990p = r.m1(arrayList);
                return;
            } else {
                arrayList.add(p0.J0(this, 2, e9.f.e("P" + cVar2.nextInt()), arrayList.size(), this.f2984j));
                arrayList2.add(c7.r.f1986a);
            }
        }
    }

    @Override // f8.e
    public final boolean A0() {
        return false;
    }

    @Override // f8.e
    public final int B() {
        return 2;
    }

    @Override // f8.e
    public final boolean C() {
        return false;
    }

    @Override // f8.e
    public final /* bridge */ /* synthetic */ Collection E() {
        return z.f2978f;
    }

    @Override // f8.e
    public final boolean J() {
        return false;
    }

    @Override // i8.z
    public final o9.n T(w9.g gVar) {
        return this.f2989o;
    }

    @Override // f8.e
    public final /* bridge */ /* synthetic */ Collection U() {
        return z.f2978f;
    }

    @Override // f8.w
    public final boolean Z() {
        return false;
    }

    @Override // f8.e, f8.m, f8.w
    public final f8.n c() {
        f8.n nVar = o.f3492e;
        q7.k.d(nVar, "PUBLIC");
        return nVar;
    }

    @Override // f8.e
    public final boolean e() {
        return false;
    }

    @Override // g8.a
    public final j getAnnotations() {
        return h.f3888a;
    }

    @Override // f8.g
    public final m0 h() {
        return this.f2988n;
    }

    @Override // f8.e, f8.w
    public final int i() {
        return 4;
    }

    @Override // f8.e
    public final r0 i0() {
        return null;
    }

    @Override // f8.e
    public final /* bridge */ /* synthetic */ i k0() {
        return null;
    }

    @Override // f8.e
    public final boolean l() {
        return false;
    }

    @Override // f8.e
    public final /* bridge */ /* synthetic */ o9.n l0() {
        return m.f7933b;
    }

    @Override // f8.h
    public final boolean m() {
        return false;
    }

    @Override // f8.j
    public final f8.j p() {
        return this.f2985k;
    }

    @Override // f8.k
    public final n0 q() {
        return n0.f3487b;
    }

    @Override // f8.w
    public final boolean r0() {
        return false;
    }

    @Override // f8.e, f8.h
    public final List s() {
        return this.f2990p;
    }

    public final String toString() {
        String strB = getName().b();
        q7.k.d(strB, "name.asString()");
        return strB;
    }

    @Override // f8.w
    public final boolean w() {
        return false;
    }
}
