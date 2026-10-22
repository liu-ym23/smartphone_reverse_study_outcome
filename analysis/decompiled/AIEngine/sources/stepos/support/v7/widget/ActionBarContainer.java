package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.stepos.aiengine.R;
import stepos.support.v7.widget.t;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f12437a;

    /* renamed from: b, reason: collision with root package name */
    public t f12438b;

    /* renamed from: c, reason: collision with root package name */
    public View f12439c;

    /* renamed from: d, reason: collision with root package name */
    public View f12440d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f12441e;
    public Drawable h;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f12442j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f12443k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12444l;

    /* renamed from: m, reason: collision with root package name */
    public final int f12445m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12446n;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundDrawable(new androidx.appcompat.widget.b(this, 1));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f8921a);
        boolean z = false;
        this.f12441e = typedArrayObtainStyledAttributes.getDrawable(0);
        this.h = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f12445m = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f12443k = true;
            this.f12442j = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f12443k ? !(this.f12441e != null || this.h != null) : this.f12442j == null) {
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
        Drawable drawable = this.f12441e;
        if (drawable != null && drawable.isStateful()) {
            this.f12441e.setState(getDrawableState());
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null && drawable2.isStateful()) {
            this.h.setState(getDrawableState());
        }
        Drawable drawable3 = this.f12442j;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f12442j.setState(getDrawableState());
    }

    public t getTabContainer() {
        return this.f12438b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f12441e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f12442j;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f12439c = findViewById(R.id.action_bar);
        this.f12440d = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f12437a || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e A[PHI: r0
      0x004e: PHI (r0v4 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:31:0x009f, B:33:0x00a3, B:15:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            super.onLayout(r6, r7, r8, r9, r10)
            stepos.support.v7.widget.t r6 = r5.f12438b
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
            boolean r7 = r5.f12443k
            if (r7 == 0) goto L51
            android.graphics.drawable.Drawable r6 = r5.f12442j
            if (r6 == 0) goto L4e
            int r7 = r5.getMeasuredWidth()
            int r8 = r5.getMeasuredHeight()
            r6.setBounds(r0, r0, r7, r8)
            goto Lcd
        L4e:
            r10 = r0
            goto Lcd
        L51:
            android.graphics.drawable.Drawable r7 = r5.f12441e
            if (r7 == 0) goto L9d
            android.view.View r7 = r5.f12439c
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L75
            android.graphics.drawable.Drawable r7 = r5.f12441e
            android.view.View r8 = r5.f12439c
            int r8 = r8.getLeft()
            android.view.View r9 = r5.f12439c
            int r9 = r9.getRight()
            android.view.View r2 = r5.f12439c
            int r2 = r2.getBottom()
            r7.setBounds(r8, r0, r9, r2)
            goto L9c
        L75:
            android.view.View r7 = r5.f12440d
            if (r7 == 0) goto L97
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L97
            android.graphics.drawable.Drawable r7 = r5.f12441e
            android.view.View r8 = r5.f12440d
            int r8 = r8.getLeft()
            android.view.View r9 = r5.f12440d
            int r9 = r9.getRight()
            android.view.View r2 = r5.f12440d
            int r2 = r2.getBottom()
            r7.setBounds(r8, r0, r9, r2)
            goto L9c
        L97:
            android.graphics.drawable.Drawable r7 = r5.f12441e
            r7.setBounds(r0, r0, r0, r0)
        L9c:
            r0 = r10
        L9d:
            r5.f12444l = r1
            if (r1 == 0) goto L4e
            android.graphics.drawable.Drawable r7 = r5.h
            if (r7 == 0) goto L4e
            android.graphics.drawable.Drawable r7 = r5.f12441e
            if (r7 == 0) goto Lb8
            boolean r8 = r7 instanceof android.graphics.drawable.ColorDrawable
            if (r8 == 0) goto Lb8
            android.graphics.drawable.ColorDrawable r7 = (android.graphics.drawable.ColorDrawable) r7
            int r7 = r7.getColor()
            android.graphics.drawable.Drawable r8 = r5.h
            r8.setTint(r7)
        Lb8:
            android.graphics.drawable.Drawable r7 = r5.h
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
    public final void onMeasure(int i10, int i11) {
        int i12;
        if (this.f12439c == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i12 = this.f12445m) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(getPaddingTop() + getPaddingBottom() + i12, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        int iA = 0;
        if (this.f12443k) {
            if (getMeasuredHeight() == getPaddingTop() + getPaddingBottom()) {
                setMeasuredDimension(getMeasuredWidth(), 0);
            }
        }
        if (this.f12439c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        t tVar = this.f12438b;
        if (tVar == null || tVar.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        View view = this.f12439c;
        if (view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0) {
            View view2 = this.f12440d;
            if (view2 != null && view2.getVisibility() != 8 && view2.getMeasuredHeight() != 0) {
                iA = a(this.f12440d);
            }
        } else {
            iA = a(this.f12439c);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(getPaddingBottom() + getPaddingTop() + a(this.f12438b) + iA, mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i11) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setCapsuleStyleEnable(boolean z) {
        this.f12446n = z;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f12441e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f12441e);
        }
        this.f12441e = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f12439c;
            if (view != null) {
                this.f12441e.setBounds(view.getLeft(), 0, this.f12439c.getRight(), this.f12439c.getBottom());
            }
        }
        if (!this.f12443k ? !(this.f12441e != null || this.h != null) : this.f12442j == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f12442j;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f12442j);
        }
        this.f12442j = drawable;
        boolean z = this.f12443k;
        boolean z3 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z && (drawable2 = this.f12442j) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z ? !(this.f12441e != null || this.h != null) : this.f12442j == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        t tVar;
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.h);
        }
        this.h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f12444l && (drawable2 = this.h) != null && (tVar = this.f12438b) != null) {
                drawable2.setBounds(tVar.getLeft(), this.f12438b.getTop(), this.f12438b.getRight(), this.f12438b.getBottom());
            }
        }
        boolean z = false;
        if (!this.f12443k ? !(this.f12441e != null || this.h != null) : this.f12442j == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(s sVar) throws Resources.NotFoundException {
        t tVar = this.f12438b;
        if (tVar != null) {
            removeView(tVar);
        }
        if (this.f12438b == null && sVar != null) {
            this.f12438b = new t(getContext());
        }
        if (sVar == null) {
            t tVar2 = this.f12438b;
            if (tVar2 != null) {
                tVar2.setTabView(null);
                this.f12438b = null;
                return;
            }
            return;
        }
        this.f12438b.setTabView(sVar);
        addView(this.f12438b);
        ViewGroup.LayoutParams layoutParams = this.f12438b.getLayoutParams();
        t tVar3 = this.f12438b;
        tVar3.f12849b.a(false);
        if (tVar3.f12855l) {
            tVar3.f12855l = false;
            TextView textView = tVar3.f12858o;
            if (textView != null && textView.getLayoutParams() != null) {
                ((t.a) tVar3.f12858o.getLayoutParams()).f12862a = 48;
            }
        }
        layoutParams.width = -1;
        layoutParams.height = -2;
        sVar.setAllowCollapse(false);
        this.f12438b.setCapsuleStyleEnable(this.f12446n);
    }

    public void setTransitioning(boolean z) {
        this.f12437a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z = i10 == 0;
        Drawable drawable = this.f12441e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f12442j;
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
        Drawable drawable2 = this.f12441e;
        boolean z = this.f12443k;
        if (drawable == drawable2 && !z) {
            return true;
        }
        if (drawable == this.h && this.f12444l) {
            return true;
        }
        return (drawable == this.f12442j && z) || super.verifyDrawable(drawable);
    }
}
