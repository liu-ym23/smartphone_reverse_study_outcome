package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends androidx.constraintlayout.core.b {

    /* renamed from: f, reason: collision with root package name */
    public SolverVariable[] f1078f;

    /* renamed from: g, reason: collision with root package name */
    public SolverVariable[] f1079g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public b f1080i;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Comparator<SolverVariable> {
        @Override // java.util.Comparator
        public final int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.f1033b - solverVariable2.f1033b;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public SolverVariable f1081a;

        public b() {
        }

        public final String toString() {
            String string = "[ ";
            if (this.f1081a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    StringBuilder sbB = v1.d.b(string);
                    sbB.append(this.f1081a.f1038k[i10]);
                    sbB.append(" ");
                    string = sbB.toString();
                }
            }
            StringBuilder sbP = a0.a.p(string, "] ");
            sbP.append(this.f1081a);
            return sbP.toString();
        }
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.c.a
    public final SolverVariable a(boolean[] zArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < this.h; i11++) {
            SolverVariable[] solverVariableArr = this.f1078f;
            SolverVariable solverVariable = solverVariableArr[i11];
            if (!zArr[solverVariable.f1033b]) {
                b bVar = this.f1080i;
                bVar.f1081a = solverVariable;
                int i12 = 8;
                if (i10 == -1) {
                    while (i12 >= 0) {
                        float f8 = bVar.f1081a.f1038k[i12];
                        if (f8 <= 0.0f) {
                            if (f8 < 0.0f) {
                                i10 = i11;
                                break;
                            }
                            i12--;
                        }
                    }
                } else {
                    SolverVariable solverVariable2 = solverVariableArr[i10];
                    while (true) {
                        if (i12 >= 0) {
                            float f9 = solverVariable2.f1038k[i12];
                            float f10 = bVar.f1081a.f1038k[i12];
                            if (f10 == f9) {
                                i12--;
                            } else if (f10 < f9) {
                            }
                        }
                    }
                }
            }
        }
        if (i10 == -1) {
            return null;
        }
        return this.f1078f[i10];
    }

    @Override // androidx.constraintlayout.core.b
    public final boolean e() {
        return this.h == 0;
    }

    @Override // androidx.constraintlayout.core.b
    public final void i(c cVar, androidx.constraintlayout.core.b bVar, boolean z) {
        SolverVariable solverVariable = bVar.f1057a;
        if (solverVariable == null) {
            return;
        }
        float[] fArr = solverVariable.f1038k;
        b.a aVar = bVar.f1060d;
        int iF = aVar.f();
        for (int i10 = 0; i10 < iF; i10++) {
            SolverVariable solverVariableB = aVar.b(i10);
            float fI = aVar.i(i10);
            b bVar2 = this.f1080i;
            bVar2.f1081a = solverVariableB;
            if (solverVariableB.f1032a) {
                boolean z3 = true;
                for (int i11 = 0; i11 < 9; i11++) {
                    float[] fArr2 = bVar2.f1081a.f1038k;
                    float f8 = (fArr[i11] * fI) + fArr2[i11];
                    fArr2[i11] = f8;
                    if (Math.abs(f8) < 1.0E-4f) {
                        bVar2.f1081a.f1038k[i11] = 0.0f;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    d.this.k(bVar2.f1081a);
                }
            } else {
                for (int i12 = 0; i12 < 9; i12++) {
                    float f9 = fArr[i12];
                    if (f9 != 0.0f) {
                        float f10 = f9 * fI;
                        if (Math.abs(f10) < 1.0E-4f) {
                            f10 = 0.0f;
                        }
                        bVar2.f1081a.f1038k[i12] = f10;
                    } else {
                        bVar2.f1081a.f1038k[i12] = 0.0f;
                    }
                }
                j(solverVariableB);
            }
            this.f1058b = (bVar.f1058b * fI) + this.f1058b;
        }
        k(solverVariable);
    }

    public final void j(SolverVariable solverVariable) {
        int i10;
        int i11 = this.h + 1;
        SolverVariable[] solverVariableArr = this.f1078f;
        if (i11 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f1078f = solverVariableArr2;
            this.f1079g = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f1078f;
        int i12 = this.h;
        solverVariableArr3[i12] = solverVariable;
        int i13 = i12 + 1;
        this.h = i13;
        if (i13 > 1 && solverVariableArr3[i12].f1033b > solverVariable.f1033b) {
            int i14 = 0;
            while (true) {
                i10 = this.h;
                if (i14 >= i10) {
                    break;
                }
                this.f1079g[i14] = this.f1078f[i14];
                i14++;
            }
            Arrays.sort(this.f1079g, 0, i10, new a());
            for (int i15 = 0; i15 < this.h; i15++) {
                this.f1078f[i15] = this.f1079g[i15];
            }
        }
        solverVariable.f1032a = true;
        solverVariable.a(this);
    }

    public final void k(SolverVariable solverVariable) {
        int i10 = 0;
        while (i10 < this.h) {
            if (this.f1078f[i10] == solverVariable) {
                while (true) {
                    int i11 = this.h;
                    if (i10 >= i11 - 1) {
                        this.h = i11 - 1;
                        solverVariable.f1032a = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.f1078f;
                        int i12 = i10 + 1;
                        solverVariableArr[i10] = solverVariableArr[i12];
                        i10 = i12;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b
    public final String toString() {
        b bVar = this.f1080i;
        String str = " goal -> (" + this.f1058b + ") : ";
        for (int i10 = 0; i10 < this.h; i10++) {
            bVar.f1081a = this.f1078f[i10];
            str = str + bVar + " ";
        }
        return str;
    }
}
