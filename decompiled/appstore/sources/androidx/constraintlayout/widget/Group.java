package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class Group extends ConstraintHelper {
    public Group(Context r10) {
        super(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void f(ConstraintLayout r10) {
        e(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        this.f2181e = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void n(ConstraintLayout r10) {
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r11.f2230v0.l1(0);
        r11.f2230v0.M0(0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.View
    public void setElevation(float r10) {
        super.setElevation(r10);
        d();
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        d();
    }

    public Group(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public Group(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
