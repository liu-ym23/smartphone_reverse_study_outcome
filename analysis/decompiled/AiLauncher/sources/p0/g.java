package p0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import o0.C4994b;

/* loaded from: classes.dex */
public class g {
    public static j a(ConstraintWidget constraintWidget, int i10, ArrayList<j> arrayList, j jVar) {
        int iX1;
        int i11 = i10 == 0 ? constraintWidget.f11969S0 : constraintWidget.f11971T0;
        if (i11 != -1 && (jVar == null || i11 != jVar.c())) {
            int i12 = 0;
            while (true) {
                if (i12 >= arrayList.size()) {
                    break;
                }
                j jVar2 = arrayList.get(i12);
                if (jVar2.c() == i11) {
                    if (jVar != null) {
                        jVar.g(i10, jVar2);
                        arrayList.remove(jVar);
                    }
                    jVar = jVar2;
                } else {
                    i12++;
                }
            }
        } else if (i11 != -1) {
            return jVar;
        }
        if (jVar == null) {
            if ((constraintWidget instanceof C4994b) && (iX1 = ((C4994b) constraintWidget).x1(i10)) != -1) {
                int i13 = 0;
                while (true) {
                    if (i13 >= arrayList.size()) {
                        break;
                    }
                    j jVar3 = arrayList.get(i13);
                    if (jVar3.c() == iX1) {
                        jVar = jVar3;
                        break;
                    }
                    i13++;
                }
            }
            if (jVar == null) {
                jVar = new j(i10);
            }
            arrayList.add(jVar);
        }
        if (jVar.a(constraintWidget)) {
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
                fVar.w1().c(fVar.x1() == 0 ? 1 : 0, arrayList, jVar);
            }
            if (i10 == 0) {
                constraintWidget.f11969S0 = jVar.c();
                constraintWidget.f11964Q.c(i10, arrayList, jVar);
                constraintWidget.f11968S.c(i10, arrayList, jVar);
            } else {
                constraintWidget.f11971T0 = jVar.c();
                constraintWidget.f11966R.c(i10, arrayList, jVar);
                constraintWidget.f11972U.c(i10, arrayList, jVar);
                constraintWidget.f11970T.c(i10, arrayList, jVar);
            }
            constraintWidget.f11975X.c(i10, arrayList, jVar);
        }
        return jVar;
    }

    public static j b(ArrayList<j> arrayList, int i10) {
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            j jVar = arrayList.get(i11);
            if (i10 == jVar.c()) {
                return jVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x0349  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(androidx.constraintlayout.core.widgets.d r17, p0.C5034b.InterfaceC0492b r18) {
        /*
            Method dump skipped, instructions count: 920
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.g.c(androidx.constraintlayout.core.widgets.d, p0.b$b):boolean");
    }

    public static boolean d(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        return (dimensionBehaviour3 == dimensionBehaviour7 || dimensionBehaviour3 == (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != dimensionBehaviour6)) || (dimensionBehaviour4 == dimensionBehaviour7 || dimensionBehaviour4 == (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != dimensionBehaviour5));
    }
}
