package wc;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends ConstraintWidget {
    public ArrayList V0;

    public b() {
        this.V0 = new ArrayList();
    }

    public void add(ConstraintWidget r10) {
        this.V0.add(r10);
        if (r10.J() == null) goto L5;
        ((b) r10.J()).v1(r10);
    L5:
        r10.e1(this);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void s0() {
        this.V0.clear();
        super.s0();
    }

    public ArrayList t1() {
        return this.V0;
    }

    public abstract void u1();

    public void v1(ConstraintWidget r10) {
        this.V0.remove(r10);
        r10.s0();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void w0(com.obric.oui.constraintlayout.core.b r10) {
        super.w0(r10);
        int r11 = this.V0.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((ConstraintWidget) this.V0.get(r12)).w0(r10);
        r12 = r12 + 1;
        goto L3
    }

    public void w1() {
        this.V0.clear();
    }
}
