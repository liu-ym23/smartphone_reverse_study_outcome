package t9;

import f8.n0;
import m.x;

/* loaded from: classes.dex */
public final class c extends i8.i implements b {
    public final z8.k J;
    public final b9.f K;
    public final b9.g L;
    public final b9.h M;
    public final j N;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public c(f8.e r12, f8.i r13, g8.j r14, boolean r15, int r16, z8.k r17, b9.f r18, b9.g r19, b9.h r20, t9.j r21, f8.n0 r22) {
        /*
            r11 = this;
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            java.lang.String r0 = "containingDeclaration"
            q7.k.e(r12, r0)
            java.lang.String r0 = "annotations"
            q7.k.e(r14, r0)
            java.lang.String r0 = "kind"
            r5 = r16
            m.x.t(r5, r0)
            java.lang.String r0 = "proto"
            q7.k.e(r7, r0)
            java.lang.String r0 = "nameResolver"
            q7.k.e(r8, r0)
            java.lang.String r0 = "typeTable"
            q7.k.e(r9, r0)
            java.lang.String r0 = "versionRequirementTable"
            q7.k.e(r10, r0)
            if (r22 != 0) goto L38
            f8.o0 r0 = f8.n0.f3487b
            r6 = r0
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r0 = r11
            goto L3f
        L38:
            r6 = r22
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
        L3f:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.J = r7
            r11.K = r8
            r11.L = r9
            r11.M = r10
            r1 = r21
            r11.N = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t9.c.<init>(f8.e, f8.i, g8.j, boolean, int, z8.k, b9.f, b9.g, b9.h, t9.j, f8.n0):void");
    }

    @Override // i8.i, i8.u
    public final /* bridge */ /* synthetic */ i8.u I0(int i2, e9.f fVar, f8.j jVar, f8.t tVar, n0 n0Var, g8.j jVar2) {
        return X0(jVar, tVar, i2, jVar2, n0Var);
    }

    @Override // t9.k
    public final f9.a L() {
        return this.J;
    }

    @Override // i8.i
    /* renamed from: R0 */
    public final /* bridge */ /* synthetic */ i8.i I0(int i2, e9.f fVar, f8.j jVar, f8.t tVar, n0 n0Var, g8.j jVar2) {
        return X0(jVar, tVar, i2, jVar2, n0Var);
    }

    public final c X0(f8.j jVar, f8.t tVar, int i2, g8.j jVar2, n0 n0Var) {
        q7.k.e(jVar, "newOwner");
        x.t(i2, "kind");
        q7.k.e(jVar2, "annotations");
        c cVar = new c((f8.e) jVar, (f8.i) tVar, jVar2, this.I, i2, this.J, this.K, this.L, this.M, this.N, n0Var);
        cVar.A = this.A;
        return cVar;
    }

    @Override // i8.u, f8.t
    public final boolean e() {
        return false;
    }

    @Override // i8.u, f8.t
    public final boolean e0() {
        return false;
    }

    @Override // t9.k
    public final b9.g m0() {
        return this.L;
    }

    @Override // i8.u, f8.t
    public final boolean o() {
        return false;
    }

    @Override // t9.k
    public final j u() {
        return this.N;
    }

    @Override // i8.u, f8.w
    public final boolean w() {
        return false;
    }

    @Override // t9.k
    public final b9.f z0() {
        return this.K;
    }
}
