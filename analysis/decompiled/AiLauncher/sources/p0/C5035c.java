package p0;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: p0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5035c extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public ArrayList<WidgetRun> f38023k;

    /* renamed from: l, reason: collision with root package name */
    public int f38024l;

    public C5035c(ConstraintWidget constraintWidget, int i10) {
        super(constraintWidget);
        this.f38023k = new ArrayList<>();
        this.f12052f = i10;
        q();
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0160  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, p0.InterfaceC5036d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(p0.InterfaceC5036d r27) {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C5035c.a(p0.d):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        Iterator<WidgetRun> it = this.f38023k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f38023k.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.f38023k.get(0).f12048b;
        ConstraintWidget constraintWidget2 = this.f38023k.get(size - 1).f12048b;
        if (this.f12052f == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.f11964Q;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.f11968S;
            DependencyNode dependencyNodeI = i(constraintAnchor, 0);
            int iF = constraintAnchor.f();
            ConstraintWidget constraintWidgetR = r();
            if (constraintWidgetR != null) {
                iF = constraintWidgetR.f11964Q.f();
            }
            if (dependencyNodeI != null) {
                b(this.f12054h, dependencyNodeI, iF);
            }
            DependencyNode dependencyNodeI2 = i(constraintAnchor2, 0);
            int iF2 = constraintAnchor2.f();
            ConstraintWidget constraintWidgetS = s();
            if (constraintWidgetS != null) {
                iF2 = constraintWidgetS.f11968S.f();
            }
            if (dependencyNodeI2 != null) {
                b(this.f12055i, dependencyNodeI2, -iF2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.f11966R;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.f11970T;
            DependencyNode dependencyNodeI3 = i(constraintAnchor3, 1);
            int iF3 = constraintAnchor3.f();
            ConstraintWidget constraintWidgetR2 = r();
            if (constraintWidgetR2 != null) {
                iF3 = constraintWidgetR2.f11966R.f();
            }
            if (dependencyNodeI3 != null) {
                b(this.f12054h, dependencyNodeI3, iF3);
            }
            DependencyNode dependencyNodeI4 = i(constraintAnchor4, 1);
            int iF4 = constraintAnchor4.f();
            ConstraintWidget constraintWidgetS2 = s();
            if (constraintWidgetS2 != null) {
                iF4 = constraintWidgetS2.f11970T.f();
            }
            if (dependencyNodeI4 != null) {
                b(this.f12055i, dependencyNodeI4, -iF4);
            }
        }
        this.f12054h.f12035a = this;
        this.f12055i.f12035a = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        for (int i10 = 0; i10 < this.f38023k.size(); i10++) {
            this.f38023k.get(i10).e();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f12049c = null;
        Iterator<WidgetRun> it = this.f38023k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long j() {
        int size = this.f38023k.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            j10 = j10 + r4.f12054h.f12040f + this.f38023k.get(i10).j() + r4.f12055i.f12040f;
        }
        return j10;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        int size = this.f38023k.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f38023k.get(i10).m()) {
                return false;
            }
        }
        return true;
    }

    public final void q() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.f12048b;
        ConstraintWidget constraintWidgetN = constraintWidget2.N(this.f12052f);
        while (true) {
            ConstraintWidget constraintWidget3 = constraintWidgetN;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                constraintWidgetN = constraintWidget2.N(this.f12052f);
            }
        }
        this.f12048b = constraintWidget;
        this.f38023k.add(constraintWidget.P(this.f12052f));
        ConstraintWidget constraintWidgetL = constraintWidget.L(this.f12052f);
        while (constraintWidgetL != null) {
            this.f38023k.add(constraintWidgetL.P(this.f12052f));
            constraintWidgetL = constraintWidgetL.L(this.f12052f);
        }
        Iterator<WidgetRun> it = this.f38023k.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int i10 = this.f12052f;
            if (i10 == 0) {
                next.f12048b.f11982c = this;
            } else if (i10 == 1) {
                next.f12048b.f11984d = this;
            }
        }
        if (this.f12052f == 0 && ((androidx.constraintlayout.core.widgets.d) this.f12048b.M()).V1() && this.f38023k.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.f38023k;
            this.f12048b = arrayList.get(arrayList.size() - 1).f12048b;
        }
        this.f38024l = this.f12052f == 0 ? this.f12048b.B() : this.f12048b.U();
    }

    public final ConstraintWidget r() {
        for (int i10 = 0; i10 < this.f38023k.size(); i10++) {
            WidgetRun widgetRun = this.f38023k.get(i10);
            if (widgetRun.f12048b.X() != 8) {
                return widgetRun.f12048b;
            }
        }
        return null;
    }

    public final ConstraintWidget s() {
        for (int size = this.f38023k.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.f38023k.get(size);
            if (widgetRun.f12048b.X() != 8) {
                return widgetRun.f12048b;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f12052f == 0 ? "horizontal : " : "vertical : ");
        Iterator<WidgetRun> it = this.f38023k.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            sb2.append("<");
            sb2.append(next);
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
