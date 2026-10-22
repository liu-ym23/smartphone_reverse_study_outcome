package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f552a;

    /* renamed from: b, reason: collision with root package name */
    public q0 f553b;

    /* renamed from: c, reason: collision with root package name */
    public View f554c;

    /* renamed from: d, reason: collision with root package name */
    public View f555d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f556e;
    public Drawable h;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f557j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f558k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f559l;

    /* renamed from: m, reason: collision with root package name */
    public final int f560m;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new b(this, 0));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f8921a);
        boolean z = false;
        this.f556e = typedArrayObtainStyledAttributes.getDrawable(0);
        this.h = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f560m = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f558k = true;
            this.f557j = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f558k ? !(this.f556e != null || this.h != null) : this.f557j == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    public static int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f556e;
        if (drawable != null && drawable.isStateful()) {
            this.f556e.setState(getDrawableState());
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null && drawable2.isStateful()) {
            this.h.setState(getDrawableState());
        }
        Drawable drawable3 = this.f557j;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f557j.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f553b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f556e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f557j;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f554c = findViewById(R.id.action_bar);
        this.f555d = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f552a || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[PHI: r0
      0x0048: PHI (r0v8 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:31:0x00a5, B:33:0x00a9, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            super.onLayout(r5, r6, r7, r8, r9)
            androidx.appcompat.widget.q0 r5 = r4.f553b
            r7 = 8
            r9 = 1
            r0 = 0
            if (r5 == 0) goto L13
            int r1 = r5.getVisibility()
            if (r1 == r7) goto L13
            r1 = r9
            goto L14
        L13:
            r1 = r0
        L14:
            if (r5 == 0) goto L33
            int r2 = r5.getVisibility()
            if (r2 == r7) goto L33
            int r7 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r5.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r5.getMeasuredHeight()
            int r3 = r7 - r3
            int r2 = r2.bottomMargin
            int r3 = r3 - r2
            int r7 = r7 - r2
            r5.layout(r6, r3, r8, r7)
        L33:
            boolean r6 = r4.f558k
            if (r6 == 0) goto L4b
            android.graphics.drawable.Drawable r5 = r4.f557j
            if (r5 == 0) goto L48
            int r6 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            r5.setBounds(r0, r0, r6, r7)
            goto Lbe
        L48:
            r9 = r0
            goto Lbe
        L4b:
            android.graphics.drawable.Drawable r6 = r4.f556e
            if (r6 == 0) goto La3
            android.view.View r6 = r4.f554c
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L75
            android.graphics.drawable.Drawable r6 = r4.f556e
            android.view.View r7 = r4.f554c
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f554c
            int r8 = r8.getTop()
            android.view.View r0 = r4.f554c
            int r0 = r0.getRight()
            android.view.View r2 = r4.f554c
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto La2
        L75:
            android.view.View r6 = r4.f555d
            if (r6 == 0) goto L9d
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L9d
            android.graphics.drawable.Drawable r6 = r4.f556e
            android.view.View r7 = r4.f555d
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f555d
            int r8 = r8.getTop()
            android.view.View r0 = r4.f555d
            int r0 = r0.getRight()
            android.view.View r2 = r4.f555d
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto La2
        L9d:
            android.graphics.drawable.Drawable r6 = r4.f556e
            r6.setBounds(r0, r0, r0, r0)
        La2:
            r0 = r9
        La3:
            r4.f559l = r1
            if (r1 == 0) goto L48
            android.graphics.drawable.Drawable r6 = r4.h
            if (r6 == 0) goto L48
            int r7 = r5.getLeft()
            int r8 = r5.getTop()
            int r0 = r5.getRight()
            int r5 = r5.getBottom()
            r6.setBounds(r7, r8, r0, r5)
        Lbe:
            if (r9 == 0) goto Lc3
            r4.invalidate()
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        int iA;
        int i12;
        if (this.f554c == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i12 = this.f560m) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i12, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        if (this.f554c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        q0 q0Var = this.f553b;
        if (q0Var == null || q0Var.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        View view = this.f554c;
        if (view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0) {
            View view2 = this.f555d;
            iA = (view2 == null || view2.getVisibility() == 8 || view2.getMeasuredHeight() == 0) ? 0 : a(this.f555d);
        } else {
            iA = a(this.f554c);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.f553b) + iA, mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i11) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f556e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f556e);
        }
        this.f556e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f554c;
            if (view != null) {
                this.f556e.setBounds(view.getLeft(), this.f554c.getTop(), this.f554c.getRight(), this.f554c.getBottom());
            }
        }
        boolean z = false;
        if (!this.f558k ? !(this.f556e != null || this.h != null) : this.f557j == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f557j;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f557j);
        }
        this.f557j = drawable;
        boolean z = this.f558k;
        boolean z3 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z && (drawable2 = this.f557j) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z ? !(this.f556e != null || this.h != null) : this.f557j == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.h);
        }
        this.h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f559l && (drawable2 = this.h) != null) {
                drawable2.setBounds(this.f553b.getLeft(), this.f553b.getTop(), this.f553b.getRight(), this.f553b.getBottom());
            }
        }
        boolean z = false;
        if (!this.f558k ? !(this.f556e != null || this.h != null) : this.f557j == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(q0 q0Var) {
        q0 q0Var2 = this.f553b;
        if (q0Var2 != null) {
            removeView(q0Var2);
        }
        this.f553b = q0Var;
        if (q0Var != null) {
            addView(q0Var);
            ViewGroup.LayoutParams layoutParams = q0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            q0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f552a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z = i10 == 0;
        Drawable drawable = this.f556e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f557j;
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
        Drawable drawable2 = this.f556e;
        boolean z = this.f558k;
        if (drawable == drawable2 && !z) {
            return true;
        }
        if (drawable == this.h && this.f559l) {
            return true;
        }
        return (drawable == this.f557j && z) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }
}
