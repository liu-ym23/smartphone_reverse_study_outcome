package i1;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public final g1.s f4479a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4481c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4482d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4483e;

    /* renamed from: f, reason: collision with root package name */
    public a f4484f;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f4486h;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4480b = true;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f4485g = new HashMap();

    /* JADX WARN: Multi-variable type inference failed */
    public g0(a aVar, int i2) {
        this.f4486h = i2;
        this.f4479a = (g1.s) aVar;
    }

    /* JADX WARN: Type inference failed for: r12v5, types: [p7.n, q7.i] */
    /* JADX WARN: Type inference failed for: r3v5, types: [g1.s, i1.a] */
    public static final void a(g0 g0Var, g1.f fVar, int i2, d1 d1Var) {
        HashMap map = g0Var.f4485g;
        float f10 = i2;
        long jFloatToRawIntBits = Float.floatToRawIntBits(f10) << 32;
        long jFloatToRawIntBits2 = Float.floatToRawIntBits(f10) & 4294967295L;
        while (true) {
            long jU0 = jFloatToRawIntBits | jFloatToRawIntBits2;
            do {
                switch (g0Var.f4486h) {
                    case 0:
                        u0.a0 a0Var = d1.O;
                        jU0 = d1Var.U0(jU0);
                        break;
                    default:
                        n0 n0VarX0 = d1Var.x0();
                        q7.k.b(n0VarX0);
                        long j2 = n0VarX0.f4545u;
                        jU0 = t0.b.g((Float.floatToRawIntBits((int) (j2 & 4294967295L)) & 4294967295L) | (Float.floatToRawIntBits((int) (j2 >> 32)) << 32), jU0);
                        break;
                }
                d1Var = d1Var.f4439v;
                q7.k.b(d1Var);
                if (d1Var.equals(g0Var.f4479a.l())) {
                    int iRound = Math.round(fVar instanceof g1.f ? Float.intBitsToFloat((int) (jU0 & 4294967295L)) : Float.intBitsToFloat((int) (jU0 >> 32)));
                    if (map.containsKey(fVar)) {
                        int iIntValue = ((Number) d7.e0.Q(fVar, map)).intValue();
                        g1.f fVar2 = g1.c.f3711a;
                        iRound = ((Number) fVar.f3732a.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iRound))).intValue();
                    }
                    map.put(fVar, Integer.valueOf(iRound));
                    return;
                }
            } while (!g0Var.b(d1Var).containsKey(fVar));
            float fC = g0Var.c(d1Var, fVar);
            long jFloatToRawIntBits3 = Float.floatToRawIntBits(fC);
            long jFloatToRawIntBits4 = Float.floatToRawIntBits(fC);
            jFloatToRawIntBits = jFloatToRawIntBits3 << 32;
            jFloatToRawIntBits2 = jFloatToRawIntBits4 & 4294967295L;
        }
    }

    public final Map b(d1 d1Var) {
        switch (this.f4486h) {
            case 0:
                return d1Var.e0().a();
            default:
                n0 n0VarX0 = d1Var.x0();
                q7.k.b(n0VarX0);
                return n0VarX0.e0().a();
        }
    }

    public final int c(d1 d1Var, g1.f fVar) {
        switch (this.f4486h) {
            case 0:
                return d1Var.W(fVar);
            default:
                n0 n0VarX0 = d1Var.x0();
                q7.k.b(n0VarX0);
                return n0VarX0.W(fVar);
        }
    }

    public final boolean d() {
        return this.f4481c || this.f4482d || this.f4483e;
    }

    public final boolean e() {
        h();
        return this.f4484f != null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [g1.s, i1.a] */
    public final void f() {
        this.f4480b = true;
        ?? r02 = this.f4479a;
        a aVarM = r02.m();
        if (aVarM == null) {
            return;
        }
        if (this.f4481c) {
            aVarM.requestLayout();
        }
        if (this.f4482d) {
            r02.C();
        }
        if (this.f4483e) {
            r02.requestLayout();
        }
        aVarM.A().f();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [g1.s, i1.a] */
    public final void g() {
        HashMap map = this.f4485g;
        map.clear();
        c1.w wVar = new c1.w(3, this);
        ?? r22 = this.f4479a;
        r22.k(wVar);
        map.putAll(b(r22.l()));
        this.f4480b = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Type inference failed for: r1v0, types: [g1.s, i1.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r2 = this;
            boolean r0 = r2.d()
            g1.s r1 = r2.f4479a
            if (r0 == 0) goto L9
            goto L51
        L9:
            i1.a r0 = r1.m()
            if (r0 != 0) goto L10
            goto L53
        L10:
            i1.g0 r0 = r0.A()
            i1.a r1 = r0.f4484f
            if (r1 == 0) goto L23
            i1.g0 r0 = r1.A()
            boolean r0 = r0.d()
            if (r0 == 0) goto L23
            goto L51
        L23:
            i1.a r0 = r2.f4484f
            if (r0 == 0) goto L53
            i1.g0 r1 = r0.A()
            boolean r1 = r1.d()
            if (r1 == 0) goto L32
            goto L53
        L32:
            i1.a r1 = r0.m()
            if (r1 == 0) goto L41
            i1.g0 r1 = r1.A()
            if (r1 == 0) goto L41
            r1.h()
        L41:
            i1.a r0 = r0.m()
            if (r0 == 0) goto L50
            i1.g0 r0 = r0.A()
            if (r0 == 0) goto L50
            i1.a r1 = r0.f4484f
            goto L51
        L50:
            r1 = 0
        L51:
            r2.f4484f = r1
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.g0.h():void");
    }
}
