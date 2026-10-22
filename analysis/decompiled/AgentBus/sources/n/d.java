package n;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final j f6588a = new j(Float.POSITIVE_INFINITY);

    /* renamed from: b, reason: collision with root package name */
    public static final k f6589b = new k(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

    /* renamed from: c, reason: collision with root package name */
    public static final l f6590c = new l(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

    /* renamed from: d, reason: collision with root package name */
    public static final m f6591d = new m(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

    /* renamed from: e, reason: collision with root package name */
    public static final j f6592e = new j(Float.NEGATIVE_INFINITY);

    /* renamed from: f, reason: collision with root package name */
    public static final k f6593f = new k(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    /* renamed from: g, reason: collision with root package name */
    public static final l f6594g = new l(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    /* renamed from: h, reason: collision with root package name */
    public static final m f6595h = new m(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    public static c a() {
        return new c(Float.valueOf(0.0f), g1.f6621a, Float.valueOf(0.01f), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(n.i r23, n.e r24, long r25, p7.k r27, i7.c r28) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.d.b(n.i, n.e, long, p7.k, i7.c):java.lang.Object");
    }

    public static final a0 c(d0 d0Var, float f10, z zVar, b0.p pVar) {
        return d(d0Var, Float.valueOf(0.0f), Float.valueOf(f10), g1.f6621a, zVar, pVar, 33208, 0);
    }

    public static final a0 d(d0 d0Var, Number number, Number number2, q6.b bVar, z zVar, b0.p pVar, int i2, int i10) {
        d0 d0Var2;
        Number number3;
        Number number4;
        z zVar2;
        Object objJ = pVar.J();
        b0.b1 b1Var = b0.k.f1229a;
        if (objJ == b1Var) {
            d0Var2 = d0Var;
            number3 = number;
            number4 = number2;
            zVar2 = zVar;
            a0 a0Var = new a0(d0Var2, number3, number4, bVar, zVar2);
            pVar.b0(a0Var);
            objJ = a0Var;
        } else {
            d0Var2 = d0Var;
            number3 = number;
            number4 = number2;
            zVar2 = zVar;
        }
        a0 a0Var2 = (a0) objJ;
        boolean z4 = (((57344 & i2) ^ 24576) > 16384 && pVar.h(zVar2)) || (i2 & 24576) == 16384;
        Object objJ2 = pVar.J();
        if (z4 || objJ2 == b1Var) {
            objJ2 = new e0(number3, a0Var2, number4, zVar2);
            pVar.b0(objJ2);
        }
        b0.b.f((p7.a) objJ2, pVar);
        boolean zH = pVar.h(d0Var2);
        Object objJ3 = pVar.J();
        if (zH || objJ3 == b1Var) {
            objJ3 = new g1.y(8, d0Var2, a0Var2);
            pVar.b0(objJ3);
        }
        b0.b.d(a0Var2, (p7.k) objJ3, pVar);
        return a0Var2;
    }

    public static final n e(n nVar) {
        n nVarC = nVar.c();
        int iB = nVarC.b();
        for (int i2 = 0; i2 < iB; i2++) {
            nVarC.e(i2, nVar.a(i2));
        }
        return nVarC;
    }

    public static final void f(g gVar, long j2, float f10, e eVar, i iVar, p7.k kVar) {
        long jD = f10 == 0.0f ? eVar.d() : (long) ((j2 - gVar.f6613c) / f10);
        gVar.f6617g = j2;
        gVar.f6615e.setValue(eVar.c(jD));
        gVar.f6616f = eVar.g(jD);
        if (eVar.i(jD)) {
            gVar.f6618h = gVar.f6617g;
            gVar.f6619i.setValue(Boolean.FALSE);
        }
        j(gVar, iVar);
        kVar.invoke(gVar);
    }

    public static final float g(g7.l lVar) {
        n0.o oVar = (n0.o) lVar.o(n0.b.f6786t);
        float fH = oVar != null ? oVar.H() : 1.0f;
        if (fH >= 0.0f) {
            return fH;
        }
        j0.b("negative scale factor");
        return fH;
    }

    public static z h(s sVar) {
        return new z(sVar, 0);
    }

    public static l0 i(int i2, Object obj) {
        float f10 = (i2 & 2) != 0 ? 1500.0f : 400.0f;
        if ((i2 & 4) != 0) {
            obj = null;
        }
        return new l0(f10, obj);
    }

    public static final void j(g gVar, i iVar) {
        iVar.f6632g.setValue(gVar.f6615e.getValue());
        n nVar = iVar.f6633h;
        n nVar2 = gVar.f6616f;
        int iB = nVar.b();
        for (int i2 = 0; i2 < iB; i2++) {
            nVar.e(i2, nVar2.a(i2));
        }
        iVar.f6635j = gVar.f6618h;
        iVar.f6634i = gVar.f6617g;
        iVar.f6636k = ((Boolean) gVar.f6619i.getValue()).booleanValue();
    }
}
