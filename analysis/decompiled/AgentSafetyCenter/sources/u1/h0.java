package u1;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final s1.o0 f13822a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13824c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13825d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13826e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13827f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13828g;

    /* renamed from: h, reason: collision with root package name */
    public a f13829h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f13830j;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13823b = true;
    public final HashMap i = new HashMap();

    /* JADX WARN: Multi-variable type inference failed */
    public h0(a aVar, int i) {
        this.f13830j = i;
        this.f13822a = (s1.o0) aVar;
    }

    /* JADX WARN: Type inference failed for: r12v5, types: [xb.p, yb.i] */
    /* JADX WARN: Type inference failed for: r3v8, types: [s1.o0, u1.a] */
    public static final void a(h0 h0Var, s1.l lVar, int i, g1 g1Var) {
        HashMap map = h0Var.i;
        float f5 = i;
        long jFloatToRawIntBits = Float.floatToRawIntBits(f5) << 32;
        long jFloatToRawIntBits2 = Float.floatToRawIntBits(f5) & 4294967295L;
        while (true) {
            long jC = jFloatToRawIntBits | jFloatToRawIntBits2;
            do {
                switch (h0Var.f13830j) {
                    case 0:
                        m1 m1Var = g1Var.M;
                        if (m1Var != null) {
                            v1.h1 h1Var = (v1.h1) m1Var;
                            float[] fArrB = h1Var.b();
                            if (!h1Var.f14470w) {
                                jC = d1.f0.l(fArrB, jC);
                            }
                        }
                        jC = td.h.C(jC, g1Var.D);
                        break;
                    default:
                        p0 p0VarF0 = g1Var.F0();
                        p0VarF0.getClass();
                        long j10 = p0VarF0.f13890t;
                        jC = c1.b.h((Float.floatToRawIntBits((int) (j10 & 4294967295L)) & 4294967295L) | (Float.floatToRawIntBits((int) (j10 >> 32)) << 32), jC);
                        break;
                }
                g1Var = g1Var.f13812u;
                g1Var.getClass();
                if (g1Var.equals(h0Var.f13822a.f())) {
                    int iRound = Math.round(lVar instanceof s1.l ? Float.intBitsToFloat((int) (jC & 4294967295L)) : Float.intBitsToFloat((int) (jC >> 32)));
                    if (map.containsKey(lVar)) {
                        int iIntValue = ((Number) kb.w.M(map, lVar)).intValue();
                        s1.l lVar2 = s1.c.f11219a;
                        iRound = ((Number) lVar.f11264a.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iRound))).intValue();
                    }
                    map.put(lVar, Integer.valueOf(iRound));
                    return;
                }
            } while (!h0Var.b(g1Var).containsKey(lVar));
            float fC = h0Var.c(g1Var, lVar);
            long jFloatToRawIntBits3 = Float.floatToRawIntBits(fC);
            long jFloatToRawIntBits4 = Float.floatToRawIntBits(fC);
            jFloatToRawIntBits = jFloatToRawIntBits3 << 32;
            jFloatToRawIntBits2 = jFloatToRawIntBits4 & 4294967295L;
        }
    }

    public final Map b(g1 g1Var) {
        switch (this.f13830j) {
            case 0:
                return g1Var.p0().b();
            default:
                p0 p0VarF0 = g1Var.F0();
                p0VarF0.getClass();
                return p0VarF0.p0().b();
        }
    }

    public final int c(g1 g1Var, s1.l lVar) {
        switch (this.f13830j) {
            case 0:
                return g1Var.H(lVar);
            default:
                p0 p0VarF0 = g1Var.F0();
                p0VarF0.getClass();
                return p0VarF0.H(lVar);
        }
    }

    public final boolean d() {
        return this.f13824c || this.f13826e || this.f13827f || this.f13828g;
    }

    public final boolean e() {
        h();
        return this.f13829h != null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [s1.o0, u1.a] */
    public final void f() {
        this.f13823b = true;
        ?? r02 = this.f13822a;
        a aVarH = r02.h();
        if (aVarH == null) {
            return;
        }
        if (this.f13824c) {
            aVarH.F();
        } else if (this.f13826e || this.f13825d) {
            aVarH.requestLayout();
        }
        if (this.f13827f) {
            r02.F();
        }
        if (this.f13828g) {
            r02.requestLayout();
        }
        aVarH.b().f();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [s1.o0, u1.a] */
    public final void g() {
        HashMap map = this.i;
        map.clear();
        a2.m mVar = new a2.m(this, 20);
        ?? r22 = this.f13822a;
        r22.d(mVar);
        map.putAll(b(r22.f()));
        this.f13823b = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Type inference failed for: r1v0, types: [s1.o0, u1.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r2 = this;
            boolean r0 = r2.d()
            s1.o0 r1 = r2.f13822a
            if (r0 == 0) goto L9
            goto L51
        L9:
            u1.a r0 = r1.h()
            if (r0 != 0) goto L10
            goto L53
        L10:
            u1.h0 r0 = r0.b()
            u1.a r1 = r0.f13829h
            if (r1 == 0) goto L23
            u1.h0 r0 = r1.b()
            boolean r0 = r0.d()
            if (r0 == 0) goto L23
            goto L51
        L23:
            u1.a r0 = r2.f13829h
            if (r0 == 0) goto L53
            u1.h0 r1 = r0.b()
            boolean r1 = r1.d()
            if (r1 == 0) goto L32
            goto L53
        L32:
            u1.a r1 = r0.h()
            if (r1 == 0) goto L41
            u1.h0 r1 = r1.b()
            if (r1 == 0) goto L41
            r1.h()
        L41:
            u1.a r0 = r0.h()
            if (r0 == 0) goto L50
            u1.h0 r0 = r0.b()
            if (r0 == 0) goto L50
            u1.a r1 = r0.f13829h
            goto L51
        L50:
            r1 = 0
        L51:
            r2.f13829h = r1
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.h0.h():void");
    }
}
