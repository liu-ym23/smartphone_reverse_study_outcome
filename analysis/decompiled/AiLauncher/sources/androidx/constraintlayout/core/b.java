package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.c;
import java.util.ArrayList;
import l0.C4855a;

/* loaded from: classes.dex */
public class b implements c.a {

    /* renamed from: e, reason: collision with root package name */
    public a f11871e;

    /* renamed from: a, reason: collision with root package name */
    public SolverVariable f11867a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f11868b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11869c = false;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<SolverVariable> f11870d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public boolean f11872f = false;

    public interface a {
        boolean a(SolverVariable solverVariable);

        SolverVariable b(int i10);

        void c(SolverVariable solverVariable, float f10, boolean z10);

        void clear();

        void d();

        float e(SolverVariable solverVariable, boolean z10);

        float f(b bVar, boolean z10);

        void g(SolverVariable solverVariable, float f10);

        int getCurrentSize();

        float h(int i10);

        float i(SolverVariable solverVariable);

        void j(float f10);
    }

    public b() {
    }

    public void A(c cVar, SolverVariable solverVariable, boolean z10) {
        if (solverVariable == null || !solverVariable.f11844g) {
            return;
        }
        this.f11868b += solverVariable.f11843f * this.f11871e.i(solverVariable);
        this.f11871e.e(solverVariable, z10);
        if (z10) {
            solverVariable.e(this);
        }
        if (c.f11875u && this.f11871e.getCurrentSize() == 0) {
            this.f11872f = true;
            cVar.f11881b = true;
        }
    }

    public void B(c cVar, b bVar, boolean z10) {
        this.f11868b += bVar.f11868b * this.f11871e.f(bVar, z10);
        if (z10) {
            bVar.f11867a.e(this);
        }
        if (c.f11875u && this.f11867a != null && this.f11871e.getCurrentSize() == 0) {
            this.f11872f = true;
            cVar.f11881b = true;
        }
    }

    public void C(c cVar, SolverVariable solverVariable, boolean z10) {
        if (solverVariable == null || !solverVariable.f11851n) {
            return;
        }
        float fI = this.f11871e.i(solverVariable);
        this.f11868b += solverVariable.f11853p * fI;
        this.f11871e.e(solverVariable, z10);
        if (z10) {
            solverVariable.e(this);
        }
        this.f11871e.c(cVar.f11894o.f36871d[solverVariable.f11852o], fI, z10);
        if (c.f11875u && this.f11871e.getCurrentSize() == 0) {
            this.f11872f = true;
            cVar.f11881b = true;
        }
    }

    public void D(c cVar) {
        if (cVar.f11887h.length == 0) {
            return;
        }
        boolean z10 = false;
        while (!z10) {
            int currentSize = this.f11871e.getCurrentSize();
            for (int i10 = 0; i10 < currentSize; i10++) {
                SolverVariable solverVariableB = this.f11871e.b(i10);
                if (solverVariableB.f11841d != -1 || solverVariableB.f11844g || solverVariableB.f11851n) {
                    this.f11870d.add(solverVariableB);
                }
            }
            int size = this.f11870d.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    SolverVariable solverVariable = this.f11870d.get(i11);
                    if (solverVariable.f11844g) {
                        A(cVar, solverVariable, true);
                    } else if (solverVariable.f11851n) {
                        C(cVar, solverVariable, true);
                    } else {
                        B(cVar, cVar.f11887h[solverVariable.f11841d], true);
                    }
                }
                this.f11870d.clear();
            } else {
                z10 = true;
            }
        }
        if (c.f11875u && this.f11867a != null && this.f11871e.getCurrentSize() == 0) {
            this.f11872f = true;
            cVar.f11881b = true;
        }
    }

    @Override // androidx.constraintlayout.core.c.a
    public void a(c.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f11867a = null;
            this.f11871e.clear();
            for (int i10 = 0; i10 < bVar.f11871e.getCurrentSize(); i10++) {
                this.f11871e.c(bVar.f11871e.b(i10), bVar.f11871e.h(i10), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.c.a
    public SolverVariable b(c cVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // androidx.constraintlayout.core.c.a
    public void c(SolverVariable solverVariable) {
        int i10 = solverVariable.f11842e;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f11871e.g(solverVariable, f10);
    }

    @Override // androidx.constraintlayout.core.c.a
    public void clear() {
        this.f11871e.clear();
        this.f11867a = null;
        this.f11868b = 0.0f;
    }

    public b d(c cVar, int i10) {
        this.f11871e.g(cVar.o(i10, "ep"), 1.0f);
        this.f11871e.g(cVar.o(i10, "em"), -1.0f);
        return this;
    }

    public b e(SolverVariable solverVariable, int i10) {
        this.f11871e.g(solverVariable, i10);
        return this;
    }

    public boolean f(c cVar) {
        boolean z10;
        SolverVariable solverVariableG = g(cVar);
        if (solverVariableG == null) {
            z10 = true;
        } else {
            x(solverVariableG);
            z10 = false;
        }
        if (this.f11871e.getCurrentSize() == 0) {
            this.f11872f = true;
        }
        return z10;
    }

    public SolverVariable g(c cVar) {
        int currentSize = this.f11871e.getCurrentSize();
        SolverVariable solverVariable = null;
        float f10 = 0.0f;
        float f11 = 0.0f;
        boolean z10 = false;
        boolean z11 = false;
        SolverVariable solverVariable2 = null;
        for (int i10 = 0; i10 < currentSize; i10++) {
            float fH = this.f11871e.h(i10);
            SolverVariable solverVariableB = this.f11871e.b(i10);
            if (solverVariableB.f11847j == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null || f10 > fH) {
                    boolean zU = u(solverVariableB, cVar);
                    z10 = zU;
                    f10 = fH;
                    solverVariable = solverVariableB;
                } else if (!z10 && u(solverVariableB, cVar)) {
                    f10 = fH;
                    solverVariable = solverVariableB;
                    z10 = true;
                }
            } else if (solverVariable == null && fH < 0.0f) {
                if (solverVariable2 == null || f11 > fH) {
                    boolean zU2 = u(solverVariableB, cVar);
                    z11 = zU2;
                    f11 = fH;
                    solverVariable2 = solverVariableB;
                } else if (!z11 && u(solverVariableB, cVar)) {
                    f11 = fH;
                    solverVariable2 = solverVariableB;
                    z11 = true;
                }
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    @Override // androidx.constraintlayout.core.c.a
    public SolverVariable getKey() {
        return this.f11867a;
    }

    public b h(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11) {
        if (solverVariable2 == solverVariable3) {
            this.f11871e.g(solverVariable, 1.0f);
            this.f11871e.g(solverVariable4, 1.0f);
            this.f11871e.g(solverVariable2, -2.0f);
            return this;
        }
        if (f10 == 0.5f) {
            this.f11871e.g(solverVariable, 1.0f);
            this.f11871e.g(solverVariable2, -1.0f);
            this.f11871e.g(solverVariable3, -1.0f);
            this.f11871e.g(solverVariable4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                this.f11868b = (-i10) + i11;
                return this;
            }
        } else {
            if (f10 <= 0.0f) {
                this.f11871e.g(solverVariable, -1.0f);
                this.f11871e.g(solverVariable2, 1.0f);
                this.f11868b = i10;
                return this;
            }
            if (f10 >= 1.0f) {
                this.f11871e.g(solverVariable4, -1.0f);
                this.f11871e.g(solverVariable3, 1.0f);
                this.f11868b = -i11;
                return this;
            }
            float f11 = 1.0f - f10;
            this.f11871e.g(solverVariable, f11 * 1.0f);
            this.f11871e.g(solverVariable2, f11 * (-1.0f));
            this.f11871e.g(solverVariable3, (-1.0f) * f10);
            this.f11871e.g(solverVariable4, 1.0f * f10);
            if (i10 > 0 || i11 > 0) {
                this.f11868b = ((-i10) * f11) + (i11 * f10);
                return this;
            }
        }
        return this;
    }

    public b i(SolverVariable solverVariable, int i10) {
        this.f11867a = solverVariable;
        float f10 = i10;
        solverVariable.f11843f = f10;
        this.f11868b = f10;
        this.f11872f = true;
        return this;
    }

    @Override // androidx.constraintlayout.core.c.a
    public boolean isEmpty() {
        return this.f11867a == null && this.f11868b == 0.0f && this.f11871e.getCurrentSize() == 0;
    }

    public b j(SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        this.f11871e.g(solverVariable, -1.0f);
        this.f11871e.g(solverVariable2, f10);
        return this;
    }

    public b k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10) {
        this.f11871e.g(solverVariable, -1.0f);
        this.f11871e.g(solverVariable2, 1.0f);
        this.f11871e.g(solverVariable3, f10);
        this.f11871e.g(solverVariable4, -f10);
        return this;
    }

    public b l(float f10, float f11, float f12, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f11868b = 0.0f;
        if (f11 == 0.0f || f10 == f12) {
            this.f11871e.g(solverVariable, 1.0f);
            this.f11871e.g(solverVariable2, -1.0f);
            this.f11871e.g(solverVariable4, 1.0f);
            this.f11871e.g(solverVariable3, -1.0f);
            return this;
        }
        if (f10 == 0.0f) {
            this.f11871e.g(solverVariable, 1.0f);
            this.f11871e.g(solverVariable2, -1.0f);
            return this;
        }
        if (f12 == 0.0f) {
            this.f11871e.g(solverVariable3, 1.0f);
            this.f11871e.g(solverVariable4, -1.0f);
            return this;
        }
        float f13 = (f10 / f11) / (f12 / f11);
        this.f11871e.g(solverVariable, 1.0f);
        this.f11871e.g(solverVariable2, -1.0f);
        this.f11871e.g(solverVariable4, f13);
        this.f11871e.g(solverVariable3, -f13);
        return this;
    }

    public b m(SolverVariable solverVariable, int i10) {
        if (i10 < 0) {
            this.f11868b = i10 * (-1);
            this.f11871e.g(solverVariable, 1.0f);
            return this;
        }
        this.f11868b = i10;
        this.f11871e.g(solverVariable, -1.0f);
        return this;
    }

    public b n(SolverVariable solverVariable, SolverVariable solverVariable2, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f11868b = i10;
        }
        if (z10) {
            this.f11871e.g(solverVariable, 1.0f);
            this.f11871e.g(solverVariable2, -1.0f);
            return this;
        }
        this.f11871e.g(solverVariable, -1.0f);
        this.f11871e.g(solverVariable2, 1.0f);
        return this;
    }

    public b o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f11868b = i10;
        }
        if (z10) {
            this.f11871e.g(solverVariable, 1.0f);
            this.f11871e.g(solverVariable2, -1.0f);
            this.f11871e.g(solverVariable3, -1.0f);
            return this;
        }
        this.f11871e.g(solverVariable, -1.0f);
        this.f11871e.g(solverVariable2, 1.0f);
        this.f11871e.g(solverVariable3, 1.0f);
        return this;
    }

    public b p(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f11868b = i10;
        }
        if (z10) {
            this.f11871e.g(solverVariable, 1.0f);
            this.f11871e.g(solverVariable2, -1.0f);
            this.f11871e.g(solverVariable3, 1.0f);
            return this;
        }
        this.f11871e.g(solverVariable, -1.0f);
        this.f11871e.g(solverVariable2, 1.0f);
        this.f11871e.g(solverVariable3, -1.0f);
        return this;
    }

    public b q(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10) {
        this.f11871e.g(solverVariable3, 0.5f);
        this.f11871e.g(solverVariable4, 0.5f);
        this.f11871e.g(solverVariable, -0.5f);
        this.f11871e.g(solverVariable2, -0.5f);
        this.f11868b = -f10;
        return this;
    }

    public void r() {
        float f10 = this.f11868b;
        if (f10 < 0.0f) {
            this.f11868b = f10 * (-1.0f);
            this.f11871e.d();
        }
    }

    public boolean s() {
        SolverVariable solverVariable = this.f11867a;
        if (solverVariable != null) {
            return solverVariable.f11847j == SolverVariable.Type.UNRESTRICTED || this.f11868b >= 0.0f;
        }
        return false;
    }

    public boolean t(SolverVariable solverVariable) {
        return this.f11871e.a(solverVariable);
    }

    public String toString() {
        return z();
    }

    public final boolean u(SolverVariable solverVariable, c cVar) {
        return solverVariable.f11850m <= 1;
    }

    public SolverVariable v(SolverVariable solverVariable) {
        return w(null, solverVariable);
    }

    public final SolverVariable w(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.f11871e.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < currentSize; i10++) {
            float fH = this.f11871e.h(i10);
            if (fH < 0.0f) {
                SolverVariable solverVariableB = this.f11871e.b(i10);
                if ((zArr == null || !zArr[solverVariableB.f11840c]) && solverVariableB != solverVariable && (((type = solverVariableB.f11847j) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && fH < f10)) {
                    f10 = fH;
                    solverVariable2 = solverVariableB;
                }
            }
        }
        return solverVariable2;
    }

    public void x(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f11867a;
        if (solverVariable2 != null) {
            this.f11871e.g(solverVariable2, -1.0f);
            this.f11867a.f11841d = -1;
            this.f11867a = null;
        }
        float fE = this.f11871e.e(solverVariable, true) * (-1.0f);
        this.f11867a = solverVariable;
        if (fE == 1.0f) {
            return;
        }
        this.f11868b /= fE;
        this.f11871e.j(fE);
    }

    public void y() {
        this.f11867a = null;
        this.f11871e.clear();
        this.f11868b = 0.0f;
        this.f11872f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String z() {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.b.z():java.lang.String");
    }

    public b(C4855a c4855a) {
        this.f11871e = new androidx.constraintlayout.core.a(this, c4855a);
    }
}
