package p0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import o0.C4994b;
import p0.C5034b;

/* renamed from: p0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5037e {

    /* renamed from: a, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.d f38025a;

    /* renamed from: d, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.d f38028d;

    /* renamed from: b, reason: collision with root package name */
    public boolean f38026b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f38027c = true;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<WidgetRun> f38029e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<i> f38030f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public C5034b.InterfaceC0492b f38031g = null;

    /* renamed from: h, reason: collision with root package name */
    public C5034b.a f38032h = new C5034b.a();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<i> f38033i = new ArrayList<>();

    public C5037e(androidx.constraintlayout.core.widgets.d dVar) {
        this.f38025a = dVar;
        this.f38028d = dVar;
    }

    public final void a(DependencyNode dependencyNode, int i10, int i11, DependencyNode dependencyNode2, ArrayList<i> arrayList, i iVar) {
        C5037e c5037e;
        int i12;
        DependencyNode dependencyNode3;
        ArrayList<i> arrayList2;
        WidgetRun widgetRun = dependencyNode.f12038d;
        if (widgetRun.f12049c == null) {
            androidx.constraintlayout.core.widgets.d dVar = this.f38025a;
            if (widgetRun == dVar.f11986e || widgetRun == dVar.f11988f) {
                return;
            }
            if (iVar == null) {
                iVar = new i(widgetRun, i11);
                arrayList.add(iVar);
            }
            i iVar2 = iVar;
            widgetRun.f12049c = iVar2;
            iVar2.a(widgetRun);
            for (InterfaceC5036d interfaceC5036d : widgetRun.f12054h.f12045k) {
                if (interfaceC5036d instanceof DependencyNode) {
                    c5037e = this;
                    i12 = i10;
                    dependencyNode3 = dependencyNode2;
                    arrayList2 = arrayList;
                    c5037e.a((DependencyNode) interfaceC5036d, i12, 0, dependencyNode3, arrayList2, iVar2);
                } else {
                    c5037e = this;
                    i12 = i10;
                    dependencyNode3 = dependencyNode2;
                    arrayList2 = arrayList;
                }
                this = c5037e;
                i10 = i12;
                dependencyNode2 = dependencyNode3;
                arrayList = arrayList2;
            }
            C5037e c5037e2 = this;
            int i13 = i10;
            DependencyNode dependencyNode4 = dependencyNode2;
            ArrayList<i> arrayList3 = arrayList;
            for (InterfaceC5036d interfaceC5036d2 : widgetRun.f12055i.f12045k) {
                if (interfaceC5036d2 instanceof DependencyNode) {
                    c5037e2.a((DependencyNode) interfaceC5036d2, i13, 1, dependencyNode4, arrayList3, iVar2);
                }
            }
            if (i13 == 1 && (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.d)) {
                for (InterfaceC5036d interfaceC5036d3 : ((androidx.constraintlayout.core.widgets.analyzer.d) widgetRun).f12061k.f12045k) {
                    if (interfaceC5036d3 instanceof DependencyNode) {
                        c5037e2.a((DependencyNode) interfaceC5036d3, i13, 2, dependencyNode4, arrayList3, iVar2);
                    }
                }
            }
            for (DependencyNode dependencyNode5 : widgetRun.f12054h.f12046l) {
                if (dependencyNode5 == dependencyNode4) {
                    iVar2.f38039b = true;
                }
                c5037e2.a(dependencyNode5, i13, 0, dependencyNode4, arrayList3, iVar2);
            }
            for (DependencyNode dependencyNode6 : widgetRun.f12055i.f12046l) {
                if (dependencyNode6 == dependencyNode4) {
                    iVar2.f38039b = true;
                }
                c5037e2.a(dependencyNode6, i13, 1, dependencyNode4, arrayList3, iVar2);
            }
            if (i13 == 1 && (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.d)) {
                Iterator<DependencyNode> it = ((androidx.constraintlayout.core.widgets.analyzer.d) widgetRun).f12061k.f12046l.iterator();
                while (it.hasNext()) {
                    c5037e2.a(it.next(), i13, 2, dependencyNode4, arrayList3, iVar2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x0284 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0008 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(androidx.constraintlayout.core.widgets.d r20) {
        /*
            Method dump skipped, instructions count: 833
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C5037e.b(androidx.constraintlayout.core.widgets.d):boolean");
    }

    public void c() {
        d(this.f38029e);
        this.f38033i.clear();
        i.f38037h = 0;
        i(this.f38025a.f11986e, 0, this.f38033i);
        i(this.f38025a.f11988f, 1, this.f38033i);
        this.f38026b = false;
    }

    public void d(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.f38028d.f11986e.f();
        this.f38028d.f11988f.f();
        arrayList.add(this.f38028d.f11986e);
        arrayList.add(this.f38028d.f11988f);
        Iterator<ConstraintWidget> it = this.f38028d.f37462V0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof androidx.constraintlayout.core.widgets.f) {
                arrayList.add(new h(next));
            } else {
                if (next.k0()) {
                    if (next.f11982c == null) {
                        next.f11982c = new C5035c(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f11982c);
                } else {
                    arrayList.add(next.f11986e);
                }
                if (next.m0()) {
                    if (next.f11984d == null) {
                        next.f11984d = new C5035c(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f11984d);
                } else {
                    arrayList.add(next.f11988f);
                }
                if (next instanceof C4994b) {
                    arrayList.add(new androidx.constraintlayout.core.widgets.analyzer.b(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.f12048b != this.f38028d) {
                next2.d();
            }
        }
    }

    public final int e(androidx.constraintlayout.core.widgets.d dVar, int i10) {
        int size = this.f38033i.size();
        long jMax = 0;
        for (int i11 = 0; i11 < size; i11++) {
            jMax = Math.max(jMax, this.f38033i.get(i11).b(dVar, i10));
        }
        return (int) jMax;
    }

    public boolean f(boolean z10) {
        boolean z11;
        boolean z12 = false;
        if (this.f38026b || this.f38027c) {
            Iterator<ConstraintWidget> it = this.f38025a.f37462V0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.p();
                next.f11978a = false;
                next.f11986e.r();
                next.f11988f.q();
            }
            this.f38025a.p();
            androidx.constraintlayout.core.widgets.d dVar = this.f38025a;
            dVar.f11978a = false;
            dVar.f11986e.r();
            this.f38025a.f11988f.q();
            this.f38027c = false;
        }
        if (b(this.f38028d)) {
            return false;
        }
        this.f38025a.r1(0);
        this.f38025a.s1(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourW = this.f38025a.w(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = this.f38025a.w(1);
        if (this.f38026b) {
            c();
        }
        int iZ = this.f38025a.Z();
        int iA0 = this.f38025a.a0();
        this.f38025a.f11986e.f12054h.d(iZ);
        this.f38025a.f11988f.f12054h.d(iA0);
        m();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviourW == dimensionBehaviour || dimensionBehaviourW2 == dimensionBehaviour) {
            if (z10) {
                Iterator<WidgetRun> it2 = this.f38029e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().m()) {
                        z10 = false;
                        break;
                    }
                }
            }
            if (z10 && dimensionBehaviourW == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f38025a.U0(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar2 = this.f38025a;
                dVar2.p1(e(dVar2, 0));
                androidx.constraintlayout.core.widgets.d dVar3 = this.f38025a;
                dVar3.f11986e.f12051e.d(dVar3.Y());
            }
            if (z10 && dimensionBehaviourW2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f38025a.l1(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar4 = this.f38025a;
                dVar4.Q0(e(dVar4, 1));
                androidx.constraintlayout.core.widgets.d dVar5 = this.f38025a;
                dVar5.f11988f.f12051e.d(dVar5.z());
            }
        }
        androidx.constraintlayout.core.widgets.d dVar6 = this.f38025a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dVar6.f11981b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour2 == dimensionBehaviour3 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int iY = dVar6.Y() + iZ;
            this.f38025a.f11986e.f12055i.d(iY);
            this.f38025a.f11986e.f12051e.d(iY - iZ);
            m();
            androidx.constraintlayout.core.widgets.d dVar7 = this.f38025a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dVar7.f11981b0[1];
            if (dimensionBehaviour4 == dimensionBehaviour3 || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int iZ2 = dVar7.z() + iA0;
                this.f38025a.f11988f.f12055i.d(iZ2);
                this.f38025a.f11988f.f12051e.d(iZ2 - iA0);
            }
            m();
            z11 = true;
        } else {
            z11 = false;
        }
        Iterator<WidgetRun> it3 = this.f38029e.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.f12048b != this.f38025a || next2.f12053g) {
                next2.e();
            }
        }
        Iterator<WidgetRun> it4 = this.f38029e.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z12 = true;
                break;
            }
            WidgetRun next3 = it4.next();
            if (z11 || next3.f12048b != this.f38025a) {
                if (!next3.f12054h.f12044j || ((!next3.f12055i.f12044j && !(next3 instanceof h)) || (!next3.f12051e.f12044j && !(next3 instanceof C5035c) && !(next3 instanceof h)))) {
                    break;
                }
            }
        }
        this.f38025a.U0(dimensionBehaviourW);
        this.f38025a.l1(dimensionBehaviourW2);
        return z12;
    }

    public boolean g(boolean z10) {
        if (this.f38026b) {
            Iterator<ConstraintWidget> it = this.f38025a.f37462V0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.p();
                next.f11978a = false;
                androidx.constraintlayout.core.widgets.analyzer.c cVar = next.f11986e;
                cVar.f12051e.f12044j = false;
                cVar.f12053g = false;
                cVar.r();
                androidx.constraintlayout.core.widgets.analyzer.d dVar = next.f11988f;
                dVar.f12051e.f12044j = false;
                dVar.f12053g = false;
                dVar.q();
            }
            this.f38025a.p();
            androidx.constraintlayout.core.widgets.d dVar2 = this.f38025a;
            dVar2.f11978a = false;
            androidx.constraintlayout.core.widgets.analyzer.c cVar2 = dVar2.f11986e;
            cVar2.f12051e.f12044j = false;
            cVar2.f12053g = false;
            cVar2.r();
            androidx.constraintlayout.core.widgets.analyzer.d dVar3 = this.f38025a.f11988f;
            dVar3.f12051e.f12044j = false;
            dVar3.f12053g = false;
            dVar3.q();
            c();
        }
        if (b(this.f38028d)) {
            return false;
        }
        this.f38025a.r1(0);
        this.f38025a.s1(0);
        this.f38025a.f11986e.f12054h.d(0);
        this.f38025a.f11988f.f12054h.d(0);
        return true;
    }

    public boolean h(boolean z10, int i10) {
        boolean z11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z12 = false;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourW = this.f38025a.w(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = this.f38025a.w(1);
        int iZ = this.f38025a.Z();
        int iA0 = this.f38025a.a0();
        if (z10 && (dimensionBehaviourW == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviourW2 == dimensionBehaviour)) {
            Iterator<WidgetRun> it = this.f38029e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun next = it.next();
                if (next.f12052f == i10 && !next.m()) {
                    z10 = false;
                    break;
                }
            }
            if (i10 == 0) {
                if (z10 && dimensionBehaviourW == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.f38025a.U0(ConstraintWidget.DimensionBehaviour.FIXED);
                    androidx.constraintlayout.core.widgets.d dVar = this.f38025a;
                    dVar.p1(e(dVar, 0));
                    androidx.constraintlayout.core.widgets.d dVar2 = this.f38025a;
                    dVar2.f11986e.f12051e.d(dVar2.Y());
                }
            } else if (z10 && dimensionBehaviourW2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f38025a.l1(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar3 = this.f38025a;
                dVar3.Q0(e(dVar3, 1));
                androidx.constraintlayout.core.widgets.d dVar4 = this.f38025a;
                dVar4.f11988f.f12051e.d(dVar4.z());
            }
        }
        if (i10 == 0) {
            androidx.constraintlayout.core.widgets.d dVar5 = this.f38025a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dVar5.f11981b0[0];
            if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int iY = dVar5.Y() + iZ;
                this.f38025a.f11986e.f12055i.d(iY);
                this.f38025a.f11986e.f12051e.d(iY - iZ);
                z11 = true;
            }
            z11 = false;
        } else {
            androidx.constraintlayout.core.widgets.d dVar6 = this.f38025a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dVar6.f11981b0[1];
            if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int iZ2 = dVar6.z() + iA0;
                this.f38025a.f11988f.f12055i.d(iZ2);
                this.f38025a.f11988f.f12051e.d(iZ2 - iA0);
                z11 = true;
            }
            z11 = false;
        }
        m();
        Iterator<WidgetRun> it2 = this.f38029e.iterator();
        while (it2.hasNext()) {
            WidgetRun next2 = it2.next();
            if (next2.f12052f == i10 && (next2.f12048b != this.f38025a || next2.f12053g)) {
                next2.e();
            }
        }
        Iterator<WidgetRun> it3 = this.f38029e.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z12 = true;
                break;
            }
            WidgetRun next3 = it3.next();
            if (next3.f12052f == i10 && (z11 || next3.f12048b != this.f38025a)) {
                if (!next3.f12054h.f12044j || !next3.f12055i.f12044j || (!(next3 instanceof C5035c) && !next3.f12051e.f12044j)) {
                    break;
                }
            }
        }
        this.f38025a.U0(dimensionBehaviourW);
        this.f38025a.l1(dimensionBehaviourW2);
        return z12;
    }

    public final void i(WidgetRun widgetRun, int i10, ArrayList<i> arrayList) {
        for (InterfaceC5036d interfaceC5036d : widgetRun.f12054h.f12045k) {
            if (interfaceC5036d instanceof DependencyNode) {
                a((DependencyNode) interfaceC5036d, i10, 0, widgetRun.f12055i, arrayList, null);
            } else if (interfaceC5036d instanceof WidgetRun) {
                a(((WidgetRun) interfaceC5036d).f12054h, i10, 0, widgetRun.f12055i, arrayList, null);
            }
        }
        for (InterfaceC5036d interfaceC5036d2 : widgetRun.f12055i.f12045k) {
            if (interfaceC5036d2 instanceof DependencyNode) {
                a((DependencyNode) interfaceC5036d2, i10, 1, widgetRun.f12054h, arrayList, null);
            } else if (interfaceC5036d2 instanceof WidgetRun) {
                a(((WidgetRun) interfaceC5036d2).f12055i, i10, 1, widgetRun.f12054h, arrayList, null);
            }
        }
        int i11 = i10;
        if (i11 == 1) {
            for (InterfaceC5036d interfaceC5036d3 : ((androidx.constraintlayout.core.widgets.analyzer.d) widgetRun).f12061k.f12045k) {
                if (interfaceC5036d3 instanceof DependencyNode) {
                    a((DependencyNode) interfaceC5036d3, i11, 2, null, arrayList, null);
                }
                i11 = i10;
            }
        }
    }

    public void j() {
        this.f38026b = true;
    }

    public void k() {
        this.f38027c = true;
    }

    public final void l(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        C5034b.a aVar = this.f38032h;
        aVar.f38013a = dimensionBehaviour;
        aVar.f38014b = dimensionBehaviour2;
        aVar.f38015c = i10;
        aVar.f38016d = i11;
        this.f38031g.b(constraintWidget, aVar);
        constraintWidget.p1(this.f38032h.f38017e);
        constraintWidget.Q0(this.f38032h.f38018f);
        constraintWidget.P0(this.f38032h.f38020h);
        constraintWidget.F0(this.f38032h.f38019g);
    }

    public void m() {
        C5037e c5037e;
        androidx.constraintlayout.core.widgets.analyzer.a aVar;
        Iterator<ConstraintWidget> it = this.f38025a.f37462V0.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.f11978a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.f11981b0;
                boolean z10 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i10 = next.f12022w;
                int i11 = next.f12024x;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z11 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i10 == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i11 == 1)) {
                    z10 = true;
                }
                androidx.constraintlayout.core.widgets.analyzer.a aVar2 = next.f11986e.f12051e;
                boolean z12 = aVar2.f12044j;
                androidx.constraintlayout.core.widgets.analyzer.a aVar3 = next.f11988f.f12051e;
                boolean z13 = aVar3.f12044j;
                if (z12 && z13) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    c5037e = this;
                    c5037e.l(next, dimensionBehaviour4, aVar2.f12041g, dimensionBehaviour4, aVar3.f12041g);
                    next.f11978a = true;
                } else if (z12 && z10) {
                    c5037e = this;
                    c5037e.l(next, ConstraintWidget.DimensionBehaviour.FIXED, aVar2.f12041g, dimensionBehaviour3, aVar3.f12041g);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.f11988f.f12051e.f12058m = next.z();
                    } else {
                        next.f11988f.f12051e.d(next.z());
                        next.f11978a = true;
                    }
                } else {
                    c5037e = this;
                    if (z13 && z11) {
                        c5037e.l(next, dimensionBehaviour3, aVar2.f12041g, ConstraintWidget.DimensionBehaviour.FIXED, aVar3.f12041g);
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            next.f11986e.f12051e.f12058m = next.Y();
                        } else {
                            next.f11986e.f12051e.d(next.Y());
                            next.f11978a = true;
                        }
                    }
                }
                if (next.f11978a && (aVar = next.f11988f.f12062l) != null) {
                    aVar.d(next.r());
                }
                this = c5037e;
            }
        }
    }

    public void n(C5034b.InterfaceC0492b interfaceC0492b) {
        this.f38031g = interfaceC0492b;
    }
}
