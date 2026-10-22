package com.stepos.common.widget;

import O6.t;
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
import com.stepos.common.R$attr;
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;
import com.stepos.common.R$drawable;
import com.stepos.common.R$style;
import com.stepos.common.R$styleable;

/* loaded from: classes3.dex */
public class Switch extends CompoundButton {
    private static final float DAMPING_CHECK_OFF_DEFAULT = 0.69f;
    private static final float DAMPING_CHECK_ON_DEFAULT = 0.81f;
    public static final int STEP_OS_SLIDE_HORIZONTAL = 31022;
    private static final float STIFFNESS_DEFAULT = 570.0f;
    public static final String TAG = "StepOSSwitch";
    private static final float THUMB_STATUS_CHANGE = 1.0f;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private static int[] sSwitchStyleableId;
    private boolean isChanged;
    private AttributeSet mAttributeSet;
    private float mCheckOffDamping;
    private float mCheckOnDamping;
    private ColorStateList mCustomDarkTrackOffColorState;
    private ColorStateList mCustomDarkTrackOnColorState;
    private ColorStateList mCustomTrackOffColorState;
    private ColorStateList mCustomTrackOnColorState;
    private boolean mIgnoreSystemNightMode;
    private boolean mIsHighContrastModeOn;
    private int mMinFlingVelocity;
    private g mParams;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private l mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private TextPaint mTextPaint;
    private k mThumbDrawable;
    private ColorStateList mThumbOffColor;
    private ColorStateList mThumbOnColor;
    private float mThumbPosition;
    private androidx.dynamicanimation.animation.i mThumbSpringAnim;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackOffColorState;
    private ColorStateList mTrackOnColorState;
    private int mUiNightMode;
    private VelocityTracker mVelocityTracker;
    public CharSequence switchOff;
    public CharSequence switchOn;
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final androidx.dynamicanimation.animation.f<Switch> THUMB_POSITION = new a("thumbPos");

    public class a extends androidx.dynamicanimation.animation.f<Switch> {
        public a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(Switch r12) {
            return r12.mThumbPosition;
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(Switch r12, float f10) {
            r12.setThumbPosition(f10);
        }
    }

    public Switch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.StepOSCommon_Switch);
    }

    private boolean getTargetCheckedState() {
        return this.mThumbPosition > 0.5f;
    }

    private int getThumbOffset() {
        return (int) ((getThumbValue() * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.mTempRect;
        drawable.getPadding(rect);
        e eVarA = this.mThumbDrawable.a() != null ? e.a(this.mThumbDrawable.c(), 0, this.mThumbDrawable.d(), 0) : e.NONE;
        return ((((this.mSwitchWidth - this.mThumbWidth) - rect.left) - rect.right) - eVarA.left) - eVarA.right;
    }

    private float getThumbValue() {
        return this.mThumbPosition;
    }

    private void setCheckOffDamping(float f10) {
        this.mCheckOffDamping = f10;
    }

    private void setCheckOnDamping(float f10) {
        this.mCheckOnDamping = f10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbPosition(float f10) {
        this.mThumbPosition = f10;
        float fMax = f10 < 0.0f ? Math.max(f10, 0.0f) : Math.min(f10, 1.0f);
        g gVar = this.mParams;
        if (gVar != null) {
            this.mThumbDrawable.l(gVar.width);
            this.mThumbDrawable.i(this.mParams.height);
            this.mThumbDrawable.h(this.mParams.cornerRadius);
            int iK = k(g(this.mParams.fromColor), g(this.mParams.toColor), fMax);
            k kVar = this.mThumbDrawable;
            g gVar2 = this.mParams;
            kVar.f(j(gVar2.fromAlpha, gVar2.toAlpha, isEnabled()));
            this.mThumbDrawable.g(iK);
            int iK2 = k(g(this.mTrackOffColorState), g(this.mTrackOnColorState), fMax);
            if (!this.mIsHighContrastModeOn || !isChecked() || t.d(iK2)) {
                this.mTrackDrawable.setColorFilter(iK2, PorterDuff.Mode.SRC_IN);
            }
        }
        invalidate();
    }

    public final void c(boolean z10) {
        float f10 = z10 ? 1.0f : 0.0f;
        e();
        if (this.mThumbSpringAnim == null) {
            this.mThumbSpringAnim = new androidx.dynamicanimation.animation.i(this, THUMB_POSITION);
        }
        androidx.dynamicanimation.animation.j jVar = new androidx.dynamicanimation.animation.j();
        jVar.h(STIFFNESS_DEFAULT).f(z10 ? this.mCheckOnDamping : this.mCheckOffDamping).g(f10);
        this.mThumbSpringAnim.o(0.00390625f);
        this.mThumbSpringAnim.B(jVar);
        this.mThumbSpringAnim.t();
    }

    public final void d(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int iC;
        int iE;
        int iB;
        int iB2;
        int i10;
        int i11;
        Rect rect = this.mTempRect;
        int i12 = this.mSwitchLeft;
        int i13 = this.mSwitchTop;
        int i14 = this.mSwitchRight;
        int i15 = this.mSwitchBottom;
        int thumbOffset = getThumbOffset() + i12;
        e eVar = this.mThumbDrawable != null ? e.NONE : e.NONE;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
            int i16 = rect.left;
            thumbOffset += i16;
            if (eVar != e.NONE) {
                int i17 = eVar.left;
                if (i17 > i16) {
                    i12 += i17 - i16;
                }
                int i18 = eVar.top;
                int i19 = rect.top;
                i10 = i18 > i19 ? (i18 - i19) + i13 : i13;
                int i20 = eVar.right;
                int i21 = rect.right;
                i11 = i20 > i21 ? i14 - (i20 - i21) : i14;
                int i22 = eVar.bottom;
                int i23 = rect.bottom;
                if (i22 > i23) {
                    i15 -= i22 - i23;
                }
            } else {
                i10 = i13;
                i11 = i14;
            }
            this.mTrackDrawable.setBounds(i12, i10, i11, i15);
        }
        k kVar = this.mThumbDrawable;
        if (kVar != null) {
            kVar.a().getPadding(rect);
            if (m()) {
                iE = (i14 - getThumbOffset()) - this.mThumbDrawable.c();
                iC = iE - this.mThumbDrawable.e();
                iB = i13 + ((this.mSwitchHeight - this.mThumbDrawable.b()) / 2);
                iB2 = this.mThumbDrawable.b();
            } else {
                iC = this.mThumbDrawable.c() + thumbOffset;
                iE = iC + this.mThumbDrawable.e();
                iB = i13 + ((this.mSwitchHeight - this.mThumbDrawable.b()) / 2);
                iB2 = this.mThumbDrawable.b();
            }
            this.mThumbDrawable.a().setBounds(iC, iB, iE, iB2 + iB);
        }
        ColorStateList colorStateList = this.mCustomTrackOffColorState;
        if (colorStateList != null) {
            this.mTrackOffColorState = colorStateList;
        }
        ColorStateList colorStateList2 = this.mCustomTrackOnColorState;
        if (colorStateList2 != null) {
            this.mTrackOnColorState = colorStateList2;
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        k kVar = this.mThumbDrawable;
        if (kVar != null && kVar.a() != null) {
            this.mThumbDrawable.a().setState(drawableState);
        }
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.setState(drawableState);
        }
        setThumbPosition(this.mThumbPosition);
        invalidate();
    }

    public final void e() {
        androidx.dynamicanimation.animation.i iVar = this.mThumbSpringAnim;
        if (iVar == null || !iVar.i()) {
            return;
        }
        this.mThumbSpringAnim.d();
    }

    public final k f(int i10, int i11) {
        k kVar = new k(new GradientDrawable());
        kVar.a().setShape(0);
        kVar.j(i10);
        kVar.k(i11);
        return kVar;
    }

    public final int g(ColorStateList colorStateList) {
        return isEnabled() ? i(colorStateList) : h(colorStateList);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!m()) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.mSwitchPadding : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (m()) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.mSwitchPadding : compoundPaddingRight;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public final int h(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    public final int i(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{R.attr.state_enabled}, 0);
    }

    @Override // android.view.View
    public boolean isLaidOut() {
        return getWidth() > 0 && getHeight() > 0;
    }

    public final int j(float f10, float f11, boolean z10) {
        return z10 ? (int) (f10 * 255.0f) : (int) (f11 * 255.0f);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        k kVar = this.mThumbDrawable;
        if (kVar != null && kVar.a() != null) {
            this.mThumbDrawable.a().jumpToCurrentState();
        }
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        androidx.dynamicanimation.animation.i iVar = this.mThumbSpringAnim;
        if (iVar != null && iVar.i() && this.mThumbSpringAnim.x()) {
            this.mThumbSpringAnim.C();
        }
    }

    public final int k(int i10, int i11, float f10) {
        return E2.c.b().evaluate(f10, Integer.valueOf(i10), Integer.valueOf(i11)).intValue();
    }

    public final boolean l(float f10, float f11) {
        return f10 > ((float) this.mSwitchLeft) && f10 < ((float) this.mSwitchRight) && f11 > ((float) this.mSwitchTop) && f11 < ((float) this.mSwitchBottom);
    }

    public boolean m() {
        return getLayoutDirection() == 1;
    }

    public void n() {
        O6.c.h(this, STEP_OS_SLIDE_HORIZONTAL);
    }

    public final void o() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(this.mAttributeSet, R$styleable.Switch, R$attr.StepOSCommon_Switch, R$style.Widget_StepOSCommon_Switch);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.Switch_mcTrack);
        this.mTrackDrawable = drawable;
        if (drawable == null) {
            this.mTrackDrawable = getResources().getDrawable(R$drawable.mc_switch_anim_track);
        }
        ColorStateList colorStateList = this.mCustomTrackOnColorState;
        if (colorStateList != null) {
            this.mTrackOnColorState = colorStateList;
        } else {
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.Switch_mcTrackOnColor);
            this.mTrackOnColorState = colorStateList2;
            if (colorStateList2 == null) {
                this.mTrackOnColorState = getResources().getColorStateList(R$color.stepos_btn_color_state);
            }
        }
        ColorStateList colorStateList3 = this.mCustomTrackOffColorState;
        if (colorStateList3 != null) {
            this.mTrackOffColorState = colorStateList3;
        } else {
            ColorStateList colorStateList4 = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.Switch_mcTrackOffColor);
            this.mTrackOffColorState = colorStateList4;
            if (colorStateList4 == null) {
                this.mTrackOffColorState = getResources().getColorStateList(R$color.stepos_switch_track_off_color);
            }
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        g gVar = this.mParams;
        if (gVar != null) {
            gVar.b(this.mThumbOffColor, this.mThumbOnColor);
            setThumbPosition(this.mThumbPosition);
        }
        typedArrayObtainStyledAttributes.recycle();
        refreshDrawableState();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
        this.mThumbDrawable.a().setCallback(this);
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        GradientDrawable gradientDrawableA = this.mThumbDrawable.a();
        if (drawable != null) {
            if (!this.mSplitTrack || gradientDrawableA == null) {
                drawable.draw(canvas);
            } else {
                e eVar = e.NONE;
                gradientDrawableA.copyBounds(rect);
                rect.left += eVar.left;
                rect.right -= eVar.right;
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
        CharSequence charSequence = isChecked() ? this.switchOn : this.switchOff;
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
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int iMax;
        int width;
        int paddingLeft;
        int i14;
        int paddingTop;
        int height;
        super.onLayout(z10, i10, i11, i12, i13);
        int iMax2 = 0;
        if (this.mThumbDrawable != null) {
            Rect rect = this.mTempRect;
            Drawable drawable = this.mTrackDrawable;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            e eVar = e.NONE;
            iMax = Math.max(0, eVar.left - rect.left);
            iMax2 = Math.max(0, eVar.right - rect.right);
        } else {
            iMax = 0;
        }
        if (m()) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.mSwitchWidth + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.mSwitchWidth) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i14 = this.mSwitchHeight;
            paddingTop = paddingTop2 - (i14 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.mSwitchHeight;
                this.mSwitchLeft = paddingLeft;
                this.mSwitchTop = paddingTop;
                this.mSwitchBottom = height;
                this.mSwitchRight = width;
            }
            paddingTop = getPaddingTop();
            i14 = this.mSwitchHeight;
        }
        height = i14 + paddingTop;
        this.mSwitchLeft = paddingLeft;
        this.mSwitchTop = paddingTop;
        this.mSwitchBottom = height;
        this.mSwitchRight = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int iMax;
        int intrinsicHeight;
        int intrinsicHeight2;
        Rect rect = this.mTempRect;
        k kVar = this.mThumbDrawable;
        if (kVar != null) {
            kVar.a().getPadding(rect);
            iMax = Math.max((this.mThumbDrawable.a().getIntrinsicWidth() - rect.left) - rect.right, this.mParams.width);
            intrinsicHeight = this.mThumbDrawable.a().getIntrinsicHeight();
        } else {
            iMax = 0;
            intrinsicHeight = 0;
        }
        this.mThumbWidth = iMax;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicHeight2 = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            rect.setEmpty();
            intrinsicHeight2 = 0;
        }
        int iMax2 = rect.left;
        int iMax3 = rect.right;
        e eVarA = e.NONE;
        if (this.mThumbDrawable != null) {
            iMax2 = Math.max(iMax2, 0);
            iMax3 = Math.max(iMax3, 0);
            eVarA = e.a(this.mThumbDrawable.c(), 0, this.mThumbDrawable.d(), 0);
        }
        int iMax4 = Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + iMax2 + iMax3 + eVarA.left + eVarA.right);
        int iMax5 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.mSwitchWidth = iMax4;
        this.mSwitchHeight = iMax5;
        super.onMeasure(i10, i11);
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
            android.view.VelocityTracker r0 = r6.mVelocityTracker
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
            int r0 = r6.mTouchMode
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.mTouchX
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
            float r0 = r6.mThumbPosition
            float r0 = r0 + r2
            float r0 = com.stepos.common.widget.f.a(r0, r4, r3)
            float r2 = r6.mThumbPosition
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.mTouchX = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.mTouchX
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.mTouchY
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.mTouchMode = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.mTouchX = r0
            r6.mTouchY = r3
            return r1
        L89:
            int r0 = r6.mTouchMode
            if (r0 != r2) goto L94
            r6.r(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.mTouchMode = r0
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.l(r0, r2)
            if (r3 == 0) goto Lb7
            r6.mTouchMode = r1
            r6.mTouchX = r0
            r6.mTouchY = r2
        Lb7:
            boolean r6 = super.onTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.Switch.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.mIsHighContrastModeOn = t.e(getContext());
        }
    }

    public void p(boolean z10, boolean z11) {
        if (isChecked() == z10) {
            androidx.dynamicanimation.animation.i iVar = this.mThumbSpringAnim;
            if (iVar == null || !iVar.i()) {
                setThumbPosition(z10 ? 1.0f : 0.0f);
                return;
            }
            return;
        }
        super.setChecked(z10);
        boolean zIsChecked = isChecked();
        if (z11 && isAttachedToWindow() && isLaidOut()) {
            c(zIsChecked);
        } else {
            e();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    public void q(boolean z10, boolean z11) {
        if (isChecked() != z10) {
            n();
        }
        p(z10, z11);
    }

    public final void r(MotionEvent motionEvent) {
        this.mTouchMode = 0;
        boolean zIsChecked = true;
        if (motionEvent.getAction() == 1 && isEnabled()) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) <= this.mMinFlingVelocity) {
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

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        p(z10, true);
    }

    public void setCheckedWithHapticFeedback(boolean z10) {
        q(z10, true);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
    }

    public void setDarkTrackOffColor(ColorStateList colorStateList) {
        this.mCustomDarkTrackOffColorState = colorStateList;
        invalidate();
    }

    public void setDarkTrackOnColor(ColorStateList colorStateList) {
        this.mCustomDarkTrackOnColorState = colorStateList;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
    }

    public void setSwitchMinWidth(int i10) {
        this.mSwitchMinWidth = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.mSwitchPadding = i10;
        requestLayout();
    }

    public void setThumbOffColor(ColorStateList colorStateList) {
        this.mThumbOffColor = colorStateList;
        g gVar = this.mParams;
        if (gVar != null) {
            gVar.b(colorStateList, this.mThumbOnColor);
            setThumbPosition(this.mThumbPosition);
        }
        invalidate();
    }

    public void setThumbOnColor(ColorStateList colorStateList) {
        this.mThumbOnColor = colorStateList;
        g gVar = this.mParams;
        if (gVar != null) {
            gVar.b(this.mThumbOffColor, colorStateList);
            setThumbPosition(this.mThumbPosition);
        }
        invalidate();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTrackDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawableStateChanged();
        }
        requestLayout();
    }

    public void setTrackOffColor(ColorStateList colorStateList) {
        this.mCustomTrackOffColorState = colorStateList;
        invalidate();
    }

    public void setTrackOnColor(ColorStateList colorStateList) {
        this.mCustomTrackOnColorState = colorStateList;
        invalidate();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(getContext().getResources().getDrawable(i10));
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setCheckedWithHapticFeedback(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable)) {
            return true;
        }
        k kVar = this.mThumbDrawable;
        return (kVar != null && drawable == kVar.a()) || drawable == this.mTrackDrawable;
    }

    public Switch(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.isChanged = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.mIgnoreSystemNightMode = false;
        this.mCheckOnDamping = DAMPING_CHECK_ON_DEFAULT;
        this.mCheckOffDamping = DAMPING_CHECK_OFF_DEFAULT;
        O6.c.e(this, 2);
        this.mAttributeSet = attributeSet;
        this.mTextPaint = new TextPaint(1);
        Resources resources = getResources();
        this.mTextPaint.density = resources.getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Switch, i10, R$style.Widget_StepOSCommon_Switch);
        this.mIgnoreSystemNightMode = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Switch_mcIgnoreSysNightMode, false);
        this.mTrackDrawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.Switch_mcTrack);
        this.mThumbDrawable = f(getResources().getDimensionPixelOffset(R$dimen.stepos_switch_thumb_padding_left), getResources().getDimensionPixelOffset(R$dimen.stepos_switch_thumb_padding_right));
        o();
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.mSwitchMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Switch_mcSwitchMinWidth, 0);
        this.mSwitchPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Switch_mcSwitchPadding, 48);
        this.mSplitTrack = false;
        this.mThumbOnColor = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.Switch_mcThumbOnColor);
        this.mThumbOffColor = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.Switch_mcThumbOffColor);
        typedArrayObtainStyledAttributes.recycle();
        int[] iArr = {R.attr.textOn, R.attr.textOff};
        sSwitchStyleableId = iArr;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, R.attr.switchStyle, 0);
        this.switchOn = typedArrayObtainStyledAttributes2.getText(0);
        this.switchOff = typedArrayObtainStyledAttributes2.getText(1);
        typedArrayObtainStyledAttributes2.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        g gVarD = g.d(this.mThumbDrawable);
        this.mParams = gVarD;
        gVarD.b(this.mThumbOffColor, this.mThumbOnColor).e(getResources().getDimensionPixelOffset(R$dimen.stepos_switch_thumb_to_height)).f(getResources().getDimensionPixelOffset(R$dimen.stepos_switch_thumb_to_width)).c(getResources().getDimensionPixelOffset(R$dimen.stepos_switch_thumb_to_corner_radius)).a(1.0f, 1.0f);
        this.mThumbDrawable.a().setCallback(this);
        refreshDrawableState();
        setChecked(isChecked());
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
