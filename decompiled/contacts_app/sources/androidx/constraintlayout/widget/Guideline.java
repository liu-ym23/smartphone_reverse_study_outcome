package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends View {
    private boolean mFilterRedundantCalls;

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
    }

    public Guideline(Context context) {
        super(context);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int margin) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls == true) goto L5;
    L7:
        r0.guideBegin = margin;
        setLayoutParams(r0);
        return;
    L5:
        if (r0.guideBegin != margin) goto L7;
    }

    public void setGuidelineEnd(int margin) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls == true) goto L5;
    L7:
        r0.guideEnd = margin;
        setLayoutParams(r0);
        return;
    L5:
        if (r0.guideEnd != margin) goto L7;
    }

    public void setGuidelinePercent(float ratio) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.mFilterRedundantCalls == true) goto L5;
    L7:
        r0.guidePercent = ratio;
        setLayoutParams(r0);
        return;
    L5:
        if (r0.guidePercent != ratio) goto L7;
    }

    public void setFilterRedundantCalls(boolean filter) {
        this.mFilterRedundantCalls = filter;
    }
}
