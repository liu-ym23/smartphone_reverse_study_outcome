package t9;

import c1.w;
import f8.n0;
import java.util.List;
import v9.m0;
import v9.v0;
import v9.x0;
import v9.z;
import z8.r0;

/* loaded from: classes.dex */
public final class s extends i8.n implements k, f8.h {

    /* renamed from: j, reason: collision with root package name */
    public final f8.n f9842j;

    /* renamed from: k, reason: collision with root package name */
    public List f9843k;

    /* renamed from: l, reason: collision with root package name */
    public final i8.e f9844l;

    /* renamed from: m, reason: collision with root package name */
    public final u9.n f9845m;

    /* renamed from: n, reason: collision with root package name */
    public final r0 f9846n;

    /* renamed from: o, reason: collision with root package name */
    public final b9.f f9847o;

    /* renamed from: p, reason: collision with root package name */
    public final b9.g f9848p;

    /* renamed from: q, reason: collision with root package name */
    public final b9.h f9849q;

    /* renamed from: r, reason: collision with root package name */
    public final j f9850r;

    /* renamed from: s, reason: collision with root package name */
    public Object f9851s;

    /* renamed from: t, reason: collision with root package name */
    public z f9852t;

    /* renamed from: u, reason: collision with root package name */
    public z f9853u;

    /* renamed from: v, reason: collision with root package name */
    public List f9854v;

    /* renamed from: w, reason: collision with root package name */
    public z f9855w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(u9.n nVar, f8.j jVar, g8.j jVar2, e9.f fVar, f8.n nVar2, r0 r0Var, b9.f fVar2, b9.g gVar, b9.h hVar, j jVar3) {
        super(jVar, jVar2, fVar, n0.f3487b);
        q7.k.e(nVar, "storageManager");
        q7.k.e(jVar, "containingDeclaration");
        q7.k.e(nVar2, "visibility");
        q7.k.e(r0Var, "proto");
        q7.k.e(fVar2, "nameResolver");
        q7.k.e(gVar, "typeTable");
        q7.k.e(hVar, "versionRequirementTable");
        this.f9842j = nVar2;
        this.f9844l = new i8.e(this);
        this.f9845m = nVar;
        this.f9846n = r0Var;
        this.f9847o = fVar2;
        this.f9848p = gVar;
        this.f9849q = hVar;
        this.f9850r = jVar3;
    }

    @Override // i8.n
    /* renamed from: F0 */
    public final f8.k a() {
        return this;
    }

    public final f8.e G0() {
        if (v9.c.i(H0())) {
            return null;
        }
        f8.g gVarC = H0().E0().c();
        if (gVarC instanceof f8.e) {
            return (f8.e) gVarC;
        }
        return null;
    }

    public final z H0() {
        z zVar = this.f9853u;
        if (zVar != null) {
            return zVar;
        }
        q7.k.j("expandedType");
        throw null;
    }

    public final z I0() {
        z zVar = this.f9852t;
        if (zVar != null) {
            return zVar;
        }
        q7.k.j("underlyingType");
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J0(java.util.List r26, v9.z r27, v9.z r28) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t9.s.J0(java.util.List, v9.z, v9.z):void");
    }

    @Override // f8.j
    public final Object P(f8.l lVar, Object obj) {
        return lVar.k(this, obj);
    }

    @Override // f8.w
    public final boolean Z() {
        return false;
    }

    @Override // i8.n, i8.m, f8.j
    public final f8.g a() {
        return this;
    }

    @Override // f8.w
    public final f8.n c() {
        return this.f9842j;
    }

    @Override // f8.p0
    public final f8.k d(v0 v0Var) {
        q7.k.e(v0Var, "substitutor");
        if (v0Var.f10596a.e()) {
            return this;
        }
        f8.j jVarP = p();
        q7.k.d(jVarP, "containingDeclaration");
        g8.j annotations = getAnnotations();
        q7.k.d(annotations, "annotations");
        e9.f name = getName();
        q7.k.d(name, "name");
        s sVar = new s(this.f9845m, jVarP, annotations, name, this.f9842j, this.f9846n, this.f9847o, this.f9848p, this.f9849q, this.f9850r);
        sVar.J0(s(), v9.c.b(v0Var.g(1, I0())), v9.c.b(v0Var.g(1, H0())));
        return sVar;
    }

    @Override // f8.g
    public final m0 h() {
        return this.f9844l;
    }

    @Override // f8.g
    public final z k() {
        z zVar = this.f9855w;
        if (zVar != null) {
            return zVar;
        }
        q7.k.j("defaultTypeImpl");
        throw null;
    }

    @Override // f8.h
    public final boolean m() {
        return x0.c(I0(), new w(5, this), null);
    }

    @Override // t9.k
    public final b9.g m0() {
        throw null;
    }

    @Override // f8.w
    public final boolean r0() {
        return false;
    }

    @Override // f8.h
    public final List s() {
        List list = this.f9843k;
        if (list != null) {
            return list;
        }
        q7.k.j("declaredTypeParametersImpl");
        throw null;
    }

    @Override // i8.m
    public final String toString() {
        return "typealias " + getName().b();
    }

    @Override // t9.k
    public final j u() {
        return this.f9850r;
    }

    @Override // f8.w
    public final boolean w() {
        return false;
    }

    @Override // t9.k
    public final b9.f z0() {
        throw null;
    }

    @Override // i8.n, i8.m, f8.j
    public final f8.j a() {
        return this;
    }
}
