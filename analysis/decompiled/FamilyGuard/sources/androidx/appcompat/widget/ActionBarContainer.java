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

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8006a;

    /* renamed from: b, reason: collision with root package name */
    private View f8007b;

    /* renamed from: c, reason: collision with root package name */
    private View f8008c;

    /* renamed from: d, reason: collision with root package name */
    private View f8009d;

    /* renamed from: e, reason: collision with root package name */
    Drawable f8010e;

    /* renamed from: f, reason: collision with root package name */
    Drawable f8011f;

    /* renamed from: g, reason: collision with root package name */
    Drawable f8012g;

    /* renamed from: h, reason: collision with root package name */
    boolean f8013h;

    /* renamed from: i, reason: collision with root package name */
    boolean f8014i;

    /* renamed from: j, reason: collision with root package name */
    private int f8015j;

    private static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new C0432b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.f17094a);
        this.f8010e = typedArrayObtainStyledAttributes.getDrawable(g.j.f17099b);
        this.f8011f = typedArrayObtainStyledAttributes.getDrawable(g.j.f17109d);
        this.f8015j = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.f17139j, -1);
        boolean z5 = true;
        if (getId() == g.f.f16943y) {
            this.f8013h = true;
            this.f8012g = typedArrayObtainStyledAttributes.getDrawable(g.j.f17104c);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f8013h ? this.f8010e != null || this.f8011f != null : this.f8012g != null) {
            z5 = false;
        }
        setWillNotDraw(z5);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f8010e;
        if (drawable != null && drawable.isStateful()) {
            this.f8010e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f8011f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f8011f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f8012g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f8012g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f8007b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f8010e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f8011f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f8012g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f8008c = findViewById(g.f.f16919a);
        this.f8009d = findViewById(g.f.f16924f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f8006a || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[PHI: r0
      0x0048: PHI (r0v8 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:31:0x00a5, B:33:0x00a9, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            super.onLayout(r5, r6, r7, r8, r9)
            android.view.View r5 = r4.f8007b
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
            boolean r6 = r4.f8013h
            if (r6 == 0) goto L4b
            android.graphics.drawable.Drawable r5 = r4.f8012g
            if (r5 == 0) goto L48
            int r6 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            r5.setBounds(r0, r0, r6, r7)
            goto Lbe
        L48:
            r9 = r0
            goto Lbe
        L4b:
            android.graphics.drawable.Drawable r6 = r4.f8010e
            if (r6 == 0) goto La3
            android.view.View r6 = r4.f8008c
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L75
            android.graphics.drawable.Drawable r6 = r4.f8010e
            android.view.View r7 = r4.f8008c
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f8008c
            int r8 = r8.getTop()
            android.view.View r0 = r4.f8008c
            int r0 = r0.getRight()
            android.view.View r2 = r4.f8008c
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto La2
        L75:
            android.view.View r6 = r4.f8009d
            if (r6 == 0) goto L9d
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L9d
            android.graphics.drawable.Drawable r6 = r4.f8010e
            android.view.View r7 = r4.f8009d
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f8009d
            int r8 = r8.getTop()
            android.view.View r0 = r4.f8009d
            int r0 = r0.getRight()
            android.view.View r2 = r4.f8009d
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto La2
        L9d:
            android.graphics.drawable.Drawable r6 = r4.f8010e
            r6.setBounds(r0, r0, r0, r0)
        La2:
            r0 = r9
        La3:
            r4.f8014i = r1
            if (r1 == 0) goto L48
            android.graphics.drawable.Drawable r6 = r4.f8011f
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
    public void onMeasure(int i5, int i6) {
        int i7;
        if (this.f8008c == null && View.MeasureSpec.getMode(i6) == Integer.MIN_VALUE && (i7 = this.f8015j) >= 0) {
            i6 = View.MeasureSpec.makeMeasureSpec(Math.min(i7, View.MeasureSpec.getSize(i6)), Integer.MIN_VALUE);
        }
        super.onMeasure(i5, i6);
        if (this.f8008c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i6);
        View view = this.f8007b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f8008c) ? a(this.f8008c) : !b(this.f8009d) ? a(this.f8009d) : 0) + a(this.f8007b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i6) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f8010e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f8010e);
        }
        this.f8010e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f8008c;
            if (view != null) {
                this.f8010e.setBounds(view.getLeft(), this.f8008c.getTop(), this.f8008c.getRight(), this.f8008c.getBottom());
            }
        }
        boolean z5 = false;
        if (!this.f8013h ? !(this.f8010e != null || this.f8011f != null) : this.f8012g == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f8012g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f8012g);
        }
        this.f8012g = drawable;
        boolean z5 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f8013h && (drawable2 = this.f8012g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f8013h ? !(this.f8010e != null || this.f8011f != null) : this.f8012g == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f8011f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f8011f);
        }
        this.f8011f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f8014i && (drawable2 = this.f8011f) != null) {
                drawable2.setBounds(this.f8007b.getLeft(), this.f8007b.getTop(), this.f8007b.getRight(), this.f8007b.getBottom());
            }
        }
        boolean z5 = false;
        if (!this.f8013h ? !(this.f8010e != null || this.f8011f != null) : this.f8012g == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(T t5) {
        View view = this.f8007b;
        if (view != null) {
            removeView(view);
        }
        this.f8007b = t5;
        if (t5 != null) {
            addView(t5);
            ViewGroup.LayoutParams layoutParams = t5.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            t5.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z5) {
        this.f8006a = z5;
        setDescendantFocusability(z5 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        boolean z5 = i5 == 0;
        Drawable drawable = this.f8010e;
        if (drawable != null) {
            drawable.setVisible(z5, false);
        }
        Drawable drawable2 = this.f8011f;
        if (drawable2 != null) {
            drawable2.setVisible(z5, false);
        }
        Drawable drawable3 = this.f8012g;
        if (drawable3 != null) {
            drawable3.setVisible(z5, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.f8010e && !this.f8013h) {
            return true;
        }
        if (drawable == this.f8011f && this.f8014i) {
            return true;
        }
        return (drawable == this.f8012g && this.f8013h) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i5) {
        if (i5 != 0) {
            return super.startActionModeForChild(view, callback, i5);
        }
        return null;
    }
}
