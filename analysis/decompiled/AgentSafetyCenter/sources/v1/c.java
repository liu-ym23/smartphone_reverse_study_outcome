package v1;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends h.b0 {

    /* renamed from: d, reason: collision with root package name */
    public static c f14385d;

    /* renamed from: e, reason: collision with root package name */
    public static final n2.j f14386e = n2.j.f8660f;

    /* renamed from: f, reason: collision with root package name */
    public static final n2.j f14387f = n2.j.f8659c;

    /* renamed from: c, reason: collision with root package name */
    public d2.i0 f14388c;

    @Override // h.b0
    public final int[] e(int i) {
        int iB;
        if (i().length() > 0 && i < i().length()) {
            d2.i0 i0Var = this.f14388c;
            n2.j jVar = f14386e;
            if (i < 0) {
                if (i0Var == null) {
                    yb.k.f("layoutResult");
                    throw null;
                }
                iB = i0Var.b(0);
            } else {
                if (i0Var == null) {
                    yb.k.f("layoutResult");
                    throw null;
                }
                int iB2 = i0Var.b(i);
                iB = m(iB2, jVar) == i ? iB2 : iB2 + 1;
            }
            d2.i0 i0Var2 = this.f14388c;
            if (i0Var2 == null) {
                yb.k.f("layoutResult");
                throw null;
            }
            if (iB < i0Var2.f3123b.f3154f) {
                return h(m(iB, jVar), m(iB, f14387f) + 1);
            }
        }
        return null;
    }

    @Override // h.b0
    public final int[] k(int i) {
        int iB;
        if (i().length() <= 0 || i <= 0) {
            return null;
        }
        int length = i().length();
        d2.i0 i0Var = this.f14388c;
        n2.j jVar = f14387f;
        if (i > length) {
            if (i0Var == null) {
                yb.k.f("layoutResult");
                throw null;
            }
            iB = i0Var.b(i().length());
        } else {
            if (i0Var == null) {
                yb.k.f("layoutResult");
                throw null;
            }
            int iB2 = i0Var.b(i);
            iB = m(iB2, jVar) + 1 == i ? iB2 : iB2 - 1;
        }
        if (iB < 0) {
            return null;
        }
        return h(m(iB, f14386e), m(iB, jVar) + 1);
    }

    public final int m(int i, n2.j jVar) {
        d2.i0 i0Var = this.f14388c;
        if (i0Var == null) {
            yb.k.f("layoutResult");
            throw null;
        }
        int iD = i0Var.d(i);
        d2.i0 i0Var2 = this.f14388c;
        if (i0Var2 == null) {
            yb.k.f("layoutResult");
            throw null;
        }
        n2.j jVarF = i0Var2.f(iD);
        d2.i0 i0Var3 = this.f14388c;
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
