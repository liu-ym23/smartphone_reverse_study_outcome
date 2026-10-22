package com.stepos.common.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import b1.C0555c;

/* loaded from: classes.dex */
public class Switch extends CompoundButton {

    /* renamed from: Q, reason: collision with root package name */
    private static int[] f14310Q;

    /* renamed from: R, reason: collision with root package name */
    private static final int[] f14311R = {R.attr.state_checked};

    /* renamed from: S, reason: collision with root package name */
    private static final P.f<Switch> f14312S = new a("thumbPos");

    /* renamed from: A, reason: collision with root package name */
    private ColorStateList f14313A;

    /* renamed from: B, reason: collision with root package name */
    private ColorStateList f14314B;

    /* renamed from: C, reason: collision with root package name */
    private ColorStateList f14315C;

    /* renamed from: D, reason: collision with root package name */
    private ColorStateList f14316D;

    /* renamed from: E, reason: collision with root package name */
    private ColorStateList f14317E;

    /* renamed from: F, reason: collision with root package name */
    private ColorStateList f14318F;

    /* renamed from: G, reason: collision with root package name */
    private final Rect f14319G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f14320H;

    /* renamed from: I, reason: collision with root package name */
    private f f14321I;

    /* renamed from: J, reason: collision with root package name */
    private AttributeSet f14322J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f14323K;

    /* renamed from: L, reason: collision with root package name */
    private float f14324L;

    /* renamed from: M, reason: collision with root package name */
    private float f14325M;

    /* renamed from: a, reason: collision with root package name */
    private Drawable f14326a;

    /* renamed from: b, reason: collision with root package name */
    private l f14327b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f14328c;

    /* renamed from: d, reason: collision with root package name */
    private int f14329d;

    /* renamed from: e, reason: collision with root package name */
    private int f14330e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f14331f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f14332g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f14333h;

    /* renamed from: i, reason: collision with root package name */
    private int f14334i;

    /* renamed from: j, reason: collision with root package name */
    private int f14335j;

    /* renamed from: k, reason: collision with root package name */
    private float f14336k;

    /* renamed from: l, reason: collision with root package name */
    private float f14337l;

    /* renamed from: m, reason: collision with root package name */
    private VelocityTracker f14338m;

    /* renamed from: n, reason: collision with root package name */
    private int f14339n;

    /* renamed from: o, reason: collision with root package name */
    private float f14340o;

    /* renamed from: p, reason: collision with root package name */
    private int f14341p;

    /* renamed from: q, reason: collision with root package name */
    private int f14342q;

    /* renamed from: r, reason: collision with root package name */
    private int f14343r;

    /* renamed from: s, reason: collision with root package name */
    private int f14344s;

    /* renamed from: t, reason: collision with root package name */
    private int f14345t;

    /* renamed from: u, reason: collision with root package name */
    private int f14346u;

    /* renamed from: v, reason: collision with root package name */
    private int f14347v;

    /* renamed from: w, reason: collision with root package name */
    private TextPaint f14348w;

    /* renamed from: x, reason: collision with root package name */
    private P.i f14349x;

    /* renamed from: y, reason: collision with root package name */
    private ColorStateList f14350y;

    /* renamed from: z, reason: collision with root package name */
    private ColorStateList f14351z;

    class a extends P.f<Switch> {
        a(String str) {
            super(str);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(Switch r12) {
            return r12.f14340o;
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(Switch r12, float f5) {
            r12.setThumbPosition(f5);
        }
    }

    public Switch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H1.c.f2061h);
    }

    private void c(boolean z5) {
        float f5 = z5 ? 1.0f : 0.0f;
        e();
        if (this.f14349x == null) {
            this.f14349x = new P.i(this, f14312S);
        }
        P.j jVar = new P.j();
        jVar.h(570.0f).f(z5 ? this.f14324L : this.f14325M).g(f5);
        this.f14349x.k(0.00390625f);
        this.f14349x.x(jVar);
        this.f14349x.p();
    }

    private void d(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private void e() {
        P.i iVar = this.f14349x;
        if (iVar == null || !iVar.i()) {
            return;
        }
        this.f14349x.d();
    }

    private l f(int i5, int i6) {
        l lVar = new l(new GradientDrawable());
        lVar.a().setShape(0);
        lVar.j(i5);
        lVar.k(i6);
        return lVar;
    }

    private int g(ColorStateList colorStateList) {
        return isEnabled() ? i(colorStateList) : h(colorStateList);
    }

    private boolean getTargetCheckedState() {
        return this.f14340o > 0.5f;
    }

    private int getThumbOffset() {
        return (int) ((getThumbValue() * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f14326a;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f14319G;
        drawable.getPadding(rect);
        d dVarA = this.f14327b.a() != null ? d.a(this.f14327b.c(), 0, this.f14327b.d(), 0) : d.f14394e;
        return ((((this.f14341p - this.f14343r) - rect.left) - rect.right) - dVarA.f14395a) - dVarA.f14397c;
    }

    private float getThumbValue() {
        return this.f14340o;
    }

    private int h(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    private int i(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{R.attr.state_enabled}, 0);
    }

    private int j(float f5, float f6, boolean z5) {
        return z5 ? (int) (f5 * 255.0f) : (int) (f6 * 255.0f);
    }

    private int k(int i5, int i6, float f5) {
        return C0555c.b().evaluate(f5, Integer.valueOf(i5), Integer.valueOf(i6)).intValue();
    }

    private boolean l(float f5, float f6) {
        return f5 > ((float) this.f14344s) && f5 < ((float) this.f14346u) && f6 > ((float) this.f14345t) && f6 < ((float) this.f14347v);
    }

    private void o() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(this.f14322J, H1.m.J6, H1.c.f2061h, H1.l.f2384p);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(H1.m.P6);
        this.f14326a = drawable;
        if (drawable == null) {
            this.f14326a = getResources().getDrawable(H1.g.f2192h);
        }
        ColorStateList colorStateList = this.f14315C;
        if (colorStateList != null) {
            this.f14313A = colorStateList;
        } else {
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(H1.m.R6);
            this.f14313A = colorStateList2;
            if (colorStateList2 == null) {
                this.f14313A = getResources().getColorStateList(H1.e.f2099u);
            }
        }
        ColorStateList colorStateList3 = this.f14316D;
        if (colorStateList3 != null) {
            this.f14314B = colorStateList3;
        } else {
            ColorStateList colorStateList4 = typedArrayObtainStyledAttributes.getColorStateList(H1.m.Q6);
            this.f14314B = colorStateList4;
            if (colorStateList4 == null) {
                this.f14314B = getResources().getColorStateList(H1.e.f2075C);
            }
        }
        Drawable drawable2 = this.f14326a;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        f fVar = this.f14321I;
        if (fVar != null) {
            fVar.b(this.f14351z, this.f14350y);
            setThumbPosition(this.f14340o);
        }
        typedArrayObtainStyledAttributes.recycle();
        refreshDrawableState();
    }

    private void r(MotionEvent motionEvent) {
        this.f14334i = 0;
        boolean zIsChecked = true;
        if (motionEvent.getAction() == 1 && isEnabled()) {
            this.f14338m.computeCurrentVelocity(1000);
            float xVelocity = this.f14338m.getXVelocity();
            if (Math.abs(xVelocity) <= this.f14339n) {
                zIsChecked = getTargetCheckedState();
            } else if (!m() ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                zIsChecked = false;
            }
        } else {
            zIsChecked = isChecked();
        }
        q(zIsChecked, false);
        d(motionEvent);
    }

    private void setCheckOffDamping(float f5) {
        this.f14325M = f5;
    }

    private void setCheckOnDamping(float f5) {
        this.f14324L = f5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbPosition(float f5) {
        this.f14340o = f5;
        float fMax = f5 < 0.0f ? Math.max(f5, 0.0f) : Math.min(f5, 1.0f);
        f fVar = this.f14321I;
        if (fVar != null) {
            this.f14327b.l(fVar.f14402d);
            this.f14327b.i(this.f14321I.f14401c);
            this.f14327b.h(this.f14321I.f14400b);
            int iK = k(g(this.f14321I.f14403e), g(this.f14321I.f14404f), fMax);
            l lVar = this.f14327b;
            f fVar2 = this.f14321I;
            lVar.f(j(fVar2.f14405g, fVar2.f14406h, isEnabled()));
            this.f14327b.g(iK);
            int iK2 = k(g(this.f14314B), g(this.f14313A), fMax);
            if (!this.f14323K || !isChecked() || N1.j.b(iK2)) {
                this.f14326a.setColorFilter(iK2, PorterDuff.Mode.SRC_IN);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int iC;
        int iE;
        int iB;
        int iB2;
        int i5;
        int i6;
        Rect rect = this.f14319G;
        int i7 = this.f14344s;
        int i8 = this.f14345t;
        int i9 = this.f14346u;
        int i10 = this.f14347v;
        int thumbOffset = getThumbOffset() + i7;
        d dVar = this.f14327b != null ? d.f14394e : d.f14394e;
        Drawable drawable = this.f14326a;
        if (drawable != null) {
            drawable.getPadding(rect);
            int i11 = rect.left;
            thumbOffset += i11;
            if (dVar != d.f14394e) {
                int i12 = dVar.f14395a;
                if (i12 > i11) {
                    i7 += i12 - i11;
                }
                int i13 = dVar.f14396b;
                int i14 = rect.top;
                i5 = i13 > i14 ? (i13 - i14) + i8 : i8;
                int i15 = dVar.f14397c;
                int i16 = rect.right;
                i6 = i15 > i16 ? i9 - (i15 - i16) : i9;
                int i17 = dVar.f14398d;
                int i18 = rect.bottom;
                if (i17 > i18) {
                    i10 -= i17 - i18;
                }
            } else {
                i5 = i8;
                i6 = i9;
            }
            this.f14326a.setBounds(i7, i5, i6, i10);
        }
        l lVar = this.f14327b;
        if (lVar != null) {
            lVar.a().getPadding(rect);
            if (m()) {
                iE = (i9 - getThumbOffset()) - this.f14327b.c();
                iC = iE - this.f14327b.e();
                iB = i8 + ((this.f14342q - this.f14327b.b()) / 2);
                iB2 = this.f14327b.b();
            } else {
                iC = this.f14327b.c() + thumbOffset;
                iE = iC + this.f14327b.e();
                iB = i8 + ((this.f14342q - this.f14327b.b()) / 2);
                iB2 = this.f14327b.b();
            }
            this.f14327b.a().setBounds(iC, iB, iE, iB2 + iB);
        }
        ColorStateList colorStateList = this.f14316D;
        if (colorStateList != null) {
            this.f14314B = colorStateList;
        }
        ColorStateList colorStateList2 = this.f14315C;
        if (colorStateList2 != null) {
            this.f14313A = colorStateList2;
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        l lVar = this.f14327b;
        if (lVar != null && lVar.a() != null) {
            this.f14327b.a().setState(drawableState);
        }
        Drawable drawable = this.f14326a;
        if (drawable != null) {
            drawable.setState(drawableState);
        }
        setThumbPosition(this.f14340o);
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!m()) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f14341p;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f14330e : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (m()) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f14341p;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f14330e : compoundPaddingRight;
    }

    public int getSwitchMinWidth() {
        return this.f14329d;
    }

    public int getSwitchPadding() {
        return this.f14330e;
    }

    public Drawable getTrackDrawable() {
        return this.f14326a;
    }

    @Override // android.view.View
    public boolean isLaidOut() {
        return getWidth() > 0 && getHeight() > 0;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        l lVar = this.f14327b;
        if (lVar != null && lVar.a() != null) {
            this.f14327b.a().jumpToCurrentState();
        }
        Drawable drawable = this.f14326a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        P.i iVar = this.f14349x;
        if (iVar != null && iVar.i() && this.f14349x.t()) {
            this.f14349x.y();
        }
    }

    public boolean m() {
        return getLayoutDirection() == 1;
    }

    public void n() {
        N1.a.h(this, 31022);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
        this.f14327b.a().setCallback(this);
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i5) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i5 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f14311R);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.f14319G;
        Drawable drawable = this.f14326a;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        GradientDrawable gradientDrawableA = this.f14327b.a();
        if (drawable != null) {
            if (!this.f14331f || gradientDrawableA == null) {
                drawable.draw(canvas);
            } else {
                d dVar = d.f14394e;
                gradientDrawableA.copyBounds(rect);
                rect.left += dVar.f14395a;
                rect.right -= dVar.f14397c;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (gradientDrawableA != null) {
            gradientDrawableA.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Switch.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Switch.class.getName());
        CharSequence charSequence = isChecked() ? this.f14332g : this.f14333h;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(' ');
        sb.append(charSequence);
        accessibilityNodeInfo.setText(sb);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int iMax;
        int width;
        int paddingLeft;
        int i9;
        int paddingTop;
        int height;
        super.onLayout(z5, i5, i6, i7, i8);
        int iMax2 = 0;
        if (this.f14327b != null) {
            Rect rect = this.f14319G;
            Drawable drawable = this.f14326a;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            d dVar = d.f14394e;
            iMax = Math.max(0, dVar.f14395a - rect.left);
            iMax2 = Math.max(0, dVar.f14397c - rect.right);
        } else {
            iMax = 0;
        }
        if (m()) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f14341p + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f14341p) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i9 = this.f14342q;
            paddingTop = paddingTop2 - (i9 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.f14342q;
                this.f14344s = paddingLeft;
                this.f14345t = paddingTop;
                this.f14347v = height;
                this.f14346u = width;
            }
            paddingTop = getPaddingTop();
            i9 = this.f14342q;
        }
        height = i9 + paddingTop;
        this.f14344s = paddingLeft;
        this.f14345t = paddingTop;
        this.f14347v = height;
        this.f14346u = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i5, int i6) {
        int iMax;
        int intrinsicHeight;
        int intrinsicHeight2;
        Rect rect = this.f14319G;
        l lVar = this.f14327b;
        if (lVar != null) {
            lVar.a().getPadding(rect);
            iMax = Math.max((this.f14327b.a().getIntrinsicWidth() - rect.left) - rect.right, this.f14321I.f14402d);
            intrinsicHeight = this.f14327b.a().getIntrinsicHeight();
        } else {
            iMax = 0;
            intrinsicHeight = 0;
        }
        this.f14343r = iMax;
        Drawable drawable = this.f14326a;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicHeight2 = this.f14326a.getIntrinsicHeight();
        } else {
            rect.setEmpty();
            intrinsicHeight2 = 0;
        }
        int iMax2 = rect.left;
        int iMax3 = rect.right;
        d dVarA = d.f14394e;
        if (this.f14327b != null) {
            iMax2 = Math.max(iMax2, 0);
            iMax3 = Math.max(iMax3, 0);
            dVarA = d.a(this.f14327b.c(), 0, this.f14327b.d(), 0);
        }
        int iMax4 = Math.max(this.f14329d, (this.f14343r * 2) + iMax2 + iMax3 + dVarA.f14395a + dVarA.f14397c);
        int iMax5 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f14341p = iMax4;
        this.f14342q = iMax5;
        super.onMeasure(i5, i6);
        if (getMeasuredHeight() < iMax5) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax5);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f14338m
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9d
            r2 = 2
            if (r0 == r1) goto L89
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L89
            goto Lb7
        L16:
            int r0 = r6.f14334i
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f14336k
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3b
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L38
            r2 = r3
            goto L3b
        L38:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L3b:
            boolean r0 = r6.m()
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.f14340o
            float r0 = r0 + r2
            float r0 = com.stepos.common.widget.e.a(r0, r4, r3)
            float r2 = r6.f14340o
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.f14336k = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f14336k
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f14335j
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.f14337l
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f14335j
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.f14334i = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f14336k = r0
            r6.f14337l = r3
            return r1
        L89:
            int r0 = r6.f14334i
            if (r0 != r2) goto L94
            r6.r(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.f14334i = r0
            android.view.VelocityTracker r0 = r6.f14338m
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.l(r0, r2)
            if (r3 == 0) goto Lb7
            r6.f14334i = r1
            r6.f14336k = r0
            r6.f14337l = r2
        Lb7:
            boolean r6 = super.onTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.Switch.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        if (z5) {
            this.f14323K = N1.j.c(getContext());
        }
    }

    public void p(boolean z5, boolean z6) {
        if (isChecked() == z5) {
            P.i iVar = this.f14349x;
            if (iVar == null || !iVar.i()) {
                setThumbPosition(z5 ? 1.0f : 0.0f);
                return;
            }
            return;
        }
        super.setChecked(z5);
        boolean zIsChecked = isChecked();
        if (z6 && isAttachedToWindow() && isLaidOut()) {
            c(zIsChecked);
        } else {
            e();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    public void q(boolean z5, boolean z6) {
        if (isChecked() != z5) {
            n();
        }
        p(z5, z6);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z5) {
        p(z5, true);
    }

    public void setCheckedWithHapticFeedback(boolean z5) {
        q(z5, true);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        super.setCompoundDrawablesWithIntrinsicBounds(i5, i6, i7, i8);
    }

    public void setDarkTrackOffColor(ColorStateList colorStateList) {
        this.f14318F = colorStateList;
        invalidate();
    }

    public void setDarkTrackOnColor(ColorStateList colorStateList) {
        this.f14317E = colorStateList;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
    }

    public void setSwitchMinWidth(int i5) {
        this.f14329d = i5;
        requestLayout();
    }

    public void setSwitchPadding(int i5) {
        this.f14330e = i5;
        requestLayout();
    }

    public void setThumbOffColor(ColorStateList colorStateList) {
        this.f14351z = colorStateList;
        f fVar = this.f14321I;
        if (fVar != null) {
            fVar.b(colorStateList, this.f14350y);
            setThumbPosition(this.f14340o);
        }
        invalidate();
    }

    public void setThumbOnColor(ColorStateList colorStateList) {
        this.f14350y = colorStateList;
        f fVar = this.f14321I;
        if (fVar != null) {
            fVar.b(this.f14351z, colorStateList);
            setThumbPosition(this.f14340o);
        }
        invalidate();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f14326a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f14326a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawableStateChanged();
        }
        requestLayout();
    }

    public void setTrackOffColor(ColorStateList colorStateList) {
        this.f14316D = colorStateList;
        invalidate();
    }

    public void setTrackOnColor(ColorStateList colorStateList) {
        this.f14315C = colorStateList;
        invalidate();
    }

    public void setTrackResource(int i5) {
        setTrackDrawable(getContext().getResources().getDrawable(i5));
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setCheckedWithHapticFeedback(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable)) {
            return true;
        }
        l lVar = this.f14327b;
        return (lVar != null && drawable == lVar.a()) || drawable == this.f14326a;
    }

    public Switch(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f14328c = false;
        this.f14338m = VelocityTracker.obtain();
        this.f14319G = new Rect();
        this.f14320H = false;
        this.f14324L = 0.81f;
        this.f14325M = 0.69f;
        N1.a.e(this, 2);
        this.f14322J = attributeSet;
        this.f14348w = new TextPaint(1);
        Resources resources = getResources();
        this.f14348w.density = resources.getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.J6, i5, H1.l.f2384p);
        this.f14320H = typedArrayObtainStyledAttributes.getBoolean(H1.m.K6, false);
        this.f14326a = typedArrayObtainStyledAttributes.getDrawable(H1.m.P6);
        this.f14327b = f(getResources().getDimensionPixelOffset(H1.f.f2136c0), getResources().getDimensionPixelOffset(H1.f.f2138d0));
        o();
        Drawable drawable = this.f14326a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f14329d = typedArrayObtainStyledAttributes.getDimensionPixelSize(H1.m.L6, 0);
        this.f14330e = typedArrayObtainStyledAttributes.getDimensionPixelSize(H1.m.M6, 48);
        this.f14331f = false;
        this.f14350y = typedArrayObtainStyledAttributes.getColorStateList(H1.m.O6);
        this.f14351z = typedArrayObtainStyledAttributes.getColorStateList(H1.m.N6);
        typedArrayObtainStyledAttributes.recycle();
        int[] iArr = {R.attr.textOn, R.attr.textOff};
        f14310Q = iArr;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, R.attr.switchStyle, 0);
        this.f14332g = typedArrayObtainStyledAttributes2.getText(0);
        this.f14333h = typedArrayObtainStyledAttributes2.getText(1);
        typedArrayObtainStyledAttributes2.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f14335j = viewConfiguration.getScaledTouchSlop();
        this.f14339n = viewConfiguration.getScaledMinimumFlingVelocity();
        f fVarD = f.d(this.f14327b);
        this.f14321I = fVarD;
        fVarD.b(this.f14351z, this.f14350y).e(getResources().getDimensionPixelOffset(H1.f.f2142f0)).f(getResources().getDimensionPixelOffset(H1.f.f2144g0)).c(getResources().getDimensionPixelOffset(H1.f.f2140e0)).a(1.0f, 1.0f);
        this.f14327b.a().setCallback(this);
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setTrackOffColor(int i5) {
        setTrackOffColor(getContext().getResources().getColorStateList(i5));
        setDarkTrackOffColor(getContext().getResources().getColorStateList(i5));
    }

    public void setTrackOnColor(int i5) {
        setTrackOnColor(getContext().getResources().getColorStateList(i5));
        setDarkTrackOnColor(getContext().getResources().getColorStateList(i5));
    }
}
