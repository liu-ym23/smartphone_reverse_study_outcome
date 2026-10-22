package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Guideline extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNWON = -1;
    public static final int VERTICAL = 1;
    private ConstraintAnchor mAnchor;
    private int mMinimumPosition;
    private int mOrientation;
    protected int mRelativeBegin;
    protected int mRelativeEnd;
    protected float mRelativePercent;
    private boolean resolved;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.Guideline$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r100 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = r100;
            r100[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "Guideline";
    }

    public void cyclePosition() {
        if (this.mRelativeBegin == (-1)) goto L6;
        inferRelativePercentPosition();
        return;
    L6:
        if (this.mRelativePercent == (-1.0f)) goto L9;
        inferRelativeEndPosition();
        return;
    L9:
        if (this.mRelativeEnd == (-1)) goto L14;
        inferRelativeBeginPosition();
        return;
    }

    public int getRelativeBehaviour() {
        if (this.mRelativePercent == (-1.0f)) goto L7;
        return 0;
    L7:
        if (this.mRelativeBegin == (-1)) goto L11;
        return 1;
    L11:
        if (this.mRelativeEnd == (-1)) goto L14;
        return 2;
    L14:
        return -1;
    }

    public boolean isPercent() {
        if (this.mRelativePercent != (-1.0f)) goto L5;
    L9:
        return false;
    L5:
        if (this.mRelativeBegin != (-1)) goto L9;
        if (this.mRelativeEnd != (-1)) goto L9;
        return true;
    }

    public Guideline() {
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = -1;
        this.mAnchor = this.mTop;
        int r100 = 0;
        this.mOrientation = 0;
        this.mMinimumPosition = 0;
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int r101 = this.mListAnchors.length;
    L3:
        if (r100 >= r101) goto L5;
        this.mListAnchors[r100] = this.mAnchor;
        r100 = r100 + 1;
        goto L3
    }

    public void inferRelativeBeginPosition() {
        int r100 = getX();
        if (this.mOrientation != 0) goto L5;
        r100 = getY();
    L5:
        setGuideBegin(r100);
    }

    public void inferRelativeEndPosition() {
        int r100 = getParent().getWidth() - getX();
        if (this.mOrientation != 0) goto L5;
        r100 = getParent().getHeight() - getY();
    L5:
        setGuideEnd(r100);
    }

    public void inferRelativePercentPosition() {
        float r100 = getX() / getParent().getWidth();
        if (this.mOrientation != 0) goto L5;
        r100 = getY() / getParent().getHeight();
    L5:
        setGuidePercent(r100);
    }

    public ConstraintAnchor getAnchor() {
        return this.mAnchor;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getRelativeBegin() {
        return this.mRelativeBegin;
    }

    public int getRelativeEnd() {
        return this.mRelativeEnd;
    }

    public float getRelativePercent() {
        return this.mRelativePercent;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ConstraintAnchor getAnchor(ConstraintAnchor.Type r100) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r100.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            default: goto L16;
        };
    L5:
        return null;
    L8:
        if (this.mOrientation != 0) goto L16;
        return this.mAnchor;
    L12:
        if (this.mOrientation != 1) goto L16;
        return this.mAnchor;
    L16:
        throw new AssertionError(r100.name());
    }

    public void setFinalValue(int r100) {
        this.mAnchor.setFinalValue(r100);
        this.resolved = true;
    }

    public void setGuideBegin(int r100) {
        if (r100 <= (-1)) goto L6;
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = r100;
        this.mRelativeEnd = -1;
        return;
    }

    public void setGuideEnd(int r100) {
        if (r100 <= (-1)) goto L6;
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = r100;
        return;
    }

    public void setGuidePercent(float r100) {
        if (r100 <= (-1.0f)) goto L6;
        this.mRelativePercent = r100;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = -1;
        return;
    }

    public void setMinimumPosition(int r100) {
        this.mMinimumPosition = r100;
    }

    public void setOrientation(int r100) {
        if (this.mOrientation != r100) goto L5;
        return;
    L5:
        this.mOrientation = r100;
        this.mAnchors.clear();
        if (this.mOrientation != 1) goto L8;
        this.mAnchor = this.mLeft;
    L9:
        this.mAnchors.add(this.mAnchor);
        int r101 = this.mListAnchors.length;
        int r102 = 0;
    L10:
        if (r102 >= r101) goto L12;
        this.mListAnchors[r102] = this.mAnchor;
        r102 = r102 + 1;
        goto L10
    L12:
        return;
    L8:
        this.mAnchor = this.mTop;
        goto L9
    }

    public void setGuidePercent(int r100) {
        setGuidePercent(r100 / 100.0f);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r100, boolean r101) {
        ConstraintWidgetContainer r102 = (ConstraintWidgetContainer) getParent();
        if (r102 != null) goto L5;
        return;
    L5:
        ConstraintAnchor r103 = r102.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r104 = r102.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget r105 = this.mParent;
        boolean r106 = true;
        if (r105 != null) goto L8;
    L10:
        boolean r107 = false;
    L12:
        if (this.mOrientation != 0) goto L21;
        r103 = r102.getAnchor(ConstraintAnchor.Type.TOP);
        r104 = r102.getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintWidget r108 = this.mParent;
        if (r108 != null) goto L16;
    L18:
        r106 = false;
    L19:
        r107 = r106;
        goto L21
    L16:
        if (r108.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L18;
    L21:
        if (this.resolved == false) goto L35;
        if (this.mAnchor.hasFinalValue() == false) goto L35;
        SolverVariable r109 = r100.createObjectVariable(this.mAnchor);
        r100.addEquality(r109, this.mAnchor.getFinalValue());
        if (this.mRelativeBegin == (-1)) goto L29;
        if (r107 == false) goto L32;
        r100.addGreaterThan(r100.createObjectVariable(r104), r109, 0, 5);
    L32:
        this.resolved = false;
        return;
    L29:
        if (this.mRelativeEnd == (-1)) goto L32;
        if (r107 == false) goto L32;
        SolverVariable r110 = r100.createObjectVariable(r104);
        r100.addGreaterThan(r109, r100.createObjectVariable(r103), 0, 5);
        r100.addGreaterThan(r110, r109, 0, 5);
    L35:
        if (this.mRelativeBegin == (-1)) goto L40;
        SolverVariable r111 = r100.createObjectVariable(this.mAnchor);
        r100.addEquality(r111, r100.createObjectVariable(r103), this.mRelativeBegin, 8);
        if (r107 == false) goto L48;
        r100.addGreaterThan(r100.createObjectVariable(r104), r111, 0, 5);
        return;
    L48:
        return;
    L40:
        if (this.mRelativeEnd == (-1)) goto L45;
        SolverVariable r112 = r100.createObjectVariable(this.mAnchor);
        SolverVariable r113 = r100.createObjectVariable(r104);
        r100.addEquality(r112, r113, -this.mRelativeEnd, 8);
        if (r107 == false) goto L50;
        r100.addGreaterThan(r112, r100.createObjectVariable(r103), 0, 5);
        r100.addGreaterThan(r113, r112, 0, 5);
        return;
    L50:
        return;
    L45:
        if (this.mRelativePercent == (-1.0f)) goto L52;
        r100.addConstraint(LinearSystem.createRowDimensionPercent(r100, r100.createObjectVariable(this.mAnchor), r100.createObjectVariable(r104), this.mRelativePercent));
        return;
    L52:
        return;
    L8:
        if (r105.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L10;
        r107 = true;
        goto L12
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget r100, HashMap<ConstraintWidget, ConstraintWidget> r101) {
        super.copy(r100, r101);
        Guideline r102 = (Guideline) r100;
        this.mRelativePercent = r102.mRelativePercent;
        this.mRelativeBegin = r102.mRelativeBegin;
        this.mRelativeEnd = r102.mRelativeEnd;
        setOrientation(r102.mOrientation);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem r100, boolean r101) {
        if (getParent() != null) goto L5;
        return;
    L5:
        int r102 = r100.getObjectVariableValue(this.mAnchor);
        if (this.mOrientation != 1) goto L8;
        setX(r102);
        setY(0);
        setHeight(getParent().getHeight());
        setWidth(0);
        return;
    L8:
        setX(0);
        setY(r102);
        setWidth(getParent().getWidth());
        setHeight(0);
    }
}
