package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class Guideline extends View {
    private boolean mFilterRedundantCalls;

    @Override // android.view.View
    public void draw(Canvas r1) {
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
    }

    public Guideline(Context r1) {
        super(r1);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    protected void onMeasure(int r1, int r2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int r3) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls == true) goto L5;
    L7:
        r0.guideBegin = r3;
        setLayoutParams(r0);
        return;
    L5:
        if (r0.guideBegin != r3) goto L7;
    }

    public void setGuidelineEnd(int r3) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls == true) goto L5;
    L7:
        r0.guideEnd = r3;
        setLayoutParams(r0);
        return;
    L5:
        if (r0.guideEnd != r3) goto L7;
    }

    public void setGuidelinePercent(float r3) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls == true) goto L5;
    L7:
        r0.guidePercent = r3;
        setLayoutParams(r0);
        return;
    L5:
        if (r0.guidePercent != r3) goto L7;
    }

    public void setFilterRedundantCalls(boolean r1) {
        this.mFilterRedundantCalls = r1;
    }
}
