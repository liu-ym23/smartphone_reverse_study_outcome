package com.stepos.common.widget;

import O6.s;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.TextView;
import com.stepos.common.R$attr;
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;
import com.stepos.common.R$drawable;
import com.stepos.common.R$styleable;
import com.stepos.common.drawble.CircularAnimatedDrawable;
import com.stepos.common.drawble.CircularProgressDrawable;
import com.stepos.common.drawble.StrokeGradientDrawable;

/* loaded from: classes3.dex */
public class CircularProgressButton extends Button {
    private static final int CRITICAL_WIDTH = 80;
    public static final int ERROR_STATE_PROGRESS = -1;
    public static final int IDLE_STATE_PROGRESS = 0;
    private static final float MAX_PADDING = 12.0f;
    private static final int MAX_WIDTH = 100;
    private static final float MIN_PADDING = 8.0f;
    private static final int MIN_WIDTH = 48;
    private static final float PADDING_AUTO_FIT_BASELINE = 90.0f;
    private static int PROGRESS_ANIMATION_DURATION = 800;
    private int mAnimCurrentProgress;
    private CircularAnimatedDrawable mAnimatedDrawable;
    private boolean mAutoFitPadding;
    private StrokeGradientDrawable mBackground;
    private boolean mCanSkipAnim;
    private int mColorIndicator;
    private int mColorIndicatorBackground;
    private int mColorProgress;
    private ColorStateList mCompleteColorState;
    private StateListDrawable mCompleteStateDrawable;
    private j mCompleteStateListener;
    private String mCompleteText;
    private boolean mConfigurationChanged;
    private float mCornerRadius;
    private StateListDrawable mCurrentStateDrawable;
    private ColorStateList mErrorColorState;
    private StateListDrawable mErrorStateDrawable;
    private j mErrorStateListener;
    private String mErrorText;
    private int mIconComplete;
    private int mIconError;
    private ColorStateList mIdleColorState;
    private StateListDrawable mIdleStateDrawable;
    private j mIdleStateListener;
    private String mIdleText;
    private boolean mIndeterminateProgressMode;
    private boolean mIsCycle;
    private boolean mIsFirstTime;
    private boolean mIsUseTransitionAnim;
    private int mMaxProgress;
    private i mMorphingAnimation;
    private boolean mMorphingInProgress;
    private boolean mNeedInvalidateCenterIcon;
    private int mOrginWidth;
    private int mPaddingProgress;
    private int mProgress;
    private ValueAnimator mProgressAnimation;
    private Drawable mProgressCenterIcon;
    private CircularProgressDrawable mProgressDrawable;
    private StateListDrawable mProgressStateDrawable;
    private j mProgressStateListener;
    private int mProgressStrokeWidth;
    private String mProgressText;
    private int mProgressWidth;
    private boolean mShouldShowCenterIcon;
    private boolean mShouldUpdateBounds;
    private State mState;
    private ColorStateList mStrokeColorComplete;
    private ColorStateList mStrokeColorError;
    private ColorStateList mStrokeColorIdle;
    private int mStrokeWidth;
    private ColorStateList mTextColorComplete;
    private ColorStateList mTextColorError;
    private ColorStateList mTextColorIdle;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private boolean mConfigurationChanged;
        private boolean mIndeterminateProgressMode;
        private int mProgress;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mProgress);
            parcel.writeInt(this.mIndeterminateProgressMode ? 1 : 0);
            parcel.writeInt(this.mConfigurationChanged ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mProgress = parcel.readInt();
            this.mIndeterminateProgressMode = parcel.readInt() == 1;
            this.mConfigurationChanged = parcel.readInt() == 1;
        }
    }

    public enum State {
        PROGRESS,
        IDLE,
        COMPLETE,
        ERROR
    }

    public class a implements j {
        public a() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.j
        public void a() {
            CircularProgressButton.this.mMorphingInProgress = false;
            CircularProgressButton.this.setClickable(true);
            CircularProgressButton.this.setText((CharSequence) null);
            CircularProgressButton.this.requestLayout();
        }
    }

    public class b implements j {
        public b() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.j
        public void a() throws Resources.NotFoundException {
            if (CircularProgressButton.this.mIconComplete != 0) {
                CircularProgressButton.this.setText((CharSequence) null);
                CircularProgressButton circularProgressButton = CircularProgressButton.this;
                circularProgressButton.setIcon(circularProgressButton.mIconComplete);
            } else {
                CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
                circularProgressButton2.setText(circularProgressButton2.mCompleteText);
            }
            CircularProgressButton.this.a0();
            CircularProgressButton.this.mMorphingInProgress = false;
            CircularProgressButton.this.setClickable(true);
            CircularProgressButton circularProgressButton3 = CircularProgressButton.this;
            circularProgressButton3.setTextColor(circularProgressButton3.mTextColorComplete);
        }
    }

    public class c implements j {
        public c() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.j
        public void a() {
            CircularProgressButton.this.W();
            CircularProgressButton circularProgressButton = CircularProgressButton.this;
            circularProgressButton.setText(circularProgressButton.mIdleText);
            CircularProgressButton.this.a0();
            CircularProgressButton.this.mMorphingInProgress = false;
            CircularProgressButton.this.setClickable(true);
            CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
            circularProgressButton2.setTextColor(circularProgressButton2.mTextColorIdle);
        }
    }

    public class d implements j {
        public d() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.j
        public void a() throws Resources.NotFoundException {
            if (CircularProgressButton.this.mIconError != 0) {
                CircularProgressButton.this.setText((CharSequence) null);
                CircularProgressButton circularProgressButton = CircularProgressButton.this;
                circularProgressButton.setIcon(circularProgressButton.mIconError);
            } else {
                CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
                circularProgressButton2.setWidth(circularProgressButton2.F(circularProgressButton2.getPaint(), CircularProgressButton.this.mErrorText) + CircularProgressButton.this.getCompoundPaddingRight() + CircularProgressButton.this.getCompoundPaddingLeft());
                CircularProgressButton circularProgressButton3 = CircularProgressButton.this;
                circularProgressButton3.setText(circularProgressButton3.mErrorText);
                CircularProgressButton.this.mIsFirstTime = false;
                CircularProgressButton.this.mIsCycle = true;
            }
        }
    }

    public class e implements j {
        public e() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.j
        public void a() throws Resources.NotFoundException {
            if (CircularProgressButton.this.mIconError != 0) {
                CircularProgressButton.this.setText((CharSequence) null);
                CircularProgressButton circularProgressButton = CircularProgressButton.this;
                circularProgressButton.setIcon(circularProgressButton.mIconError);
            } else {
                CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
                circularProgressButton2.setText(circularProgressButton2.mErrorText);
            }
            CircularProgressButton.this.mMorphingInProgress = false;
            CircularProgressButton.this.setClickable(true);
            CircularProgressButton circularProgressButton3 = CircularProgressButton.this;
            circularProgressButton3.setTextColor(circularProgressButton3.mTextColorError);
        }
    }

    public class f implements j {
        public f() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.j
        public void a() {
            CircularProgressButton.this.W();
            CircularProgressButton circularProgressButton = CircularProgressButton.this;
            circularProgressButton.setText(circularProgressButton.mIdleText);
            CircularProgressButton.this.a0();
            CircularProgressButton.this.mMorphingInProgress = false;
            CircularProgressButton.this.setClickable(true);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CircularProgressButton.this.invalidate();
        }
    }

    public class h implements ValueAnimator.AnimatorUpdateListener {
        public h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CircularProgressButton.this.mAnimCurrentProgress = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            CircularProgressButton.this.invalidate();
        }
    }

    public class i {
        public static final int DURATION_INSTANT = 1;
        public static final int DURATION_NORMAL = 240;
        private AnimatorSet mAnimSet;
        private StrokeGradientDrawable mDrawable;
        private int mDuration;
        private int mFromColor;
        private float mFromCornerRadius;
        private int mFromStrokeColor;
        private int mFromStrokeWidth;
        private int mFromWidth;
        private j mListener;
        private float mPadding;
        private int mToColor;
        private float mToCornerRadius;
        private int mToStrokeColor;
        private int mToStrokeWidth;
        private int mToWidth;
        private TextView mView;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ GradientDrawable val$gradientDrawable;

            public a(GradientDrawable gradientDrawable) {
                this.val$gradientDrawable = gradientDrawable;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue;
                int i10;
                float animatedFraction;
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                if (i.this.mFromWidth > i.this.mToWidth) {
                    iIntValue = (i.this.mFromWidth - num.intValue()) / 2;
                    i10 = i.this.mFromWidth - iIntValue;
                    animatedFraction = i.this.mPadding * valueAnimator.getAnimatedFraction();
                } else {
                    iIntValue = (i.this.mToWidth - num.intValue()) / 2;
                    i10 = i.this.mToWidth - iIntValue;
                    animatedFraction = i.this.mPadding - (i.this.mPadding * valueAnimator.getAnimatedFraction());
                }
                int i11 = (int) animatedFraction;
                this.val$gradientDrawable.setBounds(iIntValue + i11, i11, (i10 - i11) - 1, (i.this.mView.getHeight() - i11) - 1);
                CircularProgressButton.this.invalidate();
            }
        }

        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (i.this.mListener != null) {
                    i.this.mListener.a();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public class c implements Animator.AnimatorListener {
            public c() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (i.this.mListener != null) {
                    i.this.mListener.a();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public i(TextView textView, StrokeGradientDrawable strokeGradientDrawable) {
            this.mView = textView;
            this.mDrawable = strokeGradientDrawable;
        }

        public void f() {
            this.mAnimSet.end();
            this.mAnimSet.removeAllListeners();
        }

        public void g() {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.mDrawable.getGradientDrawable(), "color", this.mFromColor, this.mToColor);
            objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
            ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this.mDrawable, "strokeColor", this.mFromStrokeColor, this.mToStrokeColor);
            objectAnimatorOfInt2.setEvaluator(new ArgbEvaluator());
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimSet = animatorSet;
            animatorSet.setInterpolator(CircularProgressButton.this.getInterpolator());
            this.mAnimSet.setDuration(this.mDuration);
            this.mAnimSet.playTogether(objectAnimatorOfInt, objectAnimatorOfInt2);
            this.mAnimSet.addListener(new c());
            this.mAnimSet.start();
        }

        public void h(int i10) {
            this.mDuration = i10;
        }

        public void i(int i10) {
            this.mFromColor = i10;
        }

        public void j(float f10) {
            this.mFromCornerRadius = f10;
        }

        public void k(int i10) {
            this.mFromStrokeColor = i10;
        }

        public void l(int i10) {
            this.mFromStrokeWidth = i10;
        }

        public void m(int i10) {
            this.mFromWidth = i10;
        }

        public void n(j jVar) {
            this.mListener = jVar;
        }

        public void o(float f10) {
            this.mPadding = f10;
        }

        public void p(int i10) {
            this.mToColor = i10;
        }

        public void q(float f10) {
            this.mToCornerRadius = f10;
        }

        public void r(int i10) {
            this.mToStrokeColor = i10;
        }

        public void s(int i10) {
            this.mToStrokeWidth = i10;
        }

        public void t(int i10) {
            this.mToWidth = i10;
        }

        public void u() {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.mFromWidth, this.mToWidth);
            GradientDrawable gradientDrawable = this.mDrawable.getGradientDrawable();
            valueAnimatorOfInt.addUpdateListener(new a(gradientDrawable));
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(gradientDrawable, "color", this.mFromColor, this.mToColor);
            objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
            ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this.mDrawable, "strokeColor", this.mFromStrokeColor, this.mToStrokeColor);
            objectAnimatorOfInt2.setEvaluator(new ArgbEvaluator());
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(gradientDrawable, "cornerRadius", this.mFromCornerRadius, this.mToCornerRadius);
            ObjectAnimator objectAnimatorOfInt3 = ObjectAnimator.ofInt(this.mDrawable, "strokeWidth", this.mFromStrokeWidth, this.mToStrokeWidth);
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimSet = animatorSet;
            animatorSet.setInterpolator(CircularProgressButton.this.getInterpolator());
            this.mAnimSet.setDuration(this.mDuration);
            this.mAnimSet.playTogether(valueAnimatorOfInt, objectAnimatorOfInt, objectAnimatorOfInt2, objectAnimatorOfFloat, objectAnimatorOfInt3);
            this.mAnimSet.addListener(new b());
            this.mAnimSet.start();
        }
    }

    public interface j {
        void a();
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.StepOSCommon_CircularProgressButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Interpolator getInterpolator() {
        return new PathInterpolator(0.2f, 0.38f, 0.1f, 1.0f);
    }

    private void setBackgroundFromState(State state) {
        int iOrdinal = state.ordinal();
        if (iOrdinal == 0) {
            this.mCurrentStateDrawable = this.mProgressStateDrawable;
            return;
        }
        if (iOrdinal == 1) {
            this.mCurrentStateDrawable = this.mIdleStateDrawable;
        } else if (iOrdinal == 2) {
            this.mCurrentStateDrawable = this.mCompleteStateDrawable;
        } else {
            if (iOrdinal != 3) {
                return;
            }
            this.mCurrentStateDrawable = this.mErrorStateDrawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIcon(int i10) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(i10);
        if (drawable != null) {
            int width = (getWidth() / 2) - (drawable.getIntrinsicWidth() / 2);
            setCompoundDrawablesWithIntrinsicBounds(i10, 0, 0, 0);
            setPadding(width, 0, 0, 0);
        }
    }

    private void setState(State state) {
        if (this.mState != state) {
            this.mState = state;
        }
    }

    private void setTextForState(State state) {
        int iOrdinal = state.ordinal();
        if (iOrdinal == 1) {
            setText(this.mIdleText);
            a0();
        } else if (iOrdinal == 2) {
            setText(this.mCompleteText);
            a0();
        } else {
            if (iOrdinal != 3) {
                return;
            }
            setText(this.mErrorText);
            a0();
        }
    }

    public int A(int i10) {
        return getResources().getColor(i10);
    }

    public final int B(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    public final int C(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{R.attr.state_focused}, 0);
    }

    public final int D(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{R.attr.state_enabled}, 0);
    }

    public final int E(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{R.attr.state_pressed}, 0);
    }

    public int F(Paint paint, String str) {
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, this).toString();
        }
        return (int) paint.measureText(str);
    }

    public TypedArray G(Context context, AttributeSet attributeSet, int[] iArr, int i10) {
        return context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
    }

    public final void H(Context context, AttributeSet attributeSet, int i10) {
        I(context, attributeSet, i10);
        this.mMaxProgress = 100;
        this.mState = State.IDLE;
        setText(this.mIdleText);
        a0();
        L();
        J();
        M();
        K();
        this.mCurrentStateDrawable = this.mIdleStateDrawable;
        setBackgroundCompat(null);
        new com.stepos.common.animator.f().e(this, false);
    }

    public final void I(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayG = G(context, attributeSet, R$styleable.CircularProgressButton, i10);
        if (typedArrayG == null) {
            return;
        }
        int dimensionPixelSize = typedArrayG.getDimensionPixelSize(R$styleable.CircularProgressButton_mcCirButtonStrokeWidth, (int) getContext().getResources().getDimension(R$dimen.mc_cir_progress_button_stroke_width));
        this.mStrokeWidth = dimensionPixelSize;
        this.mProgressStrokeWidth = dimensionPixelSize;
        this.mIdleText = typedArrayG.getString(R$styleable.CircularProgressButton_mcCirButtonTextIdle);
        this.mCompleteText = typedArrayG.getString(R$styleable.CircularProgressButton_mcCirButtonTextComplete);
        this.mErrorText = typedArrayG.getString(R$styleable.CircularProgressButton_mcCirButtonTextError);
        this.mProgressText = typedArrayG.getString(R$styleable.CircularProgressButton_mcCirButtonTextProgress);
        this.mIconComplete = typedArrayG.getResourceId(R$styleable.CircularProgressButton_mcCirButtonIconComplete, 0);
        this.mIconError = typedArrayG.getResourceId(R$styleable.CircularProgressButton_mcCirButtonIconError, 0);
        this.mCornerRadius = typedArrayG.getDimension(R$styleable.CircularProgressButton_mcCirButtonCornerRadius, 0.0f);
        this.mPaddingProgress = typedArrayG.getDimensionPixelSize(R$styleable.CircularProgressButton_mcCirButtonPaddingProgress, 0);
        int i11 = R$styleable.CircularProgressButton_mcCirButtonSelectorIdle;
        int i12 = R$color.mc_cir_progress_button_red;
        int resourceId = typedArrayG.getResourceId(i11, i12);
        this.mIdleColorState = getResources().getColorStateList(resourceId);
        this.mStrokeColorIdle = getResources().getColorStateList(typedArrayG.getResourceId(R$styleable.CircularProgressButton_mcCirButtonStrokeColorIdle, resourceId));
        int resourceId2 = typedArrayG.getResourceId(R$styleable.CircularProgressButton_mcCirButtonSelectorComplete, R$color.mc_cir_progress_button_green);
        this.mCompleteColorState = getResources().getColorStateList(resourceId2);
        this.mStrokeColorComplete = getResources().getColorStateList(typedArrayG.getResourceId(R$styleable.CircularProgressButton_mcCirButtonStrokeColorComplete, resourceId2));
        int resourceId3 = typedArrayG.getResourceId(R$styleable.CircularProgressButton_mcCirButtonSelectorError, i12);
        this.mErrorColorState = getResources().getColorStateList(resourceId3);
        this.mStrokeColorError = getResources().getColorStateList(typedArrayG.getResourceId(R$styleable.CircularProgressButton_mcCirButtonStrokeColorError, resourceId3));
        this.mColorProgress = typedArrayG.getColor(R$styleable.CircularProgressButton_mcCirButtonColorProgress, A(R$color.mc_cir_progress_button_white));
        this.mColorIndicator = typedArrayG.getColor(R$styleable.CircularProgressButton_mcCirButtonColorIndicator, A(i12));
        this.mColorIndicatorBackground = typedArrayG.getColor(R$styleable.CircularProgressButton_mcCirButtonColorIndicatorBackground, A(R$color.mc_cir_progress_button_blank));
        ColorStateList colorStateList = typedArrayG.getColorStateList(R$styleable.CircularProgressButton_mcCirButtonTextColorError);
        this.mTextColorError = colorStateList;
        if (colorStateList == null) {
            this.mTextColorError = getTextColors();
        }
        ColorStateList colorStateList2 = typedArrayG.getColorStateList(R$styleable.CircularProgressButton_mcCirButtonTextColorIdle);
        this.mTextColorIdle = colorStateList2;
        if (colorStateList2 == null) {
            this.mTextColorIdle = getTextColors();
        }
        ColorStateList colorStateList3 = typedArrayG.getColorStateList(R$styleable.CircularProgressButton_mcCirButtonTextColorComplete);
        this.mTextColorComplete = colorStateList3;
        if (colorStateList3 == null) {
            this.mTextColorComplete = getTextColors();
        }
        this.mAutoFitPadding = typedArrayG.getBoolean(R$styleable.CircularProgressButton_mcCirButtonAutoFitPadding, true);
        typedArrayG.recycle();
    }

    public final void J() {
        StrokeGradientDrawable strokeGradientDrawableS = s(E(this.mCompleteColorState), E(this.mStrokeColorComplete));
        if (this.mCompleteStateDrawable == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.mCompleteStateDrawable = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.mCompleteStateDrawable.addState(new int[]{R.attr.state_pressed}, strokeGradientDrawableS.getGradientDrawable());
        this.mCompleteStateDrawable.addState(StateSet.WILD_CARD, this.mBackground.getGradientDrawable());
        this.mCompleteStateDrawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    }

    public final void K() {
        StrokeGradientDrawable strokeGradientDrawableS = s(E(this.mErrorColorState), E(this.mStrokeColorError));
        if (this.mErrorStateDrawable == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.mErrorStateDrawable = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.mErrorStateDrawable.addState(new int[]{R.attr.state_pressed}, strokeGradientDrawableS.getGradientDrawable());
        this.mErrorStateDrawable.addState(StateSet.WILD_CARD, this.mBackground.getGradientDrawable());
        this.mErrorStateDrawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    }

    public final void L() {
        int iD = D(this.mIdleColorState);
        int iE = E(this.mIdleColorState);
        int iC = C(this.mIdleColorState);
        int iB = B(this.mIdleColorState);
        int iD2 = D(this.mStrokeColorIdle);
        int iE2 = E(this.mStrokeColorIdle);
        int iC2 = C(this.mStrokeColorIdle);
        int iB2 = B(this.mStrokeColorIdle);
        if (this.mBackground == null) {
            this.mBackground = s(iD, iD2);
        }
        StrokeGradientDrawable strokeGradientDrawableS = s(iB, iB2);
        StrokeGradientDrawable strokeGradientDrawableS2 = s(iC, iC2);
        StrokeGradientDrawable strokeGradientDrawableS3 = s(iE, iE2);
        if (this.mIdleStateDrawable == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.mIdleStateDrawable = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.mIdleStateDrawable.addState(new int[]{R.attr.state_pressed}, strokeGradientDrawableS3.getGradientDrawable());
        this.mIdleStateDrawable.addState(new int[]{R.attr.state_focused}, strokeGradientDrawableS2.getGradientDrawable());
        this.mIdleStateDrawable.addState(new int[]{-16842910}, strokeGradientDrawableS.getGradientDrawable());
        this.mIdleStateDrawable.addState(StateSet.WILD_CARD, this.mBackground.getGradientDrawable());
        this.mIdleStateDrawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    }

    public final void M() {
        if (this.mProgressStateDrawable == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.mProgressStateDrawable = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.mProgressStateDrawable.addState(StateSet.WILD_CARD, this.mBackground.getGradientDrawable());
        int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.mPaddingProgress;
        int width = getWidth() - iAbs;
        int i10 = this.mPaddingProgress;
        this.mProgressStateDrawable.setBounds(iAbs, i10, width - i10, getHeight() - this.mPaddingProgress);
    }

    public final void N() {
        i iVarT = t();
        iVarT.i(D(this.mCompleteColorState));
        iVarT.p(D(this.mIdleColorState));
        iVarT.k(D(this.mStrokeColorComplete));
        iVarT.r(D(this.mStrokeColorIdle));
        iVarT.n(this.mIdleStateListener);
        setState(State.IDLE);
        this.mCurrentStateDrawable = this.mIdleStateDrawable;
        iVarT.u();
    }

    public final void O() {
        i iVarT = t();
        iVarT.i(D(this.mErrorColorState));
        iVarT.p(D(this.mIdleColorState));
        iVarT.k(D(this.mStrokeColorError));
        iVarT.r(D(this.mStrokeColorIdle));
        iVarT.n(this.mIdleStateListener);
        setState(State.IDLE);
        this.mCurrentStateDrawable = this.mIdleStateDrawable;
        iVarT.u();
    }

    public final void P() {
        i iVarT = t();
        iVarT.i(D(this.mIdleColorState));
        iVarT.k(D(this.mStrokeColorIdle));
        iVarT.p(D(this.mCompleteColorState));
        iVarT.r(D(this.mStrokeColorComplete));
        iVarT.n(this.mCompleteStateListener);
        setState(State.COMPLETE);
        this.mCurrentStateDrawable = this.mCompleteStateDrawable;
        iVarT.u();
    }

    public final void Q() {
        i iVarT = t();
        iVarT.i(D(this.mIdleColorState));
        iVarT.p(D(this.mErrorColorState));
        iVarT.k(D(this.mStrokeColorIdle));
        iVarT.r(D(this.mStrokeColorError));
        iVarT.n(this.mErrorStateListener);
        setState(State.ERROR);
        this.mCurrentStateDrawable = this.mErrorStateDrawable;
        iVarT.u();
    }

    public final void R() {
        i iVarU = u(getHeight(), this.mCornerRadius, getHeight(), getWidth());
        iVarU.i(this.mColorProgress);
        iVarU.k(this.mColorIndicator);
        iVarU.r(D(this.mStrokeColorComplete));
        iVarU.p(D(this.mCompleteColorState));
        iVarU.l(this.mProgressStrokeWidth);
        iVarU.s(this.mStrokeWidth);
        iVarU.n(this.mCompleteStateListener);
        setState(State.COMPLETE);
        this.mCurrentStateDrawable = this.mCompleteStateDrawable;
        iVarU.u();
    }

    public final void S() {
        i iVarU = u(getHeight(), this.mCornerRadius, getHeight(), getWidth());
        iVarU.i(this.mColorProgress);
        iVarU.p(D(this.mErrorColorState));
        iVarU.k(this.mColorIndicator);
        iVarU.r(D(this.mStrokeColorError));
        iVarU.l(this.mProgressStrokeWidth);
        iVarU.s(this.mStrokeWidth);
        iVarU.n(this.mErrorStateListener);
        setState(State.ERROR);
        this.mCurrentStateDrawable = this.mErrorStateDrawable;
        iVarU.u();
    }

    public final void T() {
        i iVarU = u(getHeight(), this.mCornerRadius, getHeight(), getWidth());
        iVarU.i(this.mColorProgress);
        iVarU.p(D(this.mIdleColorState));
        iVarU.k(this.mColorIndicator);
        iVarU.r(D(this.mStrokeColorIdle));
        iVarU.l(this.mProgressStrokeWidth);
        iVarU.s(this.mStrokeWidth);
        iVarU.n(new f());
        setState(State.IDLE);
        this.mCurrentStateDrawable = this.mIdleStateDrawable;
        iVarU.u();
    }

    public final void U() {
        if (this.mOrginWidth == 0) {
            this.mOrginWidth = getWidth();
        }
        if (!this.mIsFirstTime || this.mIsCycle) {
            this.mProgressWidth = F(getPaint(), this.mErrorText) + getCompoundPaddingLeft() + getCompoundPaddingRight();
        } else {
            this.mProgressWidth = getWidth();
        }
        setWidth(this.mProgressWidth);
        setText(this.mProgressText);
        a0();
        i iVarU = u(this.mCornerRadius, getHeight(), this.mProgressWidth, getHeight());
        iVarU.i(D(this.mIdleColorState));
        iVarU.p(this.mColorProgress);
        iVarU.k(D(this.mStrokeColorIdle));
        iVarU.r(this.mColorIndicatorBackground);
        iVarU.l(this.mStrokeWidth);
        iVarU.s(this.mProgressStrokeWidth);
        iVarU.n(this.mProgressStateListener);
        setState(State.PROGRESS);
        this.mCurrentStateDrawable = this.mProgressStateDrawable;
        iVarU.u();
    }

    public final Rect V() {
        if (!this.mMorphingInProgress) {
            return null;
        }
        Rect rect = new Rect();
        rect.set(this.mBackground.getGradientDrawable().getBounds());
        return rect;
    }

    public void W() {
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        setPadding(0, 0, 0, 0);
    }

    public final void X(Rect rect) {
        if (!this.mMorphingInProgress || rect == null) {
            return;
        }
        this.mBackground.getGradientDrawable().setBounds(rect);
    }

    public final void Y(State state, Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (state != State.PROGRESS) {
            drawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
            return;
        }
        int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.mPaddingProgress;
        int width = getWidth() - iAbs;
        int i10 = this.mPaddingProgress;
        drawable.setBounds(iAbs, i10, width - i10, getHeight() - this.mPaddingProgress);
    }

    public final void Z(Drawable drawable, int[] iArr) {
        if (drawable == null) {
            return;
        }
        drawable.setState(iArr);
    }

    public final float a0() {
        setEllipsize(TextUtils.TruncateAt.END);
        setMaxLines(1);
        if (!this.mAutoFitPadding || getText() == null) {
            return 0.0f;
        }
        float F10 = F(getPaint(), getText().toString());
        int iA = (int) s.a(12.0f, getContext());
        if ((iA * 2) + F10 < ((int) s.a(90.0f, getContext()))) {
            setPadding(iA, 0, iA, 0);
            return F10;
        }
        int iA2 = (int) s.a(8.0f, getContext());
        setPadding(iA2, 0, iA2, 0);
        return F10;
    }

    public void b0(int i10, boolean z10) {
        this.mProgress = i10;
        this.mIsUseTransitionAnim = z10;
        if (this.mMorphingInProgress || getWidth() == 0) {
            return;
        }
        int i11 = this.mProgress;
        if (i11 >= this.mMaxProgress) {
            State state = this.mState;
            if (state == State.PROGRESS) {
                R();
                return;
            } else {
                if (state == State.IDLE) {
                    P();
                    return;
                }
                return;
            }
        }
        if (i11 > 0) {
            State state2 = this.mState;
            if (state2 == State.IDLE || state2 == State.ERROR) {
                U();
                return;
            }
            if (state2 == State.PROGRESS) {
                q();
                if (z10) {
                    e0();
                    return;
                } else {
                    this.mAnimCurrentProgress = this.mProgress;
                    invalidate();
                    return;
                }
            }
            return;
        }
        if (i11 == -1) {
            State state3 = this.mState;
            if (state3 == State.PROGRESS) {
                S();
                return;
            } else {
                if (state3 == State.IDLE) {
                    Q();
                    return;
                }
                return;
            }
        }
        if (i11 == 0) {
            State state4 = this.mState;
            if (state4 == State.COMPLETE) {
                N();
            } else if (state4 == State.PROGRESS) {
                T();
            } else if (state4 == State.ERROR) {
                O();
            }
        }
    }

    public void c0(int i10, boolean z10) {
        if (this.mState == State.PROGRESS) {
            this.mProgress = i10;
            q();
            if (z10) {
                e0();
            } else {
                this.mAnimCurrentProgress = this.mProgress;
                invalidate();
            }
        }
    }

    public void d0(State state, boolean z10, boolean z11) {
        if (state == this.mState) {
            return;
        }
        this.mIsUseTransitionAnim = z10;
        if (!z10) {
            r(state, false);
            return;
        }
        if (this.mMorphingInProgress || getWidth() == 0) {
            if (!this.mCanSkipAnim || state != State.COMPLETE) {
                return;
            } else {
                p();
            }
        }
        int iOrdinal = state.ordinal();
        if (iOrdinal == 0) {
            if (this.mState != State.PROGRESS) {
                U();
                return;
            }
            return;
        }
        if (iOrdinal == 1) {
            int iOrdinal2 = this.mState.ordinal();
            if (iOrdinal2 == 0) {
                T();
                return;
            } else if (iOrdinal2 == 2) {
                N();
                return;
            } else {
                if (iOrdinal2 != 3) {
                    return;
                }
                O();
                return;
            }
        }
        if (iOrdinal == 2) {
            int iOrdinal3 = this.mState.ordinal();
            if (iOrdinal3 == 0) {
                R();
                return;
            } else {
                if (iOrdinal3 != 1) {
                    return;
                }
                P();
                return;
            }
        }
        if (iOrdinal != 3) {
            return;
        }
        int iOrdinal4 = this.mState.ordinal();
        if (iOrdinal4 != 0) {
            if (iOrdinal4 != 1) {
                return;
            }
            Q();
        } else if (F(getPaint(), this.mErrorText) + getCompoundPaddingRight() + getCompoundPaddingLeft() <= this.mOrginWidth || this.mErrorText == null) {
            S();
        } else {
            v();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.mShouldUpdateBounds || !this.mMorphingInProgress) {
            this.mShouldUpdateBounds = false;
            z();
        }
        if (this.mMorphingInProgress && isPressed()) {
            super.draw(canvas);
            return;
        }
        if (this.mCurrentStateDrawable != null) {
            if ((getScrollX() | getScrollY()) == 0) {
                int iOrdinal = this.mState.ordinal();
                if (iOrdinal == 0) {
                    y(this.mProgressStateDrawable, canvas);
                } else if (iOrdinal == 1) {
                    y(this.mIdleStateDrawable, canvas);
                } else if (iOrdinal == 2) {
                    y(this.mCompleteStateDrawable, canvas);
                } else if (iOrdinal == 3) {
                    y(this.mErrorStateDrawable, canvas);
                }
            } else {
                canvas.translate(getScrollX(), getScrollY());
                this.mCurrentStateDrawable.draw(canvas);
                canvas.translate(-getScrollX(), -getScrollY());
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        Rect rectV = V();
        Z(this.mIdleStateDrawable, getDrawableState());
        Z(this.mCompleteStateDrawable, getDrawableState());
        Z(this.mErrorStateDrawable, getDrawableState());
        Z(this.mProgressStateDrawable, getDrawableState());
        X(rectV);
        super.drawableStateChanged();
    }

    public final void e0() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.mAnimCurrentProgress, this.mProgress);
        this.mProgressAnimation = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(PROGRESS_ANIMATION_DURATION);
        this.mProgressAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mProgressAnimation.addUpdateListener(new h());
        this.mProgressAnimation.start();
    }

    public String getCompleteText() {
        return this.mCompleteText;
    }

    public String getErrorText() {
        return this.mErrorText;
    }

    public String getIdleText() {
        return this.mIdleText;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public State getState() {
        return this.mState;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mState != State.PROGRESS || this.mMorphingInProgress) {
            CircularAnimatedDrawable circularAnimatedDrawable = this.mAnimatedDrawable;
            if (circularAnimatedDrawable != null) {
                circularAnimatedDrawable.setAllowLoading(false);
                return;
            }
            return;
        }
        if (this.mIndeterminateProgressMode) {
            w(canvas);
        } else {
            x(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CircularProgressButton.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            d0(this.mState, false, false);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mProgress = savedState.mProgress;
        this.mIndeterminateProgressMode = savedState.mIndeterminateProgressMode;
        this.mConfigurationChanged = savedState.mConfigurationChanged;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(this.mProgress);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mProgress = this.mProgress;
        savedState.mIndeterminateProgressMode = this.mIndeterminateProgressMode;
        savedState.mConfigurationChanged = true;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mAnimatedDrawable = null;
        this.mProgressDrawable = null;
        this.mNeedInvalidateCenterIcon = true;
        this.mShouldUpdateBounds = true;
    }

    public void p() {
        i iVar = this.mMorphingAnimation;
        if (iVar != null) {
            iVar.f();
        }
    }

    public final void q() {
        ValueAnimator valueAnimator = this.mProgressAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mProgressAnimation.removeAllUpdateListeners();
            this.mProgressAnimation.removeAllListeners();
        }
    }

    public final void r(State state, boolean z10) {
        int i10;
        if (z10 || state != this.mState) {
            p();
            int iD = D(this.mIdleColorState);
            int iD2 = D(this.mIdleColorState);
            ColorStateList textColors = getTextColors();
            int iOrdinal = state.ordinal();
            String str = "";
            if (iOrdinal == 0) {
                iD = this.mColorProgress;
                iD2 = this.mColorIndicatorBackground;
                setState(State.PROGRESS);
                this.mCurrentStateDrawable = this.mProgressStateDrawable;
            } else if (iOrdinal == 1) {
                iD = D(this.mIdleColorState);
                iD2 = D(this.mStrokeColorIdle);
                str = this.mIdleText;
                setState(State.IDLE);
                textColors = this.mTextColorIdle;
                this.mCurrentStateDrawable = this.mIdleStateDrawable;
            } else if (iOrdinal == 2) {
                iD = D(this.mCompleteColorState);
                iD2 = D(this.mStrokeColorComplete);
                str = this.mCompleteText;
                setState(State.COMPLETE);
                textColors = this.mTextColorComplete;
                this.mCurrentStateDrawable = this.mCompleteStateDrawable;
            } else if (iOrdinal == 3) {
                iD = D(this.mErrorColorState);
                iD2 = D(this.mStrokeColorError);
                str = this.mErrorText;
                setState(State.ERROR);
                textColors = this.mTextColorError;
                this.mCurrentStateDrawable = this.mErrorStateDrawable;
            }
            GradientDrawable gradientDrawable = this.mBackground.getGradientDrawable();
            if (state == State.PROGRESS) {
                int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.mPaddingProgress;
                int width = getWidth() - iAbs;
                int i11 = this.mPaddingProgress;
                gradientDrawable.setBounds(iAbs, i11, width - i11, getHeight() - this.mPaddingProgress);
                i10 = this.mProgressStrokeWidth;
            } else {
                i10 = this.mStrokeWidth;
                gradientDrawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
            }
            gradientDrawable.setColor(iD);
            this.mBackground.setStrokeWidth(i10);
            this.mBackground.setStrokeColor(iD2);
            setText(str);
            setTextColor(textColors);
            post(new g());
        }
    }

    public final StrokeGradientDrawable s(int i10, int i11) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R$drawable.mc_cir_pro_btn_background).mutate();
        gradientDrawable.setColor(i10);
        gradientDrawable.setCornerRadius(this.mCornerRadius);
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(gradientDrawable);
        strokeGradientDrawable.setStrokeColor(i11);
        return strokeGradientDrawable;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.mBackground.getGradientDrawable().setColor(i10);
    }

    @SuppressLint({"NewApi"})
    public void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    public void setCanSkipAnim(boolean z10) {
        this.mCanSkipAnim = z10;
    }

    public void setCompleteText(String str) {
        this.mCompleteText = str;
    }

    public void setErrorText(String str) {
        this.mErrorText = str;
    }

    public void setIdleText(String str) {
        this.mIdleText = str;
    }

    public void setIndeterminateProgressMode(boolean z10) {
        this.mIndeterminateProgressMode = z10;
    }

    public void setIndicatorBackgroundColor(int i10) {
        if (this.mColorIndicatorBackground != i10) {
            this.mColorIndicatorBackground = i10;
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        if (z10 && this.mMorphingInProgress) {
            return;
        }
        super.setPressed(z10);
    }

    @Deprecated
    public void setProgress(int i10) {
        b0(i10, true);
    }

    public void setProgressCenterIcon(Drawable drawable) {
        this.mProgressCenterIcon = drawable;
        this.mNeedInvalidateCenterIcon = true;
    }

    public void setProgressForState(int i10) {
        c0(i10, false);
    }

    public void setProgressIndicatorColor(int i10) {
        this.mColorIndicator = i10;
        this.mAnimatedDrawable = null;
        this.mProgressDrawable = null;
    }

    public void setProgressStrokeWidth(int i10) {
        M();
        if (i10 <= 0 || this.mProgressStrokeWidth == i10) {
            return;
        }
        this.mProgressStrokeWidth = i10;
        CircularAnimatedDrawable circularAnimatedDrawable = this.mAnimatedDrawable;
        if (circularAnimatedDrawable != null) {
            circularAnimatedDrawable.setStrokeWidth(i10);
        }
        CircularProgressDrawable circularProgressDrawable = this.mProgressDrawable;
        if (circularProgressDrawable != null) {
            circularProgressDrawable.setStrokeWidth(i10);
        }
    }

    public void setShowCenterIcon(boolean z10) {
        this.mShouldShowCenterIcon = z10;
        this.mNeedInvalidateCenterIcon = true;
    }

    public void setStrokeColor(int i10) {
        this.mBackground.setStrokeColor(i10);
    }

    public final i t() {
        this.mMorphingInProgress = true;
        setClickable(false);
        i iVar = new i(this, this.mBackground);
        this.mMorphingAnimation = iVar;
        iVar.j(this.mCornerRadius);
        this.mMorphingAnimation.q(this.mCornerRadius);
        this.mMorphingAnimation.m(getWidth());
        this.mMorphingAnimation.t(getWidth());
        if (this.mConfigurationChanged || !this.mIsUseTransitionAnim) {
            this.mMorphingAnimation.h(1);
        } else {
            this.mMorphingAnimation.h(240);
        }
        this.mConfigurationChanged = false;
        return this.mMorphingAnimation;
    }

    public final i u(float f10, float f11, int i10, int i11) {
        this.mMorphingInProgress = true;
        setClickable(false);
        i iVar = new i(this, this.mBackground);
        this.mMorphingAnimation = iVar;
        iVar.j(f10);
        this.mMorphingAnimation.q(f11);
        this.mMorphingAnimation.o(this.mPaddingProgress);
        this.mMorphingAnimation.m(i10);
        this.mMorphingAnimation.t(i11);
        if (this.mConfigurationChanged || !this.mIsUseTransitionAnim) {
            this.mMorphingAnimation.h(1);
        } else {
            this.mMorphingAnimation.h(240);
        }
        this.mConfigurationChanged = false;
        return this.mMorphingAnimation;
    }

    public final void v() {
        i iVar = new i(this, this.mBackground);
        this.mMorphingAnimation = iVar;
        iVar.i(this.mColorProgress);
        this.mMorphingAnimation.p(D(this.mErrorColorState));
        this.mMorphingAnimation.k(this.mColorIndicator);
        this.mMorphingAnimation.r(D(this.mStrokeColorError));
        this.mMorphingAnimation.n(new d());
        setState(State.ERROR);
        this.mCurrentStateDrawable = this.mErrorStateDrawable;
        this.mMorphingAnimation.g();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mAnimatedDrawable || drawable == this.mProgressStateDrawable || drawable == this.mIdleStateDrawable || drawable == this.mErrorStateDrawable || drawable == this.mCompleteStateDrawable || super.verifyDrawable(drawable);
    }

    public final void w(Canvas canvas) {
        CircularAnimatedDrawable circularAnimatedDrawable = this.mAnimatedDrawable;
        if (circularAnimatedDrawable != null) {
            circularAnimatedDrawable.setAllowLoading(true);
            this.mAnimatedDrawable.draw(canvas);
            return;
        }
        int width = (getWidth() - getHeight()) / 2;
        this.mAnimatedDrawable = new CircularAnimatedDrawable(this.mColorIndicator, this.mProgressStrokeWidth);
        int i10 = this.mPaddingProgress + width;
        int width2 = (getWidth() - width) - this.mPaddingProgress;
        int height = getHeight();
        int i11 = this.mPaddingProgress;
        this.mAnimatedDrawable.setBounds(i10, i11, width2, height - i11);
        this.mAnimatedDrawable.setCallback(this);
        this.mAnimatedDrawable.start();
    }

    public final void x(Canvas canvas) {
        if (this.mProgressDrawable == null) {
            int width = (getWidth() - getHeight()) / 2;
            this.mProgressDrawable = new CircularProgressDrawable(getHeight() - (this.mPaddingProgress * 2), this.mProgressStrokeWidth, this.mColorIndicator);
            int i10 = width + this.mPaddingProgress;
            int i11 = this.mPaddingProgress;
            this.mProgressDrawable.setOffset(((getWidth() - getHeight()) / 2.0f) + i11, i11);
            CircularProgressDrawable circularProgressDrawable = this.mProgressDrawable;
            int i12 = this.mPaddingProgress;
            circularProgressDrawable.setBounds(i10, i12, i10, i12);
        }
        if (this.mNeedInvalidateCenterIcon) {
            this.mNeedInvalidateCenterIcon = false;
            this.mProgressDrawable.setCenterIcon(this.mProgressCenterIcon);
            if (this.mProgressCenterIcon == null) {
                this.mProgressDrawable.setShowCenterIcon(this.mShouldShowCenterIcon);
            }
        }
        this.mProgressDrawable.setStartAngle(-90.0f);
        this.mProgressDrawable.setSweepAngle((360.0f / this.mMaxProgress) * this.mAnimCurrentProgress);
        this.mProgressDrawable.draw(canvas);
    }

    public final void y(Drawable drawable, Canvas canvas) {
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public final void z() {
        Y(State.IDLE, this.mIdleStateDrawable);
        Y(State.COMPLETE, this.mCompleteStateDrawable);
        Y(State.ERROR, this.mErrorStateDrawable);
        Y(this.mState, this.mBackground.getGradientDrawable());
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mIsUseTransitionAnim = true;
        this.mShouldShowCenterIcon = false;
        this.mShouldUpdateBounds = false;
        this.mAutoFitPadding = true;
        this.mOrginWidth = 0;
        this.mIsFirstTime = true;
        this.mProgress = 0;
        this.mProgressStateListener = new a();
        this.mCompleteStateListener = new b();
        this.mIdleStateListener = new c();
        this.mErrorStateListener = new e();
        H(context, attributeSet, i10);
    }
}
