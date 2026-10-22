package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class Layer extends ConstraintHelper {
    public boolean A;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f1695j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f1696k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f1697l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout f1698m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f1699n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f1700o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f1701p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f1702q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f1703r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f1704s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f1705t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f1706u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1707v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View[] f1708w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f1709x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f1710y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1711z;

    public Layer(Context r10) {
        super(r10);
        this.f1695j = Float.NaN;
        this.f1696k = Float.NaN;
        this.f1697l = Float.NaN;
        this.f1699n = 1.0f;
        this.f1700o = 1.0f;
        this.f1701p = Float.NaN;
        this.f1702q = Float.NaN;
        this.f1703r = Float.NaN;
        this.f1704s = Float.NaN;
        this.f1705t = Float.NaN;
        this.f1706u = Float.NaN;
        this.f1707v = true;
        this.f1708w = null;
        this.f1709x = 0.0f;
        this.f1710y = 0.0f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void f(ConstraintLayout r10) {
        e(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        int r11 = 0;
        this.f2181e = false;
        if (r10 == null) goto L19;
        TypedArray r12 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout);
        int r13 = r12.getIndexCount();
    L5:
        if (r11 >= r13) goto L13;
        int r14 = r12.getIndex(r11);
        if (r14 != R$styleable.ConstraintLayout_Layout_android_visibility) goto L10;
        this.f1711z = true;
    L12:
        r11 = r11 + 1;
        goto L5
    L10:
        if (r14 != R$styleable.ConstraintLayout_Layout_android_elevation) goto L12;
        this.A = true;
        goto L12
    L13:
        r12.recycle();
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void n(ConstraintLayout r10) {
        u();
        this.f1701p = Float.NaN;
        this.f1702q = Float.NaN;
        ConstraintWidget r11 = ((ConstraintLayout.LayoutParams) getLayoutParams()).b();
        r11.l1(0);
        r11.M0(0);
        t();
        layout(((int) this.f1705t) - getPaddingLeft(), ((int) this.f1706u) - getPaddingTop(), ((int) this.f1703r) + getPaddingRight(), ((int) this.f1704s) + getPaddingBottom());
        v();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1698m = (ConstraintLayout) getParent();
        if (this.f1711z == false) goto L5;
    L6:
        int r10 = getVisibility();
        float r11 = getElevation();
        int r12 = 0;
    L8:
        if (r12 >= this.f2178b) goto L26;
        int r13 = this.f2177a[r12];
        View r14 = this.f1698m.getViewById(r13);
        if (r14 == null) goto L19;
        if (this.f1711z == false) goto L15;
        r14.setVisibility(r10);
    L15:
        if (this.A == false) goto L19;
        if (r11 <= 0.0f) goto L19;
        r14.setTranslationZ(r14.getTranslationZ() + r11);
    L19:
        r12 = r12 + 1;
        goto L8
    L26:
        return;
    L5:
        if (this.A == true) goto L6;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void p(ConstraintLayout r10) {
        this.f1698m = r10;
        float r11 = getRotation();
        if (r11 == 0.0f) goto L5;
        this.f1697l = r11;
        return;
    L5:
        if (Float.isNaN(this.f1697l) == true) goto L9;
        this.f1697l = r11;
        return;
    }

    @Override // android.view.View
    public void setElevation(float r10) {
        super.setElevation(r10);
        d();
    }

    @Override // android.view.View
    public void setPivotX(float r10) {
        this.f1695j = r10;
        v();
    }

    @Override // android.view.View
    public void setPivotY(float r10) {
        this.f1696k = r10;
        v();
    }

    @Override // android.view.View
    public void setRotation(float r10) {
        this.f1697l = r10;
        v();
    }

    @Override // android.view.View
    public void setScaleX(float r10) {
        this.f1699n = r10;
        v();
    }

    @Override // android.view.View
    public void setScaleY(float r10) {
        this.f1700o = r10;
        v();
    }

    @Override // android.view.View
    public void setTranslationX(float r10) {
        this.f1709x = r10;
        v();
    }

    @Override // android.view.View
    public void setTranslationY(float r10) {
        this.f1710y = r10;
        v();
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        d();
    }

    public void t() {
        if (this.f1698m != null) goto L6;
        return;
    L6:
        if (this.f1707v == true) goto L13;
        if (Float.isNaN(this.f1701p) == true) goto L13;
        if (Float.isNaN(this.f1702q) == true) goto L13;
        return;
    L13:
        if (Float.isNaN(this.f1695j) == false) goto L15;
    L18:
        View[] r10 = j(this.f1698m);
        int r11 = 0;
        int r12 = r10[0].getLeft();
        int r13 = r10[0].getTop();
        int r14 = r10[0].getRight();
        int r15 = r10[0].getBottom();
    L20:
        if (r11 >= this.f2178b) goto L22;
        View r16 = r10[r11];
        r12 = Math.min(r12, r16.getLeft());
        r13 = Math.min(r13, r16.getTop());
        r14 = Math.max(r14, r16.getRight());
        r15 = Math.max(r15, r16.getBottom());
        r11 = r11 + 1;
        goto L20
    L22:
        this.f1703r = r14;
        this.f1704s = r15;
        this.f1705t = r12;
        this.f1706u = r13;
        if (Float.isNaN(this.f1695j) == false) goto L25;
        this.f1701p = (r12 + r14) / 2;
    L27:
        if (Float.isNaN(this.f1696k) == false) goto L29;
        this.f1702q = (r13 + r15) / 2;
        return;
    L29:
        this.f1702q = this.f1696k;
        return;
    L25:
        this.f1701p = this.f1695j;
        goto L27
    L15:
        if (Float.isNaN(this.f1696k) == true) goto L18;
        this.f1702q = this.f1696k;
        this.f1701p = this.f1695j;
    }

    public final void u() {
        if (this.f1698m != null) goto L5;
        return;
    L5:
        int r10 = this.f2178b;
        if (r10 != 0) goto L8;
        return;
    L8:
        View[] r11 = this.f1708w;
        if (r11 != null) goto L11;
    L12:
        this.f1708w = new View[r10];
    L13:
        int r12 = 0;
    L15:
        if (r12 >= this.f2178b) goto L17;
        int r13 = this.f2177a[r12];
        this.f1708w[r12] = this.f1698m.getViewById(r13);
        r12 = r12 + 1;
        goto L15
    L17:
        return;
    L11:
        if (r11.length == r10) goto L13;
        goto L12
    }

    public final void v() {
        if (this.f1698m != null) goto L6;
        return;
    L6:
        if (this.f1708w != null) goto L8;
        u();
    L8:
        t();
        if (Float.isNaN(this.f1697l) == false) goto L11;
        double r10 = 0.0d;
    L12:
        float r11 = (float) Math.sin(r10);
        float r12 = (float) Math.cos(r10);
        float r13 = this.f1699n;
        float r14 = r13 * r12;
        float r15 = this.f1700o;
        float r16 = (-r15) * r11;
        float r17 = r13 * r11;
        float r18 = r15 * r12;
        int r19 = 0;
    L14:
        if (r19 >= this.f2178b) goto L19;
        View r20 = this.f1708w[r19];
        int r21 = (r20.getLeft() + r20.getRight()) / 2;
        int r22 = (r20.getTop() + r20.getBottom()) / 2;
        float r23 = r21 - this.f1701p;
        float r24 = r22 - this.f1702q;
        float r25 = (((r14 * r23) + (r16 * r24)) - r23) + this.f1709x;
        float r26 = (((r23 * r17) + (r18 * r24)) - r24) + this.f1710y;
        r20.setTranslationX(r25);
        r20.setTranslationY(r26);
        r20.setScaleY(this.f1700o);
        r20.setScaleX(this.f1699n);
        if (Float.isNaN(this.f1697l) == true) goto L18;
        r20.setRotation(this.f1697l);
    L18:
        r19 = r19 + 1;
        goto L14
    L19:
        return;
    L11:
        r10 = Math.toRadians(this.f1697l);
        goto L12
    }

    public Layer(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f1695j = Float.NaN;
        this.f1696k = Float.NaN;
        this.f1697l = Float.NaN;
        this.f1699n = 1.0f;
        this.f1700o = 1.0f;
        this.f1701p = Float.NaN;
        this.f1702q = Float.NaN;
        this.f1703r = Float.NaN;
        this.f1704s = Float.NaN;
        this.f1705t = Float.NaN;
        this.f1706u = Float.NaN;
        this.f1707v = true;
        this.f1708w = null;
        this.f1709x = 0.0f;
        this.f1710y = 0.0f;
    }

    public Layer(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f1695j = Float.NaN;
        this.f1696k = Float.NaN;
        this.f1697l = Float.NaN;
        this.f1699n = 1.0f;
        this.f1700o = 1.0f;
        this.f1701p = Float.NaN;
        this.f1702q = Float.NaN;
        this.f1703r = Float.NaN;
        this.f1704s = Float.NaN;
        this.f1705t = Float.NaN;
        this.f1706u = Float.NaN;
        this.f1707v = true;
        this.f1708w = null;
        this.f1709x = 0.0f;
        this.f1710y = 0.0f;
    }
}
