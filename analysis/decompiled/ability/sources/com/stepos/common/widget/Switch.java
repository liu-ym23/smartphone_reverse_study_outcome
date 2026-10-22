package com.stepos.common.widget;

import a5.AbstractC0301a;
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
import androidx.core.content.ContextCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

/* loaded from: classes3.dex */
public class Switch extends CompoundButton {

    /* renamed from: L, reason: collision with root package name */
    public static final int[] f3775L = {R.attr.state_checked};

    /* renamed from: M, reason: collision with root package name */
    public static final com.google.android.material.button.a f3776M = new com.google.android.material.button.a("thumbPos", 1);

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f3777A;

    /* renamed from: B, reason: collision with root package name */
    public final Rect f3778B;

    /* renamed from: C, reason: collision with root package name */
    public final w f3779C;

    /* renamed from: D, reason: collision with root package name */
    public final AttributeSet f3780D;
    public boolean E;

    /* renamed from: F, reason: collision with root package name */
    public float f3781F;

    /* renamed from: G, reason: collision with root package name */
    public float f3782G;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f3783a;
    public final O b;
    public int c;
    public int d;
    public final CharSequence e;
    public final CharSequence f;
    public int g;
    public final int h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f3784j;
    public final VelocityTracker k;
    public final int l;
    public float m;
    public int n;
    public int o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public int f3785q;

    /* renamed from: r, reason: collision with root package name */
    public int f3786r;

    /* renamed from: s, reason: collision with root package name */
    public int f3787s;

    /* renamed from: t, reason: collision with root package name */
    public int f3788t;
    public SpringAnimation u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f3789v;

    /* renamed from: w, reason: collision with root package name */
    public ColorStateList f3790w;

    /* renamed from: x, reason: collision with root package name */
    public ColorStateList f3791x;
    public ColorStateList y;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f3792z;

    public Switch(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, com.stepos.ability.R.attr.StepOSCommon_Switch);
        this.k = VelocityTracker.obtain();
        this.f3778B = new Rect();
        this.f3781F = 0.81f;
        this.f3782G = 0.69f;
        setForceDarkAllowed(false);
        this.f3780D = attributeSet;
        new TextPaint(1).density = getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.f1378w, com.stepos.ability.R.attr.StepOSCommon_Switch, com.stepos.ability.R.style.Widget_StepOSCommon_Switch);
        typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.f3783a = typedArrayObtainStyledAttributes.getDrawable(7);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_switch_thumb_padding_left);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_switch_thumb_padding_right);
        GradientDrawable gradientDrawable = new GradientDrawable();
        O o = new O();
        o.f3728a = gradientDrawable;
        gradientDrawable.setShape(0);
        o.d = dimensionPixelOffset;
        o.e = dimensionPixelOffset2;
        this.b = o;
        d();
        Drawable drawable = this.f3783a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 48);
        this.f3789v = typedArrayObtainStyledAttributes.getColorStateList(6);
        this.f3790w = typedArrayObtainStyledAttributes.getColorStateList(5);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.textOn, R.attr.textOff}, R.attr.switchStyle, 0);
        this.e = typedArrayObtainStyledAttributes2.getText(0);
        this.f = typedArrayObtainStyledAttributes2.getText(1);
        typedArrayObtainStyledAttributes2.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.h = viewConfiguration.getScaledTouchSlop();
        this.l = viewConfiguration.getScaledMinimumFlingVelocity();
        w wVar = new w();
        this.f3779C = wVar;
        ColorStateList colorStateList = this.f3790w;
        ColorStateList colorStateList2 = this.f3789v;
        wVar.d = colorStateList;
        wVar.e = colorStateList2;
        wVar.b = getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_switch_thumb_to_height);
        wVar.c = getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_switch_thumb_to_width);
        wVar.f3815a = getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_switch_thumb_to_corner_radius);
        wVar.f = 1.0f;
        wVar.g = 1.0f;
        gradientDrawable.setCallback(this);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private boolean getTargetCheckedState() {
        return this.m > 0.5f;
    }

    private int getThumbOffset() {
        return (int) ((getThumbValue() * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f3783a;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f3778B;
        drawable.getPadding(rect);
        O o = this.b;
        GradientDrawable gradientDrawable = o.f3728a;
        int i = o.d;
        int i6 = o.e;
        v vVar = (i == 0 && i6 == 0) ? v.c : new v(i, i6);
        return ((((this.n - this.p) - rect.left) - rect.right) - vVar.f3814a) - vVar.b;
    }

    private float getThumbValue() {
        return this.m;
    }

    private void setCheckOffDamping(float f) {
        this.f3782G = f;
    }

    private void setCheckOnDamping(float f) {
        this.f3781F = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbPosition(float f) {
        this.m = f;
        float fMax = f < 0.0f ? Math.max(f, 0.0f) : Math.min(f, 1.0f);
        w wVar = this.f3779C;
        if (wVar != null) {
            int i = wVar.c;
            O o = this.b;
            o.c = i;
            o.f3728a.setSize(i, o.b);
            int i6 = wVar.b;
            o.b = i6;
            o.f3728a.setSize(o.c, i6);
            o.f3728a.setCornerRadius(wVar.f3815a);
            int iIntValue = Q2.b.a(fMax, Integer.valueOf(b(wVar.d)), Integer.valueOf(b(wVar.e))).intValue();
            int i10 = isEnabled() ? (int) (wVar.f * 255.0f) : (int) (wVar.g * 255.0f);
            if (o.f != i10) {
                o.f = i10;
                o.f3728a.setAlpha(i10);
            }
            GradientDrawable gradientDrawable = o.f3728a;
            gradientDrawable.setColor(iIntValue);
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            gradientDrawable.setColorFilter(iIntValue, mode);
            int iIntValue2 = Q2.b.a(fMax, Integer.valueOf(b(this.y)), Integer.valueOf(b(this.f3791x))).intValue();
            if (this.E && isChecked()) {
                float[] fArr = new float[3];
                if (Color.alpha(iIntValue2) != 0) {
                    Color.colorToHSV(iIntValue2, fArr);
                    if (fArr[1] > 0.2f && fArr[2] > 0.2f) {
                        this.f3783a.setColorFilter(iIntValue2, mode);
                    }
                }
            } else {
                this.f3783a.setColorFilter(iIntValue2, mode);
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
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(this.f3780D, V4.s.f1378w, com.stepos.ability.R.attr.StepOSCommon_Switch, com.stepos.ability.R.style.Widget_StepOSCommon_Switch);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
        this.f3783a = drawable;
        if (drawable == null) {
            this.f3783a = getResources().getDrawable(com.stepos.ability.R.drawable.mc_switch_anim_track);
        }
        ColorStateList colorStateList = this.f3792z;
        if (colorStateList != null) {
            this.f3791x = colorStateList;
        } else {
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(12);
            this.f3791x = colorStateList2;
            if (colorStateList2 == null) {
                this.f3791x = getResources().getColorStateList(com.stepos.ability.R.color.stepos_btn_color_state);
            }
        }
        ColorStateList colorStateList3 = this.f3777A;
        if (colorStateList3 != null) {
            this.y = colorStateList3;
        } else {
            ColorStateList colorStateList4 = typedArrayObtainStyledAttributes.getColorStateList(11);
            this.y = colorStateList4;
            if (colorStateList4 == null) {
                this.y = getResources().getColorStateList(com.stepos.ability.R.color.stepos_switch_track_off_color);
            }
        }
        Drawable drawable2 = this.f3783a;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        w wVar = this.f3779C;
        if (wVar != null) {
            ColorStateList colorStateList5 = this.f3790w;
            ColorStateList colorStateList6 = this.f3789v;
            wVar.d = colorStateList5;
            wVar.e = colorStateList6;
            setThumbPosition(this.m);
        }
        typedArrayObtainStyledAttributes.recycle();
        refreshDrawableState();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        int thumbOffset;
        int i6;
        int i10;
        int i11 = this.f3785q;
        int i12 = this.f3786r;
        int i13 = this.f3787s;
        int i14 = this.f3788t;
        int thumbOffset2 = getThumbOffset() + i11;
        Drawable drawable = this.f3783a;
        Rect rect = this.f3778B;
        if (drawable != null) {
            drawable.getPadding(rect);
            thumbOffset2 += rect.left;
            this.f3783a.setBounds(i11, i12, i13, i14);
        }
        O o = this.b;
        if (o != null) {
            o.f3728a.getPadding(rect);
            if (c()) {
                thumbOffset = (i13 - getThumbOffset()) - o.d;
                i = thumbOffset - o.c;
                int i15 = this.o;
                i6 = o.b;
                i10 = (i15 - i6) / 2;
            } else {
                i = thumbOffset2 + o.d;
                thumbOffset = o.c + i;
                int i16 = this.o;
                i6 = o.b;
                i10 = (i16 - i6) / 2;
            }
            int i17 = i10 + i12;
            o.f3728a.setBounds(i, i17, thumbOffset, i6 + i17);
        }
        ColorStateList colorStateList = this.f3777A;
        if (colorStateList != null) {
            this.y = colorStateList;
        }
        ColorStateList colorStateList2 = this.f3792z;
        if (colorStateList2 != null) {
            this.f3791x = colorStateList2;
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        GradientDrawable gradientDrawable;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        O o = this.b;
        if (o != null && (gradientDrawable = o.f3728a) != null) {
            gradientDrawable.setState(drawableState);
        }
        Drawable drawable = this.f3783a;
        if (drawable != null) {
            drawable.setState(drawableState);
        }
        setThumbPosition(this.m);
        invalidate();
    }

    public final void e(boolean z10, boolean z11) {
        if (isChecked() == z10) {
            SpringAnimation springAnimation = this.u;
            if (springAnimation == null || !springAnimation.isRunning()) {
                setThumbPosition(z10 ? 1.0f : 0.0f);
                return;
            }
            return;
        }
        super.setChecked(z10);
        boolean zIsChecked = isChecked();
        if (!z11 || !isAttachedToWindow() || !isLaidOut()) {
            SpringAnimation springAnimation2 = this.u;
            if (springAnimation2 != null && springAnimation2.isRunning()) {
                this.u.cancel();
            }
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
            return;
        }
        float f = zIsChecked ? 1.0f : 0.0f;
        SpringAnimation springAnimation3 = this.u;
        if (springAnimation3 != null && springAnimation3.isRunning()) {
            this.u.cancel();
        }
        if (this.u == null) {
            this.u = new SpringAnimation(this, f3776M);
        }
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(570.0f).setDampingRatio(zIsChecked ? this.f3781F : this.f3782G).setFinalPosition(f);
        this.u.setMinimumVisibleChange(0.00390625f);
        this.u.setSpring(springForce);
        this.u.start();
    }

    public final void f(boolean z10, boolean z11) {
        if (isChecked() != z10) {
            if (AbstractC0301a.b()) {
                performHapticFeedback(31022);
            } else if (ContextCompat.checkSelfPermission(getContext(), "android.permission.VIBRATE") == 0) {
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
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.n;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.d : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (c()) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.n;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.d : compoundPaddingRight;
    }

    public int getSwitchMinWidth() {
        return this.c;
    }

    public int getSwitchPadding() {
        return this.d;
    }

    public Drawable getTrackDrawable() {
        return this.f3783a;
    }

    @Override // android.view.View
    public final boolean isLaidOut() {
        return getWidth() > 0 && getHeight() > 0;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        GradientDrawable gradientDrawable;
        super.jumpDrawablesToCurrentState();
        O o = this.b;
        if (o != null && (gradientDrawable = o.f3728a) != null) {
            gradientDrawable.jumpToCurrentState();
        }
        Drawable drawable = this.f3783a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        SpringAnimation springAnimation = this.u;
        if (springAnimation != null && springAnimation.isRunning() && this.u.canSkipToEnd()) {
            this.u.skipToEnd();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        this.b.f3728a.setCallback(this);
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f3775L);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.f3783a;
        Rect rect = this.f3778B;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        GradientDrawable gradientDrawable = this.b.f3728a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        int iSave = canvas.save();
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
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
        CharSequence charSequence = isChecked() ? this.e : this.f;
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
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z10, i, i6, i10, i11);
        int iMax2 = 0;
        if (this.b != null) {
            Drawable drawable = this.f3783a;
            Rect rect = this.f3778B;
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
            width = ((this.n + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.n) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i12 = this.o;
            int i13 = height2 - (i12 / 2);
            height = i12 + i13;
            paddingTop = i13;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.o + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.o;
        }
        this.f3785q = paddingLeft;
        this.f3786r = paddingTop;
        this.f3788t = height;
        this.f3787s = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i6) {
        int iMax;
        int intrinsicHeight;
        int intrinsicHeight2;
        Rect rect = this.f3778B;
        O o = this.b;
        if (o != null) {
            o.f3728a.getPadding(rect);
            iMax = Math.max((o.f3728a.getIntrinsicWidth() - rect.left) - rect.right, this.f3779C.c);
            intrinsicHeight = o.f3728a.getIntrinsicHeight();
        } else {
            iMax = 0;
            intrinsicHeight = 0;
        }
        this.p = iMax;
        Drawable drawable = this.f3783a;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicHeight2 = this.f3783a.getIntrinsicHeight();
        } else {
            rect.setEmpty();
            intrinsicHeight2 = 0;
        }
        int iMax2 = rect.left;
        int iMax3 = rect.right;
        v vVar = v.c;
        if (o != null) {
            iMax2 = Math.max(iMax2, 0);
            iMax3 = Math.max(iMax3, 0);
            int i10 = o.d;
            int i11 = o.e;
            if (i10 != 0 || i11 != 0) {
                vVar = new v(i10, i11);
            }
        }
        int iMax4 = Math.max(this.c, (this.p * 2) + iMax2 + iMax3 + vVar.f3814a + vVar.b);
        int iMax5 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.n = iMax4;
        this.o = iMax5;
        super.onMeasure(i, i6);
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
            this.E = Settings.Global.getInt(getContext().getContentResolver(), "flyme_high_contrast_mode", 0) != 0;
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
        this.c = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.d = i;
        requestLayout();
    }

    public void setThumbOffColor(ColorStateList colorStateList) {
        this.f3790w = colorStateList;
        w wVar = this.f3779C;
        if (wVar != null) {
            ColorStateList colorStateList2 = this.f3789v;
            wVar.d = colorStateList;
            wVar.e = colorStateList2;
            setThumbPosition(this.m);
        }
        invalidate();
    }

    public void setThumbOnColor(ColorStateList colorStateList) {
        this.f3789v = colorStateList;
        w wVar = this.f3779C;
        if (wVar != null) {
            wVar.d = this.f3790w;
            wVar.e = colorStateList;
            setThumbPosition(this.m);
        }
        invalidate();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f3783a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f3783a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawableStateChanged();
        }
        requestLayout();
    }

    public void setTrackOffColor(ColorStateList colorStateList) {
        this.f3777A = colorStateList;
        invalidate();
    }

    public void setTrackOnColor(ColorStateList colorStateList) {
        this.f3792z = colorStateList;
        invalidate();
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
        O o = this.b;
        return (o != null && drawable == o.f3728a) || drawable == this.f3783a;
    }

    public void setTrackOffColor(int i) {
        setTrackOffColor(getContext().getResources().getColorStateList(i));
        setDarkTrackOffColor(getContext().getResources().getColorStateList(i));
    }

    public void setTrackOnColor(int i) {
        setTrackOnColor(getContext().getResources().getColorStateList(i));
        setDarkTrackOnColor(getContext().getResources().getColorStateList(i));
    }
}
