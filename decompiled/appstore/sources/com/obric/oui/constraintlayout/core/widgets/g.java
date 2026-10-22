package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.LinearSystem;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean[] f13473a;

    static {
        f13473a = new boolean[3];
    }

    public static void a(d r10, LinearSystem r11, ConstraintWidget r12) {
        r12.f13289t = -1;
        r12.f13291u = -1;
        ConstraintWidget.DimensionBehaviour r13 = r10.f13254b0[0];
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r13 == r14) goto L8;
        if (r12.f13254b0[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L8;
        int r15 = r12.Q.f13246g;
        int r16 = r10.V() - r12.S.f13246g;
        ConstraintAnchor r17 = r12.Q;
        r17.f13248i = r11.q(r17);
        ConstraintAnchor r18 = r12.S;
        r18.f13248i = r11.q(r18);
        r11.f(r12.Q.f13248i, r15);
        r11.f(r12.S.f13248i, r16);
        r12.f13289t = 2;
        r12.Q0(r15, r16);
    L8:
        if (r10.f13254b0[1] != r14) goto L10;
        return;
    L10:
        if (r12.f13254b0[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L19;
        int r19 = r12.R.f13246g;
        int r20 = r10.w() - r12.T.f13246g;
        ConstraintAnchor r21 = r12.R;
        r21.f13248i = r11.q(r21);
        ConstraintAnchor r22 = r12.T;
        r22.f13248i = r11.q(r22);
        r11.f(r12.R.f13248i, r19);
        r11.f(r12.T.f13248i, r20);
        if (r12.f13278n0 <= 0) goto L14;
    L15:
        ConstraintAnchor r23 = r12.U;
        r23.f13248i = r11.q(r23);
        r11.f(r12.U.f13248i, r12.f13278n0 + r19);
    L16:
        r12.f13291u = 2;
        r12.h1(r19, r20);
        return;
    L14:
        if (r12.U() != 8) goto L16;
    }

    public static final boolean b(int r10, int r11) {
        if ((r10 & r11) != r11) goto L5;
        return true;
    L5:
        return false;
    }
}
