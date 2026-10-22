package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.stepos.stepclaw.R;
import g.a;
import g.o1;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f271a;

    /* renamed from: b, reason: collision with root package name */
    public View f272b;

    /* renamed from: c, reason: collision with root package name */
    public View f273c;
    public Drawable d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f274e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f275f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f276g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f277h;

    /* renamed from: j, reason: collision with root package name */
    public final int f278j;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new a(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.f1014a);
        boolean z = false;
        this.d = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f274e = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f278j = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f276g = true;
            this.f275f = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f276g ? !(this.d != null || this.f274e != null) : this.f275f == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.d;
        if (drawable != null && drawable.isStateful()) {
            this.d.setState(getDrawableState());
        }
        Drawable drawable2 = this.f274e;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f274e.setState(getDrawableState());
        }
        Drawable drawable3 = this.f275f;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f275f.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f274e;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f275f;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f272b = findViewById(R.id.action_bar);
        this.f273c = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f271a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        super.onLayout(z, i8, i9, i10, i11);
        boolean z2 = true;
        if (this.f276g) {
            Drawable drawable = this.f275f;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.d == null) {
                z2 = false;
            } else if (this.f272b.getVisibility() == 0) {
                this.d.setBounds(this.f272b.getLeft(), this.f272b.getTop(), this.f272b.getRight(), this.f272b.getBottom());
            } else {
                View view = this.f273c;
                if (view == null || view.getVisibility() != 0) {
                    this.d.setBounds(0, 0, 0, 0);
                } else {
                    this.d.setBounds(this.f273c.getLeft(), this.f273c.getTop(), this.f273c.getRight(), this.f273c.getBottom());
                }
            }
            this.f277h = false;
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        int i10;
        if (this.f272b == null && View.MeasureSpec.getMode(i9) == Integer.MIN_VALUE && (i10 = this.f278j) >= 0) {
            i9 = View.MeasureSpec.makeMeasureSpec(Math.min(i10, View.MeasureSpec.getSize(i9)), Integer.MIN_VALUE);
        }
        super.onMeasure(i8, i9);
        if (this.f272b == null) {
            return;
        }
        View.MeasureSpec.getMode(i9);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.d);
        }
        this.d = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f272b;
            if (view != null) {
                this.d.setBounds(view.getLeft(), this.f272b.getTop(), this.f272b.getRight(), this.f272b.getBottom());
            }
        }
        boolean z = false;
        if (!this.f276g ? !(this.d != null || this.f274e != null) : this.f275f == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f275f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f275f);
        }
        this.f275f = drawable;
        boolean z = this.f276g;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z && (drawable2 = this.f275f) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z ? !(this.d != null || this.f274e != null) : this.f275f == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f274e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f274e);
        }
        this.f274e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f277h && this.f274e != null) {
                throw null;
            }
        }
        boolean z = false;
        if (!this.f276g ? !(this.d != null || this.f274e != null) : this.f275f == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z) {
        this.f271a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        super.setVisibility(i8);
        boolean z = i8 == 0;
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f274e;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f275f;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.d;
        boolean z = this.f276g;
        if (drawable == drawable2 && !z) {
            return true;
        }
        if (drawable == this.f274e && this.f277h) {
            return true;
        }
        return (drawable == this.f275f && z) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i8) {
        if (i8 != 0) {
            return super.startActionModeForChild(view, callback, i8);
        }
        return null;
    }

    public void setTabContainer(o1 o1Var) {
    }
}
