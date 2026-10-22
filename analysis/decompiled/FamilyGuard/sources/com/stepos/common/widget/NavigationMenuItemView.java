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

/* loaded from: classes.dex */
public class NavigationMenuItemView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f14042a;

    /* renamed from: b, reason: collision with root package name */
    private StepOSImageView f14043b;

    /* renamed from: c, reason: collision with root package name */
    private int f14044c;

    /* renamed from: d, reason: collision with root package name */
    private final g f14045d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f14046e;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        StepOSImageView stepOSImageView = this.f14043b;
        if (stepOSImageView == null) {
            super.dispatchDraw(canvas);
            return;
        }
        Drawable drawable = stepOSImageView.getDrawable();
        if (this.f14046e) {
            if (isSelected()) {
                drawable.setColorFilter(this.f14044c, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.setColorFilter(null);
            }
        }
        super.dispatchDraw(canvas);
    }

    public b getItemData() {
        return null;
    }

    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StepOSImageView stepOSImageView = this.f14043b;
        if (stepOSImageView == null || stepOSImageView.getDrawable() == null) {
            return;
        }
        this.f14043b.getDrawable().setColorFilter(null);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f14042a = (TextView) findViewById(H1.h.f2276t0);
        this.f14043b = (StepOSImageView) findViewById(H1.h.f2281w);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        this.f14045d.o();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        StepOSImageView stepOSImageView = this.f14043b;
        if (stepOSImageView != null) {
            stepOSImageView.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIcon(Drawable drawable) {
        StepOSImageView stepOSImageView = this.f14043b;
        if (stepOSImageView == null) {
            return;
        }
        stepOSImageView.setImageDrawable(drawable);
        getItemData();
        throw null;
    }

    public void setSelectedIconColor(int i5) {
        if (this.f14044c != i5) {
            this.f14044c = i5;
            invalidate();
        }
    }

    public void setSelectedIconTintEnabled(boolean z5) {
        if (this.f14046e != z5) {
            this.f14046e = z5;
            invalidate();
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f14042a;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public void setTitleColor(ColorStateList colorStateList) {
        TextView textView = this.f14042a;
        if (textView == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f14046e = true;
        setWillNotDraw(false);
        g gVar = new g(context);
        this.f14045d = gVar;
        gVar.x(true);
    }
}
