package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.stepos.alphame.R;
import g.AbstractC0560a;

/* loaded from: classes2.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f14704a;

    /* renamed from: b, reason: collision with root package name */
    public View f14705b;

    /* renamed from: c, reason: collision with root package name */
    public View f14706c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f14707d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f14708e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f14709f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f14710g;

    /* renamed from: h, reason: collision with root package name */
    public final int f14711h;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z4 = true;
        setBackgroundDrawable(new C0882b(this, 1));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12588a);
        this.f14707d = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f14708e = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f14711h = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f14710g = true;
            this.f14709f = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f14710g ? this.f14707d != null || this.f14708e != null : this.f14709f != null) {
            z4 = false;
        }
        setWillNotDraw(z4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f14707d;
        if (drawable != null && drawable.isStateful()) {
            this.f14707d.setState(getDrawableState());
        }
        Drawable drawable2 = this.f14708e;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f14708e.setState(getDrawableState());
        }
        Drawable drawable3 = this.f14709f;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f14709f.setState(getDrawableState());
    }

    public S getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f14707d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f14708e;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f14709f;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f14705b = findViewById(R.id.action_bar);
        this.f14706c = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f14704a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (this.f14710g) {
            Drawable drawable = this.f14709f;
            if (drawable == null) {
                return;
            } else {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        } else {
            if (this.f14707d == null) {
                return;
            }
            if (this.f14705b.getVisibility() == 0) {
                this.f14707d.setBounds(this.f14705b.getLeft(), 0, this.f14705b.getRight(), this.f14705b.getBottom());
            } else {
                View view = this.f14706c;
                if (view == null || view.getVisibility() != 0) {
                    this.f14707d.setBounds(0, 0, 0, 0);
                } else {
                    this.f14707d.setBounds(this.f14706c.getLeft(), 0, this.f14706c.getRight(), this.f14706c.getBottom());
                }
            }
        }
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        if (this.f14705b == null && View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE && (i6 = this.f14711h) >= 0) {
            i5 = View.MeasureSpec.makeMeasureSpec(Math.min(getPaddingTop() + getPaddingBottom() + i6, View.MeasureSpec.getSize(i5)), Integer.MIN_VALUE);
        }
        super.onMeasure(i4, i5);
        if (this.f14710g) {
            if (getMeasuredHeight() == getPaddingTop() + getPaddingBottom()) {
                setMeasuredDimension(getMeasuredWidth(), 0);
            }
        }
        if (this.f14705b == null) {
            return;
        }
        View.MeasureSpec.getMode(i5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setCapsuleStyleEnable(boolean z4) {
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f14707d;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f14707d);
        }
        this.f14707d = drawable;
        boolean z4 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f14705b;
            if (view != null) {
                this.f14707d.setBounds(view.getLeft(), 0, this.f14705b.getRight(), this.f14705b.getBottom());
            }
        }
        if (!this.f14710g ? !(this.f14707d != null || this.f14708e != null) : this.f14709f == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f14709f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f14709f);
        }
        this.f14709f = drawable;
        boolean z4 = this.f14710g;
        boolean z5 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z4 && (drawable2 = this.f14709f) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z4 ? !(this.f14707d != null || this.f14708e != null) : this.f14709f == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f14708e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f14708e);
        }
        this.f14708e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        boolean z4 = false;
        if (!this.f14710g ? !(this.f14707d != null || this.f14708e != null) : this.f14709f == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
    }

    public void setTabContainer(Q q4) {
    }

    public void setTransitioning(boolean z4) {
        this.f14704a = z4;
        setDescendantFocusability(z4 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f14707d;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
        Drawable drawable2 = this.f14708e;
        if (drawable2 != null) {
            drawable2.setVisible(z4, false);
        }
        Drawable drawable3 = this.f14709f;
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
        Drawable drawable2 = this.f14707d;
        boolean z4 = this.f14710g;
        return (drawable == drawable2 && !z4) || (drawable == this.f14709f && z4) || super.verifyDrawable(drawable);
    }
}
