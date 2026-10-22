package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;
import l0.C4855a;

/* loaded from: classes.dex */
public class a implements b.a {

    /* renamed from: l, reason: collision with root package name */
    public static float f11855l = 0.001f;

    /* renamed from: b, reason: collision with root package name */
    public final b f11857b;

    /* renamed from: c, reason: collision with root package name */
    public final C4855a f11858c;

    /* renamed from: a, reason: collision with root package name */
    public int f11856a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f11859d = 8;

    /* renamed from: e, reason: collision with root package name */
    public SolverVariable f11860e = null;

    /* renamed from: f, reason: collision with root package name */
    public int[] f11861f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    public int[] f11862g = new int[8];

    /* renamed from: h, reason: collision with root package name */
    public float[] f11863h = new float[8];

    /* renamed from: i, reason: collision with root package name */
    public int f11864i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f11865j = -1;

    /* renamed from: k, reason: collision with root package name */
    public boolean f11866k = false;

    public a(b bVar, C4855a c4855a) {
        this.f11857b = bVar;
        this.f11858c = c4855a;
    }

    @Override // androidx.constraintlayout.core.b.a
    public boolean a(SolverVariable solverVariable) {
        int i10 = this.f11864i;
        if (i10 == -1) {
            return false;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.f11856a; i11++) {
            if (this.f11861f[i10] == solverVariable.f11840c) {
                return true;
            }
            i10 = this.f11862g[i10];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.b.a
    public SolverVariable b(int i10) {
        int i11 = this.f11864i;
        for (int i12 = 0; i11 != -1 && i12 < this.f11856a; i12++) {
            if (i12 == i10) {
                return this.f11858c.f36871d[this.f11861f[i11]];
            }
            i11 = this.f11862g[i11];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void c(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = f11855l;
        if (f10 <= (-f11) || f10 >= f11) {
            int i10 = this.f11864i;
            if (i10 == -1) {
                this.f11864i = 0;
                this.f11863h[0] = f10;
                this.f11861f[0] = solverVariable.f11840c;
                this.f11862g[0] = -1;
                solverVariable.f11850m++;
                solverVariable.a(this.f11857b);
                this.f11856a++;
                if (this.f11866k) {
                    return;
                }
                int i11 = this.f11865j + 1;
                this.f11865j = i11;
                int[] iArr = this.f11861f;
                if (i11 >= iArr.length) {
                    this.f11866k = true;
                    this.f11865j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i12 = -1;
            for (int i13 = 0; i10 != -1 && i13 < this.f11856a; i13++) {
                int i14 = this.f11861f[i10];
                int i15 = solverVariable.f11840c;
                if (i14 == i15) {
                    float[] fArr = this.f11863h;
                    float f12 = fArr[i10] + f10;
                    float f13 = f11855l;
                    if (f12 > (-f13) && f12 < f13) {
                        f12 = 0.0f;
                    }
                    fArr[i10] = f12;
                    if (f12 == 0.0f) {
                        if (i10 == this.f11864i) {
                            this.f11864i = this.f11862g[i10];
                        } else {
                            int[] iArr2 = this.f11862g;
                            iArr2[i12] = iArr2[i10];
                        }
                        if (z10) {
                            solverVariable.e(this.f11857b);
                        }
                        if (this.f11866k) {
                            this.f11865j = i10;
                        }
                        solverVariable.f11850m--;
                        this.f11856a--;
                        return;
                    }
                    return;
                }
                if (i14 < i15) {
                    i12 = i10;
                }
                i10 = this.f11862g[i10];
            }
            int length = this.f11865j;
            int i16 = length + 1;
            if (this.f11866k) {
                int[] iArr3 = this.f11861f;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i16;
            }
            int[] iArr4 = this.f11861f;
            if (length >= iArr4.length && this.f11856a < iArr4.length) {
                int i17 = 0;
                while (true) {
                    int[] iArr5 = this.f11861f;
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
            int[] iArr6 = this.f11861f;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i18 = this.f11859d * 2;
                this.f11859d = i18;
                this.f11866k = false;
                this.f11865j = length - 1;
                this.f11863h = Arrays.copyOf(this.f11863h, i18);
                this.f11861f = Arrays.copyOf(this.f11861f, this.f11859d);
                this.f11862g = Arrays.copyOf(this.f11862g, this.f11859d);
            }
            this.f11861f[length] = solverVariable.f11840c;
            this.f11863h[length] = f10;
            if (i12 != -1) {
                int[] iArr7 = this.f11862g;
                iArr7[length] = iArr7[i12];
                iArr7[i12] = length;
            } else {
                this.f11862g[length] = this.f11864i;
                this.f11864i = length;
            }
            solverVariable.f11850m++;
            solverVariable.a(this.f11857b);
            this.f11856a++;
            if (!this.f11866k) {
                this.f11865j++;
            }
            int i19 = this.f11865j;
            int[] iArr8 = this.f11861f;
            if (i19 >= iArr8.length) {
                this.f11866k = true;
                this.f11865j = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void clear() {
        int i10 = this.f11864i;
        for (int i11 = 0; i10 != -1 && i11 < this.f11856a; i11++) {
            SolverVariable solverVariable = this.f11858c.f36871d[this.f11861f[i10]];
            if (solverVariable != null) {
                solverVariable.e(this.f11857b);
            }
            i10 = this.f11862g[i10];
        }
        this.f11864i = -1;
        this.f11865j = -1;
        this.f11866k = false;
        this.f11856a = 0;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void d() {
        int i10 = this.f11864i;
        for (int i11 = 0; i10 != -1 && i11 < this.f11856a; i11++) {
            float[] fArr = this.f11863h;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f11862g[i10];
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float e(SolverVariable solverVariable, boolean z10) {
        if (this.f11860e == solverVariable) {
            this.f11860e = null;
        }
        int i10 = this.f11864i;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f11856a) {
            if (this.f11861f[i10] == solverVariable.f11840c) {
                if (i10 == this.f11864i) {
                    this.f11864i = this.f11862g[i10];
                } else {
                    int[] iArr = this.f11862g;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    solverVariable.e(this.f11857b);
                }
                solverVariable.f11850m--;
                this.f11856a--;
                this.f11861f[i10] = -1;
                if (this.f11866k) {
                    this.f11865j = i10;
                }
                return this.f11863h[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f11862g[i10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float f(b bVar, boolean z10) {
        float fI = i(bVar.f11867a);
        e(bVar.f11867a, z10);
        b.a aVar = bVar.f11871e;
        int currentSize = aVar.getCurrentSize();
        for (int i10 = 0; i10 < currentSize; i10++) {
            SolverVariable solverVariableB = aVar.b(i10);
            c(solverVariableB, aVar.i(solverVariableB) * fI, z10);
        }
        return fI;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void g(SolverVariable solverVariable, float f10) {
        if (f10 == 0.0f) {
            e(solverVariable, true);
            return;
        }
        int i10 = this.f11864i;
        if (i10 == -1) {
            this.f11864i = 0;
            this.f11863h[0] = f10;
            this.f11861f[0] = solverVariable.f11840c;
            this.f11862g[0] = -1;
            solverVariable.f11850m++;
            solverVariable.a(this.f11857b);
            this.f11856a++;
            if (this.f11866k) {
                return;
            }
            int i11 = this.f11865j + 1;
            this.f11865j = i11;
            int[] iArr = this.f11861f;
            if (i11 >= iArr.length) {
                this.f11866k = true;
                this.f11865j = iArr.length - 1;
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f11856a; i13++) {
            int i14 = this.f11861f[i10];
            int i15 = solverVariable.f11840c;
            if (i14 == i15) {
                this.f11863h[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f11862g[i10];
        }
        int length = this.f11865j;
        int i16 = length + 1;
        if (this.f11866k) {
            int[] iArr2 = this.f11861f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i16;
        }
        int[] iArr3 = this.f11861f;
        if (length >= iArr3.length && this.f11856a < iArr3.length) {
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.f11861f;
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
        int[] iArr5 = this.f11861f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i18 = this.f11859d * 2;
            this.f11859d = i18;
            this.f11866k = false;
            this.f11865j = length - 1;
            this.f11863h = Arrays.copyOf(this.f11863h, i18);
            this.f11861f = Arrays.copyOf(this.f11861f, this.f11859d);
            this.f11862g = Arrays.copyOf(this.f11862g, this.f11859d);
        }
        this.f11861f[length] = solverVariable.f11840c;
        this.f11863h[length] = f10;
        if (i12 != -1) {
            int[] iArr6 = this.f11862g;
            iArr6[length] = iArr6[i12];
            iArr6[i12] = length;
        } else {
            this.f11862g[length] = this.f11864i;
            this.f11864i = length;
        }
        solverVariable.f11850m++;
        solverVariable.a(this.f11857b);
        int i19 = this.f11856a + 1;
        this.f11856a = i19;
        if (!this.f11866k) {
            this.f11865j++;
        }
        int[] iArr7 = this.f11861f;
        if (i19 >= iArr7.length) {
            this.f11866k = true;
        }
        if (this.f11865j >= iArr7.length) {
            this.f11866k = true;
            this.f11865j = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public int getCurrentSize() {
        return this.f11856a;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float h(int i10) {
        int i11 = this.f11864i;
        for (int i12 = 0; i11 != -1 && i12 < this.f11856a; i12++) {
            if (i12 == i10) {
                return this.f11863h[i11];
            }
            i11 = this.f11862g[i11];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float i(SolverVariable solverVariable) {
        int i10 = this.f11864i;
        for (int i11 = 0; i10 != -1 && i11 < this.f11856a; i11++) {
            if (this.f11861f[i10] == solverVariable.f11840c) {
                return this.f11863h[i10];
            }
            i10 = this.f11862g[i10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void j(float f10) {
        int i10 = this.f11864i;
        for (int i11 = 0; i10 != -1 && i11 < this.f11856a; i11++) {
            float[] fArr = this.f11863h;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f11862g[i10];
        }
    }

    public String toString() {
        int i10 = this.f11864i;
        String str = "";
        for (int i11 = 0; i10 != -1 && i11 < this.f11856a; i11++) {
            str = ((str + " -> ") + this.f11863h[i10] + " : ") + this.f11858c.f36871d[this.f11861f[i10]];
            i10 = this.f11862g[i10];
        }
        return str;
    }
}
