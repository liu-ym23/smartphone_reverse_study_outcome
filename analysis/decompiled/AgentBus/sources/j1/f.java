package j1;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f extends c {

    /* renamed from: e, reason: collision with root package name */
    public static f f5133e;

    /* renamed from: f, reason: collision with root package name */
    public static final c2.j f5134f = c2.j.f1872g;

    /* renamed from: g, reason: collision with root package name */
    public static final c2.j f5135g = c2.j.f1871f;

    /* renamed from: c, reason: collision with root package name */
    public s1.e0 f5136c;

    /* renamed from: d, reason: collision with root package name */
    public p1.n f5137d;

    @Override // j1.c
    public final int[] c(int i2) {
        int iB;
        if (e().length() <= 0 || i2 >= e().length()) {
            return null;
        }
        try {
            p1.n nVar = this.f5137d;
            if (nVar == null) {
                q7.k.j("node");
                throw null;
            }
            t0.c cVarG = nVar.g();
            int iRound = Math.round(cVarG.f9659d - cVarG.f9657b);
            if (i2 <= 0) {
                i2 = 0;
            }
            s1.e0 e0Var = this.f5136c;
            if (e0Var == null) {
                q7.k.j("layoutResult");
                throw null;
            }
            int iA = e0Var.a(i2);
            s1.e0 e0Var2 = this.f5136c;
            if (e0Var2 == null) {
                q7.k.j("layoutResult");
                throw null;
            }
            float fD = e0Var2.d(iA) + iRound;
            s1.e0 e0Var3 = this.f5136c;
            if (e0Var3 == null) {
                q7.k.j("layoutResult");
                throw null;
            }
            if (e0Var3 == null) {
                q7.k.j("layoutResult");
                throw null;
            }
            if (fD < e0Var3.d(e0Var3.f9250b.f5754b - 1)) {
                s1.e0 e0Var4 = this.f5136c;
                if (e0Var4 == null) {
                    q7.k.j("layoutResult");
                    throw null;
                }
                iB = e0Var4.b(fD);
            } else {
                s1.e0 e0Var5 = this.f5136c;
                if (e0Var5 == null) {
                    q7.k.j("layoutResult");
                    throw null;
                }
                iB = e0Var5.f9250b.f5754b;
            }
            return d(i2, i(iB - 1, f5135g) + 1);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    @Override // j1.c
    public final int[] h(int i2) {
        int iB;
        if (e().length() <= 0 || i2 <= 0) {
            return null;
        }
        try {
            p1.n nVar = this.f5137d;
            if (nVar == null) {
                q7.k.j("node");
                throw null;
            }
            t0.c cVarG = nVar.g();
            int iRound = Math.round(cVarG.f9659d - cVarG.f9657b);
            int length = e().length();
            if (length <= i2) {
                i2 = length;
            }
            s1.e0 e0Var = this.f5136c;
            if (e0Var == null) {
                q7.k.j("layoutResult");
                throw null;
            }
            int iA = e0Var.a(i2);
            s1.e0 e0Var2 = this.f5136c;
            if (e0Var2 == null) {
                q7.k.j("layoutResult");
                throw null;
            }
            float fD = e0Var2.d(iA) - iRound;
            if (fD > 0.0f) {
                s1.e0 e0Var3 = this.f5136c;
                if (e0Var3 == null) {
                    q7.k.j("layoutResult");
                    throw null;
                }
                iB = e0Var3.b(fD);
            } else {
                iB = 0;
            }
            if (i2 == e().length() && iB < iA) {
                iB++;
            }
            return d(i(iB, f5134f), i2);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public final int i(int i2, c2.j jVar) {
        s1.e0 e0Var = this.f5136c;
        if (e0Var == null) {
            q7.k.j("layoutResult");
            throw null;
        }
        int iC = e0Var.c(i2);
        s1.e0 e0Var2 = this.f5136c;
        if (e0Var2 == null) {
            q7.k.j("layoutResult");
            throw null;
        }
        if (jVar != e0Var2.e(iC)) {
            s1.e0 e0Var3 = this.f5136c;
            if (e0Var3 != null) {
                return e0Var3.c(i2);
            }
            q7.k.j("layoutResult");
            throw null;
        }
        s1.e0 e0Var4 = this.f5136c;
        if (e0Var4 == null) {
            q7.k.j("layoutResult");
            throw null;
        }
        l0.i iVar = e0Var4.f9250b;
        iVar.b(i2);
        ArrayList arrayList = (ArrayList) iVar.f5757e;
        s1.a aVar = ((s1.m) arrayList.get(s1.z.d(i2, arrayList))).f9283a;
        return (aVar.f9207d.e(i2 - r4.f9286d) + r4.f9284b) - 1;
    }
}
