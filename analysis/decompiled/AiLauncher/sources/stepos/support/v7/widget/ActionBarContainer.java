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
import androidx.appcompat.R$styleable;
import androidx.core.view.U;
import androidx.core.view.V;
import io.requery.android.database.sqlite.SQLiteDatabase;
import stepos.support.v7.appcompat.R$id;

/* loaded from: classes5.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f41026a;

    /* renamed from: b, reason: collision with root package name */
    public s f41027b;

    /* renamed from: c, reason: collision with root package name */
    public View f41028c;

    /* renamed from: d, reason: collision with root package name */
    public View f41029d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f41030e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f41031f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f41032g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f41033h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f41034i;

    /* renamed from: j, reason: collision with root package name */
    public int f41035j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f41036k;

    /* renamed from: l, reason: collision with root package name */
    public U f41037l;

    /* renamed from: m, reason: collision with root package name */
    public final a f41038m;

    public class a implements V {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41039a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f41040b;

        public a() {
        }

        @Override // androidx.core.view.V
        public void c(View view) {
            this.f41039a = true;
        }

        @Override // androidx.core.view.V
        public void d(View view) {
            if (this.f41039a) {
                return;
            }
            ActionBarContainer actionBarContainer = ActionBarContainer.this;
            actionBarContainer.f41037l = null;
            actionBarContainer.f41027b.setVisibility(this.f41040b);
        }

        @Override // androidx.core.view.V
        public void e(View view) {
            ActionBarContainer.this.f41027b.setVisibility(0);
            this.f41039a = false;
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41038m = new a();
        setBackgroundDrawable(new c(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f41030e = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f41031f = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f41035j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z10 = true;
        if (getId() == R$id.split_action_bar) {
            this.f41033h = true;
            this.f41032g = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f41033h ? this.f41030e != null || this.f41031f != null : this.f41032g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    public final int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean c(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f41030e;
        if (drawable != null && drawable.isStateful()) {
            this.f41030e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f41031f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f41031f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f41032g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f41032g.setState(getDrawableState());
    }

    public s getTabContainer() {
        return this.f41027b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f41030e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f41031f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f41032g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f41028c = findViewById(R$id.action_bar);
        this.f41029d = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f41026a || super.onInterceptTouchEvent(motionEvent);
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
            stepos.support.v7.widget.s r6 = r5.f41027b
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
            boolean r7 = r5.f41033h
            if (r7 == 0) goto L51
            android.graphics.drawable.Drawable r6 = r5.f41032g
            if (r6 == 0) goto L4e
            int r7 = r5.getMeasuredWidth()
            int r8 = r5.getMeasuredHeight()
            r6.setBounds(r0, r0, r7, r8)
            goto Lcd
        L4e:
            r10 = r0
            goto Lcd
        L51:
            android.graphics.drawable.Drawable r7 = r5.f41030e
            if (r7 == 0) goto L9d
            android.view.View r7 = r5.f41028c
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L75
            android.graphics.drawable.Drawable r7 = r5.f41030e
            android.view.View r8 = r5.f41028c
            int r8 = r8.getLeft()
            android.view.View r9 = r5.f41028c
            int r9 = r9.getRight()
            android.view.View r2 = r5.f41028c
            int r2 = r2.getBottom()
            r7.setBounds(r8, r0, r9, r2)
            goto L9c
        L75:
            android.view.View r7 = r5.f41029d
            if (r7 == 0) goto L97
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L97
            android.graphics.drawable.Drawable r7 = r5.f41030e
            android.view.View r8 = r5.f41029d
            int r8 = r8.getLeft()
            android.view.View r9 = r5.f41029d
            int r9 = r9.getRight()
            android.view.View r2 = r5.f41029d
            int r2 = r2.getBottom()
            r7.setBounds(r8, r0, r9, r2)
            goto L9c
        L97:
            android.graphics.drawable.Drawable r7 = r5.f41030e
            r7.setBounds(r0, r0, r0, r0)
        L9c:
            r0 = r10
        L9d:
            r5.f41034i = r1
            if (r1 == 0) goto L4e
            android.graphics.drawable.Drawable r7 = r5.f41031f
            if (r7 == 0) goto L4e
            android.graphics.drawable.Drawable r7 = r5.f41030e
            if (r7 == 0) goto Lb8
            boolean r8 = r7 instanceof android.graphics.drawable.ColorDrawable
            if (r8 == 0) goto Lb8
            android.graphics.drawable.ColorDrawable r7 = (android.graphics.drawable.ColorDrawable) r7
            int r7 = r7.getColor()
            android.graphics.drawable.Drawable r8 = r5.f41031f
            r8.setTint(r7)
        Lb8:
            android.graphics.drawable.Drawable r7 = r5.f41031f
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
    public void onMeasure(int i10, int i11) {
        int i12;
        if (this.f41028c == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i12 = this.f41035j) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i12 + getPaddingBottom() + getPaddingTop(), View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        int iB = 0;
        if (this.f41033h && getMeasuredHeight() == getPaddingBottom() + getPaddingTop()) {
            setMeasuredDimension(getMeasuredWidth(), 0);
        }
        if (this.f41028c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        s sVar = this.f41027b;
        if (sVar == null || sVar.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!c(this.f41028c)) {
            iB = b(this.f41028c);
        } else if (!c(this.f41029d)) {
            iB = b(this.f41029d);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iB + b(this.f41027b) + getPaddingTop() + getPaddingBottom(), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i11) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setCapsuleStyleEnable(boolean z10) {
        this.f41036k = z10;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f41030e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f41030e);
        }
        this.f41030e = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f41028c;
            if (view != null) {
                this.f41030e.setBounds(view.getLeft(), 0, this.f41028c.getRight(), this.f41028c.getBottom());
            }
        }
        if (!this.f41033h ? !(this.f41030e != null || this.f41031f != null) : this.f41032g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f41032g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f41032g);
        }
        this.f41032g = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f41033h && (drawable2 = this.f41032g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f41033h ? !(this.f41030e != null || this.f41031f != null) : this.f41032g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        s sVar;
        Drawable drawable3 = this.f41031f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f41031f);
        }
        this.f41031f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f41034i && (drawable2 = this.f41031f) != null && (sVar = this.f41027b) != null) {
                drawable2.setBounds(sVar.getLeft(), this.f41027b.getTop(), this.f41027b.getRight(), this.f41027b.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f41033h ? !(this.f41030e != null || this.f41031f != null) : this.f41032g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
    }

    public void setTabContainer(r rVar) {
        s sVar = this.f41027b;
        if (sVar != null) {
            removeView(sVar);
        }
        if (this.f41027b == null && rVar != null) {
            this.f41027b = new s(getContext());
        }
        if (rVar == null) {
            s sVar2 = this.f41027b;
            if (sVar2 != null) {
                sVar2.setTabView(null);
                this.f41027b = null;
                return;
            }
            return;
        }
        this.f41027b.setTabView(rVar);
        addView(this.f41027b);
        ViewGroup.LayoutParams layoutParams = this.f41027b.getLayoutParams();
        this.f41027b.f(false);
        layoutParams.width = -1;
        layoutParams.height = -2;
        rVar.setAllowCollapse(false);
        this.f41027b.setCapsuleStyleEnable(this.f41036k);
    }

    public void setTransitioning(boolean z10) {
        this.f41026a = z10;
        setDescendantFocusability(z10 ? 393216 : SQLiteDatabase.OPEN_PRIVATECACHE);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f41030e;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f41031f;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f41032g;
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
        if (drawable == this.f41030e && !this.f41033h) {
            return true;
        }
        if (drawable == this.f41031f && this.f41034i) {
            return true;
        }
        return (drawable == this.f41032g && this.f41033h) || super.verifyDrawable(drawable);
    }
}
