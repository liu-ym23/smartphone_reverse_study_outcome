package com.stepos.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NewMessageView extends View {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6954a;

    /* renamed from: b, reason: collision with root package name */
    public final q f6955b;

    public NewMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6954a = true;
        this.f6955b = new q(context);
    }

    public int getBorderWidth() {
        return this.f6955b.f7180f;
    }

    public int getNewMessageGravity() {
        return ((FrameLayout.LayoutParams) getLayoutParams()).gravity;
    }

    public int[] getNewMessageMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        return new int[]{layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin};
    }

    public Integer getNewMessageNum() {
        String str = this.f6955b.f7192t;
        if (str != null) {
            try {
                return Integer.valueOf(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public int getState() {
        return this.f6955b.f7191s;
    }

    public int getViewMaxHeight() {
        return this.f6955b.f7188o;
    }

    public int getViewMaxWidth() {
        return this.f6955b.f7187n;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        q qVar = this.f6955b;
        if (qVar.f7178d && qVar.f7180f > 0) {
            qVar.h.setColor(qVar.f7179e);
            if (qVar.f7191s == 1) {
                float f8 = qVar.f7183j;
                int i10 = qVar.f7184k;
                float f9 = i10;
                float f10 = i10 >> 1;
                RectF rectF = qVar.f7190q;
                rectF.left = 0.0f;
                rectF.top = 0.0f;
                rectF.right = f8;
                rectF.bottom = f9;
                canvas.drawRoundRect(rectF, f10, f10, qVar.h);
            } else {
                canvas.drawCircle(qVar.f7183j / 2, qVar.f7184k / 2, qVar.f7181g + qVar.f7180f, qVar.h);
            }
        }
        qVar.h.setColor(qVar.f7177c);
        if (qVar.f7191s != 1) {
            canvas.drawCircle(qVar.f7183j / 2, qVar.f7184k / 2, qVar.f7181g, qVar.h);
            return;
        }
        int i11 = qVar.f7180f;
        float f11 = i11;
        float f12 = qVar.f7183j - i11;
        float f13 = qVar.f7184k - i11;
        RectF rectF2 = qVar.f7190q;
        rectF2.left = f11;
        rectF2.top = f11;
        rectF2.right = f12;
        rectF2.bottom = f13;
        float f14 = qVar.f7186m >> 1;
        canvas.drawRoundRect(rectF2, f14, f14, qVar.h);
        String str = qVar.f7192t;
        if (str != null) {
            if (qVar.f7178d) {
                canvas.drawText(str, qVar.f7183j / 2, ((qVar.f7184k - qVar.f7180f) - ((qVar.f7186m - qVar.r.height()) / 2)) - 1, qVar.f7182i);
            } else {
                canvas.drawText(str, qVar.f7183j / 2, (qVar.f7184k - ((qVar.f7186m - qVar.r.height()) / 2)) - 1, qVar.f7182i);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        this.f6955b.a();
        q qVar = this.f6955b;
        int i12 = qVar.f7183j;
        int i13 = qVar.f7187n;
        if (mode != 1073741824 || size < i12) {
            size = i12;
        } else if (size > i13) {
            size = i13;
        }
        int i14 = qVar.f7184k;
        int i15 = qVar.f7188o;
        if (mode2 != 1073741824 || size2 < i14) {
            size2 = i14;
        } else if (size2 > i15) {
            size2 = i15;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f6955b.h.setColor(i10);
    }

    public void setBorderColor(int i10) {
        this.f6955b.f7179e = i10;
    }

    public void setBorderWidth(int i10) {
        this.f6955b.f7180f = i10;
    }

    public void setCurrentStage(int i10) {
        this.f6955b.f7191s = i10;
    }

    public void setHide(boolean z) {
        this.f6954a = z;
        setText(null);
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
        this.f6955b.f7189p = i10;
    }

    public void setShowBorder(boolean z) {
        this.f6955b.f7178d = z;
    }

    public void setText(String str) {
        if (this.f6954a && (str == null || str.equalsIgnoreCase("0"))) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        this.f6955b.f7192t = str;
    }

    public void setTextSize(float f8) {
        this.f6955b.f7176b = f8;
    }
}
