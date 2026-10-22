package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;
import l0.C4855a;

/* loaded from: classes.dex */
public class e implements b.a {

    /* renamed from: n, reason: collision with root package name */
    public static float f11908n = 0.001f;

    /* renamed from: a, reason: collision with root package name */
    public final int f11909a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f11910b = 16;

    /* renamed from: c, reason: collision with root package name */
    public int f11911c = 16;

    /* renamed from: d, reason: collision with root package name */
    public int[] f11912d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    public int[] f11913e = new int[16];

    /* renamed from: f, reason: collision with root package name */
    public int[] f11914f = new int[16];

    /* renamed from: g, reason: collision with root package name */
    public float[] f11915g = new float[16];

    /* renamed from: h, reason: collision with root package name */
    public int[] f11916h = new int[16];

    /* renamed from: i, reason: collision with root package name */
    public int[] f11917i = new int[16];

    /* renamed from: j, reason: collision with root package name */
    public int f11918j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f11919k = -1;

    /* renamed from: l, reason: collision with root package name */
    public final b f11920l;

    /* renamed from: m, reason: collision with root package name */
    public final C4855a f11921m;

    public e(b bVar, C4855a c4855a) {
        this.f11920l = bVar;
        this.f11921m = c4855a;
        clear();
    }

    @Override // androidx.constraintlayout.core.b.a
    public boolean a(SolverVariable solverVariable) {
        return o(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public SolverVariable b(int i10) {
        int i11 = this.f11918j;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.f11919k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.f11921m.f36871d[this.f11914f[i12]];
            }
            i12 = this.f11917i[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void c(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = f11908n;
        if (f10 <= (-f11) || f10 >= f11) {
            int iO = o(solverVariable);
            if (iO == -1) {
                g(solverVariable, f10);
                return;
            }
            float[] fArr = this.f11915g;
            float f12 = fArr[iO] + f10;
            fArr[iO] = f12;
            float f13 = f11908n;
            if (f12 <= (-f13) || f12 >= f13) {
                return;
            }
            fArr[iO] = 0.0f;
            e(solverVariable, z10);
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public void clear() {
        int i10 = this.f11918j;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable solverVariableB = b(i11);
            if (solverVariableB != null) {
                solverVariableB.e(this.f11920l);
            }
        }
        for (int i12 = 0; i12 < this.f11910b; i12++) {
            this.f11914f[i12] = -1;
            this.f11913e[i12] = -1;
        }
        for (int i13 = 0; i13 < this.f11911c; i13++) {
            this.f11912d[i13] = -1;
        }
        this.f11918j = 0;
        this.f11919k = -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void d() {
        int i10 = this.f11918j;
        int i11 = this.f11919k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f11915g;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.f11917i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public float e(SolverVariable solverVariable, boolean z10) {
        int iO = o(solverVariable);
        if (iO == -1) {
            return 0.0f;
        }
        q(solverVariable);
        float f10 = this.f11915g[iO];
        if (this.f11919k == iO) {
            this.f11919k = this.f11917i[iO];
        }
        this.f11914f[iO] = -1;
        int[] iArr = this.f11916h;
        int i10 = iArr[iO];
        if (i10 != -1) {
            int[] iArr2 = this.f11917i;
            iArr2[i10] = iArr2[iO];
        }
        int i11 = this.f11917i[iO];
        if (i11 != -1) {
            iArr[i11] = iArr[iO];
        }
        this.f11918j--;
        solverVariable.f11850m--;
        if (z10) {
            solverVariable.e(this.f11920l);
        }
        return f10;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float f(b bVar, boolean z10) {
        float fI = i(bVar.f11867a);
        e(bVar.f11867a, z10);
        e eVar = (e) bVar.f11871e;
        int currentSize = eVar.getCurrentSize();
        int i10 = 0;
        int i11 = 0;
        while (i10 < currentSize) {
            int i12 = eVar.f11914f[i11];
            if (i12 != -1) {
                c(this.f11921m.f36871d[i12], eVar.f11915g[i11] * fI, z10);
                i10++;
            }
            i11++;
        }
        return fI;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void g(SolverVariable solverVariable, float f10) {
        float f11 = f11908n;
        if (f10 > (-f11) && f10 < f11) {
            e(solverVariable, true);
            return;
        }
        if (this.f11918j == 0) {
            l(0, solverVariable, f10);
            k(solverVariable, 0);
            this.f11919k = 0;
            return;
        }
        int iO = o(solverVariable);
        if (iO != -1) {
            this.f11915g[iO] = f10;
            return;
        }
        if (this.f11918j + 1 >= this.f11910b) {
            n();
        }
        int i10 = this.f11918j;
        int i11 = this.f11919k;
        int i12 = -1;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = this.f11914f[i11];
            int i15 = solverVariable.f11840c;
            if (i14 == i15) {
                this.f11915g[i11] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i11;
            }
            i11 = this.f11917i[i11];
            if (i11 == -1) {
                break;
            }
        }
        p(i12, solverVariable, f10);
    }

    @Override // androidx.constraintlayout.core.b.a
    public int getCurrentSize() {
        return this.f11918j;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float h(int i10) {
        int i11 = this.f11918j;
        int i12 = this.f11919k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.f11915g[i12];
            }
            i12 = this.f11917i[i12];
            if (i12 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float i(SolverVariable solverVariable) {
        int iO = o(solverVariable);
        if (iO != -1) {
            return this.f11915g[iO];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void j(float f10) {
        int i10 = this.f11918j;
        int i11 = this.f11919k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f11915g;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.f11917i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    public final void k(SolverVariable solverVariable, int i10) {
        int[] iArr;
        int i11 = solverVariable.f11840c % this.f11911c;
        int[] iArr2 = this.f11912d;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.f11913e;
                int i13 = iArr[i12];
                if (i13 == -1) {
                    break;
                } else {
                    i12 = i13;
                }
            }
            iArr[i12] = i10;
        }
        this.f11913e[i10] = -1;
    }

    public final void l(int i10, SolverVariable solverVariable, float f10) {
        this.f11914f[i10] = solverVariable.f11840c;
        this.f11915g[i10] = f10;
        this.f11916h[i10] = -1;
        this.f11917i[i10] = -1;
        solverVariable.a(this.f11920l);
        solverVariable.f11850m++;
        this.f11918j++;
    }

    public final int m() {
        for (int i10 = 0; i10 < this.f11910b; i10++) {
            if (this.f11914f[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    public final void n() {
        int i10 = this.f11910b * 2;
        this.f11914f = Arrays.copyOf(this.f11914f, i10);
        this.f11915g = Arrays.copyOf(this.f11915g, i10);
        this.f11916h = Arrays.copyOf(this.f11916h, i10);
        this.f11917i = Arrays.copyOf(this.f11917i, i10);
        this.f11913e = Arrays.copyOf(this.f11913e, i10);
        for (int i11 = this.f11910b; i11 < i10; i11++) {
            this.f11914f[i11] = -1;
            this.f11913e[i11] = -1;
        }
        this.f11910b = i10;
    }

    public int o(SolverVariable solverVariable) {
        if (this.f11918j != 0 && solverVariable != null) {
            int i10 = solverVariable.f11840c;
            int i11 = this.f11912d[i10 % this.f11911c];
            if (i11 == -1) {
                return -1;
            }
            if (this.f11914f[i11] == i10) {
                return i11;
            }
            do {
                i11 = this.f11913e[i11];
                if (i11 == -1) {
                    break;
                }
            } while (this.f11914f[i11] != i10);
            if (i11 != -1 && this.f11914f[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final void p(int i10, SolverVariable solverVariable, float f10) {
        int iM = m();
        l(iM, solverVariable, f10);
        if (i10 != -1) {
            this.f11916h[iM] = i10;
            int[] iArr = this.f11917i;
            iArr[iM] = iArr[i10];
            iArr[i10] = iM;
        } else {
            this.f11916h[iM] = -1;
            if (this.f11918j > 0) {
                this.f11917i[iM] = this.f11919k;
                this.f11919k = iM;
            } else {
                this.f11917i[iM] = -1;
            }
        }
        int i11 = this.f11917i[iM];
        if (i11 != -1) {
            this.f11916h[i11] = iM;
        }
        k(solverVariable, iM);
    }

    public final void q(SolverVariable solverVariable) {
        int[] iArr;
        int i10;
        int i11 = solverVariable.f11840c;
        int i12 = i11 % this.f11911c;
        int[] iArr2 = this.f11912d;
        int i13 = iArr2[i12];
        if (i13 == -1) {
            return;
        }
        if (this.f11914f[i13] == i11) {
            int[] iArr3 = this.f11913e;
            iArr2[i12] = iArr3[i13];
            iArr3[i13] = -1;
            return;
        }
        while (true) {
            iArr = this.f11913e;
            i10 = iArr[i13];
            if (i10 == -1 || this.f11914f[i10] == i11) {
                break;
            } else {
                i13 = i10;
            }
        }
        if (i10 == -1 || this.f11914f[i10] != i11) {
            return;
        }
        iArr[i13] = iArr[i10];
        iArr[i10] = -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i10 = this.f11918j;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable solverVariableB = b(i11);
            if (solverVariableB != null) {
                String str2 = str + solverVariableB + " = " + h(i11) + " ";
                int iO = o(solverVariableB);
                String str3 = str2 + "[p: ";
                String str4 = (this.f11916h[iO] != -1 ? str3 + this.f11921m.f36871d[this.f11914f[this.f11916h[iO]]] : str3 + "none") + ", n: ";
                str = (this.f11917i[iO] != -1 ? str4 + this.f11921m.f36871d[this.f11914f[this.f11917i[iO]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
