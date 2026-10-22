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
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f11704a;

    /* renamed from: b, reason: collision with root package name */
    public StepOSImageView f11705b;

    /* renamed from: c, reason: collision with root package name */
    public int f11706c;

    /* renamed from: d, reason: collision with root package name */
    public final r f11707d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11708e;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f11708e = true;
        setWillNotDraw(false);
        r rVar = new r(context);
        this.f11707d = rVar;
        rVar.f11947d = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        StepOSImageView stepOSImageView = this.f11705b;
        if (stepOSImageView == null) {
            super.dispatchDraw(canvas);
            return;
        }
        Drawable drawable = stepOSImageView.getDrawable();
        if (this.f11708e) {
            if (isSelected()) {
                drawable.setColorFilter(this.f11706c, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.setColorFilter(null);
            }
        }
        super.dispatchDraw(canvas);
    }

    public InterfaceC0487c getItemData() {
        return null;
    }

    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StepOSImageView stepOSImageView = this.f11705b;
        if (stepOSImageView == null || stepOSImageView.getDrawable() == null) {
            return;
        }
        this.f11705b.getDrawable().setColorFilter(null);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f11704a = (TextView) findViewById(R.id.title);
        this.f11705b = (StepOSImageView) findViewById(R.id.icon);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        this.f11707d.b();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        StepOSImageView stepOSImageView = this.f11705b;
        if (stepOSImageView != null) {
            stepOSImageView.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIcon(Drawable drawable) {
        StepOSImageView stepOSImageView = this.f11705b;
        if (stepOSImageView == null) {
            return;
        }
        stepOSImageView.setImageDrawable(drawable);
        getItemData();
        throw null;
    }

    public void setSelectedIconColor(int i4) {
        if (this.f11706c != i4) {
            this.f11706c = i4;
            invalidate();
        }
    }

    public void setSelectedIconTintEnabled(boolean z4) {
        if (this.f11708e != z4) {
            this.f11708e = z4;
            invalidate();
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f11704a;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public void setTitleColor(ColorStateList colorStateList) {
        TextView textView = this.f11704a;
        if (textView == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }
}
