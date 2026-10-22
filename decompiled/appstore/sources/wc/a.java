package wc;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.Helper;
import com.obric.oui.constraintlayout.core.widgets.analyzer.f;
import com.obric.oui.constraintlayout.core.widgets.analyzer.l;
import com.obric.oui.constraintlayout.core.widgets.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class a extends ConstraintWidget implements Helper {
    public ConstraintWidget[] V0;
    public int W0;

    public a() {
        this.V0 = new ConstraintWidget[4];
        this.W0 = 0;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.Helper
    public void add(ConstraintWidget r10) {
        if (r10 == this) goto L10;
        if (r10 == null) goto L11;
        int r11 = this.W0 + 1;
        ConstraintWidget[] r12 = this.V0;
        if (r11 <= r12.length) goto L8;
        this.V0 = (ConstraintWidget[]) Arrays.copyOf(r12, r12.length * 2);
    L8:
        ConstraintWidget[] r13 = this.V0;
        int r14 = this.W0;
        r13[r14] = r10;
        this.W0 = r14 + 1;
        return;
    L11:
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void k(ConstraintWidget r10, HashMap r11) {
        super.k(r10, r11);
        a r12 = (a) r10;
        int r13 = 0;
        this.W0 = 0;
        int r14 = r12.W0;
    L3:
        if (r13 >= r14) goto L5;
        add((ConstraintWidget) r11.get(r12.V0[r13]));
        r13 = r13 + 1;
        goto L3
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.Helper
    public void removeAllIds() {
        this.W0 = 0;
        Arrays.fill(this.V0, null);
    }

    public void t1(ArrayList r10, int r11, l r12) {
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r14 >= this.W0) goto L7;
        r12.a(this.V0[r14]);
        r14 = r14 + 1;
    L7:
        if (r13 >= this.W0) goto L9;
        f.a(this.V0[r13], r11, r10, r12);
        r13 = r13 + 1;
        goto L7
    }

    public int u1(int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.W0) goto L16;
        ConstraintWidget r12 = this.V0[r11];
        if (r10 != 0) goto L11;
        int r13 = r12.S0;
        if (r13 == (-1)) goto L11;
        return r13;
    L11:
        if (r10 != 1) goto L15;
        int r14 = r12.T0;
        if (r14 == (-1)) goto L15;
        return r14;
    L15:
        r11 = r11 + 1;
        goto L4
    L16:
        return -1;
    }

    public void updateConstraints(d r10) {
    }
}
