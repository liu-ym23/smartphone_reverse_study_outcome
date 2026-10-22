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
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import io.requery.android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8716a;

    /* renamed from: b, reason: collision with root package name */
    public View f8717b;

    /* renamed from: c, reason: collision with root package name */
    public View f8718c;

    /* renamed from: d, reason: collision with root package name */
    public View f8719d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f8720e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f8721f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f8722g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8723h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8724i;

    /* renamed from: j, reason: collision with root package name */
    public int f8725j;

    public static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new C1289b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f8720e = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f8721f = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f8725j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z10 = true;
        if (getId() == R$id.split_action_bar) {
            this.f8723h = true;
            this.f8722g = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f8723h ? this.f8720e != null || this.f8721f != null : this.f8722g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f8720e;
        if (drawable != null && drawable.isStateful()) {
            this.f8720e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f8721f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f8721f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f8722g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f8722g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f8717b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f8720e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f8721f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f8722g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f8718c = findViewById(R$id.action_bar);
        this.f8719d = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f8716a || super.onInterceptTouchEvent(motionEvent);
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
            android.view.View r5 = r4.f8717b
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
            boolean r6 = r4.f8723h
            if (r6 == 0) goto L4b
            android.graphics.drawable.Drawable r5 = r4.f8722g
            if (r5 == 0) goto L48
            int r6 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            r5.setBounds(r0, r0, r6, r7)
            goto Lbe
        L48:
            r9 = r0
            goto Lbe
        L4b:
            android.graphics.drawable.Drawable r6 = r4.f8720e
            if (r6 == 0) goto La3
            android.view.View r6 = r4.f8718c
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L75
            android.graphics.drawable.Drawable r6 = r4.f8720e
            android.view.View r7 = r4.f8718c
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f8718c
            int r8 = r8.getTop()
            android.view.View r0 = r4.f8718c
            int r0 = r0.getRight()
            android.view.View r2 = r4.f8718c
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto La2
        L75:
            android.view.View r6 = r4.f8719d
            if (r6 == 0) goto L9d
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L9d
            android.graphics.drawable.Drawable r6 = r4.f8720e
            android.view.View r7 = r4.f8719d
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f8719d
            int r8 = r8.getTop()
            android.view.View r0 = r4.f8719d
            int r0 = r0.getRight()
            android.view.View r2 = r4.f8719d
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto La2
        L9d:
            android.graphics.drawable.Drawable r6 = r4.f8720e
            r6.setBounds(r0, r0, r0, r0)
        La2:
            r0 = r9
        La3:
            r4.f8724i = r1
            if (r1 == 0) goto L48
            android.graphics.drawable.Drawable r6 = r4.f8721f
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
    public void onMeasure(int i10, int i11) {
        int i12;
        if (this.f8718c == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i12 = this.f8725j) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i12, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        if (this.f8718c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        View view = this.f8717b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f8718c) ? a(this.f8718c) : !b(this.f8719d) ? a(this.f8719d) : 0) + a(this.f8717b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i11) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f8720e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f8720e);
        }
        this.f8720e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f8718c;
            if (view != null) {
                this.f8720e.setBounds(view.getLeft(), this.f8718c.getTop(), this.f8718c.getRight(), this.f8718c.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f8723h ? !(this.f8720e != null || this.f8721f != null) : this.f8722g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f8722g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f8722g);
        }
        this.f8722g = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f8723h && (drawable2 = this.f8722g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f8723h ? !(this.f8720e != null || this.f8721f != null) : this.f8722g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f8721f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f8721f);
        }
        this.f8721f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f8724i && (drawable2 = this.f8721f) != null) {
                drawable2.setBounds(this.f8717b.getLeft(), this.f8717b.getTop(), this.f8717b.getRight(), this.f8717b.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f8723h ? !(this.f8720e != null || this.f8721f != null) : this.f8722g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(M m10) {
        View view = this.f8717b;
        if (view != null) {
            removeView(view);
        }
        this.f8717b = m10;
        if (m10 != null) {
            addView(m10);
            ViewGroup.LayoutParams layoutParams = m10.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            m10.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z10) {
        this.f8716a = z10;
        setDescendantFocusability(z10 ? 393216 : SQLiteDatabase.OPEN_PRIVATECACHE);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f8720e;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f8721f;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f8722g;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.f8720e && !this.f8723h) {
            return true;
        }
        if (drawable == this.f8721f && this.f8724i) {
            return true;
        }
        return (drawable == this.f8722g && this.f8723h) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }
}
