package i8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import v9.v0;

/* loaded from: classes.dex */
public class i0 extends s0 implements f8.l0 {
    public ArrayList A;
    public j0 B;
    public k0 C;
    public s D;
    public s E;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f4795k;

    /* renamed from: l, reason: collision with root package name */
    public u9.h f4796l;

    /* renamed from: m, reason: collision with root package name */
    public p7.a f4797m;

    /* renamed from: n, reason: collision with root package name */
    public final int f4798n;

    /* renamed from: o, reason: collision with root package name */
    public f8.n f4799o;

    /* renamed from: p, reason: collision with root package name */
    public Collection f4800p;

    /* renamed from: q, reason: collision with root package name */
    public final f8.l0 f4801q;

    /* renamed from: r, reason: collision with root package name */
    public final int f4802r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f4803s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f4804t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f4805u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f4806v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f4807w;

    /* renamed from: x, reason: collision with root package name */
    public List f4808x;

    /* renamed from: y, reason: collision with root package name */
    public v f4809y;

    /* renamed from: z, reason: collision with root package name */
    public v f4810z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(f8.j jVar, f8.l0 l0Var, g8.j jVar2, int i2, f8.n nVar, boolean z4, e9.f fVar, int i10, f8.n0 n0Var, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        super(jVar, jVar2, fVar, null, n0Var);
        if (jVar == null) {
            R(0);
            throw null;
        }
        if (jVar2 == null) {
            R(1);
            throw null;
        }
        if (i2 == 0) {
            R(2);
            throw null;
        }
        if (nVar == null) {
            R(3);
            throw null;
        }
        if (fVar == null) {
            R(4);
            throw null;
        }
        if (i10 == 0) {
            R(5);
            throw null;
        }
        if (n0Var == null) {
            R(6);
            throw null;
        }
        this.f4795k = z4;
        this.f4800p = null;
        this.f4808x = Collections.EMPTY_LIST;
        this.f4798n = i2;
        this.f4799o = nVar;
        this.f4801q = l0Var == null ? this : l0Var;
        this.f4802r = i10;
        this.f4803s = z10;
        this.f4804t = z11;
        this.f4805u = z12;
        this.f4806v = z13;
        this.f4807w = z14;
    }

    public static i0 H0(f8.j jVar, int i2, f8.n nVar, boolean z4, e9.f fVar, int i10, f8.n0 n0Var) {
        if (jVar == null) {
            R(7);
            throw null;
        }
        if (i2 == 0) {
            R(9);
            throw null;
        }
        if (nVar == null) {
            R(10);
            throw null;
        }
        if (fVar == null) {
            R(11);
            throw null;
        }
        if (i10 == 0) {
            R(12);
            throw null;
        }
        if (n0Var != null) {
            return new i0(jVar, null, g8.h.f3888a, i2, nVar, z4, fVar, i10, n0Var, false, false, false, false, false);
        }
        R(13);
        throw null;
    }

    public static f8.t J0(v0 v0Var, f8.k0 k0Var) {
        if (k0Var == null) {
            R(31);
            throw null;
        }
        f8.t tVar = ((g0) k0Var).f4777q;
        if (tVar != null) {
            return tVar.d(v0Var);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void R(int r11) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.i0.R(int):void");
    }

    @Override // f8.t0
    public boolean D() {
        return this.f4804t;
    }

    @Override // f8.t0
    public final boolean F() {
        return this.f4795k;
    }

    @Override // f8.c
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public final i0 Y(f8.j jVar, int i2, f8.n nVar) {
        h0 h0Var = new h0(this);
        if (jVar == null) {
            h0.a(0);
            throw null;
        }
        h0Var.f4784a = jVar;
        h0Var.f4787d = null;
        if (i2 == 0) {
            h0.a(6);
            throw null;
        }
        h0Var.f4785b = i2;
        if (nVar == null) {
            h0.a(8);
            throw null;
        }
        h0Var.f4786c = nVar;
        h0Var.f4788e = 2;
        h0Var.f4790g = false;
        i0 i0VarB = h0Var.b();
        if (i0VarB != null) {
            return i0VarB;
        }
        R(42);
        throw null;
    }

    @Override // i8.s0, f8.b
    public final v I() {
        return this.f4810z;
    }

    public i0 I0(f8.j jVar, int i2, f8.n nVar, f8.l0 l0Var, int i10, e9.f fVar) {
        if (jVar == null) {
            R(32);
            throw null;
        }
        if (i2 == 0) {
            R(33);
            throw null;
        }
        if (nVar == null) {
            R(34);
            throw null;
        }
        if (i10 == 0) {
            R(35);
            throw null;
        }
        if (fVar == null) {
            R(36);
            throw null;
        }
        return new i0(jVar, l0Var, getAnnotations(), i2, nVar, this.f4795k, fVar, i10, f8.n0.f3487b, this.f4803s, D(), this.f4805u, w(), this.f4807w);
    }

    @Override // f8.l0
    public final s K() {
        return this.E;
    }

    public final void K0(j0 j0Var, k0 k0Var, s sVar, s sVar2) {
        this.B = j0Var;
        this.C = k0Var;
        this.D = sVar;
        this.E = sVar2;
    }

    public final void L0(u9.h hVar, p7.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "compileTimeInitializerFactory", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl", "setCompileTimeInitializer"));
        }
        this.f4797m = aVar;
        if (hVar == null) {
            hVar = (u9.h) aVar.c();
        }
        this.f4796l = hVar;
    }

    public void M0(v9.v vVar) {
    }

    public final void N0(v9.v vVar, List list, v vVar2, v vVar3, List list2) {
        if (vVar == null) {
            R(17);
            throw null;
        }
        if (list == null) {
            R(18);
            throw null;
        }
        if (list2 == null) {
            R(19);
            throw null;
        }
        this.f4851j = vVar;
        this.A = new ArrayList(list);
        this.f4810z = vVar3;
        this.f4809y = vVar2;
        this.f4808x = list2;
    }

    @Override // f8.j
    public final Object P(f8.l lVar, Object obj) {
        return lVar.q(this, obj);
    }

    @Override // f8.l0
    public final s Q() {
        return this.D;
    }

    @Override // f8.b
    public final List S() {
        List list = this.f4808x;
        if (list != null) {
            return list;
        }
        R(22);
        throw null;
    }

    @Override // f8.t0
    public final boolean V() {
        return this.f4803s;
    }

    @Override // f8.w
    public final boolean Z() {
        return this.f4805u;
    }

    @Override // f8.l0
    public final j0 b() {
        return this.B;
    }

    @Override // f8.l0
    public final boolean b0() {
        return this.f4807w;
    }

    @Override // f8.m, f8.w
    public final f8.n c() {
        f8.n nVar = this.f4799o;
        if (nVar != null) {
            return nVar;
        }
        R(25);
        throw null;
    }

    @Override // f8.c
    public final void d0(Collection collection) {
        if (collection != null) {
            this.f4800p = collection;
        } else {
            R(40);
            throw null;
        }
    }

    @Override // i8.s0, f8.b
    public final v9.v f() {
        v9.v type = getType();
        if (type != null) {
            return type;
        }
        R(23);
        throw null;
    }

    @Override // f8.l0
    public final k0 g() {
        return this.C;
    }

    @Override // f8.c
    public final int getKind() {
        int i2 = this.f4802r;
        if (i2 != 0) {
            return i2;
        }
        R(39);
        throw null;
    }

    @Override // i8.s0, f8.b
    public final List getTypeParameters() {
        ArrayList arrayList = this.A;
        if (arrayList != null) {
            return arrayList;
        }
        throw new IllegalStateException("typeParameters == null for ".concat(m.E0(this)));
    }

    @Override // f8.w
    public final int i() {
        int i2 = this.f4798n;
        if (i2 != 0) {
            return i2;
        }
        R(24);
        throw null;
    }

    @Override // f8.t0
    public final j9.g q0() {
        u9.h hVar = this.f4796l;
        if (hVar != null) {
            return (j9.g) hVar.c();
        }
        return null;
    }

    @Override // f8.b
    public final Collection r() {
        Collection collection = this.f4800p;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection != null) {
            return collection;
        }
        R(41);
        throw null;
    }

    @Override // f8.w
    public final boolean r0() {
        return false;
    }

    @Override // f8.l0
    public final ArrayList t() {
        ArrayList arrayList = new ArrayList(2);
        j0 j0Var = this.B;
        if (j0Var != null) {
            arrayList.add(j0Var);
        }
        k0 k0Var = this.C;
        if (k0Var != null) {
            arrayList.add(k0Var);
        }
        return arrayList;
    }

    @Override // f8.w
    public boolean w() {
        return this.f4806v;
    }

    @Override // f8.b
    public Object x(f8.a aVar) {
        return null;
    }

    @Override // i8.s0, f8.b
    public final v y() {
        return this.f4809y;
    }

    @Override // f8.p0
    public final f8.l0 d(v0 v0Var) {
        if (v0Var == null) {
            R(27);
            throw null;
        }
        if (v0Var.f10596a.e()) {
            return this;
        }
        h0 h0Var = new h0(this);
        v9.s0 s0VarF = v0Var.f();
        if (s0VarF == null) {
            h0.a(15);
            throw null;
        }
        h0Var.f4789f = s0VarF;
        h0Var.f4787d = a();
        return h0Var.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [f8.l0] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // i8.n, i8.m, f8.j
    public final f8.l0 a() {
        f8.l0 l0Var = this.f4801q;
        ?? A = this;
        if (l0Var != this) {
            A = l0Var.a();
        }
        if (A != 0) {
            return A;
        }
        R(38);
        throw null;
    }
}
