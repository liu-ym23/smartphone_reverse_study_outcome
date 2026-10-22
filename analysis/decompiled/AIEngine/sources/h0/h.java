package h0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {
    public static k a(ConstraintWidget constraintWidget, int i10, ArrayList<k> arrayList, k kVar) {
        int i11;
        int i12 = i10 == 0 ? constraintWidget.f1127p0 : constraintWidget.q0;
        if (i12 != -1 && (kVar == null || i12 != kVar.f9201b)) {
            int i13 = 0;
            while (true) {
                if (i13 >= arrayList.size()) {
                    break;
                }
                k kVar2 = arrayList.get(i13);
                if (kVar2.f9201b == i12) {
                    if (kVar != null) {
                        kVar.c(i10, kVar2);
                        arrayList.remove(kVar);
                    }
                    kVar = kVar2;
                } else {
                    i13++;
                }
            }
        } else if (i12 != -1) {
            return kVar;
        }
        if (kVar == null) {
            if (constraintWidget instanceof g0.a) {
                g0.a aVar = (g0.a) constraintWidget;
                int i14 = 0;
                while (true) {
                    if (i14 >= aVar.f8945s0) {
                        i11 = -1;
                        break;
                    }
                    ConstraintWidget constraintWidget2 = aVar.f8944r0[i14];
                    if ((i10 == 0 && (i11 = constraintWidget2.f1127p0) != -1) || (i10 == 1 && (i11 = constraintWidget2.q0) != -1)) {
                        break;
                    }
                    i14++;
                }
                if (i11 != -1) {
                    int i15 = 0;
                    while (true) {
                        if (i15 >= arrayList.size()) {
                            break;
                        }
                        k kVar3 = arrayList.get(i15);
                        if (kVar3.f9201b == i11) {
                            kVar = kVar3;
                            break;
                        }
                        i15++;
                    }
                }
            }
            if (kVar == null) {
                kVar = new k();
                kVar.f9200a = new ArrayList<>();
                kVar.f9203d = null;
                kVar.f9204e = -1;
                int i16 = k.f9199f;
                k.f9199f = i16 + 1;
                kVar.f9201b = i16;
                kVar.f9202c = i10;
            }
            arrayList.add(kVar);
        }
        int i17 = kVar.f9201b;
        ArrayList<ConstraintWidget> arrayList2 = kVar.f9200a;
        if (arrayList2.contains(constraintWidget)) {
            return kVar;
        }
        arrayList2.add(constraintWidget);
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
            androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
            fVar.f1225u0.c(fVar.f1226v0 == 0 ? 1 : 0, kVar, arrayList);
        }
        if (i10 == 0) {
            constraintWidget.f1127p0 = i17;
            constraintWidget.J.c(i10, kVar, arrayList);
            constraintWidget.L.c(i10, kVar, arrayList);
        } else {
            constraintWidget.q0 = i17;
            constraintWidget.K.c(i10, kVar, arrayList);
            constraintWidget.N.c(i10, kVar, arrayList);
            constraintWidget.M.c(i10, kVar, arrayList);
        }
        constraintWidget.Q.c(i10, kVar, arrayList);
        return kVar;
    }

    public static boolean b(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.f1139d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.f1137b;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.f1136a;
        return (dimensionBehaviour3 == dimensionBehaviour7 || dimensionBehaviour3 == dimensionBehaviour6 || (dimensionBehaviour3 == dimensionBehaviour5 && dimensionBehaviour != dimensionBehaviour6)) || (dimensionBehaviour4 == dimensionBehaviour7 || dimensionBehaviour4 == dimensionBehaviour6 || (dimensionBehaviour4 == dimensionBehaviour5 && dimensionBehaviour2 != dimensionBehaviour6));
    }
}
