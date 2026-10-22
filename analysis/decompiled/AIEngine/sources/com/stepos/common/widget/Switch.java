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
import android.provider.Settings;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class Switch extends CompoundButton {
    public static final int[] K = {R.attr.state_checked};
    public static final a L = new a();
    public ColorStateList A;
    public ColorStateList B;
    public ColorStateList C;
    public ColorStateList D;
    public final Rect E;
    public final p F;
    public final AttributeSet G;
    public boolean H;
    public float I;
    public float J;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f7102a;

    /* renamed from: b, reason: collision with root package name */
    public final a0 f7103b;

    /* renamed from: c, reason: collision with root package name */
    public int f7104c;

    /* renamed from: d, reason: collision with root package name */
    public int f7105d;

    /* renamed from: e, reason: collision with root package name */
    public final CharSequence f7106e;
    public final CharSequence h;

    /* renamed from: j, reason: collision with root package name */
    public int f7107j;

    /* renamed from: k, reason: collision with root package name */
    public final int f7108k;

    /* renamed from: l, reason: collision with root package name */
    public float f7109l;

    /* renamed from: m, reason: collision with root package name */
    public float f7110m;

    /* renamed from: n, reason: collision with root package name */
    public final VelocityTracker f7111n;

    /* renamed from: o, reason: collision with root package name */
    public final int f7112o;

    /* renamed from: p, reason: collision with root package name */
    public float f7113p;

    /* renamed from: q, reason: collision with root package name */
    public int f7114q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f7115s;

    /* renamed from: t, reason: collision with root package name */
    public int f7116t;

    /* renamed from: u, reason: collision with root package name */
    public int f7117u;

    /* renamed from: v, reason: collision with root package name */
    public int f7118v;

    /* renamed from: w, reason: collision with root package name */
    public int f7119w;

    /* renamed from: x, reason: collision with root package name */
    public h1.f f7120x;

    /* renamed from: y, reason: collision with root package name */
    public ColorStateList f7121y;
    public ColorStateList z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends androidx.datastore.preferences.protobuf.f {
        @Override // androidx.datastore.preferences.protobuf.f
        public final float f(Object obj) {
            return ((Switch) obj).f7113p;
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void i(Object obj, float f8) {
            ((Switch) obj).setThumbPosition(f8);
        }
    }

    public Switch(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, com.stepos.aiengine.R.attr.StepOSCommon_Switch);
        this.f7111n = VelocityTracker.obtain();
        this.E = new Rect();
        this.I = 0.81f;
        this.J = 0.69f;
        setForceDarkAllowed(false);
        this.G = attributeSet;
        new TextPaint(1).density = getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9095w, com.stepos.aiengine.R.attr.StepOSCommon_Switch, com.stepos.aiengine.R.style.Widget_StepOSCommon_Switch);
        typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.f7102a = typedArrayObtainStyledAttributes.getDrawable(7);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.stepos.aiengine.R.dimen.stepos_switch_thumb_padding_left);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.stepos.aiengine.R.dimen.stepos_switch_thumb_padding_right);
        GradientDrawable gradientDrawable = new GradientDrawable();
        a0 a0Var = new a0();
        a0Var.f7143a = gradientDrawable;
        gradientDrawable.setShape(0);
        a0Var.f7146d = dimensionPixelOffset;
        a0Var.f7147e = dimensionPixelOffset2;
        this.f7103b = a0Var;
        c();
        Drawable drawable = this.f7102a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f7104c = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f7105d = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 48);
        this.f7121y = typedArrayObtainStyledAttributes.getColorStateList(6);
        this.z = typedArrayObtainStyledAttributes.getColorStateList(5);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.textOn, R.attr.textOff}, R.attr.switchStyle, 0);
        this.f7106e = typedArrayObtainStyledAttributes2.getText(0);
        this.h = typedArrayObtainStyledAttributes2.getText(1);
        typedArrayObtainStyledAttributes2.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7108k = viewConfiguration.getScaledTouchSlop();
        this.f7112o = viewConfiguration.getScaledMinimumFlingVelocity();
        p pVar = new p();
        this.F = pVar;
        ColorStateList colorStateList = this.z;
        ColorStateList colorStateList2 = this.f7121y;
        pVar.f7171d = colorStateList;
        pVar.f7172e = colorStateList2;
        pVar.f7169b = getResources().getDimensionPixelOffset(com.stepos.aiengine.R.dimen.stepos_switch_thumb_to_height);
        pVar.f7170c = getResources().getDimensionPixelOffset(com.stepos.aiengine.R.dimen.stepos_switch_thumb_to_width);
        pVar.f7168a = getResources().getDimensionPixelOffset(com.stepos.aiengine.R.dimen.stepos_switch_thumb_to_corner_radius);
        pVar.f7173f = 1.0f;
        pVar.f7174g = 1.0f;
        gradientDrawable.setCallback(this);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private boolean getTargetCheckedState() {
        return this.f7113p > 0.5f;
    }

    private int getThumbOffset() {
        return (int) ((getThumbValue() * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f7102a;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.E;
        drawable.getPadding(rect);
        a0 a0Var = this.f7103b;
        GradientDrawable gradientDrawable = a0Var.f7143a;
        int i10 = a0Var.f7146d;
        int i11 = a0Var.f7147e;
        o oVar = (i10 == 0 && i11 == 0) ? o.f7165c : new o(i10, i11);
        return ((((this.f7114q - this.f7115s) - rect.left) - rect.right) - oVar.f7166a) - oVar.f7167b;
    }

    private float getThumbValue() {
        return this.f7113p;
    }

    private void setCheckOffDamping(float f8) {
        this.J = f8;
    }

    private void setCheckOnDamping(float f8) {
        this.I = f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbPosition(float f8) {
        this.f7113p = f8;
        float fMax = f8 < 0.0f ? Math.max(f8, 0.0f) : Math.min(f8, 1.0f);
        p pVar = this.F;
        if (pVar != null) {
            int i10 = pVar.f7170c;
            a0 a0Var = this.f7103b;
            a0Var.f7145c = i10;
            GradientDrawable gradientDrawable = a0Var.f7143a;
            gradientDrawable.setSize(i10, a0Var.f7144b);
            int i11 = pVar.f7169b;
            a0Var.f7144b = i11;
            gradientDrawable.setSize(a0Var.f7145c, i11);
            gradientDrawable.setCornerRadius(pVar.f7168a);
            int iIntValue = l4.b.a(fMax, Integer.valueOf(b(pVar.f7171d)), Integer.valueOf(b(pVar.f7172e))).intValue();
            int i12 = isEnabled() ? (int) (pVar.f7173f * 255.0f) : (int) (pVar.f7174g * 255.0f);
            if (a0Var.f7148f != i12) {
                a0Var.f7148f = i12;
                gradientDrawable.setAlpha(i12);
            }
            gradientDrawable.setColor(iIntValue);
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            gradientDrawable.setColorFilter(iIntValue, mode);
            int iIntValue2 = l4.b.a(fMax, Integer.valueOf(b(this.B)), Integer.valueOf(b(this.A))).intValue();
            if (this.H && isChecked()) {
                float[] fArr = new float[3];
                if (Color.alpha(iIntValue2) != 0) {
                    Color.colorToHSV(iIntValue2, fArr);
                    if (fArr[1] > 0.2f && fArr[2] > 0.2f) {
                        this.f7102a.setColorFilter(iIntValue2, mode);
                    }
                }
            } else {
                this.f7102a.setColorFilter(iIntValue2, mode);
            }
        }
        invalidate();
    }

    public final int b(ColorStateList colorStateList) {
        return isEnabled() ? colorStateList.getColorForState(new int[]{R.attr.state_enabled}, 0) : colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    public final void c() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(this.G, g8.a.f9095w, com.stepos.aiengine.R.attr.StepOSCommon_Switch, com.stepos.aiengine.R.style.Widget_StepOSCommon_Switch);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
        this.f7102a = drawable;
        if (drawable == null) {
            this.f7102a = getResources().getDrawable(com.stepos.aiengine.R.drawable.mc_switch_anim_track);
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList != null) {
            this.A = colorStateList;
        } else {
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(12);
            this.A = colorStateList2;
            if (colorStateList2 == null) {
                this.A = getResources().getColorStateList(com.stepos.aiengine.R.color.stepos_btn_color_state);
            }
        }
        ColorStateList colorStateList3 = this.D;
        if (colorStateList3 != null) {
            this.B = colorStateList3;
        } else {
            ColorStateList colorStateList4 = typedArrayObtainStyledAttributes.getColorStateList(11);
            this.B = colorStateList4;
            if (colorStateList4 == null) {
                this.B = getResources().getColorStateList(com.stepos.aiengine.R.color.stepos_switch_track_off_color);
            }
        }
        Drawable drawable2 = this.f7102a;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        p pVar = this.F;
        if (pVar != null) {
            ColorStateList colorStateList5 = this.z;
            ColorStateList colorStateList6 = this.f7121y;
            pVar.f7171d = colorStateList5;
            pVar.f7172e = colorStateList6;
            setThumbPosition(this.f7113p);
        }
        typedArrayObtainStyledAttributes.recycle();
        refreshDrawableState();
    }

    public final void d(boolean z, boolean z3) {
        if (isChecked() == z) {
            h1.f fVar = this.f7120x;
            if (fVar == null || !fVar.f9232f) {
                setThumbPosition(z ? 1.0f : 0.0f);
                return;
            }
            return;
        }
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (!z3 || !isAttachedToWindow() || !isLaidOut()) {
            h1.f fVar2 = this.f7120x;
            if (fVar2 != null && fVar2.f9232f) {
                fVar2.f();
            }
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
            return;
        }
        float f8 = zIsChecked ? 1.0f : 0.0f;
        h1.f fVar3 = this.f7120x;
        if (fVar3 != null && fVar3.f9232f) {
            fVar3.f();
        }
        if (this.f7120x == null) {
            this.f7120x = new h1.f(this, L);
        }
        h1.g gVar = new h1.g();
        float f9 = zIsChecked ? this.I : this.J;
        gVar.b(570.0f);
        gVar.a(f9);
        gVar.f9251i = f8;
        h1.f fVar4 = this.f7120x;
        fVar4.f9234i = 0.00390625f;
        fVar4.f9241t = gVar;
        fVar4.h();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i10;
        int thumbOffset;
        int i11;
        int i12;
        int i13 = this.f7116t;
        int i14 = this.f7117u;
        int i15 = this.f7118v;
        int i16 = this.f7119w;
        int thumbOffset2 = getThumbOffset() + i13;
        Drawable drawable = this.f7102a;
        Rect rect = this.E;
        if (drawable != null) {
            drawable.getPadding(rect);
            thumbOffset2 += rect.left;
            this.f7102a.setBounds(i13, i14, i15, i16);
        }
        a0 a0Var = this.f7103b;
        if (a0Var != null) {
            GradientDrawable gradientDrawable = a0Var.f7143a;
            gradientDrawable.getPadding(rect);
            if (isLayoutRtl()) {
                thumbOffset = (i15 - getThumbOffset()) - a0Var.f7146d;
                i10 = thumbOffset - a0Var.f7145c;
                int i17 = this.r;
                i11 = a0Var.f7144b;
                i12 = (i17 - i11) / 2;
            } else {
                i10 = thumbOffset2 + a0Var.f7146d;
                thumbOffset = a0Var.f7145c + i10;
                int i18 = this.r;
                i11 = a0Var.f7144b;
                i12 = (i18 - i11) / 2;
            }
            int i19 = i12 + i14;
            gradientDrawable.setBounds(i10, i19, thumbOffset, i11 + i19);
        }
        ColorStateList colorStateList = this.D;
        if (colorStateList != null) {
            this.B = colorStateList;
        }
        ColorStateList colorStateList2 = this.C;
        if (colorStateList2 != null) {
            this.A = colorStateList2;
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        a0 a0Var = this.f7103b;
        if (a0Var != null) {
            a0Var.f7143a.setState(drawableState);
        }
        Drawable drawable = this.f7102a;
        if (drawable != null) {
            drawable.setState(drawableState);
        }
        setThumbPosition(this.f7113p);
        invalidate();
    }

    public final void e(boolean z, boolean z3) {
        if (isChecked() != z) {
            if (!l8.a.c(getContext())) {
                Log.d("CommonUtils", "haptic feedback disabled by settings");
            } else if (l8.a.b()) {
                performHapticFeedback(31022);
            } else {
                l8.a.d(this);
            }
        }
        d(z, z3);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!isLayoutRtl()) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f7114q;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f7105d : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (isLayoutRtl()) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f7114q;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f7105d : compoundPaddingRight;
    }

    public int getSwitchMinWidth() {
        return this.f7104c;
    }

    public int getSwitchPadding() {
        return this.f7105d;
    }

    public Drawable getTrackDrawable() {
        return this.f7102a;
    }

    @Override // android.view.View
    public final boolean isLaidOut() {
        return getWidth() > 0 && getHeight() > 0;
    }

    public final boolean isLayoutRtl() {
        return getLayoutDirection() == 1;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        a0 a0Var = this.f7103b;
        if (a0Var != null) {
            a0Var.f7143a.jumpToCurrentState();
        }
        Drawable drawable = this.f7102a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        h1.f fVar = this.f7120x;
        if (fVar == null || !fVar.f9232f || fVar.f9241t.f9245b <= 0.0d) {
            return;
        }
        fVar.g();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
        this.f7103b.f7143a.setCallback(this);
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(iArrOnCreateDrawableState, K);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.f7102a;
        Rect rect = this.E;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        GradientDrawable gradientDrawable = this.f7103b.f7143a;
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
        CharSequence charSequence = isChecked() ? this.f7106e : this.h;
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
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z, i10, i11, i12, i13);
        int iMax2 = 0;
        if (this.f7103b != null) {
            Drawable drawable = this.f7102a;
            Rect rect = this.E;
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
        if (isLayoutRtl()) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f7114q + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f7114q) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i14 = this.r;
            int i15 = height2 - (i14 / 2);
            height = i14 + i15;
            paddingTop = i15;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.r + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.r;
        }
        this.f7116t = paddingLeft;
        this.f7117u = paddingTop;
        this.f7119w = height;
        this.f7118v = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i10, int i11) {
        int intrinsicHeight;
        int iMax;
        int intrinsicHeight2;
        Rect rect = this.E;
        a0 a0Var = this.f7103b;
        if (a0Var != null) {
            GradientDrawable gradientDrawable = a0Var.f7143a;
            gradientDrawable.getPadding(rect);
            iMax = Math.max((gradientDrawable.getIntrinsicWidth() - rect.left) - rect.right, this.F.f7170c);
            intrinsicHeight = gradientDrawable.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            iMax = 0;
        }
        this.f7115s = iMax;
        Drawable drawable = this.f7102a;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicHeight2 = this.f7102a.getIntrinsicHeight();
        } else {
            rect.setEmpty();
            intrinsicHeight2 = 0;
        }
        int iMax2 = rect.left;
        int iMax3 = rect.right;
        o oVar = o.f7165c;
        if (a0Var != null) {
            iMax2 = Math.max(iMax2, 0);
            iMax3 = Math.max(iMax3, 0);
            int i12 = a0Var.f7146d;
            int i13 = a0Var.f7147e;
            if (i12 != 0 || i13 != 0) {
                oVar = new o(i12, i13);
            }
        }
        int iMax4 = Math.max(this.f7104c, (this.f7115s * 2) + iMax2 + iMax3 + oVar.f7166a + oVar.f7167b);
        int iMax5 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f7114q = iMax4;
        this.r = iMax5;
        super.onMeasure(i10, i11);
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
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.H = Settings.Global.getInt(getContext().getContentResolver(), "stepos_high_contrast_mode", 0) != 0;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        d(z, true);
    }

    public void setCheckedWithHapticFeedback(boolean z) {
        e(z, true);
    }

    public void setDarkTrackOffColor(ColorStateList colorStateList) {
        invalidate();
    }

    public void setDarkTrackOnColor(ColorStateList colorStateList) {
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public void setSwitchMinWidth(int i10) {
        this.f7104c = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.f7105d = i10;
        requestLayout();
    }

    public void setThumbOffColor(ColorStateList colorStateList) {
        this.z = colorStateList;
        p pVar = this.F;
        if (pVar != null) {
            ColorStateList colorStateList2 = this.f7121y;
            pVar.f7171d = colorStateList;
            pVar.f7172e = colorStateList2;
            setThumbPosition(this.f7113p);
        }
        invalidate();
    }

    public void setThumbOnColor(ColorStateList colorStateList) {
        this.f7121y = colorStateList;
        p pVar = this.F;
        if (pVar != null) {
            pVar.f7171d = this.z;
            pVar.f7172e = colorStateList;
            setThumbPosition(this.f7113p);
        }
        invalidate();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f7102a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f7102a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawableStateChanged();
        }
        requestLayout();
    }

    public void setTrackOffColor(ColorStateList colorStateList) {
        this.D = colorStateList;
        invalidate();
    }

    public void setTrackOnColor(ColorStateList colorStateList) {
        this.C = colorStateList;
        invalidate();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(getContext().getResources().getDrawable(i10));
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
        a0 a0Var = this.f7103b;
        return (a0Var != null && drawable == a0Var.f7143a) || drawable == this.f7102a;
    }

    public void setTrackOffColor(int i10) {
        setTrackOffColor(getContext().getResources().getColorStateList(i10));
        setDarkTrackOffColor(getContext().getResources().getColorStateList(i10));
    }

    public void setTrackOnColor(int i10) {
        setTrackOnColor(getContext().getResources().getColorStateList(i10));
        setDarkTrackOnColor(getContext().getResources().getColorStateList(i10));
    }
}
