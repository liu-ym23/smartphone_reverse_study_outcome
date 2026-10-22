package o0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import l0.C4855a;

/* renamed from: o0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C4995c extends ConstraintWidget {

    /* renamed from: V0, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f37462V0 = new ArrayList<>();

    public void a(ConstraintWidget constraintWidget) {
        this.f37462V0.add(constraintWidget);
        if (constraintWidget.M() != null) {
            ((C4995c) constraintWidget.M()).y1(constraintWidget);
        }
        constraintWidget.h1(this);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void v0() {
        this.f37462V0.clear();
        super.v0();
    }

    public ArrayList<ConstraintWidget> w1() {
        return this.f37462V0;
    }

    public void x1() {
        ArrayList<ConstraintWidget> arrayList = this.f37462V0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.f37462V0.get(i10);
            if (constraintWidget instanceof C4995c) {
                ((C4995c) constraintWidget).x1();
            }
        }
    }

    public void y1(ConstraintWidget constraintWidget) {
        this.f37462V0.remove(constraintWidget);
        constraintWidget.v0();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void z0(C4855a c4855a) {
        super.z0(c4855a);
        int size = this.f37462V0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f37462V0.get(i10).z0(c4855a);
        }
    }

    public void z1() {
        this.f37462V0.clear();
    }
}
