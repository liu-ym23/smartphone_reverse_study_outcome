package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.c;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b implements c.a {

    /* renamed from: d, reason: collision with root package name */
    public final a f1060d;

    /* renamed from: a, reason: collision with root package name */
    public SolverVariable f1057a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f1058b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<SolverVariable> f1059c = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public boolean f1061e = false;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        boolean a(SolverVariable solverVariable);

        SolverVariable b(int i10);

        void c(SolverVariable solverVariable, float f8, boolean z);

        void clear();

        void d();

        float e(SolverVariable solverVariable, boolean z);

        int f();

        float g(b bVar, boolean z);

        void h(SolverVariable solverVariable, float f8);

        float i(int i10);

        float j(SolverVariable solverVariable);

        void k(float f8);
    }

    public b() {
    }

    @Override // androidx.constraintlayout.core.c.a
    public SolverVariable a(boolean[] zArr) {
        return f(zArr, null);
    }

    public final void b(c cVar, int i10) {
        this.f1060d.h(cVar.j(i10), 1.0f);
        this.f1060d.h(cVar.j(i10), -1.0f);
    }

    public final void c(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z = true;
            }
            this.f1058b = i10;
        }
        if (z) {
            this.f1060d.h(solverVariable, 1.0f);
            this.f1060d.h(solverVariable2, -1.0f);
            this.f1060d.h(solverVariable3, -1.0f);
        } else {
            this.f1060d.h(solverVariable, -1.0f);
            this.f1060d.h(solverVariable2, 1.0f);
            this.f1060d.h(solverVariable3, 1.0f);
        }
    }

    public final void d(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z = true;
            }
            this.f1058b = i10;
        }
        if (z) {
            this.f1060d.h(solverVariable, 1.0f);
            this.f1060d.h(solverVariable2, -1.0f);
            this.f1060d.h(solverVariable3, 1.0f);
        } else {
            this.f1060d.h(solverVariable, -1.0f);
            this.f1060d.h(solverVariable2, 1.0f);
            this.f1060d.h(solverVariable3, -1.0f);
        }
    }

    public boolean e() {
        return this.f1057a == null && this.f1058b == 0.0f && this.f1060d.f() == 0;
    }

    public final SolverVariable f(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int iF = this.f1060d.f();
        SolverVariable solverVariable2 = null;
        float f8 = 0.0f;
        for (int i10 = 0; i10 < iF; i10++) {
            float fI = this.f1060d.i(i10);
            if (fI < 0.0f) {
                SolverVariable solverVariableB = this.f1060d.b(i10);
                if ((zArr == null || !zArr[solverVariableB.f1033b]) && solverVariableB != solverVariable && (((type = solverVariableB.f1039l) == SolverVariable.Type.f1044b || type == SolverVariable.Type.f1045c) && fI < f8)) {
                    f8 = fI;
                    solverVariable2 = solverVariableB;
                }
            }
        }
        return solverVariable2;
    }

    public final void g(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f1057a;
        if (solverVariable2 != null) {
            this.f1060d.h(solverVariable2, -1.0f);
            this.f1057a.f1034c = -1;
            this.f1057a = null;
        }
        float fE = this.f1060d.e(solverVariable, true) * (-1.0f);
        this.f1057a = solverVariable;
        if (fE == 1.0f) {
            return;
        }
        this.f1058b /= fE;
        this.f1060d.k(fE);
    }

    public final void h(c cVar, SolverVariable solverVariable, boolean z) {
        if (solverVariable.h) {
            float fJ = this.f1060d.j(solverVariable);
            this.f1058b = (solverVariable.f1036e * fJ) + this.f1058b;
            this.f1060d.e(solverVariable, z);
            if (z) {
                solverVariable.b(this);
            }
            if (this.f1060d.f() == 0) {
                this.f1061e = true;
                cVar.f1064b = true;
            }
        }
    }

    public void i(c cVar, b bVar, boolean z) {
        float fG = this.f1060d.g(bVar, z);
        this.f1058b = (bVar.f1058b * fG) + this.f1058b;
        if (z) {
            bVar.f1057a.b(this);
        }
        if (this.f1057a == null || this.f1060d.f() != 0) {
            return;
        }
        this.f1061e = true;
        cVar.f1064b = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            androidx.constraintlayout.core.SolverVariable r0 = r10.f1057a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            androidx.constraintlayout.core.SolverVariable r1 = r10.f1057a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = a0.a.j(r0, r1)
            float r1 = r10.f1058b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = v1.d.b(r0)
            float r1 = r10.f1058b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r4
            goto L36
        L35:
            r1 = r3
        L36:
            androidx.constraintlayout.core.b$a r5 = r10.f1060d
            int r5 = r5.f()
        L3c:
            if (r3 >= r5) goto L9c
            androidx.constraintlayout.core.b$a r6 = r10.f1060d
            androidx.constraintlayout.core.SolverVariable r6 = r6.b(r3)
            if (r6 != 0) goto L47
            goto L99
        L47:
            androidx.constraintlayout.core.b$a r7 = r10.f1060d
            float r7 = r7.i(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L52
            goto L99
        L52:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L66
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L76
            java.lang.String r1 = "- "
            java.lang.String r0 = a0.a.j(r0, r1)
        L64:
            float r7 = r7 * r9
            goto L76
        L66:
            if (r8 <= 0) goto L6f
            java.lang.String r1 = " + "
            java.lang.String r0 = a0.a.j(r0, r1)
            goto L76
        L6f:
            java.lang.String r1 = " - "
            java.lang.String r0 = a0.a.j(r0, r1)
            goto L64
        L76:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L81
            java.lang.String r0 = a0.a.j(r0, r6)
            goto L98
        L81:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L98:
            r1 = r4
        L99:
            int r3 = r3 + 1
            goto L3c
        L9c:
            if (r1 != 0) goto La5
            java.lang.String r10 = "0.0"
            java.lang.String r10 = a0.a.j(r0, r10)
            return r10
        La5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.b.toString():java.lang.String");
    }

    public b(e0.a aVar) {
        this.f1060d = new androidx.constraintlayout.core.a(this, aVar);
    }
}
