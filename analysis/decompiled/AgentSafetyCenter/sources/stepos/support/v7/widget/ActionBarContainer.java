package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public boolean f12557c;

    /* renamed from: f, reason: collision with root package name */
    public View f12558f;

    /* renamed from: g, reason: collision with root package name */
    public View f12559g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f12560h;
    public Drawable i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f12561j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f12562k;

    /* renamed from: l, reason: collision with root package name */
    public final int f12563l;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z10 = true;
        m.b bVar = new m.b(1);
        bVar.f7879b = this;
        VarHandle.storeStoreFence();
        setBackgroundDrawable(bVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f4098a);
        this.f12560h = typedArrayObtainStyledAttributes.getDrawable(0);
        this.i = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f12563l = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f12562k = true;
            this.f12561j = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f12562k ? this.f12560h != null || this.i != null : this.f12561j != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f12560h;
        if (drawable != null && drawable.isStateful()) {
            this.f12560h.setState(getDrawableState());
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null && drawable2.isStateful()) {
            this.i.setState(getDrawableState());
        }
        Drawable drawable3 = this.f12561j;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f12561j.setState(getDrawableState());
    }

    public r0 getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f12560h;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f12561j;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f12558f = findViewById(R.id.action_bar);
        this.f12559g = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f12557c || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        super.onLayout(z10, i, i3, i10, i11);
        if (this.f12562k) {
            Drawable drawable = this.f12561j;
            if (drawable == null) {
                return;
            } else {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        } else {
            if (this.f12560h == null) {
                return;
            }
            if (this.f12558f.getVisibility() == 0) {
                this.f12560h.setBounds(this.f12558f.getLeft(), 0, this.f12558f.getRight(), this.f12558f.getBottom());
            } else {
                View view = this.f12559g;
                if (view == null || view.getVisibility() != 0) {
                    this.f12560h.setBounds(0, 0, 0, 0);
                } else {
                    this.f12560h.setBounds(this.f12559g.getLeft(), 0, this.f12559g.getRight(), this.f12559g.getBottom());
                }
            }
        }
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        int i10;
        if (this.f12558f == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i10 = this.f12563l) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(getPaddingTop() + getPaddingBottom() + i10, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i3);
        if (this.f12562k) {
            if (getMeasuredHeight() == getPaddingTop() + getPaddingBottom()) {
                setMeasuredDimension(getMeasuredWidth(), 0);
            }
        }
        if (this.f12558f == null) {
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
        Drawable drawable2 = this.f12560h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f12560h);
        }
        this.f12560h = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f12558f;
            if (view != null) {
                this.f12560h.setBounds(view.getLeft(), 0, this.f12558f.getRight(), this.f12558f.getBottom());
            }
        }
        if (!this.f12562k ? !(this.f12560h != null || this.i != null) : this.f12561j == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f12561j;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f12561j);
        }
        this.f12561j = drawable;
        boolean z10 = this.f12562k;
        boolean z11 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z10 && (drawable2 = this.f12561j) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z10 ? !(this.f12560h != null || this.i != null) : this.f12561j == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        invalidate();
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
        }
        boolean z10 = false;
        if (!this.f12562k ? !(this.f12560h != null || this.i != null) : this.f12561j == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
    }

    public void setTransitioning(boolean z10) {
        this.f12557c = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z10 = i == 0;
        Drawable drawable = this.f12560h;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f12561j;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f12560h;
        boolean z10 = this.f12562k;
        if (drawable != drawable2 || z10) {
            return (drawable == this.f12561j && z10) || super.verifyDrawable(drawable);
        }
        return true;
    }

    public void setCapsuleStyleEnable(boolean z10) {
    }

    public void setTabContainer(q0 q0Var) {
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }
}
