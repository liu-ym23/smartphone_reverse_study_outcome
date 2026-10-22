package w5;

import b0.t1;
import r.g0;
import r.i0;

/* loaded from: classes.dex */
public final class x implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f10771f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f10772g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f10773h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f10774i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f10775j;

    public x(String str, int i2, int i10, long j2, long j4) {
        this.f10771f = str;
        this.f10772g = i2;
        this.f10773h = i10;
        this.f10774i = j2;
        this.f10775j = j4;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        String str;
        b0.p pVar = (b0.p) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && pVar.z()) {
            pVar.O();
        } else {
            n0.m mVarD = androidx.compose.foundation.layout.a.d(androidx.compose.foundation.layout.a.f744a, 12);
            i0 i0VarA = g0.a(r.i.f8869d, n0.b.f6781o, pVar, 6);
            int iK = b0.b.k(pVar);
            t1 t1VarL = pVar.l();
            n0.m mVarV = a.a.V(pVar, mVarD);
            i1.h.f4488c.getClass();
            i1.y yVar = i1.g.f4474b;
            pVar.U();
            if (pVar.P) {
                pVar.k(yVar);
            } else {
                pVar.e0();
            }
            b0.b.q(pVar, i0VarA, i1.g.f4477e);
            b0.b.q(pVar, t1VarL, i1.g.f4476d);
            i1.f fVar = i1.g.f4478f;
            if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iK))) {
                a1.a.r(iK, pVar, iK, fVar);
            }
            b0.b.q(pVar, mVarV, i1.g.f4475c);
            a0.e("VERSION", this.f10771f + " (" + this.f10772g + ")", pVar, 6);
            a0.e("PID", String.valueOf(this.f10773h), pVar, 6);
            long j2 = this.f10774i;
            if (j2 <= 0) {
                str = "-";
            } else {
                long j4 = j2 / 1000;
                long j10 = 3600;
                long j11 = j4 / j10;
                long j12 = 60;
                long j13 = (j4 % j10) / j12;
                if (j11 > 0) {
                    str = j11 + "h" + j13 + "m";
                } else if (j13 > 0) {
                    str = j13 + "m" + (j4 % j12) + "s";
                } else {
                    str = j4 + "s";
                }
            }
            a0.e("UPTIME", str, pVar, 6);
            a0.e("RSS", this.f10775j + "MB", pVar, 6);
            pVar.q(true);
        }
        return c7.r.f1986a;
    }
}
