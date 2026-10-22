package i8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import v9.v0;
import v9.x0;

/* loaded from: classes.dex */
public final class y extends z {

    /* renamed from: f, reason: collision with root package name */
    public final z f4901f;

    /* renamed from: g, reason: collision with root package name */
    public final v0 f4902g;

    /* renamed from: h, reason: collision with root package name */
    public v0 f4903h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f4904i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f4905j;

    /* renamed from: k, reason: collision with root package name */
    public v9.i f4906k;

    public y(z zVar, v0 v0Var) {
        this.f4901f = zVar;
        this.f4902g = v0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void j0(int r15) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.y.j0(int):void");
    }

    @Override // f8.e
    public final boolean A0() {
        return this.f4901f.A0();
    }

    @Override // f8.e
    public final int B() {
        int iB = this.f4901f.B();
        if (iB != 0) {
            return iB;
        }
        j0(25);
        throw null;
    }

    @Override // f8.e
    public final v B0() {
        throw new UnsupportedOperationException();
    }

    @Override // f8.e
    public final boolean C() {
        return this.f4901f.C();
    }

    @Override // f8.e
    public final Collection E() {
        Collection<i> collectionE = this.f4901f.E();
        ArrayList arrayList = new ArrayList(collectionE.size());
        for (i iVar : collectionE) {
            i iVar2 = iVar;
            iVar2.getClass();
            t tVarM0 = iVar2.M0(v0.f10595b);
            tVarM0.f4856j = iVar.F0();
            tVarM0.z(iVar2.i());
            tVarM0.s(iVar2.c());
            tVarM0.o(iVar2.getKind());
            tVarM0.f4864r = false;
            arrayList.add(((i) tVarM0.C.J0(tVarM0)).d(u0()));
        }
        return arrayList;
    }

    @Override // f8.e
    public final boolean J() {
        return this.f4901f.J();
    }

    @Override // f8.j
    public final Object P(f8.l lVar, Object obj) {
        return lVar.n(this, obj);
    }

    @Override // i8.z
    public final o9.n R(v9.s0 s0Var, w9.g gVar) {
        o9.n nVarR = this.f4901f.R(s0Var, gVar);
        if (!this.f4902g.f10596a.e()) {
            return new o9.t(nVarR, u0());
        }
        if (nVarR != null) {
            return nVarR;
        }
        j0(7);
        throw null;
    }

    @Override // i8.z
    public final o9.n T(w9.g gVar) {
        o9.n nVarT = this.f4901f.T(gVar);
        if (!this.f4902g.f10596a.e()) {
            return new o9.t(nVarT, u0());
        }
        if (nVarT != null) {
            return nVarT;
        }
        j0(14);
        throw null;
    }

    @Override // f8.e
    public final Collection U() {
        Collection collectionU = this.f4901f.U();
        if (collectionU != null) {
            return collectionU;
        }
        j0(31);
        throw null;
    }

    @Override // f8.e
    public final o9.n X(v9.s0 s0Var) {
        l9.d.i(h9.f.d(this));
        return R(s0Var, w9.g.f10933a);
    }

    @Override // f8.w
    public final boolean Z() {
        return this.f4901f.Z();
    }

    @Override // i8.z, f8.e, f8.j
    public final f8.e a() {
        f8.e eVarA = this.f4901f.a();
        if (eVarA != null) {
            return eVarA;
        }
        j0(21);
        throw null;
    }

    @Override // f8.e, f8.m, f8.w
    public final f8.n c() {
        f8.n nVarC = this.f4901f.c();
        if (nVarC != null) {
            return nVarC;
        }
        j0(27);
        throw null;
    }

    @Override // f8.p0
    public final f8.k d(v0 v0Var) {
        if (v0Var != null) {
            return v0Var.f10596a.e() ? this : new y(this, v0.e(v0Var.f(), u0().f()));
        }
        j0(23);
        throw null;
    }

    @Override // f8.e
    public final boolean e() {
        return this.f4901f.e();
    }

    @Override // g8.a
    public final g8.j getAnnotations() {
        g8.j annotations = this.f4901f.getAnnotations();
        if (annotations != null) {
            return annotations;
        }
        j0(19);
        throw null;
    }

    @Override // f8.j
    public final e9.f getName() {
        e9.f name = this.f4901f.getName();
        if (name != null) {
            return name;
        }
        j0(20);
        throw null;
    }

    @Override // f8.g
    public final v9.m0 h() {
        v9.m0 m0VarH = this.f4901f.h();
        if (this.f4902g.f10596a.e()) {
            if (m0VarH != null) {
                return m0VarH;
            }
            j0(0);
            throw null;
        }
        if (this.f4906k == null) {
            v0 v0VarU0 = u0();
            Collection collectionD = m0VarH.d();
            ArrayList arrayList = new ArrayList(collectionD.size());
            Iterator it = collectionD.iterator();
            while (it.hasNext()) {
                arrayList.add(v0VarU0.i(1, (v9.v) it.next()));
            }
            this.f4906k = new v9.i(this, this.f4904i, arrayList, u9.k.f10207e);
        }
        v9.i iVar = this.f4906k;
        if (iVar != null) {
            return iVar;
        }
        j0(1);
        throw null;
    }

    @Override // f8.e
    public final o9.n h0() {
        o9.n nVarH0 = this.f4901f.h0();
        if (nVarH0 != null) {
            return nVarH0;
        }
        j0(28);
        throw null;
    }

    @Override // f8.e, f8.w
    public final int i() {
        int i2 = this.f4901f.i();
        if (i2 != 0) {
            return i2;
        }
        j0(26);
        throw null;
    }

    @Override // f8.e
    public final f8.r0 i0() {
        f8.r0 r0VarI0 = this.f4901f.i0();
        if (r0VarI0 == null) {
            return null;
        }
        boolean z4 = r0VarI0 instanceof f8.u;
        v0 v0Var = this.f4902g;
        if (z4) {
            f8.u uVar = (f8.u) r0VarI0;
            e9.f fVar = uVar.f3513a;
            v9.z zVar = (v9.z) uVar.f3514b;
            if (zVar != null && !v0Var.f10596a.e()) {
                zVar = (v9.z) u0().i(1, zVar);
            }
            return new f8.u(fVar, zVar);
        }
        if (!(r0VarI0 instanceof f8.a0)) {
            throw new a4.u();
        }
        ArrayList arrayList = ((f8.a0) r0VarI0).f3460a;
        ArrayList arrayList2 = new ArrayList(d7.t.A0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c7.j jVar = (c7.j) it.next();
            e9.f fVar2 = (e9.f) jVar.f1973f;
            v9.z zVar2 = (v9.z) ((y9.j) jVar.f1974g);
            if (zVar2 != null && !v0Var.f10596a.e()) {
                zVar2 = (v9.z) u0().i(1, zVar2);
            }
            arrayList2.add(new c7.j(fVar2, zVar2));
        }
        return new f8.a0(arrayList2);
    }

    @Override // f8.e, f8.g
    public final v9.z k() {
        v9.i0 i0VarQ;
        List listD = x0.d(h().getParameters());
        g8.j annotations = getAnnotations();
        if (annotations.isEmpty()) {
            v9.i0.f10557g.getClass();
            i0VarQ = v9.i0.f10558h;
        } else {
            nb.f fVar = v9.i0.f10557g;
            List listS = a.a.S(new v9.g(annotations));
            fVar.getClass();
            i0VarQ = nb.f.q(listS);
        }
        return v9.d.s(listD, p0(), i0VarQ, h(), false);
    }

    @Override // f8.e
    public final i k0() {
        return this.f4901f.k0();
    }

    @Override // f8.e
    public final boolean l() {
        return this.f4901f.l();
    }

    @Override // f8.e
    public final o9.n l0() {
        o9.n nVarL0 = this.f4901f.l0();
        if (nVarL0 != null) {
            return nVarL0;
        }
        j0(15);
        throw null;
    }

    @Override // f8.h
    public final boolean m() {
        return this.f4901f.m();
    }

    @Override // f8.j
    public final f8.j p() {
        f8.j jVarP = this.f4901f.p();
        if (jVarP != null) {
            return jVarP;
        }
        j0(22);
        throw null;
    }

    @Override // f8.e
    public final o9.n p0() {
        l9.d.i(h9.f.d(this.f4901f));
        return T(w9.g.f10933a);
    }

    @Override // f8.k
    public final f8.n0 q() {
        return f8.n0.f3487b;
    }

    @Override // f8.w
    public final boolean r0() {
        return this.f4901f.r0();
    }

    @Override // f8.e, f8.h
    public final List s() {
        u0();
        ArrayList arrayList = this.f4905j;
        if (arrayList != null) {
            return arrayList;
        }
        j0(30);
        throw null;
    }

    public final v0 u0() {
        if (this.f4903h == null) {
            v0 v0Var = this.f4902g;
            if (v0Var.f10596a.e()) {
                this.f4903h = v0Var;
            } else {
                List parameters = this.f4901f.h().getParameters();
                this.f4904i = new ArrayList(parameters.size());
                this.f4903h = v9.c.u(parameters, v0Var.f(), this, this.f4904i);
                ArrayList arrayList = this.f4904i;
                q7.k.e(arrayList, "<this>");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (!((f8.q0) obj).M()) {
                        arrayList2.add(obj);
                    }
                }
                this.f4905j = arrayList2;
            }
        }
        return this.f4903h;
    }

    @Override // f8.w
    public final boolean w() {
        return this.f4901f.w();
    }

    @Override // f8.e
    public final List w0() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        j0(17);
        throw null;
    }
}
