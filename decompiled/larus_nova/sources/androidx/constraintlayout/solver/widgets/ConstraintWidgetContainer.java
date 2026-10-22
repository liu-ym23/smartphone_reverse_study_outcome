package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.solver.widgets.analyzer.Direct;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    static int mycounter;
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
    private WeakReference<ConstraintAnchor> verticalWrapMax;
    private WeakReference<ConstraintAnchor> verticalWrapMin;

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> r100 = new ArrayList();
        int r101 = this.mChildren.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        ConstraintWidget r103 = (ConstraintWidget) ListProtector.get(this.mChildren, r102);
        if ((r103 instanceof Guideline) == false) goto L9;
        Guideline r104 = (Guideline) r103;
        if (r104.getOrientation() != 0) goto L9;
        r100.add(r104);
    L9:
        r102 = r102 + 1;
        goto L3
    L10:
        return r100;
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> r100 = new ArrayList();
        int r101 = this.mChildren.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        ConstraintWidget r103 = (ConstraintWidget) ListProtector.get(this.mChildren, r102);
        if ((r103 instanceof Guideline) == false) goto L9;
        Guideline r104 = (Guideline) r103;
        if (r104.getOrientation() != 1) goto L9;
        r100.add(r104);
    L9:
        r102 = r102 + 1;
        goto L3
    L10:
        return r100;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    public void layout() {
        this.mX = 0;
        this.mY = 0;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        int r100 = this.mChildren.size();
        int r101 = Math.max(0, getWidth());
        int r102 = Math.max(0, getHeight());
        ConstraintWidget.DimensionBehaviour[] r103 = this.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r104 = r103[1];
        ConstraintWidget.DimensionBehaviour r105 = r103[0];
        Metrics r106 = this.mMetrics;
        if (r106 == null) goto L6;
        r106.layouts++;
    L6:
        if (Optimizer.enabled(this.mOptimizationLevel, 1) == false) goto L32;
        Direct.solvingPass(this, getMeasurer());
        int r107 = 0;
    L8:
        if (r107 >= r100) goto L32;
        ConstraintWidget r108 = (ConstraintWidget) ListProtector.get(this.mChildren, r107);
        if (r108.isMeasureRequested() == false) goto L30;
        if ((r108 instanceof Guideline) == true) goto L30;
        if ((r108 instanceof Barrier) == true) goto L30;
        if ((r108 instanceof VirtualLayout) == true) goto L30;
        if (r108.isInVirtualLayout() == true) goto L30;
        ConstraintWidget.DimensionBehaviour r110 = r108.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r111 = r108.getDimensionBehaviour(1);
        ConstraintWidget.DimensionBehaviour r112 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r110 == r112) goto L22;
    L27:
        boolean r113 = false;
    L28:
        if (r113 == true) goto L30;
        measure(r108, this.mMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L30
    L22:
        if (r108.mMatchConstraintDefaultWidth == 1) goto L27;
        if (r111 != r112) goto L27;
        if (r108.mMatchConstraintDefaultHeight == 1) goto L27;
        r113 = true;
    L30:
        r107 = r107 + 1;
    L32:
        if (r100 <= 2) goto L53;
        ConstraintWidget.DimensionBehaviour r109 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r105 == r109) goto L37;
        if (r104 != r109) goto L53;
    L37:
        if (Optimizer.enabled(this.mOptimizationLevel, 1024) == false) goto L53;
        if (Grouping.simpleSolvingPass(this, getMeasurer()) == false) goto L53;
        if (r105 == r109) goto L42;
    L46:
        if (r104 == r109) goto L48;
    L52:
        int r114 = r102;
        int r115 = r101;
        boolean r116 = true;
    L55:
        if (optimizeFor(64) == false) goto L57;
    L60:
        boolean r117 = true;
    L61:
        LinearSystem r118 = this.mSystem;
        r118.graphOptimizer = false;
        r118.newgraphOptimizer = false;
        if (this.mOptimizationLevel == 0) goto L65;
        if (r117 == false) goto L65;
        r118.newgraphOptimizer = true;
    L65:
        ArrayList<ConstraintWidget> r119 = this.mChildren;
        ConstraintWidget.DimensionBehaviour r120 = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r121 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r120 != r121) goto L68;
    L71:
        boolean r122 = true;
    L72:
        resetChains();
        int r123 = 0;
    L73:
        if (r123 >= r100) goto L78;
        ConstraintWidget r124 = (ConstraintWidget) ListProtector.get(this.mChildren, r123);
        if ((r124 instanceof WidgetContainer) == false) goto L77;
        ((WidgetContainer) r124).layout();
    L77:
        r123 = r123 + 1;
        goto L73
    L78:
        boolean r125 = optimizeFor(64);
        boolean r126 = r116;
        int r127 = 0;
        boolean r128 = true;
    L79:
        if (r128 == false) goto L155;
        int r129 = r127 + 1;
        this.mSystem.reset();     // Catch: Exception -> L107
        resetChains();     // Catch: Exception -> L107
        createObjectVariables(this.mSystem);     // Catch: Exception -> L107
        int r130 = 0;
    L82:
        if (r130 >= r100) goto L84;
        ((ConstraintWidget) ListProtector.get(this.mChildren, r130)).createObjectVariables(this.mSystem);     // Catch: Exception -> L107
        r130 = r130 + 1;     // Catch: Exception -> L107
        goto L82
    L84:
        r128 = addChildrenToSolver(this.mSystem);     // Catch: Exception -> L107
        WeakReference<ConstraintAnchor> r131 = this.verticalWrapMin;     // Catch: Exception -> L107
        if (r131 != null) goto L87;
    L89:
        WeakReference<ConstraintAnchor> r132 = this.verticalWrapMax;     // Catch: Exception -> L107
        if (r132 != null) goto L92;
    L94:
        WeakReference<ConstraintAnchor> r133 = this.horizontalWrapMin;     // Catch: Exception -> L107
        if (r133 != null) goto L97;
    L99:
        WeakReference<ConstraintAnchor> r134 = this.horizontalWrapMax;     // Catch: Exception -> L107
        if (r134 != null) goto L102;
    L104:
        if (r128 == false) goto L109;
        this.mSystem.minimize();     // Catch: Exception -> L107
    L109:
        if (r128 == false) goto L111;
        updateChildrenFromSolver(this.mSystem, Optimizer.flags);
    L114:
        if (r122 == true) goto L116;
    L132:
        boolean r135 = false;
    L133:
        int r136 = Math.max(this.mMinWidth, getWidth());
        if (r136 <= getWidth()) goto L136;
        setWidth(r136);
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        r135 = true;
        r126 = true;
    L136:
        int r137 = Math.max(this.mMinHeight, getHeight());
        if (r137 <= getHeight()) goto L139;
        setHeight(r137);
        ?? r138 = 1;
        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
        r135 = true;
        boolean r139 = true;
    L140:
        if (r139 == true) goto L153;
        ConstraintWidget.DimensionBehaviour r140 = this.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r141 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r140 != r141) goto L148;
        if (r115 <= 0) goto L148;
        if (getWidth() <= r115) goto L148;
        this.mWidthMeasuredTooSmall = r138;
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        setWidth(r115);
        r135 = true;
        r139 = true;
    L148:
        if (this.mListDimensionBehaviors[r138] != r141) goto L153;
        if (r114 <= 0) goto L153;
        if (getHeight() <= r114) goto L153;
        this.mHeightMeasuredTooSmall = r138;
        this.mListDimensionBehaviors[r138] = ConstraintWidget.DimensionBehaviour.FIXED;
        setHeight(r114);
        r126 = true;
        r128 = true;
    L154:
        r127 = r129;
    L153:
        r128 = r135;
        r126 = r139;
        goto L154
    L139:
        r138 = 1;
        r139 = r126;
        goto L140
    L116:
        if (r129 >= 8) goto L132;
        if (Optimizer.flags[2] == false) goto L132;
        int r142 = 0;
        int r143 = 0;
        int r144 = 0;
    L120:
        if (r142 >= r100) goto L122;
        ConstraintWidget r145 = (ConstraintWidget) ListProtector.get(this.mChildren, r142);
        r143 = Math.max(r143, r145.mX + r145.getWidth());
        r144 = Math.max(r144, r145.mY + r145.getHeight());
        r142 = r142 + 1;
        goto L120
    L122:
        int r146 = Math.max(this.mMinWidth, r143);
        int r147 = Math.max(this.mMinHeight, r144);
        ConstraintWidget.DimensionBehaviour r148 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r105 == r148) goto L125;
    L127:
        r135 = false;
    L128:
        if (r104 != r148) goto L133;
        if (getHeight() >= r147) goto L133;
        setHeight(r147);
        this.mListDimensionBehaviors[1] = r148;
        r135 = true;
        r126 = true;
        goto L133
    L125:
        if (getWidth() >= r146) goto L127;
        setWidth(r146);
        this.mListDimensionBehaviors[0] = r148;
        r135 = true;
        r126 = true;
        goto L128
    L111:
        updateFromSolver(this.mSystem, r125);
        int r149 = 0;
    L112:
        if (r149 >= r100) goto L114;
        ((ConstraintWidget) ListProtector.get(this.mChildren, r149)).updateFromSolver(this.mSystem, r125);
        r149 = r149 + 1;
        goto L112
    L102:
        if (r134.get() == null) goto L104;
        addMaxWrap(this.horizontalWrapMax.get(), this.mSystem.createObjectVariable(this.mRight));     // Catch: Exception -> L107
        this.horizontalWrapMax = null;     // Catch: Exception -> L107
        goto L104
    L97:
        if (r133.get() == null) goto L99;
        addMinWrap(this.horizontalWrapMin.get(), this.mSystem.createObjectVariable(this.mLeft));     // Catch: Exception -> L107
        this.horizontalWrapMin = null;     // Catch: Exception -> L107
        goto L99
    L92:
        if (r132.get() == null) goto L94;
        addMaxWrap(this.verticalWrapMax.get(), this.mSystem.createObjectVariable(this.mBottom));     // Catch: Exception -> L107
        this.verticalWrapMax = null;     // Catch: Exception -> L107
        goto L94
    L87:
        if (r131.get() == null) goto L89;
        addMinWrap(this.verticalWrapMin.get(), this.mSystem.createObjectVariable(this.mTop));     // Catch: Exception -> L107
        this.verticalWrapMin = null;     // Catch: Exception -> L107
    L107:
        e = move-exception;
        e.printStackTrace();
        System.out.println("EXCEPTION : " + e);
        goto L109
    L155:
        this.mChildren = r119;
        if (r126 == false) goto L158;
        ConstraintWidget.DimensionBehaviour[] r150 = this.mListDimensionBehaviors;
        r150[0] = r105;
        r150[1] = r104;
    L158:
        resetSolverVariables(this.mSystem.getCache());
        return;
    L68:
        if (getVerticalDimensionBehaviour() == r121) goto L71;
        r122 = false;
        goto L72
    L57:
        if (optimizeFor(128) == true) goto L60;
        r117 = false;
        goto L61
    L48:
        if (r102 >= getHeight()) goto L51;
        if (r102 <= 0) goto L51;
        setHeight(r102);
        this.mHeightMeasuredTooSmall = true;
    L51:
        r102 = getHeight();
        goto L52
    L42:
        if (r101 >= getWidth()) goto L45;
        if (r101 <= 0) goto L45;
        setWidth(r101);
        this.mWidthMeasuredTooSmall = true;
    L45:
        r101 = getWidth();
    L53:
        r114 = r102;
        r115 = r101;
        r116 = false;
        goto L55
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
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
        this.mMeasure = new BasicMeasure.Measure();
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    private void addHorizontalChain(ConstraintWidget r100) {
        int r101 = this.mHorizontalChainsSize + 1;
        ChainHead[] r102 = this.mHorizontalChainsArray;
        if (r101 < r102.length) goto L5;
        this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(r102, r102.length * 2);
    L5:
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(r100, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget r100) {
        int r101 = this.mVerticalChainsSize + 1;
        ChainHead[] r102 = this.mVerticalChainsArray;
        if (r101 < r102.length) goto L5;
        this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(r102, r102.length * 2);
    L5:
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(r100, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    public boolean addChildrenToSolver(LinearSystem r110) {
        boolean r100 = optimizeFor(64);
        addToSolver(r110, r100);
        int r101 = this.mChildren.size();
        int r102 = 0;
        boolean r103 = false;
    L4:
        if (r102 >= r101) goto L9;
        ConstraintWidget r104 = (ConstraintWidget) ListProtector.get(this.mChildren, r102);
        r104.setInBarrier(0, false);
        r104.setInBarrier(1, false);
        if ((r104 instanceof Barrier) == false) goto L8;
        r103 = true;
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        if (r103 == false) goto L16;
        int r105 = 0;
    L11:
        if (r105 >= r101) goto L16;
        ConstraintWidget r106 = (ConstraintWidget) ListProtector.get(this.mChildren, r105);
        if ((r106 instanceof Barrier) == false) goto L15;
        ((Barrier) r106).markWidgets();
    L15:
        r105 = r105 + 1;
    L16:
        int r107 = 0;
    L17:
        if (r107 >= r101) goto L23;
        ConstraintWidget r108 = (ConstraintWidget) ListProtector.get(this.mChildren, r107);
        if (r108.addFirst() == false) goto L21;
        r108.addToSolver(r110, r100);
    L21:
        r107 = r107 + 1;
        goto L17
    L23:
        if (LinearSystem.USE_DEPENDENCY_ORDERING == false) goto L38;
        HashSet<ConstraintWidget> r109 = new HashSet();
        int r111 = 0;
    L25:
        if (r111 >= r101) goto L31;
        ConstraintWidget r112 = (ConstraintWidget) ListProtector.get(this.mChildren, r111);
        if (r112.addFirst() == true) goto L29;
        r109.add(r112);
    L29:
        r111 = r111 + 1;
        goto L25
    L31:
        if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L33;
        int r113 = 0;
    L34:
        addChildrenToSolverByDependency(this, r110, r109, r113, false);
        Iterator<ConstraintWidget> r114 = r109.iterator();
    L36:
        if (r114.hasNext() == false) goto L57;
        ConstraintWidget r115 = r114.next();
        Optimizer.checkMatchParent(this, r110, r115);
        r115.addToSolver(r110, r100);
    L57:
        if (this.mHorizontalChainsSize <= 0) goto L60;
        Chain.applyChainConstraints(this, r110, null, 0);
    L60:
        if (this.mVerticalChainsSize <= 0) goto L62;
        Chain.applyChainConstraints(this, r110, null, 1);
    L62:
        return true;
    L33:
        r113 = 1;
        goto L34
    L38:
        int r116 = 0;
    L39:
        if (r116 >= r101) goto L57;
        ConstraintWidget r117 = (ConstraintWidget) ListProtector.get(this.mChildren, r116);
        if ((r117 instanceof ConstraintWidgetContainer) == false) goto L52;
        ConstraintWidget.DimensionBehaviour[] r118 = r117.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r119 = r118[0];
        ConstraintWidget.DimensionBehaviour r120 = r118[1];
        ConstraintWidget.DimensionBehaviour r121 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r119 != r121) goto L45;
        r117.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
    L45:
        if (r120 != r121) goto L47;
        r117.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
    L47:
        r117.addToSolver(r110, r100);
        if (r119 != r121) goto L50;
        r117.setHorizontalDimensionBehaviour(r119);
    L50:
        if (r120 != r121) goto L55;
        r117.setVerticalDimensionBehaviour(r120);
    L55:
        r116 = r116 + 1;
        goto L39
    L52:
        Optimizer.checkMatchParent(this, r110, r117);
        if (r117.addFirst() == true) goto L55;
        r117.addToSolver(r110, r100);
        goto L55
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor r100) {
        WeakReference<ConstraintAnchor> r101 = this.horizontalWrapMax;
        if (r101 != null) goto L5;
    L8:
        this.horizontalWrapMax = new WeakReference(r100);
        return;
    L5:
        if (r101.get() == null) goto L8;
        if (r100.getFinalValue() > this.horizontalWrapMax.get().getFinalValue()) goto L8;
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor r100) {
        WeakReference<ConstraintAnchor> r101 = this.horizontalWrapMin;
        if (r101 != null) goto L5;
    L8:
        this.horizontalWrapMin = new WeakReference(r100);
        return;
    L5:
        if (r101.get() == null) goto L8;
        if (r100.getFinalValue() > this.horizontalWrapMin.get().getFinalValue()) goto L8;
    }

    public void addVerticalWrapMaxVariable(ConstraintAnchor r100) {
        WeakReference<ConstraintAnchor> r101 = this.verticalWrapMax;
        if (r101 != null) goto L5;
    L8:
        this.verticalWrapMax = new WeakReference(r100);
        return;
    L5:
        if (r101.get() == null) goto L8;
        if (r100.getFinalValue() > this.verticalWrapMax.get().getFinalValue()) goto L8;
    }

    public void addVerticalWrapMinVariable(ConstraintAnchor r100) {
        WeakReference<ConstraintAnchor> r101 = this.verticalWrapMin;
        if (r101 != null) goto L5;
    L8:
        this.verticalWrapMin = new WeakReference(r100);
        return;
    L5:
        if (r101.get() == null) goto L8;
        if (r100.getFinalValue() > this.verticalWrapMin.get().getFinalValue()) goto L8;
    }

    public boolean directMeasure(boolean r100) {
        return this.mDependencyGraph.directMeasure(r100);
    }

    public boolean directMeasureSetup(boolean r100) {
        return this.mDependencyGraph.directMeasureSetup(r100);
    }

    public void fillMetrics(Metrics r100) {
        this.mMetrics = r100;
        this.mSystem.fillMetrics(r100);
    }

    public boolean optimizeFor(int r100) {
        if ((this.mOptimizationLevel & r100) != r100) goto L5;
        return true;
    L5:
        return false;
    }

    public void setMeasurer(BasicMeasure.Measurer r100) {
        this.mMeasurer = r100;
        this.mDependencyGraph.setMeasurer(r100);
    }

    public void setOptimizationLevel(int r100) {
        this.mOptimizationLevel = r100;
        LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public void setRtl(boolean r100) {
        this.mIsRtl = r100;
    }

    public ConstraintWidgetContainer(int r100, int r101) {
        super(r100, r101);
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
        this.mMeasure = new BasicMeasure.Measure();
    }

    private void addMaxWrap(ConstraintAnchor r100, SolverVariable r101) {
        SolverVariable r102 = this.mSystem.createObjectVariable(r100);
        this.mSystem.addGreaterThan(r101, r102, 0, 5);
    }

    private void addMinWrap(ConstraintAnchor r100, SolverVariable r101) {
        SolverVariable r102 = this.mSystem.createObjectVariable(r100);
        this.mSystem.addGreaterThan(r102, r101, 0, 5);
    }

    public void addChain(ConstraintWidget r100, int r101) {
        if (r101 != 0) goto L5;
        addHorizontalChain(r100);
        return;
    L5:
        if (r101 != 1) goto L9;
        addVerticalChain(r100);
        return;
    }

    public boolean directMeasureWithOrientation(boolean r100, int r101) {
        return this.mDependencyGraph.directMeasureWithOrientation(r100, r101);
    }

    public void updateChildrenFromSolver(LinearSystem r100, boolean[] r101) {
        int r102 = 0;
        r101[2] = false;
        boolean r103 = optimizeFor(64);
        updateFromSolver(r100, r103);
        int r104 = this.mChildren.size();
    L3:
        if (r102 >= r104) goto L5;
        ((ConstraintWidget) ListProtector.get(this.mChildren, r102)).updateFromSolver(r100, r103);
        r102 = r102 + 1;
        goto L3
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromRuns(boolean r100, boolean r101) {
        super.updateFromRuns(r100, r101);
        int r102 = this.mChildren.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((ConstraintWidget) ListProtector.get(this.mChildren, r103)).updateFromRuns(r100, r101);
        r103 = r103 + 1;
        goto L3
    }

    public ConstraintWidgetContainer(String r100, int r101, int r102) {
        super(r101, r102);
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
        this.mMeasure = new BasicMeasure.Measure();
        setDebugName(r100);
    }

    public ConstraintWidgetContainer(int r100, int r101, int r102, int r103) {
        super(r100, r101, r102, r103);
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
        this.mMeasure = new BasicMeasure.Measure();
    }

    public static boolean measure(ConstraintWidget r100, BasicMeasure.Measurer r101, BasicMeasure.Measure r102, int r110) {
        if (r101 != null) goto L5;
        return false;
    L5:
        r102.horizontalBehavior = r100.getHorizontalDimensionBehaviour();
        r102.verticalBehavior = r100.getVerticalDimensionBehaviour();
        r102.horizontalDimension = r100.getWidth();
        r102.verticalDimension = r100.getHeight();
        r102.measuredNeedsSolverPass = false;
        r102.measureStrategy = r110;
        ConstraintWidget.DimensionBehaviour r111 = r102.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour r103 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r111 != r103) goto L8;
        boolean r112 = true;
    L10:
        if (r102.verticalBehavior != r103) goto L12;
        boolean r104 = true;
    L14:
        if (r112 == true) goto L16;
    L18:
        boolean r105 = false;
    L19:
        if (r104 == true) goto L21;
    L23:
        boolean r106 = false;
    L24:
        if (r112 == true) goto L26;
    L36:
        if (r104 == false) goto L49;
        if (r100.hasDanglingDimension(1) == false) goto L49;
        if (r100.mMatchConstraintDefaultHeight != 0) goto L49;
        if (r106 == true) goto L49;
        r102.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r112 == true) goto L45;
    L47:
        r104 = false;
        goto L49
    L45:
        if (r100.mMatchConstraintDefaultWidth != 0) goto L47;
        r102.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
    L49:
        if (r100.isResolvedHorizontally() == false) goto L52;
        r102.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r112 = false;
    L52:
        if (r100.isResolvedVertically() == false) goto L55;
        r102.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r104 = false;
    L55:
        if (r105 == true) goto L57;
    L70:
        if (r106 == true) goto L72;
    L85:
        r101.measure(r100, r102);
        r100.setWidth(r102.measuredWidth);
        r100.setHeight(r102.measuredHeight);
        r100.setHasBaseline(r102.measuredHasBaseline);
        r100.setBaselineDistance(r102.measuredBaseline);
        r102.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
        return r102.measuredNeedsSolverPass;
    L72:
        if (r100.mResolvedMatchConstraintDefault[1] != 4) goto L74;
        r102.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L85
    L74:
        if (r112 == true) goto L85;
        ConstraintWidget.DimensionBehaviour r113 = r102.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour r107 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r113 != r107) goto L78;
        int r114 = r102.horizontalDimension;
    L79:
        r102.verticalBehavior = r107;
        int r108 = r100.mDimensionRatioSide;
        if (r108 == 0) goto L84;
        if (r108 == (-1)) goto L84;
        r102.verticalDimension = (int) (r114 * r100.getDimensionRatio());
    L84:
        r102.verticalDimension = (int) (r114 / r100.getDimensionRatio());
        goto L85
    L78:
        r102.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r101.measure(r100, r102);
        r114 = r102.measuredWidth;
        goto L79
    L57:
        if (r100.mResolvedMatchConstraintDefault[0] != 4) goto L59;
        r102.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L70
    L59:
        if (r104 == true) goto L70;
        ConstraintWidget.DimensionBehaviour r109 = r102.verticalBehavior;
        ConstraintWidget.DimensionBehaviour r115 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r109 != r115) goto L63;
        int r116 = r102.verticalDimension;
    L64:
        r102.horizontalBehavior = r115;
        int r117 = r100.mDimensionRatioSide;
        if (r117 == 0) goto L69;
        if (r117 == (-1)) goto L69;
        r102.horizontalDimension = (int) (r100.getDimensionRatio() / r116);
    L69:
        r102.horizontalDimension = (int) (r100.getDimensionRatio() * r116);
        goto L70
    L63:
        r102.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r101.measure(r100, r102);
        r116 = r102.measuredHeight;
        goto L64
    L26:
        if (r100.hasDanglingDimension(0) == false) goto L36;
        if (r100.mMatchConstraintDefaultWidth != 0) goto L36;
        if (r105 == true) goto L36;
        r102.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r104 == true) goto L33;
    L35:
        r112 = false;
        goto L36
    L33:
        if (r100.mMatchConstraintDefaultHeight != 0) goto L35;
        r102.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L35
    L21:
        if (r100.mDimensionRatio <= 0.0f) goto L23;
        r106 = true;
        goto L24
    L16:
        if (r100.mDimensionRatio <= 0.0f) goto L18;
        r105 = true;
        goto L19
    L12:
        r104 = false;
        goto L14
    L8:
        r112 = false;
        goto L10
    }

    public void setPadding(int r100, int r101, int r102, int r103) {
        this.mPaddingLeft = r100;
        this.mPaddingTop = r101;
        this.mPaddingRight = r102;
        this.mPaddingBottom = r103;
    }

    public long measure(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r210, int r211) {
        this.mPaddingLeft = r210;
        this.mPaddingTop = r211;
        return this.mBasicMeasureSolver.solverMeasure(this, r110, r210, r211, r111, r112, r113, r114, r115, r116);
    }
}
