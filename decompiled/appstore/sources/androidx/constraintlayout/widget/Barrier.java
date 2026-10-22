package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends ConstraintHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.a f2167l;

    public Barrier(Context r10) {
        super(r10);
        super.setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.f2167l.v1();
    }

    public int getMargin() {
        return this.f2167l.x1();
    }

    public int getType() {
        return this.f2165j;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        this.f2167l = new androidx.constraintlayout.core.widgets.a();
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
        this.f2167l.A1(r11.getBoolean(r14, true));
        goto L15
    L13:
        if (r14 != R$styleable.ConstraintLayout_Layout_barrierMargin) goto L15;
        this.f2167l.C1(r11.getDimensionPixelSize(r14, 0));
        goto L15
    L16:
        r11.recycle();
    L17:
        this.f2180d = this.f2167l;
        s();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void l(ConstraintSet.a r10, k.a r11, ConstraintLayout.LayoutParams r12, SparseArray r13) {
        super.l(r10, r11, r12, r13);
        if ((r11 instanceof androidx.constraintlayout.core.widgets.a) == false) goto L6;
        androidx.constraintlayout.core.widgets.a r14 = (androidx.constraintlayout.core.widgets.a) r11;
        boolean r15 = ((ConstraintWidgetContainer) r11.J()).R1();
        t(r14, r10.f2277e.f2310h0, r15);
        r14.A1(r10.f2277e.f2326p0);
        r14.C1(r10.f2277e.f2312i0);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void m(ConstraintWidget r10, boolean r11) {
        t(r10, this.f2165j, r11);
    }

    public void setAllowsGoneWidget(boolean r10) {
        this.f2167l.A1(r10);
    }

    public void setDpMargin(int r10) {
        this.f2167l.C1((int) ((r10 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int r10) {
        this.f2167l.C1(r10);
    }

    public void setType(int r10) {
        this.f2165j = r10;
    }

    public final void t(ConstraintWidget r10, int r11, boolean r12) {
        this.f2166k = r11;
        if (r12 == false) goto L9;
        int r13 = this.f2165j;
        if (r13 != 5) goto L7;
        this.f2166k = 1;
    L15:
        if ((r10 instanceof androidx.constraintlayout.core.widgets.a) == false) goto L18;
        ((androidx.constraintlayout.core.widgets.a) r10).B1(this.f2166k);
        return;
    L18:
        return;
    L7:
        if (r13 != 6) goto L15;
        this.f2166k = 0;
        goto L15
    L9:
        int r14 = this.f2165j;
        if (r14 != 5) goto L12;
        this.f2166k = 0;
        goto L15
    L12:
        if (r14 != 6) goto L15;
        this.f2166k = 1;
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
