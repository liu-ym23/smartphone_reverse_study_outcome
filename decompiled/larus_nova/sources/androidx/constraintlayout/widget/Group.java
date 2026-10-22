package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes17.dex */
public class Group extends ConstraintHelper {
    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        applyLayoutFeatures();
    }

    public Group(Context r100) {
        super(r100);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r100) {
        super.init(r100);
        this.mUseViewMeasure = false;
    }

    @Override // android.view.View
    public void setElevation(float r100) {
        super.setElevation(r100);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r101.widget.setWidth(0);
        r101.widget.setHeight(0);
    }

    public Group(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public Group(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
