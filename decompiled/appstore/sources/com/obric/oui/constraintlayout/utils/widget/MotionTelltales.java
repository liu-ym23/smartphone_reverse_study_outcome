package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class MotionTelltales extends MockView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f14032l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MotionLayout f14033m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f14034n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Matrix f14035o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14036p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14037q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f14038r;

    public MotionTelltales(Context r10) {
        super(r10);
        this.f14032l = new Paint();
        this.f14034n = new float[2];
        this.f14035o = new Matrix();
        this.f14036p = 0;
        this.f14037q = -65281;
        this.f14038r = 0.25f;
        a(r10, null);
    }

    public final void a(Context r10, AttributeSet r11) {
        if (r11 == null) goto L16;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.MotionTelltales);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L15;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.MotionTelltales_telltales_tailColor) goto L9;
        this.f14037q = r12.getColor(r15, this.f14037q);
    L14:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 != R$styleable.MotionTelltales_telltales_velocityMode) goto L12;
        this.f14036p = r12.getInt(r15, this.f14036p);
        goto L14
    L12:
        if (r15 != R$styleable.MotionTelltales_telltales_tailScale) goto L14;
        this.f14038r = r12.getFloat(r15, this.f14038r);
        goto L14
    L15:
        r12.recycle();
    L16:
        this.f14032l.setColor(this.f14037q);
        this.f14032l.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.obric.oui.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas r24) {
        super.onDraw(r24);
        getMatrix().invert(this.f14035o);
        if (this.f14033m != null) goto L8;
        ViewParent r10 = getParent();
        if ((r10 instanceof MotionLayout) == false) goto L17;
        this.f14033m = (MotionLayout) r10;
        return;
    L17:
        return;
    L8:
        int r11 = getWidth();
        int r12 = getHeight();
        float[] r13 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int r14 = 0;
    L9:
        if (r14 >= 5) goto L14;
        float r15 = r13[r14];
        int r16 = 0;
    L11:
        if (r16 >= 5) goto L13;
        float r17 = r13[r16];
        this.f14033m.m0(this, r17, r15, this.f14034n, this.f14036p);
        this.f14035o.mapVectors(this.f14034n);
        float r18 = r11 * r17;
        float r19 = r12 * r15;
        float[] r20 = this.f14034n;
        float r21 = r20[0];
        float r22 = this.f14038r;
        float r23 = r19 - (r20[1] * r22);
        this.f14035o.mapVectors(r20);
        r24.drawLine(r18, r19, r18 - (r21 * r22), r23, this.f14032l);
        r16 = r16 + 1;
        goto L11
    L13:
        r14 = r14 + 1;
        goto L9
    }

    @Override // android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        postInvalidate();
    }

    public void setText(CharSequence r10) {
        this.f13990f = r10.toString();
        requestLayout();
    }

    public MotionTelltales(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f14032l = new Paint();
        this.f14034n = new float[2];
        this.f14035o = new Matrix();
        this.f14036p = 0;
        this.f14037q = -65281;
        this.f14038r = 0.25f;
        a(r10, r11);
    }

    public MotionTelltales(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f14032l = new Paint();
        this.f14034n = new float[2];
        this.f14035o = new Matrix();
        this.f14036p = 0;
        this.f14037q = -65281;
        this.f14038r = 0.25f;
        a(r10, r11);
    }
}
