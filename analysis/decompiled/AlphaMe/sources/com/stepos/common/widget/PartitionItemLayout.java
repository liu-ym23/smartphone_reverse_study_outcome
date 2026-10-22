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
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public class PartitionItemLayout extends FrameLayout implements AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public Rect f11711a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f11712b;

    public PartitionItemLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        Drawable drawable = getResources().getDrawable(R.drawable.stepos_list_new_item_bg_light_activated);
        if (drawable != null) {
            setContentBackground(drawable);
        }
        if (this.f11711a == null) {
            this.f11711a = new Rect();
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        int i4 = rect.left;
        Rect rect2 = this.f11711a;
        rect.left = i4 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f11712b;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f11712b.setState(getDrawableState());
    }

    public Drawable getContentBackground() {
        return this.f11712b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f11712b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable drawable = this.f11712b;
        Rect rect = this.f11711a;
        drawable.setBounds(rect.left, rect.top, getMeasuredWidth() - this.f11711a.right, getMeasuredHeight() - this.f11711a.bottom);
        this.f11712b.draw(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
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
        if (this.f11711a == null) {
            this.f11711a = new Rect();
        }
        if (drawable != null) {
            drawable.getPadding(this.f11711a);
        } else {
            this.f11711a.setEmpty();
        }
    }

    public void setContentBackground(Drawable drawable) {
        Drawable drawable2 = this.f11712b;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f11712b);
            }
            this.f11712b = drawable;
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
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f11712b;
    }
}
