package com.stepos.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class NewMessageView extends View {

    /* renamed from: c, reason: collision with root package name */
    public boolean f2622c;

    /* renamed from: f, reason: collision with root package name */
    public final i f2623f;

    public NewMessageView(Context context) {
        super(context);
        this.f2622c = true;
        this.f2623f = new i(context);
    }

    public int getBorderWidth() {
        return this.f2623f.f2704f;
    }

    public int getNewMessageGravity() {
        return ((FrameLayout.LayoutParams) getLayoutParams()).gravity;
    }

    public int[] getNewMessageMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        return new int[]{layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin};
    }

    public Integer getNewMessageNum() {
        String str = this.f2623f.f2717t;
        if (str != null) {
            try {
                return Integer.valueOf(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public int getState() {
        return this.f2623f.f2716s;
    }

    public int getViewMaxHeight() {
        return this.f2623f.f2712o;
    }

    public int getViewMaxWidth() {
        return this.f2623f.f2711n;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        i iVar = this.f2623f;
        if (iVar.f2702d && iVar.f2704f > 0) {
            iVar.f2706h.setColor(iVar.f2703e);
            int i = iVar.f2716s;
            int i3 = iVar.f2707j;
            int i10 = iVar.f2708k;
            if (i == 1) {
                float f5 = i3;
                float f10 = i10;
                float f11 = i10 >> 1;
                RectF rectF = iVar.f2714q;
                rectF.left = 0.0f;
                rectF.top = 0.0f;
                rectF.right = f5;
                rectF.bottom = f10;
                canvas.drawRoundRect(rectF, f11, f11, iVar.f2706h);
            } else {
                canvas.drawCircle(i3 / 2, i10 / 2, iVar.f2705g + iVar.f2704f, iVar.f2706h);
            }
        }
        iVar.f2706h.setColor(iVar.f2701c);
        if (iVar.f2716s != 1) {
            canvas.drawCircle(iVar.f2707j / 2, iVar.f2708k / 2, iVar.f2705g, iVar.f2706h);
            return;
        }
        int i11 = iVar.f2704f;
        float f12 = i11;
        float f13 = iVar.f2707j - i11;
        float f14 = iVar.f2708k - i11;
        RectF rectF2 = iVar.f2714q;
        rectF2.left = f12;
        rectF2.top = f12;
        rectF2.right = f13;
        rectF2.bottom = f14;
        float f15 = iVar.f2710m >> 1;
        canvas.drawRoundRect(rectF2, f15, f15, iVar.f2706h);
        String str = iVar.f2717t;
        if (str != null) {
            boolean z10 = iVar.f2702d;
            int i12 = iVar.f2707j;
            int i13 = iVar.f2708k;
            if (z10) {
                canvas.drawText(str, i12 / 2, ((i13 - iVar.f2704f) - ((iVar.f2710m - iVar.f2715r.height()) / 2)) - 1, iVar.i);
            } else {
                canvas.drawText(str, i12 / 2, (i13 - ((iVar.f2710m - iVar.f2715r.height()) / 2)) - 1, iVar.i);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        int iE;
        int i10;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i3);
        i iVar = this.f2623f;
        Context context = iVar.f2718u;
        if (iVar.f2716s != 1 || iVar.f2717t == null) {
            boolean z10 = iVar.f2702d;
            int i11 = iVar.f2705g;
            if (z10) {
                i11 += iVar.f2704f;
            }
            iE = i11 * 2;
            i10 = iE;
        } else {
            iVar.i.setTextSize((int) ((iVar.f2700b * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f));
            iVar.i.setColor(iVar.f2699a);
            TextPaint textPaint = iVar.i;
            String str = iVar.f2717t;
            textPaint.getTextBounds(str, 0, str.length(), iVar.f2715r);
            iVar.f2709l = iVar.f2715r.width() + (iVar.f2713p * 2);
            iE = (int) t1.e.e(18.0f, context);
            iVar.f2710m = iE;
            if (iVar.f2709l < iE) {
                iVar.f2709l = iE;
            }
            boolean z11 = iVar.f2702d;
            i10 = iVar.f2709l;
            if (z11) {
                int i12 = iVar.f2704f * 2;
                i10 += i12;
                iE += i12;
            }
        }
        iVar.f2707j = i10;
        iVar.f2708k = iE;
        i iVar2 = this.f2623f;
        int i13 = iVar2.f2707j;
        int i14 = iVar2.f2711n;
        if (mode != 1073741824 || size < i13) {
            size = i13;
        } else if (size > i14) {
            size = i14;
        }
        int i15 = iVar2.f2708k;
        int i16 = iVar2.f2712o;
        if (mode2 != 1073741824 || size2 < i15) {
            size2 = i15;
        } else if (size2 > i16) {
            size2 = i16;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f2623f.f2706h.setColor(i);
    }

    public void setBorderColor(int i) {
        this.f2623f.f2703e = i;
    }

    public void setBorderWidth(int i) {
        this.f2623f.f2704f = i;
    }

    public void setCurrentStage(int i) {
        this.f2623f.f2716s = i;
    }

    public void setHide(boolean z10) {
        this.f2622c = z10;
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
        this.f2623f.f2713p = i;
    }

    public void setShowBorder(boolean z10) {
        this.f2623f.f2702d = z10;
    }

    public void setText(String str) {
        if (this.f2622c && (str == null || str.equalsIgnoreCase("0"))) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        this.f2623f.f2717t = str;
    }

    public void setTextSize(float f5) {
        this.f2623f.f2700b = f5;
    }

    public NewMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2622c = true;
        this.f2623f = new i(context);
    }

    public NewMessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2622c = true;
        this.f2623f = new i(context);
    }
}
