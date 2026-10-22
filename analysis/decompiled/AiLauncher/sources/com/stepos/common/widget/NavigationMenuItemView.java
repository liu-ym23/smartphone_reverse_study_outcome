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
import com.stepos.common.R$id;

/* loaded from: classes3.dex */
public class NavigationMenuItemView extends LinearLayout {
    private StepOSImageView mIconView;
    private c mItemData;
    private final h mNewMessagePainter;
    private int mSelectedIconColor;
    private boolean mSelectedIconTintEnabled;
    private TextView mTitleView;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        StepOSImageView stepOSImageView = this.mIconView;
        if (stepOSImageView == null) {
            super.dispatchDraw(canvas);
            return;
        }
        Drawable drawable = stepOSImageView.getDrawable();
        if (this.mSelectedIconTintEnabled) {
            if (isSelected()) {
                drawable.setColorFilter(this.mSelectedIconColor, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.setColorFilter(null);
            }
        }
        super.dispatchDraw(canvas);
    }

    public c getItemData() {
        return null;
    }

    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StepOSImageView stepOSImageView = this.mIconView;
        if (stepOSImageView == null || stepOSImageView.getDrawable() == null) {
            return;
        }
        this.mIconView.getDrawable().setColorFilter(null);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mTitleView = (TextView) findViewById(R$id.title);
        this.mIconView = (StepOSImageView) findViewById(R$id.icon);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.mNewMessagePainter.o();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        StepOSImageView stepOSImageView = this.mIconView;
        if (stepOSImageView != null) {
            stepOSImageView.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIcon(Drawable drawable) {
        StepOSImageView stepOSImageView = this.mIconView;
        if (stepOSImageView == null) {
            return;
        }
        stepOSImageView.setImageDrawable(drawable);
        getItemData();
        throw null;
    }

    public void setSelectedIconColor(int i10) {
        if (this.mSelectedIconColor != i10) {
            this.mSelectedIconColor = i10;
            invalidate();
        }
    }

    public void setSelectedIconTintEnabled(boolean z10) {
        if (this.mSelectedIconTintEnabled != z10) {
            this.mSelectedIconTintEnabled = z10;
            invalidate();
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.mTitleView;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public void setTitleColor(ColorStateList colorStateList) {
        TextView textView = this.mTitleView;
        if (textView == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mSelectedIconTintEnabled = true;
        setWillNotDraw(false);
        h hVar = new h(context);
        this.mNewMessagePainter = hVar;
        hVar.x(true);
    }
}
