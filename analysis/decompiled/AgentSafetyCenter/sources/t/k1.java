package t;

import com.google.crypto.tink.shaded.protobuf.Reader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k1 extends w0.l implements u1.w {

    /* renamed from: s, reason: collision with root package name */
    public h1 f13027s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f13028t;

    @Override // u1.w
    public final s1.g0 f(u1.o0 o0Var, s1.e0 e0Var, long j10) {
        o.c(j10, this.f13028t ? u.f0.f13453c : u.f0.f13454f);
        boolean z10 = this.f13028t;
        int i = Reader.READ_DONE;
        int iH = z10 ? Integer.MAX_VALUE : o2.a.h(j10);
        if (this.f13028t) {
            i = o2.a.i(j10);
        }
        s1.o0 o0VarQ = e0Var.q(o2.a.b(j10, 0, i, 0, iH, 5));
        int i3 = o0VarQ.f11277c;
        int i10 = o2.a.i(j10);
        if (i3 > i10) {
            i3 = i10;
        }
        int i11 = o0VarQ.f11278f;
        int iH2 = o2.a.h(j10);
        if (i11 > iH2) {
            i11 = iH2;
        }
        int i12 = o0VarQ.f11278f - i11;
        int i13 = o0VarQ.f11277c - i3;
        if (!this.f13028t) {
            i12 = i13;
        }
        h1 h1Var = this.f13027s;
        k0.h1 h1Var2 = h1Var.f13001d;
        k0.h1 h1Var3 = h1Var.f12998a;
        h1Var2.h(i12);
        u0.f fVarD = u0.r.d();
        xb.l lVarE = fVarD != null ? fVarD.e() : null;
        u0.f fVarG = u0.r.g(fVarD);
        try {
            if (h1Var3.g() > i12) {
                h1Var3.h(i12);
            }
            u0.r.j(fVarD, fVarG, lVarE);
            this.f13027s.f12999b.h(this.f13028t ? i11 : i3);
            return o0Var.Y(i3, i11, kb.t.f7405c, new j1(this, i12, o0VarQ));
        } catch (Throwable th) {
            u0.r.j(fVarD, fVarG, lVarE);
            throw th;
        }
    }
}
