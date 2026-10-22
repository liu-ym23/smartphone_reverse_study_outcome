package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import com.alipay.sdk.m.u.i;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private boolean mAllowsGoneWidget;
    private int mBarrierType;
    private int mMargin;
    boolean resolved;

    public boolean allSolved() {
        int r100 = 0;
        int r101 = 0;
        boolean r102 = true;
    L3:
        int r103 = this.mWidgetsCount;
        if (r101 >= r103) goto L23;
        ConstraintWidget r104 = this.mWidgets[r101];
        if (this.mAllowsGoneWidget == false) goto L8;
    L10:
        int r105 = this.mBarrierType;
        if (r105 == 0) goto L14;
        if (r105 == 1) goto L14;
    L16:
        int r106 = this.mBarrierType;
        if (r106 == 2) goto L20;
        if (r106 == 3) goto L20;
    L22:
        r101 = r101 + 1;
    L20:
        if (r104.isResolvedVertically() == true) goto L22;
    L15:
        r102 = false;
    L14:
        if (r104.isResolvedHorizontally() == true) goto L16;
    L8:
        if (r104.allowedInBarrier() == true) goto L10;
    L23:
        if (r102 == false) goto L62;
        if (r103 <= 0) goto L62;
        int r107 = 0;
        boolean r108 = false;
    L27:
        if (r100 >= this.mWidgetsCount) goto L54;
        ConstraintWidget r109 = this.mWidgets[r100];
        if (this.mAllowsGoneWidget == false) goto L31;
    L33:
        if (r108 == true) goto L44;
        int r110 = this.mBarrierType;
        if (r110 != 0) goto L37;
        r107 = r109.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
    L43:
        r108 = true;
        goto L44
    L37:
        if (r110 != 1) goto L39;
        r107 = r109.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
        goto L43
    L39:
        if (r110 != 2) goto L41;
        r107 = r109.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
        goto L43
    L41:
        if (r110 != 3) goto L43;
        r107 = r109.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
    L44:
        int r111 = this.mBarrierType;
        if (r111 != 0) goto L47;
        r107 = Math.min(r107, r109.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
    L53:
        r100 = r100 + 1;
        goto L27
    L47:
        if (r111 != 1) goto L49;
        r107 = Math.max(r107, r109.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
        goto L53
    L49:
        if (r111 != 2) goto L51;
        r107 = Math.min(r107, r109.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
        goto L53
    L51:
        if (r111 != 3) goto L53;
        r107 = Math.max(r107, r109.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
        goto L53
    L31:
        if (r109.allowedInBarrier() == true) goto L33;
    L54:
        int r112 = r107 + this.mMargin;
        int r113 = this.mBarrierType;
        if (r113 == 0) goto L59;
        if (r113 == 1) goto L59;
        setFinalVertical(r112, r112);
    L60:
        this.resolved = true;
        return true;
    L59:
        setFinalHorizontal(r112, r112);
    L62:
        return false;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    public void markWidgets() {
        int r100 = 0;
    L4:
        if (r100 >= this.mWidgetsCount) goto L16;
        ConstraintWidget r101 = this.mWidgets[r100];
        int r102 = this.mBarrierType;
        if (r102 == 0) goto L14;
        if (r102 == 1) goto L14;
        if (r102 != 2) goto L12;
    L13:
        r101.setInBarrier(1, true);
    L15:
        r100 = r100 + 1;
        goto L4
    L12:
        if (r102 != 3) goto L15;
    L14:
        r101.setInBarrier(0, true);
        goto L15
    }

    public int getOrientation() {
        int r100 = this.mBarrierType;
        if (r100 != 0) goto L5;
        return 0;
    L5:
        if (r100 != 1) goto L7;
        return 0;
    L7:
        if (r100 != 2) goto L9;
    L12:
        return 1;
    L9:
        if (r100 == 3) goto L12;
        return -1;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String toString() {
        String r100 = "[Barrier] " + getDebugName() + " {";
        int r101 = 0;
    L4:
        if (r101 >= this.mWidgetsCount) goto L10;
        ConstraintWidget r102 = this.mWidgets[r101];
        if (r101 <= 0) goto L8;
        r100 = r100 + ", ";
    L8:
        r100 = r100 + r102.getDebugName();
        r101 = r101 + 1;
        goto L4
    L10:
        return r100 + i.f25855d;
    }

    public Barrier() {
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
        this.resolved = false;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.resolved;
    }

    public Barrier(String r100) {
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
        this.resolved = false;
        setDebugName(r100);
    }

    public void setAllowsGoneWidget(boolean r100) {
        this.mAllowsGoneWidget = r100;
    }

    public void setBarrierType(int r100) {
        this.mBarrierType = r100;
    }

    public void setMargin(int r100) {
        this.mMargin = r100;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r110, boolean r111) {
        ConstraintAnchor[] r112 = this.mListAnchors;
        r112[0] = this.mLeft;
        r112[2] = this.mTop;
        r112[1] = this.mRight;
        r112[3] = this.mBottom;
        int r113 = 0;
    L3:
        ConstraintAnchor[] r100 = this.mListAnchors;
        if (r113 >= r100.length) goto L6;
        ConstraintAnchor r101 = r100[r113];
        r101.mSolverVariable = r110.createObjectVariable(r101);
        r113 = r113 + 1;
        goto L3
    L6:
        int r114 = this.mBarrierType;
        if (r114 >= 0) goto L9;
        return;
    L9:
        if (r114 >= 4) goto L129;
        ConstraintAnchor r115 = r100[r114];
        if (this.resolved == true) goto L14;
        allSolved();
    L14:
        if (this.resolved == false) goto L24;
        this.resolved = false;
        int r116 = this.mBarrierType;
        if (r116 == 0) goto L22;
        if (r116 == 1) goto L22;
        if (r116 == 2) goto L21;
        if (r116 == 3) goto L21;
        return;
    L21:
        r110.addEquality(this.mTop.mSolverVariable, this.mY);
        r110.addEquality(this.mBottom.mSolverVariable, this.mY);
        return;
    L22:
        r110.addEquality(this.mLeft.mSolverVariable, this.mX);
        r110.addEquality(this.mRight.mSolverVariable, this.mX);
        return;
    L24:
        int r102 = 0;
    L26:
        if (r102 >= this.mWidgetsCount) goto L53;
        ConstraintWidget r103 = this.mWidgets[r102];
        if (this.mAllowsGoneWidget == false) goto L30;
    L32:
        int r104 = this.mBarrierType;
        if (r104 == 0) goto L36;
        if (r104 == 1) goto L36;
    L42:
        int r105 = this.mBarrierType;
        if (r105 == 2) goto L46;
        if (r105 == 3) goto L46;
    L52:
        r102 = r102 + 1;
    L46:
        if (r103.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L52;
        if (r103.mTop.mTarget == null) goto L52;
        if (r103.mBottom.mTarget == null) goto L52;
    L41:
        boolean r106 = true;
    L55:
        if (this.mLeft.hasCenteredDependents() == false) goto L57;
    L60:
        boolean r107 = true;
    L62:
        if (this.mTop.hasCenteredDependents() == false) goto L64;
    L67:
        boolean r108 = true;
    L68:
        if (r106 == true) goto L79;
        int r109 = this.mBarrierType;
        if (r109 != 0) goto L72;
        if (r107 == false) goto L72;
    L78:
        boolean r117 = true;
    L80:
        if (r117 == true) goto L82;
        int r118 = 4;
    L83:
        int r119 = 0;
    L85:
        if (r119 >= this.mWidgetsCount) goto L104;
        ConstraintWidget r120 = this.mWidgets[r119];
        if (this.mAllowsGoneWidget == false) goto L89;
    L91:
        SolverVariable r121 = r110.createObjectVariable(r120.mListAnchors[this.mBarrierType]);
        ConstraintAnchor[] r122 = r120.mListAnchors;
        int r123 = this.mBarrierType;
        ConstraintAnchor r124 = r122[r123];
        r124.mSolverVariable = r121;
        ConstraintAnchor r125 = r124.mTarget;
        if (r125 != null) goto L94;
    L96:
        int r126 = 0;
    L97:
        if (r123 == 0) goto L101;
        if (r123 == 2) goto L101;
        r110.addGreaterBarrier(r115.mSolverVariable, r121, this.mMargin + r126, r106);
    L102:
        r110.addEquality(r115.mSolverVariable, r121, this.mMargin + r126, r118);
    L103:
        r119 = r119 + 1;
    L101:
        r110.addLowerBarrier(r115.mSolverVariable, r121, this.mMargin - r126, r106);
        goto L102
    L94:
        if (r125.mOwner != this) goto L96;
        r126 = r124.mMargin + 0;
        goto L97
    L89:
        if (r120.allowedInBarrier() == true) goto L91;
    L104:
        int r127 = this.mBarrierType;
        if (r127 != 0) goto L107;
        r110.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
        r110.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
        r110.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
        return;
    L107:
        if (r127 != 1) goto L109;
        r110.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
        r110.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
        r110.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        return;
    L109:
        if (r127 != 2) goto L111;
        r110.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
        r110.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
        r110.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        return;
    L111:
        if (r127 != 3) goto L133;
        r110.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
        r110.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
        r110.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
        return;
    L133:
        return;
    L82:
        r118 = 5;
    L72:
        if (r109 != 2) goto L74;
        if (r108 == true) goto L78;
    L74:
        if (r109 != 1) goto L76;
        if (r107 == true) goto L78;
    L76:
        if (r109 != 3) goto L79;
        if (r108 == true) goto L78;
    L79:
        r117 = false;
        goto L80
    L64:
        if (this.mBottom.hasCenteredDependents() == true) goto L67;
        r108 = false;
        goto L68
    L57:
        if (this.mRight.hasCenteredDependents() == true) goto L60;
        r107 = false;
    L36:
        if (r103.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L42;
        if (r103.mLeft.mTarget == null) goto L42;
        if (r103.mRight.mTarget == null) goto L42;
    L30:
        if (r103.allowedInBarrier() == true) goto L32;
    L53:
        r106 = false;
        goto L55
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget r100, HashMap<ConstraintWidget, ConstraintWidget> r101) {
        super.copy(r100, r101);
        Barrier r102 = (Barrier) r100;
        this.mBarrierType = r102.mBarrierType;
        this.mAllowsGoneWidget = r102.mAllowsGoneWidget;
        this.mMargin = r102.mMargin;
    }
}
