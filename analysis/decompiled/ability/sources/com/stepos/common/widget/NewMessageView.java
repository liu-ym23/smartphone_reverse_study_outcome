package com.stepos.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class NewMessageView extends View {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3727a;
    public final x b;

    public NewMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3727a = true;
        this.b = new x(context);
    }

    public int getBorderWidth() {
        return this.b.f;
    }

    public int getNewMessageGravity() {
        return ((FrameLayout.LayoutParams) getLayoutParams()).gravity;
    }

    public int[] getNewMessageMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        return new int[]{layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin};
    }

    public Integer getNewMessageNum() {
        String str = this.b.f3821t;
        if (str != null) {
            try {
                return Integer.valueOf(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public int getState() {
        return this.b.f3820s;
    }

    public int getViewMaxHeight() {
        return this.b.o;
    }

    public int getViewMaxWidth() {
        return this.b.n;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        x xVar = this.b;
        if (xVar.d && xVar.f > 0) {
            xVar.h.setColor(xVar.e);
            if (xVar.f3820s == 1) {
                float f = xVar.f3817j;
                int i = xVar.k;
                float f7 = i;
                float f9 = i >> 1;
                RectF rectF = xVar.f3818q;
                rectF.left = 0.0f;
                rectF.top = 0.0f;
                rectF.right = f;
                rectF.bottom = f7;
                canvas.drawRoundRect(rectF, f9, f9, xVar.h);
            } else {
                canvas.drawCircle(xVar.f3817j / 2, xVar.k / 2, xVar.g + xVar.f, xVar.h);
            }
        }
        xVar.h.setColor(xVar.c);
        if (xVar.f3820s != 1) {
            canvas.drawCircle(xVar.f3817j / 2, xVar.k / 2, xVar.g, xVar.h);
            return;
        }
        int i6 = xVar.f;
        float f10 = i6;
        float f11 = xVar.f3817j - i6;
        float f12 = xVar.k - i6;
        RectF rectF2 = xVar.f3818q;
        rectF2.left = f10;
        rectF2.top = f10;
        rectF2.right = f11;
        rectF2.bottom = f12;
        float f13 = xVar.m >> 1;
        canvas.drawRoundRect(rectF2, f13, f13, xVar.h);
        String str = xVar.f3821t;
        if (str != null) {
            if (xVar.d) {
                canvas.drawText(str, xVar.f3817j / 2, ((xVar.k - xVar.f) - ((xVar.m - xVar.f3819r.height()) / 2)) - 1, xVar.i);
            } else {
                canvas.drawText(str, xVar.f3817j / 2, (xVar.k - ((xVar.m - xVar.f3819r.height()) / 2)) - 1, xVar.i);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i6);
        this.b.a();
        x xVar = this.b;
        int i10 = xVar.f3817j;
        int i11 = xVar.n;
        if (mode != 1073741824 || size < i10) {
            size = i10;
        } else if (size > i11) {
            size = i11;
        }
        int i12 = xVar.k;
        int i13 = xVar.o;
        if (mode2 != 1073741824 || size2 < i12) {
            size2 = i12;
        } else if (size2 > i13) {
            size2 = i13;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.b.h.setColor(i);
    }

    public void setBorderColor(int i) {
        this.b.e = i;
    }

    public void setBorderWidth(int i) {
        this.b.f = i;
    }

    public void setCurrentStage(int i) {
        this.b.f3820s = i;
    }

    public void setHide(boolean z10) {
        this.f3727a = z10;
        setText(null);
    }

    public void setNewMessageGravity(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.gravity = i;
        setLayoutParams(layoutParams);
    }

    public void setNewMessageNum(int i) {
        setCurrentStage(1);
        if (i >= 999) {
            i = 999;
        } else if (i <= 0) {
            i = 0;
        }
        setText(String.valueOf(i));
        requestLayout();
    }

    public void setNewMessageSpace(int i) {
        this.b.p = i;
    }

    public void setShowBorder(boolean z10) {
        this.b.d = z10;
    }

    public void setText(String str) {
        if (this.f3727a && (str == null || str.equalsIgnoreCase("0"))) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        this.b.f3821t = str;
    }

    public void setTextSize(float f) {
        this.b.b = f;
    }
}
