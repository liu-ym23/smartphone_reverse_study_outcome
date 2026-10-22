package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public class ConstraintReference implements Reference {
    private Object key;
    Object mBaselineToBaseline;
    Object mBottomToBottom;
    Object mBottomToTop;
    private ConstraintWidget mConstraintWidget;
    Object mEndToEnd;
    Object mEndToStart;
    float mHorizontalBias;
    int mHorizontalChainStyle;
    Dimension mHorizontalDimension;
    State.Constraint mLast;
    Object mLeftToLeft;
    Object mLeftToRight;
    int mMarginBottom;
    int mMarginBottomGone;
    int mMarginEnd;
    int mMarginEndGone;
    int mMarginLeft;
    int mMarginLeftGone;
    int mMarginRight;
    int mMarginRightGone;
    int mMarginStart;
    int mMarginStartGone;
    int mMarginTop;
    int mMarginTopGone;
    Object mRightToLeft;
    Object mRightToRight;
    Object mStartToEnd;
    Object mStartToStart;
    final State mState;
    Object mTopToBottom;
    Object mTopToTop;
    float mVerticalBias;
    int mVerticalChainStyle;
    Dimension mVerticalDimension;
    private Object mView;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.state.ConstraintReference$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint = null;

        static {
            int[] r100 = new int[State.Constraint.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint = r100;
            r100[State.Constraint.LEFT_TO_LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L54:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.LEFT_TO_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.RIGHT_TO_LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L50:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L56:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.START_TO_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L40:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.START_TO_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L44:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.END_TO_START.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L62:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.END_TO_END.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L34:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.TOP_TO_TOP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L58:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.TOP_TO_BOTTOM.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L60:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.BOTTOM_TO_TOP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L29
        L46:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
        L52:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.BASELINE_TO_BASELINE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
        L36:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.CENTER_HORIZONTALLY.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
        L42:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.CENTER_VERTICALLY.ordinal()] = 15;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    public interface ConstraintReferenceFactory {
        ConstraintReference create(State r100);
    }

    public class IncorrectConstraintException extends Exception {
        private final ArrayList<String> mErrors;
        final /* synthetic */ ConstraintReference this$0;

        @Override // java.lang.Throwable
        public String toString() {
            return "IncorrectConstraintException: " + this.mErrors.toString();
        }

        public ArrayList<String> getErrors() {
            return this.mErrors;
        }

        public IncorrectConstraintException(ConstraintReference r100, ArrayList<String> r101) {
            this.this$0 = r100;
            this.mErrors = r101;
        }
    }

    private void dereference() {
        this.mLeftToLeft = get(this.mLeftToLeft);
        this.mLeftToRight = get(this.mLeftToRight);
        this.mRightToLeft = get(this.mRightToLeft);
        this.mRightToRight = get(this.mRightToRight);
        this.mStartToStart = get(this.mStartToStart);
        this.mStartToEnd = get(this.mStartToEnd);
        this.mEndToStart = get(this.mEndToStart);
        this.mEndToEnd = get(this.mEndToEnd);
        this.mTopToTop = get(this.mTopToTop);
        this.mTopToBottom = get(this.mTopToBottom);
        this.mBottomToTop = get(this.mBottomToTop);
        this.mBottomToBottom = get(this.mBottomToBottom);
        this.mBaselineToBaseline = get(this.mBaselineToBaseline);
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void apply() {
        ConstraintWidget r100 = this.mConstraintWidget;
        if (r100 != null) goto L5;
        return;
    L5:
        this.mHorizontalDimension.apply(this.mState, r100, 0);
        this.mVerticalDimension.apply(this.mState, this.mConstraintWidget, 1);
        dereference();
        applyConnection(this.mConstraintWidget, this.mLeftToLeft, State.Constraint.LEFT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mLeftToRight, State.Constraint.LEFT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mRightToLeft, State.Constraint.RIGHT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mRightToRight, State.Constraint.RIGHT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mStartToStart, State.Constraint.START_TO_START);
        applyConnection(this.mConstraintWidget, this.mStartToEnd, State.Constraint.START_TO_END);
        applyConnection(this.mConstraintWidget, this.mEndToStart, State.Constraint.END_TO_START);
        applyConnection(this.mConstraintWidget, this.mEndToEnd, State.Constraint.END_TO_END);
        applyConnection(this.mConstraintWidget, this.mTopToTop, State.Constraint.TOP_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mTopToBottom, State.Constraint.TOP_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBottomToTop, State.Constraint.BOTTOM_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mBottomToBottom, State.Constraint.BOTTOM_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBaselineToBaseline, State.Constraint.BASELINE_TO_BASELINE);
        int r101 = this.mHorizontalChainStyle;
        if (r101 == 0) goto L8;
        this.mConstraintWidget.setHorizontalChainStyle(r101);
    L8:
        int r102 = this.mVerticalChainStyle;
        if (r102 == 0) goto L11;
        this.mConstraintWidget.setVerticalChainStyle(r102);
    L11:
        this.mConstraintWidget.setHorizontalBiasPercent(this.mHorizontalBias);
        this.mConstraintWidget.setVerticalBiasPercent(this.mVerticalBias);
    }

    public ConstraintReference baseline() {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference bottom() {
        if (this.mBottomToTop == null) goto L5;
        this.mLast = State.Constraint.BOTTOM_TO_TOP;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
        goto L6
    }

    public ConstraintReference clear() {
        State.Constraint r100 = this.mLast;
        if (r100 != null) goto L5;
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mMarginLeft = 0;
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mMarginRight = 0;
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mMarginStart = 0;
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mMarginEnd = 0;
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mMarginTop = 0;
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mMarginBottom = 0;
        this.mBaselineToBaseline = null;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
        this.mMarginBottomGone = 0;
    L15:
        return this;
    L5:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[r100.ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L7;
            default: goto L15;
        };
    L7:
        this.mBaselineToBaseline = null;
        goto L15
    L8:
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mMarginBottom = 0;
        this.mMarginBottomGone = 0;
        goto L15
    L9:
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mMarginTop = 0;
        this.mMarginTopGone = 0;
        goto L15
    L10:
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mMarginEnd = 0;
        this.mMarginEndGone = 0;
        goto L15
    L11:
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mMarginStart = 0;
        this.mMarginStartGone = 0;
        goto L15
    L12:
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mMarginRight = 0;
        this.mMarginRightGone = 0;
        goto L15
    L13:
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mMarginLeft = 0;
        this.mMarginLeftGone = 0;
        goto L15
    }

    public ConstraintWidget createConstraintWidget() {
        return new ConstraintWidget(getWidth().getValue(), getHeight().getValue());
    }

    public ConstraintReference end() {
        if (this.mEndToStart == null) goto L5;
        this.mLast = State.Constraint.END_TO_START;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.END_TO_END;
        goto L6
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.mConstraintWidget != null) goto L6;
        ConstraintWidget r100 = createConstraintWidget();
        this.mConstraintWidget = r100;
        r100.setCompanionWidget(this.mView);
    L6:
        return this.mConstraintWidget;
    }

    public ConstraintReference left() {
        if (this.mLeftToLeft == null) goto L5;
        this.mLast = State.Constraint.LEFT_TO_LEFT;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.LEFT_TO_RIGHT;
        goto L6
    }

    public ConstraintReference right() {
        if (this.mRightToLeft == null) goto L5;
        this.mLast = State.Constraint.RIGHT_TO_LEFT;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.RIGHT_TO_RIGHT;
        goto L6
    }

    public ConstraintReference start() {
        if (this.mStartToStart == null) goto L5;
        this.mLast = State.Constraint.START_TO_START;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.START_TO_END;
        goto L6
    }

    public ConstraintReference top() {
        if (this.mTopToTop == null) goto L5;
        this.mLast = State.Constraint.TOP_TO_TOP;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.TOP_TO_BOTTOM;
        goto L6
    }

    public void validate() throws IncorrectConstraintException {
        ArrayList r100 = new ArrayList();
        if (this.mLeftToLeft == null) goto L8;
        if (this.mLeftToRight == null) goto L8;
        r100.add("LeftToLeft and LeftToRight both defined");
    L8:
        if (this.mRightToLeft == null) goto L13;
        if (this.mRightToRight == null) goto L13;
        r100.add("RightToLeft and RightToRight both defined");
    L13:
        if (this.mStartToStart == null) goto L18;
        if (this.mStartToEnd == null) goto L18;
        r100.add("StartToStart and StartToEnd both defined");
    L18:
        if (this.mEndToStart == null) goto L23;
        if (this.mEndToEnd == null) goto L23;
        r100.add("EndToStart and EndToEnd both defined");
    L23:
        if (this.mLeftToLeft != null) goto L31;
        if (this.mLeftToRight != null) goto L31;
        if (this.mRightToLeft != null) goto L31;
        if (this.mRightToRight != null) goto L31;
    L40:
        if (r100.size() > 0) goto L43;
        return;
    L43:
        throw new IncorrectConstraintException(this, r100);
    L31:
        if (this.mStartToStart == null) goto L33;
    L38:
        r100.add("Both left/right and start/end constraints defined");
        goto L40
    L33:
        if (this.mStartToEnd != null) goto L38;
        if (this.mEndToStart != null) goto L38;
        if (this.mEndToEnd == null) goto L40;
        goto L38
    }

    public ConstraintReference clearHorizontal() {
        start().clear();
        end().clear();
        left().clear();
        right().clear();
        return this;
    }

    public ConstraintReference clearVertical() {
        top().clear();
        baseline().clear();
        bottom().clear();
        return this;
    }

    public Dimension getHeight() {
        return this.mVerticalDimension;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public Object getKey() {
        return this.key;
    }

    public Object getView() {
        return this.mView;
    }

    public Dimension getWidth() {
        return this.mHorizontalDimension;
    }

    public ConstraintReference(State r100) {
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mMarginLeft = 0;
        this.mMarginRight = 0;
        this.mMarginStart = 0;
        this.mMarginEnd = 0;
        this.mMarginTop = 0;
        this.mMarginBottom = 0;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
        this.mMarginBottomGone = 0;
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mBaselineToBaseline = null;
        this.mLast = null;
        Object r101 = Dimension.WRAP_DIMENSION;
        this.mHorizontalDimension = Dimension.Fixed(r101);
        this.mVerticalDimension = Dimension.Fixed(r101);
        this.mState = r100;
    }

    private Object get(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof ConstraintReference) == false) goto L8;
        return r100;
    L8:
        return this.mState.reference(r100);
    }

    private ConstraintWidget getTarget(Object r100) {
        if ((r100 instanceof Reference) == true) goto L5;
        return null;
    L5:
        return ((Reference) r100).getConstraintWidget();
    }

    public ConstraintReference baselineToBaseline(Object r100) {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        this.mBaselineToBaseline = r100;
        return this;
    }

    public ConstraintReference bias(float r100) {
        State.Constraint r101 = this.mLast;
        if (r101 != null) goto L6;
        return this;
    L6:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[r101.ordinal()]) {
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L8;
            default: goto L10;
        };
    L8:
        this.mVerticalBias = r100;
        goto L10
    L9:
        this.mHorizontalBias = r100;
    L10:
        return this;
    }

    public ConstraintReference bottomToBottom(Object r100) {
        this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
        this.mBottomToBottom = r100;
        return this;
    }

    public ConstraintReference bottomToTop(Object r100) {
        this.mLast = State.Constraint.BOTTOM_TO_TOP;
        this.mBottomToTop = r100;
        return this;
    }

    public ConstraintReference centerHorizontally(Object r100) {
        Object r101 = get(r100);
        this.mStartToStart = r101;
        this.mEndToEnd = r101;
        this.mLast = State.Constraint.CENTER_HORIZONTALLY;
        this.mHorizontalBias = 0.5f;
        return this;
    }

    public ConstraintReference centerVertically(Object r100) {
        Object r101 = get(r100);
        this.mTopToTop = r101;
        this.mBottomToBottom = r101;
        this.mLast = State.Constraint.CENTER_VERTICALLY;
        this.mVerticalBias = 0.5f;
        return this;
    }

    public ConstraintReference endToEnd(Object r100) {
        this.mLast = State.Constraint.END_TO_END;
        this.mEndToEnd = r100;
        return this;
    }

    public ConstraintReference endToStart(Object r100) {
        this.mLast = State.Constraint.END_TO_START;
        this.mEndToStart = r100;
        return this;
    }

    public int getVerticalChainStyle(int r100) {
        return this.mVerticalChainStyle;
    }

    public ConstraintReference height(Dimension r100) {
        return setHeight(r100);
    }

    public ConstraintReference horizontalBias(float r100) {
        this.mHorizontalBias = r100;
        return this;
    }

    public ConstraintReference leftToLeft(Object r100) {
        this.mLast = State.Constraint.LEFT_TO_LEFT;
        this.mLeftToLeft = r100;
        return this;
    }

    public ConstraintReference leftToRight(Object r100) {
        this.mLast = State.Constraint.LEFT_TO_RIGHT;
        this.mLeftToRight = r100;
        return this;
    }

    public ConstraintReference margin(int r100) {
        State.Constraint r101 = this.mLast;
        if (r101 != null) goto L5;
        this.mMarginLeft = r100;
        this.mMarginRight = r100;
        this.mMarginStart = r100;
        this.mMarginEnd = r100;
        this.mMarginTop = r100;
        this.mMarginBottom = r100;
    L14:
        return this;
    L5:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[r101.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L7;
            default: goto L14;
        };
    L7:
        this.mMarginBottom = r100;
        goto L14
    L8:
        this.mMarginTop = r100;
        goto L14
    L9:
        this.mMarginEnd = r100;
        goto L14
    L10:
        this.mMarginStart = r100;
        goto L14
    L11:
        this.mMarginRight = r100;
        goto L14
    L12:
        this.mMarginLeft = r100;
        goto L14
    }

    public ConstraintReference marginGone(int r100) {
        State.Constraint r101 = this.mLast;
        if (r101 != null) goto L5;
        this.mMarginLeftGone = r100;
        this.mMarginRightGone = r100;
        this.mMarginStartGone = r100;
        this.mMarginEndGone = r100;
        this.mMarginTopGone = r100;
        this.mMarginBottomGone = r100;
    L14:
        return this;
    L5:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[r101.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L7;
            default: goto L14;
        };
    L7:
        this.mMarginBottomGone = r100;
        goto L14
    L8:
        this.mMarginTopGone = r100;
        goto L14
    L9:
        this.mMarginEndGone = r100;
        goto L14
    L10:
        this.mMarginStartGone = r100;
        goto L14
    L11:
        this.mMarginRightGone = r100;
        goto L14
    L12:
        this.mMarginLeftGone = r100;
        goto L14
    }

    public ConstraintReference rightToLeft(Object r100) {
        this.mLast = State.Constraint.RIGHT_TO_LEFT;
        this.mRightToLeft = r100;
        return this;
    }

    public ConstraintReference rightToRight(Object r100) {
        this.mLast = State.Constraint.RIGHT_TO_RIGHT;
        this.mRightToRight = r100;
        return this;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setConstraintWidget(ConstraintWidget r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mConstraintWidget = r100;
        r100.setCompanionWidget(this.mView);
    }

    public ConstraintReference setHeight(Dimension r100) {
        this.mVerticalDimension = r100;
        return this;
    }

    public void setHorizontalChainStyle(int r100) {
        this.mHorizontalChainStyle = r100;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setKey(Object r100) {
        this.key = r100;
    }

    public void setVerticalChainStyle(int r100) {
        this.mVerticalChainStyle = r100;
    }

    public void setView(Object r100) {
        this.mView = r100;
        ConstraintWidget r101 = this.mConstraintWidget;
        if (r101 == null) goto L6;
        r101.setCompanionWidget(r100);
        return;
    }

    public ConstraintReference setWidth(Dimension r100) {
        this.mHorizontalDimension = r100;
        return this;
    }

    public ConstraintReference startToEnd(Object r100) {
        this.mLast = State.Constraint.START_TO_END;
        this.mStartToEnd = r100;
        return this;
    }

    public ConstraintReference startToStart(Object r100) {
        this.mLast = State.Constraint.START_TO_START;
        this.mStartToStart = r100;
        return this;
    }

    public ConstraintReference topToBottom(Object r100) {
        this.mLast = State.Constraint.TOP_TO_BOTTOM;
        this.mTopToBottom = r100;
        return this;
    }

    public ConstraintReference topToTop(Object r100) {
        this.mLast = State.Constraint.TOP_TO_TOP;
        this.mTopToTop = r100;
        return this;
    }

    public ConstraintReference verticalBias(float r100) {
        this.mVerticalBias = r100;
        return this;
    }

    public ConstraintReference width(Dimension r100) {
        return setWidth(r100);
    }

    public ConstraintReference margin(Object r100) {
        return margin(this.mState.convertDimension(r100));
    }

    private void applyConnection(ConstraintWidget r100, Object r101, State.Constraint r102) {
        ConstraintWidget r103 = getTarget(r101);
        if (r103 != null) goto L5;
        return;
    L5:
        int[] r104 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
        int r105 = r104[r102.ordinal()];
        switch(r104[r102.ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            default: goto L34;
        };
    L8:
        ConstraintAnchor.Type r106 = ConstraintAnchor.Type.BASELINE;
        r100.immediateConnect(r106, r103, r106, 0, 0);
        return;
    L9:
        ConstraintAnchor.Type r107 = ConstraintAnchor.Type.BOTTOM;
        r100.getAnchor(r107).connect(r103.getAnchor(r107), this.mMarginBottom, this.mMarginBottomGone, false);
        return;
    L10:
        r100.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(r103.getAnchor(ConstraintAnchor.Type.TOP), this.mMarginBottom, this.mMarginBottomGone, false);
        return;
    L11:
        r100.getAnchor(ConstraintAnchor.Type.TOP).connect(r103.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mMarginTop, this.mMarginTopGone, false);
        return;
    L12:
        ConstraintAnchor.Type r108 = ConstraintAnchor.Type.TOP;
        r100.getAnchor(r108).connect(r103.getAnchor(r108), this.mMarginTop, this.mMarginTopGone, false);
        return;
    L13:
        ConstraintAnchor.Type r109 = ConstraintAnchor.Type.RIGHT;
        r100.getAnchor(r109).connect(r103.getAnchor(r109), this.mMarginEnd, this.mMarginEndGone, false);
        return;
    L14:
        r100.getAnchor(ConstraintAnchor.Type.RIGHT).connect(r103.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginEnd, this.mMarginEndGone, false);
        return;
    L15:
        r100.getAnchor(ConstraintAnchor.Type.LEFT).connect(r103.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginStart, this.mMarginStartGone, false);
        return;
    L16:
        ConstraintAnchor.Type r110 = ConstraintAnchor.Type.LEFT;
        r100.getAnchor(r110).connect(r103.getAnchor(r110), this.mMarginStart, this.mMarginStartGone, false);
        return;
    L17:
        ConstraintAnchor.Type r111 = ConstraintAnchor.Type.RIGHT;
        r100.getAnchor(r111).connect(r103.getAnchor(r111), this.mMarginRight, this.mMarginRightGone, false);
        return;
    L18:
        r100.getAnchor(ConstraintAnchor.Type.RIGHT).connect(r103.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginRight, this.mMarginRightGone, false);
        return;
    L19:
        r100.getAnchor(ConstraintAnchor.Type.LEFT).connect(r103.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginLeft, this.mMarginLeftGone, false);
        return;
    L20:
        ConstraintAnchor.Type r112 = ConstraintAnchor.Type.LEFT;
        r100.getAnchor(r112).connect(r103.getAnchor(r112), this.mMarginLeft, this.mMarginLeftGone, false);
        return;
    }
}
