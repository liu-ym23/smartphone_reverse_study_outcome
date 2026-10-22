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
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NavigationMenuItemView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f6949a;

    /* renamed from: b, reason: collision with root package name */
    public StepOSImageView f6950b;

    /* renamed from: c, reason: collision with root package name */
    public int f6951c;

    /* renamed from: d, reason: collision with root package name */
    public final q f6952d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6953e;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6953e = true;
        setWillNotDraw(false);
        q qVar = new q(context);
        this.f6952d = qVar;
        qVar.f7178d = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        StepOSImageView stepOSImageView = this.f6950b;
        if (stepOSImageView == null) {
            super.dispatchDraw(canvas);
            return;
        }
        Drawable drawable = stepOSImageView.getDrawable();
        if (this.f6953e) {
            if (isSelected()) {
                drawable.setColorFilter(this.f6951c, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.setColorFilter(null);
            }
        }
        super.dispatchDraw(canvas);
    }

    public c getItemData() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StepOSImageView stepOSImageView = this.f6950b;
        if (stepOSImageView == null || stepOSImageView.getDrawable() == null) {
            return;
        }
        this.f6950b.getDrawable().setColorFilter(null);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f6949a = (TextView) findViewById(R.id.title);
        this.f6950b = (StepOSImageView) findViewById(R.id.icon);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f6952d.a();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        StepOSImageView stepOSImageView = this.f6950b;
        if (stepOSImageView != null) {
            stepOSImageView.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIcon(Drawable drawable) {
        StepOSImageView stepOSImageView = this.f6950b;
        if (stepOSImageView == null) {
            return;
        }
        stepOSImageView.setImageDrawable(drawable);
        getItemData();
        throw null;
    }

    public void setSelectedIconColor(int i10) {
        if (this.f6951c != i10) {
            this.f6951c = i10;
            invalidate();
        }
    }

    public void setSelectedIconTintEnabled(boolean z) {
        if (this.f6953e != z) {
            this.f6953e = z;
            invalidate();
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f6949a;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public void setTitleColor(ColorStateList colorStateList) {
        TextView textView = this.f6949a;
        if (textView == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public View getView() {
        return this;
    }
}
