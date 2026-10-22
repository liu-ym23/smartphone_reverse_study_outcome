package com.stepos.common.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public class NavigationMenuItemView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f3726a;
    public StepOSImageView b;
    public int c;
    public final x d;
    public boolean e;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.e = true;
        setWillNotDraw(false);
        x xVar = new x(context);
        this.d = xVar;
        xVar.d = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        StepOSImageView stepOSImageView = this.b;
        if (stepOSImageView == null) {
            super.dispatchDraw(canvas);
            return;
        }
        Drawable drawable = stepOSImageView.getDrawable();
        if (this.e) {
            if (isSelected()) {
                drawable.setColorFilter(this.c, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.setColorFilter(null);
            }
        }
        super.dispatchDraw(canvas);
    }

    public InterfaceC1099d getItemData() {
        return null;
    }

    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StepOSImageView stepOSImageView = this.b;
        if (stepOSImageView == null || stepOSImageView.getDrawable() == null) {
            return;
        }
        this.b.getDrawable().setColorFilter(null);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f3726a = (TextView) findViewById(R.id.title);
        this.b = (StepOSImageView) findViewById(R.id.icon);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        this.d.a();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        StepOSImageView stepOSImageView = this.b;
        if (stepOSImageView != null) {
            stepOSImageView.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIcon(Drawable drawable) {
        StepOSImageView stepOSImageView = this.b;
        if (stepOSImageView == null) {
            return;
        }
        stepOSImageView.setImageDrawable(drawable);
        getItemData();
        throw null;
    }

    public void setSelectedIconColor(int i) {
        if (this.c != i) {
            this.c = i;
            invalidate();
        }
    }

    public void setSelectedIconTintEnabled(boolean z10) {
        if (this.e != z10) {
            this.e = z10;
            invalidate();
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f3726a;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public void setTitleColor(ColorStateList colorStateList) {
        TextView textView = this.f3726a;
        if (textView == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }
}
