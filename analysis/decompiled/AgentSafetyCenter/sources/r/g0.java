package r;

import s.e1;
import s.x0;
import s.y0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 extends w0.l implements u1.w {
    public long A;
    public w0.e B;
    public f0 C;
    public f0 D;

    /* renamed from: s, reason: collision with root package name */
    public e1 f10283s;

    /* renamed from: t, reason: collision with root package name */
    public y0 f10284t;

    /* renamed from: u, reason: collision with root package name */
    public y0 f10285u;

    /* renamed from: v, reason: collision with root package name */
    public y0 f10286v;

    /* renamed from: w, reason: collision with root package name */
    public h0 f10287w;

    /* renamed from: x, reason: collision with root package name */
    public i0 f10288x;

    /* renamed from: y, reason: collision with root package name */
    public xb.a f10289y;

    /* renamed from: z, reason: collision with root package name */
    public x f10290z;

    public final w0.e B0() {
        if (this.f10283s.f().a(w.f10348c, w.f10349f)) {
            q0 q0Var = this.f10287w.f10297a;
            q0 q0Var2 = this.f10288x.f10306a;
            return null;
        }
        q0 q0Var3 = this.f10288x.f10306a;
        q0 q0Var4 = this.f10287w.f10297a;
        return null;
    }

    @Override // u1.w
    public final s1.g0 f(u1.o0 o0Var, s1.e0 e0Var, long j10) {
        long j11;
        if (this.f10283s.c() == this.f10283s.f10992d.getValue()) {
            this.B = null;
        } else if (this.B == null) {
            w0.e eVarB0 = B0();
            if (eVarB0 == null) {
                eVarB0 = w0.b.f15089c;
            }
            this.B = eVarB0;
        }
        boolean zV = o0Var.V();
        kb.t tVar = kb.t.f7405c;
        if (zV) {
            s1.o0 o0VarQ = e0Var.q(j10);
            long jB = ac.a.b(o0VarQ.f11277c, o0VarQ.f11278f);
            this.A = jB;
            return o0Var.Y((int) (jB >> 32), (int) (jB & 4294967295L), tVar, new a1.i(o0VarQ, 4));
        }
        if (!((Boolean) this.f10289y.invoke()).booleanValue()) {
            s1.o0 o0VarQ2 = e0Var.q(j10);
            return o0Var.Y(o0VarQ2.f11277c, o0VarQ2.f11278f, tVar, new a1.i(o0VarQ2, 5));
        }
        x xVar = this.f10290z;
        y0 y0Var = xVar.f10352a;
        y0 y0Var2 = xVar.f10353b;
        e1 e1Var = xVar.f10354c;
        h0 h0Var = xVar.f10355d;
        i0 i0Var = xVar.f10356e;
        y0 y0Var3 = xVar.f10357f;
        x0 x0VarA = y0Var != null ? y0Var.a(new y(h0Var, i0Var, 0), new y(h0Var, i0Var, 1)) : null;
        x0 x0VarA2 = y0Var2 != null ? y0Var2.a(new y(h0Var, i0Var, 2), new y(h0Var, i0Var, 3)) : null;
        if (e1Var.c() == w.f10348c) {
            q0 q0Var = i0Var.f10306a;
        } else {
            q0 q0Var2 = i0Var.f10306a;
        }
        b.g gVar = new b.g(x0VarA, x0VarA2, y0Var3 != null ? y0Var3.a(c.f10251j, new b.g(x0VarA, h0Var, i0Var, 4)) : null, 3);
        s1.o0 o0VarQ3 = e0Var.q(j10);
        long jB2 = ac.a.b(o0VarQ3.f11277c, o0VarQ3.f11278f);
        long j12 = !o2.k.b(this.A, u.f10343a) ? this.A : jB2;
        y0 y0Var4 = this.f10284t;
        x0VarA = y0Var4 != null ? y0Var4.a(this.C, new e0(this, j12, 0)) : null;
        if (x0VarA != null) {
            jB2 = ((o2.k) x0VarA.getValue()).f9122a;
        }
        long jD = o2.b.d(j10, jB2);
        y0 y0Var5 = this.f10285u;
        long jA = 0;
        long j13 = y0Var5 != null ? ((o2.i) y0Var5.a(c.f10252k, new e0(this, j12, 1)).getValue()).f9116a : 0L;
        y0 y0Var6 = this.f10286v;
        long j14 = y0Var6 != null ? ((o2.i) y0Var6.a(this.D, new e0(this, j12, 2)).getValue()).f9116a : 0L;
        w0.e eVar = this.B;
        if (eVar != null) {
            long j15 = j12;
            j11 = j14;
            jA = eVar.a(j15, jD, o2.l.f9123c);
        } else {
            j11 = j14;
        }
        return o0Var.Y((int) (jD >> 32), (int) (jD & 4294967295L), tVar, new d0(o0VarQ3, o2.i.d(jA, j11), j13, gVar, 0));
    }

    @Override // w0.l
    public final void t0() {
        this.A = u.f10343a;
    }
}
