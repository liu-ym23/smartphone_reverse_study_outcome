package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ChainHead {
    private boolean mDefined;
    protected ConstraintWidget mFirst;
    protected ConstraintWidget mFirstMatchConstraintWidget;
    protected ConstraintWidget mFirstVisibleWidget;
    protected boolean mHasComplexMatchWeights;
    protected boolean mHasDefinedWeights;
    protected boolean mHasRatio;
    protected boolean mHasUndefinedWeights;
    protected ConstraintWidget mHead;
    private boolean mIsRtl;
    protected ConstraintWidget mLast;
    protected ConstraintWidget mLastMatchConstraintWidget;
    protected ConstraintWidget mLastVisibleWidget;
    boolean mOptimizable;
    private int mOrientation;
    int mTotalMargins;
    int mTotalSize;
    protected float mTotalWeight;
    int mVisibleWidgets;
    protected ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
    protected int mWidgetsCount;
    protected int mWidgetsMatchCount;

    private void defineChainProperties() {
        int r100 = this.mOrientation * 2;
        ConstraintWidget r101 = this.mFirst;
        boolean r102 = true;
        this.mOptimizable = true;
        ConstraintWidget r103 = r101;
        boolean r104 = false;
    L3:
        if (r104 == true) goto L74;
        this.mWidgetsCount++;
        ConstraintWidget[] r105 = r101.mNextChainWidget;
        int r106 = this.mOrientation;
        ConstraintWidget r107 = null;
        r105[r106] = null;
        r101.mListNextMatchConstraintsWidget[r106] = null;
        if (r101.getVisibility() == 8) goto L60;
        this.mVisibleWidgets++;
        ConstraintWidget.DimensionBehaviour r108 = r101.getDimensionBehaviour(this.mOrientation);
        ConstraintWidget.DimensionBehaviour r109 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r108 == r109) goto L9;
        this.mTotalSize += r101.getLength(this.mOrientation);
    L9:
        int r110 = this.mTotalSize + r101.mListAnchors[r100].getMargin();
        this.mTotalSize = r110;
        int r111 = r100 + 1;
        this.mTotalSize = r110 + r101.mListAnchors[r111].getMargin();
        int r112 = this.mTotalMargins + r101.mListAnchors[r100].getMargin();
        this.mTotalMargins = r112;
        this.mTotalMargins = r112 + r101.mListAnchors[r111].getMargin();
        if (this.mFirstVisibleWidget != null) goto L12;
        this.mFirstVisibleWidget = r101;
    L12:
        this.mLastVisibleWidget = r101;
        ConstraintWidget.DimensionBehaviour[] r113 = r101.mListDimensionBehaviors;
        int r114 = this.mOrientation;
        if (r113[r114] != r109) goto L60;
        int r115 = r101.mResolvedMatchConstraintDefault[r114];
        if (r115 != 0) goto L17;
    L19:
        this.mWidgetsMatchCount++;
        float r116 = r101.mWeight[r114];
        if (r116 <= 0.0f) goto L23;
        this.mTotalWeight += r116;
    L23:
        if (isMatchConstraintEqualityCandidate(r101, r114) == false) goto L33;
        if (r116 >= 0.0f) goto L27;
        this.mHasUndefinedWeights = true;
    L29:
        if (this.mWeightedMatchConstraintsWidgets != null) goto L31;
        this.mWeightedMatchConstraintsWidgets = new ArrayList();
    L31:
        this.mWeightedMatchConstraintsWidgets.add(r101);
        goto L33
    L27:
        this.mHasDefinedWeights = true;
    L33:
        if (this.mFirstMatchConstraintWidget != null) goto L35;
        this.mFirstMatchConstraintWidget = r101;
    L35:
        ConstraintWidget r117 = this.mLastMatchConstraintWidget;
        if (r117 == null) goto L38;
        r117.mListNextMatchConstraintsWidget[this.mOrientation] = r101;
    L38:
        this.mLastMatchConstraintWidget = r101;
    L40:
        if (this.mOrientation != 0) goto L50;
        if (r101.mMatchConstraintDefaultWidth == 0) goto L45;
        this.mOptimizable = false;
    L58:
        if (r101.mDimensionRatio == 0.0f) goto L60;
        this.mOptimizable = false;
        this.mHasRatio = true;
        goto L60
    L45:
        if (r101.mMatchConstraintMinWidth == 0) goto L47;
    L48:
        this.mOptimizable = false;
        goto L58
    L47:
        if (r101.mMatchConstraintMaxWidth == 0) goto L58;
    L50:
        if (r101.mMatchConstraintDefaultHeight == 0) goto L53;
        this.mOptimizable = false;
        goto L58
    L53:
        if (r101.mMatchConstraintMinHeight == 0) goto L55;
    L56:
        this.mOptimizable = false;
        goto L58
    L55:
        if (r101.mMatchConstraintMaxHeight == 0) goto L58;
    L17:
        if (r115 == 3) goto L19;
        if (r115 != 2) goto L40;
    L60:
        if (r103 == r101) goto L62;
        r103.mNextChainWidget[this.mOrientation] = r101;
    L62:
        ConstraintAnchor r118 = r101.mListAnchors[r100 + 1].mTarget;
        if (r118 == null) goto L70;
        ConstraintWidget r119 = r118.mOwner;
        ConstraintAnchor r120 = r119.mListAnchors[r100].mTarget;
        if (r120 == null) goto L70;
        if (r120.mOwner != r101) goto L70;
        r107 = r119;
    L70:
        if (r107 != null) goto L73;
        r107 = r101;
        r104 = true;
    L73:
        r103 = r101;
        r101 = r107;
        goto L3
    L74:
        ConstraintWidget r121 = this.mFirstVisibleWidget;
        if (r121 == null) goto L77;
        this.mTotalSize -= r121.mListAnchors[r100].getMargin();
    L77:
        ConstraintWidget r122 = this.mLastVisibleWidget;
        if (r122 == null) goto L80;
        this.mTotalSize -= r122.mListAnchors[r100 + 1].getMargin();
    L80:
        this.mLast = r101;
        if (this.mOrientation == 0) goto L83;
    L85:
        this.mHead = this.mFirst;
    L87:
        if (this.mHasDefinedWeights == true) goto L89;
    L91:
        r102 = false;
    L92:
        this.mHasComplexMatchWeights = r102;
        return;
    L89:
        if (this.mHasUndefinedWeights == false) goto L91;
    L83:
        if (this.mIsRtl == false) goto L85;
        this.mHead = r101;
        goto L87
    }

    public void define() {
        if (this.mDefined == true) goto L5;
        defineChainProperties();
    L5:
        this.mDefined = true;
    }

    public ConstraintWidget getFirst() {
        return this.mFirst;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.mFirstMatchConstraintWidget;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.mFirstVisibleWidget;
    }

    public ConstraintWidget getHead() {
        return this.mHead;
    }

    public ConstraintWidget getLast() {
        return this.mLast;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.mLastMatchConstraintWidget;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.mLastVisibleWidget;
    }

    public float getTotalWeight() {
        return this.mTotalWeight;
    }

    private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget r100, int r101) {
        if (r100.getVisibility() != 8) goto L5;
    L11:
        return false;
    L5:
        if (r100.mListDimensionBehaviors[r101] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L11;
        int r102 = r100.mResolvedMatchConstraintDefault[r101];
        if (r102 != 0) goto L9;
    L10:
        return true;
    L9:
        if (r102 != 3) goto L11;
        goto L10
    }

    public ChainHead(ConstraintWidget r100, int r101, boolean r102) {
        this.mTotalWeight = 0.0f;
        this.mFirst = r100;
        this.mOrientation = r101;
        this.mIsRtl = r102;
    }
}
