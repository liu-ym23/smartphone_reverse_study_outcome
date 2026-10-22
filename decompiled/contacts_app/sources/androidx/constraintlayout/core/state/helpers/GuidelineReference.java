package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.Reference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* JADX INFO: loaded from: classes.dex */
public class GuidelineReference implements Facade, Reference {
    private Object key;
    private int mEnd;
    private Guideline mGuidelineWidget;
    private int mOrientation;
    private float mPercent;
    private int mStart;
    final State mState;

    @Override // androidx.constraintlayout.core.state.Reference
    public Facade getFacade() {
        return null;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setKey(Object r1) {
        this.key = r1;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Object getKey() {
        return this.key;
    }

    public GuidelineReference(State r2) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = 0.0f;
        this.mState = r2;
    }

    public GuidelineReference start(Object r2) {
        this.mStart = this.mState.convertDimension(r2);
        this.mEnd = -1;
        this.mPercent = 0.0f;
        return this;
    }

    public GuidelineReference end(Object r2) {
        this.mStart = -1;
        this.mEnd = this.mState.convertDimension(r2);
        this.mPercent = 0.0f;
        return this;
    }

    public GuidelineReference percent(float r2) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = r2;
        return this;
    }

    public void setOrientation(int r1) {
        this.mOrientation = r1;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @Override // androidx.constraintlayout.core.state.helpers.Facade, androidx.constraintlayout.core.state.Reference
    public void apply() {
        this.mGuidelineWidget.setOrientation(this.mOrientation);
        int r0 = this.mStart;
        if (r0 == (-1)) goto L5;
        this.mGuidelineWidget.setGuideBegin(r0);
        return;
    L5:
        int r1 = this.mEnd;
        if (r1 == (-1)) goto L8;
        this.mGuidelineWidget.setGuideEnd(r1);
        return;
    L8:
        this.mGuidelineWidget.setGuidePercent(this.mPercent);
    }

    @Override // androidx.constraintlayout.core.state.helpers.Facade, androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.mGuidelineWidget != null) goto L6;
        this.mGuidelineWidget = new Guideline();
    L6:
        return this.mGuidelineWidget;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setConstraintWidget(ConstraintWidget r2) {
        if ((r2 instanceof Guideline) == false) goto L5;
        this.mGuidelineWidget = (Guideline) r2;
        return;
    L5:
        this.mGuidelineWidget = null;
    }
}
