package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.S;
import androidx.core.view.T;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f21408a;

    /* renamed from: b, reason: collision with root package name */
    private w f21409b;

    /* renamed from: c, reason: collision with root package name */
    private View f21410c;

    /* renamed from: d, reason: collision with root package name */
    private View f21411d;

    /* renamed from: e, reason: collision with root package name */
    Drawable f21412e;

    /* renamed from: f, reason: collision with root package name */
    Drawable f21413f;

    /* renamed from: g, reason: collision with root package name */
    Drawable f21414g;

    /* renamed from: h, reason: collision with root package name */
    boolean f21415h;

    /* renamed from: i, reason: collision with root package name */
    boolean f21416i;

    /* renamed from: j, reason: collision with root package name */
    private int f21417j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f21418k;

    /* renamed from: l, reason: collision with root package name */
    protected S f21419l;

    /* renamed from: m, reason: collision with root package name */
    protected final a f21420m;

    protected class a implements T {

        /* renamed from: a, reason: collision with root package name */
        private boolean f21421a = false;

        /* renamed from: b, reason: collision with root package name */
        int f21422b;

        protected a() {
        }

        @Override // androidx.core.view.T
        public void c(View view) {
            this.f21421a = true;
        }

        @Override // androidx.core.view.T
        public void d(View view) {
            if (this.f21421a) {
                return;
            }
            ActionBarContainer actionBarContainer = ActionBarContainer.this;
            actionBarContainer.f21419l = null;
            actionBarContainer.f21409b.setVisibility(this.f21422b);
        }

        @Override // androidx.core.view.T
        public void e(View view) {
            ActionBarContainer.this.f21409b.setVisibility(0);
            this.f21421a = false;
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21420m = new a();
        setBackgroundDrawable(new C1100c(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.f17094a);
        this.f21412e = typedArrayObtainStyledAttributes.getDrawable(g.j.f17099b);
        this.f21413f = typedArrayObtainStyledAttributes.getDrawable(g.j.f17109d);
        this.f21417j = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.f17139j, -1);
        boolean z5 = true;
        if (getId() == X4.f.f5966N) {
            this.f21415h = true;
            this.f21414g = typedArrayObtainStyledAttributes.getDrawable(g.j.f17104c);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f21415h ? this.f21412e != null || this.f21413f != null : this.f21414g != null) {
            z5 = false;
        }
        setWillNotDraw(z5);
    }

    private int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean c(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f21412e;
        if (drawable != null && drawable.isStateful()) {
            this.f21412e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f21413f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f21413f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f21414g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f21414g.setState(getDrawableState());
    }

    public w getTabContainer() {
        return this.f21409b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f21412e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f21413f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f21414g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f21410c = findViewById(X4.f.f5979a);
        this.f21411d = findViewById(X4.f.f5991g);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f21408a || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e A[PHI: r0
      0x004e: PHI (r0v4 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:31:0x009f, B:33:0x00a3, B:15:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            super.onLayout(r6, r7, r8, r9, r10)
            stepos.support.v7.widget.w r6 = r5.f21409b
            r8 = 8
            r10 = 1
            r0 = 0
            if (r6 == 0) goto L13
            int r1 = r6.getVisibility()
            if (r1 == r8) goto L13
            r1 = r10
            goto L14
        L13:
            r1 = r0
        L14:
            if (r6 == 0) goto L39
            int r2 = r6.getVisibility()
            if (r2 == r8) goto L39
            int r8 = r5.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r6.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r6.getMeasuredHeight()
            int r4 = r2.leftMargin
            int r7 = r7 + r4
            int r3 = r8 - r3
            int r4 = r2.bottomMargin
            int r3 = r3 - r4
            int r2 = r2.rightMargin
            int r9 = r9 - r2
            int r8 = r8 - r4
            r6.layout(r7, r3, r9, r8)
        L39:
            boolean r7 = r5.f21415h
            if (r7 == 0) goto L51
            android.graphics.drawable.Drawable r6 = r5.f21414g
            if (r6 == 0) goto L4e
            int r7 = r5.getMeasuredWidth()
            int r8 = r5.getMeasuredHeight()
            r6.setBounds(r0, r0, r7, r8)
            goto Lcd
        L4e:
            r10 = r0
            goto Lcd
        L51:
            android.graphics.drawable.Drawable r7 = r5.f21412e
            if (r7 == 0) goto L9d
            android.view.View r7 = r5.f21410c
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L75
            android.graphics.drawable.Drawable r7 = r5.f21412e
            android.view.View r8 = r5.f21410c
            int r8 = r8.getLeft()
            android.view.View r9 = r5.f21410c
            int r9 = r9.getRight()
            android.view.View r2 = r5.f21410c
            int r2 = r2.getBottom()
            r7.setBounds(r8, r0, r9, r2)
            goto L9c
        L75:
            android.view.View r7 = r5.f21411d
            if (r7 == 0) goto L97
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L97
            android.graphics.drawable.Drawable r7 = r5.f21412e
            android.view.View r8 = r5.f21411d
            int r8 = r8.getLeft()
            android.view.View r9 = r5.f21411d
            int r9 = r9.getRight()
            android.view.View r2 = r5.f21411d
            int r2 = r2.getBottom()
            r7.setBounds(r8, r0, r9, r2)
            goto L9c
        L97:
            android.graphics.drawable.Drawable r7 = r5.f21412e
            r7.setBounds(r0, r0, r0, r0)
        L9c:
            r0 = r10
        L9d:
            r5.f21416i = r1
            if (r1 == 0) goto L4e
            android.graphics.drawable.Drawable r7 = r5.f21413f
            if (r7 == 0) goto L4e
            android.graphics.drawable.Drawable r7 = r5.f21412e
            if (r7 == 0) goto Lb8
            boolean r8 = r7 instanceof android.graphics.drawable.ColorDrawable
            if (r8 == 0) goto Lb8
            android.graphics.drawable.ColorDrawable r7 = (android.graphics.drawable.ColorDrawable) r7
            int r7 = r7.getColor()
            android.graphics.drawable.Drawable r8 = r5.f21413f
            r8.setTint(r7)
        Lb8:
            android.graphics.drawable.Drawable r7 = r5.f21413f
            int r8 = r6.getLeft()
            int r9 = r6.getTop()
            int r0 = r6.getRight()
            int r6 = r6.getBottom()
            r7.setBounds(r8, r9, r0, r6)
        Lcd:
            if (r10 == 0) goto Ld2
            r5.invalidate()
        Ld2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i5, int i6) {
        int i7;
        if (this.f21410c == null && View.MeasureSpec.getMode(i6) == Integer.MIN_VALUE && (i7 = this.f21417j) >= 0) {
            i6 = View.MeasureSpec.makeMeasureSpec(Math.min(i7 + getPaddingBottom() + getPaddingTop(), View.MeasureSpec.getSize(i6)), Integer.MIN_VALUE);
        }
        super.onMeasure(i5, i6);
        int iB = 0;
        if (this.f21415h && getMeasuredHeight() == getPaddingBottom() + getPaddingTop()) {
            setMeasuredDimension(getMeasuredWidth(), 0);
        }
        if (this.f21410c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i6);
        w wVar = this.f21409b;
        if (wVar == null || wVar.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!c(this.f21410c)) {
            iB = b(this.f21410c);
        } else if (!c(this.f21411d)) {
            iB = b(this.f21411d);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iB + b(this.f21409b) + getPaddingTop() + getPaddingBottom(), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i6) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setCapsuleStyleEnable(boolean z5) {
        this.f21418k = z5;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f21412e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f21412e);
        }
        this.f21412e = drawable;
        boolean z5 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f21410c;
            if (view != null) {
                this.f21412e.setBounds(view.getLeft(), 0, this.f21410c.getRight(), this.f21410c.getBottom());
            }
        }
        if (!this.f21415h ? !(this.f21412e != null || this.f21413f != null) : this.f21414g == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f21414g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f21414g);
        }
        this.f21414g = drawable;
        boolean z5 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f21415h && (drawable2 = this.f21414g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f21415h ? !(this.f21412e != null || this.f21413f != null) : this.f21414g == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        w wVar;
        Drawable drawable3 = this.f21413f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f21413f);
        }
        this.f21413f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f21416i && (drawable2 = this.f21413f) != null && (wVar = this.f21409b) != null) {
                drawable2.setBounds(wVar.getLeft(), this.f21409b.getTop(), this.f21409b.getRight(), this.f21409b.getBottom());
            }
        }
        boolean z5 = false;
        if (!this.f21415h ? !(this.f21412e != null || this.f21413f != null) : this.f21414g == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
    }

    public void setTabContainer(v vVar) {
        w wVar = this.f21409b;
        if (wVar != null) {
            removeView(wVar);
        }
        if (this.f21409b == null && vVar != null) {
            this.f21409b = new w(getContext());
        }
        if (vVar == null) {
            w wVar2 = this.f21409b;
            if (wVar2 != null) {
                wVar2.setTabView(null);
                this.f21409b = null;
                return;
            }
            return;
        }
        this.f21409b.setTabView(vVar);
        addView(this.f21409b);
        ViewGroup.LayoutParams layoutParams = this.f21409b.getLayoutParams();
        this.f21409b.f(false);
        layoutParams.width = -1;
        layoutParams.height = -2;
        vVar.setAllowCollapse(false);
        this.f21409b.setCapsuleStyleEnable(this.f21418k);
    }

    public void setTransitioning(boolean z5) {
        this.f21408a = z5;
        setDescendantFocusability(z5 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        boolean z5 = i5 == 0;
        Drawable drawable = this.f21412e;
        if (drawable != null) {
            drawable.setVisible(z5, false);
        }
        Drawable drawable2 = this.f21413f;
        if (drawable2 != null) {
            drawable2.setVisible(z5, false);
        }
        Drawable drawable3 = this.f21414g;
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
        if (drawable == this.f21412e && !this.f21415h) {
            return true;
        }
        if (drawable == this.f21413f && this.f21416i) {
            return true;
        }
        return (drawable == this.f21414g && this.f21415h) || super.verifyDrawable(drawable);
    }
}
