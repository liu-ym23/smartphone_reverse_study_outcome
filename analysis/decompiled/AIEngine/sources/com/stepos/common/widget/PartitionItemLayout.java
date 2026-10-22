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
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PartitionItemLayout extends FrameLayout implements AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public Rect f6956a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f6957b;

    public PartitionItemLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        Drawable drawable = getResources().getDrawable(R.drawable.stepos_list_new_item_bg_light_activated);
        if (drawable != null) {
            setContentBackground(drawable);
        }
        if (this.f6956a == null) {
            this.f6956a = new Rect();
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        int i10 = rect.left;
        Rect rect2 = this.f6956a;
        rect.left = i10 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f6957b;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f6957b.setState(getDrawableState());
    }

    public Drawable getContentBackground() {
        return this.f6957b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6957b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable drawable = this.f6957b;
        Rect rect = this.f6956a;
        drawable.setBounds(rect.left, rect.top, getMeasuredWidth() - this.f6956a.right, getMeasuredHeight() - this.f6956a.bottom);
        this.f6957b.draw(canvas);
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
        if (this.f6956a == null) {
            this.f6956a = new Rect();
        }
        if (drawable != null) {
            drawable.getPadding(this.f6956a);
        } else {
            this.f6956a.setEmpty();
        }
    }

    public void setContentBackground(Drawable drawable) {
        Drawable drawable2 = this.f6957b;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f6957b);
            }
            this.f6957b = drawable;
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
        return super.verifyDrawable(drawable) || drawable == this.f6957b;
    }
}
