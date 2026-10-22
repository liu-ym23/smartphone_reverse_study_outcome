package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.android.contacts.common.SimContactsConstants;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.constraintlayout.core.widgets.Barrier;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.obric.oui.constraintlayout.core.widgets.Guideline;
import com.obric.oui.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class DependencyGraph {
    private static final boolean DEBUG = false;
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer mContainer;
    ArrayList<RunGroup> mGroups;
    private BasicMeasure.Measure mMeasure;
    private BasicMeasure.Measurer mMeasurer;
    private boolean mNeedBuildGraph;
    private boolean mNeedRedoMeasures;
    private ArrayList<RunGroup> mRunGroups;
    private ArrayList<WidgetRun> mRuns;
    private ConstraintWidgetContainer mWidgetcontainer;

    public DependencyGraph(ConstraintWidgetContainer r2) {
        this.mNeedBuildGraph = true;
        this.mNeedRedoMeasures = true;
        this.mRuns = new ArrayList();
        this.mRunGroups = new ArrayList();
        this.mMeasurer = null;
        this.mMeasure = new BasicMeasure.Measure();
        this.mGroups = new ArrayList();
        this.mWidgetcontainer = r2;
        this.mContainer = r2;
    }

    public void setMeasurer(BasicMeasure.Measurer r1) {
        this.mMeasurer = r1;
    }

    private int computeWrap(ConstraintWidgetContainer r7, int r8) {
        int r0 = this.mGroups.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1 = Math.max(r1, this.mGroups.get(r3).computeWrapSize(r7, r8));
        r3 = r3 + 1;
        goto L3
    L6:
        return (int) r1;
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour r7, ConstraintWidget.DimensionBehaviour r8) {
        if (this.mNeedBuildGraph == false) goto L23;
        buildGraph();
        Iterator<ConstraintWidget> r0 = this.mWidgetcontainer.mChildren.iterator();
        boolean r2 = false;
    L6:
        if (r0.hasNext() == false) goto L10;
        ConstraintWidget r3 = r0.next();
        r3.isTerminalWidget[0] = true;
        r3.isTerminalWidget[1] = true;
        if ((r3 instanceof Barrier) == false) goto L6;
        r2 = true;
        goto L6
    L10:
        if (r2 == true) goto L32;
        Iterator<RunGroup> r6 = this.mGroups.iterator();
    L13:
        if (r6.hasNext() == false) goto L33;
        RunGroup r1 = r6.next();
        if (r7 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L17;
        boolean r4 = true;
    L19:
        if (r8 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L21;
        boolean r5 = true;
    L22:
        r1.defineTerminalWidgets(r4, r5);
        goto L13
    L21:
        r5 = false;
        goto L22
    L17:
        r4 = false;
        goto L19
    L33:
        return;
    L32:
        return;
    }

    public boolean directMeasure(boolean r9) {
        boolean r0 = true;
        boolean r10 = r9 & true;
        if (this.mNeedBuildGraph == false) goto L5;
    L6:
        Iterator<ConstraintWidget> r1 = this.mWidgetcontainer.mChildren.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ConstraintWidget r3 = r1.next();
        r3.ensureWidgetRuns();
        r3.measured = false;
        r3.mHorizontalRun.reset();
        r3.mVerticalRun.reset();
        goto L8
    L10:
        this.mWidgetcontainer.ensureWidgetRuns();
        this.mWidgetcontainer.measured = false;
        this.mWidgetcontainer.mHorizontalRun.reset();
        this.mWidgetcontainer.mVerticalRun.reset();
        this.mNeedRedoMeasures = false;
    L12:
        if (basicMeasureWidgets(this.mContainer) == false) goto L14;
        return false;
    L14:
        this.mWidgetcontainer.setX(0);
        this.mWidgetcontainer.setY(0);
        ConstraintWidget.DimensionBehaviour r2 = this.mWidgetcontainer.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r4 = this.mWidgetcontainer.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph == false) goto L17;
        buildGraph();
    L17:
        int r5 = this.mWidgetcontainer.getX();
        int r6 = this.mWidgetcontainer.getY();
        this.mWidgetcontainer.mHorizontalRun.start.resolve(r5);
        this.mWidgetcontainer.mVerticalRun.start.resolve(r6);
        measureWidgets();
        if (r2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L20;
    L21:
        if (r10 == false) goto L28;
        Iterator<WidgetRun> r7 = this.mRuns.iterator();
    L24:
        if (r7.hasNext() == false) goto L28;
        if (r7.next().supportsWrapComputation() == true) goto L24;
        r10 = false;
    L28:
        if (r10 == true) goto L30;
    L32:
        if (r10 == true) goto L34;
    L37:
        if (this.mWidgetcontainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED) goto L39;
    L42:
        int r11 = this.mWidgetcontainer.getWidth() + r5;
        this.mWidgetcontainer.mHorizontalRun.end.resolve(r11);
        this.mWidgetcontainer.mHorizontalRun.mDimension.resolve(r11 - r5);
        measureWidgets();
        if (this.mWidgetcontainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L45;
    L46:
        int r12 = this.mWidgetcontainer.getHeight() + r6;
        this.mWidgetcontainer.mVerticalRun.end.resolve(r12);
        this.mWidgetcontainer.mVerticalRun.mDimension.resolve(r12 - r6);
    L47:
        measureWidgets();
        boolean r13 = true;
    L48:
        Iterator<WidgetRun> r8 = this.mRuns.iterator();
    L50:
        if (r8.hasNext() == false) goto L57;
        WidgetRun r14 = r8.next();
        if (r14.mWidget != this.mWidgetcontainer) goto L56;
        if (r14.mResolved == false) goto L50;
    L56:
        r14.applyToWidget();
        goto L50
    L57:
        Iterator<WidgetRun> r15 = this.mRuns.iterator();
    L59:
        if (r15.hasNext() == false) goto L80;
        WidgetRun r16 = r15.next();
        if (r13 == true) goto L66;
        if (r16.mWidget == this.mWidgetcontainer) goto L59;
    L66:
        if (r16.start.resolved == false) goto L67;
        if (r16.end.resolved == true) goto L74;
        if ((r16 instanceof GuidelineReference) == false) goto L67;
    L74:
        if (r16.mDimension.resolved == true) goto L59;
        if ((r16 instanceof ChainRun) == true) goto L59;
        if ((r16 instanceof GuidelineReference) == true) goto L59;
    L67:
        r0 = false;
    L80:
        this.mWidgetcontainer.setHorizontalDimensionBehaviour(r2);
        this.mWidgetcontainer.setVerticalDimensionBehaviour(r4);
        return r0;
    L45:
        if (this.mWidgetcontainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L47;
    L39:
        if (this.mWidgetcontainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L42;
        r13 = false;
        goto L48
    L34:
        if (r4 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L37;
        this.mWidgetcontainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r17 = this.mWidgetcontainer;
        r17.setHeight(computeWrap(r17, 1));
        this.mWidgetcontainer.mVerticalRun.mDimension.resolve(this.mWidgetcontainer.getHeight());
        goto L37
    L30:
        if (r2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L32;
        this.mWidgetcontainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r18 = this.mWidgetcontainer;
        r18.setWidth(computeWrap(r18, 0));
        this.mWidgetcontainer.mHorizontalRun.mDimension.resolve(this.mWidgetcontainer.getWidth());
        goto L32
    L20:
        if (r4 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L37;
    L5:
        if (this.mNeedRedoMeasures == false) goto L12;
        goto L6
    }

    public boolean directMeasureSetup(boolean r4) {
        if (this.mNeedBuildGraph == false) goto L10;
        Iterator<ConstraintWidget> r5 = this.mWidgetcontainer.mChildren.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        ConstraintWidget r1 = r5.next();
        r1.ensureWidgetRuns();
        r1.measured = false;
        r1.mHorizontalRun.mDimension.resolved = false;
        r1.mHorizontalRun.mResolved = false;
        r1.mHorizontalRun.reset();
        r1.mVerticalRun.mDimension.resolved = false;
        r1.mVerticalRun.mResolved = false;
        r1.mVerticalRun.reset();
        goto L6
    L8:
        this.mWidgetcontainer.ensureWidgetRuns();
        this.mWidgetcontainer.measured = false;
        this.mWidgetcontainer.mHorizontalRun.mDimension.resolved = false;
        this.mWidgetcontainer.mHorizontalRun.mResolved = false;
        this.mWidgetcontainer.mHorizontalRun.reset();
        this.mWidgetcontainer.mVerticalRun.mDimension.resolved = false;
        this.mWidgetcontainer.mVerticalRun.mResolved = false;
        this.mWidgetcontainer.mVerticalRun.reset();
        buildGraph();
    L10:
        if (basicMeasureWidgets(this.mContainer) == false) goto L12;
        return false;
    L12:
        this.mWidgetcontainer.setX(0);
        this.mWidgetcontainer.setY(0);
        this.mWidgetcontainer.mHorizontalRun.start.resolve(0);
        this.mWidgetcontainer.mVerticalRun.start.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean r10, int r11) {
        boolean r0 = true;
        boolean r12 = r10 & true;
        ConstraintWidget.DimensionBehaviour r1 = this.mWidgetcontainer.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r3 = this.mWidgetcontainer.getDimensionBehaviour(1);
        int r4 = this.mWidgetcontainer.getX();
        int r5 = this.mWidgetcontainer.getY();
        if (r12 == true) goto L5;
    L25:
        if (r11 != 0) goto L32;
        if (this.mWidgetcontainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED) goto L29;
    L30:
        int r13 = this.mWidgetcontainer.getWidth() + r4;
        this.mWidgetcontainer.mHorizontalRun.end.resolve(r13);
        this.mWidgetcontainer.mHorizontalRun.mDimension.resolve(r13 - r4);
    L38:
        boolean r14 = true;
    L39:
        measureWidgets();
        Iterator<WidgetRun> r6 = this.mRuns.iterator();
    L41:
        if (r6.hasNext() == false) goto L51;
        WidgetRun r7 = r6.next();
        if (r7.orientation != r11) goto L41;
        if (r7.mWidget != this.mWidgetcontainer) goto L50;
        if (r7.mResolved == false) goto L41;
    L50:
        r7.applyToWidget();
        goto L41
    L51:
        Iterator<WidgetRun> r8 = this.mRuns.iterator();
    L53:
        if (r8.hasNext() == false) goto L72;
        WidgetRun r9 = r8.next();
        if (r9.orientation != r11) goto L53;
        if (r14 == true) goto L62;
        if (r9.mWidget == this.mWidgetcontainer) goto L53;
    L62:
        if (r9.start.resolved == false) goto L63;
        if (r9.end.resolved == false) goto L63;
        if ((r9 instanceof ChainRun) == true) goto L53;
        if (r9.mDimension.resolved == true) goto L53;
    L63:
        r0 = false;
    L72:
        this.mWidgetcontainer.setHorizontalDimensionBehaviour(r1);
        this.mWidgetcontainer.setVerticalDimensionBehaviour(r3);
        return r0;
    L29:
        if (this.mWidgetcontainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L30;
    L36:
        r14 = false;
        goto L39
    L32:
        if (this.mWidgetcontainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L34;
    L37:
        int r15 = this.mWidgetcontainer.getHeight() + r5;
        this.mWidgetcontainer.mVerticalRun.end.resolve(r15);
        this.mWidgetcontainer.mVerticalRun.mDimension.resolve(r15 - r5);
        goto L38
    L34:
        if (this.mWidgetcontainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L36;
    L5:
        if (r1 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L7;
    L8:
        Iterator<WidgetRun> r16 = this.mRuns.iterator();
    L10:
        if (r16.hasNext() == false) goto L16;
        WidgetRun r17 = r16.next();
        if (r17.orientation != r11) goto L10;
        if (r17.supportsWrapComputation() == true) goto L10;
        r12 = false;
    L16:
        if (r11 != 0) goto L21;
        if (r12 == false) goto L25;
        if (r1 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
        this.mWidgetcontainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r18 = this.mWidgetcontainer;
        r18.setWidth(computeWrap(r18, 0));
        this.mWidgetcontainer.mHorizontalRun.mDimension.resolve(this.mWidgetcontainer.getWidth());
        goto L25
    L21:
        if (r12 == false) goto L25;
        if (r3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
        this.mWidgetcontainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r19 = this.mWidgetcontainer;
        r19.setHeight(computeWrap(r19, 1));
        this.mWidgetcontainer.mVerticalRun.mDimension.resolve(this.mWidgetcontainer.getHeight());
        goto L25
    L7:
        if (r3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
        goto L8
    }

    private void measure(ConstraintWidget r2, ConstraintWidget.DimensionBehaviour r3, int r4, ConstraintWidget.DimensionBehaviour r5, int r6) {
        this.mMeasure.horizontalBehavior = r3;
        this.mMeasure.verticalBehavior = r5;
        this.mMeasure.horizontalDimension = r4;
        this.mMeasure.verticalDimension = r6;
        this.mMeasurer.measure(r2, this.mMeasure);
        r2.setWidth(this.mMeasure.measuredWidth);
        r2.setHeight(this.mMeasure.measuredHeight);
        r2.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r2.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer r13) {
        Iterator<ConstraintWidget> r0 = r13.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L161;
        ConstraintWidget r1 = r0.next();
        ConstraintWidget.DimensionBehaviour r3 = r1.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r4 = r1.mListDimensionBehaviors[1];
        if (r1.getVisibility() == 8) goto L7;
        if (r1.mMatchConstraintPercentWidth >= 1.0f) goto L14;
        if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        r1.mMatchConstraintDefaultWidth = 2;
    L14:
        if (r1.mMatchConstraintPercentHeight >= 1.0f) goto L19;
        if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        r1.mMatchConstraintDefaultHeight = 2;
    L19:
        if (r1.getDimensionRatio() <= 0.0f) goto L45;
        if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L28;
        if (r4 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
    L26:
        r1.mMatchConstraintDefaultWidth = 3;
        goto L45
    L25:
        if (r4 == ConstraintWidget.DimensionBehaviour.FIXED) goto L26;
    L28:
        if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L35;
        if (r3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L32;
    L33:
        r1.mMatchConstraintDefaultHeight = 3;
        goto L45
    L32:
        if (r3 == ConstraintWidget.DimensionBehaviour.FIXED) goto L33;
    L35:
        if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L45;
        if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L45;
        if (r1.mMatchConstraintDefaultWidth != 0) goto L42;
        r1.mMatchConstraintDefaultWidth = 3;
    L42:
        if (r1.mMatchConstraintDefaultHeight != 0) goto L45;
        r1.mMatchConstraintDefaultHeight = 3;
    L45:
        if (r3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L47;
    L53:
        ConstraintWidget.DimensionBehaviour r5 = r3;
        if (r4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L56;
    L62:
        ConstraintWidget.DimensionBehaviour r8 = r4;
    L63:
        r1.mHorizontalRun.mDimensionBehavior = r5;
        r1.mHorizontalRun.matchConstraintsType = r1.mMatchConstraintDefaultWidth;
        r1.mVerticalRun.mDimensionBehavior = r8;
        r1.mVerticalRun.matchConstraintsType = r1.mMatchConstraintDefaultHeight;
        if (r5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L70;
        if (r5 == ConstraintWidget.DimensionBehaviour.FIXED) goto L70;
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L70;
    L77:
        if (r5 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L104;
        if (r8 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L83;
        if (r8 != ConstraintWidget.DimensionBehaviour.FIXED) goto L104;
    L83:
        if (r1.mMatchConstraintDefaultWidth == 3) goto L85;
        if (r1.mMatchConstraintDefaultWidth != 1) goto L92;
        measure(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, r8, 0);
        r1.mHorizontalRun.mDimension.wrapValue = r1.getWidth();
        goto L4
    L92:
        if (r1.mMatchConstraintDefaultWidth == 2) goto L94;
        if (r1.mListAnchors[0].mTarget == null) goto L102;
        if (r1.mListAnchors[1].mTarget != null) goto L104;
    L102:
        measure(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, r8, 0);
        r1.mHorizontalRun.mDimension.resolve(r1.getWidth());
        r1.mVerticalRun.mDimension.resolve(r1.getHeight());
        r1.measured = true;
        goto L4
    L94:
        if (r13.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED) goto L97;
        if (r13.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L104;
    L97:
        measure(r1, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((r1.mMatchConstraintPercentWidth * r13.getWidth()) + 0.5f), r8, r1.getHeight());
        r1.mHorizontalRun.mDimension.resolve(r1.getWidth());
        r1.mVerticalRun.mDimension.resolve(r1.getHeight());
        r1.measured = true;
        goto L4
    L85:
        if (r8 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L87;
        measure(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
    L87:
        int r9 = r1.getHeight();
        measure(r1, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((r9 * r1.mDimensionRatio) + 0.5f), ConstraintWidget.DimensionBehaviour.FIXED, r9);
        r1.mHorizontalRun.mDimension.resolve(r1.getWidth());
        r1.mVerticalRun.mDimension.resolve(r1.getHeight());
        r1.measured = true;
    L104:
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L134;
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L110;
        if (r5 != ConstraintWidget.DimensionBehaviour.FIXED) goto L134;
    L110:
        if (r1.mMatchConstraintDefaultHeight == 3) goto L112;
        if (r1.mMatchConstraintDefaultHeight != 1) goto L122;
        measure(r1, r5, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
        r1.mVerticalRun.mDimension.wrapValue = r1.getHeight();
        goto L4
    L122:
        if (r1.mMatchConstraintDefaultHeight == 2) goto L124;
        if (r1.mListAnchors[2].mTarget == null) goto L132;
        if (r1.mListAnchors[3].mTarget != null) goto L134;
    L132:
        measure(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, r8, 0);
        r1.mHorizontalRun.mDimension.resolve(r1.getWidth());
        r1.mVerticalRun.mDimension.resolve(r1.getHeight());
        r1.measured = true;
        goto L4
    L124:
        if (r13.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED) goto L127;
        if (r13.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L134;
    L127:
        float r2 = r1.mMatchConstraintPercentHeight;
        measure(r1, r5, r1.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, (int) ((r2 * r13.getHeight()) + 0.5f));
        r1.mHorizontalRun.mDimension.resolve(r1.getWidth());
        r1.mVerticalRun.mDimension.resolve(r1.getHeight());
        r1.measured = true;
        goto L4
    L112:
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L114;
        measure(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
    L114:
        int r6 = r1.getWidth();
        float r7 = r1.mDimensionRatio;
        if (r1.getDimensionRatioSide() != (-1)) goto L117;
        r7 = 1.0f / r7;
    L117:
        measure(r1, ConstraintWidget.DimensionBehaviour.FIXED, r6, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((r6 * r7) + 0.5f));
        r1.mHorizontalRun.mDimension.resolve(r1.getWidth());
        r1.mVerticalRun.mDimension.resolve(r1.getHeight());
        r1.measured = true;
    L134:
        if (r5 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L4;
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L4;
        if (r1.mMatchConstraintDefaultWidth == 1) goto L151;
        if (r1.mMatchConstraintDefaultHeight == 1) goto L151;
        if (r1.mMatchConstraintDefaultHeight != 2) goto L4;
        if (r1.mMatchConstraintDefaultWidth != 2) goto L4;
        if (r13.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED) goto L4;
        if (r13.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L4;
        float r10 = r1.mMatchConstraintPercentWidth;
        float r11 = r1.mMatchConstraintPercentHeight;
        measure(r1, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((r10 * r13.getWidth()) + 0.5f), ConstraintWidget.DimensionBehaviour.FIXED, (int) ((r11 * r13.getHeight()) + 0.5f));
        r1.mHorizontalRun.mDimension.resolve(r1.getWidth());
        r1.mVerticalRun.mDimension.resolve(r1.getHeight());
        r1.measured = true;
    L151:
        measure(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
        r1.mHorizontalRun.mDimension.wrapValue = r1.getWidth();
        r1.mVerticalRun.mDimension.wrapValue = r1.getHeight();
    L70:
        if (r8 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L152;
        if (r8 == ConstraintWidget.DimensionBehaviour.FIXED) goto L152;
        if (r8 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L77;
    L152:
        int r12 = r1.getWidth();
        if (r5 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L155;
        int r14 = (r13.getWidth() - r1.mLeft.mMargin) - r1.mRight.mMargin;
        r5 = ConstraintWidget.DimensionBehaviour.FIXED;
    L156:
        int r15 = r1.getHeight();
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L159;
        int r16 = (r13.getHeight() - r1.mTop.mMargin) - r1.mBottom.mMargin;
        ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.FIXED;
    L160:
        measure(r1, r5, r14, r17, r16);
        r1.mHorizontalRun.mDimension.resolve(r1.getWidth());
        r1.mVerticalRun.mDimension.resolve(r1.getHeight());
        r1.measured = true;
        goto L4
    L159:
        r17 = r8;
        r16 = r15;
        goto L160
    L155:
        r14 = r12;
        goto L156
    L56:
        if (r1.mMatchConstraintDefaultHeight != 1) goto L62;
        if (r1.mTop.mTarget != null) goto L60;
    L61:
        r8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L63
    L60:
        if (r1.mBottom.mTarget != null) goto L62;
    L47:
        if (r1.mMatchConstraintDefaultWidth != 1) goto L53;
        if (r1.mLeft.mTarget != null) goto L51;
    L52:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L53
    L51:
        if (r1.mRight.mTarget != null) goto L53;
    L7:
        r1.measured = true;
        goto L4
    L161:
        return false;
    }

    public void measureWidgets() {
        Iterator<ConstraintWidget> r0 = this.mWidgetcontainer.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L43;
        ConstraintWidget r1 = r0.next();
        if (r1.measured == true) goto L4;
        boolean r3 = false;
        ConstraintWidget.DimensionBehaviour r8 = r1.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r10 = r1.mListDimensionBehaviors[1];
        int r2 = r1.mMatchConstraintDefaultWidth;
        int r4 = r1.mMatchConstraintDefaultHeight;
        if (r8 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L11;
    L15:
        boolean r5 = true;
    L17:
        if (r10 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L19;
    L21:
        r3 = true;
    L22:
        boolean r6 = r1.mHorizontalRun.mDimension.resolved;
        boolean r7 = r1.mVerticalRun.mDimension.resolved;
        if (r6 == false) goto L26;
        if (r7 == false) goto L26;
        measure(r1, ConstraintWidget.DimensionBehaviour.FIXED, r1.mHorizontalRun.mDimension.value, ConstraintWidget.DimensionBehaviour.FIXED, r1.mVerticalRun.mDimension.value);
        r1.measured = true;
    L39:
        if (r1.measured == false) goto L4;
        if (r1.mVerticalRun.mBaselineDimension == null) goto L4;
        r1.mVerticalRun.mBaselineDimension.resolve(r1.getBaselineDistance());
    L26:
        if (r6 == false) goto L32;
        if (r3 == false) goto L32;
        measure(r1, ConstraintWidget.DimensionBehaviour.FIXED, r1.mHorizontalRun.mDimension.value, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, r1.mVerticalRun.mDimension.value);
        if (r10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L31;
        r1.mVerticalRun.mDimension.wrapValue = r1.getHeight();
        goto L39
    L31:
        r1.mVerticalRun.mDimension.resolve(r1.getHeight());
        r1.measured = true;
    L32:
        if (r7 == false) goto L39;
        if (r5 == false) goto L39;
        measure(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, r1.mHorizontalRun.mDimension.value, ConstraintWidget.DimensionBehaviour.FIXED, r1.mVerticalRun.mDimension.value);
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L37;
        r1.mHorizontalRun.mDimension.wrapValue = r1.getWidth();
        goto L39
    L37:
        r1.mHorizontalRun.mDimension.resolve(r1.getWidth());
        r1.measured = true;
        goto L39
    L19:
        if (r10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L22;
        if (r4 != 1) goto L22;
    L11:
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        if (r2 == 1) goto L15;
    L14:
        r5 = false;
        goto L17
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void buildGraph() {
        buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        findGroup(this.mWidgetcontainer.mHorizontalRun, 0, this.mGroups);
        findGroup(this.mWidgetcontainer.mVerticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void buildGraph(ArrayList<WidgetRun> r6) {
        r6.clear();
        this.mContainer.mHorizontalRun.clear();
        this.mContainer.mVerticalRun.clear();
        r6.add(this.mContainer.mHorizontalRun);
        r6.add(this.mContainer.mVerticalRun);
        Iterator<ConstraintWidget> r0 = this.mContainer.mChildren.iterator();
        HashSet r1 = null;
    L4:
        if (r0.hasNext() == false) goto L29;
        ConstraintWidget r2 = r0.next();
        if ((r2 instanceof Guideline) == true) goto L7;
        if (r2.isInHorizontalChain() == true) goto L11;
        r6.add(r2.mHorizontalRun);
    L18:
        if (r2.isInVerticalChain() == true) goto L20;
        r6.add(r2.mVerticalRun);
    L27:
        if ((r2 instanceof HelperWidget) == false) goto L4;
        r6.add(new HelperReferences(r2));
        goto L4
    L20:
        if (r2.verticalChainRun != null) goto L22;
        r2.verticalChainRun = new ChainRun(r2, 1);
    L22:
        if (r1 != null) goto L24;
        r1 = new HashSet();
    L24:
        r1.add(r2.verticalChainRun);
        goto L27
    L11:
        if (r2.horizontalChainRun != null) goto L13;
        r2.horizontalChainRun = new ChainRun(r2, 0);
    L13:
        if (r1 != null) goto L15;
        r1 = new HashSet();
    L15:
        r1.add(r2.horizontalChainRun);
        goto L18
    L7:
        r6.add(new GuidelineReference(r2));
        goto L4
    L29:
        if (r1 == null) goto L31;
        r6.addAll(r1);
    L31:
        Iterator<WidgetRun> r3 = r6.iterator();
    L33:
        if (r3.hasNext() == false) goto L35;
        r3.next().clear();
        goto L33
    L35:
        Iterator<WidgetRun> r7 = r6.iterator();
    L37:
        if (r7.hasNext() == false) goto L42;
        WidgetRun r4 = r7.next();
        if (r4.mWidget == this.mContainer) goto L37;
        r4.apply();
        goto L37
    }

    private void displayGraph() {
        Iterator<WidgetRun> r0 = this.mRuns.iterator();
        String r1 = "digraph {\n";
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = generateDisplayGraph(r0.next(), r1);
        goto L4
    L6:
        System.out.println("content:<<\n" + (r1 + "\n}\n") + "\n>>");
    }

    private void applyGroup(DependencyNode r9, int r10, int r11, DependencyNode r12, ArrayList<RunGroup> r13, RunGroup r14) {
        WidgetRun r15 = r9.mRun;
        if (r15.mRunGroup == null) goto L5;
        return;
    L5:
        if (r15 != this.mWidgetcontainer.mHorizontalRun) goto L7;
        return;
    L7:
        if (r15 == this.mWidgetcontainer.mVerticalRun) goto L80;
        if (r14 != null) goto L11;
        r14 = new RunGroup(r15, r11);
        r13.add(r14);
    L11:
        r15.mRunGroup = r14;
        r14.add(r15);
        Iterator<Dependency> r16 = r15.start.mDependencies.iterator();
    L13:
        if (r16.hasNext() == false) goto L17;
        Dependency r0 = r16.next();
        if ((r0 instanceof DependencyNode) == false) goto L13;
        applyGroup((DependencyNode) r0, r10, 0, r12, r13, r14);
        goto L13
    L17:
        Iterator<Dependency> r17 = r15.end.mDependencies.iterator();
    L19:
        if (r17.hasNext() == false) goto L24;
        Dependency r1 = r17.next();
        if ((r1 instanceof DependencyNode) == false) goto L19;
        applyGroup((DependencyNode) r1, r10, 1, r12, r13, r14);
        goto L19
    L24:
        if (r10 == 1) goto L26;
    L33:
        Iterator<DependencyNode> r7 = r15.start.mTargets.iterator();
    L35:
        if (r7.hasNext() == false) goto L40;
        DependencyNode r2 = r7.next();
        if (r2 != r12) goto L39;
        r14.dual = true;
    L39:
        applyGroup(r2, r10, 0, r12, r13, r14);
        goto L35
    L40:
        Iterator<DependencyNode> r8 = r15.end.mTargets.iterator();
    L42:
        if (r8.hasNext() == false) goto L47;
        DependencyNode r3 = r8.next();
        if (r3 != r12) goto L46;
        r14.dual = true;
    L46:
        applyGroup(r3, r10, 1, r12, r13, r14);
        goto L42
    L47:
        if (r10 == 1) goto L49;
        return;
    L49:
        if ((r15 instanceof VerticalWidgetRun) == false) goto L79;
        Iterator<DependencyNode> r18 = ((VerticalWidgetRun) r15).baseline.mTargets.iterator();
    L52:
        if (r18.hasNext() == false) goto L81;
        applyGroup(r18.next(), r10, 2, r12, r13, r14);
        goto L52
    L81:
        return;
    L79:
        return;
    L26:
        if ((r15 instanceof VerticalWidgetRun) == false) goto L33;
        Iterator<Dependency> r19 = ((VerticalWidgetRun) r15).baseline.mDependencies.iterator();
    L29:
        if (r19.hasNext() == false) goto L33;
        Dependency r4 = r19.next();
        if ((r4 instanceof DependencyNode) == false) goto L29;
        applyGroup((DependencyNode) r4, r10, 2, r12, r13, r14);
        goto L29
    }

    private void findGroup(WidgetRun r11, int r12, ArrayList<RunGroup> r13) {
        Iterator<Dependency> r0 = r11.start.mDependencies.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Dependency r1 = r0.next();
        if ((r1 instanceof DependencyNode) == true) goto L7;
        if ((r1 instanceof WidgetRun) == false) goto L4;
        applyGroup(((WidgetRun) r1).start, r12, 0, r11.end, r13, null);
        goto L4
    L7:
        applyGroup((DependencyNode) r1, r12, 0, r11.end, r13, null);
        goto L4
    L11:
        Iterator<Dependency> r2 = r11.end.mDependencies.iterator();
    L13:
        if (r2.hasNext() == false) goto L21;
        Dependency r3 = r2.next();
        if ((r3 instanceof DependencyNode) == true) goto L16;
        if ((r3 instanceof WidgetRun) == false) goto L13;
        applyGroup(((WidgetRun) r3).end, r12, 1, r11.start, r13, null);
        goto L13
    L16:
        applyGroup((DependencyNode) r3, r12, 1, r11.start, r13, null);
        goto L13
    L21:
        if (r12 != 1) goto L28;
        Iterator<Dependency> r14 = ((VerticalWidgetRun) r11).baseline.mDependencies.iterator();
    L24:
        if (r14.hasNext() == false) goto L50;
        Dependency r4 = r14.next();
        if ((r4 instanceof DependencyNode) == false) goto L24;
        applyGroup((DependencyNode) r4, r12, 2, null, r13, null);
        goto L24
    L50:
        return;
    }

    private String generateDisplayNode(DependencyNode r5, boolean r6, String r7) {
        StringBuilder r4 = new StringBuilder(r7);
        Iterator<DependencyNode> r8 = r5.mTargets.iterator();
    L4:
        if (r8.hasNext() == false) goto L23;
        DependencyNode r0 = r8.next();
        String r1 = ("\n" + r5.name()) + " -> " + r0.name();
        if (r5.mMargin > 0) goto L10;
        if (r6 == true) goto L10;
        if ((r5.mRun instanceof HelperReferences) == true) goto L10;
    L21:
        r4.append(r1 + "\n");
    L10:
        String r2 = r1 + "[";
        if (r5.mMargin <= 0) goto L15;
        r2 = r2 + "label=\"" + r5.mMargin + "\"";
        if (r6 == false) goto L15;
        r2 = r2 + SimContactsConstants.EMAIL_SEP;
    L15:
        if (r6 == false) goto L18;
        r2 = r2 + " style=dashed ";
    L18:
        if ((r5.mRun instanceof HelperReferences) == false) goto L20;
        r2 = r2 + " style=bold,color=gray ";
    L20:
        r1 = r2 + "]";
        goto L21
    L23:
        return r4.toString();
    }

    private String nodeDefinition(WidgetRun r8) {
        boolean r7 = r8 instanceof VerticalWidgetRun;
        String r0 = r8.mWidget.getDebugName();
        StringBuilder r1 = new StringBuilder(r0);
        if (r7 == true) goto L5;
        ConstraintWidget.DimensionBehaviour r2 = r8.mWidget.getHorizontalDimensionBehaviour();
    L6:
        RunGroup r3 = r8.mRunGroup;
        if (r7 == true) goto L9;
        r1.append("_HORIZONTAL");
    L10:
        r1.append(" [shape=none, label=<<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">  <TR>");
        if (r7 == true) goto L16;
        r1.append("    <TD ");
        if (r8.start.resolved == false) goto L15;
        r1.append(" BGCOLOR=\"green\"");
    L15:
        r1.append(" PORT=\"LEFT\" BORDER=\"1\">L</TD>");
    L20:
        r1.append("    <TD BORDER=\"1\" ");
        if (r8.mDimension.resolved == false) goto L26;
        if (r8.mWidget.measured == true) goto L26;
        r1.append(" BGCOLOR=\"green\" ");
    L32:
        if (r2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L34;
        r1.append("style=\"dashed\"");
    L34:
        r1.append(">");
        r1.append(r0);
        if (r3 == null) goto L37;
        r1.append(" [");
        r1.append(r3.mGroupIndex + 1);
        r1.append(LibrarianImpl.Constants.SEPARATOR);
        r1.append(RunGroup.index);
        r1.append("]");
    L37:
        r1.append(" </TD>");
        if (r7 == true) goto L43;
        r1.append("    <TD ");
        if (r8.end.resolved == false) goto L42;
        r1.append(" BGCOLOR=\"green\"");
    L42:
        r1.append(" PORT=\"RIGHT\" BORDER=\"1\">R</TD>");
    L50:
        r1.append("  </TR></TABLE>>];\n");
        return r1.toString();
    L43:
        r1.append("    <TD ");
        if (((VerticalWidgetRun) r8).baseline.resolved == false) goto L46;
        r1.append(" BGCOLOR=\"green\"");
    L46:
        r1.append(" PORT=\"BASELINE\" BORDER=\"1\">b</TD>    <TD ");
        if (r8.end.resolved == false) goto L49;
        r1.append(" BGCOLOR=\"green\"");
    L49:
        r1.append(" PORT=\"BOTTOM\" BORDER=\"1\">B</TD>");
    L26:
        if (r8.mDimension.resolved == false) goto L29;
        r1.append(" BGCOLOR=\"lightgray\" ");
        goto L32
    L29:
        if (r8.mWidget.measured == false) goto L32;
        r1.append(" BGCOLOR=\"yellow\" ");
        goto L32
    L16:
        r1.append("    <TD ");
        if (r8.start.resolved == false) goto L19;
        r1.append(" BGCOLOR=\"green\"");
    L19:
        r1.append(" PORT=\"TOP\" BORDER=\"1\">T</TD>");
        goto L20
    L9:
        r1.append("_VERTICAL");
        goto L10
    L5:
        r2 = r8.mWidget.getVerticalDimensionBehaviour();
        goto L6
    }

    private String generateChainDisplayGraph(ChainRun r6, String r7) {
        int r0 = r6.orientation;
        StringBuilder r1 = new StringBuilder("subgraph cluster_");
        r1.append(r6.mWidget.getDebugName());
        if (r0 != 0) goto L5;
        r1.append("_h");
    L6:
        r1.append(" {\n");
        Iterator<WidgetRun> r8 = r6.mWidgets.iterator();
        String r2 = "";
    L8:
        if (r8.hasNext() == false) goto L14;
        WidgetRun r3 = r8.next();
        r1.append(r3.mWidget.getDebugName());
        if (r0 != 0) goto L12;
        r1.append("_HORIZONTAL");
    L13:
        r1.append(";\n");
        r2 = generateDisplayGraph(r3, r2);
        goto L8
    L12:
        r1.append("_VERTICAL");
        goto L13
    L14:
        r1.append("}\n");
        return r7 + r2 + r1;
    L5:
        r1.append("_v");
        goto L6
    }

    private boolean isCenteredConnection(DependencyNode r4, DependencyNode r5) {
        Iterator<DependencyNode> r3 = r4.mTargets.iterator();
        int r1 = 0;
    L4:
        if (r3.hasNext() == false) goto L8;
        if (r3.next() == r5) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        Iterator<DependencyNode> r6 = r5.mTargets.iterator();
        int r7 = 0;
    L10:
        if (r6.hasNext() == false) goto L14;
        if (r6.next() == r4) goto L10;
        r7 = r7 + 1;
        goto L10
    L14:
        if (r1 <= 0) goto L28;
        if (r7 <= 0) goto L29;
        return true;
    L29:
        return false;
    L28:
        return false;
    }

    private String generateDisplayGraph(WidgetRun r10, String r11) {
        DependencyNode r0 = r10.start;
        DependencyNode r1 = r10.end;
        StringBuilder r2 = new StringBuilder(r11);
        if ((r10 instanceof HelperReferences) == false) goto L5;
    L13:
        r2.append(nodeDefinition(r10));
        boolean r3 = isCenteredConnection(r0, r1);
        String r12 = generateDisplayNode(r1, r3, generateDisplayNode(r0, r3, r11));
        boolean r4 = r10 instanceof VerticalWidgetRun;
        if (r4 == false) goto L17;
        r12 = generateDisplayNode(((VerticalWidgetRun) r10).baseline, r3, r12);
    L17:
        if ((r10 instanceof HorizontalWidgetRun) == true) goto L47;
        boolean r5 = r10 instanceof ChainRun;
        if (r5 == true) goto L21;
    L23:
        if (r4 == true) goto L27;
        if (r5 == false) goto L68;
        if (((ChainRun) r10).orientation == 1) goto L27;
    L68:
        if ((r10 instanceof ChainRun) == false) goto L72;
        return generateChainDisplayGraph((ChainRun) r10, r12);
    L72:
        return r2.toString();
    L27:
        ConstraintWidget.DimensionBehaviour r6 = r10.mWidget.getVerticalDimensionBehaviour();
        if (r6 == ConstraintWidget.DimensionBehaviour.FIXED) goto L38;
        if (r6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L38;
        if (r6 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L68;
        if (r10.mWidget.getDimensionRatio() <= 0.0f) goto L68;
        r2.append("\n");
        r2.append(r10.mWidget.getDebugName());
        r2.append("_VERTICAL -> ");
        r2.append(r10.mWidget.getDebugName());
        r2.append("_HORIZONTAL;\n");
    L38:
        if (r0.mTargets.isEmpty() == true) goto L43;
        if (r1.mTargets.isEmpty() == false) goto L43;
        r2.append("\n");
        r2.append(r1.name());
        r2.append(" -> ");
        r2.append(r0.name());
        r2.append("\n");
    L43:
        if (r0.mTargets.isEmpty() == false) goto L68;
        if (r1.mTargets.isEmpty() == true) goto L68;
        r2.append("\n");
        r2.append(r0.name());
        r2.append(" -> ");
        r2.append(r1.name());
        r2.append("\n");
        goto L68
    L21:
        if (((ChainRun) r10).orientation != 0) goto L23;
    L47:
        ConstraintWidget.DimensionBehaviour r7 = r10.mWidget.getHorizontalDimensionBehaviour();
        if (r7 == ConstraintWidget.DimensionBehaviour.FIXED) goto L58;
        if (r7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L58;
        if (r7 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L68;
        if (r10.mWidget.getDimensionRatio() <= 0.0f) goto L68;
        r2.append("\n");
        r2.append(r10.mWidget.getDebugName());
        r2.append("_HORIZONTAL -> ");
        r2.append(r10.mWidget.getDebugName());
        r2.append("_VERTICAL;\n");
    L58:
        if (r0.mTargets.isEmpty() == true) goto L63;
        if (r1.mTargets.isEmpty() == false) goto L63;
        r2.append("\n");
        r2.append(r1.name());
        r2.append(" -> ");
        r2.append(r0.name());
        r2.append("\n");
    L63:
        if (r0.mTargets.isEmpty() == false) goto L68;
        if (r1.mTargets.isEmpty() == true) goto L68;
        r2.append("\n");
        r2.append(r0.name());
        r2.append(" -> ");
        r2.append(r1.name());
        r2.append("\n");
        goto L68
    L5:
        if (r0.mDependencies.isEmpty() == false) goto L13;
        if (r1.mDependencies.isEmpty() == false) goto L13;
        if (r0.mTargets.isEmpty() == false) goto L13;
        if (r1.mTargets.isEmpty() == false) goto L13;
        return r11;
    }
}
