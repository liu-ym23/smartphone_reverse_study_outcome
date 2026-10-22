package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: loaded from: classes17.dex */
public class VirtualLayout extends HelperWidget {
    protected BasicMeasure.Measure mMeasure;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    BasicMeasure.Measurer mMeasurer;
    private boolean mNeedsCallFromSolver;
    private int mPaddingBottom;
    private int mPaddingEnd;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingStart;
    private int mPaddingTop;
    private int mResolvedPaddingLeft;
    private int mResolvedPaddingRight;

    public void captureWidgets() {
        int r100 = 0;
    L4:
        if (r100 >= this.mWidgetsCount) goto L9;
        ConstraintWidget r101 = this.mWidgets[r100];
        if (r101 == null) goto L8;
        r101.setInVirtualLayout(true);
    L8:
        r100 = r100 + 1;
        goto L4
    }

    public void measure(int r100, int r101, int r102, int r103) {
    }

    public boolean measureChildren() {
        ConstraintWidget r100 = this.mParent;
        if (r100 == null) goto L5;
        BasicMeasure.Measurer r101 = ((ConstraintWidgetContainer) r100).getMeasurer();
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        int r102 = 0;
    L10:
        boolean r103 = true;
        if (r102 >= this.mWidgetsCount) goto L35;
        ConstraintWidget r104 = this.mWidgets[r102];
        if (r104 == null) goto L34;
        if ((r104 instanceof Guideline) == true) goto L34;
        ConstraintWidget.DimensionBehaviour r105 = r104.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r106 = r104.getDimensionBehaviour(1);
        ConstraintWidget.DimensionBehaviour r107 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r105 == r107) goto L21;
    L26:
        r103 = false;
    L27:
        if (r103 == true) goto L34;
        if (r105 != r107) goto L31;
        r105 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L31:
        if (r106 != r107) goto L33;
        r106 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L33:
        BasicMeasure.Measure r108 = this.mMeasure;
        r108.horizontalBehavior = r105;
        r108.verticalBehavior = r106;
        r108.horizontalDimension = r104.getWidth();
        BasicMeasure.Measure r109 = this.mMeasure;
        r109.verticalDimension = r104.getHeight();
        r101.measure(r104, this.mMeasure);
        r104.setWidth(this.mMeasure.measuredWidth);
        r104.setHeight(this.mMeasure.measuredHeight);
        r104.setBaselineDistance(this.mMeasure.measuredBaseline);
        goto L34
    L21:
        if (r104.mMatchConstraintDefaultWidth == 1) goto L26;
        if (r106 != r107) goto L26;
        if (r104.mMatchConstraintDefaultHeight == 1) goto L26;
    L34:
        r102 = r102 + 1;
        goto L10
    L35:
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public VirtualLayout() {
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingStart = 0;
        this.mPaddingEnd = 0;
        this.mResolvedPaddingLeft = 0;
        this.mResolvedPaddingRight = 0;
        this.mNeedsCallFromSolver = false;
        this.mMeasuredWidth = 0;
        this.mMeasuredHeight = 0;
        this.mMeasure = new BasicMeasure.Measure();
        this.mMeasurer = null;
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mResolvedPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mResolvedPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public boolean needSolverPass() {
        return this.mNeedsCallFromSolver;
    }

    public void applyRtl(boolean r100) {
        int r101 = this.mPaddingStart;
        if (r101 <= 0) goto L5;
    L6:
        if (r100 == false) goto L8;
        this.mResolvedPaddingLeft = this.mPaddingEnd;
        this.mResolvedPaddingRight = r101;
        return;
    L8:
        this.mResolvedPaddingLeft = r101;
        this.mResolvedPaddingRight = this.mPaddingEnd;
        return;
    L5:
        if (this.mPaddingEnd > 0) goto L6;
    }

    public void needsCallbackFromSolver(boolean r100) {
        this.mNeedsCallFromSolver = r100;
    }

    public void setPadding(int r100) {
        this.mPaddingLeft = r100;
        this.mPaddingTop = r100;
        this.mPaddingRight = r100;
        this.mPaddingBottom = r100;
        this.mPaddingStart = r100;
        this.mPaddingEnd = r100;
    }

    public void setPaddingBottom(int r100) {
        this.mPaddingBottom = r100;
    }

    public void setPaddingEnd(int r100) {
        this.mPaddingEnd = r100;
    }

    public void setPaddingLeft(int r100) {
        this.mPaddingLeft = r100;
        this.mResolvedPaddingLeft = r100;
    }

    public void setPaddingRight(int r100) {
        this.mPaddingRight = r100;
        this.mResolvedPaddingRight = r100;
    }

    public void setPaddingStart(int r100) {
        this.mPaddingStart = r100;
        this.mResolvedPaddingLeft = r100;
        this.mResolvedPaddingRight = r100;
    }

    public void setPaddingTop(int r100) {
        this.mPaddingTop = r100;
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer r100) {
        captureWidgets();
    }

    public void setMeasure(int r100, int r101) {
        this.mMeasuredWidth = r100;
        this.mMeasuredHeight = r101;
    }

    public void measure(ConstraintWidget r100, ConstraintWidget.DimensionBehaviour r101, int r102, ConstraintWidget.DimensionBehaviour r103, int r104) {
    L3:
        if (this.mMeasurer != null) goto L7;
        if (getParent() == null) goto L7;
        this.mMeasurer = ((ConstraintWidgetContainer) getParent()).getMeasurer();
    L7:
        BasicMeasure.Measure r105 = this.mMeasure;
        r105.horizontalBehavior = r101;
        r105.verticalBehavior = r103;
        r105.horizontalDimension = r102;
        r105.verticalDimension = r104;
        this.mMeasurer.measure(r100, r105);
        r100.setWidth(this.mMeasure.measuredWidth);
        r100.setHeight(this.mMeasure.measuredHeight);
        r100.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r100.setBaselineDistance(this.mMeasure.measuredBaseline);
    }
}
