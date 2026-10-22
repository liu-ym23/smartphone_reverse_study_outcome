package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;

/* JADX INFO: loaded from: classes.dex */
public class g extends h {
    public g() {
    }

    @Override // androidx.constraintlayout.core.widgets.h
    public void D1(int r10, int r11, int r12, int r13) {
        int r14 = A1() + B1();
        int r15 = C1() + z1();
        boolean r16 = false;
        if (this.W0 <= 0) goto L5;
        r14 = r14 + this.V0[0].V();
        r15 = r15 + this.V0[0].w();
    L5:
        int r17 = Math.max(H(), r14);
        int r18 = Math.max(G(), r15);
        if (r10 == 1073741824) goto L13;
        if (r10 != Integer.MIN_VALUE) goto L10;
        r11 = Math.min(r17, r11);
        goto L13
    L10:
        if (r10 != 0) goto L12;
        r11 = r17;
        goto L13
    L12:
        r11 = 0;
    L13:
        if (r12 == 1073741824) goto L20;
        if (r12 != Integer.MIN_VALUE) goto L17;
        r13 = Math.min(r18, r13);
        goto L20
    L17:
        if (r12 != 0) goto L19;
        r13 = r18;
        goto L20
    L19:
        r13 = 0;
    L20:
        I1(r11, r13);
        l1(r11);
        M0(r13);
        if (this.W0 <= 0) goto L23;
        r16 = true;
    L23:
        H1(r16);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void d(LinearSystem r10, boolean r11) {
        super.d(r10, r11);
        if (this.W0 <= 0) goto L6;
        ConstraintWidget r12 = this.V0[0];
        r12.t0();
        ConstraintAnchor.Type r13 = ConstraintAnchor.Type.LEFT;
        r12.g(r13, this, r13);
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.RIGHT;
        r12.g(r14, this, r14);
        ConstraintAnchor.Type r15 = ConstraintAnchor.Type.TOP;
        r12.g(r15, this, r15);
        ConstraintAnchor.Type r16 = ConstraintAnchor.Type.BOTTOM;
        r12.g(r16, this, r16);
        return;
    }
}
