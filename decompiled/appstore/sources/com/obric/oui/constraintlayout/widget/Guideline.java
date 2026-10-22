package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class Guideline extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14149a;

    public Guideline(Context r10) {
        super(r10);
        this.f14149a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean r10) {
        this.f14149a = r10;
    }

    public void setGuidelineBegin(int r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f14149a == true) goto L5;
    L7:
        r11.f14086a = r10;
        setLayoutParams(r11);
        return;
    L5:
        if (r11.f14086a != r10) goto L7;
    }

    public void setGuidelineEnd(int r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f14149a == true) goto L5;
    L7:
        r11.f14088b = r10;
        setLayoutParams(r11);
        return;
    L5:
        if (r11.f14088b != r10) goto L7;
    }

    public void setGuidelinePercent(float r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f14149a == true) goto L5;
    L7:
        r11.f14090c = r10;
        setLayoutParams(r11);
        return;
    L5:
        if (r11.f14090c != r10) goto L7;
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
    }

    public Guideline(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f14149a = true;
        super.setVisibility(8);
    }

    public Guideline(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f14149a = true;
        super.setVisibility(8);
    }
}
