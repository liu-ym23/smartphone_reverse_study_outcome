package s;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final j f10976a = new j(Float.POSITIVE_INFINITY);

    /* renamed from: b, reason: collision with root package name */
    public static final k f10977b = new k(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

    /* renamed from: c, reason: collision with root package name */
    public static final l f10978c = new l(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

    /* renamed from: d, reason: collision with root package name */
    public static final m f10979d = new m(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

    /* renamed from: e, reason: collision with root package name */
    public static final j f10980e = new j(Float.NEGATIVE_INFINITY);

    /* renamed from: f, reason: collision with root package name */
    public static final k f10981f = new k(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    /* renamed from: g, reason: collision with root package name */
    public static final l f10982g = new l(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    /* renamed from: h, reason: collision with root package name */
    public static final m f10983h = new m(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    public static c a() {
        return new c(Float.valueOf(0.0f), i1.f11026a, Float.valueOf(0.01f), 8);
    }

    public static i b(float f5, int i) {
        if ((i & 2) != 0) {
            f5 = 0.0f;
        }
        return new i(i1.f11026a, Float.valueOf(0.0f), new j(f5), Long.MIN_VALUE, Long.MIN_VALUE, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(s.i r23, s.e r24, long r25, xb.l r27, nb.c r28) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.d.c(s.i, s.e, long, xb.l, nb.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [xb.l, yb.l] */
    /* JADX WARN: Type inference failed for: r6v3, types: [xb.l, yb.l] */
    public static Object d(i iVar, t tVar, b0.r rVar, u.j jVar) {
        Object value = iVar.f11021f.getValue();
        n nVar = iVar.f11022g;
        n6.a aVar = iVar.f11020c;
        a1.g gVar = tVar.f11121a;
        p5.i iVar2 = new p5.i();
        iVar2.f9730c = gVar;
        VarHandle.storeStoreFence();
        s sVar = new s();
        sVar.f11111a = iVar2;
        sVar.f11112b = aVar;
        sVar.f11113c = value;
        n nVar2 = (n) ((yb.l) aVar.f8776c).invoke(value);
        sVar.f11114d = nVar2;
        sVar.f11115e = h(nVar);
        ?? r32 = (yb.l) aVar.f8777f;
        if (((n) iVar2.f9733h) == null) {
            iVar2.f9733h = nVar2.c();
        }
        n nVar3 = (n) iVar2.f9733h;
        if (nVar3 == null) {
            yb.k.f("targetVector");
            throw null;
        }
        int iB = nVar3.b();
        int i = 0;
        while (true) {
            n nVar4 = (n) iVar2.f9733h;
            if (i >= iB) {
                if (nVar4 == null) {
                    yb.k.f("targetVector");
                    throw null;
                }
                sVar.f11117g = r32.invoke(nVar4);
                if (((n) iVar2.f9732g) == null) {
                    iVar2.f9732g = nVar2.c();
                }
                n nVar5 = (n) iVar2.f9732g;
                if (nVar5 == null) {
                    yb.k.f("velocityVector");
                    throw null;
                }
                int iB2 = nVar5.b();
                long jMax = 0;
                for (int i3 = 0; i3 < iB2; i3++) {
                    a1.g gVar2 = (a1.g) iVar2.f9730c;
                    nVar2.getClass();
                    jMax = Math.max(jMax, ((long) (Math.exp(((r.l0) gVar2.f19f).b(nVar.a(i3)) / (r.m0.f10318a - 1.0d)) * 1000.0d)) * 1000000);
                }
                sVar.f11118h = jMax;
                n nVarH = h(iVar2.x(jMax, nVar2, nVar));
                sVar.f11116f = nVarH;
                int iB3 = nVarH.b();
                for (int i10 = 0; i10 < iB3; i10++) {
                    n nVar6 = sVar.f11116f;
                    nVar6.e(p5.f.p(nVar6.a(i10), -0.0f, 0.0f), i10);
                }
                VarHandle.storeStoreFence();
                Object objC = c(iVar, sVar, Long.MIN_VALUE, rVar, jVar);
                return objC == ob.a.f9351c ? objC : jb.v.f6774a;
            }
            if (nVar4 == null) {
                yb.k.f("targetVector");
                throw null;
            }
            a1.g gVar3 = (a1.g) iVar2.f9730c;
            float fA = nVar2.a(i);
            float fA2 = nVar.a(i);
            r.l0 l0Var = (r.l0) gVar3.f19f;
            double dB = l0Var.b(fA2);
            double d7 = r.m0.f10318a;
            nVar4.e((Math.signum(fA2) * ((float) (Math.exp((d7 / (d7 - 1.0d)) * dB) * l0Var.f10313a * l0Var.f10314b))) + fA, i);
            i++;
            iB = iB;
        }
    }

    public static final c0 e(e0 e0Var, float f5, b0 b0Var, k0.s sVar) {
        return g(e0Var, Float.valueOf(0.0f), Float.valueOf(f5), i1.f11026a, b0Var, sVar, 33208);
    }

    public static Object f(i iVar, Float f5, o0 o0Var, boolean z10, xb.l lVar, pb.i iVar2, int i) {
        if ((i & 2) != 0) {
            o0Var = m(7, null);
        }
        o0 o0Var2 = o0Var;
        if ((i & 8) != 0) {
            lVar = v0.f11132f;
        }
        Object objC = c(iVar, new w0(o0Var2, iVar.f11020c, iVar.f11021f.getValue(), f5, iVar.f11022g), z10 ? iVar.f11023h : Long.MIN_VALUE, lVar, iVar2);
        return objC == ob.a.f9351c ? objC : jb.v.f6774a;
    }

    public static final c0 g(e0 e0Var, Number number, Number number2, n6.a aVar, b0 b0Var, k0.s sVar, int i) {
        b0 b0Var2;
        Object obj;
        Object objM = sVar.M();
        Object obj2 = k0.m.f6974a;
        if (objM == obj2) {
            c0 c0Var = new c0();
            c0Var.f10973m = e0Var;
            c0Var.f10966c = number;
            c0Var.f10967f = number2;
            c0Var.f10968g = aVar;
            c0Var.f10969h = k0.z.v(number);
            b0Var2 = b0Var;
            c0Var.i = new w0(b0Var2, aVar, c0Var.f10966c, c0Var.f10967f, null);
            VarHandle.storeStoreFence();
            sVar.i0(c0Var);
            obj = c0Var;
        } else {
            b0Var2 = b0Var;
            obj = objM;
        }
        c0 c0Var2 = (c0) obj;
        boolean z10 = (((57344 & i) ^ 24576) > 16384 && sVar.h(b0Var2)) || (i & 24576) == 16384;
        Object objM2 = sVar.M();
        if (z10 || objM2 == obj2) {
            objM2 = new f0(number, c0Var2, number2, b0Var2);
            sVar.i0(objM2);
        }
        k0.z.j((xb.a) objM2, sVar);
        boolean zH = sVar.h(e0Var);
        Object objM3 = sVar.M();
        if (zH || objM3 == obj2) {
            objM3 = new b0.n(13, e0Var, c0Var2);
            sVar.i0(objM3);
        }
        k0.z.d(c0Var2, (xb.l) objM3, sVar);
        return c0Var2;
    }

    public static final n h(n nVar) {
        n nVarC = nVar.c();
        int iB = nVarC.b();
        for (int i = 0; i < iB; i++) {
            nVarC.e(nVar.a(i), i);
        }
        return nVarC;
    }

    public static i i(i iVar, float f5) {
        float f10 = ((j) iVar.f11022g).f11034a;
        return new i(iVar.f11020c, Float.valueOf(f5), new j(f10), iVar.f11023h, iVar.i, iVar.f11024j);
    }

    public static final void j(g gVar, long j10, float f5, e eVar, i iVar, xb.l lVar) {
        long jB = f5 == 0.0f ? eVar.b() : (long) ((j10 - gVar.f11007c) / f5);
        gVar.f11011g = j10;
        gVar.f11009e.setValue(eVar.f(jB));
        gVar.f11010f = eVar.d(jB);
        if (eVar.e(jB)) {
            gVar.f11012h = gVar.f11011g;
            gVar.i.setValue(Boolean.FALSE);
        }
        o(gVar, iVar);
        lVar.invoke(gVar);
    }

    public static final float k(nb.g gVar) {
        w0.n nVar = (w0.n) gVar.get(w0.b.f15103t);
        float fR = nVar != null ? nVar.r() : 1.0f;
        if (fR >= 0.0f) {
            return fR;
        }
        m0.b("negative scale factor");
        return fR;
    }

    public static b0 l(u uVar) {
        b0 b0Var = new b0();
        b0Var.f10943a = uVar;
        b0Var.f10944b = 0;
        VarHandle.storeStoreFence();
        return b0Var;
    }

    public static o0 m(int i, Object obj) {
        float f5 = (i & 2) != 0 ? 1500.0f : 400.0f;
        if ((i & 4) != 0) {
            obj = null;
        }
        return new o0(f5, obj);
    }

    public static h1 n(int i, int i3, v vVar) {
        int i10 = (i3 & 2) != 0 ? 0 : 90;
        if ((i3 & 4) != 0) {
            vVar = w.f11152a;
        }
        return new h1(i, i10, vVar);
    }

    public static final void o(g gVar, i iVar) {
        iVar.f11021f.setValue(gVar.f11009e.getValue());
        n nVar = iVar.f11022g;
        n nVar2 = gVar.f11010f;
        int iB = nVar.b();
        for (int i = 0; i < iB; i++) {
            nVar.e(nVar2.a(i), i);
        }
        iVar.i = gVar.f11012h;
        iVar.f11023h = gVar.f11011g;
        iVar.f11024j = ((Boolean) gVar.i.getValue()).booleanValue();
    }
}
