package h0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.widget.ConstraintLayout;
import h0.b;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.d f9189a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9190b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9191c;

    /* renamed from: d, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.d f9192d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<WidgetRun> f9193e;

    /* renamed from: f, reason: collision with root package name */
    public b.InterfaceC0086b f9194f;

    /* renamed from: g, reason: collision with root package name */
    public b.a f9195g;
    public ArrayList<j> h;

    public final void a(DependencyNode dependencyNode, int i10, ArrayList arrayList, j jVar) {
        WidgetRun widgetRun = dependencyNode.f1148d;
        j jVar2 = widgetRun.f1166c;
        DependencyNode dependencyNode2 = widgetRun.f1171i;
        DependencyNode dependencyNode3 = widgetRun.h;
        if (jVar2 == null) {
            androidx.constraintlayout.core.widgets.d dVar = this.f9189a;
            if (widgetRun == dVar.f1103d || widgetRun == dVar.f1105e) {
                return;
            }
            if (jVar == null) {
                jVar = new j();
                jVar.f9197a = null;
                jVar.f9198b = new ArrayList<>();
                jVar.f9197a = widgetRun;
                arrayList.add(jVar);
            }
            widgetRun.f1166c = jVar;
            jVar.f9198b.add(widgetRun);
            ArrayList arrayList2 = dependencyNode3.f1154k;
            int size = arrayList2.size();
            int i11 = 0;
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayList2.get(i12);
                i12++;
                d dVar2 = (d) obj;
                if (dVar2 instanceof DependencyNode) {
                    a((DependencyNode) dVar2, i10, arrayList, jVar);
                }
            }
            ArrayList arrayList3 = dependencyNode2.f1154k;
            int size2 = arrayList3.size();
            int i13 = 0;
            while (i13 < size2) {
                Object obj2 = arrayList3.get(i13);
                i13++;
                d dVar3 = (d) obj2;
                if (dVar3 instanceof DependencyNode) {
                    a((DependencyNode) dVar3, i10, arrayList, jVar);
                }
            }
            if (i10 == 1 && (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.d)) {
                ArrayList arrayList4 = ((androidx.constraintlayout.core.widgets.analyzer.d) widgetRun).f1178k.f1154k;
                int size3 = arrayList4.size();
                int i14 = 0;
                while (i14 < size3) {
                    Object obj3 = arrayList4.get(i14);
                    i14++;
                    d dVar4 = (d) obj3;
                    if (dVar4 instanceof DependencyNode) {
                        a((DependencyNode) dVar4, i10, arrayList, jVar);
                    }
                }
            }
            ArrayList arrayList5 = dependencyNode3.f1155l;
            int size4 = arrayList5.size();
            int i15 = 0;
            while (i15 < size4) {
                Object obj4 = arrayList5.get(i15);
                i15++;
                a((DependencyNode) obj4, i10, arrayList, jVar);
            }
            ArrayList arrayList6 = dependencyNode2.f1155l;
            int size5 = arrayList6.size();
            int i16 = 0;
            while (i16 < size5) {
                Object obj5 = arrayList6.get(i16);
                i16++;
                a((DependencyNode) obj5, i10, arrayList, jVar);
            }
            if (i10 == 1 && (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.d)) {
                ArrayList arrayList7 = ((androidx.constraintlayout.core.widgets.analyzer.d) widgetRun).f1178k.f1155l;
                int size6 = arrayList7.size();
                while (i11 < size6) {
                    Object obj6 = arrayList7.get(i11);
                    i11++;
                    a((DependencyNode) obj6, i10, arrayList, jVar);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0321  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.constraintlayout.core.widgets.d r26) {
        /*
            Method dump skipped, instructions count: 834
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.f.b(androidx.constraintlayout.core.widgets.d):void");
    }

    public final void c() {
        androidx.constraintlayout.core.widgets.d dVar = this.f9189a;
        ArrayList<j> arrayList = this.h;
        ArrayList<WidgetRun> arrayList2 = this.f9193e;
        arrayList2.clear();
        androidx.constraintlayout.core.widgets.d dVar2 = this.f9192d;
        dVar2.f1103d.f();
        dVar2.f1105e.f();
        arrayList2.add(dVar2.f1103d);
        arrayList2.add(dVar2.f1105e);
        ArrayList<ConstraintWidget> arrayList3 = dVar2.f8946r0;
        int size = arrayList3.size();
        HashSet hashSet = null;
        int i10 = 0;
        while (i10 < size) {
            ConstraintWidget constraintWidget = arrayList3.get(i10);
            i10++;
            ConstraintWidget constraintWidget2 = constraintWidget;
            if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.f) {
                i iVar = new i(constraintWidget2);
                constraintWidget2.f1103d.f();
                constraintWidget2.f1105e.f();
                iVar.f1169f = ((androidx.constraintlayout.core.widgets.f) constraintWidget2).f1226v0;
                arrayList2.add(iVar);
            } else {
                if (constraintWidget2.x()) {
                    if (constraintWidget2.f1101b == null) {
                        constraintWidget2.f1101b = new c(constraintWidget2, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget2.f1101b);
                } else {
                    arrayList2.add(constraintWidget2.f1103d);
                }
                if (constraintWidget2.y()) {
                    if (constraintWidget2.f1102c == null) {
                        constraintWidget2.f1102c = new c(constraintWidget2, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget2.f1102c);
                } else {
                    arrayList2.add(constraintWidget2.f1105e);
                }
                if (constraintWidget2 instanceof g0.a) {
                    arrayList2.add(new androidx.constraintlayout.core.widgets.analyzer.b(constraintWidget2));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        int size2 = arrayList2.size();
        int i11 = 0;
        while (i11 < size2) {
            WidgetRun widgetRun = arrayList2.get(i11);
            i11++;
            widgetRun.f();
        }
        int size3 = arrayList2.size();
        int i12 = 0;
        while (i12 < size3) {
            WidgetRun widgetRun2 = arrayList2.get(i12);
            i12++;
            WidgetRun widgetRun3 = widgetRun2;
            if (widgetRun3.f1165b != dVar2) {
                widgetRun3.d();
            }
        }
        arrayList.clear();
        e(dVar.f1103d, 0, arrayList);
        e(dVar.f1105e, 1, arrayList);
        this.f9190b = false;
    }

    public final int d(androidx.constraintlayout.core.widgets.d dVar, int i10) {
        ArrayList<j> arrayList;
        int i11;
        long jMax;
        float f8;
        androidx.constraintlayout.core.widgets.d dVar2 = dVar;
        ArrayList<j> arrayList2 = this.h;
        int size = arrayList2.size();
        long j10 = 0;
        int i12 = 0;
        long jMax2 = 0;
        while (i12 < size) {
            WidgetRun widgetRun = arrayList2.get(i12).f9197a;
            if (!(widgetRun instanceof c) ? !(i10 != 0 ? (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.d) : (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.c)) : ((c) widgetRun).f1169f != i10) {
                DependencyNode dependencyNode = (i10 == 0 ? dVar2.f1103d : dVar2.f1105e).h;
                DependencyNode dependencyNode2 = (i10 == 0 ? dVar2.f1103d : dVar2.f1105e).f1171i;
                DependencyNode dependencyNode3 = widgetRun.h;
                DependencyNode dependencyNode4 = widgetRun.f1171i;
                boolean zContains = dependencyNode3.f1155l.contains(dependencyNode);
                boolean zContains2 = dependencyNode4.f1155l.contains(dependencyNode2);
                long j11 = widgetRun.j();
                if (zContains && zContains2) {
                    long jB = j.b(dependencyNode3, j10);
                    arrayList = arrayList2;
                    long jA = j.a(dependencyNode4, j10);
                    long j12 = jB - j11;
                    int i13 = dependencyNode4.f1150f;
                    i11 = i12;
                    if (j12 >= (-i13)) {
                        j12 += i13;
                    }
                    long j13 = dependencyNode3.f1150f;
                    long j14 = ((-jA) - j11) - j13;
                    if (j14 >= j13) {
                        j14 -= j13;
                    }
                    ConstraintWidget constraintWidget = widgetRun.f1165b;
                    if (i10 == 0) {
                        f8 = constraintWidget.f1108f0;
                    } else if (i10 == 1) {
                        f8 = constraintWidget.f1110g0;
                    } else {
                        constraintWidget.getClass();
                        f8 = -1.0f;
                    }
                    float f9 = f8 > 0.0f ? (long) ((j12 / (1.0f - f8)) + (j14 / f8)) : 0L;
                    jMax = (dependencyNode3.f1150f + ((((long) ((f9 * f8) + 0.5f)) + j11) + ((long) e.a(1.0f, f8, f9, 0.5f)))) - dependencyNode4.f1150f;
                } else {
                    arrayList = arrayList2;
                    i11 = i12;
                    jMax = zContains ? Math.max(j.b(dependencyNode3, dependencyNode3.f1150f), dependencyNode3.f1150f + j11) : zContains2 ? Math.max(-j.a(dependencyNode4, dependencyNode4.f1150f), (-dependencyNode4.f1150f) + j11) : (widgetRun.j() + dependencyNode3.f1150f) - dependencyNode4.f1150f;
                }
            } else {
                arrayList = arrayList2;
                jMax = j10;
                i11 = i12;
            }
            jMax2 = Math.max(jMax2, jMax);
            i12 = i11 + 1;
            arrayList2 = arrayList;
            dVar2 = dVar;
            j10 = 0;
        }
        return (int) jMax2;
    }

    public final void e(WidgetRun widgetRun, int i10, ArrayList<j> arrayList) {
        DependencyNode dependencyNode = widgetRun.h;
        DependencyNode dependencyNode2 = widgetRun.f1171i;
        ArrayList arrayList2 = dependencyNode.f1154k;
        int size = arrayList2.size();
        int i11 = 0;
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList2.get(i12);
            i12++;
            d dVar = (d) obj;
            if (dVar instanceof DependencyNode) {
                a((DependencyNode) dVar, i10, arrayList, null);
            } else if (dVar instanceof WidgetRun) {
                a(((WidgetRun) dVar).h, i10, arrayList, null);
            }
        }
        ArrayList arrayList3 = dependencyNode2.f1154k;
        int size2 = arrayList3.size();
        int i13 = 0;
        while (i13 < size2) {
            Object obj2 = arrayList3.get(i13);
            i13++;
            d dVar2 = (d) obj2;
            if (dVar2 instanceof DependencyNode) {
                a((DependencyNode) dVar2, i10, arrayList, null);
            } else if (dVar2 instanceof WidgetRun) {
                a(((WidgetRun) dVar2).f1171i, i10, arrayList, null);
            }
        }
        if (i10 == 1) {
            ArrayList arrayList4 = ((androidx.constraintlayout.core.widgets.analyzer.d) widgetRun).f1178k.f1154k;
            int size3 = arrayList4.size();
            while (i11 < size3) {
                Object obj3 = arrayList4.get(i11);
                i11++;
                d dVar3 = (d) obj3;
                if (dVar3 instanceof DependencyNode) {
                    a((DependencyNode) dVar3, i10, arrayList, null);
                }
            }
        }
    }

    public final void f(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        b.a aVar = this.f9195g;
        aVar.f9178a = dimensionBehaviour;
        aVar.f9179b = dimensionBehaviour2;
        aVar.f9180c = i10;
        aVar.f9181d = i11;
        ((ConstraintLayout.b) this.f9194f).b(constraintWidget, aVar);
        constraintWidget.O(aVar.f9182e);
        constraintWidget.L(aVar.f9183f);
        constraintWidget.E = aVar.h;
        constraintWidget.I(aVar.f9184g);
    }

    public final void g() {
        a aVar;
        f fVar = this;
        ArrayList<ConstraintWidget> arrayList = fVar.f9189a.f8946r0;
        int size = arrayList.size();
        char c9 = 0;
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            ConstraintWidget constraintWidget = arrayList.get(i10);
            if (!constraintWidget.f1099a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[c9];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i12 = constraintWidget.r;
                int i13 = constraintWidget.f1129s;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1138c;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.f1137b;
                char c10 = (dimensionBehaviour == dimensionBehaviour4 || (dimensionBehaviour == dimensionBehaviour3 && i12 == 1)) ? (char) 1 : c9;
                char c11 = (dimensionBehaviour2 == dimensionBehaviour4 || (dimensionBehaviour2 == dimensionBehaviour3 && i13 == 1)) ? (char) 1 : c9;
                androidx.constraintlayout.core.widgets.analyzer.a aVar2 = constraintWidget.f1103d.f1168e;
                boolean z = aVar2.f1153j;
                androidx.constraintlayout.core.widgets.analyzer.a aVar3 = constraintWidget.f1105e.f1168e;
                boolean z3 = aVar3.f1153j;
                char c12 = c10;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.f1136a;
                if (z && z3) {
                    fVar.f(constraintWidget, dimensionBehaviour5, aVar2.f1151g, dimensionBehaviour5, aVar3.f1151g);
                    constraintWidget.f1099a = true;
                } else if (z && c11 != 0) {
                    f(constraintWidget, dimensionBehaviour5, aVar2.f1151g, dimensionBehaviour4, aVar3.f1151g);
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget.f1105e.f1168e.f1176m = constraintWidget.k();
                    } else {
                        constraintWidget.f1105e.f1168e.d(constraintWidget.k());
                        constraintWidget.f1099a = true;
                    }
                } else if (z3 && c12 != 0) {
                    f(constraintWidget, dimensionBehaviour4, aVar2.f1151g, dimensionBehaviour5, aVar3.f1151g);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget.f1103d.f1168e.f1176m = constraintWidget.q();
                    } else {
                        constraintWidget.f1103d.f1168e.d(constraintWidget.q());
                        constraintWidget.f1099a = true;
                    }
                }
                if (constraintWidget.f1099a && (aVar = constraintWidget.f1105e.f1179l) != null) {
                    aVar.d(constraintWidget.c0);
                }
                c9 = 0;
                fVar = this;
            }
            i10 = i11;
        }
    }
}
