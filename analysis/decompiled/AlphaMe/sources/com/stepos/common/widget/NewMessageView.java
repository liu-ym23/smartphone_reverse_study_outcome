package com.stepos.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class NewMessageView extends View {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11709a;

    /* renamed from: b, reason: collision with root package name */
    public final r f11710b;

    public NewMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11709a = true;
        this.f11710b = new r(context);
    }

    public int getBorderWidth() {
        return this.f11710b.f11949f;
    }

    public int getNewMessageGravity() {
        return ((FrameLayout.LayoutParams) getLayoutParams()).gravity;
    }

    public int[] getNewMessageMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        return new int[]{layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin};
    }

    public Integer getNewMessageNum() {
        String str = this.f11710b.f11963t;
        int i4 = 0;
        if (str == null) {
            return i4;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return i4;
        }
    }

    public int getState() {
        return this.f11710b.f11962s;
    }

    public int getViewMaxHeight() {
        return this.f11710b.f11958o;
    }

    public int getViewMaxWidth() {
        return this.f11710b.f11957n;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        this.f11710b.a(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        this.f11710b.b();
        r rVar = this.f11710b;
        int i6 = rVar.f11953j;
        int i7 = rVar.f11957n;
        if (mode != 1073741824 || size < i6) {
            size = i6;
        } else if (size > i7) {
            size = i7;
        }
        int i8 = rVar.f11954k;
        int i9 = rVar.f11958o;
        if (mode2 != 1073741824 || size2 < i8) {
            size2 = i8;
        } else if (size2 > i9) {
            size2 = i9;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        this.f11710b.f11951h.setColor(i4);
    }

    public void setBorderColor(int i4) {
        this.f11710b.f11948e = i4;
    }

    public void setBorderWidth(int i4) {
        this.f11710b.f11949f = i4;
    }

    public void setCurrentStage(int i4) {
        this.f11710b.f11962s = i4;
    }

    public void setHide(boolean z4) {
        this.f11709a = z4;
        setText(null);
    }

    public void setNewMessageGravity(int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.gravity = i4;
        setLayoutParams(layoutParams);
    }

    public void setNewMessageNum(int i4) {
        setCurrentStage(1);
        if (i4 >= 999) {
            i4 = 999;
        } else if (i4 <= 0) {
            i4 = 0;
        }
        setText(String.valueOf(i4));
        requestLayout();
    }

    public void setNewMessageSpace(int i4) {
        this.f11710b.f11959p = i4;
    }

    public void setShowBorder(boolean z4) {
        this.f11710b.f11947d = z4;
    }

    public void setText(String str) {
        if (this.f11709a && (str == null || str.equalsIgnoreCase("0"))) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        this.f11710b.f11963t = str;
    }

    public void setTextSize(float f4) {
        this.f11710b.f11945b = f4;
    }
}
