package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.core.widgets.analyzer.Direct;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    static int myCounter;
    private WeakReference<ConstraintAnchor> horizontalWrapMax;
    private WeakReference<ConstraintAnchor> horizontalWrapMin;
    BasicMeasure mBasicMeasureSolver;
    int mDebugSolverPassCount;
    public DependencyGraph mDependencyGraph;
    public boolean mGroupsWrapOptimized;
    private boolean mHeightMeasuredTooSmall;
    ChainHead[] mHorizontalChainsArray;
    public int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    private boolean mIsRtl;
    public BasicMeasure.Measure mMeasure;
    protected BasicMeasure.Measurer mMeasurer;
    public Metrics mMetrics;
    private int mOptimizationLevel;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver;
    protected LinearSystem mSystem;
    ChainHead[] mVerticalChainsArray;
    public int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    private boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;
    private int pass;
    private WeakReference<ConstraintAnchor> verticalWrapMax;
    private WeakReference<ConstraintAnchor> verticalWrapMin;
    HashSet<ConstraintWidget> widgetsToAdd;

    static {
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean directMeasure(boolean r1) {
        return this.mDependencyGraph.directMeasure(r1);
    }

    public boolean directMeasureSetup(boolean r1) {
        return this.mDependencyGraph.directMeasureSetup(r1);
    }

    public boolean directMeasureWithOrientation(boolean r1, int r2) {
        return this.mDependencyGraph.directMeasureWithOrientation(r1, r2);
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public long measure(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        this.mPaddingLeft = r19;
        this.mPaddingTop = r20;
        return this.mBasicMeasureSolver.solverMeasure(this, r12, r19, r20, r13, r14, r15, r16, r17, r18);
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }

    public void setMeasurer(BasicMeasure.Measurer r1) {
        this.mMeasurer = r1;
        this.mDependencyGraph.setMeasurer(r1);
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public void fillMetrics(Metrics r1) {
        this.mMetrics = r1;
        this.mSystem.fillMetrics(r1);
    }

    public ConstraintWidgetContainer() {
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int r1, int r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int r3, int r4) {
        super(r3, r4);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(String r3, int r4, int r5) {
        super(r4, r5);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
        setDebugName(r3);
    }

    public void setOptimizationLevel(int r1) {
        this.mOptimizationLevel = r1;
        LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public boolean optimizeFor(int r1) {
        if ((this.mOptimizationLevel & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.WidgetContainer, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    void addVerticalWrapMinVariable(ConstraintAnchor r3) {
        WeakReference<ConstraintAnchor> r0 = this.verticalWrapMin;
        if (r0 != null) goto L5;
    L8:
        this.verticalWrapMin = new WeakReference(r3);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r3.getFinalValue() > this.verticalWrapMin.get().getFinalValue()) goto L8;
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor r3) {
        WeakReference<ConstraintAnchor> r0 = this.horizontalWrapMin;
        if (r0 != null) goto L5;
    L8:
        this.horizontalWrapMin = new WeakReference(r3);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r3.getFinalValue() > this.horizontalWrapMin.get().getFinalValue()) goto L8;
    }

    void addVerticalWrapMaxVariable(ConstraintAnchor r3) {
        WeakReference<ConstraintAnchor> r0 = this.verticalWrapMax;
        if (r0 != null) goto L5;
    L8:
        this.verticalWrapMax = new WeakReference(r3);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r3.getFinalValue() > this.verticalWrapMax.get().getFinalValue()) goto L8;
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor r3) {
        WeakReference<ConstraintAnchor> r0 = this.horizontalWrapMax;
        if (r0 != null) goto L5;
    L8:
        this.horizontalWrapMax = new WeakReference(r3);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r3.getFinalValue() > this.horizontalWrapMax.get().getFinalValue()) goto L8;
    }

    private void addMinWrap(ConstraintAnchor r3, SolverVariable r4) {
        SolverVariable r5 = this.mSystem.createObjectVariable(r3);
        this.mSystem.addGreaterThan(r5, r4, 0, 5);
    }

    private void addMaxWrap(ConstraintAnchor r3, SolverVariable r4) {
        SolverVariable r5 = this.mSystem.createObjectVariable(r3);
        this.mSystem.addGreaterThan(r4, r5, 0, 5);
    }

    public boolean addChildrenToSolver(LinearSystem r13) {
        boolean r0 = optimizeFor(64);
        addToSolver(r13, r0);
        int r1 = this.mChildren.size();
        int r3 = 0;
        boolean r4 = false;
    L4:
        if (r3 >= r1) goto L9;
        ConstraintWidget r6 = this.mChildren.get(r3);
        r6.setInBarrier(0, false);
        r6.setInBarrier(1, false);
        if ((r6 instanceof Barrier) == false) goto L8;
        r4 = true;
    L8:
        r3 = r3 + 1;
        goto L4
    L9:
        if (r4 == false) goto L16;
        int r5 = 0;
    L11:
        if (r5 >= r1) goto L16;
        ConstraintWidget r7 = this.mChildren.get(r5);
        if ((r7 instanceof Barrier) == false) goto L15;
        ((Barrier) r7).markWidgets();
    L15:
        r5 = r5 + 1;
    L16:
        this.widgetsToAdd.clear();
        int r8 = 0;
    L17:
        if (r8 >= r1) goto L26;
        ConstraintWidget r9 = this.mChildren.get(r8);
        if (r9.addFirst() == false) goto L24;
        if ((r9 instanceof VirtualLayout) == false) goto L23;
        this.widgetsToAdd.add(r9);
        goto L24
    L23:
        r9.addToSolver(r13, r0);
    L24:
        r8 = r8 + 1;
    L26:
        if (this.widgetsToAdd.size() <= 0) goto L41;
        int r10 = this.widgetsToAdd.size();
        Iterator<ConstraintWidget> r11 = this.widgetsToAdd.iterator();
    L29:
        if (r11.hasNext() == false) goto L34;
        VirtualLayout r12 = (VirtualLayout) r11.next();
        if (r12.contains(this.widgetsToAdd) == false) goto L29;
        r12.addToSolver(r13, r0);
        this.widgetsToAdd.remove(r12);
    L34:
        if (r10 != this.widgetsToAdd.size()) goto L26;
        Iterator<ConstraintWidget> r14 = this.widgetsToAdd.iterator();
    L37:
        if (r14.hasNext() == false) goto L39;
        r14.next().addToSolver(r13, r0);
        goto L37
    L39:
        this.widgetsToAdd.clear();
        goto L26
    L41:
        if (LinearSystem.USE_DEPENDENCY_ORDERING == false) goto L56;
        HashSet<ConstraintWidget> r15 = new HashSet();
        int r16 = 0;
    L43:
        if (r16 >= r1) goto L49;
        ConstraintWidget r17 = this.mChildren.get(r16);
        if (r17.addFirst() == true) goto L47;
        r15.add(r17);
    L47:
        r16 = r16 + 1;
        goto L43
    L49:
        if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L51;
        int r18 = 0;
    L52:
        addChildrenToSolverByDependency(this, r13, r15, r18, false);
        Iterator<ConstraintWidget> r2 = r15.iterator();
    L54:
        if (r2.hasNext() == false) goto L77;
        ConstraintWidget r19 = r2.next();
        Optimizer.checkMatchParent(this, r13, r19);
        r19.addToSolver(r13, r0);
    L77:
        if (this.mHorizontalChainsSize <= 0) goto L80;
        Chain.applyChainConstraints(this, r13, null, 0);
    L80:
        if (this.mVerticalChainsSize <= 0) goto L82;
        Chain.applyChainConstraints(this, r13, null, 1);
    L82:
        return true;
    L51:
        r18 = 1;
        goto L52
    L56:
        int r20 = 0;
    L57:
        if (r20 >= r1) goto L77;
        ConstraintWidget r21 = this.mChildren.get(r20);
        if ((r21 instanceof ConstraintWidgetContainer) == false) goto L72;
        ConstraintWidget.DimensionBehaviour r22 = r21.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r23 = r21.mListDimensionBehaviors[1];
        if (r22 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L64;
        r21.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
    L64:
        if (r23 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L66;
        r21.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
    L66:
        r21.addToSolver(r13, r0);
        if (r22 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L70;
        r21.setHorizontalDimensionBehaviour(r22);
    L70:
        if (r23 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L75;
        r21.setVerticalDimensionBehaviour(r23);
    L75:
        r20 = r20 + 1;
        goto L57
    L72:
        Optimizer.checkMatchParent(this, r13, r21);
        if (r21.addFirst() == true) goto L75;
        r21.addToSolver(r13, r0);
        goto L75
    }

    public boolean updateChildrenFromSolver(LinearSystem r5, boolean[] r6) {
        int r1 = 0;
        r6[2] = false;
        boolean r7 = optimizeFor(64);
        updateFromSolver(r5, r7);
        int r0 = this.mChildren.size();
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L8;
        ConstraintWidget r3 = this.mChildren.get(r1);
        r3.updateFromSolver(r5, r7);
        if (r3.hasDimensionOverride() == false) goto L7;
        r2 = true;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void updateFromRuns(boolean r4, boolean r5) {
        super.updateFromRuns(r4, r5);
        int r0 = this.mChildren.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mChildren.get(r1).updateFromRuns(r4, r5);
        r1 = r1 + 1;
        goto L3
    }

    public void setPadding(int r1, int r2, int r3, int r4) {
        this.mPaddingLeft = r1;
        this.mPaddingTop = r2;
        this.mPaddingRight = r3;
        this.mPaddingBottom = r4;
    }

    public void setRtl(boolean r1) {
        this.mIsRtl = r1;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public static boolean measure(int r5, ConstraintWidget r6, BasicMeasure.Measurer r7, BasicMeasure.Measure r8, int r9) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if (r6.getVisibility() != 8) goto L8;
    L87:
        r8.measuredWidth = 0;
        r8.measuredHeight = 0;
        return false;
    L8:
        if ((r6 instanceof Guideline) == true) goto L87;
        if ((r6 instanceof Barrier) == true) goto L87;
        r8.horizontalBehavior = r6.getHorizontalDimensionBehaviour();
        r8.verticalBehavior = r6.getVerticalDimensionBehaviour();
        r8.horizontalDimension = r6.getWidth();
        r8.verticalDimension = r6.getHeight();
        r8.measuredNeedsSolverPass = false;
        r8.measureStrategy = r9;
        if (r8.horizontalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L15;
        boolean r10 = true;
    L17:
        if (r8.verticalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        boolean r0 = true;
    L21:
        if (r10 == true) goto L23;
    L25:
        boolean r3 = false;
    L26:
        if (r0 == true) goto L28;
    L30:
        boolean r2 = false;
    L31:
        if (r10 == true) goto L33;
    L43:
        if (r0 == false) goto L56;
        if (r6.hasDanglingDimension(1) == false) goto L56;
        if (r6.mMatchConstraintDefaultHeight != 0) goto L56;
        if (r2 == true) goto L56;
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r10 == true) goto L52;
    L54:
        r0 = false;
        goto L56
    L52:
        if (r6.mMatchConstraintDefaultWidth != 0) goto L54;
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
    L56:
        if (r6.isResolvedHorizontally() == false) goto L59;
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r10 = false;
    L59:
        if (r6.isResolvedVertically() == false) goto L62;
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r0 = false;
    L62:
        if (r3 == true) goto L64;
    L72:
        if (r2 == true) goto L74;
    L85:
        r7.measure(r6, r8);
        r6.setWidth(r8.measuredWidth);
        r6.setHeight(r8.measuredHeight);
        r6.setHasBaseline(r8.measuredHasBaseline);
        r6.setBaselineDistance(r8.measuredBaseline);
        r8.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
        return r8.measuredNeedsSolverPass;
    L74:
        if (r6.mResolvedMatchConstraintDefault[1] != 4) goto L76;
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L85
    L76:
        if (r10 == true) goto L85;
        if (r8.horizontalBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L80;
        int r11 = r8.horizontalDimension;
    L81:
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r6.getDimensionRatioSide() != (-1)) goto L84;
        r8.verticalDimension = (int) (r11 / r6.getDimensionRatio());
        goto L85
    L84:
        r8.verticalDimension = (int) (r6.getDimensionRatio() * r11);
        goto L85
    L80:
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r7.measure(r6, r8);
        r11 = r8.measuredWidth;
        goto L81
    L64:
        if (r6.mResolvedMatchConstraintDefault[0] != 4) goto L66;
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L72
    L66:
        if (r0 == true) goto L72;
        if (r8.verticalBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L70;
        int r12 = r8.verticalDimension;
    L71:
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r8.horizontalDimension = (int) (r6.getDimensionRatio() * r12);
        goto L72
    L70:
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r7.measure(r6, r8);
        r12 = r8.measuredHeight;
        goto L71
    L33:
        if (r6.hasDanglingDimension(0) == false) goto L43;
        if (r6.mMatchConstraintDefaultWidth != 0) goto L43;
        if (r3 == true) goto L43;
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r0 == true) goto L40;
    L42:
        r10 = false;
        goto L43
    L40:
        if (r6.mMatchConstraintDefaultHeight != 0) goto L42;
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L42
    L28:
        if (r6.mDimensionRatio <= 0.0f) goto L30;
        r2 = true;
        goto L31
    L23:
        if (r6.mDimensionRatio <= 0.0f) goto L25;
        r3 = true;
        goto L26
    L19:
        r0 = false;
        goto L21
    L15:
        r10 = false;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // androidx.constraintlayout.core.widgets.WidgetContainer
    public void layout() {
        int r2 = 0;
        this.mX = 0;
        this.mY = 0;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        int r3 = this.mChildren.size();
        int r0 = Math.max(0, getWidth());
        int r4 = Math.max(0, getHeight());
        ConstraintWidget.DimensionBehaviour r5 = this.mListDimensionBehaviors[1];
        ConstraintWidget.DimensionBehaviour r7 = this.mListDimensionBehaviors[0];
        Metrics r8 = this.mMetrics;
        if (r8 == null) goto L6;
        r8.layouts++;
    L6:
        if (this.pass != 0) goto L35;
        if (Optimizer.enabled(this.mOptimizationLevel, 1) == false) goto L35;
        Direct.solvingPass(this, getMeasurer());
        int r9 = 0;
    L10:
        if (r9 >= r3) goto L35;
        ConstraintWidget r10 = this.mChildren.get(r9);
        if (r10.isMeasureRequested() == false) goto L33;
        if ((r10 instanceof Guideline) == true) goto L33;
        if ((r10 instanceof Barrier) == true) goto L33;
        if ((r10 instanceof VirtualLayout) == true) goto L33;
        if (r10.isInVirtualLayout() == true) goto L33;
        ConstraintWidget.DimensionBehaviour r11 = r10.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r12 = r10.getDimensionBehaviour(1);
        if (r11 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
    L30:
        boolean r13 = false;
    L31:
        if (r13 == true) goto L33;
        measure(0, r10, this.mMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L33
    L24:
        if (r10.mMatchConstraintDefaultWidth == 1) goto L30;
        if (r12 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L30;
        if (r10.mMatchConstraintDefaultHeight == 1) goto L30;
        r13 = true;
    L33:
        r9 = r9 + 1;
    L35:
        if (r3 > 2) goto L37;
    L59:
        int r14 = r4;
        int r6 = r0;
        boolean r1 = false;
    L61:
        if (optimizeFor(64) == false) goto L63;
    L66:
        boolean r15 = true;
    L67:
        this.mSystem.graphOptimizer = false;
        this.mSystem.newgraphOptimizer = false;
        if (this.mOptimizationLevel == 0) goto L71;
        if (r15 == false) goto L71;
        this.mSystem.newgraphOptimizer = true;
    L71:
        ArrayList<ConstraintWidget> r16 = this.mChildren;
        if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L74;
    L77:
        boolean r17 = true;
    L78:
        resetChains();
        int r18 = 0;
    L79:
        if (r18 >= r3) goto L84;
        ConstraintWidget r19 = this.mChildren.get(r18);
        if ((r19 instanceof WidgetContainer) == false) goto L83;
        ((WidgetContainer) r19).layout();
    L83:
        r18 = r18 + 1;
        goto L79
    L84:
        boolean r110 = optimizeFor(64);
        ?? r111 = r1;
        int r20 = 0;
        boolean r112 = true;
    L85:
        if (r112 == false) goto L165;
        int r113 = r20 + 1;
        this.mSystem.reset();     // Catch: Exception -> L113
        resetChains();     // Catch: Exception -> L113
        createObjectVariables(this.mSystem);     // Catch: Exception -> L113
        int r21 = r2;
    L88:
        if (r21 >= r3) goto L90;
        this.mChildren.get(r21).createObjectVariables(this.mSystem);     // Catch: Exception -> L113
        r21 = r21 + 1;     // Catch: Exception -> L113
        goto L88
    L90:
        r112 = addChildrenToSolver(this.mSystem);     // Catch: Exception -> L113
        WeakReference<ConstraintAnchor> r22 = this.verticalWrapMin;     // Catch: Exception -> L113
        if (r22 != null) goto L93;
    L95:
        WeakReference<ConstraintAnchor> r23 = this.verticalWrapMax;     // Catch: Exception -> L113
        if (r23 != null) goto L98;
    L100:
        WeakReference<ConstraintAnchor> r24 = this.horizontalWrapMin;     // Catch: Exception -> L113
        if (r24 != null) goto L103;
    L105:
        WeakReference<ConstraintAnchor> r25 = this.horizontalWrapMax;     // Catch: Exception -> L113
        if (r25 != null) goto L108;
    L110:
        if (r112 == false) goto L115;
        this.mSystem.minimize();     // Catch: Exception -> L113
    L115:
        if (r112 == false) goto L117;
        boolean r26 = updateChildrenFromSolver(this.mSystem, Optimizer.flags);
    L122:
        if (r17 == false) goto L139;
        if (r113 >= 8) goto L139;
        if (Optimizer.flags[2] == false) goto L139;
        int r27 = 0;
        int r28 = 0;
        int r114 = 0;
    L127:
        if (r27 >= r3) goto L129;
        ConstraintWidget r29 = this.mChildren.get(r27);
        r114 = Math.max(r114, r29.mX + r29.getWidth());
        r28 = Math.max(r28, r29.mY + r29.getHeight());
        r27 = r27 + 1;
        r26 = r26;
        goto L127
    L129:
        boolean r115 = r26;
        int r30 = Math.max(this.mMinWidth, r114);
        int r31 = Math.max(this.mMinHeight, r28);
        ?? r116 = r111;
        if (r7 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L134;
        r116 = r111;
        if (getWidth() >= r30) goto L134;
        setWidth(r30);
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r116 = 1;
        r115 = true;
    L134:
        ?? r117 = r116;
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L140;
        r117 = r116;
        if (getHeight() >= r31) goto L140;
        setHeight(r31);
        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r117 = 1;
        r115 = true;
    L140:
        int r32 = Math.max(this.mMinWidth, getWidth());
        ?? r118 = r117;
        if (r32 <= getWidth()) goto L143;
        setWidth(r32);
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        r118 = 1;
        r115 = true;
    L143:
        int r33 = Math.max(this.mMinHeight, getHeight());
        if (r33 <= getHeight()) goto L146;
        setHeight(r33);
        ?? r34 = 1;
        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
        ?? r119 = 1;
        r115 = true;
    L147:
        if (r119 != 0) goto L160;
        r119 = r119;
        r119 = r119;
        if (this.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L155;
        if (r6 <= 0) goto L155;
        r119 = r119;
        if (getWidth() <= r6) goto L155;
        this.mWidthMeasuredTooSmall = r34;
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        setWidth(r6);
        ?? r120 = r34;
        r115 = r120 == true ? 1 : 0;
        r119 = r120;
    L155:
        if (this.mListDimensionBehaviors[r34] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L160;
        if (r14 <= 0) goto L160;
        if (getHeight() <= r14) goto L160;
        this.mHeightMeasuredTooSmall = r34;
        this.mListDimensionBehaviors[r34] = ConstraintWidget.DimensionBehaviour.FIXED;
        setHeight(r14);
        int r35 = 8;
        boolean r36 = true;
        ?? r121 = 1;
    L161:
        if (r113 <= r35) goto L163;
        r112 = false;
    L164:
        r20 = r113;
        r2 = 0;
        r111 = r121;
        goto L85
    L163:
        r112 = r36;
    L160:
        r36 = r115;
        r35 = 8;
        r121 = r119;
        goto L161
    L146:
        r34 = 1;
        r119 = r118;
    L139:
        r115 = r26;
        r117 = r111;
        goto L140
    L117:
        updateFromSolver(this.mSystem, r110);
        int r37 = 0;
    L118:
        if (r37 >= r3) goto L120;
        this.mChildren.get(r37).updateFromSolver(this.mSystem, r110);
        r37 = r37 + 1;
        goto L118
    L120:
        r26 = false;
        goto L122
    L108:
        if (r25.get() == null) goto L110;
        addMaxWrap(this.horizontalWrapMax.get(), this.mSystem.createObjectVariable(this.mRight));     // Catch: Exception -> L113
        this.horizontalWrapMax = null;     // Catch: Exception -> L113
        goto L110
    L103:
        if (r24.get() == null) goto L105;
        addMinWrap(this.horizontalWrapMin.get(), this.mSystem.createObjectVariable(this.mLeft));     // Catch: Exception -> L113
        this.horizontalWrapMin = null;     // Catch: Exception -> L113
        goto L105
    L98:
        if (r23.get() == null) goto L100;
        addMaxWrap(this.verticalWrapMax.get(), this.mSystem.createObjectVariable(this.mBottom));     // Catch: Exception -> L113
        this.verticalWrapMax = null;     // Catch: Exception -> L113
        goto L100
    L93:
        if (r22.get() == null) goto L95;
        addMinWrap(this.verticalWrapMin.get(), this.mSystem.createObjectVariable(this.mTop));     // Catch: Exception -> L113
        this.verticalWrapMin = null;     // Catch: Exception -> L113
    L113:
        e = move-exception;
        e.printStackTrace();
        System.out.println("EXCEPTION : " + e);
        goto L115
    L165:
        this.mChildren = r16;
        if (r111 == 0) goto L168;
        this.mListDimensionBehaviors[0] = r7;
        this.mListDimensionBehaviors[1] = r5;
    L168:
        resetSolverVariables(this.mSystem.getCache());
        return;
    L74:
        if (getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L77;
        r17 = false;
        goto L78
    L63:
        if (optimizeFor(128) == true) goto L66;
        r15 = false;
        goto L67
    L37:
        if (r7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L41;
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L59;
    L41:
        if (Optimizer.enabled(this.mOptimizationLevel, 1024) == false) goto L59;
        if (Grouping.simpleSolvingPass(this, getMeasurer()) == false) goto L59;
        if (r7 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L52;
        if (r0 >= getWidth()) goto L50;
        if (r0 <= 0) goto L50;
        setWidth(r0);
        this.mWidthMeasuredTooSmall = true;
    L50:
        r0 = getWidth();
    L52:
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L54;
    L58:
        r14 = r4;
        r6 = r0;
        r1 = true;
        goto L61
    L54:
        if (r4 >= getHeight()) goto L57;
        if (r4 <= 0) goto L57;
        setHeight(r4);
        this.mHeightMeasuredTooSmall = true;
    L57:
        r4 = getHeight();
        goto L58
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> r0 = new ArrayList();
        int r1 = this.mChildren.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        ConstraintWidget r3 = this.mChildren.get(r2);
        if ((r3 instanceof Guideline) == false) goto L9;
        Guideline r4 = (Guideline) r3;
        if (r4.getOrientation() != 1) goto L9;
        r0.add(r4);
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> r0 = new ArrayList();
        int r1 = this.mChildren.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        ConstraintWidget r3 = this.mChildren.get(r2);
        if ((r3 instanceof Guideline) == false) goto L9;
        Guideline r4 = (Guideline) r3;
        if (r4.getOrientation() != 0) goto L9;
        r0.add(r4);
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    void addChain(ConstraintWidget r2, int r3) {
        if (r3 != 0) goto L5;
        addHorizontalChain(r2);
        return;
    L5:
        if (r3 != 1) goto L9;
        addVerticalChain(r2);
        return;
    }

    private void addHorizontalChain(ConstraintWidget r6) {
        int r0 = this.mHorizontalChainsSize + 1;
        ChainHead[] r1 = this.mHorizontalChainsArray;
        if (r0 < r1.length) goto L5;
        this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(r1, r1.length * 2);
    L5:
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(r6, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget r6) {
        int r0 = this.mVerticalChainsSize + 1;
        ChainHead[] r2 = this.mVerticalChainsArray;
        if (r0 < r2.length) goto L5;
        this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(r2, r2.length * 2);
    L5:
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(r6, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    public void setPass(int r1) {
        this.pass = r1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void getSceneString(StringBuilder r4) {
        r4.append(this.stringId + ":{\n");
        r4.append("  actualWidth:" + this.mWidth);
        r4.append("\n");
        r4.append("  actualHeight:" + this.mHeight);
        r4.append("\n");
        Iterator<ConstraintWidget> r3 = getChildren().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().getSceneString(r4);
        r4.append(",\n");
        goto L4
    L6:
        r4.append("}");
    }
}
