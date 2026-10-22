package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class Guideline extends View {
    @Override // android.view.View
    public void draw(Canvas r100) {
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
    }

    public Guideline(Context r100) {
        super(r100);
        super.setVisibility(8);
    }

    public void setGuidelineBegin(int r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r101.guideBegin = r100;
        setLayoutParams(r101);
    }

    public void setGuidelineEnd(int r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r101.guideEnd = r100;
        setLayoutParams(r101);
    }

    public void setGuidelinePercent(float r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r101.guidePercent = r100;
        setLayoutParams(r101);
    }

    public Guideline(Context r100, AttributeSet r101) {
        super(r100, r101);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        setMeasuredDimension(0, 0);
    }

    public Guideline(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        super.setVisibility(8);
    }

    public Guideline(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102);
        super.setVisibility(8);
    }
}
