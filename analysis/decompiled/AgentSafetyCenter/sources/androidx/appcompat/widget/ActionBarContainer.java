package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.stepos.agentsafetycenter.R;
import g.a;
import java.lang.invoke.VarHandle;
import m.b;
import m.g2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public boolean f744c;

    /* renamed from: f, reason: collision with root package name */
    public View f745f;

    /* renamed from: g, reason: collision with root package name */
    public View f746g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f747h;
    public Drawable i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f748j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f749k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f750l;

    /* renamed from: m, reason: collision with root package name */
    public final int f751m;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z10 = false;
        b bVar = new b(0);
        bVar.f7879b = this;
        VarHandle.storeStoreFence();
        setBackground(bVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f4098a);
        this.f747h = typedArrayObtainStyledAttributes.getDrawable(0);
        this.i = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f751m = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f749k = true;
            this.f748j = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f749k ? !(this.f747h != null || this.i != null) : this.f748j == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f747h;
        if (drawable != null && drawable.isStateful()) {
            this.f747h.setState(getDrawableState());
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null && drawable2.isStateful()) {
            this.i.setState(getDrawableState());
        }
        Drawable drawable3 = this.f748j;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f748j.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f747h;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f748j;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f745f = findViewById(R.id.action_bar);
        this.f746g = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f744c || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        super.onLayout(z10, i, i3, i10, i11);
        boolean z11 = true;
        if (this.f749k) {
            Drawable drawable = this.f748j;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z11 = false;
            }
        } else {
            if (this.f747h == null) {
                z11 = false;
            } else if (this.f745f.getVisibility() == 0) {
                this.f747h.setBounds(this.f745f.getLeft(), this.f745f.getTop(), this.f745f.getRight(), this.f745f.getBottom());
            } else {
                View view = this.f746g;
                if (view == null || view.getVisibility() != 0) {
                    this.f747h.setBounds(0, 0, 0, 0);
                } else {
                    this.f747h.setBounds(this.f746g.getLeft(), this.f746g.getTop(), this.f746g.getRight(), this.f746g.getBottom());
                }
            }
            this.f750l = false;
        }
        if (z11) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        int i10;
        if (this.f745f == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i10 = this.f751m) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i10, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i3);
        if (this.f745f == null) {
            return;
        }
        View.MeasureSpec.getMode(i3);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f747h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f747h);
        }
        this.f747h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f745f;
            if (view != null) {
                this.f747h.setBounds(view.getLeft(), this.f745f.getTop(), this.f745f.getRight(), this.f745f.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f749k ? !(this.f747h != null || this.i != null) : this.f748j == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f748j;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f748j);
        }
        this.f748j = drawable;
        boolean z10 = this.f749k;
        boolean z11 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z10 && (drawable2 = this.f748j) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z10 ? !(this.f747h != null || this.i != null) : this.f748j == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.i);
        }
        this.i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f750l && this.i != null) {
                throw null;
            }
        }
        boolean z10 = false;
        if (!this.f749k ? !(this.f747h != null || this.i != null) : this.f748j == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z10) {
        this.f744c = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z10 = i == 0;
        Drawable drawable = this.f747h;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f748j;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f747h;
        boolean z10 = this.f749k;
        if (drawable == drawable2 && !z10) {
            return true;
        }
        if (drawable == this.i && this.f750l) {
            return true;
        }
        return (drawable == this.f748j && z10) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public void setTabContainer(g2 g2Var) {
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }
}
