package com.stepos.common.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class Switch extends CompoundButton {
    public static final int[] L = {R.attr.state_checked};
    public static final n M = new n();
    public ColorStateList A;
    public ColorStateList B;
    public ColorStateList C;
    public ColorStateList D;
    public ColorStateList E;
    public final Rect F;
    public final h G;
    public final AttributeSet H;
    public boolean I;
    public float J;
    public float K;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f2639c;

    /* renamed from: f, reason: collision with root package name */
    public final m f2640f;

    /* renamed from: g, reason: collision with root package name */
    public int f2641g;

    /* renamed from: h, reason: collision with root package name */
    public int f2642h;
    public final CharSequence i;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f2643j;

    /* renamed from: k, reason: collision with root package name */
    public int f2644k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2645l;

    /* renamed from: m, reason: collision with root package name */
    public float f2646m;

    /* renamed from: n, reason: collision with root package name */
    public float f2647n;

    /* renamed from: o, reason: collision with root package name */
    public final VelocityTracker f2648o;

    /* renamed from: p, reason: collision with root package name */
    public final int f2649p;

    /* renamed from: q, reason: collision with root package name */
    public float f2650q;

    /* renamed from: r, reason: collision with root package name */
    public int f2651r;

    /* renamed from: s, reason: collision with root package name */
    public int f2652s;

    /* renamed from: t, reason: collision with root package name */
    public int f2653t;

    /* renamed from: u, reason: collision with root package name */
    public int f2654u;

    /* renamed from: v, reason: collision with root package name */
    public int f2655v;

    /* renamed from: w, reason: collision with root package name */
    public int f2656w;

    /* renamed from: x, reason: collision with root package name */
    public int f2657x;

    /* renamed from: y, reason: collision with root package name */
    public z3.g f2658y;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f2659z;

    public Switch(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.f2648o = VelocityTracker.obtain();
        this.F = new Rect();
        this.J = 0.81f;
        this.K = 0.69f;
        setForceDarkAllowed(false);
        this.H = attributeSet;
        new TextPaint(1).density = getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q9.a.f10208l, i, com.stepos.agentsafetycenter.R.style.Widget_StepOSCommon_Switch);
        typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.f2639c = typedArrayObtainStyledAttributes.getDrawable(7);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.stepos.agentsafetycenter.R.dimen.stepos_switch_thumb_padding_left);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.stepos.agentsafetycenter.R.dimen.stepos_switch_thumb_padding_right);
        GradientDrawable gradientDrawable = new GradientDrawable();
        m mVar = new m();
        mVar.f2726a = gradientDrawable;
        gradientDrawable.setShape(0);
        mVar.f2729d = dimensionPixelOffset;
        mVar.f2730e = dimensionPixelOffset2;
        this.f2640f = mVar;
        d();
        Drawable drawable = this.f2639c;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f2641g = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f2642h = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 48);
        this.f2659z = typedArrayObtainStyledAttributes.getColorStateList(6);
        this.A = typedArrayObtainStyledAttributes.getColorStateList(5);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.textOn, R.attr.textOff}, R.attr.switchStyle, 0);
        this.i = typedArrayObtainStyledAttributes2.getText(0);
        this.f2643j = typedArrayObtainStyledAttributes2.getText(1);
        typedArrayObtainStyledAttributes2.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2645l = viewConfiguration.getScaledTouchSlop();
        this.f2649p = viewConfiguration.getScaledMinimumFlingVelocity();
        h hVar = new h();
        this.G = hVar;
        ColorStateList colorStateList = this.A;
        ColorStateList colorStateList2 = this.f2659z;
        hVar.f2695d = colorStateList;
        hVar.f2696e = colorStateList2;
        hVar.f2693b = getResources().getDimensionPixelOffset(com.stepos.agentsafetycenter.R.dimen.stepos_switch_thumb_to_height);
        hVar.f2694c = getResources().getDimensionPixelOffset(com.stepos.agentsafetycenter.R.dimen.stepos_switch_thumb_to_width);
        hVar.f2692a = getResources().getDimensionPixelOffset(com.stepos.agentsafetycenter.R.dimen.stepos_switch_thumb_to_corner_radius);
        hVar.f2697f = 1.0f;
        hVar.f2698g = 1.0f;
        gradientDrawable.setCallback(this);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private boolean getTargetCheckedState() {
        return this.f2650q > 0.5f;
    }

    private int getThumbOffset() {
        return (int) ((getThumbValue() * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f2639c;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.F;
        drawable.getPadding(rect);
        m mVar = this.f2640f;
        GradientDrawable gradientDrawable = mVar.f2726a;
        int i = mVar.f2729d;
        int i3 = mVar.f2730e;
        g gVar = (i == 0 && i3 == 0) ? g.f2689c : new g(i, i3);
        return ((((this.f2651r - this.f2653t) - rect.left) - rect.right) - gVar.f2690a) - gVar.f2691b;
    }

    private float getThumbValue() {
        return this.f2650q;
    }

    private void setCheckOffDamping(float f5) {
        this.K = f5;
    }

    private void setCheckOnDamping(float f5) {
        this.J = f5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbPosition(float f5) {
        this.f2650q = f5;
        float fMax = f5 < 0.0f ? Math.max(f5, 0.0f) : Math.min(f5, 1.0f);
        h hVar = this.G;
        if (hVar != null) {
            int i = hVar.f2694c;
            m mVar = this.f2640f;
            mVar.f2728c = i;
            GradientDrawable gradientDrawable = mVar.f2726a;
            gradientDrawable.setSize(i, mVar.f2727b);
            int i3 = hVar.f2693b;
            mVar.f2727b = i3;
            gradientDrawable.setSize(mVar.f2728c, i3);
            gradientDrawable.setCornerRadius(hVar.f2692a);
            int iIntValue = q6.b.a(fMax, Integer.valueOf(b(hVar.f2695d)), Integer.valueOf(b(hVar.f2696e))).intValue();
            int i10 = isEnabled() ? (int) (hVar.f2697f * 255.0f) : (int) (hVar.f2698g * 255.0f);
            if (mVar.f2731f != i10) {
                mVar.f2731f = i10;
                gradientDrawable.setAlpha(i10);
            }
            gradientDrawable.setColor(iIntValue);
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            gradientDrawable.setColorFilter(iIntValue, mode);
            int iIntValue2 = q6.b.a(fMax, Integer.valueOf(b(this.C)), Integer.valueOf(b(this.B))).intValue();
            if (this.I && isChecked()) {
                float[] fArr = new float[3];
                if (Color.alpha(iIntValue2) != 0) {
                    Color.colorToHSV(iIntValue2, fArr);
                    if (fArr[1] > 0.2f && fArr[2] > 0.2f) {
                        this.f2639c.setColorFilter(iIntValue2, mode);
                    }
                }
            } else {
                this.f2639c.setColorFilter(iIntValue2, mode);
            }
        }
        invalidate();
    }

    public final int b(ColorStateList colorStateList) {
        return isEnabled() ? colorStateList.getColorForState(new int[]{R.attr.state_enabled}, 0) : colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    public final boolean c() {
        return getLayoutDirection() == 1;
    }

    public final void d() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(this.H, q9.a.f10208l, com.stepos.agentsafetycenter.R.attr.StepOSCommon_Switch, com.stepos.agentsafetycenter.R.style.Widget_StepOSCommon_Switch);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
        this.f2639c = drawable;
        if (drawable == null) {
            this.f2639c = getResources().getDrawable(com.stepos.agentsafetycenter.R.drawable.mc_switch_anim_track);
        }
        ColorStateList colorStateList = this.D;
        if (colorStateList != null) {
            this.B = colorStateList;
        } else {
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(12);
            this.B = colorStateList2;
            if (colorStateList2 == null) {
                this.B = getResources().getColorStateList(com.stepos.agentsafetycenter.R.color.stepos_btn_color_state);
            }
        }
        ColorStateList colorStateList3 = this.E;
        if (colorStateList3 != null) {
            this.C = colorStateList3;
        } else {
            ColorStateList colorStateList4 = typedArrayObtainStyledAttributes.getColorStateList(11);
            this.C = colorStateList4;
            if (colorStateList4 == null) {
                this.C = getResources().getColorStateList(com.stepos.agentsafetycenter.R.color.stepos_switch_track_off_color);
            }
        }
        Drawable drawable2 = this.f2639c;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        h hVar = this.G;
        if (hVar != null) {
            ColorStateList colorStateList5 = this.A;
            ColorStateList colorStateList6 = this.f2659z;
            hVar.f2695d = colorStateList5;
            hVar.f2696e = colorStateList6;
            setThumbPosition(this.f2650q);
        }
        typedArrayObtainStyledAttributes.recycle();
        refreshDrawableState();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        int thumbOffset;
        int i3;
        int i10;
        int i11 = this.f2654u;
        int i12 = this.f2655v;
        int i13 = this.f2656w;
        int i14 = this.f2657x;
        int thumbOffset2 = getThumbOffset() + i11;
        Drawable drawable = this.f2639c;
        Rect rect = this.F;
        if (drawable != null) {
            drawable.getPadding(rect);
            thumbOffset2 += rect.left;
            this.f2639c.setBounds(i11, i12, i13, i14);
        }
        m mVar = this.f2640f;
        if (mVar != null) {
            GradientDrawable gradientDrawable = mVar.f2726a;
            gradientDrawable.getPadding(rect);
            if (c()) {
                thumbOffset = (i13 - getThumbOffset()) - mVar.f2729d;
                i = thumbOffset - mVar.f2728c;
                int i15 = this.f2652s;
                i3 = mVar.f2727b;
                i10 = (i15 - i3) / 2;
            } else {
                i = thumbOffset2 + mVar.f2729d;
                thumbOffset = mVar.f2728c + i;
                int i16 = this.f2652s;
                i3 = mVar.f2727b;
                i10 = (i16 - i3) / 2;
            }
            int i17 = i10 + i12;
            gradientDrawable.setBounds(i, i17, thumbOffset, i3 + i17);
        }
        ColorStateList colorStateList = this.E;
        if (colorStateList != null) {
            this.C = colorStateList;
        }
        ColorStateList colorStateList2 = this.D;
        if (colorStateList2 != null) {
            this.B = colorStateList2;
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        m mVar = this.f2640f;
        if (mVar != null) {
            mVar.f2726a.setState(drawableState);
        }
        Drawable drawable = this.f2639c;
        if (drawable != null) {
            drawable.setState(drawableState);
        }
        setThumbPosition(this.f2650q);
        invalidate();
    }

    public final void e(boolean z10, boolean z11) {
        if (isChecked() == z10) {
            z3.g gVar = this.f2658y;
            if (gVar == null || !gVar.f16365f) {
                setThumbPosition(z10 ? 1.0f : 0.0f);
                return;
            }
            return;
        }
        super.setChecked(z10);
        boolean zIsChecked = isChecked();
        if (!z11 || !isAttachedToWindow() || !isLaidOut()) {
            z3.g gVar2 = this.f2658y;
            if (gVar2 != null && gVar2.f16365f) {
                gVar2.b();
            }
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
            return;
        }
        float f5 = zIsChecked ? 1.0f : 0.0f;
        z3.g gVar3 = this.f2658y;
        if (gVar3 != null && gVar3.f16365f) {
            gVar3.b();
        }
        if (this.f2658y == null) {
            this.f2658y = new z3.g(this, M);
        }
        z3.h hVar = new z3.h();
        float f10 = zIsChecked ? this.J : this.K;
        hVar.b(570.0f);
        hVar.a(f10);
        hVar.i = f5;
        z3.g gVar4 = this.f2658y;
        gVar4.f16367h = 0.00390625f;
        gVar4.f16369k = hVar;
        gVar4.g();
    }

    public final void f(boolean z10, boolean z11) {
        if (isChecked() != z10) {
            if (u9.a.b()) {
                performHapticFeedback(31022);
            } else if (d3.a.a(getContext(), "android.permission.VIBRATE") == 0) {
                ((Vibrator) getContext().getSystemService("vibrator")).vibrate(VibrationEffect.createOneShot(45L, -1));
            } else {
                Log.d("CommonUtils", "permission not declared");
            }
        }
        e(z10, z11);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!c()) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f2651r;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f2642h : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (c()) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f2651r;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f2642h : compoundPaddingRight;
    }

    public int getSwitchMinWidth() {
        return this.f2641g;
    }

    public int getSwitchPadding() {
        return this.f2642h;
    }

    public Drawable getTrackDrawable() {
        return this.f2639c;
    }

    @Override // android.view.View
    public final boolean isLaidOut() {
        return getWidth() > 0 && getHeight() > 0;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        m mVar = this.f2640f;
        if (mVar != null) {
            mVar.f2726a.jumpToCurrentState();
        }
        Drawable drawable = this.f2639c;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        z3.g gVar = this.f2658y;
        if (gVar == null || !gVar.f16365f || gVar.f16369k.f16373b <= 0.0d) {
            return;
        }
        gVar.f();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        this.f2640f.f2726a.setCallback(this);
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, L);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.f2639c;
        Rect rect = this.F;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        GradientDrawable gradientDrawable = this.f2640f.f2726a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        int iSave = canvas.save();
        gradientDrawable.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Switch.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Switch.class.getName());
        CharSequence charSequence = isChecked() ? this.i : this.f2643j;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(text);
        sb2.append(' ');
        sb2.append(charSequence);
        accessibilityNodeInfo.setText(sb2);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z10, i, i3, i10, i11);
        int iMax2 = 0;
        if (this.f2640f != null) {
            Drawable drawable = this.f2639c;
            Rect rect = this.F;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            iMax = Math.max(0, 0 - rect.left);
            iMax2 = Math.max(0, 0 - rect.right);
        } else {
            iMax = 0;
        }
        if (c()) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f2651r + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f2651r) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i12 = this.f2652s;
            int i13 = height2 - (i12 / 2);
            height = i12 + i13;
            paddingTop = i13;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.f2652s + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.f2652s;
        }
        this.f2654u = paddingLeft;
        this.f2655v = paddingTop;
        this.f2657x = height;
        this.f2656w = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i3) {
        int intrinsicHeight;
        int iMax;
        int intrinsicHeight2;
        Rect rect = this.F;
        m mVar = this.f2640f;
        if (mVar != null) {
            GradientDrawable gradientDrawable = mVar.f2726a;
            gradientDrawable.getPadding(rect);
            iMax = Math.max((gradientDrawable.getIntrinsicWidth() - rect.left) - rect.right, this.G.f2694c);
            intrinsicHeight = gradientDrawable.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            iMax = 0;
        }
        this.f2653t = iMax;
        Drawable drawable = this.f2639c;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicHeight2 = this.f2639c.getIntrinsicHeight();
        } else {
            rect.setEmpty();
            intrinsicHeight2 = 0;
        }
        int iMax2 = rect.left;
        int iMax3 = rect.right;
        g gVar = g.f2689c;
        if (mVar != null) {
            iMax2 = Math.max(iMax2, 0);
            iMax3 = Math.max(iMax3, 0);
            int i10 = mVar.f2729d;
            int i11 = mVar.f2730e;
            if (i10 != 0 || i11 != 0) {
                gVar = new g(i10, i11);
            }
        }
        int iMax4 = Math.max(this.f2641g, (this.f2653t * 2) + iMax2 + iMax3 + gVar.f2690a + gVar.f2691b);
        int iMax5 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f2651r = iMax4;
        this.f2652s = iMax5;
        super.onMeasure(i, i3);
        if (getMeasuredHeight() < iMax5) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008c  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.Switch.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.I = Settings.Global.getInt(getContext().getContentResolver(), "flyme_high_contrast_mode", 0) != 0;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        e(z10, true);
    }

    public void setCheckedWithHapticFeedback(boolean z10) {
        f(z10, true);
    }

    public void setDarkTrackOffColor(ColorStateList colorStateList) {
        invalidate();
    }

    public void setDarkTrackOnColor(ColorStateList colorStateList) {
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
    }

    public void setSwitchMinWidth(int i) {
        this.f2641g = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f2642h = i;
        requestLayout();
    }

    public void setThumbOffColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        h hVar = this.G;
        if (hVar != null) {
            ColorStateList colorStateList2 = this.f2659z;
            hVar.f2695d = colorStateList;
            hVar.f2696e = colorStateList2;
            setThumbPosition(this.f2650q);
        }
        invalidate();
    }

    public void setThumbOnColor(ColorStateList colorStateList) {
        this.f2659z = colorStateList;
        h hVar = this.G;
        if (hVar != null) {
            hVar.f2695d = this.A;
            hVar.f2696e = colorStateList;
            setThumbPosition(this.f2650q);
        }
        invalidate();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2639c;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2639c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawableStateChanged();
        }
        requestLayout();
    }

    public void setTrackOffColor(int i) {
        setTrackOffColor(getContext().getResources().getColorStateList(i));
        setDarkTrackOffColor(getContext().getResources().getColorStateList(i));
    }

    public void setTrackOnColor(int i) {
        setTrackOnColor(getContext().getResources().getColorStateList(i));
        setDarkTrackOnColor(getContext().getResources().getColorStateList(i));
    }

    public void setTrackResource(int i) {
        setTrackDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setCheckedWithHapticFeedback(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable)) {
            return true;
        }
        m mVar = this.f2640f;
        return (mVar != null && drawable == mVar.f2726a) || drawable == this.f2639c;
    }

    public void setTrackOffColor(ColorStateList colorStateList) {
        this.E = colorStateList;
        invalidate();
    }

    public void setTrackOnColor(ColorStateList colorStateList) {
        this.D = colorStateList;
        invalidate();
    }

    public Switch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.stepos.agentsafetycenter.R.attr.StepOSCommon_Switch);
    }

    public Switch(Context context) {
        this(context, null);
    }
}
