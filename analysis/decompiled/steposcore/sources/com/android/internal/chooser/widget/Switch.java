package com.android.internal.chooser.widget;

import android.R;
import android.animation.ArgbEvaluator;
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
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.android.internal.dynamicanimation.animation.SpringAnimation;
import com.android.internal.dynamicanimation.animation.SpringForce;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
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
    private static Field mShellHapticFeedBackMotor;
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
    private int mMinFlingVelocity;
    private MorphingParams mParams;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod2 mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private TextPaint mTextPaint;
    private StrokeGradientDrawable mThumbDrawable;
    private ColorStateList mThumbOffColor;
    private ColorStateList mThumbOnColor;
    private float mThumbPosition;
    private SpringAnimation mThumbSpringAnim;
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
    private static final FloatProperty<Switch> THUMB_POSITION = new FloatProperty<Switch>("thumbPos") { // from class: com.android.internal.chooser.widget.Switch.1
        @Override // android.util.Property
        public Float get(Switch object) {
            return Float.valueOf(object.mThumbPosition);
        }

        @Override // android.util.FloatProperty
        public void setValue(Switch object, float value) {
            object.setThumbPosition(value);
        }
    };

    public Switch(Context context) {
        this(context, null);
    }

    public Switch(Context context, AttributeSet attrs) {
        this(context, attrs, R.^attr-private.__removed0);
    }

    public Switch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.isChanged = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.mIgnoreSystemNightMode = false;
        this.mCheckOnDamping = DAMPING_CHECK_ON_DEFAULT;
        this.mCheckOffDamping = DAMPING_CHECK_OFF_DEFAULT;
        disableAutoNightMode();
        this.mAttributeSet = attrs;
        this.mTextPaint = new TextPaint(1);
        Resources res = getResources();
        this.mTextPaint.density = res.getDisplayMetrics().density;
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.Switch, defStyleAttr, 16975273);
        this.mIgnoreSystemNightMode = a.getBoolean(15, false);
        this.mTrackDrawable = a.getDrawable(22);
        this.mThumbDrawable = createDrawable(getResources().getDimensionPixelOffset(17106788), getResources().getDimensionPixelOffset(17106789));
        refreshAndGetTrackRes();
        if (this.mTrackDrawable != null) {
            this.mTrackDrawable.setCallback(this);
        }
        this.mSwitchMinWidth = a.getDimensionPixelSize(16, 0);
        this.mSwitchPadding = a.getDimensionPixelSize(17, 48);
        this.mSplitTrack = false;
        this.mThumbOnColor = a.getColorStateList(21);
        this.mThumbOffColor = a.getColorStateList(20);
        a.recycle();
        sSwitchStyleableId = new int[]{R.attr.textOn, R.attr.textOff};
        TypedArray b = context.obtainStyledAttributes(attrs, sSwitchStyleableId, R.attr.switchStyle, 0);
        this.switchOn = b.getText(0);
        this.switchOff = b.getText(1);
        b.recycle();
        ViewConfiguration config = ViewConfiguration.get(context);
        this.mTouchSlop = config.getScaledTouchSlop();
        this.mMinFlingVelocity = config.getScaledMinimumFlingVelocity();
        this.mParams = MorphingParams.create(this.mThumbDrawable);
        this.mParams.color(this.mThumbOffColor, this.mThumbOnColor).height(getResources().getDimensionPixelOffset(17106791)).width(getResources().getDimensionPixelOffset(17106792)).cornerRadius(getResources().getDimensionPixelOffset(17106790)).alpha(1.0f, 1.0f);
        this.mThumbDrawable.getGradientDrawable().setCallback(this);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void setCheckOnDamping(float damping) {
        this.mCheckOnDamping = damping;
    }

    private void setCheckOffDamping(float damping) {
        this.mCheckOffDamping = damping;
    }

    private void refreshAndGetTrackRes() {
        TypedArray a = getContext().obtainStyledAttributes(this.mAttributeSet, com.android.internal.R.styleable.Switch, R.^attr-private.__removed0, 16975273);
        this.mTrackDrawable = a.getDrawable(22);
        if (this.mTrackDrawable == null) {
            this.mTrackDrawable = getResources().getDrawable(17305050);
        }
        if (this.mCustomTrackOnColorState != null) {
            this.mTrackOnColorState = this.mCustomTrackOnColorState;
        } else {
            this.mTrackOnColorState = a.getColorStateList(27);
            if (this.mTrackOnColorState == null) {
                this.mTrackOnColorState = getResources().getColorStateList(17171499);
            }
        }
        if (this.mCustomTrackOffColorState != null) {
            this.mTrackOffColorState = this.mCustomTrackOffColorState;
        } else {
            this.mTrackOffColorState = a.getColorStateList(26);
            if (this.mTrackOffColorState == null) {
                this.mTrackOffColorState = getResources().getColorStateList(17171494);
            }
        }
        if (this.mTrackDrawable != null) {
            this.mTrackDrawable.setCallback(this);
        }
        if (this.mParams != null) {
            this.mParams.color(this.mThumbOffColor, this.mThumbOnColor);
            setThumbPosition(this.mThumbPosition);
        }
        a.recycle();
        refreshDrawableState();
    }

    public void setSwitchPadding(int pixels) {
        this.mSwitchPadding = pixels;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public void setSwitchMinWidth(int pixels) {
        this.mSwitchMinWidth = pixels;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public void setTrackDrawable(Drawable track) {
        if (this.mTrackDrawable != null) {
            this.mTrackDrawable.setCallback(null);
        }
        this.mTrackDrawable = track;
        if (track != null) {
            track.setCallback(this);
            drawableStateChanged();
        }
        requestLayout();
    }

    public void setTrackResource(int resId) {
        setTrackDrawable(getContext().getResources().getDrawable(resId));
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int thumbWidth;
        int thumbHeight;
        int trackHeight;
        Rect padding = this.mTempRect;
        if (this.mThumbDrawable != null) {
            this.mThumbDrawable.getGradientDrawable().getPadding(padding);
            int thumbWidth2 = (this.mThumbDrawable.getGradientDrawable().getIntrinsicWidth() - padding.left) - padding.right;
            thumbWidth = Math.max(thumbWidth2, this.mParams.width);
            thumbHeight = this.mThumbDrawable.getGradientDrawable().getIntrinsicHeight();
        } else {
            thumbWidth = 0;
            thumbHeight = 0;
        }
        this.mThumbWidth = thumbWidth;
        if (this.mTrackDrawable != null) {
            this.mTrackDrawable.getPadding(padding);
            trackHeight = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            padding.setEmpty();
            trackHeight = 0;
        }
        int paddingLeft = padding.left;
        int paddingRight = padding.right;
        Insets thumbInsets = Insets.NONE;
        if (this.mThumbDrawable != null) {
            paddingLeft = Math.max(paddingLeft, 0);
            paddingRight = Math.max(paddingRight, 0);
            thumbInsets = Insets.of(this.mThumbDrawable.getPaddingLeft(), 0, this.mThumbDrawable.getPaddingRight(), 0);
        }
        int switchWidth = Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + paddingLeft + paddingRight + thumbInsets.left + thumbInsets.right);
        int switchHeight = Math.max(trackHeight, thumbHeight);
        this.mSwitchWidth = switchWidth;
        this.mSwitchHeight = switchHeight;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight < switchHeight) {
            setMeasuredDimension(getMeasuredWidthAndState(), switchHeight);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
    }

    private Layout makeLayout(CharSequence text) {
        CharSequence transformed = this.mSwitchTransformationMethod != null ? this.mSwitchTransformationMethod.getTransformation(text, this) : text;
        this.mTextPaint = new TextPaint(1);
        this.mTextPaint.density = getResources().getDisplayMetrics().density;
        return new StaticLayout(transformed, this.mTextPaint, (int) Math.ceil(Layout.getDesiredWidth(transformed, this.mTextPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean hitThumb(float x, float y) {
        return x > ((float) this.mSwitchLeft) && x < ((float) this.mSwitchRight) && y > ((float) this.mSwitchTop) && y < ((float) this.mSwitchBottom);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        float dPos;
        this.mVelocityTracker.addMovement(ev);
        int action = ev.getActionMasked();
        switch (action) {
            case 0:
                float x = ev.getX();
                float y = ev.getY();
                if (isEnabled() && hitThumb(x, y)) {
                    this.mTouchMode = 1;
                    this.mTouchX = x;
                    this.mTouchY = y;
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.mTouchMode == 2) {
                    stopDrag(ev);
                    super.onTouchEvent(ev);
                    return true;
                }
                this.mTouchMode = 0;
                this.mVelocityTracker.clear();
                break;
            case 2:
                switch (this.mTouchMode) {
                    case 1:
                        float x2 = ev.getX();
                        float y2 = ev.getY();
                        if (Math.abs(x2 - this.mTouchX) > this.mTouchSlop || Math.abs(y2 - this.mTouchY) > this.mTouchSlop) {
                            this.mTouchMode = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.mTouchX = x2;
                            this.mTouchY = y2;
                            return true;
                        }
                        break;
                    case 2:
                        float x3 = ev.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float thumbScrollOffset = x3 - this.mTouchX;
                        if (thumbScrollRange == 0) {
                            dPos = thumbScrollOffset > 0.0f ? 1.0f : -1.0f;
                        } else {
                            dPos = thumbScrollOffset / thumbScrollRange;
                        }
                        if (isLayoutRtl()) {
                            dPos = -dPos;
                        }
                        float newPos = MathUtils.constrain(this.mThumbPosition + dPos, 0.0f, 1.0f);
                        if (newPos != this.mThumbPosition) {
                            this.mTouchX = x3;
                            setThumbPosition(newPos);
                        }
                        return true;
                }
        }
        return super.onTouchEvent(ev);
    }

    private void cancelSuperTouch(MotionEvent ev) {
        MotionEvent cancel = MotionEvent.obtain(ev);
        cancel.setAction(3);
        super.onTouchEvent(cancel);
        cancel.recycle();
    }

    private void stopDrag(MotionEvent ev) {
        this.mTouchMode = 0;
        boolean newState = true;
        boolean commitChange = ev.getAction() == 1 && isEnabled();
        if (commitChange) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xvel = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xvel) > this.mMinFlingVelocity) {
                if (!isLayoutRtl() ? xvel <= 0.0f : xvel >= 0.0f) {
                    newState = false;
                }
            } else {
                newState = getTargetCheckedState();
            }
        } else {
            newState = isChecked();
        }
        setCheckedWithHapticFeedback(newState, false);
        cancelSuperTouch(ev);
    }

    private void animateThumbToCheckedState(boolean newCheckedState) {
        float target = newCheckedState ? 1.0f : 0.0f;
        cancelThumbSpringAnimator();
        if (this.mThumbSpringAnim == null) {
            this.mThumbSpringAnim = new SpringAnimation(this, THUMB_POSITION);
        }
        SpringForce springForce = new SpringForce();
        float damping = newCheckedState ? this.mCheckOnDamping : this.mCheckOffDamping;
        springForce.setStiffness(STIFFNESS_DEFAULT).setDampingRatio(damping).setFinalPosition(target);
        this.mThumbSpringAnim.setMinimumVisibleChange(0.00390625f);
        this.mThumbSpringAnim.setSpring(springForce);
        this.mThumbSpringAnim.start();
    }

    private void cancelThumbSpringAnimator() {
        if (this.mThumbSpringAnim != null && this.mThumbSpringAnim.isRunning()) {
            this.mThumbSpringAnim.cancel();
        }
    }

    public void performHapticFeedback() {
        try {
            if (hasStepOSFeature()) {
                performHapticFeedback(STEP_OS_SLIDE_HORIZONTAL);
            } else {
                Vibrator vibrator = (Vibrator) getContext().getSystemService(Vibrator.class);
                if (vibrator != null && vibrator.hasVibrator()) {
                    vibrator.vibrate(VibrationEffect.createOneShot(20L, -1));
                }
            }
        } catch (Exception e) {
        }
    }

    private boolean hasStepOSFeature() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException {
        try {
            if (mShellHapticFeedBackMotor == null) {
                Class mCls = Class.forName("stepos.config.StepOSFeature");
                mShellHapticFeedBackMotor = mCls.getDeclaredField("SHELL_HAPTICFEEDBACK_MOTOR");
            }
            boolean has = mShellHapticFeedBackMotor.getBoolean(null);
            return has;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean getTargetCheckedState() {
        return this.mThumbPosition > 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbPosition(float position) {
        this.mThumbPosition = position;
        float limitPosition = position < 0.0f ? Math.max(position, 0.0f) : Math.min(position, 1.0f);
        if (this.mParams != null) {
            this.mThumbDrawable.setWidth(this.mParams.width);
            this.mThumbDrawable.setHeight(this.mParams.height);
            this.mThumbDrawable.setCornerRadius(this.mParams.cornerRadius);
            int color = getThumbColorValue(getColorFromState(this.mParams.fromColor), getColorFromState(this.mParams.toColor), limitPosition);
            this.mThumbDrawable.setAlpha(getThumbAlphaValue(this.mParams.fromAlpha, this.mParams.toAlpha, isEnabled()));
            this.mThumbDrawable.setColor(color);
            int trackColor = getThumbColorValue(getColorFromState(this.mTrackOffColorState), getColorFromState(this.mTrackOnColorState), limitPosition);
            this.mTrackDrawable.setColorFilter(trackColor, PorterDuff.Mode.SRC_IN);
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setCheckedWithHapticFeedback(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean checked) {
        setChecked(checked, true);
    }

    public void setCheckedWithHapticFeedback(boolean checked, boolean useAnim) {
        if (isChecked() != checked) {
            performHapticFeedback();
        }
        setChecked(checked, useAnim);
    }

    public void setCheckedWithHapticFeedback(boolean checked) {
        setCheckedWithHapticFeedback(checked, true);
    }

    public void setChecked(boolean checked, boolean useAnim) {
        if (isChecked() == checked) {
            if (this.mThumbSpringAnim == null || !this.mThumbSpringAnim.isRunning()) {
                setThumbPosition(checked ? 1.0f : 0.0f);
                return;
            }
            return;
        }
        super.setChecked(checked);
        boolean checked2 = isChecked();
        if (useAnim && isAttachedToWindow() && isLaidOut()) {
            animateThumbToCheckedState(checked2);
        } else {
            cancelThumbSpringAnimator();
            setThumbPosition(checked2 ? 1.0f : 0.0f);
        }
    }

    @Override // android.view.View
    public boolean isLaidOut() {
        return getWidth() > 0 && getHeight() > 0;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int switchRight;
        int switchLeft;
        int switchTop;
        int switchBottom;
        super.onLayout(changed, left, top, right, bottom);
        int opticalInsetLeft = 0;
        int opticalInsetRight = 0;
        if (this.mThumbDrawable != null) {
            Rect trackPadding = this.mTempRect;
            if (this.mTrackDrawable != null) {
                this.mTrackDrawable.getPadding(trackPadding);
            } else {
                trackPadding.setEmpty();
            }
            Insets insets = Insets.NONE;
            opticalInsetLeft = Math.max(0, insets.left - trackPadding.left);
            opticalInsetRight = Math.max(0, insets.right - trackPadding.right);
        }
        if (isLayoutRtl()) {
            switchLeft = getPaddingLeft() + opticalInsetLeft;
            switchRight = ((this.mSwitchWidth + switchLeft) - opticalInsetLeft) - opticalInsetRight;
        } else {
            int switchLeft2 = getWidth();
            switchRight = (switchLeft2 - getPaddingRight()) - opticalInsetRight;
            switchLeft = (switchRight - this.mSwitchWidth) + opticalInsetLeft + opticalInsetRight;
        }
        switch (getGravity() & 112) {
            case 16:
                int switchBottom2 = getPaddingTop();
                switchTop = (((switchBottom2 + getHeight()) - getPaddingBottom()) / 2) - (this.mSwitchHeight / 2);
                switchBottom = this.mSwitchHeight + switchTop;
                break;
            case 80:
                int switchBottom3 = getHeight();
                switchBottom = switchBottom3 - getPaddingBottom();
                switchTop = switchBottom - this.mSwitchHeight;
                break;
            default:
                switchTop = getPaddingTop();
                switchBottom = this.mSwitchHeight + switchTop;
                break;
        }
        this.mSwitchLeft = switchLeft;
        this.mSwitchTop = switchTop;
        this.mSwitchBottom = switchBottom;
        this.mSwitchRight = switchRight;
    }

    @Override // android.view.View
    public void draw(Canvas c) {
        Insets thumbInsets;
        int thumbLeft;
        int thumbRight;
        int thumbTop;
        int thumbBottom;
        Rect padding = this.mTempRect;
        int switchLeft = this.mSwitchLeft;
        int switchTop = this.mSwitchTop;
        int switchRight = this.mSwitchRight;
        int switchBottom = this.mSwitchBottom;
        int thumbInitialLeft = getThumbOffset() + switchLeft;
        if (this.mThumbDrawable != null) {
            thumbInsets = Insets.NONE;
        } else {
            thumbInsets = Insets.NONE;
        }
        if (this.mTrackDrawable != null) {
            this.mTrackDrawable.getPadding(padding);
            thumbInitialLeft += padding.left;
            int trackLeft = switchLeft;
            int trackTop = switchTop;
            int trackRight = switchRight;
            int trackBottom = switchBottom;
            if (thumbInsets != Insets.NONE) {
                if (thumbInsets.left > padding.left) {
                    trackLeft += thumbInsets.left - padding.left;
                }
                if (thumbInsets.top > padding.top) {
                    trackTop += thumbInsets.top - padding.top;
                }
                if (thumbInsets.right > padding.right) {
                    trackRight -= thumbInsets.right - padding.right;
                }
                if (thumbInsets.bottom > padding.bottom) {
                    trackBottom -= thumbInsets.bottom - padding.bottom;
                }
            }
            this.mTrackDrawable.setBounds(trackLeft, trackTop, trackRight, trackBottom);
        }
        if (this.mThumbDrawable != null) {
            this.mThumbDrawable.getGradientDrawable().getPadding(padding);
            if (isLayoutRtl()) {
                thumbRight = (switchRight - getThumbOffset()) - this.mThumbDrawable.getPaddingLeft();
                thumbLeft = thumbRight - this.mThumbDrawable.getWidth();
                thumbTop = ((this.mSwitchHeight - this.mThumbDrawable.getHeight()) / 2) + switchTop;
                thumbBottom = this.mThumbDrawable.getHeight() + thumbTop;
            } else {
                thumbLeft = thumbInitialLeft + this.mThumbDrawable.getPaddingLeft();
                thumbRight = this.mThumbDrawable.getWidth() + thumbLeft;
                thumbTop = ((this.mSwitchHeight - this.mThumbDrawable.getHeight()) / 2) + switchTop;
                thumbBottom = this.mThumbDrawable.getHeight() + thumbTop;
            }
            this.mThumbDrawable.getGradientDrawable().setBounds(thumbLeft, thumbTop, thumbRight, thumbBottom);
        }
        if (this.mCustomTrackOffColorState != null) {
            this.mTrackOffColorState = this.mCustomTrackOffColorState;
        }
        if (this.mCustomTrackOnColorState != null) {
            this.mTrackOnColorState = this.mCustomTrackOnColorState;
        }
        super.draw(c);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect padding = this.mTempRect;
        Drawable trackDrawable = this.mTrackDrawable;
        if (trackDrawable != null) {
            trackDrawable.getPadding(padding);
        } else {
            padding.setEmpty();
        }
        Drawable thumbDrawable = this.mThumbDrawable.getGradientDrawable();
        if (trackDrawable != null) {
            if (this.mSplitTrack && thumbDrawable != null) {
                Insets insets = Insets.NONE;
                thumbDrawable.copyBounds(padding);
                padding.left += insets.left;
                padding.right -= insets.right;
                int saveCount = canvas.save();
                canvas.clipRect(padding, Region.Op.DIFFERENCE);
                trackDrawable.draw(canvas);
                canvas.restoreToCount(saveCount);
            } else {
                trackDrawable.draw(canvas);
            }
        }
        int saveCount2 = canvas.save();
        if (thumbDrawable != null) {
            thumbDrawable.draw(canvas);
        }
        canvas.restoreToCount(saveCount2);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!isLayoutRtl()) {
            return super.getCompoundPaddingLeft();
        }
        int padding = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return padding + this.mSwitchPadding;
        }
        return padding;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (isLayoutRtl()) {
            return super.getCompoundPaddingRight();
        }
        int padding = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return padding + this.mSwitchPadding;
        }
        return padding;
    }

    public boolean isLayoutRtl() {
        return getLayoutDirection() == 1;
    }

    private int getThumbOffset() {
        return (int) ((getThumbValue() * getThumbScrollRange()) + 0.5f);
    }

    private float getThumbValue() {
        return this.mThumbPosition;
    }

    private boolean isThumbOn() {
        return this.mThumbPosition == 1.0f;
    }

    private boolean isThumbOff() {
        return this.mThumbPosition == 0.0f;
    }

    private int getThumbScrollRange() {
        Insets insets;
        if (this.mTrackDrawable == null) {
            return 0;
        }
        Rect padding = this.mTempRect;
        this.mTrackDrawable.getPadding(padding);
        if (this.mThumbDrawable.getGradientDrawable() != null) {
            insets = Insets.of(this.mThumbDrawable.getPaddingLeft(), 0, this.mThumbDrawable.getPaddingRight(), 0);
        } else {
            insets = Insets.NONE;
        }
        return ((((this.mSwitchWidth - this.mThumbWidth) - padding.left) - padding.right) - insets.left) - insets.right;
    }

    private StrokeGradientDrawable createDrawable(int paddingLeft, int paddingRight) {
        StrokeGradientDrawable drawable = new StrokeGradientDrawable(new GradientDrawable());
        drawable.getGradientDrawable().setShape(0);
        drawable.setPaddingLeft(paddingLeft);
        drawable.setPaddingRight(paddingRight);
        return drawable;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] myDrawableState = getDrawableState();
        if (this.mThumbDrawable != null && this.mThumbDrawable.getGradientDrawable() != null) {
            this.mThumbDrawable.getGradientDrawable().setState(myDrawableState);
        }
        if (this.mTrackDrawable != null) {
            this.mTrackDrawable.setState(myDrawableState);
        }
        setThumbPosition(this.mThumbPosition);
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || (this.mThumbDrawable != null && who == this.mThumbDrawable.getGradientDrawable()) || who == this.mTrackDrawable;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mThumbDrawable != null && this.mThumbDrawable.getGradientDrawable() != null) {
            this.mThumbDrawable.getGradientDrawable().jumpToCurrentState();
        }
        if (this.mTrackDrawable != null) {
            this.mTrackDrawable.jumpToCurrentState();
        }
        if (this.mThumbSpringAnim != null && this.mThumbSpringAnim.isRunning() && this.mThumbSpringAnim.canSkipToEnd()) {
            this.mThumbSpringAnim.skipToEnd();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(Switch.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(Switch.class.getName());
        CharSequence switchText = isChecked() ? this.switchOn : this.switchOff;
        if (!TextUtils.isEmpty(switchText)) {
            CharSequence oldText = info.getText();
            if (TextUtils.isEmpty(oldText)) {
                info.setText(switchText);
                return;
            }
            StringBuilder newText = new StringBuilder();
            newText.append(oldText).append(' ').append(switchText);
            info.setText(newText);
        }
    }

    public void setThumbOnColor(ColorStateList color) {
        this.mThumbOnColor = color;
        if (this.mParams != null) {
            this.mParams.color(this.mThumbOffColor, this.mThumbOnColor);
            setThumbPosition(this.mThumbPosition);
        }
        invalidate();
    }

    public void setThumbOffColor(ColorStateList color) {
        this.mThumbOffColor = color;
        if (this.mParams != null) {
            this.mParams.color(this.mThumbOffColor, this.mThumbOnColor);
            setThumbPosition(this.mThumbPosition);
        }
        invalidate();
    }

    public void setTrackOnColor(ColorStateList color) {
        this.mCustomTrackOnColorState = color;
        invalidate();
    }

    public void setTrackOnColor(int colorId) {
        setTrackOnColor(getContext().getResources().getColorStateList(colorId));
        setDarkTrackOnColor(getContext().getResources().getColorStateList(colorId));
    }

    public void setTrackOffColor(ColorStateList color) {
        this.mCustomTrackOffColorState = color;
        invalidate();
    }

    public void setTrackOffColor(int colorId) {
        setTrackOffColor(getContext().getResources().getColorStateList(colorId));
        setDarkTrackOffColor(getContext().getResources().getColorStateList(colorId));
    }

    public void setDarkTrackOnColor(ColorStateList color) {
        this.mCustomDarkTrackOnColorState = color;
        invalidate();
    }

    public void setDarkTrackOffColor(ColorStateList color) {
        this.mCustomDarkTrackOffColorState = color;
        invalidate();
    }

    private int getThumbColorValue(int fromColor, int toColor, float fraction) {
        return ((Integer) ArgbEvaluator.getInstance().evaluate(fraction, Integer.valueOf(fromColor), Integer.valueOf(toColor))).intValue();
    }

    private int getThumbAlphaValue(float enableAlpha, float disableAlpha, boolean enable) {
        return (int) (enable ? 255.0f * enableAlpha : 255.0f * disableAlpha);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        refreshAndGetTrackRes();
        this.mThumbDrawable.getGradientDrawable().setCallback(this);
        invalidate();
    }

    private void disableAutoNightMode() {
    }

    private int getColorFromState(ColorStateList colorStateList) {
        if (isEnabled()) {
            return getNormalColor(colorStateList);
        }
        return getDisabledColor(colorStateList);
    }

    private int getNormalColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        return colorStateList.getColorForState(new int[]{R.attr.state_enabled}, 0);
    }

    private int getDisabledColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }
}
