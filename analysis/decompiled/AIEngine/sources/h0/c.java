package h0;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList<WidgetRun> f9187k;

    /* renamed from: l, reason: collision with root package name */
    public int f9188l;

    public c(ConstraintWidget constraintWidget, int i10) {
        ConstraintWidget constraintWidget2;
        super(constraintWidget);
        ArrayList<WidgetRun> arrayList = new ArrayList<>();
        this.f9187k = arrayList;
        this.f1169f = i10;
        ConstraintWidget constraintWidget3 = this.f1165b;
        ConstraintWidget constraintWidgetM = constraintWidget3.m(i10);
        while (true) {
            constraintWidget2 = constraintWidget3;
            constraintWidget3 = constraintWidgetM;
            if (constraintWidget3 == null) {
                break;
            } else {
                constraintWidgetM = constraintWidget3.m(this.f1169f);
            }
        }
        this.f1165b = constraintWidget2;
        int i11 = this.f1169f;
        arrayList.add(i11 == 0 ? constraintWidget2.f1103d : i11 == 1 ? constraintWidget2.f1105e : null);
        ConstraintWidget constraintWidgetL = constraintWidget2.l(this.f1169f);
        while (constraintWidgetL != null) {
            int i12 = this.f1169f;
            arrayList.add(i12 == 0 ? constraintWidgetL.f1103d : i12 == 1 ? constraintWidgetL.f1105e : null);
            constraintWidgetL = constraintWidgetL.l(this.f1169f);
        }
        int size = arrayList.size();
        int i13 = 0;
        while (i13 < size) {
            WidgetRun widgetRun = arrayList.get(i13);
            i13++;
            WidgetRun widgetRun2 = widgetRun;
            int i14 = this.f1169f;
            if (i14 == 0) {
                widgetRun2.f1165b.f1101b = this;
            } else if (i14 == 1) {
                widgetRun2.f1165b.f1102c = this;
            }
        }
        if (this.f1169f == 0 && ((androidx.constraintlayout.core.widgets.d) this.f1165b.V).f1200w0 && arrayList.size() > 1) {
            this.f1165b = arrayList.get(arrayList.size() - 1).f1165b;
        }
        this.f9188l = this.f1169f == 0 ? this.f1165b.f1117k0 : this.f1165b.f1119l0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e2  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, h0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(h0.d r28) {
        /*
            Method dump skipped, instructions count: 947
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.c.a(h0.d):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        ArrayList<WidgetRun> arrayList = this.f9187k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            WidgetRun widgetRun = arrayList.get(i10);
            i10++;
            widgetRun.d();
        }
        int size2 = arrayList.size();
        if (size2 < 1) {
            return;
        }
        ConstraintWidget constraintWidget = arrayList.get(0).f1165b;
        ConstraintWidget constraintWidget2 = arrayList.get(size2 - 1).f1165b;
        int i11 = this.f1169f;
        DependencyNode dependencyNode = this.f1171i;
        DependencyNode dependencyNode2 = this.h;
        if (i11 == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.J;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.L;
            DependencyNode dependencyNodeI = WidgetRun.i(constraintAnchor, 0);
            int iE = constraintAnchor.e();
            ConstraintWidget constraintWidgetM = m();
            if (constraintWidgetM != null) {
                iE = constraintWidgetM.J.e();
            }
            if (dependencyNodeI != null) {
                WidgetRun.b(dependencyNode2, dependencyNodeI, iE);
            }
            DependencyNode dependencyNodeI2 = WidgetRun.i(constraintAnchor2, 0);
            int iE2 = constraintAnchor2.e();
            ConstraintWidget constraintWidgetN = n();
            if (constraintWidgetN != null) {
                iE2 = constraintWidgetN.L.e();
            }
            if (dependencyNodeI2 != null) {
                WidgetRun.b(dependencyNode, dependencyNodeI2, -iE2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.K;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.M;
            DependencyNode dependencyNodeI3 = WidgetRun.i(constraintAnchor3, 1);
            int iE3 = constraintAnchor3.e();
            ConstraintWidget constraintWidgetM2 = m();
            if (constraintWidgetM2 != null) {
                iE3 = constraintWidgetM2.K.e();
            }
            if (dependencyNodeI3 != null) {
                WidgetRun.b(dependencyNode2, dependencyNodeI3, iE3);
            }
            DependencyNode dependencyNodeI4 = WidgetRun.i(constraintAnchor4, 1);
            int iE4 = constraintAnchor4.e();
            ConstraintWidget constraintWidgetN2 = n();
            if (constraintWidgetN2 != null) {
                iE4 = constraintWidgetN2.M.e();
            }
            if (dependencyNodeI4 != null) {
                WidgetRun.b(dependencyNode, dependencyNodeI4, -iE4);
            }
        }
        dependencyNode2.f1145a = this;
        dependencyNode.f1145a = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        int i10 = 0;
        while (true) {
            ArrayList<WidgetRun> arrayList = this.f9187k;
            if (i10 >= arrayList.size()) {
                return;
            }
            arrayList.get(i10).e();
            i10++;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void f() {
        this.f1166c = null;
        ArrayList<WidgetRun> arrayList = this.f9187k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            WidgetRun widgetRun = arrayList.get(i10);
            i10++;
            widgetRun.f();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final long j() {
        ArrayList<WidgetRun> arrayList = this.f9187k;
        int size = arrayList.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            j10 = r4.f1171i.f1150f + arrayList.get(i10).j() + j10 + r4.h.f1150f;
        }
        return j10;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean k() {
        ArrayList<WidgetRun> arrayList = this.f9187k;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!arrayList.get(i10).k()) {
                return false;
            }
        }
        return true;
    }

    public final ConstraintWidget m() {
        int i10 = 0;
        while (true) {
            ArrayList<WidgetRun> arrayList = this.f9187k;
            if (i10 >= arrayList.size()) {
                return null;
            }
            ConstraintWidget constraintWidget = arrayList.get(i10).f1165b;
            if (constraintWidget.f1113i0 != 8) {
                return constraintWidget;
            }
            i10++;
        }
    }

    public final ConstraintWidget n() {
        ArrayList<WidgetRun> arrayList = this.f9187k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ConstraintWidget constraintWidget = arrayList.get(size).f1165b;
            if (constraintWidget.f1113i0 != 8) {
                return constraintWidget;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f1169f == 0 ? "horizontal : " : "vertical : ");
        ArrayList<WidgetRun> arrayList = this.f9187k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            WidgetRun widgetRun = arrayList.get(i10);
            i10++;
            sb2.append("<");
            sb2.append(widgetRun);
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
