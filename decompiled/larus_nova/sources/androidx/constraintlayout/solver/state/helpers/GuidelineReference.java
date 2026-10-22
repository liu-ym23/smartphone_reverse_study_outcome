package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.Reference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;

/* JADX INFO: loaded from: classes17.dex */
public class GuidelineReference implements Reference {
    private Object key;
    private int mEnd;
    private Guideline mGuidelineWidget;
    private int mOrientation;
    private float mPercent;
    private int mStart;
    final State mState;

    @Override // androidx.constraintlayout.solver.state.Reference
    public void apply() {
        this.mGuidelineWidget.setOrientation(this.mOrientation);
        int r100 = this.mStart;
        if (r100 == (-1)) goto L5;
        this.mGuidelineWidget.setGuideBegin(r100);
        return;
    L5:
        int r101 = this.mEnd;
        if (r101 == (-1)) goto L8;
        this.mGuidelineWidget.setGuideEnd(r101);
        return;
    L8:
        this.mGuidelineWidget.setGuidePercent(this.mPercent);
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.mGuidelineWidget != null) goto L6;
        this.mGuidelineWidget = new Guideline();
    L6:
        return this.mGuidelineWidget;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public Object getKey() {
        return this.key;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public GuidelineReference(State r100) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = 0.0f;
        this.mState = r100;
    }

    public void end(Object r100) {
        this.mStart = -1;
        this.mEnd = this.mState.convertDimension(r100);
        this.mPercent = 0.0f;
    }

    public void percent(float r100) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = r100;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setConstraintWidget(ConstraintWidget r100) {
        if ((r100 instanceof Guideline) == false) goto L5;
        this.mGuidelineWidget = (Guideline) r100;
        return;
    L5:
        this.mGuidelineWidget = null;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setKey(Object r100) {
        this.key = r100;
    }

    public void setOrientation(int r100) {
        this.mOrientation = r100;
    }

    public void start(Object r100) {
        this.mStart = this.mState.convertDimension(r100);
        this.mEnd = -1;
        this.mPercent = 0.0f;
    }
}
