package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.stepos.common.R$drawable;

/* loaded from: classes3.dex */
public class PartitionItemLayout extends FrameLayout implements AbsListView.SelectionBoundsAdjuster {
    protected Drawable mContentBackground;
    private Rect mItemShadeRect;

    public PartitionItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        int i10 = rect.left;
        Rect rect2 = this.mItemShadeRect;
        rect.left = i10 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mContentBackground;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.mContentBackground.setState(getDrawableState());
    }

    public Drawable getContentBackground() {
        return this.mContentBackground;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mContentBackground;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = this.mContentBackground;
        Rect rect = this.mItemShadeRect;
        drawable.setBounds(rect.left, rect.top, getMeasuredWidth() - this.mItemShadeRect.right, getMeasuredHeight() - this.mItemShadeRect.bottom);
        this.mContentBackground.draw(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PartitionItemLayout.class.getName());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.mItemShadeRect == null) {
            this.mItemShadeRect = new Rect();
        }
        if (drawable != null) {
            drawable.getPadding(this.mItemShadeRect);
        } else {
            this.mItemShadeRect.setEmpty();
        }
    }

    public void setContentBackground(Drawable drawable) {
        Drawable drawable2 = this.mContentBackground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.mContentBackground);
            }
            this.mContentBackground = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mContentBackground;
    }

    public PartitionItemLayout(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        Drawable drawable = getResources().getDrawable(R$drawable.stepos_list_new_item_bg_light_activated);
        if (drawable != null) {
            setContentBackground(drawable);
        }
        if (this.mItemShadeRect == null) {
            this.mItemShadeRect = new Rect();
        }
    }
}
