package com.stepos.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class NewMessageView extends View {

    /* renamed from: a, reason: collision with root package name */
    private boolean f14047a;

    /* renamed from: b, reason: collision with root package name */
    private int f14048b;

    /* renamed from: c, reason: collision with root package name */
    private g f14049c;

    public NewMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14047a = true;
        this.f14048b = 0;
        b(context, attributeSet);
    }

    private int a(int i5, int i6, int i7, int i8) {
        return (i8 == 1073741824 && i5 >= i6) ? i5 > i7 ? i7 : i5 : i6;
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f14049c = new g(context);
    }

    public boolean c() {
        return this.f14047a;
    }

    public int getBorderWidth() {
        return this.f14049c.b();
    }

    public int getNewMessageGravity() {
        return ((FrameLayout.LayoutParams) getLayoutParams()).gravity;
    }

    public int[] getNewMessageMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        return new int[]{layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin};
    }

    public Integer getNewMessageNum() {
        return this.f14049c.d();
    }

    public int getState() {
        return this.f14049c.e();
    }

    public int getViewMaxHeight() {
        return this.f14049c.g();
    }

    public int getViewMaxWidth() {
        return this.f14049c.h();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f14049c.a(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        this.f14049c.o();
        setMeasuredDimension(a(size, this.f14049c.i(), this.f14049c.h(), mode), a(size2, this.f14049c.c(), this.f14049c.g(), mode2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i5) {
        this.f14049c.q(i5);
    }

    public void setBorderColor(int i5) {
        this.f14049c.r(i5);
    }

    public void setBorderWidth(int i5) {
        this.f14049c.s(i5);
    }

    public void setCurrentStage(int i5) {
        this.f14049c.t(i5);
    }

    public void setHide(boolean z5) {
        this.f14047a = z5;
        if (this.f14048b == 1) {
            setText(this.f14049c.f());
        } else {
            setText(null);
        }
    }

    public void setNewMessageGravity(int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.gravity = i5;
        setLayoutParams(layoutParams);
    }

    public void setNewMessageNum(int i5) {
        setCurrentStage(1);
        if (i5 >= 999) {
            i5 = 999;
        } else if (i5 <= 0) {
            i5 = 0;
        }
        setText(String.valueOf(i5));
        requestLayout();
    }

    public void setNewMessageSpace(int i5) {
        this.f14049c.v(i5);
    }

    public void setShowBorder(boolean z5) {
        this.f14049c.x(z5);
    }

    public void setText(String str) {
        if (c() && (str == null || str.equalsIgnoreCase("0"))) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        this.f14049c.y(str);
    }

    public void setTextSize(float f5) {
        this.f14049c.z(f5);
    }
}
