package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.h;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import k.a;

/* JADX INFO: loaded from: classes.dex */
public class Flow extends VirtualLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d f1694l;

    public Flow(Context r10) {
        super(r10);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        this.f1694l = new d();
        if (r10 == null) goto L86;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L85;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.ConstraintLayout_Layout_android_orientation) goto L10;
        this.f1694l.E2(r11.getInt(r14, 0));
    L84:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R$styleable.ConstraintLayout_Layout_android_padding) goto L13;
        this.f1694l.J1(r11.getDimensionPixelSize(r14, 0));
        goto L84
    L13:
        if (r14 != R$styleable.ConstraintLayout_Layout_android_paddingStart) goto L16;
        this.f1694l.O1(r11.getDimensionPixelSize(r14, 0));
        goto L84
    L16:
        if (r14 != R$styleable.ConstraintLayout_Layout_android_paddingEnd) goto L19;
        this.f1694l.L1(r11.getDimensionPixelSize(r14, 0));
        goto L84
    L19:
        if (r14 != R$styleable.ConstraintLayout_Layout_android_paddingLeft) goto L22;
        this.f1694l.M1(r11.getDimensionPixelSize(r14, 0));
        goto L84
    L22:
        if (r14 != R$styleable.ConstraintLayout_Layout_android_paddingTop) goto L25;
        this.f1694l.P1(r11.getDimensionPixelSize(r14, 0));
        goto L84
    L25:
        if (r14 != R$styleable.ConstraintLayout_Layout_android_paddingRight) goto L28;
        this.f1694l.N1(r11.getDimensionPixelSize(r14, 0));
        goto L84
    L28:
        if (r14 != R$styleable.ConstraintLayout_Layout_android_paddingBottom) goto L31;
        this.f1694l.K1(r11.getDimensionPixelSize(r14, 0));
        goto L84
    L31:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_wrapMode) goto L34;
        this.f1694l.J2(r11.getInt(r14, 0));
        goto L84
    L34:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_horizontalStyle) goto L37;
        this.f1694l.y2(r11.getInt(r14, 0));
        goto L84
    L37:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_verticalStyle) goto L40;
        this.f1694l.I2(r11.getInt(r14, 0));
        goto L84
    L40:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) goto L43;
        this.f1694l.s2(r11.getInt(r14, 0));
        goto L84
    L43:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) goto L46;
        this.f1694l.A2(r11.getInt(r14, 0));
        goto L84
    L46:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) goto L49;
        this.f1694l.u2(r11.getInt(r14, 0));
        goto L84
    L49:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) goto L52;
        this.f1694l.C2(r11.getInt(r14, 0));
        goto L84
    L52:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_horizontalBias) goto L55;
        this.f1694l.w2(r11.getFloat(r14, 0.5f));
        goto L84
    L55:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) goto L58;
        this.f1694l.r2(r11.getFloat(r14, 0.5f));
        goto L84
    L58:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) goto L61;
        this.f1694l.z2(r11.getFloat(r14, 0.5f));
        goto L84
    L61:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_firstVerticalBias) goto L64;
        this.f1694l.t2(r11.getFloat(r14, 0.5f));
        goto L84
    L64:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_lastVerticalBias) goto L67;
        this.f1694l.B2(r11.getFloat(r14, 0.5f));
        goto L84
    L67:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_verticalBias) goto L70;
        this.f1694l.G2(r11.getFloat(r14, 0.5f));
        goto L84
    L70:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_horizontalAlign) goto L73;
        this.f1694l.v2(r11.getInt(r14, 2));
        goto L84
    L73:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_verticalAlign) goto L76;
        this.f1694l.F2(r11.getInt(r14, 2));
        goto L84
    L76:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_horizontalGap) goto L79;
        this.f1694l.x2(r11.getDimensionPixelSize(r14, 0));
        goto L84
    L79:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_verticalGap) goto L82;
        this.f1694l.H2(r11.getDimensionPixelSize(r14, 0));
        goto L84
    L82:
        if (r14 != R$styleable.ConstraintLayout_Layout_flow_maxElementsWrap) goto L84;
        this.f1694l.D2(r11.getInt(r14, -1));
        goto L84
    L85:
        r11.recycle();
    L86:
        this.f2180d = this.f1694l;
        s();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void l(ConstraintSet.a r10, a r11, ConstraintLayout.LayoutParams r12, SparseArray r13) {
        super.l(r10, r11, r12, r13);
        if ((r11 instanceof d) == false) goto L8;
        d r14 = (d) r11;
        int r15 = r12.Z;
        if (r15 == (-1)) goto L9;
        r14.E2(r15);
        return;
    L9:
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void m(ConstraintWidget r10, boolean r11) {
        this.f1694l.u1(r11);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onMeasure(int r10, int r11) {
        t(this.f1694l, r10, r11);
    }

    public void setFirstHorizontalBias(float r10) {
        this.f1694l.r2(r10);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int r10) {
        this.f1694l.s2(r10);
        requestLayout();
    }

    public void setFirstVerticalBias(float r10) {
        this.f1694l.t2(r10);
        requestLayout();
    }

    public void setFirstVerticalStyle(int r10) {
        this.f1694l.u2(r10);
        requestLayout();
    }

    public void setHorizontalAlign(int r10) {
        this.f1694l.v2(r10);
        requestLayout();
    }

    public void setHorizontalBias(float r10) {
        this.f1694l.w2(r10);
        requestLayout();
    }

    public void setHorizontalGap(int r10) {
        this.f1694l.x2(r10);
        requestLayout();
    }

    public void setHorizontalStyle(int r10) {
        this.f1694l.y2(r10);
        requestLayout();
    }

    public void setLastHorizontalBias(float r10) {
        this.f1694l.z2(r10);
        requestLayout();
    }

    public void setLastHorizontalStyle(int r10) {
        this.f1694l.A2(r10);
        requestLayout();
    }

    public void setLastVerticalBias(float r10) {
        this.f1694l.B2(r10);
        requestLayout();
    }

    public void setLastVerticalStyle(int r10) {
        this.f1694l.C2(r10);
        requestLayout();
    }

    public void setMaxElementsWrap(int r10) {
        this.f1694l.D2(r10);
        requestLayout();
    }

    public void setOrientation(int r10) {
        this.f1694l.E2(r10);
        requestLayout();
    }

    public void setPadding(int r10) {
        this.f1694l.J1(r10);
        requestLayout();
    }

    public void setPaddingBottom(int r10) {
        this.f1694l.K1(r10);
        requestLayout();
    }

    public void setPaddingLeft(int r10) {
        this.f1694l.M1(r10);
        requestLayout();
    }

    public void setPaddingRight(int r10) {
        this.f1694l.N1(r10);
        requestLayout();
    }

    public void setPaddingTop(int r10) {
        this.f1694l.P1(r10);
        requestLayout();
    }

    public void setVerticalAlign(int r10) {
        this.f1694l.F2(r10);
        requestLayout();
    }

    public void setVerticalBias(float r10) {
        this.f1694l.G2(r10);
        requestLayout();
    }

    public void setVerticalGap(int r10) {
        this.f1694l.H2(r10);
        requestLayout();
    }

    public void setVerticalStyle(int r10) {
        this.f1694l.I2(r10);
        requestLayout();
    }

    public void setWrapMode(int r10) {
        this.f1694l.J2(r10);
        requestLayout();
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

    public Flow(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public Flow(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
