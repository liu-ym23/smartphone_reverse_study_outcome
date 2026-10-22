package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.obric.oui.constraintlayout.core.widgets.Helper;
import com.obric.oui.constraintlayout.core.widgets.d;
import com.obric.oui.constraintlayout.core.widgets.h;
import com.obric.oui.constraintlayout.core.widgets.i;
import com.obric.oui.constraintlayout.widget.VirtualLayout;

/* JADX INFO: loaded from: classes4.dex */
public class MotionPlaceholder extends VirtualLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h f13553l;

    public MotionPlaceholder(Context r10) {
        super(r10);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        this.f14054d = new h();
        s();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onMeasure(int r10, int r11) {
        t(this.f13553l, r10, r11);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void q(d r10, Helper r11, SparseArray r12) {
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout
    public void t(i r10, int r11, int r12) {
        int r13 = View.MeasureSpec.getMode(r11);
        int r14 = View.MeasureSpec.getSize(r11);
        int r15 = View.MeasureSpec.getMode(r12);
        int r16 = View.MeasureSpec.getSize(r12);
        if (r10 == null) goto L5;
        r10.E1(r13, r14, r15, r16);
        setMeasuredDimension(r10.z1(), r10.y1());
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
