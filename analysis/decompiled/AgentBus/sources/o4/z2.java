package o4;

/* loaded from: classes.dex */
public final /* synthetic */ class z2 extends q7.i implements p7.n {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f7727n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z2(int i2, Object obj, Class cls, String str, String str2, int i10, int i11) {
        super(i2, obj, cls, str, str2, i10);
        this.f7727n = i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        h4.e eVar;
        switch (this.f7727n) {
            case 0:
                return ((b3) this.f8801g).j((c5.b) obj, (g7.d) obj2);
            case 1:
                i5.u uVar = (i5.u) this.f8801g;
                return ia.d0.B(uVar.f4724d.f5619d, new b0.f2((String) obj, uVar, (g7.d) null, 4), (g7.d) obj2);
            case 2:
                i5.u uVar2 = (i5.u) this.f8801g;
                return ia.d0.B(uVar2.f4724d.f5619d, new b0.f2((String) obj, uVar2, (g7.d) null, 4), (g7.d) obj2);
            case 3:
                k0 k0Var = (k0) obj;
                g7.d dVar = (g7.d) obj2;
                y4.m mVar = (y4.m) this.f8801g;
                k5.s.info$default(mVar.f11607f, "OpenClawCloudBridge", "Cloud claw relayInvoke ".concat(k0Var.f7421c), null, 4, null);
                Object[] objArr = 0;
                Object[] objArr2 = 0;
                Object[] objArr3 = 0;
                if (y4.m.f11601v.contains(k0Var.f7421c)) {
                    return mVar.d(k0Var, new y4.k(mVar, k0Var, objArr3 == true ? 1 : 0, 0), dVar);
                }
                if (k0Var.f7421c.equals("agent.call")) {
                    return mVar.d(k0Var, new y4.k(mVar, k0Var, objArr2 == true ? 1 : 0, 1), dVar);
                }
                String strS = mVar.f11611j.s(k0Var.f7421c);
                d5.e eVarC = strS != null ? mVar.f11603b.c(strS) : null;
                if (eVarC != null) {
                    return mVar.d(k0Var, new la.a0((Object) mVar, (Object) k0Var, (Object) eVarC, (g7.d) (objArr == true ? 1 : 0), 9), dVar);
                }
                t1 t1Var = (t1) mVar.f11613l.c();
                if (t1Var == null) {
                    return new l0(false, null, new j0("UNAVAILABLE", "edge openclaw vendor not active", null));
                }
                synchronized (mVar) {
                    h4.e eVar2 = mVar.f11621t;
                    if (eVar2 != null) {
                        eVar = mVar.f11622u == t1Var ? eVar2 : null;
                        if (eVar != null) {
                        }
                    }
                    h4.e eVar3 = new h4.e(new m4.w0(t1Var), new i5.l(t1Var, mVar.f11607f), mVar.f11610i, mVar.f11607f);
                    mVar.f11621t = eVar3;
                    mVar.f11622u = t1Var;
                    eVar = eVar3;
                }
                return eVar.a(k0Var, dVar);
            default:
                ua.d dVar2 = (ua.d) obj;
                int iIntValue = ((Number) obj2).intValue();
                q7.k.e(dVar2, "p0");
                ya.e eVar4 = (ya.e) this.f8801g;
                eVar4.getClass();
                boolean z4 = !dVar2.j(iIntValue) && dVar2.i(iIntValue).g();
                eVar4.f11735b = z4;
                return Boolean.valueOf(z4);
        }
    }
}
