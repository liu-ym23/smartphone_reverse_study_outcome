package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;
import java.util.Comparator;
import l0.C4855a;

/* loaded from: classes.dex */
public class d extends androidx.constraintlayout.core.b {

    /* renamed from: g, reason: collision with root package name */
    public int f11898g;

    /* renamed from: h, reason: collision with root package name */
    public SolverVariable[] f11899h;

    /* renamed from: i, reason: collision with root package name */
    public SolverVariable[] f11900i;

    /* renamed from: j, reason: collision with root package name */
    public int f11901j;

    /* renamed from: k, reason: collision with root package name */
    public b f11902k;

    /* renamed from: l, reason: collision with root package name */
    public C4855a f11903l;

    public class a implements Comparator<SolverVariable> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.f11840c - solverVariable2.f11840c;
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public SolverVariable f11905a;

        /* renamed from: b, reason: collision with root package name */
        public d f11906b;

        public b(d dVar) {
            this.f11906b = dVar;
        }

        public boolean a(SolverVariable solverVariable, float f10) {
            boolean z10 = true;
            if (!this.f11905a.f11838a) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float f11 = solverVariable.f11846i[i10];
                    if (f11 != 0.0f) {
                        float f12 = f11 * f10;
                        if (Math.abs(f12) < 1.0E-4f) {
                            f12 = 0.0f;
                        }
                        this.f11905a.f11846i[i10] = f12;
                    } else {
                        this.f11905a.f11846i[i10] = 0.0f;
                    }
                }
                return true;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float[] fArr = this.f11905a.f11846i;
                float f13 = fArr[i11] + (solverVariable.f11846i[i11] * f10);
                fArr[i11] = f13;
                if (Math.abs(f13) < 1.0E-4f) {
                    this.f11905a.f11846i[i11] = 0.0f;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                d.this.G(this.f11905a);
            }
            return false;
        }

        public void b(SolverVariable solverVariable) {
            this.f11905a = solverVariable;
        }

        public final boolean c() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.f11905a.f11846i[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(SolverVariable solverVariable) {
            int i10 = 8;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                float f10 = solverVariable.f11846i[i10];
                float f11 = this.f11905a.f11846i[i10];
                if (f11 == f10) {
                    i10--;
                } else if (f11 < f10) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f11905a.f11846i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f11905a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.f11905a.f11846i[i10] + " ";
                }
            }
            return str + "] " + this.f11905a;
        }
    }

    public d(C4855a c4855a) {
        super(c4855a);
        this.f11898g = 128;
        this.f11899h = new SolverVariable[128];
        this.f11900i = new SolverVariable[128];
        this.f11901j = 0;
        this.f11902k = new b(this);
        this.f11903l = c4855a;
    }

    @Override // androidx.constraintlayout.core.b
    public void B(c cVar, androidx.constraintlayout.core.b bVar, boolean z10) {
        SolverVariable solverVariable = bVar.f11867a;
        if (solverVariable == null) {
            return;
        }
        b.a aVar = bVar.f11871e;
        int currentSize = aVar.getCurrentSize();
        for (int i10 = 0; i10 < currentSize; i10++) {
            SolverVariable solverVariableB = aVar.b(i10);
            float fH = aVar.h(i10);
            this.f11902k.b(solverVariableB);
            if (this.f11902k.a(solverVariable, fH)) {
                F(solverVariableB);
            }
            this.f11868b += bVar.f11868b * fH;
        }
        G(solverVariable);
    }

    public final void F(SolverVariable solverVariable) {
        int i10;
        int i11 = this.f11901j + 1;
        SolverVariable[] solverVariableArr = this.f11899h;
        if (i11 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f11899h = solverVariableArr2;
            this.f11900i = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f11899h;
        int i12 = this.f11901j;
        solverVariableArr3[i12] = solverVariable;
        int i13 = i12 + 1;
        this.f11901j = i13;
        if (i13 > 1 && solverVariableArr3[i12].f11840c > solverVariable.f11840c) {
            int i14 = 0;
            while (true) {
                i10 = this.f11901j;
                if (i14 >= i10) {
                    break;
                }
                this.f11900i[i14] = this.f11899h[i14];
                i14++;
            }
            Arrays.sort(this.f11900i, 0, i10, new a());
            for (int i15 = 0; i15 < this.f11901j; i15++) {
                this.f11899h[i15] = this.f11900i[i15];
            }
        }
        solverVariable.f11838a = true;
        solverVariable.a(this);
    }

    public final void G(SolverVariable solverVariable) {
        int i10 = 0;
        while (i10 < this.f11901j) {
            if (this.f11899h[i10] == solverVariable) {
                while (true) {
                    int i11 = this.f11901j;
                    if (i10 >= i11 - 1) {
                        this.f11901j = i11 - 1;
                        solverVariable.f11838a = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.f11899h;
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.constraintlayout.core.SolverVariable b(androidx.constraintlayout.core.c r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = r5
        L3:
            int r2 = r4.f11901j
            if (r0 >= r2) goto L32
            androidx.constraintlayout.core.SolverVariable[] r2 = r4.f11899h
            r2 = r2[r0]
            int r3 = r2.f11840c
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2f
        L12:
            androidx.constraintlayout.core.d$b r3 = r4.f11902k
            r3.b(r2)
            if (r1 != r5) goto L22
            androidx.constraintlayout.core.d$b r2 = r4.f11902k
            boolean r2 = r2.c()
            if (r2 == 0) goto L2f
            goto L2e
        L22:
            androidx.constraintlayout.core.d$b r2 = r4.f11902k
            androidx.constraintlayout.core.SolverVariable[] r3 = r4.f11899h
            r3 = r3[r1]
            boolean r2 = r2.d(r3)
            if (r2 == 0) goto L2f
        L2e:
            r1 = r0
        L2f:
            int r0 = r0 + 1
            goto L3
        L32:
            if (r1 != r5) goto L36
            r4 = 0
            return r4
        L36:
            androidx.constraintlayout.core.SolverVariable[] r4 = r4.f11899h
            r4 = r4[r1]
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.d.b(androidx.constraintlayout.core.c, boolean[]):androidx.constraintlayout.core.SolverVariable");
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.c.a
    public void c(SolverVariable solverVariable) {
        this.f11902k.b(solverVariable);
        this.f11902k.e();
        solverVariable.f11846i[solverVariable.f11842e] = 1.0f;
        F(solverVariable);
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.c.a
    public void clear() {
        this.f11901j = 0;
        this.f11868b = 0.0f;
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.c.a
    public boolean isEmpty() {
        return this.f11901j == 0;
    }

    @Override // androidx.constraintlayout.core.b
    public String toString() {
        String str = " goal -> (" + this.f11868b + ") : ";
        for (int i10 = 0; i10 < this.f11901j; i10++) {
            this.f11902k.b(this.f11899h[i10]);
            str = str + this.f11902k + " ";
        }
        return str;
    }
}
