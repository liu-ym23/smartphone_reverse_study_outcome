package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.g;
import androidx.constraintlayout.core.widgets.h;
import androidx.constraintlayout.widget.VirtualLayout;

/* JADX INFO: loaded from: classes.dex */
public class MotionPlaceholder extends VirtualLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f1720l;

    public MotionPlaceholder(Context r10) {
        super(r10);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        this.f2180d = new g();
        s();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onMeasure(int r10, int r11) {
        t(this.f1720l, r10, r11);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void q(ConstraintWidgetContainer r10, Helper r11, SparseArray r12) {
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void t(h r10, int r11, int r12) {
        int r13 = View.MeasureSpec.getMode(r11);
        int r14 = View.MeasureSpec.getSize(r11);
        int r15 = View.MeasureSpec.getMode(r12);
        int r16 = View.MeasureSpec.getSize(r12);
        if (r10 == null) goto L5;
        r10.D1(r13, r14, r15, r16);
        setMeasuredDimension(r10.y1(), r10.x1());
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public MotionPlaceholder(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public MotionPlaceholder(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
