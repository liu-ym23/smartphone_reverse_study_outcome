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
import com.stepos.alphame.utils.Property;
import i2.AbstractC0620a;
import m2.AbstractC0770a;
import n1.AbstractC0776b;

/* loaded from: classes.dex */
public class Switch extends CompoundButton {

    /* renamed from: H, reason: collision with root package name */
    public static final int[] f11831H = {R.attr.state_checked};

    /* renamed from: I, reason: collision with root package name */
    public static final K0.a f11832I = new K0.a("thumbPos", 1);

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f11833A;

    /* renamed from: B, reason: collision with root package name */
    public final Rect f11834B;

    /* renamed from: C, reason: collision with root package name */
    public final q f11835C;

    /* renamed from: D, reason: collision with root package name */
    public final AttributeSet f11836D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f11837E;

    /* renamed from: F, reason: collision with root package name */
    public float f11838F;

    /* renamed from: G, reason: collision with root package name */
    public float f11839G;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f11840a;

    /* renamed from: b, reason: collision with root package name */
    public final K f11841b;

    /* renamed from: c, reason: collision with root package name */
    public int f11842c;

    /* renamed from: d, reason: collision with root package name */
    public int f11843d;

    /* renamed from: e, reason: collision with root package name */
    public final CharSequence f11844e;

    /* renamed from: f, reason: collision with root package name */
    public final CharSequence f11845f;

    /* renamed from: g, reason: collision with root package name */
    public int f11846g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11847h;

    /* renamed from: i, reason: collision with root package name */
    public float f11848i;

    /* renamed from: j, reason: collision with root package name */
    public float f11849j;

    /* renamed from: k, reason: collision with root package name */
    public final VelocityTracker f11850k;

    /* renamed from: l, reason: collision with root package name */
    public final int f11851l;

    /* renamed from: m, reason: collision with root package name */
    public float f11852m;

    /* renamed from: n, reason: collision with root package name */
    public int f11853n;

    /* renamed from: o, reason: collision with root package name */
    public int f11854o;

    /* renamed from: p, reason: collision with root package name */
    public int f11855p;

    /* renamed from: q, reason: collision with root package name */
    public int f11856q;

    /* renamed from: r, reason: collision with root package name */
    public int f11857r;

    /* renamed from: s, reason: collision with root package name */
    public int f11858s;

    /* renamed from: t, reason: collision with root package name */
    public int f11859t;

    /* renamed from: u, reason: collision with root package name */
    public W.m f11860u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f11861v;

    /* renamed from: w, reason: collision with root package name */
    public ColorStateList f11862w;

    /* renamed from: x, reason: collision with root package name */
    public ColorStateList f11863x;

    /* renamed from: y, reason: collision with root package name */
    public ColorStateList f11864y;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f11865z;

    public Switch(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, com.stepos.alphame.R.attr.StepOSCommon_Switch);
        this.f11850k = VelocityTracker.obtain();
        this.f11834B = new Rect();
        this.f11838F = 0.81f;
        this.f11839G = 0.69f;
        AbstractC0770a.c(this);
        this.f11836D = attributeSet;
        new TextPaint(1).density = getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13041w, com.stepos.alphame.R.attr.StepOSCommon_Switch, com.stepos.alphame.R.style.Widget_StepOSCommon_Switch);
        typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.f11840a = typedArrayObtainStyledAttributes.getDrawable(7);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.stepos.alphame.R.dimen.stepos_switch_thumb_padding_left);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.stepos.alphame.R.dimen.stepos_switch_thumb_padding_right);
        GradientDrawable gradientDrawable = new GradientDrawable();
        K k4 = new K();
        k4.f11663a = gradientDrawable;
        gradientDrawable.setShape(0);
        k4.f11666d = dimensionPixelOffset;
        k4.f11667e = dimensionPixelOffset2;
        this.f11841b = k4;
        d();
        Drawable drawable = this.f11840a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f11842c = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f11843d = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 48);
        this.f11861v = typedArrayObtainStyledAttributes.getColorStateList(6);
        this.f11862w = typedArrayObtainStyledAttributes.getColorStateList(5);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.textOn, R.attr.textOff}, R.attr.switchStyle, 0);
        this.f11844e = typedArrayObtainStyledAttributes2.getText(0);
        this.f11845f = typedArrayObtainStyledAttributes2.getText(1);
        typedArrayObtainStyledAttributes2.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f11847h = viewConfiguration.getScaledTouchSlop();
        this.f11851l = viewConfiguration.getScaledMinimumFlingVelocity();
        q qVar = new q();
        this.f11835C = qVar;
        ColorStateList colorStateList = this.f11862w;
        ColorStateList colorStateList2 = this.f11861v;
        qVar.f11940d = colorStateList;
        qVar.f11941e = colorStateList2;
        qVar.f11938b = getResources().getDimensionPixelOffset(com.stepos.alphame.R.dimen.stepos_switch_thumb_to_height);
        qVar.f11939c = getResources().getDimensionPixelOffset(com.stepos.alphame.R.dimen.stepos_switch_thumb_to_width);
        qVar.f11937a = getResources().getDimensionPixelOffset(com.stepos.alphame.R.dimen.stepos_switch_thumb_to_corner_radius);
        qVar.f11942f = 1.0f;
        qVar.f11943g = 1.0f;
        gradientDrawable.setCallback(this);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private boolean getTargetCheckedState() {
        return this.f11852m > 0.5f;
    }

    private int getThumbOffset() {
        return (int) ((getThumbValue() * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f11840a;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f11834B;
        drawable.getPadding(rect);
        K k4 = this.f11841b;
        GradientDrawable gradientDrawable = k4.f11663a;
        p pVar = p.f11932e;
        if (gradientDrawable != null) {
            int i4 = k4.f11666d;
            int i5 = k4.f11667e;
            if (i4 != 0 || i5 != 0) {
                pVar = new p(i4, i5);
            }
        }
        return ((((this.f11853n - this.f11855p) - rect.left) - rect.right) - pVar.f11933a) - pVar.f11935c;
    }

    private float getThumbValue() {
        return this.f11852m;
    }

    private void setCheckOffDamping(float f4) {
        this.f11839G = f4;
    }

    private void setCheckOnDamping(float f4) {
        this.f11838F = f4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbPosition(float f4) {
        this.f11852m = f4;
        float fMax = f4 < Property.DEFAULT_FLOAT_VALUE ? Math.max(f4, Property.DEFAULT_FLOAT_VALUE) : Math.min(f4, 1.0f);
        q qVar = this.f11835C;
        if (qVar != null) {
            int i4 = qVar.f11939c;
            K k4 = this.f11841b;
            k4.f11665c = i4;
            k4.f11663a.setSize(i4, k4.f11664b);
            int i5 = qVar.f11938b;
            k4.f11664b = i5;
            k4.f11663a.setSize(k4.f11665c, i5);
            k4.f11663a.setCornerRadius(qVar.f11937a);
            int iIntValue = AbstractC0776b.a(fMax, Integer.valueOf(b(qVar.f11940d)), Integer.valueOf(b(qVar.f11941e))).intValue();
            int i6 = isEnabled() ? (int) (qVar.f11942f * 255.0f) : (int) (qVar.f11943g * 255.0f);
            if (k4.f11668f != i6) {
                k4.f11668f = i6;
                k4.f11663a.setAlpha(i6);
            }
            GradientDrawable gradientDrawable = k4.f11663a;
            gradientDrawable.setColor(iIntValue);
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            gradientDrawable.setColorFilter(iIntValue, mode);
            int iIntValue2 = AbstractC0776b.a(fMax, Integer.valueOf(b(this.f11864y)), Integer.valueOf(b(this.f11863x))).intValue();
            if (this.f11837E && isChecked()) {
                float[] fArr = new float[3];
                if (Color.alpha(iIntValue2) != 0) {
                    Color.colorToHSV(iIntValue2, fArr);
                    if (fArr[1] > 0.2f && fArr[2] > 0.2f) {
                        this.f11840a.setColorFilter(iIntValue2, mode);
                    }
                }
            } else {
                this.f11840a.setColorFilter(iIntValue2, mode);
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
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(this.f11836D, AbstractC0620a.f13041w, com.stepos.alphame.R.attr.StepOSCommon_Switch, com.stepos.alphame.R.style.Widget_StepOSCommon_Switch);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
        this.f11840a = drawable;
        if (drawable == null) {
            this.f11840a = getResources().getDrawable(com.stepos.alphame.R.drawable.mc_switch_anim_track);
        }
        ColorStateList colorStateList = this.f11865z;
        if (colorStateList != null) {
            this.f11863x = colorStateList;
        } else {
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(12);
            this.f11863x = colorStateList2;
            if (colorStateList2 == null) {
                this.f11863x = getResources().getColorStateList(com.stepos.alphame.R.color.stepos_btn_color_state);
            }
        }
        ColorStateList colorStateList3 = this.f11833A;
        if (colorStateList3 != null) {
            this.f11864y = colorStateList3;
        } else {
            ColorStateList colorStateList4 = typedArrayObtainStyledAttributes.getColorStateList(11);
            this.f11864y = colorStateList4;
            if (colorStateList4 == null) {
                this.f11864y = getResources().getColorStateList(com.stepos.alphame.R.color.stepos_switch_track_off_color);
            }
        }
        Drawable drawable2 = this.f11840a;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        q qVar = this.f11835C;
        if (qVar != null) {
            ColorStateList colorStateList5 = this.f11862w;
            ColorStateList colorStateList6 = this.f11861v;
            qVar.f11940d = colorStateList5;
            qVar.f11941e = colorStateList6;
            setThumbPosition(this.f11852m);
        }
        typedArrayObtainStyledAttributes.recycle();
        refreshDrawableState();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i4;
        int thumbOffset;
        int i5;
        int i6;
        int i7 = this.f11856q;
        int i8 = this.f11857r;
        int i9 = this.f11858s;
        int i10 = this.f11859t;
        int thumbOffset2 = getThumbOffset() + i7;
        Drawable drawable = this.f11840a;
        Rect rect = this.f11834B;
        if (drawable != null) {
            drawable.getPadding(rect);
            thumbOffset2 += rect.left;
            this.f11840a.setBounds(i7, i8, i9, i10);
        }
        K k4 = this.f11841b;
        if (k4 != null) {
            k4.f11663a.getPadding(rect);
            if (c()) {
                thumbOffset = (i9 - getThumbOffset()) - k4.f11666d;
                i4 = thumbOffset - k4.f11665c;
                int i11 = this.f11854o;
                i5 = k4.f11664b;
                i6 = (i11 - i5) / 2;
            } else {
                i4 = thumbOffset2 + k4.f11666d;
                thumbOffset = k4.f11665c + i4;
                int i12 = this.f11854o;
                i5 = k4.f11664b;
                i6 = (i12 - i5) / 2;
            }
            int i13 = i6 + i8;
            k4.f11663a.setBounds(i4, i13, thumbOffset, i5 + i13);
        }
        ColorStateList colorStateList = this.f11833A;
        if (colorStateList != null) {
            this.f11864y = colorStateList;
        }
        ColorStateList colorStateList2 = this.f11865z;
        if (colorStateList2 != null) {
            this.f11863x = colorStateList2;
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        GradientDrawable gradientDrawable;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        K k4 = this.f11841b;
        if (k4 != null && (gradientDrawable = k4.f11663a) != null) {
            gradientDrawable.setState(drawableState);
        }
        Drawable drawable = this.f11840a;
        if (drawable != null) {
            drawable.setState(drawableState);
        }
        setThumbPosition(this.f11852m);
        invalidate();
    }

    public final void e(boolean z4, boolean z5) {
        boolean zIsChecked = isChecked();
        float f4 = Property.DEFAULT_FLOAT_VALUE;
        if (zIsChecked == z4) {
            W.m mVar = this.f11860u;
            if (mVar == null || !mVar.f1967f) {
                if (z4) {
                    f4 = 1.0f;
                }
                setThumbPosition(f4);
                return;
            }
            return;
        }
        super.setChecked(z4);
        boolean zIsChecked2 = isChecked();
        if (!z5 || !isAttachedToWindow() || !isLaidOut()) {
            W.m mVar2 = this.f11860u;
            if (mVar2 != null && mVar2.f1967f) {
                mVar2.c();
            }
            if (zIsChecked2) {
                f4 = 1.0f;
            }
            setThumbPosition(f4);
            return;
        }
        if (zIsChecked2) {
            f4 = 1.0f;
        }
        W.m mVar3 = this.f11860u;
        if (mVar3 != null && mVar3.f1967f) {
            mVar3.c();
        }
        if (this.f11860u == null) {
            this.f11860u = new W.m(this, f11832I);
        }
        W.n nVar = new W.n();
        float f5 = zIsChecked2 ? this.f11838F : this.f11839G;
        nVar.b(570.0f);
        nVar.a(f5);
        nVar.f1985i = f4;
        W.m mVar4 = this.f11860u;
        mVar4.f1971j = 0.00390625f;
        mVar4.f1974m = nVar;
        mVar4.i();
    }

    public final void f(boolean z4, boolean z5) {
        if (isChecked() != z4) {
            if (AbstractC0770a.b()) {
                performHapticFeedback(31022);
            } else if (B0.f.i(getContext(), "android.permission.VIBRATE") == 0) {
                ((Vibrator) getContext().getSystemService("vibrator")).vibrate(VibrationEffect.createOneShot(45L, -1));
            } else {
                Log.d("CommonUtils", "permission not declared");
            }
        }
        e(z4, z5);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!c()) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f11853n;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f11843d : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (c()) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f11853n;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f11843d : compoundPaddingRight;
    }

    public int getSwitchMinWidth() {
        return this.f11842c;
    }

    public int getSwitchPadding() {
        return this.f11843d;
    }

    public Drawable getTrackDrawable() {
        return this.f11840a;
    }

    @Override // android.view.View
    public final boolean isLaidOut() {
        return getWidth() > 0 && getHeight() > 0;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        GradientDrawable gradientDrawable;
        super.jumpDrawablesToCurrentState();
        K k4 = this.f11841b;
        if (k4 != null && (gradientDrawable = k4.f11663a) != null) {
            gradientDrawable.jumpToCurrentState();
        }
        Drawable drawable = this.f11840a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        W.m mVar = this.f11860u;
        if (mVar == null || !mVar.f1967f || mVar.f1974m.f1978b <= 0.0d) {
            return;
        }
        mVar.h();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        this.f11841b.f11663a.setCallback(this);
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i4 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f11831H);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.f11840a;
        Rect rect = this.f11834B;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        GradientDrawable gradientDrawable = this.f11841b.f11663a;
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
        CharSequence charSequence = isChecked() ? this.f11844e : this.f11845f;
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
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int iMax;
        int paddingLeft;
        int iE;
        int height;
        int paddingTop;
        super.onLayout(z4, i4, i5, i6, i7);
        int iMax2 = 0;
        if (this.f11841b != null) {
            Drawable drawable = this.f11840a;
            Rect rect = this.f11834B;
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
            iE = B0.g.e(paddingLeft, this.f11853n, iMax, iMax2);
        } else {
            int width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f11853n) + iMax + iMax2;
            iE = width;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i8 = this.f11854o;
            int i9 = height2 - (i8 / 2);
            height = i8 + i9;
            paddingTop = i9;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.f11854o + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.f11854o;
        }
        this.f11856q = paddingLeft;
        this.f11857r = paddingTop;
        this.f11859t = height;
        this.f11858s = iE;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i4, int i5) {
        int iMax;
        int intrinsicHeight;
        int intrinsicHeight2;
        K k4 = this.f11841b;
        Rect rect = this.f11834B;
        if (k4 != null) {
            k4.f11663a.getPadding(rect);
            iMax = Math.max((k4.f11663a.getIntrinsicWidth() - rect.left) - rect.right, this.f11835C.f11939c);
            intrinsicHeight = k4.f11663a.getIntrinsicHeight();
        } else {
            iMax = 0;
            intrinsicHeight = 0;
        }
        this.f11855p = iMax;
        Drawable drawable = this.f11840a;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicHeight2 = this.f11840a.getIntrinsicHeight();
        } else {
            rect.setEmpty();
            intrinsicHeight2 = 0;
        }
        int iMax2 = rect.left;
        int iMax3 = rect.right;
        p pVar = p.f11932e;
        if (k4 != null) {
            iMax2 = Math.max(iMax2, 0);
            iMax3 = Math.max(iMax3, 0);
            int i6 = k4.f11666d;
            int i7 = k4.f11667e;
            if (i6 != 0 || i7 != 0) {
                pVar = new p(i6, i7);
            }
        }
        int iMax4 = Math.max(this.f11842c, (this.f11855p * 2) + iMax2 + iMax3 + pVar.f11933a + pVar.f11935c);
        int iMax5 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f11853n = iMax4;
        this.f11854o = iMax5;
        super.onMeasure(i4, i5);
        if (getMeasuredHeight() < iMax5) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax5);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008d  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.Switch.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        if (z4) {
            this.f11837E = Settings.Global.getInt(getContext().getContentResolver(), "flyme_high_contrast_mode", 0) != 0;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        e(z4, true);
    }

    public void setCheckedWithHapticFeedback(boolean z4) {
        f(z4, true);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        super.setCompoundDrawablesWithIntrinsicBounds(i4, i5, i6, i7);
    }

    public void setDarkTrackOffColor(ColorStateList colorStateList) {
        invalidate();
    }

    public void setDarkTrackOnColor(ColorStateList colorStateList) {
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
    }

    public void setSwitchMinWidth(int i4) {
        this.f11842c = i4;
        requestLayout();
    }

    public void setSwitchPadding(int i4) {
        this.f11843d = i4;
        requestLayout();
    }

    public void setThumbOffColor(ColorStateList colorStateList) {
        this.f11862w = colorStateList;
        q qVar = this.f11835C;
        if (qVar != null) {
            ColorStateList colorStateList2 = this.f11861v;
            qVar.f11940d = colorStateList;
            qVar.f11941e = colorStateList2;
            setThumbPosition(this.f11852m);
        }
        invalidate();
    }

    public void setThumbOnColor(ColorStateList colorStateList) {
        this.f11861v = colorStateList;
        q qVar = this.f11835C;
        if (qVar != null) {
            qVar.f11940d = this.f11862w;
            qVar.f11941e = colorStateList;
            setThumbPosition(this.f11852m);
        }
        invalidate();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f11840a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f11840a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawableStateChanged();
        }
        requestLayout();
    }

    public void setTrackOffColor(ColorStateList colorStateList) {
        this.f11833A = colorStateList;
        invalidate();
    }

    public void setTrackOnColor(ColorStateList colorStateList) {
        this.f11865z = colorStateList;
        invalidate();
    }

    public void setTrackResource(int i4) {
        setTrackDrawable(getContext().getResources().getDrawable(i4));
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setCheckedWithHapticFeedback(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        K k4;
        return super.verifyDrawable(drawable) || ((k4 = this.f11841b) != null && drawable == k4.f11663a) || drawable == this.f11840a;
    }

    public void setTrackOffColor(int i4) {
        setTrackOffColor(getContext().getResources().getColorStateList(i4));
        setDarkTrackOffColor(getContext().getResources().getColorStateList(i4));
    }

    public void setTrackOnColor(int i4) {
        setTrackOnColor(getContext().getResources().getColorStateList(i4));
        setDarkTrackOnColor(getContext().getResources().getColorStateList(i4));
    }
}
