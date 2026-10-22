package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean[] f1655a;

    static {
        f1655a = new boolean[3];
    }

    public static void a(ConstraintWidgetContainer r10, LinearSystem r11, ConstraintWidget r12) {
        r12.f1470t = -1;
        r12.f1472u = -1;
        ConstraintWidget.DimensionBehaviour r13 = r10.f1435b0[0];
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r13 == r14) goto L8;
        if (r12.f1435b0[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L8;
        int r15 = r12.Q.f1427g;
        int r16 = r10.V() - r12.S.f1427g;
        ConstraintAnchor r17 = r12.Q;
        r17.f1429i = r11.q(r17);
        ConstraintAnchor r18 = r12.S;
        r18.f1429i = r11.q(r18);
        r11.f(r12.Q.f1429i, r15);
        r11.f(r12.S.f1429i, r16);
        r12.f1470t = 2;
        r12.P0(r15, r16);
    L8:
        if (r10.f1435b0[1] != r14) goto L10;
        return;
    L10:
        if (r12.f1435b0[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L19;
        int r19 = r12.R.f1427g;
        int r20 = r10.w() - r12.T.f1427g;
        ConstraintAnchor r21 = r12.R;
        r21.f1429i = r11.q(r21);
        ConstraintAnchor r22 = r12.T;
        r22.f1429i = r11.q(r22);
        r11.f(r12.R.f1429i, r19);
        r11.f(r12.T.f1429i, r20);
        if (r12.f1459n0 <= 0) goto L14;
    L15:
        ConstraintAnchor r23 = r12.U;
        r23.f1429i = r11.q(r23);
        r11.f(r12.U.f1429i, r12.f1459n0 + r19);
    L16:
        r12.f1472u = 2;
        r12.g1(r19, r20);
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
