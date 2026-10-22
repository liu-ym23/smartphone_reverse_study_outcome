package j1;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e extends c {

    /* renamed from: d, reason: collision with root package name */
    public static e f5125d;

    /* renamed from: e, reason: collision with root package name */
    public static final c2.j f5126e = c2.j.f1872g;

    /* renamed from: f, reason: collision with root package name */
    public static final c2.j f5127f = c2.j.f1871f;

    /* renamed from: c, reason: collision with root package name */
    public s1.e0 f5128c;

    @Override // j1.c
    public final int[] c(int i2) {
        int iA;
        if (e().length() <= 0 || i2 >= e().length()) {
            return null;
        }
        c2.j jVar = f5126e;
        if (i2 < 0) {
            s1.e0 e0Var = this.f5128c;
            if (e0Var == null) {
                q7.k.j("layoutResult");
                throw null;
            }
            iA = e0Var.a(0);
        } else {
            s1.e0 e0Var2 = this.f5128c;
            if (e0Var2 == null) {
                q7.k.j("layoutResult");
                throw null;
            }
            int iA2 = e0Var2.a(i2);
            iA = i(iA2, jVar) == i2 ? iA2 : iA2 + 1;
        }
        s1.e0 e0Var3 = this.f5128c;
        if (e0Var3 == null) {
            q7.k.j("layoutResult");
            throw null;
        }
        if (iA >= e0Var3.f9250b.f5754b) {
            return null;
        }
        return d(i(iA, jVar), i(iA, f5127f) + 1);
    }

    @Override // j1.c
    public final int[] h(int i2) {
        int iA;
        if (e().length() <= 0 || i2 <= 0) {
            return null;
        }
        int length = e().length();
        c2.j jVar = f5127f;
        if (i2 > length) {
            s1.e0 e0Var = this.f5128c;
            if (e0Var == null) {
                q7.k.j("layoutResult");
                throw null;
            }
            iA = e0Var.a(e().length());
        } else {
            s1.e0 e0Var2 = this.f5128c;
            if (e0Var2 == null) {
                q7.k.j("layoutResult");
                throw null;
            }
            int iA2 = e0Var2.a(i2);
            iA = i(iA2, jVar) + 1 == i2 ? iA2 : iA2 - 1;
        }
        if (iA < 0) {
            return null;
        }
        return d(i(iA, f5126e), i(iA, jVar) + 1);
    }

    public final int i(int i2, c2.j jVar) {
        s1.e0 e0Var = this.f5128c;
        if (e0Var == null) {
            q7.k.j("layoutResult");
            throw null;
        }
        int iC = e0Var.c(i2);
        s1.e0 e0Var2 = this.f5128c;
        if (e0Var2 == null) {
            q7.k.j("layoutResult");
            throw null;
        }
        if (jVar != e0Var2.e(iC)) {
            s1.e0 e0Var3 = this.f5128c;
            if (e0Var3 != null) {
                return e0Var3.c(i2);
            }
            q7.k.j("layoutResult");
            throw null;
        }
        s1.e0 e0Var4 = this.f5128c;
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
