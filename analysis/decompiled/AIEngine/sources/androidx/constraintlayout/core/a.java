package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements b.a {

    /* renamed from: b, reason: collision with root package name */
    public final b f1049b;

    /* renamed from: c, reason: collision with root package name */
    public final e0.a f1050c;

    /* renamed from: a, reason: collision with root package name */
    public int f1048a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f1051d = 8;

    /* renamed from: e, reason: collision with root package name */
    public int[] f1052e = new int[8];

    /* renamed from: f, reason: collision with root package name */
    public int[] f1053f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    public float[] f1054g = new float[8];
    public int h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f1055i = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1056j = false;

    public a(b bVar, e0.a aVar) {
        this.f1049b = bVar;
        this.f1050c = aVar;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final boolean a(SolverVariable solverVariable) {
        int i10 = this.h;
        if (i10 != -1) {
            for (int i11 = 0; i10 != -1 && i11 < this.f1048a; i11++) {
                if (this.f1052e[i10] == solverVariable.f1033b) {
                    return true;
                }
                i10 = this.f1053f[i10];
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final SolverVariable b(int i10) {
        int i11 = this.h;
        for (int i12 = 0; i11 != -1 && i12 < this.f1048a; i12++) {
            if (i12 == i10) {
                return ((SolverVariable[]) this.f1050c.f8517d)[this.f1052e[i11]];
            }
            i11 = this.f1053f[i11];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void c(SolverVariable solverVariable, float f8, boolean z) {
        if (f8 <= -0.001f || f8 >= 0.001f) {
            int i10 = this.h;
            b bVar = this.f1049b;
            if (i10 == -1) {
                this.h = 0;
                this.f1054g[0] = f8;
                this.f1052e[0] = solverVariable.f1033b;
                this.f1053f[0] = -1;
                solverVariable.f1042o++;
                solverVariable.a(bVar);
                this.f1048a++;
                if (this.f1056j) {
                    return;
                }
                int i11 = this.f1055i + 1;
                this.f1055i = i11;
                int[] iArr = this.f1052e;
                if (i11 >= iArr.length) {
                    this.f1056j = true;
                    this.f1055i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i12 = -1;
            for (int i13 = 0; i10 != -1 && i13 < this.f1048a; i13++) {
                int i14 = this.f1052e[i10];
                int i15 = solverVariable.f1033b;
                if (i14 == i15) {
                    float[] fArr = this.f1054g;
                    float f9 = fArr[i10] + f8;
                    if (f9 > -0.001f && f9 < 0.001f) {
                        f9 = 0.0f;
                    }
                    fArr[i10] = f9;
                    if (f9 == 0.0f) {
                        if (i10 == this.h) {
                            this.h = this.f1053f[i10];
                        } else {
                            int[] iArr2 = this.f1053f;
                            iArr2[i12] = iArr2[i10];
                        }
                        if (z) {
                            solverVariable.b(bVar);
                        }
                        if (this.f1056j) {
                            this.f1055i = i10;
                        }
                        solverVariable.f1042o--;
                        this.f1048a--;
                        return;
                    }
                    return;
                }
                if (i14 < i15) {
                    i12 = i10;
                }
                i10 = this.f1053f[i10];
            }
            int length = this.f1055i;
            int i16 = length + 1;
            if (this.f1056j) {
                int[] iArr3 = this.f1052e;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i16;
            }
            int[] iArr4 = this.f1052e;
            if (length >= iArr4.length && this.f1048a < iArr4.length) {
                int i17 = 0;
                while (true) {
                    int[] iArr5 = this.f1052e;
                    if (i17 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i17] == -1) {
                        length = i17;
                        break;
                    }
                    i17++;
                }
            }
            int[] iArr6 = this.f1052e;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i18 = this.f1051d * 2;
                this.f1051d = i18;
                this.f1056j = false;
                this.f1055i = length - 1;
                this.f1054g = Arrays.copyOf(this.f1054g, i18);
                this.f1052e = Arrays.copyOf(this.f1052e, this.f1051d);
                this.f1053f = Arrays.copyOf(this.f1053f, this.f1051d);
            }
            this.f1052e[length] = solverVariable.f1033b;
            this.f1054g[length] = f8;
            if (i12 != -1) {
                int[] iArr7 = this.f1053f;
                iArr7[length] = iArr7[i12];
                iArr7[i12] = length;
            } else {
                this.f1053f[length] = this.h;
                this.h = length;
            }
            solverVariable.f1042o++;
            solverVariable.a(bVar);
            this.f1048a++;
            if (!this.f1056j) {
                this.f1055i++;
            }
            int i19 = this.f1055i;
            int[] iArr8 = this.f1052e;
            if (i19 >= iArr8.length) {
                this.f1056j = true;
                this.f1055i = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void clear() {
        int i10 = this.h;
        for (int i11 = 0; i10 != -1 && i11 < this.f1048a; i11++) {
            SolverVariable solverVariable = ((SolverVariable[]) this.f1050c.f8517d)[this.f1052e[i10]];
            if (solverVariable != null) {
                solverVariable.b(this.f1049b);
            }
            i10 = this.f1053f[i10];
        }
        this.h = -1;
        this.f1055i = -1;
        this.f1056j = false;
        this.f1048a = 0;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void d() {
        int i10 = this.h;
        for (int i11 = 0; i10 != -1 && i11 < this.f1048a; i11++) {
            float[] fArr = this.f1054g;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f1053f[i10];
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float e(SolverVariable solverVariable, boolean z) {
        int i10 = this.h;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f1048a) {
            if (this.f1052e[i10] == solverVariable.f1033b) {
                if (i10 == this.h) {
                    this.h = this.f1053f[i10];
                } else {
                    int[] iArr = this.f1053f;
                    iArr[i12] = iArr[i10];
                }
                if (z) {
                    solverVariable.b(this.f1049b);
                }
                solverVariable.f1042o--;
                this.f1048a--;
                this.f1052e[i10] = -1;
                if (this.f1056j) {
                    this.f1055i = i10;
                }
                return this.f1054g[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f1053f[i10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final int f() {
        return this.f1048a;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float g(b bVar, boolean z) {
        float fJ = j(bVar.f1057a);
        e(bVar.f1057a, z);
        b.a aVar = bVar.f1060d;
        int iF = aVar.f();
        for (int i10 = 0; i10 < iF; i10++) {
            SolverVariable solverVariableB = aVar.b(i10);
            c(solverVariableB, aVar.j(solverVariableB) * fJ, z);
        }
        return fJ;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void h(SolverVariable solverVariable, float f8) {
        if (f8 == 0.0f) {
            e(solverVariable, true);
            return;
        }
        int i10 = this.h;
        b bVar = this.f1049b;
        if (i10 == -1) {
            this.h = 0;
            this.f1054g[0] = f8;
            this.f1052e[0] = solverVariable.f1033b;
            this.f1053f[0] = -1;
            solverVariable.f1042o++;
            solverVariable.a(bVar);
            this.f1048a++;
            if (this.f1056j) {
                return;
            }
            int i11 = this.f1055i + 1;
            this.f1055i = i11;
            int[] iArr = this.f1052e;
            if (i11 >= iArr.length) {
                this.f1056j = true;
                this.f1055i = iArr.length - 1;
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f1048a; i13++) {
            int i14 = this.f1052e[i10];
            int i15 = solverVariable.f1033b;
            if (i14 == i15) {
                this.f1054g[i10] = f8;
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f1053f[i10];
        }
        int length = this.f1055i;
        int i16 = length + 1;
        if (this.f1056j) {
            int[] iArr2 = this.f1052e;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i16;
        }
        int[] iArr3 = this.f1052e;
        if (length >= iArr3.length && this.f1048a < iArr3.length) {
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.f1052e;
                if (i17 >= iArr4.length) {
                    break;
                }
                if (iArr4[i17] == -1) {
                    length = i17;
                    break;
                }
                i17++;
            }
        }
        int[] iArr5 = this.f1052e;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i18 = this.f1051d * 2;
            this.f1051d = i18;
            this.f1056j = false;
            this.f1055i = length - 1;
            this.f1054g = Arrays.copyOf(this.f1054g, i18);
            this.f1052e = Arrays.copyOf(this.f1052e, this.f1051d);
            this.f1053f = Arrays.copyOf(this.f1053f, this.f1051d);
        }
        this.f1052e[length] = solverVariable.f1033b;
        this.f1054g[length] = f8;
        if (i12 != -1) {
            int[] iArr6 = this.f1053f;
            iArr6[length] = iArr6[i12];
            iArr6[i12] = length;
        } else {
            this.f1053f[length] = this.h;
            this.h = length;
        }
        solverVariable.f1042o++;
        solverVariable.a(bVar);
        int i19 = this.f1048a + 1;
        this.f1048a = i19;
        if (!this.f1056j) {
            this.f1055i++;
        }
        int[] iArr7 = this.f1052e;
        if (i19 >= iArr7.length) {
            this.f1056j = true;
        }
        if (this.f1055i >= iArr7.length) {
            this.f1056j = true;
            this.f1055i = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float i(int i10) {
        int i11 = this.h;
        for (int i12 = 0; i11 != -1 && i12 < this.f1048a; i12++) {
            if (i12 == i10) {
                return this.f1054g[i11];
            }
            i11 = this.f1053f[i11];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float j(SolverVariable solverVariable) {
        int i10 = this.h;
        for (int i11 = 0; i10 != -1 && i11 < this.f1048a; i11++) {
            if (this.f1052e[i10] == solverVariable.f1033b) {
                return this.f1054g[i10];
            }
            i10 = this.f1053f[i10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void k(float f8) {
        int i10 = this.h;
        for (int i11 = 0; i10 != -1 && i11 < this.f1048a; i11++) {
            float[] fArr = this.f1054g;
            fArr[i10] = fArr[i10] / f8;
            i10 = this.f1053f[i10];
        }
    }

    public final String toString() {
        int i10 = this.h;
        String string = "";
        for (int i11 = 0; i10 != -1 && i11 < this.f1048a; i11++) {
            StringBuilder sbB = v1.d.b(a0.a.j(string, " -> "));
            sbB.append(this.f1054g[i10]);
            sbB.append(" : ");
            StringBuilder sbB2 = v1.d.b(sbB.toString());
            sbB2.append(((SolverVariable[]) this.f1050c.f8517d)[this.f1052e[i10]]);
            string = sbB2.toString();
            i10 = this.f1053f[i10];
        }
        return string;
    }
}
