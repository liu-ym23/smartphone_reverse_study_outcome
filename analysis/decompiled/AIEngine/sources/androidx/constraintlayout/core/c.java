package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d.b;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: q, reason: collision with root package name */
    public static boolean f1062q = false;

    /* renamed from: d, reason: collision with root package name */
    public final d f1066d;

    /* renamed from: m, reason: collision with root package name */
    public final e0.a f1074m;

    /* renamed from: p, reason: collision with root package name */
    public b f1077p;

    /* renamed from: a, reason: collision with root package name */
    public int f1063a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1064b = false;

    /* renamed from: c, reason: collision with root package name */
    public int f1065c = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f1067e = 32;

    /* renamed from: f, reason: collision with root package name */
    public int f1068f = 32;
    public boolean h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean[] f1070i = new boolean[32];

    /* renamed from: j, reason: collision with root package name */
    public int f1071j = 1;

    /* renamed from: k, reason: collision with root package name */
    public int f1072k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f1073l = 32;

    /* renamed from: n, reason: collision with root package name */
    public SolverVariable[] f1075n = new SolverVariable[1000];

    /* renamed from: o, reason: collision with root package name */
    public int f1076o = 0;

    /* renamed from: g, reason: collision with root package name */
    public b[] f1069g = new b[32];

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        SolverVariable a(boolean[] zArr);
    }

    public c() {
        s();
        e0.a aVar = new e0.a();
        aVar.f8515b = new e0.b(0);
        aVar.f8516c = new e0.b(0);
        aVar.f8517d = new SolverVariable[32];
        this.f1074m = aVar;
        d dVar = new d(aVar);
        dVar.f1078f = new SolverVariable[TraceIdKeys.MAX_LENGTH];
        dVar.f1079g = new SolverVariable[TraceIdKeys.MAX_LENGTH];
        dVar.h = 0;
        dVar.f1080i = dVar.new b();
        this.f1066d = dVar;
        this.f1077p = new b(aVar);
    }

    public static int n(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).f1090i;
        if (solverVariable != null) {
            return (int) (solverVariable.f1036e + 0.5f);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v0 */
    public final SolverVariable a(SolverVariable.Type type) {
        e0.b bVar = (e0.b) this.f1074m.f8516c;
        int i10 = bVar.f8518a;
        SolverVariable solverVariable = null;
        if (i10 > 0) {
            int i11 = i10 - 1;
            ?? r32 = (Object[]) bVar.f8519b;
            ?? r42 = r32[i11];
            r32[i11] = 0;
            bVar.f8518a = i11;
            solverVariable = r42;
        }
        SolverVariable solverVariable2 = solverVariable;
        if (solverVariable2 == null) {
            solverVariable2 = new SolverVariable(type);
            solverVariable2.f1039l = type;
        } else {
            solverVariable2.c();
            solverVariable2.f1039l = type;
        }
        int i12 = this.f1076o;
        int i13 = this.f1063a;
        if (i12 >= i13) {
            int i14 = i13 * 2;
            this.f1063a = i14;
            this.f1075n = (SolverVariable[]) Arrays.copyOf(this.f1075n, i14);
        }
        SolverVariable[] solverVariableArr = this.f1075n;
        int i15 = this.f1076o;
        this.f1076o = i15 + 1;
        solverVariableArr[i15] = solverVariable2;
        return solverVariable2;
    }

    public final void b(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f8, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11, int i12) {
        b bVarL = l();
        if (solverVariable2 == solverVariable3) {
            bVarL.f1060d.h(solverVariable, 1.0f);
            bVarL.f1060d.h(solverVariable4, 1.0f);
            bVarL.f1060d.h(solverVariable2, -2.0f);
        } else if (f8 == 0.5f) {
            bVarL.f1060d.h(solverVariable, 1.0f);
            bVarL.f1060d.h(solverVariable2, -1.0f);
            bVarL.f1060d.h(solverVariable3, -1.0f);
            bVarL.f1060d.h(solverVariable4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                bVarL.f1058b = (-i10) + i11;
            }
        } else if (f8 <= 0.0f) {
            bVarL.f1060d.h(solverVariable, -1.0f);
            bVarL.f1060d.h(solverVariable2, 1.0f);
            bVarL.f1058b = i10;
        } else if (f8 >= 1.0f) {
            bVarL.f1060d.h(solverVariable4, -1.0f);
            bVarL.f1060d.h(solverVariable3, 1.0f);
            bVarL.f1058b = -i11;
        } else {
            float f9 = 1.0f - f8;
            bVarL.f1060d.h(solverVariable, f9 * 1.0f);
            bVarL.f1060d.h(solverVariable2, f9 * (-1.0f));
            bVarL.f1060d.h(solverVariable3, (-1.0f) * f8);
            bVarL.f1060d.h(solverVariable4, 1.0f * f8);
            if (i10 > 0 || i11 > 0) {
                bVarL.f1058b = (i11 * f8) + ((-i10) * f9);
            }
        }
        if (i12 != 8) {
            bVarL.b(this, i12);
        }
        c(bVarL);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(androidx.constraintlayout.core.b r18) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.c.c(androidx.constraintlayout.core.b):void");
    }

    public final void d(SolverVariable solverVariable, int i10) {
        int i11 = solverVariable.f1034c;
        if (i11 == -1) {
            solverVariable.d(this, i10);
            for (int i12 = 0; i12 < this.f1065c + 1; i12++) {
                SolverVariable solverVariable2 = ((SolverVariable[]) this.f1074m.f8517d)[i12];
            }
            return;
        }
        if (i11 == -1) {
            b bVarL = l();
            bVarL.f1057a = solverVariable;
            float f8 = i10;
            solverVariable.f1036e = f8;
            bVarL.f1058b = f8;
            bVarL.f1061e = true;
            c(bVarL);
            return;
        }
        b bVar = this.f1069g[i11];
        if (bVar.f1061e) {
            bVar.f1058b = i10;
            return;
        }
        if (bVar.f1060d.f() == 0) {
            bVar.f1061e = true;
            bVar.f1058b = i10;
            return;
        }
        b bVarL2 = l();
        if (i10 < 0) {
            bVarL2.f1058b = i10 * (-1);
            bVarL2.f1060d.h(solverVariable, 1.0f);
        } else {
            bVarL2.f1058b = i10;
            bVarL2.f1060d.h(solverVariable, -1.0f);
        }
        c(bVarL2);
    }

    public final void e(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        if (i11 == 8 && solverVariable2.h && solverVariable.f1034c == -1) {
            solverVariable.d(this, solverVariable2.f1036e + i10);
            return;
        }
        b bVarL = l();
        boolean z = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z = true;
            }
            bVarL.f1058b = i10;
        }
        if (z) {
            bVarL.f1060d.h(solverVariable, 1.0f);
            bVarL.f1060d.h(solverVariable2, -1.0f);
        } else {
            bVarL.f1060d.h(solverVariable, -1.0f);
            bVarL.f1060d.h(solverVariable2, 1.0f);
        }
        if (i11 != 8) {
            bVarL.b(this, i11);
        }
        c(bVarL);
    }

    public final void f(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        b bVarL = l();
        SolverVariable solverVariableM = m();
        solverVariableM.f1035d = 0;
        bVarL.c(solverVariable, solverVariable2, solverVariableM, i10);
        if (i11 != 8) {
            bVarL.f1060d.h(j(i11), (int) (bVarL.f1060d.j(solverVariableM) * (-1.0f)));
        }
        c(bVarL);
    }

    public final void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        b bVarL = l();
        SolverVariable solverVariableM = m();
        solverVariableM.f1035d = 0;
        bVarL.d(solverVariable, solverVariable2, solverVariableM, i10);
        if (i11 != 8) {
            bVarL.f1060d.h(j(i11), (int) (bVarL.f1060d.j(solverVariableM) * (-1.0f)));
        }
        c(bVarL);
    }

    public final void h(b bVar) {
        int i10;
        if (bVar.f1061e) {
            bVar.f1057a.d(this, bVar.f1058b);
        } else {
            b[] bVarArr = this.f1069g;
            int i11 = this.f1072k;
            bVarArr[i11] = bVar;
            SolverVariable solverVariable = bVar.f1057a;
            solverVariable.f1034c = i11;
            this.f1072k = i11 + 1;
            solverVariable.e(this, bVar);
        }
        if (this.f1064b) {
            int i12 = 0;
            while (i12 < this.f1072k) {
                if (this.f1069g[i12] == null) {
                    System.out.println("WTF");
                }
                b bVar2 = this.f1069g[i12];
                if (bVar2 != null && bVar2.f1061e) {
                    bVar2.f1057a.d(this, bVar2.f1058b);
                    ((e0.b) this.f1074m.f8515b).a(bVar2);
                    this.f1069g[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f1072k;
                        if (i13 >= i10) {
                            break;
                        }
                        b[] bVarArr2 = this.f1069g;
                        int i15 = i13 - 1;
                        b bVar3 = bVarArr2[i13];
                        bVarArr2[i15] = bVar3;
                        SolverVariable solverVariable2 = bVar3.f1057a;
                        if (solverVariable2.f1034c == i13) {
                            solverVariable2.f1034c = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.f1069g[i14] = null;
                    }
                    this.f1072k = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f1064b = false;
        }
    }

    public final void i() {
        for (int i10 = 0; i10 < this.f1072k; i10++) {
            b bVar = this.f1069g[i10];
            bVar.f1057a.f1036e = bVar.f1058b;
        }
    }

    public final SolverVariable j(int i10) {
        if (this.f1071j + 1 >= this.f1068f) {
            o();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.f1045c);
        float[] fArr = solverVariableA.f1038k;
        int i11 = this.f1065c + 1;
        this.f1065c = i11;
        this.f1071j++;
        solverVariableA.f1033b = i11;
        solverVariableA.f1035d = i10;
        ((SolverVariable[]) this.f1074m.f8517d)[i11] = solverVariableA;
        d dVar = this.f1066d;
        dVar.f1080i.f1081a = solverVariableA;
        Arrays.fill(fArr, 0.0f);
        fArr[solverVariableA.f1035d] = 1.0f;
        dVar.j(solverVariableA);
        return solverVariableA;
    }

    public final SolverVariable k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.f1071j + 1 >= this.f1068f) {
            o();
        }
        if (!(obj instanceof ConstraintAnchor)) {
            return null;
        }
        ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
        SolverVariable solverVariable = constraintAnchor.f1090i;
        if (solverVariable == null) {
            constraintAnchor.k();
            solverVariable = constraintAnchor.f1090i;
        }
        int i10 = solverVariable.f1033b;
        e0.a aVar = this.f1074m;
        if (i10 != -1 && i10 <= this.f1065c && ((SolverVariable[]) aVar.f8517d)[i10] != null) {
            return solverVariable;
        }
        if (i10 != -1) {
            solverVariable.c();
        }
        int i11 = this.f1065c + 1;
        this.f1065c = i11;
        this.f1071j++;
        solverVariable.f1033b = i11;
        solverVariable.f1039l = SolverVariable.Type.f1043a;
        ((SolverVariable[]) aVar.f8517d)[i11] = solverVariable;
        return solverVariable;
    }

    public final b l() {
        Object obj;
        e0.a aVar = this.f1074m;
        e0.b bVar = (e0.b) aVar.f8515b;
        int i10 = bVar.f8518a;
        if (i10 > 0) {
            int i11 = i10 - 1;
            Object[] objArr = (Object[]) bVar.f8519b;
            obj = objArr[i11];
            objArr[i11] = null;
            bVar.f8518a = i11;
        } else {
            obj = null;
        }
        b bVar2 = (b) obj;
        if (bVar2 == null) {
            return new b(aVar);
        }
        bVar2.f1057a = null;
        bVar2.f1060d.clear();
        bVar2.f1058b = 0.0f;
        bVar2.f1061e = false;
        return bVar2;
    }

    public final SolverVariable m() {
        if (this.f1071j + 1 >= this.f1068f) {
            o();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.f1044b);
        int i10 = this.f1065c + 1;
        this.f1065c = i10;
        this.f1071j++;
        solverVariableA.f1033b = i10;
        ((SolverVariable[]) this.f1074m.f8517d)[i10] = solverVariableA;
        return solverVariableA;
    }

    public final void o() {
        int i10 = this.f1067e * 2;
        this.f1067e = i10;
        this.f1069g = (b[]) Arrays.copyOf(this.f1069g, i10);
        e0.a aVar = this.f1074m;
        aVar.f8517d = (SolverVariable[]) Arrays.copyOf((SolverVariable[]) aVar.f8517d, this.f1067e);
        int i11 = this.f1067e;
        this.f1070i = new boolean[i11];
        this.f1068f = i11;
        this.f1073l = i11;
    }

    public final void p() {
        d dVar = this.f1066d;
        if (dVar.e()) {
            i();
            return;
        }
        if (!this.h) {
            q(dVar);
            return;
        }
        for (int i10 = 0; i10 < this.f1072k; i10++) {
            if (!this.f1069g[i10].f1061e) {
                q(dVar);
                return;
            }
        }
        i();
    }

    public final void q(d dVar) {
        int i10 = 0;
        while (true) {
            if (i10 >= this.f1072k) {
                break;
            }
            b bVar = this.f1069g[i10];
            SolverVariable.Type type = bVar.f1057a.f1039l;
            SolverVariable.Type type2 = SolverVariable.Type.f1043a;
            if (type != type2) {
                float f8 = 0.0f;
                if (bVar.f1058b < 0.0f) {
                    boolean z = false;
                    int i11 = 0;
                    while (!z) {
                        i11++;
                        float f9 = Float.MAX_VALUE;
                        int i12 = 0;
                        int i13 = -1;
                        int i14 = -1;
                        int i15 = 0;
                        while (i12 < this.f1072k) {
                            b bVar2 = this.f1069g[i12];
                            if (bVar2.f1057a.f1039l != type2 && !bVar2.f1061e && bVar2.f1058b < f8) {
                                int iF = bVar2.f1060d.f();
                                int i16 = 0;
                                while (i16 < iF) {
                                    SolverVariable solverVariableB = bVar2.f1060d.b(i16);
                                    float f10 = f8;
                                    float fJ = bVar2.f1060d.j(solverVariableB);
                                    if (fJ > f10) {
                                        for (int i17 = 0; i17 < 9; i17++) {
                                            float f11 = solverVariableB.f1037j[i17] / fJ;
                                            if ((f11 < f9 && i17 == i15) || i17 > i15) {
                                                i15 = i17;
                                                i14 = solverVariableB.f1033b;
                                                i13 = i12;
                                                f9 = f11;
                                            }
                                        }
                                    }
                                    i16++;
                                    f8 = f10;
                                }
                            }
                            i12++;
                            f8 = f8;
                        }
                        float f12 = f8;
                        if (i13 != -1) {
                            b bVar3 = this.f1069g[i13];
                            bVar3.f1057a.f1034c = -1;
                            bVar3.g(((SolverVariable[]) this.f1074m.f8517d)[i14]);
                            SolverVariable solverVariable = bVar3.f1057a;
                            solverVariable.f1034c = i13;
                            solverVariable.e(this, bVar3);
                        } else {
                            z = true;
                        }
                        if (i11 > this.f1071j / 2) {
                            z = true;
                        }
                        f8 = f12;
                    }
                }
            }
            i10++;
        }
        r(dVar);
        i();
    }

    public final void r(a aVar) {
        for (int i10 = 0; i10 < this.f1071j; i10++) {
            this.f1070i[i10] = false;
        }
        boolean z = false;
        int i11 = 0;
        while (!z) {
            i11++;
            if (i11 >= this.f1071j * 2) {
                return;
            }
            SolverVariable solverVariable = ((b) aVar).f1057a;
            if (solverVariable != null) {
                this.f1070i[solverVariable.f1033b] = true;
            }
            SolverVariable solverVariableA = aVar.a(this.f1070i);
            if (solverVariableA != null) {
                boolean[] zArr = this.f1070i;
                int i12 = solverVariableA.f1033b;
                if (zArr[i12]) {
                    return;
                } else {
                    zArr[i12] = true;
                }
            }
            if (solverVariableA != null) {
                float f8 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = 0; i14 < this.f1072k; i14++) {
                    b bVar = this.f1069g[i14];
                    if (bVar.f1057a.f1039l != SolverVariable.Type.f1043a && !bVar.f1061e && bVar.f1060d.a(solverVariableA)) {
                        float fJ = bVar.f1060d.j(solverVariableA);
                        if (fJ < 0.0f) {
                            float f9 = (-bVar.f1058b) / fJ;
                            if (f9 < f8) {
                                i13 = i14;
                                f8 = f9;
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    b bVar2 = this.f1069g[i13];
                    bVar2.f1057a.f1034c = -1;
                    bVar2.g(solverVariableA);
                    SolverVariable solverVariable2 = bVar2.f1057a;
                    solverVariable2.f1034c = i13;
                    solverVariable2.e(this, bVar2);
                }
            } else {
                z = true;
            }
        }
    }

    public final void s() {
        for (int i10 = 0; i10 < this.f1072k; i10++) {
            b bVar = this.f1069g[i10];
            if (bVar != null) {
                ((e0.b) this.f1074m.f8515b).a(bVar);
            }
            this.f1069g[i10] = null;
        }
    }

    public final void t() {
        e0.a aVar;
        int i10 = 0;
        while (true) {
            aVar = this.f1074m;
            SolverVariable[] solverVariableArr = (SolverVariable[]) aVar.f8517d;
            if (i10 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i10];
            if (solverVariable != null) {
                solverVariable.c();
            }
            i10++;
        }
        e0.b bVar = (e0.b) aVar.f8516c;
        SolverVariable[] solverVariableArr2 = this.f1075n;
        int length = this.f1076o;
        bVar.getClass();
        if (length > solverVariableArr2.length) {
            length = solverVariableArr2.length;
        }
        for (int i11 = 0; i11 < length; i11++) {
            SolverVariable solverVariable2 = solverVariableArr2[i11];
            int i12 = bVar.f8518a;
            Object[] objArr = (Object[]) bVar.f8519b;
            if (i12 < objArr.length) {
                objArr[i12] = solverVariable2;
                bVar.f8518a = i12 + 1;
            }
        }
        this.f1076o = 0;
        Arrays.fill((SolverVariable[]) aVar.f8517d, (Object) null);
        this.f1065c = 0;
        d dVar = this.f1066d;
        dVar.h = 0;
        dVar.f1058b = 0.0f;
        this.f1071j = 1;
        for (int i13 = 0; i13 < this.f1072k; i13++) {
            b bVar2 = this.f1069g[i13];
        }
        s();
        this.f1072k = 0;
        this.f1077p = new b(aVar);
    }
}
