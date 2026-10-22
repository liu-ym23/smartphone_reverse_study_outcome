package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import com.stepos.alphame.R;
import e.EnumC0546d;
import g.AbstractC0560a;

@RestrictTo({EnumC0546d.f12494c})
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2725a;

    /* renamed from: b, reason: collision with root package name */
    public View f2726b;

    /* renamed from: c, reason: collision with root package name */
    public View f2727c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f2728d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f2729e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2730f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2731g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2732h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2733i;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z4 = false;
        setBackground(new C0191b(this, 0));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12588a);
        this.f2728d = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f2729e = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f2733i = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f2731g = true;
            this.f2730f = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f2731g ? !(this.f2728d != null || this.f2729e != null) : this.f2730f == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2728d;
        if (drawable != null && drawable.isStateful()) {
            this.f2728d.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2729e;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2729e.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2730f;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f2730f.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2728d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2729e;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2730f;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f2726b = findViewById(R.id.action_bar);
        this.f2727c = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2725a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        boolean z5;
        super.onLayout(z4, i4, i5, i6, i7);
        if (this.f2731g) {
            Drawable drawable = this.f2730f;
            if (drawable == null) {
                return;
            } else {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        } else {
            if (this.f2728d != null) {
                if (this.f2726b.getVisibility() == 0) {
                    this.f2728d.setBounds(this.f2726b.getLeft(), this.f2726b.getTop(), this.f2726b.getRight(), this.f2726b.getBottom());
                } else {
                    View view = this.f2727c;
                    if (view == null || view.getVisibility() != 0) {
                        this.f2728d.setBounds(0, 0, 0, 0);
                    } else {
                        this.f2728d.setBounds(this.f2727c.getLeft(), this.f2727c.getTop(), this.f2727c.getRight(), this.f2727c.getBottom());
                    }
                }
                z5 = true;
            } else {
                z5 = false;
            }
            this.f2732h = false;
            if (!z5) {
                return;
            }
        }
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        if (this.f2726b == null && View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE && (i6 = this.f2733i) >= 0) {
            i5 = View.MeasureSpec.makeMeasureSpec(Math.min(i6, View.MeasureSpec.getSize(i5)), Integer.MIN_VALUE);
        }
        super.onMeasure(i4, i5);
        if (this.f2726b == null) {
            return;
        }
        View.MeasureSpec.getMode(i5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f2728d;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2728d);
        }
        this.f2728d = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f2726b;
            if (view != null) {
                this.f2728d.setBounds(view.getLeft(), this.f2726b.getTop(), this.f2726b.getRight(), this.f2726b.getBottom());
            }
        }
        boolean z4 = false;
        if (!this.f2731g ? !(this.f2728d != null || this.f2729e != null) : this.f2730f == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2730f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2730f);
        }
        this.f2730f = drawable;
        boolean z4 = this.f2731g;
        boolean z5 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z4 && (drawable2 = this.f2730f) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z4 ? !(this.f2728d != null || this.f2729e != null) : this.f2730f == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f2729e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2729e);
        }
        this.f2729e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2732h && this.f2729e != null) {
                throw null;
            }
        }
        boolean z4 = false;
        if (!this.f2731g ? !(this.f2728d != null || this.f2729e != null) : this.f2730f == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(Q0 q02) {
    }

    public void setTransitioning(boolean z4) {
        this.f2725a = z4;
        setDescendantFocusability(z4 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f2728d;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
        Drawable drawable2 = this.f2729e;
        if (drawable2 != null) {
            drawable2.setVisible(z4, false);
        }
        Drawable drawable3 = this.f2730f;
        if (drawable3 != null) {
            drawable3.setVisible(z4, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2728d;
        boolean z4 = this.f2731g;
        return (drawable == drawable2 && !z4) || (drawable == this.f2729e && this.f2732h) || ((drawable == this.f2730f && z4) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i4) {
        if (i4 != 0) {
            return super.startActionModeForChild(view, callback, i4);
        }
        return null;
    }
}
