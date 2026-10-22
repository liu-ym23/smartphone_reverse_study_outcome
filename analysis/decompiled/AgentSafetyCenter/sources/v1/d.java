package v1;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends h.b0 {

    /* renamed from: e, reason: collision with root package name */
    public static d f14396e;

    /* renamed from: f, reason: collision with root package name */
    public static final n2.j f14397f = n2.j.f8660f;

    /* renamed from: g, reason: collision with root package name */
    public static final n2.j f14398g = n2.j.f8659c;

    /* renamed from: c, reason: collision with root package name */
    public d2.i0 f14399c;

    /* renamed from: d, reason: collision with root package name */
    public a2.p f14400d;

    @Override // h.b0
    public final int[] e(int i) {
        int iC;
        if (i().length() > 0 && i < i().length()) {
            try {
                a2.p pVar = this.f14400d;
                if (pVar == null) {
                    yb.k.f("node");
                    throw null;
                }
                c1.c cVarG = pVar.g();
                int iRound = Math.round(cVarG.f2170d - cVarG.f2168b);
                if (i <= 0) {
                    i = 0;
                }
                d2.i0 i0Var = this.f14399c;
                if (i0Var == null) {
                    yb.k.f("layoutResult");
                    throw null;
                }
                int iB = i0Var.b(i);
                d2.i0 i0Var2 = this.f14399c;
                if (i0Var2 == null) {
                    yb.k.f("layoutResult");
                    throw null;
                }
                float fE = i0Var2.e(iB) + iRound;
                d2.i0 i0Var3 = this.f14399c;
                if (i0Var3 == null) {
                    yb.k.f("layoutResult");
                    throw null;
                }
                float fE2 = i0Var3.e(i0Var3.f3123b.f3154f - 1);
                d2.i0 i0Var4 = this.f14399c;
                if (fE < fE2) {
                    if (i0Var4 == null) {
                        yb.k.f("layoutResult");
                        throw null;
                    }
                    iC = i0Var4.c(fE);
                } else {
                    if (i0Var4 == null) {
                        yb.k.f("layoutResult");
                        throw null;
                    }
                    iC = i0Var4.f3123b.f3154f;
                }
                return h(i, m(iC - 1, f14398g) + 1);
            } catch (IllegalStateException unused) {
            }
        }
        return null;
    }

    @Override // h.b0
    public final int[] k(int i) {
        int iC;
        if (i().length() <= 0 || i <= 0) {
            return null;
        }
        try {
            a2.p pVar = this.f14400d;
            if (pVar == null) {
                yb.k.f("node");
                throw null;
            }
            c1.c cVarG = pVar.g();
            int iRound = Math.round(cVarG.f2170d - cVarG.f2168b);
            int length = i().length();
            if (length <= i) {
                i = length;
            }
            d2.i0 i0Var = this.f14399c;
            if (i0Var == null) {
                yb.k.f("layoutResult");
                throw null;
            }
            int iB = i0Var.b(i);
            d2.i0 i0Var2 = this.f14399c;
            if (i0Var2 == null) {
                yb.k.f("layoutResult");
                throw null;
            }
            float fE = i0Var2.e(iB) - iRound;
            if (fE > 0.0f) {
                d2.i0 i0Var3 = this.f14399c;
                if (i0Var3 == null) {
                    yb.k.f("layoutResult");
                    throw null;
                }
                iC = i0Var3.c(fE);
            } else {
                iC = 0;
            }
            if (i == i().length() && iC < iB) {
                iC++;
            }
            return h(m(iC, f14397f), i);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public final int m(int i, n2.j jVar) {
        d2.i0 i0Var = this.f14399c;
        if (i0Var == null) {
            yb.k.f("layoutResult");
            throw null;
        }
        int iD = i0Var.d(i);
        d2.i0 i0Var2 = this.f14399c;
        if (i0Var2 == null) {
            yb.k.f("layoutResult");
            throw null;
        }
        n2.j jVarF = i0Var2.f(iD);
        d2.i0 i0Var3 = this.f14399c;
        if (jVar != jVarF) {
            if (i0Var3 != null) {
                return i0Var3.d(i);
            }
            yb.k.f("layoutResult");
            throw null;
        }
        if (i0Var3 == null) {
            yb.k.f("layoutResult");
            throw null;
        }
        d2.o oVar = i0Var3.f3123b;
        oVar.b(i);
        ArrayList arrayList = oVar.f3156h;
        d2.a aVar = ((d2.q) arrayList.get(a.a.s(i, arrayList))).f3159a;
        return (aVar.f3039d.f(i - r4.f3162d) + r4.f3160b) - 1;
    }
}
