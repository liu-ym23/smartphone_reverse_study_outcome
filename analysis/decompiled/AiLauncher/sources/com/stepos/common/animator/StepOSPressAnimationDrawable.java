package com.stepos.common.animator;

import O6.r;
import Z2.h;
import Z2.k;
import Z2.l;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Interpolator;
import androidx.dynamicanimation.animation.e;
import androidx.dynamicanimation.animation.g;
import androidx.dynamicanimation.animation.i;
import androidx.dynamicanimation.animation.j;
import com.stepos.common.R$styleable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class StepOSPressAnimationDrawable extends StateListDrawable {
    private static final float DAMPING = 0.9f;
    private static final long DEFAULT_ALPHA_ANIM_NO_SCALE_DURATION = 200;
    private static final long DEFAULT_ALPHA_ANIM_TO_NORMAL_DURATION = 300;
    private static final long DEFAULT_ALPHA_ANIM_TO_PRESS_DURATION = 100;
    private static final float DEFAULT_ALPHA_FROM = 0.0f;
    private static final float DEFAULT_ALPHA_TO = 0.03f;
    private static final float DEFAULT_BOUND_SCALE_FROM = 1.0f;
    private static final float DEFAULT_BOUND_SCALE_TO = 1.0f;
    private static final int DEFAULT_CORNER_SIZE = 0;
    private static final int DEFAULT_DRAW_OFFSET = 0;
    private static final boolean DEFAULT_NOT_FULL_STYLE_USE_SQUARE = false;
    private static final boolean DEFAULT_USE_FULL_STYLE = true;
    private static final int DIVIDER_HEIGHT_RANGE = 2;
    private static final int DIVIDER_WIDTH_RANGE = 2;
    private static final long FADE_IN_DURATION = 350;
    private static final long FADE_OUT_DURATION = 500;
    private static final int OPAQUE = 255;
    private static final float SPRING_ANIMATION_FLOAT_TO_INT_PROP = 100.0f;
    private static final long STAY_DURATION = 350;
    private static final float STIFFNESS = 250.0f;
    private static final String TAG = "StepOSSPressDrawable";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f29502a = 0;
    private static final Interpolator sAlphaCubic = D0.a.a(0.4f, 0.0f, 0.58f, 1.0f);
    private static final Interpolator sFadeInterpolator = D0.a.a(0.33f, 0.0f, 0.67f, 1.0f);
    private ValueAnimator mAlphaAnimToNormal;
    private ValueAnimator mAlphaAnimToPress;
    private int mAlphaProgress;
    private int mBottomPadding;
    private boolean mCanReflect;
    private int mEndPadding;
    private AnimatorSet mFadeAnimSet;
    private boolean mHandleQuickClick;
    private boolean mInit;
    private float mScaleProgress;
    private i mScaleSpringAnimation;
    private h mShapeDrawable;
    protected int mShapeDrawableHeight;
    protected int mShapeDrawableWidth;
    private int mStartPadding;
    private int mStickyHeight;
    private int mStickyWidth;
    private int mTopPadding;
    private Rect mShapeDrawableBound = new Rect();
    private int mRadius = 0;
    private float mBoundScaleTo = 1.0f;
    private float mBoundScaleFrom = 1.0f;
    private int mTint = -16777216;
    private float mAlphaFrom = 0.0f;
    private float mAlphaTo = 0.03f;
    private boolean mUseFullStyle = true;
    private boolean mNotFullStyleUseSquare = false;
    private int mDrawOffsetX = 0;
    private int mDrawOffsetY = 0;

    public class a implements e.r {
        public a() {
        }

        @Override // androidx.dynamicanimation.animation.e.r
        public void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
            StepOSPressAnimationDrawable.this.mScaleProgress = f10 / 100.0f;
            StepOSPressAnimationDrawable.this.invalidateSelf();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            StepOSPressAnimationDrawable.this.mAlphaProgress = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            StepOSPressAnimationDrawable.this.invalidateSelf();
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (StepOSPressAnimationDrawable.this.mHandleQuickClick) {
                StepOSPressAnimationDrawable.this.mHandleQuickClick = false;
                StepOSPressAnimationDrawable.this.r();
            }
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            StepOSPressAnimationDrawable.this.mAlphaProgress = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            StepOSPressAnimationDrawable.this.invalidateSelf();
        }
    }

    public static class e extends Drawable {
        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            super.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public StepOSPressAnimationDrawable() {
        this.mCanReflect = true;
        addState(new int[]{R.attr.state_pressed}, new e());
        addState(new int[0], new e());
        try {
            Canvas canvas = new Canvas();
            r.b(canvas).a("setNightModeUseOf", Integer.TYPE).a(canvas, 2);
        } catch (Exception e10) {
            Log.e(TAG, "setNightModeUseOf error " + e10);
            this.mCanReflect = false;
        }
    }

    public static /* synthetic */ void a(i iVar) {
        if (iVar != null) {
            iVar.t();
        }
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mCanReflect) {
            try {
                r.b(canvas).a("setNightModeUseOf", Integer.TYPE).a(canvas, 2);
            } catch (Exception unused) {
            }
        }
        if (o()) {
            this.mShapeDrawableBound.set(getBounds().centerX() - (this.mShapeDrawableWidth / 2), getBounds().centerY() - (this.mShapeDrawableHeight / 2), getBounds().centerX() + (this.mShapeDrawableWidth / 2), this.mShapeDrawableHeight);
        } else {
            this.mShapeDrawableBound.set((int) (getBounds().centerX() - ((this.mShapeDrawableWidth / 2) * this.mScaleProgress)), (int) (getBounds().centerY() - ((this.mShapeDrawableHeight / 2) * this.mScaleProgress)), (int) (getBounds().centerX() + ((this.mShapeDrawableWidth / 2) * this.mScaleProgress)), (int) (getBounds().centerY() + ((this.mShapeDrawableHeight / 2) * this.mScaleProgress)));
        }
        this.mShapeDrawable.setAlpha(this.mAlphaProgress);
        this.mShapeDrawable.setBounds(this.mShapeDrawableBound);
        this.mShapeDrawable.draw(canvas);
    }

    public h g() {
        return this.mShapeDrawable;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    public int h() {
        return this.mRadius;
    }

    public final void i() {
        k();
        j();
        m();
        l();
        this.mInit = true;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.Drawable
    @SuppressLint({"LongLogTag"})
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, R$styleable.StepOSPressAnimationDrawable);
        int i10 = R$styleable.StepOSPressAnimationDrawable_radius;
        if (typedArrayObtainAttributes.hasValue(i10)) {
            this.mRadius = typedArrayObtainAttributes.getDimensionPixelSize(i10, 0);
        }
        int i11 = R$styleable.StepOSPressAnimationDrawable_pressScaleTo;
        if (typedArrayObtainAttributes.hasValue(i11)) {
            this.mBoundScaleTo = typedArrayObtainAttributes.getFloat(i11, 1.0f);
        }
        int i12 = R$styleable.StepOSPressAnimationDrawable_pressScaleFrom;
        if (typedArrayObtainAttributes.hasValue(i12)) {
            this.mBoundScaleFrom = typedArrayObtainAttributes.getFloat(i12, 1.0f);
        }
        int i13 = R$styleable.StepOSPressAnimationDrawable_drawOffsetX;
        if (typedArrayObtainAttributes.hasValue(i13)) {
            this.mDrawOffsetX = typedArrayObtainAttributes.getDimensionPixelSize(i13, 0);
        }
        int i14 = R$styleable.StepOSPressAnimationDrawable_drawOffsetY;
        if (typedArrayObtainAttributes.hasValue(i14)) {
            this.mDrawOffsetY = typedArrayObtainAttributes.getDimensionPixelSize(i14, 0);
        }
        int i15 = R$styleable.StepOSPressAnimationDrawable_tint;
        if (typedArrayObtainAttributes.hasValue(i15)) {
            this.mTint = typedArrayObtainAttributes.getColor(i15, -16777216);
        }
        int i16 = R$styleable.StepOSPressAnimationDrawable_pressAlphaFrom;
        if (typedArrayObtainAttributes.hasValue(i16)) {
            this.mAlphaFrom = typedArrayObtainAttributes.getFloat(i16, 0.0f);
        }
        int i17 = R$styleable.StepOSPressAnimationDrawable_pressAlphaTo;
        if (typedArrayObtainAttributes.hasValue(i17)) {
            this.mAlphaTo = typedArrayObtainAttributes.getFloat(i17, 0.03f);
        }
        int i18 = R$styleable.StepOSPressAnimationDrawable_useFullStyle;
        if (typedArrayObtainAttributes.hasValue(i18)) {
            this.mUseFullStyle = typedArrayObtainAttributes.getBoolean(i18, true);
        }
        int i19 = R$styleable.StepOSPressAnimationDrawable_notFullStyleUseSquare;
        if (typedArrayObtainAttributes.hasValue(i19)) {
            this.mNotFullStyleUseSquare = typedArrayObtainAttributes.getBoolean(i19, false);
        }
        int i20 = R$styleable.StepOSPressAnimationDrawable_startPadding;
        if (typedArrayObtainAttributes.hasValue(i20)) {
            this.mStartPadding = typedArrayObtainAttributes.getDimensionPixelSize(i20, 0);
        }
        int i21 = R$styleable.StepOSPressAnimationDrawable_endPadding;
        if (typedArrayObtainAttributes.hasValue(i21)) {
            this.mEndPadding = typedArrayObtainAttributes.getDimensionPixelSize(i21, 0);
        }
        int i22 = R$styleable.StepOSPressAnimationDrawable_topPadding;
        if (typedArrayObtainAttributes.hasValue(i22)) {
            this.mTopPadding = typedArrayObtainAttributes.getDimensionPixelSize(i22, 0);
        }
        int i23 = R$styleable.StepOSPressAnimationDrawable_bottomPadding;
        if (typedArrayObtainAttributes.hasValue(i23)) {
            this.mBottomPadding = typedArrayObtainAttributes.getDimensionPixelSize(i23, 0);
        }
        typedArrayObtainAttributes.recycle();
        if (this.mInit) {
            return;
        }
        i();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        return true;
    }

    public final void j() {
        i iVarB = new i(new g()).B(new j().f(0.9f).h(STIFFNESS));
        this.mScaleSpringAnimation = iVarB;
        iVarB.q(this.mBoundScaleFrom * 100.0f);
        this.mScaleProgress = this.mBoundScaleFrom;
        this.mScaleSpringAnimation.y().g(this.mBoundScaleTo * 100.0f);
        this.mScaleSpringAnimation.c(new a());
    }

    public final void k() {
        h hVar = new h(l.a().r(new k()).o(0.0f).m());
        this.mShapeDrawable = hVar;
        hVar.setTint(this.mTint);
        this.mShapeDrawable.c0(this.mRadius);
        this.mShapeDrawable.setAlpha((int) (this.mAlphaFrom * 255.0f));
    }

    public final void l() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mAlphaTo, this.mAlphaFrom);
        this.mAlphaAnimToNormal = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(sAlphaCubic);
        this.mAlphaAnimToNormal.setDuration(n() ? 300L : 200L);
        this.mAlphaAnimToNormal.addUpdateListener(new d());
    }

    public final void m() {
        float f10 = n() ? 100.0f : 200.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mAlphaFrom, this.mAlphaTo);
        this.mAlphaAnimToPress = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(sAlphaCubic);
        this.mAlphaAnimToPress.setDuration((long) f10);
        this.mAlphaAnimToPress.addUpdateListener(new b());
        this.mAlphaAnimToPress.addListener(new c());
    }

    public final boolean n() {
        return Float.compare(this.mBoundScaleTo, 1.0f) != 0;
    }

    public boolean o() {
        return false;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i10;
        super.onBoundsChange(rect);
        getBounds().offset(this.mDrawOffsetX, this.mDrawOffsetY);
        if (this.mUseFullStyle) {
            this.mShapeDrawableWidth = (getBounds().width() - this.mStartPadding) - this.mEndPadding;
            this.mShapeDrawableHeight = (getBounds().height() - this.mTopPadding) - this.mBottomPadding;
            return;
        }
        if (!this.mNotFullStyleUseSquare) {
            int i11 = this.mRadius;
            this.mShapeDrawableWidth = i11 * 2;
            this.mShapeDrawableHeight = i11 * 2;
            return;
        }
        int iMin = Math.min(getBounds().width(), getBounds().height());
        this.mShapeDrawableWidth = iMin;
        this.mShapeDrawableHeight = iMin;
        int i12 = this.mStickyWidth;
        if (i12 <= 0 || (i10 = this.mStickyHeight) <= 0) {
            return;
        }
        this.mShapeDrawableWidth = i12;
        this.mShapeDrawableHeight = i10;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        if (!this.mInit) {
            i();
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z10 = true;
            } else if (i10 == 16842919) {
                z11 = true;
            }
        }
        if (z10 && z11) {
            s();
            return zOnStateChange;
        }
        r();
        return zOnStateChange;
    }

    public void p(int i10, int i11) {
        this.mStickyWidth = i10;
        this.mStickyHeight = i11;
    }

    public final void q(final i iVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            iVar.t();
            return;
        }
        Log.w(TAG, "Your looper is not on MainLooper, force run on MainLooper now, and trace:" + Log.getStackTraceString(new Throwable()));
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.stepos.common.animator.c
            @Override // java.lang.Runnable
            public final void run() {
                StepOSPressAnimationDrawable.a(iVar);
            }
        });
    }

    public final void r() {
        this.mAlphaAnimToNormal.setFloatValues(this.mAlphaProgress / 255.0f, this.mAlphaFrom);
        if (this.mAlphaAnimToPress.isRunning()) {
            this.mHandleQuickClick = true;
        } else {
            this.mAlphaAnimToNormal.start();
        }
        this.mScaleSpringAnimation.q(this.mScaleProgress * 100.0f);
        this.mScaleSpringAnimation.y().g(this.mBoundScaleFrom * 100.0f);
        q(this.mScaleSpringAnimation);
    }

    public final void s() {
        this.mAlphaAnimToPress.setFloatValues(this.mAlphaProgress / 255.0f, this.mAlphaTo);
        this.mAlphaAnimToPress.start();
        if (this.mAlphaAnimToNormal.isRunning()) {
            this.mAlphaAnimToNormal.cancel();
        }
        this.mScaleSpringAnimation.q(this.mScaleProgress * 100.0f);
        this.mScaleSpringAnimation.y().g(this.mBoundScaleTo * 100.0f);
        q(this.mScaleSpringAnimation);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.mShapeDrawable.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mShapeDrawable.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        this.mTint = i10;
    }
}
