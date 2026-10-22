package com.stepos.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class NewMessageView extends View {
    private static final int MAX_COUNT = 999;
    private int mCurrentStage;
    private boolean mIsHide;
    private h mNewMessagePainter;

    public NewMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsHide = true;
        this.mCurrentStage = 0;
        b(context, attributeSet);
    }

    public final int a(int i10, int i11, int i12, int i13) {
        return (i13 == 1073741824 && i10 >= i11) ? i10 > i12 ? i12 : i10 : i11;
    }

    public final void b(Context context, AttributeSet attributeSet) {
        this.mNewMessagePainter = new h(context);
    }

    public boolean c() {
        return this.mIsHide;
    }

    public int getBorderWidth() {
        return this.mNewMessagePainter.b();
    }

    public int getNewMessageGravity() {
        return ((FrameLayout.LayoutParams) getLayoutParams()).gravity;
    }

    public int[] getNewMessageMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        return new int[]{layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin};
    }

    public Integer getNewMessageNum() {
        return this.mNewMessagePainter.d();
    }

    public int getState() {
        return this.mNewMessagePainter.e();
    }

    public int getViewMaxHeight() {
        return this.mNewMessagePainter.g();
    }

    public int getViewMaxWidth() {
        return this.mNewMessagePainter.h();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.mNewMessagePainter.a(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        this.mNewMessagePainter.o();
        setMeasuredDimension(a(size, this.mNewMessagePainter.i(), this.mNewMessagePainter.h(), mode), a(size2, this.mNewMessagePainter.c(), this.mNewMessagePainter.g(), mode2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.mNewMessagePainter.q(i10);
    }

    public void setBorderColor(int i10) {
        this.mNewMessagePainter.r(i10);
    }

    public void setBorderWidth(int i10) {
        this.mNewMessagePainter.s(i10);
    }

    public void setCurrentStage(int i10) {
        this.mNewMessagePainter.t(i10);
    }

    public void setHide(boolean z10) {
        this.mIsHide = z10;
        if (this.mCurrentStage == 1) {
            setText(this.mNewMessagePainter.f());
        } else {
            setText(null);
        }
    }

    public void setNewMessageGravity(int i10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.gravity = i10;
        setLayoutParams(layoutParams);
    }

    public void setNewMessageNum(int i10) {
        setCurrentStage(1);
        if (i10 >= 999) {
            i10 = 999;
        } else if (i10 <= 0) {
            i10 = 0;
        }
        setText(String.valueOf(i10));
        requestLayout();
    }

    public void setNewMessageSpace(int i10) {
        this.mNewMessagePainter.v(i10);
    }

    public void setShowBorder(boolean z10) {
        this.mNewMessagePainter.x(z10);
    }

    public void setText(String str) {
        if (c() && (str == null || str.equalsIgnoreCase("0"))) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        this.mNewMessagePainter.y(str);
    }

    public void setTextSize(float f10) {
        this.mNewMessagePainter.z(f10);
    }
}
