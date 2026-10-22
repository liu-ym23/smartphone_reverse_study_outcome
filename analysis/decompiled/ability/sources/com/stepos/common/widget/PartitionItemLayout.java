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
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public class PartitionItemLayout extends FrameLayout implements AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public Rect f3733a;
    public Drawable b;

    public PartitionItemLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        Drawable drawable = getResources().getDrawable(R.drawable.stepos_list_new_item_bg_light_activated);
        if (drawable != null) {
            setContentBackground(drawable);
        }
        if (this.f3733a == null) {
            this.f3733a = new Rect();
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        int i = rect.left;
        Rect rect2 = this.f3733a;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.b;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.b.setState(getDrawableState());
    }

    public Drawable getContentBackground() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable drawable = this.b;
        Rect rect = this.f3733a;
        drawable.setBounds(rect.left, rect.top, getMeasuredWidth() - this.f3733a.right, getMeasuredHeight() - this.f3733a.bottom);
        this.b.draw(canvas);
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
        if (this.f3733a == null) {
            this.f3733a = new Rect();
        }
        if (drawable != null) {
            drawable.getPadding(this.f3733a);
        } else {
            this.f3733a.setEmpty();
        }
    }

    public void setContentBackground(Drawable drawable) {
        Drawable drawable2 = this.b;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.b);
            }
            this.b = drawable;
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
        return super.verifyDrawable(drawable) || drawable == this.b;
    }
}
