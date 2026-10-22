package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.d;

/* JADX INFO: loaded from: classes4.dex */
public class Barrier extends ConstraintHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14039j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14040k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.widgets.a f14041l;

    public Barrier(Context r10) {
        super(r10);
        super.setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.f14041l.w1();
    }

    public int getMargin() {
        return this.f14041l.y1();
    }

    public int getType() {
        return this.f14039j;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        this.f14041l = new com.obric.oui.constraintlayout.core.widgets.a();
        if (r10 == null) goto L17;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L16;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.ConstraintLayout_Layout_barrierDirection) goto L10;
        setType(r11.getInt(r14, 0));
    L15:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) goto L13;
        this.f14041l.B1(r11.getBoolean(r14, true));
        goto L15
    L13:
        if (r14 != R$styleable.ConstraintLayout_Layout_barrierMargin) goto L15;
        this.f14041l.D1(r11.getDimensionPixelSize(r14, 0));
        goto L15
    L16:
        r11.recycle();
    L17:
        this.f14054d = this.f14041l;
        s();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void l(a.C0195a r10, wc.a r11, ConstraintLayout.LayoutParams r12, SparseArray r13) {
        super.l(r10, r11, r12, r13);
        if ((r11 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L6;
        com.obric.oui.constraintlayout.core.widgets.a r14 = (com.obric.oui.constraintlayout.core.widgets.a) r11;
        boolean r15 = ((d) r11.J()).S1();
        t(r14, r10.f14176e.f14209h0, r15);
        r14.B1(r10.f14176e.f14225p0);
        r14.D1(r10.f14176e.f14211i0);
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void m(ConstraintWidget r10, boolean r11) {
        t(r10, this.f14039j, r11);
    }

    public void setAllowsGoneWidget(boolean r10) {
        this.f14041l.B1(r10);
    }

    public void setDpMargin(int r10) {
        this.f14041l.D1((int) ((r10 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int r10) {
        this.f14041l.D1(r10);
    }

    public void setType(int r10) {
        this.f14039j = r10;
    }

    public final void t(ConstraintWidget r10, int r11, boolean r12) {
        this.f14040k = r11;
        if (r12 == false) goto L9;
        int r13 = this.f14039j;
        if (r13 != 5) goto L7;
        this.f14040k = 1;
    L15:
        if ((r10 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L18;
        ((com.obric.oui.constraintlayout.core.widgets.a) r10).C1(this.f14040k);
        return;
    L18:
        return;
    L7:
        if (r13 != 6) goto L15;
        this.f14040k = 0;
        goto L15
    L9:
        int r14 = this.f14039j;
        if (r14 != 5) goto L12;
        this.f14040k = 0;
        goto L15
    L12:
        if (r14 != 6) goto L15;
        this.f14040k = 1;
        goto L15
    }

    public Barrier(Context r10, AttributeSet r11) {
        super(r10, r11);
        super.setVisibility(8);
    }

    public Barrier(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        super.setVisibility(8);
    }
}
