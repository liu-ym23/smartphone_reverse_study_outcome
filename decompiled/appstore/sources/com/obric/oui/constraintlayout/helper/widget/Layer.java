package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class Layer extends ConstraintHelper {
    public boolean A;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f13528j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f13529k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f13530l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout f13531m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13532n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13533o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13534p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13535q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f13536r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f13537s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f13538t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f13539u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f13540v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View[] f13541w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f13542x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f13543y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f13544z;

    public Layer(Context r10) {
        super(r10);
        this.f13528j = Float.NaN;
        this.f13529k = Float.NaN;
        this.f13530l = Float.NaN;
        this.f13532n = 1.0f;
        this.f13533o = 1.0f;
        this.f13534p = Float.NaN;
        this.f13535q = Float.NaN;
        this.f13536r = Float.NaN;
        this.f13537s = Float.NaN;
        this.f13538t = Float.NaN;
        this.f13539u = Float.NaN;
        this.f13540v = true;
        this.f13541w = null;
        this.f13542x = 0.0f;
        this.f13543y = 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void f(ConstraintLayout r10) {
        e(r10);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        int r11 = 0;
        this.f14055e = false;
        if (r10 == null) goto L19;
        TypedArray r12 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout);
        int r13 = r12.getIndexCount();
    L5:
        if (r11 >= r13) goto L13;
        int r14 = r12.getIndex(r11);
        if (r14 != R$styleable.ConstraintLayout_Layout_android_visibility) goto L10;
        this.f13544z = true;
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

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void n(ConstraintLayout r10) {
        u();
        this.f13534p = Float.NaN;
        this.f13535q = Float.NaN;
        ConstraintWidget r11 = ((ConstraintLayout.LayoutParams) getLayoutParams()).b();
        r11.m1(0);
        r11.N0(0);
        t();
        layout(((int) this.f13538t) - getPaddingLeft(), ((int) this.f13539u) - getPaddingTop(), ((int) this.f13536r) + getPaddingRight(), ((int) this.f13537s) + getPaddingBottom());
        v();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f13531m = (ConstraintLayout) getParent();
        if (this.f13544z == false) goto L5;
    L6:
        int r10 = getVisibility();
        float r11 = getElevation();
        int r12 = 0;
    L8:
        if (r12 >= this.f14052b) goto L26;
        int r13 = this.f14051a[r12];
        View r14 = this.f13531m.j(r13);
        if (r14 == null) goto L19;
        if (this.f13544z == false) goto L15;
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

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void p(ConstraintLayout r10) {
        this.f13531m = r10;
        float r11 = getRotation();
        if (r11 == 0.0f) goto L5;
        this.f13530l = r11;
        return;
    L5:
        if (Float.isNaN(this.f13530l) == true) goto L9;
        this.f13530l = r11;
        return;
    }

    @Override // android.view.View
    public void setElevation(float r10) {
        super.setElevation(r10);
        d();
    }

    @Override // android.view.View
    public void setPivotX(float r10) {
        this.f13528j = r10;
        v();
    }

    @Override // android.view.View
    public void setPivotY(float r10) {
        this.f13529k = r10;
        v();
    }

    @Override // android.view.View
    public void setRotation(float r10) {
        this.f13530l = r10;
        v();
    }

    @Override // android.view.View
    public void setScaleX(float r10) {
        this.f13532n = r10;
        v();
    }

    @Override // android.view.View
    public void setScaleY(float r10) {
        this.f13533o = r10;
        v();
    }

    @Override // android.view.View
    public void setTranslationX(float r10) {
        this.f13542x = r10;
        v();
    }

    @Override // android.view.View
    public void setTranslationY(float r10) {
        this.f13543y = r10;
        v();
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        d();
    }

    public void t() {
        if (this.f13531m != null) goto L6;
        return;
    L6:
        if (this.f13540v == true) goto L13;
        if (Float.isNaN(this.f13534p) == true) goto L13;
        if (Float.isNaN(this.f13535q) == true) goto L13;
        return;
    L13:
        if (Float.isNaN(this.f13528j) == false) goto L15;
    L18:
        View[] r10 = j(this.f13531m);
        int r11 = 0;
        int r12 = r10[0].getLeft();
        int r13 = r10[0].getTop();
        int r14 = r10[0].getRight();
        int r15 = r10[0].getBottom();
    L20:
        if (r11 >= this.f14052b) goto L22;
        View r16 = r10[r11];
        r12 = Math.min(r12, r16.getLeft());
        r13 = Math.min(r13, r16.getTop());
        r14 = Math.max(r14, r16.getRight());
        r15 = Math.max(r15, r16.getBottom());
        r11 = r11 + 1;
        goto L20
    L22:
        this.f13536r = r14;
        this.f13537s = r15;
        this.f13538t = r12;
        this.f13539u = r13;
        if (Float.isNaN(this.f13528j) == false) goto L25;
        this.f13534p = (r12 + r14) / 2;
    L27:
        if (Float.isNaN(this.f13529k) == false) goto L29;
        this.f13535q = (r13 + r15) / 2;
        return;
    L29:
        this.f13535q = this.f13529k;
        return;
    L25:
        this.f13534p = this.f13528j;
        goto L27
    L15:
        if (Float.isNaN(this.f13529k) == true) goto L18;
        this.f13535q = this.f13529k;
        this.f13534p = this.f13528j;
    }

    public final void u() {
        if (this.f13531m != null) goto L5;
        return;
    L5:
        int r10 = this.f14052b;
        if (r10 != 0) goto L8;
        return;
    L8:
        View[] r11 = this.f13541w;
        if (r11 != null) goto L11;
    L12:
        this.f13541w = new View[r10];
    L13:
        int r12 = 0;
    L15:
        if (r12 >= this.f14052b) goto L17;
        int r13 = this.f14051a[r12];
        this.f13541w[r12] = this.f13531m.j(r13);
        r12 = r12 + 1;
        goto L15
    L17:
        return;
    L11:
        if (r11.length == r10) goto L13;
        goto L12
    }

    public final void v() {
        if (this.f13531m != null) goto L6;
        return;
    L6:
        if (this.f13541w != null) goto L8;
        u();
    L8:
        t();
        if (Float.isNaN(this.f13530l) == false) goto L11;
        double r10 = 0.0d;
    L12:
        float r11 = (float) Math.sin(r10);
        float r12 = (float) Math.cos(r10);
        float r13 = this.f13532n;
        float r14 = r13 * r12;
        float r15 = this.f13533o;
        float r16 = (-r15) * r11;
        float r17 = r13 * r11;
        float r18 = r15 * r12;
        int r19 = 0;
    L14:
        if (r19 >= this.f14052b) goto L19;
        View r20 = this.f13541w[r19];
        int r21 = (r20.getLeft() + r20.getRight()) / 2;
        int r22 = (r20.getTop() + r20.getBottom()) / 2;
        float r23 = r21 - this.f13534p;
        float r24 = r22 - this.f13535q;
        float r25 = (((r14 * r23) + (r16 * r24)) - r23) + this.f13542x;
        float r26 = (((r23 * r17) + (r18 * r24)) - r24) + this.f13543y;
        r20.setTranslationX(r25);
        r20.setTranslationY(r26);
        r20.setScaleY(this.f13533o);
        r20.setScaleX(this.f13532n);
        if (Float.isNaN(this.f13530l) == true) goto L18;
        r20.setRotation(this.f13530l);
    L18:
        r19 = r19 + 1;
        goto L14
    L19:
        return;
    L11:
        r10 = Math.toRadians(this.f13530l);
        goto L12
    }

    public Layer(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f13528j = Float.NaN;
        this.f13529k = Float.NaN;
        this.f13530l = Float.NaN;
        this.f13532n = 1.0f;
        this.f13533o = 1.0f;
        this.f13534p = Float.NaN;
        this.f13535q = Float.NaN;
        this.f13536r = Float.NaN;
        this.f13537s = Float.NaN;
        this.f13538t = Float.NaN;
        this.f13539u = Float.NaN;
        this.f13540v = true;
        this.f13541w = null;
        this.f13542x = 0.0f;
        this.f13543y = 0.0f;
    }

    public Layer(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f13528j = Float.NaN;
        this.f13529k = Float.NaN;
        this.f13530l = Float.NaN;
        this.f13532n = 1.0f;
        this.f13533o = 1.0f;
        this.f13534p = Float.NaN;
        this.f13535q = Float.NaN;
        this.f13536r = Float.NaN;
        this.f13537s = Float.NaN;
        this.f13538t = Float.NaN;
        this.f13539u = Float.NaN;
        this.f13540v = true;
        this.f13541w = null;
        this.f13542x = 0.0f;
        this.f13543y = 0.0f;
    }
}
